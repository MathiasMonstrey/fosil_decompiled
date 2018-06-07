package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fossil.duj;

public class TextObject extends BaseMediaObject {
    public static final Creator<TextObject> CREATOR = new C50441();
    public String text;

    class C50441 implements Creator<TextObject> {
        C50441() {
        }

        public TextObject createFromParcel(Parcel parcel) {
            return new TextObject(parcel);
        }

        public TextObject[] newArray(int i) {
            return new TextObject[i];
        }
    }

    public TextObject(Parcel parcel) {
        this.text = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.text);
    }

    public boolean checkArgs() {
        if (this.text != null && this.text.length() != 0 && this.text.length() <= 1024) {
            return true;
        }
        duj.e("Weibo.TextObject", "checkArgs fail, text is invalid");
        return false;
    }

    public int getObjType() {
        return 1;
    }

    protected BaseMediaObject toExtraMediaObject(String str) {
        return this;
    }

    protected String toExtraMediaString() {
        return "";
    }
}
