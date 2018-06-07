package com.fossil;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public class nf extends ImageView {
    private AnimationListener VE;
    int VF;

    class C3912a extends OvalShape {
        private RadialGradient VG;
        private Paint VH = new Paint();
        final /* synthetic */ nf VI;

        C3912a(nf nfVar, int i) {
            this.VI = nfVar;
            nfVar.VF = i;
            bK((int) rect().width());
        }

        protected void onResize(float f, float f2) {
            super.onResize(f, f2);
            bK((int) f);
        }

        public void draw(Canvas canvas, Paint paint) {
            int width = this.VI.getWidth();
            int height = this.VI.getHeight();
            canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) (width / 2), this.VH);
            canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) ((width / 2) - this.VI.VF), paint);
        }

        private void bK(int i) {
            this.VG = new RadialGradient((float) (i / 2), (float) (i / 2), (float) this.VI.VF, new int[]{1023410176, 0}, null, TileMode.CLAMP);
            this.VH.setShader(this.VG);
        }
    }

    public nf(Context context, int i) {
        Drawable shapeDrawable;
        super(context);
        float f = getContext().getResources().getDisplayMetrics().density;
        int i2 = (int) (1.75f * f);
        int i3 = (int) (0.0f * f);
        this.VF = (int) (3.5f * f);
        if (km()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            li.l(this, f * 4.0f);
        } else {
            shapeDrawable = new ShapeDrawable(new C3912a(this, this.VF));
            li.a(this, 1, shapeDrawable.getPaint());
            shapeDrawable.getPaint().setShadowLayer((float) this.VF, (float) i3, (float) i2, 503316480);
            int i4 = this.VF;
            setPadding(i4, i4, i4, i4);
        }
        shapeDrawable.getPaint().setColor(i);
        li.a(this, shapeDrawable);
    }

    private boolean km() {
        return VERSION.SDK_INT >= 21;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!km()) {
            setMeasuredDimension(getMeasuredWidth() + (this.VF * 2), getMeasuredHeight() + (this.VF * 2));
        }
    }

    public void setAnimationListener(AnimationListener animationListener) {
        this.VE = animationListener;
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        if (this.VE != null) {
            this.VE.onAnimationStart(getAnimation());
        }
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.VE != null) {
            this.VE.onAnimationEnd(getAnimation());
        }
    }

    public void bJ(int i) {
        setBackgroundColor(gn.e(getContext(), i));
    }

    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }
}
