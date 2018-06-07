package com.fossil;

import android.content.Context;
import android.os.Binder;
import com.fossil.ats.C1879a.C1880a;
import com.fossil.atv.C1897a;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public final class asy extends ast {
    private final Context mContext;

    public asy(Context context) {
        this.mContext = context;
    }

    public final void Kn() {
        if (ayo.m4452B(this.mContext, Binder.getCallingUid())) {
            atb ai = atb.ai(this.mContext);
            GoogleSignInAccount Ko = ai.Ko();
            C1880a c1880a = GoogleSignInOptions.beR;
            if (Ko != null) {
                c1880a = ai.Kp();
            }
            atv KI = new C1897a(this.mContext).m4466a(arz.beh, c1880a).KI();
            try {
                if (KI.KE().Kb()) {
                    if (Ko != null) {
                        arz.bem.mo1156c(KI);
                    } else {
                        KI.KF();
                    }
                }
                KI.disconnect();
            } catch (Throwable th) {
                KI.disconnect();
            }
        } else {
            throw new SecurityException("Calling UID " + Binder.getCallingUid() + " is not Google Play services.");
        }
    }
}
