package com.google.common.reflect;

import com.fossil.cck;
import com.fossil.ccl;
import com.fossil.ccn;
import com.fossil.cco;
import com.fossil.cdg;
import com.fossil.cea;
import com.fossil.ceb;
import com.fossil.cee;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$a;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$a;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicReference;

public final class Types {
    private static final cck<Type, String> bOU = new C43791();
    private static final ccl bOV = ccl.fc(", ").fd("null");

    static class C43791 implements cck<Type, String> {
        C43791() {
        }

        public /* synthetic */ Object apply(Object obj) {
            return m14528s((Type) obj);
        }

        public String m14528s(Type type) {
            return JavaVersion.CURRENT.typeName(type);
        }
    }

    enum ClassOwnership {
        OWNED_BY_ENCLOSING_CLASS {
            Class<?> getOwnerType(Class<?> cls) {
                return cls.getEnclosingClass();
            }
        },
        LOCAL_CLASS_HAS_NO_OWNER {
            Class<?> getOwnerType(Class<?> cls) {
                if (cls.isLocalClass()) {
                    return null;
                }
                return cls.getEnclosingClass();
            }
        };
        
        static final ClassOwnership JVM_BEHAVIOR = null;

        class C4383a<T> {
            C4383a() {
            }
        }

        static class C43843 extends C4383a<String> {
            C43843() {
            }
        }

        abstract Class<?> getOwnerType(Class<?> cls);

        static {
            JVM_BEHAVIOR = VO();
        }

        private static ClassOwnership VO() {
            ParameterizedType parameterizedType = (ParameterizedType) new C43843().getClass().getGenericSuperclass();
            for (ClassOwnership classOwnership : values()) {
                if (classOwnership.getOwnerType(C4383a.class) == parameterizedType.getOwnerType()) {
                    return classOwnership;
                }
            }
            throw new AssertionError();
        }
    }

    static final class GenericArrayTypeImpl implements Serializable, GenericArrayType {
        private static final long serialVersionUID = 0;
        private final Type componentType;

        GenericArrayTypeImpl(Type type) {
            this.componentType = JavaVersion.CURRENT.usedInGenericType(type);
        }

        public Type getGenericComponentType() {
            return this.componentType;
        }

