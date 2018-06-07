package com.fossil;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.a;
import com.google.common.collect.Maps;
import com.google.common.reflect.Types;
import com.google.common.reflect.Types.WildcardTypeImpl;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public final class ced {
    private final C2016b bOr;

    static final class C2015a extends cee {
        private static final C2019d bOu = new C2019d();
        private final Map<C2018c, Type> bOv = Maps.Vu();

        private C2015a() {
        }

        static ImmutableMap<C2018c, Type> m6065e(Type type) {
            C2015a c2015a = new C2015a();
            c2015a.m6058g(bOu.m6080h(type));
            return ImmutableMap.copyOf(c2015a.bOv);
        }

        void mo1647P(Class<?> cls) {
            m6058g(cls.getGenericSuperclass());
            m6058g(cls.getGenericInterfaces());
        }

        void mo1650b(ParameterizedType parameterizedType) {
            boolean z;
            TypeVariable[] typeParameters = ((Class) parameterizedType.getRawType()).getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            if (typeParameters.length == actualTypeArguments.length) {
                z = true;
            } else {
                z = false;
            }
            cco.bA(z);
            for (int i = 0; i < typeParameters.length; i++) {
                m6064a(new C2018c(typeParameters[i]), actualTypeArguments[i]);
            }
            m6058g(r0);
            m6058g(parameterizedType.getOwnerType());
        }

        void mo1648a(TypeVariable<?> typeVariable) {
            m6058g(typeVariable.getBounds());
        }

        void mo1651b(WildcardType wildcardType) {
            m6058g(wildcardType.getUpperBounds());
        }

        private void m6064a(C2018c c2018c, Type type) {
            if (!this.bOv.containsKey(c2018c)) {
                Type type2 = type;
                while (type2 != null) {
                    if (c2018c.m6076g(type2)) {
                        while (type != null) {
                            type = (Type) this.bOv.remove(C2018c.m6075f(type));
                        }
                        return;
                    }
                    type2 = (Type) this.bOv.get(C2018c.m6075f(type2));
                }
                this.bOv.put(c2018c, type);
            }
        }
    }

    static class C2016b {
        private final ImmutableMap<C2018c, Type> map;

        C2016b() {
            this.map = ImmutableMap.of();
        }

        private C2016b(ImmutableMap<C2018c, Type> immutableMap) {
            this.map = immutableMap;
        }

        final C2016b m6072v(Map<C2018c, ? extends Type> map) {
            a builder = ImmutableMap.builder();
            builder.s(this.map);
            for (Entry entry : map.entrySet()) {
                Object obj = (C2018c) entry.getKey();
                Type type = (Type) entry.getValue();
                cco.m5986a(!obj.m6076g(type), "Type variable %s bound to itself", obj);
                builder.z(obj, type);
            }
            return new C2016b(builder.UJ());
        }

        final Type m6071b(final TypeVariable<?> typeVariable) {
            return mo1652a(typeVariable, new C2016b(this) {
                final /* synthetic */ C2016b bOy;

                public Type mo1652a(TypeVariable<?> typeVariable, C2016b c2016b) {
                    return typeVariable.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) ? typeVariable : this.mo1652a(typeVariable, c2016b);
                }
            });
        }

        Type mo1652a(TypeVariable<?> typeVariable, C2016b c2016b) {
            Type type = (Type) this.map.get(new C2018c(typeVariable));
            if (type != null) {
                return new ced(c2016b).m6093d(type);
            }
            Type[] bounds = typeVariable.getBounds();
            if (bounds.length == 0) {
                return typeVariable;
            }
            Type[] a = new ced(c2016b).m6088a(bounds);
            if (Types.a.bOZ && Arrays.equals(bounds, a)) {
                return typeVariable;
            }
            return Types.a(typeVariable.getGenericDeclaration(), typeVariable.getName(), a);
        }
    }

    public static final class C2018c {
        private final TypeVariable<?> bOz;

        public C2018c(TypeVariable<?> typeVariable) {
            this.bOz = (TypeVariable) cco.ce(typeVariable);
        }

        public int hashCode() {
            return ccn.hashCode(this.bOz.getGenericDeclaration(), this.bOz.getName());
        }

        public boolean equals(Object obj) {
            if (obj instanceof C2018c) {
                return m6074c(((C2018c) obj).bOz);
            }
            return false;
        }

        public String toString() {
            return this.bOz.toString();
        }

        static C2018c m6075f(Type type) {
            if (type instanceof TypeVariable) {
                return new C2018c((TypeVariable) type);
            }
            return null;
        }

        boolean m6076g(Type type) {
            if (type instanceof TypeVariable) {
                return m6074c((TypeVariable) type);
            }
            return false;
        }

        private boolean m6074c(TypeVariable<?> typeVariable) {
            return this.bOz.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) && this.bOz.getName().equals(typeVariable.getName());
        }
    }

    static class C2019d {
        private final AtomicInteger bOA;

        C2019d() {
            this(new AtomicInteger());
        }

        private C2019d(AtomicInteger atomicInteger) {
            this.bOA = atomicInteger;
        }

        final Type m6080h(Type type) {
            cco.ce(type);
            if ((type instanceof Class) || (type instanceof TypeVariable)) {
                return type;
            }
            if (type instanceof GenericArrayType) {
                return Types.newArrayType(VH().m6080h(((GenericArrayType) type).getGenericComponentType()));
            } else if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Class cls = (Class) parameterizedType.getRawType();
                TypeVariable[] typeParameters = cls.getTypeParameters();
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for (int i = 0; i < actualTypeArguments.length; i++) {
                    actualTypeArguments[i] = m6077d(typeParameters[i]).m6080h(actualTypeArguments[i]);
                }
                return Types.a(VH().m6078i(parameterizedType.getOwnerType()), cls, actualTypeArguments);
            } else if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                if (wildcardType.getLowerBounds().length == 0) {
                    return mo1653b(wildcardType.getUpperBounds());
                }
                return type;
            } else {
                throw new AssertionError("must have been one of the known types");
            }
        }

        TypeVariable<?> mo1653b(Type[] typeArr) {
            return Types.a(C2019d.class, "capture#" + this.bOA.incrementAndGet() + "-of ? extends " + ccl.m5972c('&').m5977d(typeArr), typeArr);
        }

        private C2019d m6077d(final TypeVariable<?> typeVariable) {
            return new C2019d(this, this.bOA) {
                final /* synthetic */ C2019d bOC;

                TypeVariable<?> mo1653b(Type[] typeArr) {
                    Set linkedHashSet = new LinkedHashSet(Arrays.asList(typeArr));
                    linkedHashSet.addAll(Arrays.asList(typeVariable.getBounds()));
                    if (linkedHashSet.size() > 1) {
                        linkedHashSet.remove(Object.class);
                    }
                    return super.mo1653b((Type[]) linkedHashSet.toArray(new Type[0]));
                }
            };
        }

        private C2019d VH() {
            return new C2019d(this.bOA);
        }

        private Type m6078i(Type type) {
            if (type == null) {
                return null;
            }
            return m6080h(type);
        }
    }

    public ced() {
        this.bOr = new C2016b();
    }

    private ced(C2016b c2016b) {
        this.bOr = c2016b;
    }

    public static ced m6091c(Type type) {
        return new ced().m6094u(C2015a.m6065e(type));
    }

    public ced m6092a(Type type, Type type2) {
        Map Vu = Maps.Vu();
        m6086a(Vu, (Type) cco.ce(type), (Type) cco.ce(type2));
        return m6094u(Vu);
    }

    public ced m6094u(Map<C2018c, ? extends Type> map) {
        return new ced(this.bOr.m6072v(map));
    }

    private static void m6086a(final Map<C2018c, Type> map, Type type, final Type type2) {
        if (!type.equals(type2)) {
            new cee() {
                void mo1648a(TypeVariable<?> typeVariable) {
                    map.put(new C2018c(typeVariable), type2);
                }

                void mo1651b(WildcardType wildcardType) {
                    int i = 0;
                    if (type2 instanceof WildcardType) {
                        WildcardType wildcardType2 = (WildcardType) type2;
                        Type[] upperBounds = wildcardType.getUpperBounds();
                        Type[] upperBounds2 = wildcardType2.getUpperBounds();
                        Type[] lowerBounds = wildcardType.getLowerBounds();
                        Type[] lowerBounds2 = wildcardType2.getLowerBounds();
                        boolean z = upperBounds.length == upperBounds2.length && lowerBounds.length == lowerBounds2.length;
                        cco.m5987a(z, "Incompatible type: %s vs. %s", (Object) wildcardType, type2);
                        for (int i2 = 0; i2 < upperBounds.length; i2++) {
                            ced.m6086a(map, upperBounds[i2], upperBounds2[i2]);
                        }
                        while (i < lowerBounds.length) {
                            ced.m6086a(map, lowerBounds[i], lowerBounds2[i]);
                            i++;
                        }
                    }
                }

                void mo1650b(ParameterizedType parameterizedType) {
                    int i = 0;
                    if (!(type2 instanceof WildcardType)) {
                        Object obj = (ParameterizedType) ced.m6082a(ParameterizedType.class, (Object) type2);
                        if (!(parameterizedType.getOwnerType() == null || obj.getOwnerType() == null)) {
                            ced.m6086a(map, parameterizedType.getOwnerType(), obj.getOwnerType());
                        }
                        cco.m5987a(parameterizedType.getRawType().equals(obj.getRawType()), "Inconsistent raw type: %s vs. %s", (Object) parameterizedType, type2);
                        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                        Type[] actualTypeArguments2 = obj.getActualTypeArguments();
                        cco.m5987a(actualTypeArguments.length == actualTypeArguments2.length, "%s not compatible with %s", (Object) parameterizedType, obj);
                        while (i < actualTypeArguments.length) {
                            ced.m6086a(map, actualTypeArguments[i], actualTypeArguments2[i]);
                            i++;
                        }
                    }
                }

                void mo1649b(GenericArrayType genericArrayType) {
                    if (!(type2 instanceof WildcardType)) {
                        Type r = Types.r(type2);
                        cco.m5986a(r != null, "%s is not an array type.", type2);
                        ced.m6086a(map, genericArrayType.getGenericComponentType(), r);
                    }
                }

                void mo1647P(Class<?> cls) {
                    if (!(type2 instanceof WildcardType)) {
                        throw new IllegalArgumentException("No type mapping from " + cls + " to " + type2);
                    }
                }
            }.m6058g(type);
        }
    }

    public Type m6093d(Type type) {
        cco.ce(type);
        if (type instanceof TypeVariable) {
            return this.bOr.m6071b((TypeVariable) type);
        }
        if (type instanceof ParameterizedType) {
            return m6083a((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return m6084a((GenericArrayType) type);
        }
        if (type instanceof WildcardType) {
            return m6085a((WildcardType) type);
        }
        return type;
    }

    private Type[] m6088a(Type[] typeArr) {
        Type[] typeArr2 = new Type[typeArr.length];
        for (int i = 0; i < typeArr.length; i++) {
            typeArr2[i] = m6093d(typeArr[i]);
        }
        return typeArr2;
    }

    private WildcardType m6085a(WildcardType wildcardType) {
        return new WildcardTypeImpl(m6088a(wildcardType.getLowerBounds()), m6088a(wildcardType.getUpperBounds()));
    }

    private Type m6084a(GenericArrayType genericArrayType) {
        return Types.newArrayType(m6093d(genericArrayType.getGenericComponentType()));
    }

    private ParameterizedType m6083a(ParameterizedType parameterizedType) {
        Type ownerType = parameterizedType.getOwnerType();
        return Types.a(ownerType == null ? null : m6093d(ownerType), (Class) m6093d(parameterizedType.getRawType()), m6088a(parameterizedType.getActualTypeArguments()));
    }

    private static <T> T m6082a(Class<T> cls, Object obj) {
        try {
            return cls.cast(obj);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException(obj + " is not a " + cls.getSimpleName());
        }
    }
}
