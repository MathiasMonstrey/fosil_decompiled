package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.CallbackManager;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.share.Sharer.Result;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.model.ShareContent;

public abstract class ShareButtonBase extends FacebookButtonBase {
    private boolean enabledExplicitlySet = false;
    private int requestCode = 0;
    private ShareContent shareContent;

    class C14961 implements OnClickListener {
        C14961() {
        }

        public void onClick(View view) {
            ShareButtonBase.this.callExternalOnClickListener(view);
            ShareButtonBase.this.getDialog().show(ShareButtonBase.this.getShareContent());
        }
    }

    protected abstract FacebookDialogBase<ShareContent, Result> getDialog();

    protected ShareButtonBase(Context context, AttributeSet attributeSet, int i, String str, String str2) {
        super(context, attributeSet, i, 0, str, str2);
        this.requestCode = isInEditMode() ? 0 : getDefaultRequestCode();
        internalSetEnabled(false);
    }

    public ShareContent getShareContent() {
        return this.shareContent;
    }

    public void setShareContent(ShareContent shareContent) {
        this.shareContent = shareContent;
        if (!this.enabledExplicitlySet) {
            internalSetEnabled(canShare());
        }
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.enabledExplicitlySet = true;
    }

    public int getRequestCode() {
        return this.requestCode;
    }

    protected void setRequestCode(int i) {
        if (FacebookSdk.isFacebookRequestCode(i)) {
            throw new IllegalArgumentException("Request code " + i + " cannot be within the range reserved by the Facebook SDK.");
        }
        this.requestCode = i;
    }

    public void registerCallback(CallbackManager callbackManager, FacebookCallback<Result> facebookCallback) {
        ShareInternalUtility.registerSharerCallback(getRequestCode(), callbackManager, facebookCallback);
    }

    public void registerCallback(CallbackManager callbackManager, FacebookCallback<Result> facebookCallback, int i) {
        setRequestCode(i);
        registerCallback(callbackManager, facebookCallback);
    }

    protected void configureButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super.configureButton(context, attributeSet, i, i2);
        setInternalOnClickListener(getShareOnClickListener());
    }

    protected boolean canShare() {
        return getDialog().canShow(getShareContent());
    }

    protected OnClickListener getShareOnClickListener() {
        return new C14961();
    }

    private void internalSetEnabled(boolean z) {
        setEnabled(z);
        this.enabledExplicitlySet = false;
    }
}
