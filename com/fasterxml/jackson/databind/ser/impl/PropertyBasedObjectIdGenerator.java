package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;
import com.fossil.aiy;
import com.fossil.ald;

public class PropertyBasedObjectIdGenerator extends PropertyGenerator {
    private static final long serialVersionUID = 1;
    protected final ald _property;

    public PropertyBasedObjectIdGenerator(aiy com_fossil_aiy, ald com_fossil_ald) {
        this(com_fossil_aiy.getScope(), com_fossil_ald);
    }

    protected PropertyBasedObjectIdGenerator(Class<?> cls, ald com_fossil_ald) {
        super(cls);
        this._property = com_fossil_ald;
    }

    public boolean canUseFor(ObjectIdGenerator<?> objectIdGenerator) {
        if (objectIdGenerator.getClass() != getClass()) {
            return false;
        }
        PropertyBasedObjectIdGenerator propertyBasedObjectIdGenerator = (PropertyBasedObjectIdGenerator) objectIdGenerator;
        if (propertyBasedObjectIdGenerator.getScope() == this._scope && propertyBasedObjectIdGenerator._property == this._property) {
            return true;
        }
        return false;
    }

    public Object generateId(Object obj) {
        try {
            return this._property.get(obj);
        } catch (RuntimeException e) {
            throw e;
        } catch (Throwable e2) {
            throw new IllegalStateException("Problem accessing property '" + this._property.getName() + "': " + e2.getMessage(), e2);
        }
    }

    public ObjectIdGenerator<Object> forScope(Class<?> cls) {
        return cls == this._scope ? this : new PropertyBasedObjectIdGenerator((Class) cls, this._property);
    }

    public ObjectIdGenerator<Object> newForSerialization(Object obj) {
        return this;
    }

    public IdKey key(Object obj) {
        if (obj == null) {
            return null;
        }
        return new IdKey(getClass(), this._scope, obj);
    }
}
