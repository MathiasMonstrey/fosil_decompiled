package com.facebook.internal;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.WebDialog.Builder;
import com.facebook.internal.WebDialog.OnCompleteListener;
import com.fossil.ev;
import com.fossil.ew;

public class FacebookDialogFragment extends ev {
    public static final String TAG = "FacebookDialogFragment";
    private Dialog dialog;

    class C13611 implements OnCompleteListener {
        C13611() {
        }

        public void onComplete(Bundle bundle, FacebookException facebookException) {
            FacebookDialogFragment.this.onCompleteWebDialog(bundle, facebookException);
        }
    }

    class C13622 implements OnCompleteListener {
        C13622() {
        }

        public void onComplete(Bundle bundle, FacebookException facebookException) {
            FacebookDialogFragment.this.onCompleteWebFallbackDialog(bundle);
        }
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.dialog == null) {
            Dialog facebookWebFallbackDialog;
            Context activity = getActivity();
            Bundle methodArgumentsFromIntent = NativeProtocol.getMethodArgumentsFromIntent(activity.getIntent());
            String string;
            if (methodArgumentsFromIntent.getBoolean(NativeProtocol.WEB_DIALOG_IS_FALLBACK, false)) {
                string = methodArgumentsFromIntent.getString("url");
                if (Utility.isNullOrEmpty(string)) {
                    Utility.logd(TAG, "Cannot start a fallback WebDialog with an empty/missing 'url'");
                    activity.finish();
                    return;
                }
                facebookWebFallbackDialog = new FacebookWebFallbackDialog(activity, string, String.format("fb%s://bridge/", new Object[]{FacebookSdk.getApplicationId()}));
                facebookWebFallbackDialog.setOnCompleteListener(new C13622());
            } else {
                string = methodArgumentsFromIntent.getString("action");
                methodArgumentsFromIntent = methodArgumentsFromIntent.getBundle(NativeProtocol.WEB_DIALOG_PARAMS);
                if (Utility.isNullOrEmpty(string)) {
                    Utility.logd(TAG, "Cannot start a WebDialog with an empty/missing 'actionName'");
                    activity.finish();
                    return;
                }
                facebookWebFallbackDialog = new Builder(activity, string, methodArgumentsFromIntent).setOnCompleteListener(new C13611()).build();
            }
            this.dialog = facebookWebFallbackDialog;
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.dialog == null) {
            onCompleteWebDialog(null, null);
            setShowsDialog(false);
        }
        return this.dialog;
    }

    public void onResume() {
        super.onResume();
        if (this.dialog instanceof WebDialog) {
            ((WebDialog) this.dialog).resize();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if ((this.dialog instanceof WebDialog) && isResumed()) {
            ((WebDialog) this.dialog).resize();
        }
    }

    public void onDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
    }

    private void onCompleteWebDialog(Bundle bundle, FacebookException facebookException) {
        ew activity = getActivity();
        activity.setResult(facebookException == null ? -1 : 0, NativeProtocol.createProtocolResultIntent(activity.getIntent(), bundle, facebookException));
        activity.finish();
    }

    private void onCompleteWebFallbackDialog(Bundle bundle) {
        ew activity = getActivity();
        Intent intent = new Intent();
        if (bundle == null) {
            bundle = new Bundle();
        }
        intent.putExtras(bundle);
        activity.setResult(-1, intent);
        activity.finish();
    }
}
