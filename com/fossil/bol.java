package com.fossil;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.measurement.AppMeasurement;

public final class bol extends bqi {
    private final String bhB = bnm.PI();
    private final long bxc = bnm.Pr();
    private final bon bzA;
    private final bon bzB;
    private final char bzs;
    private final bon bzt;
    private final bon bzu;
    private final bon bzv;
    private final bon bzw;
    private final bon bzx;
    private final bon bzy;
    private final bon bzz;

    bol(bpk com_fossil_bpk) {
        super(com_fossil_bpk);
        if (super.Ph().Qi()) {
            bnm.Qh();
            this.bzs = 'C';
        } else {
            bnm.Qh();
            this.bzs = 'c';
        }
        this.bzt = new bon(this, 6, false, false);
        this.bzu = new bon(this, 6, true, false);
        this.bzv = new bon(this, 6, false, true);
        this.bzw = new bon(this, 5, false, false);
        this.bzx = new bon(this, 5, true, false);
        this.bzy = new bon(this, 5, false, true);
        this.bzz = new bon(this, 4, false, false);
        this.bzA = new bon(this, 3, false, false);
        this.bzB = new bon(this, 2, false, false);
    }

    private static String m5433a(boolean z, String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            Object obj4 = "";
        }
        Object c = m5434c(z, obj);
        Object c2 = m5434c(z, obj2);
        Object c3 = m5434c(z, obj3);
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(obj4)) {
            stringBuilder.append(obj4);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(c)) {
            stringBuilder.append(str2);
            stringBuilder.append(c);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(c2)) {
            stringBuilder.append(str2);
            stringBuilder.append(c2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(c3)) {
            stringBuilder.append(str2);
            stringBuilder.append(c3);
        }
        return stringBuilder.toString();
    }

    private static String m5434c(boolean z, Object obj) {
        if (obj == null) {
            return "";
        }
        Object valueOf = obj instanceof Integer ? Long.valueOf((long) ((Integer) obj).intValue()) : obj;
        if (valueOf instanceof Long) {
            if (!z) {
                return String.valueOf(valueOf);
            }
            if (Math.abs(((Long) valueOf).longValue()) < 100) {
                return String.valueOf(valueOf);
            }
            String str = String.valueOf(valueOf).charAt(0) == '-' ? "-" : "";
            String valueOf2 = String.valueOf(Math.abs(((Long) valueOf).longValue()));
            return new StringBuilder((String.valueOf(str).length() + 43) + String.valueOf(str).length()).append(str).append(Math.round(Math.pow(10.0d, (double) (valueOf2.length() - 1)))).append("...").append(str).append(Math.round(Math.pow(10.0d, (double) valueOf2.length()) - 1.0d)).toString();
        } else if (valueOf instanceof Boolean) {
            return String.valueOf(valueOf);
        } else {
            if (!(valueOf instanceof Throwable)) {
                return valueOf instanceof boo ? ((boo) valueOf).bzG : z ? "-" : String.valueOf(valueOf);
            } else {
                Throwable th = (Throwable) valueOf;
                StringBuilder stringBuilder = new StringBuilder(z ? th.getClass().getName() : th.toString());
                String ej = ej(AppMeasurement.class.getCanonicalName());
                String ej2 = ej(bpk.class.getCanonicalName());
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (!stackTraceElement.isNativeMethod()) {
                        String className = stackTraceElement.getClassName();
                        if (className != null) {
                            className = ej(className);
                            if (className.equals(ej) || className.equals(ej2)) {
                                stringBuilder.append(": ");
                                stringBuilder.append(stackTraceElement);
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                return stringBuilder.toString();
            }
        }
    }

    protected static Object ei(String str) {
        return str == null ? null : new boo(str);
    }

    private static String ej(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf != -1 ? str.substring(0, lastIndexOf) : str;
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

    public final bon Rc() {
        return this.bzt;
    }

    public final bon Rd() {
        return this.bzu;
    }

    public final bon Re() {
        return this.bzw;
    }

    public final bon Rf() {
        return this.bzy;
    }

    public final bon Rg() {
        return this.bzz;
    }

    public final bon Rh() {
        return this.bzA;
    }

    public final bon Ri() {
        return this.bzB;
    }

    public final String Rj() {
        Pair Rt = super.Pg().bzW.Rt();
        if (Rt == null || Rt == bow.bzU) {
            return null;
        }
        String valueOf = String.valueOf(String.valueOf(Rt.second));
        String str = (String) Rt.first;
        return new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(str).length()).append(valueOf).append(":").append(str).toString();
    }

    protected final void m5435a(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && ig(i)) {
            m5436m(i, m5433a(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            awa.bO(str);
            bpg RD = this.zzboe.RD();
            if (RD == null) {
                m5436m(6, "Scheduler not set. Not logging error/warn");
            } else if (RD.isInitialized()) {
                int i2 = i < 0 ? 0 : i;
                if (i2 >= 9) {
                    i2 = 8;
                }
                String valueOf = String.valueOf("2");
                char charAt = "01VDIWEA?".charAt(i2);
                char c = this.bzs;
                long j = this.bxc;
                String valueOf2 = String.valueOf(m5433a(true, str, obj, obj2, obj3));
                String stringBuilder = new StringBuilder((String.valueOf(valueOf).length() + 23) + String.valueOf(valueOf2).length()).append(valueOf).append(charAt).append(c).append(j).append(":").append(valueOf2).toString();
                if (stringBuilder.length() > 1024) {
                    stringBuilder = str.substring(0, 1024);
                }
                RD.m5469h(new bom(this, stringBuilder));
            } else {
                m5436m(6, "Scheduler not initialized. Not logging error/warn");
            }
        }
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    protected final boolean ig(int i) {
        return Log.isLoggable(this.bhB, i);
    }

    protected final void m5436m(int i, String str) {
        Log.println(i, this.bhB, str);
    }
}
