package com.fossil;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.fossil.atv.C1898b;
import com.fossil.atv.C1899c;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public final class bue extends axg<buc> implements btu {
    private final Bundle bGc;
    private final boolean bGk;
    private Integer biG;
    private final awy biS;

    public bue(Context context, Looper looper, boolean z, awy com_fossil_awy, Bundle bundle, C1898b c1898b, C1899c c1899c) {
        super(context, looper, 44, com_fossil_awy, c1898b, c1899c);
        this.bGk = z;
        this.biS = com_fossil_awy;
        this.bGc = bundle;
        this.biG = com_fossil_awy.LA();
    }

    public bue(Context context, Looper looper, boolean z, awy com_fossil_awy, btv com_fossil_btv, C1898b c1898b, C1899c c1899c) {
        this(context, looper, true, com_fossil_awy, m5680a(com_fossil_awy), c1898b, c1899c);
    }

    public static Bundle m5680a(awy com_fossil_awy) {
        btv Lz = com_fossil_awy.Lz();
        Integer LA = com_fossil_awy.LA();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", com_fossil_awy.KQ());
        if (LA != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", LA.intValue());
        }
        if (Lz != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", Lz.Sy());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", Lz.Sz());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", Lz.SA());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", Lz.SB());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", Lz.SC());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", Lz.SD());
            if (Lz.SE() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", Lz.SE().longValue());
            }
            if (Lz.SF() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", Lz.SF().longValue());
            }
        }
        return bundle;
    }

    protected final Bundle JJ() {
        if (!getContext().getPackageName().equals(this.biS.Lx())) {
            this.bGc.putString("com.google.android.gms.signin.internal.realClientPackageName", this.biS.Lx());
        }
        return this.bGc;
    }

    protected final String Kh() {
        return "com.google.android.gms.signin.service.START";
    }

    protected final String Ki() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    public final boolean Ky() {
        return this.bGk;
    }

    public final void Sx() {
        try {
            ((buc) Lm()).ij(this.biG.intValue());
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    public final void mo1482a(avg com_fossil_avg, boolean z) {
        try {
            ((buc) Lm()).mo1478a(com_fossil_avg, this.biG.intValue(), z);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    public final void mo1483a(bua com_fossil_bua) {
        awa.m4640p(com_fossil_bua, "Expecting a valid ISignInCallbacks");
        try {
            Account Lt = this.biS.Lt();
            GoogleSignInAccount googleSignInAccount = null;
            if ("<<default account>>".equals(Lt.name)) {
                googleSignInAccount = atb.ai(getContext()).Ko();
            }
            ((buc) Lm()).mo1479a(new buf(new awb(Lt, this.biG.intValue(), googleSignInAccount)), com_fossil_bua);
        } catch (Throwable e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                com_fossil_bua.mo1327b(new buh(8));
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    public final void connect() {
        m4384a(new awv(this));
    }

    protected final /* synthetic */ IInterface mo1165f(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return queryLocalInterface instanceof buc ? (buc) queryLocalInterface : new bud(iBinder);
    }
}
