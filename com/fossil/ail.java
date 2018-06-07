package com.fossil;

import com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class ail {
    @Deprecated
    public Object aRP;
    @Deprecated
    public final Object aRQ;
    protected final IdKey aRR;
    protected LinkedList<C1512a> aRS;
    protected aeu aRT;

    public static abstract class C1512a {
        private final UnresolvedForwardReference aRU;
        private final Class<?> aRV;

        public abstract void mo510i(Object obj, Object obj2) throws IOException;

        public C1512a(UnresolvedForwardReference unresolvedForwardReference, Class<?> cls) {
            this.aRU = unresolvedForwardReference;
            this.aRV = cls;
        }

        public JsonLocation getLocation() {
            return this.aRU.getLocation();
        }

        public Class<?> EO() {
            return this.aRV;
        }

        public boolean bv(Object obj) {
            return obj.equals(this.aRU.getUnresolvedId());
        }
    }

    public ail(IdKey idKey) {
        this.aRR = idKey;
        this.aRQ = idKey.key;
    }

    public void m3407b(aeu com_fossil_aeu) {
        this.aRT = com_fossil_aeu;
    }

    public IdKey EK() {
        return this.aRR;
    }

    public void m3405a(C1512a c1512a) {
        if (this.aRS == null) {
            this.aRS = new LinkedList();
        }
        this.aRS.add(c1512a);
    }

    public void bu(Object obj) throws IOException {
        this.aRT.mo842a(this.aRR, obj);
        this.aRP = obj;
        if (this.aRS != null) {
            Iterator it = this.aRS.iterator();
            this.aRS = null;
            while (it.hasNext()) {
                ((C1512a) it.next()).mo510i(this.aRQ, obj);
            }
        }
    }

    public Object EL() {
        Object a = this.aRT.mo841a(this.aRR);
        this.aRP = a;
        return a;
    }

    public boolean EM() {
        return (this.aRS == null || this.aRS.isEmpty()) ? false : true;
    }

    public Iterator<C1512a> EN() {
        if (this.aRS == null) {
            return Collections.emptyList().iterator();
        }
        return this.aRS.iterator();
    }

    public boolean m3406a(DeserializationContext deserializationContext) {
        return false;
    }

    public String toString() {
        return String.valueOf(this.aRR);
    }
}
