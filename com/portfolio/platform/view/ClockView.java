package com.portfolio.platform.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.fossil.cjz.a;
import com.fossil.cmz;
import com.fossil.dri;
import com.fossil.eqe;
import com.fossil.eqg;
import com.fossil.eqk;
import com.fossil.eqn;
import com.fossil.eqw;
import com.fossil.gn;
import com.fossil.kd;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.concurrent.TimeUnit;

public class ClockView extends View implements OnGestureListener {
    private static final String TAG = ClockView.class.getSimpleName();
    private static final int[] dhv = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    private Paint aEf;
    private int cOO;
    private kd cay;
    private float ccq;
    private float dhA;
    private int dhB;
    private int dhC;
    private int dhD;
    private float dhE;
    private float dhF;
    private Paint dhG;
    private Paint dhH;
    private Bitmap dhI;
    private float dhJ;
    private float dhK;
    private float dhL;
    private float dhM;
    private float dhN;
    private float dhO;
    private float dhP;
    private float dhQ;
    private boolean dhR;
    private boolean dhS;
    private boolean dhT;
    private boolean dhU;
    private Rect dhV = new Rect();
    private int dhW;
    private int dhX;
    private int dhY;
    private int dhZ;
    private String dhw;
    private float dhx;
    private float dhy;
    private float dhz;
    private int dia;
    private float dib;
    private float dic;
    private float did;
    private boolean die = true;
    private boolean dif = false;
    private boolean dig = false;
    private boolean dih = false;
    private boolean dii = true;
    private boolean dij = false;
    private float dik;
    private float dil;
    private float dim;
    private float din;
    private float dio;
    private C4983b dip;
    private C4982a diq;
    private float height;
    private float width;

    class C49781 implements eqg<Long> {
        final /* synthetic */ ClockView dir;

        C49781(ClockView clockView) {
            this.dir = clockView;
        }

        public /* synthetic */ void onNext(Object obj) {
            m15827c((Long) obj);
        }

        public void onSubscribe(eqn com_fossil_eqn) {
            if (this.dir.diq != null) {
                this.dir.diq.onAnimationStart();
            }
        }

        public void m15827c(Long l) {
            this.dir.dhA = this.dir.dhA + this.dir.dik;
            this.dir.height = this.dir.height + this.dir.dil;
            this.dir.dhO = this.dir.dhO + this.dir.dim;
            this.dir.dhK = this.dir.dhK + this.dir.din;
            this.dir.dhQ = this.dir.dhQ + this.dir.dio;
            this.dir.invalidate();
            if (this.dir.diq != null) {
                this.dir.diq.aD(this.dir.height);
            }
        }

        public void onError(Throwable th) {
        }

        public void onComplete() {
            MFLogger.d(ClockView.TAG, "onComplete: numeralFontSize = " + this.dir.dhA + ", height = " + this.dir.height + ", textRadius = " + this.dir.dhO + ", py = " + this.dir.dhK + ", bitmapScale = " + this.dir.dhQ);
            this.dir.dhS = false;
            this.dir.dhT = false;
            this.dir.dif = false;
        }
    }

    class C49792 implements eqw<Long> {
        final /* synthetic */ ClockView dir;

        C49792(ClockView clockView) {
            this.dir = clockView;
        }

        public /* synthetic */ boolean test(Object obj) throws Exception {
            return m15828d((Long) obj);
        }

        public boolean m15828d(Long l) throws Exception {
            return l.longValue() >= 20;
        }
    }

    class C49803 implements eqg<Long> {
        final /* synthetic */ ClockView dir;

        C49803(ClockView clockView) {
            this.dir = clockView;
        }

        public /* synthetic */ void onNext(Object obj) {
            m15829c((Long) obj);
        }

        public void onSubscribe(eqn com_fossil_eqn) {
        }

