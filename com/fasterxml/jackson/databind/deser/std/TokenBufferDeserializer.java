package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fossil.ahh;
import com.fossil.amt;
import java.io.IOException;

@ahh
public class TokenBufferDeserializer extends StdScalarDeserializer<amt> {
    private static final long serialVersionUID = 1;

    public TokenBufferDeserializer() {
        super(amt.class);
    }

    public amt deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return createBufferInstance(jsonParser).deserialize(jsonParser, deserializationContext);
    }

    protected amt createBufferInstance(JsonParser jsonParser) {
        return new amt(jsonParser);
    }
}
