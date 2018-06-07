package com.fossil;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.SettableAnyProperty;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fossil.aij.C1647a;
import com.fossil.aij.C1648b;
import com.fossil.aij.C1649c;
import java.io.IOException;
import java.util.BitSet;

public class aik {
    protected final ObjectIdReader _objectIdReader;
    protected final JsonParser _parser;
    protected final DeserializationContext aQk;
    protected final Object[] aRJ;
    protected int aRK;
    protected int aRL;
    protected final BitSet aRM;
    protected aij aRN;
    protected Object aRO;

    public aik(JsonParser jsonParser, DeserializationContext deserializationContext, int i, ObjectIdReader objectIdReader) {
        this._parser = jsonParser;
        this.aQk = deserializationContext;
        this.aRK = i;
        this._objectIdReader = objectIdReader;
        this.aRJ = new Object[i];
        if (i < 32) {
            this.aRM = null;
        } else {
            this.aRM = new BitSet();
        }
    }

    protected Object[] m3401a(SettableBeanProperty[] settableBeanPropertyArr) throws JsonMappingException {
        int i = 0;
        if (this.aRK > 0) {
            int length;
            if (this.aRM != null) {
                length = this.aRJ.length;
                while (true) {
                    i = this.aRM.nextClearBit(i);
                    if (i >= length) {
                        break;
                    }
                    this.aRJ[i] = m3403d(settableBeanPropertyArr[i]);
                    i++;
                }
            } else {
                length = this.aRL;
                int length2 = this.aRJ.length;
                while (i < length2) {
                    if ((length & 1) == 0) {
                        this.aRJ[i] = m3403d(settableBeanPropertyArr[i]);
                    }
                    i++;
                    length >>= 1;
                }
            }
        }
        return this.aRJ;
    }

    protected Object m3403d(SettableBeanProperty settableBeanProperty) throws JsonMappingException {
        if (settableBeanProperty.getInjectableValueId() != null) {
            return this.aQk.findInjectableValue(settableBeanProperty.getInjectableValueId(), settableBeanProperty, null);
        }
        if (settableBeanProperty.isRequired()) {
            throw this.aQk.mappingException("Missing required creator property '%s' (index %d)", settableBeanProperty.getName(), Integer.valueOf(settableBeanProperty.getCreatorIndex()));
        } else if (!this.aQk.isEnabled(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES)) {
            return settableBeanProperty.getValueDeserializer().getNullValue(this.aQk);
        } else {
            throw this.aQk.mappingException("Missing creator property '%s' (index %d); DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES enabled", settableBeanProperty.getName(), Integer.valueOf(settableBeanProperty.getCreatorIndex()));
        }
    }

    public boolean bK(String str) throws IOException {
        if (this._objectIdReader == null || !str.equals(this._objectIdReader.propertyName.getSimpleName())) {
            return false;
        }
        this.aRO = this._objectIdReader.readObjectReference(this._parser, this.aQk);
        return true;
    }

    public Object m3398a(DeserializationContext deserializationContext, Object obj) throws IOException {
        if (this._objectIdReader == null) {
            return obj;
        }
        if (this.aRO != null) {
            deserializationContext.findObjectId(this.aRO, this._objectIdReader.generator, this._objectIdReader.resolver).bu(obj);
            SettableBeanProperty settableBeanProperty = this._objectIdReader.idProperty;
            if (settableBeanProperty != null) {
                return settableBeanProperty.setAndReturn(obj, this.aRO);
            }
            return obj;
        }
        throw deserializationContext.mappingException("No _idValue when handleIdValue called, on instance of %s", obj.getClass().getName());
    }

    protected aij EJ() {
        return this.aRN;
    }

    public boolean m3400a(SettableBeanProperty settableBeanProperty, Object obj) {
        int creatorIndex = settableBeanProperty.getCreatorIndex();
        this.aRJ[creatorIndex] = obj;
        int i;
        if (this.aRM == null) {
            i = this.aRL;
            creatorIndex = (1 << creatorIndex) | i;
            if (i != creatorIndex) {
                this.aRL = creatorIndex;
                creatorIndex = this.aRK - 1;
                this.aRK = creatorIndex;
                if (creatorIndex <= 0) {
                    return true;
                }
            }
        } else if (!this.aRM.get(creatorIndex)) {
            i = this.aRK - 1;
            this.aRK = i;
            if (i <= 0) {
                return true;
            }
            this.aRM.set(creatorIndex);
        }
        return false;
    }

    public void m3402b(SettableBeanProperty settableBeanProperty, Object obj) {
        this.aRN = new C1649c(this.aRN, obj, settableBeanProperty);
    }

    public void m3399a(SettableAnyProperty settableAnyProperty, String str, Object obj) {
        this.aRN = new C1647a(this.aRN, obj, settableAnyProperty, str);
    }

    public void m3404j(Object obj, Object obj2) {
        this.aRN = new C1648b(this.aRN, obj2, obj);
    }
}