        public void m15829c(Long l) {
            this.dir.dhA = this.dir.dhA - this.dir.dik;
            this.dir.height = this.dir.height - this.dir.dil;
            this.dir.dhO = this.dir.dhO - this.dir.dim;
            this.dir.dhK = this.dir.dhK - this.dir.din;
            this.dir.dhQ = this.dir.dhQ - this.dir.dio;
            this.dir.invalidate();
        }

        public void onError(Throwable th) {
        }

        public void onComplete() {
            boolean z = true;
            MFLogger.d(ClockView.TAG, "onComplete: numeralFontSize = " + this.dir.dhA + ", height = " + this.dir.height + ", textRadius = " + this.dir.dhO + ", py = " + this.dir.dhK + ", bitmapScale = " + this.dir.dhQ);
            this.dir.dhS = true;
            this.dir.dhT = false;
            this.dir.dif = false;
            if (this.dir.diq != null) {
                this.dir.diq.aD(this.dir.height);
                C4982a a = this.dir.diq;
                if (this.dir.dhZ != this.dir.dia) {
                    z = false;
                }
                a.cG(z);
            }
        }
    }

    class C49814 implements eqw<Long> {
        final /* synthetic */ ClockView dir;

        C49814(ClockView clockView) {
            this.dir = clockView;
        }

        public /* synthetic */ boolean test(Object obj) throws Exception {
            return m15830d((Long) obj);
        }

        public boolean m15830d(Long l) throws Exception {
            return l.longValue() >= 20;
        }
    }

    public interface C4982a {
        void aD(float f);

        void cG(boolean z);

        void onAnimationStart();
    }

    public interface C4983b {
        void kq(int i);
    }

    public ClockView(Context context) {
        super(context);
        avf();
    }

