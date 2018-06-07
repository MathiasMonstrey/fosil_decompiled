package com.fossil;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.AbstractDeserializer;
import com.fasterxml.jackson.databind.deser.BeanDeserializer;
import com.fasterxml.jackson.databind.deser.BuilderBasedDeserializer;
import com.fasterxml.jackson.databind.deser.SettableAnyProperty;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdValueProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fossil.ahl.C1642a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class aht {
    protected SettableAnyProperty _anySetter;
    protected AnnotatedMethod _buildMethod;
    protected HashSet<String> _ignorableProps;
    protected boolean _ignoreAllUnknown;
    protected ObjectIdReader _objectIdReader;
    protected aie _valueInstantiator;
    protected final agu aQQ;
    protected final boolean aQR;
    protected final boolean aQS;
    protected final Map<String, SettableBeanProperty> aQT = new LinkedHashMap();
    protected List<ain> aQU;
    protected HashMap<String, SettableBeanProperty> aQV;
    protected C1642a aQW;

    public aht(agu com_fossil_agu, DeserializationConfig deserializationConfig) {
        this.aQQ = com_fossil_agu;
        this.aQR = deserializationConfig.isEnabled(MapperFeature.DEFAULT_VIEW_INCLUSION);
        this.aQS = deserializationConfig.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
    }

    public void m3355a(SettableBeanProperty settableBeanProperty, boolean z) {
        this.aQT.put(settableBeanProperty.getName(), settableBeanProperty);
    }

    public void m3354a(SettableBeanProperty settableBeanProperty) {
        SettableBeanProperty settableBeanProperty2 = (SettableBeanProperty) this.aQT.put(settableBeanProperty.getName(), settableBeanProperty);
        if (settableBeanProperty2 != null && settableBeanProperty2 != settableBeanProperty) {
            throw new IllegalArgumentException("Duplicate property '" + settableBeanProperty.getName() + "' for " + this.aQQ.getType());
        }
    }

    public void m3359a(String str, SettableBeanProperty settableBeanProperty) {
        if (this.aQV == null) {
            this.aQV = new HashMap(4);
        }
        this.aQV.put(str, settableBeanProperty);
        if (this.aQT != null) {
            this.aQT.remove(settableBeanProperty.getName());
        }
    }

    public void m3352a(PropertyName propertyName, JavaType javaType, amc com_fossil_amc, AnnotatedMember annotatedMember, Object obj) {
        if (this.aQU == null) {
            this.aQU = new ArrayList();
        }
        this.aQU.add(new ain(propertyName, javaType, com_fossil_amc, annotatedMember, obj));
    }

    public void bG(String str) {
        if (this._ignorableProps == null) {
            this._ignorableProps = new HashSet();
        }
        this._ignorableProps.add(str);
    }

    public void m3360b(SettableBeanProperty settableBeanProperty) {
        m3354a(settableBeanProperty);
    }

    public void m3353a(SettableAnyProperty settableAnyProperty) {
        if (this._anySetter == null || settableAnyProperty == null) {
            this._anySetter = settableAnyProperty;
            return;
        }
        throw new IllegalStateException("_anySetter already set to non-null");
    }

    public void aK(boolean z) {
        this._ignoreAllUnknown = z;
    }

    public void m3358a(aie com_fossil_aie) {
        this._valueInstantiator = com_fossil_aie;
    }

    public void m3356a(ObjectIdReader objectIdReader) {
        this._objectIdReader = objectIdReader;
    }

    public void m3357a(AnnotatedMethod annotatedMethod, C1642a c1642a) {
        this._buildMethod = annotatedMethod;
        this.aQW = c1642a;
    }

    public SettableBeanProperty findProperty(PropertyName propertyName) {
        return (SettableBeanProperty) this.aQT.get(propertyName.getSimpleName());
    }

    public SettableAnyProperty Ep() {
        return this._anySetter;
    }

    public aie getValueInstantiator() {
        return this._valueInstantiator;
    }

    public List<ain> Eq() {
        return this.aQU;
    }

    public ObjectIdReader getObjectIdReader() {
        return this._objectIdReader;
    }

    public AnnotatedMethod Er() {
        return this._buildMethod;
    }

    public agy<?> Es() {
        boolean z = true;
        Collection<SettableBeanProperty> values = this.aQT.values();
        BeanPropertyMap construct = BeanPropertyMap.construct(values, this.aQS);
        construct.assignIndexes();
        boolean z2 = !this.aQR;
        if (!z2) {
            for (SettableBeanProperty hasViews : values) {
                if (hasViews.hasViews()) {
                    break;
                }
            }
        }
        z = z2;
        if (this._objectIdReader != null) {
            construct = construct.withProperty(new ObjectIdValueProperty(this._objectIdReader, PropertyMetadata.STD_REQUIRED));
        }
        return new BeanDeserializer(this, this.aQQ, construct, this.aQV, this._ignorableProps, this._ignoreAllUnknown, z);
    }

    public AbstractDeserializer Et() {
        return new AbstractDeserializer(this, this.aQQ, this.aQV);
    }

    public agy<?> m3351a(JavaType javaType, String str) {
        boolean z = true;
        if (this._buildMethod != null) {
            Class rawReturnType = this._buildMethod.getRawReturnType();
            Class rawClass = javaType.getRawClass();
            if (!(rawReturnType == rawClass || rawReturnType.isAssignableFrom(rawClass) || rawClass.isAssignableFrom(rawReturnType))) {
                throw new IllegalArgumentException("Build method '" + this._buildMethod.getFullName() + " has bad return type (" + rawReturnType.getName() + "), not compatible with POJO type (" + javaType.getRawClass().getName() + ")");
            }
        } else if (!str.isEmpty()) {
            throw new IllegalArgumentException("Builder class " + this.aQQ.getBeanClass().getName() + " does not have build method (name: '" + str + "')");
        }
        Collection<SettableBeanProperty> values = this.aQT.values();
        BeanPropertyMap construct = BeanPropertyMap.construct(values, this.aQS);
        construct.assignIndexes();
        boolean z2 = !this.aQR;
        if (!z2) {
            for (SettableBeanProperty hasViews : values) {
                if (hasViews.hasViews()) {
                    break;
                }
            }
        }
        z = z2;
        if (this._objectIdReader != null) {
            construct = construct.withProperty(new ObjectIdValueProperty(this._objectIdReader, PropertyMetadata.STD_REQUIRED));
        }
        return new BuilderBasedDeserializer(this, this.aQQ, construct, this.aQV, this._ignorableProps, this._ignoreAllUnknown, z);
    }
}
