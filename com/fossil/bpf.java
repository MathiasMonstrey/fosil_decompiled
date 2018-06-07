package com.fossil;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import com.google.android.gms.measurement.AppMeasurement.a;
import com.google.android.gms.measurement.AppMeasurement.d;
import com.google.android.gms.measurement.AppMeasurement.e;
import java.io.IOException;
import java.util.Map;

public final class bpf extends bqi {
    private final Map<String, Map<String, String>> bAG = new jl();
    private final Map<String, Map<String, Boolean>> bAH = new jl();
    private final Map<String, Map<String, Boolean>> bAI = new jl();
    private final Map<String, bss> bAJ = new jl();
    private final Map<String, String> bAK = new jl();

    bpf(bpk com_fossil_bpk) {
        super(com_fossil_bpk);
    }

    private static Map<String, String> m5454a(bss com_fossil_bss) {
        Map<String, String> jlVar = new jl();
        if (!(com_fossil_bss == null || com_fossil_bss.bEj == null)) {
            for (bst com_fossil_bst : com_fossil_bss.bEj) {
                if (com_fossil_bst != null) {
                    jlVar.put(com_fossil_bst.key, com_fossil_bst.value);
                }
            }
        }
        return jlVar;
    }

    private final void m5455a(String str, bss com_fossil_bss) {
        Map jlVar = new jl();
        Map jlVar2 = new jl();
        if (!(com_fossil_bss == null || com_fossil_bss.bEk == null)) {
            for (bsr com_fossil_bsr : com_fossil_bss.bEk) {
                if (com_fossil_bsr != null) {
                    String eY = a.eY(com_fossil_bsr.name);
                    if (eY != null) {
                        com_fossil_bsr.name = eY;
                    }
                    jlVar.put(com_fossil_bsr.name, com_fossil_bsr.bEf);
                    jlVar2.put(com_fossil_bsr.name, com_fossil_bsr.bEg);
                }
            }
        }
        this.bAH.put(str, jlVar);
        this.bAI.put(str, jlVar2);
    }

    private final bss m5456e(String str, byte[] bArr) {
        if (bArr == null) {
            return new bss();
        }
        bch g = bch.m4834g(bArr, 0, bArr.length);
        bss com_fossil_bss = new bss();
        try {
            com_fossil_bss.mo1266a(g);
            super.Pf().Ri().m5437a("Parsed config. version, gmp_app_id", com_fossil_bss.bEh, com_fossil_bss.bxq);
            return com_fossil_bss;
        } catch (IOException e) {
            super.Pf().Re().m5437a("Unable to merge remote config. appId", bol.ei(str), e);
            return new bss();
        }
    }

    private final void ep(String str) {
        RA();
        super.OP();
        awa.df(str);
        if (this.bAJ.get(str) == null) {
            byte[] eb = super.OZ().eb(str);
            if (eb == null) {
                this.bAG.put(str, null);
                this.bAH.put(str, null);
                this.bAI.put(str, null);
                this.bAJ.put(str, null);
                this.bAK.put(str, null);
                return;
            }
            bss e = m5456e(str, eb);
            this.bAG.put(str, m5454a(e));
            m5455a(str, e);
            this.bAJ.put(str, e);
            this.bAK.put(str, null);
        }
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

    protected final void PH() {
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

    final String m5457Z(String str, String str2) {
        super.OP();
        ep(str);
        Map map = (Map) this.bAG.get(str);
        return map != null ? (String) map.get(str2) : null;
    }

    protected final boolean m5458a(String str, byte[] bArr, String str2) {
        RA();
        super.OP();
        awa.df(str);
        bss e = m5456e(str, bArr);
        if (e == null) {
            return false;
        }
        m5455a(str, e);
        this.bAJ.put(str, e);
        this.bAK.put(str, str2);
        this.bAG.put(str, m5454a(e));
        bnj OR = super.OR();
        bsl[] com_fossil_bslArr = e.bEl;
        awa.bO(com_fossil_bslArr);
        for (bsl com_fossil_bsl : com_fossil_bslArr) {
            for (bsm com_fossil_bsm : com_fossil_bsl.bDG) {
                String eY = a.eY(com_fossil_bsm.bDJ);
                if (eY != null) {
                    com_fossil_bsm.bDJ = eY;
                }
                for (bsn com_fossil_bsn : com_fossil_bsm.bDK) {
                    String eY2 = d.eY(com_fossil_bsn.bDR);
                    if (eY2 != null) {
                        com_fossil_bsn.bDR = eY2;
                    }
                }
            }
            for (bsp com_fossil_bsp : com_fossil_bsl.bDF) {
                String eY3 = e.eY(com_fossil_bsp.bDY);
                if (eY3 != null) {
                    com_fossil_bsp.bDY = eY3;
                }
            }
        }
        OR.OZ().m5361a(str, com_fossil_bslArr);
        try {
            e.bEl = null;
            byte[] bArr2 = new byte[e.MW()];
            e.mo1264a(bci.m4843h(bArr2, 0, bArr2.length));
            bArr = bArr2;
        } catch (IOException e2) {
            super.Pf().Re().m5437a("Unable to serialize reduced-size config. Storing full config instead. appId", bol.ei(str), e2);
        }
        bnn OZ = super.OZ();
        awa.df(str);
        OZ.OP();
        OZ.RA();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        try {
            if (((long) OZ.getWritableDatabase().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                OZ.Pf().Rc().m5439d("Failed to update remote config (got 0). appId", bol.ei(str));
            }
        } catch (SQLiteException e3) {
            OZ.Pf().Rc().m5437a("Error storing remote config. appId", bol.ei(str), e3);
        }
        return true;
    }

    final boolean aa(String str, String str2) {
        super.OP();
        ep(str);
        if (super.Pb().eL(str) && bsk.eI(str2)) {
            return true;
        }
        if (super.Pb().eM(str) && bsk.ex(str2)) {
            return true;
        }
        Map map = (Map) this.bAH.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        return bool == null ? false : bool.booleanValue();
    }

    final boolean ab(String str, String str2) {
        super.OP();
        ep(str);
        if ("ecommerce_purchase".equals(str2)) {
            return true;
        }
        Map map = (Map) this.bAI.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        return bool == null ? false : bool.booleanValue();
    }

    protected final bss eq(String str) {
        RA();
        super.OP();
        awa.df(str);
        ep(str);
        return (bss) this.bAJ.get(str);
    }

    protected final String er(String str) {
        super.OP();
        return (String) this.bAK.get(str);
    }

    protected final void es(String str) {
        super.OP();
        this.bAK.put(str, null);
    }

    final void et(String str) {
        super.OP();
        this.bAJ.remove(str);
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }
}
