package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat.C1501b;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fossil.afc;
import com.fossil.agu;
import com.fossil.agv;
import com.fossil.agz;
import com.fossil.ahb;
import com.fossil.ahg;
import com.fossil.ahh;
import com.fossil.ajg;
import com.fossil.ajh;
import com.fossil.ajm;
import com.fossil.akh;
import com.fossil.alg;
import com.fossil.amm;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.LinkedHashSet;
import java.util.Set;

@ahh
public class EnumSerializer extends StdScalarSerializer<Enum<?>> implements alg {
    private static final long serialVersionUID = 1;
    protected final Boolean _serializeAsIndex;
    protected final amm _values;

    @Deprecated
    public EnumSerializer(amm com_fossil_amm) {
        this(com_fossil_amm, null);
    }

    public EnumSerializer(amm com_fossil_amm, Boolean bool) {
        super(com_fossil_amm.getEnumClass(), false);
        this._values = com_fossil_amm;
        this._serializeAsIndex = bool;
    }

    public static EnumSerializer construct(Class<?> cls, SerializationConfig serializationConfig, agu com_fossil_agu, C1501b c1501b) {
        return new EnumSerializer(amm.m3880b(serializationConfig, cls), _isShapeWrittenUsingIndex(cls, c1501b, true));
    }

    public ahb<?> createContextual(ahg com_fossil_ahg, agv com_fossil_agv) throws JsonMappingException {
        if (com_fossil_agv == null) {
            return this;
        }
        C1501b findFormat = com_fossil_ahg.getAnnotationIntrospector().findFormat(com_fossil_agv.getMember());
        if (findFormat == null) {
            return this;
        }
        Boolean _isShapeWrittenUsingIndex = _isShapeWrittenUsingIndex(com_fossil_agv.getType().getRawClass(), findFormat, false);
        if (_isShapeWrittenUsingIndex != this._serializeAsIndex) {
            return new EnumSerializer(this._values, _isShapeWrittenUsingIndex);
        }
        return this;
    }

    public amm getEnumValues() {
        return this._values;
    }

    public final void serialize(Enum<?> enumR, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        if (_serializeAsIndex(com_fossil_ahg)) {
            jsonGenerator.fl(enumR.ordinal());
        } else if (com_fossil_ahg.isEnabled(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)) {
            jsonGenerator.writeString(enumR.toString());
        } else {
            jsonGenerator.mo852c(this._values.m3881b(enumR));
        }
    }

    public agz getSchema(ahg com_fossil_ahg, Type type) {
        if (_serializeAsIndex(com_fossil_ahg)) {
            return createSchemaNode("integer", true);
        }
        agz createSchemaNode = createSchemaNode("string", true);
        if (type != null && com_fossil_ahg.constructType(type).isEnumType()) {
            akh bW = createSchemaNode.bW("enum");
            for (afc value : this._values.values()) {
                bW.bV(value.getValue());
            }
        }
        return createSchemaNode;
    }

    public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
        ahg Gd = com_fossil_ajg.Gd();
        if (_serializeAsIndex(Gd)) {
            ajh h = com_fossil_ajg.mo1020h(javaType);
            if (h != null) {
                h.m3556a(NumberType.INT);
                return;
            }
            return;
        }
        ajm f = com_fossil_ajg.mo1018f(javaType);
        if (f != null) {
            Set linkedHashSet = new LinkedHashSet();
            if (Gd == null || !Gd.isEnabled(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)) {
                for (afc value : this._values.values()) {
                    linkedHashSet.add(value.getValue());
                }
            } else {
                for (Enum enumR : this._values.Hl()) {
                    linkedHashSet.add(enumR.toString());
                }
            }
            f.m3536e(linkedHashSet);
        }
    }

    protected final boolean _serializeAsIndex(ahg com_fossil_ahg) {
        if (this._serializeAsIndex != null) {
            return this._serializeAsIndex.booleanValue();
        }
        return com_fossil_ahg.isEnabled(SerializationFeature.WRITE_ENUMS_USING_INDEX);
    }

    protected static Boolean _isShapeWrittenUsingIndex(Class<?> cls, C1501b c1501b, boolean z) {
        Shape yZ = c1501b == null ? null : c1501b.yZ();
        if (yZ == null || yZ == Shape.ANY || yZ == Shape.SCALAR) {
            return null;
        }
        if (yZ == Shape.STRING) {
            return Boolean.FALSE;
        }
        if (yZ.isNumeric() || yZ == Shape.ARRAY) {
            return Boolean.TRUE;
        }
        throw new IllegalArgumentException("Unsupported serialization shape (" + yZ + ") for Enum " + cls.getName() + ", not supported as " + (z ? "class" : "property") + " annotation");
    }
}
