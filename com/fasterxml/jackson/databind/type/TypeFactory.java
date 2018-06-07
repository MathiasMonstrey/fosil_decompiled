package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.util.LRUMap;
import com.fossil.agl;
import com.fossil.alz;
import com.fossil.ama;
import com.fossil.amb;
import com.fossil.amd;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

public final class TypeFactory implements Serializable {
    protected static final SimpleType CORE_TYPE_BOOL = new SimpleType(Boolean.TYPE);
    protected static final SimpleType CORE_TYPE_INT = new SimpleType(Integer.TYPE);
    protected static final SimpleType CORE_TYPE_LONG = new SimpleType(Long.TYPE);
    protected static final SimpleType CORE_TYPE_STRING = new SimpleType(String.class);
    private static final JavaType[] aVk = new JavaType[0];
    protected static final TypeFactory instance = new TypeFactory();
    private static final long serialVersionUID = 1;
    protected transient alz _cachedArrayListType;
    protected transient alz _cachedHashMapType;
    protected final ClassLoader _classLoader;
    protected final amb[] _modifiers;
    protected final TypeParser _parser;
    protected final LRUMap<ClassKey, JavaType> _typeCache;

    private TypeFactory() {
        this._typeCache = new LRUMap(16, 100);
        this._parser = new TypeParser(this);
        this._modifiers = null;
        this._classLoader = null;
    }

    protected TypeFactory(TypeParser typeParser, amb[] com_fossil_ambArr) {
        this(typeParser, com_fossil_ambArr, null);
    }

    protected TypeFactory(TypeParser typeParser, amb[] com_fossil_ambArr, ClassLoader classLoader) {
        this._typeCache = new LRUMap(16, 100);
        this._parser = typeParser;
        this._modifiers = com_fossil_ambArr;
        this._classLoader = classLoader;
    }

    public TypeFactory withModifier(amb com_fossil_amb) {
        if (com_fossil_amb == null) {
            return new TypeFactory(this._parser, this._modifiers, this._classLoader);
        }
        if (this._modifiers != null) {
            return new TypeFactory(this._parser, (amb[]) amd.m3837a(this._modifiers, (Object) com_fossil_amb), this._classLoader);
        }
        return new TypeFactory(this._parser, new amb[]{com_fossil_amb}, this._classLoader);
    }

    public TypeFactory withClassLoader(ClassLoader classLoader) {
        return new TypeFactory(this._parser, this._modifiers, classLoader);
    }

    public static TypeFactory defaultInstance() {
        return instance;
    }

    public void clearCache() {
        this._typeCache.clear();
    }

    public ClassLoader getClassLoader() {
        return this._classLoader;
    }

    public static JavaType unknownType() {
        return defaultInstance()._unknownType();
    }

