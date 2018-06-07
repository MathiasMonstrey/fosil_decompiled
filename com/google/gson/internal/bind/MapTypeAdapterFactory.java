package com.google.gson.internal.bind;

import com.fossil.cfj;
import com.fossil.cfp;
import com.fossil.cft;
import com.fossil.cfw;
import com.fossil.cfx;
import com.fossil.cge;
import com.fossil.cgf;
import com.fossil.cgg;
import com.fossil.cgi;
import com.fossil.cgr;
import com.fossil.cgs;
import com.fossil.cgu;
import com.fossil.cgv;
import com.fossil.cgw;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class MapTypeAdapterFactory implements cfx {
    private final cge bQM;
    final boolean bRf;

    final class C4402a<K, V> extends cfw<Map<K, V>> {
        private final cgg<? extends Map<K, V>> bSe;
        private final cfw<K> bSq;
        private final cfw<V> bSr;
        final /* synthetic */ MapTypeAdapterFactory bSs;

        public /* synthetic */ Object m14603b(cgv com_fossil_cgv) throws IOException {
            return m14604k(com_fossil_cgv);
        }

        public C4402a(MapTypeAdapterFactory mapTypeAdapterFactory, cfj com_fossil_cfj, Type type, cfw<K> com_fossil_cfw_K, Type type2, cfw<V> com_fossil_cfw_V, cgg<? extends Map<K, V>> com_fossil_cgg__extends_java_util_Map_K__V) {
            this.bSs = mapTypeAdapterFactory;
            this.bSq = new cgr(com_fossil_cfj, com_fossil_cfw_K, type);
            this.bSr = new cgr(com_fossil_cfj, com_fossil_cfw_V, type2);
            this.bSe = com_fossil_cgg__extends_java_util_Map_K__V;
        }

        public Map<K, V> m14604k(cgv com_fossil_cgv) throws IOException {
            JsonToken WT = com_fossil_cgv.WT();
            if (WT == JsonToken.NULL) {
                com_fossil_cgv.nextNull();
                return null;
            }
            Map<K, V> map = (Map) this.bSe.WL();
            Object b;
            if (WT == JsonToken.BEGIN_ARRAY) {
                com_fossil_cgv.beginArray();
                while (com_fossil_cgv.hasNext()) {
                    com_fossil_cgv.beginArray();
                    b = this.bSq.b(com_fossil_cgv);
                    if (map.put(b, this.bSr.b(com_fossil_cgv)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + b);
                    }
                    com_fossil_cgv.endArray();
                }
                com_fossil_cgv.endArray();
                return map;
            }
            com_fossil_cgv.beginObject();
            while (com_fossil_cgv.hasNext()) {
                cgf.bRH.h(com_fossil_cgv);
                b = this.bSq.b(com_fossil_cgv);
                if (map.put(b, this.bSr.b(com_fossil_cgv)) != null) {
                    throw new JsonSyntaxException("duplicate key: " + b);
                }
            }
            com_fossil_cgv.endObject();
            return map;
        }

        public void m14602a(cgw com_fossil_cgw, Map<K, V> map) throws IOException {
            int i = 0;
            if (map == null) {
                com_fossil_cgw.Xe();
            } else if (this.bSs.bRf) {
                List arrayList = new ArrayList(map.size());
                List arrayList2 = new ArrayList(map.size());
                int i2 = 0;
                for (Entry entry : map.entrySet()) {
                    int i3;
                    cfp cF = this.bSq.cF(entry.getKey());
                    arrayList.add(cF);
                    arrayList2.add(entry.getValue());
                    if (cF.Ww() || cF.Wx()) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    i2 = i3 | i2;
                }
                if (i2 != 0) {
                    com_fossil_cgw.Xa();
                    while (i < arrayList.size()) {
                        com_fossil_cgw.Xa();
                        cgi.b((cfp) arrayList.get(i), com_fossil_cgw);
                        this.bSr.a(com_fossil_cgw, arrayList2.get(i));
                        com_fossil_cgw.Xb();
                        i++;
                    }
                    com_fossil_cgw.Xb();
                    return;
                }
                com_fossil_cgw.Xc();
                while (i < arrayList.size()) {
                    com_fossil_cgw.fu(m14600e((cfp) arrayList.get(i)));
                    this.bSr.a(com_fossil_cgw, arrayList2.get(i));
                    i++;
                }
                com_fossil_cgw.Xd();
            } else {
                com_fossil_cgw.Xc();
                for (Entry entry2 : map.entrySet()) {
                    com_fossil_cgw.fu(String.valueOf(entry2.getKey()));
                    this.bSr.a(com_fossil_cgw, entry2.getValue());
                }
                com_fossil_cgw.Xd();
            }
        }

        private String m14600e(cfp com_fossil_cfp) {
            if (com_fossil_cfp.Wy()) {
                cft WC = com_fossil_cfp.WC();
                if (WC.DI()) {
                    return String.valueOf(WC.Wv());
                }
                if (WC.isBoolean()) {
                    return Boolean.toString(WC.getAsBoolean());
                }
                if (WC.WE()) {
                    return WC.getAsString();
                }
                throw new AssertionError();
            } else if (com_fossil_cfp.Wz()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }

    public MapTypeAdapterFactory(cge com_fossil_cge, boolean z) {
        this.bQM = com_fossil_cge;
        this.bRf = z;
    }

    public <T> cfw<T> m14606a(cfj com_fossil_cfj, cgu<T> com_fossil_cgu_T) {
        Type type = com_fossil_cgu_T.getType();
        if (!Map.class.isAssignableFrom(com_fossil_cgu_T.getRawType())) {
            return null;
        }
        Type[] b = C$Gson$Types.m14572b(type, C$Gson$Types.getRawType(type));
        cfw a = m14605a(com_fossil_cfj, b[0]);
        cfw a2 = com_fossil_cfj.a(cgu.get(b[1]));
        cgg b2 = this.bQM.b(com_fossil_cgu_T);
        return new C4402a(this, com_fossil_cfj, b[0], a, b[1], a2, b2);
    }

    private cfw<?> m14605a(cfj com_fossil_cfj, Type type) {
        if (type == Boolean.TYPE || type == Boolean.class) {
            return cgs.bSU;
        }
        return com_fossil_cfj.a(cgu.get(type));
    }
}
