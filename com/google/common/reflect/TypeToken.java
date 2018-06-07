package com.google.common.reflect;

import com.fossil.ccl;
import com.fossil.cco;
import com.fossil.ccp;
import com.fossil.ccy;
import com.fossil.cdd;
import com.fossil.cdx;
import com.fossil.cdz;
import com.fossil.cdz.a;
import com.fossil.cdz.b;
import com.fossil.ceb;
import com.fossil.cec;
import com.fossil.ced;
import com.fossil.ced.c;
import com.fossil.cee;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$a;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet$a;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class TypeToken<T> extends ceb<T> implements Serializable {
    private transient ced bOD;
    private final Type runtimeType;

    class C43673 extends cee {
        C43673() {
        }

        void m14490a(TypeVariable<?> typeVariable) {
            throw new IllegalArgumentException(TypeToken.this.runtimeType + "contains a type variable and is not safe for the operation");
        }

        void m14493b(WildcardType wildcardType) {
            g(wildcardType.getLowerBounds());
            g(wildcardType.getUpperBounds());
        }

        void m14492b(ParameterizedType parameterizedType) {
            g(parameterizedType.getActualTypeArguments());
            g(new Type[]{parameterizedType.getOwnerType()});
        }

        void m14491b(GenericArrayType genericArrayType) {
            g(new Type[]{genericArrayType.getGenericComponentType()});
        }
    }

    public class TypeSet extends cdd<TypeToken<? super T>> implements Serializable {
        private static final long serialVersionUID = 0;
        private transient ImmutableSet<TypeToken<? super T>> bOS;

        TypeSet() {
        }

        public TypeSet interfaces() {
            return new InterfaceSet(this);
        }

        public TypeSet classes() {
            return new ClassSet();
        }

        protected Set<TypeToken<? super T>> delegate() {
            Set<TypeToken<? super T>> set = this.bOS;
            if (set != null) {
                return set;
            }
            Set UE = ccy.d(C4373b.bOL.cz(TypeToken.this)).b(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).UE();
            this.bOS = UE;
            return UE;
        }

        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf(C4373b.bOM.mo4552t(TypeToken.this.VJ()));
        }
    }

    final class ClassSet extends TypeSet {
        private static final long serialVersionUID = 0;
        private transient ImmutableSet<TypeToken<? super T>> bOH;

        private ClassSet() {
            super();
        }

        protected Set<TypeToken<? super T>> delegate() {
            Set<TypeToken<? super T>> set = this.bOH;
            if (set != null) {
                return set;
            }
            Set UE = ccy.d(C4373b.bOL.VL().cz(TypeToken.this)).b(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).UE();
            this.bOH = UE;
            return UE;
        }

        public TypeSet classes() {
            return this;
        }

        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf(C4373b.bOM.VL().mo4552t(TypeToken.this.VJ()));
        }

        public TypeSet interfaces() {
            throw new UnsupportedOperationException("classes().interfaces() not supported.");
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().classes();
        }
    }

    final class InterfaceSet extends TypeSet {
        private static final long serialVersionUID = 0;
        private final transient TypeSet bOI;
        private transient ImmutableSet<TypeToken<? super T>> bOJ;

        class C43691 implements ccp<Class<?>> {
            final /* synthetic */ InterfaceSet bOK;

            C43691(InterfaceSet interfaceSet) {
                this.bOK = interfaceSet;
            }

            public /* synthetic */ boolean apply(Object obj) {
                return m14499U((Class) obj);
            }

            public boolean m14499U(Class<?> cls) {
                return cls.isInterface();
            }
        }

        InterfaceSet(TypeSet typeSet) {
            super();
            this.bOI = typeSet;
        }

        protected Set<TypeToken<? super T>> delegate() {
            Set<TypeToken<? super T>> set = this.bOJ;
            if (set != null) {
                return set;
            }
            Set UE = ccy.d(this.bOI).b(TypeFilter.INTERFACE_ONLY).UE();
            this.bOJ = UE;
            return UE;
        }

        public TypeSet interfaces() {
            return this;
        }

        public Set<Class<? super T>> rawTypes() {
            return ccy.d(C4373b.bOM.mo4552t(TypeToken.this.VJ())).b(new C43691(this)).UE();
        }

        public TypeSet classes() {
            throw new UnsupportedOperationException("interfaces().classes() not supported.");
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().interfaces();
        }
    }

    static final class SimpleTypeToken<T> extends TypeToken<T> {
        private static final long serialVersionUID = 0;

        SimpleTypeToken(Type type) {
            super(type);
        }
    }

    enum TypeFilter implements ccp<TypeToken<?>> {
        IGNORE_TYPE_VARIABLE_OR_WILDCARD {
            public boolean apply(TypeToken<?> typeToken) {
                return ((typeToken.runtimeType instanceof TypeVariable) || (typeToken.runtimeType instanceof WildcardType)) ? false : true;
            }
        },
        INTERFACE_ONLY {
            public boolean apply(TypeToken<?> typeToken) {
                return typeToken.getRawType().isInterface();
            }
        }
    }

    static class C4372a {
        private final Type[] bOF;
        private final boolean bOG;

        C4372a(Type[] typeArr, boolean z) {
            this.bOF = typeArr;
            this.bOG = z;
        }

        boolean isSubtypeOf(Type type) {
            for (Type of : this.bOF) {
                if (TypeToken.of(of).isSubtypeOf(type) == this.bOG) {
                    return this.bOG;
                }
            }
            if (this.bOG) {
                return false;
            }
            return true;
        }

        boolean isSupertypeOf(Type type) {
            TypeToken of = TypeToken.of(type);
            for (Type isSubtypeOf : this.bOF) {
                if (of.isSubtypeOf(isSubtypeOf) == this.bOG) {
                    return this.bOG;
                }
            }
            if (this.bOG) {
                return false;
            }
            return true;
        }
    }

    static abstract class C4373b<K> {
        static final C4373b<TypeToken<?>> bOL = new C43741();
        static final C4373b<Class<?>> bOM = new C43752();

        static class C43741 extends C4373b<TypeToken<?>> {
            C43741() {
                super();
            }

            /* synthetic */ Class cA(Object obj) {
                return m14521a((TypeToken) obj);
            }

            /* synthetic */ Iterable cB(Object obj) {
                return m14522b((TypeToken) obj);
            }

            /* synthetic */ Object cC(Object obj) {
                return m14523c((TypeToken) obj);
            }

            Class<?> m14521a(TypeToken<?> typeToken) {
                return typeToken.getRawType();
            }

            Iterable<? extends TypeToken<?>> m14522b(TypeToken<?> typeToken) {
                return typeToken.getGenericInterfaces();
            }

            TypeToken<?> m14523c(TypeToken<?> typeToken) {
                return typeToken.getGenericSuperclass();
            }
        }

        static class C43752 extends C4373b<Class<?>> {
            C43752() {
                super();
            }

            /* synthetic */ Class cA(Object obj) {
                return m14524V((Class) obj);
            }

            /* synthetic */ Iterable cB(Object obj) {
                return m14525W((Class) obj);
            }

            /* synthetic */ Object cC(Object obj) {
                return m14526X((Class) obj);
            }

            Class<?> m14524V(Class<?> cls) {
                return cls;
            }

            Iterable<? extends Class<?>> m14525W(Class<?> cls) {
                return Arrays.asList(cls.getInterfaces());
            }

            Class<?> m14526X(Class<?> cls) {
                return cls.getSuperclass();
            }
        }

        static class C4376a<K> extends C4373b<K> {
            private final C4373b<K> bOQ;

            C4376a(C4373b<K> c4373b) {
                super();
                this.bOQ = c4373b;
            }

            Class<?> cA(K k) {
                return this.bOQ.cA(k);
            }

            Iterable<? extends K> cB(K k) {
                return this.bOQ.cB(k);
            }

            K cC(K k) {
                return this.bOQ.cC(k);
            }
        }

        abstract Class<?> cA(K k);

        abstract Iterable<? extends K> cB(K k);

        abstract K cC(K k);

        private C4373b() {
        }

        final C4373b<K> VL() {
            return new C4376a<K>(this, this) {
                final /* synthetic */ C4373b bON;

                Iterable<? extends K> cB(K k) {
                    return ImmutableSet.of();
                }

                ImmutableList<K> mo4552t(Iterable<? extends K> iterable) {
                    ImmutableList$a builder = ImmutableList.builder();
                    for (Object next : iterable) {
                        if (!cA(next).isInterface()) {
                            builder.cp(next);
                        }
                    }
                    return super.mo4552t(builder.UF());
                }
            };
        }

        final ImmutableList<K> cz(K k) {
            return mo4552t(ImmutableList.of(k));
        }

        ImmutableList<K> mo4552t(Iterable<? extends K> iterable) {
            Map Vu = Maps.Vu();
            for (Object a : iterable) {
                m14518a(a, Vu);
            }
            return C4373b.m14519a(Vu, Ordering.natural().reverse());
        }

        private int m14518a(K k, Map<? super K, Integer> map) {
            Integer num = (Integer) map.get(k);
            if (num != null) {
                return num.intValue();
            }
            int i = cA(k).isInterface() ? 1 : 0;
            for (Object a : cB(k)) {
                i = Math.max(i, m14518a(a, (Map) map));
            }
            Object cC = cC(k);
            if (cC != null) {
                i = Math.max(i, m14518a(cC, (Map) map));
            }
            map.put(k, Integer.valueOf(i + 1));
            return i + 1;
        }

        private static <K, V> ImmutableList<K> m14519a(final Map<K, V> map, final Comparator<? super V> comparator) {
            return new Ordering<K>() {
                public int compare(K k, K k2) {
                    return comparator.compare(map.get(k), map.get(k2));
                }
            }.immutableSortedCopy(map.keySet());
        }
    }

    protected TypeToken() {
        this.runtimeType = capture();
        cco.b(!(this.runtimeType instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", this.runtimeType);
    }

    protected TypeToken(Class<?> cls) {
        Type capture = super.capture();
        if (capture instanceof Class) {
            this.runtimeType = capture;
        } else {
            this.runtimeType = of((Class) cls).resolveType(capture).runtimeType;
        }
    }

    private TypeToken(Type type) {
        this.runtimeType = (Type) cco.ce(type);
    }

    public static <T> TypeToken<T> of(Class<T> cls) {
        return new SimpleTypeToken(cls);
    }

    public static TypeToken<?> of(Type type) {
        return new SimpleTypeToken(type);
    }

    public final Class<? super T> getRawType() {
        return (Class) VJ().iterator().next();
    }

    public final Type getType() {
        return this.runtimeType;
    }

    public final <X> TypeToken<T> where(cec<X> com_fossil_cec_X, TypeToken<X> typeToken) {
        return new SimpleTypeToken(new ced().u(ImmutableMap.of(new c(com_fossil_cec_X.bOq), typeToken.runtimeType)).d(this.runtimeType));
    }

    public final <X> TypeToken<T> where(cec<X> com_fossil_cec_X, Class<X> cls) {
        return where((cec) com_fossil_cec_X, of((Class) cls));
    }

    public final TypeToken<?> resolveType(Type type) {
        cco.ce(type);
        ced com_fossil_ced = this.bOD;
        if (com_fossil_ced == null) {
            com_fossil_ced = ced.c(this.runtimeType);
            this.bOD = com_fossil_ced;
        }
        return of(com_fossil_ced.d(type));
    }

    private Type[] m14508c(Type[] typeArr) {
        for (int i = 0; i < typeArr.length; i++) {
            typeArr[i] = resolveType(typeArr[i]).getType();
        }
        return typeArr;
    }

    private TypeToken<?> m14513j(Type type) {
        TypeToken<?> resolveType = resolveType(type);
        resolveType.bOD = this.bOD;
        return resolveType;
    }

    final TypeToken<? super T> getGenericSuperclass() {
        if (this.runtimeType instanceof TypeVariable) {
            return m14514k(((TypeVariable) this.runtimeType).getBounds()[0]);
        }
        if (this.runtimeType instanceof WildcardType) {
            return m14514k(((WildcardType) this.runtimeType).getUpperBounds()[0]);
        }
        Type genericSuperclass = getRawType().getGenericSuperclass();
        if (genericSuperclass == null) {
            return null;
        }
        return m14513j(genericSuperclass);
    }

    private TypeToken<? super T> m14514k(Type type) {
        TypeToken<? super T> of = of(type);
        if (of.getRawType().isInterface()) {
            return null;
        }
        return of;
    }

    final ImmutableList<TypeToken<? super T>> getGenericInterfaces() {
        if (this.runtimeType instanceof TypeVariable) {
            return m14509d(((TypeVariable) this.runtimeType).getBounds());
        }
        if (this.runtimeType instanceof WildcardType) {
            return m14509d(((WildcardType) this.runtimeType).getUpperBounds());
        }
        ImmutableList$a builder = ImmutableList.builder();
        for (Type j : getRawType().getGenericInterfaces()) {
            builder.cp(m14513j(j));
        }
        return builder.UF();
    }

    private ImmutableList<TypeToken<? super T>> m14509d(Type[] typeArr) {
        ImmutableList$a builder = ImmutableList.builder();
        for (Type of : typeArr) {
            TypeToken of2 = of(of);
            if (of2.getRawType().isInterface()) {
                builder.cp(of2);
            }
        }
        return builder.UF();
    }

    public final TypeSet getTypes() {
        return new TypeSet();
    }

    public final TypeToken<? super T> getSupertype(Class<? super T> cls) {
        cco.a(m14500Q(cls), "%s is not a super class of %s", cls, this);
        if (this.runtimeType instanceof TypeVariable) {
            return m14504a(cls, ((TypeVariable) this.runtimeType).getBounds());
        }
        if (this.runtimeType instanceof WildcardType) {
            return m14504a(cls, ((WildcardType) this.runtimeType).getUpperBounds());
        }
        if (cls.isArray()) {
            return m14501R(cls);
        }
        return m14513j(toGenericType(cls).runtimeType);
    }

    public final TypeToken<? extends T> getSubtype(Class<?> cls) {
        cco.a(!(this.runtimeType instanceof TypeVariable), "Cannot get subtype of type variable <%s>", this);
        if (this.runtimeType instanceof WildcardType) {
            return m14505b(cls, ((WildcardType) this.runtimeType).getLowerBounds());
        }
        if (isArray()) {
            return m14502S(cls);
        }
        cco.a(getRawType().isAssignableFrom(cls), "%s isn't a subclass of %s", cls, this);
        return of(m14503T(cls));
    }

    public final boolean isSupertypeOf(TypeToken<?> typeToken) {
        return typeToken.isSubtypeOf(getType());
    }

    public final boolean isSupertypeOf(Type type) {
        return of(type).isSubtypeOf(getType());
    }

    public final boolean isSubtypeOf(TypeToken<?> typeToken) {
        return isSubtypeOf(typeToken.getType());
    }

    public final boolean isSubtypeOf(Type type) {
        cco.ce(type);
        if (type instanceof WildcardType) {
            return m14512f(((WildcardType) type).getLowerBounds()).isSupertypeOf(this.runtimeType);
        }
        if (this.runtimeType instanceof WildcardType) {
            return m14512f(((WildcardType) this.runtimeType).getUpperBounds()).isSubtypeOf(type);
        }
        if (this.runtimeType instanceof TypeVariable) {
            return this.runtimeType.equals(type) || m14512f(((TypeVariable) this.runtimeType).getBounds()).isSubtypeOf(type);
        } else {
            if (this.runtimeType instanceof GenericArrayType) {
                return of(type).m14510d((GenericArrayType) this.runtimeType);
            }
            if (type instanceof Class) {
                return m14500Q((Class) type);
            }
            if (type instanceof ParameterizedType) {
                return m14507c((ParameterizedType) type);
            }
            return type instanceof GenericArrayType ? m14506c((GenericArrayType) type) : false;
        }
    }

    public final boolean isArray() {
        return getComponentType() != null;
    }

    public final boolean isPrimitive() {
        return (this.runtimeType instanceof Class) && ((Class) this.runtimeType).isPrimitive();
    }

    public final TypeToken<T> wrap() {
        if (isPrimitive()) {
            return of(cdx.N((Class) this.runtimeType));
        }
        return this;
    }

    private boolean VI() {
        return cdx.VE().contains(this.runtimeType);
    }

    public final TypeToken<T> unwrap() {
        if (VI()) {
            return of(cdx.O((Class) this.runtimeType));
        }
        return this;
    }

    public final TypeToken<?> getComponentType() {
        Type r = Types.m14548r(this.runtimeType);
        if (r == null) {
            return null;
        }
        return of(r);
    }

    public final cdz<T, Object> method(Method method) {
        cco.a(m14500Q(method.getDeclaringClass()), "%s not declared by %s", method, this);
        return new b<T>(method) {
            Type[] getGenericParameterTypes() {
                return TypeToken.this.m14508c(super.getGenericParameterTypes());
            }

            public TypeToken<T> VF() {
                return TypeToken.this;
            }

            public String toString() {
                return VF() + "." + super.toString();
            }
        };
    }

    public final cdz<T, T> constructor(Constructor<?> constructor) {
        cco.a(constructor.getDeclaringClass() == getRawType(), "%s not declared by %s", constructor, getRawType());
        return new a<T>(constructor) {
            Type[] getGenericParameterTypes() {
                return TypeToken.this.m14508c(super.getGenericParameterTypes());
            }

            public TypeToken<T> VF() {
                return TypeToken.this;
            }

            public String toString() {
                return VF() + "(" + ccl.fc(", ").d(getGenericParameterTypes()) + ")";
            }
        };
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TypeToken)) {
            return false;
        }
        return this.runtimeType.equals(((TypeToken) obj).runtimeType);
    }

    public int hashCode() {
        return this.runtimeType.hashCode();
    }

    public String toString() {
        return Types.m14547q(this.runtimeType);
    }

    protected Object writeReplace() {
        return of(new ced().d(this.runtimeType));
    }

    final TypeToken<T> rejectTypeVariables() {
        new C43673().g(new Type[]{this.runtimeType});
        return this;
    }

    private boolean m14500Q(Class<?> cls) {
        Iterator it = VJ().iterator();
        while (it.hasNext()) {
            if (cls.isAssignableFrom((Class) it.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean m14507c(ParameterizedType parameterizedType) {
        Class rawType = of((Type) parameterizedType).getRawType();
        if (!m14500Q(rawType)) {
            return false;
        }
        TypeVariable[] typeParameters = rawType.getTypeParameters();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i = 0; i < typeParameters.length; i++) {
            if (!resolveType(typeParameters[i]).m14515l(actualTypeArguments[i])) {
                return false;
            }
        }
        if (Modifier.isStatic(((Class) parameterizedType.getRawType()).getModifiers()) || parameterizedType.getOwnerType() == null || m14516m(parameterizedType.getOwnerType())) {
            return true;
        }
        return false;
    }

    private boolean m14506c(GenericArrayType genericArrayType) {
        if (!(this.runtimeType instanceof Class)) {
            return this.runtimeType instanceof GenericArrayType ? of(((GenericArrayType) this.runtimeType).getGenericComponentType()).isSubtypeOf(genericArrayType.getGenericComponentType()) : false;
        } else {
            Class cls = (Class) this.runtimeType;
            if (cls.isArray()) {
                return of(cls.getComponentType()).isSubtypeOf(genericArrayType.getGenericComponentType());
            }
            return false;
        }
    }

    private boolean m14510d(GenericArrayType genericArrayType) {
        if (this.runtimeType instanceof Class) {
            Class cls = (Class) this.runtimeType;
            if (cls.isArray()) {
                return of(genericArrayType.getGenericComponentType()).isSubtypeOf(cls.getComponentType());
            }
            return cls.isAssignableFrom(Object[].class);
        } else if (this.runtimeType instanceof GenericArrayType) {
            return of(genericArrayType.getGenericComponentType()).isSubtypeOf(((GenericArrayType) this.runtimeType).getGenericComponentType());
        } else {
            return false;
        }
    }

    private boolean m14515l(Type type) {
        if (this.runtimeType.equals(type)) {
            return true;
        }
        if (!(type instanceof WildcardType)) {
            return false;
        }
        boolean z;
        if (m14511e(((WildcardType) type).getUpperBounds()).isSupertypeOf(this.runtimeType) && m14511e(((WildcardType) type).getLowerBounds()).isSubtypeOf(this.runtimeType)) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    private static C4372a m14511e(Type[] typeArr) {
        return new C4372a(typeArr, false);
    }

    private static C4372a m14512f(Type[] typeArr) {
        return new C4372a(typeArr, true);
    }

    private ImmutableSet<Class<? super T>> VJ() {
        final ImmutableSet$a builder = ImmutableSet.builder();
        new cee() {
            void m14495a(TypeVariable<?> typeVariable) {
                g(typeVariable.getBounds());
            }

            void m14498b(WildcardType wildcardType) {
                g(wildcardType.getUpperBounds());
            }

            void m14497b(ParameterizedType parameterizedType) {
                builder.cr((Class) parameterizedType.getRawType());
            }

            void m14494P(Class<?> cls) {
                builder.cr(cls);
            }

            void m14496b(GenericArrayType genericArrayType) {
                builder.cr(Types.m14534Y(TypeToken.of(genericArrayType.getGenericComponentType()).getRawType()));
            }
        }.g(new Type[]{this.runtimeType});
        return builder.UN();
    }

    private boolean m14516m(Type type) {
        Iterator it = getTypes().iterator();
        while (it.hasNext()) {
            Type VK = ((TypeToken) it.next()).VK();
            if (VK != null && of(VK).isSubtypeOf(type)) {
                return true;
            }
        }
        return false;
    }

    private Type VK() {
        if (this.runtimeType instanceof ParameterizedType) {
            return ((ParameterizedType) this.runtimeType).getOwnerType();
        }
        if (this.runtimeType instanceof Class) {
            return ((Class) this.runtimeType).getEnclosingClass();
        }
        return null;
    }

    static <T> TypeToken<? extends T> toGenericType(Class<T> cls) {
        if (cls.isArray()) {
            return of(Types.newArrayType(toGenericType(cls.getComponentType()).runtimeType));
        }
        Type[] typeParameters = cls.getTypeParameters();
        Type type = (!cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) ? null : toGenericType(cls.getEnclosingClass()).runtimeType;
        if (typeParameters.length > 0 || (type != null && type != cls.getEnclosingClass())) {
            return of(Types.m14535a(type, (Class) cls, typeParameters));
        }
        return of((Class) cls);
    }

    private TypeToken<? super T> m14504a(Class<? super T> cls, Type[] typeArr) {
        for (Type of : typeArr) {
            TypeToken of2 = of(of);
            if (of2.isSubtypeOf((Type) cls)) {
                return of2.getSupertype(cls);
            }
        }
        throw new IllegalArgumentException(cls + " isn't a super type of " + this);
    }

    private TypeToken<? extends T> m14505b(Class<?> cls, Type[] typeArr) {
        if (0 < typeArr.length) {
            return of(typeArr[0]).getSubtype(cls);
        }
        throw new IllegalArgumentException(cls + " isn't a subclass of " + this);
    }

    private TypeToken<? super T> m14501R(Class<? super T> cls) {
        return of(m14517n(((TypeToken) cco.a(getComponentType(), "%s isn't a super type of %s", cls, this)).getSupertype(cls.getComponentType()).runtimeType));
    }

    private TypeToken<? extends T> m14502S(Class<?> cls) {
        return of(m14517n(getComponentType().getSubtype(cls.getComponentType()).runtimeType));
    }

    private Type m14503T(Class<?> cls) {
        if ((this.runtimeType instanceof Class) && (cls.getTypeParameters().length == 0 || getRawType().getTypeParameters().length != 0)) {
            return cls;
        }
        TypeToken toGenericType = toGenericType(cls);
        return new ced().a(toGenericType.getSupertype(getRawType()).runtimeType, this.runtimeType).d(toGenericType.runtimeType);
    }

    private static Type m14517n(Type type) {
        return JavaVersion.JAVA7.newArrayType(type);
    }
}