    public ClockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.ClockView);
        this.dhw = obtainStyledAttributes.getString(5);
        this.dhE = obtainStyledAttributes.getDimension(0, dri.at(202.0f));
        this.dhF = obtainStyledAttributes.getDimension(1, dri.at(314.0f));
        this.dhx = obtainStyledAttributes.getDimension(2, dri.at(50.0f));
        this.dhz = obtainStyledAttributes.getDimension(3, dri.at(50.0f));
        this.dhA = obtainStyledAttributes.getDimension(4, (float) dri.a(13.0f, context));
        this.dhB = obtainStyledAttributes.getColor(6, gn.e(context, R.color.black));
        this.dhC = obtainStyledAttributes.getColor(7, gn.e(context, R.color.white));
        this.dhD = obtainStyledAttributes.getColor(8, gn.e(context, R.color.fossilOrange));
        obtainStyledAttributes.recycle();
        avf();
    }

    private void avf() {
        this.dhy = this.dhx;
        if (getContext().getResources().getConfiguration().getLayoutDirection() == 1) {
            this.dhx = ((float) cmz.abN().abO()) - this.dhx;
            this.dij = true;
        }
        this.dhP = this.dhF / this.dhE;
        this.dhS = true;
        setScale(false);
        this.aEf = new Paint();
        if (!TextUtils.isEmpty(this.dhw)) {
            this.aEf.setTypeface(Typeface.createFromAsset(getResources().getAssets(), this.dhw));
            this.aEf.setAntiAlias(true);
        }
        this.aEf.setTextSize(this.dhA);
        this.dhG = new Paint();
        this.dhG.setAntiAlias(true);
        this.dhG.setColor(this.dhD);
        this.dhG.setStyle(Style.FILL);
        this.dhH = new Paint();
        this.dhH.setAntiAlias(true);
        this.dhH.setFilterBitmap(true);
        this.dhH.setDither(true);
        this.cay = new kd(getContext(), this);
    }

    protected void onDraw(Canvas canvas) {
        if (!this.dhR) {
            avg();
            this.dhR = true;
        }
        if (this.dih) {
            m15832I(canvas);
            return;
        }
        m15833J(canvas);
        m15832I(canvas);
        m15834K(canvas);
    }

    private void avg() {
        this.height = (float) this.dhY;
        this.width = (float) this.dhY;
        this.dhJ = this.width / 2.0f;
        this.dhK = this.height / 2.0f;
        this.dhL = (float) ((int) dri.at(15.0f));
        float min = Math.min(this.height, this.width);
        this.ccq = (min / 2.0f) - this.dhL;
        this.dhO = (float) ((int) (this.ccq - dri.at(15.0f)));
        this.dhM = min / 8.0f;
        this.dhN = min / 3.0f;
        min = this.dhO - (this.dhA * 3.0f);
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.notification_hands);
        min /= (float) decodeResource.getHeight();
        int width = (int) (((float) decodeResource.getWidth()) * min);
        int height = (int) (min * ((float) decodeResource.getHeight()));
        if (width <= 0) {
            width = decodeResource.getWidth();
        }
        if (height <= 0) {
            height = decodeResource.getHeight();
        }
        this.dhI = Bitmap.createScaledBitmap(decodeResource, width, height, false);
        this.dio = (this.dhP - 1.0f) / 20.0f;
        this.dik = (this.dhA * this.dio) / 2.0f;
        this.dil = (this.height * this.dio) / 2.0f;
        this.dim = (this.dhO * this.dio) / 2.0f;
        this.din = (this.dhK * this.dio) / 2.0f;
    }

    public void setCurrentHour(int i) {
        this.cOO = i;
        invalidate();
    }

    private void m15832I(Canvas canvas) {
        double d;
        if (this.dih) {
            float f;
            float f2 = ((float) this.dhZ) / ((float) this.dia);
            float f3 = this.dib * f2;
            if (this.dhZ == 0) {
                f = this.dhA;
            } else {
                f = this.dhA + f3;
            }
            MFLogger.d(TAG, "drawNumeral() called with: deltaOffset = [" + f2 + "], deltaFontScale = [" + this.dib + "], fontScale = [" + f3 + "], finalFontSize = [" + f + "], deltaXScale = [" + this.dic + "], deltaYScale = [" + this.did + "]");
            if (f <= this.dhA) {
                f = this.dhA;
            }
            String valueOf = String.valueOf("22");
            this.aEf.setTextSize(f);
            this.aEf.getTextBounds(valueOf, 0, valueOf.length(), this.dhV);
            d = 0.5235987755982988d * ((double) (this.cOO - 3));
            if (this.dij) {
                f3 = ((float) (((int) ((((double) (this.width / 2.0f)) + (Math.cos(d) * ((double) this.dhO))) - ((double) (this.dhV.width() / 2)))) + this.dhW)) + (this.dic * f2);
                f2 = ((float) ((int) (((Math.sin(d) * ((double) this.dhO)) + ((double) (this.height / 2.0f))) + ((double) (this.dhV.height() / 2))))) - (f2 * this.did);
                if (f3 + f >= this.dhx - dri.at(10.0f)) {
                    f3 = (this.dhx - dri.at(10.0f)) - f;
                }
                if (f2 - f <= this.dhy) {
                    f2 = this.dhy + f;
                }
            } else {
                f3 = ((float) (((int) ((((double) (this.width / 2.0f)) + (Math.cos(d) * ((double) this.dhO))) - ((double) (this.dhV.width() / 2)))) + this.dhW)) - (this.dic * f2);
                f2 = ((float) ((int) (((Math.sin(d) * ((double) this.dhO)) + ((double) (this.height / 2.0f))) + ((double) (this.dhV.height() / 2))))) - (f2 * this.did);
                if (f3 - f <= this.dhx - dri.at(10.0f)) {
                    f3 = (this.dhx - dri.at(10.0f)) + f;
                }
                if (f2 - f <= this.dhy) {
                    f2 = this.dhy + f;
                }
            }
            MFLogger.d(TAG, "drawNumeral() called with: x = [" + f3 + "], y = [" + f2 + "]");
            canvas.drawCircle(((float) (this.dhV.width() / 2)) + f3, f2 - ((float) (this.dhV.height() / 2)), f, this.dhG);
            this.aEf.setColor(this.dhC);
            String valueOf2 = String.valueOf(this.cOO);
            canvas.drawText(valueOf2, (float) ((int) (f3 + ((((float) this.dhV.width()) - this.aEf.measureText(valueOf2)) / 2.0f))), f2, this.aEf);
            return;
        }
        for (int i : dhv) {
            String valueOf3 = String.valueOf("22");
            this.aEf.setTextSize(this.dhA);
            this.aEf.getTextBounds(valueOf3, 0, valueOf3.length(), this.dhV);
            d = 0.5235987755982988d * ((double) (i - 3));
            int cos = ((int) ((((double) (this.width / 2.0f)) + (Math.cos(d) * ((double) this.dhO))) - ((double) (this.dhV.width() / 2)))) + this.dhW;
            int sin = (int) (((Math.sin(d) * ((double) this.dhO)) + ((double) (this.height / 2.0f))) + ((double) (this.dhV.height() / 2)));
            if (i == this.cOO) {
                canvas.drawCircle((float) ((this.dhV.width() / 2) + cos), (float) (sin - (this.dhV.height() / 2)), this.dhA, this.dhG);
                this.aEf.setColor(this.dhC);
                if (!this.dig) {
                    if (this.dij) {
                        this.dic = ((float) cmz.abN().abO()) - this.dic;
                    } else {
                        this.dic = (float) cos;
                    }
                    this.did = (float) sin;
                    this.dig = true;
                }
            } else {
                this.aEf.setColor(this.dhB);
            }
            canvas.drawText(String.valueOf(i), (float) ((int) (((((float) this.dhV.width()) - this.aEf.measureText(String.valueOf(i))) / 2.0f) + ((float) cos))), (float) sin, this.aEf);
        }
    }

    private void m15833J(Canvas canvas) {
        this.aEf.setStyle(Style.FILL);
    }

    private void m15834K(Canvas canvas) {
        if (this.cOO != -1 && this.dii) {
            double d = 0.5235987755982988d * ((double) this.cOO);
            Matrix matrix = new Matrix();
            matrix.postScale(this.dhQ, this.dhQ);
            matrix.postTranslate((((float) (-this.dhI.getWidth())) * this.dhQ) / 2.0f, (((float) (-this.dhI.getHeight())) * this.dhQ) / 2.0f);
            matrix.postRotate((float) Math.toDegrees(d), 0.0f, (((float) this.dhI.getHeight()) * this.dhQ) / 2.0f);
            matrix.postTranslate(this.dhJ + ((float) this.dhW), this.dhK - ((((float) this.dhI.getHeight()) * this.dhQ) / 2.0f));
            canvas.drawBitmap(this.dhI, matrix, this.dhH);
            matrix.reset();
        }
    }

    public void ch(int i, int i2) {
        this.dhZ = Math.abs(i2);
        this.dia = i;
        this.dih = this.dhZ > 0;
        if (!this.dif) {
            float f;
            if (this.dhz - this.dhA > 0.0f) {
                f = this.dhz - this.dhA;
            } else {
                f = 0.0f;
            }
            this.dib = f;
            this.dif = true;
        }
        invalidate();
    }

    public void setShowHand(boolean z) {
        this.dii = z;
    }

    public void setScale(boolean z) {
        MFLogger.d(TAG, "setScale() called with: scale = [" + z + "]");
        if (this.dhS != z) {
            if (z) {
                this.dhA /= this.dhP;
                this.height /= this.dhP;
                this.dhO /= this.dhP;
                this.dhK = this.height / 2.0f;
                this.dhQ = 1.0f;
            } else {
                this.dhA *= this.dhP;
                this.height *= this.dhP;
                this.dhO *= this.dhP;
                this.dhK *= this.dhP;
                this.dhQ = this.dhP;
            }
            this.dhS = z;
            invalidate();
            if (this.diq != null) {
                boolean z2;
                this.diq.aD(this.height);
                C4982a c4982a = this.diq;
                if (this.dhZ == this.dia) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                c4982a.cG(z2);
            }
        }
    }

    public void avh() {
        if (this.dhU) {
            avi();
        } else {
            setScale(false);
        }
    }

    private void avi() {
        if (!this.dhT && this.dhS) {
            this.dhT = true;
            eqe.e(10, TimeUnit.MILLISECONDS).a(eqk.aGH()).a(new C49792(this)).a(new C49781(this));
        }
    }

    public void avj() {
        if (this.dhU) {
            avk();
        } else {
            setScale(true);
        }
    }

    private void avk() {
        if (!this.dhT && !this.dhS) {
            this.dhT = true;
            eqe.e(10, TimeUnit.MILLISECONDS).a(eqk.aGH()).a(new C49814(this)).a(new C49803(this));
        }
    }

    public boolean avl() {
        return this.dhS;
    }

    public void setShowAnimation(boolean z) {
        this.dhU = z;
        this.dif = false;
    }

    protected void onMeasure(int i, int i2) {
        int jn = jn(i);
        int jn2 = jn(i2);
        MFLogger.d(TAG, "onMeasure() called with: measureWidth = [" + jn + "], measureHeight = [" + jn2 + "]");
        int min = Math.min(jn, jn2);
        setMeasuredDimension(jn, min);
        if (this.die && jn > jn2) {
            this.dhY = min;
            this.dhX = jn;
            this.dhW = (jn - jn2) / 2;
            this.die = false;
        }
    }

    private int jn(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 0) {
            return MFNetworkReturnCode.RESPONSE_OK;
        }
        return size;
    }

    public boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.cOO = aE(m15831C(motionEvent.getX(), motionEvent.getY()));
        if (this.dip != null) {
            this.dip.kq(this.cOO);
        }
        invalidate();
        return true;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void setClockOnTouchListener(C4983b c4983b) {
        this.dip = c4983b;
    }

    private boolean m15849f(float f, float f2, float f3) {
        return f2 <= f && f < f3;
    }

    private float m15831C(float f, float f2) {
        return ((float) Math.toDegrees(Math.atan2((double) (f2 - ((float) (getHeight() / 2))), (double) (f - ((float) (getWidth() / 2)))))) + 90.0f;
    }

    private int aE(float f) {
        if (m15849f(f, -15.0f, 15.0f)) {
            return 12;
        }
        if (m15849f(f, 15.0f, 45.0f)) {
            return 1;
        }
        if (m15849f(f, 45.0f, 75.0f)) {
            return 2;
        }
        if (m15849f(f, 75.0f, 105.0f)) {
            return 3;
        }
        if (m15849f(f, 105.0f, 135.0f)) {
            return 4;
        }
        if (m15849f(f, 135.0f, 165.0f)) {
            return 5;
        }
        if (m15849f(f, 165.0f, 195.0f)) {
            return 6;
        }
        if (m15849f(f, 195.0f, 225.0f)) {
            return 7;
        }
        if (m15849f(f, 225.0f, 255.0f)) {
            return 8;
        }
        if (m15849f(f, 255.0f, 270.0f) || m15849f(f, -90.0f, -70.0f)) {
            return 9;
        }
        if (m15849f(f, -70.0f, -40.0f)) {
            return 10;
        }
        if (m15849f(f, -40.0f, -15.0f)) {
            return 11;
        }
        return 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return isEnabled() && this.cay.onTouchEvent(motionEvent);
    }

    public void setOnAnimationListener(C4982a c4982a) {
        this.diq = c4982a;
    }
}
