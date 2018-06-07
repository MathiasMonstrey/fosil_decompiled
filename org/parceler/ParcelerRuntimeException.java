package org.parceler;

public class ParcelerRuntimeException extends RuntimeException {
    public ParcelerRuntimeException(String str) {
        super(str);
    }

    public ParcelerRuntimeException(String str, Exception exception) {
        super(str, exception);
    }

    public ParcelerRuntimeException(String str, Throwable th) {
        super(str, th);
    }
}
