package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.facebook.internal.CustomTab;
import com.fossil.gy;

public class CustomTabMainActivity extends Activity {
    public static final String EXTRA_CHROME_PACKAGE = (CustomTabMainActivity.class.getSimpleName() + ".extra_chromePackage");
    public static final String EXTRA_PARAMS = (CustomTabMainActivity.class.getSimpleName() + ".extra_params");
    public static final String EXTRA_URL = (CustomTabMainActivity.class.getSimpleName() + ".extra_url");
    private static final String OAUTH_DIALOG = "oauth";
    public static final String REFRESH_ACTION = (CustomTabMainActivity.class.getSimpleName() + ".action_refresh");
    private BroadcastReceiver redirectReceiver;
    private boolean shouldCloseCustomTab = true;

    class C13041 extends BroadcastReceiver {
        C13041() {
        }

        public void onReceive(Context context, Intent intent) {
            Intent intent2 = new Intent(CustomTabMainActivity.this, CustomTabMainActivity.class);
            intent2.setAction(CustomTabMainActivity.REFRESH_ACTION);
            intent2.putExtra(CustomTabMainActivity.EXTRA_URL, intent.getStringExtra(CustomTabMainActivity.EXTRA_URL));
            intent2.addFlags(603979776);
            CustomTabMainActivity.this.startActivity(intent2);
        }
    }

    public static final String getRedirectUrl() {
        return "fb" + FacebookSdk.getApplicationId() + "://authorize";
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION.equals(getIntent().getAction())) {
            setResult(0);
            finish();
        } else if (bundle == null) {
            Bundle bundleExtra = getIntent().getBundleExtra(EXTRA_PARAMS);
            new CustomTab(OAUTH_DIALOG, bundleExtra).openCustomTab(this, getIntent().getStringExtra(EXTRA_CHROME_PACKAGE));
            this.shouldCloseCustomTab = false;
            this.redirectReceiver = new C13041();
            gy.m11536p(this).m11537a(this.redirectReceiver, new IntentFilter(CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION));
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (REFRESH_ACTION.equals(intent.getAction())) {
            gy.m11536p(this).m11538b(new Intent(CustomTabActivity.DESTROY_ACTION));
            sendResult(-1, intent);
        } else if (CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION.equals(intent.getAction())) {
            sendResult(-1, intent);
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.shouldCloseCustomTab) {
            sendResult(0, null);
        }
        this.shouldCloseCustomTab = true;
    }

    private void sendResult(int i, Intent intent) {
        gy.m11536p(this).unregisterReceiver(this.redirectReceiver);
        if (intent != null) {
            setResult(i, intent);
        } else {
            setResult(i);
        }
        finish();
    }
}
