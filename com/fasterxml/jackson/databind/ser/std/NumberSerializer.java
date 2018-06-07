package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fossil.agz;
import com.fossil.ahg;
import com.fossil.ahh;
import com.fossil.ajg;
import com.fossil.ajh;
import com.fossil.ajk;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;

@ahh
public class NumberSerializer extends StdScalarSerializer<Number> {
    public static final NumberSerializer instance = new NumberSerializer(Number.class);
    protected final boolean _isInt;

    @Deprecated
    public NumberSerializer() {
        super(Number.class);
        this._isInt = false;
    }

    public NumberSerializer(Class<? extends Number> cls) {
        boolean z = false;
        super(cls, false);
        if (cls == BigInteger.class) {
            z = true;
        }
        this._isInt = z;
    }

    public void serialize(Number number, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        if (number instanceof BigDecimal) {
            jsonGenerator.mo937a((BigDecimal) number);
        } else if (number instanceof BigInteger) {
            jsonGenerator.mo938a((BigInteger) number);
        } else if (number instanceof Integer) {
            jsonGenerator.fl(number.intValue());
        } else if (number instanceof Long) {
            jsonGenerator.mo933J(number.longValue());
        } else if (number instanceof Double) {
            jsonGenerator.mo945d(number.doubleValue());
        } else if (number instanceof Float) {
            jsonGenerator.mo934T(number.floatValue());
        } else if ((number instanceof Byte) || (number instanceof Short)) {
            jsonGenerator.fl(number.intValue());
        } else {
            jsonGenerator.aT(number.toString());
        }
    }

    public agz getSchema(ahg com_fossil_ahg, Type type) {
        return createSchemaNode(this._isInt ? "integer" : "number", true);
    }

    public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
        if (this._isInt) {
            ajh h = com_fossil_ajg.mo1020h(javaType);
            if (h != null) {
                h.m3556a(NumberType.BIG_INTEGER);
                return;
            }
            return;
        }
        ajk g = com_fossil_ajg.mo1019g(javaType);
        if (g != null && handledType() == BigDecimal.class) {
            g.m3559a(NumberType.BIG_DECIMAL);
        }
    }
}
