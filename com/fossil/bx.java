package com.fossil;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import org.xmlpull.v1.XmlPullParser;

public class bx implements Interpolator {
    private float[] DU;
    private float[] DV;

    public bx(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    public bx(Resources resources, Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray a = bz.m5835a(resources, theme, attributeSet, br.DD);
        m5758a(a, xmlPullParser);
        a.recycle();
    }

    private void m5758a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        if (bz.m5838a(xmlPullParser, "pathData")) {
            String a = bz.m5836a(typedArray, xmlPullParser, "pathData", 4);
            Path O = by.m5784O(a);
            if (O == null) {
                throw new InflateException("The path is null, which is created from " + a);
            }
            m5759a(O);
        } else if (!bz.m5838a(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        } else if (bz.m5838a(xmlPullParser, "controlY1")) {
            float a2 = bz.m5833a(typedArray, xmlPullParser, "controlX1", 0, 0.0f);
            float a3 = bz.m5833a(typedArray, xmlPullParser, "controlY1", 1, 0.0f);
            boolean a4 = bz.m5838a(xmlPullParser, "controlX2");
            if (a4 != bz.m5838a(xmlPullParser, "controlY2")) {
                throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
            } else if (a4) {
                m5757a(a2, a3, bz.m5833a(typedArray, xmlPullParser, "controlX2", 2, 0.0f), bz.m5833a(typedArray, xmlPullParser, "controlY2", 3, 0.0f));
            } else {
                m5760e(a2, a3);
            }
        } else {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
    }

    private void m5760e(float f, float f2) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f, f2, 1.0f, 1.0f);
        m5759a(path);
    }

    private void m5757a(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
        m5759a(path);
    }

    private void m5759a(Path path) {
        int i = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int min = Math.min(3000, ((int) (length / 0.002f)) + 1);
        if (min <= 0) {
            throw new IllegalArgumentException("The Path has a invalid length " + length);
        }
        int i2;
        this.DU = new float[min];
        this.DV = new float[min];
        float[] fArr = new float[2];
        for (i2 = 0; i2 < min; i2++) {
            pathMeasure.getPosTan((((float) i2) * length) / ((float) (min - 1)), fArr, null);
            this.DU[i2] = fArr[0];
            this.DV[i2] = fArr[1];
        }
        if (((double) Math.abs(this.DU[0])) > 1.0E-5d || ((double) Math.abs(this.DV[0])) > 1.0E-5d || ((double) Math.abs(this.DU[min - 1] - 1.0f)) > 1.0E-5d || ((double) Math.abs(this.DV[min - 1] - 1.0f)) > 1.0E-5d) {
            throw new IllegalArgumentException("The Path must start at (0,0) and end at (1,1) start: " + this.DU[0] + "," + this.DV[0] + " end:" + this.DU[min - 1] + "," + this.DV[min - 1]);
        }
        float f = 0.0f;
        i2 = 0;
        while (i < min) {
            int i3 = i2 + 1;
            float f2 = this.DU[i2];
            if (f2 < f) {
                throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + f2);
            }
            this.DU[i] = f2;
            i++;
            f = f2;
            i2 = i3;
        }
        if (pathMeasure.nextContour()) {
            throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
        }
    }

    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int i = 0;
        int length = this.DU.length - 1;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.DU[i2]) {
                length = i;
            } else {
                int i3 = length;
                length = i2;
                i2 = i3;
            }
            i = length;
            length = i2;
        }
        float f2 = this.DU[length] - this.DU[i];
        if (f2 == 0.0f) {
            return this.DV[i];
        }
        f2 = (f - this.DU[i]) / f2;
        float f3 = this.DV[i];
        return (f2 * (this.DV[length] - f3)) + f3;
    }
}
