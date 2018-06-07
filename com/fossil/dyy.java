package com.fossil;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.fossil.dxy.C3288a;
import com.fossil.dxz.C3289a;
import com.fossil.dyi.C3295a;
import com.fossil.dyj.C3297a;
import com.fossil.dyk.C3298a;
import com.fossil.dyl.C3299a;
import com.fossil.dym.C3300a;
import com.fossil.dyn.C3301a;
import com.fossil.dyo.C3303b;
import com.fossil.dyp.C3304a;
import com.fossil.dyq.C3305a;
import com.tencent.wxop.stat.MtaSDkException;
import com.tencent.wxop.stat.StatReportStrategy;

final class dyy implements dyt {
    private static C3310a dBl = null;
    private static String dBo = null;
    private String appId;
    private Context context;
    private boolean dBm = false;
    private boolean dBn = false;

    static final class C3310a implements ActivityLifecycleCallbacks {
        private Context context;
        private boolean dBp;
        private Runnable dBq;
        private Runnable dBr;
        private Handler handler;

        private C3310a(Context context) {
            this.dBp = false;
            this.handler = new Handler(Looper.getMainLooper());
            this.dBq = new dyz(this);
            this.dBr = new dza(this);
            this.context = context;
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }

        public final void onActivityPaused(Activity activity) {
            Log.v("MicroMsg.SDK.WXApiImplV10.ActivityLifecycleCb", activity.getComponentName().getClassName() + "  onActivityPaused");
            this.handler.removeCallbacks(this.dBr);
            this.handler.postDelayed(this.dBq, 800);
        }

        public final void onActivityResumed(Activity activity) {
            Log.v("MicroMsg.SDK.WXApiImplV10.ActivityLifecycleCb", activity.getComponentName().getClassName() + "  onActivityResumed");
            this.handler.removeCallbacks(this.dBq);
            this.handler.postDelayed(this.dBr, 800);
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityStarted(Activity activity) {
        }

        public final void onActivityStopped(Activity activity) {
        }
    }

    dyy(Context context, String str, boolean z) {
        dyc.m10281e("MicroMsg.SDK.WXApiImplV10", "<init>, appId = " + str + ", checkSignature = " + z);
        this.context = context;
        this.appId = str;
        this.dBm = z;
    }

    private void m10318V(Context context, String str) {
        String str2 = "AWXOP" + str;
        dze.m10334W(context, str2);
        dze.dC(true);
        dze.m10343a(StatReportStrategy.PERIOD);
        dze.mV(60);
        dze.m10335X(context, "Wechat_Sdk");
        try {
            dzf.m10351k(context, str2, "2.0.3");
        } catch (MtaSDkException e) {
            e.printStackTrace();
        }
    }

