package com.portfolio.platform.view;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.e;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.fossil.jj;
import com.fossil.jl;
import com.fossil.la;
import java.util.Map;

public class RTLViewPager extends ViewPager {
    private final Map<e, C5019d> dmf = new jl(1);
    private DataSetObserver dmg;
    private boolean dmh;

    class C5016a extends la {
        private final la dmi;
        final /* synthetic */ RTLViewPager dmj;

        protected C5016a(RTLViewPager rTLViewPager, la laVar) {
            this.dmj = rTLViewPager;
            this.dmi = laVar;
        }

        public la awa() {
            return this.dmi;
        }

        public int getCount() {
            return this.dmi.getCount();
        }

        public boolean m15980a(View view, Object obj) {
            return this.dmi.a(view, obj);
        }

        public CharSequence bo(int i) {
            return this.dmi.bo(i);
        }

        public float bp(int i) {
            return this.dmi.bp(i);
        }

        public int ae(Object obj) {
            return this.dmi.ae(obj);
        }

        public Object mo5432d(ViewGroup viewGroup, int i) {
            return this.dmi.d(viewGroup, i);
        }

        public void mo5427a(ViewGroup viewGroup, int i, Object obj) {
            this.dmi.a(viewGroup, i, obj);
        }

        public void mo5429b(ViewGroup viewGroup, int i, Object obj) {
            this.dmi.b(viewGroup, i, obj);
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.dmi.registerDataSetObserver(dataSetObserver);
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.dmi.unregisterDataSetObserver(dataSetObserver);
        }

        public Parcelable ip() {
            return this.dmi.ip();
        }

        public void m15978a(Parcelable parcelable, ClassLoader classLoader) {
            this.dmi.a(parcelable, classLoader);
        }

        public void m15983e(ViewGroup viewGroup) {
            this.dmi.e(viewGroup);
        }

        public void m15984f(ViewGroup viewGroup) {
            this.dmi.f(viewGroup);
        }
    }

    static class C5017b extends DataSetObserver {
        private final C5018c dmk;

        private C5017b(C5018c c5018c) {
            this.dmk = c5018c;
        }

        public void onChanged() {
            super.onChanged();
            this.dmk.awb();
        }
    }

    class C5018c extends C5016a {
        final /* synthetic */ RTLViewPager dmj;
        private int dml;

        public C5018c(RTLViewPager rTLViewPager, la laVar) {
            this.dmj = rTLViewPager;
            super(rTLViewPager, laVar);
            this.dml = laVar.getCount();
        }

        public CharSequence bo(int i) {
            return super.bo(reverse(i));
        }

        public float bp(int i) {
            return super.bp(reverse(i));
        }

        public int ae(Object obj) {
            int ae = super.ae(obj);
            return ae < 0 ? ae : reverse(ae);
        }

        public Object mo5432d(ViewGroup viewGroup, int i) {
            return super.mo5432d(viewGroup, reverse(i));
        }

        public void mo5427a(ViewGroup viewGroup, int i, Object obj) {
            super.mo5427a(viewGroup, reverse(i), obj);
        }

        public void mo5429b(ViewGroup viewGroup, int i, Object obj) {
            super.mo5429b(viewGroup, (this.dml - i) - 1, obj);
        }

        private int reverse(int i) {
            return (getCount() - i) - 1;
        }

        private void awb() {
            int count = getCount();
            if (count != this.dml) {
                this.dmj.setCurrentItemWithoutNotification(Math.max(0, this.dml - 1));
                this.dml = count;
            }
        }
    }

    class C5019d implements e {
        final /* synthetic */ RTLViewPager dmj;
        private final e dmm;
        private int dmn;

        private C5019d(RTLViewPager rTLViewPager, e eVar) {
            this.dmj = rTLViewPager;
            this.dmm = eVar;
            this.dmn = -1;
        }

        public void m15989a(int i, float f, int i2) {
            if (!this.dmj.dmh) {
                if (f == 0.0f && i2 == 0) {
                    this.dmn = reverse(i);
                } else {
                    this.dmn = reverse(i + 1);
                }
                e eVar = this.dmm;
                int i3 = this.dmn;
                if (f > 0.0f) {
                    f = 1.0f - f;
                }
                eVar.a(i3, f, i2);
            }
        }

        public void ar(int i) {
            if (!this.dmj.dmh) {
                this.dmm.ar(reverse(i));
            }
        }

