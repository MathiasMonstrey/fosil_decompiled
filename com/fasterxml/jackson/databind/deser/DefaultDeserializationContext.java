package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fossil.aeu;
import com.fossil.aev;
import com.fossil.agx;
import com.fossil.agy;
import com.fossil.agy.C1636a;
import com.fossil.ahc;
import com.fossil.ahc.C1639a;
import com.fossil.ahr;
import com.fossil.ahz;
import com.fossil.aic;
import com.fossil.ail;
import com.fossil.ail.C1512a;
import com.fossil.aiq;
import com.fossil.ami;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public abstract class DefaultDeserializationContext extends DeserializationContext implements Serializable {
    private static final long serialVersionUID = 1;
    private List<aeu> _objectIdResolvers;
    protected transient LinkedHashMap<IdKey, ail> _objectIds;

    public static final class Impl extends DefaultDeserializationContext {
        private static final long serialVersionUID = 1;

        public Impl(ahz com_fossil_ahz) {
            super(com_fossil_ahz, null);
        }

        protected Impl(Impl impl, DeserializationConfig deserializationConfig, JsonParser jsonParser, agx com_fossil_agx) {
            super(impl, deserializationConfig, jsonParser, com_fossil_agx);
        }

        protected Impl(Impl impl) {
            super(impl);
        }

        protected Impl(Impl impl, ahz com_fossil_ahz) {
            super((DefaultDeserializationContext) impl, com_fossil_ahz);
        }

        public DefaultDeserializationContext copy() {
            if (getClass() != Impl.class) {
                return super.copy();
            }
            return new Impl(this);
        }

        public DefaultDeserializationContext createInstance(DeserializationConfig deserializationConfig, JsonParser jsonParser, agx com_fossil_agx) {
            return new Impl(this, deserializationConfig, jsonParser, com_fossil_agx);
        }

        public DefaultDeserializationContext with(ahz com_fossil_ahz) {
            return new Impl(this, com_fossil_ahz);
        }
    }

    public abstract DefaultDeserializationContext createInstance(DeserializationConfig deserializationConfig, JsonParser jsonParser, agx com_fossil_agx);

    public abstract DefaultDeserializationContext with(ahz com_fossil_ahz);

    protected DefaultDeserializationContext(ahz com_fossil_ahz, DeserializerCache deserializerCache) {
        super(com_fossil_ahz, deserializerCache);
    }

    protected DefaultDeserializationContext(DefaultDeserializationContext defaultDeserializationContext, DeserializationConfig deserializationConfig, JsonParser jsonParser, agx com_fossil_agx) {
        super(defaultDeserializationContext, deserializationConfig, jsonParser, com_fossil_agx);
    }

    protected DefaultDeserializationContext(DefaultDeserializationContext defaultDeserializationContext, ahz com_fossil_ahz) {
        super((DeserializationContext) defaultDeserializationContext, com_fossil_ahz);
    }

    protected DefaultDeserializationContext(DefaultDeserializationContext defaultDeserializationContext) {
        super((DeserializationContext) defaultDeserializationContext);
    }

    public DefaultDeserializationContext copy() {
        throw new IllegalStateException("DefaultDeserializationContext sub-class not overriding copy()");
    }

    public ail findObjectId(Object obj, ObjectIdGenerator<?> objectIdGenerator, aeu com_fossil_aeu) {
        if (obj == null) {
            return null;
        }
        aeu com_fossil_aeu2;
        IdKey key = objectIdGenerator.key(obj);
        if (this._objectIds == null) {
            this._objectIds = new LinkedHashMap();
        } else {
            ail com_fossil_ail = (ail) this._objectIds.get(key);
            if (com_fossil_ail != null) {
                return com_fossil_ail;
            }
        }
        if (this._objectIdResolvers == null) {
            this._objectIdResolvers = new ArrayList(8);
            com_fossil_aeu2 = null;
        } else {
            for (aeu com_fossil_aeu22 : this._objectIdResolvers) {
                if (com_fossil_aeu22.mo843a(com_fossil_aeu)) {
                    break;
                }
            }
            com_fossil_aeu22 = null;
        }
        if (com_fossil_aeu22 == null) {
            com_fossil_aeu22 = com_fossil_aeu.bl(this);
            this._objectIdResolvers.add(com_fossil_aeu22);
        }
        ail com_fossil_ail2 = new ail(key);
        com_fossil_ail2.m3407b(com_fossil_aeu22);
        this._objectIds.put(key, com_fossil_ail2);
        return com_fossil_ail2;
    }

    @Deprecated
    public ail findObjectId(Object obj, ObjectIdGenerator<?> objectIdGenerator) {
        return findObjectId(obj, objectIdGenerator, new aev());
    }

    public void checkUnresolvedObjectId() throws UnresolvedForwardReference {
        if (this._objectIds != null && isEnabled(DeserializationFeature.FAIL_ON_UNRESOLVED_OBJECT_IDS)) {
            UnresolvedForwardReference unresolvedForwardReference = null;
            for (Entry value : this._objectIds.entrySet()) {
                ail com_fossil_ail = (ail) value.getValue();
                if (com_fossil_ail.EM() && !tryToResolveUnresolvedObjectId(com_fossil_ail)) {
                    if (unresolvedForwardReference == null) {
                        unresolvedForwardReference = new UnresolvedForwardReference("Unresolved forward references for: ");
                    }
                    Object obj = com_fossil_ail.EK().key;
                    Iterator EN = com_fossil_ail.EN();
                    while (EN.hasNext()) {
                        C1512a c1512a = (C1512a) EN.next();
                        unresolvedForwardReference.addUnresolvedId(obj, c1512a.EO(), c1512a.getLocation());
                    }
                }
            }
            if (unresolvedForwardReference != null) {
                throw unresolvedForwardReference;
            }
        }
    }

    protected boolean tryToResolveUnresolvedObjectId(ail com_fossil_ail) {
        return com_fossil_ail.m3406a((DeserializationContext) this);
    }

    public agy<Object> deserializerInstance(aiq com_fossil_aiq, Object obj) throws JsonMappingException {
        agy<Object> com_fossil_agy_java_lang_Object = null;
        if (obj != null) {
            if (obj instanceof agy) {
                com_fossil_agy_java_lang_Object = (agy) obj;
            } else if (obj instanceof Class) {
                Class cls = (Class) obj;
                if (!(cls == C1636a.class || ami.m3854D(cls))) {
                    if (agy.class.isAssignableFrom(cls)) {
                        ahr handlerInstantiator = this._config.getHandlerInstantiator();
                        if (handlerInstantiator != null) {
                            com_fossil_agy_java_lang_Object = handlerInstantiator.m3340a(this._config, com_fossil_aiq, cls);
                        }
                        if (com_fossil_agy_java_lang_Object == null) {
                            com_fossil_agy_java_lang_Object = (agy) ami.m3863b(cls, this._config.canOverrideAccessModifiers());
                        }
                    } else {
                        throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<JsonDeserializer>");
                    }
                }
            } else {
                throw new IllegalStateException("AnnotationIntrospector returned deserializer definition of type " + obj.getClass().getName() + "; expected type JsonDeserializer or Class<JsonDeserializer> instead");
            }
            if (com_fossil_agy_java_lang_Object instanceof aic) {
                ((aic) com_fossil_agy_java_lang_Object).resolve(this);
            }
        }
        return com_fossil_agy_java_lang_Object;
    }

    public final ahc keyDeserializerInstance(aiq com_fossil_aiq, Object obj) throws JsonMappingException {
        ahc com_fossil_ahc = null;
        if (obj != null) {
            if (obj instanceof ahc) {
                com_fossil_ahc = (ahc) obj;
            } else if (obj instanceof Class) {
                Class cls = (Class) obj;
                if (!(cls == C1639a.class || ami.m3854D(cls))) {
                    if (ahc.class.isAssignableFrom(cls)) {
                        ahr handlerInstantiator = this._config.getHandlerInstantiator();
                        if (handlerInstantiator != null) {
                            com_fossil_ahc = handlerInstantiator.m3344b(this._config, com_fossil_aiq, cls);
                        }
                        if (com_fossil_ahc == null) {
                            com_fossil_ahc = (ahc) ami.m3863b(cls, this._config.canOverrideAccessModifiers());
                        }
                    } else {
                        throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<KeyDeserializer>");
                    }
                }
            } else {
                throw new IllegalStateException("AnnotationIntrospector returned key deserializer definition of type " + obj.getClass().getName() + "; expected type KeyDeserializer or Class<KeyDeserializer> instead");
            }
            if (com_fossil_ahc instanceof aic) {
                ((aic) com_fossil_ahc).resolve(this);
            }
        }
        return com_fossil_ahc;
    }
}
