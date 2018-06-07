package com.fossil;

import com.google.common.collect.MapMaker;
import java.lang.reflect.Array;

public final class cdm {
    static <T> T[] m6026d(T[] tArr, int i) {
        return (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i);
    }

    public static MapMaker m6025a(MapMaker mapMaker) {
        return mapMaker.UY();
    }
}
