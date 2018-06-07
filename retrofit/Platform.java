package retrofit;

import android.os.Build.VERSION;
import android.os.Process;
import com.fossil.cfj;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import retrofit.RestAdapter.Log;
import retrofit.android.AndroidApacheClient;
import retrofit.android.AndroidLog;
import retrofit.android.MainThreadExecutor;
import retrofit.appengine.UrlFetchClient;
import retrofit.client.Client;
import retrofit.client.Client.Provider;
import retrofit.client.OkClient;
import retrofit.client.UrlConnectionClient;
import retrofit.converter.Converter;
import retrofit.converter.GsonConverter;

abstract class Platform {
    static final boolean HAS_RX_JAVA = hasRxJavaOnClasspath();
    private static final Platform PLATFORM = findPlatform();

    static class Android extends Platform {

        class C51872 implements ThreadFactory {
            C51872() {
            }

            public Thread newThread(final Runnable runnable) {
                return new Thread(new Runnable() {
                    public void run() {
                        Process.setThreadPriority(10);
                        runnable.run();
                    }
                }, "Retrofit-Idle");
            }
        }

        private Android() {
        }

        Converter defaultConverter() {
            return new GsonConverter(new cfj());
        }

        Provider defaultClient() {
            Client instantiate;
            if (Platform.hasOkHttpOnClasspath()) {
                instantiate = OkClientInstantiator.instantiate();
            } else if (VERSION.SDK_INT < 9) {
                instantiate = new AndroidApacheClient();
            } else {
                instantiate = new UrlConnectionClient();
            }
            return new Provider() {
                public Client get() {
                    return instantiate;
                }
            };
        }

        Executor defaultHttpExecutor() {
            return Executors.newCachedThreadPool(new C51872());
        }

        Executor defaultCallbackExecutor() {
            return new MainThreadExecutor();
        }

        Log defaultLog() {
            return new AndroidLog("Retrofit");
        }
    }

    static class Base extends Platform {

        class C51912 implements ThreadFactory {
            C51912() {
            }

            public Thread newThread(final Runnable runnable) {
                return new Thread(new Runnable() {
                    public void run() {
                        Thread.currentThread().setPriority(1);
                        runnable.run();
                    }
                }, "Retrofit-Idle");
            }
        }

        class C51923 implements Log {
            C51923() {
            }

            public void log(String str) {
                System.out.println(str);
            }
        }

        private Base() {
        }

        Converter defaultConverter() {
            return new GsonConverter(new cfj());
        }

        Provider defaultClient() {
            Client instantiate;
            if (Platform.hasOkHttpOnClasspath()) {
                instantiate = OkClientInstantiator.instantiate();
            } else {
                instantiate = new UrlConnectionClient();
            }
            return new Provider() {
                public Client get() {
                    return instantiate;
                }
            };
        }

        Executor defaultHttpExecutor() {
            return Executors.newCachedThreadPool(new C51912());
        }

        Executor defaultCallbackExecutor() {
            return new SynchronousExecutor();
        }

        Log defaultLog() {
            return new C51923();
        }
    }

    static class AppEngine extends Base {
        private AppEngine() {
            super();
        }

        Provider defaultClient() {
            final UrlFetchClient urlFetchClient = new UrlFetchClient();
            return new Provider() {
                public Client get() {
                    return urlFetchClient;
                }
            };
        }
    }

    static class OkClientInstantiator {
        private OkClientInstantiator() {
        }

        static Client instantiate() {
            return new OkClient();
        }
    }

    abstract Executor defaultCallbackExecutor();

    abstract Provider defaultClient();

    abstract Converter defaultConverter();

    abstract Executor defaultHttpExecutor();

    abstract Log defaultLog();

    Platform() {
    }

    static Platform get() {
        return PLATFORM;
    }

    private static Platform findPlatform() {
        try {
            Class.forName("android.os.Build");
            if (VERSION.SDK_INT != 0) {
                return new Android();
            }
        } catch (ClassNotFoundException e) {
        }
        if (System.getProperty("com.google.appengine.runtime.version") != null) {
            return new AppEngine();
        }
        return new Base();
    }

    private static boolean hasOkHttpOnClasspath() {
        try {
            Class.forName("com.fossil.dvi");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    private static boolean hasRxJavaOnClasspath() {
        try {
            Class.forName("rx.Observable");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
