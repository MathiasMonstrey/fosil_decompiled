package com.portfolio.platform.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.fossil.cjz.a;

public class AutoResizeTextView extends FlexibleTextView {
    private float bXl;
    private C4971a dfS;
    private boolean dfT;
    private float dfU;
    private float dfV;
    private float dfW;
    private float dfX;
    private boolean dfY;

    public interface C4971a {
        void m15814a(TextView textView, float f, float f2);
    }

    public AutoResizeTextView(Context context) {
        this(context, null);
    }

    public AutoResizeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoResizeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dfT = false;
        this.dfU = 0.0f;
        this.dfW = 1.0f;
        this.dfX = 0.0f;
        this.dfY = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.AutoResizeTextView);
        this.dfV = obtainStyledAttributes.getDimension(0, 20.0f);
        obtainStyledAttributes.recycle();
        this.bXl = getTextSize();
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.dfT = true;
        auS();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (i != i3 || i2 != i4) {
            this.dfT = true;
        }
    }

    public void setOnResizeListener(C4971a c4971a) {
        this.dfS = c4971a;
    }

    public void setTextSize(float f) {
        super.setTextSize(f);
        this.bXl = getTextSize();
    }

    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        this.bXl = getTextSize();
    }

    public void setLineSpacing(float f, float f2) {
        super.setLineSpacing(f, f2);
        this.dfW = f2;
        this.dfX = f;
    }

    public void setMaxTextSize(float f) {
        this.dfU = f;
        requestLayout();
        invalidate();
    }

    public float getMaxTextSize() {
        return this.dfU;
    }

    public void setMinTextSize(float f) {
        this.dfV = f;
        requestLayout();
        invalidate();
    }

    public float getMinTextSize() {
        return this.dfV;
    }

    public void setAddEllipsis(boolean z) {
        this.dfY = z;
    }

    public boolean getAddEllipsis() {
        return this.dfY;
    }

    public void auS() {
        if (this.bXl > 0.0f) {
            super.setTextSize(0, this.bXl);
            this.dfU = this.bXl;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z || this.dfT) {
            cg(((i3 - i) - getCompoundPaddingLeft()) - getCompoundPaddingRight(), ((i4 - i2) - getCompoundPaddingBottom()) - getCompoundPaddingTop());
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public void cg(int i, int i2) {
        CharSequence text = getText();
        if (text != null && text.length() != 0 && i2 > 0 && i > 0 && this.bXl != 0.0f) {
            if (getTransformationMethod() != null) {
                text = getTransformationMethod().getTransformation(text, this);
            }
            Paint paint = getPaint();
            float textSize = paint.getTextSize();
            float min = this.dfU > 0.0f ? Math.min(this.bXl, this.dfU) : this.bXl;
            float f = min;
            int a = m15818a(text, paint, i, min);
            while (a > i2 && f > this.dfV) {
                float max = Math.max(f - 2.0f, this.dfV);
                a = m15818a(text, paint, i, max);
                f = max;
            }
            if (this.dfY && f == this.dfV && a > i2) {
                StaticLayout staticLayout = new StaticLayout(text, new TextPaint(paint), i, Alignment.ALIGN_NORMAL, this.dfW, this.dfX, false);
                if (staticLayout.getLineCount() > 0) {
                    int lineForVertical = staticLayout.getLineForVertical(i2) - 1;
                    if (lineForVertical < 0) {
                        setText("");
                    } else {
                        int lineStart = staticLayout.getLineStart(lineForVertical);
                        int lineEnd = staticLayout.getLineEnd(lineForVertical);
                        min = staticLayout.getLineWidth(lineForVertical);
                        float measureText = paint.measureText("...");
                        while (((float) i) < min + measureText) {
                            lineEnd--;
                            min = paint.measureText(text.subSequence(lineStart, lineEnd + 1).toString());
                        }
                        setText(text.subSequence(0, lineEnd) + "...");
                    }
                }
            }
            setTextSize(0, f);
            setLineSpacing(this.dfX, this.dfW);
            if (this.dfS != null) {
                this.dfS.m15814a(this, textSize, f);
            }
            this.dfT = false;
        }
    }

    private int m15818a(CharSequence charSequence, TextPaint textPaint, int i, float f) {
        TextPaint textPaint2 = new TextPaint(textPaint);
        textPaint2.setTextSize(f);
        return new StaticLayout(charSequence, textPaint2, i, Alignment.ALIGN_NORMAL, this.dfW, this.dfX, true).getHeight();
    }
}
