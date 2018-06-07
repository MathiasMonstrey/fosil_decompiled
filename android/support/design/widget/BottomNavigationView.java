package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.internal.BottomNavigationMenuView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.fossil.ag.C1622c;
import com.fossil.ag.C1623d;
import com.fossil.ag.C1629j;
import com.fossil.ag.C1630k;
import com.fossil.aj;
import com.fossil.ak;
import com.fossil.bi;
import com.fossil.gn;
import com.fossil.ix;
import com.fossil.iy;
import com.fossil.jy;
import com.fossil.li;
import com.fossil.pk;
import com.fossil.pn;
import com.fossil.pz;
import com.fossil.qj;
import com.fossil.qj.a;
import com.fossil.sw;

public class BottomNavigationView extends FrameLayout {
    private static final int[] tH = new int[]{16842912};
    private static final int[] vK = new int[]{-16842910};
    private final ak ug;
    private final qj uh;
    private final BottomNavigationMenuView uj;
    private MenuInflater vL;
    private C1080b vM;
    private C1079a vN;

    class C10781 implements a {
        final /* synthetic */ BottomNavigationView vO;

        C10781(BottomNavigationView bottomNavigationView) {
            this.vO = bottomNavigationView;
        }

        public boolean m1761a(qj qjVar, MenuItem menuItem) {
            if (this.vO.vN != null && menuItem.getItemId() == this.vO.getSelectedItemId()) {
                this.vO.vN.m1763a(menuItem);
                return true;
            } else if (this.vO.vM == null || this.vO.vM.m1764b(menuItem)) {
                return false;
            } else {
                return true;
            }
        }

        public void m1762b(qj qjVar) {
        }
    }

    public interface C1079a {
        void m1763a(MenuItem menuItem);
    }

    public interface C1080b {
        boolean m1764b(MenuItem menuItem);
    }

    static class C1082c extends jy {
        public static final Creator<C1082c> CREATOR = ix.m11854a(new C10811());
        Bundle vP;

        static class C10811 implements iy<C1082c> {
            C10811() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return m1766d(parcel, classLoader);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m1765N(i);
            }

            public C1082c m1766d(Parcel parcel, ClassLoader classLoader) {
                return new C1082c(parcel, classLoader);
            }

            public C1082c[] m1765N(int i) {
                return new C1082c[i];
            }
        }

        public C1082c(Parcelable parcelable) {
            super(parcelable);
        }

        public C1082c(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            m1767c(parcel, classLoader);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.vP);
        }

        private void m1767c(Parcel parcel, ClassLoader classLoader) {
            this.vP = parcel.readBundle(classLoader);
        }
    }

    public BottomNavigationView(Context context) {
        this(context, null);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ug = new ak();
        bi.m5190g(context);
        this.uh = new aj(context);
        this.uj = new BottomNavigationMenuView(context);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.uj.setLayoutParams(layoutParams);
        this.ug.m3631c(this.uj);
        this.ug.setId(1);
        this.uj.setPresenter(this.ug);
        this.uh.a(this.ug);
        this.ug.m3625a(getContext(), this.uh);
        sw a = sw.a(context, attributeSet, C1630k.BottomNavigationView, i, C1629j.Widget_Design_BottomNavigationView);
        if (a.hasValue(C1630k.BottomNavigationView_itemIconTint)) {
            this.uj.setIconTintList(a.getColorStateList(C1630k.BottomNavigationView_itemIconTint));
        } else {
            this.uj.setIconTintList(m1768M(16842808));
        }
        if (a.hasValue(C1630k.BottomNavigationView_itemTextColor)) {
            this.uj.setItemTextColor(a.getColorStateList(C1630k.BottomNavigationView_itemTextColor));
        } else {
            this.uj.setItemTextColor(m1768M(16842808));
        }
        if (a.hasValue(C1630k.BottomNavigationView_elevation)) {
            li.m12269l((View) this, (float) a.getDimensionPixelSize(C1630k.BottomNavigationView_elevation, 0));
        }
        this.uj.setItemBackgroundRes(a.getResourceId(C1630k.BottomNavigationView_itemBackground, 0));
        if (a.hasValue(C1630k.BottomNavigationView_menu)) {
            inflateMenu(a.getResourceId(C1630k.BottomNavigationView_menu, 0));
        }
        a.recycle();
        addView(this.uj, layoutParams);
        if (VERSION.SDK_INT < 21) {
            m1771f(context);
        }
        this.uh.a(new C10781(this));
    }

    public void setOnNavigationItemSelectedListener(C1080b c1080b) {
        this.vM = c1080b;
    }

    public void setOnNavigationItemReselectedListener(C1079a c1079a) {
        this.vN = c1079a;
    }

    public Menu getMenu() {
        return this.uh;
    }

    public void inflateMenu(int i) {
        this.ug.m3633h(true);
        getMenuInflater().inflate(i, this.uh);
        this.ug.m3633h(false);
        this.ug.m3632g(true);
    }

    public int getMaxItemCount() {
        return 5;
    }

    public ColorStateList getItemIconTintList() {
        return this.uj.getIconTintList();
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.uj.setIconTintList(colorStateList);
    }

    public ColorStateList getItemTextColor() {
        return this.uj.getItemTextColor();
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.uj.setItemTextColor(colorStateList);
    }

    public int getItemBackgroundResource() {
        return this.uj.getItemBackgroundRes();
    }

    public void setItemBackgroundResource(int i) {
        this.uj.setItemBackgroundRes(i);
    }

    public int getSelectedItemId() {
        return this.uj.getSelectedItemId();
    }

    public void setSelectedItemId(int i) {
        MenuItem findItem = this.uh.findItem(i);
        if (findItem != null && !this.uh.a(findItem, this.ug, 0)) {
            findItem.setChecked(true);
        }
    }

    private void m1771f(Context context) {
        View view = new View(context);
        view.setBackgroundColor(gn.m10634e(context, C1622c.design_bottom_navigation_shadow_color));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(C1623d.design_bottom_navigation_shadow_height)));
        addView(view);
    }

    private MenuInflater getMenuInflater() {
        if (this.vL == null) {
            this.vL = new pz(getContext());
        }
        return this.vL;
    }

    private ColorStateList m1768M(int i) {
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

    protected Parcelable onSaveInstanceState() {
        Parcelable c1082c = new C1082c(super.onSaveInstanceState());
        c1082c.vP = new Bundle();
        this.uh.h(c1082c.vP);
        return c1082c;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C1082c) {
            C1082c c1082c = (C1082c) parcelable;
            super.onRestoreInstanceState(c1082c.getSuperState());
            this.uh.i(c1082c.vP);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }
}
