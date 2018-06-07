package com.fossil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class dxj {
    private boolean dAu = true;
    private final int hashCode;
    private final Method method;
    private final Object target;

    dxj(Object obj, Method method) {
        if (obj == null) {
            throw new NullPointerException("EventHandler target cannot be null.");
        } else if (method == null) {
            throw new NullPointerException("EventHandler method cannot be null.");
        } else {
            this.target = obj;
            this.method = method;
            method.setAccessible(true);
            this.hashCode = ((method.hashCode() + 31) * 31) + obj.hashCode();
        }
    }

    public boolean isValid() {
        return this.dAu;
    }

    public void invalidate() {
        this.dAu = false;
    }

    public void cX(Object obj) throws InvocationTargetException {
        if (this.dAu) {
            try {
                this.method.invoke(this.target, new Object[]{obj});
                return;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                if (e2.getCause() instanceof Error) {
                    throw ((Error) e2.getCause());
                }
                throw e2;
            }
        }
        throw new IllegalStateException(toString() + " has been invalidated and can no longer handle events.");
    }

    public String toString() {
        return "[EventHandler " + this.method + "]";
    }

    public int hashCode() {
        return this.hashCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        dxj com_fossil_dxj = (dxj) obj;
        if (this.method.equals(com_fossil_dxj.method) && this.target == com_fossil_dxj.target) {
            return true;
        }
        return false;
    }
}