    private boolean m10319d(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0) {
            dyc.m10282x("MicroMsg.SDK.WXApiImplV10", "checkSumConsistent fail, invalid arguments");
            return false;
        } else if (bArr.length != bArr2.length) {
            dyc.m10282x("MicroMsg.SDK.WXApiImplV10", "checkSumConsistent fail, length is different");
            return false;
        } else {
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    private boolean m10320f(Context context, Bundle bundle) {
        if (dBo == null) {
            dBo = new dyv(context).getString("_wxapp_pay_entry_classname_", null);
            dyc.m10281e("MicroMsg.SDK.WXApiImplV10", "pay, set wxappPayEntryClassname = " + dBo);
            if (dBo == null) {
                dyc.m10282x("MicroMsg.SDK.WXApiImplV10", "pay fail, wxappPayEntryClassname is null");
                return false;
            }
        }
        C3288a c3288a = new C3288a();
        c3288a.dAE = bundle;
        c3288a.f1466W = "com.tencent.mm";
        c3288a.dAC = dBo;
        return dxy.m10272a(context, c3288a);
    }

    private boolean m10321g(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile"), null, null, new String[]{this.appId, bundle.getString("_wxapi_jump_to_biz_profile_req_to_user_name"), bundle.getString("_wxapi_jump_to_biz_profile_req_ext_msg"), bundle.getInt("_wxapi_jump_to_biz_profile_req_scene"), bundle.getInt("_wxapi_jump_to_biz_profile_req_profile_type")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean m10322h(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile"), null, null, new String[]{this.appId, bundle.getString("_wxapi_jump_to_biz_webview_req_to_user_name"), bundle.getString("_wxapi_jump_to_biz_webview_req_ext_msg"), bundle.getInt("_wxapi_jump_to_biz_webview_req_scene")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean m10323i(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizTempSession"), null, null, new String[]{this.appId, bundle.getString("_wxapi_jump_to_biz_webview_req_to_user_name"), bundle.getString("_wxapi_jump_to_biz_webview_req_session_from"), bundle.getInt("_wxapi_jump_to_biz_webview_req_show_type")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean m10324j(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/addCardToWX"), null, null, new String[]{this.appId, bundle.getString("_wxapi_add_card_to_wx_card_list"), bundle.getString("_wxapi_basereq_transaction")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean m10325k(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openRankList"), null, null, new String[0], null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean m10326l(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openWebview"), null, null, new String[]{this.appId, bundle.getString("_wxapi_jump_to_webview_url"), bundle.getString("_wxapi_basereq_transaction")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean m10327m(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusiLuckyMoney"), null, null, new String[]{this.appId, bundle.getString("_wxapi_open_busi_lucky_money_timeStamp"), bundle.getString("_wxapi_open_busi_lucky_money_nonceStr"), bundle.getString("_wxapi_open_busi_lucky_money_signType"), bundle.getString("_wxapi_open_busi_lucky_money_signature"), bundle.getString("_wxapi_open_busi_lucky_money_package")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean m10328n(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/createChatroom"), null, null, new String[]{this.appId, bundle.getString("_wxapi_basereq_transaction"), bundle.getString("_wxapi_create_chatroom_group_id"), bundle.getString("_wxapi_create_chatroom_chatroom_name"), bundle.getString("_wxapi_create_chatroom_chatroom_nickname"), bundle.getString("_wxapi_create_chatroom_ext_msg")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean m10329o(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/joinChatroom"), null, null, new String[]{this.appId, bundle.getString("_wxapi_basereq_transaction"), bundle.getString("_wxapi_join_chatroom_group_id"), bundle.getString("_wxapi_join_chatroom_chatroom_nickname"), bundle.getString("_wxapi_join_chatroom_ext_msg")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    public final boolean aBD() {
        boolean z = false;
        if (this.dBn) {
            throw new IllegalStateException("isWXAppInstalled fail, WXMsgImpl has been detached");
        }
        try {
            PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo("com.tencent.mm", 64);
            if (packageInfo != null) {
                z = dyx.m10312a(this.context, packageInfo.signatures, this.dBm);
            }
        } catch (NameNotFoundException e) {
        }
        return z;
    }

    public final boolean mo2789b(Intent intent, dyu com_fossil_dyu) {
        try {
            if (!dyx.m10313b(intent, "com.tencent.mm.openapi.token")) {
                dyc.m10280d("MicroMsg.SDK.WXApiImplV10", "handleIntent fail, intent not from weixin msg");
                return false;
            } else if (this.dBn) {
                throw new IllegalStateException("handleIntent fail, WXMsgImpl has been detached");
            } else {
                String stringExtra = intent.getStringExtra("_mmessage_content");
                int intExtra = intent.getIntExtra("_mmessage_sdkVersion", 0);
                String stringExtra2 = intent.getStringExtra("_mmessage_appPackage");
                if (stringExtra2 == null || stringExtra2.length() == 0) {
                    dyc.m10282x("MicroMsg.SDK.WXApiImplV10", "invalid argument");
                    return false;
                } else if (m10319d(intent.getByteArrayExtra("_mmessage_checksum"), dya.m10275c(stringExtra, intExtra, stringExtra2))) {
                    int intExtra2 = intent.getIntExtra("_wxapi_command_type", 0);
                    switch (intExtra2) {
                        case 1:
                            com_fossil_dyu.mo1902a(new C3303b(intent.getExtras()));
                            return true;
                        case 2:
                            com_fossil_dyu.mo1902a(new C3304a(intent.getExtras()));
                            return true;
                        case 3:
                            com_fossil_dyu.mo1901a(new C3300a(intent.getExtras()));
                            return true;
                        case 4:
                            com_fossil_dyu.mo1901a(new C3305a(intent.getExtras()));
                            return true;
                        case 5:
                            com_fossil_dyu.mo1902a(new dys(intent.getExtras()));
                            return true;
                        case 6:
                            com_fossil_dyu.mo1901a(new C3301a(intent.getExtras()));
                            return true;
                        case 9:
                            com_fossil_dyu.mo1902a(new C3295a(intent.getExtras()));
                            return true;
                        case 12:
                            com_fossil_dyu.mo1902a(new C3299a(intent.getExtras()));
                            return true;
                        case 14:
                            com_fossil_dyu.mo1902a(new C3297a(intent.getExtras()));
                            return true;
                        case 15:
                            com_fossil_dyu.mo1902a(new C3298a(intent.getExtras()));
                            return true;
                        default:
                            dyc.m10282x("MicroMsg.SDK.WXApiImplV10", "unknown cmd = " + intExtra2);
                            return false;
                    }
                } else {
                    dyc.m10282x("MicroMsg.SDK.WXApiImplV10", "checksum fail");
                    return false;
                }
            }
        } catch (Exception e) {
            dyc.m10279a("MicroMsg.SDK.WXApiImplV10", "handleIntent fail, ex = %s", e.getMessage());
            return false;
        }
    }

    public final boolean mo2790b(dyg com_fossil_dyg) {
        if (this.dBn) {
            throw new IllegalStateException("sendReq fail, WXMsgImpl has been detached");
        } else if (!dyx.m10314i(this.context, "com.tencent.mm", this.dBm)) {
            dyc.m10282x("MicroMsg.SDK.WXApiImplV10", "sendReq failed for wechat app signature check failed");
            return false;
        } else if (com_fossil_dyg.checkArgs()) {
            dyc.m10281e("MicroMsg.SDK.WXApiImplV10", "sendReq, req type = " + com_fossil_dyg.getType());
            Bundle bundle = new Bundle();
            com_fossil_dyg.mo2787o(bundle);
            if (com_fossil_dyg.getType() == 5) {
                return m10320f(this.context, bundle);
            }
            if (com_fossil_dyg.getType() == 7) {
                return m10321g(this.context, bundle);
            }
            if (com_fossil_dyg.getType() == 8) {
                return m10322h(this.context, bundle);
            }
            if (com_fossil_dyg.getType() == 10) {
                return m10323i(this.context, bundle);
            }
            if (com_fossil_dyg.getType() == 9) {
                return m10324j(this.context, bundle);
            }
            if (com_fossil_dyg.getType() == 11) {
                return m10325k(this.context, bundle);
            }
            if (com_fossil_dyg.getType() == 12) {
                return m10326l(this.context, bundle);
            }
            if (com_fossil_dyg.getType() == 13) {
                return m10327m(this.context, bundle);
            }
            if (com_fossil_dyg.getType() == 14) {
                return m10328n(this.context, bundle);
            }
            if (com_fossil_dyg.getType() == 15) {
                return m10329o(this.context, bundle);
            }
            C3288a c3288a = new C3288a();
            c3288a.dAE = bundle;
            c3288a.dAD = "weixin://sendreq?appid=" + this.appId;
            c3288a.f1466W = "com.tencent.mm";
            c3288a.dAC = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
            return dxy.m10272a(this.context, c3288a);
        } else {
            dyc.m10282x("MicroMsg.SDK.WXApiImplV10", "sendReq checkArgs fail");
            return false;
        }
    }

    public final boolean lf(String str) {
        if (this.dBn) {
            throw new IllegalStateException("registerApp fail, WXMsgImpl has been detached");
        } else if (dyx.m10314i(this.context, "com.tencent.mm", this.dBm)) {
            if (dBl == null && VERSION.SDK_INT >= 14) {
                if (this.context instanceof Activity) {
                    m10318V(this.context, str);
                    dBl = new C3310a(this.context);
                    ((Activity) this.context).getApplication().registerActivityLifecycleCallbacks(dBl);
                } else if (this.context instanceof Service) {
                    m10318V(this.context, str);
                    dBl = new C3310a(this.context);
                    ((Service) this.context).getApplication().registerActivityLifecycleCallbacks(dBl);
                } else {
                    dyc.m10283y("MicroMsg.SDK.WXApiImplV10", "context is not instanceof Activity or Service, disable WXStat");
                }
            }
            dyc.m10281e("MicroMsg.SDK.WXApiImplV10", "registerApp, appId = " + str);
            if (str != null) {
                this.appId = str;
            }
            dyc.m10281e("MicroMsg.SDK.WXApiImplV10", "register app " + this.context.getPackageName());
            C3289a c3289a = new C3289a();
            c3289a.dAF = "com.tencent.mm";
            c3289a.dAG = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_REGISTER";
            c3289a.dAD = "weixin://registerapp?appid=" + this.appId;
            return dxz.m10273a(this.context, c3289a);
        } else {
            dyc.m10282x("MicroMsg.SDK.WXApiImplV10", "register app failed for wechat app signature check failed");
            return false;
        }
    }
}
