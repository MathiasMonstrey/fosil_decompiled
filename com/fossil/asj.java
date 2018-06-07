package com.fossil;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.auth.api.signin.internal.SignInHubActivity;
import com.google.android.gms.common.api.Status;

public final class asj {
    private static bif bft = new bif("GoogleSignInCommon", new String[0]);

    public static Intent m4391a(Context context, GoogleSignInOptions googleSignInOptions) {
        bft.m5195a("GoogleSignInCommon", "getSignInIntent()");
        Parcelable signInConfiguration = new SignInConfiguration(context.getPackageName(), googleSignInOptions);
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setClass(context, SignInHubActivity.class);
        intent.putExtra("config", signInConfiguration);
        return intent;
    }

    public static atw<Status> m4392a(atv com_fossil_atv, Context context) {
        bft.m5195a("GoogleSignInCommon", "Signing out");
        ah(context);
        return com_fossil_atv.mo1335d(new ask(com_fossil_atv));
    }

    private static void ah(Context context) {
        atb.ai(context).Kq();
        for (atv KD : atv.KC()) {
            KD.KD();
        }
        bfs.NR();
    }

    public static atw<Status> m4393b(atv com_fossil_atv, Context context) {
        bft.m5195a("GoogleSignInCommon", "Revoking access");
        ah(context);
        return com_fossil_atv.mo1335d(new asm(com_fossil_atv));
    }

    public static ase m4394h(Intent intent) {
        if (intent == null || (!intent.hasExtra("googleSignInStatus") && !intent.hasExtra("googleSignInAccount"))) {
            return null;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) intent.getParcelableExtra("googleSignInAccount");
        Status status = (Status) intent.getParcelableExtra("googleSignInStatus");
        if (googleSignInAccount != null) {
            status = Status.bgw;
        }
        return new ase(googleSignInAccount, status);
    }
}
