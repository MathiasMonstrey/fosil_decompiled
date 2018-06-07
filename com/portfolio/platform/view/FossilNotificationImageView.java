package com.portfolio.platform.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import com.fossil.dri;
import com.fossil.tz;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;

public class FossilNotificationImageView extends ViewGroup {
    private static final String TAG = FossilNotificationImageView.class.getSimpleName();
    private final Paint ER = new Paint();
    private final Paint dgY = new Paint();
    private final Rect diM = new Rect();
    private FossilCircleImageView diN;
    private boolean diO;

    public FossilCircleImageView getFossilCircleImageView() {
        return this.diN;
    }

    public FossilNotificationImageView(Context context) {
        super(context);
        m15864t(context, null);
    }

    public FossilNotificationImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m15864t(context, attributeSet);
    }

    private void m15864t(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            this.diN = new FossilCircleImageView(context, attributeSet);
        } else {
            this.diN = new FossilCircleImageView(context);
        }
        addView(this.diN);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (!TextUtils.isEmpty(this.diN.getHandNumber())) {
            int width;
            if (this.diO) {
                width = getWidth() / 6;
            } else {
                width = getWidth() / 4;
            }
            this.ER.setAntiAlias(true);
            this.ER.setFilterBitmap(true);
            this.ER.setDither(true);
            this.ER.setColor(-65536);
            this.ER.setStyle(Style.FILL);
            if (this.diO) {
                canvas.drawCircle((float) (getWidth() - (getWidth() / 6)), (float) (getHeight() / 6), (float) (getWidth() / 6), this.ER);
            } else {
                canvas.drawCircle((float) (getWidth() / 2), ((float) (getHeight() - width)) - dri.at(5.0f), (float) width, this.ER);
            }
            this.dgY.setAntiAlias(true);
            this.dgY.setColor(-1);
            this.dgY.setStrokeWidth(4.0f);
            this.dgY.setStyle(Style.STROKE);
            if (this.diO) {
                canvas.drawCircle((float) (getWidth() - (getWidth() / 6)), (float) (getHeight() / 6), (float) (getWidth() / 6), this.dgY);
            } else {
                canvas.drawCircle((float) (getWidth() / 2), ((float) (getHeight() - width)) - dri.at(5.0f), (float) width, this.dgY);
            }
            this.ER.setColor(-1);
            this.ER.setTextSize((float) width);
            this.ER.getTextBounds(this.diN.getHandNumber(), 0, this.diN.getHandNumber().length(), this.diM);
            float measureText = this.ER.measureText(this.diN.getHandNumber());
            int height = this.diM.height();
            if (this.diO) {
                canvas.drawText(this.diN.getHandNumber(), ((float) (getWidth() - (getWidth() / 6))) - (measureText / 2.0f), (float) ((height / 2) + (getHeight() / 6)), this.ER);
                return;
            }
            canvas.drawText(this.diN.getHandNumber(), ((float) (getWidth() / 2)) - (measureText / 2.0f), (((float) (getHeight() - width)) - dri.at(5.0f)) + ((float) (height / 2)), this.ER);
        }
    }

    public void setTopRightBadge(boolean z) {
        this.diO = z;
    }

    public void m15869a(String str, tz tzVar) {
        this.diN.a(str, tzVar);
    }

    public void m15868a(Bitmap bitmap, tz tzVar) {
        if (bitmap == null) {
            Log.d(TAG, "Inside. setImageBitmap 1 bitmap, bitmap == null");
        } else {
            this.diN.a(bitmap, tzVar);
        }
    }

    public void m15870b(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null || bitmap2 == null) {
            Log.d(TAG, "Inside. setImageBitmap 2 bitmap, bitmap == null");
        } else {
            this.diN.b(bitmap, bitmap2);
        }
    }

    public void m15866a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        if (bitmap == null || bitmap2 == null || bitmap3 == null) {
            Log.d(TAG, "Inside. setImageBitmap 3 bitmap, bitmap == null");
        } else {
            this.diN.a(bitmap, bitmap2, bitmap3);
        }
    }

    public void m15867a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4) {
        if (bitmap == null || bitmap2 == null || bitmap3 == null || bitmap4 == null) {
            Log.d(TAG, "Inside. setImageBitmap 4 bitmap, bitmap == null");
        } else {
            this.diN.a(bitmap, bitmap2, bitmap3, bitmap4);
        }
    }

    public void m15865a(int i, tz tzVar) {
        this.diN.a(i, tzVar);
    }

    public void setDefault(boolean z) {
        this.diN.setDefault(z);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        this.diN.layout(0, 0, i5, i5);
    }

    public void setHandNumber(String str) {
        this.diN.setHandNumber(str);
    }

    public void avn() {
        this.diN.setBorderColor(PortfolioApp.ZQ().getResources().getColor(R.color.fossilCoolGray));
        this.diN.setBorderWidth(3);
    }

    public void avo() {
        this.diN.setBorderColor(PortfolioApp.ZQ().getResources().getColor(R.color.transparent));
        this.diN.setBorderWidth(3);
    }
}
