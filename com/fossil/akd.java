package com.fossil;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.impl.AsExternalTypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.impl.AsWrapperTypeDeserializer;
import java.util.Collection;

public class akd implements aju<akd> {
    protected ajt _customIdResolver;
    protected Class<?> _defaultImpl;
    protected Id _idType;
    protected As _includeAs;
    protected boolean _typeIdVisible = false;
    protected String _typeProperty;

    public static akd noTypeInfoBuilder() {
        return new akd().init(Id.NONE, null);
    }

    public akd init(Id id, ajt com_fossil_ajt) {
        if (id == null) {
            throw new IllegalArgumentException("idType can not be null");
        }
        this._idType = id;
        this._customIdResolver = com_fossil_ajt;
        this._typeProperty = id.getDefaultPropertyName();
        return this;
    }

    public ajv buildTypeSerializer(SerializationConfig serializationConfig, JavaType javaType, Collection<NamedType> collection) {
        if (this._idType == Id.NONE) {
            return null;
        }
        ajt idResolver = idResolver(serializationConfig, javaType, collection, true, false);
        switch (this._includeAs) {
            case WRAPPER_ARRAY:
                return new ajw(idResolver, null);
            case PROPERTY:
                return new ajz(idResolver, null, this._typeProperty);
            case WRAPPER_OBJECT:
                return new aka(idResolver, null);
            case EXTERNAL_PROPERTY:
                return new ajy(idResolver, null, this._typeProperty);
            case EXISTING_PROPERTY:
                return new ajx(idResolver, null, this._typeProperty);
            default:
                throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + this._includeAs);
        }
    }

    public ajs buildTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, Collection<NamedType> collection) {
        if (this._idType == Id.NONE) {
            return null;
        }
        ajt idResolver = idResolver(deserializationConfig, javaType, collection, false, true);
        switch (this._includeAs) {
            case WRAPPER_ARRAY:
                return new AsArrayTypeDeserializer(javaType, idResolver, this._typeProperty, this._typeIdVisible, this._defaultImpl);
            case PROPERTY:
            case EXISTING_PROPERTY:
                return new AsPropertyTypeDeserializer(javaType, idResolver, this._typeProperty, this._typeIdVisible, this._defaultImpl, this._includeAs);
            case WRAPPER_OBJECT:
                return new AsWrapperTypeDeserializer(javaType, idResolver, this._typeProperty, this._typeIdVisible, this._defaultImpl);
            case EXTERNAL_PROPERTY:
                return new AsExternalTypeDeserializer(javaType, idResolver, this._typeProperty, this._typeIdVisible, this._defaultImpl);
            default:
                throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + this._includeAs);
        }
    }

    public akd inclusion(As as) {
        if (as == null) {
            throw new IllegalArgumentException("includeAs can not be null");
        }
        this._includeAs = as;
        return this;
    }

    public akd typeProperty(String str) {
        if (str == null || str.length() == 0) {
            str = this._idType.getDefaultPropertyName();
        }
        this._typeProperty = str;
        return this;
    }

    public akd defaultImpl(Class<?> cls) {
        this._defaultImpl = cls;
        return this;
    }

    public akd typeIdVisibility(boolean z) {
        this._typeIdVisible = z;
        return this;
    }

    public Class<?> getDefaultImpl() {
        return this._defaultImpl;
    }

    public String getTypeProperty() {
        return this._typeProperty;
    }

    public boolean isTypeIdVisible() {
        return this._typeIdVisible;
    }

    protected ajt idResolver(MapperConfig<?> mapperConfig, JavaType javaType, Collection<NamedType> collection, boolean z, boolean z2) {
        if (this._customIdResolver != null) {
            return this._customIdResolver;
        }
        if (this._idType == null) {
            throw new IllegalStateException("Can not build, 'init()' not yet called");
        }
        switch (this._idType) {
            case CLASS:
                return new akb(javaType, mapperConfig.getTypeFactory());
            case MINIMAL_CLASS:
                return new akc(javaType, mapperConfig.getTypeFactory());
            case NAME:
                return akf.m3654a(mapperConfig, javaType, collection, z, z2);
            case NONE:
                return null;
            default:
                throw new IllegalStateException("Do not know how to construct standard type id resolver for idType: " + this._idType);
        }
    }
}
