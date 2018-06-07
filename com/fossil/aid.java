package com.fossil;

import com.fasterxml.jackson.core.JsonLocation;

public class aid {
    private final JsonLocation _location;
    private final Object aRm;
    private final Class<?> aRn;

    public aid(Object obj, Class<?> cls, JsonLocation jsonLocation) {
        this.aRm = obj;
        this.aRn = cls;
        this._location = jsonLocation;
    }

    public String toString() {
        String str = "Object id [%s] (for %s) at %s";
        Object[] objArr = new Object[3];
        objArr[0] = this.aRm;
        objArr[1] = this.aRn == null ? "NULL" : this.aRn.getName();
        objArr[2] = this._location;
        return String.format(str, objArr);
    }
}
