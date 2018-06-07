package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ShareLinkContent extends ShareContent<ShareLinkContent, Builder> {
    public static final Creator<ShareLinkContent> CREATOR = new C14731();
    private final String contentDescription;
    private final String contentTitle;
    private final Uri imageUrl;
    private final String quote;

    static class C14731 implements Creator<ShareLinkContent> {
        C14731() {
        }

        public ShareLinkContent createFromParcel(Parcel parcel) {
            return new ShareLinkContent(parcel);
        }

        public ShareLinkContent[] newArray(int i) {
            return new ShareLinkContent[i];
        }
    }

    public static final class Builder extends com.facebook.share.model.ShareContent.Builder<ShareLinkContent, Builder> {
        private String contentDescription;
        private String contentTitle;
        private Uri imageUrl;
        private String quote;

        public Builder setContentDescription(String str) {
            this.contentDescription = str;
            return this;
        }

        public Builder setContentTitle(String str) {
            this.contentTitle = str;
            return this;
        }

        public Builder setImageUrl(Uri uri) {
            this.imageUrl = uri;
            return this;
        }

        public Builder setQuote(String str) {
            this.quote = str;
            return this;
        }

        public ShareLinkContent build() {
            return new ShareLinkContent();
        }

        public Builder readFrom(ShareLinkContent shareLinkContent) {
            return shareLinkContent == null ? this : ((Builder) super.readFrom((ShareContent) shareLinkContent)).setContentDescription(shareLinkContent.getContentDescription()).setImageUrl(shareLinkContent.getImageUrl()).setContentTitle(shareLinkContent.getContentTitle()).setQuote(shareLinkContent.getQuote());
        }
    }

    private ShareLinkContent(Builder builder) {
        super((com.facebook.share.model.ShareContent.Builder) builder);
        this.contentDescription = builder.contentDescription;
        this.contentTitle = builder.contentTitle;
        this.imageUrl = builder.imageUrl;
        this.quote = builder.quote;
    }

    ShareLinkContent(Parcel parcel) {
        super(parcel);
        this.contentDescription = parcel.readString();
        this.contentTitle = parcel.readString();
        this.imageUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.quote = parcel.readString();
    }

    public String getContentDescription() {
        return this.contentDescription;
    }

    public String getContentTitle() {
        return this.contentTitle;
    }

    public Uri getImageUrl() {
        return this.imageUrl;
    }

    public String getQuote() {
        return this.quote;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.contentDescription);
        parcel.writeString(this.contentTitle);
        parcel.writeParcelable(this.imageUrl, 0);
        parcel.writeString(this.quote);
    }
}