        public void aq(int i) {
            if (!this.dmj.dmh) {
                this.dmm.aq(i);
            }
        }

        private int reverse(int i) {
            la adapter = this.dmj.getAdapter();
            return adapter == null ? i : (adapter.getCount() - i) - 1;
        }
    }

    public static class C5021e implements Parcelable {
        public static final ClassLoaderCreator<C5021e> CREATOR = new C50201();
        Parcelable dmo;
        boolean dmp;
        int position;

        static class C50201 implements ClassLoaderCreator<C5021e> {
            C50201() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m15990D(parcel);
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return m15991p(parcel, classLoader);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return lP(i);
            }

            public C5021e m15991p(Parcel parcel, ClassLoader classLoader) {
                return new C5021e(parcel, classLoader);
            }

            public C5021e m15990D(Parcel parcel) {
                return new C5021e(parcel, null);
            }

            public C5021e[] lP(int i) {
                return new C5021e[i];
            }
        }

        public C5021e(Parcelable parcelable, int i, boolean z) {
            this.dmo = parcelable;
            this.position = i;
            this.dmp = z;
        }

        C5021e(Parcel parcel, ClassLoader classLoader) {
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.dmo = parcel.readParcelable(classLoader);
            this.position = parcel.readInt();
            this.dmp = parcel.readByte() != (byte) 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.dmo, i);
            parcel.writeInt(this.position);
            parcel.writeByte(this.dmp ? (byte) 1 : (byte) 0);
        }

        public int describeContents() {
            return 0;
        }
    }

    public RTLViewPager(Context context) {
        super(context);
    }

    public RTLViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m15992a(super.getAdapter());
    }

    protected void onDetachedFromWindow() {
        avY();
        super.onDetachedFromWindow();
    }

    private void m15992a(la laVar) {
        if ((laVar instanceof C5018c) && this.dmg == null) {
            this.dmg = new C5017b((C5018c) laVar);
            laVar.registerDataSetObserver(this.dmg);
            ((C5018c) laVar).awb();
        }
    }

    private void avY() {
        la adapter = super.getAdapter();
        if ((adapter instanceof C5018c) && this.dmg != null) {
            adapter.unregisterDataSetObserver(this.dmg);
            this.dmg = null;
        }
    }

    public void m15997e(int i, boolean z) {
        super.e(lO(i), z);
    }

    public void setCurrentItem(int i) {
        super.setCurrentItem(lO(i));
    }

    public int getCurrentItem() {
        return lO(super.getCurrentItem());
    }

    private int lO(int i) {
        if (i < 0 || !avZ()) {
            return i;
        }
        return getAdapter() == null ? 0 : (getAdapter().getCount() - i) - 1;
    }

    public la getAdapter() {
        la adapter = super.getAdapter();
        return adapter instanceof C5018c ? ((C5018c) adapter).awa() : adapter;
    }

    public void m15998x(float f) {
        if (!avZ()) {
            f = -f;
        }
        super.x(f);
    }

    public void setAdapter(la laVar) {
        avY();
        int i = (laVar == null || !avZ()) ? 0 : 1;
        if (i != 0) {
            la c5018c = new C5018c(this, laVar);
            m15992a(c5018c);
            laVar = c5018c;
        }
        super.setAdapter(laVar);
        if (i != 0) {
            setCurrentItemWithoutNotification(0);
        }
    }

    private void setCurrentItemWithoutNotification(int i) {
        this.dmh = true;
        m15997e(i, false);
        this.dmh = false;
    }

    protected boolean avZ() {
        return jj.getLayoutDirectionFromLocale(getContext().getResources().getConfiguration().locale) == 1;
    }

    public void m15995a(e eVar) {
        if (avZ()) {
            C5019d c5019d = new C5019d(eVar);
            this.dmf.put(eVar, c5019d);
            eVar = c5019d;
        }
        super.a(eVar);
    }

    public void m15996b(e eVar) {
        e eVar2;
        if (avZ()) {
            eVar2 = (e) this.dmf.remove(eVar);
        } else {
            eVar2 = eVar;
        }
        super.b(eVar2);
    }

    public Parcelable onSaveInstanceState() {
        return new C5021e(super.onSaveInstanceState(), getCurrentItem(), avZ());
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        C5021e c5021e = (C5021e) parcelable;
        super.onRestoreInstanceState(c5021e.dmo);
        if (c5021e.dmp != avZ()) {
            m15997e(c5021e.position, false);
        }
    }
}
