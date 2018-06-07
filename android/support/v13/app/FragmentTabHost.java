package android.support.v13.app;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabWidget;
import java.util.ArrayList;

@TargetApi(13)
public class FragmentTabHost extends TabHost implements OnTabChangeListener {
    private final ArrayList<C1134b> AQ = new ArrayList();
    private FrameLayout Hj;
    private FragmentManager Hk;
    private OnTabChangeListener Hl;
    private C1134b Hm;
    private boolean Hn;
    private int mContainerId;
    private Context mContext;

    static class C1133a extends BaseSavedState {
        public static final Creator<C1133a> CREATOR = new C11321();
        String Ho;

        static class C11321 implements Creator<C1133a> {
            C11321() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m1977d(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return aA(i);
            }

            public C1133a m1977d(Parcel parcel) {
                return new C1133a(parcel);
            }

            public C1133a[] aA(int i) {
                return new C1133a[i];
            }
        }

        C1133a(Parcelable parcelable) {
            super(parcelable);
        }

        C1133a(Parcel parcel) {
            super(parcel);
            this.Ho = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.Ho);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.Ho + "}";
        }
    }

    static final class C1134b {
        final Class<?> Hp;
        final Bundle Hq;
        Fragment Hr;
        final String tag;
    }

    public FragmentTabHost(Context context) {
        super(context, null);
        m1979c(context, null);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1979c(context, attributeSet);
    }

    private void m1979c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
        this.mContainerId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    private void m1980l(Context context) {
        if (findViewById(16908307) == null) {
            View linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            addView(linearLayout, new LayoutParams(-1, -1));
            View tabWidget = new TabWidget(context);
            tabWidget.setId(16908307);
            tabWidget.setOrientation(0);
            linearLayout.addView(tabWidget, new LinearLayout.LayoutParams(-1, -2, 0.0f));
            tabWidget = new FrameLayout(context);
            tabWidget.setId(16908305);
            linearLayout.addView(tabWidget, new LinearLayout.LayoutParams(0, 0, 0.0f));
            tabWidget = new FrameLayout(context);
            this.Hj = tabWidget;
            this.Hj.setId(this.mContainerId);
            linearLayout.addView(tabWidget, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    public void m1981a(Context context, FragmentManager fragmentManager) {
        m1980l(context);
        super.setup();
        this.mContext = context;
        this.Hk = fragmentManager;
        hF();
    }

    public void m1982a(Context context, FragmentManager fragmentManager, int i) {
        m1980l(context);
        super.setup();
        this.mContext = context;
        this.Hk = fragmentManager;
        this.mContainerId = i;
        hF();
        this.Hj.setId(i);
        if (getId() == -1) {
            setId(16908306);
        }
    }

    private void hF() {
        if (this.Hj == null) {
            this.Hj = (FrameLayout) findViewById(this.mContainerId);
            if (this.Hj == null) {
                throw new IllegalStateException("No tab content FrameLayout found for id " + this.mContainerId);
            }
        }
    }

    public void setOnTabChangedListener(OnTabChangeListener onTabChangeListener) {
        this.Hl = onTabChangeListener;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        FragmentTransaction fragmentTransaction = null;
        for (int i = 0; i < this.AQ.size(); i++) {
            C1134b c1134b = (C1134b) this.AQ.get(i);
            c1134b.Hr = this.Hk.findFragmentByTag(c1134b.tag);
            if (!(c1134b.Hr == null || c1134b.Hr.isDetached())) {
                if (c1134b.tag.equals(currentTabTag)) {
                    this.Hm = c1134b;
                } else {
                    if (fragmentTransaction == null) {
                        fragmentTransaction = this.Hk.beginTransaction();
                    }
                    fragmentTransaction.detach(c1134b.Hr);
                }
            }
        }
        this.Hn = true;
        FragmentTransaction a = m1978a(currentTabTag, fragmentTransaction);
        if (a != null) {
            a.commit();
            this.Hk.executePendingTransactions();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.Hn = false;
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable c1133a = new C1133a(super.onSaveInstanceState());
        c1133a.Ho = getCurrentTabTag();
        return c1133a;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C1133a) {
            C1133a c1133a = (C1133a) parcelable;
            super.onRestoreInstanceState(c1133a.getSuperState());
            setCurrentTabByTag(c1133a.Ho);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void onTabChanged(String str) {
        if (this.Hn) {
            FragmentTransaction a = m1978a(str, null);
            if (a != null) {
                a.commit();
            }
        }
        if (this.Hl != null) {
            this.Hl.onTabChanged(str);
        }
    }

    private FragmentTransaction m1978a(String str, FragmentTransaction fragmentTransaction) {
        C1134b c1134b = null;
        int i = 0;
        while (i < this.AQ.size()) {
            C1134b c1134b2 = (C1134b) this.AQ.get(i);
            if (!c1134b2.tag.equals(str)) {
                c1134b2 = c1134b;
            }
            i++;
            c1134b = c1134b2;
        }
        if (c1134b == null) {
            throw new IllegalStateException("No tab known for tag " + str);
        }
        if (this.Hm != c1134b) {
            if (fragmentTransaction == null) {
                fragmentTransaction = this.Hk.beginTransaction();
            }
            if (!(this.Hm == null || this.Hm.Hr == null)) {
                fragmentTransaction.detach(this.Hm.Hr);
            }
            if (c1134b != null) {
                if (c1134b.Hr == null) {
                    c1134b.Hr = Fragment.instantiate(this.mContext, c1134b.Hp.getName(), c1134b.Hq);
                    fragmentTransaction.add(this.mContainerId, c1134b.Hr, c1134b.tag);
                } else {
                    fragmentTransaction.attach(c1134b.Hr);
                }
            }
            this.Hm = c1134b;
        }
        return fragmentTransaction;
    }
}
