package com.fossil;

import com.fasterxml.jackson.annotation.JsonFormat.C1501b;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import com.fossil.alt.C1678d;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;

@ahh
public class ald extends alk implements agv {
    public static final Object aUh = Include.NON_EMPTY;
    protected static final C1501b aUi = new C1501b();
    protected final Method _accessorMethod;
    protected final amc _contextAnnotations;
    protected transient alt _dynamicSerializers;
    protected final Field _field;
    protected final PropertyMetadata _metadata;
    protected ahb<Object> _serializer;
    protected final Object _suppressableValue;
    protected final PropertyName _wrapperName;
    protected final AnnotatedMember aQg;
    protected ajv aQx;
    protected final JavaType aUj;
    protected HashMap<Object, Object> aUk;
    protected final SerializedString aUl;
    protected final JavaType aUm;
    protected JavaType aUn;
    protected transient C1501b aUo;
    protected ahb<Object> aUp;
    protected final boolean aUq;
    protected final Class<?>[] aUr;

    public ald(aiv com_fossil_aiv, AnnotatedMember annotatedMember, amc com_fossil_amc, JavaType javaType, ahb<?> com_fossil_ahb_, ajv com_fossil_ajv, JavaType javaType2, boolean z, Object obj) {
        this.aQg = annotatedMember;
        this._contextAnnotations = com_fossil_amc;
        this.aUl = new SerializedString(com_fossil_aiv.getName());
        this._wrapperName = com_fossil_aiv.getWrapperName();
        this._metadata = com_fossil_aiv.getMetadata();
        this.aUr = com_fossil_aiv.Ft();
        this.aUj = javaType;
        this._serializer = com_fossil_ahb_;
        this._dynamicSerializers = com_fossil_ahb_ == null ? alt.GM() : null;
        this.aQx = com_fossil_ajv;
        this.aUm = javaType2;
        if (annotatedMember instanceof AnnotatedField) {
            this._accessorMethod = null;
            this._field = (Field) annotatedMember.getMember();
        } else if (annotatedMember instanceof AnnotatedMethod) {
            this._accessorMethod = (Method) annotatedMember.getMember();
            this._field = null;
        } else {
            this._accessorMethod = null;
            this._field = null;
        }
        this.aUq = z;
        this._suppressableValue = obj;
        this.aUp = null;
    }

    protected ald() {
        this.aQg = null;
        this._contextAnnotations = null;
        this.aUl = null;
        this._wrapperName = null;
        this._metadata = null;
        this.aUr = null;
        this.aUj = null;
        this._serializer = null;
        this._dynamicSerializers = null;
        this.aQx = null;
        this.aUm = null;
        this._accessorMethod = null;
        this._field = null;
        this.aUq = false;
        this._suppressableValue = null;
        this.aUp = null;
    }

    protected ald(ald com_fossil_ald) {
        this(com_fossil_ald, com_fossil_ald.aUl);
    }

    protected ald(ald com_fossil_ald, PropertyName propertyName) {
        this.aUl = new SerializedString(propertyName.getSimpleName());
        this._wrapperName = com_fossil_ald._wrapperName;
        this.aQg = com_fossil_ald.aQg;
        this._contextAnnotations = com_fossil_ald._contextAnnotations;
        this.aUj = com_fossil_ald.aUj;
        this._accessorMethod = com_fossil_ald._accessorMethod;
        this._field = com_fossil_ald._field;
        this._serializer = com_fossil_ald._serializer;
        this.aUp = com_fossil_ald.aUp;
        if (com_fossil_ald.aUk != null) {
            this.aUk = new HashMap(com_fossil_ald.aUk);
        }
        this.aUm = com_fossil_ald.aUm;
        this._dynamicSerializers = com_fossil_ald._dynamicSerializers;
        this.aUq = com_fossil_ald.aUq;
        this._suppressableValue = com_fossil_ald._suppressableValue;
        this.aUr = com_fossil_ald.aUr;
        this.aQx = com_fossil_ald.aQx;
        this.aUn = com_fossil_ald.aUn;
        this._metadata = com_fossil_ald._metadata;
    }

    protected ald(ald com_fossil_ald, SerializedString serializedString) {
        this.aUl = serializedString;
        this._wrapperName = com_fossil_ald._wrapperName;
        this.aQg = com_fossil_ald.aQg;
        this._contextAnnotations = com_fossil_ald._contextAnnotations;
        this.aUj = com_fossil_ald.aUj;
        this._accessorMethod = com_fossil_ald._accessorMethod;
        this._field = com_fossil_ald._field;
        this._serializer = com_fossil_ald._serializer;
        this.aUp = com_fossil_ald.aUp;
        if (com_fossil_ald.aUk != null) {
            this.aUk = new HashMap(com_fossil_ald.aUk);
        }
        this.aUm = com_fossil_ald.aUm;
        this._dynamicSerializers = com_fossil_ald._dynamicSerializers;
        this.aUq = com_fossil_ald.aUq;
        this._suppressableValue = com_fossil_ald._suppressableValue;
        this.aUr = com_fossil_ald.aUr;
        this.aQx = com_fossil_ald.aQx;
        this.aUn = com_fossil_ald.aUn;
        this._metadata = com_fossil_ald._metadata;
    }

