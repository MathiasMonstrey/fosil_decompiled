package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.util.Base64;
import android.util.Log;
import com.fossil.cef;
import com.fossil.cep;
import com.fossil.ceq;
import com.fossil.cew;
import com.fossil.cex;
import com.fossil.cey;
import com.fossil.jl;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class FirebaseInstanceId {
    private static ceq bPx;
    private static Map<String, FirebaseInstanceId> bpM = new jl();
    private final String bPA;
    private final cef bPy;
    private final cep bPz;

    private FirebaseInstanceId(cef com_fossil_cef, cep com_fossil_cep) {
        this.bPy = com_fossil_cef;
        this.bPz = com_fossil_cep;
        String VV = this.bPy.VP().VV();
        if (VV == null) {
            VV = this.bPy.VP().getApplicationId();
            if (VV.startsWith("1:")) {
                String[] split = VV.split(":");
                if (split.length < 2) {
                    VV = null;
                } else {
                    VV = split[1];
                    if (VV.isEmpty()) {
                        VV = null;
                    }
                }
            }
        }
        this.bPA = VV;
        if (this.bPA == null) {
            throw new IllegalStateException("IID failing to initialize, FirebaseApp is missing project ID");
        }
        FirebaseInstanceIdService.a(this.bPy.getApplicationContext(), this);
    }

    private final void m12666B(Bundle bundle) {
        bundle.putString("gmp_app_id", this.bPy.VP().getApplicationId());
    }

    public static FirebaseInstanceId VW() {
        return getInstance(cef.VQ());
    }

    static ceq Wa() {
        return bPx;
    }

    public static String m12667a(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) ((digest[0] & 15) + 112);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException e) {
            Log.w("FirebaseInstanceId", "Unexpected error, device missing required alghorithms");
            return null;
        }
    }

    public static void m12668a(Context context, cex com_fossil_cex) {
        com_fossil_cex.ME();
        Intent intent = new Intent();
        intent.putExtra("CMD", "RST");
        cew.Wk().m6123d(context, intent);
    }

    public static String am(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    public static int bb(Context context) {
        return m12669w(context, context.getPackageName());
    }

    public static String bc(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 38).append("Never happens: can't find own package ").append(valueOf).toString());
            return null;
        }
    }

    public static void bd(Context context) {
        Intent intent = new Intent();
        intent.putExtra("CMD", "SYNC");
        cew.Wk().m6123d(context, intent);
    }

    @Keep
    public static synchronized FirebaseInstanceId getInstance(cef com_fossil_cef) {
        FirebaseInstanceId firebaseInstanceId;
        synchronized (FirebaseInstanceId.class) {
            firebaseInstanceId = (FirebaseInstanceId) bpM.get(com_fossil_cef.VP().getApplicationId());
            if (firebaseInstanceId == null) {
                cep b = cep.m6102b(com_fossil_cef.getApplicationContext(), null);
                if (bPx == null) {
                    bPx = new ceq(cep.We());
                }
                firebaseInstanceId = new FirebaseInstanceId(com_fossil_cef, b);
                bpM.put(com_fossil_cef.VP().getApplicationId(), firebaseInstanceId);
            }
        }
        return firebaseInstanceId;
    }

    public static int m12669w(Context context, String str) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 23).append("Failed to find package ").append(valueOf).toString());
            return i;
        }
    }

    public void VX() throws IOException {
        this.bPz.m6103b("*", "*", null);
        this.bPz.MB();
    }

    final cey VY() {
        return cep.We().m6126j("", this.bPA, "*");
    }

    final String VZ() throws IOException {
        return ag(this.bPA, "*");
    }

    public String ag(String str, String str2) throws IOException {
        Bundle bundle = new Bundle();
        m12666B(bundle);
        return this.bPz.m6104c(str, str2, bundle);
    }

    final void fe(String str) throws IOException {
        cey VY = VY();
        if (VY == null || VY.fm(cep.bpS)) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String str2 = "gcm.topic";
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str);
        bundle.putString(str2, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        String str3 = VY.bQu;
        str2 = String.valueOf("/topics/");
        valueOf2 = String.valueOf(str);
        valueOf2 = valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2);
        m12666B(bundle);
        this.bPz.m6105d(str3, valueOf2, bundle);
    }

    final void ff(String str) throws IOException {
        cey VY = VY();
        if (VY == null || VY.fm(cep.bpS)) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String str2 = "gcm.topic";
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str);
        bundle.putString(str2, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        cep com_fossil_cep = this.bPz;
        String str3 = VY.bQu;
        valueOf = String.valueOf("/topics/");
        valueOf2 = String.valueOf(str);
        com_fossil_cep.m6103b(str3, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), bundle);
    }

    public String getId() {
        return m12667a(this.bPz.Wd());
    }

    public String getToken() {
        cey VY = VY();
        if (VY == null || VY.fm(cep.bpS)) {
            FirebaseInstanceIdService.bf(this.bPy.getApplicationContext());
        }
        return VY != null ? VY.bQu : null;
    }
}
