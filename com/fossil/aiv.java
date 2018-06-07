package com.fossil;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import java.util.Iterator;

public abstract class aiv {
    public abstract boolean Fd();

    public abstract boolean Fh();

    public abstract boolean Fi();

    public abstract boolean Fj();

    public abstract boolean Fk();

    public abstract AnnotatedMethod Fl();

    public abstract AnnotatedMethod Fm();

    public abstract AnnotatedField Fn();

    public abstract AnnotatedMember Fp();

    public abstract AnnotatedMember Fq();

    public abstract AnnotatedMember Fr();

    public abstract AnnotatedMember Fs();

    public abstract PropertyName getFullName();

    public abstract PropertyMetadata getMetadata();

    public abstract String getName();

    public abstract PropertyName getWrapperName();

    public boolean mo1009c(PropertyName propertyName) {
        return getFullName().equals(propertyName);
    }

    public boolean Fe() {
        return Fd();
    }

    public boolean Ff() {
        return Fq() != null;
    }

    public boolean Fg() {
        return Fp() != null;
    }

    public Iterator<AnnotatedParameter> Fo() {
        return aml.Hk();
    }

    public Class<?>[] Ft() {
        return null;
    }

    public ReferenceProperty Fu() {
        return null;
    }

    public boolean Fv() {
        return false;
    }

    public aiy Fw() {
        return null;
    }

    public Include Fx() {
        return null;
    }
}
