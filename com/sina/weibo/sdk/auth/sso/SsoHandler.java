package com.sina.weibo.sdk.auth.sso;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.fossil.dsh;
import com.fossil.dsk;
import com.fossil.dsk.a;
import com.fossil.dsn;
import com.fossil.dso;
import com.fossil.dsp;
import com.fossil.dsq;
import com.fossil.dsx;
import com.fossil.dud;
import com.fossil.duh;
import com.fossil.duj;
import com.fossil.duo;
import com.fossil.duq;
import com.sina.weibo.sdk.exception.WeiboDialogException;
import com.sina.weibo.sdk.exception.WeiboException;
import java.util.HashMap;
import java.util.Map;

public class SsoHandler {
    private dsq dqq;
    private dsp dqr;
    private Activity dqs;
    private int dqt;
    private a dqu;
    private dsn dqv;
    private ServiceConnection dqw = new C50511(this);

    class C50511 implements ServiceConnection {
        final /* synthetic */ SsoHandler dqx;

        C50511(SsoHandler ssoHandler) {
            this.dqx = ssoHandler;
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.dqx.dqq.b(this.dqx.dqr);
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            dsh s = dsh.a.s(iBinder);
            try {
                String packageName = s.getPackageName();
                String aws = s.aws();
                this.dqx.dqs.getApplicationContext().unbindService(this.dqx.dqw);
                if (!this.dqx.aK(packageName, aws)) {
                    this.dqx.dqq.b(this.dqx.dqr);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    enum AuthType {
        ALL,
        SsoOnly,
        WebOnly
    }

    public SsoHandler(Activity activity, dsn com_fossil_dsn) {
        this.dqs = activity;
        this.dqv = com_fossil_dsn;
        this.dqq = new dsq(activity, com_fossil_dsn);
        this.dqu = dsk.cF(activity).awu();
        duh.cP(this.dqs).kh(com_fossil_dsn.awy());
    }

    public void m16054a(dsp com_fossil_dsp) {
        m16048a(32973, com_fossil_dsp, AuthType.ALL);
        dsx.L(this.dqs, this.dqv.awy()).awO();
    }

    private void m16048a(int i, dsp com_fossil_dsp, AuthType authType) {
        this.dqt = i;
        this.dqr = com_fossil_dsp;
        Object obj = null;
        if (authType == AuthType.SsoOnly) {
            obj = 1;
        }
        if (authType == AuthType.WebOnly) {
            if (com_fossil_dsp != null) {
                this.dqq.b(com_fossil_dsp);
            }
        } else if (!cJ(this.dqs.getApplicationContext())) {
            if (obj == null) {
                this.dqq.b(this.dqr);
            } else if (this.dqr != null) {
                this.dqr.a(new WeiboException("not install weibo client!!!!!"));
            }
        }
    }

    public void m16053a(int i, int i2, Intent intent) {
        duj.d("Weibo_SSO_login", "requestCode: " + i + ", resultCode: " + i2 + ", data: " + intent);
        String stringExtra;
        Bundle extras;
        dso K;
        if (i == this.dqt) {
            if (i2 == -1) {
                if (duo.a(this.dqs, this.dqu, intent)) {
                    stringExtra = intent.getStringExtra("error");
                    if (stringExtra == null) {
                        stringExtra = intent.getStringExtra(NativeProtocol.BRIDGE_ARG_ERROR_TYPE);
                    }
                    if (stringExtra == null) {
                        extras = intent.getExtras();
                        K = dso.K(extras);
                        if (K == null || !K.awC()) {
                            duj.d("Weibo_SSO_login", "Failed to receive access token by SSO");
                            this.dqq.b(this.dqr);
                            return;
                        }
                        duj.d("Weibo_SSO_login", "Login Success! " + K.toString());
                        this.dqr.G(extras);
                    } else if (stringExtra.equals("access_denied") || stringExtra.equals("OAuthAccessDeniedException")) {
                        duj.d("Weibo_SSO_login", "Login canceled by user.");
                        this.dqr.onCancel();
                    } else {
                        String stringExtra2 = intent.getStringExtra(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION);
                        if (stringExtra2 != null) {
                            stringExtra = new StringBuilder(String.valueOf(stringExtra)).append(":").append(stringExtra2).toString();
                        }
                        duj.d("Weibo_SSO_login", "Login failed: " + stringExtra);
                        this.dqr.a(new WeiboDialogException(stringExtra, i2, stringExtra2));
                    }
                }
            } else if (i2 != 0) {
            } else {
                if (intent != null) {
                    duj.d("Weibo_SSO_login", "Login failed: " + intent.getStringExtra("error"));
                    this.dqr.a(new WeiboDialogException(intent.getStringExtra("error"), intent.getIntExtra(NativeProtocol.BRIDGE_ARG_ERROR_CODE, -1), intent.getStringExtra("failing_url")));
                    return;
                }
                duj.d("Weibo_SSO_login", "Login canceled by user.");
                this.dqr.onCancel();
            }
        } else if (i != 40000) {
        } else {
            if (i2 == -1) {
                extras = intent.getExtras();
                K = dso.K(extras);
                if (K != null && K.awC()) {
                    duj.d("Weibo_SSO_login", "Login Success! " + K.toString());
                    this.dqr.G(extras);
                }
            } else if (i2 != 0) {
            } else {
                if (intent != null) {
                    duj.d("Weibo_SSO_login", "Login failed: " + intent.getStringExtra("error"));
                    stringExtra = intent.getStringExtra("error");
                    if (stringExtra == null) {
                        stringExtra = intent.getStringExtra(NativeProtocol.BRIDGE_ARG_ERROR_TYPE);
                    }
                    if (stringExtra != null) {
                        this.dqr.a(new WeiboDialogException(intent.getStringExtra("error"), intent.getIntExtra(NativeProtocol.BRIDGE_ARG_ERROR_CODE, -1), intent.getStringExtra(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION)));
                        return;
                    }
                    return;
                }
                duj.d("Weibo_SSO_login", "Login canceled by user.");
                this.dqr.onCancel();
            }
        }
    }

    private boolean cJ(Context context) {
        if (!awD()) {
            return false;
        }
        String packageName = this.dqu.getPackageName();
        Intent intent = new Intent("com.sina.weibo.remotessoservice");
        intent.setPackage(packageName);
        return context.bindService(intent, this.dqw, 1);
    }

    private boolean aK(String str, String str2) {
        boolean z = true;
        Intent intent = new Intent();
        intent.setClassName(str, str2);
        intent.putExtras(this.dqq.awE().awB());
        intent.putExtra("_weibo_command_type", 3);
        String valueOf = String.valueOf(System.currentTimeMillis());
        intent.putExtra("_weibo_transaction", valueOf);
        m16055f(this.dqs, valueOf, ServerProtocol.DIALOG_PARAM_SSO_DEVICE);
        intent.putExtra("aid", duq.U(this.dqs, this.dqv.awy()));
        if (!duo.j(this.dqs, intent)) {
            return false;
        }
        Object U = duq.U(this.dqs, this.dqv.awy());
        if (!TextUtils.isEmpty(U)) {
            intent.putExtra("aid", U);
        }
        try {
            this.dqs.startActivityForResult(intent, this.dqt);
        } catch (ActivityNotFoundException e) {
            z = false;
        }
        return z;
    }

    public boolean awD() {
        return this.dqu != null && this.dqu.aww();
    }

    public void m16055f(Context context, String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("other_app_action_start_time", str);
        try {
            dud.a(context, str2, hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