        public String toString() {
            return Types.m14547q(this.componentType) + "[]";
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof GenericArrayType)) {
                return false;
            }
            return ccn.equal(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
        }
    }

    enum JavaVersion {
        JAVA6 {
            GenericArrayType newArrayType(Type type) {
                return new GenericArrayTypeImpl(type);
            }

            Type usedInGenericType(Type type) {
                cco.ce(type);
                if (!(type instanceof Class)) {
                    return type;
                }
                Class cls = (Class) type;
                if (cls.isArray()) {
                    return new GenericArrayTypeImpl(cls.getComponentType());
                }
                return type;
            }
        },
        JAVA7 {
            Type newArrayType(Type type) {
                if (type instanceof Class) {
                    return Types.m14534Y((Class) type);
                }
                return new GenericArrayTypeImpl(type);
            }

            Type usedInGenericType(Type type) {
                return (Type) cco.ce(type);
            }
        },
        JAVA8 {
            Type newArrayType(Type type) {
                return JAVA7.newArrayType(type);
            }

            Type usedInGenericType(Type type) {
                return JAVA7.usedInGenericType(type);
            }

            String typeName(Type type) {
                try {
                    return (String) Type.class.getMethod("getTypeName", new Class[0]).invoke(type, new Object[0]);
                } catch (NoSuchMethodException e) {
                    throw new AssertionError("Type.getTypeName should be available in Java 8");
                } catch (Throwable e2) {
                    throw new RuntimeException(e2);
                } catch (Throwable e22) {
                    throw new RuntimeException(e22);
                }
            }
        },
        JAVA9 {
            Type newArrayType(Type type) {
                return JAVA8.newArrayType(type);
            }

            Type usedInGenericType(Type type) {
                return JAVA8.usedInGenericType(type);
            }

            String typeName(Type type) {
                return JAVA8.typeName(type);
            }

            boolean jdkTypeDuplicatesOwnerName() {
                return false;
            }
        };
        
        static final JavaVersion CURRENT = null;

        static class C43895 extends ceb<Entry<String, int[][]>> {
            C43895() {
            }
        }

        static class C43906 extends ceb<int[]> {
            C43906() {
            }
        }

        abstract Type newArrayType(Type type);

        abstract Type usedInGenericType(Type type);

        String typeName(Type type) {
            return Types.m14547q(type);
        }

        boolean jdkTypeDuplicatesOwnerName() {
            return true;
        }

        final ImmutableList<Type> usedInGenericType(Type[] typeArr) {
            ImmutableList$a builder = ImmutableList.builder();
            for (Type usedInGenericType : typeArr) {
                builder.cp(usedInGenericType(usedInGenericType));
            }
            return builder.UF();
        }
    }

    static final class ParameterizedTypeImpl implements Serializable, ParameterizedType {
        private static final long serialVersionUID = 0;
        private final ImmutableList<Type> argumentsList;
        private final Type ownerType;
        private final Class<?> rawType;

        ParameterizedTypeImpl(Type type, Class<?> cls, Type[] typeArr) {
            cco.ce(cls);
            cco.bz(typeArr.length == cls.getTypeParameters().length);
            Types.m14537a(typeArr, "type parameter");
            this.ownerType = type;
            this.rawType = cls;
            this.argumentsList = JavaVersion.CURRENT.usedInGenericType(typeArr);
        }

        public Type[] getActualTypeArguments() {
            return Types.m14543j(this.argumentsList);
        }

        public Type getRawType() {
            return this.rawType;
        }

        public Type getOwnerType() {
            return this.ownerType;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            if (this.ownerType != null && JavaVersion.CURRENT.jdkTypeDuplicatesOwnerName()) {
                stringBuilder.append(JavaVersion.CURRENT.typeName(this.ownerType)).append('.');
            }
            return stringBuilder.append(this.rawType.getName()).append('<').append(Types.bOV.b(cdg.a(this.argumentsList, Types.bOU))).append('>').toString();
        }

        public int hashCode() {
            return ((this.ownerType == null ? 0 : this.ownerType.hashCode()) ^ this.argumentsList.hashCode()) ^ this.rawType.hashCode();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            if (getRawType().equals(parameterizedType.getRawType()) && ccn.equal(getOwnerType(), parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments())) {
                return true;
            }
            return false;
        }
    }

    public static final class WildcardTypeImpl implements Serializable, WildcardType {
        private static final long serialVersionUID = 0;
        private final ImmutableList<Type> lowerBounds;
        private final ImmutableList<Type> upperBounds;

        public WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            Types.m14537a(typeArr, "lower bound for wildcard");
            Types.m14537a(typeArr2, "upper bound for wildcard");
            this.lowerBounds = JavaVersion.CURRENT.usedInGenericType(typeArr);
            this.upperBounds = JavaVersion.CURRENT.usedInGenericType(typeArr2);
        }

        public Type[] getLowerBounds() {
            return Types.m14543j(this.lowerBounds);
        }

        public Type[] getUpperBounds() {
            return Types.m14543j(this.upperBounds);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) obj;
            if (this.lowerBounds.equals(Arrays.asList(wildcardType.getLowerBounds())) && this.upperBounds.equals(Arrays.asList(wildcardType.getUpperBounds()))) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.lowerBounds.hashCode() ^ this.upperBounds.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("?");
            Iterator it = this.lowerBounds.iterator();
            while (it.hasNext()) {
                stringBuilder.append(" super ").append(JavaVersion.CURRENT.typeName((Type) it.next()));
            }
            for (Type typeName : Types.m14549u(this.upperBounds)) {
                stringBuilder.append(" extends ").append(JavaVersion.CURRENT.typeName(typeName));
            }
            return stringBuilder.toString();
        }
    }

    public static final class C4391a<X> {
        public static final boolean bOZ;

        C4391a() {
        }

        static {
            boolean z = false;
            if (!C4391a.class.getTypeParameters()[0].equals(Types.m14536a((GenericDeclaration) C4391a.class, "X", new Type[0]))) {
                z = true;
            }
            bOZ = z;
        }
    }

    static final class C4392b<D extends GenericDeclaration> {
        private final D bPa;
        private final ImmutableList<Type> bPb;
        private final String name;

        C4392b(D d, String str, Type[] typeArr) {
            Types.m14537a(typeArr, "bound for type variable");
            this.bPa = (GenericDeclaration) cco.ce(d);
            this.name = (String) cco.ce(str);
            this.bPb = ImmutableList.copyOf(typeArr);
        }

        public D getGenericDeclaration() {
            return this.bPa;
        }

        public String getName() {
            return this.name;
        }

        public String toString() {
            return this.name;
        }

        public int hashCode() {
            return this.bPa.hashCode() ^ this.name.hashCode();
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (C4391a.bOZ) {
                if (obj == null || !Proxy.isProxyClass(obj.getClass()) || !(Proxy.getInvocationHandler(obj) instanceof C4393c)) {
                    return false;
                }
                C4392b a = ((C4393c) Proxy.getInvocationHandler(obj)).bPd;
                boolean z2 = this.name.equals(a.getName()) && this.bPa.equals(a.getGenericDeclaration()) && this.bPb.equals(a.bPb);
                return z2;
            } else if (!(obj instanceof TypeVariable)) {
                return false;
            } else {
                TypeVariable typeVariable = (TypeVariable) obj;
                if (!(this.name.equals(typeVariable.getName()) && this.bPa.equals(typeVariable.getGenericDeclaration()))) {
                    z = false;
                }
                return z;
            }
        }
    }

    static final class C4393c implements InvocationHandler {
        private static final ImmutableMap<String, Method> bPc;
        private final C4392b<?> bPd;

        static {
            ImmutableMap$a builder = ImmutableMap.builder();
            for (Method method : C4392b.class.getMethods()) {
                if (method.getDeclaringClass().equals(C4392b.class)) {
                    try {
                        method.setAccessible(true);
                    } catch (AccessControlException e) {
                    }
                    builder.m14325z(method.getName(), method);
                }
            }
            bPc = builder.UJ();
        }

        C4393c(C4392b<?> c4392b) {
            this.bPd = c4392b;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Method method2 = (Method) bPc.get(name);
            if (method2 == null) {
                throw new UnsupportedOperationException(name);
            }
            try {
                return method2.invoke(this.bPd, objArr);
            } catch (InvocationTargetException e) {
                throw e.getCause();
            }
        }
    }

    public static Type newArrayType(Type type) {
        boolean z = true;
        if (!(type instanceof WildcardType)) {
            return JavaVersion.CURRENT.newArrayType(type);
        }
        WildcardType wildcardType = (WildcardType) type;
        Type[] lowerBounds = wildcardType.getLowerBounds();
        cco.d(lowerBounds.length <= 1, "Wildcard cannot have more than one lower bounds.");
        if (lowerBounds.length == 1) {
            return m14546p(newArrayType(lowerBounds[0]));
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        if (upperBounds.length != 1) {
            z = false;
        }
        cco.d(z, "Wildcard should have only one upper bound.");
        return m14545o(newArrayType(upperBounds[0]));
    }

    public static ParameterizedType m14535a(Type type, Class<?> cls, Type... typeArr) {
        if (type == null) {
            return m14540c(cls, typeArr);
        }
        cco.ce(typeArr);
        cco.a(cls.getEnclosingClass() != null, "Owner type for unenclosed %s", cls);
        return new ParameterizedTypeImpl(type, cls, typeArr);
    }

    static ParameterizedType m14540c(Class<?> cls, Type... typeArr) {
        return new ParameterizedTypeImpl(ClassOwnership.JVM_BEHAVIOR.getOwnerType(cls), cls, typeArr);
    }

    public static <D extends GenericDeclaration> TypeVariable<D> m14536a(D d, String str, Type... typeArr) {
        if (typeArr.length == 0) {
            typeArr = new Type[]{Object.class};
        }
        return m14538b(d, str, typeArr);
    }

    static WildcardType m14545o(Type type) {
        return new WildcardTypeImpl(new Type[0], new Type[]{type});
    }

    static WildcardType m14546p(Type type) {
        return new WildcardTypeImpl(new Type[]{type}, new Type[]{Object.class});
    }

    static String m14547q(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    public static Type m14548r(Type type) {
        cco.ce(type);
        final AtomicReference atomicReference = new AtomicReference();
        new cee() {
            void m14530a(TypeVariable<?> typeVariable) {
                atomicReference.set(Types.m14541h(typeVariable.getBounds()));
            }

            void m14532b(WildcardType wildcardType) {
                atomicReference.set(Types.m14541h(wildcardType.getUpperBounds()));
            }

            void m14531b(GenericArrayType genericArrayType) {
                atomicReference.set(genericArrayType.getGenericComponentType());
            }

            void m14529P(Class<?> cls) {
                atomicReference.set(cls.getComponentType());
            }
        }.g(new Type[]{type});
        return (Type) atomicReference.get();
    }

    private static Type m14541h(Type[] typeArr) {
        for (Type r : typeArr) {
            Type r2 = m14548r(r2);
            if (r2 != null) {
                if (r2 instanceof Class) {
                    Class cls = (Class) r2;
                    if (cls.isPrimitive()) {
                        return cls;
                    }
                }
                return m14545o(r2);
            }
        }
        return null;
    }

    private static <D extends GenericDeclaration> TypeVariable<D> m14538b(D d, String str, Type[] typeArr) {
        return (TypeVariable) cea.a(TypeVariable.class, new C4393c(new C4392b(d, str, typeArr)));
    }

    private static Type[] m14543j(Collection<Type> collection) {
        return (Type[]) collection.toArray(new Type[collection.size()]);
    }

    private static Iterable<Type> m14549u(Iterable<Type> iterable) {
        return cdg.a(iterable, Predicates.m14291a(Predicates.cf(Object.class)));
    }

    private static void m14537a(Type[] typeArr, String str) {
        for (Type type : typeArr) {
            if (type instanceof Class) {
                boolean z;
                Class cls = (Class) type;
                if (cls.isPrimitive()) {
                    z = false;
                } else {
                    z = true;
                }
                cco.a(z, "Primitive type '%s' used as %s", cls, str);
            }
        }
    }

    static Class<?> m14534Y(Class<?> cls) {
        return Array.newInstance(cls, 0).getClass();
    }
}
