package com.fossil;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement.a;
import com.google.android.gms.measurement.AppMeasurement.d;
import com.google.android.gms.measurement.AppMeasurement.e;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.misfit.frameworks.common.constants.Constants;
import com.portfolio.platform.data.model.microapp.MicroApp;

public final class boj extends bqi {
    private static String[] bzp = new String[a.bJF.length];
    private static String[] bzq = new String[d.bJH.length];
    private static String[] bzr = new String[e.bJJ.length];

    boj(bpk com_fossil_bpk) {
        super(com_fossil_bpk);
    }

    private final boolean Rb() {
        return this.zzboe.Pf().ig(3);
    }

    private static String m5416a(String str, String[] strArr, String[] strArr2, String[] strArr3) {
        boolean z = true;
        int i = 0;
        awa.bO(strArr);
        awa.bO(strArr2);
        awa.bO(strArr3);
        awa.aY(strArr.length == strArr2.length);
        if (strArr.length != strArr3.length) {
            z = false;
        }
        awa.aY(z);
        while (i < strArr.length) {
            if (bsk.ae(str, strArr[i])) {
                synchronized (strArr3) {
                    if (strArr3[i] == null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(strArr2[i]);
                        stringBuilder.append("(");
                        stringBuilder.append(strArr[i]);
                        stringBuilder.append(")");
                        strArr3[i] = stringBuilder.toString();
                    }
                    str = strArr3[i];
                }
                return str;
            }
            i++;
        }
        return str;
    }

