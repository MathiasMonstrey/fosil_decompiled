package com.fossil;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

public final class aii {
    protected final aie _valueInstantiator;
    protected final HashMap<String, SettableBeanProperty> aRD = new HashMap();
    protected final int aRE;
    protected final SettableBeanProperty[] aRF;

    protected aii(aie com_fossil_aie, SettableBeanProperty[] settableBeanPropertyArr) {
        this._valueInstantiator = com_fossil_aie;
        int length = settableBeanPropertyArr.length;
        this.aRE = length;
        this.aRF = new SettableBeanProperty[length];
        for (int i = 0; i < length; i++) {
            SettableBeanProperty settableBeanProperty = settableBeanPropertyArr[i];
            this.aRF[i] = settableBeanProperty;
            this.aRD.put(settableBeanProperty.getName(), settableBeanProperty);
        }
    }

    public static aii m3395a(DeserializationContext deserializationContext, aie com_fossil_aie, SettableBeanProperty[] settableBeanPropertyArr) throws JsonMappingException {
        int length = settableBeanPropertyArr.length;
        SettableBeanProperty[] settableBeanPropertyArr2 = new SettableBeanProperty[length];
        for (int i = 0; i < length; i++) {
            SettableBeanProperty settableBeanProperty = settableBeanPropertyArr[i];
            if (!settableBeanProperty.hasValueDeserializer()) {
                settableBeanProperty = settableBeanProperty.withValueDeserializer(deserializationContext.findContextualValueDeserializer(settableBeanProperty.getType(), settableBeanProperty));
            }
            settableBeanPropertyArr2[i] = settableBeanProperty;
        }
        return new aii(com_fossil_aie, settableBeanPropertyArr2);
    }

    public Collection<SettableBeanProperty> EI() {
        return this.aRD.values();
    }

    public SettableBeanProperty bJ(String str) {
        return (SettableBeanProperty) this.aRD.get(str);
    }

    public SettableBeanProperty gR(int i) {
        for (SettableBeanProperty settableBeanProperty : this.aRD.values()) {
            if (settableBeanProperty.getPropertyIndex() == i) {
                return settableBeanProperty;
            }
        }
        return null;
    }

    public aik m3396a(JsonParser jsonParser, DeserializationContext deserializationContext, ObjectIdReader objectIdReader) {
        return new aik(jsonParser, deserializationContext, this.aRE, objectIdReader);
    }

    public Object m3397a(DeserializationContext deserializationContext, aik com_fossil_aik) throws IOException {
        Object createFromObjectWith = this._valueInstantiator.createFromObjectWith(deserializationContext, com_fossil_aik.m3401a(this.aRF));
        if (createFromObjectWith != null) {
            createFromObjectWith = com_fossil_aik.m3398a(deserializationContext, createFromObjectWith);
            for (aij EJ = com_fossil_aik.EJ(); EJ != null; EJ = EJ.aRG) {
                EJ.bt(createFromObjectWith);
            }
        }
        return createFromObjectWith;
    }
}
