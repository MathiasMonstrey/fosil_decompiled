package retrofit;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import retrofit.Profiler.RequestInformation;
import retrofit.client.Client;
import retrofit.client.Client.Provider;
import retrofit.client.Header;
import retrofit.client.Request;
import retrofit.client.Response;
import retrofit.converter.Converter;
import retrofit.mime.MimeUtil;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

public class RestAdapter {
    static final String IDLE_THREAD_NAME = "Retrofit-Idle";
    static final String THREAD_PREFIX = "Retrofit-";
    final Executor callbackExecutor;
    private final Provider clientProvider;
    final Converter converter;
    final ErrorHandler errorHandler;
    final Executor httpExecutor;
    final Log log;
    volatile LogLevel logLevel;
    private final Profiler profiler;
    final RequestInterceptor requestInterceptor;
    private RxSupport rxSupport;
    final Endpoint server;
    private final Map<Class<?>, Map<Method, RestMethodInfo>> serviceMethodInfoCache;

    public interface Log {
        public static final Log NONE = new C52031();

        static class C52031 implements Log {
            C52031() {
            }

            public void log(String str) {
            }
        }

        void log(String str);
    }

    public static class Builder {
        private Executor callbackExecutor;
        private Provider clientProvider;
        private Converter converter;
        private Endpoint endpoint;
        private ErrorHandler errorHandler;
        private Executor httpExecutor;
        private Log log;
        private LogLevel logLevel = LogLevel.NONE;
        private Profiler profiler;
        private RequestInterceptor requestInterceptor;

        public Builder setEndpoint(String str) {
            if (str == null || str.trim().length() == 0) {
                throw new NullPointerException("Endpoint may not be blank.");
            }
            this.endpoint = Endpoints.newFixedEndpoint(str);
            return this;
        }

        public Builder setEndpoint(Endpoint endpoint) {
            if (endpoint == null) {
                throw new NullPointerException("Endpoint may not be null.");
            }
            this.endpoint = endpoint;
            return this;
        }

        public Builder setClient(final Client client) {
            if (client != null) {
                return setClient(new Provider() {
                    public Client get() {
                        return client;
                    }
                });
            }
            throw new NullPointerException("Client may not be null.");
        }

        public Builder setClient(Provider provider) {
            if (provider == null) {
                throw new NullPointerException("Client provider may not be null.");
            }
            this.clientProvider = provider;
            return this;
        }

        public Builder setExecutors(Executor executor, Executor executor2) {
            if (executor == null) {
                throw new NullPointerException("HTTP executor may not be null.");
            }
            if (executor2 == null) {
                executor2 = new SynchronousExecutor();
            }
            this.httpExecutor = executor;
            this.callbackExecutor = executor2;
            return this;
        }

        public Builder setRequestInterceptor(RequestInterceptor requestInterceptor) {
            if (requestInterceptor == null) {
                throw new NullPointerException("Request interceptor may not be null.");
            }
            this.requestInterceptor = requestInterceptor;
            return this;
        }

        public Builder setConverter(Converter converter) {
            if (converter == null) {
                throw new NullPointerException("Converter may not be null.");
            }
            this.converter = converter;
            return this;
        }

        public Builder setProfiler(Profiler profiler) {
            if (profiler == null) {
                throw new NullPointerException("Profiler may not be null.");
            }
            this.profiler = profiler;
            return this;
        }

        public Builder setErrorHandler(ErrorHandler errorHandler) {
            if (errorHandler == null) {
                throw new NullPointerException("Error handler may not be null.");
            }
            this.errorHandler = errorHandler;
            return this;
        }

        public Builder setLog(Log log) {
            if (log == null) {
                throw new NullPointerException("Log may not be null.");
            }
            this.log = log;
            return this;
        }

        public Builder setLogLevel(LogLevel logLevel) {
            if (logLevel == null) {
                throw new NullPointerException("Log level may not be null.");
            }
            this.logLevel = logLevel;
            return this;
        }

        public RestAdapter build() {
            if (this.endpoint == null) {
                throw new IllegalArgumentException("Endpoint may not be null.");
            }
            ensureSaneDefaults();
            return new RestAdapter(this.endpoint, this.clientProvider, this.httpExecutor, this.callbackExecutor, this.requestInterceptor, this.converter, this.profiler, this.errorHandler, this.log, this.logLevel);
        }