    public ald mo1082b(amo com_fossil_amo) {
        String cc = com_fossil_amo.cc(this.aUl.getValue());
        return cc.equals(this.aUl.toString()) ? this : m3701e(PropertyName.construct(cc));
    }

    protected ald m3701e(PropertyName propertyName) {
        return new ald(this, propertyName);
    }

    public void m3691a(ajv com_fossil_ajv) {
        this.aQx = com_fossil_ajv;
    }

    public void mo1081a(ahb<Object> com_fossil_ahb_java_lang_Object) {
        if (this._serializer == null || this._serializer == com_fossil_ahb_java_lang_Object) {
            this._serializer = com_fossil_ahb_java_lang_Object;
            return;
        }
        throw new IllegalStateException("Can not override serializer");
    }

    public void mo1083b(ahb<Object> com_fossil_ahb_java_lang_Object) {
        if (this.aUp == null || this.aUp == com_fossil_ahb_java_lang_Object) {
            this.aUp = com_fossil_ahb_java_lang_Object;
            return;
        }
        throw new IllegalStateException("Can not override null serializer");
    }

    public ald m3698c(amo com_fossil_amo) {
        return new alw(this, com_fossil_amo);
    }

    public void m3704n(JavaType javaType) {
        this.aUn = javaType;
    }

    public String getName() {
        return this.aUl.getValue();
    }

    public JavaType getType() {
        return this.aUj;
    }

    public boolean isRequired() {
        return this._metadata.isRequired();
    }

    public C1501b findFormatOverrides(AnnotationIntrospector annotationIntrospector) {
        C1501b c1501b = this.aUo;
        if (c1501b == null) {
            C1501b c1501b2;
            c1501b = (annotationIntrospector == null || this.aQg == null) ? null : annotationIntrospector.findFormat(this.aQg);
            if (c1501b == null) {
                c1501b2 = aUi;
            } else {
                c1501b2 = c1501b;
            }
            this.aUo = c1501b2;
        }
        return c1501b == aUi ? null : c1501b;
    }

    public AnnotatedMember getMember() {
        return this.aQg;
    }

    protected void mo1087a(akv com_fossil_akv, agz com_fossil_agz) {
        com_fossil_akv.m3669a(getName(), com_fossil_agz);
    }

    public boolean hasSerializer() {
        return this._serializer != null;
    }

    public boolean Gv() {
        return this.aUp != null;
    }

    public ajv getTypeSerializer() {
        return this.aQx;
    }

    public boolean Gw() {
        return this.aUq;
    }

    public boolean m3703f(PropertyName propertyName) {
        if (this._wrapperName != null) {
            return this._wrapperName.equals(propertyName);
        }
        return propertyName.hasSimpleName(this.aUl.getValue()) && !propertyName.hasNamespace();
    }

    public ahb<Object> Gx() {
        return this._serializer;
    }

    public JavaType Gy() {
        return this.aUm;
    }

    public Class<?> Gz() {
        return this._accessorMethod != null ? this._accessorMethod.getReturnType() : this._field.getType();
    }

    public Type GA() {
        if (this._accessorMethod != null) {
            return this._accessorMethod.getGenericReturnType();
        }
        if (this._field != null) {
            return this._field.getGenericType();
        }
        return null;
    }

    public Class<?>[] GB() {
        return this.aUr;
    }

