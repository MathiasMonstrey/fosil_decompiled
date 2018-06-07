package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import com.fossil.agv;
import com.fossil.agy;
import com.fossil.ahc;
import com.fossil.ahh;
import com.fossil.ahv;
import com.fossil.ahw;
import com.fossil.aic;
import com.fossil.aie;
import com.fossil.aii;
import com.fossil.aik;
import com.fossil.ail.C1512a;
import com.fossil.aiq;
import com.fossil.ajs;
import com.fossil.amd;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ahh
public class MapDeserializer extends ContainerDeserializerBase<Map<Object, Object>> implements ahv, aic {
    private static final long serialVersionUID = 1;
    protected agy<Object> _delegateDeserializer;
    protected final boolean _hasDefaultCreator;
    protected HashSet<String> _ignorableProperties;
    protected final ahc _keyDeserializer;
    protected final JavaType _mapType;
    protected aii _propertyBasedCreator;
    protected boolean _standardStringKey;
    protected final agy<Object> _valueDeserializer;
    protected final aie _valueInstantiator;
    protected final ajs _valueTypeDeserializer;

    static final class C1517a extends C1512a {
        private final C1518b aSf;
        public final Map<Object, Object> aSg = new LinkedHashMap();
        public final Object key;

        C1517a(C1518b c1518b, UnresolvedForwardReference unresolvedForwardReference, Class<?> cls, Object obj) {
            super(unresolvedForwardReference, cls);
            this.aSf = c1518b;
            this.key = obj;
        }

        public void mo510i(Object obj, Object obj2) throws IOException {
            this.aSf.m2725k(obj, obj2);
        }
    }

    static final class C1518b {
        private List<C1517a> aSc = new ArrayList();
        private final Class<?> aSh;
        private Map<Object, Object> aSi;

        public C1518b(Class<?> cls, Map<Object, Object> map) {
            this.aSh = cls;
            this.aSi = map;
        }

        public void m2726l(Object obj, Object obj2) {
            if (this.aSc.isEmpty()) {
                this.aSi.put(obj, obj2);
            } else {
                ((C1517a) this.aSc.get(this.aSc.size() - 1)).aSg.put(obj, obj2);
            }
        }

        public C1512a m2724a(UnresolvedForwardReference unresolvedForwardReference, Object obj) {
            C1512a c1517a = new C1517a(this, unresolvedForwardReference, this.aSh, obj);
            this.aSc.add(c1517a);
            return c1517a;
        }

        public void m2725k(Object obj, Object obj2) throws IOException {
            Iterator it = this.aSc.iterator();
            Map map = this.aSi;
            while (it.hasNext()) {
                C1517a c1517a = (C1517a) it.next();
                if (c1517a.bv(obj)) {
                    it.remove();
                    map.put(c1517a.key, obj2);
                    map.putAll(c1517a.aSg);
                    return;
                }
                map = c1517a.aSg;
            }
            throw new IllegalArgumentException("Trying to resolve a forward reference with id [" + obj + "] that wasn't previously seen as unresolved.");
        }
    }

    public MapDeserializer(JavaType javaType, aie com_fossil_aie, ahc com_fossil_ahc, agy<Object> com_fossil_agy_java_lang_Object, ajs com_fossil_ajs) {
        super(javaType);
        this._mapType = javaType;
        this._keyDeserializer = com_fossil_ahc;
        this._valueDeserializer = com_fossil_agy_java_lang_Object;
        this._valueTypeDeserializer = com_fossil_ajs;
        this._valueInstantiator = com_fossil_aie;
        this._hasDefaultCreator = com_fossil_aie.canCreateUsingDefault();
        this._delegateDeserializer = null;
        this._propertyBasedCreator = null;
        this._standardStringKey = _isStdKeyDeser(javaType, com_fossil_ahc);
    }

