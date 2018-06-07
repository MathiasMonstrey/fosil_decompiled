package com.fossil;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class id implements Parcelable {
    public static final Creator<id> CREATOR = new C36941();
    static final jl<String, Integer> Ok = new jl();
    private static final String[] Ol = new String[]{"android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER"};
    private static final String[] Om = new String[]{"android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART"};
    private static final String[] On = new String[]{"android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI"};
    final Bundle Oo;
    private Object Op;

    static class C36941 implements Creator<id> {
        C36941() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m11742l(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return aU(i);
        }

        public id m11742l(Parcel parcel) {
            return new id(parcel);
        }

        public id[] aU(int i) {
            return new id[i];
        }
    }

    static {
        Ok.put("android.media.metadata.TITLE", Integer.valueOf(1));
        Ok.put("android.media.metadata.ARTIST", Integer.valueOf(1));
        Ok.put("android.media.metadata.DURATION", Integer.valueOf(0));
        Ok.put("android.media.metadata.ALBUM", Integer.valueOf(1));
        Ok.put("android.media.metadata.AUTHOR", Integer.valueOf(1));
        Ok.put("android.media.metadata.WRITER", Integer.valueOf(1));
        Ok.put("android.media.metadata.COMPOSER", Integer.valueOf(1));
        Ok.put("android.media.metadata.COMPILATION", Integer.valueOf(1));
        Ok.put("android.media.metadata.DATE", Integer.valueOf(1));
        Ok.put("android.media.metadata.YEAR", Integer.valueOf(0));
        Ok.put("android.media.metadata.GENRE", Integer.valueOf(1));
        Ok.put("android.media.metadata.TRACK_NUMBER", Integer.valueOf(0));
        Ok.put("android.media.metadata.NUM_TRACKS", Integer.valueOf(0));
        Ok.put("android.media.metadata.DISC_NUMBER", Integer.valueOf(0));
        Ok.put("android.media.metadata.ALBUM_ARTIST", Integer.valueOf(1));
        Ok.put("android.media.metadata.ART", Integer.valueOf(2));
        Ok.put("android.media.metadata.ART_URI", Integer.valueOf(1));
        Ok.put("android.media.metadata.ALBUM_ART", Integer.valueOf(2));
        Ok.put("android.media.metadata.ALBUM_ART_URI", Integer.valueOf(1));
        Ok.put("android.media.metadata.USER_RATING", Integer.valueOf(3));
        Ok.put("android.media.metadata.RATING", Integer.valueOf(3));
        Ok.put("android.media.metadata.DISPLAY_TITLE", Integer.valueOf(1));
        Ok.put("android.media.metadata.DISPLAY_SUBTITLE", Integer.valueOf(1));
        Ok.put("android.media.metadata.DISPLAY_DESCRIPTION", Integer.valueOf(1));
        Ok.put("android.media.metadata.DISPLAY_ICON", Integer.valueOf(2));
        Ok.put("android.media.metadata.DISPLAY_ICON_URI", Integer.valueOf(1));
        Ok.put("android.media.metadata.MEDIA_ID", Integer.valueOf(1));
        Ok.put("android.media.metadata.BT_FOLDER_TYPE", Integer.valueOf(0));
        Ok.put("android.media.metadata.MEDIA_URI", Integer.valueOf(1));
        Ok.put("android.media.metadata.ADVERTISEMENT", Integer.valueOf(0));
    }

    id(Parcel parcel) {
        this.Oo = parcel.readBundle();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.Oo);
    }

    public static id m11743B(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        ie.m11744a(obj, obtain, 0);
        obtain.setDataPosition(0);
        id idVar = (id) CREATOR.createFromParcel(obtain);
        obtain.recycle();
        idVar.Op = obj;
        return idVar;
    }
}
