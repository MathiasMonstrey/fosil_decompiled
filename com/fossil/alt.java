package com.fossil;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.util.Arrays;

public abstract class alt {
    protected final boolean aUF;

    static final class C1675a extends alt {
        private final Class<?> aUG;
        private final Class<?> aUH;
        private final ahb<Object> aUI;
        private final ahb<Object> aUJ;

        public C1675a(alt com_fossil_alt, Class<?> cls, ahb<Object> com_fossil_ahb_java_lang_Object, Class<?> cls2, ahb<Object> com_fossil_ahb_java_lang_Object2) {
            super(com_fossil_alt);
            this.aUG = cls;
            this.aUI = com_fossil_ahb_java_lang_Object;
            this.aUH = cls2;
            this.aUJ = com_fossil_ahb_java_lang_Object2;
        }

        public ahb<Object> mo1085o(Class<?> cls) {
            if (cls == this.aUG) {
                return this.aUI;
            }
            if (cls == this.aUH) {
                return this.aUJ;
            }
            return null;
        }

        public alt mo1084b(Class<?> cls, ahb<Object> com_fossil_ahb_java_lang_Object) {
            return new C1677c(this, new C1680f[]{new C1680f(this.aUG, this.aUI), new C1680f(this.aUH, this.aUJ), new C1680f(cls, com_fossil_ahb_java_lang_Object)});
        }
    }

    static final class C1676b extends alt {
        public static final C1676b aUK = new C1676b(false);
        public static final C1676b aUL = new C1676b(true);

        protected C1676b(boolean z) {
            super(z);
        }

        public ahb<Object> mo1085o(Class<?> cls) {
            return null;
        }

        public alt mo1084b(Class<?> cls, ahb<Object> com_fossil_ahb_java_lang_Object) {
            return new C1679e(this, cls, com_fossil_ahb_java_lang_Object);
        }
    }

    static final class C1677c extends alt {
        private final C1680f[] aUM;

        public C1677c(alt com_fossil_alt, C1680f[] c1680fArr) {
            super(com_fossil_alt);
            this.aUM = c1680fArr;
        }

        public ahb<Object> mo1085o(Class<?> cls) {
            for (C1680f c1680f : this.aUM) {
                if (c1680f.type == cls) {
                    return c1680f.aUD;
                }
            }
            return null;
        }

        public alt mo1084b(Class<?> cls, ahb<Object> com_fossil_ahb_java_lang_Object) {
            int length = this.aUM.length;
            if (length != 8) {
                C1680f[] c1680fArr = (C1680f[]) Arrays.copyOf(this.aUM, length + 1);
                c1680fArr[length] = new C1680f(cls, com_fossil_ahb_java_lang_Object);
                return new C1677c(this, c1680fArr);
            } else if (this.aUF) {
                return new C1679e(this, cls, com_fossil_ahb_java_lang_Object);
            } else {
                return this;
            }
        }
    }

    public static final class C1678d {
        public final ahb<Object> aUD;
        public final alt aUN;

        public C1678d(ahb<Object> com_fossil_ahb_java_lang_Object, alt com_fossil_alt) {
            this.aUD = com_fossil_ahb_java_lang_Object;
            this.aUN = com_fossil_alt;
        }
    }

    static final class C1679e extends alt {
        private final ahb<Object> _serializer;
        private final Class<?> aRn;

        public C1679e(alt com_fossil_alt, Class<?> cls, ahb<Object> com_fossil_ahb_java_lang_Object) {
            super(com_fossil_alt);
            this.aRn = cls;
            this._serializer = com_fossil_ahb_java_lang_Object;
        }

        public ahb<Object> mo1085o(Class<?> cls) {
            if (cls == this.aRn) {
                return this._serializer;
            }
            return null;
        }

        public alt mo1084b(Class<?> cls, ahb<Object> com_fossil_ahb_java_lang_Object) {
            return new C1675a(this, this.aRn, this._serializer, cls, com_fossil_ahb_java_lang_Object);
        }
    }

    static final class C1680f {
        public final ahb<Object> aUD;
        public final Class<?> type;

        public C1680f(Class<?> cls, ahb<Object> com_fossil_ahb_java_lang_Object) {
            this.type = cls;
            this.aUD = com_fossil_ahb_java_lang_Object;
        }
    }

    public abstract alt mo1084b(Class<?> cls, ahb<Object> com_fossil_ahb_java_lang_Object);

    public abstract ahb<Object> mo1085o(Class<?> cls);

    protected alt(boolean z) {
        this.aUF = z;
    }

    protected alt(alt com_fossil_alt) {
        this.aUF = com_fossil_alt.aUF;
    }

    public final C1678d m3769a(Class<?> cls, ahg com_fossil_ahg, agv com_fossil_agv) throws JsonMappingException {
        ahb findPrimaryPropertySerializer = com_fossil_ahg.findPrimaryPropertySerializer((Class) cls, com_fossil_agv);
        return new C1678d(findPrimaryPropertySerializer, mo1084b(cls, findPrimaryPropertySerializer));
    }

    public final C1678d m3768a(JavaType javaType, ahg com_fossil_ahg, agv com_fossil_agv) throws JsonMappingException {
        ahb findPrimaryPropertySerializer = com_fossil_ahg.findPrimaryPropertySerializer(javaType, com_fossil_agv);
        return new C1678d(findPrimaryPropertySerializer, mo1084b(javaType.getRawClass(), findPrimaryPropertySerializer));
    }

    public final C1678d m3771b(Class<?> cls, ahg com_fossil_ahg, agv com_fossil_agv) throws JsonMappingException {
        ahb findValueSerializer = com_fossil_ahg.findValueSerializer((Class) cls, com_fossil_agv);
        return new C1678d(findValueSerializer, mo1084b(cls, findValueSerializer));
    }

    public final C1678d m3770b(JavaType javaType, ahg com_fossil_ahg, agv com_fossil_agv) throws JsonMappingException {
        ahb findValueSerializer = com_fossil_ahg.findValueSerializer(javaType, com_fossil_agv);
        return new C1678d(findValueSerializer, mo1084b(javaType.getRawClass(), findValueSerializer));
    }

    public static alt GM() {
        return C1676b.aUK;
    }

    public static alt GN() {
        return C1676b.aUL;
    }
}