        private void ensureSaneDefaults() {
            if (this.converter == null) {
                this.converter = Platform.get().defaultConverter();
            }
            if (this.clientProvider == null) {
                this.clientProvider = Platform.get().defaultClient();
            }
            if (this.httpExecutor == null) {
                this.httpExecutor = Platform.get().defaultHttpExecutor();
            }
            if (this.callbackExecutor == null) {
                this.callbackExecutor = Platform.get().defaultCallbackExecutor();
            }
            if (this.errorHandler == null) {
                this.errorHandler = ErrorHandler.DEFAULT;
            }
            if (this.log == null) {
                this.log = Platform.get().defaultLog();
            }
            if (this.requestInterceptor == null) {
                this.requestInterceptor = RequestInterceptor.NONE;
            }
        }
    }

    public enum LogLevel {
        NONE,
        BASIC,
        HEADERS,
        HEADERS_AND_ARGS,
        FULL;

        public boolean log() {
            return this != NONE;
        }
    }

    class RestHandler implements InvocationHandler {
        private final Map<Method, RestMethodInfo> methodDetailsCache;

        RestHandler(Map<Method, RestMethodInfo> map) {
            this.methodDetailsCache = map;
        }

        public Object invoke(Object obj, Method method, final Object[] objArr) throws Throwable {
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, objArr);
            }
            final RestMethodInfo methodInfo = RestAdapter.getMethodInfo(this.methodDetailsCache, method);
            if (methodInfo.isSynchronous) {
                try {
                    return invokeRequest(RestAdapter.this.requestInterceptor, methodInfo, objArr);
                } catch (Throwable e) {
                    Throwable handleError = RestAdapter.this.errorHandler.handleError(e);
                    if (handleError == null) {
                        throw new IllegalStateException("Error handler returned null for wrapped exception.", e);
                    }
                    throw handleError;
                }
            } else if (RestAdapter.this.httpExecutor == null || RestAdapter.this.callbackExecutor == null) {
                throw new IllegalStateException("Asynchronous invocation requires calling setExecutors.");
            } else if (methodInfo.isObservable) {
                if (RestAdapter.this.rxSupport == null) {
                    if (Platform.HAS_RX_JAVA) {
                        RestAdapter.this.rxSupport = new RxSupport(RestAdapter.this.httpExecutor, RestAdapter.this.errorHandler, RestAdapter.this.requestInterceptor);
                    } else {
                        throw new IllegalStateException("Observable method found but no RxJava on classpath.");
                    }
                }
                return RestAdapter.this.rxSupport.createRequestObservable(new Invoker() {
                    public ResponseWrapper invoke(RequestInterceptor requestInterceptor) {
                        return (ResponseWrapper) RestHandler.this.invokeRequest(requestInterceptor, methodInfo, objArr);
                    }
                });
            } else {
                final Object requestInterceptorTape = new RequestInterceptorTape();
                RestAdapter.this.requestInterceptor.intercept(requestInterceptorTape);
                Callback callback = (Callback) objArr[objArr.length - 1];
                final Object[] objArr2 = objArr;
                RestAdapter.this.httpExecutor.execute(new CallbackRunnable(callback, RestAdapter.this.callbackExecutor, RestAdapter.this.errorHandler) {
                    public ResponseWrapper obtainResponse() {
                        return (ResponseWrapper) RestHandler.this.invokeRequest(requestInterceptorTape, methodInfo, objArr2);
                    }
                });
                return null;
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.lang.Object invokeRequest(retrofit.RequestInterceptor r13, retrofit.RestMethodInfo r14, java.lang.Object[] r15) {
            /*
            r12 = this;
            r6 = 0;
            r14.init();	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x01d0, Throwable -> 0x01cd }
            r0 = retrofit.RestAdapter.this;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x01d0, Throwable -> 0x01cd }
            r0 = r0.server;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x01d0, Throwable -> 0x01cd }
            r9 = r0.getUrl();	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x01d0, Throwable -> 0x01cd }
            r0 = new retrofit.RequestBuilder;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x01d0, Throwable -> 0x01cd }
            r1 = retrofit.RestAdapter.this;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x01d0, Throwable -> 0x01cd }
            r1 = r1.converter;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x01d0, Throwable -> 0x01cd }
            r0.<init>(r9, r14, r1);	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x01d0, Throwable -> 0x01cd }
            r0.setArguments(r15);	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x01d0, Throwable -> 0x01cd }
            r13.intercept(r0);	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x01d0, Throwable -> 0x01cd }
            r0 = r0.build();	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x01d0, Throwable -> 0x01cd }
            r7 = r0.getUrl();	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x01d0, Throwable -> 0x01cd }
            r1 = r14.isSynchronous;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            if (r1 != 0) goto L_0x005a;
        L_0x0027:
            r1 = "?";
            r2 = r9.length();	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r1 = r7.indexOf(r1, r2);	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r2 = -1;
            if (r1 != r2) goto L_0x0038;
        L_0x0034:
            r1 = r7.length();	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
        L_0x0038:
            r2 = java.lang.Thread.currentThread();	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r3 = new java.lang.StringBuilder;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r3.<init>();	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r4 = "Retrofit-";
            r3 = r3.append(r4);	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r4 = r9.length();	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r1 = r7.substring(r4, r1);	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r1 = r3.append(r1);	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r1 = r1.toString();	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r2.setName(r1);	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
        L_0x005a:
            r1 = retrofit.RestAdapter.this;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r1 = r1.logLevel;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r1 = r1.log();	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            if (r1 == 0) goto L_0x006c;
        L_0x0064:
            r1 = retrofit.RestAdapter.this;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r2 = "HTTP";
            r0 = r1.logAndReplaceRequest(r2, r0, r15);	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
        L_0x006c:
            r1 = retrofit.RestAdapter.this;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r1 = r1.profiler;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            if (r1 == 0) goto L_0x01d8;
        L_0x0074:
            r1 = retrofit.RestAdapter.this;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r1 = r1.profiler;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r5 = r1.beforeCall();	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
        L_0x007e:
            r2 = java.lang.System.nanoTime();	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r1 = retrofit.RestAdapter.this;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r1 = r1.clientProvider;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r1 = r1.get();	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r8 = r1.execute(r0);	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r1 = java.util.concurrent.TimeUnit.NANOSECONDS;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r10 = java.lang.System.nanoTime();	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r2 = r10 - r2;
            r2 = r1.toMillis(r2);	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r4 = r8.getStatus();	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r1 = retrofit.RestAdapter.this;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r1 = r1.profiler;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            if (r1 == 0) goto L_0x00b5;
        L_0x00a8:
            r1 = retrofit.RestAdapter.getRequestInfo(r9, r14, r0);	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r0 = retrofit.RestAdapter.this;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r0 = r0.profiler;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r0.afterCall(r1, r2, r4, r5);	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
        L_0x00b5:
            r0 = retrofit.RestAdapter.this;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r0 = r0.logLevel;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r0 = r0.log();	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            if (r0 == 0) goto L_0x01d5;
        L_0x00bf:
            r0 = retrofit.RestAdapter.this;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r2 = r0.logAndReplaceResponse(r7, r8, r2);	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
        L_0x00c5:
            r3 = r14.responseObjectType;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r0 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
            if (r4 < r0) goto L_0x01ab;
        L_0x00cb:
            r0 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
            if (r4 >= r0) goto L_0x01ab;
        L_0x00cf:
            r0 = retrofit.client.Response.class;
            r0 = r3.equals(r0);	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            if (r0 == 0) goto L_0x0105;
        L_0x00d7:
            r0 = r14.isStreaming;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            if (r0 != 0) goto L_0x01d2;
        L_0x00db:
            r0 = retrofit.Utils.readBodyToBytesIfNecessary(r2);	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
        L_0x00df:
            r1 = r14.isSynchronous;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            if (r1 == 0) goto L_0x00f1;
        L_0x00e3:
            r1 = r14.isSynchronous;
            if (r1 != 0) goto L_0x00f0;
        L_0x00e7:
            r1 = java.lang.Thread.currentThread();
            r2 = "Retrofit-Idle";
            r1.setName(r2);
        L_0x00f0:
            return r0;
        L_0x00f1:
            r1 = new retrofit.ResponseWrapper;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r1.<init>(r0, r0);	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r0 = r14.isSynchronous;
            if (r0 != 0) goto L_0x0103;
        L_0x00fa:
            r0 = java.lang.Thread.currentThread();
            r2 = "Retrofit-Idle";
            r0.setName(r2);
        L_0x0103:
            r0 = r1;
            goto L_0x00f0;
        L_0x0105:
            r1 = r2.getBody();	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            if (r1 != 0) goto L_0x0132;
        L_0x010b:
            r0 = r14.isSynchronous;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            if (r0 == 0) goto L_0x011e;
        L_0x010f:
            r0 = r14.isSynchronous;
            if (r0 != 0) goto L_0x011c;
        L_0x0113:
            r0 = java.lang.Thread.currentThread();
            r1 = "Retrofit-Idle";
            r0.setName(r1);
        L_0x011c:
            r0 = r6;
            goto L_0x00f0;
        L_0x011e:
            r0 = new retrofit.ResponseWrapper;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r1 = 0;
            r0.<init>(r2, r1);	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r1 = r14.isSynchronous;
            if (r1 != 0) goto L_0x00f0;
        L_0x0128:
            r1 = java.lang.Thread.currentThread();
            r2 = "Retrofit-Idle";
            r1.setName(r2);
            goto L_0x00f0;
        L_0x0132:
            r4 = new retrofit.ExceptionCatchingTypedInput;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r4.<init>(r1);	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r0 = retrofit.RestAdapter.this;	 Catch:{ ConversionException -> 0x016a }
            r0 = r0.converter;	 Catch:{ ConversionException -> 0x016a }
            r0 = r0.fromBody(r4, r3);	 Catch:{ ConversionException -> 0x016a }
            r5 = retrofit.RestAdapter.this;	 Catch:{ ConversionException -> 0x016a }
            r5.logResponseBody(r1, r0);	 Catch:{ ConversionException -> 0x016a }
            r1 = r14.isSynchronous;	 Catch:{ ConversionException -> 0x016a }
            if (r1 == 0) goto L_0x0156;
        L_0x0148:
            r1 = r14.isSynchronous;
            if (r1 != 0) goto L_0x00f0;
        L_0x014c:
            r1 = java.lang.Thread.currentThread();
            r2 = "Retrofit-Idle";
            r1.setName(r2);
            goto L_0x00f0;
        L_0x0156:
            r1 = new retrofit.ResponseWrapper;	 Catch:{ ConversionException -> 0x016a }
            r1.<init>(r2, r0);	 Catch:{ ConversionException -> 0x016a }
            r0 = r14.isSynchronous;
            if (r0 != 0) goto L_0x0168;
        L_0x015f:
            r0 = java.lang.Thread.currentThread();
            r2 = "Retrofit-Idle";
            r0.setName(r2);
        L_0x0168:
            r0 = r1;
            goto L_0x00f0;
        L_0x016a:
            r0 = move-exception;
            r1 = r4.threwException();	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            if (r1 == 0) goto L_0x0187;
        L_0x0171:
            r0 = r4.getThrownException();	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            throw r0;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
        L_0x0176:
            r0 = move-exception;
            throw r0;	 Catch:{ all -> 0x0178 }
        L_0x0178:
            r0 = move-exception;
            r1 = r14.isSynchronous;
            if (r1 != 0) goto L_0x0186;
        L_0x017d:
            r1 = java.lang.Thread.currentThread();
            r2 = "Retrofit-Idle";
            r1.setName(r2);
        L_0x0186:
            throw r0;
        L_0x0187:
            r1 = 0;
            r1 = retrofit.Utils.replaceResponseBody(r2, r1);	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r2 = retrofit.RestAdapter.this;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r2 = r2.converter;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r0 = retrofit.RetrofitError.conversionError(r7, r1, r2, r3, r0);	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            throw r0;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
        L_0x0195:
            r0 = move-exception;
            r6 = r7;
        L_0x0197:
            r1 = retrofit.RestAdapter.this;	 Catch:{ all -> 0x0178 }
            r1 = r1.logLevel;	 Catch:{ all -> 0x0178 }
            r1 = r1.log();	 Catch:{ all -> 0x0178 }
            if (r1 == 0) goto L_0x01a6;
        L_0x01a1:
            r1 = retrofit.RestAdapter.this;	 Catch:{ all -> 0x0178 }
            r1.logException(r0, r6);	 Catch:{ all -> 0x0178 }
        L_0x01a6:
            r0 = retrofit.RetrofitError.networkError(r6, r0);	 Catch:{ all -> 0x0178 }
            throw r0;	 Catch:{ all -> 0x0178 }
        L_0x01ab:
            r0 = retrofit.Utils.readBodyToBytesIfNecessary(r2);	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r1 = retrofit.RestAdapter.this;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r1 = r1.converter;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            r0 = retrofit.RetrofitError.httpError(r7, r0, r1, r3);	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
            throw r0;	 Catch:{ RetrofitError -> 0x0176, IOException -> 0x0195, Throwable -> 0x01b8 }
        L_0x01b8:
            r0 = move-exception;
        L_0x01b9:
            r1 = retrofit.RestAdapter.this;	 Catch:{ all -> 0x0178 }
            r1 = r1.logLevel;	 Catch:{ all -> 0x0178 }
            r1 = r1.log();	 Catch:{ all -> 0x0178 }
            if (r1 == 0) goto L_0x01c8;
        L_0x01c3:
            r1 = retrofit.RestAdapter.this;	 Catch:{ all -> 0x0178 }
            r1.logException(r0, r7);	 Catch:{ all -> 0x0178 }
        L_0x01c8:
            r0 = retrofit.RetrofitError.unexpectedError(r7, r0);	 Catch:{ all -> 0x0178 }
            throw r0;	 Catch:{ all -> 0x0178 }
        L_0x01cd:
            r0 = move-exception;
            r7 = r6;
            goto L_0x01b9;
        L_0x01d0:
            r0 = move-exception;
            goto L_0x0197;
        L_0x01d2:
            r0 = r2;
            goto L_0x00df;
        L_0x01d5:
            r2 = r8;
            goto L_0x00c5;
        L_0x01d8:
            r5 = r6;
            goto L_0x007e;
            */
            throw new UnsupportedOperationException("Method not decompiled: retrofit.RestAdapter.RestHandler.invokeRequest(retrofit.RequestInterceptor, retrofit.RestMethodInfo, java.lang.Object[]):java.lang.Object");
        }
    }

