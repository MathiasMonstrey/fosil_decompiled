package com.fossil;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fossil.aiw.C1505a;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class air extends aiq {
    private static final ait[] aSl = new ait[0];
    protected final AnnotationIntrospector _annotationIntrospector;
    protected final Class<?> _class;
    protected final List<Class<?>> aSm;
    protected final C1505a aSn;
    protected final Class<?> aSo;
    protected ait aSp;
    protected boolean aSq = false;
    protected AnnotatedConstructor aSr;
    protected List<AnnotatedConstructor> aSs;
    protected List<AnnotatedMethod> aSt;
    protected ais aSu;
    protected List<AnnotatedField> aSv;

    public /* synthetic */ AnnotatedElement getAnnotated() {
        return EQ();
    }

    public /* synthetic */ aiq withAnnotations(ait com_fossil_ait) {
        return m3426a(com_fossil_ait);
    }

    private air(Class<?> cls, List<Class<?>> list, AnnotationIntrospector annotationIntrospector, C1505a c1505a, ait com_fossil_ait) {
        this._class = cls;
        this.aSm = list;
        this._annotationIntrospector = annotationIntrospector;
        this.aSn = c1505a;
        this.aSo = this.aSn == null ? null : this.aSn.findMixInClassFor(this._class);
        this.aSp = com_fossil_ait;
    }

    public air m3426a(ait com_fossil_ait) {
        return new air(this._class, this.aSm, this._annotationIntrospector, this.aSn, com_fossil_ait);
    }

    public static air m3414a(Class<?> cls, AnnotationIntrospector annotationIntrospector, C1505a c1505a) {
        return new air(cls, ami.m3870j(cls, null), annotationIntrospector, c1505a, null);
    }

    public static air m3419b(Class<?> cls, AnnotationIntrospector annotationIntrospector, C1505a c1505a) {
        return new air(cls, Collections.emptyList(), annotationIntrospector, c1505a, null);
    }

    public Class<?> EQ() {
        return this._class;
    }

    public int getModifiers() {
        return this._class.getModifiers();
    }

    public String getName() {
        return this._class.getName();
    }

    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        if (this.aSp == null) {
            EX();
        }
        return this.aSp.mo959j(cls);
    }

    public Type getGenericType() {
        return this._class;
    }

    public Class<?> getRawType() {
        return this._class;
    }

    public Iterable<Annotation> annotations() {
        if (this.aSp == null) {
            EX();
        }
        return this.aSp.annotations();
    }

    protected ait getAllAnnotations() {
        if (this.aSp == null) {
            EX();
        }
        return this.aSp;
    }

    public amc ER() {
        if (this.aSp == null) {
            EX();
        }
        return this.aSp;
    }

    public boolean ES() {
        if (this.aSp == null) {
            EX();
        }
        return this.aSp.size() > 0;
    }

    public AnnotatedConstructor ET() {
        if (!this.aSq) {
            EY();
        }
        return this.aSr;
    }

    public List<AnnotatedConstructor> Du() {
        if (!this.aSq) {
            EY();
        }
        return this.aSs;
    }

    public List<AnnotatedMethod> EU() {
        if (!this.aSq) {
            EY();
        }
        return this.aSt;
    }

    public Iterable<AnnotatedMethod> EV() {
        if (this.aSu == null) {
            EZ();
        }
        return this.aSu;
    }

    public AnnotatedMethod m3424a(String str, Class<?>[] clsArr) {
        if (this.aSu == null) {
            EZ();
        }
        return this.aSu.m3444b(str, clsArr);
    }

    public Iterable<AnnotatedField> EW() {
        if (this.aSv == null) {
            Fa();
        }
        return this.aSv;
    }

    private void EX() {
        this.aSp = new ait();
        if (this._annotationIntrospector != null) {
            if (this.aSo != null) {
                m3430a(this.aSp, this._class, this.aSo);
            }
            m3415a(this.aSp, this._class.getDeclaredAnnotations());
            for (Class cls : this.aSm) {
                m3429a(this.aSp, cls);
                m3415a(this.aSp, cls.getDeclaredAnnotations());
            }
            m3429a(this.aSp, Object.class);
        }
    }

    private void EY() {
        int i;
        int size;
        int i2 = 0;
        Constructor[] declaredConstructors = this._class.getDeclaredConstructors();
        List list = null;
        for (Constructor constructor : declaredConstructors) {
            if (constructor.getParameterTypes().length == 0) {
                this.aSr = m3422a(constructor, true);
            } else {
                if (list == null) {
                    list = new ArrayList(Math.max(10, declaredConstructors.length));
                }
                list.add(m3422a(constructor, false));
            }
        }
        if (list == null) {
            this.aSs = Collections.emptyList();
        } else {
            this.aSs = list;
        }
        if (!(this.aSo == null || (this.aSr == null && this.aSs.isEmpty()))) {
            m3440g(this.aSo);
        }
        if (this._annotationIntrospector != null) {
            if (this.aSr != null && this._annotationIntrospector.hasIgnoreMarker(this.aSr)) {
                this.aSr = null;
            }
            if (this.aSs != null) {
                size = this.aSs.size();
                while (true) {
                    i = size - 1;
                    if (i < 0) {
                        break;
                    } else if (this._annotationIntrospector.hasIgnoreMarker((AnnotatedMember) this.aSs.get(i))) {
                        this.aSs.remove(i);
                        size = i;
                    } else {
                        size = i;
                    }
                }
            }
        }
        Method[] i3 = m3442i(this._class);
        int length = i3.length;
        list = null;
        while (i2 < length) {
            Method method = i3[i2];
            if (Modifier.isStatic(method.getModifiers())) {
                if (list == null) {
                    list = new ArrayList(8);
                }
                list.add(m3437b(method));
            }
            i2++;
        }
        if (list == null) {
            this.aSt = Collections.emptyList();
        } else {
            this.aSt = list;
            if (this.aSo != null) {
                m3441h(this.aSo);
            }
            if (this._annotationIntrospector != null) {
                size = this.aSt.size();
                while (true) {
                    i2 = size - 1;
                    if (i2 < 0) {
                        break;
                    } else if (this._annotationIntrospector.hasIgnoreMarker((AnnotatedMember) this.aSt.get(i2))) {
                        this.aSt.remove(i2);
                        size = i2;
                    } else {
                        size = i2;
                    }
                }
            }
        }
        this.aSq = true;
    }

    private void EZ() {
        this.aSu = new ais();
        ais com_fossil_ais = new ais();
        m3431a(this._class, this.aSu, this.aSo, com_fossil_ais);
        for (Class cls : this.aSm) {
            Class cls2;
            m3431a(cls2, this.aSu, this.aSn == null ? null : this.aSn.findMixInClassFor(cls2), com_fossil_ais);
        }
        if (this.aSn != null) {
            cls2 = this.aSn.findMixInClassFor(Object.class);
            if (cls2 != null) {
                m3438b(this._class, this.aSu, cls2, com_fossil_ais);
            }
        }
        if (this._annotationIntrospector != null && !com_fossil_ais.isEmpty()) {
            Iterator it = com_fossil_ais.iterator();
            while (it.hasNext()) {
                AnnotatedMethod annotatedMethod = (AnnotatedMethod) it.next();
                try {
                    Method declaredMethod = Object.class.getDeclaredMethod(annotatedMethod.getName(), annotatedMethod.getRawParameterTypes());
                    if (declaredMethod != null) {
                        AnnotatedMethod a = m3425a(declaredMethod);
                        m3435a(annotatedMethod.getAnnotated(), a, false);
                        this.aSu.m3443a(a);
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    private void Fa() {
        Map a = m3428a(this._class, null);
        if (a == null || a.size() == 0) {
            this.aSv = Collections.emptyList();
            return;
        }
        this.aSv = new ArrayList(a.size());
        this.aSv.addAll(a.values());
    }

    protected void m3429a(ait com_fossil_ait, Class<?> cls) {
        if (this.aSn != null) {
            m3430a(com_fossil_ait, (Class) cls, this.aSn.findMixInClassFor(cls));
        }
    }

    protected void m3430a(ait com_fossil_ait, Class<?> cls, Class<?> cls2) {
        if (cls2 != null) {
            m3415a(com_fossil_ait, cls2.getDeclaredAnnotations());
            for (Class declaredAnnotations : ami.m3870j(cls2, cls)) {
                m3415a(com_fossil_ait, declaredAnnotations.getDeclaredAnnotations());
            }
        }
    }

    protected void m3440g(Class<?> cls) {
        int size = this.aSs == null ? 0 : this.aSs.size();
        aix[] com_fossil_aixArr = null;
        for (Constructor constructor : cls.getDeclaredConstructors()) {
            if (constructor.getParameterTypes().length != 0) {
                aix[] com_fossil_aixArr2;
                if (com_fossil_aixArr == null) {
                    com_fossil_aixArr2 = new aix[size];
                    for (int i = 0; i < size; i++) {
                        com_fossil_aixArr2[i] = new aix(((AnnotatedConstructor) this.aSs.get(i)).getAnnotated());
                    }
                } else {
                    com_fossil_aixArr2 = com_fossil_aixArr;
                }
                aix com_fossil_aix = new aix(constructor);
                for (int i2 = 0; i2 < size; i2++) {
                    if (com_fossil_aix.equals(com_fossil_aixArr2[i2])) {
                        m3433a(constructor, (AnnotatedConstructor) this.aSs.get(i2), true);
                        com_fossil_aixArr = com_fossil_aixArr2;
                        break;
                    }
                }
                com_fossil_aixArr = com_fossil_aixArr2;
            } else if (this.aSr != null) {
                m3433a(constructor, this.aSr, false);
            }
        }
    }

    protected void m3441h(Class<?> cls) {
        aix[] com_fossil_aixArr = null;
        int size = this.aSt.size();
        for (Method method : cls.getDeclaredMethods()) {
            if (Modifier.isStatic(method.getModifiers()) && method.getParameterTypes().length != 0) {
                aix[] com_fossil_aixArr2;
                if (com_fossil_aixArr == null) {
                    com_fossil_aixArr2 = new aix[size];
                    for (int i = 0; i < size; i++) {
                        com_fossil_aixArr2[i] = new aix(((AnnotatedMethod) this.aSt.get(i)).getAnnotated());
                    }
                } else {
                    com_fossil_aixArr2 = com_fossil_aixArr;
                }
                aix com_fossil_aix = new aix(method);
                for (int i2 = 0; i2 < size; i2++) {
                    if (com_fossil_aix.equals(com_fossil_aixArr2[i2])) {
                        m3435a(method, (AnnotatedMethod) this.aSt.get(i2), true);
                        com_fossil_aixArr = com_fossil_aixArr2;
                        break;
                    }
                }
                com_fossil_aixArr = com_fossil_aixArr2;
            }
        }
    }

    protected void m3431a(Class<?> cls, ais com_fossil_ais, Class<?> cls2, ais com_fossil_ais2) {
        if (cls2 != null) {
            m3438b(cls, com_fossil_ais, cls2, com_fossil_ais2);
        }
        if (cls != null) {
            for (Method method : m3442i(cls)) {
                if (m3439c(method)) {
                    AnnotatedMethod e = com_fossil_ais.m3446e(method);
                    if (e == null) {
                        e = m3425a(method);
                        com_fossil_ais.m3443a(e);
                        AnnotatedMethod d = com_fossil_ais2.m3445d(method);
                        if (d != null) {
                            m3435a(d.getAnnotated(), e, false);
                        }
                    } else {
                        m3434a(method, e);
                        if (e.getDeclaringClass().isInterface() && !method.getDeclaringClass().isInterface()) {
                            com_fossil_ais.m3443a(e.withMethod(method));
                        }
                    }
                }
            }
        }
    }

    protected void m3438b(Class<?> cls, ais com_fossil_ais, Class<?> cls2, ais com_fossil_ais2) {
        List<Class> arrayList = new ArrayList();
        arrayList.add(cls2);
        ami.m3860a(cls2, cls, arrayList);
        for (Class declaredMethods : arrayList) {
            for (Method method : declaredMethods.getDeclaredMethods()) {
                if (m3439c(method)) {
                    AnnotatedMethod e = com_fossil_ais.m3446e(method);
                    if (e != null) {
                        m3434a(method, e);
                    } else {
                        e = com_fossil_ais2.m3446e(method);
                        if (e != null) {
                            m3434a(method, e);
                        } else {
                            com_fossil_ais2.m3443a(m3425a(method));
                        }
                    }
                }
            }
        }
    }

    protected Map<String, AnnotatedField> m3428a(Class<?> cls, Map<String, AnnotatedField> map) {
        Class superclass = cls.getSuperclass();
        if (superclass == null) {
            return map;
        }
        Map<String, AnnotatedField> a = m3428a(superclass, (Map) map);
        Map map2 = a;
        for (Field field : cls.getDeclaredFields()) {
            if (m3421b(field)) {
                if (map2 == null) {
                    map2 = new LinkedHashMap();
                }
                map2.put(field.getName(), m3423a(field));
            }
        }
        if (this.aSn == null) {
            return map2;
        }
        Class findMixInClassFor = this.aSn.findMixInClassFor(cls);
        if (findMixInClassFor == null) {
            return map2;
        }
        m3432a(superclass, findMixInClassFor, map2);
        return map2;
    }

    protected void m3432a(Class<?> cls, Class<?> cls2, Map<String, AnnotatedField> map) {
        List<Class> arrayList = new ArrayList();
        arrayList.add(cls2);
        ami.m3860a(cls2, cls, arrayList);
        for (Class declaredFields : arrayList) {
            for (Field field : declaredFields.getDeclaredFields()) {
                if (m3421b(field)) {
                    AnnotatedField annotatedField = (AnnotatedField) map.get(field.getName());
                    if (annotatedField != null) {
                        m3420b(annotatedField, field.getDeclaredAnnotations());
                    }
                }
            }
        }
    }

    protected AnnotatedMethod m3425a(Method method) {
        if (this._annotationIntrospector == null) {
            return new AnnotatedMethod(this, method, Fb(), null);
        }
        return new AnnotatedMethod(this, method, m3427a(method.getDeclaredAnnotations()), null);
    }

    protected AnnotatedConstructor m3422a(Constructor<?> constructor, boolean z) {
        if (this._annotationIntrospector == null) {
            return new AnnotatedConstructor(this, constructor, Fb(), gS(constructor.getParameterTypes().length));
        }
        if (z) {
            return new AnnotatedConstructor(this, constructor, m3427a(constructor.getDeclaredAnnotations()), null);
        }
        ait[] a;
        Object parameterAnnotations = constructor.getParameterAnnotations();
        int length = constructor.getParameterTypes().length;
        if (length != parameterAnnotations.length) {
            Object obj;
            Class declaringClass = constructor.getDeclaringClass();
            if (declaringClass.isEnum() && length == parameterAnnotations.length + 2) {
                obj = new Annotation[(parameterAnnotations.length + 2)][];
                System.arraycopy(parameterAnnotations, 0, obj, 2, parameterAnnotations.length);
                a = m3436a((Annotation[][]) obj);
            } else if (declaringClass.isMemberClass() && length == parameterAnnotations.length + 1) {
                Annotation[][] annotationArr = new Annotation[(parameterAnnotations.length + 1)][];
                System.arraycopy(parameterAnnotations, 0, annotationArr, 1, parameterAnnotations.length);
                a = m3436a(annotationArr);
            } else {
                obj = parameterAnnotations;
                a = null;
            }
            if (a == null) {
                throw new IllegalStateException("Internal error: constructor for " + constructor.getDeclaringClass().getName() + " has mismatch: " + length + " parameters; " + obj.length + " sets of annotations");
            }
        }
        a = m3436a((Annotation[][]) parameterAnnotations);
        return new AnnotatedConstructor(this, constructor, m3427a(constructor.getDeclaredAnnotations()), a);
    }

    protected AnnotatedMethod m3437b(Method method) {
        if (this._annotationIntrospector == null) {
            return new AnnotatedMethod(this, method, Fb(), gS(method.getParameterTypes().length));
        }
        return new AnnotatedMethod(this, method, m3427a(method.getDeclaredAnnotations()), m3436a(method.getParameterAnnotations()));
    }

    protected AnnotatedField m3423a(Field field) {
        if (this._annotationIntrospector == null) {
            return new AnnotatedField(this, field, Fb());
        }
        return new AnnotatedField(this, field, m3427a(field.getDeclaredAnnotations()));
    }

    private ait Fb() {
        return new ait();
    }

    private ait[] gS(int i) {
        if (i == 0) {
            return aSl;
        }
        ait[] com_fossil_aitArr = new ait[i];
        for (int i2 = 0; i2 < i; i2++) {
            com_fossil_aitArr[i2] = Fb();
        }
        return com_fossil_aitArr;
    }

    protected boolean m3439c(Method method) {
        if (Modifier.isStatic(method.getModifiers()) || method.isSynthetic() || method.isBridge() || method.getParameterTypes().length > 2) {
            return false;
        }
        return true;
    }

    private boolean m3421b(Field field) {
        if (field.isSynthetic() || Modifier.isStatic(field.getModifiers())) {
            return false;
        }
        return true;
    }

    protected ait[] m3436a(Annotation[][] annotationArr) {
        int length = annotationArr.length;
        ait[] com_fossil_aitArr = new ait[length];
        for (int i = 0; i < length; i++) {
            com_fossil_aitArr[i] = m3427a(annotationArr[i]);
        }
        return com_fossil_aitArr;
    }

    protected ait m3427a(Annotation[] annotationArr) {
        return m3415a(new ait(), annotationArr);
    }

    private ait m3415a(ait com_fossil_ait, Annotation[] annotationArr) {
        if (annotationArr != null) {
            List list = null;
            for (Annotation annotation : annotationArr) {
                if (com_fossil_ait.addIfNotPresent(annotation) && m3418a(annotation)) {
                    list = m3416a(annotation, list);
                }
            }
            if (list != null) {
                m3415a(com_fossil_ait, (Annotation[]) list.toArray(new Annotation[list.size()]));
            }
        }
        return com_fossil_ait;
    }

    private List<Annotation> m3416a(Annotation annotation, List<Annotation> list) {
        List<Annotation> list2 = list;
        for (Object obj : annotation.annotationType().getDeclaredAnnotations()) {
            if (!((obj instanceof Target) || (obj instanceof Retention))) {
                if (list2 == null) {
                    list2 = new ArrayList();
                }
                list2.add(obj);
            }
        }
        return list2;
    }

    private void m3417a(AnnotatedMember annotatedMember, Annotation[] annotationArr) {
        if (annotationArr != null) {
            List list = null;
            for (Annotation annotation : annotationArr) {
                if (annotatedMember.addIfNotPresent(annotation) && m3418a(annotation)) {
                    list = m3416a(annotation, list);
                }
            }
            if (list != null) {
                m3417a(annotatedMember, (Annotation[]) list.toArray(new Annotation[list.size()]));
            }
        }
    }

    private void m3420b(AnnotatedMember annotatedMember, Annotation[] annotationArr) {
        if (annotationArr != null) {
            List list = null;
            for (Annotation annotation : annotationArr) {
                if (annotatedMember.addOrOverride(annotation) && m3418a(annotation)) {
                    list = m3416a(annotation, list);
                }
            }
            if (list != null) {
                m3420b(annotatedMember, (Annotation[]) list.toArray(new Annotation[list.size()]));
            }
        }
    }

    protected void m3433a(Constructor<?> constructor, AnnotatedConstructor annotatedConstructor, boolean z) {
        m3420b(annotatedConstructor, constructor.getDeclaredAnnotations());
        if (z) {
            Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
            int length = parameterAnnotations.length;
            for (int i = 0; i < length; i++) {
                for (Annotation addOrOverrideParam : parameterAnnotations[i]) {
                    annotatedConstructor.addOrOverrideParam(i, addOrOverrideParam);
                }
            }
        }
    }

    protected void m3435a(Method method, AnnotatedMethod annotatedMethod, boolean z) {
        m3420b(annotatedMethod, method.getDeclaredAnnotations());
        if (z) {
            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            int length = parameterAnnotations.length;
            for (int i = 0; i < length; i++) {
                for (Annotation addOrOverrideParam : parameterAnnotations[i]) {
                    annotatedMethod.addOrOverrideParam(i, addOrOverrideParam);
                }
            }
        }
    }

    protected void m3434a(Method method, AnnotatedMethod annotatedMethod) {
        m3417a((AnnotatedMember) annotatedMethod, method.getDeclaredAnnotations());
    }

    private final boolean m3418a(Annotation annotation) {
        return this._annotationIntrospector != null && this._annotationIntrospector.isAnnotationBundle(annotation);
    }

    protected Method[] m3442i(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (Object e) {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader == null) {
                throw e;
            }
            try {
                return contextClassLoader.loadClass(cls.getName()).getDeclaredMethods();
            } catch (ClassNotFoundException e2) {
                throw e;
            }
        }
    }

    public String toString() {
        return "[AnnotedClass " + this._class.getName() + "]";
    }

    public int hashCode() {
        return this._class.getName().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (((air) obj)._class != this._class) {
            return false;
        }
        return true;
    }
}
