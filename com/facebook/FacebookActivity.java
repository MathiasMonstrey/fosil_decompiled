package com.facebook;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.NativeProtocol;
import com.facebook.login.LoginFragment;
import com.facebook.share.internal.DeviceShareDialogFragment;
import com.facebook.share.model.ShareContent;
import com.fossil.ew;
import com.fossil.fa;

public class FacebookActivity extends ew {
    private static String FRAGMENT_TAG = "SingleFragment";
    public static String PASS_THROUGH_CANCEL_ACTION = "PassThrough";
    private static final String TAG = FacebookActivity.class.getName();
    private Fragment singleFragment;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (!FacebookSdk.isInitialized()) {
            Log.d(TAG, "Facebook SDK not initialized. Make sure you call sdkInitialize inside your Application's onCreate method.");
            FacebookSdk.sdkInitialize(getApplicationContext());
        }
        setContentView(C1325R.layout.com_facebook_activity_layout);
        if (PASS_THROUGH_CANCEL_ACTION.equals(intent.getAction())) {
            handlePassThroughError();
        } else {
            this.singleFragment = getFragment();
        }
    }

    protected Fragment getFragment() {
        Intent intent = getIntent();
        fa supportFragmentManager = getSupportFragmentManager();
        Fragment W = supportFragmentManager.mo3086W(FRAGMENT_TAG);
        if (W != null) {
            return W;
        }
        if (FacebookDialogFragment.TAG.equals(intent.getAction())) {
            W = new FacebookDialogFragment();
            W.setRetainInstance(true);
            W.show(supportFragmentManager, FRAGMENT_TAG);
            return W;
        } else if (DeviceShareDialogFragment.TAG.equals(intent.getAction())) {
            Fragment deviceShareDialogFragment = new DeviceShareDialogFragment();
            deviceShareDialogFragment.setRetainInstance(true);
            deviceShareDialogFragment.setShareContent((ShareContent) intent.getParcelableExtra("content"));
            deviceShareDialogFragment.show(supportFragmentManager, FRAGMENT_TAG);
            return deviceShareDialogFragment;
        } else {
            W = new LoginFragment();
            W.setRetainInstance(true);
            supportFragmentManager.hW().mo2966a(C1325R.id.com_facebook_fragment_container, W, FRAGMENT_TAG).commit();
            return W;
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.singleFragment != null) {
            this.singleFragment.onConfigurationChanged(configuration);
        }
    }

    public Fragment getCurrentFragment() {
        return this.singleFragment;
    }

    private void handlePassThroughError() {
        setResult(0, NativeProtocol.createProtocolResultIntent(getIntent(), null, NativeProtocol.getExceptionFromErrorData(NativeProtocol.getMethodArgumentsFromIntent(getIntent()))));
        finish();
    }
}
