package retrofit;

public interface RequestInterceptor {
    public static final RequestInterceptor NONE = new C51941();

    public interface RequestFacade {
        void addEncodedPathParam(String str, String str2);

        void addEncodedQueryParam(String str, String str2);

        void addHeader(String str, String str2);

        void addPathParam(String str, String str2);

        void addQueryParam(String str, String str2);
    }

    static class C51941 implements RequestInterceptor {
        C51941() {
        }

        public void intercept(RequestFacade requestFacade) {
        }
    }

    void intercept(RequestFacade requestFacade);
}
