package com.portfolio.platform.view;

import android.content.Context;
import android.util.AttributeSet;
import com.fossil.cnc;

public class RTLEditText extends FlexibleEditText {
    public RTLEditText(Context context) {
        super(context);
        cC(context);
    }

    public RTLEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cC(context);
    }

    public RTLEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        cC(context);
    }

    private void cC(Context context) {
        cnc.b(this, context);
    }
}
