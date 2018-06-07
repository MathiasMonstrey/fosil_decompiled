package com.fossil;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyName;

public final class als {
    public final JavaType aUB;
    public final afc aUC;
    public final ahb<Object> aUD;
    public final boolean aUE;
    public final ObjectIdGenerator<?> generator;

    protected als(JavaType javaType, afc com_fossil_afc, ObjectIdGenerator<?> objectIdGenerator, ahb<?> com_fossil_ahb_, boolean z) {
        this.aUB = javaType;
        this.aUC = com_fossil_afc;
        this.generator = objectIdGenerator;
        this.aUD = com_fossil_ahb_;
        this.aUE = z;
    }

    public static als m3765a(JavaType javaType, PropertyName propertyName, ObjectIdGenerator<?> objectIdGenerator, boolean z) {
        return m3766a(javaType, propertyName == null ? null : propertyName.getSimpleName(), (ObjectIdGenerator) objectIdGenerator, z);
    }

    @Deprecated
    public static als m3766a(JavaType javaType, String str, ObjectIdGenerator<?> objectIdGenerator, boolean z) {
        return new als(javaType, str == null ? null : new SerializedString(str), objectIdGenerator, null, z);
    }

    public als m3767c(ahb<?> com_fossil_ahb_) {
        return new als(this.aUB, this.aUC, this.generator, com_fossil_ahb_, this.aUE);
    }

    public als aO(boolean z) {
        return z == this.aUE ? this : new als(this.aUB, this.aUC, this.generator, this.aUD, z);
    }
}
