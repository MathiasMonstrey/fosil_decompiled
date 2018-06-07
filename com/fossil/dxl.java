package com.fossil;

import java.util.Map;
import java.util.Set;

interface dxl {
    public static final dxl dAv = new C32851();

    static class C32851 implements dxl {
        C32851() {
        }

        public Map<Class<?>, dxk> cT(Object obj) {
            return dxg.cT(obj);
        }

        public Map<Class<?>, Set<dxj>> cU(Object obj) {
            return dxg.cU(obj);
        }
    }

    Map<Class<?>, dxk> cT(Object obj);

    Map<Class<?>, Set<dxj>> cU(Object obj);
}
