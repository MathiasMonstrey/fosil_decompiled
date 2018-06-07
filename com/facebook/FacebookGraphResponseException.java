package com.facebook;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;

public class FacebookGraphResponseException extends FacebookException {
    private final GraphResponse graphResponse;

    public FacebookGraphResponseException(GraphResponse graphResponse, String str) {
        super(str);
        this.graphResponse = graphResponse;
    }

    public final GraphResponse getGraphResponse() {
        return this.graphResponse;
    }

    public final String toString() {
        FacebookRequestError error = this.graphResponse != null ? this.graphResponse.getError() : null;
        StringBuilder append = new StringBuilder().append("{FacebookGraphResponseException: ");
        String message = getMessage();
        if (message != null) {
            append.append(message);
            append.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        }
        if (error != null) {
            append.append("httpResponseCode: ").append(error.getRequestStatusCode()).append(", facebookErrorCode: ").append(error.getErrorCode()).append(", facebookErrorType: ").append(error.getErrorType()).append(", message: ").append(error.getErrorMessage()).append("}");
        }
        return append.toString();
    }
}
