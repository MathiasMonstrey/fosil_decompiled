package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.widget.CoordinatorLayout.C1090a;
import android.support.design.widget.CoordinatorLayout.C1092c;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import com.fossil.ag.C1623d;
import com.fossil.ag.C1629j;
import com.fossil.ag.C1630k;
import com.fossil.az;
import com.fossil.ba;
import com.fossil.bb;
import com.fossil.bb.C1097a;
import com.fossil.bc;
import com.fossil.bf;
import com.fossil.bi;
import com.fossil.bm;
import com.fossil.bp;
import com.fossil.hb;
import com.fossil.li;
import com.fossil.rh;
import java.util.List;

@C1090a(Behavior.class)
public class FloatingActionButton extends VisibilityAwareImageButton {
    private int mSize;
    private ColorStateList yZ;
    private Mode za;
    private int zb;
    private int zc;
    int zd;
    private int zf;
    boolean zg;
    final Rect zh;
    private final Rect zi;
    private rh zj;
    private bb zk;

    public static class Behavior extends android.support.design.widget.CoordinatorLayout.Behavior<FloatingActionButton> {
        private Rect xL;
        private C1098a zn;
        private boolean zo;

        public /* synthetic */ boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            return m1857a(coordinatorLayout, (FloatingActionButton) view, rect);
        }

