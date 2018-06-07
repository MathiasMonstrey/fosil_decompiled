package android.support.v4.app;

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
import com.fossil.fa;
import com.fossil.fg;
import java.util.ArrayList;

public class FragmentTabHost extends TabHost implements OnTabChangeListener {
    private final ArrayList<C1141b> AQ = new ArrayList();
    private FrameLayout Hj;
    private OnTabChangeListener Hl;
    private boolean Hn;
    private fa JV;
    private C1141b Ka;
    private int mContainerId;
    private Context mContext;

    static class C1140a extends BaseSavedState {
        public static final Creator<C1140a> CREATOR = new C11391();
        String Ho;

        static class C11391 implements Creator<C1140a> {
            C11391() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m2000i(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return aM(i);
            }

            public C1140a m2000i(Parcel parcel) {
                return new C1140a(parcel);
            }

            public C1140a[] aM(int i) {
                return new C1140a[i];
            }
        }

        C1140a(Parcelable parcelable) {
            super(parcelable);
        }

        C1140a(Parcel parcel) {
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

    static final class C1141b {
        final Class<?> Hp;
        final Bundle Hq;
        Fragment fragment;
        final String tag;
    }

    public FragmentTabHost(Context context) {
        super(context, null);
        m2003c(context, null);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m2003c(context, attributeSet);
    }

    private void m2003c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
        this.mContainerId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    private void m2004l(Context context) {
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

    public void m2005a(Context context, fa faVar) {
        m2004l(context);
        super.setup();
        this.mContext = context;
        this.JV = faVar;
        hF();
    }

    public void m2006a(Context context, fa faVar, int i) {
        m2004l(context);
        super.setup();
        this.mContext = context;
        this.JV = faVar;
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
        fg fgVar = null;
        int size = this.AQ.size();
        for (int i = 0; i < size; i++) {
            C1141b c1141b = (C1141b) this.AQ.get(i);
            c1141b.fragment = this.JV.mo3086W(c1141b.tag);
            if (!(c1141b.fragment == null || c1141b.fragment.isDetached())) {
                if (c1141b.tag.equals(currentTabTag)) {
                    this.Ka = c1141b;
                } else {
                    if (fgVar == null) {
                        fgVar = this.JV.hW();
                    }
                    fgVar.mo2971b(c1141b.fragment);
                }
            }
        }
        this.Hn = true;
        fg a = m2002a(currentTabTag, fgVar);
        if (a != null) {
            a.commit();
            this.JV.executePendingTransactions();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.Hn = false;
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable c1140a = new C1140a(super.onSaveInstanceState());
        c1140a.Ho = getCurrentTabTag();
        return c1140a;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C1140a) {
            C1140a c1140a = (C1140a) parcelable;
            super.onRestoreInstanceState(c1140a.getSuperState());
            setCurrentTabByTag(c1140a.Ho);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void onTabChanged(String str) {
        if (this.Hn) {
            fg a = m2002a(str, null);
            if (a != null) {
                a.commit();
            }
        }
        if (this.Hl != null) {
            this.Hl.onTabChanged(str);
        }
    }

    private fg m2002a(String str, fg fgVar) {
        C1141b X = m2001X(str);
        if (this.Ka != X) {
            if (fgVar == null) {
                fgVar = this.JV.hW();
            }
            if (!(this.Ka == null || this.Ka.fragment == null)) {
                fgVar.mo2971b(this.Ka.fragment);
            }
            if (X != null) {
                if (X.fragment == null) {
                    X.fragment = Fragment.instantiate(this.mContext, X.Hp.getName(), X.Hq);
                    fgVar.mo2966a(this.mContainerId, X.fragment, X.tag);
                } else {
                    fgVar.mo2972c(X.fragment);
                }
            }
            this.Ka = X;
        }
        return fgVar;
    }

    private C1141b m2001X(String str) {
        int size = this.AQ.size();
        for (int i = 0; i < size; i++) {
            C1141b c1141b = (C1141b) this.AQ.get(i);
            if (c1141b.tag.equals(str)) {
                return c1141b;
            }
        }
        return null;
    }
}
