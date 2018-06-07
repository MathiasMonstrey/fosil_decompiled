package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ShareOpenGraphAction extends ShareOpenGraphValueContainer<ShareOpenGraphAction, Builder> {
    public static final Creator<ShareOpenGraphAction> CREATOR = new C14751();

    static class C14751 implements Creator<ShareOpenGraphAction> {
        C14751() {
        }

        public ShareOpenGraphAction createFromParcel(Parcel parcel) {
            return new ShareOpenGraphAction(parcel);
        }

        public ShareOpenGraphAction[] newArray(int i) {
            return new ShareOpenGraphAction[i];
        }
    }

    public static final class Builder extends com.facebook.share.model.ShareOpenGraphValueContainer.Builder<ShareOpenGraphAction, Builder> {
        private static final String ACTION_TYPE_KEY = "og:type";

        public Builder setActionType(String str) {
            putString(ACTION_TYPE_KEY, str);
            return this;
        }

        public ShareOpenGraphAction build() {
            return new ShareOpenGraphAction();
        }

        public Builder readFrom(ShareOpenGraphAction shareOpenGraphAction) {
            return shareOpenGraphAction == null ? this : ((Builder) super.readFrom((ShareOpenGraphValueContainer) shareOpenGraphAction)).setActionType(shareOpenGraphAction.getActionType());
        }

        Builder readFrom(Parcel parcel) {
            return readFrom((ShareOpenGraphAction) parcel.readParcelable(ShareOpenGraphAction.class.getClassLoader()));
        }
    }

    private ShareOpenGraphAction(Builder builder) {
        super((com.facebook.share.model.ShareOpenGraphValueContainer.Builder) builder);
    }

    ShareOpenGraphAction(Parcel parcel) {
        super(parcel);
    }

    public String getActionType() {
        return getString("og:type");
    }
}
