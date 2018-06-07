package com.fossil;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.fossil.pk.C3991j;

public class rj extends ri {
    private final SeekBar akX;
    private Drawable akY;
    private ColorStateList akZ = null;
    private Mode ala = null;
    private boolean alb = false;
    private boolean alc = false;

    public rj(SeekBar seekBar) {
        super(seekBar);
        this.akX = seekBar;
    }

    public void mo4071a(AttributeSet attributeSet, int i) {
        super.mo4071a(attributeSet, i);
        sw a = sw.m13583a(this.akX.getContext(), attributeSet, C3991j.AppCompatSeekBar, i, 0);
        Drawable el = a.el(C3991j.AppCompatSeekBar_android_thumb);
        if (el != null) {
            this.akX.setThumb(el);
        }
        setTickMark(a.getDrawable(C3991j.AppCompatSeekBar_tickMark));
        if (a.hasValue(C3991j.AppCompatSeekBar_tickMarkTintMode)) {
            this.ala = rv.m13469a(a.getInt(C3991j.AppCompatSeekBar_tickMarkTintMode, -1), this.ala);
            this.alc = true;
        }
        if (a.hasValue(C3991j.AppCompatSeekBar_tickMarkTint)) {
            this.akZ = a.getColorStateList(C3991j.AppCompatSeekBar_tickMarkTint);
            this.alb = true;
        }
        a.recycle();
        oy();
    }

    void setTickMark(Drawable drawable) {
        if (this.akY != null) {
            this.akY.setCallback(null);
        }
        this.akY = drawable;
        if (drawable != null) {
            drawable.setCallback(this.akX);
            hh.b(drawable, li.S(this.akX));
            if (drawable.isStateful()) {
                drawable.setState(this.akX.getDrawableState());
            }
            oy();
        }
        this.akX.invalidate();
    }

    private void oy() {
        if (this.akY == null) {
            return;
        }
        if (this.alb || this.alc) {
            this.akY = hh.i(this.akY.mutate());
            if (this.alb) {
                hh.a(this.akY, this.akZ);
            }
            if (this.alc) {
                hh.a(this.akY, this.ala);
            }
            if (this.akY.isStateful()) {
                this.akY.setState(this.akX.getDrawableState());
            }
        }
    }

    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        if (this.akY != null) {
            this.akY.jumpToCurrentState();
        }
    }

    public void drawableStateChanged() {
        Drawable drawable = this.akY;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.akX.getDrawableState())) {
            this.akX.invalidateDrawable(drawable);
        }
    }

    public void m13351b(Canvas canvas) {
        int i = 1;
        if (this.akY != null) {
            int max = this.akX.getMax();
            if (max > 1) {
                int intrinsicWidth = this.akY.getIntrinsicWidth();
                int intrinsicHeight = this.akY.getIntrinsicHeight();
                intrinsicWidth = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i = intrinsicHeight / 2;
                }
                this.akY.setBounds(-intrinsicWidth, -i, intrinsicWidth, i);
                float width = ((float) ((this.akX.getWidth() - this.akX.getPaddingLeft()) - this.akX.getPaddingRight())) / ((float) max);
                intrinsicHeight = canvas.save();
                canvas.translate((float) this.akX.getPaddingLeft(), (float) (this.akX.getHeight() / 2));
                for (i = 0; i <= max; i++) {
                    this.akY.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(intrinsicHeight);
            }
        }
    }
}
