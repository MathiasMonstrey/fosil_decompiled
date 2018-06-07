package com.fasterxml.jackson.databind.cfg;

import com.fossil.alf;
import com.fossil.alo;
import com.fossil.amd;
import com.fossil.ame;
import java.io.Serializable;

public final class SerializerFactoryConfig implements Serializable {
    protected static final alf[] NO_MODIFIERS = new alf[0];
    protected static final alo[] NO_SERIALIZERS = new alo[0];
    private static final long serialVersionUID = 1;
    protected final alo[] _additionalKeySerializers;
    protected final alo[] _additionalSerializers;
    protected final alf[] _modifiers;

    public SerializerFactoryConfig() {
        this(null, null, null);
    }

    protected SerializerFactoryConfig(alo[] com_fossil_aloArr, alo[] com_fossil_aloArr2, alf[] com_fossil_alfArr) {
        if (com_fossil_aloArr == null) {
            com_fossil_aloArr = NO_SERIALIZERS;
        }
        this._additionalSerializers = com_fossil_aloArr;
        if (com_fossil_aloArr2 == null) {
            com_fossil_aloArr2 = NO_SERIALIZERS;
        }
        this._additionalKeySerializers = com_fossil_aloArr2;
        if (com_fossil_alfArr == null) {
            com_fossil_alfArr = NO_MODIFIERS;
        }
        this._modifiers = com_fossil_alfArr;
    }

    public SerializerFactoryConfig withAdditionalSerializers(alo com_fossil_alo) {
        if (com_fossil_alo != null) {
            return new SerializerFactoryConfig((alo[]) amd.m3837a(this._additionalSerializers, (Object) com_fossil_alo), this._additionalKeySerializers, this._modifiers);
        }
        throw new IllegalArgumentException("Can not pass null Serializers");
    }

    public SerializerFactoryConfig withAdditionalKeySerializers(alo com_fossil_alo) {
        if (com_fossil_alo == null) {
            throw new IllegalArgumentException("Can not pass null Serializers");
        }
        return new SerializerFactoryConfig(this._additionalSerializers, (alo[]) amd.m3837a(this._additionalKeySerializers, (Object) com_fossil_alo), this._modifiers);
    }

    public SerializerFactoryConfig withSerializerModifier(alf com_fossil_alf) {
        if (com_fossil_alf == null) {
            throw new IllegalArgumentException("Can not pass null modifier");
        }
        return new SerializerFactoryConfig(this._additionalSerializers, this._additionalKeySerializers, (alf[]) amd.m3837a(this._modifiers, (Object) com_fossil_alf));
    }

    public boolean hasSerializers() {
        return this._additionalSerializers.length > 0;
    }

    public boolean hasKeySerializers() {
        return this._additionalKeySerializers.length > 0;
    }

    public boolean hasSerializerModifiers() {
        return this._modifiers.length > 0;
    }

    public Iterable<alo> serializers() {
        return new ame(this._additionalSerializers);
    }

    public Iterable<alo> keySerializers() {
        return new ame(this._additionalKeySerializers);
    }

    public Iterable<alf> serializerModifiers() {
        return new ame(this._modifiers);
    }
}
