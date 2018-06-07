package com.fossil;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;

public class aih<T> extends agy<T> {
    private final NoClassDefFoundError aRB;

    public aih(NoClassDefFoundError noClassDefFoundError) {
        this.aRB = noClassDefFoundError;
    }

    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        throw this.aRB;
    }
}
