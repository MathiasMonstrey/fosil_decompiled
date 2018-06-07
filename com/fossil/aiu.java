package com.fossil;

import com.fasterxml.jackson.annotation.JsonFormat.C1501b;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fossil.ahl.C1642a;
import com.fossil.amk.C1703a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class aiu extends agu {
    protected final AnnotationIntrospector _annotationIntrospector;
    protected aiy _objectIdInfo;
    protected List<aiv> aRW;
    protected final air aSA;
    protected ama aSB;
    protected final aiz aSy;
    protected final MapperConfig<?> aSz;

    protected aiu(aiz com_fossil_aiz, JavaType javaType, air com_fossil_air) {
        super(javaType);
        this.aSy = com_fossil_aiz;
        this.aSz = com_fossil_aiz.getConfig();
        this._annotationIntrospector = this.aSz == null ? null : this.aSz.getAnnotationIntrospector();
        this.aSA = com_fossil_air;
    }

    protected aiu(MapperConfig<?> mapperConfig, JavaType javaType, air com_fossil_air, List<aiv> list) {
        AnnotationIntrospector annotationIntrospector = null;
        super(javaType);
        this.aSy = null;
        this.aSz = mapperConfig;
        if (this.aSz != null) {
            annotationIntrospector = this.aSz.getAnnotationIntrospector();
        }
        this._annotationIntrospector = annotationIntrospector;
        this.aSA = com_fossil_air;
        this.aRW = list;
    }

    protected aiu(aiz com_fossil_aiz) {
        this(com_fossil_aiz, com_fossil_aiz.getType(), com_fossil_aiz.FC());
        this._objectIdInfo = com_fossil_aiz.getObjectIdInfo();
    }

    public static aiu m3453a(aiz com_fossil_aiz) {
        return new aiu(com_fossil_aiz);
    }

    public static aiu m3454b(aiz com_fossil_aiz) {
        return new aiu(com_fossil_aiz);
    }

    public static aiu m3452a(MapperConfig<?> mapperConfig, JavaType javaType, air com_fossil_air) {
        return new aiu(mapperConfig, javaType, com_fossil_air, Collections.emptyList());
    }

    protected List<aiv> Fc() {
        if (this.aRW == null) {
            this.aRW = this.aSy.FD();
        }
        return this.aRW;
    }

    public boolean bN(String str) {
        Iterator it = Fc().iterator();
        while (it.hasNext()) {
            if (((aiv) it.next()).getName().equals(str)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public boolean m3460a(aiv com_fossil_aiv) {
        if (m3459a(com_fossil_aiv.getFullName())) {
            return false;
        }
        Fc().add(com_fossil_aiv);
        return true;
    }

    public boolean m3459a(PropertyName propertyName) {
        return m3461b(propertyName) != null;
    }

    public aiv m3461b(PropertyName propertyName) {
        for (aiv com_fossil_aiv : Fc()) {
            if (com_fossil_aiv.mo1009c(propertyName)) {
                return com_fossil_aiv;
            }
        }
        return null;
    }

    public air Dn() {
        return this.aSA;
    }

    public aiy getObjectIdInfo() {
        return this._objectIdInfo;
    }

    public List<aiv> Dr() {
        return Fc();
    }

    public AnnotatedMethod Dz() {
        return this.aSy == null ? null : this.aSy.FF();
    }

    public Set<String> Dt() {
        Set<String> Dt = this.aSy == null ? null : this.aSy.Dt();
        if (Dt == null) {
            return Collections.emptySet();
        }
        return Dt;
    }

    public boolean Do() {
        return this.aSA.ES();
    }

    public amc Dq() {
        return this.aSA.ER();
    }

    public ama Dp() {
        if (this.aSB == null) {
            this.aSB = new ama(this.aSz.getTypeFactory(), this._type);
        }
        return this.aSB;
    }

    public JavaType mo979a(Type type) {
        if (type == null) {
            return null;
        }
        return Dp().m3829a(type);
    }

    public AnnotatedConstructor Dw() {
        return this.aSA.ET();
    }

    public AnnotatedMethod Dy() throws IllegalArgumentException {
        AnnotatedMethod annotatedMethod;
        if (this.aSy == null) {
            annotatedMethod = null;
        } else {
            annotatedMethod = this.aSy.FH();
        }
        if (annotatedMethod != null) {
            Class rawParameterType = annotatedMethod.getRawParameterType(0);
            if (!(rawParameterType == String.class || rawParameterType == Object.class)) {
                throw new IllegalArgumentException("Invalid 'any-setter' annotation on method " + annotatedMethod.getName() + "(): first argument not of type String or Object, but " + rawParameterType.getName());
            }
        }
        return annotatedMethod;
    }

    public Map<Object, AnnotatedMember> DC() {
        if (this.aSy != null) {
            return this.aSy.FE();
        }
        return Collections.emptyMap();
    }

    public List<AnnotatedConstructor> Du() {
        return this.aSA.Du();
    }

    public Object aI(boolean z) {
        AnnotatedConstructor ET = this.aSA.ET();
        if (ET == null) {
            return null;
        }
        if (z) {
            ET.fixAccess();
        }
        try {
            return ET.getAnnotated().newInstance(new Object[0]);
        } catch (Exception e) {
            Throwable e2 = e;
            while (e2.getCause() != null) {
                e2 = e2.getCause();
            }
            if (e2 instanceof Error) {
                throw ((Error) e2);
            } else if (e2 instanceof RuntimeException) {
                throw ((RuntimeException) e2);
            } else {
                throw new IllegalArgumentException("Failed to instantiate bean of type " + this.aSA.EQ().getName() + ": (" + e2.getClass().getName() + ") " + e2.getMessage(), e2);
            }
        }
    }

    public AnnotatedMethod mo980a(String str, Class<?>[] clsArr) {
        return this.aSA.m3424a(str, (Class[]) clsArr);
    }

    public C1501b mo978a(C1501b c1501b) {
        if (this._annotationIntrospector == null) {
            return c1501b;
        }
        C1501b findFormat = this._annotationIntrospector.findFormat(this.aSA);
        if (findFormat != null) {
            return findFormat;
        }
        return c1501b;
    }

    public amk<Object, Object> DA() {
        if (this._annotationIntrospector == null) {
            return null;
        }
        return by(this._annotationIntrospector.findSerializationConverter(this.aSA));
    }

    public Include mo984c(Include include) {
        return this._annotationIntrospector == null ? include : this._annotationIntrospector.findSerializationInclusion(this.aSA, include);
    }

    public Include mo985d(Include include) {
        return this._annotationIntrospector == null ? include : this._annotationIntrospector.findSerializationInclusionForContent(this.aSA, include);
    }

    public AnnotatedMember Dx() throws IllegalArgumentException {
        AnnotatedMember annotatedMember;
        if (this.aSy == null) {
            annotatedMember = null;
        } else {
            annotatedMember = this.aSy.FG();
        }
        if (annotatedMember != null) {
            if (!Map.class.isAssignableFrom(annotatedMember.getRawType())) {
                throw new IllegalArgumentException("Invalid 'any-getter' annotation on method " + annotatedMember.getName() + "(): return type is not instance of java.util.Map");
            }
        }
        return annotatedMember;
    }

    public Map<String, AnnotatedMember> Ds() {
        Map<String, AnnotatedMember> map = null;
        for (aiv Fq : Fc()) {
            AnnotatedMember Fq2 = Fq.Fq();
            if (Fq2 != null) {
                ReferenceProperty findReferenceType = this._annotationIntrospector.findReferenceType(Fq2);
                if (findReferenceType != null && findReferenceType.Dm()) {
                    HashMap hashMap;
                    if (map == null) {
                        hashMap = new HashMap();
                    } else {
                        Map map2 = map;
                    }
                    String name = findReferenceType.getName();
                    if (hashMap.put(name, Fq2) != null) {
                        throw new IllegalArgumentException("Multiple back-reference properties with name '" + name + "'");
                    }
                    map = hashMap;
                }
            }
        }
        return map;
    }

    public List<AnnotatedMethod> Dv() {
        List<AnnotatedMethod> EU = this.aSA.EU();
        if (EU.isEmpty()) {
            return EU;
        }
        ArrayList arrayList = new ArrayList();
        for (AnnotatedMethod annotatedMethod : EU) {
            if (m3463b(annotatedMethod)) {
                arrayList.add(annotatedMethod);
            }
        }
        return arrayList;
    }

    public Constructor<?> mo981a(Class<?>... clsArr) {
        for (AnnotatedConstructor annotatedConstructor : this.aSA.Du()) {
            if (annotatedConstructor.getParameterCount() == 1) {
                Class<?> rawParameterType = annotatedConstructor.getRawParameterType(0);
                for (Class<?> cls : clsArr) {
                    if (cls == rawParameterType) {
                        return annotatedConstructor.getAnnotated();
                    }
                }
                continue;
            }
        }
        return null;
    }

    public Method mo983b(Class<?>... clsArr) {
        for (AnnotatedMethod annotatedMethod : this.aSA.EU()) {
            if (m3463b(annotatedMethod)) {
                Class rawParameterType = annotatedMethod.getRawParameterType(0);
                for (Class isAssignableFrom : clsArr) {
                    if (rawParameterType.isAssignableFrom(isAssignableFrom)) {
                        return annotatedMethod.getAnnotated();
                    }
                }
                continue;
            }
        }
        return null;
    }

    protected boolean m3463b(AnnotatedMethod annotatedMethod) {
        if (!getBeanClass().isAssignableFrom(annotatedMethod.getRawReturnType())) {
            return false;
        }
        if (this._annotationIntrospector.hasCreatorAnnotation(annotatedMethod)) {
            return true;
        }
        String name = annotatedMethod.getName();
        if ("valueOf".equals(name)) {
            return true;
        }
        if (!"fromString".equals(name) || 1 != annotatedMethod.getParameterCount()) {
            return false;
        }
        Class rawParameterType = annotatedMethod.getRawParameterType(0);
        if (rawParameterType == String.class || CharSequence.class.isAssignableFrom(rawParameterType)) {
            return true;
        }
        return false;
    }

    public Class<?> DD() {
        return this._annotationIntrospector == null ? null : this._annotationIntrospector.findPOJOBuilder(this.aSA);
    }

    public C1642a DE() {
        return this._annotationIntrospector == null ? null : this._annotationIntrospector.findPOJOBuilderConfig(this.aSA);
    }

    public amk<Object, Object> DB() {
        if (this._annotationIntrospector == null) {
            return null;
        }
        return by(this._annotationIntrospector.findDeserializationConverter(this.aSA));
    }

    public amk<Object, Object> by(Object obj) {
        amk com_fossil_amk = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof amk) {
            return (amk) obj;
        }
        if (obj instanceof Class) {
            Class cls = (Class) obj;
            if (cls == C1703a.class || ami.m3854D(cls)) {
                return null;
            }
            if (amk.class.isAssignableFrom(cls)) {
                ahr handlerInstantiator = this.aSz.getHandlerInstantiator();
                if (handlerInstantiator != null) {
                    com_fossil_amk = handlerInstantiator.m3350g(this.aSz, this.aSA, cls);
                }
                if (com_fossil_amk == null) {
                    com_fossil_amk = (amk) ami.m3863b(cls, this.aSz.canOverrideAccessModifiers());
                }
                return com_fossil_amk;
            }
            throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<Converter>");
        }
        throw new IllegalStateException("AnnotationIntrospector returned Converter definition of type " + obj.getClass().getName() + "; expected type Converter or Class<Converter> instead");
    }
}
