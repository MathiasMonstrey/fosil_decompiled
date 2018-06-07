package com.fossil;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;

public class drt extends ShapeDrawable {
    private final Paint borderPaint;
    private final Paint caf;
    private final float ccq;
    private final int color;
    private final RectShape dnj;
    private final int dnk;
    private final int dnl;
    private boolean dnm;
    private final int height;
    private final String text;
    private final int width;

    public interface C3147b {
    }

    public interface C3148c {
        C3149d awe();

        C3148c lR(int i);

        C3148c lS(int i);

        C3148c lT(int i);

        C3148c lU(int i);
    }

    public interface C3149d {
        drt mo2668I(String str, int i);

        C3148c awd();
    }

    public static class C3150a implements C3147b, C3148c, C3149d {
        public float ccq;
        private int color;
        private RectShape dnj;
        private int dnk;
        private int dnl;
        private Typeface dnn;
        private boolean dno;
        private boolean dnp;
        private int height;
        private String text;
        public int textColor;
        private int width;

        private C3150a() {
            this.text = "";
            this.color = -7829368;
            this.textColor = -1;
            this.dnl = 0;
            this.width = -1;
            this.height = -1;
            this.dnj = new RectShape();
            this.dnn = Typeface.create("sans-serif-light", 0);
            this.dnk = -1;
            this.dno = false;
            this.dnp = false;
        }

        public C3148c lR(int i) {
            this.width = i;
            return this;
        }

        public C3148c lS(int i) {
            this.height = i;
            return this;
        }

        public C3148c lT(int i) {
            this.textColor = i;
            return this;
        }

        public C3148c lU(int i) {
            this.dnk = i;
            return this;
        }

        public C3148c awd() {
            return this;
        }

        public C3149d awe() {
            return this;
        }

        public C3147b awf() {
            this.dnj = new RectShape();
            return this;
        }

        public drt mo2668I(String str, int i) {
            awf();
            return m9552J(str, i);
        }

        public drt m9552J(String str, int i) {
            this.color = i;
            this.text = str;
            return new drt();
        }
    }

    public void du(boolean z) {
        this.dnm = z;
    }

    private drt(C3150a c3150a) {
        super(c3150a.dnj);
        this.dnj = c3150a.dnj;
        this.height = c3150a.height;
        this.width = c3150a.width;
        this.ccq = c3150a.ccq;
        this.text = c3150a.dnp ? c3150a.text.toUpperCase() : c3150a.text;
        this.color = c3150a.color;
        this.dnk = c3150a.dnk;
        this.caf = new Paint();
        this.caf.setColor(c3150a.textColor);
        this.caf.setAntiAlias(true);
        this.caf.setFakeBoldText(c3150a.dno);
        this.caf.setStyle(Style.FILL);
        this.caf.setTypeface(c3150a.dnn);
        this.caf.setTextAlign(Align.CENTER);
        this.caf.setStrokeWidth((float) c3150a.dnl);
        this.dnl = c3150a.dnl;
        this.borderPaint = new Paint();
        this.borderPaint.setAntiAlias(true);
        this.borderPaint.setColor(lQ(this.color));
        this.borderPaint.setStyle(Style.STROKE);
        this.borderPaint.setStrokeWidth((float) this.dnl);
        Paint paint = getPaint();
        paint.setAntiAlias(true);
        paint.setColor(this.color);
    }

    private int lQ(int i) {
        return Color.rgb((int) (((float) Color.red(i)) * 0.9f), (int) (((float) Color.green(i)) * 0.9f), (int) (((float) Color.blue(i)) * 0.9f));
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        Rect bounds = getBounds();
        if (this.dnl > 0) {
            m9553L(canvas);
        }
        int save = canvas.save();
        canvas.translate((float) bounds.left, (float) bounds.top);
        int width = this.width < 0 ? bounds.width() : this.width;
        int height = this.height < 0 ? bounds.height() : this.height;
        this.caf.setTextSize((float) (this.dnk < 0 ? Math.min(width, height) / 2 : this.dnk));
        if (this.dnm) {
            canvas.drawText(this.text, (float) ((width / 2) - (width / 6)), (((float) (height / 2)) - (this.caf.descent() + (this.caf.ascent() / 2.0f))) - ((float) (height / 6)), this.caf);
        } else {
            canvas.drawText(this.text, (float) (width / 2), ((float) (height / 2)) - ((this.caf.descent() + (this.caf.ascent() / 2.0f)) + (this.caf.ascent() / 6.0f)), this.caf);
        }
        canvas.restoreToCount(save);
    }

    private void m9553L(Canvas canvas) {
        RectF rectF = new RectF(getBounds());
        rectF.inset((float) (this.dnl / 2), (float) (this.dnl / 2));
        if (this.dnj instanceof OvalShape) {
            canvas.drawOval(rectF, this.borderPaint);
        } else if (this.dnj instanceof RoundRectShape) {
            canvas.drawRoundRect(rectF, this.ccq, this.ccq, this.borderPaint);
        } else {
            canvas.drawRect(rectF, this.borderPaint);
        }
    }

    public void setAlpha(int i) {
        this.caf.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.caf.setColorFilter(colorFilter);
    }

    public int getOpacity() {
        return -3;
    }

    public int getIntrinsicWidth() {
        return this.width;
    }

    public int getIntrinsicHeight() {
        return this.height;
    }

    public static C3149d awc() {
        return new C3150a();
    }
}
