package com.fossil;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.fossil.ib.C3692a;
import com.fossil.ic.C3693a;

public final class ia implements Parcelable {
    public static final Creator<ia> CREATOR = new C36901();
    private final Bundle KV;
    private final String Oc;
    private final CharSequence Od;
    private final CharSequence Oe;
    private final CharSequence Of;
    private final Bitmap Og;
    private final Uri Oh;
    private final Uri Oi;
    private Object Oj;

    static class C36901 implements Creator<ia> {
        C36901() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m11715k(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return aT(i);
        }

        public ia m11715k(Parcel parcel) {
            if (VERSION.SDK_INT < 21) {
                return new ia(parcel);
            }
            return ia.m11723r(ib.fromParcel(parcel));
        }

        public ia[] aT(int i) {
            return new ia[i];
        }
    }

    public static final class C3691a {
        private Bundle KV;
        private String Oc;
        private CharSequence Od;
        private CharSequence Oe;
        private CharSequence Of;
        private Bitmap Og;
        private Uri Oh;
        private Uri Oi;

        public C3691a aa(String str) {
            this.Oc = str;
            return this;
        }

        public C3691a m11720i(CharSequence charSequence) {
            this.Od = charSequence;
            return this;
        }

        public C3691a m11721j(CharSequence charSequence) {
            this.Oe = charSequence;
            return this;
        }

        public C3691a m11722k(CharSequence charSequence) {
            this.Of = charSequence;
            return this;
        }

        public C3691a m11716b(Bitmap bitmap) {
            this.Og = bitmap;
            return this;
        }

        public C3691a m11717c(Uri uri) {
            this.Oh = uri;
            return this;
        }

        public C3691a m11719g(Bundle bundle) {
            this.KV = bundle;
            return this;
        }

        public C3691a m11718d(Uri uri) {
            this.Oi = uri;
            return this;
        }

        public ia iS() {
            return new ia(this.Oc, this.Od, this.Oe, this.Of, this.Og, this.Oh, this.KV, this.Oi);
        }
    }

    ia(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.Oc = str;
        this.Od = charSequence;
        this.Oe = charSequence2;
        this.Of = charSequence3;
        this.Og = bitmap;
        this.Oh = uri;
        this.KV = bundle;
        this.Oi = uri2;
    }

    ia(Parcel parcel) {
        this.Oc = parcel.readString();
        this.Od = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.Oe = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.Of = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.Og = (Bitmap) parcel.readParcelable(null);
        this.Oh = (Uri) parcel.readParcelable(null);
        this.KV = parcel.readBundle();
        this.Oi = (Uri) parcel.readParcelable(null);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (VERSION.SDK_INT < 21) {
            parcel.writeString(this.Oc);
            TextUtils.writeToParcel(this.Od, parcel, i);
            TextUtils.writeToParcel(this.Oe, parcel, i);
            TextUtils.writeToParcel(this.Of, parcel, i);
            parcel.writeParcelable(this.Og, i);
            parcel.writeParcelable(this.Oh, i);
            parcel.writeBundle(this.KV);
            parcel.writeParcelable(this.Oi, i);
            return;
        }
        ib.m11732a(iR(), parcel, i);
    }

    public String toString() {
        return this.Od + ", " + this.Oe + ", " + this.Of;
    }

    public Object iR() {
        if (this.Oj != null || VERSION.SDK_INT < 21) {
            return this.Oj;
        }
        Object newInstance = C3692a.newInstance();
        C3692a.m11730c(newInstance, this.Oc);
        C3692a.m11727a(newInstance, this.Od);
        C3692a.m11728b(newInstance, this.Oe);
        C3692a.m11729c(newInstance, this.Of);
        C3692a.m11724a(newInstance, this.Og);
        C3692a.m11725a(newInstance, this.Oh);
        Bundle bundle = this.KV;
        if (VERSION.SDK_INT < 23 && this.Oi != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            }
            bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.Oi);
        }
        C3692a.m11726a(newInstance, bundle);
        if (VERSION.SDK_INT >= 23) {
            C3693a.m11740b(newInstance, this.Oi);
        }
        this.Oj = C3692a.m11731z(newInstance);
        return this.Oj;
    }

    public static ia m11723r(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        Uri uri;
        Bundle bundle;
        ia iS;
        C3691a c3691a = new C3691a();
        c3691a.aa(ib.m11733s(obj));
        c3691a.m11720i(ib.m11734t(obj));
        c3691a.m11721j(ib.m11735u(obj));
        c3691a.m11722k(ib.m11736v(obj));
        c3691a.m11716b(ib.m11737w(obj));
        c3691a.m11717c(ib.m11738x(obj));
        Bundle y = ib.m11739y(obj);
        if (y == null) {
            uri = null;
        } else {
            uri = (Uri) y.getParcelable("android.support.v4.media.description.MEDIA_URI");
        }
        if (uri != null) {
            if (y.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && y.size() == 2) {
                bundle = null;
                c3691a.m11719g(bundle);
                if (uri != null) {
                    c3691a.m11718d(uri);
                } else if (VERSION.SDK_INT >= 23) {
                    c3691a.m11718d(ic.m11741A(obj));
                }
                iS = c3691a.iS();
                iS.Oj = obj;
                return iS;
            }
            y.remove("android.support.v4.media.description.MEDIA_URI");
            y.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
        }
        bundle = y;
        c3691a.m11719g(bundle);
        if (uri != null) {
            c3691a.m11718d(uri);
        } else if (VERSION.SDK_INT >= 23) {
            c3691a.m11718d(ic.m11741A(obj));
        }
        iS = c3691a.iS();
        iS.Oj = obj;
        return iS;
    }
}
