package com.fossil;

import com.google.gson.internal.bind.ArrayTypeAdapter.1;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class cgk<E> extends cfw<Object> {
    public static final cfx bSa = new 1();
    private final Class<E> bSb;
    private final cfw<E> bSc;

    public cgk(cfj com_fossil_cfj, cfw<E> com_fossil_cfw_E, Class<E> cls) {
        this.bSc = new cgr(com_fossil_cfj, com_fossil_cfw_E, cls);
        this.bSb = cls;
    }

    public Object mo1657b(cgv com_fossil_cgv) throws IOException {
        if (com_fossil_cgv.WT() == JsonToken.NULL) {
            com_fossil_cgv.nextNull();
            return null;
        }
        List arrayList = new ArrayList();
        com_fossil_cgv.beginArray();
        while (com_fossil_cgv.hasNext()) {
            arrayList.add(this.bSc.mo1657b(com_fossil_cgv));
        }
        com_fossil_cgv.endArray();
        Object newInstance = Array.newInstance(this.bSb, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }

    public void mo1656a(cgw com_fossil_cgw, Object obj) throws IOException {
        if (obj == null) {
            com_fossil_cgw.Xe();
            return;
        }
        com_fossil_cgw.Xa();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.bSc.mo1656a(com_fossil_cgw, Array.get(obj, i));
        }
        com_fossil_cgw.Xb();
    }
}
