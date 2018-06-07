package com.fossil;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public final class atb {
    private static atb bfA;
    private static final Lock bfz = new ReentrantLock();
    private final Lock bfB = new ReentrantLock();
    private final SharedPreferences bfC;

    private atb(Context context) {
        this.bfC = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    private final void m4425L(String str, String str2) {
        this.bfB.lock();
        try {
            this.bfC.edit().putString(str, str2).apply();
        } finally {
            this.bfB.unlock();
        }
    }

    private static String m4426M(String str, String str2) {
        String valueOf = String.valueOf(":");
        return new StringBuilder((String.valueOf(str).length() + String.valueOf(valueOf).length()) + String.valueOf(str2).length()).append(str).append(valueOf).append(str2).toString();
    }

    public static atb ai(Context context) {
        awa.bO(context);
        bfz.lock();
        try {
            if (bfA == null) {
                bfA = new atb(context.getApplicationContext());
            }
            atb com_fossil_atb = bfA;
            return com_fossil_atb;
        } finally {
            bfz.unlock();
        }
    }

    private final GoogleSignInAccount cW(String str) {
        GoogleSignInAccount googleSignInAccount = null;
        if (!TextUtils.isEmpty(str)) {
            String cY = cY(m4426M("googleSignInAccount", str));
            if (cY != null) {
                try {
                    googleSignInAccount = GoogleSignInAccount.cR(cY);
                } catch (JSONException e) {
                }
            }
        }
        return googleSignInAccount;
    }

    private final GoogleSignInOptions cX(String str) {
        GoogleSignInOptions googleSignInOptions = null;
        if (!TextUtils.isEmpty(str)) {
            String cY = cY(m4426M("googleSignInOptions", str));
            if (cY != null) {
                try {
                    googleSignInOptions = GoogleSignInOptions.cS(cY);
                } catch (JSONException e) {
                }
            }
        }
        return googleSignInOptions;
    }

    private final String cY(String str) {
        this.bfB.lock();
        try {
            String string = this.bfC.getString(str, null);
            return string;
        } finally {
            this.bfB.unlock();
        }
    }

    private final void cZ(String str) {
        this.bfB.lock();
        try {
            this.bfC.edit().remove(str).apply();
        } finally {
            this.bfB.unlock();
        }
    }

    public final GoogleSignInAccount Ko() {
        return cW(cY("defaultGoogleSignInAccount"));
    }

    public final GoogleSignInOptions Kp() {
        return cX(cY("defaultGoogleSignInAccount"));
    }

    public final void Kq() {
        String cY = cY("defaultGoogleSignInAccount");
        cZ("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(cY)) {
            cZ(m4426M("googleSignInAccount", cY));
            cZ(m4426M("googleSignInOptions", cY));
        }
    }

    public final void m4427a(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        awa.bO(googleSignInAccount);
        awa.bO(googleSignInOptions);
        m4425L("defaultGoogleSignInAccount", googleSignInAccount.JQ());
        awa.bO(googleSignInAccount);
        awa.bO(googleSignInOptions);
        String JQ = googleSignInAccount.JQ();
        m4425L(m4426M("googleSignInAccount", JQ), googleSignInAccount.JR());
        m4425L(m4426M("googleSignInOptions", JQ), googleSignInOptions.JU());
    }
}
