package com.fossil;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class aiz {
    protected final AnnotationIntrospector _annotationIntrospector;
    protected final JavaType _type;
    protected final VisibilityChecker<?> _visibilityChecker;
    protected final boolean aSI;
    protected final boolean aSJ;
    protected final air aSK;
    protected final String aSL;
    protected boolean aSM;
    protected LinkedHashMap<String, aja> aSN;
    protected LinkedList<aja> aSO;
    protected LinkedList<AnnotatedMember> aSP;
    protected LinkedList<AnnotatedMethod> aSQ;
    protected LinkedList<AnnotatedMethod> aSR;
    protected HashSet<String> aSS;
    protected LinkedHashMap<Object, AnnotatedMember> aST;
    protected final MapperConfig<?> aSz;

    public aiz(MapperConfig<?> mapperConfig, boolean z, JavaType javaType, air com_fossil_air, String str) {
        this.aSz = mapperConfig;
        this.aSJ = mapperConfig.isEnabled(MapperFeature.USE_STD_BEAN_NAMING);
        this.aSI = z;
        this._type = javaType;
        this.aSK = com_fossil_air;
        if (str == null) {
            str = "set";
        }
        this.aSL = str;
        this._annotationIntrospector = mapperConfig.isAnnotationProcessingEnabled() ? this.aSz.getAnnotationIntrospector() : null;
        if (this._annotationIntrospector == null) {
            this._visibilityChecker = this.aSz.getDefaultVisibilityChecker();
        } else {
            this._visibilityChecker = this._annotationIntrospector.findAutoDetectVisibility(com_fossil_air, this.aSz.getDefaultVisibilityChecker());
        }
    }

    public MapperConfig<?> getConfig() {
        return this.aSz;
    }

    public JavaType getType() {
        return this._type;
    }

    public air FC() {
        return this.aSK;
    }

    public List<aiv> FD() {
        return new ArrayList(FI().values());
    }

    public Map<Object, AnnotatedMember> FE() {
        if (!this.aSM) {
            FJ();
        }
        return this.aST;
    }

    public AnnotatedMethod FF() {
        if (!this.aSM) {
            FJ();
        }
        if (this.aSR == null) {
            return null;
        }
        if (this.aSR.size() > 1) {
            bQ("Multiple value properties defined (" + this.aSR.get(0) + " vs " + this.aSR.get(1) + ")");
        }
        return (AnnotatedMethod) this.aSR.get(0);
    }

    public AnnotatedMember FG() {
        if (!this.aSM) {
            FJ();
        }
        if (this.aSP == null) {
            return null;
        }
        if (this.aSP.size() > 1) {
            bQ("Multiple 'any-getters' defined (" + this.aSP.get(0) + " vs " + this.aSP.get(1) + ")");
        }
        return (AnnotatedMember) this.aSP.getFirst();
    }

    public AnnotatedMethod FH() {
        if (!this.aSM) {
            FJ();
        }
        if (this.aSQ == null) {
            return null;
        }
        if (this.aSQ.size() > 1) {
            bQ("Multiple 'any-setters' defined (" + this.aSQ.get(0) + " vs " + this.aSQ.get(1) + ")");
        }
        return (AnnotatedMethod) this.aSQ.getFirst();
    }

    public Set<String> Dt() {
        return this.aSS;
    }

    public aiy getObjectIdInfo() {
        if (this._annotationIntrospector == null) {
            return null;
        }
        aiy findObjectIdInfo = this._annotationIntrospector.findObjectIdInfo(this.aSK);
        if (findObjectIdInfo != null) {
            return this._annotationIntrospector.findObjectReferenceInfo(this.aSK, findObjectIdInfo);
        }
        return findObjectIdInfo;
    }

    protected Map<String, aja> FI() {
        if (!this.aSM) {
            FJ();
        }
        return this.aSN;
    }

    protected void FJ() {
        Map linkedHashMap = new LinkedHashMap();
        m3475d(linkedHashMap);
        m3477f(linkedHashMap);
        m3476e(linkedHashMap);
        m3478g(linkedHashMap);
        m3479h(linkedHashMap);
        for (aja aN : linkedHashMap.values()) {
            aN.aN(this.aSI);
        }
        m3480i(linkedHashMap);
        m3481j(linkedHashMap);
        PropertyNamingStrategy FK = FK();
        if (FK != null) {
            m3470a(linkedHashMap, FK);
        }
        for (aja aN2 : linkedHashMap.values()) {
            aN2.FU();
        }
        if (this.aSz.isEnabled(MapperFeature.USE_WRAPPER_NAME_AS_PROPERTY_NAME)) {
            m3482k(linkedHashMap);
        }
        m3483l(linkedHashMap);
        this.aSN = linkedHashMap;
        this.aSM = true;
    }

    protected void m3475d(Map<String, aja> map) {
        AnnotationIntrospector annotationIntrospector = this._annotationIntrospector;
        Object obj = (this.aSI || this.aSz.isEnabled(MapperFeature.ALLOW_FINAL_FIELDS_AS_MUTATORS)) ? null : 1;
        boolean isEnabled = this.aSz.isEnabled(MapperFeature.PROPAGATE_TRANSIENT_MARKER);
        for (AnnotatedField annotatedField : this.aSK.EW()) {
            String name;
            PropertyName propertyName;
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            String findImplicitPropertyName = annotationIntrospector == null ? null : annotationIntrospector.findImplicitPropertyName(annotatedField);
            if (findImplicitPropertyName == null) {
                name = annotatedField.getName();
            } else {
                name = findImplicitPropertyName;
            }
            if (annotationIntrospector == null) {
                propertyName = null;
            } else if (this.aSI) {
                propertyName = annotationIntrospector.findNameForSerialization(annotatedField);
            } else {
                propertyName = annotationIntrospector.findNameForDeserialization(annotatedField);
            }
            if (propertyName != null) {
                z = true;
            } else {
                z = false;
            }
            if (z && propertyName.isEmpty()) {
                propertyName = bO(name);
                z = false;
            }
            if (propertyName != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                z2 = this._visibilityChecker.isFieldVisible(annotatedField);
            }
            if (annotationIntrospector == null || !annotationIntrospector.hasIgnoreMarker(annotatedField)) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (!annotatedField.isTransient()) {
                z4 = z3;
            } else if (isEnabled) {
                z4 = true;
                z2 = false;
            } else {
                z4 = z3;
                z2 = false;
            }
            if (obj == null || propertyName != null || z4 || !Modifier.isFinal(annotatedField.getModifiers())) {
                m3474c(map, name).m3522a(annotatedField, propertyName, z, z2, z4);
            }
        }
    }

    protected void m3476e(Map<String, aja> map) {
        if (this._annotationIntrospector != null) {
            int parameterCount;
            int i;
            for (AnnotatedConstructor annotatedConstructor : this.aSK.Du()) {
                if (this.aSO == null) {
                    this.aSO = new LinkedList();
                }
                parameterCount = annotatedConstructor.getParameterCount();
                for (i = 0; i < parameterCount; i++) {
                    m3472a((Map) map, annotatedConstructor.getParameter(i));
                }
            }
            for (AnnotatedMethod annotatedMethod : this.aSK.EU()) {
                if (this.aSO == null) {
                    this.aSO = new LinkedList();
                }
                parameterCount = annotatedMethod.getParameterCount();
                for (i = 0; i < parameterCount; i++) {
                    m3472a((Map) map, annotatedMethod.getParameter(i));
                }
            }
        }
    }

    protected void m3472a(Map<String, aja> map, AnnotatedParameter annotatedParameter) {
        String findImplicitPropertyName = this._annotationIntrospector.findImplicitPropertyName(annotatedParameter);
        if (findImplicitPropertyName == null) {
            findImplicitPropertyName = "";
        }
        PropertyName findNameForDeserialization = this._annotationIntrospector.findNameForDeserialization(annotatedParameter);
        boolean z = (findNameForDeserialization == null || findNameForDeserialization.isEmpty()) ? false : true;
        if (!z) {
            if (!findImplicitPropertyName.isEmpty() && this._annotationIntrospector.hasCreatorAnnotation(annotatedParameter.getOwner())) {
                findNameForDeserialization = PropertyName.construct(findImplicitPropertyName);
            } else {
                return;
            }
        }
        aja a = (z && findImplicitPropertyName.isEmpty()) ? m3467a((Map) map, findNameForDeserialization) : m3474c(map, findImplicitPropertyName);
        a.m3524a(annotatedParameter, findNameForDeserialization, z, true, false);
        this.aSO.add(a);
    }

    protected void m3477f(Map<String, aja> map) {
        AnnotationIntrospector annotationIntrospector = this._annotationIntrospector;
        for (AnnotatedMethod annotatedMethod : this.aSK.EV()) {
            int parameterCount = annotatedMethod.getParameterCount();
            if (parameterCount == 0) {
                m3471a(map, annotatedMethod, annotationIntrospector);
            } else if (parameterCount == 1) {
                m3473b(map, annotatedMethod, annotationIntrospector);
            } else if (parameterCount == 2 && annotationIntrospector != null && annotationIntrospector.hasAnySetterAnnotation(annotatedMethod)) {
                if (this.aSQ == null) {
                    this.aSQ = new LinkedList();
                }
                this.aSQ.add(annotatedMethod);
            }
        }
    }

    protected void m3471a(Map<String, aja> map, AnnotatedMethod annotatedMethod, AnnotationIntrospector annotationIntrospector) {
        boolean z = true;
        String str = null;
        boolean z2 = false;
        if (annotatedMethod.hasReturnType()) {
            boolean z3;
            boolean z4;
            if (annotationIntrospector != null) {
                if (annotationIntrospector.hasAnyGetterAnnotation(annotatedMethod)) {
                    if (this.aSP == null) {
                        this.aSP = new LinkedList();
                    }
                    this.aSP.add(annotatedMethod);
                    return;
                } else if (annotationIntrospector.hasAsValueAnnotation(annotatedMethod)) {
                    if (this.aSR == null) {
                        this.aSR = new LinkedList();
                    }
                    this.aSR.add(annotatedMethod);
                    return;
                }
            }
            PropertyName findNameForSerialization = annotationIntrospector == null ? null : annotationIntrospector.findNameForSerialization(annotatedMethod);
            if (findNameForSerialization != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                if (annotationIntrospector != null) {
                    str = annotationIntrospector.findImplicitPropertyName(annotatedMethod);
                }
                if (str == null) {
                    str = amf.m3840a(annotatedMethod, this.aSJ);
                }
                if (str == null) {
                    str = annotatedMethod.getName();
                }
                if (findNameForSerialization.isEmpty()) {
                    findNameForSerialization = bO(str);
                    z3 = false;
                }
                z4 = z3;
            } else {
                if (annotationIntrospector != null) {
                    str = annotationIntrospector.findImplicitPropertyName(annotatedMethod);
                }
                if (str == null) {
                    str = amf.m3839a(annotatedMethod, annotatedMethod.getName(), this.aSJ);
                }
                if (str == null) {
                    str = amf.m3841b(annotatedMethod, annotatedMethod.getName(), this.aSJ);
                    if (str != null) {
                        z = this._visibilityChecker.isIsGetterVisible(annotatedMethod);
                        z4 = z3;
                    } else {
                        return;
                    }
                }
                z = this._visibilityChecker.isGetterVisible(annotatedMethod);
                z4 = z3;
            }
            if (annotationIntrospector != null) {
                z2 = annotationIntrospector.hasIgnoreMarker(annotatedMethod);
            }
            m3474c(map, str).m3523a(annotatedMethod, findNameForSerialization, z4, z, z2);
        }
    }

    protected void m3473b(Map<String, aja> map, AnnotatedMethod annotatedMethod, AnnotationIntrospector annotationIntrospector) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        String str = null;
        boolean z4 = false;
        PropertyName findNameForDeserialization = annotationIntrospector == null ? null : annotationIntrospector.findNameForDeserialization(annotatedMethod);
        if (findNameForDeserialization != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (annotationIntrospector != null) {
                str = annotationIntrospector.findImplicitPropertyName(annotatedMethod);
            }
            if (str == null) {
                str = amf.m3842c(annotatedMethod, this.aSL, this.aSJ);
            }
            if (str == null) {
                str = annotatedMethod.getName();
            }
            if (findNameForDeserialization.isEmpty()) {
                findNameForDeserialization = bO(str);
                z = false;
            }
            z2 = z;
        } else {
            if (annotationIntrospector != null) {
                str = annotationIntrospector.findImplicitPropertyName(annotatedMethod);
            }
            if (str == null) {
                str = amf.m3842c(annotatedMethod, this.aSL, this.aSJ);
            }
            if (str != null) {
                z3 = this._visibilityChecker.isSetterVisible(annotatedMethod);
                z2 = z;
            } else {
                return;
            }
        }
        if (annotationIntrospector != null) {
            z4 = annotationIntrospector.hasIgnoreMarker(annotatedMethod);
        }
        m3474c(map, str).m3526b(annotatedMethod, findNameForDeserialization, z2, z3, z4);
    }

    protected void m3478g(Map<String, aja> map) {
        AnnotationIntrospector annotationIntrospector = this._annotationIntrospector;
        if (annotationIntrospector != null) {
            for (AnnotatedMember annotatedMember : this.aSK.EW()) {
                m3469a(annotationIntrospector.findInjectableValueId(annotatedMember), annotatedMember);
            }
            for (AnnotatedMember annotatedMember2 : this.aSK.EV()) {
                if (annotatedMember2.getParameterCount() == 1) {
                    m3469a(annotationIntrospector.findInjectableValueId(annotatedMember2), annotatedMember2);
                }
            }
        }
    }

    protected void m3469a(Object obj, AnnotatedMember annotatedMember) {
        if (obj != null) {
            if (this.aST == null) {
                this.aST = new LinkedHashMap();
            }
            if (((AnnotatedMember) this.aST.put(obj, annotatedMember)) != null) {
                throw new IllegalArgumentException("Duplicate injectable value with id '" + String.valueOf(obj) + "' (of type " + obj.getClass().getName() + ")");
            }
        }
    }

    private PropertyName bO(String str) {
        return PropertyName.construct(str, null);
    }

    protected void m3479h(Map<String, aja> map) {
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            aja com_fossil_aja = (aja) it.next();
            if (!com_fossil_aja.FV()) {
                it.remove();
            } else if (com_fossil_aja.FW()) {
                if (com_fossil_aja.Fd()) {
                    com_fossil_aja.FS();
                    if (!(this.aSI || com_fossil_aja.Ff())) {
                        bP(com_fossil_aja.getName());
                    }
                } else {
                    it.remove();
                    bP(com_fossil_aja.getName());
                }
            }
        }
    }

    protected void m3480i(Map<String, aja> map) {
        boolean isEnabled = this.aSz.isEnabled(MapperFeature.INFER_PROPERTY_MUTATORS);
        for (aja aM : map.values()) {
            aM.aM(isEnabled);
        }
    }

    private void bP(String str) {
        if (!this.aSI) {
            if (this.aSS == null) {
                this.aSS = new HashSet();
            }
            this.aSS.add(str);
        }
    }

    protected void m3481j(Map<String, aja> map) {
        Iterator it = map.entrySet().iterator();
        LinkedList linkedList = null;
        while (it.hasNext()) {
            aja com_fossil_aja = (aja) ((Entry) it.next()).getValue();
            Collection FX = com_fossil_aja.FX();
            if (!FX.isEmpty()) {
                it.remove();
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                if (FX.size() == 1) {
                    linkedList.add(com_fossil_aja.m3531d((PropertyName) FX.iterator().next()));
                } else {
                    linkedList.addAll(com_fossil_aja.m3525b(FX));
                }
            }
        }
        if (linkedList != null) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                aja com_fossil_aja2 = (aja) it2.next();
                String name = com_fossil_aja2.getName();
                com_fossil_aja = (aja) map.get(name);
                if (com_fossil_aja == null) {
                    map.put(name, com_fossil_aja2);
                } else {
                    com_fossil_aja.m3527b(com_fossil_aja2);
                }
                m3468a(com_fossil_aja2, this.aSO);
            }
        }
    }

    protected void m3470a(Map<String, aja> map, PropertyNamingStrategy propertyNamingStrategy) {
        aja[] com_fossil_ajaArr = (aja[]) map.values().toArray(new aja[map.size()]);
        map.clear();
        for (aja com_fossil_aja : com_fossil_ajaArr) {
            aja com_fossil_aja2;
            Object obj;
            PropertyName fullName = com_fossil_aja.getFullName();
            String str = null;
            if (!com_fossil_aja.Fe()) {
                if (this.aSI) {
                    if (com_fossil_aja.Fh()) {
                        str = propertyNamingStrategy.nameForGetterMethod(this.aSz, com_fossil_aja.Fl(), fullName.getSimpleName());
                    } else if (com_fossil_aja.Fj()) {
                        str = propertyNamingStrategy.nameForField(this.aSz, com_fossil_aja.Fn(), fullName.getSimpleName());
                    }
                } else if (com_fossil_aja.Fi()) {
                    str = propertyNamingStrategy.nameForSetterMethod(this.aSz, com_fossil_aja.Fm(), fullName.getSimpleName());
                } else if (com_fossil_aja.Fk()) {
                    str = propertyNamingStrategy.nameForConstructorParameter(this.aSz, com_fossil_aja.FM(), fullName.getSimpleName());
                } else if (com_fossil_aja.Fj()) {
                    str = propertyNamingStrategy.nameForField(this.aSz, com_fossil_aja.Fn(), fullName.getSimpleName());
                } else if (com_fossil_aja.Fh()) {
                    str = propertyNamingStrategy.nameForGetterMethod(this.aSz, com_fossil_aja.Fl(), fullName.getSimpleName());
                }
            }
            if (str == null || fullName.hasSimpleName(str)) {
                str = fullName.getSimpleName();
                com_fossil_aja2 = com_fossil_aja;
                String str2 = str;
            } else {
                com_fossil_aja2 = com_fossil_aja.bR(str);
                obj = str;
            }
            aja com_fossil_aja3 = (aja) map.get(obj);
            if (com_fossil_aja3 == null) {
                map.put(obj, com_fossil_aja2);
            } else {
                com_fossil_aja3.m3527b(com_fossil_aja2);
            }
            m3468a(com_fossil_aja2, this.aSO);
        }
    }

    protected void m3482k(Map<String, aja> map) {
        Iterator it = map.entrySet().iterator();
        LinkedList linkedList = null;
        while (it.hasNext()) {
            aja com_fossil_aja = (aja) ((Entry) it.next()).getValue();
            aiq Fs = com_fossil_aja.Fs();
            if (Fs != null) {
                PropertyName findWrapperName = this._annotationIntrospector.findWrapperName(Fs);
                if (!(findWrapperName == null || !findWrapperName.hasSimpleName() || findWrapperName.equals(com_fossil_aja.getFullName()))) {
                    if (linkedList == null) {
                        linkedList = new LinkedList();
                    }
                    linkedList.add(com_fossil_aja.m3531d(findWrapperName));
                    it.remove();
                }
            }
        }
        if (linkedList != null) {
            it = linkedList.iterator();
            while (it.hasNext()) {
                com_fossil_aja = (aja) it.next();
                String name = com_fossil_aja.getName();
                aja com_fossil_aja2 = (aja) map.get(name);
                if (com_fossil_aja2 == null) {
                    map.put(name, com_fossil_aja);
                } else {
                    com_fossil_aja2.m3527b(com_fossil_aja);
                }
            }
        }
    }

    protected void m3483l(Map<String, aja> map) {
        boolean shouldSortPropertiesAlphabetically;
        AnnotationIntrospector annotationIntrospector = this._annotationIntrospector;
        Boolean findSerializationSortAlphabetically = annotationIntrospector == null ? null : annotationIntrospector.findSerializationSortAlphabetically(this.aSK);
        if (findSerializationSortAlphabetically == null) {
            shouldSortPropertiesAlphabetically = this.aSz.shouldSortPropertiesAlphabetically();
        } else {
            shouldSortPropertiesAlphabetically = findSerializationSortAlphabetically.booleanValue();
        }
        String[] findSerializationPropertyOrder = annotationIntrospector == null ? null : annotationIntrospector.findSerializationPropertyOrder(this.aSK);
        if (shouldSortPropertiesAlphabetically || this.aSO != null || findSerializationPropertyOrder != null) {
            Map treeMap;
            Iterator it;
            aja com_fossil_aja;
            int size = map.size();
            if (shouldSortPropertiesAlphabetically) {
                treeMap = new TreeMap();
            } else {
                Object linkedHashMap = new LinkedHashMap(size + size);
            }
            for (aja com_fossil_aja2 : map.values()) {
                treeMap.put(com_fossil_aja2.getName(), com_fossil_aja2);
            }
            Map linkedHashMap2 = new LinkedHashMap(size + size);
            if (findSerializationPropertyOrder != null) {
                for (String str : findSerializationPropertyOrder) {
                    Object name;
                    Object obj = (aja) treeMap.get(str);
                    if (obj == null) {
                        for (aja com_fossil_aja3 : map.values()) {
                            if (str.equals(com_fossil_aja3.FL())) {
                                aja com_fossil_aja4 = com_fossil_aja3;
                                name = com_fossil_aja3.getName();
                                obj = com_fossil_aja4;
                                break;
                            }
                        }
                    }
                    String str2 = str;
                    if (obj != null) {
                        linkedHashMap2.put(name, obj);
                    }
                }
            }
            if (this.aSO != null) {
                Collection values;
                if (shouldSortPropertiesAlphabetically) {
                    TreeMap treeMap2 = new TreeMap();
                    it = this.aSO.iterator();
                    while (it.hasNext()) {
                        com_fossil_aja2 = (aja) it.next();
                        treeMap2.put(com_fossil_aja2.getName(), com_fossil_aja2);
                    }
                    values = treeMap2.values();
                } else {
                    values = this.aSO;
                }
                for (aja com_fossil_aja22 : r0) {
                    linkedHashMap2.put(com_fossil_aja22.getName(), com_fossil_aja22);
                }
            }
            linkedHashMap2.putAll(treeMap);
            map.clear();
            map.putAll(linkedHashMap2);
        }
    }

    protected void bQ(String str) {
        throw new IllegalArgumentException("Problem with definition of " + this.aSK + ": " + str);
    }

    protected aja m3467a(Map<String, aja> map, PropertyName propertyName) {
        return m3474c(map, propertyName.getSimpleName());
    }

    protected aja m3474c(Map<String, aja> map, String str) {
        aja com_fossil_aja = (aja) map.get(str);
        if (com_fossil_aja != null) {
            return com_fossil_aja;
        }
        com_fossil_aja = new aja(PropertyName.construct(str), this._annotationIntrospector, this.aSI);
        map.put(str, com_fossil_aja);
        return com_fossil_aja;
    }

    private PropertyNamingStrategy FK() {
        Object findNamingStrategy = this._annotationIntrospector == null ? null : this._annotationIntrospector.findNamingStrategy(this.aSK);
        if (findNamingStrategy == null) {
            return this.aSz.getPropertyNamingStrategy();
        }
        if (findNamingStrategy instanceof PropertyNamingStrategy) {
            return (PropertyNamingStrategy) findNamingStrategy;
        }
        if (findNamingStrategy instanceof Class) {
            Class cls = (Class) findNamingStrategy;
            if (PropertyNamingStrategy.class.isAssignableFrom(cls)) {
                ahr handlerInstantiator = this.aSz.getHandlerInstantiator();
                if (handlerInstantiator != null) {
                    PropertyNamingStrategy f = handlerInstantiator.m3349f(this.aSz, this.aSK, cls);
                    if (f != null) {
                        return f;
                    }
                }
                return (PropertyNamingStrategy) ami.m3863b(cls, this.aSz.canOverrideAccessModifiers());
            }
            throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<PropertyNamingStrategy>");
        }
        throw new IllegalStateException("AnnotationIntrospector returned PropertyNamingStrategy definition of type " + findNamingStrategy.getClass().getName() + "; expected type PropertyNamingStrategy or Class<PropertyNamingStrategy> instead");
    }

    protected void m3468a(aja com_fossil_aja, List<aja> list) {
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((aja) list.get(i)).FL().equals(com_fossil_aja.FL())) {
                    list.set(i, com_fossil_aja);
                    return;
                }
            }
        }
    }
}
