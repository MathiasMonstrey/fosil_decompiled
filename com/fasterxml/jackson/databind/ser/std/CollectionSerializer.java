package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fossil.agv;
import com.fossil.ahb;
import com.fossil.ahg;
import com.fossil.ajv;
import com.fossil.alt;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

public class CollectionSerializer extends AsArraySerializerBase<Collection<?>> {
    private static final long serialVersionUID = 1;

    public CollectionSerializer(JavaType javaType, boolean z, ajv com_fossil_ajv, ahb<Object> com_fossil_ahb_java_lang_Object) {
        super(Collection.class, javaType, z, com_fossil_ajv, (ahb) com_fossil_ahb_java_lang_Object);
    }

    @Deprecated
    public CollectionSerializer(JavaType javaType, boolean z, ajv com_fossil_ajv, agv com_fossil_agv, ahb<Object> com_fossil_ahb_java_lang_Object) {
        this(javaType, z, com_fossil_ajv, com_fossil_ahb_java_lang_Object);
    }

    public CollectionSerializer(CollectionSerializer collectionSerializer, agv com_fossil_agv, ajv com_fossil_ajv, ahb<?> com_fossil_ahb_, Boolean bool) {
        super((AsArraySerializerBase) collectionSerializer, com_fossil_agv, com_fossil_ajv, (ahb) com_fossil_ahb_, bool);
    }

    public ContainerSerializer<?> _withValueTypeSerializer(ajv com_fossil_ajv) {
        return new CollectionSerializer(this, this._property, com_fossil_ajv, this._elementSerializer, this._unwrapSingle);
    }

    public CollectionSerializer withResolved(agv com_fossil_agv, ajv com_fossil_ajv, ahb<?> com_fossil_ahb_, Boolean bool) {
        return new CollectionSerializer(this, com_fossil_agv, com_fossil_ajv, (ahb) com_fossil_ahb_, bool);
    }

    public boolean isEmpty(ahg com_fossil_ahg, Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public boolean hasSingleElement(Collection<?> collection) {
        Iterator it = collection.iterator();
        if (!it.hasNext()) {
            return false;
        }
        it.next();
        if (it.hasNext()) {
            return false;
        }
        return true;
    }

    public final void serialize(Collection<?> collection, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        int size = collection.size();
        if (size == 1 && ((this._unwrapSingle == null && com_fossil_ahg.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            serializeContents((Collection) collection, jsonGenerator, com_fossil_ahg);
            return;
        }
        jsonGenerator.fk(size);
        serializeContents((Collection) collection, jsonGenerator, com_fossil_ahg);
        jsonGenerator.zI();
    }

    public void serializeContents(Collection<?> collection, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        if (this._elementSerializer != null) {
            serializeContentsUsing(collection, jsonGenerator, com_fossil_ahg, this._elementSerializer);
            return;
        }
        Iterator it = collection.iterator();
        if (it.hasNext()) {
            alt com_fossil_alt = this._dynamicSerializers;
            ajv com_fossil_ajv = this._valueTypeSerializer;
            int i = 0;
            do {
                Object next = it.next();
                if (next == null) {
                    com_fossil_ahg.defaultSerializeNull(jsonGenerator);
                } else {
                    Class cls = next.getClass();
                    ahb o = com_fossil_alt.mo1085o(cls);
                    if (o == null) {
                        ahb _findAndAddDynamic;
                        if (this._elementType.hasGenericTypes()) {
                            _findAndAddDynamic = _findAndAddDynamic(com_fossil_alt, com_fossil_ahg.constructSpecializedType(this._elementType, cls), com_fossil_ahg);
                        } else {
                            try {
                                _findAndAddDynamic = _findAndAddDynamic(com_fossil_alt, cls, com_fossil_ahg);
                            } catch (Throwable e) {
                                wrapAndThrow(com_fossil_ahg, e, (Object) collection, i);
                                return;
                            }
                        }
                        ahb com_fossil_ahb = _findAndAddDynamic;
                        com_fossil_alt = this._dynamicSerializers;
                        o = com_fossil_ahb;
                    }
                    if (com_fossil_ajv == null) {
                        o.serialize(next, jsonGenerator, com_fossil_ahg);
                    } else {
                        o.serializeWithType(next, jsonGenerator, com_fossil_ahg, com_fossil_ajv);
                    }
                }
                i++;
            } while (it.hasNext());
        }
    }

    public void serializeContentsUsing(Collection<?> collection, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ahb<Object> com_fossil_ahb_java_lang_Object) throws IOException, JsonGenerationException {
        Iterator it = collection.iterator();
        if (it.hasNext()) {
            ajv com_fossil_ajv = this._valueTypeSerializer;
            int i = 0;
            do {
                Object next = it.next();
                if (next == null) {
                    try {
                        com_fossil_ahg.defaultSerializeNull(jsonGenerator);
                    } catch (Throwable e) {
                        wrapAndThrow(com_fossil_ahg, e, (Object) collection, i);
                    }
                } else if (com_fossil_ajv == null) {
                    com_fossil_ahb_java_lang_Object.serialize(next, jsonGenerator, com_fossil_ahg);
                } else {
                    com_fossil_ahb_java_lang_Object.serializeWithType(next, jsonGenerator, com_fossil_ahg, com_fossil_ajv);
                }
                i++;
            } while (it.hasNext());
        }
    }
}
