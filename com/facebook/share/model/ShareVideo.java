package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareMedia.Type;

public final class ShareVideo extends ShareMedia {
    public static final Creator<ShareVideo> CREATOR = new C14801();
    private final Uri localUrl;

    static class C14801 implements Creator<ShareVideo> {
        C14801() {
        }

        public ShareVideo createFromParcel(Parcel parcel) {
            return new ShareVideo(parcel);
        }

        public ShareVideo[] newArray(int i) {
            return new ShareVideo[i];
        }
    }

    public static final class Builder extends com.facebook.share.model.ShareMedia.Builder<ShareVideo, Builder> {
        private Uri localUrl;

        public Builder setLocalUrl(Uri uri) {
            this.localUrl = uri;
            return this;
        }

        public ShareVideo build() {
            return new ShareVideo();
        }

        public Builder readFrom(ShareVideo shareVideo) {
            return shareVideo == null ? this : ((Builder) super.readFrom((ShareMedia) shareVideo)).setLocalUrl(shareVideo.getLocalUrl());
        }

        Builder readFrom(Parcel parcel) {
            return readFrom((ShareVideo) parcel.readParcelable(ShareVideo.class.getClassLoader()));
        }
    }

    private ShareVideo(Builder builder) {
        super((com.facebook.share.model.ShareMedia.Builder) builder);
        this.localUrl = builder.localUrl;
    }

    ShareVideo(Parcel parcel) {
        super(parcel);
        this.localUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
    }

    public Uri getLocalUrl() {
        return this.localUrl;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.localUrl, 0);
    }

    public Type getMediaType() {
        return Type.VIDEO;
    }
}
