package com.fossil;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement.g;
import java.util.Map;

public final class bnc extends bqh {
    private final Map<String, Long> bwM = new jl();
    private final Map<String, Integer> bwN = new jl();
    private long bwO;

    public bnc(bpk com_fossil_bpk) {
        super(com_fossil_bpk);
    }

    private final void m5309T(long j) {
        for (String put : this.bwM.keySet()) {
            this.bwM.put(put, Long.valueOf(j));
        }
        if (!this.bwM.isEmpty()) {
            this.bwO = j;
        }
    }

    private final void m5310a(long j, g gVar) {
        if (gVar == null) {
            super.Pf().Ri().log("Not logging ad exposure. No active activity");
        } else if (j < 1000) {
            super.Pf().Ri().m5439d("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j);
            bqy.m5546a(gVar, bundle);
            super.OS().m5539a("am", "_xa", bundle);
        }
    }

    private final void m5313a(String str, long j, g gVar) {
        if (gVar == null) {
            super.Pf().Ri().log("Not logging ad unit exposure. No active activity");
        } else if (j < 1000) {
            super.Pf().Ri().m5439d("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j);
            bqy.m5546a(gVar, bundle);
            super.OS().m5539a("am", "_xu", bundle);
        }
    }

    private final void m5315d(String str, long j) {
        super.ON();
        super.OP();
        awa.df(str);
        if (this.bwN.isEmpty()) {
            this.bwO = j;
        }
        Integer num = (Integer) this.bwN.get(str);
        if (num != null) {
            this.bwN.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (this.bwN.size() >= 100) {
            super.Pf().Re().log("Too many ads visible");
        } else {
            this.bwN.put(str, Integer.valueOf(1));
            this.bwM.put(str, Long.valueOf(j));
        }
    }

    private final void m5316e(String str, long j) {
        super.ON();
        super.OP();
        awa.df(str);
        Integer num = (Integer) this.bwN.get(str);
        if (num != null) {
            g RT = super.OW().RT();
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.bwN.remove(str);
                Long l = (Long) this.bwM.get(str);
                if (l == null) {
                    super.Pf().Rc().log("First ad unit exposure time was never set");
                } else {
                    long longValue = j - l.longValue();
                    this.bwM.remove(str);
                    m5313a(str, longValue, RT);
                }
                if (!this.bwN.isEmpty()) {
                    return;
                }
                if (this.bwO == 0) {
                    super.Pf().Rc().log("First ad exposure time was never set");
                    return;
                }
                m5310a(j - this.bwO, RT);
                this.bwO = 0;
                return;
            }
            this.bwN.put(str, Integer.valueOf(intValue));
            return;
        }
        super.Pf().Rc().m5439d("Call to endAdUnitExposure for unknown ad unit id", str);
    }

    public final void OL() {
        super.Pe().m5469h(new bnf(this, super.OX().elapsedRealtime()));
    }

    public final /* bridge */ /* synthetic */ void OM() {
        super.OM();
    }

    public final /* bridge */ /* synthetic */ void ON() {
        super.ON();
    }

    public final /* bridge */ /* synthetic */ void OO() {
        super.OO();
    }

    public final /* bridge */ /* synthetic */ void OP() {
        super.OP();
    }

    public final /* bridge */ /* synthetic */ bnc OQ() {
        return super.OQ();
    }

    public final /* bridge */ /* synthetic */ bnj OR() {
        return super.OR();
    }

    public final /* bridge */ /* synthetic */ bqk OS() {
        return super.OS();
    }

    public final /* bridge */ /* synthetic */ bog OT() {
        return super.OT();
    }

    public final /* bridge */ /* synthetic */ bnt OU() {
        return super.OU();
    }

    public final /* bridge */ /* synthetic */ brc OV() {
        return super.OV();
    }

    public final /* bridge */ /* synthetic */ bqy OW() {
        return super.OW();
    }

    public final /* bridge */ /* synthetic */ axm OX() {
        return super.OX();
    }

    public final /* bridge */ /* synthetic */ boh OY() {
        return super.OY();
    }

    public final /* bridge */ /* synthetic */ bnn OZ() {
        return super.OZ();
    }

    public final /* bridge */ /* synthetic */ boj Pa() {
        return super.Pa();
    }

    public final /* bridge */ /* synthetic */ bsk Pb() {
        return super.Pb();
    }

    public final /* bridge */ /* synthetic */ bpf Pc() {
        return super.Pc();
    }

    public final /* bridge */ /* synthetic */ brz Pd() {
        return super.Pd();
    }

    public final /* bridge */ /* synthetic */ bpg Pe() {
        return super.Pe();
    }

    public final /* bridge */ /* synthetic */ bol Pf() {
        return super.Pf();
    }

    public final /* bridge */ /* synthetic */ bow Pg() {
        return super.Pg();
    }

    public final /* bridge */ /* synthetic */ bnm Ph() {
        return super.Ph();
    }

    public final void m5317S(long j) {
        g RT = super.OW().RT();
        for (String str : this.bwM.keySet()) {
            m5313a(str, j - ((Long) this.bwM.get(str)).longValue(), RT);
        }
        if (!this.bwM.isEmpty()) {
            m5310a(j - this.bwO, RT);
        }
        m5309T(j);
    }

    public final void beginAdUnitExposure(String str) {
        if (str == null || str.length() == 0) {
            super.Pf().Rc().log("Ad unit id must be a non-empty string");
            return;
        }
        super.Pe().m5469h(new bnd(this, str, super.OX().elapsedRealtime()));
    }

    public final void endAdUnitExposure(String str) {
        if (str == null || str.length() == 0) {
            super.Pf().Rc().log("Ad unit id must be a non-empty string");
            return;
        }
        super.Pe().m5469h(new bne(this, str, super.OX().elapsedRealtime()));
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }
}
