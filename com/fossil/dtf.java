package com.fossil;

import android.content.Context;
import android.text.TextUtils;
import com.fossil.dtj.C3188a;
import java.util.HashMap;
import java.util.Map;

public class dtf {
    private static dtf drn;
    private Map<String, dsp> dro = new HashMap();
    private Map<String, C3188a> drp = new HashMap();
    private Context mContext;

    private dtf(Context context) {
        this.mContext = context;
    }

    public static synchronized dtf cL(Context context) {
        dtf com_fossil_dtf;
        synchronized (dtf.class) {
            if (drn == null) {
                drn = new dtf(context);
            }
            com_fossil_dtf = drn;
        }
        return com_fossil_dtf;
    }

    public synchronized dsp jJ(String str) {
        dsp com_fossil_dsp;
        if (TextUtils.isEmpty(str)) {
            com_fossil_dsp = null;
        } else {
            com_fossil_dsp = (dsp) this.dro.get(str);
        }
        return com_fossil_dsp;
    }

    public synchronized void m9692a(String str, dsp com_fossil_dsp) {
        if (!(TextUtils.isEmpty(str) || com_fossil_dsp == null)) {
            this.dro.put(str, com_fossil_dsp);
        }
    }

    public synchronized void jK(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.dro.remove(str);
        }
    }

    public synchronized C3188a jL(String str) {
        C3188a c3188a;
        if (TextUtils.isEmpty(str)) {
            c3188a = null;
        } else {
            c3188a = (C3188a) this.drp.get(str);
        }
        return c3188a;
    }

    public synchronized void m9693a(String str, C3188a c3188a) {
        if (!(TextUtils.isEmpty(str) || c3188a == null)) {
            this.drp.put(str, c3188a);
        }
    }

    public synchronized void jM(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.drp.remove(str);
        }
    }

    public String awX() {
        return String.valueOf(System.currentTimeMillis());
    }
}
