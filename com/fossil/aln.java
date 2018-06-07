package com.fossil;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationConfig;

public abstract class aln {
    public abstract ahb<Object> createKeySerializer(SerializationConfig serializationConfig, JavaType javaType, ahb<Object> com_fossil_ahb_java_lang_Object) throws JsonMappingException;

    public abstract ahb<Object> createSerializer(ahg com_fossil_ahg, JavaType javaType) throws JsonMappingException;

    public abstract ajv createTypeSerializer(SerializationConfig serializationConfig, JavaType javaType) throws JsonMappingException;

    public abstract aln withAdditionalKeySerializers(alo com_fossil_alo);

    public abstract aln withAdditionalSerializers(alo com_fossil_alo);

    public abstract aln withSerializerModifier(alf com_fossil_alf);
}