    public void mo1072b(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws Exception {
        Object obj2;
        if (this._accessorMethod == null) {
            obj2 = this._field.get(obj);
        } else {
            obj2 = this._accessorMethod.invoke(obj, new Object[0]);
        }
        if (obj2 != null) {
            ahb com_fossil_ahb = this._serializer;
            if (com_fossil_ahb == null) {
                Class cls = obj2.getClass();
                alt com_fossil_alt = this._dynamicSerializers;
                com_fossil_ahb = com_fossil_alt.mo1085o(cls);
                if (com_fossil_ahb == null) {
                    com_fossil_ahb = _findAndAddDynamic(com_fossil_alt, cls, com_fossil_ahg);
                }
            }
            if (this._suppressableValue != null) {
                if (aUh == this._suppressableValue) {
                    if (com_fossil_ahb.isEmpty(com_fossil_ahg, obj2)) {
                        return;
                    }
                } else if (this._suppressableValue.equals(obj2)) {
                    return;
                }
            }
            if (obj2 != obj || !m3694a(obj, jsonGenerator, com_fossil_ahg, com_fossil_ahb)) {
                jsonGenerator.mo850b(this.aUl);
                if (this.aQx == null) {
                    com_fossil_ahb.serialize(obj2, jsonGenerator, com_fossil_ahg);
                } else {
                    com_fossil_ahb.serializeWithType(obj2, jsonGenerator, com_fossil_ahg, this.aQx);
                }
            }
        } else if (this.aUp != null) {
            jsonGenerator.mo850b(this.aUl);
            this.aUp.serialize(null, jsonGenerator, com_fossil_ahg);
        }
    }

    public void mo1073c(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws Exception {
        if (!jsonGenerator.zG()) {
            jsonGenerator.aW(this.aUl.getValue());
        }
    }

    public void mo1074d(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws Exception {
        Object invoke = this._accessorMethod == null ? this._field.get(obj) : this._accessorMethod.invoke(obj, new Object[0]);
        if (invoke != null) {
            ahb com_fossil_ahb = this._serializer;
            if (com_fossil_ahb == null) {
                Class cls = invoke.getClass();
                alt com_fossil_alt = this._dynamicSerializers;
                com_fossil_ahb = com_fossil_alt.mo1085o(cls);
                if (com_fossil_ahb == null) {
                    com_fossil_ahb = _findAndAddDynamic(com_fossil_alt, cls, com_fossil_ahg);
                }
            }
            if (this._suppressableValue != null) {
                if (aUh == this._suppressableValue) {
                    if (com_fossil_ahb.isEmpty(com_fossil_ahg, invoke)) {
                        m3702e(obj, jsonGenerator, com_fossil_ahg);
                        return;
                    }
                } else if (this._suppressableValue.equals(invoke)) {
                    m3702e(obj, jsonGenerator, com_fossil_ahg);
                    return;
                }
            }
            if (invoke != obj || !m3694a(obj, jsonGenerator, com_fossil_ahg, com_fossil_ahb)) {
                if (this.aQx == null) {
                    com_fossil_ahb.serialize(invoke, jsonGenerator, com_fossil_ahg);
                } else {
                    com_fossil_ahb.serializeWithType(invoke, jsonGenerator, com_fossil_ahg, this.aQx);
                }
            }
        } else if (this.aUp != null) {
            this.aUp.serialize(null, jsonGenerator, com_fossil_ahg);
        } else {
            jsonGenerator.zL();
        }
    }

    public void m3702e(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws Exception {
        if (this.aUp != null) {
            this.aUp.serialize(null, jsonGenerator, com_fossil_ahg);
        } else {
            jsonGenerator.zL();
        }
    }

    public void depositSchemaProperty(ajl com_fossil_ajl) throws JsonMappingException {
        if (com_fossil_ajl == null) {
            return;
        }
        if (isRequired()) {
            com_fossil_ajl.m3560a(this);
        } else {
            com_fossil_ajl.m3561b(this);
        }
    }

    @Deprecated
    public void mo1071a(akv com_fossil_akv, ahg com_fossil_ahg) throws JsonMappingException {
        agz schema;
        JavaType Gy = Gy();
        if (Gy == null) {
            Type GA = GA();
        } else {
            Object rawClass = Gy.getRawClass();
        }
        ahb Gx = Gx();
        if (Gx == null) {
            Gx = com_fossil_ahg.findValueSerializer(getType(), (agv) this);
        }
        boolean z = !isRequired();
        if (Gx instanceof ajq) {
            schema = ((ajq) Gx).getSchema(com_fossil_ahg, GA, z);
        } else {
            schema = ajo.Ge();
        }
        mo1087a(com_fossil_akv, schema);
    }

    protected ahb<Object> _findAndAddDynamic(alt com_fossil_alt, Class<?> cls, ahg com_fossil_ahg) throws JsonMappingException {
        C1678d a;
        if (this.aUn != null) {
            a = com_fossil_alt.m3768a(com_fossil_ahg.constructSpecializedType(this.aUn, cls), com_fossil_ahg, (agv) this);
        } else {
            a = com_fossil_alt.m3769a((Class) cls, com_fossil_ahg, (agv) this);
        }
        if (com_fossil_alt != a.aUN) {
            this._dynamicSerializers = a.aUN;
        }
        return a.aUD;
    }

    public final Object get(Object obj) throws Exception {
        return this._accessorMethod == null ? this._field.get(obj) : this._accessorMethod.invoke(obj, new Object[0]);
    }

    protected boolean m3694a(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ahb<?> com_fossil_ahb_) throws JsonMappingException {
        if (!com_fossil_ahg.isEnabled(SerializationFeature.FAIL_ON_SELF_REFERENCES) || com_fossil_ahb_.usesObjectId() || !(com_fossil_ahb_ instanceof BeanSerializerBase)) {
            return false;
        }
        throw new JsonMappingException("Direct self-reference leading to cycle");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(40);
        stringBuilder.append("property '").append(getName()).append("' (");
        if (this._accessorMethod != null) {
            stringBuilder.append("via method ").append(this._accessorMethod.getDeclaringClass().getName()).append("#").append(this._accessorMethod.getName());
        } else if (this._field != null) {
            stringBuilder.append("field \"").append(this._field.getDeclaringClass().getName()).append("#").append(this._field.getName());
        } else {
            stringBuilder.append("virtual");
        }
        if (this._serializer == null) {
            stringBuilder.append(", no static serializer");
        } else {
            stringBuilder.append(", static serializer of type " + this._serializer.getClass().getName());
        }
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