        public /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return m1858a(coordinatorLayout, (FloatingActionButton) view, view2);
        }

        public /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
            return m1856a(coordinatorLayout, (FloatingActionButton) view, i);
        }

        public Behavior() {
            this.zo = true;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1630k.FloatingActionButton_Behavior_Layout);
            this.zo = obtainStyledAttributes.getBoolean(C1630k.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            obtainStyledAttributes.recycle();
        }

        public void onAttachedToLayoutParams(C1092c c1092c) {
            if (c1092c.yI == 0) {
                c1092c.yI = 80;
            }
        }

        public boolean m1858a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                m1852a(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
            } else if (m1855u(view)) {
                m1854b(view, floatingActionButton);
            }
            return false;
        }

        private static boolean m1855u(View view) {
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof C1092c) {
                return ((C1092c) layoutParams).fW() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean m1853a(View view, FloatingActionButton floatingActionButton) {
            C1092c c1092c = (C1092c) floatingActionButton.getLayoutParams();
            if (!this.zo) {
                return false;
            }
            if (c1092c.fV() != view.getId()) {
                return false;
            }
            if (floatingActionButton.getUserSetVisibility() != 0) {
                return false;
            }
            return true;
        }

        private boolean m1852a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!m1853a((View) appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.xL == null) {
                this.xL = new Rect();
            }
            Rect rect = this.xL;
            bm.m5287b(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.m1867b(this.zn, false);
            } else {
                floatingActionButton.m1866a(this.zn, false);
            }
            return true;
        }

        private boolean m1854b(View view, FloatingActionButton floatingActionButton) {
            if (!m1853a(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < ((C1092c) floatingActionButton.getLayoutParams()).topMargin + (floatingActionButton.getHeight() / 2)) {
                floatingActionButton.m1867b(this.zn, false);
            } else {
                floatingActionButton.m1866a(this.zn, false);
            }
            return true;
        }

        public boolean m1856a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            List r = coordinatorLayout.m1849r(floatingActionButton);
            int size = r.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) r.get(i2);
                if (!(view instanceof AppBarLayout)) {
                    if (m1855u(view) && m1854b(view, floatingActionButton)) {
                        break;
                    }
                } else if (m1852a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.m1844d(floatingActionButton, i);
            m1851a(coordinatorLayout, floatingActionButton);
            return true;
        }

        public boolean m1857a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.zh;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        private void m1851a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i = 0;
            Rect rect = floatingActionButton.zh;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                int i2;
                C1092c c1092c = (C1092c) floatingActionButton.getLayoutParams();
                if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - c1092c.rightMargin) {
                    i2 = rect.right;
                } else if (floatingActionButton.getLeft() <= c1092c.leftMargin) {
                    i2 = -rect.left;
                } else {
                    i2 = 0;
                }
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - c1092c.bottomMargin) {
                    i = rect.bottom;
                } else if (floatingActionButton.getTop() <= c1092c.topMargin) {
                    i = -rect.top;
                }
                if (i != 0) {
                    li.m12274p(floatingActionButton, i);
                }
                if (i2 != 0) {
                    li.m12275q(floatingActionButton, i2);
                }
            }
        }
    }

    public static abstract class C1098a {
        public void m1859a(FloatingActionButton floatingActionButton) {
        }

        public void m1860b(FloatingActionButton floatingActionButton) {
        }
    }

    class C1099b implements bf {
        final /* synthetic */ FloatingActionButton zm;

        C1099b(FloatingActionButton floatingActionButton) {
            this.zm = floatingActionButton;
        }

        public float getRadius() {
            return ((float) this.zm.getSizeDimension()) / 2.0f;
        }

        public void mo64f(int i, int i2, int i3, int i4) {
            this.zm.zh.set(i, i2, i3, i4);
            this.zm.setPadding(this.zm.zd + i, this.zm.zd + i2, this.zm.zd + i3, this.zm.zd + i4);
        }

        public void setBackgroundDrawable(Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        public boolean gl() {
            return this.zm.zg;
        }
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zh = new Rect();
        this.zi = new Rect();
        bi.m5190g(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1630k.FloatingActionButton, i, C1629j.Widget_Design_FloatingActionButton);
        this.yZ = obtainStyledAttributes.getColorStateList(C1630k.FloatingActionButton_backgroundTint);
        this.za = bp.m5449a(obtainStyledAttributes.getInt(C1630k.FloatingActionButton_backgroundTintMode, -1), null);
        this.zc = obtainStyledAttributes.getColor(C1630k.FloatingActionButton_rippleColor, 0);
        this.mSize = obtainStyledAttributes.getInt(C1630k.FloatingActionButton_fabSize, -1);
        this.zb = obtainStyledAttributes.getDimensionPixelSize(C1630k.FloatingActionButton_borderWidth, 0);
        float dimension = obtainStyledAttributes.getDimension(C1630k.FloatingActionButton_elevation, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(C1630k.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.zg = obtainStyledAttributes.getBoolean(C1630k.FloatingActionButton_useCompatPadding, false);
        obtainStyledAttributes.recycle();
        this.zj = new rh(this);
        this.zj.a(attributeSet, i);
        this.zf = (int) getResources().getDimension(C1623d.design_fab_image_size);
        getImpl().mo1224a(this.yZ, this.za, this.zc, this.zb);
        getImpl().setElevation(dimension);
        getImpl().m4731p(dimension2);
    }

    protected void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.zd = (sizeDimension - this.zf) / 2;
        getImpl().gt();
        sizeDimension = Math.min(resolveAdjustedSize(sizeDimension, i), resolveAdjustedSize(sizeDimension, i2));
        setMeasuredDimension((this.zh.left + sizeDimension) + this.zh.right, (sizeDimension + this.zh.top) + this.zh.bottom);
    }

    public int getRippleColor() {
        return this.zc;
    }

    public void setRippleColor(int i) {
        if (this.zc != i) {
            this.zc = i;
            getImpl().setRippleColor(i);
        }
    }

    public ColorStateList getBackgroundTintList() {
        return this.yZ;
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.yZ != colorStateList) {
            this.yZ = colorStateList;
            getImpl().setBackgroundTintList(colorStateList);
        }
    }

    public Mode getBackgroundTintMode() {
        return this.za;
    }

    public void setBackgroundTintMode(Mode mode) {
        if (this.za != mode) {
            this.za = mode;
            getImpl().setBackgroundTintMode(mode);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setImageResource(int i) {
        this.zj.setImageResource(i);
    }

    void m1866a(C1098a c1098a, boolean z) {
        getImpl().mo1228b(m1864a(c1098a), z);
    }

    void m1867b(C1098a c1098a, boolean z) {
        getImpl().mo1225a(m1864a(c1098a), z);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.zg != z) {
            this.zg = z;
            getImpl().gn();
        }
    }

    public boolean getUseCompatPadding() {
        return this.zg;
    }

    public void setSize(int i) {
        if (i != this.mSize) {
            this.mSize = i;
            requestLayout();
        }
    }

    public int getSize() {
        return this.mSize;
    }

    private C1097a m1864a(final C1098a c1098a) {
        if (c1098a == null) {
            return null;
        }
        return new C1097a(this) {
            final /* synthetic */ FloatingActionButton zm;

            public void gj() {
                c1098a.m1859a(this.zm);
            }

            public void gk() {
                c1098a.m1860b(this.zm);
            }
        };
    }

    int getSizeDimension() {
        return ad(this.mSize);
    }

    private int ad(int i) {
        Resources resources = getResources();
        switch (i) {
            case -1:
                if (Math.max(hb.m11553b(resources), hb.m11552a(resources)) < 470) {
                    return ad(1);
                }
                return ad(0);
            case 1:
                return resources.getDimensionPixelSize(C1623d.design_fab_size_mini);
            default:
                return resources.getDimensionPixelSize(C1623d.design_fab_size_normal);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().onDetachedFromWindow();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().mo1226a(getDrawableState());
    }

    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().gm();
    }

    public boolean m1868c(Rect rect) {
        if (!li.as(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        rect.left += this.zh.left;
        rect.top += this.zh.top;
        rect.right -= this.zh.right;
        rect.bottom -= this.zh.bottom;
        return true;
    }

    public Drawable getContentBackground() {
        return getImpl().getContentBackground();
    }

    private static int resolveAdjustedSize(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(i, size);
            case 1073741824:
                return size;
            default:
                return i;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (m1868c(this.zi) && !this.zi.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    return false;
                }
        }
        return super.onTouchEvent(motionEvent);
    }

    public float getCompatElevation() {
        return getImpl().getElevation();
    }

    public void setCompatElevation(float f) {
        getImpl().setElevation(f);
    }

    private bb getImpl() {
        if (this.zk == null) {
            this.zk = gi();
        }
        return this.zk;
    }

    private bb gi() {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            return new bc(this, new C1099b(this), bp.Dp);
        }
        if (i >= 14) {
            return new ba(this, new C1099b(this), bp.Dp);
        }
        return new az(this, new C1099b(this), bp.Dp);
    }
}
