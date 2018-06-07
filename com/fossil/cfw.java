package com.fossil;

import com.google.gson.JsonIOException;
import com.google.gson.stream.JsonToken;
import java.io.IOException;

public abstract class cfw<T> {

    class C20311 extends cfw<T> {
        final /* synthetic */ cfw bRn;

        C20311(cfw com_fossil_cfw) {
            this.bRn = com_fossil_cfw;
        }

        public void mo1656a(cgw com_fossil_cgw, T t) throws IOException {
            if (t == null) {
                com_fossil_cgw.Xe();
            } else {
                this.bRn.mo1656a(com_fossil_cgw, t);
            }
        }

        public T mo1657b(cgv com_fossil_cgv) throws IOException {
            if (com_fossil_cgv.WT() != JsonToken.NULL) {
                return this.bRn.mo1657b(com_fossil_cgv);
            }
            com_fossil_cgv.nextNull();
            return null;
        }
    }

    public abstract void mo1656a(cgw com_fossil_cgw, T t) throws IOException;

    public abstract T mo1657b(cgv com_fossil_cgv) throws IOException;

    public final cfw<T> WF() {
        return new C20311(this);
    }

    public final cfp cF(T t) {
        try {
            cgw com_fossil_cgn = new cgn();
            mo1656a(com_fossil_cgn, t);
            return com_fossil_cgn.WY();
        } catch (Throwable e) {
            throw new JsonIOException(e);
        }
    }
}
