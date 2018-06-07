package com.fossil;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.internal.BottomNavigationMenuView;
import com.fossil.qq.a;

public class ak implements qq {
    private int mId;
    private qj uh;
    private BottomNavigationMenuView uj;
    private boolean uk = false;

    static class C1665a implements Parcelable {
        public static final Creator<C1665a> CREATOR = new C16641();
        int ul;

        static class C16641 implements Creator<C1665a> {
            C16641() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m3624c(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m3623C(i);
            }

            public C1665a m3624c(Parcel parcel) {
                return new C1665a(parcel);
            }

            public C1665a[] m3623C(int i) {
                return new C1665a[i];
            }
        }

        C1665a() {
        }

        C1665a(Parcel parcel) {
            this.ul = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.ul);
        }
    }

    public void m3631c(BottomNavigationMenuView bottomNavigationMenuView) {
        this.uj = bottomNavigationMenuView;
    }

    public void m3625a(Context context, qj qjVar) {
        this.uj.m1683a(this.uh);
        this.uh = qjVar;
    }

    public void m3632g(boolean z) {
        if (!this.uk) {
            if (z) {
                this.uj.eU();
            } else {
                this.uj.eV();
            }
        }
    }

    public void m3627a(a aVar) {
    }

    public boolean m3629a(qw qwVar) {
        return false;
    }

    public void m3626a(qj qjVar, boolean z) {
    }

    public boolean eW() {
        return false;
    }

    public boolean m3628a(qj qjVar, ql qlVar) {
        return false;
    }

    public boolean m3630b(qj qjVar, ql qlVar) {
        return false;
    }

    public void setId(int i) {
        this.mId = i;
    }

    public int getId() {
        return this.mId;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable c1665a = new C1665a();
        c1665a.ul = this.uj.getSelectedItemId();
        return c1665a;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C1665a) {
            this.uj.m1682B(((C1665a) parcelable).ul);
        }
    }

    public void m3633h(boolean z) {
        this.uk = z;
    }
}
