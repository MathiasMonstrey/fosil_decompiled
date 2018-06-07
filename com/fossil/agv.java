package com.fossil;

import com.fasterxml.jackson.annotation.JsonFormat.C1501b;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;

public interface agv {

    public static class C1635a implements agv {
        protected final amc _contextAnnotations;
        protected final PropertyMetadata _metadata;
        protected final JavaType _type;
        protected final PropertyName _wrapperName;
        protected final PropertyName aQf;
        protected final AnnotatedMember aQg;

        public C1635a(PropertyName propertyName, JavaType javaType, PropertyName propertyName2, amc com_fossil_amc, AnnotatedMember annotatedMember, PropertyMetadata propertyMetadata) {
            this.aQf = propertyName;
            this._type = javaType;
            this._wrapperName = propertyName2;
            this._metadata = propertyMetadata;
            this.aQg = annotatedMember;
            this._contextAnnotations = com_fossil_amc;
        }

        public C1635a(C1635a c1635a, JavaType javaType) {
            this(c1635a.aQf, javaType, c1635a._wrapperName, c1635a._contextAnnotations, c1635a.aQg, c1635a._metadata);
        }

        public C1635a m3334a(JavaType javaType) {
            return new C1635a(this, javaType);
        }

        public C1501b findFormatOverrides(AnnotationIntrospector annotationIntrospector) {
            return null;
        }

        public JavaType getType() {
            return this._type;
        }

        public PropertyName getWrapperName() {
            return this._wrapperName;
        }

        public AnnotatedMember getMember() {
            return this.aQg;
        }
    }

    C1501b findFormatOverrides(AnnotationIntrospector annotationIntrospector);

    AnnotatedMember getMember();

    JavaType getType();
}
