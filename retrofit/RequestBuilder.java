package retrofit;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import retrofit.RequestInterceptor.RequestFacade;
import retrofit.client.Header;
import retrofit.client.Request;
import retrofit.converter.Converter;
import retrofit.http.Body;
import retrofit.http.EncodedPath;
import retrofit.http.EncodedQuery;
import retrofit.http.EncodedQueryMap;
import retrofit.http.Field;
import retrofit.http.FieldMap;
import retrofit.http.Part;
import retrofit.http.PartMap;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.http.QueryMap;
import retrofit.mime.FormUrlEncodedTypedOutput;
import retrofit.mime.MultipartTypedOutput;
import retrofit.mime.TypedOutput;
import retrofit.mime.TypedString;

final class RequestBuilder implements RequestFacade {
    private final String apiUrl;
    private TypedOutput body;
    private String contentTypeHeader;
    private final Converter converter;
    private final FormUrlEncodedTypedOutput formBody;
    private List<Header> headers;
    private final boolean isObservable;
    private final boolean isSynchronous;
    private final MultipartTypedOutput multipartBody;
    private final Annotation[] paramAnnotations;
    private StringBuilder queryParams;
    private String relativeUrl;
    private final String requestMethod;

    static class MimeOverridingTypedOutput implements TypedOutput {
        private final TypedOutput delegate;
        private final String mimeType;

        MimeOverridingTypedOutput(TypedOutput typedOutput, String str) {
            this.delegate = typedOutput;
            this.mimeType = str;
        }

        public String fileName() {
            return this.delegate.fileName();
        }

        public String mimeType() {
            return this.mimeType;
        }

        public long length() {
            return this.delegate.length();
        }

        public void writeTo(OutputStream outputStream) throws IOException {
            this.delegate.writeTo(outputStream);
        }
    }

    RequestBuilder(String str, RestMethodInfo restMethodInfo, Converter converter) {
        this.apiUrl = str;
        this.converter = converter;
        this.paramAnnotations = restMethodInfo.requestParamAnnotations;
        this.requestMethod = restMethodInfo.requestMethod;
        this.isSynchronous = restMethodInfo.isSynchronous;
        this.isObservable = restMethodInfo.isObservable;
        if (restMethodInfo.headers != null) {
            this.headers = new ArrayList(restMethodInfo.headers);
        }
        this.contentTypeHeader = restMethodInfo.contentTypeHeader;
        this.relativeUrl = restMethodInfo.requestUrl;
        String str2 = restMethodInfo.requestQuery;
        if (str2 != null) {
            this.queryParams = new StringBuilder().append('?').append(str2);
        }
        switch (restMethodInfo.requestType) {
            case FORM_URL_ENCODED:
                this.formBody = new FormUrlEncodedTypedOutput();
                this.multipartBody = null;
                this.body = this.formBody;
                return;
            case MULTIPART:
                this.formBody = null;
                this.multipartBody = new MultipartTypedOutput();
                this.body = this.multipartBody;
                return;
            case SIMPLE:
                this.formBody = null;
                this.multipartBody = null;
                return;
            default:
                throw new IllegalArgumentException("Unknown request type: " + restMethodInfo.requestType);
        }
    }

