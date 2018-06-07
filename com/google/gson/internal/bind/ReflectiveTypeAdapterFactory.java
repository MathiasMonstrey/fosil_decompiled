package com.google.gson.internal.bind;

import com.fossil.cfi;
import com.fossil.cfj;
import com.fossil.cfw;
import com.fossil.cfx;
import com.fossil.cfz;
import com.fossil.cga;
import com.fossil.cge;
import com.fossil.cgg;
import com.fossil.cgh;
import com.fossil.cgr;
import com.fossil.cgu;
import com.fossil.cgv;
import com.fossil.cgw;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.Excluder;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory implements cfx {
    private final cge bQM;
    private final Excluder bQN;
    private final JsonAdapterAnnotationTypeAdapterFactory bQU;
    private final cfi bQZ;

    static abstract class C4403b {
        final boolean bSC;
        final boolean bSD;
        final String name;

        abstract void mo4559a(cgv com_fossil_cgv, Object obj) throws IOException, IllegalAccessException;

        abstract void mo4560a(cgw com_fossil_cgw, Object obj) throws IOException, IllegalAccessException;

        abstract boolean cJ(Object obj) throws IOException, IllegalAccessException;

        protected C4403b(String str, boolean z, boolean z2) {
            this.name = str;
            this.bSC = z;
            this.bSD = z2;
        }
    }

    public static final class C4404a<T> extends cfw<T> {
        private final Map<String, C4403b> bSB;
        private final cgg<T> bSe;

        C4404a(cgg<T> com_fossil_cgg_T, Map<String, C4403b> map) {
            this.bSe = com_fossil_cgg_T;
            this.bSB = map;
        }

        public T m14613b(cgv com_fossil_cgv) throws IOException {
            if (com_fossil_cgv.WT() == JsonToken.NULL) {
                com_fossil_cgv.nextNull();
                return null;
            }
            T WL = this.bSe.WL();
            try {
                com_fossil_cgv.beginObject();
                while (com_fossil_cgv.hasNext()) {
                    C4403b c4403b = (C4403b) this.bSB.get(com_fossil_cgv.nextName());
                    if (c4403b == null || !c4403b.bSD) {
                        com_fossil_cgv.skipValue();
                    } else {
                        c4403b.mo4559a(com_fossil_cgv, (Object) WL);
                    }
                }
                com_fossil_cgv.endObject();
                return WL;
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        public void m14612a(cgw com_fossil_cgw, T t) throws IOException {
            if (t == null) {
                com_fossil_cgw.Xe();
                return;
            }
            com_fossil_cgw.Xc();
            try {
                for (C4403b c4403b : this.bSB.values()) {
                    if (c4403b.cJ(t)) {
                        com_fossil_cgw.fu(c4403b.name);
                        c4403b.mo4560a(com_fossil_cgw, (Object) t);
                    }
                }
                com_fossil_cgw.Xd();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }

    public ReflectiveTypeAdapterFactory(cge com_fossil_cge, cfi com_fossil_cfi, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.bQM = com_fossil_cge;
        this.bQZ = com_fossil_cfi;
        this.bQN = excluder;
        this.bQU = jsonAdapterAnnotationTypeAdapterFactory;
    }

    public boolean m14619a(Field field, boolean z) {
        return m14616a(field, z, this.bQN);
    }

    static boolean m14616a(Field field, boolean z, Excluder excluder) {
        return (excluder.m14585d(field.getType(), z) || excluder.m14584a(field, z)) ? false : true;
    }

    private List<String> m14617c(Field field) {
        cga com_fossil_cga = (cga) field.getAnnotation(cga.class);
        if (com_fossil_cga == null) {
            return Collections.singletonList(this.bQZ.translateName(field));
        }
        String value = com_fossil_cga.value();
        String[] WJ = com_fossil_cga.WJ();
        if (WJ.length == 0) {
            return Collections.singletonList(value);
        }
        List<String> arrayList = new ArrayList(WJ.length + 1);
        arrayList.add(value);
        for (Object add : WJ) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public <T> cfw<T> m14618a(cfj com_fossil_cfj, cgu<T> com_fossil_cgu_T) {
        Class rawType = com_fossil_cgu_T.getRawType();
        if (Object.class.isAssignableFrom(rawType)) {
            return new C4404a(this.bQM.b(com_fossil_cgu_T), m14615a(com_fossil_cfj, (cgu) com_fossil_cgu_T, rawType));
        }
        return null;
    }

    private C4403b m14614a(cfj com_fossil_cfj, Field field, String str, cgu<?> com_fossil_cgu_, boolean z, boolean z2) {
        final boolean x = cgh.x(com_fossil_cgu_.getRawType());
        cfz com_fossil_cfz = (cfz) field.getAnnotation(cfz.class);
        cfw com_fossil_cfw = null;
        if (com_fossil_cfz != null) {
            com_fossil_cfw = this.bQU.m14599a(this.bQM, com_fossil_cfj, com_fossil_cgu_, com_fossil_cfz);
        }
        final boolean z3 = com_fossil_cfw != null;
        if (com_fossil_cfw == null) {
            com_fossil_cfw = com_fossil_cfj.a(com_fossil_cgu_);
        }
        final Field field2 = field;
        final cfj com_fossil_cfj2 = com_fossil_cfj;
        final cgu<?> com_fossil_cgu_2 = com_fossil_cgu_;
        return new C4403b(this, str, z, z2) {
            final /* synthetic */ ReflectiveTypeAdapterFactory bSA;

            void mo4560a(cgw com_fossil_cgw, Object obj) throws IOException, IllegalAccessException {
                cfw com_fossil_cfw;
                Object obj2 = field2.get(obj);
                if (z3) {
                    com_fossil_cfw = com_fossil_cfw;
                } else {
                    com_fossil_cfw = new cgr(com_fossil_cfj2, com_fossil_cfw, com_fossil_cgu_2.getType());
                }
                com_fossil_cfw.a(com_fossil_cgw, obj2);
            }

            void mo4559a(cgv com_fossil_cgv, Object obj) throws IOException, IllegalAccessException {
                Object b = com_fossil_cfw.b(com_fossil_cgv);
                if (b != null || !x) {
                    field2.set(obj, b);
                }
            }

            public boolean cJ(Object obj) throws IOException, IllegalAccessException {
                if (this.bSC && field2.get(obj) != obj) {
                    return true;
                }
                return false;
            }
        };
    }

    private Map<String, C4403b> m14615a(cfj com_fossil_cfj, cgu<?> com_fossil_cgu_, Class<?> cls) {
        Map<String, C4403b> linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = com_fossil_cgu_.getType();
        while (cls != Object.class) {
            for (Field field : cls.getDeclaredFields()) {
                boolean a = m14619a(field, true);
                boolean a2 = m14619a(field, false);
                if (a || a2) {
                    field.setAccessible(true);
                    Type resolve = C$Gson$Types.resolve(com_fossil_cgu_.getType(), cls, field.getGenericType());
                    List c = m14617c(field);
                    C4403b c4403b = null;
                    int i = 0;
                    while (i < c.size()) {
                        String str = (String) c.get(i);
                        if (i != 0) {
                            a = false;
                        }
                        C4403b c4403b2 = (C4403b) linkedHashMap.put(str, m14614a(com_fossil_cfj, field, str, cgu.get(resolve), a, a2));
                        if (c4403b != null) {
                            c4403b2 = c4403b;
                        }
                        i++;
                        c4403b = c4403b2;
                    }
                    if (c4403b != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + c4403b.name);
                    }
                }
            }
            com_fossil_cgu_ = cgu.get(C$Gson$Types.resolve(com_fossil_cgu_.getType(), cls, cls.getGenericSuperclass()));
            cls = com_fossil_cgu_.getRawType();
        }
        return linkedHashMap;
    }
}
