package com.ua.sdk;

public class UaException extends Exception {
    private final Code code;

    public enum Code {
        TIMEOUT,
        NETWORK,
        PERMISSION,
        CANCELED,
        NOT_FOUND,
        BAD_FORMAT,
        UNKNOWN,
        NOT_AUTHENTICATED,
        NOT_CONNECTED,
        NETWORK_ON_MAIN_THREAD
    }

    public UaException(String str) {
        super(str);
        this.code = Code.UNKNOWN;
    }

    public UaException(String str, Throwable th) {
        super(str, th);
        this.code = Code.UNKNOWN;
    }

    public UaException(Code code, String str, Throwable th) {
        super(str, th);
        this.code = code;
    }

    public UaException() {
        super(Code.UNKNOWN.toString());
        this.code = Code.UNKNOWN;
    }

    public UaException(Throwable th) {
        super(Code.UNKNOWN.toString(), th);
        this.code = Code.UNKNOWN;
    }

    public UaException(Code code) {
        super(code.toString());
        this.code = code;
    }

    public UaException(Code code, Throwable th) {
        super(code.toString(), th);
        this.code = code;
    }

    public Code getCode() {
        return this.code;
    }
}
