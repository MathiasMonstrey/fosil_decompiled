package com.fossil;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ser.impl.UnwrappingBeanSerializer;
import com.fossil.ajg.C1662a;
import java.util.Iterator;
import java.util.Map.Entry;

public class alw extends ald {
    protected final amo _nameTransformer;

    public /* synthetic */ ald mo1082b(amo com_fossil_amo) {
        return m3797f(com_fossil_amo);
    }

    public alw(ald com_fossil_ald, amo com_fossil_amo) {
        super(com_fossil_ald);
        this._nameTransformer = com_fossil_amo;
    }

    protected alw(alw com_fossil_alw, amo com_fossil_amo, SerializedString serializedString) {
        super((ald) com_fossil_alw, serializedString);
        this._nameTransformer = com_fossil_amo;
    }

    public alw m3797f(amo com_fossil_amo) {
        return m3792a(amo.m3884a(com_fossil_amo, this._nameTransformer), new SerializedString(com_fossil_amo.cc(this.aUl.getValue())));
    }

    protected alw m3792a(amo com_fossil_amo, SerializedString serializedString) {
        return new alw(this, com_fossil_amo, serializedString);
    }

    public void mo1072b(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws Exception {
        Object obj2 = get(obj);
        if (obj2 != null) {
            ahb com_fossil_ahb = this._serializer;
            if (com_fossil_ahb == null) {
                Class cls = obj2.getClass();
                alt com_fossil_alt = this._dynamicSerializers;
                com_fossil_ahb = com_fossil_alt.mo1085o(cls);
                if (com_fossil_ahb == null) {
                    com_fossil_ahb = _findAndAddDynamic(com_fossil_alt, cls, com_fossil_ahg);
                }
            }
            if (this._suppressableValue != null) {
                if (aUh == this._suppressableValue) {
                    if (com_fossil_ahb.isEmpty(com_fossil_ahg, obj2)) {
                        return;
                    }
                } else if (this._suppressableValue.equals(obj2)) {
                    return;
                }
            }
            if (obj2 != obj || !m3694a(obj, jsonGenerator, com_fossil_ahg, com_fossil_ahb)) {
                if (!com_fossil_ahb.isUnwrappingSerializer()) {
                    jsonGenerator.mo850b(this.aUl);
                }
                if (this.aQx == null) {
                    com_fossil_ahb.serialize(obj2, jsonGenerator, com_fossil_ahg);
                } else {
                    com_fossil_ahb.serializeWithType(obj2, jsonGenerator, com_fossil_ahg, this.aQx);
                }
            }
        }
    }

    public void mo1081a(ahb<Object> com_fossil_ahb_java_lang_Object) {
        super.mo1081a((ahb) com_fossil_ahb_java_lang_Object);
        if (this._serializer != null) {
            amo a;
            amo com_fossil_amo = this._nameTransformer;
            if (this._serializer.isUnwrappingSerializer()) {
                a = amo.m3884a(com_fossil_amo, ((UnwrappingBeanSerializer) this._serializer)._nameTransformer);
            } else {
                a = com_fossil_amo;
            }
            this._serializer = this._serializer.unwrappingSerializer(a);
        }
    }

    public void depositSchemaProperty(final ajl com_fossil_ajl) throws JsonMappingException {
        ahg Gd = com_fossil_ajl.Gd();
        ahb unwrappingSerializer = Gd.findValueSerializer(getType(), (agv) this).unwrappingSerializer(this._nameTransformer);
        if (unwrappingSerializer.isUnwrappingSerializer()) {
            unwrappingSerializer.acceptJsonFormatVisitor(new C1662a(this, Gd) {
                final /* synthetic */ alw aUV;

                public ajl mo1016d(JavaType javaType) throws JsonMappingException {
                    return com_fossil_ajl;
                }
            }, getType());
        } else {
            super.depositSchemaProperty(com_fossil_ajl);
        }
    }

    protected void mo1087a(akv com_fossil_akv, agz com_fossil_agz) {
        agz bF = com_fossil_agz.bF("properties");
        if (bF != null) {
            Iterator DR = bF.DR();
            while (DR.hasNext()) {
                Entry entry = (Entry) DR.next();
                String str = (String) entry.getKey();
                if (this._nameTransformer != null) {
                    str = this._nameTransformer.cc(str);
                }
                com_fossil_akv.m3669a(str, (agz) entry.getValue());
            }
        }
    }

    protected ahb<Object> _findAndAddDynamic(alt com_fossil_alt, Class<?> cls, ahg com_fossil_ahg) throws JsonMappingException {
        ahb findValueSerializer;
        amo a;
        if (this.aUn != null) {
            findValueSerializer = com_fossil_ahg.findValueSerializer(com_fossil_ahg.constructSpecializedType(this.aUn, cls), (agv) this);
        } else {
            findValueSerializer = com_fossil_ahg.findValueSerializer((Class) cls, (agv) this);
        }
        amo com_fossil_amo = this._nameTransformer;
        if (findValueSerializer.isUnwrappingSerializer()) {
            a = amo.m3884a(com_fossil_amo, ((UnwrappingBeanSerializer) findValueSerializer)._nameTransformer);
        } else {
            a = com_fossil_amo;
        }
        ahb<Object> unwrappingSerializer = findValueSerializer.unwrappingSerializer(a);
        this._dynamicSerializers = this._dynamicSerializers.mo1084b(cls, unwrappingSerializer);
        return unwrappingSerializer;
    }
}
