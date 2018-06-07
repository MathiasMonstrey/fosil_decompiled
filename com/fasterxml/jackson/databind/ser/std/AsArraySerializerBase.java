package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat.C1501b;
import com.fasterxml.jackson.annotation.JsonFormat.Feature;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fossil.agv;
import com.fossil.agz;
import com.fossil.ahb;
import com.fossil.ahg;
import com.fossil.aiq;
import com.fossil.ajc;
import com.fossil.aje;
import com.fossil.ajg;
import com.fossil.ajo;
import com.fossil.ajq;
import com.fossil.ajv;
import com.fossil.alg;
import com.fossil.alt;
import com.fossil.alt.C1678d;
import java.io.IOException;
import java.lang.reflect.Type;

public abstract class AsArraySerializerBase<T> extends ContainerSerializer<T> implements alg {
    protected alt _dynamicSerializers;
    protected final ahb<Object> _elementSerializer;
    protected final JavaType _elementType;
    protected final agv _property;
    protected final boolean _staticTyping;
    protected final Boolean _unwrapSingle;
    protected final ajv _valueTypeSerializer;

    protected abstract void serializeContents(T t, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException;

    public abstract AsArraySerializerBase<T> withResolved(agv com_fossil_agv, ajv com_fossil_ajv, ahb<?> com_fossil_ahb_, Boolean bool);

    protected AsArraySerializerBase(Class<?> cls, JavaType javaType, boolean z, ajv com_fossil_ajv, ahb<Object> com_fossil_ahb_java_lang_Object) {
        boolean z2 = false;
        super(cls, false);
        this._elementType = javaType;
        if (z || (javaType != null && javaType.isFinal())) {
            z2 = true;
        }
        this._staticTyping = z2;
        this._valueTypeSerializer = com_fossil_ajv;
        this._property = null;
        this._elementSerializer = com_fossil_ahb_java_lang_Object;
        this._dynamicSerializers = alt.GM();
        this._unwrapSingle = null;
    }

    @Deprecated
    protected AsArraySerializerBase(Class<?> cls, JavaType javaType, boolean z, ajv com_fossil_ajv, agv com_fossil_agv, ahb<Object> com_fossil_ahb_java_lang_Object) {
        boolean z2 = false;
        super(cls, false);
        this._elementType = javaType;
        if (z || (javaType != null && javaType.isFinal())) {
            z2 = true;
        }
        this._staticTyping = z2;
        this._valueTypeSerializer = com_fossil_ajv;
        this._property = com_fossil_agv;
        this._elementSerializer = com_fossil_ahb_java_lang_Object;
        this._dynamicSerializers = alt.GM();
        this._unwrapSingle = null;
    }

    protected AsArraySerializerBase(AsArraySerializerBase<?> asArraySerializerBase, agv com_fossil_agv, ajv com_fossil_ajv, ahb<?> com_fossil_ahb_, Boolean bool) {
        super((ContainerSerializer) asArraySerializerBase);
        this._elementType = asArraySerializerBase._elementType;
        this._staticTyping = asArraySerializerBase._staticTyping;
        this._valueTypeSerializer = com_fossil_ajv;
        this._property = com_fossil_agv;
        this._elementSerializer = com_fossil_ahb_;
        this._dynamicSerializers = asArraySerializerBase._dynamicSerializers;
        this._unwrapSingle = bool;
    }

    @Deprecated
    protected AsArraySerializerBase(AsArraySerializerBase<?> asArraySerializerBase, agv com_fossil_agv, ajv com_fossil_ajv, ahb<?> com_fossil_ahb_) {
        this((AsArraySerializerBase) asArraySerializerBase, com_fossil_agv, com_fossil_ajv, (ahb) com_fossil_ahb_, asArraySerializerBase._unwrapSingle);
    }

    @Deprecated
    public final AsArraySerializerBase<T> withResolved(agv com_fossil_agv, ajv com_fossil_ajv, ahb<?> com_fossil_ahb_) {
        return withResolved(com_fossil_agv, com_fossil_ajv, com_fossil_ahb_, this._unwrapSingle);
    }

    public ahb<?> createContextual(ahg com_fossil_ahg, agv com_fossil_agv) throws JsonMappingException {
        ajv c;
        ahb serializerInstance;
        Boolean bool = null;
        ajv com_fossil_ajv = this._valueTypeSerializer;
        if (com_fossil_ajv != null) {
            c = com_fossil_ajv.mo1031c(com_fossil_agv);
        } else {
            c = com_fossil_ajv;
        }
        if (com_fossil_agv != null) {
            C1501b findFormatOverrides;
            AnnotationIntrospector annotationIntrospector = com_fossil_ahg.getAnnotationIntrospector();
            aiq member = com_fossil_agv.getMember();
            if (member != null) {
                Object findContentSerializer = annotationIntrospector.findContentSerializer(member);
                if (findContentSerializer != null) {
                    serializerInstance = com_fossil_ahg.serializerInstance(member, findContentSerializer);
                    findFormatOverrides = com_fossil_agv.findFormatOverrides(annotationIntrospector);
                    if (findFormatOverrides != null) {
                        bool = findFormatOverrides.m2653b(Feature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED);
                    }
                }
            }
            serializerInstance = null;
            findFormatOverrides = com_fossil_agv.findFormatOverrides(annotationIntrospector);
            if (findFormatOverrides != null) {
                bool = findFormatOverrides.m2653b(Feature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED);
            }
        } else {
            serializerInstance = null;
        }
        if (serializerInstance == null) {
            serializerInstance = this._elementSerializer;
        }
        serializerInstance = findConvertingContentSerializer(com_fossil_ahg, com_fossil_agv, serializerInstance);
        if (serializerInstance != null) {
            serializerInstance = com_fossil_ahg.handleSecondaryContextualization(serializerInstance, com_fossil_agv);
        } else if (this._elementType != null && ((this._staticTyping && this._elementType.getRawClass() != Object.class) || hasContentTypeAnnotation(com_fossil_ahg, com_fossil_agv))) {
            serializerInstance = com_fossil_ahg.findValueSerializer(this._elementType, com_fossil_agv);
        }
        if (serializerInstance == this._elementSerializer && com_fossil_agv == this._property && this._valueTypeSerializer == c && this._unwrapSingle == bool) {
            return this;
        }
        return withResolved(com_fossil_agv, c, serializerInstance, bool);
    }

    public JavaType getContentType() {
        return this._elementType;
    }

    public ahb<?> getContentSerializer() {
        return this._elementSerializer;
    }

    public void serialize(T t, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        if (com_fossil_ahg.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) && hasSingleElement(t)) {
            serializeContents(t, jsonGenerator, com_fossil_ahg);
            return;
        }
        jsonGenerator.zH();
        jsonGenerator.bm(t);
        serializeContents(t, jsonGenerator, com_fossil_ahg);
        jsonGenerator.zI();
    }

