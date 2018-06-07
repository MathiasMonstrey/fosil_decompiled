package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import com.fossil.agv;
import com.fossil.agy;
import com.fossil.ahh;
import com.fossil.ahv;
import com.fossil.aie;
import com.fossil.ail.C1512a;
import com.fossil.ajs;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@ahh
public class CollectionDeserializer extends ContainerDeserializerBase<Collection<Object>> implements ahv {
    private static final long serialVersionUID = -1;
    protected final JavaType _collectionType;
    protected final agy<Object> _delegateDeserializer;
    protected final agy<Object> _valueDeserializer;
    protected final aie _valueInstantiator;
    protected final ajs _valueTypeDeserializer;

    static final class C1515a extends C1512a {
        private final C1516b aRY;
        public final List<Object> aRZ = new ArrayList();

        C1515a(C1516b c1516b, UnresolvedForwardReference unresolvedForwardReference, Class<?> cls) {
            super(unresolvedForwardReference, cls);
            this.aRY = c1516b;
        }

        public void mo510i(Object obj, Object obj2) throws IOException {
            this.aRY.m2720k(obj, obj2);
        }
    }

    public static final class C1516b {
        private final Class<?> aSa;
        private final Collection<Object> aSb;
        private List<C1515a> aSc = new ArrayList();

        public C1516b(Class<?> cls, Collection<Object> collection) {
            this.aSa = cls;
            this.aSb = collection;
        }

        public void add(Object obj) {
            if (this.aSc.isEmpty()) {
                this.aSb.add(obj);
            } else {
                ((C1515a) this.aSc.get(this.aSc.size() - 1)).aRZ.add(obj);
            }
        }

        public C1512a m2719a(UnresolvedForwardReference unresolvedForwardReference) {
            C1512a c1515a = new C1515a(this, unresolvedForwardReference, this.aSa);
            this.aSc.add(c1515a);
            return c1515a;
        }

        public void m2720k(Object obj, Object obj2) throws IOException {
            Iterator it = this.aSc.iterator();
            Collection collection = this.aSb;
            while (it.hasNext()) {
                C1515a c1515a = (C1515a) it.next();
                if (c1515a.bv(obj)) {
                    it.remove();
                    collection.add(obj2);
                    collection.addAll(c1515a.aRZ);
                    return;
                }
                Object obj3 = c1515a.aRZ;
            }
            throw new IllegalArgumentException("Trying to resolve a forward reference with id [" + obj + "] that wasn't previously seen as unresolved.");
        }
    }

    public CollectionDeserializer(JavaType javaType, agy<Object> com_fossil_agy_java_lang_Object, ajs com_fossil_ajs, aie com_fossil_aie) {
        this(javaType, com_fossil_agy_java_lang_Object, com_fossil_ajs, com_fossil_aie, null);
    }

    protected CollectionDeserializer(JavaType javaType, agy<Object> com_fossil_agy_java_lang_Object, ajs com_fossil_ajs, aie com_fossil_aie, agy<Object> com_fossil_agy_java_lang_Object2) {
        super(javaType);
        this._collectionType = javaType;
        this._valueDeserializer = com_fossil_agy_java_lang_Object;
        this._valueTypeDeserializer = com_fossil_ajs;
        this._valueInstantiator = com_fossil_aie;
        this._delegateDeserializer = com_fossil_agy_java_lang_Object2;
    }

    protected CollectionDeserializer(CollectionDeserializer collectionDeserializer) {
        super(collectionDeserializer._collectionType);
        this._collectionType = collectionDeserializer._collectionType;
        this._valueDeserializer = collectionDeserializer._valueDeserializer;
        this._valueTypeDeserializer = collectionDeserializer._valueTypeDeserializer;
        this._valueInstantiator = collectionDeserializer._valueInstantiator;
        this._delegateDeserializer = collectionDeserializer._delegateDeserializer;
    }

    protected CollectionDeserializer withResolved(agy<?> com_fossil_agy_, agy<?> com_fossil_agy_2, ajs com_fossil_ajs) {
        if (com_fossil_agy_ == this._delegateDeserializer && com_fossil_agy_2 == this._valueDeserializer && com_fossil_ajs == this._valueTypeDeserializer) {
            return this;
        }
        return new CollectionDeserializer(this._collectionType, com_fossil_agy_2, com_fossil_ajs, this._valueInstantiator, com_fossil_agy_);
    }

    public boolean isCachable() {
        return this._valueDeserializer == null && this._valueTypeDeserializer == null && this._delegateDeserializer == null;
    }

