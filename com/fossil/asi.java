package com.fossil;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.fossil.atv.C1898b;
import com.fossil.atv.C1899c;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.a;
import com.google.android.gms.common.api.Scope;

public final class asi extends axg<asw> {
    private final GoogleSignInOptions bfs;

    public asi(Context context, Looper looper, awy com_fossil_awy, GoogleSignInOptions googleSignInOptions, C1898b c1898b, C1899c c1899c) {
        super(context, looper, 91, com_fossil_awy, c1898b, c1899c);
        if (googleSignInOptions == null) {
            googleSignInOptions = new a().JY();
        }
        if (!com_fossil_awy.Lv().isEmpty()) {
            a aVar = new a(googleSignInOptions);
            for (Scope a : com_fossil_awy.Lv()) {
                aVar.a(a, new Scope[0]);
            }
            googleSignInOptions = aVar.JY();
        }
        this.bfs = googleSignInOptions;
    }

    protected final String Kh() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    protected final String Ki() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    public final boolean Kj() {
        return true;
    }

    public final Intent Kk() {
        return asj.m4391a(getContext(), this.bfs);
    }

    public final GoogleSignInOptions Kl() {
        return this.bfs;
    }

    protected final /* synthetic */ IInterface mo1165f(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        return queryLocalInterface instanceof asw ? (asw) queryLocalInterface : new asx(iBinder);
    }
}
