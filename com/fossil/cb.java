package com.fossil;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import com.fossil.by.C1971b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class cb extends ca {
    static final Mode Eb = Mode.SRC_IN;
    private C1988f Ec;
    private PorterDuffColorFilter Ed;
    private ColorFilter Ee;
    private boolean Ef;
    private boolean Eg;
    private ConstantState Eh;
    private final float[] Ei;
    private final Matrix Ej;
    private final Rect Ek;

    static class C1983d {
        int DK;
        protected C1971b[] EK = null;
        String EL;

        public C1983d(C1983d c1983d) {
            this.EL = c1983d.EL;
            this.DK = c1983d.DK;
            this.EK = by.m5790a(c1983d.EK);
        }

        public void m5915b(Path path) {
            path.reset();
            if (this.EK != null) {
                C1971b.m5782a(this.EK, path);
            }
        }

        public String getPathName() {
            return this.EL;
        }

        public boolean hm() {
            return false;
        }

        public C1971b[] getPathData() {
            return this.EK;
        }

        public void setPathData(C1971b[] c1971bArr) {
            if (by.m5789a(this.EK, c1971bArr)) {
                by.m5791b(this.EK, c1971bArr);
            } else {
                this.EK = by.m5790a(c1971bArr);
            }
        }
    }

    static class C1984a extends C1983d {
        public C1984a(C1984a c1984a) {
            super(c1984a);
        }

        public void m5917a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            if (bz.m5838a(xmlPullParser, "pathData")) {
                TypedArray a = bz.m5835a(resources, theme, attributeSet, br.Dv);
                m5916a(a);
                a.recycle();
            }
        }

        private void m5916a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.EL = string;
            }
            string = typedArray.getString(1);
            if (string != null) {
                this.EK = by.m5785P(string);
            }
        }

        public boolean hm() {
            return true;
        }
    }

    static class C1985b extends C1983d {
        private int[] El;
        int Em = 0;
        float En = 0.0f;
        int Eo = 0;
        float Ep = 1.0f;
        int Eq = 0;
        float Er = 1.0f;
        float Es = 0.0f;
        float Et = 1.0f;
        float Eu = 0.0f;
        Cap Ev = Cap.BUTT;
        Join Ew = Join.MITER;
        float Ex = 4.0f;

        public C1985b(C1985b c1985b) {
            super(c1985b);
            this.El = c1985b.El;
            this.Em = c1985b.Em;
            this.En = c1985b.En;
            this.Ep = c1985b.Ep;
            this.Eo = c1985b.Eo;
            this.Eq = c1985b.Eq;
            this.Er = c1985b.Er;
            this.Es = c1985b.Es;
            this.Et = c1985b.Et;
            this.Eu = c1985b.Eu;
            this.Ev = c1985b.Ev;
            this.Ew = c1985b.Ew;
            this.Ex = c1985b.Ex;
        }

        private Cap m5918a(int i, Cap cap) {
            switch (i) {
                case 0:
                    return Cap.BUTT;
                case 1:
                    return Cap.ROUND;
                case 2:
                    return Cap.SQUARE;
                default:
                    return cap;
            }
        }

        private Join m5919a(int i, Join join) {
            switch (i) {
                case 0:
                    return Join.MITER;
                case 1:
                    return Join.ROUND;
                case 2:
                    return Join.BEVEL;
                default:
                    return join;
            }
        }

        public void m5921a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a = bz.m5835a(resources, theme, attributeSet, br.Du);
            m5920b(a, xmlPullParser);
            a.recycle();
        }

        private void m5920b(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.El = null;
            if (bz.m5838a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.EL = string;
                }
                string = typedArray.getString(2);
                if (string != null) {
                    this.EK = by.m5785P(string);
                }
                this.Eo = bz.m5839b(typedArray, xmlPullParser, "fillColor", 1, this.Eo);
                this.Er = bz.m5833a(typedArray, xmlPullParser, "fillAlpha", 12, this.Er);
                this.Ev = m5918a(bz.m5834a(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.Ev);
                this.Ew = m5919a(bz.m5834a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.Ew);
                this.Ex = bz.m5833a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.Ex);
                this.Em = bz.m5839b(typedArray, xmlPullParser, "strokeColor", 3, this.Em);
                this.Ep = bz.m5833a(typedArray, xmlPullParser, "strokeAlpha", 11, this.Ep);
                this.En = bz.m5833a(typedArray, xmlPullParser, "strokeWidth", 4, this.En);
                this.Et = bz.m5833a(typedArray, xmlPullParser, "trimPathEnd", 6, this.Et);
                this.Eu = bz.m5833a(typedArray, xmlPullParser, "trimPathOffset", 7, this.Eu);
                this.Es = bz.m5833a(typedArray, xmlPullParser, "trimPathStart", 5, this.Es);
                this.Eq = bz.m5834a(typedArray, xmlPullParser, "fillType", 13, this.Eq);
            }
        }

        int getStrokeColor() {
            return this.Em;
        }

        void setStrokeColor(int i) {
            this.Em = i;
        }

        float getStrokeWidth() {
            return this.En;
        }

        void setStrokeWidth(float f) {
            this.En = f;
        }

        float getStrokeAlpha() {
            return this.Ep;
        }

        void setStrokeAlpha(float f) {
            this.Ep = f;
        }

        int getFillColor() {
            return this.Eo;
        }

        void setFillColor(int i) {
            this.Eo = i;
        }

        float getFillAlpha() {
            return this.Er;
        }

        void setFillAlpha(float f) {
            this.Er = f;
        }

        float getTrimPathStart() {
            return this.Es;
        }

        void setTrimPathStart(float f) {
            this.Es = f;
        }

        float getTrimPathEnd() {
            return this.Et;
        }

        void setTrimPathEnd(float f) {
            this.Et = f;
        }

        float getTrimPathOffset() {
            return this.Eu;
        }

        void setTrimPathOffset(float f) {
            this.Eu = f;
        }
    }

    static class C1986c {
        int DK;
        private float EB = 0.0f;
        private float EC = 0.0f;
        private float ED = 1.0f;
        private float EF = 1.0f;
        private float EG = 0.0f;
        private float EH = 0.0f;
        private final Matrix EI = new Matrix();
        private String EJ = null;
        private int[] El;
        private final Matrix Ey = new Matrix();
        float Ez = 0.0f;
        final ArrayList<Object> tj = new ArrayList();

        public C1986c(C1986c c1986c, jl<String, Object> jlVar) {
            this.Ez = c1986c.Ez;
            this.EB = c1986c.EB;
            this.EC = c1986c.EC;
            this.ED = c1986c.ED;
            this.EF = c1986c.EF;
            this.EG = c1986c.EG;
            this.EH = c1986c.EH;
            this.El = c1986c.El;
            this.EJ = c1986c.EJ;
            this.DK = c1986c.DK;
            if (this.EJ != null) {
                jlVar.put(this.EJ, this);
            }
            this.EI.set(c1986c.EI);
            ArrayList arrayList = c1986c.tj;
            for (int i = 0; i < arrayList.size(); i++) {
                Object obj = arrayList.get(i);
                if (obj instanceof C1986c) {
                    this.tj.add(new C1986c((C1986c) obj, jlVar));
                } else {
                    C1983d c1985b;
                    if (obj instanceof C1985b) {
                        c1985b = new C1985b((C1985b) obj);
                    } else if (obj instanceof C1984a) {
                        c1985b = new C1984a((C1984a) obj);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.tj.add(c1985b);
                    if (c1985b.EL != null) {
                        jlVar.put(c1985b.EL, c1985b);
                    }
                }
            }
        }

        public String getGroupName() {
            return this.EJ;
        }

        public Matrix getLocalMatrix() {
            return this.EI;
        }

        public void m5925a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a = bz.m5835a(resources, theme, attributeSet, br.Dt);
            m5924b(a, xmlPullParser);
            a.recycle();
        }

        private void m5924b(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.El = null;
            this.Ez = bz.m5833a(typedArray, xmlPullParser, "rotation", 5, this.Ez);
            this.EB = typedArray.getFloat(1, this.EB);
            this.EC = typedArray.getFloat(2, this.EC);
            this.ED = bz.m5833a(typedArray, xmlPullParser, "scaleX", 3, this.ED);
            this.EF = bz.m5833a(typedArray, xmlPullParser, "scaleY", 4, this.EF);
            this.EG = bz.m5833a(typedArray, xmlPullParser, "translateX", 6, this.EG);
            this.EH = bz.m5833a(typedArray, xmlPullParser, "translateY", 7, this.EH);
            String string = typedArray.getString(0);
            if (string != null) {
                this.EJ = string;
            }
            hn();
        }

        private void hn() {
            this.EI.reset();
            this.EI.postTranslate(-this.EB, -this.EC);
            this.EI.postScale(this.ED, this.EF);
            this.EI.postRotate(this.Ez, 0.0f, 0.0f);
            this.EI.postTranslate(this.EG + this.EB, this.EH + this.EC);
        }

        public float getRotation() {
            return this.Ez;
        }

        public void setRotation(float f) {
            if (f != this.Ez) {
                this.Ez = f;
                hn();
            }
        }

        public float getPivotX() {
            return this.EB;
        }

        public void setPivotX(float f) {
            if (f != this.EB) {
                this.EB = f;
                hn();
            }
        }

        public float getPivotY() {
            return this.EC;
        }

        public void setPivotY(float f) {
            if (f != this.EC) {
                this.EC = f;
                hn();
            }
        }

        public float getScaleX() {
            return this.ED;
        }

        public void setScaleX(float f) {
            if (f != this.ED) {
                this.ED = f;
                hn();
            }
        }

        public float getScaleY() {
            return this.EF;
        }

        public void setScaleY(float f) {
            if (f != this.EF) {
                this.EF = f;
                hn();
            }
        }

        public float getTranslateX() {
            return this.EG;
        }

        public void setTranslateX(float f) {
            if (f != this.EG) {
                this.EG = f;
                hn();
            }
        }

        public float getTranslateY() {
            return this.EH;
        }

        public void setTranslateY(float f) {
            if (f != this.EH) {
                this.EH = f;
                hn();
            }
        }
    }

    static class C1987e {
        private static final Matrix EO = new Matrix();
        private int DK;
        private final Path EM;
        private final Path EN;
        private final Matrix EP;
        private Paint EQ;
        private Paint ER;
        private PathMeasure ES;
        final C1986c ET;
        float EU;
        float EV;
        float EW;
        float EX;
        int EY;
        String EZ;
        final jl<String, Object> Fa;

        public C1987e() {
            this.EP = new Matrix();
            this.EU = 0.0f;
            this.EV = 0.0f;
            this.EW = 0.0f;
            this.EX = 0.0f;
            this.EY = 255;
            this.EZ = null;
            this.Fa = new jl();
            this.ET = new C1986c();
            this.EM = new Path();
            this.EN = new Path();
        }

        public void setRootAlpha(int i) {
            this.EY = i;
        }

        public int getRootAlpha() {
            return this.EY;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (255.0f * f));
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public C1987e(C1987e c1987e) {
            this.EP = new Matrix();
            this.EU = 0.0f;
            this.EV = 0.0f;
            this.EW = 0.0f;
            this.EX = 0.0f;
            this.EY = 255;
            this.EZ = null;
            this.Fa = new jl();
            this.ET = new C1986c(c1987e.ET, this.Fa);
            this.EM = new Path(c1987e.EM);
            this.EN = new Path(c1987e.EN);
            this.EU = c1987e.EU;
            this.EV = c1987e.EV;
            this.EW = c1987e.EW;
            this.EX = c1987e.EX;
            this.DK = c1987e.DK;
            this.EY = c1987e.EY;
            this.EZ = c1987e.EZ;
            if (c1987e.EZ != null) {
                this.Fa.put(c1987e.EZ, this);
            }
        }

        private void m5929a(C1986c c1986c, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            c1986c.Ey.set(matrix);
            c1986c.Ey.preConcat(c1986c.EI);
            canvas.save();
            for (int i3 = 0; i3 < c1986c.tj.size(); i3++) {
                Object obj = c1986c.tj.get(i3);
                if (obj instanceof C1986c) {
                    m5929a((C1986c) obj, c1986c.Ey, canvas, i, i2, colorFilter);
                } else if (obj instanceof C1983d) {
                    m5930a(c1986c, (C1983d) obj, canvas, i, i2, colorFilter);
                }
            }
            canvas.restore();
        }

        public void m5934a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            m5929a(this.ET, EO, canvas, i, i2, colorFilter);
        }

        private void m5930a(C1986c c1986c, C1983d c1983d, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = ((float) i) / this.EW;
            float f2 = ((float) i2) / this.EX;
            float min = Math.min(f, f2);
            Matrix a = c1986c.Ey;
            this.EP.set(a);
            this.EP.postScale(f, f2);
            f2 = m5926a(a);
            if (f2 != 0.0f) {
                c1983d.m5915b(this.EM);
                Path path = this.EM;
                this.EN.reset();
                if (c1983d.hm()) {
                    this.EN.addPath(path, this.EP);
                    canvas.clipPath(this.EN);
                    return;
                }
                C1985b c1985b = (C1985b) c1983d;
                if (!(c1985b.Es == 0.0f && c1985b.Et == 1.0f)) {
                    float f3 = (c1985b.Es + c1985b.Eu) % 1.0f;
                    float f4 = (c1985b.Et + c1985b.Eu) % 1.0f;
                    if (this.ES == null) {
                        this.ES = new PathMeasure();
                    }
                    this.ES.setPath(this.EM, false);
                    float length = this.ES.getLength();
                    f3 *= length;
                    f4 *= length;
                    path.reset();
                    if (f3 > f4) {
                        this.ES.getSegment(f3, length, path, true);
                        this.ES.getSegment(0.0f, f4, path, true);
                    } else {
                        this.ES.getSegment(f3, f4, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.EN.addPath(path, this.EP);
                if (c1985b.Eo != 0) {
                    if (this.ER == null) {
                        this.ER = new Paint();
                        this.ER.setStyle(Style.FILL);
                        this.ER.setAntiAlias(true);
                    }
                    Paint paint = this.ER;
                    paint.setColor(cb.m5945c(c1985b.Eo, c1985b.Er));
                    paint.setColorFilter(colorFilter);
                    this.EN.setFillType(c1985b.Eq == 0 ? FillType.WINDING : FillType.EVEN_ODD);
                    canvas.drawPath(this.EN, paint);
                }
                if (c1985b.Em != 0) {
                    if (this.EQ == null) {
                        this.EQ = new Paint();
                        this.EQ.setStyle(Style.STROKE);
                        this.EQ.setAntiAlias(true);
                    }
                    Paint paint2 = this.EQ;
                    if (c1985b.Ew != null) {
                        paint2.setStrokeJoin(c1985b.Ew);
                    }
                    if (c1985b.Ev != null) {
                        paint2.setStrokeCap(c1985b.Ev);
                    }
                    paint2.setStrokeMiter(c1985b.Ex);
                    paint2.setColor(cb.m5945c(c1985b.Em, c1985b.Ep));
                    paint2.setColorFilter(colorFilter);
                    paint2.setStrokeWidth((f2 * min) * c1985b.En);
                    canvas.drawPath(this.EN, paint2);
                }
            }
        }

        private static float m5931b(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        private float m5926a(Matrix matrix) {
            float[] fArr = new float[]{0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float hypot = (float) Math.hypot((double) fArr[0], (double) fArr[1]);
            float hypot2 = (float) Math.hypot((double) fArr[2], (double) fArr[3]);
            float b = C1987e.m5931b(fArr[0], fArr[1], fArr[2], fArr[3]);
            hypot = Math.max(hypot, hypot2);
            if (hypot > 0.0f) {
                return Math.abs(b) / hypot;
            }
            return 0.0f;
        }
    }

    static class C1988f extends ConstantState {
        int DK;
        C1987e Fb;
        ColorStateList Fc;
        Mode Fd;
        boolean Fe;
        Bitmap Ff;
        ColorStateList Fg;
        Mode Fh;
        int Fi;
        boolean Fj;
        boolean Fk;
        Paint Fl;

        public C1988f(C1988f c1988f) {
            this.Fc = null;
            this.Fd = cb.Eb;
            if (c1988f != null) {
                this.DK = c1988f.DK;
                this.Fb = new C1987e(c1988f.Fb);
                if (c1988f.Fb.ER != null) {
                    this.Fb.ER = new Paint(c1988f.Fb.ER);
                }
                if (c1988f.Fb.EQ != null) {
                    this.Fb.EQ = new Paint(c1988f.Fb.EQ);
                }
                this.Fc = c1988f.Fc;
                this.Fd = c1988f.Fd;
                this.Fe = c1988f.Fe;
            }
        }

        public void m5936a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.Ff, null, rect, m5935a(colorFilter));
        }

        public boolean ho() {
            return this.Fb.getRootAlpha() < 255;
        }

        public Paint m5935a(ColorFilter colorFilter) {
            if (!ho() && colorFilter == null) {
                return null;
            }
            if (this.Fl == null) {
                this.Fl = new Paint();
                this.Fl.setFilterBitmap(true);
            }
            this.Fl.setAlpha(this.Fb.getRootAlpha());
            this.Fl.setColorFilter(colorFilter);
            return this.Fl;
        }

        public void m5937r(int i, int i2) {
            this.Ff.eraseColor(0);
            this.Fb.m5934a(new Canvas(this.Ff), i, i2, null);
        }

        public void m5938s(int i, int i2) {
            if (this.Ff == null || !m5939t(i, i2)) {
                this.Ff = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
                this.Fk = true;
            }
        }

        public boolean m5939t(int i, int i2) {
            if (i == this.Ff.getWidth() && i2 == this.Ff.getHeight()) {
                return true;
            }
            return false;
        }

        public boolean hp() {
            if (!this.Fk && this.Fg == this.Fc && this.Fh == this.Fd && this.Fj == this.Fe && this.Fi == this.Fb.getRootAlpha()) {
                return true;
            }
            return false;
        }

        public void hq() {
            this.Fg = this.Fc;
            this.Fh = this.Fd;
            this.Fi = this.Fb.getRootAlpha();
            this.Fj = this.Fe;
            this.Fk = false;
        }

        public C1988f() {
            this.Fc = null;
            this.Fd = cb.Eb;
            this.Fb = new C1987e();
        }

        public Drawable newDrawable() {
            return new cb(this);
        }

        public Drawable newDrawable(Resources resources) {
            return new cb(this);
        }

        public int getChangingConfigurations() {
            return this.DK;
        }
    }

    static class C1989g extends ConstantState {
        private final ConstantState DQ;

        public C1989g(ConstantState constantState) {
            this.DQ = constantState;
        }

        public Drawable newDrawable() {
            Drawable cbVar = new cb();
            cbVar.Ea = (VectorDrawable) this.DQ.newDrawable();
            return cbVar;
        }

        public Drawable newDrawable(Resources resources) {
            Drawable cbVar = new cb();
            cbVar.Ea = (VectorDrawable) this.DQ.newDrawable(resources);
            return cbVar;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            Drawable cbVar = new cb();
            cbVar.Ea = (VectorDrawable) this.DQ.newDrawable(resources, theme);
            return cbVar;
        }

        public boolean canApplyTheme() {
            return this.DQ.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.DQ.getChangingConfigurations();
        }
    }

    public /* bridge */ /* synthetic */ void applyTheme(Theme theme) {
        super.applyTheme(theme);
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    cb() {
        this.Eg = true;
        this.Ei = new float[9];
        this.Ej = new Matrix();
        this.Ek = new Rect();
        this.Ec = new C1988f();
    }

    cb(C1988f c1988f) {
        this.Eg = true;
        this.Ei = new float[9];
        this.Ej = new Matrix();
        this.Ek = new Rect();
        this.Ec = c1988f;
        this.Ed = m5947a(this.Ed, c1988f.Fc, c1988f.Fd);
    }

    public Drawable mutate() {
        if (this.Ea != null) {
            this.Ea.mutate();
        } else if (!this.Ef && super.mutate() == this) {
            this.Ec = new C1988f(this.Ec);
            this.Ef = true;
        }
        return this;
    }

    Object m5946R(String str) {
        return this.Ec.Fb.Fa.get(str);
    }

    public ConstantState getConstantState() {
        if (this.Ea != null) {
            return new C1989g(this.Ea.getConstantState());
        }
        this.Ec.DK = getChangingConfigurations();
        return this.Ec;
    }

    public void draw(Canvas canvas) {
        if (this.Ea != null) {
            this.Ea.draw(canvas);
            return;
        }
        copyBounds(this.Ek);
        if (this.Ek.width() > 0 && this.Ek.height() > 0) {
            ColorFilter colorFilter = this.Ee == null ? this.Ed : this.Ee;
            canvas.getMatrix(this.Ej);
            this.Ej.getValues(this.Ei);
            float abs = Math.abs(this.Ei[0]);
            float abs2 = Math.abs(this.Ei[4]);
            float abs3 = Math.abs(this.Ei[1]);
            float abs4 = Math.abs(this.Ei[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs2 = 1.0f;
                abs = 1.0f;
            }
            int height = (int) (abs2 * ((float) this.Ek.height()));
            int min = Math.min(2048, (int) (abs * ((float) this.Ek.width())));
            height = Math.min(2048, height);
            if (min > 0 && height > 0) {
                int save = canvas.save();
                canvas.translate((float) this.Ek.left, (float) this.Ek.top);
                if (hl()) {
                    canvas.translate((float) this.Ek.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.Ek.offsetTo(0, 0);
                this.Ec.m5938s(min, height);
                if (!this.Eg) {
                    this.Ec.m5937r(min, height);
                } else if (!this.Ec.hp()) {
                    this.Ec.m5937r(min, height);
                    this.Ec.hq();
                }
                this.Ec.m5936a(canvas, colorFilter, this.Ek);
                canvas.restoreToCount(save);
            }
        }
    }

    public int getAlpha() {
        if (this.Ea != null) {
            return hh.m11631e(this.Ea);
        }
        return this.Ec.Fb.getRootAlpha();
    }

    public void setAlpha(int i) {
        if (this.Ea != null) {
            this.Ea.setAlpha(i);
        } else if (this.Ec.Fb.getRootAlpha() != i) {
            this.Ec.Fb.setRootAlpha(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.Ea != null) {
            this.Ea.setColorFilter(colorFilter);
            return;
        }
        this.Ee = colorFilter;
        invalidateSelf();
    }

    PorterDuffColorFilter m5947a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @SuppressLint({"NewApi"})
    public void setTint(int i) {
        if (this.Ea != null) {
            hh.m11621a(this.Ea, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.Ea != null) {
            hh.m11623a(this.Ea, colorStateList);
            return;
        }
        C1988f c1988f = this.Ec;
        if (c1988f.Fc != colorStateList) {
            c1988f.Fc = colorStateList;
            this.Ed = m5947a(this.Ed, colorStateList, c1988f.Fd);
            invalidateSelf();
        }
    }

    public void setTintMode(Mode mode) {
        if (this.Ea != null) {
            hh.m11626a(this.Ea, mode);
            return;
        }
        C1988f c1988f = this.Ec;
        if (c1988f.Fd != mode) {
            c1988f.Fd = mode;
            this.Ed = m5947a(this.Ed, c1988f.Fc, mode);
            invalidateSelf();
        }
    }

    public boolean isStateful() {
        if (this.Ea != null) {
            return this.Ea.isStateful();
        }
        return super.isStateful() || !(this.Ec == null || this.Ec.Fc == null || !this.Ec.Fc.isStateful());
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.Ea != null) {
            return this.Ea.setState(iArr);
        }
        C1988f c1988f = this.Ec;
        if (c1988f.Fc == null || c1988f.Fd == null) {
            return false;
        }
        this.Ed = m5947a(this.Ed, c1988f.Fc, c1988f.Fd);
        invalidateSelf();
        return true;
    }

    public int getOpacity() {
        if (this.Ea != null) {
            return this.Ea.getOpacity();
        }
        return -3;
    }

    public int getIntrinsicWidth() {
        if (this.Ea != null) {
            return this.Ea.getIntrinsicWidth();
        }
        return (int) this.Ec.Fb.EU;
    }

    public int getIntrinsicHeight() {
        if (this.Ea != null) {
            return this.Ea.getIntrinsicHeight();
        }
        return (int) this.Ec.Fb.EV;
    }

    public boolean canApplyTheme() {
        if (this.Ea != null) {
            hh.m11632f(this.Ea);
        }
        return false;
    }

    public boolean isAutoMirrored() {
        if (this.Ea != null) {
            return hh.m11630d(this.Ea);
        }
        return this.Ec.Fe;
    }

    public void setAutoMirrored(boolean z) {
        if (this.Ea != null) {
            hh.m11627a(this.Ea, z);
        } else {
            this.Ec.Fe = z;
        }
    }

    @SuppressLint({"NewApi"})
    public static cb m5940a(Resources resources, int i, Theme theme) {
        if (VERSION.SDK_INT >= 24) {
            cb cbVar = new cb();
            cbVar.Ea = he.m11561b(resources, i, theme);
            cbVar.Eh = new C1989g(cbVar.Ea.getConstantState());
            return cbVar;
        }
        try {
            int next;
            XmlPullParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return m5941a(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (Throwable e) {
            Log.e("VectorDrawableCompat", "parser error", e);
            return null;
        } catch (Throwable e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        }
    }

    @SuppressLint({"NewApi"})
    public static cb m5941a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        cb cbVar = new cb();
        cbVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return cbVar;
    }

    static int m5945c(int i, float f) {
        return (((int) (((float) Color.alpha(i)) * f)) << 24) | (16777215 & i);
    }

    @SuppressLint({"NewApi"})
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        if (this.Ea != null) {
            this.Ea.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        if (this.Ea != null) {
            hh.m11625a(this.Ea, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C1988f c1988f = this.Ec;
        c1988f.Fb = new C1987e();
        TypedArray a = bz.m5835a(resources, theme, attributeSet, br.Ds);
        m5944b(a, xmlPullParser);
        a.recycle();
        c1988f.DK = getChangingConfigurations();
        c1988f.Fk = true;
        m5943b(resources, xmlPullParser, attributeSet, theme);
        this.Ed = m5947a(this.Ed, c1988f.Fc, c1988f.Fd);
    }

    private static Mode m5942b(int i, Mode mode) {
        switch (i) {
            case 3:
                return Mode.SRC_OVER;
            case 5:
                return Mode.SRC_IN;
            case 9:
                return Mode.SRC_ATOP;
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                if (VERSION.SDK_INT >= 11) {
                    return Mode.ADD;
                }
                return mode;
            default:
                return mode;
        }
    }

    private void m5944b(TypedArray typedArray, XmlPullParser xmlPullParser) throws XmlPullParserException {
        C1988f c1988f = this.Ec;
        C1987e c1987e = c1988f.Fb;
        c1988f.Fd = m5942b(bz.m5834a(typedArray, xmlPullParser, "tintMode", 6, -1), Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            c1988f.Fc = colorStateList;
        }
        c1988f.Fe = bz.m5837a(typedArray, xmlPullParser, "autoMirrored", 5, c1988f.Fe);
        c1987e.EW = bz.m5833a(typedArray, xmlPullParser, "viewportWidth", 7, c1987e.EW);
        c1987e.EX = bz.m5833a(typedArray, xmlPullParser, "viewportHeight", 8, c1987e.EX);
        if (c1987e.EW <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (c1987e.EX <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        } else {
            c1987e.EU = typedArray.getDimension(3, c1987e.EU);
            c1987e.EV = typedArray.getDimension(2, c1987e.EV);
            if (c1987e.EU <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (c1987e.EV <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            } else {
                c1987e.setAlpha(bz.m5833a(typedArray, xmlPullParser, "alpha", 4, c1987e.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    c1987e.EZ = string;
                    c1987e.Fa.put(string, c1987e);
                }
            }
        }
    }

    private void m5943b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        C1988f c1988f = this.Ec;
        C1987e c1987e = c1988f.Fb;
        Stack stack = new Stack();
        stack.push(c1987e.ET);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        Object obj = 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                Object obj2;
                String name = xmlPullParser.getName();
                C1986c c1986c = (C1986c) stack.peek();
                if ("path".equals(name)) {
                    C1985b c1985b = new C1985b();
                    c1985b.m5921a(resources, attributeSet, theme, xmlPullParser);
                    c1986c.tj.add(c1985b);
                    if (c1985b.getPathName() != null) {
                        c1987e.Fa.put(c1985b.getPathName(), c1985b);
                    }
                    obj2 = null;
                    c1988f.DK = c1985b.DK | c1988f.DK;
                } else if ("clip-path".equals(name)) {
                    C1984a c1984a = new C1984a();
                    c1984a.m5917a(resources, attributeSet, theme, xmlPullParser);
                    c1986c.tj.add(c1984a);
                    if (c1984a.getPathName() != null) {
                        c1987e.Fa.put(c1984a.getPathName(), c1984a);
                    }
                    c1988f.DK |= c1984a.DK;
                    obj2 = obj;
                } else {
                    if ("group".equals(name)) {
                        C1986c c1986c2 = new C1986c();
                        c1986c2.m5925a(resources, attributeSet, theme, xmlPullParser);
                        c1986c.tj.add(c1986c2);
                        stack.push(c1986c2);
                        if (c1986c2.getGroupName() != null) {
                            c1987e.Fa.put(c1986c2.getGroupName(), c1986c2);
                        }
                        c1988f.DK |= c1986c2.DK;
                    }
                    obj2 = obj;
                }
                obj = obj2;
            } else if (eventType == 3) {
                if ("group".equals(xmlPullParser.getName())) {
                    stack.pop();
                }
            }
            eventType = xmlPullParser.next();
        }
        if (obj != null) {
            StringBuffer stringBuffer = new StringBuffer();
            if (stringBuffer.length() > 0) {
                stringBuffer.append(" or ");
            }
            stringBuffer.append("path");
            throw new XmlPullParserException("no " + stringBuffer + " defined");
        }
    }

    void m5948u(boolean z) {
        this.Eg = z;
    }

    @SuppressLint({"NewApi"})
    private boolean hl() {
        boolean z = true;
        if (VERSION.SDK_INT < 17) {
            return false;
        }
        if (!(isAutoMirrored() && getLayoutDirection() == 1)) {
            z = false;
        }
        return z;
    }

    protected void onBoundsChange(Rect rect) {
        if (this.Ea != null) {
            this.Ea.setBounds(rect);
        }
    }

    public int getChangingConfigurations() {
        if (this.Ea != null) {
            return this.Ea.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.Ec.getChangingConfigurations();
    }

    public void invalidateSelf() {
        if (this.Ea != null) {
            this.Ea.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public void scheduleSelf(Runnable runnable, long j) {
        if (this.Ea != null) {
            this.Ea.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.Ea != null) {
            return this.Ea.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        if (this.Ea != null) {
            this.Ea.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
