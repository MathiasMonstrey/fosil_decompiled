package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.portfolio.platform.data.model.PinObject;
import java.io.IOException;

public class StackTraceElementDeserializer extends StdScalarDeserializer<StackTraceElement> {
    private static final long serialVersionUID = 1;

    public StackTraceElementDeserializer() {
        super(StackTraceElement.class);
    }

    public StackTraceElement deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken zU = jsonParser.zU();
        if (zU == JsonToken.START_OBJECT) {
            String str = "";
            String str2 = "";
            String str3 = "";
            int i = -1;
            while (true) {
                JsonToken zQ = jsonParser.zQ();
                if (zQ == JsonToken.END_OBJECT) {
                    return new StackTraceElement(str, str2, str3, i);
                }
                String zW = jsonParser.zW();
                if (PinObject.COLUMN_CLASS_NAME.equals(zW)) {
                    str = jsonParser.getText();
                } else if ("fileName".equals(zW)) {
                    str3 = jsonParser.getText();
                } else if ("lineNumber".equals(zW)) {
                    if (zQ.isNumeric()) {
                        i = jsonParser.getIntValue();
                    } else {
                        throw JsonMappingException.from(jsonParser, "Non-numeric token (" + zQ + ") for property 'lineNumber'");
                    }
                } else if ("methodName".equals(zW)) {
                    str2 = jsonParser.getText();
                } else if (!"nativeMethod".equals(zW)) {
                    handleUnknownProperty(jsonParser, deserializationContext, this._valueClass, zW);
                }
            }
        } else if (zU == JsonToken.START_ARRAY && deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
            jsonParser.zP();
            StackTraceElement deserialize = deserialize(jsonParser, deserializationContext);
            if (jsonParser.zP() == JsonToken.END_ARRAY) {
                return deserialize;
            }
            throw deserializationContext.wrongTokenException(jsonParser, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'java.lang.StackTraceElement' value but there was more than a single value in the array");
        } else {
            throw deserializationContext.mappingException(this._valueClass, zU);
        }
    }
}
