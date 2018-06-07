package com.fossil.wearables.fossil.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.fossil.drj;
import com.fossil.dyg;
import com.fossil.dyh;
import com.fossil.dyu;
import com.misfit.frameworks.common.log.MFLogger;

public class WXEntryActivity extends Activity implements dyu {
    private static final String TAG = WXEntryActivity.class.getSimpleName();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        drj.auQ().a(getIntent(), this);
        MFLogger.d(TAG, getPackageName());
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        drj.auQ().a(getIntent(), this);
    }

    public void m13982a(dyg com_fossil_dyg) {
        drj.auQ().a(com_fossil_dyg);
        MFLogger.i(TAG, "Wechat onReq");
        finish();
    }

    public void m13983a(dyh com_fossil_dyh) {
        drj.auQ().a(com_fossil_dyh);
        MFLogger.i(TAG, "Wechat onResp");
        finish();
    }
}
