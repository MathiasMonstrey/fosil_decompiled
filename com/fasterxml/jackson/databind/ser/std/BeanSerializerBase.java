package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat.C1501b;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonMappingException.Reference;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.impl.PropertyBasedObjectIdGenerator;
import com.fossil.agv;
import com.fossil.agz;
import com.fossil.ahb;
import com.fossil.ahg;
import com.fossil.aiq;
import com.fossil.aiy;
import com.fossil.aje;
import com.fossil.ajg;
import com.fossil.ajl;
import com.fossil.ajp;
import com.fossil.ajq;
import com.fossil.ajv;
import com.fossil.akv;
import com.fossil.alb;
import com.fossil.ald;
import com.fossil.ale;
import com.fossil.alg;
import com.fossil.alj;
import com.fossil.alk;
import com.fossil.all;
import com.fossil.als;
import com.fossil.alx;
import com.fossil.amd;
import com.fossil.amk;
import com.fossil.amo;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public abstract class BeanSerializerBase extends StdSerializer<Object> implements aje, ajq, alg, all {
    protected static final PropertyName NAME_FOR_OBJECT_REF = new PropertyName("#object-ref");
    protected static final ald[] NO_PROPS = new ald[0];
    protected final alb _anyGetterWriter;
    protected final ald[] _filteredProps;
    protected final als _objectIdWriter;
    protected final Object _propertyFilterId;
    protected final ald[] _props;
    protected final Shape _serializationShape;
    protected final AnnotatedMember _typeId;

    protected abstract BeanSerializerBase asArraySerializer();

    public abstract void serialize(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException;

    public abstract BeanSerializerBase withFilterId(Object obj);

    protected abstract BeanSerializerBase withIgnorals(String[] strArr);

    public abstract BeanSerializerBase withObjectIdWriter(als com_fossil_als);

    protected BeanSerializerBase(JavaType javaType, ale com_fossil_ale, ald[] com_fossil_aldArr, ald[] com_fossil_aldArr2) {
        Shape shape = null;
        super(javaType);
        this._props = com_fossil_aldArr;
        this._filteredProps = com_fossil_aldArr2;
        if (com_fossil_ale == null) {
            this._typeId = null;
            this._anyGetterWriter = null;
            this._propertyFilterId = null;
            this._objectIdWriter = null;
            this._serializationShape = null;
            return;
        }
        this._typeId = com_fossil_ale.GF();
        this._anyGetterWriter = com_fossil_ale.GD();
        this._propertyFilterId = com_fossil_ale.GE();
        this._objectIdWriter = com_fossil_ale.GG();
        C1501b a = com_fossil_ale.GC().mo978a(null);
        if (a != null) {
            shape = a.yZ();
        }
        this._serializationShape = shape;
    }

    public BeanSerializerBase(BeanSerializerBase beanSerializerBase, ald[] com_fossil_aldArr, ald[] com_fossil_aldArr2) {
        super(beanSerializerBase._handledType);
        this._props = com_fossil_aldArr;
        this._filteredProps = com_fossil_aldArr2;
        this._typeId = beanSerializerBase._typeId;
        this._anyGetterWriter = beanSerializerBase._anyGetterWriter;
        this._objectIdWriter = beanSerializerBase._objectIdWriter;
        this._propertyFilterId = beanSerializerBase._propertyFilterId;
        this._serializationShape = beanSerializerBase._serializationShape;
    }

    protected BeanSerializerBase(BeanSerializerBase beanSerializerBase, als com_fossil_als) {
        this(beanSerializerBase, com_fossil_als, beanSerializerBase._propertyFilterId);
    }

    protected BeanSerializerBase(BeanSerializerBase beanSerializerBase, als com_fossil_als, Object obj) {
        super(beanSerializerBase._handledType);
        this._props = beanSerializerBase._props;
        this._filteredProps = beanSerializerBase._filteredProps;
        this._typeId = beanSerializerBase._typeId;
        this._anyGetterWriter = beanSerializerBase._anyGetterWriter;
        this._objectIdWriter = com_fossil_als;
        this._propertyFilterId = obj;
        this._serializationShape = beanSerializerBase._serializationShape;
    }

    protected BeanSerializerBase(BeanSerializerBase beanSerializerBase, String[] strArr) {
        ald[] com_fossil_aldArr = null;
        super(beanSerializerBase._handledType);
        HashSet b = amd.m3838b(strArr);
        ald[] com_fossil_aldArr2 = beanSerializerBase._props;
        ald[] com_fossil_aldArr3 = beanSerializerBase._filteredProps;
        int length = com_fossil_aldArr2.length;
        ArrayList arrayList = new ArrayList(length);
        ArrayList arrayList2 = com_fossil_aldArr3 == null ? null : new ArrayList(length);
        for (int i = 0; i < length; i++) {
            ald com_fossil_ald = com_fossil_aldArr2[i];
            if (!b.contains(com_fossil_ald.getName())) {
                arrayList.add(com_fossil_ald);
                if (com_fossil_aldArr3 != null) {
                    arrayList2.add(com_fossil_aldArr3[i]);
                }
            }
        }
        this._props = (ald[]) arrayList.toArray(new ald[arrayList.size()]);
        if (arrayList2 != null) {
            com_fossil_aldArr = (ald[]) arrayList2.toArray(new ald[arrayList2.size()]);
        }
        this._filteredProps = com_fossil_aldArr;
        this._typeId = beanSerializerBase._typeId;
        this._anyGetterWriter = beanSerializerBase._anyGetterWriter;
        this._objectIdWriter = beanSerializerBase._objectIdWriter;
        this._propertyFilterId = beanSerializerBase._propertyFilterId;
        this._serializationShape = beanSerializerBase._serializationShape;
    }

    protected BeanSerializerBase(BeanSerializerBase beanSerializerBase) {
        this(beanSerializerBase, beanSerializerBase._props, beanSerializerBase._filteredProps);
    }

    protected BeanSerializerBase(BeanSerializerBase beanSerializerBase, amo com_fossil_amo) {
        this(beanSerializerBase, m2747a(beanSerializerBase._props, com_fossil_amo), m2747a(beanSerializerBase._filteredProps, com_fossil_amo));
    }

    private static final ald[] m2747a(ald[] com_fossil_aldArr, amo com_fossil_amo) {
        if (com_fossil_aldArr == null || com_fossil_aldArr.length == 0 || com_fossil_amo == null || com_fossil_amo == amo.aVN) {
            return com_fossil_aldArr;
        }
        int length = com_fossil_aldArr.length;
        ald[] com_fossil_aldArr2 = new ald[length];
        for (int i = 0; i < length; i++) {
            ald com_fossil_ald = com_fossil_aldArr[i];
            if (com_fossil_ald != null) {
                com_fossil_aldArr2[i] = com_fossil_ald.mo1082b(com_fossil_amo);
            }
        }
        return com_fossil_aldArr2;
    }

    public void resolve(ahg com_fossil_ahg) throws JsonMappingException {
        int i;
        if (this._filteredProps == null) {
            i = 0;
        } else {
            i = this._filteredProps.length;
        }
        int length = this._props.length;
        for (int i2 = 0; i2 < length; i2++) {
            agv com_fossil_agv = this._props[i2];
            if (!(com_fossil_agv.Gw() || com_fossil_agv.Gv())) {
                ahb findNullValueSerializer = com_fossil_ahg.findNullValueSerializer(com_fossil_agv);
                if (findNullValueSerializer != null) {
                    com_fossil_agv.mo1083b(findNullValueSerializer);
                    if (i2 < i) {
                        ald com_fossil_ald = this._filteredProps[i2];
                        if (com_fossil_ald != null) {
                            com_fossil_ald.mo1083b(findNullValueSerializer);
                        }
                    }
                }
            }
            if (!com_fossil_agv.hasSerializer()) {
                ahb findConvertingSerializer = findConvertingSerializer(com_fossil_ahg, com_fossil_agv);
                if (findConvertingSerializer == null) {
                    JavaType Gy = com_fossil_agv.Gy();
                    if (Gy == null) {
                        Gy = com_fossil_ahg.constructType(com_fossil_agv.GA());
                        if (!Gy.isFinal()) {
                            if (Gy.isContainerType() || Gy.containedTypeCount() > 0) {
                                com_fossil_agv.m3704n(Gy);
                            }
                        }
                    }
                    findConvertingSerializer = com_fossil_ahg.findValueSerializer(Gy, com_fossil_agv);
                    if (Gy.isContainerType()) {
                        ajv com_fossil_ajv = (ajv) Gy.getContentType().getTypeHandler();
                        if (com_fossil_ajv != null && (findConvertingSerializer instanceof ContainerSerializer)) {
                            findConvertingSerializer = ((ContainerSerializer) findConvertingSerializer).withValueTypeSerializer(com_fossil_ajv);
                        }
                    }
                }
                com_fossil_agv.mo1081a(findConvertingSerializer);
                if (i2 < i) {
                    ald com_fossil_ald2 = this._filteredProps[i2];
                    if (com_fossil_ald2 != null) {
                        com_fossil_ald2.mo1081a(findConvertingSerializer);
                    }
                }
            }
        }
        if (this._anyGetterWriter != null) {
            this._anyGetterWriter.resolve(com_fossil_ahg);
        }
    }

    protected ahb<Object> findConvertingSerializer(ahg com_fossil_ahg, ald com_fossil_ald) throws JsonMappingException {
        ahb com_fossil_ahb = null;
        AnnotationIntrospector annotationIntrospector = com_fossil_ahg.getAnnotationIntrospector();
        if (annotationIntrospector == null) {
            return null;
        }
        aiq member = com_fossil_ald.getMember();
        if (member == null) {
            return null;
        }
        Object findSerializationConverter = annotationIntrospector.findSerializationConverter(member);
        if (findSerializationConverter == null) {
            return null;
        }
        amk converterInstance = com_fossil_ahg.converterInstance(com_fossil_ald.getMember(), findSerializationConverter);
        JavaType b = converterInstance.m3879b(com_fossil_ahg.getTypeFactory());
        if (!b.isJavaLangObject()) {
            com_fossil_ahb = com_fossil_ahg.findValueSerializer(b, (agv) com_fossil_ald);
        }
        return new StdDelegatingSerializer(converterInstance, b, com_fossil_ahb);
    }

    public ahb<?> createContextual(ahg com_fossil_ahg, agv com_fossil_agv) throws JsonMappingException {
        Shape shape;
        als com_fossil_als;
        String[] findPropertiesToIgnore;
        aiy findObjectIdInfo;
        Type Fz;
        JavaType javaType;
        String simpleName;
        int length;
        int i;
        ald com_fossil_ald;
        Object findFilterId;
        String[] strArr;
        ahb<?> withObjectIdWriter;
        ahb com_fossil_ahb;
        Object obj = null;
        AnnotationIntrospector annotationIntrospector = com_fossil_ahg.getAnnotationIntrospector();
        aiq member = (com_fossil_agv == null || annotationIntrospector == null) ? null : com_fossil_agv.getMember();
        SerializationConfig config = com_fossil_ahg.getConfig();
        if (member != null) {
            C1501b findFormat = annotationIntrospector.findFormat(member);
            if (findFormat != null) {
                Shape yZ = findFormat.yZ();
                if (yZ != this._serializationShape && this._handledType.isEnum()) {
                    switch (yZ) {
                        case STRING:
                        case NUMBER:
                        case NUMBER_INT:
                            return com_fossil_ahg.handlePrimaryContextualization(EnumSerializer.construct(this._handledType, com_fossil_ahg.getConfig(), config.introspectClassAnnotations(this._handledType), findFormat), com_fossil_agv);
                    }
                }
                shape = yZ;
                com_fossil_als = this._objectIdWriter;
                if (member == null) {
                    findPropertiesToIgnore = annotationIntrospector.findPropertiesToIgnore(member, true);
                    findObjectIdInfo = annotationIntrospector.findObjectIdInfo(member);
                    if (findObjectIdInfo == null) {
                        findObjectIdInfo = annotationIntrospector.findObjectReferenceInfo(member, findObjectIdInfo);
                        Fz = findObjectIdInfo.Fz();
                        javaType = com_fossil_ahg.getTypeFactory().findTypeParameters(com_fossil_ahg.constructType(Fz), ObjectIdGenerator.class)[0];
                        if (Fz != PropertyGenerator.class) {
                            simpleName = findObjectIdInfo.Fy().getSimpleName();
                            length = this._props.length;
                            i = 0;
                            while (i != length) {
                                com_fossil_ald = this._props[i];
                                if (simpleName.equals(com_fossil_ald.getName())) {
                                    i++;
                                } else {
                                    if (i > 0) {
                                        System.arraycopy(this._props, 0, this._props, 1, i);
                                        this._props[0] = com_fossil_ald;
                                        if (this._filteredProps != null) {
                                            ald com_fossil_ald2 = this._filteredProps[i];
                                            System.arraycopy(this._filteredProps, 0, this._filteredProps, 1, i);
                                            this._filteredProps[0] = com_fossil_ald2;
                                        }
                                    }
                                    com_fossil_als = als.m3765a(com_fossil_ald.getType(), (PropertyName) null, new PropertyBasedObjectIdGenerator(findObjectIdInfo, com_fossil_ald), findObjectIdInfo.FB());
                                }
                            }
                            throw new IllegalArgumentException("Invalid Object Id definition for " + this._handledType.getName() + ": can not find property with name '" + simpleName + "'");
                        }
                        com_fossil_als = als.m3765a(javaType, findObjectIdInfo.Fy(), com_fossil_ahg.objectIdGeneratorInstance(member, findObjectIdInfo), findObjectIdInfo.FB());
                    } else if (com_fossil_als != null) {
                        com_fossil_als = this._objectIdWriter.aO(annotationIntrospector.findObjectReferenceInfo(member, new aiy(NAME_FOR_OBJECT_REF, null, null, null)).FB());
                    }
                    findFilterId = annotationIntrospector.findFilterId(member);
                    if (findFilterId != null || (this._propertyFilterId != null && findFilterId.equals(this._propertyFilterId))) {
                        strArr = findPropertiesToIgnore;
                    } else {
                        obj = findFilterId;
                        strArr = findPropertiesToIgnore;
                    }
                } else {
                    strArr = null;
                }
                if (com_fossil_als != null) {
                    com_fossil_als = com_fossil_als.m3767c(com_fossil_ahg.findValueSerializer(com_fossil_als.aUB, com_fossil_agv));
                    if (com_fossil_als != this._objectIdWriter) {
                        withObjectIdWriter = withObjectIdWriter(com_fossil_als);
                        if (!(strArr == null || strArr.length == 0)) {
                            withObjectIdWriter = withObjectIdWriter.withIgnorals(strArr);
                        }
                        if (obj != null) {
                            withObjectIdWriter = withObjectIdWriter.withFilterId(obj);
                        }
                        if (shape == null) {
                            shape = this._serializationShape;
                        }
                        if (shape != Shape.ARRAY) {
                            return withObjectIdWriter.asArraySerializer();
                        }
                        return withObjectIdWriter;
                    }
                }
                com_fossil_ahb = this;
                withObjectIdWriter = withObjectIdWriter.withIgnorals(strArr);
                if (obj != null) {
                    withObjectIdWriter = withObjectIdWriter.withFilterId(obj);
                }
                if (shape == null) {
                    shape = this._serializationShape;
                }
                if (shape != Shape.ARRAY) {
                    return withObjectIdWriter;
                }
                return withObjectIdWriter.asArraySerializer();
            }
        }
        shape = null;
        com_fossil_als = this._objectIdWriter;
        if (member == null) {
            strArr = null;
        } else {
            findPropertiesToIgnore = annotationIntrospector.findPropertiesToIgnore(member, true);
            findObjectIdInfo = annotationIntrospector.findObjectIdInfo(member);
            if (findObjectIdInfo == null) {
                findObjectIdInfo = annotationIntrospector.findObjectReferenceInfo(member, findObjectIdInfo);
                Fz = findObjectIdInfo.Fz();
                javaType = com_fossil_ahg.getTypeFactory().findTypeParameters(com_fossil_ahg.constructType(Fz), ObjectIdGenerator.class)[0];
                if (Fz != PropertyGenerator.class) {
                    com_fossil_als = als.m3765a(javaType, findObjectIdInfo.Fy(), com_fossil_ahg.objectIdGeneratorInstance(member, findObjectIdInfo), findObjectIdInfo.FB());
                } else {
                    simpleName = findObjectIdInfo.Fy().getSimpleName();
                    length = this._props.length;
                    i = 0;
                    while (i != length) {
                        com_fossil_ald = this._props[i];
                        if (simpleName.equals(com_fossil_ald.getName())) {
                            i++;
                        } else {
                            if (i > 0) {
                                System.arraycopy(this._props, 0, this._props, 1, i);
                                this._props[0] = com_fossil_ald;
                                if (this._filteredProps != null) {
                                    ald com_fossil_ald22 = this._filteredProps[i];
                                    System.arraycopy(this._filteredProps, 0, this._filteredProps, 1, i);
                                    this._filteredProps[0] = com_fossil_ald22;
                                }
                            }
                            com_fossil_als = als.m3765a(com_fossil_ald.getType(), (PropertyName) null, new PropertyBasedObjectIdGenerator(findObjectIdInfo, com_fossil_ald), findObjectIdInfo.FB());
                        }
                    }
                    throw new IllegalArgumentException("Invalid Object Id definition for " + this._handledType.getName() + ": can not find property with name '" + simpleName + "'");
                }
            } else if (com_fossil_als != null) {
                com_fossil_als = this._objectIdWriter.aO(annotationIntrospector.findObjectReferenceInfo(member, new aiy(NAME_FOR_OBJECT_REF, null, null, null)).FB());
            }
            findFilterId = annotationIntrospector.findFilterId(member);
            if (findFilterId != null) {
            }
            strArr = findPropertiesToIgnore;
        }
        if (com_fossil_als != null) {
            com_fossil_als = com_fossil_als.m3767c(com_fossil_ahg.findValueSerializer(com_fossil_als.aUB, com_fossil_agv));
            if (com_fossil_als != this._objectIdWriter) {
                withObjectIdWriter = withObjectIdWriter(com_fossil_als);
                withObjectIdWriter = withObjectIdWriter.withIgnorals(strArr);
                if (obj != null) {
                    withObjectIdWriter = withObjectIdWriter.withFilterId(obj);
                }
                if (shape == null) {
                    shape = this._serializationShape;
                }
                if (shape != Shape.ARRAY) {
                    return withObjectIdWriter.asArraySerializer();
                }
                return withObjectIdWriter;
            }
        }
        com_fossil_ahb = this;
        withObjectIdWriter = withObjectIdWriter.withIgnorals(strArr);
        if (obj != null) {
            withObjectIdWriter = withObjectIdWriter.withFilterId(obj);
        }
        if (shape == null) {
            shape = this._serializationShape;
        }
        if (shape != Shape.ARRAY) {
            return withObjectIdWriter;
        }
        return withObjectIdWriter.asArraySerializer();
    }

    public Iterator<alk> properties() {
        return Arrays.asList(this._props).iterator();
    }

    public boolean usesObjectId() {
        return this._objectIdWriter != null;
    }

    public void serializeWithType(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ajv com_fossil_ajv) throws IOException {
        if (this._objectIdWriter != null) {
            jsonGenerator.bm(obj);
            _serializeWithObjectId(obj, jsonGenerator, com_fossil_ahg, com_fossil_ajv);
            return;
        }
        String _customTypeId = this._typeId == null ? null : _customTypeId(obj);
        if (_customTypeId == null) {
            com_fossil_ajv.mo1029b(obj, jsonGenerator);
        } else {
            com_fossil_ajv.mo1028a(obj, jsonGenerator, _customTypeId);
        }
        jsonGenerator.bm(obj);
        if (this._propertyFilterId != null) {
            serializeFieldsFiltered(obj, jsonGenerator, com_fossil_ahg);
        } else {
            serializeFields(obj, jsonGenerator, com_fossil_ahg);
        }
        if (_customTypeId == null) {
            com_fossil_ajv.mo1036e(obj, jsonGenerator);
        } else {
            com_fossil_ajv.mo1033c(obj, jsonGenerator, _customTypeId);
        }
    }

    protected final void _serializeWithObjectId(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg, boolean z) throws IOException {
        als com_fossil_als = this._objectIdWriter;
        alx findObjectId = com_fossil_ahg.findObjectId(obj, com_fossil_als.generator);
        if (!findObjectId.m3798a(jsonGenerator, com_fossil_ahg, com_fossil_als)) {
            Object generateId = findObjectId.generateId(obj);
            if (com_fossil_als.aUE) {
                com_fossil_als.aUD.serialize(generateId, jsonGenerator, com_fossil_ahg);
                return;
            }
            if (z) {
                jsonGenerator.zJ();
            }
            findObjectId.m3799b(jsonGenerator, com_fossil_ahg, com_fossil_als);
            if (this._propertyFilterId != null) {
                serializeFieldsFiltered(obj, jsonGenerator, com_fossil_ahg);
            } else {
                serializeFields(obj, jsonGenerator, com_fossil_ahg);
            }
            if (z) {
                jsonGenerator.zK();
            }
        }
    }

    protected final void _serializeWithObjectId(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ajv com_fossil_ajv) throws IOException {
        als com_fossil_als = this._objectIdWriter;
        alx findObjectId = com_fossil_ahg.findObjectId(obj, com_fossil_als.generator);
        if (!findObjectId.m3798a(jsonGenerator, com_fossil_ahg, com_fossil_als)) {
            Object generateId = findObjectId.generateId(obj);
            if (com_fossil_als.aUE) {
                com_fossil_als.aUD.serialize(generateId, jsonGenerator, com_fossil_ahg);
            } else {
                _serializeObjectId(obj, jsonGenerator, com_fossil_ahg, com_fossil_ajv, findObjectId);
            }
        }
    }

    protected void _serializeObjectId(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ajv com_fossil_ajv, alx com_fossil_alx) throws IOException {
        als com_fossil_als = this._objectIdWriter;
        String _customTypeId = this._typeId == null ? null : _customTypeId(obj);
        if (_customTypeId == null) {
            com_fossil_ajv.mo1029b(obj, jsonGenerator);
        } else {
            com_fossil_ajv.mo1028a(obj, jsonGenerator, _customTypeId);
        }
        com_fossil_alx.m3799b(jsonGenerator, com_fossil_ahg, com_fossil_als);
        if (this._propertyFilterId != null) {
            serializeFieldsFiltered(obj, jsonGenerator, com_fossil_ahg);
        } else {
            serializeFields(obj, jsonGenerator, com_fossil_ahg);
        }
        if (_customTypeId == null) {
            com_fossil_ajv.mo1036e(obj, jsonGenerator);
        } else {
            com_fossil_ajv.mo1033c(obj, jsonGenerator, _customTypeId);
        }
    }

    protected final String _customTypeId(Object obj) {
        Object value = this._typeId.getValue(obj);
        if (value == null) {
            return "";
        }
        return value instanceof String ? (String) value : value.toString();
    }

    protected void serializeFields(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException, JsonGenerationException {
        ald[] com_fossil_aldArr;
        if (this._filteredProps == null || com_fossil_ahg.getActiveView() == null) {
            com_fossil_aldArr = this._props;
        } else {
            com_fossil_aldArr = this._filteredProps;
        }
        int i = 0;
        try {
            int length = com_fossil_aldArr.length;
            while (i < length) {
                ald com_fossil_ald = com_fossil_aldArr[i];
                if (com_fossil_ald != null) {
                    com_fossil_ald.mo1072b(obj, jsonGenerator, com_fossil_ahg);
                }
                i++;
            }
            if (this._anyGetterWriter != null) {
                this._anyGetterWriter.m3684a(obj, jsonGenerator, com_fossil_ahg);
            }
        } catch (Throwable e) {
            wrapAndThrow(com_fossil_ahg, e, obj, i == com_fossil_aldArr.length ? "[anySetter]" : com_fossil_aldArr[i].getName());
        } catch (Throwable e2) {
            JsonMappingException jsonMappingException = new JsonMappingException("Infinite recursion (StackOverflowError)", e2);
            jsonMappingException.prependPath(new Reference(obj, i == com_fossil_aldArr.length ? "[anySetter]" : com_fossil_aldArr[i].getName()));
            throw jsonMappingException;
        }
    }

    protected void serializeFieldsFiltered(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException, JsonGenerationException {
        ald[] com_fossil_aldArr;
        if (this._filteredProps == null || com_fossil_ahg.getActiveView() == null) {
            com_fossil_aldArr = this._props;
        } else {
            com_fossil_aldArr = this._filteredProps;
        }
        alj findPropertyFilter = findPropertyFilter(com_fossil_ahg, this._propertyFilterId, obj);
        if (findPropertyFilter == null) {
            serializeFields(obj, jsonGenerator, com_fossil_ahg);
            return;
        }
        int i = 0;
        try {
            int length = com_fossil_aldArr.length;
            while (i < length) {
                alk com_fossil_alk = com_fossil_aldArr[i];
                if (com_fossil_alk != null) {
                    findPropertyFilter.serializeAsField(obj, jsonGenerator, com_fossil_ahg, com_fossil_alk);
                }
                i++;
            }
            if (this._anyGetterWriter != null) {
                this._anyGetterWriter.m3685a(obj, jsonGenerator, com_fossil_ahg, findPropertyFilter);
            }
        } catch (Throwable e) {
            wrapAndThrow(com_fossil_ahg, e, obj, 0 == com_fossil_aldArr.length ? "[anySetter]" : com_fossil_aldArr[0].getName());
        } catch (Throwable e2) {
            JsonMappingException jsonMappingException = new JsonMappingException("Infinite recursion (StackOverflowError)", e2);
            jsonMappingException.prependPath(new Reference(obj, 0 == com_fossil_aldArr.length ? "[anySetter]" : com_fossil_aldArr[0].getName()));
            throw jsonMappingException;
        }
    }

    @Deprecated
    public agz getSchema(ahg com_fossil_ahg, Type type) throws JsonMappingException {
        alj findPropertyFilter;
        agz createSchemaNode = createSchemaNode("object", true);
        ajp com_fossil_ajp = (ajp) this._handledType.getAnnotation(ajp.class);
        if (com_fossil_ajp != null) {
            String id = com_fossil_ajp.id();
            if (id != null && id.length() > 0) {
                createSchemaNode.m3675t("id", id);
            }
        }
        akv objectNode = createSchemaNode.objectNode();
        if (this._propertyFilterId != null) {
            findPropertyFilter = findPropertyFilter(com_fossil_ahg, this._propertyFilterId, null);
        } else {
            findPropertyFilter = null;
        }
        for (alk com_fossil_alk : this._props) {
            if (findPropertyFilter == null) {
                com_fossil_alk.mo1071a(objectNode, com_fossil_ahg);
            } else {
                findPropertyFilter.depositSchemaProperty(com_fossil_alk, objectNode, com_fossil_ahg);
            }
        }
        createSchemaNode.m3669a("properties", objectNode);
        return createSchemaNode;
    }

    public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
        int i = 0;
        if (com_fossil_ajg != null) {
            ajl d = com_fossil_ajg.mo1016d(javaType);
            if (d == null) {
                return;
            }
            if (this._propertyFilterId != null) {
                alj findPropertyFilter = findPropertyFilter(com_fossil_ajg.Gd(), this._propertyFilterId, null);
                while (i < this._props.length) {
                    findPropertyFilter.depositSchemaProperty(this._props[i], d, com_fossil_ajg.Gd());
                    i++;
                }
                return;
            }
            while (i < this._props.length) {
                this._props[i].depositSchemaProperty(d);
                i++;
            }
        }
    }
}
