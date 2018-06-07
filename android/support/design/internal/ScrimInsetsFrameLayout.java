package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.fossil.ag.C1629j;
import com.fossil.ag.C1630k;
import com.fossil.kz;
import com.fossil.li;
import com.fossil.mg;

public class ScrimInsetsFrameLayout extends FrameLayout {
    Drawable uS;
    Rect uT;
    private Rect uU;

    class C10701 implements kz {
        final /* synthetic */ ScrimInsetsFrameLayout uV;

        C10701(ScrimInsetsFrameLayout scrimInsetsFrameLayout) {
            this.uV = scrimInsetsFrameLayout;
        }

        public mg mo11a(View view, mg mgVar) {
            if (this.uV.uT == null) {
                this.uV.uT = new Rect();
            }
            this.uV.uT.set(mgVar.getSystemWindowInsetLeft(), mgVar.getSystemWindowInsetTop(), mgVar.getSystemWindowInsetRight(), mgVar.getSystemWindowInsetBottom());
            this.uV.mo69b(mgVar);
            ScrimInsetsFrameLayout scrimInsetsFrameLayout = this.uV;
            boolean z = !mgVar.hasSystemWindowInsets() || this.uV.uS == null;
            scrimInsetsFrameLayout.setWillNotDraw(z);
            li.m12231O(this.uV);
            return mgVar.jT();
        }
    }

    public ScrimInsetsFrameLayout(Context context) {
        this(context, null);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.uU = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1630k.ScrimInsetsFrameLayout, i, C1629j.Widget_Design_ScrimInsetsFrameLayout);
        this.uS = obtainStyledAttributes.getDrawable(C1630k.ScrimInsetsFrameLayout_insetForeground);
        obtainStyledAttributes.recycle();
        setWillNotDraw(true);
        li.m12250a((View) this, new C10701(this));
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.uT != null && this.uS != null) {
            int save = canvas.save();
            canvas.translate((float) getScrollX(), (float) getScrollY());
            this.uU.set(0, 0, width, this.uT.top);
            this.uS.setBounds(this.uU);
            this.uS.draw(canvas);
            this.uU.set(0, height - this.uT.bottom, width, height);
            this.uS.setBounds(this.uU);
            this.uS.draw(canvas);
            this.uU.set(0, this.uT.top, this.uT.left, height - this.uT.bottom);
            this.uS.setBounds(this.uU);
            this.uS.draw(canvas);
            this.uU.set(width - this.uT.right, this.uT.top, width, height - this.uT.bottom);
            this.uS.setBounds(this.uU);
            this.uS.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.uS != null) {
            this.uS.setCallback(this);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.uS != null) {
            this.uS.setCallback(null);
        }
    }

    public void mo69b(mg mgVar) {
    }
}
