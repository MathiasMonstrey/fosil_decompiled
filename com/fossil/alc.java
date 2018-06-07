package com.fossil;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;

@Deprecated
public interface alc {
    void depositSchemaProperty(ald com_fossil_ald, ajl com_fossil_ajl, ahg com_fossil_ahg) throws JsonMappingException;

    @Deprecated
    void depositSchemaProperty(ald com_fossil_ald, akv com_fossil_akv, ahg com_fossil_ahg) throws JsonMappingException;

    void serializeAsField(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ald com_fossil_ald) throws Exception;
}
