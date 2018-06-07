package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.internal.NativeProtocol;

public final class ShareOpenGraphObject extends ShareOpenGraphValueContainer<ShareOpenGraphObject, Builder> {
    public static final Creator<ShareOpenGraphObject> CREATOR = new C14771();

    static class C14771 implements Creator<ShareOpenGraphObject> {
        C14771() {
        }

        public ShareOpenGraphObject createFromParcel(Parcel parcel) {
            return new ShareOpenGraphObject(parcel);
        }

        public ShareOpenGraphObject[] newArray(int i) {
            return new ShareOpenGraphObject[i];
        }
    }

    public static final class Builder extends com.facebook.share.model.ShareOpenGraphValueContainer.Builder<ShareOpenGraphObject, Builder> {
        public Builder() {
            putBoolean(NativeProtocol.OPEN_GRAPH_CREATE_OBJECT_KEY, true);
        }

        public ShareOpenGraphObject build() {
            return new ShareOpenGraphObject();
        }

        Builder readFrom(Parcel parcel) {
            return (Builder) readFrom((ShareOpenGraphValueContainer) (ShareOpenGraphObject) parcel.readParcelable(ShareOpenGraphObject.class.getClassLoader()));
        }
    }

    private ShareOpenGraphObject(Builder builder) {
        super((com.facebook.share.model.ShareOpenGraphValueContainer.Builder) builder);
    }

    ShareOpenGraphObject(Parcel parcel) {
        super(parcel);
    }
}
