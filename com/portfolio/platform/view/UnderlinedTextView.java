package com.portfolio.platform.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.fossil.cjz.a;

public class UnderlinedTextView extends FlexibleTextView {
    private Rect djQ;
    private Rect dnv;
    private Paint dnw;
    private float dnx;
    private float dny;

    public UnderlinedTextView(Context context) {
        this(context, null, 0);
    }

    public UnderlinedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UnderlinedTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.djQ = new Rect();
        m16004b(context, attributeSet, i);
    }

    private void m16004b(Context context, AttributeSet attributeSet, int i) {
        float f = context.getResources().getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.UnderlinedTextView, i, 0);
        int color = obtainStyledAttributes.getColor(3, -65536);
        this.dnx = obtainStyledAttributes.getDimension(0, -1.0f);
        f = obtainStyledAttributes.getDimension(1, f * 1.0f);
        this.dny = obtainStyledAttributes.getDimension(2, 4.0f * f);
        obtainStyledAttributes.recycle();
        this.dnv = new Rect();
        this.dnw = new Paint();
        this.dnw.setStyle(Style.STROKE);
        this.dnw.setColor(color);
        this.dnw.setStrokeWidth(f);
    }

    protected void onDraw(Canvas canvas) {
        int lineCount = getLineCount();
        CharSequence text = getText();
        getPaint().getTextBounds(text.toString(), 0, text.length(), this.djQ);
        int lineBounds;
        float f;
        if (this.dnx == -1.0f) {
            for (int i = 0; i < lineCount; i++) {
                lineBounds = getLineBounds(i, this.dnv);
                f = (float) lineBounds;
                canvas.drawLine((float) this.dnv.left, ((float) lineBounds) + this.dny, (float) this.dnv.right, this.dny + f, this.dnw);
            }
        } else {
            lineBounds = getLineBounds(getLineCount() - 1, this.dnv);
            float width = (((float) this.dnv.width()) - this.dnx) / 2.0f;
            f = (float) lineBounds;
            canvas.drawLine(((float) this.dnv.left) + width, ((float) lineBounds) + this.dny, ((float) this.dnv.right) - width, this.dny + f, this.dnw);
        }
        super.onDraw(canvas);
    }
}