    public CollectionDeserializer createContextual(DeserializationContext deserializationContext, agv com_fossil_agv) throws JsonMappingException {
        agy com_fossil_agy = null;
        if (this._valueInstantiator != null && this._valueInstantiator.canCreateUsingDelegate()) {
            JavaType delegateType = this._valueInstantiator.getDelegateType(deserializationContext.getConfig());
            if (delegateType == null) {
                throw new IllegalArgumentException("Invalid delegate-creator definition for " + this._collectionType + ": value instantiator (" + this._valueInstantiator.getClass().getName() + ") returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'");
            }
            com_fossil_agy = findDeserializer(deserializationContext, delegateType, com_fossil_agv);
        }
        agy findConvertingContentDeserializer = findConvertingContentDeserializer(deserializationContext, com_fossil_agv, this._valueDeserializer);
        JavaType contentType = this._collectionType.getContentType();
        if (findConvertingContentDeserializer == null) {
            findConvertingContentDeserializer = deserializationContext.findContextualValueDeserializer(contentType, com_fossil_agv);
        } else {
            findConvertingContentDeserializer = deserializationContext.handleSecondaryContextualization(findConvertingContentDeserializer, com_fossil_agv, contentType);
        }
        ajs com_fossil_ajs = this._valueTypeDeserializer;
        if (com_fossil_ajs != null) {
            com_fossil_ajs = com_fossil_ajs.forProperty(com_fossil_agv);
        }
        return withResolved(com_fossil_agy, findConvertingContentDeserializer, com_fossil_ajs);
    }

    public JavaType getContentType() {
        return this._collectionType.getContentType();
    }

    public agy<Object> getContentDeserializer() {
        return this._valueDeserializer;
    }

    public Collection<Object> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (this._delegateDeserializer != null) {
            return (Collection) this._valueInstantiator.createUsingDelegate(deserializationContext, this._delegateDeserializer.deserialize(jsonParser, deserializationContext));
        }
        if (jsonParser.zU() == JsonToken.VALUE_STRING) {
            String text = jsonParser.getText();
            if (text.length() == 0) {
                return (Collection) this._valueInstantiator.createFromString(deserializationContext, text);
            }
        }
        return deserialize(jsonParser, deserializationContext, (Collection) this._valueInstantiator.createUsingDefault(deserializationContext));
    }

    public Collection<Object> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<Object> collection) throws IOException {
        if (!jsonParser.Aa()) {
            return handleNonArray(jsonParser, deserializationContext, collection);
        }
        jsonParser.bm(collection);
        agy com_fossil_agy = this._valueDeserializer;
        ajs com_fossil_ajs = this._valueTypeDeserializer;
        C1516b c1516b = com_fossil_agy.getObjectIdReader() == null ? null : new C1516b(this._collectionType.getContentType().getRawClass(), collection);
        while (true) {
            JsonToken zP = jsonParser.zP();
            if (zP == JsonToken.END_ARRAY) {
                return collection;
            }
            Object nullValue;
            try {
                if (zP == JsonToken.VALUE_NULL) {
                    nullValue = com_fossil_agy.getNullValue(deserializationContext);
                } else if (com_fossil_ajs == null) {
                    nullValue = com_fossil_agy.deserialize(jsonParser, deserializationContext);
                } else {
                    nullValue = com_fossil_agy.deserializeWithType(jsonParser, deserializationContext, com_fossil_ajs);
                }
                if (c1516b != null) {
                    c1516b.add(nullValue);
                } else {
                    collection.add(nullValue);
                }
            } catch (Throwable e) {
                if (c1516b == null) {
                    throw JsonMappingException.from(jsonParser, "Unresolved forward reference but no identity info", e);
                }
                e.getRoid().m3405a(c1516b.m2719a(e));
            } catch (Throwable e2) {
                nullValue = (deserializationContext == null || deserializationContext.isEnabled(DeserializationFeature.WRAP_EXCEPTIONS)) ? 1 : null;
                if (nullValue == null && (e2 instanceof RuntimeException)) {
                    throw ((RuntimeException) e2);
                }
                throw JsonMappingException.wrapWithPath(e2, (Object) collection, collection.size());
            }
        }
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, ajs com_fossil_ajs) throws IOException {
        return com_fossil_ajs.deserializeTypedFromArray(jsonParser, deserializationContext);
    }

    protected final Collection<Object> handleNonArray(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<Object> collection) throws IOException {
        if (deserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
            agy com_fossil_agy = this._valueDeserializer;
            ajs com_fossil_ajs = this._valueTypeDeserializer;
            try {
                Object nullValue;
                if (jsonParser.zU() == JsonToken.VALUE_NULL) {
                    nullValue = com_fossil_agy.getNullValue(deserializationContext);
                } else if (com_fossil_ajs == null) {
                    nullValue = com_fossil_agy.deserialize(jsonParser, deserializationContext);
                } else {
                    nullValue = com_fossil_agy.deserializeWithType(jsonParser, deserializationContext, com_fossil_ajs);
                }
                collection.add(nullValue);
                return collection;
            } catch (Throwable e) {
                throw JsonMappingException.wrapWithPath(e, (Object) Object.class, collection.size());
            }
        }
        throw deserializationContext.mappingException(this._collectionType.getRawClass());
    }
}
