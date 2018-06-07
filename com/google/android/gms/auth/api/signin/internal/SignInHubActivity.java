package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import com.fossil.asg;
import com.fossil.atb;
import com.fossil.atv;
import com.fossil.ew;
import com.fossil.fj.a;
import com.fossil.gx;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;

@KeepName
public class SignInHubActivity extends ew {
    private atb bfj;
    private boolean bfk = false;
    private SignInConfiguration bfl;
    private boolean bfm;
    private int bfn;
    private Intent bfo;

    class C4247a implements a<Void> {
        private /* synthetic */ SignInHubActivity bfp;

        private C4247a(SignInHubActivity signInHubActivity) {
            this.bfp = signInHubActivity;
        }

        public final void m14199a(gx<Void> gxVar) {
        }

        public final /* synthetic */ void m14200a(gx gxVar, Object obj) {
            this.bfp.setResult(this.bfp.bfn, this.bfp.bfo);
            this.bfp.finish();
        }

        public final gx<Void> m14201b(int i, Bundle bundle) {
            return new asg(this.bfp, atv.KC());
        }
    }

    private final void Ke() {
        getSupportLoaderManager().a(0, null, new C4247a());
    }

    private final void hl(int i) {
        Parcelable status = new Status(i);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (!this.bfk) {
            setResult(0);
            switch (i) {
                case 40962:
                    if (intent != null) {
                        SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
                        if (signInAccount != null && signInAccount.Kc() != null) {
                            Parcelable Kc = signInAccount.Kc();
                            this.bfj.a(Kc, this.bfl.Kd());
                            intent.removeExtra("signInAccount");
                            intent.putExtra("googleSignInAccount", Kc);
                            this.bfm = true;
                            this.bfn = i2;
                            this.bfo = intent;
                            Ke();
                            return;
                        } else if (intent.hasExtra("errorCode")) {
                            hl(intent.getIntExtra("errorCode", 8));
                            return;
                        }
                    }
                    hl(8);
                    return;
                default:
                    return;
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bfj = atb.ai(this);
        Intent intent = getIntent();
        if (!"com.google.android.gms.auth.GOOGLE_SIGN_IN".equals(intent.getAction())) {
            String str = "AuthSignInClient";
            String str2 = "Unknown action: ";
            String valueOf = String.valueOf(intent.getAction());
            Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            finish();
        }
        this.bfl = (SignInConfiguration) intent.getParcelableExtra("config");
        if (this.bfl == null) {
            Log.e("AuthSignInClient", "Activity started with invalid configuration.");
            setResult(0);
            finish();
        } else if (bundle == null) {
            Intent intent2 = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
            intent2.setPackage("com.google.android.gms");
            intent2.putExtra("config", this.bfl);
            try {
                startActivityForResult(intent2, 40962);
            } catch (ActivityNotFoundException e) {
                this.bfk = true;
                Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
                hl(17);
            }
        } else {
            this.bfm = bundle.getBoolean("signingInGoogleApiClients");
            if (this.bfm) {
                this.bfn = bundle.getInt("signInResultCode");
                this.bfo = (Intent) bundle.getParcelable("signInResultData");
                Ke();
            }
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.bfm);
        if (this.bfm) {
            bundle.putInt("signInResultCode", this.bfn);
            bundle.putParcelable("signInResultData", this.bfo);
        }
    }
}
