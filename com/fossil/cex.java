package com.fossil;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public final class cex {
    private Context bqb;
    SharedPreferences bqd;

    public cex(Context context) {
        this(context, "com.google.android.gms.appid");
    }

    private cex(Context context, String str) {
        this.bqb = context;
        this.bqd = context.getSharedPreferences(str, 0);
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("-no-backup");
        File file = new File(axx.aw(this.bqb), valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !isEmpty()) {
                    Log.i("InstanceID/Store", "App restored, clearing state");
                    FirebaseInstanceId.m12668a(this.bqb, this);
                }
            } catch (IOException e) {
                if (Log.isLoggable("InstanceID/Store", 3)) {
                    valueOf = "InstanceID/Store";
                    String str2 = "Error creating file in no backup dir: ";
                    valueOf2 = String.valueOf(e.getMessage());
                    Log.d(valueOf, valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2));
                }
            }
        }
    }

    private static String ai(String str, String str2) {
        String valueOf = String.valueOf("|S|");
        return new StringBuilder((String.valueOf(str).length() + String.valueOf(valueOf).length()) + String.valueOf(str2).length()).append(str).append(valueOf).append(str2).toString();
    }

    private final void dD(String str) {
        Editor edit = this.bqd.edit();
        for (String str2 : this.bqd.getAll().keySet()) {
            if (str2.startsWith(str)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }

    private static String m6124i(String str, String str2, String str3) {
        String valueOf = String.valueOf("|T|");
        return new StringBuilder((((String.valueOf(str).length() + 1) + String.valueOf(valueOf).length()) + String.valueOf(str2).length()) + String.valueOf(str3).length()).append(str).append(valueOf).append(str2).append("|").append(str3).toString();
    }

    public final synchronized void ME() {
        this.bqd.edit().clear().commit();
    }

    public final synchronized void m6125b(String str, String str2, String str3, String str4, String str5) {
        String a = cey.m6128a(str4, str5, System.currentTimeMillis());
        if (a != null) {
            Editor edit = this.bqd.edit();
            edit.putString(m6124i(str, str2, str3), a);
            edit.commit();
        }
    }

    public final synchronized void dE(String str) {
        dD(String.valueOf(str).concat("|T|"));
    }

    final synchronized KeyPair fi(String str) {
        KeyPair Wb;
        Wb = ceh.Wb();
        long currentTimeMillis = System.currentTimeMillis();
        Editor edit = this.bqd.edit();
        edit.putString(ai(str, "|P|"), FirebaseInstanceId.am(Wb.getPublic().getEncoded()));
        edit.putString(ai(str, "|K|"), FirebaseInstanceId.am(Wb.getPrivate().getEncoded()));
        edit.putString(ai(str, "cre"), Long.toString(currentTimeMillis));
        edit.commit();
        return Wb;
    }

    final synchronized void fj(String str) {
        dD(String.valueOf(str).concat("|"));
    }

    public final synchronized KeyPair fk(String str) {
        KeyPair keyPair;
        Object e;
        String string = this.bqd.getString(ai(str, "|P|"), null);
        String string2 = this.bqd.getString(ai(str, "|K|"), null);
        if (string == null || string2 == null) {
            keyPair = null;
        } else {
            try {
                byte[] decode = Base64.decode(string, 8);
                byte[] decode2 = Base64.decode(string2, 8);
                KeyFactory instance = KeyFactory.getInstance("RSA");
                keyPair = new KeyPair(instance.generatePublic(new X509EncodedKeySpec(decode)), instance.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
            } catch (InvalidKeySpecException e2) {
                e = e2;
                string = String.valueOf(e);
                Log.w("InstanceID/Store", new StringBuilder(String.valueOf(string).length() + 19).append("Invalid key stored ").append(string).toString());
                FirebaseInstanceId.m12668a(this.bqb, this);
                keyPair = null;
                return keyPair;
            } catch (NoSuchAlgorithmException e3) {
                e = e3;
                string = String.valueOf(e);
                Log.w("InstanceID/Store", new StringBuilder(String.valueOf(string).length() + 19).append("Invalid key stored ").append(string).toString());
                FirebaseInstanceId.m12668a(this.bqb, this);
                keyPair = null;
                return keyPair;
            }
        }
        return keyPair;
    }

    public final synchronized boolean isEmpty() {
        return this.bqd.getAll().isEmpty();
    }

    public final synchronized cey m6126j(String str, String str2, String str3) {
        return cey.fl(this.bqd.getString(m6124i(str, str2, str3), null));
    }

    public final synchronized void m6127k(String str, String str2, String str3) {
        String i = m6124i(str, str2, str3);
        Editor edit = this.bqd.edit();
        edit.remove(i);
        edit.commit();
    }
}
