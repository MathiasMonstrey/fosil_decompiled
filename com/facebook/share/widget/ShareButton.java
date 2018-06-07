package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.C1325R;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.share.Sharer.Result;
import com.facebook.share.model.ShareContent;

public final class ShareButton extends ShareButtonBase {
    public ShareButton(Context context) {
        super(context, null, 0, AnalyticsEvents.EVENT_SHARE_BUTTON_CREATE, AnalyticsEvents.EVENT_SHARE_BUTTON_DID_TAP);
    }

    public ShareButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, AnalyticsEvents.EVENT_SHARE_BUTTON_CREATE, AnalyticsEvents.EVENT_SHARE_BUTTON_DID_TAP);
    }

    public ShareButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, AnalyticsEvents.EVENT_SHARE_BUTTON_CREATE, AnalyticsEvents.EVENT_SHARE_BUTTON_DID_TAP);
    }

    protected int getDefaultStyleResource() {
        return C1325R.style.com_facebook_button_share;
    }

    protected int getDefaultRequestCode() {
        return RequestCodeOffset.Share.toRequestCode();
    }

    protected FacebookDialogBase<ShareContent, Result> getDialog() {
        if (getFragment() != null) {
            return new ShareDialog(getFragment(), getRequestCode());
        }
        if (getNativeFragment() != null) {
            return new ShareDialog(getNativeFragment(), getRequestCode());
        }
        return new ShareDialog(getActivity(), getRequestCode());
    }
}
