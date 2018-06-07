package com.ua.sdk.sleep;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.ekf;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class SleepMetricAdapter implements cfo<SleepMetric>, cfv<SleepMetric> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16237Q(com_fossil_cfp, type, com_fossil_cfn);
    }

    public ekf m16237Q(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return (ekf) com_fossil_cfn.b(com_fossil_cfp, ekf.class);
    }

    public cfp m16238a(SleepMetric sleepMetric, Type type, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(sleepMetric, sleepMetric.getClass());
    }
}
