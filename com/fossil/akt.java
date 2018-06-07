package com.fossil;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.io.IOException;

public final class akt extends ala {
    public static final akt aTX = new akt();

    private akt() {
    }

    public static akt Gs() {
        return aTX;
    }

    public JsonNodeType DG() {
        return JsonNodeType.NULL;
    }

    public JsonToken AE() {
        return JsonToken.VALUE_NULL;
    }

    public String DP() {
        return "null";
    }

    public final void serialize(JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException, JsonProcessingException {
        com_fossil_ahg.defaultSerializeNull(jsonGenerator);
    }

    public boolean equals(Object obj) {
        return obj == this;
    }
}
