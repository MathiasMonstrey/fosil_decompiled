package com.fossil;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v7.widget.ActionMenuView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.fossil.pk.C3982a;
import com.fossil.pk.C3991j;

public abstract class qy extends ViewGroup {
    private boolean ahA;
    protected final C4021a aht;
    protected final Context ahu;
    protected ActionMenuView ahv;
    protected rb ahw;
    protected int ahx;
    protected lz ahy;
    private boolean ahz;

    public class C4021a implements md {
        private boolean FN = false;
        int ahB;
        final /* synthetic */ qy ahC;

        protected C4021a(qy qyVar) {
            this.ahC = qyVar;
        }

        public C4021a m13221a(lz lzVar, int i) {
            this.ahC.ahy = lzVar;
            this.ahB = i;
            return this;
        }

        public void m13222e(View view) {
            super.setVisibility(0);
            this.FN = false;
        }

        public void m13223f(View view) {
            if (!this.FN) {
                this.ahC.ahy = null;
                super.setVisibility(this.ahB);
            }
        }

        public void aD(View view) {
            this.FN = true;
        }
    }

    qy(Context context) {
        this(context, null);
    }

    qy(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected qy(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aht = new C4021a(this);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(C3982a.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.ahu = context;
        } else {
            this.ahu = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, C3991j.ActionBar, C3982a.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(C3991j.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        if (this.ahw != null) {
            this.ahw.onConfigurationChanged(configuration);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = ks.a(motionEvent);
        if (a == 0) {
            this.ahz = false;
        }
        if (!this.ahz) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (a == 0 && !onTouchEvent) {
                this.ahz = true;
            }
        }
        if (a == 1 || a == 3) {
            this.ahz = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int a = ks.a(motionEvent);
        if (a == 9) {
            this.ahA = false;
        }
        if (!this.ahA) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (a == 9 && !onHoverEvent) {
                this.ahA = true;
            }
        }
        if (a == 10 || a == 3) {
            this.ahA = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.ahx = i;
        requestLayout();
    }

    public int getContentHeight() {
        return this.ahx;
    }

    public int getAnimatedVisibility() {
        if (this.ahy != null) {
            return this.aht.ahB;
        }
        return getVisibility();
    }

    public lz m13229c(int i, long j) {
        if (this.ahy != null) {
            this.ahy.cancel();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                li.g(this, 0.0f);
            }
            lz y = li.ae(this).y(1.0f);
            y.n(j);
            y.a(this.aht.m13221a(y, i));
            return y;
        }
        y = li.ae(this).y(0.0f);
        y.n(j);
        y.a(this.aht.m13221a(y, i));
        return y;
    }

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            if (this.ahy != null) {
                this.ahy.cancel();
            }
            super.setVisibility(i);
        }
    }

    public boolean showOverflowMenu() {
        if (this.ahw != null) {
            return this.ahw.showOverflowMenu();
        }
        return false;
    }

    protected int m13227a(View view, int i, int i2, int i3) {
        view.measure(MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    protected static int m13224a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    protected int m13228a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }
}
