package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fossil.ahr;
import com.fossil.aiw;
import com.fossil.aju;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;

public final class BaseSettings implements Serializable {
    private static final long serialVersionUID = 1;
    protected final AnnotationIntrospector _annotationIntrospector;
    protected final aiw _classIntrospector;
    protected final DateFormat _dateFormat;
    protected final Base64Variant _defaultBase64;
    protected final ahr _handlerInstantiator;
    protected final Locale _locale;
    protected final PropertyNamingStrategy _propertyNamingStrategy;
    protected final TimeZone _timeZone;
    protected final TypeFactory _typeFactory;
    protected final aju<?> _typeResolverBuilder;
    protected final VisibilityChecker<?> _visibilityChecker;

    public BaseSettings(aiw com_fossil_aiw, AnnotationIntrospector annotationIntrospector, VisibilityChecker<?> visibilityChecker, PropertyNamingStrategy propertyNamingStrategy, TypeFactory typeFactory, aju<?> com_fossil_aju_, DateFormat dateFormat, ahr com_fossil_ahr, Locale locale, TimeZone timeZone, Base64Variant base64Variant) {
        this._classIntrospector = com_fossil_aiw;
        this._annotationIntrospector = annotationIntrospector;
        this._visibilityChecker = visibilityChecker;
        this._propertyNamingStrategy = propertyNamingStrategy;
        this._typeFactory = typeFactory;
        this._typeResolverBuilder = com_fossil_aju_;
        this._dateFormat = dateFormat;
        this._handlerInstantiator = com_fossil_ahr;
        this._locale = locale;
        this._timeZone = timeZone;
        this._defaultBase64 = base64Variant;
    }

    public BaseSettings withClassIntrospector(aiw com_fossil_aiw) {
        if (this._classIntrospector == com_fossil_aiw) {
            return this;
        }
        return new BaseSettings(com_fossil_aiw, this._annotationIntrospector, this._visibilityChecker, this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, this._handlerInstantiator, this._locale, this._timeZone, this._defaultBase64);
    }

    public BaseSettings withAnnotationIntrospector(AnnotationIntrospector annotationIntrospector) {
        if (this._annotationIntrospector == annotationIntrospector) {
            return this;
        }
        return new BaseSettings(this._classIntrospector, annotationIntrospector, this._visibilityChecker, this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, this._handlerInstantiator, this._locale, this._timeZone, this._defaultBase64);
    }

    public BaseSettings withInsertedAnnotationIntrospector(AnnotationIntrospector annotationIntrospector) {
        return withAnnotationIntrospector(AnnotationIntrospectorPair.create(annotationIntrospector, this._annotationIntrospector));
    }

    public BaseSettings withAppendedAnnotationIntrospector(AnnotationIntrospector annotationIntrospector) {
        return withAnnotationIntrospector(AnnotationIntrospectorPair.create(this._annotationIntrospector, annotationIntrospector));
    }

    public BaseSettings withVisibilityChecker(VisibilityChecker<?> visibilityChecker) {
        if (this._visibilityChecker == visibilityChecker) {
            return this;
        }
        return new BaseSettings(this._classIntrospector, this._annotationIntrospector, visibilityChecker, this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, this._handlerInstantiator, this._locale, this._timeZone, this._defaultBase64);
    }

    public BaseSettings withVisibility(PropertyAccessor propertyAccessor, Visibility visibility) {
        return new BaseSettings(this._classIntrospector, this._annotationIntrospector, this._visibilityChecker.withVisibility(propertyAccessor, visibility), this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, this._handlerInstantiator, this._locale, this._timeZone, this._defaultBase64);
    }

    public BaseSettings withPropertyNamingStrategy(PropertyNamingStrategy propertyNamingStrategy) {
        if (this._propertyNamingStrategy == propertyNamingStrategy) {
            return this;
        }
        return new BaseSettings(this._classIntrospector, this._annotationIntrospector, this._visibilityChecker, propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, this._handlerInstantiator, this._locale, this._timeZone, this._defaultBase64);
    }