    public static Class<?> rawClass(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        return defaultInstance().constructType(type).getRawClass();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Class<?> findClass(java.lang.String r4) throws java.lang.ClassNotFoundException {
        /*
        r3 = this;
        r0 = 46;
        r0 = r4.indexOf(r0);
        if (r0 >= 0) goto L_0x000f;
    L_0x0008:
        r0 = r3._findPrimitive(r4);
        if (r0 == 0) goto L_0x000f;
    L_0x000e:
        return r0;
    L_0x000f:
        r0 = 0;
        r1 = r3.getClassLoader();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r1 = java.lang.Thread.currentThread();
        r1 = r1.getContextClassLoader();
    L_0x001e:
        if (r1 == 0) goto L_0x002b;
    L_0x0020:
        r0 = 1;
        r0 = r3.classForName(r4, r0, r1);	 Catch:{ Exception -> 0x0026 }
        goto L_0x000e;
    L_0x0026:
        r0 = move-exception;
        r0 = com.fossil.ami.m3865c(r0);
    L_0x002b:
        r0 = r3.classForName(r4);	 Catch:{ Exception -> 0x0030 }
        goto L_0x000e;
    L_0x0030:
        r1 = move-exception;
        if (r0 != 0) goto L_0x0037;
    L_0x0033:
        r0 = com.fossil.ami.m3865c(r1);
    L_0x0037:
        r1 = r0 instanceof java.lang.RuntimeException;
        if (r1 == 0) goto L_0x003e;
    L_0x003b:
        r0 = (java.lang.RuntimeException) r0;
        throw r0;
    L_0x003e:
        r1 = new java.lang.ClassNotFoundException;
        r2 = r0.getMessage();
        r1.<init>(r2, r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.type.TypeFactory.findClass(java.lang.String):java.lang.Class<?>");
    }

    protected Class<?> classForName(String str, boolean z, ClassLoader classLoader) throws ClassNotFoundException {
        return Class.forName(str, true, classLoader);
    }

    protected Class<?> classForName(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }

    protected Class<?> _findPrimitive(String str) {
        if ("int".equals(str)) {
            return Integer.TYPE;
        }
        if ("long".equals(str)) {
            return Long.TYPE;
        }
        if ("float".equals(str)) {
            return Float.TYPE;
        }
        if ("double".equals(str)) {
            return Double.TYPE;
        }
        if ("boolean".equals(str)) {
            return Boolean.TYPE;
        }
        if ("byte".equals(str)) {
            return Byte.TYPE;
        }
        if ("char".equals(str)) {
            return Character.TYPE;
        }
        if ("short".equals(str)) {
            return Short.TYPE;
        }
        if ("void".equals(str)) {
            return Void.TYPE;
        }
        return null;
    }

    public JavaType constructSpecializedType(JavaType javaType, Class<?> cls) {
        if (javaType.getRawClass() == cls) {
            return javaType;
        }
        if (!(javaType instanceof SimpleType) || (!cls.isArray() && !Map.class.isAssignableFrom(cls) && !Collection.class.isAssignableFrom(cls))) {
            return javaType.narrowBy(cls);
        }
        if (javaType.getRawClass().isAssignableFrom(cls)) {
            JavaType _fromClass = _fromClass(cls, new ama(this, javaType.getRawClass()));
            Object valueHandler = javaType.getValueHandler();
            if (valueHandler != null) {
                _fromClass = _fromClass.withValueHandler(valueHandler);
            }
            valueHandler = javaType.getTypeHandler();
            if (valueHandler != null) {
                _fromClass = _fromClass.withTypeHandler(valueHandler);
            }
            return _fromClass;
        }
        throw new IllegalArgumentException("Class " + cls.getClass().getName() + " not subtype of " + javaType);
    }

    public JavaType constructFromCanonical(String str) throws IllegalArgumentException {
        return this._parser.parse(str);
    }

    public JavaType[] findTypeParameters(JavaType javaType, Class<?> cls) {
        if (cls != javaType.getParameterSource()) {
            return findTypeParameters(javaType.getRawClass(), cls, new ama(this, javaType));
        }
        int containedTypeCount = javaType.containedTypeCount();
        if (containedTypeCount == 0) {
            return null;
        }
        JavaType[] javaTypeArr = new JavaType[containedTypeCount];
        for (int i = 0; i < containedTypeCount; i++) {
            javaTypeArr[i] = javaType.containedType(i);
        }
        return javaTypeArr;
    }

    public JavaType[] findTypeParameters(Class<?> cls, Class<?> cls2) {
        return findTypeParameters(cls, cls2, new ama(this, (Class) cls));
    }

    public JavaType[] findTypeParameters(Class<?> cls, Class<?> cls2, ama com_fossil_ama) {
        alz _findSuperTypeChain = _findSuperTypeChain(cls, cls2);
        if (_findSuperTypeChain == null) {
            throw new IllegalArgumentException("Class " + cls.getName() + " is not a subtype of " + cls2.getName());
        }
        while (_findSuperTypeChain.GT() != null) {
            _findSuperTypeChain = _findSuperTypeChain.GT();
            Class rawClass = _findSuperTypeChain.getRawClass();
            ama com_fossil_ama2 = new ama(this, rawClass);
            if (_findSuperTypeChain.GV()) {
                Type[] actualTypeArguments = _findSuperTypeChain.GW().getActualTypeArguments();
                TypeVariable[] typeParameters = rawClass.getTypeParameters();
                int length = actualTypeArguments.length;
                for (int i = 0; i < length; i++) {
                    com_fossil_ama2.m3830a(typeParameters[i].getName(), _constructType(actualTypeArguments[i], com_fossil_ama));
                }
            }
            com_fossil_ama = com_fossil_ama2;
        }
        if (_findSuperTypeChain.GV()) {
            return com_fossil_ama.GY();
        }
        return null;
    }

    public JavaType moreSpecificType(JavaType javaType, JavaType javaType2) {
        if (javaType == null) {
            return javaType2;
        }
        if (javaType2 == null) {
            return javaType;
        }
        Class rawClass = javaType.getRawClass();
        Class rawClass2 = javaType2.getRawClass();
        if (rawClass == rawClass2 || !rawClass.isAssignableFrom(rawClass2)) {
            return javaType;
        }
        return javaType2;
    }

    public JavaType constructType(Type type) {
        return _constructType(type, null);
    }

    public JavaType constructType(Type type, ama com_fossil_ama) {
        return _constructType(type, com_fossil_ama);
    }

    public JavaType constructType(agl<?> com_fossil_agl_) {
        return _constructType(com_fossil_agl_.getType(), null);
    }

    public JavaType constructType(Type type, Class<?> cls) {
        return _constructType(type, cls == null ? null : new ama(this, (Class) cls));
    }

    public JavaType constructType(Type type, JavaType javaType) {
        return _constructType(type, javaType == null ? null : new ama(this, javaType));
    }

    public JavaType _constructType(Type type, ama com_fossil_ama) {
        JavaType _fromClass;
        if (type instanceof Class) {
            _fromClass = _fromClass((Class) type, com_fossil_ama);
        } else if (type instanceof ParameterizedType) {
            _fromClass = _fromParamType((ParameterizedType) type, com_fossil_ama);
        } else if (type instanceof JavaType) {
            return (JavaType) type;
        } else {
            if (type instanceof GenericArrayType) {
                _fromClass = _fromArrayType((GenericArrayType) type, com_fossil_ama);
            } else if (type instanceof TypeVariable) {
                _fromClass = _fromVariable((TypeVariable) type, com_fossil_ama);
            } else if (type instanceof WildcardType) {
                _fromClass = _fromWildcard((WildcardType) type, com_fossil_ama);
            } else {
                throw new IllegalArgumentException("Unrecognized Type: " + (type == null ? "[null]" : type.toString()));
            }
        }
        if (!(this._modifiers == null || r0.isContainerType())) {
            amb[] com_fossil_ambArr = this._modifiers;
            int length = com_fossil_ambArr.length;
            int i = 0;
            while (i < length) {
                JavaType a = com_fossil_ambArr[i].m3833a(_fromClass, type, com_fossil_ama, this);
                i++;
                _fromClass = a;
            }
        }
        return _fromClass;
    }

    public ArrayType constructArrayType(Class<?> cls) {
        return ArrayType.construct(_constructType(cls, null), null, null);
    }

    public ArrayType constructArrayType(JavaType javaType) {
        return ArrayType.construct(javaType, null, null);
    }

    public CollectionType constructCollectionType(Class<? extends Collection> cls, Class<?> cls2) {
        return CollectionType.construct(cls, constructType((Type) cls2));
    }

    public CollectionType constructCollectionType(Class<? extends Collection> cls, JavaType javaType) {
        return CollectionType.construct(cls, javaType);
    }

    public CollectionLikeType constructCollectionLikeType(Class<?> cls, Class<?> cls2) {
        return CollectionLikeType.construct(cls, constructType((Type) cls2));
    }

    public CollectionLikeType constructCollectionLikeType(Class<?> cls, JavaType javaType) {
        return CollectionLikeType.construct(cls, javaType);
    }

    public MapType constructMapType(Class<? extends Map> cls, JavaType javaType, JavaType javaType2) {
        return MapType.construct(cls, javaType, javaType2);
    }

    public MapType constructMapType(Class<? extends Map> cls, Class<?> cls2, Class<?> cls3) {
        return MapType.construct(cls, constructType((Type) cls2), constructType((Type) cls3));
    }

    public MapLikeType constructMapLikeType(Class<?> cls, JavaType javaType, JavaType javaType2) {
        return MapLikeType.construct(cls, javaType, javaType2);
    }

    public MapLikeType constructMapLikeType(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        return MapType.construct(cls, constructType((Type) cls2), constructType((Type) cls3));
    }

    @Deprecated
    public JavaType constructSimpleType(Class<?> cls, JavaType[] javaTypeArr) {
        return constructSimpleType(cls, cls, javaTypeArr);
    }

    public JavaType constructSimpleType(Class<?> cls, Class<?> cls2, JavaType[] javaTypeArr) {
        TypeVariable[] typeParameters = cls2.getTypeParameters();
        if (typeParameters.length != javaTypeArr.length) {
            throw new IllegalArgumentException("Parameter type mismatch for " + cls.getName() + " (and target " + cls2.getName() + "): expected " + typeParameters.length + " parameters, was given " + javaTypeArr.length);
        }
        String[] strArr = new String[typeParameters.length];
        int length = typeParameters.length;
        for (int i = 0; i < length; i++) {
            strArr[i] = typeParameters[i].getName();
        }
        return new SimpleType(cls, strArr, javaTypeArr, null, null, false, cls2);
    }

    public JavaType constructReferenceType(Class<?> cls, JavaType javaType) {
        return new ReferenceType(cls, javaType, null, null, false);
    }

    public JavaType uncheckedSimpleType(Class<?> cls) {
        return new SimpleType(cls);
    }

    public JavaType constructParametrizedType(Class<?> cls, Class<?> cls2, Class<?>... clsArr) {
        int length = clsArr.length;
        JavaType[] javaTypeArr = new JavaType[length];
        for (int i = 0; i < length; i++) {
            javaTypeArr[i] = _fromClass(clsArr[i], null);
        }
        return constructParametrizedType((Class) cls, (Class) cls2, javaTypeArr);
    }

    @Deprecated
    public JavaType constructParametricType(Class<?> cls, Class<?>... clsArr) {
        return constructParametrizedType((Class) cls, (Class) cls, (Class[]) clsArr);
    }

    public JavaType constructParametrizedType(Class<?> cls, Class<?> cls2, JavaType... javaTypeArr) {
        if (cls.isArray()) {
            if (javaTypeArr.length == 1) {
                return constructArrayType(javaTypeArr[0]);
            }
            throw new IllegalArgumentException("Need exactly 1 parameter type for arrays (" + cls.getName() + ")");
        } else if (Map.class.isAssignableFrom(cls)) {
            if (javaTypeArr.length == 2) {
                return constructMapType((Class) cls, javaTypeArr[0], javaTypeArr[1]);
            }
            throw new IllegalArgumentException("Need exactly 2 parameter types for Map types (" + cls.getName() + ")");
        } else if (!Collection.class.isAssignableFrom(cls)) {
            return constructSimpleType(cls, cls2, javaTypeArr);
        } else {
            if (javaTypeArr.length == 1) {
                return constructCollectionType((Class) cls, javaTypeArr[0]);
            }
            throw new IllegalArgumentException("Need exactly 1 parameter type for Collection types (" + cls.getName() + ")");
        }
    }

    @Deprecated
    public JavaType constructParametricType(Class<?> cls, JavaType... javaTypeArr) {
        return constructParametrizedType((Class) cls, (Class) cls, javaTypeArr);
    }

    public CollectionType constructRawCollectionType(Class<? extends Collection> cls) {
        return CollectionType.construct(cls, unknownType());
    }

    public CollectionLikeType constructRawCollectionLikeType(Class<?> cls) {
        return CollectionLikeType.construct(cls, unknownType());
    }

    public MapType constructRawMapType(Class<? extends Map> cls) {
        return MapType.construct(cls, unknownType(), unknownType());
    }

    public MapLikeType constructRawMapLikeType(Class<?> cls) {
        return MapLikeType.construct(cls, unknownType(), unknownType());
    }

    protected JavaType _fromClass(Class<?> cls, ama com_fossil_ama) {
        if (cls == String.class) {
            return CORE_TYPE_STRING;
        }
        if (cls == Boolean.TYPE) {
            return CORE_TYPE_BOOL;
        }
        if (cls == Integer.TYPE) {
            return CORE_TYPE_INT;
        }
        if (cls == Long.TYPE) {
            return CORE_TYPE_LONG;
        }
        ClassKey classKey = new ClassKey(cls);
        JavaType javaType = (JavaType) this._typeCache.get(classKey);
        if (javaType != null) {
            return javaType;
        }
        if (cls.isArray()) {
            javaType = ArrayType.construct(_constructType(cls.getComponentType(), null), null, null);
        } else if (cls.isEnum()) {
            javaType = new SimpleType(cls);
        } else if (Map.class.isAssignableFrom(cls)) {
            javaType = m2764t(cls);
        } else if (Collection.class.isAssignableFrom(cls)) {
            javaType = m2765u(cls);
        } else if (AtomicReference.class.isAssignableFrom(cls)) {
            r0 = findTypeParameters((Class) cls, AtomicReference.class);
            javaType = (r0 == null || r0.length != 1) ? unknownType() : r0[0];
            javaType = constructReferenceType(cls, javaType);
        } else if (Entry.class.isAssignableFrom(cls)) {
            JavaType javaType2;
            r0 = findTypeParameters((Class) cls, Entry.class);
            if (r0 == null || r0.length != 2) {
                javaType = unknownType();
                javaType2 = javaType;
            } else {
                javaType2 = r0[0];
                javaType = r0[1];
            }
            javaType = constructSimpleType(cls, Entry.class, new JavaType[]{javaType2, javaType});
        } else {
            javaType = new SimpleType(cls);
        }
        this._typeCache.put(classKey, javaType);
        return javaType;
    }

    protected JavaType _fromParameterizedClass(Class<?> cls, List<JavaType> list) {
        if (cls.isArray()) {
            return ArrayType.construct(_constructType(cls.getComponentType(), null), null, null);
        }
        if (cls.isEnum()) {
            return new SimpleType(cls);
        }
        if (Map.class.isAssignableFrom(cls)) {
            if (list.size() <= 0) {
                return m2764t(cls);
            }
            return MapType.construct(cls, (JavaType) list.get(0), list.size() >= 2 ? (JavaType) list.get(1) : _unknownType());
        } else if (Collection.class.isAssignableFrom(cls)) {
            if (list.size() >= 1) {
                return CollectionType.construct(cls, (JavaType) list.get(0));
            }
            return m2765u(cls);
        } else if (list.size() == 0) {
            return new SimpleType(cls);
        } else {
            return constructSimpleType(cls, cls, (JavaType[]) list.toArray(new JavaType[list.size()]));
        }
    }

    protected JavaType _fromParamType(ParameterizedType parameterizedType, ama com_fossil_ama) {
        JavaType[] javaTypeArr;
        JavaType javaType = null;
        Class cls = (Class) parameterizedType.getRawType();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        int length = actualTypeArguments == null ? 0 : actualTypeArguments.length;
        if (length == 0) {
            javaTypeArr = aVk;
        } else {
            javaTypeArr = new JavaType[length];
            for (int i = 0; i < length; i++) {
                javaTypeArr[i] = _constructType(actualTypeArguments[i], com_fossil_ama);
            }
        }
        if (Map.class.isAssignableFrom(cls)) {
            javaTypeArr = findTypeParameters(constructSimpleType(cls, cls, javaTypeArr), Map.class);
            if (javaTypeArr.length == 2) {
                return MapType.construct(cls, javaTypeArr[0], javaTypeArr[1]);
            }
            throw new IllegalArgumentException("Could not find 2 type parameters for Map class " + cls.getName() + " (found " + javaTypeArr.length + ")");
        } else if (Collection.class.isAssignableFrom(cls)) {
            javaTypeArr = findTypeParameters(constructSimpleType(cls, cls, javaTypeArr), Collection.class);
            if (javaTypeArr.length == 1) {
                return CollectionType.construct(cls, javaTypeArr[0]);
            }
            throw new IllegalArgumentException("Could not find 1 type parameter for Collection class " + cls.getName() + " (found " + javaTypeArr.length + ")");
        } else if (AtomicReference.class.isAssignableFrom(cls)) {
            if (cls == AtomicReference.class) {
                if (length == 1) {
                    r1 = javaTypeArr[0];
                }
                r1 = null;
            } else {
                javaTypeArr = findTypeParameters(cls, AtomicReference.class);
                if (!(javaTypeArr == null || javaTypeArr.length == 1)) {
                    r1 = javaTypeArr[0];
                }
                r1 = null;
            }
            if (r1 == null) {
                r1 = unknownType();
            }
            return constructReferenceType(cls, r1);
        } else if (Entry.class.isAssignableFrom(cls)) {
            if (cls == Entry.class) {
                if (length == 2) {
                    javaType = javaTypeArr[0];
                    r1 = javaTypeArr[1];
                }
                r1 = null;
            } else {
                javaTypeArr = findTypeParameters(cls, Entry.class);
                if (!(javaTypeArr == null || javaTypeArr.length == 2)) {
                    javaType = javaTypeArr[0];
                    r1 = javaTypeArr[1];
                }
                r1 = null;
            }
            Class cls2 = Entry.class;
            JavaType[] javaTypeArr2 = new JavaType[2];
            if (javaType == null) {
                javaType = unknownType();
            }
            javaTypeArr2[0] = javaType;
            if (r1 == null) {
                r1 = unknownType();
            }
            javaTypeArr2[1] = r1;
            return constructSimpleType(cls, cls2, javaTypeArr2);
        } else if (length == 0) {
            return new SimpleType(cls);
        } else {
            return constructSimpleType(cls, javaTypeArr);
        }
    }

    protected JavaType _fromArrayType(GenericArrayType genericArrayType, ama com_fossil_ama) {
        return ArrayType.construct(_constructType(genericArrayType.getGenericComponentType(), com_fossil_ama), null, null);
    }

    protected JavaType _fromVariable(TypeVariable<?> typeVariable, ama com_fossil_ama) {
        String name = typeVariable.getName();
        if (com_fossil_ama == null) {
            com_fossil_ama = new ama(this, (Class) null);
        } else {
            JavaType g = com_fossil_ama.m3832g(name, false);
            if (g != null) {
                return g;
            }
        }
        Type[] bounds = typeVariable.getBounds();
        com_fossil_ama.bZ(name);
        return _constructType(bounds[0], com_fossil_ama);
    }

    protected JavaType _fromWildcard(WildcardType wildcardType, ama com_fossil_ama) {
        return _constructType(wildcardType.getUpperBounds()[0], com_fossil_ama);
    }

    private JavaType m2764t(Class<?> cls) {
        if (cls == Properties.class) {
            return MapType.construct(cls, CORE_TYPE_STRING, CORE_TYPE_STRING);
        }
        JavaType[] findTypeParameters = findTypeParameters((Class) cls, Map.class);
        if (findTypeParameters == null) {
            return MapType.construct(cls, _unknownType(), _unknownType());
        }
        if (findTypeParameters.length == 2) {
            return MapType.construct(cls, findTypeParameters[0], findTypeParameters[1]);
        }
        throw new IllegalArgumentException("Strange Map type " + cls.getName() + ": can not determine type parameters");
    }

    private JavaType m2765u(Class<?> cls) {
        JavaType[] findTypeParameters = findTypeParameters((Class) cls, Collection.class);
        if (findTypeParameters == null) {
            return CollectionType.construct(cls, _unknownType());
        }
        if (findTypeParameters.length == 1) {
            return CollectionType.construct(cls, findTypeParameters[0]);
        }
        throw new IllegalArgumentException("Strange Collection type " + cls.getName() + ": can not determine type parameters");
    }

    protected JavaType _resolveVariableViaSubTypes(alz com_fossil_alz, String str, ama com_fossil_ama) {
        if (com_fossil_alz != null && com_fossil_alz.GV()) {
            TypeVariable[] typeParameters = com_fossil_alz.getRawClass().getTypeParameters();
            int length = typeParameters.length;
            for (int i = 0; i < length; i++) {
                if (str.equals(typeParameters[i].getName())) {
                    Type type = com_fossil_alz.GW().getActualTypeArguments()[i];
                    if (type instanceof TypeVariable) {
                        return _resolveVariableViaSubTypes(com_fossil_alz.GU(), ((TypeVariable) type).getName(), com_fossil_ama);
                    }
                    return _constructType(type, com_fossil_ama);
                }
            }
        }
        return _unknownType();
    }

    protected JavaType _unknownType() {
        return new SimpleType(Object.class);
    }

    protected alz _findSuperTypeChain(Class<?> cls, Class<?> cls2) {
        if (cls2.isInterface()) {
            return _findSuperInterfaceChain(cls, cls2);
        }
        return _findSuperClassChain(cls, cls2);
    }

    protected alz _findSuperClassChain(Type type, Class<?> cls) {
        alz com_fossil_alz = new alz(type);
        Class<?> rawClass = com_fossil_alz.getRawClass();
        if (rawClass == cls) {
            return com_fossil_alz;
        }
        Type genericSuperclass = rawClass.getGenericSuperclass();
        if (genericSuperclass != null) {
            alz _findSuperClassChain = _findSuperClassChain(genericSuperclass, cls);
            if (_findSuperClassChain != null) {
                _findSuperClassChain.m3806b(com_fossil_alz);
                com_fossil_alz.m3805a(_findSuperClassChain);
                return com_fossil_alz;
            }
        }
        return null;
    }

    protected alz _findSuperInterfaceChain(Type type, Class<?> cls) {
        alz com_fossil_alz = new alz(type);
        Class<?> rawClass = com_fossil_alz.getRawClass();
        if (rawClass == cls) {
            return new alz(type);
        }
        if (rawClass == HashMap.class && cls == Map.class) {
            return _hashMapSuperInterfaceChain(com_fossil_alz);
        }
        if (rawClass == ArrayList.class && cls == List.class) {
            return _arrayListSuperInterfaceChain(com_fossil_alz);
        }
        return _doFindSuperInterfaceChain(com_fossil_alz, cls);
    }

    protected alz _doFindSuperInterfaceChain(alz com_fossil_alz, Class<?> cls) {
        Class rawClass = com_fossil_alz.getRawClass();
        Type[] genericInterfaces = rawClass.getGenericInterfaces();
        if (genericInterfaces != null) {
            for (Type _findSuperInterfaceChain : genericInterfaces) {
                alz _findSuperInterfaceChain2 = _findSuperInterfaceChain(_findSuperInterfaceChain, cls);
                if (_findSuperInterfaceChain2 != null) {
                    _findSuperInterfaceChain2.m3806b(com_fossil_alz);
                    com_fossil_alz.m3805a(_findSuperInterfaceChain2);
                    return com_fossil_alz;
                }
            }
        }
        Type genericSuperclass = rawClass.getGenericSuperclass();
        if (genericSuperclass != null) {
            alz _findSuperInterfaceChain3 = _findSuperInterfaceChain(genericSuperclass, cls);
            if (_findSuperInterfaceChain3 != null) {
                _findSuperInterfaceChain3.m3806b(com_fossil_alz);
                com_fossil_alz.m3805a(_findSuperInterfaceChain3);
                return com_fossil_alz;
            }
        }
        return null;
    }

    protected synchronized alz _hashMapSuperInterfaceChain(alz com_fossil_alz) {
        alz GS;
        if (this._cachedHashMapType == null) {
            GS = com_fossil_alz.GS();
            _doFindSuperInterfaceChain(GS, Map.class);
            this._cachedHashMapType = GS.GT();
        }
        GS = this._cachedHashMapType.GS();
        com_fossil_alz.m3805a(GS);
        GS.m3806b(com_fossil_alz);
        return com_fossil_alz;
    }

    protected synchronized alz _arrayListSuperInterfaceChain(alz com_fossil_alz) {
        alz GS;
        if (this._cachedArrayListType == null) {
            GS = com_fossil_alz.GS();
            _doFindSuperInterfaceChain(GS, List.class);
            this._cachedArrayListType = GS.GT();
        }
        GS = this._cachedArrayListType.GS();
        com_fossil_alz.m3805a(GS);
        GS.m3806b(com_fossil_alz);
        return com_fossil_alz;
    }
}
