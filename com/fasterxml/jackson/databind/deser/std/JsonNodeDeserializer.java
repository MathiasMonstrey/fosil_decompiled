package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fossil.agy;
import com.fossil.agz;
import com.fossil.ajs;
import com.fossil.akh;
import com.fossil.akt;
import com.fossil.akv;
import java.io.IOException;

public class JsonNodeDeserializer extends BaseNodeDeserializer<agz> {
    private static final JsonNodeDeserializer aSe = new JsonNodeDeserializer();

    static final class ArrayDeserializer extends BaseNodeDeserializer<akh> {
        protected static final ArrayDeserializer _instance = new ArrayDeserializer();
        private static final long serialVersionUID = 1;

        protected ArrayDeserializer() {
            super(akh.class);
        }

        public static ArrayDeserializer getInstance() {
            return _instance;
        }

        public akh deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            if (jsonParser.Aa()) {
                return deserializeArray(jsonParser, deserializationContext, deserializationContext.getNodeFactory());
            }
            throw deserializationContext.mappingException(akh.class);
        }
    }

    static final class ObjectDeserializer extends BaseNodeDeserializer<akv> {
        protected static final ObjectDeserializer _instance = new ObjectDeserializer();
        private static final long serialVersionUID = 1;

        protected ObjectDeserializer() {
            super(akv.class);
        }

        public static ObjectDeserializer getInstance() {
            return _instance;
        }

        public akv deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            if (jsonParser.zU() == JsonToken.START_OBJECT) {
                jsonParser.zP();
                return deserializeObject(jsonParser, deserializationContext, deserializationContext.getNodeFactory());
            } else if (jsonParser.zU() == JsonToken.FIELD_NAME) {
                return deserializeObject(jsonParser, deserializationContext, deserializationContext.getNodeFactory());
            } else {
                throw deserializationContext.mappingException(akv.class);
            }
        }
    }

    public /* bridge */ /* synthetic */ Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, ajs com_fossil_ajs) throws IOException {
        return super.deserializeWithType(jsonParser, deserializationContext, com_fossil_ajs);
    }

    public /* bridge */ /* synthetic */ boolean isCachable() {
        return super.isCachable();
    }

    protected JsonNodeDeserializer() {
        super(agz.class);
    }

    public static agy<? extends agz> getDeserializer(Class<?> cls) {
        if (cls == akv.class) {
            return ObjectDeserializer.getInstance();
        }
        if (cls == akh.class) {
            return ArrayDeserializer.getInstance();
        }
        return aSe;
    }

    public agz getNullValue(DeserializationContext deserializationContext) {
        return akt.Gs();
    }

    @Deprecated
    public agz getNullValue() {
        return akt.Gs();
    }

    public agz deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        switch (jsonParser.zV()) {
            case 1:
                return deserializeObject(jsonParser, deserializationContext, deserializationContext.getNodeFactory());
            case 3:
                return deserializeArray(jsonParser, deserializationContext, deserializationContext.getNodeFactory());
            default:
                return deserializeAny(jsonParser, deserializationContext, deserializationContext.getNodeFactory());
        }
    }
}
