package retrofit;

public interface ErrorHandler {
    public static final ErrorHandler DEFAULT = new C51831();

    static class C51831 implements ErrorHandler {
        C51831() {
        }

        public Throwable handleError(RetrofitError retrofitError) {
            return retrofitError;
        }
    }

    Throwable handleError(RetrofitError retrofitError);
}
