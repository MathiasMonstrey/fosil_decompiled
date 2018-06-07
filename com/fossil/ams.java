package com.fossil;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import java.util.Collections;
import java.util.Iterator;

public class ams extends aiv {
    protected final PropertyMetadata _metadata;
    @Deprecated
    protected final String _name;
    protected final AnnotatedMember aQg;
    protected final AnnotationIntrospector aWc;
    protected final PropertyName aWd;
    protected final Include aWe;

    protected ams(AnnotatedMember annotatedMember, PropertyName propertyName, AnnotationIntrospector annotationIntrospector, PropertyMetadata propertyMetadata, Include include) {
        this.aWc = annotationIntrospector;
        this.aQg = annotatedMember;
        this.aWd = propertyName;
        this._name = propertyName.getSimpleName();
        if (propertyMetadata == null) {
            propertyMetadata = PropertyMetadata.STD_OPTIONAL;
        }
        this._metadata = propertyMetadata;
        this.aWe = include;
    }

    public static ams m3895a(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember) {
        return new ams(annotatedMember, PropertyName.construct(annotatedMember.getName()), mapperConfig == null ? null : mapperConfig.getAnnotationIntrospector(), null, null);
    }

    public static ams m3896a(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, PropertyName propertyName) {
        return m3897a(mapperConfig, annotatedMember, propertyName, null, null);
    }

    public static ams m3897a(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, PropertyName propertyName, PropertyMetadata propertyMetadata, Include include) {
        return new ams(annotatedMember, propertyName, mapperConfig == null ? null : mapperConfig.getAnnotationIntrospector(), propertyMetadata, include);
    }

    public String getName() {
        return this.aWd.getSimpleName();
    }

    public PropertyName getFullName() {
        return this.aWd;
    }

    public boolean mo1009c(PropertyName propertyName) {
        return this.aWd.equals(propertyName);
    }

    public PropertyName getWrapperName() {
        return (this.aWc != null || this.aQg == null) ? this.aWc.findWrapperName(this.aQg) : null;
    }

    public boolean Fd() {
        return false;
    }

    public boolean Fe() {
        return false;
    }

    public PropertyMetadata getMetadata() {
        return this._metadata;
    }

    public Include Fx() {
        return this.aWe;
    }

    public boolean Fh() {
        return Fl() != null;
    }

    public boolean Fi() {
        return Fm() != null;
    }

    public boolean Fj() {
        return this.aQg instanceof AnnotatedField;
    }

    public boolean Fk() {
        return this.aQg instanceof AnnotatedParameter;
    }

    public AnnotatedMethod Fl() {
        if ((this.aQg instanceof AnnotatedMethod) && ((AnnotatedMethod) this.aQg).getParameterCount() == 0) {
            return (AnnotatedMethod) this.aQg;
        }
        return null;
    }

    public AnnotatedMethod Fm() {
        if ((this.aQg instanceof AnnotatedMethod) && ((AnnotatedMethod) this.aQg).getParameterCount() == 1) {
            return (AnnotatedMethod) this.aQg;
        }
        return null;
    }

    public AnnotatedField Fn() {
        return this.aQg instanceof AnnotatedField ? (AnnotatedField) this.aQg : null;
    }

    public AnnotatedParameter FM() {
        return this.aQg instanceof AnnotatedParameter ? (AnnotatedParameter) this.aQg : null;
    }

    public Iterator<AnnotatedParameter> Fo() {
        AnnotatedParameter FM = FM();
        if (FM == null) {
            return aml.Hk();
        }
        return Collections.singleton(FM).iterator();
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
        return this.aQg;
    }
}
