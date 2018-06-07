package com.fossil;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.RecyclerView.r.a;
import android.support.v7.widget.RecyclerView.r.b;
import android.support.v7.widget.RecyclerView.s;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.fossil.wearables.fsl.fitness.FitnessProviderImpl;

public class sb extends r {
    protected final DecelerateInterpolator YU = new DecelerateInterpolator();
    protected final LinearInterpolator aoi = new LinearInterpolator();
    protected PointF aoj;
    private final float aok;
    protected int aol = 0;
    protected int aom = 0;

    public sb(Context context) {
        this.aok = mo4116a(context.getResources().getDisplayMetrics());
    }

    protected void onStart() {
    }

    protected void mo4117a(View view, s sVar, a aVar) {
        int z = m13502z(view, px());
        int y = m13501y(view, py());
        int dj = dj((int) Math.sqrt((double) ((z * z) + (y * y))));
        if (dj > 0) {
            aVar.a(-z, -y, dj, this.YU);
        }
    }

    protected void m13497a(int i, int i2, s sVar, a aVar) {
        if (getChildCount() == 0) {
            stop();
            return;
        }
        this.aol = am(this.aol, i);
        this.aom = am(this.aom, i2);
        if (this.aol == 0 && this.aom == 0) {
            m13498a(aVar);
        }
    }

    protected void onStop() {
        this.aom = 0;
        this.aol = 0;
        this.aoj = null;
    }

    protected float mo4116a(DisplayMetrics displayMetrics) {
        return 25.0f / ((float) displayMetrics.densityDpi);
    }

    protected int dj(int i) {
        return (int) Math.ceil(((double) dk(i)) / 0.3356d);
    }

    protected int dk(int i) {
        return (int) Math.ceil((double) (((float) Math.abs(i)) * this.aok));
    }

    protected int px() {
        if (this.aoj == null || this.aoj.x == 0.0f) {
            return 0;
        }
        return this.aoj.x > 0.0f ? 1 : -1;
    }

    protected int py() {
        if (this.aoj == null || this.aoj.y == 0.0f) {
            return 0;
        }
        return this.aoj.y > 0.0f ? 1 : -1;
    }

    protected void m13498a(a aVar) {
        PointF df = df(qZ());
        if (df == null || (df.x == 0.0f && df.y == 0.0f)) {
            aVar.dF(qZ());
            stop();
            return;
        }
        a(df);
        this.aoj = df;
        this.aol = (int) (df.x * 10000.0f);
        this.aom = (int) (df.y * 10000.0f);
        aVar.a((int) (((float) this.aol) * 1.2f), (int) (((float) this.aom) * 1.2f), (int) (((float) dk(FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL)) * 1.2f), this.aoi);
    }

    private int am(int i, int i2) {
        int i3 = i - i2;
        if (i * i3 <= 0) {
            return 0;
        }
        return i3;
    }

    public int m13500d(int i, int i2, int i3, int i4, int i5) {
        switch (i5) {
            case -1:
                return i3 - i;
            case 0:
                int i6 = i3 - i;
                if (i6 > 0) {
                    return i6;
                }
                i6 = i4 - i2;
                return i6 >= 0 ? 0 : i6;
            case 1:
                return i4 - i2;
            default:
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }

    public int m13501y(View view, int i) {
        h layoutManager = getLayoutManager();
        if (layoutManager == null || !layoutManager.pf()) {
            return 0;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return m13500d(layoutManager.ci(view) - layoutParams.topMargin, layoutManager.ck(view) + layoutParams.bottomMargin, layoutManager.getPaddingTop(), layoutManager.getHeight() - layoutManager.getPaddingBottom(), i);
    }

    public int m13502z(View view, int i) {
        h layoutManager = getLayoutManager();
        if (layoutManager == null || !layoutManager.pe()) {
            return 0;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return m13500d(layoutManager.ch(view) - layoutParams.leftMargin, layoutManager.cj(view) + layoutParams.rightMargin, layoutManager.getPaddingLeft(), layoutManager.getWidth() - layoutManager.getPaddingRight(), i);
    }

    public PointF df(int i) {
        h layoutManager = getLayoutManager();
        if (layoutManager instanceof b) {
            return ((b) layoutManager).df(i);
        }
        Log.w("LinearSmoothScroller", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
        return null;
    }
}
