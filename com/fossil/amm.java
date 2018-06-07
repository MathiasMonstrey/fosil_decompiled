package com.fossil;

import com.fasterxml.jackson.databind.cfg.MapperConfig;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public final class amm {
    private final Class<Enum<?>> _enumClass;
    private final Enum<?>[] aVK;
    private final afc[] aVL;

    private amm(Class<Enum<?>> cls, afc[] com_fossil_afcArr) {
        this._enumClass = cls;
        this.aVK = (Enum[]) cls.getEnumConstants();
        this.aVL = com_fossil_afcArr;
    }

    public static amm m3880b(MapperConfig<?> mapperConfig, Class<Enum<?>> cls) {
        Enum[] enumArr = (Enum[]) ami.m3852B(cls).getEnumConstants();
        if (enumArr != null) {
            afc[] com_fossil_afcArr = new afc[enumArr.length];
            for (Enum enumR : enumArr) {
                com_fossil_afcArr[enumR.ordinal()] = mapperConfig.compileString(mapperConfig.getAnnotationIntrospector().findEnumValue(enumR));
            }
            return new amm(cls, com_fossil_afcArr);
        }
        throw new IllegalArgumentException("Can not determine enum constants for Class " + cls.getName());
    }

    public afc m3881b(Enum<?> enumR) {
        return this.aVL[enumR.ordinal()];
    }

    public Collection<afc> values() {
        return Arrays.asList(this.aVL);
    }

    public List<Enum<?>> Hl() {
        return Arrays.asList(this.aVK);
    }

    public Class<Enum<?>> getEnumClass() {
        return this._enumClass;
    }
}
