package com.fossil;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface aic {
    void resolve(DeserializationContext deserializationContext) throws JsonMappingException;
}
