package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.fossil.ag.C1623d;
import com.fossil.ag.C1624e;
import com.fossil.ag.C1625f;
import com.fossil.ag.C1627h;
import com.fossil.gn;
import com.fossil.hh;
import com.fossil.lc;
import com.fossil.li;
import com.fossil.ql;
import com.fossil.qr.a;

public class BottomNavigationItemView extends FrameLayout implements a {
    private static final int[] tH = new int[]{16842912};
    private final int tI;
    private final int tJ;
    private final float tK;
    private final float tL;
    private boolean tM;
    private ImageView tN;
    private final TextView tO;
    private final TextView tP;
    private int tQ;
    private ql tR;
    private ColorStateList tS;

    public BottomNavigationItemView(Context context) {
        this(context, null);
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tQ = -1;
        Resources resources = getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(C1623d.design_bottom_navigation_text_size);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(C1623d.design_bottom_navigation_active_text_size);
        this.tI = resources.getDimensionPixelSize(C1623d.design_bottom_navigation_margin);
        this.tJ = dimensionPixelSize - dimensionPixelSize2;
        this.tK = (((float) dimensionPixelSize2) * 1.0f) / ((float) dimensionPixelSize);
        this.tL = (((float) dimensionPixelSize) * 1.0f) / ((float) dimensionPixelSize2);
        LayoutInflater.from(context).inflate(C1627h.design_bottom_navigation_item, this, true);
        setBackgroundResource(C1624e.design_bottom_navigation_item_background);
        this.tN = (ImageView) findViewById(C1625f.icon);
        this.tO = (TextView) findViewById(C1625f.smallLabel);
        this.tP = (TextView) findViewById(C1625f.largeLabel);
    }

    public void m1678a(ql qlVar, int i) {
        this.tR = qlVar;
        setCheckable(qlVar.isCheckable());
        setChecked(qlVar.isChecked());
        setEnabled(qlVar.isEnabled());
        setIcon(qlVar.getIcon());
        setTitle(qlVar.getTitle());
        setId(qlVar.getItemId());
    }

    public void setItemPosition(int i) {
        this.tQ = i;
    }

    public int getItemPosition() {
        return this.tQ;
    }

    public void setShiftingMode(boolean z) {
        this.tM = z;
    }

    public ql getItemData() {
        return this.tR;
    }

    public void setTitle(CharSequence charSequence) {
        this.tO.setText(charSequence);
        this.tP.setText(charSequence);
        setContentDescription(charSequence);
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        li.m12267j(this.tP, (float) (this.tP.getWidth() / 2));
        li.m12268k(this.tP, (float) this.tP.getBaseline());
        li.m12267j(this.tO, (float) (this.tO.getWidth() / 2));
        li.m12268k(this.tO, (float) this.tO.getBaseline());
        LayoutParams layoutParams;
        if (this.tM) {
            if (z) {
                layoutParams = (LayoutParams) this.tN.getLayoutParams();
                layoutParams.gravity = 49;
                layoutParams.topMargin = this.tI;
                this.tN.setLayoutParams(layoutParams);
                this.tP.setVisibility(0);
                li.m12265h(this.tP, 1.0f);
                li.m12266i(this.tP, 1.0f);
            } else {
                layoutParams = (LayoutParams) this.tN.getLayoutParams();
                layoutParams.gravity = 17;
                layoutParams.topMargin = this.tI;
                this.tN.setLayoutParams(layoutParams);
                this.tP.setVisibility(4);
                li.m12265h(this.tP, 0.5f);
                li.m12266i(this.tP, 0.5f);
            }
            this.tO.setVisibility(4);
        } else if (z) {
            layoutParams = (LayoutParams) this.tN.getLayoutParams();
            layoutParams.gravity = 49;
            layoutParams.topMargin = this.tI + this.tJ;
            this.tN.setLayoutParams(layoutParams);
            this.tP.setVisibility(0);
            this.tO.setVisibility(4);
            li.m12265h(this.tP, 1.0f);
            li.m12266i(this.tP, 1.0f);
            li.m12265h(this.tO, this.tK);
            li.m12266i(this.tO, this.tK);
        } else {
            layoutParams = (LayoutParams) this.tN.getLayoutParams();
            layoutParams.gravity = 49;
            layoutParams.topMargin = this.tI;
            this.tN.setLayoutParams(layoutParams);
            this.tP.setVisibility(4);
            this.tO.setVisibility(0);
            li.m12265h(this.tP, this.tL);
            li.m12266i(this.tP, this.tL);
            li.m12265h(this.tO, 1.0f);
            li.m12266i(this.tO, 1.0f);
        }
        refreshDrawableState();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.tO.setEnabled(z);
        this.tP.setEnabled(z);
        this.tN.setEnabled(z);
        if (z) {
            li.m12251a((View) this, lc.m12067f(getContext(), 1002));
        } else {
            li.m12251a((View) this, null);
        }
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.tR != null && this.tR.isCheckable() && this.tR.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, tH);
        }
        return onCreateDrawableState;
    }

    public void m1679a(boolean z, char c) {
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = hh.m11635i(drawable).mutate();
            hh.m11623a(drawable, this.tS);
        }
        this.tN.setImageDrawable(drawable);
    }

    public boolean eT() {
        return false;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.tS = colorStateList;
        if (this.tR != null) {
            setIcon(this.tR.getIcon());
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.tO.setTextColor(colorStateList);
        this.tP.setTextColor(colorStateList);
    }

    public void setItemBackground(int i) {
        Drawable drawable;
        if (i == 0) {
            drawable = null;
        } else {
            drawable = gn.m10632c(getContext(), i);
        }
        li.m12248a((View) this, drawable);
    }
}
