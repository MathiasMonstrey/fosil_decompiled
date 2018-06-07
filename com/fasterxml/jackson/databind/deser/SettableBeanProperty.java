package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.JsonFormat.C1501b;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.impl.FailingDeserializer;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.util.ViewMatcher;
import com.fossil.agv;
import com.fossil.agy;
import com.fossil.aiq;
import com.fossil.aiv;
import com.fossil.aiy;
import com.fossil.ajl;
import com.fossil.ajs;
import com.fossil.amc;
import java.io.IOException;
import java.io.Serializable;
import java.lang.annotation.Annotation;

public abstract class SettableBeanProperty implements agv, Serializable {
    protected static final agy<Object> MISSING_VALUE_DESERIALIZER = new FailingDeserializer("No _valueDeserializer assigned");
    protected final transient amc _contextAnnotations;
    protected String _managedReferenceName;
    protected final PropertyMetadata _metadata;
    protected aiy _objectIdInfo;
    protected final PropertyName _propName;
    protected int _propertyIndex;
    protected final JavaType _type;
    protected final agy<Object> _valueDeserializer;
    protected final ajs _valueTypeDeserializer;
    protected ViewMatcher _viewMatcher;
    protected final PropertyName _wrapperName;

    public abstract void deserializeAndSet(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException;

    public abstract Object deserializeSetAndReturn(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException;

    public abstract <A extends Annotation> A getAnnotation(Class<A> cls);

    public abstract AnnotatedMember getMember();

    public abstract void set(Object obj, Object obj2) throws IOException;

    public abstract Object setAndReturn(Object obj, Object obj2) throws IOException;

    public abstract SettableBeanProperty withName(PropertyName propertyName);

    public abstract SettableBeanProperty withValueDeserializer(agy<?> com_fossil_agy_);

    protected SettableBeanProperty(aiv com_fossil_aiv, JavaType javaType, ajs com_fossil_ajs, amc com_fossil_amc) {
        this(com_fossil_aiv.getFullName(), javaType, com_fossil_aiv.getWrapperName(), com_fossil_ajs, com_fossil_amc, com_fossil_aiv.getMetadata());
    }

    @Deprecated
    protected SettableBeanProperty(String str, JavaType javaType, PropertyName propertyName, ajs com_fossil_ajs, amc com_fossil_amc, boolean z) {
        this(new PropertyName(str), javaType, propertyName, com_fossil_ajs, com_fossil_amc, PropertyMetadata.construct(z, null, null, null));
    }

    protected SettableBeanProperty(PropertyName propertyName, JavaType javaType, PropertyName propertyName2, ajs com_fossil_ajs, amc com_fossil_amc, PropertyMetadata propertyMetadata) {
        this._propertyIndex = -1;
        if (propertyName == null) {
            this._propName = PropertyName.NO_NAME;
        } else {
            this._propName = propertyName.internSimpleName();
        }
        this._type = javaType;
        this._wrapperName = propertyName2;
        this._metadata = propertyMetadata;
        this._contextAnnotations = com_fossil_amc;
        this._viewMatcher = null;
        if (com_fossil_ajs != null) {
            com_fossil_ajs = com_fossil_ajs.forProperty(this);
        }
        this._valueTypeDeserializer = com_fossil_ajs;
        this._valueDeserializer = MISSING_VALUE_DESERIALIZER;
    }

    protected SettableBeanProperty(PropertyName propertyName, JavaType javaType, PropertyMetadata propertyMetadata, agy<Object> com_fossil_agy_java_lang_Object) {
        this._propertyIndex = -1;
        if (propertyName == null) {
            this._propName = PropertyName.NO_NAME;
        } else {
            this._propName = propertyName.internSimpleName();
        }
        this._type = javaType;
        this._wrapperName = null;
        this._metadata = propertyMetadata;
        this._contextAnnotations = null;
        this._viewMatcher = null;
        this._valueTypeDeserializer = null;
        this._valueDeserializer = com_fossil_agy_java_lang_Object;
    }

    protected SettableBeanProperty(SettableBeanProperty settableBeanProperty) {
        this._propertyIndex = -1;
        this._propName = settableBeanProperty._propName;
        this._type = settableBeanProperty._type;
        this._wrapperName = settableBeanProperty._wrapperName;
        this._metadata = settableBeanProperty._metadata;
        this._contextAnnotations = settableBeanProperty._contextAnnotations;
        this._valueDeserializer = settableBeanProperty._valueDeserializer;
        this._valueTypeDeserializer = settableBeanProperty._valueTypeDeserializer;
        this._managedReferenceName = settableBeanProperty._managedReferenceName;
        this._propertyIndex = settableBeanProperty._propertyIndex;
        this._viewMatcher = settableBeanProperty._viewMatcher;
    }

    protected SettableBeanProperty(SettableBeanProperty settableBeanProperty, agy<?> com_fossil_agy_) {
        this._propertyIndex = -1;
        this._propName = settableBeanProperty._propName;
        this._type = settableBeanProperty._type;
        this._wrapperName = settableBeanProperty._wrapperName;
        this._metadata = settableBeanProperty._metadata;
        this._contextAnnotations = settableBeanProperty._contextAnnotations;
        this._valueTypeDeserializer = settableBeanProperty._valueTypeDeserializer;
        this._managedReferenceName = settableBeanProperty._managedReferenceName;
        this._propertyIndex = settableBeanProperty._propertyIndex;
        if (com_fossil_agy_ == null) {
            this._valueDeserializer = MISSING_VALUE_DESERIALIZER;
        } else {
            this._valueDeserializer = com_fossil_agy_;
        }
        this._viewMatcher = settableBeanProperty._viewMatcher;
    }

    @Deprecated
    protected SettableBeanProperty(SettableBeanProperty settableBeanProperty, String str) {
        this(settableBeanProperty, new PropertyName(str));
    }

    protected SettableBeanProperty(SettableBeanProperty settableBeanProperty, PropertyName propertyName) {
        this._propertyIndex = -1;
        this._propName = propertyName;
        this._type = settableBeanProperty._type;
        this._wrapperName = settableBeanProperty._wrapperName;
        this._metadata = settableBeanProperty._metadata;
        this._contextAnnotations = settableBeanProperty._contextAnnotations;
        this._valueDeserializer = settableBeanProperty._valueDeserializer;
        this._valueTypeDeserializer = settableBeanProperty._valueTypeDeserializer;
        this._managedReferenceName = settableBeanProperty._managedReferenceName;
        this._propertyIndex = settableBeanProperty._propertyIndex;
        this._viewMatcher = settableBeanProperty._viewMatcher;
    }

    public SettableBeanProperty withSimpleName(String str) {
        PropertyName propertyName = this._propName == null ? new PropertyName(str) : this._propName.withSimpleName(str);
        return propertyName == this._propName ? this : withName(propertyName);
    }

    @Deprecated
    public SettableBeanProperty withName(String str) {
        return withName(new PropertyName(str));
    }

    public void setManagedReferenceName(String str) {
        this._managedReferenceName = str;
    }

    public void setObjectIdInfo(aiy com_fossil_aiy) {
        this._objectIdInfo = com_fossil_aiy;
    }

    public void setViews(Class<?>[] clsArr) {
        if (clsArr == null) {
            this._viewMatcher = null;
        } else {
            this._viewMatcher = ViewMatcher.construct(clsArr);
        }
    }

    public void assignIndex(int i) {
        if (this._propertyIndex != -1) {
            throw new IllegalStateException("Property '" + getName() + "' already had index (" + this._propertyIndex + "), trying to assign " + i);
        }
        this._propertyIndex = i;
    }

    public final String getName() {
        return this._propName.getSimpleName();
    }

    public PropertyName getFullName() {
        return this._propName;
    }

    public boolean isRequired() {
        return this._metadata.isRequired();
    }

    public PropertyMetadata getMetadata() {
        return this._metadata;
    }

    public JavaType getType() {
        return this._type;
    }

    public PropertyName getWrapperName() {
        return this._wrapperName;
    }

    public <A extends Annotation> A getContextAnnotation(Class<A> cls) {
        return this._contextAnnotations.mo959j(cls);
    }

    public C1501b findFormatOverrides(AnnotationIntrospector annotationIntrospector) {
        if (annotationIntrospector != null) {
            aiq member = getMember();
            if (member != null) {
                return annotationIntrospector.findFormat(member);
            }
        }
        return null;
    }

    public void depositSchemaProperty(ajl com_fossil_ajl) throws JsonMappingException {
        if (isRequired()) {
            com_fossil_ajl.m3560a(this);
        } else {
            com_fossil_ajl.m3561b(this);
        }
    }

    protected final Class<?> getDeclaringClass() {
        return getMember().getDeclaringClass();
    }

    public String getManagedReferenceName() {
        return this._managedReferenceName;
    }

    public aiy getObjectIdInfo() {
        return this._objectIdInfo;
    }

    public boolean hasValueDeserializer() {
        return (this._valueDeserializer == null || this._valueDeserializer == MISSING_VALUE_DESERIALIZER) ? false : true;
    }

    public boolean hasValueTypeDeserializer() {
        return this._valueTypeDeserializer != null;
    }

    public agy<Object> getValueDeserializer() {
        agy<Object> com_fossil_agy_java_lang_Object = this._valueDeserializer;
        if (com_fossil_agy_java_lang_Object == MISSING_VALUE_DESERIALIZER) {
            return null;
        }
        return com_fossil_agy_java_lang_Object;
    }

    public ajs getValueTypeDeserializer() {
        return this._valueTypeDeserializer;
    }

    public boolean visibleInView(Class<?> cls) {
        return this._viewMatcher == null || this._viewMatcher.isVisibleForView(cls);
    }

    public boolean hasViews() {
        return this._viewMatcher != null;
    }

    public int getPropertyIndex() {
        return this._propertyIndex;
    }

    public int getCreatorIndex() {
        return -1;
    }

    public Object getInjectableValueId() {
        return null;
    }

    public final Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (jsonParser.zU() == JsonToken.VALUE_NULL) {
            return this._valueDeserializer.getNullValue(deserializationContext);
        }
        if (this._valueTypeDeserializer != null) {
            return this._valueDeserializer.deserializeWithType(jsonParser, deserializationContext, this._valueTypeDeserializer);
        }
        return this._valueDeserializer.deserialize(jsonParser, deserializationContext);
    }

    protected void _throwAsIOE(Exception exception, Object obj) throws IOException {
        if (exception instanceof IllegalArgumentException) {
            String name = obj == null ? "[NULL]" : obj.getClass().getName();
            StringBuilder append = new StringBuilder("Problem deserializing property '").append(getName());
            append.append("' (expected type: ").append(getType());
            append.append("; actual type: ").append(name).append(")");
            name = exception.getMessage();
            if (name != null) {
                append.append(", problem: ").append(name);
            } else {
                append.append(" (no error message provided)");
            }
            throw new JsonMappingException(append.toString(), null, exception);
        }
        _throwAsIOE(exception);
    }

    protected IOException _throwAsIOE(Exception exception) throws IOException {
        if (exception instanceof IOException) {
            throw ((IOException) exception);
        } else if (exception instanceof RuntimeException) {
            throw ((RuntimeException) exception);
        } else {
            while (exception.getCause() != null) {
                exception = exception.getCause();
            }
            throw new JsonMappingException(exception.getMessage(), null, exception);
        }
    }

    public String toString() {
        return "[property '" + getName() + "']";
    }
}
