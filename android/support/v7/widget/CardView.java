package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.fossil.pl.a;
import com.fossil.pl.c;
import com.fossil.pl.d;
import com.fossil.rm;
import com.fossil.rn;
import com.fossil.ro;
import com.fossil.rp;
import com.fossil.rq;

public class CardView extends FrameLayout {
    private static final int[] alC = new int[]{16842801};
    private static final rp alD;
    private boolean alE;
    int alF;
    int alG;
    final Rect alH = new Rect();
    final Rect alI = new Rect();
    private final rn alJ = new C12171(this);
    private boolean zg;

    class C12171 implements rn {
        private Drawable alK;
        final /* synthetic */ CardView alL;

        C12171(CardView cardView) {
            this.alL = cardView;
        }

        public void m2214s(Drawable drawable) {
            this.alK = drawable;
            this.alL.setBackgroundDrawable(drawable);
        }

        public boolean getUseCompatPadding() {
            return this.alL.getUseCompatPadding();
        }

        public boolean getPreventCornerOverlap() {
            return this.alL.getPreventCornerOverlap();
        }

        public void m2213f(int i, int i2, int i3, int i4) {
            this.alL.alI.set(i, i2, i3, i4);
            super.setPadding(this.alL.alH.left + i, this.alL.alH.top + i2, this.alL.alH.right + i3, this.alL.alH.bottom + i4);
        }

        public void ab(int i, int i2) {
            if (i > this.alL.alF) {
                super.setMinimumWidth(i);
            }
            if (i2 > this.alL.alG) {
                super.setMinimumHeight(i2);
            }
        }

        public Drawable oD() {
            return this.alK;
        }

        public View oE() {
            return this.alL;
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            alD = new rm();
        } else if (VERSION.SDK_INT >= 17) {
            alD = new rq();
        } else {
            alD = new ro();
        }
        alD.oF();
    }

    public CardView(Context context) {
        super(context);
        m2215a(context, null, 0);
    }

    public CardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m2215a(context, attributeSet, 0);
    }

    public CardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2215a(context, attributeSet, i);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public boolean getUseCompatPadding() {
        return this.zg;
    }

    public void setUseCompatPadding(boolean z) {
        if (this.zg != z) {
            this.zg = z;
            alD.g(this.alJ);
        }
    }

    public void m2219k(int i, int i2, int i3, int i4) {
        this.alH.set(i, i2, i3, i4);
        alD.f(this.alJ);
    }

    protected void onMeasure(int i, int i2) {
        if (alD instanceof rm) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        switch (mode) {
            case Integer.MIN_VALUE:
            case 1073741824:
                i = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) alD.b(this.alJ)), MeasureSpec.getSize(i)), mode);
                break;
        }
        mode = MeasureSpec.getMode(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
            case 1073741824:
                i2 = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) alD.c(this.alJ)), MeasureSpec.getSize(i2)), mode);
                break;
        }
        super.onMeasure(i, i2);
    }

    private void m2215a(Context context, AttributeSet attributeSet, int i) {
        ColorStateList colorStateList;
        int color;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.CardView, i, c.CardView);
        if (obtainStyledAttributes.hasValue(d.CardView_cardBackgroundColor)) {
            colorStateList = obtainStyledAttributes.getColorStateList(d.CardView_cardBackgroundColor);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(alC);
            int color2 = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            if (fArr[2] > 0.5f) {
                color = getResources().getColor(a.cardview_light_background);
            } else {
                color = getResources().getColor(a.cardview_dark_background);
            }
            colorStateList = ColorStateList.valueOf(color);
        }
        float dimension = obtainStyledAttributes.getDimension(d.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(d.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(d.CardView_cardMaxElevation, 0.0f);
        this.zg = obtainStyledAttributes.getBoolean(d.CardView_cardUseCompatPadding, false);
        this.alE = obtainStyledAttributes.getBoolean(d.CardView_cardPreventCornerOverlap, true);
        color = obtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPadding, 0);
        this.alH.left = obtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPaddingLeft, color);
        this.alH.top = obtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPaddingTop, color);
        this.alH.right = obtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPaddingRight, color);
        this.alH.bottom = obtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPaddingBottom, color);
        if (dimension2 > dimension3) {
            dimension3 = dimension2;
        }
        this.alF = obtainStyledAttributes.getDimensionPixelSize(d.CardView_android_minWidth, 0);
        this.alG = obtainStyledAttributes.getDimensionPixelSize(d.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        alD.a(this.alJ, context, colorStateList, dimension, dimension2, dimension3);
    }

    public void setMinimumWidth(int i) {
        this.alF = i;
        super.setMinimumWidth(i);
    }

    public void setMinimumHeight(int i) {
        this.alG = i;
        super.setMinimumHeight(i);
    }

    public void setCardBackgroundColor(int i) {
        alD.a(this.alJ, ColorStateList.valueOf(i));
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        alD.a(this.alJ, colorStateList);
    }

    public ColorStateList getCardBackgroundColor() {
        return alD.i(this.alJ);
    }

    public int getContentPaddingLeft() {
        return this.alH.left;
    }

    public int getContentPaddingRight() {
        return this.alH.right;
    }

    public int getContentPaddingTop() {
        return this.alH.top;
    }

    public int getContentPaddingBottom() {
        return this.alH.bottom;
    }

    public void setRadius(float f) {
        alD.a(this.alJ, f);
    }

    public float getRadius() {
        return alD.d(this.alJ);
    }

    public void setCardElevation(float f) {
        alD.c(this.alJ, f);
    }

    public float getCardElevation() {
        return alD.e(this.alJ);
    }

    public void setMaxCardElevation(float f) {
        alD.b(this.alJ, f);
    }

    public float getMaxCardElevation() {
        return alD.a(this.alJ);
    }

    public boolean getPreventCornerOverlap() {
        return this.alE;
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.alE) {
            this.alE = z;
            alD.h(this.alJ);
        }
    }
}
