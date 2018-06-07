package com.fossil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class dxk {
    private boolean dAu = true;
    private final int hashCode;
    private final Method method;
    final Object target;

    dxk(Object obj, Method method) {
        if (obj == null) {
            throw new NullPointerException("EventProducer target cannot be null.");
        } else if (method == null) {
            throw new NullPointerException("EventProducer method cannot be null.");
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

    public Object aBx() throws InvocationTargetException {
        if (this.dAu) {
            try {
                return this.method.invoke(this.target, new Object[0]);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                if (e2.getCause() instanceof Error) {
                    throw ((Error) e2.getCause());
                }
                throw e2;
            }
        }
        throw new IllegalStateException(toString() + " has been invalidated and can no longer produce events.");
    }

    public String toString() {
        return "[EventProducer " + this.method + "]";
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
        dxk com_fossil_dxk = (dxk) obj;
        if (this.method.equals(com_fossil_dxk.method) && this.target == com_fossil_dxk.target) {
            return true;
        }
        return false;
    }
}
