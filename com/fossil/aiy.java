package com.fossil;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.databind.PropertyName;

public class aiy {
    protected final Class<?> _scope;
    protected final PropertyName aSE;
    protected final Class<? extends ObjectIdGenerator<?>> aSF;
    protected final Class<? extends aeu> aSG;
    protected final boolean aSH;

    public aiy(PropertyName propertyName, Class<?> cls, Class<? extends ObjectIdGenerator<?>> cls2, Class<? extends aeu> cls3) {
        this(propertyName, cls, cls2, false, cls3);
    }

    protected aiy(PropertyName propertyName, Class<?> cls, Class<? extends ObjectIdGenerator<?>> cls2, boolean z, Class<? extends aeu> cls3) {
        this.aSE = propertyName;
        this._scope = cls;
        this.aSF = cls2;
        this.aSH = z;
        if (cls3 == null) {
            cls3 = aev.class;
        }
        this.aSG = cls3;
    }

    public aiy aL(boolean z) {
        if (this.aSH == z) {
            return this;
        }
        return new aiy(this.aSE, this._scope, this.aSF, z, this.aSG);
    }

    public PropertyName Fy() {
        return this.aSE;
    }

    public Class<?> getScope() {
        return this._scope;
    }

    public Class<? extends ObjectIdGenerator<?>> Fz() {
        return this.aSF;
    }

    public Class<? extends aeu> FA() {
        return this.aSG;
    }

    public boolean FB() {
        return this.aSH;
    }

    public String toString() {
        return "ObjectIdInfo: propName=" + this.aSE + ", scope=" + (this._scope == null ? "null" : this._scope.getName()) + ", generatorType=" + (this.aSF == null ? "null" : this.aSF.getName()) + ", alwaysAsId=" + this.aSH;
    }
}
