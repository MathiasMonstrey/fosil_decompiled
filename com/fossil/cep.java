package com.fossil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.IOException;
import java.security.KeyPair;
import java.util.Map;

public final class cep {
    private static cex bPY;
    private static cer bPZ;
    private static Map<String, cep> bpM = new jl();
    public static String bpS;
    private KeyPair bpP;
    private String bpQ = "";
    private Context mContext;

    private cep(Context context, String str, Bundle bundle) {
        this.mContext = context.getApplicationContext();
        this.bpQ = str;
    }

    public static cex We() {
        return bPY;
    }

    public static cer Wf() {
        return bPZ;
    }

    public static synchronized cep m6102b(Context context, Bundle bundle) {
        cep com_fossil_cep;
        synchronized (cep.class) {
            String string = bundle == null ? "" : bundle.getString("subtype");
            String str = string == null ? "" : string;
            Context applicationContext = context.getApplicationContext();
            if (bPY == null) {
                bPY = new cex(applicationContext);
                bPZ = new cer(applicationContext);
            }
            bpS = Integer.toString(FirebaseInstanceId.bb(applicationContext));
            com_fossil_cep = (cep) bpM.get(str);
            if (com_fossil_cep == null) {
                com_fossil_cep = new cep(applicationContext, str, bundle);
                bpM.put(str, com_fossil_cep);
            }
        }
        return com_fossil_cep;
    }

    public final void MB() {
        bPY.fj(this.bpQ);
        this.bpP = null;
    }

    public final KeyPair Wd() {
        if (this.bpP == null) {
            this.bpP = bPY.fk(this.bpQ);
        }
        if (this.bpP == null) {
            this.bpP = bPY.fi(this.bpQ);
        }
        return this.bpP;
    }

    public final void m6103b(String str, String str2, Bundle bundle) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        bPY.m6127k(this.bpQ, str, str2);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("delete", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        m6105d(str, str2, bundle);
    }

    public final String m6104c(String str, String str2, Bundle bundle) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        Object obj = 1;
        if (bundle.getString("ttl") != null || "jwt".equals(bundle.getString("type"))) {
            obj = null;
        } else {
            cey j = bPY.m6126j(this.bpQ, str, str2);
            if (!(j == null || j.fm(bpS))) {
                return j.bQu;
            }
        }
        String d = m6105d(str, str2, bundle);
        if (d == null || r0 == null) {
            return d;
        }
        bPY.m6125b(this.bpQ, str, str2, d, bpS);
        return d;
    }

    public final String m6105d(String str, String str2, Bundle bundle) throws IOException {
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("sender", str);
        if (!"".equals(this.bpQ)) {
            str = this.bpQ;
        }
        bundle.putString("subtype", str);
        bundle.putString("X-subtype", str);
        Intent a = bPZ.m6113a(bundle, Wd());
        if (a == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String stringExtra = a.getStringExtra("registration_id");
        if (stringExtra == null) {
            stringExtra = a.getStringExtra("unregistered");
        }
        if (stringExtra != null) {
            return stringExtra;
        }
        stringExtra = a.getStringExtra("error");
        if (stringExtra != null) {
            throw new IOException(stringExtra);
        }
        String valueOf = String.valueOf(a.getExtras());
        Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 29).append("Unexpected response from GCM ").append(valueOf).toString(), new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }
}
