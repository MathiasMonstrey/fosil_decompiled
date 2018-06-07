package com.fossil;

import android.content.Context;
import android.os.Looper;
import com.fossil.ats.C1888f;
import com.fossil.ats.C1890b;
import com.fossil.atv.C1898b;
import com.fossil.atv.C1899c;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import java.util.Collections;
import java.util.List;

final class atj extends C1890b<asi, GoogleSignInOptions> {
    atj() {
    }

    public final /* synthetic */ C1888f mo1176a(Context context, Looper looper, awy com_fossil_awy, Object obj, C1898b c1898b, C1899c c1899c) {
        return new asi(context, looper, com_fossil_awy, (GoogleSignInOptions) obj, c1898b, c1899c);
    }

    public final /* synthetic */ List bM(Object obj) {
        GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
        return googleSignInOptions == null ? Collections.emptyList() : googleSignInOptions.JT();
    }
}
