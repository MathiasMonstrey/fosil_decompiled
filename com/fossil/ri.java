package com.fossil;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.fossil.wearables.fsl.fitness.FitnessProviderImpl;

public class ri {
    private static final int[] afU = new int[]{16843067, 16843068};
    private final ProgressBar akT;
    private Bitmap akU;

    public ri(ProgressBar progressBar) {
        this.akT = progressBar;
    }

    public void mo4071a(AttributeSet attributeSet, int i) {
        sw a = sw.m13583a(this.akT.getContext(), attributeSet, afU, i, 0);
        Drawable el = a.el(0);
        if (el != null) {
            this.akT.setIndeterminateDrawable(m13348r(el));
        }
        el = a.el(1);
        if (el != null) {
            this.akT.setProgressDrawable(m13347b(el, false));
        }
        a.recycle();
    }

    private Drawable m13347b(Drawable drawable, boolean z) {
        int i = 0;
        Drawable iM;
        if (drawable instanceof ho) {
            iM = ((ho) drawable).iM();
            if (iM != null) {
                ((ho) drawable).l(m13347b(iM, z));
            }
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                boolean z2;
                int id = layerDrawable.getId(i2);
                Drawable drawable2 = layerDrawable.getDrawable(i2);
                if (id == 16908301 || id == 16908303) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                drawableArr[i2] = m13347b(drawable2, z2);
            }
            iM = new LayerDrawable(drawableArr);
            while (i < numberOfLayers) {
                iM.setId(i, layerDrawable.getId(i));
                i++;
            }
            return iM;
        } else if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.akU == null) {
                this.akU = bitmap;
            }
            Drawable shapeDrawable = new ShapeDrawable(ow());
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, TileMode.REPEAT, TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
        }
        return drawable;
    }

    private Drawable m13348r(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        Drawable animationDrawable2 = new AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        for (int i = 0; i < numberOfFrames; i++) {
            Drawable b = m13347b(animationDrawable.getFrame(i), true);
            b.setLevel(FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL);
            animationDrawable2.addFrame(b, animationDrawable.getDuration(i));
        }
        animationDrawable2.setLevel(FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL);
        return animationDrawable2;
    }

    private Shape ow() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    public Bitmap ox() {
        return this.akU;
    }
}
