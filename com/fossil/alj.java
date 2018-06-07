package com.fossil;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface alj {
    void depositSchemaProperty(alk com_fossil_alk, ajl com_fossil_ajl, ahg com_fossil_ahg) throws JsonMappingException;

    @Deprecated
    void depositSchemaProperty(alk com_fossil_alk, akv com_fossil_akv, ahg com_fossil_ahg) throws JsonMappingException;

    void serializeAsField(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg, alk com_fossil_alk) throws Exception;
}
