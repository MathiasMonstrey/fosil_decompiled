package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ShareVideoContent extends ShareContent<ShareVideoContent, Builder> implements ShareModel {
    public static final Creator<ShareVideoContent> CREATOR = new C14811();
    private final String contentDescription;
    private final String contentTitle;
    private final SharePhoto previewPhoto;
    private final ShareVideo video;

    static class C14811 implements Creator<ShareVideoContent> {
        C14811() {
        }

        public ShareVideoContent createFromParcel(Parcel parcel) {
            return new ShareVideoContent(parcel);
        }

        public ShareVideoContent[] newArray(int i) {
            return new ShareVideoContent[i];
        }
    }

    public static final class Builder extends com.facebook.share.model.ShareContent.Builder<ShareVideoContent, Builder> {
        private String contentDescription;
        private String contentTitle;
        private SharePhoto previewPhoto;
        private ShareVideo video;

        public Builder setContentDescription(String str) {
            this.contentDescription = str;
            return this;
        }

        public Builder setContentTitle(String str) {
            this.contentTitle = str;
            return this;
        }

        public Builder setPreviewPhoto(SharePhoto sharePhoto) {
            this.previewPhoto = sharePhoto == null ? null : new com.facebook.share.model.SharePhoto.Builder().readFrom(sharePhoto).build();
            return this;
        }

        public Builder setVideo(ShareVideo shareVideo) {
            if (shareVideo != null) {
                this.video = new com.facebook.share.model.ShareVideo.Builder().readFrom(shareVideo).build();
            }
            return this;
        }

        public ShareVideoContent build() {
            return new ShareVideoContent();
        }

        public Builder readFrom(ShareVideoContent shareVideoContent) {
            return shareVideoContent == null ? this : ((Builder) super.readFrom((ShareContent) shareVideoContent)).setContentDescription(shareVideoContent.getContentDescription()).setContentTitle(shareVideoContent.getContentTitle()).setPreviewPhoto(shareVideoContent.getPreviewPhoto()).setVideo(shareVideoContent.getVideo());
        }
    }

    private ShareVideoContent(Builder builder) {
        super((com.facebook.share.model.ShareContent.Builder) builder);
        this.contentDescription = builder.contentDescription;
        this.contentTitle = builder.contentTitle;
        this.previewPhoto = builder.previewPhoto;
        this.video = builder.video;
    }

    ShareVideoContent(Parcel parcel) {
        super(parcel);
        this.contentDescription = parcel.readString();
        this.contentTitle = parcel.readString();
        com.facebook.share.model.SharePhoto.Builder readFrom = new com.facebook.share.model.SharePhoto.Builder().readFrom(parcel);
        if (readFrom.getImageUrl() == null && readFrom.getBitmap() == null) {
            this.previewPhoto = null;
        } else {
            this.previewPhoto = readFrom.build();
        }
        this.video = new com.facebook.share.model.ShareVideo.Builder().readFrom(parcel).build();
    }

    public String getContentDescription() {
        return this.contentDescription;
    }

    public String getContentTitle() {
        return this.contentTitle;
    }

    public SharePhoto getPreviewPhoto() {
        return this.previewPhoto;
    }

    public ShareVideo getVideo() {
        return this.video;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.contentDescription);
        parcel.writeString(this.contentTitle);
        parcel.writeParcelable(this.previewPhoto, 0);
        parcel.writeParcelable(this.video, 0);
    }
}
