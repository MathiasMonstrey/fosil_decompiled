package com.portfolio.platform.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class EditTextCustom extends FlexibleEditText {
    int diA;
    int diB;
    private DrawableClickListener diC;
    private Drawable div;
    private Drawable diw;
    private Drawable dix;
    private Drawable diy;
    private C4984a diz;

    public interface DrawableClickListener {

        public enum DrawablePosition {
            TOP,
            BOTTOM,
            LEFT,
            RIGHT
        }

        void m15857a(DrawablePosition drawablePosition);
    }

    public interface C4984a {
        void alV();
    }

    public EditTextCustom(Context context) {
        super(context);
    }

    public EditTextCustom(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EditTextCustom(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
            if (this.diz != null) {
                this.diz.alV();
            }
            clearFocus();
        }
        return true;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            this.diw = drawable;
        }
        if (drawable3 != null) {
            this.div = drawable3;
        }
        if (drawable2 != null) {
            this.dix = drawable2;
        }
        if (drawable4 != null) {
            this.diy = drawable4;
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.diA = (int) motionEvent.getX();
            this.diB = (int) motionEvent.getY();
            if (this.diy != null && this.diy.getBounds().contains(this.diA, this.diB)) {
                this.diC.m15857a(DrawablePosition.BOTTOM);
                return super.onTouchEvent(motionEvent);
            } else if (this.dix == null || !this.dix.getBounds().contains(this.diA, this.diB)) {
                Rect bounds;
                int i;
                int i2;
                if (this.diw != null) {
                    bounds = this.diw.getBounds();
                    int i3 = (int) (((double) (13.0f * getResources().getDisplayMetrics().density)) + 0.5d);
                    i = this.diA;
                    i2 = this.diB;
                    if (!bounds.contains(this.diA, this.diB)) {
                        i = this.diA - i3;
                        i2 = this.diB - i3;
                        if (i <= 0) {
                            i = this.diA;
                        }
                        if (i2 <= 0) {
                            i2 = this.diB;
                        }
                    }
                    if (bounds.contains(i, i2) && this.diC != null) {
                        this.diC.m15857a(DrawablePosition.LEFT);
                        motionEvent.setAction(3);
                        return false;
                    }
                }
                if (this.div != null) {
                    bounds = this.div.getBounds();
                    i2 = this.diB - 13;
                    i = getWidth() - (this.diA + 13);
                    if (i <= 0) {
                        i += 13;
                    }
                    if (i2 <= 0) {
                        i2 = this.diB;
                    }
                    if (!bounds.contains(i, i2) || this.diC == null) {
                        return super.onTouchEvent(motionEvent);
                    }
                    this.diC.m15857a(DrawablePosition.RIGHT);
                    motionEvent.setAction(3);
                    return false;
                }
            } else {
                this.diC.m15857a(DrawablePosition.TOP);
                return super.onTouchEvent(motionEvent);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void finalize() throws Throwable {
        this.div = null;
        this.diy = null;
        this.diw = null;
        this.dix = null;
        super.finalize();
    }

    public void setDrawableClickListener(DrawableClickListener drawableClickListener) {
        this.diC = drawableClickListener;
    }

    public void setBackPressListener(C4984a c4984a) {
        this.diz = c4984a;
    }

    public void setTypeface(Typeface typeface) {
        super.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/Fossil_Scout-Regular_10.otf"));
    }
}
