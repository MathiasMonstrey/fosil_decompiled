package com.fasterxml.jackson.databind.introspect;

import com.fossil.aiq;
import com.fossil.air;
import com.fossil.ait;
import com.fossil.ami;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.util.Collections;

public abstract class AnnotatedMember extends aiq implements Serializable {
    private static final long serialVersionUID = 1;
    protected final transient ait _annotations;
    protected final transient air _context;

    public abstract Class<?> getDeclaringClass();

    public abstract Member getMember();

    public abstract Object getValue(Object obj) throws UnsupportedOperationException, IllegalArgumentException;

    public abstract void setValue(Object obj, Object obj2) throws UnsupportedOperationException, IllegalArgumentException;

    protected AnnotatedMember(air com_fossil_air, ait com_fossil_ait) {
        this._context = com_fossil_air;
        this._annotations = com_fossil_ait;
    }

    protected AnnotatedMember(AnnotatedMember annotatedMember) {
        this._context = annotatedMember._context;
        this._annotations = annotatedMember._annotations;
    }

    public air getContextClass() {
        return this._context;
    }

    public Iterable<Annotation> annotations() {
        if (this._annotations == null) {
            return Collections.emptyList();
        }
        return this._annotations.annotations();
    }

    public ait getAllAnnotations() {
        return this._annotations;
    }

    public final boolean addOrOverride(Annotation annotation) {
        return this._annotations.m3449b(annotation);
    }

    public final boolean addIfNotPresent(Annotation annotation) {
        return this._annotations.addIfNotPresent(annotation);
    }

    public final void fixAccess() {
        ami.m3862a(getMember());
    }
}
