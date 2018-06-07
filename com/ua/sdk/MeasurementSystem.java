package com.ua.sdk;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cft;
import com.fossil.cfu;
import com.fossil.cfv;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public enum MeasurementSystem {
    METRIC,
    IMPERIAL,
    HYBRID;

    public static class MeasurementSystemAdapter implements cfo<MeasurementSystem>, cfv<MeasurementSystem> {
        public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
            return m16106c(com_fossil_cfp, type, com_fossil_cfn);
        }

        public MeasurementSystem m16106c(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
            return MeasurementSystem.ln(com_fossil_cfp.getAsString());
        }

        public cfp m16104a(MeasurementSystem measurementSystem, Type type, cfu com_fossil_cfu) {
            return new cft(MeasurementSystem.m16107a(measurementSystem));
        }
    }

    private static String m16107a(MeasurementSystem measurementSystem) {
        switch (measurementSystem) {
            case METRIC:
                return "metric";
            case IMPERIAL:
                return "imperial";
            case HYBRID:
                return "hybrid";
            default:
                return null;
        }
    }

    private static MeasurementSystem ln(String str) {
        if ("metric".equals(str)) {
            return METRIC;
        }
        if ("imperial".equals(str)) {
            return IMPERIAL;
        }
        if ("hybrid".equals(str)) {
            return HYBRID;
        }
        return null;
    }
}
