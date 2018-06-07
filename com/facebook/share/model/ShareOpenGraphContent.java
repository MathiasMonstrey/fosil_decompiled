package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ShareOpenGraphContent extends ShareContent<ShareOpenGraphContent, Builder> {
    public static final Creator<ShareOpenGraphContent> CREATOR = new C14761();
    private final ShareOpenGraphAction action;
    private final String previewPropertyName;

    static class C14761 implements Creator<ShareOpenGraphContent> {
        C14761() {
        }

        public ShareOpenGraphContent createFromParcel(Parcel parcel) {
            return new ShareOpenGraphContent(parcel);
        }

        public ShareOpenGraphContent[] newArray(int i) {
            return new ShareOpenGraphContent[i];
        }
    }

    public static final class Builder extends com.facebook.share.model.ShareContent.Builder<ShareOpenGraphContent, Builder> {
        private ShareOpenGraphAction action;
        private String previewPropertyName;

        public Builder setAction(ShareOpenGraphAction shareOpenGraphAction) {
            this.action = shareOpenGraphAction == null ? null : new com.facebook.share.model.ShareOpenGraphAction.Builder().readFrom(shareOpenGraphAction).build();
            return this;
        }

        public Builder setPreviewPropertyName(String str) {
            this.previewPropertyName = str;
            return this;
        }

        public ShareOpenGraphContent build() {
            return new ShareOpenGraphContent();
        }

        public Builder readFrom(ShareOpenGraphContent shareOpenGraphContent) {
            return shareOpenGraphContent == null ? this : ((Builder) super.readFrom((ShareContent) shareOpenGraphContent)).setAction(shareOpenGraphContent.getAction()).setPreviewPropertyName(shareOpenGraphContent.getPreviewPropertyName());
        }
    }

    private ShareOpenGraphContent(Builder builder) {
        super((com.facebook.share.model.ShareContent.Builder) builder);
        this.action = builder.action;
        this.previewPropertyName = builder.previewPropertyName;
    }

    ShareOpenGraphContent(Parcel parcel) {
        super(parcel);
        this.action = new com.facebook.share.model.ShareOpenGraphAction.Builder().readFrom(parcel).build();
        this.previewPropertyName = parcel.readString();
    }

    public ShareOpenGraphAction getAction() {
        return this.action;
    }

    public String getPreviewPropertyName() {
        return this.previewPropertyName;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.action, 0);
        parcel.writeString(this.previewPropertyName);
    }
}
