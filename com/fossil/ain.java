package com.fossil;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fossil.agv.C1635a;
import java.io.IOException;

public class ain extends C1635a {
    protected final Object aRX;

    public ain(PropertyName propertyName, JavaType javaType, amc com_fossil_amc, AnnotatedMember annotatedMember, Object obj) {
        super(propertyName, javaType, null, com_fossil_amc, annotatedMember, PropertyMetadata.STD_OPTIONAL);
        this.aRX = obj;
    }

    public Object m3411b(DeserializationContext deserializationContext, Object obj) {
        return deserializationContext.findInjectableValue(this.aRX, this, obj);
    }

    public void inject(DeserializationContext deserializationContext, Object obj) throws IOException {
        this.aQg.setValue(obj, m3411b(deserializationContext, obj));
    }
}
