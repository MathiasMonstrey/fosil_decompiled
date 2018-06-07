package com.fossil;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class aim {
    protected final List<SettableBeanProperty> aRW;

    public aim() {
        this.aRW = new ArrayList();
    }

    protected aim(List<SettableBeanProperty> list) {
        this.aRW = list;
    }

    public void m3410a(SettableBeanProperty settableBeanProperty) {
        this.aRW.add(settableBeanProperty);
    }

    public aim m3408a(amo com_fossil_amo) {
        List arrayList = new ArrayList(this.aRW.size());
        for (SettableBeanProperty settableBeanProperty : this.aRW) {
            Object withSimpleName = settableBeanProperty.withSimpleName(com_fossil_amo.cc(settableBeanProperty.getName()));
            agy valueDeserializer = withSimpleName.getValueDeserializer();
            if (valueDeserializer != null) {
                agy unwrappingDeserializer = valueDeserializer.unwrappingDeserializer(com_fossil_amo);
                if (unwrappingDeserializer != valueDeserializer) {
                    withSimpleName = withSimpleName.withValueDeserializer(unwrappingDeserializer);
                }
            }
            arrayList.add(withSimpleName);
        }
        return new aim(arrayList);
    }

    public Object m3409a(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, amt com_fossil_amt) throws IOException, JsonProcessingException {
        int size = this.aRW.size();
        for (int i = 0; i < size; i++) {
            SettableBeanProperty settableBeanProperty = (SettableBeanProperty) this.aRW.get(i);
            JsonParser Hu = com_fossil_amt.Hu();
            Hu.zP();
            settableBeanProperty.deserializeAndSet(Hu, deserializationContext, obj);
        }
        return obj;
    }
}
