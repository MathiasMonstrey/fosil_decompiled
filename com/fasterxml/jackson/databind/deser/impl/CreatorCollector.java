package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.std.StdValueInstantiator;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.fossil.agu;
import com.fossil.aie;
import com.fossil.ami;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CreatorCollector {
    protected static final String[] aRo = new String[]{"default", "String", "int", "long", "double", "boolean", "delegate", "property-based"};
    protected AnnotatedParameter _incompleteParameter;
    protected final agu aQQ;
    protected final boolean aRp;
    protected final AnnotatedWithParams[] aRq = new AnnotatedWithParams[8];
    protected int aRr = 0;
    protected boolean aRs = false;
    protected SettableBeanProperty[] aRt;
    protected SettableBeanProperty[] aRu;

    public static final class Vanilla extends aie implements Serializable {
        public static final int TYPE_COLLECTION = 1;
        public static final int TYPE_HASH_MAP = 3;
        public static final int TYPE_MAP = 2;
        private static final long serialVersionUID = 1;
        private final int _type;

        public Vanilla(int i) {
            this._type = i;
        }

        public String getValueTypeDesc() {
            switch (this._type) {
                case 1:
                    return ArrayList.class.getName();
                case 2:
                    return LinkedHashMap.class.getName();
                case 3:
                    return HashMap.class.getName();
                default:
                    return Object.class.getName();
            }
        }

        public boolean canInstantiate() {
            return true;
        }

        public boolean canCreateUsingDefault() {
            return true;
        }

        public Object createUsingDefault(DeserializationContext deserializationContext) throws IOException {
            switch (this._type) {
                case 1:
                    return new ArrayList();
                case 2:
                    return new LinkedHashMap();
                case 3:
                    return new HashMap();
                default:
                    throw new IllegalStateException("Unknown type " + this._type);
            }
        }
    }

    public CreatorCollector(agu com_fossil_agu, boolean z) {
        this.aQQ = com_fossil_agu;
        this.aRp = z;
    }

    public aie m2711b(DeserializationConfig deserializationConfig) {
        JavaType javaType;
        int i = !this.aRs ? 1 : 0;
        if (i != 0 || this.aRq[6] == null) {
            javaType = null;
        } else {
            int i2;
            if (this.aRt != null) {
                int length = this.aRt.length;
                i2 = 0;
                while (i2 < length) {
                    if (this.aRt[i2] == null) {
                        break;
                    }
                    i2++;
                }
            }
            i2 = 0;
            javaType = this.aQQ.Dp().m3829a(this.aRq[6].getGenericParameterType(i2));
        }
        JavaType type = this.aQQ.getType();
        if (((!this.aRs ? 1 : 0) & i) != 0) {
            Class rawClass = type.getRawClass();
            if (rawClass == Collection.class || rawClass == List.class || rawClass == ArrayList.class) {
                return new Vanilla(1);
            }
            if (rawClass == Map.class || rawClass == LinkedHashMap.class) {
                return new Vanilla(2);
            }
            if (rawClass == HashMap.class) {
                return new Vanilla(3);
            }
        }
        aie stdValueInstantiator = new StdValueInstantiator(deserializationConfig, type);
        stdValueInstantiator.configureFromObjectSettings(this.aRq[0], this.aRq[6], javaType, this.aRt, this.aRq[7], this.aRu);
        stdValueInstantiator.configureFromStringCreator(this.aRq[1]);
        stdValueInstantiator.configureFromIntCreator(this.aRq[2]);
        stdValueInstantiator.configureFromLongCreator(this.aRq[3]);
        stdValueInstantiator.configureFromDoubleCreator(this.aRq[4]);
        stdValueInstantiator.configureFromBooleanCreator(this.aRq[5]);
        stdValueInstantiator.configureIncompleteParameter(this._incompleteParameter);
        return stdValueInstantiator;
    }

    public void m2707a(AnnotatedWithParams annotatedWithParams) {
        this.aRq[0] = (AnnotatedWithParams) m2706a((AnnotatedMember) annotatedWithParams);
    }

    public void m2709a(AnnotatedWithParams annotatedWithParams, boolean z) {
        m2708a(annotatedWithParams, 1, z);
    }

    public void m2712b(AnnotatedWithParams annotatedWithParams, boolean z) {
        m2708a(annotatedWithParams, 2, z);
    }

    public void m2714c(AnnotatedWithParams annotatedWithParams, boolean z) {
        m2708a(annotatedWithParams, 3, z);
    }

    public void m2715d(AnnotatedWithParams annotatedWithParams, boolean z) {
        m2708a(annotatedWithParams, 4, z);
    }

    public void m2716e(AnnotatedWithParams annotatedWithParams, boolean z) {
        m2708a(annotatedWithParams, 5, z);
    }

    public void m2710a(AnnotatedWithParams annotatedWithParams, boolean z, SettableBeanProperty[] settableBeanPropertyArr) {
        m2708a(annotatedWithParams, 6, z);
        this.aRt = settableBeanPropertyArr;
    }

    public void m2713b(AnnotatedWithParams annotatedWithParams, boolean z, SettableBeanProperty[] settableBeanPropertyArr) {
        m2708a(annotatedWithParams, 7, z);
        if (settableBeanPropertyArr.length > 1) {
            HashMap hashMap = new HashMap();
            int length = settableBeanPropertyArr.length;
            int i = 0;
            while (i < length) {
                String name = settableBeanPropertyArr[i].getName();
                if (name.length() != 0 || settableBeanPropertyArr[i].getInjectableValueId() == null) {
                    Integer num = (Integer) hashMap.put(name, Integer.valueOf(i));
                    if (num != null) {
                        throw new IllegalArgumentException("Duplicate creator property \"" + name + "\" (index " + num + " vs " + i + ")");
                    }
                }
                i++;
            }
        }
        this.aRu = settableBeanPropertyArr;
    }

    public boolean Ez() {
        return this.aRq[0] != null;
    }

    public boolean EA() {
        return this.aRq[6] != null;
    }

    public boolean EB() {
        return this.aRq[7] != null;
    }

    private <T extends AnnotatedMember> T m2706a(T t) {
        if (t != null && this.aRp) {
            ami.m3862a((Member) t.getAnnotated());
        }
        return t;
    }

    protected void m2708a(AnnotatedWithParams annotatedWithParams, int i, boolean z) {
        boolean z2 = true;
        int i2 = 1 << i;
        this.aRs = true;
        AnnotatedWithParams annotatedWithParams2 = this.aRq[i];
        if (annotatedWithParams2 != null) {
            if ((this.aRr & i2) != 0) {
                if (!z) {
                    return;
                }
            } else if (z) {
                z2 = false;
            }
            if (z2 && annotatedWithParams2.getClass() == annotatedWithParams.getClass()) {
                Class rawParameterType = annotatedWithParams2.getRawParameterType(0);
                Class rawParameterType2 = annotatedWithParams.getRawParameterType(0);
                if (rawParameterType == rawParameterType2) {
                    throw new IllegalArgumentException("Conflicting " + aRo[i] + " creators: already had explicitly marked " + annotatedWithParams2 + ", encountered " + annotatedWithParams);
                } else if (rawParameterType2.isAssignableFrom(rawParameterType)) {
                    return;
                }
            }
        }
        if (z) {
            this.aRr |= i2;
        }
        this.aRq[i] = (AnnotatedWithParams) m2706a((AnnotatedMember) annotatedWithParams);
    }
}
