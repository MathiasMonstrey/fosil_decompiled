package com.fossil;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

public final class alm {
    private final HashMap<amu, ahb<Object>> aUx = new HashMap(64);
    private final AtomicReference<alu> aUy = new AtomicReference();

    @Deprecated
    public static final class C1672a extends amu {
        public C1672a(Class<?> cls, boolean z) {
            super((Class) cls, z);
        }

        public C1672a(JavaType javaType, boolean z) {
            super(javaType, z);
        }
    }

    public alu GK() {
        alu com_fossil_alu = (alu) this.aUy.get();
        return com_fossil_alu != null ? com_fossil_alu : GL();
    }

    private final synchronized alu GL() {
        alu com_fossil_alu;
        com_fossil_alu = (alu) this.aUy.get();
        if (com_fossil_alu == null) {
            com_fossil_alu = alu.m3786b(this.aUx);
            this.aUy.set(com_fossil_alu);
        }
        return com_fossil_alu;
    }

    public synchronized int size() {
        return this.aUx.size();
    }

    public ahb<Object> m3734m(Class<?> cls) {
        ahb<Object> com_fossil_ahb_java_lang_Object;
        synchronized (this) {
            com_fossil_ahb_java_lang_Object = (ahb) this.aUx.get(new C1672a((Class) cls, false));
        }
        return com_fossil_ahb_java_lang_Object;
    }

    public ahb<Object> m3736o(JavaType javaType) {
        ahb<Object> com_fossil_ahb_java_lang_Object;
        synchronized (this) {
            com_fossil_ahb_java_lang_Object = (ahb) this.aUx.get(new C1672a(javaType, false));
        }
        return com_fossil_ahb_java_lang_Object;
    }

    public ahb<Object> m3737p(JavaType javaType) {
        ahb<Object> com_fossil_ahb_java_lang_Object;
        synchronized (this) {
            com_fossil_ahb_java_lang_Object = (ahb) this.aUx.get(new C1672a(javaType, true));
        }
        return com_fossil_ahb_java_lang_Object;
    }

    public ahb<Object> m3735n(Class<?> cls) {
        ahb<Object> com_fossil_ahb_java_lang_Object;
        synchronized (this) {
            com_fossil_ahb_java_lang_Object = (ahb) this.aUx.get(new C1672a((Class) cls, true));
        }
        return com_fossil_ahb_java_lang_Object;
    }

    public void m3731a(JavaType javaType, ahb<Object> com_fossil_ahb_java_lang_Object) {
        synchronized (this) {
            if (this.aUx.put(new C1672a(javaType, true), com_fossil_ahb_java_lang_Object) == null) {
                this.aUy.set(null);
            }
        }
    }

    public void m3733a(Class<?> cls, ahb<Object> com_fossil_ahb_java_lang_Object) {
        synchronized (this) {
            if (this.aUx.put(new C1672a((Class) cls, true), com_fossil_ahb_java_lang_Object) == null) {
                this.aUy.set(null);
            }
        }
    }

    public void m3732a(JavaType javaType, ahb<Object> com_fossil_ahb_java_lang_Object, ahg com_fossil_ahg) throws JsonMappingException {
        synchronized (this) {
            if (this.aUx.put(new C1672a(javaType, false), com_fossil_ahb_java_lang_Object) == null) {
                this.aUy.set(null);
            }
            if (com_fossil_ahb_java_lang_Object instanceof all) {
                ((all) com_fossil_ahb_java_lang_Object).resolve(com_fossil_ahg);
            }
        }
    }

    public synchronized void flush() {
        this.aUx.clear();
    }
}
