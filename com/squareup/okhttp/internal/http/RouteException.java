package com.squareup.okhttp.internal.http;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class RouteException extends Exception {
    private static final Method dzV;
    private IOException lastException;

    static {
        Method declaredMethod;
        try {
            declaredMethod = Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class});
        } catch (Exception e) {
            declaredMethod = null;
        }
        dzV = declaredMethod;
    }

    public RouteException(IOException iOException) {
        super(iOException);
        this.lastException = iOException;
    }

    public IOException getLastConnectException() {
        return this.lastException;
    }

    public void addConnectException(IOException iOException) {
        m16101a(iOException, this.lastException);
        this.lastException = iOException;
    }

    private void m16101a(IOException iOException, IOException iOException2) {
        if (dzV != null) {
            try {
                dzV.invoke(iOException, new Object[]{iOException2});
            } catch (InvocationTargetException e) {
            } catch (IllegalAccessException e2) {
            }
        }
    }
}