    public void addHeader(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Header name must not be null.");
        } else if ("Content-Type".equalsIgnoreCase(str)) {
            this.contentTypeHeader = str2;
        } else {
            List list = this.headers;
            if (list == null) {
                list = new ArrayList(2);
                this.headers = list;
            }
            list.add(new Header(str, str2));
        }
    }

    public void addPathParam(String str, String str2) {
        addPathParam(str, str2, true);
    }

    public void addEncodedPathParam(String str, String str2) {
        addPathParam(str, str2, false);
    }

    private void addPathParam(String str, String str2, boolean z) {
        if (str == null) {
            throw new IllegalArgumentException("Path replacement name must not be null.");
        } else if (str2 == null) {
            throw new IllegalArgumentException("Path replacement \"" + str + "\" value must not be null.");
        } else if (z) {
            try {
                this.relativeUrl = this.relativeUrl.replace("{" + str + "}", URLEncoder.encode(String.valueOf(str2), "UTF-8").replace("+", "%20"));
            } catch (Throwable e) {
                throw new RuntimeException("Unable to convert path parameter \"" + str + "\" value to UTF-8:" + str2, e);
            }
        } else {
            this.relativeUrl = this.relativeUrl.replace("{" + str + "}", String.valueOf(str2));
        }
    }

    public void addQueryParam(String str, String str2) {
        addQueryParam(str, str2, false, true);
    }

    public void addEncodedQueryParam(String str, String str2) {
        addQueryParam(str, str2, false, false);
    }

    private void addQueryParam(String str, Object obj, boolean z, boolean z2) {
        if (obj instanceof Iterable) {
            for (Object next : (Iterable) obj) {
                if (next != null) {
                    addQueryParam(str, next.toString(), z, z2);
                }
            }
        } else if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                Object obj2 = Array.get(obj, i);
                if (obj2 != null) {
                    addQueryParam(str, obj2.toString(), z, z2);
                }
            }
        } else {
            addQueryParam(str, obj.toString(), z, z2);
        }
    }

    private void addQueryParam(String str, String str2, boolean z, boolean z2) {
        if (str == null) {
            throw new IllegalArgumentException("Query param name must not be null.");
        } else if (str2 == null) {
            throw new IllegalArgumentException("Query param \"" + str + "\" value must not be null.");
        } else {
            try {
                StringBuilder stringBuilder;
                StringBuilder stringBuilder2 = this.queryParams;
                if (stringBuilder2 == null) {
                    stringBuilder2 = new StringBuilder();
                    this.queryParams = stringBuilder2;
                    stringBuilder = stringBuilder2;
                } else {
                    stringBuilder = stringBuilder2;
                }
                stringBuilder.append(stringBuilder.length() > 0 ? '&' : '?');
                if (z) {
                    str = URLEncoder.encode(str, "UTF-8");
                }
                if (z2) {
                    str2 = URLEncoder.encode(str2, "UTF-8");
                }
                stringBuilder.append(str).append('=').append(str2);
            } catch (Throwable e) {
                throw new RuntimeException("Unable to convert query parameter \"" + str + "\" value to UTF-8: " + str2, e);
            }
        }
    }

    private void addQueryParamMap(int i, Map<?, ?> map, boolean z, boolean z2) {
        for (Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            if (key == null) {
                throw new IllegalArgumentException("Parameter #" + (i + 1) + " query map contained null key.");
            }
            Object value = entry.getValue();
            if (value != null) {
                addQueryParam(key.toString(), value.toString(), z, z2);
            }
        }
    }

    void setArguments(Object[] objArr) {
        if (objArr != null) {
            int i;
            int length = objArr.length;
            if (this.isSynchronous || this.isObservable) {
                i = length;
            } else {
                i = length - 1;
            }
            for (int i2 = 0; i2 < i; i2++) {
                Object obj = objArr[i2];
                Annotation annotation = this.paramAnnotations[i2];
                Class annotationType = annotation.annotationType();
                String value;
                if (annotationType == Path.class) {
                    Path path = (Path) annotation;
                    value = path.value();
                    if (obj == null) {
                        throw new IllegalArgumentException("Path parameter \"" + value + "\" value must not be null.");
                    }
                    addPathParam(value, obj.toString(), path.encode());
                } else if (annotationType == EncodedPath.class) {
                    r0 = ((EncodedPath) annotation).value();
                    if (obj == null) {
                        throw new IllegalArgumentException("Path parameter \"" + r0 + "\" value must not be null.");
                    }
                    addPathParam(r0, obj.toString(), false);
                } else if (annotationType == Query.class) {
                    if (obj != null) {
                        Query query = (Query) annotation;
                        addQueryParam(query.value(), obj, query.encodeName(), query.encodeValue());
                    }
                } else if (annotationType == EncodedQuery.class) {
                    if (obj != null) {
                        addQueryParam(((EncodedQuery) annotation).value(), obj, false, false);
                    }
                } else if (annotationType == QueryMap.class) {
                    if (obj != null) {
                        QueryMap queryMap = (QueryMap) annotation;
                        addQueryParamMap(i2, (Map) obj, queryMap.encodeNames(), queryMap.encodeValues());
                    }
                } else if (annotationType == EncodedQueryMap.class) {
                    if (obj != null) {
                        addQueryParamMap(i2, (Map) obj, false, false);
                    }
                } else if (annotationType == retrofit.http.Header.class) {
                    if (obj != null) {
                        value = ((retrofit.http.Header) annotation).value();
                        if (obj instanceof Iterable) {
                            for (Object obj2 : (Iterable) obj2) {
                                if (obj2 != null) {
                                    addHeader(value, obj2.toString());
                                }
                            }
                        } else if (obj2.getClass().isArray()) {
                            int length2 = Array.getLength(obj2);
                            for (length = 0; length < length2; length++) {
                                r7 = Array.get(obj2, length);
                                if (r7 != null) {
                                    addHeader(value, r7.toString());
                                }
                            }
                        } else {
                            addHeader(value, obj2.toString());
                        }
                    }
                } else if (annotationType == Field.class) {
                    if (obj2 != null) {
                        Field field = (Field) annotation;
                        value = field.value();
                        r6 = field.encodeName();
                        boolean encodeValue = field.encodeValue();
                        if (obj2 instanceof Iterable) {
                            for (Object obj22 : (Iterable) obj22) {
                                if (obj22 != null) {
                                    this.formBody.addField(value, r6, obj22.toString(), encodeValue);
                                }
                            }
                        } else if (obj22.getClass().isArray()) {
                            int length3 = Array.getLength(obj22);
                            for (length = 0; length < length3; length++) {
                                Object obj3 = Array.get(obj22, length);
                                if (obj3 != null) {
                                    this.formBody.addField(value, r6, obj3.toString(), encodeValue);
                                }
                            }
                        } else {
                            this.formBody.addField(value, r6, obj22.toString(), encodeValue);
                        }
                    }
                } else if (annotationType == FieldMap.class) {
                    if (obj22 != null) {
                        FieldMap fieldMap = (FieldMap) annotation;
                        boolean encodeNames = fieldMap.encodeNames();
                        r6 = fieldMap.encodeValues();
                        for (Entry entry : ((Map) obj22).entrySet()) {
                            r7 = entry.getKey();
                            if (r7 == null) {
                                throw new IllegalArgumentException("Parameter #" + (i2 + 1) + " field map contained null key.");
                            }
                            r0 = entry.getValue();
                            if (r0 != null) {
                                this.formBody.addField(r7.toString(), encodeNames, r0.toString(), r6);
                            }
                        }
                        continue;
                    } else {
                        continue;
                    }
                } else if (annotationType == Part.class) {
                    if (obj22 != null) {
                        value = ((Part) annotation).value();
                        r0 = ((Part) annotation).encoding();
                        if (obj22 instanceof TypedOutput) {
                            this.multipartBody.addPart(value, r0, (TypedOutput) obj22);
                        } else if (obj22 instanceof String) {
                            this.multipartBody.addPart(value, r0, new TypedString((String) obj22));
                        } else {
                            this.multipartBody.addPart(value, r0, this.converter.toBody(obj22));
                        }
                    }
                } else if (annotationType == PartMap.class) {
                    if (obj22 != null) {
                        value = ((PartMap) annotation).encoding();
                        for (Entry entry2 : ((Map) obj22).entrySet()) {
                            Object key = entry2.getKey();
                            if (key == null) {
                                throw new IllegalArgumentException("Parameter #" + (i2 + 1) + " part map contained null key.");
                            }
                            String obj4 = key.toString();
                            r0 = entry2.getValue();
                            if (r0 != null) {
                                if (r0 instanceof TypedOutput) {
                                    this.multipartBody.addPart(obj4, value, (TypedOutput) r0);
                                } else if (r0 instanceof String) {
                                    this.multipartBody.addPart(obj4, value, new TypedString((String) r0));
                                } else {
                                    this.multipartBody.addPart(obj4, value, this.converter.toBody(r0));
                                }
                            }
                        }
                        continue;
                    } else {
                        continue;
                    }
                } else if (annotationType != Body.class) {
                    throw new IllegalArgumentException("Unknown annotation: " + annotationType.getCanonicalName());
                } else if (obj22 == null) {
                    throw new IllegalArgumentException("Body parameter value must not be null.");
                } else if (obj22 instanceof TypedOutput) {
                    this.body = (TypedOutput) obj22;
                } else {
                    this.body = this.converter.toBody(obj22);
                }
            }
        }
    }

    Request build() throws UnsupportedEncodingException {
        if (this.multipartBody == null || this.multipartBody.getPartCount() != 0) {
            TypedOutput mimeOverridingTypedOutput;
            String str = this.apiUrl;
            StringBuilder stringBuilder = new StringBuilder(str);
            if (str.endsWith("/")) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            stringBuilder.append(this.relativeUrl);
            CharSequence charSequence = this.queryParams;
            if (charSequence != null) {
                stringBuilder.append(charSequence);
            }
            TypedOutput typedOutput = this.body;
            List list = this.headers;
            if (this.contentTypeHeader != null) {
                if (typedOutput != null) {
                    mimeOverridingTypedOutput = new MimeOverridingTypedOutput(typedOutput, this.contentTypeHeader);
                } else {
                    Header header = new Header("Content-Type", this.contentTypeHeader);
                    if (list == null) {
                        list = Collections.singletonList(header);
                        mimeOverridingTypedOutput = typedOutput;
                    } else {
                        list.add(header);
                    }
                }
                return new Request(this.requestMethod, stringBuilder.toString(), list, mimeOverridingTypedOutput);
            }
            mimeOverridingTypedOutput = typedOutput;
            return new Request(this.requestMethod, stringBuilder.toString(), list, mimeOverridingTypedOutput);
        }
        throw new IllegalStateException("Multipart requests must contain at least one part.");
    }
}
