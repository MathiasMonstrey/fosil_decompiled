package com.google.gson.internal.bind;

import com.fossil.cfj;
import com.fossil.cfw;
import com.fossil.cfx;
import com.fossil.cge;
import com.fossil.cgg;
import com.fossil.cgr;
import com.fossil.cgu;
import com.fossil.cgv;
import com.fossil.cgw;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

public final class CollectionTypeAdapterFactory implements cfx {
    private final cge bQM;

    static final class C4401a<E> extends cfw<Collection<E>> {
        private final cfw<E> bSd;
        private final cgg<? extends Collection<E>> bSe;

        public /* synthetic */ Object m14594b(cgv com_fossil_cgv) throws IOException {
            return m14595i(com_fossil_cgv);
        }

        public C4401a(cfj com_fossil_cfj, Type type, cfw<E> com_fossil_cfw_E, cgg<? extends Collection<E>> com_fossil_cgg__extends_java_util_Collection_E) {
            this.bSd = new cgr(com_fossil_cfj, com_fossil_cfw_E, type);
            this.bSe = com_fossil_cgg__extends_java_util_Collection_E;
        }

        public Collection<E> m14595i(cgv com_fossil_cgv) throws IOException {
            if (com_fossil_cgv.WT() == JsonToken.NULL) {
                com_fossil_cgv.nextNull();
                return null;
            }
            Collection<E> collection = (Collection) this.bSe.WL();
            com_fossil_cgv.beginArray();
            while (com_fossil_cgv.hasNext()) {
                collection.add(this.bSd.b(com_fossil_cgv));
            }
            com_fossil_cgv.endArray();
            return collection;
        }

        public void m14593a(cgw com_fossil_cgw, Collection<E> collection) throws IOException {
            if (collection == null) {
                com_fossil_cgw.Xe();
                return;
            }
            com_fossil_cgw.Xa();
            for (E a : collection) {
                this.bSd.a(com_fossil_cgw, a);
            }
            com_fossil_cgw.Xb();
        }
    }

    public CollectionTypeAdapterFactory(cge com_fossil_cge) {
        this.bQM = com_fossil_cge;
    }

    public <T> cfw<T> m14596a(cfj com_fossil_cfj, cgu<T> com_fossil_cgu_T) {
        Type type = com_fossil_cgu_T.getType();
        Class rawType = com_fossil_cgu_T.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type a = C$Gson$Types.m14571a(type, rawType);
        return new C4401a(com_fossil_cfj, a, com_fossil_cfj.a(cgu.get(a)), this.bQM.b(com_fossil_cgu_T));
    }
}
