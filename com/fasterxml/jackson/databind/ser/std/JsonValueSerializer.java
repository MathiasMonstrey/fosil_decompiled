package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fossil.agv;
import com.fossil.agz;
import com.fossil.ahb;
import com.fossil.ahg;
import com.fossil.ahh;
import com.fossil.aje;
import com.fossil.ajg;
import com.fossil.ajm;
import com.fossil.ajo;
import com.fossil.ajq;
import com.fossil.ajv;
import com.fossil.alg;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.LinkedHashSet;
import java.util.Set;

@ahh
public class JsonValueSerializer extends StdSerializer<Object> implements aje, ajq, alg {
    protected final Method _accessorMethod;
    protected final boolean _forceTypeInformation;
    protected final agv _property;
    protected final ahb<Object> _valueSerializer;

    public JsonValueSerializer(Method method, ahb<?> com_fossil_ahb_) {
        super(method.getReturnType(), false);
        this._accessorMethod = method;
        this._valueSerializer = com_fossil_ahb_;
        this._property = null;
        this._forceTypeInformation = true;
    }

    public JsonValueSerializer(JsonValueSerializer jsonValueSerializer, agv com_fossil_agv, ahb<?> com_fossil_ahb_, boolean z) {
        super(m2755r(jsonValueSerializer.handledType()));
        this._accessorMethod = jsonValueSerializer._accessorMethod;
        this._valueSerializer = com_fossil_ahb_;
        this._property = com_fossil_agv;
        this._forceTypeInformation = z;
    }

    private static final Class<Object> m2755r(Class<?> cls) {
        return cls == null ? Object.class : cls;
    }

    public JsonValueSerializer withResolved(agv com_fossil_agv, ahb<?> com_fossil_ahb_, boolean z) {
        return (this._property == com_fossil_agv && this._valueSerializer == com_fossil_ahb_ && z == this._forceTypeInformation) ? this : new JsonValueSerializer(this, com_fossil_agv, com_fossil_ahb_, z);
    }

    public ahb<?> createContextual(ahg com_fossil_ahg, agv com_fossil_agv) throws JsonMappingException {
        ahb com_fossil_ahb = this._valueSerializer;
        if (com_fossil_ahb != null) {
            return withResolved(com_fossil_agv, com_fossil_ahg.handlePrimaryContextualization(com_fossil_ahb, com_fossil_agv), this._forceTypeInformation);
        }
        if (!com_fossil_ahg.isEnabled(MapperFeature.USE_STATIC_TYPING) && !Modifier.isFinal(this._accessorMethod.getReturnType().getModifiers())) {
            return this;
        }
        JavaType constructType = com_fossil_ahg.constructType(this._accessorMethod.getGenericReturnType());
        ahb findPrimaryPropertySerializer = com_fossil_ahg.findPrimaryPropertySerializer(constructType, com_fossil_agv);
        return withResolved(com_fossil_agv, findPrimaryPropertySerializer, isNaturalTypeWithStdHandling(constructType.getRawClass(), findPrimaryPropertySerializer));
    }

    public void serialize(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        try {
            Object invoke = this._accessorMethod.invoke(obj, new Object[0]);
            if (invoke == null) {
                com_fossil_ahg.defaultSerializeNull(jsonGenerator);
                return;
            }
            ahb com_fossil_ahb = this._valueSerializer;
            if (com_fossil_ahb == null) {
                com_fossil_ahb = com_fossil_ahg.findTypedValueSerializer(invoke.getClass(), true, this._property);
            }
            com_fossil_ahb.serialize(invoke, jsonGenerator, com_fossil_ahg);
        } catch (IOException e) {
            throw e;
        } catch (Exception e2) {
            Throwable e3 = e2;
            while ((e3 instanceof InvocationTargetException) && e3.getCause() != null) {
                e3 = e3.getCause();
            }
            if (e3 instanceof Error) {
                throw ((Error) e3);
            }
            throw JsonMappingException.wrapWithPath(e3, obj, this._accessorMethod.getName() + "()");
        }
    }

