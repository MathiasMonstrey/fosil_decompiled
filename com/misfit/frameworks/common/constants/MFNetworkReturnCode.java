package com.misfit.frameworks.common.constants;

public class MFNetworkReturnCode {
    public static final int BAD_REQUEST = 400;
    public static final int CONTENT_TYPE_ERROR = 415;
    public static final int INTERNAL_SERVER_ERROR = 500;
    public static final int ITEM_NAME_IN_USED = 409;
    public static final int METHOD_NOT_ALLOWED = 404;
    public static final int NOT_FOUND = 404;
    public static final int NO_INTERNET_CONNECTION = 601;
    public static final int RATE_LIMIT_EXEEDED = 429;
    public static final int REJECTED_REQUEST = 666;
    public static final int REQUEST_NOT_FOUND = 8000;
    public static final int RESPONSE_OK = 200;
    public static final int SERVER_NOT_RESPONDING = 504;
    public static final int UNAUTHORIZED = 401;
    public static final int UNAVAILABLE = 503;
    public static final int UNKNOWN_ERROR = 600;
    public static final int WRONG_PASSWORD = 403;

    public class InternalErrorCode {
        public static final int TOKEN_EXCHANGE_ERROR = 4012;
        public static final int TOKEN_EXPIRE = 401;
        public static final int WRONG_EMAIL_OR_PASSWORD = 4011;
    }
}
