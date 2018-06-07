package com.portfolio.platform.view;

import android.content.Context;
import android.text.Layout;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;

public class SingleLineTextView extends FlexibleTextView {
    public SingleLineTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setSingleLine();
        setEllipsize(TruncateAt.END);
    }

    public SingleLineTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setSingleLine();
        setEllipsize(TruncateAt.END);
    }

    public SingleLineTextView(Context context) {
        super(context);
        setSingleLine();
        setEllipsize(TruncateAt.END);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Layout layout = getLayout();
        if (layout != null) {
            int lineCount = layout.getLineCount();
            if (lineCount > 0 && layout.getEllipsisCount(lineCount - 1) > 0) {
                setTextSize(0, getTextSize() - 1.0f);
                measure(i, i2);
            }
        }
    }
}
