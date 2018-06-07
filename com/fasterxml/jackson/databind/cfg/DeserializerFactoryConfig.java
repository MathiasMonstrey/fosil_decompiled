package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializers;
import com.fossil.agt;
import com.fossil.ahu;
import com.fossil.aia;
import com.fossil.aib;
import com.fossil.aif;
import com.fossil.amd;
import com.fossil.ame;
import java.io.Serializable;

public class DeserializerFactoryConfig implements Serializable {
    protected static final aib[] DEFAULT_KEY_DESERIALIZERS = new aib[]{new StdKeyDeserializers()};
    protected static final agt[] NO_ABSTRACT_TYPE_RESOLVERS = new agt[0];
    protected static final aia[] NO_DESERIALIZERS = new aia[0];
    protected static final ahu[] NO_MODIFIERS = new ahu[0];
    protected static final aif[] NO_VALUE_INSTANTIATORS = new aif[0];
    private static final long serialVersionUID = 1;
    protected final agt[] _abstractTypeResolvers;
    protected final aia[] _additionalDeserializers;
    protected final aib[] _additionalKeyDeserializers;
    protected final ahu[] _modifiers;
    protected final aif[] _valueInstantiators;

    public DeserializerFactoryConfig() {
        this(null, null, null, null, null);
    }

    protected DeserializerFactoryConfig(aia[] com_fossil_aiaArr, aib[] com_fossil_aibArr, ahu[] com_fossil_ahuArr, agt[] com_fossil_agtArr, aif[] com_fossil_aifArr) {
        if (com_fossil_aiaArr == null) {
            com_fossil_aiaArr = NO_DESERIALIZERS;
        }
        this._additionalDeserializers = com_fossil_aiaArr;
        if (com_fossil_aibArr == null) {
            com_fossil_aibArr = DEFAULT_KEY_DESERIALIZERS;
        }
        this._additionalKeyDeserializers = com_fossil_aibArr;
        if (com_fossil_ahuArr == null) {
            com_fossil_ahuArr = NO_MODIFIERS;
        }
        this._modifiers = com_fossil_ahuArr;
        if (com_fossil_agtArr == null) {
            com_fossil_agtArr = NO_ABSTRACT_TYPE_RESOLVERS;
        }
        this._abstractTypeResolvers = com_fossil_agtArr;
        if (com_fossil_aifArr == null) {
            com_fossil_aifArr = NO_VALUE_INSTANTIATORS;
        }
        this._valueInstantiators = com_fossil_aifArr;
    }

    public DeserializerFactoryConfig withAdditionalDeserializers(aia com_fossil_aia) {
        if (com_fossil_aia != null) {
            return new DeserializerFactoryConfig((aia[]) amd.m3837a(this._additionalDeserializers, (Object) com_fossil_aia), this._additionalKeyDeserializers, this._modifiers, this._abstractTypeResolvers, this._valueInstantiators);
        }
        throw new IllegalArgumentException("Can not pass null Deserializers");
    }

    public DeserializerFactoryConfig withAdditionalKeyDeserializers(aib com_fossil_aib) {
        if (com_fossil_aib == null) {
            throw new IllegalArgumentException("Can not pass null KeyDeserializers");
        }
        return new DeserializerFactoryConfig(this._additionalDeserializers, (aib[]) amd.m3837a(this._additionalKeyDeserializers, (Object) com_fossil_aib), this._modifiers, this._abstractTypeResolvers, this._valueInstantiators);
    }

    public DeserializerFactoryConfig withDeserializerModifier(ahu com_fossil_ahu) {
        if (com_fossil_ahu == null) {
            throw new IllegalArgumentException("Can not pass null modifier");
        }
        return new DeserializerFactoryConfig(this._additionalDeserializers, this._additionalKeyDeserializers, (ahu[]) amd.m3837a(this._modifiers, (Object) com_fossil_ahu), this._abstractTypeResolvers, this._valueInstantiators);
    }

    public DeserializerFactoryConfig withAbstractTypeResolver(agt com_fossil_agt) {
        if (com_fossil_agt == null) {
            throw new IllegalArgumentException("Can not pass null resolver");
        }
        return new DeserializerFactoryConfig(this._additionalDeserializers, this._additionalKeyDeserializers, this._modifiers, (agt[]) amd.m3837a(this._abstractTypeResolvers, (Object) com_fossil_agt), this._valueInstantiators);
    }

    public DeserializerFactoryConfig withValueInstantiators(aif com_fossil_aif) {
        if (com_fossil_aif == null) {
            throw new IllegalArgumentException("Can not pass null resolver");
        }
        return new DeserializerFactoryConfig(this._additionalDeserializers, this._additionalKeyDeserializers, this._modifiers, this._abstractTypeResolvers, (aif[]) amd.m3837a(this._valueInstantiators, (Object) com_fossil_aif));
    }

    public boolean hasDeserializers() {
        return this._additionalDeserializers.length > 0;
    }

    public boolean hasKeyDeserializers() {
        return this._additionalKeyDeserializers.length > 0;
    }

    public boolean hasDeserializerModifiers() {
        return this._modifiers.length > 0;
    }

    public boolean hasAbstractTypeResolvers() {
        return this._abstractTypeResolvers.length > 0;
    }

    public boolean hasValueInstantiators() {
        return this._valueInstantiators.length > 0;
    }

    public Iterable<aia> deserializers() {
        return new ame(this._additionalDeserializers);
    }

    public Iterable<aib> keyDeserializers() {
        return new ame(this._additionalKeyDeserializers);
    }

    public Iterable<ahu> deserializerModifiers() {
        return new ame(this._modifiers);
    }

    public Iterable<agt> abstractTypeResolvers() {
        return new ame(this._abstractTypeResolvers);
    }

    public Iterable<aif> valueInstantiators() {
        return new ame(this._valueInstantiators);
    }
}