    protected MapDeserializer(MapDeserializer mapDeserializer) {
        super(mapDeserializer._mapType);
        this._mapType = mapDeserializer._mapType;
        this._keyDeserializer = mapDeserializer._keyDeserializer;
        this._valueDeserializer = mapDeserializer._valueDeserializer;
        this._valueTypeDeserializer = mapDeserializer._valueTypeDeserializer;
        this._valueInstantiator = mapDeserializer._valueInstantiator;
        this._propertyBasedCreator = mapDeserializer._propertyBasedCreator;
        this._delegateDeserializer = mapDeserializer._delegateDeserializer;
        this._hasDefaultCreator = mapDeserializer._hasDefaultCreator;
        this._ignorableProperties = mapDeserializer._ignorableProperties;
        this._standardStringKey = mapDeserializer._standardStringKey;
    }

    protected MapDeserializer(MapDeserializer mapDeserializer, ahc com_fossil_ahc, agy<Object> com_fossil_agy_java_lang_Object, ajs com_fossil_ajs, HashSet<String> hashSet) {
        super(mapDeserializer._mapType);
        this._mapType = mapDeserializer._mapType;
        this._keyDeserializer = com_fossil_ahc;
        this._valueDeserializer = com_fossil_agy_java_lang_Object;
        this._valueTypeDeserializer = com_fossil_ajs;
        this._valueInstantiator = mapDeserializer._valueInstantiator;
        this._propertyBasedCreator = mapDeserializer._propertyBasedCreator;
        this._delegateDeserializer = mapDeserializer._delegateDeserializer;
        this._hasDefaultCreator = mapDeserializer._hasDefaultCreator;
        this._ignorableProperties = hashSet;
        this._standardStringKey = _isStdKeyDeser(this._mapType, com_fossil_ahc);
    }

    protected MapDeserializer withResolved(ahc com_fossil_ahc, ajs com_fossil_ajs, agy<?> com_fossil_agy_, HashSet<String> hashSet) {
        return (this._keyDeserializer == com_fossil_ahc && this._valueDeserializer == com_fossil_agy_ && this._valueTypeDeserializer == com_fossil_ajs && this._ignorableProperties == hashSet) ? this : new MapDeserializer(this, com_fossil_ahc, (agy) com_fossil_agy_, com_fossil_ajs, (HashSet) hashSet);
    }

    protected final boolean _isStdKeyDeser(JavaType javaType, ahc com_fossil_ahc) {
        if (com_fossil_ahc == null) {
            return true;
        }
        JavaType keyType = javaType.getKeyType();
        if (keyType == null) {
            return true;
        }
        Class rawClass = keyType.getRawClass();
        if ((rawClass == String.class || rawClass == Object.class) && isDefaultKeyDeserializer(com_fossil_ahc)) {
            return true;
        }
        return false;
    }

    public void setIgnorableProperties(String[] strArr) {
        HashSet b = (strArr == null || strArr.length == 0) ? null : amd.m3838b(strArr);
        this._ignorableProperties = b;
    }

    public void resolve(DeserializationContext deserializationContext) throws JsonMappingException {
        if (this._valueInstantiator.canCreateUsingDelegate()) {
            JavaType delegateType = this._valueInstantiator.getDelegateType(deserializationContext.getConfig());
            if (delegateType == null) {
                throw new IllegalArgumentException("Invalid delegate-creator definition for " + this._mapType + ": value instantiator (" + this._valueInstantiator.getClass().getName() + ") returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'");
            }
            this._delegateDeserializer = findDeserializer(deserializationContext, delegateType, null);
        }
        if (this._valueInstantiator.canCreateFromObjectWith()) {
            this._propertyBasedCreator = aii.m3395a(deserializationContext, this._valueInstantiator, this._valueInstantiator.getFromObjectArguments(deserializationContext.getConfig()));
        }
        this._standardStringKey = _isStdKeyDeser(this._mapType, this._keyDeserializer);
    }

