package com.fossil;

import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.internal.bind.ObjectTypeAdapter.1;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class cgo extends cfw<Object> {
    public static final cfx bSa = new 1();
    private final cfj gson;

    static /* synthetic */ class C20511 {
        static final /* synthetic */ int[] bSt = new int[JsonToken.values().length];

        static {
            try {
                bSt[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                bSt[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                bSt[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                bSt[JsonToken.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                bSt[JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                bSt[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public cgo(cfj com_fossil_cfj) {
        this.gson = com_fossil_cfj;
    }

    public Object mo1657b(cgv com_fossil_cgv) throws IOException {
        switch (C20511.bSt[com_fossil_cgv.WT().ordinal()]) {
            case 1:
                List arrayList = new ArrayList();
                com_fossil_cgv.beginArray();
                while (com_fossil_cgv.hasNext()) {
                    arrayList.add(mo1657b(com_fossil_cgv));
                }
                com_fossil_cgv.endArray();
                return arrayList;
            case 2:
                Object linkedTreeMap = new LinkedTreeMap();
                com_fossil_cgv.beginObject();
                while (com_fossil_cgv.hasNext()) {
                    linkedTreeMap.put(com_fossil_cgv.nextName(), mo1657b(com_fossil_cgv));
                }
                com_fossil_cgv.endObject();
                return linkedTreeMap;
            case 3:
                return com_fossil_cgv.nextString();
            case 4:
                return Double.valueOf(com_fossil_cgv.nextDouble());
            case 5:
                return Boolean.valueOf(com_fossil_cgv.nextBoolean());
            case 6:
                com_fossil_cgv.nextNull();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    public void mo1656a(cgw com_fossil_cgw, Object obj) throws IOException {
        if (obj == null) {
            com_fossil_cgw.Xe();
            return;
        }
        cfw aa = this.gson.aa(obj.getClass());
        if (aa instanceof cgo) {
            com_fossil_cgw.Xc();
            com_fossil_cgw.Xd();
            return;
        }
        aa.mo1656a(com_fossil_cgw, obj);
    }
}
