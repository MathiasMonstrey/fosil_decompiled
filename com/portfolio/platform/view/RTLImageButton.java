package com.portfolio.platform.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;

public class RTLImageButton extends AppCompatImageButton {
    public RTLImageButton(Context context) {
        super(context);
    }

    public RTLImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RTLImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setImageDrawable(Drawable drawable) {
        drawable.setAutoMirrored(true);
        super.setImageDrawable(drawable);
    }
}
