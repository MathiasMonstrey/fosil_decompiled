package com.fossil;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Typing;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.ser.BasicSerializerFactory;

public class ali {
    protected final AnnotationIntrospector _annotationIntrospector = this._config.getAnnotationIntrospector();
    protected final SerializationConfig _config;
    protected final agu aQQ;
    protected final Include aUv;
    protected Object aUw;

    public ali(SerializationConfig serializationConfig, agu com_fossil_agu) {
        this._config = serializationConfig;
        this.aQQ = com_fossil_agu;
        this.aUv = com_fossil_agu.mo984c(serializationConfig.getSerializationInclusion());
    }

    public amc Dq() {
        return this.aQQ.Dq();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fossil.ald m3724a(com.fossil.ahg r13, com.fossil.aiv r14, com.fasterxml.jackson.databind.JavaType r15, com.fossil.ahb<?> r16, com.fossil.ajv r17, com.fossil.ajv r18, com.fasterxml.jackson.databind.introspect.AnnotatedMember r19, boolean r20) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
        r12 = this;
        r0 = r19;
        r1 = r20;
        r2 = r12.m3723a(r0, r1, r15);
        if (r18 == 0) goto L_0x00f4;
    L_0x000a:
        if (r2 != 0) goto L_0x000d;
    L_0x000c:
        r2 = r15;
    L_0x000d:
        r3 = r2.getContentType();
        if (r3 != 0) goto L_0x0050;
    L_0x0013:
        r3 = new java.lang.IllegalStateException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "Problem trying to create BeanPropertyWriter for property '";
        r4 = r4.append(r5);
        r5 = r14.getName();
        r4 = r4.append(r5);
        r5 = "' (of type ";
        r4 = r4.append(r5);
        r5 = r12.aQQ;
        r5 = r5.getType();
        r4 = r4.append(r5);
        r5 = "); serialization type ";
        r4 = r4.append(r5);
        r2 = r4.append(r2);
        r4 = " has no content";
        r2 = r2.append(r4);
        r2 = r2.toString();
        r3.<init>(r2);
        throw r3;
    L_0x0050:
        r0 = r18;
        r9 = r2.withContentTypeHandler(r0);
        r9.getContentType();
    L_0x0059:
        r11 = 0;
        r3 = 0;
        r2 = r14.Fx();
        if (r2 == 0) goto L_0x0065;
    L_0x0061:
        r4 = com.fasterxml.jackson.annotation.JsonInclude.Include.USE_DEFAULTS;
        if (r2 != r4) goto L_0x006b;
    L_0x0065:
        r2 = r12.aUv;
        if (r2 != 0) goto L_0x006b;
    L_0x0069:
        r2 = com.fasterxml.jackson.annotation.JsonInclude.Include.ALWAYS;
    L_0x006b:
        r4 = com.fossil.ali.C16711.aUg;
        r2 = r2.ordinal();
        r2 = r4[r2];
        switch(r2) {
            case 1: goto L_0x00bf;
            case 2: goto L_0x00de;
            case 3: goto L_0x00e9;
            case 4: goto L_0x00ee;
            default: goto L_0x0076;
        };
    L_0x0076:
        r2 = r3;
    L_0x0077:
        r3 = r15.isContainerType();
        if (r3 == 0) goto L_0x00f0;
    L_0x007d:
        r3 = r12._config;
        r4 = com.fasterxml.jackson.databind.SerializationFeature.WRITE_EMPTY_JSON_ARRAYS;
        r3 = r3.isEnabled(r4);
        if (r3 != 0) goto L_0x00f0;
    L_0x0087:
        r11 = com.fossil.ald.aUh;
        r10 = r2;
    L_0x008a:
        r2 = new com.fossil.ald;
        r3 = r12.aQQ;
        r5 = r3.Dq();
        r3 = r14;
        r4 = r19;
        r6 = r15;
        r7 = r16;
        r8 = r17;
        r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11);
        r3 = r12._annotationIntrospector;
        r0 = r19;
        r3 = r3.findNullSerializer(r0);
        if (r3 == 0) goto L_0x00b0;
    L_0x00a7:
        r0 = r19;
        r3 = r13.serializerInstance(r0, r3);
        r2.mo1083b(r3);
    L_0x00b0:
        r3 = r12._annotationIntrospector;
        r0 = r19;
        r3 = r3.findUnwrappingNameTransformer(r0);
        if (r3 == 0) goto L_0x00be;
    L_0x00ba:
        r2 = r2.m3698c(r3);
    L_0x00be:
        return r2;
    L_0x00bf:
        r2 = r14.getName();
        r0 = r19;
        r11 = r12.m3726a(r2, r0);
        if (r11 != 0) goto L_0x00ce;
    L_0x00cb:
        r2 = 1;
        r10 = r2;
        goto L_0x008a;
    L_0x00ce:
        r2 = r11.getClass();
        r2 = r2.isArray();
        if (r2 == 0) goto L_0x00f2;
    L_0x00d8:
        r11 = com.fossil.amd.bE(r11);
        r10 = r3;
        goto L_0x008a;
    L_0x00de:
        r2 = 1;
        r3 = r15.isReferenceType();
        if (r3 == 0) goto L_0x00f0;
    L_0x00e5:
        r11 = com.fossil.ald.aUh;
        r10 = r2;
        goto L_0x008a;
    L_0x00e9:
        r2 = 1;
        r11 = com.fossil.ald.aUh;
        r10 = r2;
        goto L_0x008a;
    L_0x00ee:
        r2 = 1;
        goto L_0x0077;
    L_0x00f0:
        r10 = r2;
        goto L_0x008a;
    L_0x00f2:
        r10 = r3;
        goto L_0x008a;
    L_0x00f4:
        r9 = r2;
        goto L_0x0059;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.ali.a(com.fossil.ahg, com.fossil.aiv, com.fasterxml.jackson.databind.JavaType, com.fossil.ahb, com.fossil.ajv, com.fossil.ajv, com.fasterxml.jackson.databind.introspect.AnnotatedMember, boolean):com.fossil.ald");
    }

    protected JavaType m3723a(aiq com_fossil_aiq, boolean z, JavaType javaType) {
        JavaType widenBy;
        boolean z2 = true;
        Class findSerializationType = this._annotationIntrospector.findSerializationType(com_fossil_aiq);
        if (findSerializationType != null) {
            Class rawClass = javaType.getRawClass();
            if (findSerializationType.isAssignableFrom(rawClass)) {
                widenBy = javaType.widenBy(findSerializationType);
            } else if (rawClass.isAssignableFrom(findSerializationType)) {
                widenBy = this._config.constructSpecializedType(javaType, findSerializationType);
            } else {
                throw new IllegalArgumentException("Illegal concrete-type annotation for method '" + com_fossil_aiq.getName() + "': class " + findSerializationType.getName() + " not a super-type of (declared) class " + rawClass.getName());
            }
            z = true;
        } else {
            widenBy = javaType;
        }
        JavaType modifySecondaryTypesByAnnotation = BasicSerializerFactory.modifySecondaryTypesByAnnotation(this._config, com_fossil_aiq, widenBy);
        if (modifySecondaryTypesByAnnotation != widenBy) {
            widenBy = modifySecondaryTypesByAnnotation;
            z = true;
        }
        Typing findSerializationTyping = this._annotationIntrospector.findSerializationTyping(com_fossil_aiq);
        if (!(findSerializationTyping == null || findSerializationTyping == Typing.DEFAULT_TYPING)) {
            if (findSerializationTyping != Typing.STATIC) {
                z2 = false;
            }
            z = z2;
        }
        if (z) {
            return widenBy;
        }
        return null;
    }

    protected Object GJ() {
        if (this.aUw == null) {
            this.aUw = this.aQQ.aI(this._config.canOverrideAccessModifiers());
            if (this.aUw == null) {
                throw new IllegalArgumentException("Class " + this.aQQ.Dn().EQ().getName() + " has no default constructor; can not instantiate default bean value to support 'properties=JsonSerialize.Inclusion.NON_DEFAULT' annotation");
            }
        }
        return this.aUw;
    }

    protected Object m3726a(String str, AnnotatedMember annotatedMember) {
        Object GJ = GJ();
        try {
            return annotatedMember.getValue(GJ);
        } catch (Exception e) {
            return m3725a(e, str, GJ);
        }
    }

    protected Object m3725a(Exception exception, String str, Object obj) {
        Throwable th = exception;
        while (th.getCause() != null) {
            th = th.getCause();
        }
        if (th instanceof Error) {
            throw ((Error) th);
        } else if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else {
            throw new IllegalArgumentException("Failed to get property '" + str + "' of default " + obj.getClass().getName() + " instance");
        }
    }
}
