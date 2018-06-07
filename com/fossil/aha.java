package com.fossil;

import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;

public interface aha {

    public static abstract class C1637a implements aha {
        public boolean mo1055a(ahg com_fossil_ahg) {
            return false;
        }
    }

    void serialize(JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException;

    void serializeWithType(JsonGenerator jsonGenerator, ahg com_fossil_ahg, ajv com_fossil_ajv) throws IOException;
}
