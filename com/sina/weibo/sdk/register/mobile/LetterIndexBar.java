package com.sina.weibo.sdk.register.mobile;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.fossil.dum;

public class LetterIndexBar extends View {
    private int count = 27;
    private String[] dsA;
    private boolean[] dsB;
    private C5065a dsC;
    private int dsD;
    private boolean dsE;
    private RectF dsF;
    private int dsG;
    private Drawable dsH;
    private int mIndex;
    private int tW;
    private Paint wx = new Paint();

    public interface C5065a {
        void mv(int i);
    }

    public LetterIndexBar(Context context) {
        super(context);
        init();
    }

    public LetterIndexBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public LetterIndexBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.wx.setAntiAlias(true);
        this.wx.setStyle(Style.FILL);
        this.wx.setColor(-10658467);
        this.dsG = dum.I(getContext(), 13);
    }

    public void setIndexMark(boolean[] zArr) {
        if (zArr != null) {
            this.dsB = zArr;
            invalidate();
        }
    }

    public void setIndexLetter(String[] strArr) {
        if (strArr != null) {
            this.dsA = strArr;
            this.count = this.dsA.length;
            this.mIndex = -1;
            invalidate();
        }
    }

    public void setIndexChangeListener(C5065a c5065a) {
        this.dsC = c5065a;
    }

    protected void onDraw(Canvas canvas) {
        int color;
        int i = 0;
        super.onDraw(canvas);
        if (this.dsE) {
            color = this.wx.getColor();
            this.wx.setColor(-2005436536);
            canvas.drawRoundRect(this.dsF, (float) (getMeasuredWidth() / 2), (float) (getMeasuredWidth() / 2), this.wx);
            this.wx.setColor(color);
        }
        if (this.dsG > this.tW) {
            color = this.tW;
        } else {
            color = this.dsG;
        }
        this.wx.setTextSize((float) color);
        int paddingTop;
        String str;
        if (this.dsA == null) {
            char c = 'A';
            while (i < this.count) {
                paddingTop = this.dsD + (((this.tW * i) + getPaddingTop()) + color);
                if (this.dsB == null || this.dsB[i]) {
                    if (i == this.count - 1) {
                        str = "#";
                    } else {
                        char c2 = (char) (c + 1);
                        str = String.valueOf(c);
                        c = c2;
                    }
                    canvas.drawText(str, (float) ((getMeasuredWidth() - ((int) this.wx.measureText(str))) / 2), (float) paddingTop, this.wx);
                }
                i++;
            }
            return;
        }
        while (i < this.count) {
            int paddingTop2 = (((this.tW * i) + getPaddingTop()) + color) + this.dsD;
            if (this.dsB == null || this.dsB[i]) {
                str = this.dsA[i];
                if (str.equals("")) {
                    int measureText = (int) this.wx.measureText("M");
                    paddingTop = (getMeasuredWidth() - measureText) / 2;
                    this.dsH.setBounds(paddingTop, paddingTop2 - paddingTop, measureText + paddingTop, (paddingTop2 + measureText) - paddingTop);
                    this.dsH.draw(canvas);
                } else {
                    canvas.drawText(str, (float) ((getMeasuredWidth() - ((int) this.wx.measureText(str))) / 2), (float) paddingTop2, this.wx);
                }
            }
            i++;
        }
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i2);
        this.tW = ((size - getPaddingTop()) - getPaddingBottom()) / this.count;
        this.dsD = (int) ((((float) this.tW) - this.wx.getTextSize()) / 2.0f);
        setMeasuredDimension((this.dsG + getPaddingLeft()) + getPaddingRight(), i2);
        this.dsF = new RectF(0.0f, (float) getPaddingTop(), (float) getMeasuredWidth(), (float) ((size - getPaddingTop()) - getPaddingBottom()));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.dsE = true;
                int y = (((int) motionEvent.getY()) - getPaddingTop()) / this.tW;
                if (y != this.mIndex && ((this.dsB == null || this.dsB[y]) && y < this.count && y >= 0)) {
                    this.mIndex = y;
                    if (this.dsC != null) {
                        this.dsC.mv(this.mIndex);
                        break;
                    }
                }
                break;
            case 1:
            case 3:
            case 4:
                this.dsE = false;
                break;
        }
        invalidate();
        return true;
    }
}
