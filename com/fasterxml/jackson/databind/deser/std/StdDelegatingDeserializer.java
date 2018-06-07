package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fossil.agv;
import com.fossil.agy;
import com.fossil.ahv;
import com.fossil.aic;
import com.fossil.ajs;
import com.fossil.amk;
import java.io.IOException;

public class StdDelegatingDeserializer<T> extends StdDeserializer<T> implements ahv, aic {
    private static final long serialVersionUID = 1;
    protected final amk<Object, T> _converter;
    protected final agy<Object> _delegateDeserializer;
    protected final JavaType _delegateType;

    public StdDelegatingDeserializer(amk<?, T> com_fossil_amk___T) {
        super(Object.class);
        this._converter = com_fossil_amk___T;
        this._delegateType = null;
        this._delegateDeserializer = null;
    }

    public StdDelegatingDeserializer(amk<Object, T> com_fossil_amk_java_lang_Object__T, JavaType javaType, agy<?> com_fossil_agy_) {
        super(javaType);
        this._converter = com_fossil_amk_java_lang_Object__T;
        this._delegateType = javaType;
        this._delegateDeserializer = com_fossil_agy_;
    }

    protected StdDelegatingDeserializer(StdDelegatingDeserializer<T> stdDelegatingDeserializer) {
        super((StdDeserializer) stdDelegatingDeserializer);
        this._converter = stdDelegatingDeserializer._converter;
        this._delegateType = stdDelegatingDeserializer._delegateType;
        this._delegateDeserializer = stdDelegatingDeserializer._delegateDeserializer;
    }

    protected StdDelegatingDeserializer<T> withDelegate(amk<Object, T> com_fossil_amk_java_lang_Object__T, JavaType javaType, agy<?> com_fossil_agy_) {
        if (getClass() == StdDelegatingDeserializer.class) {
            return new StdDelegatingDeserializer(com_fossil_amk_java_lang_Object__T, javaType, com_fossil_agy_);
        }
        throw new IllegalStateException("Sub-class " + getClass().getName() + " must override 'withDelegate'");
    }

    public void resolve(DeserializationContext deserializationContext) throws JsonMappingException {
        if (this._delegateDeserializer != null && (this._delegateDeserializer instanceof aic)) {
            ((aic) this._delegateDeserializer).resolve(deserializationContext);
        }
    }

    public agy<?> createContextual(DeserializationContext deserializationContext, agv com_fossil_agv) throws JsonMappingException {
        if (this._delegateDeserializer != null) {
            agy handleSecondaryContextualization = deserializationContext.handleSecondaryContextualization(this._delegateDeserializer, com_fossil_agv, this._delegateType);
            if (handleSecondaryContextualization != this._delegateDeserializer) {
                return withDelegate(this._converter, this._delegateType, handleSecondaryContextualization);
            }
            return this;
        }
        JavaType a = this._converter.m3878a(deserializationContext.getTypeFactory());
        return withDelegate(this._converter, a, deserializationContext.findContextualValueDeserializer(a, com_fossil_agv));
    }

    public agy<?> getDelegatee() {
        return this._delegateDeserializer;
    }

    public Class<?> handledType() {
        return this._delegateDeserializer.handledType();
    }

    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Object deserialize = this._delegateDeserializer.deserialize(jsonParser, deserializationContext);
        if (deserialize == null) {
            return null;
        }
        return convertValue(deserialize);
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, ajs com_fossil_ajs) throws IOException {
        Object deserializeWithType = this._delegateDeserializer.deserializeWithType(jsonParser, deserializationContext, com_fossil_ajs);
        if (deserializeWithType == null) {
            return null;
        }
        return convertValue(deserializeWithType);
    }

    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        if (this._delegateType.getRawClass().isAssignableFrom(obj.getClass())) {
            return this._delegateDeserializer.deserialize(jsonParser, deserializationContext, obj);
        }
        return _handleIncompatibleUpdateValue(jsonParser, deserializationContext, obj);
    }

    protected Object _handleIncompatibleUpdateValue(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        throw new UnsupportedOperationException(String.format("Can not update object of type %s (using deserializer for type %s)" + obj.getClass().getName(), new Object[]{this._delegateType}));
    }

    protected T convertValue(Object obj) {
        return this._converter.convert(obj);
    }
}