    private RestAdapter(Endpoint endpoint, Provider provider, Executor executor, Executor executor2, RequestInterceptor requestInterceptor, Converter converter, Profiler profiler, ErrorHandler errorHandler, Log log, LogLevel logLevel) {
        this.serviceMethodInfoCache = new LinkedHashMap();
        this.server = endpoint;
        this.clientProvider = provider;
        this.httpExecutor = executor;
        this.callbackExecutor = executor2;
        this.requestInterceptor = requestInterceptor;
        this.converter = converter;
        this.profiler = profiler;
        this.errorHandler = errorHandler;
        this.log = log;
        this.logLevel = logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        if (this.logLevel == null) {
            throw new NullPointerException("Log level may not be null.");
        }
        this.logLevel = logLevel;
    }

    public LogLevel getLogLevel() {
        return this.logLevel;
    }

    public <T> T create(Class<T> cls) {
        Utils.validateServiceClass(cls);
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new RestHandler(getMethodInfoCache(cls)));
    }

    Map<Method, RestMethodInfo> getMethodInfoCache(Class<?> cls) {
        Map<Method, RestMethodInfo> map;
        synchronized (this.serviceMethodInfoCache) {
            map = (Map) this.serviceMethodInfoCache.get(cls);
            if (map == null) {
                map = new LinkedHashMap();
                this.serviceMethodInfoCache.put(cls, map);
            }
        }
        return map;
    }

    static RestMethodInfo getMethodInfo(Map<Method, RestMethodInfo> map, Method method) {
        RestMethodInfo restMethodInfo;
        synchronized (map) {
            restMethodInfo = (RestMethodInfo) map.get(method);
            if (restMethodInfo == null) {
                restMethodInfo = new RestMethodInfo(method);
                map.put(method, restMethodInfo);
            }
        }
        return restMethodInfo;
    }

    Request logAndReplaceRequest(String str, Request request, Object[] objArr) throws IOException {
        this.log.log(String.format("---> %s %s %s", new Object[]{str, request.getMethod(), request.getUrl()}));
        if (this.logLevel.ordinal() >= LogLevel.HEADERS.ordinal()) {
            for (Header header : request.getHeaders()) {
                this.log.log(header.toString());
            }
            String str2 = "no";
            TypedOutput body = request.getBody();
            if (body != null) {
                str2 = body.mimeType();
                if (str2 != null) {
                    this.log.log("Content-Type: " + str2);
                }
                long length = body.length();
                String str3 = length + "-byte";
                if (length != -1) {
                    this.log.log("Content-Length: " + length);
                }
                if (this.logLevel.ordinal() >= LogLevel.FULL.ordinal()) {
                    if (!request.getHeaders().isEmpty()) {
                        this.log.log("");
                    }
                    if (!(body instanceof TypedByteArray)) {
                        request = Utils.readBodyToBytesIfNecessary(request);
                        body = request.getBody();
                    }
                    this.log.log(new String(((TypedByteArray) body).getBytes(), MimeUtil.parseCharset(body.mimeType(), "UTF-8")));
                    str2 = str3;
                } else {
                    if (this.logLevel.ordinal() >= LogLevel.HEADERS_AND_ARGS.ordinal()) {
                        if (!request.getHeaders().isEmpty()) {
                            this.log.log("---> REQUEST:");
                        }
                        for (int i = 0; i < objArr.length; i++) {
                            this.log.log("#" + i + ": " + objArr[i]);
                        }
                    }
                    str2 = str3;
                }
            }
            this.log.log(String.format("---> END %s (%s body)", new Object[]{str, str2}));
        }
        return request;
    }

    private Response logAndReplaceResponse(String str, Response response, long j) throws IOException {
        this.log.log(String.format("<--- HTTP %s %s (%sms)", new Object[]{Integer.valueOf(response.getStatus()), str, Long.valueOf(j)}));
        if (this.logLevel.ordinal() >= LogLevel.HEADERS.ordinal()) {
            for (Header header : response.getHeaders()) {
                this.log.log(header.toString());
            }
            long j2 = 0;
            TypedInput body = response.getBody();
            if (body != null) {
                j2 = body.length();
                if (this.logLevel.ordinal() >= LogLevel.FULL.ordinal()) {
                    if (!response.getHeaders().isEmpty()) {
                        this.log.log("");
                    }
                    if (!(body instanceof TypedByteArray)) {
                        response = Utils.readBodyToBytesIfNecessary(response);
                        body = response.getBody();
                    }
                    byte[] bytes = ((TypedByteArray) body).getBytes();
                    j2 = (long) bytes.length;
                    this.log.log(new String(bytes, MimeUtil.parseCharset(body.mimeType(), "UTF-8")));
                }
            }
            long j3 = j2;
            this.log.log(String.format("<--- END HTTP (%s-byte body)", new Object[]{Long.valueOf(j3)}));
        }
        return response;
    }

    private void logResponseBody(TypedInput typedInput, Object obj) {
        if (this.logLevel.ordinal() == LogLevel.HEADERS_AND_ARGS.ordinal()) {
            this.log.log("<--- BODY:");
            this.log.log(obj.toString());
        }
    }

    void logException(Throwable th, String str) {
        Log log = this.log;
        String str2 = "---- ERROR %s";
        Object[] objArr = new Object[1];
        if (str == null) {
            str = "";
        }
        objArr[0] = str;
        log.log(String.format(str2, objArr));
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        this.log.log(stringWriter.toString());
        this.log.log("---- END ERROR");
    }

    private static RequestInformation getRequestInfo(String str, RestMethodInfo restMethodInfo, Request request) {
        long j = 0;
        String str2 = null;
        TypedOutput body = request.getBody();
        if (body != null) {
            j = body.length();
            str2 = body.mimeType();
        }
        return new RequestInformation(restMethodInfo.requestMethod, str, restMethodInfo.requestUrl, j, str2);
    }
}