    public BaseSettings withTypeFactory(TypeFactory typeFactory) {
        if (this._typeFactory == typeFactory) {
            return this;
        }
        return new BaseSettings(this._classIntrospector, this._annotationIntrospector, this._visibilityChecker, this._propertyNamingStrategy, typeFactory, this._typeResolverBuilder, this._dateFormat, this._handlerInstantiator, this._locale, this._timeZone, this._defaultBase64);
    }

    public BaseSettings withTypeResolverBuilder(aju<?> com_fossil_aju_) {
        if (this._typeResolverBuilder == com_fossil_aju_) {
            return this;
        }
        return new BaseSettings(this._classIntrospector, this._annotationIntrospector, this._visibilityChecker, this._propertyNamingStrategy, this._typeFactory, com_fossil_aju_, this._dateFormat, this._handlerInstantiator, this._locale, this._timeZone, this._defaultBase64);
    }

    public BaseSettings withDateFormat(DateFormat dateFormat) {
        if (this._dateFormat == dateFormat) {
            return this;
        }
        return new BaseSettings(this._classIntrospector, this._annotationIntrospector, this._visibilityChecker, this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, dateFormat, this._handlerInstantiator, this._locale, this._timeZone, this._defaultBase64);
    }

    public BaseSettings withHandlerInstantiator(ahr com_fossil_ahr) {
        if (this._handlerInstantiator == com_fossil_ahr) {
            return this;
        }
        return new BaseSettings(this._classIntrospector, this._annotationIntrospector, this._visibilityChecker, this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, com_fossil_ahr, this._locale, this._timeZone, this._defaultBase64);
    }

    public BaseSettings with(Locale locale) {
        if (this._locale == locale) {
            return this;
        }
        return new BaseSettings(this._classIntrospector, this._annotationIntrospector, this._visibilityChecker, this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, this._handlerInstantiator, locale, this._timeZone, this._defaultBase64);
    }

    public BaseSettings with(TimeZone timeZone) {
        if (timeZone == null) {
            throw new IllegalArgumentException();
        }
        DateFormat withTimeZone;
        DateFormat dateFormat = this._dateFormat;
        if (dateFormat instanceof StdDateFormat) {
            withTimeZone = ((StdDateFormat) dateFormat).withTimeZone(timeZone);
        } else {
            dateFormat = (DateFormat) dateFormat.clone();
            dateFormat.setTimeZone(timeZone);
            withTimeZone = dateFormat;
        }
        return new BaseSettings(this._classIntrospector, this._annotationIntrospector, this._visibilityChecker, this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, withTimeZone, this._handlerInstantiator, this._locale, timeZone, this._defaultBase64);
    }

    public BaseSettings with(Base64Variant base64Variant) {
        return base64Variant == this._defaultBase64 ? this : new BaseSettings(this._classIntrospector, this._annotationIntrospector, this._visibilityChecker, this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, this._handlerInstantiator, this._locale, this._timeZone, base64Variant);
    }

    public aiw getClassIntrospector() {
        return this._classIntrospector;
    }

    public AnnotationIntrospector getAnnotationIntrospector() {
        return this._annotationIntrospector;
    }

    public VisibilityChecker<?> getVisibilityChecker() {
        return this._visibilityChecker;
    }

    public PropertyNamingStrategy getPropertyNamingStrategy() {
        return this._propertyNamingStrategy;
    }

    public TypeFactory getTypeFactory() {
        return this._typeFactory;
    }

    public aju<?> getTypeResolverBuilder() {
        return this._typeResolverBuilder;
    }

    public DateFormat getDateFormat() {
        return this._dateFormat;
    }

    public ahr getHandlerInstantiator() {
        return this._handlerInstantiator;
    }

    public Locale getLocale() {
        return this._locale;
    }

    public TimeZone getTimeZone() {
        return this._timeZone;
    }

    public Base64Variant getBase64Variant() {
        return this._defaultBase64;
    }
}
