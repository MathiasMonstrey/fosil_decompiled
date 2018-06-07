package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat.C1501b;
import com.fasterxml.jackson.annotation.JsonFormat.Feature;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fossil.agv;
import com.fossil.agz;
import com.fossil.ahb;
import com.fossil.ahg;
import com.fossil.ahh;
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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

@ahh
public class ObjectArraySerializer extends ArraySerializerBase<Object[]> implements alg {
    protected alt _dynamicSerializers;
    protected ahb<Object> _elementSerializer;
    protected final JavaType _elementType;
    protected final boolean _staticTyping;
    protected final ajv _valueTypeSerializer;

    public ObjectArraySerializer(JavaType javaType, boolean z, ajv com_fossil_ajv, ahb<Object> com_fossil_ahb_java_lang_Object) {
        super(Object[].class);
        this._elementType = javaType;
        this._staticTyping = z;
        this._valueTypeSerializer = com_fossil_ajv;
        this._dynamicSerializers = alt.GM();
        this._elementSerializer = com_fossil_ahb_java_lang_Object;
    }

    public ObjectArraySerializer(ObjectArraySerializer objectArraySerializer, ajv com_fossil_ajv) {
        super((ArraySerializerBase) objectArraySerializer);
        this._elementType = objectArraySerializer._elementType;
        this._valueTypeSerializer = com_fossil_ajv;
        this._staticTyping = objectArraySerializer._staticTyping;
        this._dynamicSerializers = objectArraySerializer._dynamicSerializers;
        this._elementSerializer = objectArraySerializer._elementSerializer;
    }

    public ObjectArraySerializer(ObjectArraySerializer objectArraySerializer, agv com_fossil_agv, ajv com_fossil_ajv, ahb<?> com_fossil_ahb_, Boolean bool) {
        super(objectArraySerializer, com_fossil_agv, bool);
        this._elementType = objectArraySerializer._elementType;
        this._valueTypeSerializer = com_fossil_ajv;
        this._staticTyping = objectArraySerializer._staticTyping;
        this._dynamicSerializers = objectArraySerializer._dynamicSerializers;
        this._elementSerializer = com_fossil_ahb_;
    }

    public ahb<?> _withResolved(agv com_fossil_agv, Boolean bool) {
        return new ObjectArraySerializer(this, com_fossil_agv, this._valueTypeSerializer, this._elementSerializer, bool);
    }

    public ContainerSerializer<?> _withValueTypeSerializer(ajv com_fossil_ajv) {
        return new ObjectArraySerializer(this._elementType, this._staticTyping, com_fossil_ajv, this._elementSerializer);
    }

