package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.internal.ScrimInsetsFrameLayout;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.fossil.ag.C1629j;
import com.fossil.ag.C1630k;
import com.fossil.al;
import com.fossil.am;
import com.fossil.bi;
import com.fossil.gn;
import com.fossil.ix;
import com.fossil.iy;
import com.fossil.jy;
import com.fossil.li;
import com.fossil.mg;
import com.fossil.pk;
import com.fossil.pn;
import com.fossil.pz;
import com.fossil.qj;
import com.fossil.qj.a;
import com.fossil.ql;
import com.fossil.sw;

public class NavigationView extends ScrimInsetsFrameLayout {
    private static final int[] tH = new int[]{16842912};
    private static final int[] vK = new int[]{-16842910};
    private int mMaxWidth;
    private MenuInflater vL;
    private final al zR;
    private final am zS;
    C1102a zT;

    class C11011 implements a {
        final /* synthetic */ NavigationView zU;

        C11011(NavigationView navigationView) {
            this.zU = navigationView;
        }

        public boolean m1869a(qj qjVar, MenuItem menuItem) {
            return this.zU.zT != null && this.zU.zT.m1871b(menuItem);
        }

        public void m1870b(qj qjVar) {
        }
    }

    public interface C1102a {
        boolean m1871b(MenuItem menuItem);
    }

    public static class C1104b extends jy {
        public static final Creator<C1104b> CREATOR = ix.m11854a(new C11031());
        public Bundle zV;

        static class C11031 implements iy<C1104b> {
            C11031() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return m1872g(parcel, classLoader);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return af(i);
            }

            public C1104b m1872g(Parcel parcel, ClassLoader classLoader) {
                return new C1104b(parcel, classLoader);
            }

            public C1104b[] af(int i) {
                return new C1104b[i];
            }
        }

        public C1104b(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.zV = parcel.readBundle(classLoader);
        }

        public C1104b(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.zV);
        }
    }

    public NavigationView(Context context) {
        this(context, null);
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationView(Context context, AttributeSet attributeSet, int i) {
        ColorStateList colorStateList;
        int resourceId;
        super(context, attributeSet, i);
        this.zS = new am();
        bi.m5190g(context);
        this.zR = new al(context);
        sw a = sw.a(context, attributeSet, C1630k.NavigationView, i, C1629j.Widget_Design_NavigationView);
        li.m12248a((View) this, a.getDrawable(C1630k.NavigationView_android_background));
        if (a.hasValue(C1630k.NavigationView_elevation)) {
            li.m12269l((View) this, (float) a.getDimensionPixelSize(C1630k.NavigationView_elevation, 0));
        }
        li.m12255b((View) this, a.getBoolean(C1630k.NavigationView_android_fitsSystemWindows, false));
        this.mMaxWidth = a.getDimensionPixelSize(C1630k.NavigationView_android_maxWidth, 0);
        if (a.hasValue(C1630k.NavigationView_itemIconTint)) {
            colorStateList = a.getColorStateList(C1630k.NavigationView_itemIconTint);
        } else {
            colorStateList = m1873M(16842808);
        }
        if (a.hasValue(C1630k.NavigationView_itemTextAppearance)) {
            resourceId = a.getResourceId(C1630k.NavigationView_itemTextAppearance, 0);
            int i2 = 1;
        } else {
            resourceId = 0;
            boolean z = false;
        }
        ColorStateList colorStateList2 = null;
        if (a.hasValue(C1630k.NavigationView_itemTextColor)) {
            colorStateList2 = a.getColorStateList(C1630k.NavigationView_itemTextColor);
        }
        if (i2 == 0 && r5 == null) {
            colorStateList2 = m1873M(16842806);
        }
        Drawable drawable = a.getDrawable(C1630k.NavigationView_itemBackground);
        this.zR.a(new C11011(this));
        this.zS.setId(1);
        this.zS.m3819a(context, this.zR);
        this.zS.setItemIconTintList(colorStateList);
        if (i2 != 0) {
            this.zS.setItemTextAppearance(resourceId);
        }
        this.zS.setItemTextColor(colorStateList2);
        this.zS.setItemBackground(drawable);
        this.zR.a(this.zS);
        addView((View) this.zS.m3818a((ViewGroup) this));
        if (a.hasValue(C1630k.NavigationView_menu)) {
            inflateMenu(a.getResourceId(C1630k.NavigationView_menu, 0));
        }
        if (a.hasValue(C1630k.NavigationView_headerLayout)) {
            m1874D(a.getResourceId(C1630k.NavigationView_headerLayout, 0));
        }
        a.recycle();
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable c1104b = new C1104b(super.onSaveInstanceState());
        c1104b.zV = new Bundle();
        this.zR.h(c1104b.zV);
        return c1104b;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C1104b) {
            C1104b c1104b = (C1104b) parcelable;
            super.onRestoreInstanceState(c1104b.getSuperState());
            this.zR.i(c1104b.zV);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void setNavigationItemSelectedListener(C1102a c1102a) {
        this.zT = c1102a;
    }

    protected void onMeasure(int i, int i2) {
        switch (MeasureSpec.getMode(i)) {
            case Integer.MIN_VALUE:
                i = MeasureSpec.makeMeasureSpec(Math.min(MeasureSpec.getSize(i), this.mMaxWidth), 1073741824);
                break;
            case 0:
                i = MeasureSpec.makeMeasureSpec(this.mMaxWidth, 1073741824);
                break;
        }
        super.onMeasure(i, i2);
    }

    protected void mo69b(mg mgVar) {
        this.zS.m3820a(mgVar);
    }

    public void inflateMenu(int i) {
        this.zS.m3828h(true);
        getMenuInflater().inflate(i, this.zR);
        this.zS.m3828h(false);
        this.zS.m3827g(false);
    }

    public Menu getMenu() {
        return this.zR;
    }

    public View m1874D(int i) {
        return this.zS.m3817D(i);
    }

    public int getHeaderCount() {
        return this.zS.getHeaderCount();
    }

    public ColorStateList getItemIconTintList() {
        return this.zS.fa();
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.zS.setItemIconTintList(colorStateList);
    }

    public ColorStateList getItemTextColor() {
        return this.zS.getItemTextColor();
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.zS.setItemTextColor(colorStateList);
    }

    public Drawable getItemBackground() {
        return this.zS.getItemBackground();
    }

    public void setItemBackgroundResource(int i) {
        setItemBackground(gn.m10632c(getContext(), i));
    }

    public void setItemBackground(Drawable drawable) {
        this.zS.setItemBackground(drawable);
    }

    public void setCheckedItem(int i) {
        MenuItem findItem = this.zR.findItem(i);
        if (findItem != null) {
            this.zS.m3822a((ql) findItem);
        }
    }

    public void setItemTextAppearance(int i) {
        this.zS.setItemTextAppearance(i);
    }

    private MenuInflater getMenuInflater() {
        if (this.vL == null) {
            this.vL = new pz(getContext());
        }
        return this.vL;
    }

    private ColorStateList m1873M(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList d = pn.d(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(pk.a.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = d.getDefaultColor();
        return new ColorStateList(new int[][]{vK, tH, EMPTY_STATE_SET}, new int[]{d.getColorForState(vK, defaultColor), i2, defaultColor});
    }
}
