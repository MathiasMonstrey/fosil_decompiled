package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fossil.aew;
import com.fossil.ahh;
import com.fossil.ajs;
import java.io.IOException;

@ahh
public final class StringDeserializer extends StdScalarDeserializer<String> {
    public static final StringDeserializer instance = new StringDeserializer();
    private static final long serialVersionUID = 1;

    public StringDeserializer() {
        super(String.class);
    }

    public boolean isCachable() {
        return true;
    }

    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken zU = jsonParser.zU();
        if (zU == JsonToken.VALUE_STRING) {
            return jsonParser.getText();
        }
        String _parseString;
        if (zU == JsonToken.START_ARRAY && deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
            jsonParser.zP();
            _parseString = _parseString(jsonParser, deserializationContext);
            if (jsonParser.zP() == JsonToken.END_ARRAY) {
                return _parseString;
            }
            throw deserializationContext.wrongTokenException(jsonParser, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'String' value but there was more than a single value in the array");
        } else if (zU == JsonToken.VALUE_EMBEDDED_OBJECT) {
            Object Aq = jsonParser.Aq();
            if (Aq == null) {
                return null;
            }
            if (Aq instanceof byte[]) {
                return aew.zz().encode((byte[]) Aq, false);
            }
            return Aq.toString();
        } else {
            _parseString = jsonParser.Au();
            if (_parseString != null) {
                return _parseString;
            }
            throw deserializationContext.mappingException(this._valueClass, zU);
        }
    }

    public String deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, ajs com_fossil_ajs) throws IOException {
        return deserialize(jsonParser, deserializationContext);
    }
}
