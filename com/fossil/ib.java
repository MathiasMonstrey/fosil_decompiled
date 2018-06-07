package com.fossil;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;

@TargetApi(21)
class ib {

    static class C3692a {
        public static Object newInstance() {
            return new Builder();
        }

        public static void m11730c(Object obj, String str) {
            ((Builder) obj).setMediaId(str);
        }

        public static void m11727a(Object obj, CharSequence charSequence) {
            ((Builder) obj).setTitle(charSequence);
        }

        public static void m11728b(Object obj, CharSequence charSequence) {
            ((Builder) obj).setSubtitle(charSequence);
        }

        public static void m11729c(Object obj, CharSequence charSequence) {
            ((Builder) obj).setDescription(charSequence);
        }

        public static void m11724a(Object obj, Bitmap bitmap) {
            ((Builder) obj).setIconBitmap(bitmap);
        }

        public static void m11725a(Object obj, Uri uri) {
            ((Builder) obj).setIconUri(uri);
        }

        public static void m11726a(Object obj, Bundle bundle) {
            ((Builder) obj).setExtras(bundle);
        }

        public static Object m11731z(Object obj) {
            return ((Builder) obj).build();
        }
    }

    public static String m11733s(Object obj) {
        return ((MediaDescription) obj).getMediaId();
    }

    public static CharSequence m11734t(Object obj) {
        return ((MediaDescription) obj).getTitle();
    }

    public static CharSequence m11735u(Object obj) {
        return ((MediaDescription) obj).getSubtitle();
    }

    public static CharSequence m11736v(Object obj) {
        return ((MediaDescription) obj).getDescription();
    }

    public static Bitmap m11737w(Object obj) {
        return ((MediaDescription) obj).getIconBitmap();
    }

    public static Uri m11738x(Object obj) {
        return ((MediaDescription) obj).getIconUri();
    }

    public static Bundle m11739y(Object obj) {
        return ((MediaDescription) obj).getExtras();
    }

    public static void m11732a(Object obj, Parcel parcel, int i) {
        ((MediaDescription) obj).writeToParcel(parcel, i);
    }

    public static Object fromParcel(Parcel parcel) {
        return MediaDescription.CREATOR.createFromParcel(parcel);
    }
}