    public ObjectArraySerializer withResolved(agv com_fossil_agv, ajv com_fossil_ajv, ahb<?> com_fossil_ahb_, Boolean bool) {
        return (this._property == com_fossil_agv && com_fossil_ahb_ == this._elementSerializer && this._valueTypeSerializer == com_fossil_ajv && this._unwrapSingle == bool) ? this : new ObjectArraySerializer(this, com_fossil_agv, com_fossil_ajv, com_fossil_ahb_, bool);
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
            aiq member = com_fossil_agv.getMember();
            AnnotationIntrospector annotationIntrospector = com_fossil_ahg.getAnnotationIntrospector();
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
        } else if (this._elementType != null && (this._staticTyping || hasContentTypeAnnotation(com_fossil_ahg, com_fossil_agv))) {
            serializerInstance = com_fossil_ahg.findValueSerializer(this._elementType, com_fossil_agv);
        }
        return withResolved(com_fossil_agv, c, serializerInstance, bool);
    }

    public JavaType getContentType() {
        return this._elementType;
    }

    public ahb<?> getContentSerializer() {
        return this._elementSerializer;
    }

    public boolean isEmpty(ahg com_fossil_ahg, Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    public boolean hasSingleElement(Object[] objArr) {
        return objArr.length == 1;
    }

    public final void serialize(Object[] objArr, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        int length = objArr.length;
        if (length == 1 && ((this._unwrapSingle == null && com_fossil_ahg.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            serializeContents(objArr, jsonGenerator, com_fossil_ahg);
            return;
        }
        jsonGenerator.fk(length);
        serializeContents(objArr, jsonGenerator, com_fossil_ahg);
        jsonGenerator.zI();
    }

    public void serializeContents(Object[] objArr, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        int length = objArr.length;
        if (length != 0) {
            if (this._elementSerializer != null) {
                serializeContentsUsing(objArr, jsonGenerator, com_fossil_ahg, this._elementSerializer);
            } else if (this._valueTypeSerializer != null) {
                serializeTypedContents(objArr, jsonGenerator, com_fossil_ahg);
            } else {
                int i = 0;
                Object obj = null;
                try {
                    alt com_fossil_alt = this._dynamicSerializers;
                    while (i < length) {
                        obj = objArr[i];
                        if (obj == null) {
                            com_fossil_ahg.defaultSerializeNull(jsonGenerator);
                        } else {
                            Class cls = obj.getClass();
                            ahb o = com_fossil_alt.mo1085o(cls);
                            if (o == null) {
                                if (this._elementType.hasGenericTypes()) {
                                    o = _findAndAddDynamic(com_fossil_alt, com_fossil_ahg.constructSpecializedType(this._elementType, cls), com_fossil_ahg);
                                } else {
                                    o = _findAndAddDynamic(com_fossil_alt, cls, com_fossil_ahg);
                                }
                            }
                            o.serialize(obj, jsonGenerator, com_fossil_ahg);
                        }
                        i++;
                    }
                } catch (IOException e) {
                    throw e;
                } catch (Exception e2) {
                    Throwable e3 = e2;
                    while ((e3 instanceof InvocationTargetException) && e3.getCause() != null) {
                        e3 = e3.getCause();
                    }
                    if (e3 instanceof Error) {
                        throw ((Error) e3);
                    }
                    throw JsonMappingException.wrapWithPath(e3, obj, i);
                }
            }
        }
    }

    public void serializeContentsUsing(Object[] objArr, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ahb<Object> com_fossil_ahb_java_lang_Object) throws IOException {
        int length = objArr.length;
        ajv com_fossil_ajv = this._valueTypeSerializer;
        Object obj = null;
        int i = 0;
        while (i < length) {
            try {
                obj = objArr[i];
                if (obj == null) {
                    com_fossil_ahg.defaultSerializeNull(jsonGenerator);
                } else if (com_fossil_ajv == null) {
                    com_fossil_ahb_java_lang_Object.serialize(obj, jsonGenerator, com_fossil_ahg);
                } else {
                    com_fossil_ahb_java_lang_Object.serializeWithType(obj, jsonGenerator, com_fossil_ahg, com_fossil_ajv);
                }
                i++;
            } catch (IOException e) {
                throw e;
            } catch (Exception e2) {
                Throwable e3 = e2;
                while ((e3 instanceof InvocationTargetException) && e3.getCause() != null) {
                    e3 = e3.getCause();
                }
                if (e3 instanceof Error) {
                    throw ((Error) e3);
                }
                throw JsonMappingException.wrapWithPath(e3, obj, i);
            }
        }
    }

    public void serializeTypedContents(Object[] objArr, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        int length = objArr.length;
        ajv com_fossil_ajv = this._valueTypeSerializer;
        int i = 0;
        try {
            alt com_fossil_alt = this._dynamicSerializers;
            while (i < length) {
                Object obj = objArr[i];
                if (obj == null) {
                    com_fossil_ahg.defaultSerializeNull(jsonGenerator);
                } else {
                    Class cls = obj.getClass();
                    ahb o = com_fossil_alt.mo1085o(cls);
                    if (o == null) {
                        o = _findAndAddDynamic(com_fossil_alt, cls, com_fossil_ahg);
                    }
                    o.serializeWithType(obj, jsonGenerator, com_fossil_ahg, com_fossil_ajv);
                }
                i++;
            }
        } catch (IOException e) {
            throw e;
        } catch (Exception e2) {
            Throwable e3 = e2;
            while ((e3 instanceof InvocationTargetException) && e3.getCause() != null) {
                e3 = e3.getCause();
            }
            if (e3 instanceof Error) {
                throw ((Error) e3);
            }
            throw JsonMappingException.wrapWithPath(e3, null, 0);
        }
    }

    public agz getSchema(ahg com_fossil_ahg, Type type) throws JsonMappingException {
        agz createSchemaNode = createSchemaNode("array", true);
        if (type != null) {
            JavaType constructType = com_fossil_ahg.constructType(type);
            if (constructType.isArrayType()) {
                Class rawClass = ((ArrayType) constructType).getContentType().getRawClass();
                if (rawClass == Object.class) {
                    createSchemaNode.m3669a("items", ajo.Ge());
                } else {
                    ahb findValueSerializer = com_fossil_ahg.findValueSerializer(rawClass, this._property);
                    createSchemaNode.m3669a("items", findValueSerializer instanceof ajq ? ((ajq) findValueSerializer).getSchema(com_fossil_ahg, null) : ajo.Ge());
                }
            }
        }
        return createSchemaNode;
    }

    public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
        ajc e = com_fossil_ajg.mo1017e(javaType);
        if (e != null) {
            JavaType moreSpecificType = com_fossil_ajg.Gd().getTypeFactory().moreSpecificType(this._elementType, javaType.getContentType());
            if (moreSpecificType == null) {
                throw new JsonMappingException("Could not resolve type");
            }
            aje com_fossil_aje = this._elementSerializer;
            if (com_fossil_aje == null) {
                com_fossil_aje = com_fossil_ajg.Gd().findValueSerializer(moreSpecificType, this._property);
            }
            e.m3534a(com_fossil_aje, moreSpecificType);
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