    public void serializeWithType(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ajv com_fossil_ajv) throws IOException {
        try {
            Object invoke = this._accessorMethod.invoke(obj, new Object[0]);
            if (invoke == null) {
                com_fossil_ahg.defaultSerializeNull(jsonGenerator);
                return;
            }
            ahb com_fossil_ahb = this._valueSerializer;
            if (com_fossil_ahb == null) {
                com_fossil_ahb = com_fossil_ahg.findValueSerializer(invoke.getClass(), this._property);
            } else if (this._forceTypeInformation) {
                com_fossil_ajv.mo1026a(obj, jsonGenerator);
                com_fossil_ahb.serialize(invoke, jsonGenerator, com_fossil_ahg);
                com_fossil_ajv.mo1034d(obj, jsonGenerator);
                return;
            }
            com_fossil_ahb.serializeWithType(invoke, jsonGenerator, com_fossil_ahg, com_fossil_ajv);
        } catch (IOException e) {
            throw e;
        } catch (Exception e2) {
            Throwable e3 = e2;
            while ((e3 instanceof InvocationTargetException) && e3.getCause() != null) {
                e3 = e3.getCause();
            }
            if (e3 instanceof Error) {
                throw ((Error) e3);
            }
            throw JsonMappingException.wrapWithPath(e3, obj, this._accessorMethod.getName() + "()");
        }
    }

    public agz getSchema(ahg com_fossil_ahg, Type type) throws JsonMappingException {
        if (this._valueSerializer instanceof ajq) {
            return ((ajq) this._valueSerializer).getSchema(com_fossil_ahg, null);
        }
        return ajo.Ge();
    }

    public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
        Class rawClass = javaType == null ? null : javaType.getRawClass();
        if (rawClass == null) {
            rawClass = this._accessorMethod.getDeclaringClass();
        }
        if (rawClass == null || !rawClass.isEnum() || !_acceptJsonFormatVisitorForEnum(com_fossil_ajg, javaType, rawClass)) {
            ahb com_fossil_ahb = this._valueSerializer;
            if (com_fossil_ahb == null) {
                if (javaType == null) {
                    if (this._property != null) {
                        javaType = this._property.getType();
                    }
                    if (javaType == null) {
                        javaType = com_fossil_ajg.Gd().constructType(this._handledType);
                    }
                }
                com_fossil_ahb = com_fossil_ajg.Gd().findTypedValueSerializer(javaType, false, this._property);
                if (com_fossil_ahb == null) {
                    com_fossil_ajg.mo1023k(javaType);
                    return;
                }
            }
            com_fossil_ahb.acceptJsonFormatVisitor(com_fossil_ajg, null);
        }
    }

    protected boolean _acceptJsonFormatVisitorForEnum(ajg com_fossil_ajg, JavaType javaType, Class<?> cls) throws JsonMappingException {
        int i = 0;
        ajm f = com_fossil_ajg.mo1018f(javaType);
        if (f != null) {
            Set linkedHashSet = new LinkedHashSet();
            Object[] enumConstants = cls.getEnumConstants();
            int length = enumConstants.length;
            while (i < length) {
                Object obj = enumConstants[i];
                try {
                    linkedHashSet.add(String.valueOf(this._accessorMethod.invoke(obj, new Object[0])));
                    i++;
                } catch (Exception e) {
                    Throwable e2 = e;
                    while ((e2 instanceof InvocationTargetException) && e2.getCause() != null) {
                        e2 = e2.getCause();
                    }
                    if (e2 instanceof Error) {
                        throw ((Error) e2);
                    }
                    throw JsonMappingException.wrapWithPath(e2, obj, this._accessorMethod.getName() + "()");
                }
            }
            f.m3536e(linkedHashSet);
        }
        return true;
    }

    protected boolean isNaturalTypeWithStdHandling(Class<?> cls, ahb<?> com_fossil_ahb_) {
        if (cls.isPrimitive()) {
            if (!(cls == Integer.TYPE || cls == Boolean.TYPE || cls == Double.TYPE)) {
                return false;
            }
        } else if (!(cls == String.class || cls == Integer.class || cls == Boolean.class || cls == Double.class)) {
            return false;
        }
        return isDefaultSerializer(com_fossil_ahb_);
    }

    public String toString() {
        return "(@JsonValue serializer for method " + this._accessorMethod.getDeclaringClass() + "#" + this._accessorMethod.getName() + ")";
    }
}
