package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fossil.ajs;
import java.io.IOException;

public class NullifyingDeserializer extends StdDeserializer<Object> {
    public static final NullifyingDeserializer instance = new NullifyingDeserializer();
    private static final long serialVersionUID = 1;

    public NullifyingDeserializer() {
        super(Object.class);
    }

    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        jsonParser.zT();
        return null;
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, ajs com_fossil_ajs) throws IOException, JsonProcessingException {
        switch (jsonParser.zU()) {
            case START_ARRAY:
            case START_OBJECT:
            case FIELD_NAME:
                return com_fossil_ajs.deserializeTypedFromAny(jsonParser, deserializationContext);
            default:
                return null;
        }
    }
}
