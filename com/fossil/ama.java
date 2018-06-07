package com.fossil;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class ama {
    private static final JavaType[] aVk = new JavaType[0];
    public static final JavaType aVl = new SimpleType(Object.class);
    protected final TypeFactory _typeFactory;
    protected final JavaType aVm;
    protected final Class<?> aVn;
    protected Map<String, JavaType> aVo;
    protected HashSet<String> aVp;
    private final ama aVq;

    public ama(TypeFactory typeFactory, Class<?> cls) {
        this(typeFactory, null, cls, null);
    }

    public ama(TypeFactory typeFactory, JavaType javaType) {
        this(typeFactory, null, javaType.getRawClass(), javaType);
    }

    public ama GX() {
        return new ama(this._typeFactory, this, this.aVn, this.aVm);
    }

    private ama(TypeFactory typeFactory, ama com_fossil_ama, Class<?> cls, JavaType javaType) {
        this._typeFactory = typeFactory;
        this.aVq = com_fossil_ama;
        this.aVn = cls;
        this.aVm = javaType;
    }

    public JavaType m3829a(Type type) {
        return this._typeFactory._constructType(type, this);
    }

    @Deprecated
    public JavaType bY(String str) {
        return m3832g(str, true);
    }

    public JavaType m3832g(String str, boolean z) {
        if (this.aVo == null) {
            GZ();
        }
        JavaType javaType = (JavaType) this.aVo.get(str);
        if (javaType != null) {
            return javaType;
        }
        if (this.aVp != null && this.aVp.contains(str)) {
            return aVl;
        }
        if (this.aVq != null) {
            return this.aVq.bY(str);
        }
        if (this.aVn != null && this.aVn.getEnclosingClass() != null && !Modifier.isStatic(this.aVn.getModifiers())) {
            return aVl;
        }
        if (!z) {
            return null;
        }
        String name;
        if (this.aVn != null) {
            name = this.aVn.getName();
        } else if (this.aVm != null) {
            name = this.aVm.toString();
        } else {
            name = "UNKNOWN";
        }
        throw new IllegalArgumentException("Type variable '" + str + "' can not be resolved (with context of class " + name + ")");
    }

    public void m3830a(String str, JavaType javaType) {
        if (this.aVo == null || this.aVo.size() == 0) {
            this.aVo = new LinkedHashMap();
        }
        this.aVo.put(str, javaType);
    }

    public JavaType[] GY() {
        if (this.aVo == null) {
            GZ();
        }
        if (this.aVo.size() == 0) {
            return aVk;
        }
        return (JavaType[]) this.aVo.values().toArray(new JavaType[this.aVo.size()]);
    }

    protected void GZ() {
        m3831b(this.aVn);
        if (this.aVm != null) {
            int containedTypeCount = this.aVm.containedTypeCount();
            if (containedTypeCount > 0) {
                for (int i = 0; i < containedTypeCount; i++) {
                    m3830a(this.aVm.containedTypeName(i), this.aVm.containedType(i));
                }
            }
        }
        if (this.aVo == null) {
            this.aVo = Collections.emptyMap();
        }
    }

    public void bZ(String str) {
        if (this.aVp == null) {
            this.aVp = new HashSet();
        }
        this.aVp.add(str);
    }

    protected void m3831b(Type type) {
        int i = 0;
        if (type != null) {
            Class cls;
            int i2;
            TypeVariable[] typeParameters;
            String name;
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                if (actualTypeArguments != null && actualTypeArguments.length > 0) {
                    cls = (Class) parameterizedType.getRawType();
                    typeParameters = cls.getTypeParameters();
                    if (typeParameters.length != actualTypeArguments.length) {
                        throw new IllegalArgumentException("Strange parametrized type (in class " + cls.getName() + "): number of type arguments != number of type parameters (" + actualTypeArguments.length + " vs " + typeParameters.length + ")");
                    }
                    int length = actualTypeArguments.length;
                    for (int i3 = 0; i3 < length; i3++) {
                        name = typeParameters[i3].getName();
                        if (this.aVo == null) {
                            this.aVo = new LinkedHashMap();
                        } else if (this.aVo.containsKey(name)) {
                        }
                        bZ(name);
                        this.aVo.put(name, this._typeFactory._constructType(actualTypeArguments[i3], this));
                    }
                }
                cls = (Class) parameterizedType.getRawType();
            } else if (type instanceof Class) {
                Class cls2 = (Class) type;
                cls = cls2.getDeclaringClass();
                if (!(cls == null || cls.isAssignableFrom(cls2))) {
                    m3831b(cls2.getDeclaringClass());
                }
                typeParameters = cls2.getTypeParameters();
                if (typeParameters != null && typeParameters.length > 0) {
                    JavaType[] javaTypeArr = null;
                    if (this.aVm != null && cls2.isAssignableFrom(this.aVm.getRawClass())) {
                        javaTypeArr = this._typeFactory.findTypeParameters(this.aVm, cls2);
                    }
                    i2 = 0;
                    while (i2 < typeParameters.length) {
                        TypeVariable typeVariable = typeParameters[i2];
                        name = typeVariable.getName();
                        Type type2 = typeVariable.getBounds()[0];
                        if (type2 != null) {
                            if (this.aVo == null) {
                                this.aVo = new LinkedHashMap();
                            } else if (this.aVo.containsKey(name)) {
                            }
                            bZ(name);
                            if (javaTypeArr == null || javaTypeArr.length <= i2) {
                                this.aVo.put(name, this._typeFactory._constructType(type2, this));
                            } else {
                                this.aVo.put(name, javaTypeArr[i2]);
                            }
                        }
                        i2++;
                    }
                }
                cls = cls2;
            } else {
                return;
            }
            m3831b(cls.getGenericSuperclass());
            Type[] genericInterfaces = cls.getGenericInterfaces();
            i2 = genericInterfaces.length;
            while (i < i2) {
                m3831b(genericInterfaces[i]);
                i++;
            }
        }
    }

    public String toString() {
        if (this.aVo == null) {
            GZ();
        }
        StringBuilder stringBuilder = new StringBuilder("[TypeBindings for ");
        if (this.aVm != null) {
            stringBuilder.append(this.aVm.toString());
        } else {
            stringBuilder.append(this.aVn.getName());
        }
        stringBuilder.append(": ").append(this.aVo).append("]");
        return stringBuilder.toString();
    }
}
