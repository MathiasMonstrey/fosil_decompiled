package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase;
import com.fossil.agv;
import com.fossil.ahb;
import com.fossil.ahg;
import com.fossil.ahh;
import com.fossil.ajv;
import com.fossil.alt;
import java.io.IOException;
import java.util.List;

@ahh
public final class IndexedListSerializer extends AsArraySerializerBase<List<?>> {
    private static final long serialVersionUID = 1;

    public IndexedListSerializer(JavaType javaType, boolean z, ajv com_fossil_ajv, ahb<Object> com_fossil_ahb_java_lang_Object) {
        super(List.class, javaType, z, com_fossil_ajv, (ahb) com_fossil_ahb_java_lang_Object);
    }

    public IndexedListSerializer(IndexedListSerializer indexedListSerializer, agv com_fossil_agv, ajv com_fossil_ajv, ahb<?> com_fossil_ahb_, Boolean bool) {
        super((AsArraySerializerBase) indexedListSerializer, com_fossil_agv, com_fossil_ajv, (ahb) com_fossil_ahb_, bool);
    }

    public IndexedListSerializer withResolved(agv com_fossil_agv, ajv com_fossil_ajv, ahb<?> com_fossil_ahb_, Boolean bool) {
        return new IndexedListSerializer(this, com_fossil_agv, com_fossil_ajv, com_fossil_ahb_, bool);
    }

    public boolean isEmpty(ahg com_fossil_ahg, List<?> list) {
        return list == null || list.isEmpty();
    }

    public boolean hasSingleElement(List<?> list) {
        return list.size() == 1;
    }

    public ContainerSerializer<?> _withValueTypeSerializer(ajv com_fossil_ajv) {
        return new IndexedListSerializer(this, this._property, com_fossil_ajv, this._elementSerializer, this._unwrapSingle);
    }

    public final void serialize(List<?> list, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        int size = list.size();
        if (size == 1 && ((this._unwrapSingle == null && com_fossil_ahg.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            serializeContents((List) list, jsonGenerator, com_fossil_ahg);
            return;
        }
        jsonGenerator.fk(size);
        serializeContents((List) list, jsonGenerator, com_fossil_ahg);
        jsonGenerator.zI();
    }

    public void serializeContents(List<?> list, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        if (this._elementSerializer != null) {
            serializeContentsUsing(list, jsonGenerator, com_fossil_ahg, this._elementSerializer);
        } else if (this._valueTypeSerializer != null) {
            serializeTypedContents(list, jsonGenerator, com_fossil_ahg);
        } else {
            int size = list.size();
            if (size != 0) {
                int i = 0;
                try {
                    alt com_fossil_alt = this._dynamicSerializers;
                    while (i < size) {
                        Object obj = list.get(i);
                        if (obj == null) {
                            com_fossil_ahg.defaultSerializeNull(jsonGenerator);
                        } else {
                            Class cls = obj.getClass();
                            ahb o = com_fossil_alt.mo1085o(cls);
                            if (o == null) {
                                ahb _findAndAddDynamic;
                                if (this._elementType.hasGenericTypes()) {
                                    _findAndAddDynamic = _findAndAddDynamic(com_fossil_alt, com_fossil_ahg.constructSpecializedType(this._elementType, cls), com_fossil_ahg);
                                } else {
                                    _findAndAddDynamic = _findAndAddDynamic(com_fossil_alt, cls, com_fossil_ahg);
                                }
                                ahb com_fossil_ahb = _findAndAddDynamic;
                                com_fossil_alt = this._dynamicSerializers;
                                o = com_fossil_ahb;
                            }
                            o.serialize(obj, jsonGenerator, com_fossil_ahg);
                        }
                        i++;
                    }
                } catch (Throwable e) {
                    wrapAndThrow(com_fossil_ahg, e, (Object) list, i);
                }
            }
        }
    }

    public void serializeContentsUsing(List<?> list, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ahb<Object> com_fossil_ahb_java_lang_Object) throws IOException {
        int size = list.size();
        if (size != 0) {
            ajv com_fossil_ajv = this._valueTypeSerializer;
            for (int i = 0; i < size; i++) {
                Object obj = list.get(i);
                if (obj == null) {
                    try {
                        com_fossil_ahg.defaultSerializeNull(jsonGenerator);
                    } catch (Throwable e) {
                        wrapAndThrow(com_fossil_ahg, e, (Object) list, i);
                    }
                } else if (com_fossil_ajv == null) {
                    com_fossil_ahb_java_lang_Object.serialize(obj, jsonGenerator, com_fossil_ahg);
                } else {
                    com_fossil_ahb_java_lang_Object.serializeWithType(obj, jsonGenerator, com_fossil_ahg, com_fossil_ajv);
                }
            }
        }
    }

    public void serializeTypedContents(List<?> list, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        int size = list.size();
        if (size != 0) {
            int i = 0;
            try {
                ajv com_fossil_ajv = this._valueTypeSerializer;
                alt com_fossil_alt = this._dynamicSerializers;
                while (i < size) {
                    Object obj = list.get(i);
                    if (obj == null) {
                        com_fossil_ahg.defaultSerializeNull(jsonGenerator);
                    } else {
                        Class cls = obj.getClass();
                        ahb o = com_fossil_alt.mo1085o(cls);
                        if (o == null) {
                            ahb _findAndAddDynamic;
                            if (this._elementType.hasGenericTypes()) {
                                _findAndAddDynamic = _findAndAddDynamic(com_fossil_alt, com_fossil_ahg.constructSpecializedType(this._elementType, cls), com_fossil_ahg);
                            } else {
                                _findAndAddDynamic = _findAndAddDynamic(com_fossil_alt, cls, com_fossil_ahg);
                            }
                            ahb com_fossil_ahb = _findAndAddDynamic;
                            com_fossil_alt = this._dynamicSerializers;
                            o = com_fossil_ahb;
                        }
                        o.serializeWithType(obj, jsonGenerator, com_fossil_ahg, com_fossil_ajv);
                    }
                    i++;
                }
            } catch (Throwable e) {
                wrapAndThrow(com_fossil_ahg, e, (Object) list, i);
            }
        }
    }
}