    public agy<?> createContextual(DeserializationContext deserializationContext, agv com_fossil_agv) throws JsonMappingException {
        HashSet hashSet;
        ahc com_fossil_ahc = this._keyDeserializer;
        if (com_fossil_ahc == null) {
            com_fossil_ahc = deserializationContext.findKeyDeserializer(this._mapType.getKeyType(), com_fossil_agv);
        } else if (com_fossil_ahc instanceof ahw) {
            com_fossil_ahc = ((ahw) com_fossil_ahc).m3371a(deserializationContext, com_fossil_agv);
        }
        agy com_fossil_agy = this._valueDeserializer;
        if (com_fossil_agv != null) {
            com_fossil_agy = findConvertingContentDeserializer(deserializationContext, com_fossil_agv, com_fossil_agy);
        }
        JavaType contentType = this._mapType.getContentType();
        if (com_fossil_agy == null) {
            com_fossil_agy = deserializationContext.findContextualValueDeserializer(contentType, com_fossil_agv);
        } else {
            com_fossil_agy = deserializationContext.handleSecondaryContextualization(com_fossil_agy, com_fossil_agv, contentType);
        }
        ajs com_fossil_ajs = this._valueTypeDeserializer;
        if (com_fossil_ajs != null) {
            com_fossil_ajs = com_fossil_ajs.forProperty(com_fossil_agv);
        }
        Collection collection = this._ignorableProperties;
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        if (!(annotationIntrospector == null || com_fossil_agv == null)) {
            aiq member = com_fossil_agv.getMember();
            if (member != null) {
                String[] findPropertiesToIgnore = annotationIntrospector.findPropertiesToIgnore(member, false);
                if (findPropertiesToIgnore != null) {
                    hashSet = collection == null ? new HashSet() : new HashSet(collection);
                    for (Object add : findPropertiesToIgnore) {
                        hashSet.add(add);
                    }
                    return withResolved(com_fossil_ahc, com_fossil_ajs, com_fossil_agy, hashSet);
                }
            }
        }
        hashSet = collection;
        return withResolved(com_fossil_ahc, com_fossil_ajs, com_fossil_agy, hashSet);
    }

    public JavaType getContentType() {
        return this._mapType.getContentType();
    }

    public agy<Object> getContentDeserializer() {
        return this._valueDeserializer;
    }

    public boolean isCachable() {
        return this._valueDeserializer == null && this._keyDeserializer == null && this._valueTypeDeserializer == null && this._ignorableProperties == null;
    }

