package com.portfolio.platform.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatImageView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.fossil.cjz.a;
import com.fossil.cmc;
import com.fossil.cme;
import com.fossil.cmh;
import com.fossil.dri;
import com.fossil.gn;
import com.fossil.kd;
import com.fossil.tt;
import com.fossil.tz;
import com.fossil.wearables.fossil.R;
import com.fossil.wearables.fsl.shared.BaseFeatureModel;
import java.util.List;

public class NotificationConfigurationSummaryView extends ViewGroup implements OnGestureListener {
    private static final String TAG = NotificationConfigurationSummaryView.class.getSimpleName();
    private static final int[] dhv = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    private kd cay;
    private boolean dhR;
    private String dhw;
    private int djS;
    private int djT;
    private int djU;
    private int djV;
    private Paint djW;
    private Paint djX;
    private Rect djY;
    private int djZ;
    private int dka;
    private int dkb;
    private int dkc;
    private int dkd;
    private int dke;
    private int dkf;
    public C4993a dkg;
    private int height;
    private int width;

    public interface C4993a {
        void kp(int i);
    }

    public void m15902a(int i, List<BaseFeatureModel> list, tz tzVar) {
        tt c = tzVar.m13778a(Integer.valueOf(R.color.transparent)).tv().m13747c(new cmc(getContext(), getResources().getDimensionPixelSize(R.dimen.dp2), gn.e(getContext(), R.color.hexEEEEEE)));
        ImageView appCompatImageView = new AppCompatImageView(getContext());
        tzVar.m13780a(new cmh()).bc(new cme(list)).m13729a(c).m13747c(new cmc(getContext())).mo4173c(appCompatImageView);
        appCompatImageView.setTag(123456789, Integer.valueOf(i));
        super.addView(appCompatImageView);
    }

    private void m15900a(AppCompatImageView appCompatImageView, int i) {
        double d = 0.5235987755982988d * ((double) (i - 3));
        int i2 = this.dkc;
        int i3 = this.dkc;
        int cos = (int) (((double) ((this.dkd / 2) - (i2 / 2))) + (((double) this.dkf) * Math.cos(d)));
        int sin = (int) ((Math.sin(d) * ((double) this.dkf)) + ((double) ((this.dke / 2) - (i3 / 2))));
        appCompatImageView.layout(cos, sin, cos + i2, sin + i3);
    }

    public NotificationConfigurationSummaryView(Context context) {
        super(context);
        avf();
    }

    public NotificationConfigurationSummaryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.NotificationConfigurationSummaryView);
        this.djS = (int) obtainStyledAttributes.getDimension(0, (float) dri.a(15.0f, context));
        this.djT = obtainStyledAttributes.getColor(1, -1);
        this.dhw = obtainStyledAttributes.getString(2);
        this.djU = obtainStyledAttributes.getColor(3, -65536);
        obtainStyledAttributes.recycle();
        avf();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        this.dkf = (int) (((float) (Math.min(i3 - i, i4 - i2) / 2)) - dri.at(40.0f));
        this.dkd = getWidth();
        this.dke = getHeight();
        for (int i5 = 0; i5 < childCount; i5++) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) getChildAt(i5);
            m15900a(appCompatImageView, ((Integer) appCompatImageView.getTag(123456789)).intValue());
        }
    }

    private void avf() {
        this.djW = new Paint(1);
        this.djW.setStyle(Style.FILL);
        this.djW.setColor(this.djU);
        this.djX = new Paint(1);
        if (!TextUtils.isEmpty(this.dhw)) {
            this.djX.setTypeface(Typeface.createFromAsset(getResources().getAssets(), this.dhw));
        }
        this.djX.setTextSize((float) this.djS);
        this.djX.setColor(this.djT);
        this.djX.setStrokeWidth(2.0f);
        this.djY = new Rect();
        this.cay = new kd(getContext(), this);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (!this.dhR) {
            avg();
            this.dhR = true;
        }
        m15899I(canvas);
    }

    private void avg() {
        this.width = getMeasuredWidth();
        this.height = getMeasuredHeight();
        this.djZ = Math.min(this.width, this.height) / 2;
        this.dka = (int) (((float) this.djZ) - dri.at(50.0f));
        this.dkb = (int) (((float) this.dka) - dri.at(20.0f));
        this.djV = (int) (((float) this.djZ) / 8.5f);
        this.dkc = (int) (((float) this.djZ) / 3.5f);
    }

    private void m15899I(Canvas canvas) {
        for (int i : dhv) {
            String valueOf = String.valueOf(i);
            this.djX.getTextBounds(valueOf, 0, valueOf.length(), this.djY);
            double d = 0.5235987755982988d * ((double) (i - 3));
            int i2 = (int) ((((double) (this.width / 2)) + (Math.cos(d) * ((double) this.dkb))) - ((double) (this.djY.width() / 2)));
            int sin = (int) (((Math.sin(d) * ((double) this.dkb)) + ((double) (this.height / 2))) + ((double) (this.djY.height() / 2)));
            this.djW.setColor(-1);
            canvas.drawCircle((float) ((this.djY.width() / 2) + i2), (float) (sin - (this.djY.height() / 2)), (float) this.djV, this.djW);
            this.djW.setColor(this.djU);
            canvas.drawCircle((float) ((this.djY.width() / 2) + i2), (float) (sin - (this.djY.height() / 2)), ((float) this.djV) - dri.at(1.0f), this.djW);
            canvas.drawText(valueOf, ((float) i2) + ((((float) this.djY.width()) - this.djX.measureText(valueOf)) / 2.0f), (float) sin, this.djX);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return isEnabled() && this.cay.onTouchEvent(motionEvent);
    }

    public boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        int aE = aE(m15898C(motionEvent.getX(), motionEvent.getY()));
        if (this.dkg != null) {
            this.dkg.kp(aE);
        }
        return true;
    }

    private float m15898C(float f, float f2) {
        return ((float) Math.toDegrees(Math.atan2((double) (f2 - ((float) (getHeight() / 2))), (double) (f - ((float) (getWidth() / 2)))))) + 90.0f;
    }

    private int aE(float f) {
        if (m15901f(f, -15.0f, 15.0f)) {
            return 12;
        }
        if (m15901f(f, 15.0f, 45.0f)) {
            return 1;
        }
        if (m15901f(f, 45.0f, 75.0f)) {
            return 2;
        }
        if (m15901f(f, 75.0f, 105.0f)) {
            return 3;
        }
        if (m15901f(f, 105.0f, 135.0f)) {
            return 4;
        }
        if (m15901f(f, 135.0f, 165.0f)) {
            return 5;
        }
        if (m15901f(f, 165.0f, 195.0f)) {
            return 6;
        }
        if (m15901f(f, 195.0f, 225.0f)) {
            return 7;
        }
        if (m15901f(f, 225.0f, 255.0f)) {
            return 8;
        }
        if (m15901f(f, 255.0f, 270.0f) || m15901f(f, -90.0f, -70.0f)) {
            return 9;
        }
        if (m15901f(f, -70.0f, -40.0f)) {
            return 10;
        }
        if (m15901f(f, -40.0f, -15.0f)) {
            return 11;
        }
        return 0;
    }

    private boolean m15901f(float f, float f2, float f3) {
        return f2 <= f && f < f3;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void setOnItemClickListener(C4993a c4993a) {
        this.dkg = c4993a;
    }
}
