package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.v7.widget.LinearLayoutCompat.LayoutParams;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import com.fossil.ag.C1623d;
import com.fossil.ag.C1624e;
import com.fossil.ag.C1625f;
import com.fossil.ag.C1627h;
import com.fossil.he;
import com.fossil.hh;
import com.fossil.jz;
import com.fossil.li;
import com.fossil.ml;
import com.fossil.oi;
import com.fossil.pk;
import com.fossil.ql;
import com.fossil.qr.a;

public class NavigationMenuItemView extends ForegroundLinearLayout implements a {
    private static final int[] tH = new int[]{16842912};
    private ql tR;
    private Drawable uA;
    private final jz uB;
    private final int ut;
    private boolean uu;
    boolean uv;
    private final CheckedTextView uw;
    private FrameLayout ux;
    private ColorStateList uy;
    private boolean uz;

    class C00051 extends jz {
        final /* synthetic */ NavigationMenuItemView uC;

        C00051(NavigationMenuItemView navigationMenuItemView) {
            this.uC = navigationMenuItemView;
        }

        public void mo2a(View view, ml mlVar) {
            super.mo2a(view, mlVar);
            mlVar.setCheckable(this.uC.uv);
        }
    }

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.uB = new C00051(this);
        setOrientation(0);
        LayoutInflater.from(context).inflate(C1627h.design_navigation_menu_item, this, true);
        this.ut = context.getResources().getDimensionPixelSize(C1623d.design_navigation_icon_size);
        this.uw = (CheckedTextView) findViewById(C1625f.design_menu_item_text);
        this.uw.setDuplicateParentStateEnabled(true);
        li.m12249a(this.uw, this.uB);
    }

    public void m1687a(ql qlVar, int i) {
        this.tR = qlVar;
        setVisibility(qlVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            li.m12248a((View) this, eZ());
        }
        setCheckable(qlVar.isCheckable());
        setChecked(qlVar.isChecked());
        setEnabled(qlVar.isEnabled());
        setTitle(qlVar.getTitle());
        setIcon(qlVar.getIcon());
        setActionView(qlVar.getActionView());
        eY();
    }

    private boolean eX() {
        return this.tR.getTitle() == null && this.tR.getIcon() == null && this.tR.getActionView() != null;
    }

    private void eY() {
        if (eX()) {
            this.uw.setVisibility(8);
            if (this.ux != null) {
                LayoutParams layoutParams = (LayoutParams) this.ux.getLayoutParams();
                layoutParams.width = -1;
                this.ux.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.uw.setVisibility(0);
        if (this.ux != null) {
            layoutParams = (LayoutParams) this.ux.getLayoutParams();
            layoutParams.width = -2;
            this.ux.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
        if (this.ux != null) {
            this.ux.removeAllViews();
        }
        this.uw.setCompoundDrawables(null, null, null, null);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.ux == null) {
                this.ux = (FrameLayout) ((ViewStub) findViewById(C1625f.design_menu_item_action_area_stub)).inflate();
            }
            this.ux.removeAllViews();
            this.ux.addView(view);
        }
    }

    private StateListDrawable eZ() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(pk.a.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(tH, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    public ql getItemData() {
        return this.tR;
    }

    public void setTitle(CharSequence charSequence) {
        this.uw.setText(charSequence);
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.uv != z) {
            this.uv = z;
            this.uB.sendAccessibilityEvent(this.uw, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.uw.setChecked(z);
    }

    public void m1688a(boolean z, char c) {
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.uz) {
                ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = hh.m11635i(drawable).mutate();
                hh.m11623a(drawable, this.uy);
            }
            drawable.setBounds(0, 0, this.ut, this.ut);
        } else if (this.uu) {
            if (this.uA == null) {
                this.uA = he.m11561b(getResources(), C1624e.navigation_empty_icon, getContext().getTheme());
                if (this.uA != null) {
                    this.uA.setBounds(0, 0, this.ut, this.ut);
                }
            }
            drawable = this.uA;
        }
        oi.a(this.uw, drawable, null, null, null);
    }

    public boolean eT() {
        return false;
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.tR != null && this.tR.isCheckable() && this.tR.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, tH);
        }
        return onCreateDrawableState;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.uy = colorStateList;
        this.uz = this.uy != null;
        if (this.tR != null) {
            setIcon(this.tR.getIcon());
        }
    }

    public void setTextAppearance(int i) {
        oi.b(this.uw, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.uw.setTextColor(colorStateList);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.uu = z;
    }
}
