package com.fossil;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import java.lang.reflect.Type;

public abstract class alp extends ald {
    public abstract alp mo1079a(MapperConfig<?> mapperConfig, air com_fossil_air, aiv com_fossil_aiv, JavaType javaType);

    protected abstract Object mo1080f(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws Exception;

    protected alp() {
    }

    protected alp(aiv com_fossil_aiv, amc com_fossil_amc, JavaType javaType, ahb<?> com_fossil_ahb_, ajv com_fossil_ajv, JavaType javaType2, Include include) {
        super(com_fossil_aiv, com_fossil_aiv.Fs(), com_fossil_amc, javaType, com_fossil_ahb_, com_fossil_ajv, javaType2, m3743e(include), m3744f(include));
    }

    protected static boolean m3743e(Include include) {
        return include != Include.ALWAYS;
    }

    protected static Object m3744f(Include include) {
        if (include == Include.NON_EMPTY || include == Include.NON_EMPTY) {
            return aUh;
        }
        return null;
    }

    public Class<?> Gz() {
        return this.aUj.getRawClass();
    }

    public Type GA() {
        return Gz();
    }

    public void mo1072b(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws Exception {
        Object f = mo1080f(obj, jsonGenerator, com_fossil_ahg);
        if (f != null) {
            ahb com_fossil_ahb = this._serializer;
            if (com_fossil_ahb == null) {
                Class cls = f.getClass();
                alt com_fossil_alt = this._dynamicSerializers;
                com_fossil_ahb = com_fossil_alt.mo1085o(cls);
                if (com_fossil_ahb == null) {
                    com_fossil_ahb = _findAndAddDynamic(com_fossil_alt, cls, com_fossil_ahg);
                }
            }
            if (this._suppressableValue != null) {
                if (aUh == this._suppressableValue) {
                    if (com_fossil_ahb.isEmpty(com_fossil_ahg, f)) {
                        return;
                    }
                } else if (this._suppressableValue.equals(f)) {
                    return;
                }
            }
            if (f != obj || !m3694a(obj, jsonGenerator, com_fossil_ahg, com_fossil_ahb)) {
                jsonGenerator.mo850b(this.aUl);
                if (this.aQx == null) {
                    com_fossil_ahb.serialize(f, jsonGenerator, com_fossil_ahg);
                } else {
                    com_fossil_ahb.serializeWithType(f, jsonGenerator, com_fossil_ahg, this.aQx);
                }
            }
        } else if (this.aUp != null) {
            jsonGenerator.mo850b(this.aUl);
            this.aUp.serialize(null, jsonGenerator, com_fossil_ahg);
        }
    }

    public void mo1074d(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws Exception {
        Object f = mo1080f(obj, jsonGenerator, com_fossil_ahg);
        if (f != null) {
            ahb com_fossil_ahb = this._serializer;
            if (com_fossil_ahb == null) {
                Class cls = f.getClass();
                alt com_fossil_alt = this._dynamicSerializers;
                com_fossil_ahb = com_fossil_alt.mo1085o(cls);
                if (com_fossil_ahb == null) {
                    com_fossil_ahb = _findAndAddDynamic(com_fossil_alt, cls, com_fossil_ahg);
                }
            }
            if (this._suppressableValue != null) {
                if (aUh == this._suppressableValue) {
                    if (com_fossil_ahb.isEmpty(com_fossil_ahg, f)) {
                        m3702e(obj, jsonGenerator, com_fossil_ahg);
                        return;
                    }
                } else if (this._suppressableValue.equals(f)) {
                    m3702e(obj, jsonGenerator, com_fossil_ahg);
                    return;
                }
            }
            if (f != obj || !m3694a(obj, jsonGenerator, com_fossil_ahg, com_fossil_ahb)) {
                if (this.aQx == null) {
                    com_fossil_ahb.serialize(f, jsonGenerator, com_fossil_ahg);
                } else {
                    com_fossil_ahb.serializeWithType(f, jsonGenerator, com_fossil_ahg, this.aQx);
                }
            }
        } else if (this.aUp != null) {
            this.aUp.serialize(null, jsonGenerator, com_fossil_ahg);
        } else {
            jsonGenerator.zL();
        }
    }
}
