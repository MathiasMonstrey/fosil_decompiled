package com.fossil;

import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.View;
import com.fossil.cjz.C2125a;
import com.misfit.frameworks.common.log.MFLogger;

public class dsd {
    private Paint aEf;
    private float dpj;
    private LinearGradient dpk;
    private Matrix dpl;
    private int dpm;
    private int dpn;
    private boolean dpo;
    private boolean dpp;
    private C3167a dpq;
    private View view;

    public interface C3167a {
        void da(View view);
    }

    public dsd(View view, Paint paint, AttributeSet attributeSet) {
        this.view = view;
        this.aEf = paint;
        m9609a(attributeSet);
    }

    public float getGradientX() {
        return this.dpj;
    }

    public void setGradientX(float f) {
        this.dpj = f;
        this.view.invalidate();
    }

    public void setShimmering(boolean z) {
        this.dpo = z;
    }

    public void setAnimationSetupCallback(C3167a c3167a) {
        this.dpq = c3167a;
    }

    public int getPrimaryColor() {
        return this.dpm;
    }

    public void setPrimaryColor(int i) {
        this.dpm = i;
        if (this.dpp) {
            awp();
        }
    }

    public int getReflectionColor() {
        return this.dpn;
    }

    public void setReflectionColor(int i) {
        this.dpn = i;
        if (this.dpp) {
            awp();
        }
    }

    private void m9609a(AttributeSet attributeSet) {
        this.dpn = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = this.view.getContext().obtainStyledAttributes(attributeSet, C2125a.ShimmerView, 0, 0);
            if (obtainStyledAttributes != null) {
                try {
                    this.dpn = obtainStyledAttributes.getColor(0, -1);
                } catch (Exception e) {
                    MFLogger.m12671e("ShimmerTextView", "Error while creating the view:" + e);
                } finally {
                    obtainStyledAttributes.recycle();
                }
            }
        }
        this.dpl = new Matrix();
    }

    private void awp() {
        float f = 0.0f;
        float f2 = 0.0f;
        this.dpk = new LinearGradient((float) (-this.view.getWidth()), 0.0f, f, f2, new int[]{this.dpm, this.dpn, this.dpm}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP);
        this.aEf.setShader(this.dpk);
    }

    public void awq() {
        awp();
        if (!this.dpp) {
            this.dpp = true;
            if (this.dpq != null) {
                this.dpq.da(this.view);
            }
        }
    }

    public void onDraw() {
        if (this.dpo) {
            if (this.aEf.getShader() == null) {
                this.aEf.setShader(this.dpk);
            }
            this.dpl.setTranslate(2.0f * this.dpj, 0.0f);
            this.dpk.setLocalMatrix(this.dpl);
            return;
        }
        this.aEf.setShader(null);
    }
}
