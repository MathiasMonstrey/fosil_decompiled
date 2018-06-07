package com.portfolio.platform.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.fossil.cjz.a;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.buttonservice.utils.DeviceIdentityUtils;
import com.misfit.frameworks.common.log.MFLogger;

public class LetterFastScroller extends View {
    private static final String TAG = LetterFastScroller.class.getSimpleName();
    private static final char[] bRV = new char[]{'#', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static final String[] djN = new String[]{"#", "A", "B", "C", "D", "E", DeviceIdentityUtils.FLASH_SERIAL_NUMBER_PREFIX, "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", DeviceIdentityUtils.SHINE_SERIAL_NUMBER_PREFIX, "T", "U", "V", "W", "X", "Y", "Z"};
    private Paint aEf = new Paint();
    private C4992a djO;
    private int djP = -1;
    private Rect djQ = new Rect();

    public interface C4992a {
        void m15896g(char c);
    }

    public LetterFastScroller(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15897a(attributeSet);
    }

    public LetterFastScroller(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m15897a(attributeSet);
    }

    public LetterFastScroller(Context context) {
        super(context);
    }

    public void m15897a(AttributeSet attributeSet) {
        String string = getResources().getString(R.string.font_path_scout_light_10);
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, a.LetterFastScroller, 0, 0);
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.getResourceId(0, R.color.black);
            string = obtainStyledAttributes.getString(1);
        }
        if (string == null || string.isEmpty()) {
            string = getResources().getString(R.string.font_path_scout_light_10);
        }
        this.aEf.setTypeface(Typeface.createFromAsset(getContext().getAssets(), string));
        this.aEf.setTextSize(getResources().getDimension(R.dimen.sp10));
        this.aEf.setAntiAlias(true);
    }

    public void setOnTouchingLetterChangedListener(C4992a c4992a) {
        this.djO = c4992a;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int width = getWidth();
        int length = height / bRV.length;
        for (height = 0; height < bRV.length; height++) {
            String str = djN[height];
            float measureText = ((float) (width / 2)) - (this.aEf.measureText(djN[height]) / 2.0f);
            float paddingTop = (float) (getPaddingTop() + (length * height));
            this.aEf.getTextBounds(str, 0, 1, this.djQ);
            canvas.drawText(str, measureText, paddingTop + ((float) ((this.djQ.height() + length) / 2)), this.aEf);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        int paddingTop = getPaddingTop();
        int i = this.djP;
        int height = (int) (((y - ((float) paddingTop)) / ((float) ((getHeight() - paddingTop) - getPaddingBottom()))) * ((float) bRV.length));
        switch (action) {
            case 0:
                if (i != height && height >= 0 && height < bRV.length) {
                    MFLogger.d(TAG, "dispatchTouchEvent ACTION_DOWN: char = " + bRV[height]);
                    if (this.djO != null) {
                        this.djO.m15896g(bRV[height]);
                    }
                    this.djP = height;
                    break;
                }
            case 1:
                this.djP = -1;
                break;
            case 2:
                if (height >= 0 && height < bRV.length) {
                    MFLogger.d(TAG, "dispatchTouchEvent ACTION_MOVE: char = " + bRV[height]);
                    if (this.djO != null) {
                        this.djO.m15896g(bRV[height]);
                    }
                    this.djP = height;
                    break;
                }
        }
        return true;
    }
}