    private static void m5417a(StringBuilder stringBuilder, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append("  ");
        }
    }

    private final void m5418a(StringBuilder stringBuilder, int i, bsn com_fossil_bsn) {
        if (com_fossil_bsn != null) {
            m5417a(stringBuilder, i);
            stringBuilder.append("filter {\n");
            m5421a(stringBuilder, i, "complement", com_fossil_bsn.bDQ);
            m5421a(stringBuilder, i, "param_name", eg(com_fossil_bsn.bDR));
            int i2 = i + 1;
            String str = "string_filter";
            bsq com_fossil_bsq = com_fossil_bsn.bDO;
            if (com_fossil_bsq != null) {
                m5417a(stringBuilder, i2);
                stringBuilder.append(str);
                stringBuilder.append(" {\n");
                if (com_fossil_bsq.bEa != null) {
                    Object obj = "UNKNOWN_MATCH_TYPE";
                    switch (com_fossil_bsq.bEa.intValue()) {
                        case 1:
                            obj = "REGEXP";
                            break;
                        case 2:
                            obj = "BEGINS_WITH";
                            break;
                        case 3:
                            obj = "ENDS_WITH";
                            break;
                        case 4:
                            obj = "PARTIAL";
                            break;
                        case 5:
                            obj = "EXACT";
                            break;
                        case 6:
                            obj = "IN_LIST";
                            break;
                    }
                    m5421a(stringBuilder, i2, "match_type", obj);
                }
                m5421a(stringBuilder, i2, "expression", com_fossil_bsq.bEb);
                m5421a(stringBuilder, i2, "case_sensitive", com_fossil_bsq.bEc);
                if (com_fossil_bsq.bEd.length > 0) {
                    m5417a(stringBuilder, i2 + 1);
                    stringBuilder.append("expression_list {\n");
                    for (String str2 : com_fossil_bsq.bEd) {
                        m5417a(stringBuilder, i2 + 2);
                        stringBuilder.append(str2);
                        stringBuilder.append("\n");
                    }
                    stringBuilder.append("}\n");
                }
                m5417a(stringBuilder, i2);
                stringBuilder.append("}\n");
            }
            m5419a(stringBuilder, i + 1, "number_filter", com_fossil_bsn.bDP);
            m5417a(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private final void m5419a(StringBuilder stringBuilder, int i, String str, bso com_fossil_bso) {
        if (com_fossil_bso != null) {
            m5417a(stringBuilder, i);
            stringBuilder.append(str);
            stringBuilder.append(" {\n");
            if (com_fossil_bso.bDS != null) {
                Object obj = "UNKNOWN_COMPARISON_TYPE";
                switch (com_fossil_bso.bDS.intValue()) {
                    case 1:
                        obj = "LESS_THAN";
                        break;
                    case 2:
                        obj = "GREATER_THAN";
                        break;
                    case 3:
                        obj = "EQUAL";
                        break;
                    case 4:
                        obj = "BETWEEN";
                        break;
                }
                m5421a(stringBuilder, i, "comparison_type", obj);
            }
            m5421a(stringBuilder, i, "match_as_float", com_fossil_bso.bDT);
            m5421a(stringBuilder, i, "comparison_value", com_fossil_bso.bDU);
            m5421a(stringBuilder, i, "min_comparison_value", com_fossil_bso.bDV);
            m5421a(stringBuilder, i, "max_comparison_value", com_fossil_bso.bDW);
            m5417a(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void m5420a(StringBuilder stringBuilder, int i, String str, bsz com_fossil_bsz) {
        int i2 = 0;
        if (com_fossil_bsz != null) {
            int i3;
            int i4;
            int i5 = i + 1;
            m5417a(stringBuilder, i5);
            stringBuilder.append(str);
            stringBuilder.append(" {\n");
            if (com_fossil_bsz.bFd != null) {
                m5417a(stringBuilder, i5 + 1);
                stringBuilder.append("results: ");
                long[] jArr = com_fossil_bsz.bFd;
                int length = jArr.length;
                i3 = 0;
                i4 = 0;
                while (i3 < length) {
                    Long valueOf = Long.valueOf(jArr[i3]);
                    int i6 = i4 + 1;
                    if (i4 != 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(valueOf);
                    i3++;
                    i4 = i6;
                }
                stringBuilder.append('\n');
            }
            if (com_fossil_bsz.bFc != null) {
                m5417a(stringBuilder, i5 + 1);
                stringBuilder.append("status: ");
                long[] jArr2 = com_fossil_bsz.bFc;
                int length2 = jArr2.length;
                i3 = 0;
                while (i2 < length2) {
                    Long valueOf2 = Long.valueOf(jArr2[i2]);
                    i4 = i3 + 1;
                    if (i3 != 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(valueOf2);
                    i2++;
                    i3 = i4;
                }
                stringBuilder.append('\n');
            }
            m5417a(stringBuilder, i5);
            stringBuilder.append("}\n");
        }
    }

    private static void m5421a(StringBuilder stringBuilder, int i, String str, Object obj) {
        if (obj != null) {
            m5417a(stringBuilder, i + 1);
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(obj);
            stringBuilder.append('\n');
        }
    }

    private final void m5422a(StringBuilder stringBuilder, int i, bsu[] com_fossil_bsuArr) {
        if (com_fossil_bsuArr != null) {
            for (bsu com_fossil_bsu : com_fossil_bsuArr) {
                if (com_fossil_bsu != null) {
                    m5417a(stringBuilder, 2);
                    stringBuilder.append("audience_membership {\n");
                    m5421a(stringBuilder, 2, "audience_id", com_fossil_bsu.bDE);
                    m5421a(stringBuilder, 2, "new_audience", com_fossil_bsu.bEq);
                    m5420a(stringBuilder, 2, "current_data", com_fossil_bsu.bEo);
                    m5420a(stringBuilder, 2, "previous_data", com_fossil_bsu.bEp);
                    m5417a(stringBuilder, 2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    private final void m5423a(StringBuilder stringBuilder, int i, bsv[] com_fossil_bsvArr) {
        if (com_fossil_bsvArr != null) {
            for (bsv com_fossil_bsv : com_fossil_bsvArr) {
                if (com_fossil_bsv != null) {
                    m5417a(stringBuilder, 2);
                    stringBuilder.append("event {\n");
                    m5421a(stringBuilder, 2, "name", ef(com_fossil_bsv.name));
                    m5421a(stringBuilder, 2, "timestamp_millis", com_fossil_bsv.bEt);
                    m5421a(stringBuilder, 2, "previous_timestamp_millis", com_fossil_bsv.bEu);
                    m5421a(stringBuilder, 2, "count", com_fossil_bsv.count);
                    bsw[] com_fossil_bswArr = com_fossil_bsv.bEs;
                    if (com_fossil_bswArr != null) {
                        for (bsw com_fossil_bsw : com_fossil_bswArr) {
                            if (com_fossil_bsw != null) {
                                m5417a(stringBuilder, 3);
                                stringBuilder.append("param {\n");
                                m5421a(stringBuilder, 3, "name", eg(com_fossil_bsw.name));
                                m5421a(stringBuilder, 3, "string_value", com_fossil_bsw.boy);
                                m5421a(stringBuilder, 3, "int_value", com_fossil_bsw.bEw);
                                m5421a(stringBuilder, 3, "double_value", com_fossil_bsw.bDx);
                                m5417a(stringBuilder, 3);
                                stringBuilder.append("}\n");
                            }
                        }
                    }
                    m5417a(stringBuilder, 2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    private final void m5424a(StringBuilder stringBuilder, int i, bta[] com_fossil_btaArr) {
        if (com_fossil_btaArr != null) {
            for (bta com_fossil_bta : com_fossil_btaArr) {
                if (com_fossil_bta != null) {
                    m5417a(stringBuilder, 2);
                    stringBuilder.append("user_property {\n");
                    m5421a(stringBuilder, 2, "set_timestamp_millis", com_fossil_bta.bFf);
                    m5421a(stringBuilder, 2, "name", eh(com_fossil_bta.name));
                    m5421a(stringBuilder, 2, "string_value", com_fossil_bta.boy);
                    m5421a(stringBuilder, 2, "int_value", com_fossil_bta.bEw);
                    m5421a(stringBuilder, 2, "double_value", com_fossil_bta.bDx);
                    m5417a(stringBuilder, 2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    private final String m5425b(bnw com_fossil_bnw) {
        return com_fossil_bnw == null ? null : !Rb() ? com_fossil_bnw.toString() : m5431y(com_fossil_bnw.QY());
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

    protected final String m5426a(bnu com_fossil_bnu) {
        if (com_fossil_bnu == null) {
            return null;
        }
        if (!Rb()) {
            return com_fossil_bnu.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Event{appId='");
        stringBuilder.append(com_fossil_bnu.mAppId);
        stringBuilder.append("', name='");
        stringBuilder.append(ef(com_fossil_bnu.mName));
        stringBuilder.append("', params=");
        stringBuilder.append(m5425b(com_fossil_bnu.byj));
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    protected final String m5427a(bsm com_fossil_bsm) {
        int i = 0;
        if (com_fossil_bsm == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nevent_filter {\n");
        m5421a(stringBuilder, 0, "filter_id", com_fossil_bsm.bDI);
        m5421a(stringBuilder, 0, "event_name", ef(com_fossil_bsm.bDJ));
        m5419a(stringBuilder, 1, "event_count_filter", com_fossil_bsm.bDM);
        stringBuilder.append("  filters {\n");
        bsn[] com_fossil_bsnArr = com_fossil_bsm.bDK;
        int length = com_fossil_bsnArr.length;
        while (i < length) {
            m5418a(stringBuilder, 2, com_fossil_bsnArr[i]);
            i++;
        }
        m5417a(stringBuilder, 1);
        stringBuilder.append("}\n}\n");
        return stringBuilder.toString();
    }

    protected final String m5428a(bsp com_fossil_bsp) {
        if (com_fossil_bsp == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nproperty_filter {\n");
        m5421a(stringBuilder, 0, "filter_id", com_fossil_bsp.bDI);
        m5421a(stringBuilder, 0, "property_name", eh(com_fossil_bsp.bDY));
        m5418a(stringBuilder, 1, com_fossil_bsp.bDZ);
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }

    protected final String m5429a(bsx com_fossil_bsx) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nbatch {\n");
        if (com_fossil_bsx.bEx != null) {
            for (bsy com_fossil_bsy : com_fossil_bsx.bEx) {
                if (!(com_fossil_bsy == null || com_fossil_bsy == null)) {
                    m5417a(stringBuilder, 1);
                    stringBuilder.append("bundle {\n");
                    m5421a(stringBuilder, 1, "protocol_version", com_fossil_bsy.bEz);
                    m5421a(stringBuilder, 1, MicroApp.COLUMN_PLATFORM, com_fossil_bsy.bEH);
                    m5421a(stringBuilder, 1, "gmp_version", com_fossil_bsy.bEN);
                    m5421a(stringBuilder, 1, "uploading_gmp_version", com_fossil_bsy.bEO);
                    m5421a(stringBuilder, 1, "config_version", com_fossil_bsy.bEZ);
                    m5421a(stringBuilder, 1, "gmp_app_id", com_fossil_bsy.bxq);
                    m5421a(stringBuilder, 1, "app_id", com_fossil_bsy.bEM);
                    m5421a(stringBuilder, 1, Constants.APP_VERSION, com_fossil_bsy.bpS);
                    m5421a(stringBuilder, 1, "app_version_major", com_fossil_bsy.bEW);
                    m5421a(stringBuilder, 1, "firebase_instance_id", com_fossil_bsy.bxy);
                    m5421a(stringBuilder, 1, "dev_cert_hash", com_fossil_bsy.bES);
                    m5421a(stringBuilder, 1, "app_store", com_fossil_bsy.bxr);
                    m5421a(stringBuilder, 1, "upload_timestamp_millis", com_fossil_bsy.bEC);
                    m5421a(stringBuilder, 1, "start_timestamp_millis", com_fossil_bsy.bED);
                    m5421a(stringBuilder, 1, "end_timestamp_millis", com_fossil_bsy.bEE);
                    m5421a(stringBuilder, 1, "previous_bundle_start_timestamp_millis", com_fossil_bsy.bEF);
                    m5421a(stringBuilder, 1, "previous_bundle_end_timestamp_millis", com_fossil_bsy.bEG);
                    m5421a(stringBuilder, 1, "app_instance_id", com_fossil_bsy.bER);
                    m5421a(stringBuilder, 1, "resettable_device_id", com_fossil_bsy.bEP);
                    m5421a(stringBuilder, 1, "limited_ad_tracking", com_fossil_bsy.bEQ);
                    m5421a(stringBuilder, 1, Constants.OS_VERSION, com_fossil_bsy.bEI);
                    m5421a(stringBuilder, 1, Constants.DEVICE_MODEL, com_fossil_bsy.bEJ);
                    m5421a(stringBuilder, 1, "user_default_language", com_fossil_bsy.bEK);
                    m5421a(stringBuilder, 1, "time_zone_offset_minutes", com_fossil_bsy.bEL);
                    m5421a(stringBuilder, 1, "bundle_sequential_index", com_fossil_bsy.bET);
                    m5421a(stringBuilder, 1, "service_upload", com_fossil_bsy.bEU);
                    m5421a(stringBuilder, 1, "health_monitor", com_fossil_bsy.bxu);
                    if (com_fossil_bsy.bFa.longValue() != 0) {
                        m5421a(stringBuilder, 1, "android_id", com_fossil_bsy.bFa);
                    }
                    m5424a(stringBuilder, 1, com_fossil_bsy.bEB);
                    m5422a(stringBuilder, 1, com_fossil_bsy.bEV);
                    m5423a(stringBuilder, 1, com_fossil_bsy.bEA);
                    m5417a(stringBuilder, 1);
                    stringBuilder.append("}\n");
                }
            }
        }
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }

    protected final String m5430b(bnz com_fossil_bnz) {
        if (com_fossil_bnz == null) {
            return null;
        }
        if (!Rb()) {
            return com_fossil_bnz.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("origin=");
        stringBuilder.append(com_fossil_bnz.bxC);
        stringBuilder.append(",name=");
        stringBuilder.append(ef(com_fossil_bnz.name));
        stringBuilder.append(",params=");
        stringBuilder.append(m5425b(com_fossil_bnz.byq));
        return stringBuilder.toString();
    }

    protected final String ef(String str) {
        return str == null ? null : Rb() ? m5416a(str, a.bJG, a.bJF, bzp) : str;
    }

    protected final String eg(String str) {
        return str == null ? null : Rb() ? m5416a(str, d.bJI, d.bJH, bzq) : str;
    }

    protected final String eh(String str) {
        if (str == null) {
            return null;
        }
        if (!Rb()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return m5416a(str, e.bJK, e.bJJ, bzr);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("experiment_id");
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    protected final String m5431y(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!Rb()) {
            return bundle.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : bundle.keySet()) {
            if (stringBuilder.length() != 0) {
                stringBuilder.append(", ");
            } else {
                stringBuilder.append("Bundle[{");
            }
            stringBuilder.append(eg(str));
            stringBuilder.append(SimpleComparison.EQUAL_TO_OPERATION);
            stringBuilder.append(bundle.get(str));
        }
        stringBuilder.append("}]");
        return stringBuilder.toString();
    }
}
