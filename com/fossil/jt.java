package com.fossil;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;

public class jt<F, S> {
    public final F first;
    public final S second;

    public jt(F f, S s) {
        this.first = f;
        this.second = s;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof jt)) {
            return false;
        }
        jt jtVar = (jt) obj;
        if (objectsEqual(jtVar.first, this.first) && objectsEqual(jtVar.second, this.second)) {
            return true;
        }
        return false;
    }

    private static boolean objectsEqual(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.first == null ? 0 : this.first.hashCode();
        if (this.second != null) {
            i = this.second.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.first) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + String.valueOf(this.second) + "}";
    }
}
