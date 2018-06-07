package com.fossil;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;

public abstract class ahz {
    protected static final aia[] NO_DESERIALIZERS = new aia[0];

    public abstract agy<?> createArrayDeserializer(DeserializationContext deserializationContext, ArrayType arrayType, agu com_fossil_agu) throws JsonMappingException;

    public abstract agy<Object> createBeanDeserializer(DeserializationContext deserializationContext, JavaType javaType, agu com_fossil_agu) throws JsonMappingException;

    public abstract agy<Object> createBuilderBasedDeserializer(DeserializationContext deserializationContext, JavaType javaType, agu com_fossil_agu, Class<?> cls) throws JsonMappingException;

    public abstract agy<?> createCollectionDeserializer(DeserializationContext deserializationContext, CollectionType collectionType, agu com_fossil_agu) throws JsonMappingException;

    public abstract agy<?> createCollectionLikeDeserializer(DeserializationContext deserializationContext, CollectionLikeType collectionLikeType, agu com_fossil_agu) throws JsonMappingException;

    public abstract agy<?> createEnumDeserializer(DeserializationContext deserializationContext, JavaType javaType, agu com_fossil_agu) throws JsonMappingException;

    public abstract ahc createKeyDeserializer(DeserializationContext deserializationContext, JavaType javaType) throws JsonMappingException;

    public abstract agy<?> createMapDeserializer(DeserializationContext deserializationContext, MapType mapType, agu com_fossil_agu) throws JsonMappingException;

    public abstract agy<?> createMapLikeDeserializer(DeserializationContext deserializationContext, MapLikeType mapLikeType, agu com_fossil_agu) throws JsonMappingException;

    public abstract agy<?> createTreeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, agu com_fossil_agu) throws JsonMappingException;

    public abstract ajs findTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType) throws JsonMappingException;

    public abstract aie findValueInstantiator(DeserializationContext deserializationContext, agu com_fossil_agu) throws JsonMappingException;

    public abstract JavaType mapAbstractType(DeserializationConfig deserializationConfig, JavaType javaType) throws JsonMappingException;

    public abstract ahz withAbstractTypeResolver(agt com_fossil_agt);

    public abstract ahz withAdditionalDeserializers(aia com_fossil_aia);

    public abstract ahz withAdditionalKeyDeserializers(aib com_fossil_aib);

    public abstract ahz withDeserializerModifier(ahu com_fossil_ahu);

    public abstract ahz withValueInstantiators(aif com_fossil_aif);
}
