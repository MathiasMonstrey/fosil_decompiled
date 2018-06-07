package com.fossil;

public class abk {
    private Class<?> aHc;
    private Class<?> aHd;

    public abk(Class<?> cls, Class<?> cls2) {
        m2862i(cls, cls2);
    }

    public void m2862i(Class<?> cls, Class<?> cls2) {
        this.aHc = cls;
        this.aHd = cls2;
    }

    public String toString() {
        return "MultiClassKey{first=" + this.aHc + ", second=" + this.aHd + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        abk com_fossil_abk = (abk) obj;
        if (!this.aHc.equals(com_fossil_abk.aHc)) {
            return false;
        }
        if (this.aHd.equals(com_fossil_abk.aHd)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.aHc.hashCode() * 31) + this.aHd.hashCode();
    }
}
