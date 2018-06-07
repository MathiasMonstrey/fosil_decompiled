package com.fossil;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.MapperConfig;

public class alq extends alp {
    protected final String aUz;

    protected alq(String str, aiv com_fossil_aiv, amc com_fossil_amc, JavaType javaType) {
        this(str, com_fossil_aiv, com_fossil_amc, javaType, com_fossil_aiv.Fx());
    }

    protected alq(String str, aiv com_fossil_aiv, amc com_fossil_amc, JavaType javaType, Include include) {
        super(com_fossil_aiv, com_fossil_amc, javaType, null, null, null, include);
        this.aUz = str;
    }

    public static alq m3749a(String str, aiv com_fossil_aiv, amc com_fossil_amc, JavaType javaType) {
        return new alq(str, com_fossil_aiv, com_fossil_amc, javaType);
    }

    public alp mo1079a(MapperConfig<?> mapperConfig, air com_fossil_air, aiv com_fossil_aiv, JavaType javaType) {
        throw new IllegalStateException("Should not be called on this type");
    }

    protected Object mo1080f(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws Exception {
        return com_fossil_ahg.getAttribute(this.aUz);
    }
}
