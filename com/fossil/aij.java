package com.fossil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.deser.SettableAnyProperty;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import java.io.IOException;
import java.util.Map;

public abstract class aij {
    public final aij aRG;
    public final Object value;

    static final class C1647a extends aij {
        final String _propertyName;
        final SettableAnyProperty aRH;

        public C1647a(aij com_fossil_aij, Object obj, SettableAnyProperty settableAnyProperty, String str) {
            super(com_fossil_aij, obj);
            this.aRH = settableAnyProperty;
            this._propertyName = str;
        }

        public void bt(Object obj) throws IOException, JsonProcessingException {
            this.aRH.set(obj, this._propertyName, this.value);
        }
    }

    static final class C1648b extends aij {
        final Object aRI;

        public C1648b(aij com_fossil_aij, Object obj, Object obj2) {
            super(com_fossil_aij, obj);
            this.aRI = obj2;
        }

        public void bt(Object obj) throws IOException, JsonProcessingException {
            ((Map) obj).put(this.aRI, this.value);
        }
    }

    static final class C1649c extends aij {
        final SettableBeanProperty aRA;

        public C1649c(aij com_fossil_aij, Object obj, SettableBeanProperty settableBeanProperty) {
            super(com_fossil_aij, obj);
            this.aRA = settableBeanProperty;
        }

        public void bt(Object obj) throws IOException, JsonProcessingException {
            this.aRA.set(obj, this.value);
        }
    }

    public abstract void bt(Object obj) throws IOException, JsonProcessingException;

    protected aij(aij com_fossil_aij, Object obj) {
        this.aRG = com_fossil_aij;
        this.value = obj;
    }
}
