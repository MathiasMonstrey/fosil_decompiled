package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fossil.agz;
import com.fossil.ahb;
import com.fossil.ahb.C1638a;
import com.fossil.ahg;
import com.fossil.ahr;
import com.fossil.aiq;
import com.fossil.ajg;
import com.fossil.ajo;
import com.fossil.ajq;
import com.fossil.ajv;
import com.fossil.akv;
import com.fossil.aln;
import com.fossil.alx;
import com.fossil.ami;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public abstract class DefaultSerializerProvider extends ahg implements Serializable {
    private static final long serialVersionUID = 1;
    protected transient ArrayList<ObjectIdGenerator<?>> _objectIdGenerators;
    protected transient Map<Object, alx> _seenObjectIds;

    public static final class Impl extends DefaultSerializerProvider {
        private static final long serialVersionUID = 1;

        public Impl(Impl impl) {
            super(impl);
        }

        protected Impl(ahg com_fossil_ahg, SerializationConfig serializationConfig, aln com_fossil_aln) {
            super(com_fossil_ahg, serializationConfig, com_fossil_aln);
        }

        public DefaultSerializerProvider copy() {
            if (getClass() != Impl.class) {
                return super.copy();
            }
            return new Impl(this);
        }

        public Impl createInstance(SerializationConfig serializationConfig, aln com_fossil_aln) {
            return new Impl(this, serializationConfig, com_fossil_aln);
        }
    }

    public abstract DefaultSerializerProvider createInstance(SerializationConfig serializationConfig, aln com_fossil_aln);

    protected DefaultSerializerProvider() {
    }

    protected DefaultSerializerProvider(ahg com_fossil_ahg, SerializationConfig serializationConfig, aln com_fossil_aln) {
        super(com_fossil_ahg, serializationConfig, com_fossil_aln);
    }

    protected DefaultSerializerProvider(DefaultSerializerProvider defaultSerializerProvider) {
        super(defaultSerializerProvider);
    }

    public DefaultSerializerProvider copy() {
        throw new IllegalStateException("DefaultSerializerProvider sub-class not overriding copy()");
    }

    public void serializeValue(JsonGenerator jsonGenerator, Object obj) throws IOException {
        boolean z = true;
        if (obj == null) {
            _serializeNull(jsonGenerator);
            return;
        }
        ahb findTypedValueSerializer = findTypedValueSerializer(obj.getClass(), true, null);
        PropertyName fullRootName = this._config.getFullRootName();
        if (fullRootName == null) {
            z = this._config.isEnabled(SerializationFeature.WRAP_ROOT_VALUE);
            if (z) {
                jsonGenerator.zJ();
                jsonGenerator.mo850b(this._config.findRootName(obj.getClass()).simpleAsEncoded(this._config));
            }
        } else if (fullRootName.isEmpty()) {
            z = false;
        } else {
            jsonGenerator.zJ();
            jsonGenerator.aQ(fullRootName.getSimpleName());
        }
        try {
            findTypedValueSerializer.serialize(obj, jsonGenerator, this);
            if (z) {
                jsonGenerator.zK();
            }
        } catch (IOException e) {
            throw e;
        } catch (Throwable e2) {
            Throwable th = e2;
            String message = th.getMessage();
            if (message == null) {
                message = "[no message for " + th.getClass().getName() + "]";
            }
            throw new JsonMappingException(message, th);
        }
    }

    public void serializeValue(JsonGenerator jsonGenerator, Object obj, JavaType javaType) throws IOException {
        boolean z = true;
        if (obj == null) {
            _serializeNull(jsonGenerator);
            return;
        }
        if (!javaType.getRawClass().isAssignableFrom(obj.getClass())) {
            _reportIncompatibleRootType(obj, javaType);
        }
        ahb findTypedValueSerializer = findTypedValueSerializer(javaType, true, null);
        PropertyName fullRootName = this._config.getFullRootName();
        if (fullRootName == null) {
            z = this._config.isEnabled(SerializationFeature.WRAP_ROOT_VALUE);
            if (z) {
                jsonGenerator.zJ();
                jsonGenerator.mo850b(this._config.findRootName(obj.getClass()).simpleAsEncoded(this._config));
            }
        } else if (fullRootName.isEmpty()) {
            z = false;
        } else {
            jsonGenerator.zJ();
            jsonGenerator.aQ(fullRootName.getSimpleName());
        }
        try {
            findTypedValueSerializer.serialize(obj, jsonGenerator, this);
            if (z) {
                jsonGenerator.zK();
            }
        } catch (IOException e) {
            throw e;
        } catch (Throwable e2) {
            Throwable th = e2;
            String message = th.getMessage();
            if (message == null) {
                message = "[no message for " + th.getClass().getName() + "]";
            }
            throw new JsonMappingException(message, th);
        }
    }

    public void serializeValue(JsonGenerator jsonGenerator, Object obj, JavaType javaType, ahb<Object> com_fossil_ahb_java_lang_Object) throws IOException {
        boolean z = true;
        if (obj == null) {
            _serializeNull(jsonGenerator);
            return;
        }
        if (!(javaType == null || javaType.getRawClass().isAssignableFrom(obj.getClass()))) {
            _reportIncompatibleRootType(obj, javaType);
        }
        if (com_fossil_ahb_java_lang_Object == null) {
            com_fossil_ahb_java_lang_Object = findTypedValueSerializer(javaType, true, null);
        }
        PropertyName fullRootName = this._config.getFullRootName();
        if (fullRootName == null) {
            boolean isEnabled = this._config.isEnabled(SerializationFeature.WRAP_ROOT_VALUE);
            if (isEnabled) {
                jsonGenerator.zJ();
                jsonGenerator.mo850b((javaType == null ? this._config.findRootName(obj.getClass()) : this._config.findRootName(javaType)).simpleAsEncoded(this._config));
                z = isEnabled;
            } else {
                z = isEnabled;
            }
        } else if (fullRootName.isEmpty()) {
            z = false;
        } else {
            jsonGenerator.zJ();
            jsonGenerator.aQ(fullRootName.getSimpleName());
        }
        try {
            com_fossil_ahb_java_lang_Object.serialize(obj, jsonGenerator, this);
            if (z) {
                jsonGenerator.zK();
            }
        } catch (IOException e) {
            throw e;
        } catch (Throwable e2) {
            Throwable th = e2;
            String message = th.getMessage();
            if (message == null) {
                message = "[no message for " + th.getClass().getName() + "]";
            }
            throw new JsonMappingException(message, th);
        }
    }

    public void serializePolymorphic(JsonGenerator jsonGenerator, Object obj, JavaType javaType, ahb<Object> com_fossil_ahb_java_lang_Object, ajv com_fossil_ajv) throws IOException {
        if (obj == null) {
            _serializeNull(jsonGenerator);
            return;
        }
        boolean isEnabled;
        if (!(javaType == null || javaType.getRawClass().isAssignableFrom(obj.getClass()))) {
            _reportIncompatibleRootType(obj, javaType);
        }
        if (com_fossil_ahb_java_lang_Object == null) {
            if (javaType == null || !javaType.isContainerType()) {
                com_fossil_ahb_java_lang_Object = findValueSerializer(obj.getClass(), null);
            } else {
                com_fossil_ahb_java_lang_Object = findValueSerializer(javaType, null);
            }
        }
        PropertyName fullRootName = this._config.getFullRootName();
        if (fullRootName == null) {
            isEnabled = this._config.isEnabled(SerializationFeature.WRAP_ROOT_VALUE);
            if (isEnabled) {
                jsonGenerator.zJ();
                jsonGenerator.mo850b(this._config.findRootName(obj.getClass()).simpleAsEncoded(this._config));
            }
        } else if (fullRootName.isEmpty()) {
            isEnabled = false;
        } else {
            isEnabled = true;
            jsonGenerator.zJ();
            jsonGenerator.aQ(fullRootName.getSimpleName());
        }
        try {
            com_fossil_ahb_java_lang_Object.serializeWithType(obj, jsonGenerator, this, com_fossil_ajv);
            if (isEnabled) {
                jsonGenerator.zK();
            }
        } catch (IOException e) {
            throw e;
        } catch (Throwable e2) {
            Throwable th = e2;
            String message = th.getMessage();
            if (message == null) {
                message = "[no message for " + th.getClass().getName() + "]";
            }
            throw new JsonMappingException(message, th);
        }
    }

    @Deprecated
    public void serializePolymorphic(JsonGenerator jsonGenerator, Object obj, ajv com_fossil_ajv) throws IOException {
        serializePolymorphic(jsonGenerator, obj, obj == null ? null : this._config.constructType(obj.getClass()), null, com_fossil_ajv);
    }

    protected void _serializeNull(JsonGenerator jsonGenerator) throws IOException {
        try {
            getDefaultNullValueSerializer().serialize(null, jsonGenerator, this);
        } catch (IOException e) {
            throw e;
        } catch (Throwable e2) {
            String message = e2.getMessage();
            if (message == null) {
                message = "[no message for " + e2.getClass().getName() + "]";
            }
            throw new JsonMappingException(message, e2);
        }
    }

    @Deprecated
    public ajo generateJsonSchema(Class<?> cls) throws JsonMappingException {
        if (cls == null) {
            throw new IllegalArgumentException("A class must be provided");
        }
        ahb findValueSerializer = findValueSerializer((Class) cls, null);
        agz schema = findValueSerializer instanceof ajq ? ((ajq) findValueSerializer).getSchema(this, null) : ajo.Ge();
        if (schema instanceof akv) {
            return new ajo((akv) schema);
        }
        throw new IllegalArgumentException("Class " + cls.getName() + " would not be serialized as a JSON object and therefore has no schema");
    }

    public void acceptJsonFormatVisitor(JavaType javaType, ajg com_fossil_ajg) throws JsonMappingException {
        if (javaType == null) {
            throw new IllegalArgumentException("A class must be provided");
        }
        com_fossil_ajg.mo1015b(this);
        findValueSerializer(javaType, null).acceptJsonFormatVisitor(com_fossil_ajg, javaType);
    }

    public boolean hasSerializerFor(Class<?> cls, AtomicReference<Throwable> atomicReference) {
        try {
            if (_findExplicitUntypedSerializer(cls) != null) {
                return true;
            }
            return false;
        } catch (JsonMappingException e) {
            if (atomicReference == null) {
                return false;
            }
            atomicReference.set(e);
            return false;
        } catch (RuntimeException e2) {
            if (atomicReference == null) {
                throw e2;
            }
            atomicReference.set(e2);
            return false;
        }
    }

    public int cachedSerializersCount() {
        return this._serializerCache.size();
    }

    public void flushCachedSerializers() {
        this._serializerCache.flush();
    }

    public alx findObjectId(Object obj, ObjectIdGenerator<?> objectIdGenerator) {
        ObjectIdGenerator objectIdGenerator2;
        if (this._seenObjectIds == null) {
            this._seenObjectIds = _createObjectIdMap();
        } else {
            alx com_fossil_alx = (alx) this._seenObjectIds.get(obj);
            if (com_fossil_alx != null) {
                return com_fossil_alx;
            }
        }
        if (this._objectIdGenerators == null) {
            this._objectIdGenerators = new ArrayList(8);
            objectIdGenerator2 = null;
        } else {
            int size = this._objectIdGenerators.size();
            for (int i = 0; i < size; i++) {
                objectIdGenerator2 = (ObjectIdGenerator) this._objectIdGenerators.get(i);
                if (objectIdGenerator2.canUseFor(objectIdGenerator)) {
                    break;
                }
            }
            objectIdGenerator2 = null;
        }
        if (objectIdGenerator2 == null) {
            objectIdGenerator2 = objectIdGenerator.newForSerialization(this);
            this._objectIdGenerators.add(objectIdGenerator2);
        }
        alx com_fossil_alx2 = new alx(objectIdGenerator2);
        this._seenObjectIds.put(obj, com_fossil_alx2);
        return com_fossil_alx2;
    }

    protected Map<Object, alx> _createObjectIdMap() {
        if (isEnabled(SerializationFeature.USE_EQUALITY_FOR_OBJECT_ID)) {
            return new HashMap();
        }
        return new IdentityHashMap();
    }

    public ahb<Object> serializerInstance(aiq com_fossil_aiq, Object obj) throws JsonMappingException {
        ahb<Object> com_fossil_ahb_java_lang_Object = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof ahb) {
            obj = (ahb) obj;
        } else if (obj instanceof Class) {
            Class cls = (Class) obj;
            if (cls == C1638a.class || ami.m3854D(cls)) {
                return null;
            }
            if (ahb.class.isAssignableFrom(cls)) {
                ahr handlerInstantiator = this._config.getHandlerInstantiator();
                if (handlerInstantiator != null) {
                    com_fossil_ahb_java_lang_Object = handlerInstantiator.m3341a(this._config, com_fossil_aiq, cls);
                }
                if (com_fossil_ahb_java_lang_Object == null) {
                    ahb com_fossil_ahb = (ahb) ami.m3863b(cls, this._config.canOverrideAccessModifiers());
                } else {
                    ahb<Object> com_fossil_ahb_java_lang_Object2 = com_fossil_ahb_java_lang_Object;
                }
            } else {
                throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<JsonSerializer>");
            }
        } else {
            throw new IllegalStateException("AnnotationIntrospector returned serializer definition of type " + obj.getClass().getName() + "; expected type JsonSerializer or Class<JsonSerializer> instead");
        }
        return _handleResolvable(obj);
    }
}
