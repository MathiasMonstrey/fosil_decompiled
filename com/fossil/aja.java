package com.fossil;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class aja extends aiv implements Comparable<aja> {
    protected final AnnotationIntrospector _annotationIntrospector;
    protected final PropertyName aQf;
    protected final boolean aSI;
    protected final PropertyName aSU;
    protected C1660a<AnnotatedField> aSV;
    protected C1660a<AnnotatedParameter> aSW;
    protected C1660a<AnnotatedMethod> aSX;
    protected C1660a<AnnotatedMethod> aSY;

    interface C1650c<T> {
        T mo987c(AnnotatedMember annotatedMember);
    }

    class C16511 implements C1650c<Class<?>[]> {
        final /* synthetic */ aja aSZ;

        C16511(aja com_fossil_aja) {
            this.aSZ = com_fossil_aja;
        }

        public /* synthetic */ Object mo987c(AnnotatedMember annotatedMember) {
            return m3488b(annotatedMember);
        }

        public Class<?>[] m3488b(AnnotatedMember annotatedMember) {
            return this.aSZ._annotationIntrospector.findViews(annotatedMember);
        }
    }

    class C16533 implements C1650c<ReferenceProperty> {
        final /* synthetic */ aja aSZ;

        C16533(aja com_fossil_aja) {
            this.aSZ = com_fossil_aja;
        }

        public /* synthetic */ Object mo987c(AnnotatedMember annotatedMember) {
            return m3491d(annotatedMember);
        }

        public ReferenceProperty m3491d(AnnotatedMember annotatedMember) {
            return this.aSZ._annotationIntrospector.findReferenceType(annotatedMember);
        }
    }

    class C16544 implements C1650c<Boolean> {
        final /* synthetic */ aja aSZ;

        C16544(aja com_fossil_aja) {
            this.aSZ = com_fossil_aja;
        }

        public /* synthetic */ Object mo987c(AnnotatedMember annotatedMember) {
            return m3493e(annotatedMember);
        }

        public Boolean m3493e(AnnotatedMember annotatedMember) {
            return this.aSZ._annotationIntrospector.isTypeId(annotatedMember);
        }
    }

    class C16555 implements C1650c<Boolean> {
        final /* synthetic */ aja aSZ;

        C16555(aja com_fossil_aja) {
            this.aSZ = com_fossil_aja;
        }

        public /* synthetic */ Object mo987c(AnnotatedMember annotatedMember) {
            return m3495e(annotatedMember);
        }

        public Boolean m3495e(AnnotatedMember annotatedMember) {
            return this.aSZ._annotationIntrospector.hasRequiredMarker(annotatedMember);
        }
    }

    class C16566 implements C1650c<String> {
        final /* synthetic */ aja aSZ;

        C16566(aja com_fossil_aja) {
            this.aSZ = com_fossil_aja;
        }

        public /* synthetic */ Object mo987c(AnnotatedMember annotatedMember) {
            return m3497f(annotatedMember);
        }

        public String m3497f(AnnotatedMember annotatedMember) {
            return this.aSZ._annotationIntrospector.findPropertyDescription(annotatedMember);
        }
    }

    class C16577 implements C1650c<Integer> {
        final /* synthetic */ aja aSZ;

        C16577(aja com_fossil_aja) {
            this.aSZ = com_fossil_aja;
        }

        public /* synthetic */ Object mo987c(AnnotatedMember annotatedMember) {
            return m3499g(annotatedMember);
        }

        public Integer m3499g(AnnotatedMember annotatedMember) {
            return this.aSZ._annotationIntrospector.findPropertyIndex(annotatedMember);
        }
    }

    class C16588 implements C1650c<String> {
        final /* synthetic */ aja aSZ;

        C16588(aja com_fossil_aja) {
            this.aSZ = com_fossil_aja;
        }

        public /* synthetic */ Object mo987c(AnnotatedMember annotatedMember) {
            return m3501f(annotatedMember);
        }

        public String m3501f(AnnotatedMember annotatedMember) {
            return this.aSZ._annotationIntrospector.findPropertyDefaultValue(annotatedMember);
        }
    }

    class C16599 implements C1650c<aiy> {
        final /* synthetic */ aja aSZ;

        C16599(aja com_fossil_aja) {
            this.aSZ = com_fossil_aja;
        }

        public /* synthetic */ Object mo987c(AnnotatedMember annotatedMember) {
            return m3503h(annotatedMember);
        }

        public aiy m3503h(AnnotatedMember annotatedMember) {
            aiy findObjectIdInfo = this.aSZ._annotationIntrospector.findObjectIdInfo(annotatedMember);
            if (findObjectIdInfo != null) {
                return this.aSZ._annotationIntrospector.findObjectReferenceInfo(annotatedMember, findObjectIdInfo);
            }
            return findObjectIdInfo;
        }
    }

    public static final class C1660a<T> {
        public final boolean aEE;
        public final C1660a<T> aTb;
        public final PropertyName aTc;
        public final boolean aTd;
        public final boolean aTe;
        public final T value;

        public C1660a(T t, C1660a<T> c1660a, PropertyName propertyName, boolean z, boolean z2, boolean z3) {
            PropertyName propertyName2;
            this.value = t;
            this.aTb = c1660a;
            if (propertyName == null || propertyName.isEmpty()) {
                propertyName2 = null;
            } else {
                propertyName2 = propertyName;
            }
            this.aTc = propertyName2;
            if (z) {
                if (this.aTc == null) {
                    throw new IllegalArgumentException("Can not pass true for 'explName' if name is null/empty");
                } else if (!propertyName.hasSimpleName()) {
                    z = false;
                }
            }
            this.aTd = z;
            this.aEE = z2;
            this.aTe = z3;
        }

        public C1660a<T> FY() {
            return this.aTb == null ? this : new C1660a(this.value, null, this.aTc, this.aTd, this.aEE, this.aTe);
        }

        public C1660a<T> bz(T t) {
            if (t == this.value) {
                return this;
            }
            return new C1660a(t, this.aTb, this.aTc, this.aTd, this.aEE, this.aTe);
        }

        public C1660a<T> m3504i(C1660a<T> c1660a) {
            if (c1660a == this.aTb) {
                return this;
            }
            return new C1660a(this.value, c1660a, this.aTc, this.aTd, this.aEE, this.aTe);
        }

        public C1660a<T> FZ() {
            if (this.aTe) {
                return this.aTb == null ? null : this.aTb.FZ();
            } else {
                if (this.aTb != null) {
                    C1660a FZ = this.aTb.FZ();
                    if (FZ != this.aTb) {
                        return m3504i(FZ);
                    }
                }
                return this;
            }
        }

        public C1660a<T> Ga() {
            C1660a<T> Ga = this.aTb == null ? null : this.aTb.Ga();
            return this.aEE ? m3504i(Ga) : Ga;
        }

        protected C1660a<T> m3505j(C1660a<T> c1660a) {
            if (this.aTb == null) {
                return m3504i(c1660a);
            }
            return m3504i(this.aTb.m3505j(c1660a));
        }

        public C1660a<T> Gb() {
            if (this.aTb == null) {
                return this;
            }
            C1660a<T> Gb = this.aTb.Gb();
            if (this.aTc != null) {
                if (Gb.aTc == null) {
                    return m3504i(null);
                }
                return m3504i(Gb);
            } else if (Gb.aTc != null) {
                return Gb;
            } else {
                if (this.aEE == Gb.aEE) {
                    return m3504i(Gb);
                }
                return this.aEE ? m3504i(null) : Gb;
            }
        }

        public String toString() {
            String str = this.value.toString() + "[visible=" + this.aEE + ",ignore=" + this.aTe + ",explicitName=" + this.aTd + "]";
            if (this.aTb != null) {
                return str + ", " + this.aTb.toString();
            }
            return str;
        }
    }

    public static class C1661b<T extends AnnotatedMember> implements Iterator<T> {
        private C1660a<T> aTb;

        public /* synthetic */ Object next() {
            return Gc();
        }

        public C1661b(C1660a<T> c1660a) {
            this.aTb = c1660a;
        }

        public boolean hasNext() {
            return this.aTb != null;
        }

        public T Gc() {
            if (this.aTb == null) {
                throw new NoSuchElementException();
            }
            AnnotatedMember annotatedMember = (AnnotatedMember) this.aTb.value;
            this.aTb = this.aTb.aTb;
            return annotatedMember;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m3519a((aja) obj);
    }

    public aja(PropertyName propertyName, AnnotationIntrospector annotationIntrospector, boolean z) {
        this(propertyName, propertyName, annotationIntrospector, z);
    }

    protected aja(PropertyName propertyName, PropertyName propertyName2, AnnotationIntrospector annotationIntrospector, boolean z) {
        this.aSU = propertyName;
        this.aQf = propertyName2;
        this._annotationIntrospector = annotationIntrospector;
        this.aSI = z;
    }

    public aja(aja com_fossil_aja, PropertyName propertyName) {
        this.aSU = com_fossil_aja.aSU;
        this.aQf = propertyName;
        this._annotationIntrospector = com_fossil_aja._annotationIntrospector;
        this.aSV = com_fossil_aja.aSV;
        this.aSW = com_fossil_aja.aSW;
        this.aSX = com_fossil_aja.aSX;
        this.aSY = com_fossil_aja.aSY;
        this.aSI = com_fossil_aja.aSI;
    }

    public aja m3531d(PropertyName propertyName) {
        return new aja(this, propertyName);
    }

    public aja bR(String str) {
        PropertyName withSimpleName = this.aQf.withSimpleName(str);
        return withSimpleName == this.aQf ? this : new aja(this, withSimpleName);
    }

    public int m3519a(aja com_fossil_aja) {
        if (this.aSW != null) {
            if (com_fossil_aja.aSW == null) {
                return -1;
            }
        } else if (com_fossil_aja.aSW != null) {
            return 1;
        }
        return getName().compareTo(com_fossil_aja.getName());
    }

    public String getName() {
        return this.aQf == null ? null : this.aQf.getSimpleName();
    }

    public PropertyName getFullName() {
        return this.aQf;
    }

    public boolean mo1009c(PropertyName propertyName) {
        return this.aQf.equals(propertyName);
    }

    public String FL() {
        return this.aSU.getSimpleName();
    }

    public PropertyName getWrapperName() {
        aiq Fs = Fs();
        return (Fs == null || this._annotationIntrospector == null) ? null : this._annotationIntrospector.findWrapperName(Fs);
    }

    public boolean Fd() {
        return m3515e(this.aSV) || m3515e(this.aSX) || m3515e(this.aSY) || m3515e(this.aSW);
    }

    public boolean Fe() {
        return m3516f(this.aSV) || m3516f(this.aSX) || m3516f(this.aSY) || m3516f(this.aSW);
    }

    public boolean Fh() {
        return this.aSX != null;
    }

    public boolean Fi() {
        return this.aSY != null;
    }

    public boolean Fj() {
        return this.aSV != null;
    }

    public boolean Fk() {
        return this.aSW != null;
    }

    public boolean Ff() {
        return (this.aSW == null && this.aSY == null && this.aSV == null) ? false : true;
    }

    public boolean Fg() {
        return (this.aSX == null && this.aSV == null) ? false : true;
    }

    public AnnotatedMethod Fl() {
        C1660a c1660a = this.aSX;
        if (c1660a == null) {
            return null;
        }
        C1660a c1660a2 = c1660a.aTb;
        if (c1660a2 == null) {
            return (AnnotatedMethod) c1660a.value;
        }
        while (c1660a2 != null) {
            C1660a c1660a3;
            Class declaringClass = ((AnnotatedMethod) c1660a.value).getDeclaringClass();
            Class declaringClass2 = ((AnnotatedMethod) c1660a2.value).getDeclaringClass();
            if (declaringClass != declaringClass2) {
                if (declaringClass.isAssignableFrom(declaringClass2)) {
                    c1660a3 = c1660a2;
                } else if (declaringClass2.isAssignableFrom(declaringClass)) {
                    c1660a3 = c1660a;
                }
                c1660a2 = c1660a2.aTb;
                c1660a = c1660a3;
            }
            int c = m3528c((AnnotatedMethod) c1660a2.value);
            int c2 = m3528c((AnnotatedMethod) c1660a.value);
            if (c != c2) {
                if (c < c2) {
                    c1660a3 = c1660a2;
                } else {
                    c1660a3 = c1660a;
                }
                c1660a2 = c1660a2.aTb;
                c1660a = c1660a3;
            } else {
                throw new IllegalArgumentException("Conflicting getter definitions for property \"" + getName() + "\": " + ((AnnotatedMethod) c1660a.value).getFullName() + " vs " + ((AnnotatedMethod) c1660a2.value).getFullName());
            }
        }
        this.aSX = c1660a.FY();
        return (AnnotatedMethod) c1660a.value;
    }

    public AnnotatedMethod Fm() {
        C1660a c1660a = this.aSY;
        if (c1660a == null) {
            return null;
        }
        C1660a c1660a2 = c1660a.aTb;
        if (c1660a2 == null) {
            return (AnnotatedMethod) c1660a.value;
        }
        while (c1660a2 != null) {
            C1660a c1660a3;
            Class declaringClass = ((AnnotatedMethod) c1660a.value).getDeclaringClass();
            Class declaringClass2 = ((AnnotatedMethod) c1660a2.value).getDeclaringClass();
            if (declaringClass != declaringClass2) {
                if (declaringClass.isAssignableFrom(declaringClass2)) {
                    c1660a3 = c1660a2;
                } else if (declaringClass2.isAssignableFrom(declaringClass)) {
                    c1660a3 = c1660a;
                }
                c1660a2 = c1660a2.aTb;
                c1660a = c1660a3;
            }
            int d = m3530d((AnnotatedMethod) c1660a2.value);
            int d2 = m3530d((AnnotatedMethod) c1660a.value);
            if (d != d2) {
                if (d < d2) {
                    c1660a3 = c1660a2;
                } else {
                    c1660a3 = c1660a;
                }
                c1660a2 = c1660a2.aTb;
                c1660a = c1660a3;
            } else {
                throw new IllegalArgumentException("Conflicting setter definitions for property \"" + getName() + "\": " + ((AnnotatedMethod) c1660a.value).getFullName() + " vs " + ((AnnotatedMethod) c1660a2.value).getFullName());
            }
        }
        this.aSY = c1660a.FY();
        return (AnnotatedMethod) c1660a.value;
    }

    public AnnotatedField Fn() {
        if (this.aSV == null) {
            return null;
        }
        AnnotatedField annotatedField = (AnnotatedField) this.aSV.value;
        C1660a c1660a = this.aSV.aTb;
        AnnotatedField annotatedField2 = annotatedField;
        while (c1660a != null) {
            annotatedField = (AnnotatedField) c1660a.value;
            Class declaringClass = annotatedField2.getDeclaringClass();
            Class declaringClass2 = annotatedField.getDeclaringClass();
            if (declaringClass != declaringClass2) {
                if (!declaringClass.isAssignableFrom(declaringClass2)) {
                    if (declaringClass2.isAssignableFrom(declaringClass)) {
                        annotatedField = annotatedField2;
                    }
                }
                c1660a = c1660a.aTb;
                annotatedField2 = annotatedField;
            }
            throw new IllegalArgumentException("Multiple fields representing property \"" + getName() + "\": " + annotatedField2.getFullName() + " vs " + annotatedField.getFullName());
        }
        return annotatedField2;
    }

    public AnnotatedParameter FM() {
        if (this.aSW == null) {
            return null;
        }
        C1660a c1660a = this.aSW;
        while (!(((AnnotatedParameter) c1660a.value).getOwner() instanceof AnnotatedConstructor)) {
            C1660a c1660a2 = c1660a.aTb;
            if (c1660a2 == null) {
                return (AnnotatedParameter) this.aSW.value;
            }
            c1660a = c1660a2;
        }
        return (AnnotatedParameter) c1660a.value;
    }

    public Iterator<AnnotatedParameter> Fo() {
        if (this.aSW == null) {
            return aml.Hk();
        }
        return new C1661b(this.aSW);
    }

    public AnnotatedMember Fp() {
        AnnotatedMember Fl = Fl();
        if (Fl == null) {
            return Fn();
        }
        return Fl;
    }

    public AnnotatedMember Fq() {
        AnnotatedMember FM = FM();
        if (FM != null) {
            return FM;
        }
        FM = Fm();
        if (FM == null) {
            return Fn();
        }
        return FM;
    }

    public AnnotatedMember Fr() {
        AnnotatedMember Fm = Fm();
        if (Fm == null) {
            return Fn();
        }
        return Fm;
    }

    public AnnotatedMember Fs() {
        if (this.aSI) {
            return Fp();
        }
        return Fq();
    }

    protected int m3528c(AnnotatedMethod annotatedMethod) {
        String name = annotatedMethod.getName();
        if (name.startsWith("get") && name.length() > 3) {
            return 1;
        }
        if (!name.startsWith("is") || name.length() <= 2) {
            return 3;
        }
        return 2;
    }

    protected int m3530d(AnnotatedMethod annotatedMethod) {
        String name = annotatedMethod.getName();
        if (!name.startsWith("set") || name.length() <= 3) {
            return 2;
        }
        return 1;
    }

    public Class<?>[] Ft() {
        return (Class[]) m3520a(new C16511(this));
    }

    public ReferenceProperty Fu() {
        return (ReferenceProperty) m3520a(new C16533(this));
    }

    public boolean Fv() {
        Boolean bool = (Boolean) m3520a(new C16544(this));
        return bool != null && bool.booleanValue();
    }

    public PropertyMetadata getMetadata() {
        Boolean FN = FN();
        String FO = FO();
        Integer FP = FP();
        String FQ = FQ();
        if (FN == null && FP == null && FQ == null) {
            return FO == null ? PropertyMetadata.STD_REQUIRED_OR_OPTIONAL : PropertyMetadata.STD_REQUIRED_OR_OPTIONAL.withDescription(FO);
        } else {
            return PropertyMetadata.construct(FN.booleanValue(), FO, FP, FQ);
        }
    }

    protected Boolean FN() {
        return (Boolean) m3520a(new C16555(this));
    }

    protected String FO() {
        return (String) m3520a(new C16566(this));
    }

    protected Integer FP() {
        return (Integer) m3520a(new C16577(this));
    }

    protected String FQ() {
        return (String) m3520a(new C16588(this));
    }

    public aiy Fw() {
        return (aiy) m3520a(new C16599(this));
    }

    public Include Fx() {
        if (this._annotationIntrospector == null) {
            return null;
        }
        return this._annotationIntrospector.findSerializationInclusion(Fp(), null);
    }

    public Access FR() {
        return (Access) m3521a(new C1650c<Access>(this) {
            final /* synthetic */ aja aSZ;

            {
                this.aSZ = r1;
            }

            public /* synthetic */ Object mo987c(AnnotatedMember annotatedMember) {
                return m3487i(annotatedMember);
            }

            public Access m3487i(AnnotatedMember annotatedMember) {
                return this.aSZ._annotationIntrospector.findPropertyAccess(annotatedMember);
            }
        }, Access.AUTO);
    }

    public void m3522a(AnnotatedField annotatedField, PropertyName propertyName, boolean z, boolean z2, boolean z3) {
        this.aSV = new C1660a(annotatedField, this.aSV, propertyName, z, z2, z3);
    }

    public void m3524a(AnnotatedParameter annotatedParameter, PropertyName propertyName, boolean z, boolean z2, boolean z3) {
        this.aSW = new C1660a(annotatedParameter, this.aSW, propertyName, z, z2, z3);
    }

    public void m3523a(AnnotatedMethod annotatedMethod, PropertyName propertyName, boolean z, boolean z2, boolean z3) {
        this.aSX = new C1660a(annotatedMethod, this.aSX, propertyName, z, z2, z3);
    }

    public void m3526b(AnnotatedMethod annotatedMethod, PropertyName propertyName, boolean z, boolean z2, boolean z3) {
        this.aSY = new C1660a(annotatedMethod, this.aSY, propertyName, z, z2, z3);
    }

    public void m3527b(aja com_fossil_aja) {
        this.aSV = m3509a(this.aSV, com_fossil_aja.aSV);
        this.aSW = m3509a(this.aSW, com_fossil_aja.aSW);
        this.aSX = m3509a(this.aSX, com_fossil_aja.aSX);
        this.aSY = m3509a(this.aSY, com_fossil_aja.aSY);
    }

    private static <T> C1660a<T> m3509a(C1660a<T> c1660a, C1660a<T> c1660a2) {
        if (c1660a == null) {
            return c1660a2;
        }
        if (c1660a2 == null) {
            return c1660a;
        }
        return c1660a.m3505j(c1660a2);
    }

    public void FS() {
        this.aSV = m3512b(this.aSV);
        this.aSX = m3512b(this.aSX);
        this.aSY = m3512b(this.aSY);
        this.aSW = m3512b(this.aSW);
    }

    public void aM(boolean z) {
        Access FR = FR();
        if (FR == null) {
            FR = Access.AUTO;
        }
        switch (FR) {
            case READ_ONLY:
                this.aSY = null;
                this.aSW = null;
                if (!this.aSI) {
                    this.aSV = null;
                    return;
                }
                return;
            case READ_WRITE:
                return;
            case WRITE_ONLY:
                this.aSX = null;
                if (this.aSI) {
                    this.aSV = null;
                    return;
                }
                return;
            default:
                this.aSX = m3513c(this.aSX);
                this.aSW = m3513c(this.aSW);
                if (!z || this.aSX == null) {
                    this.aSV = m3513c(this.aSV);
                    this.aSY = m3513c(this.aSY);
                    return;
                }
                return;
        }
    }

    public void FT() {
        this.aSW = null;
    }

    public void FU() {
        this.aSV = m3514d(this.aSV);
        this.aSX = m3514d(this.aSX);
        this.aSY = m3514d(this.aSY);
        this.aSW = m3514d(this.aSW);
    }

    public void aN(boolean z) {
        if (z) {
            if (this.aSX != null) {
                this.aSX = m3508a(this.aSX, m3506a(0, this.aSX, this.aSV, this.aSW, this.aSY));
            } else if (this.aSV != null) {
                this.aSV = m3508a(this.aSV, m3506a(0, this.aSV, this.aSW, this.aSY));
            }
        } else if (this.aSW != null) {
            this.aSW = m3508a(this.aSW, m3506a(0, this.aSW, this.aSY, this.aSV, this.aSX));
        } else if (this.aSY != null) {
            this.aSY = m3508a(this.aSY, m3506a(0, this.aSY, this.aSV, this.aSX));
        } else if (this.aSV != null) {
            this.aSV = m3508a(this.aSV, m3506a(0, this.aSV, this.aSX));
        }
    }

    private ait m3506a(int i, C1660a<? extends AnnotatedMember>... c1660aArr) {
        ait a = m3507a(c1660aArr[i]);
        for (int i2 = i + 1; i2 < c1660aArr.length; i2++) {
            if (c1660aArr[i2] != null) {
                return ait.m3448a(a, m3506a(i2, (C1660a[]) c1660aArr));
            }
        }
        return a;
    }

    private <T extends AnnotatedMember> ait m3507a(C1660a<T> c1660a) {
        ait allAnnotations = ((AnnotatedMember) c1660a.value).getAllAnnotations();
        if (c1660a.aTb != null) {
            return ait.m3448a(allAnnotations, m3507a(c1660a.aTb));
        }
        return allAnnotations;
    }

    private <T extends AnnotatedMember> C1660a<T> m3508a(C1660a<T> c1660a, ait com_fossil_ait) {
        AnnotatedMember annotatedMember = (AnnotatedMember) ((AnnotatedMember) c1660a.value).withAnnotations(com_fossil_ait);
        if (c1660a.aTb != null) {
            c1660a = c1660a.m3504i(m3508a(c1660a.aTb, com_fossil_ait));
        }
        return c1660a.bz(annotatedMember);
    }

    private <T> C1660a<T> m3512b(C1660a<T> c1660a) {
        return c1660a == null ? c1660a : c1660a.FZ();
    }

    private <T> C1660a<T> m3513c(C1660a<T> c1660a) {
        return c1660a == null ? c1660a : c1660a.Ga();
    }

    private <T> C1660a<T> m3514d(C1660a<T> c1660a) {
        return c1660a == null ? c1660a : c1660a.Gb();
    }

    private <T> boolean m3515e(C1660a<T> c1660a) {
        while (c1660a != null) {
            if (c1660a.aTc != null && c1660a.aTc.hasSimpleName()) {
                return true;
            }
            c1660a = c1660a.aTb;
        }
        return false;
    }

    private <T> boolean m3516f(C1660a<T> c1660a) {
        while (c1660a != null) {
            if (c1660a.aTc != null && c1660a.aTd) {
                return true;
            }
            c1660a = c1660a.aTb;
        }
        return false;
    }

    public boolean FV() {
        return m3517g(this.aSV) || m3517g(this.aSX) || m3517g(this.aSY) || m3517g(this.aSW);
    }

    private <T> boolean m3517g(C1660a<T> c1660a) {
        while (c1660a != null) {
            if (c1660a.aEE) {
                return true;
            }
            c1660a = c1660a.aTb;
        }
        return false;
    }

    public boolean FW() {
        return m3518h(this.aSV) || m3518h(this.aSX) || m3518h(this.aSY) || m3518h(this.aSW);
    }

    private <T> boolean m3518h(C1660a<T> c1660a) {
        while (c1660a != null) {
            if (c1660a.aTe) {
                return true;
            }
            c1660a = c1660a.aTb;
        }
        return false;
    }

    public Set<PropertyName> FX() {
        Set<PropertyName> a = m3510a(this.aSW, m3510a(this.aSY, m3510a(this.aSX, m3510a(this.aSV, null))));
        if (a == null) {
            return Collections.emptySet();
        }
        return a;
    }

    public Collection<aja> m3525b(Collection<PropertyName> collection) {
        Object hashMap = new HashMap();
        m3511a(collection, hashMap, this.aSV);
        m3511a(collection, hashMap, this.aSX);
        m3511a(collection, hashMap, this.aSY);
        m3511a(collection, hashMap, this.aSW);
        return hashMap.values();
    }

    private void m3511a(Collection<PropertyName> collection, Map<PropertyName, aja> map, C1660a<?> c1660a) {
        for (C1660a c1660a2 = c1660a; c1660a2 != null; c1660a2 = c1660a2.aTb) {
            PropertyName propertyName = c1660a2.aTc;
            if (c1660a2.aTd && propertyName != null) {
                aja com_fossil_aja = (aja) map.get(propertyName);
                if (com_fossil_aja == null) {
                    com_fossil_aja = new aja(this.aSU, propertyName, this._annotationIntrospector, this.aSI);
                    map.put(propertyName, com_fossil_aja);
                }
                if (c1660a == this.aSV) {
                    com_fossil_aja.aSV = c1660a2.m3504i(com_fossil_aja.aSV);
                } else if (c1660a == this.aSX) {
                    com_fossil_aja.aSX = c1660a2.m3504i(com_fossil_aja.aSX);
                } else if (c1660a == this.aSY) {
                    com_fossil_aja.aSY = c1660a2.m3504i(com_fossil_aja.aSY);
                } else if (c1660a == this.aSW) {
                    com_fossil_aja.aSW = c1660a2.m3504i(com_fossil_aja.aSW);
                } else {
                    throw new IllegalStateException("Internal error: mismatched accessors, property: " + this);
                }
            } else if (c1660a2.aEE) {
                throw new IllegalStateException("Conflicting/ambiguous property name definitions (implicit name '" + this.aQf + "'): found multiple explicit names: " + collection + ", but also implicit accessor: " + c1660a2);
            }
        }
    }

    private Set<PropertyName> m3510a(C1660a<? extends AnnotatedMember> c1660a, Set<PropertyName> set) {
        Set<PropertyName> set2 = set;
        while (c1660a != null) {
            if (c1660a.aTd && c1660a.aTc != null) {
                if (set2 == null) {
                    set2 = new HashSet();
                }
                set2.add(c1660a.aTc);
            }
            c1660a = c1660a.aTb;
        }
        return set2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[Property '").append(this.aQf).append("'; ctors: ").append(this.aSW).append(", field(s): ").append(this.aSV).append(", getter(s): ").append(this.aSX).append(", setter(s): ").append(this.aSY);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    protected <T> T m3520a(C1650c<T> c1650c) {
        T t = null;
        if (this._annotationIntrospector == null) {
            return null;
        }
        if (!this.aSI) {
            if (this.aSW != null) {
                t = c1650c.mo987c((AnnotatedMember) this.aSW.value);
            }
            if (t == null && this.aSY != null) {
                t = c1650c.mo987c((AnnotatedMember) this.aSY.value);
            }
        } else if (this.aSX != null) {
            t = c1650c.mo987c((AnnotatedMember) this.aSX.value);
        }
        if (t != null || this.aSV == null) {
            return t;
        }
        return c1650c.mo987c((AnnotatedMember) this.aSV.value);
    }

    protected <T> T m3521a(C1650c<T> c1650c, T t) {
        if (this._annotationIntrospector == null) {
            return null;
        }
        T c;
        if (this.aSI) {
            if (this.aSX != null) {
                c = c1650c.mo987c((AnnotatedMember) this.aSX.value);
                if (!(c == null || c == t)) {
                    return c;
                }
            }
            if (this.aSV != null) {
                c = c1650c.mo987c((AnnotatedMember) this.aSV.value);
                if (!(c == null || c == t)) {
                    return c;
                }
            }
            if (this.aSW != null) {
                c = c1650c.mo987c((AnnotatedMember) this.aSW.value);
                if (!(c == null || c == t)) {
                    return c;
                }
            }
            if (this.aSY != null) {
                c = c1650c.mo987c((AnnotatedMember) this.aSY.value);
                if (!(c == null || c == t)) {
                    return c;
                }
            }
            return null;
        }
        if (this.aSW != null) {
            c = c1650c.mo987c((AnnotatedMember) this.aSW.value);
            if (!(c == null || c == t)) {
                return c;
            }
        }
        if (this.aSY != null) {
            c = c1650c.mo987c((AnnotatedMember) this.aSY.value);
            if (!(c == null || c == t)) {
                return c;
            }
        }
        if (this.aSV != null) {
            c = c1650c.mo987c((AnnotatedMember) this.aSV.value);
            if (!(c == null || c == t)) {
                return c;
            }
        }
        if (this.aSX != null) {
            c = c1650c.mo987c((AnnotatedMember) this.aSX.value);
            if (!(c == null || c == t)) {
                return c;
            }
        }
        return null;
    }
}