    public void serializeWithType(T t, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ajv com_fossil_ajv) throws IOException {
        com_fossil_ajv.mo1032c(t, jsonGenerator);
        jsonGenerator.bm(t);
        serializeContents(t, jsonGenerator, com_fossil_ahg);
        com_fossil_ajv.mo1037f(t, jsonGenerator);
    }

    public agz getSchema(ahg com_fossil_ahg, Type type) throws JsonMappingException {
        agz createSchemaNode = createSchemaNode("array", true);
        JavaType javaType = this._elementType;
        if (javaType != null) {
            agz schema;
            if (javaType.getRawClass() != Object.class) {
                ahb findValueSerializer = com_fossil_ahg.findValueSerializer(javaType, this._property);
                if (findValueSerializer instanceof ajq) {
                    schema = ((ajq) findValueSerializer).getSchema(com_fossil_ahg, null);
                    if (schema == null) {
                        schema = ajo.Ge();
                    }
                    createSchemaNode.m3669a("items", schema);
                }
            }
            schema = null;
            if (schema == null) {
                schema = ajo.Ge();
            }
            createSchemaNode.m3669a("items", schema);
        }
        return createSchemaNode;
    }

    public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
        ajc e = com_fossil_ajg == null ? null : com_fossil_ajg.mo1017e(javaType);
        if (e != null) {
            aje com_fossil_aje = this._elementSerializer;
            if (com_fossil_aje == null) {
                com_fossil_aje = com_fossil_ajg.Gd().findValueSerializer(this._elementType, this._property);
            }
            e.m3534a(com_fossil_aje, this._elementType);
        }
    }

    protected final ahb<Object> _findAndAddDynamic(alt com_fossil_alt, Class<?> cls, ahg com_fossil_ahg) throws JsonMappingException {
        C1678d b = com_fossil_alt.m3771b((Class) cls, com_fossil_ahg, this._property);
        if (com_fossil_alt != b.aUN) {
            this._dynamicSerializers = b.aUN;
        }
        return b.aUD;
    }

    protected final ahb<Object> _findAndAddDynamic(alt com_fossil_alt, JavaType javaType, ahg com_fossil_ahg) throws JsonMappingException {
        C1678d b = com_fossil_alt.m3770b(javaType, com_fossil_ahg, this._property);
        if (com_fossil_alt != b.aUN) {
            this._dynamicSerializers = b.aUN;
        }
        return b.aUD;
    }
}