    public Map<Object, Object> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (this._propertyBasedCreator != null) {
            return _deserializeUsingCreator(jsonParser, deserializationContext);
        }
        if (this._delegateDeserializer != null) {
            return (Map) this._valueInstantiator.createUsingDelegate(deserializationContext, this._delegateDeserializer.deserialize(jsonParser, deserializationContext));
        }
        if (this._hasDefaultCreator) {
            JsonToken zU = jsonParser.zU();
            if (zU == JsonToken.START_OBJECT || zU == JsonToken.FIELD_NAME || zU == JsonToken.END_OBJECT) {
                Map<Object, Object> map = (Map) this._valueInstantiator.createUsingDefault(deserializationContext);
                if (this._standardStringKey) {
                    _readAndBindStringMap(jsonParser, deserializationContext, map);
                    return map;
                }
                _readAndBind(jsonParser, deserializationContext, map);
                return map;
            } else if (zU == JsonToken.VALUE_STRING) {
                return (Map) this._valueInstantiator.createFromString(deserializationContext, jsonParser.getText());
            } else {
                return (Map) _deserializeFromEmpty(jsonParser, deserializationContext);
            }
        }
        throw deserializationContext.instantiationException(getMapClass(), "No default constructor found");
    }

    public Map<Object, Object> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Map<Object, Object> map) throws IOException {
        jsonParser.bm(map);
        JsonToken zU = jsonParser.zU();
        if (zU == JsonToken.START_OBJECT || zU == JsonToken.FIELD_NAME) {
            if (this._standardStringKey) {
                _readAndBindStringMap(jsonParser, deserializationContext, map);
            } else {
                _readAndBind(jsonParser, deserializationContext, map);
            }
            return map;
        }
        throw deserializationContext.mappingException(getMapClass());
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, ajs com_fossil_ajs) throws IOException, JsonProcessingException {
        return com_fossil_ajs.deserializeTypedFromObject(jsonParser, deserializationContext);
    }

    public final Class<?> getMapClass() {
        return this._mapType.getRawClass();
    }

    public JavaType getValueType() {
        return this._mapType;
    }

    protected final void _readAndBind(JsonParser jsonParser, DeserializationContext deserializationContext, Map<Object, Object> map) throws IOException {
        String zR;
        JsonToken zU;
        ahc com_fossil_ahc = this._keyDeserializer;
        agy com_fossil_agy = this._valueDeserializer;
        ajs com_fossil_ajs = this._valueTypeDeserializer;
        C1518b c1518b = null;
        Object obj = com_fossil_agy.getObjectIdReader() != null ? 1 : null;
        if (obj != null) {
            c1518b = new C1518b(this._mapType.getContentType().getRawClass(), map);
        }
        if (jsonParser.Ab()) {
            zR = jsonParser.zR();
        } else {
            zU = jsonParser.zU();
            if (zU != JsonToken.END_OBJECT) {
                if (zU != JsonToken.FIELD_NAME) {
                    throw deserializationContext.mappingException(this._mapType.getRawClass(), jsonParser.zU());
                }
                zR = jsonParser.zW();
            } else {
                return;
            }
        }
        while (zR != null) {
            Object deserializeKey = com_fossil_ahc.deserializeKey(zR, deserializationContext);
            zU = jsonParser.zP();
            if (this._ignorableProperties == null || !this._ignorableProperties.contains(zR)) {
                try {
                    Object nullValue;
                    if (zU == JsonToken.VALUE_NULL) {
                        nullValue = com_fossil_agy.getNullValue(deserializationContext);
                    } else if (com_fossil_ajs == null) {
                        nullValue = com_fossil_agy.deserialize(jsonParser, deserializationContext);
                    } else {
                        nullValue = com_fossil_agy.deserializeWithType(jsonParser, deserializationContext, com_fossil_ajs);
                    }
                    if (obj != null) {
                        c1518b.m2726l(deserializeKey, nullValue);
                    } else {
                        map.put(deserializeKey, nullValue);
                    }
                } catch (UnresolvedForwardReference e) {
                    m2727a(jsonParser, c1518b, deserializeKey, e);
                } catch (Throwable e2) {
                    wrapAndThrow(e2, map, zR);
                }
            } else {
                jsonParser.zT();
            }
            zR = jsonParser.zR();
        }
    }

    protected final void _readAndBindStringMap(JsonParser jsonParser, DeserializationContext deserializationContext, Map<Object, Object> map) throws IOException {
        String zR;
        JsonToken zU;
        agy com_fossil_agy = this._valueDeserializer;
        ajs com_fossil_ajs = this._valueTypeDeserializer;
        C1518b c1518b = null;
        Object obj = com_fossil_agy.getObjectIdReader() != null ? 1 : null;
        if (obj != null) {
            c1518b = new C1518b(this._mapType.getContentType().getRawClass(), map);
        }
        if (jsonParser.Ab()) {
            zR = jsonParser.zR();
        } else {
            zU = jsonParser.zU();
            if (zU != JsonToken.END_OBJECT) {
                if (zU != JsonToken.FIELD_NAME) {
                    throw deserializationContext.mappingException(this._mapType.getRawClass(), jsonParser.zU());
                }
                zR = jsonParser.zW();
            } else {
                return;
            }
        }
        while (zR != null) {
            zU = jsonParser.zP();
            if (this._ignorableProperties == null || !this._ignorableProperties.contains(zR)) {
                try {
                    Object nullValue;
                    if (zU == JsonToken.VALUE_NULL) {
                        nullValue = com_fossil_agy.getNullValue(deserializationContext);
                    } else if (com_fossil_ajs == null) {
                        nullValue = com_fossil_agy.deserialize(jsonParser, deserializationContext);
                    } else {
                        nullValue = com_fossil_agy.deserializeWithType(jsonParser, deserializationContext, com_fossil_ajs);
                    }
                    if (obj != null) {
                        c1518b.m2726l(zR, nullValue);
                    } else {
                        map.put(zR, nullValue);
                    }
                } catch (UnresolvedForwardReference e) {
                    m2727a(jsonParser, c1518b, zR, e);
                } catch (Throwable e2) {
                    wrapAndThrow(e2, map, zR);
                }
            } else {
                jsonParser.zT();
            }
            zR = jsonParser.zR();
        }
    }

    public Map<Object, Object> _deserializeUsingCreator(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        aii com_fossil_aii = this._propertyBasedCreator;
        aik a = com_fossil_aii.m3396a(jsonParser, deserializationContext, null);
        agy com_fossil_agy = this._valueDeserializer;
        ajs com_fossil_ajs = this._valueTypeDeserializer;
        String zR = jsonParser.Ab() ? jsonParser.zR() : jsonParser.mo865a(JsonToken.FIELD_NAME) ? jsonParser.zW() : null;
        while (zR != null) {
            JsonToken zP = jsonParser.zP();
            if (this._ignorableProperties == null || !this._ignorableProperties.contains(zR)) {
                SettableBeanProperty bJ = com_fossil_aii.bJ(zR);
                if (bJ == null) {
                    Object deserializeKey = this._keyDeserializer.deserializeKey(zR, deserializationContext);
                    try {
                        Object nullValue;
                        if (zP == JsonToken.VALUE_NULL) {
                            nullValue = com_fossil_agy.getNullValue(deserializationContext);
                        } else if (com_fossil_ajs == null) {
                            nullValue = com_fossil_agy.deserialize(jsonParser, deserializationContext);
                        } else {
                            nullValue = com_fossil_agy.deserializeWithType(jsonParser, deserializationContext, com_fossil_ajs);
                        }
                        a.m3404j(deserializeKey, nullValue);
                    } catch (Throwable e) {
                        wrapAndThrow(e, this._mapType.getRawClass(), zR);
                        return null;
                    }
                } else if (a.m3400a(bJ, bJ.deserialize(jsonParser, deserializationContext))) {
                    jsonParser.zP();
                    try {
                        Map<Object, Object> map = (Map) com_fossil_aii.m3397a(deserializationContext, a);
                        _readAndBind(jsonParser, deserializationContext, map);
                        return map;
                    } catch (Throwable e2) {
                        wrapAndThrow(e2, this._mapType.getRawClass(), zR);
                        return null;
                    }
                }
            } else {
                jsonParser.zT();
            }
            zR = jsonParser.zR();
        }
        try {
            return (Map) com_fossil_aii.m3397a(deserializationContext, a);
        } catch (Throwable e22) {
            wrapAndThrow(e22, this._mapType.getRawClass(), null);
            return null;
        }
    }

    @Deprecated
    protected void wrapAndThrow(Throwable th, Object obj) throws IOException {
        wrapAndThrow(th, obj, null);
    }

    private void m2727a(JsonParser jsonParser, C1518b c1518b, Object obj, UnresolvedForwardReference unresolvedForwardReference) throws JsonMappingException {
        if (c1518b == null) {
            throw JsonMappingException.from(jsonParser, "Unresolved forward reference but no identity info.", unresolvedForwardReference);
        }
        unresolvedForwardReference.getRoid().m3405a(c1518b.m2724a(unresolvedForwardReference, obj));
    }
}
