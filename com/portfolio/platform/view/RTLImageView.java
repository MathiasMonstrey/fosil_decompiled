package com.portfolio.platform.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

public class RTLImageView extends AppCompatImageView {
    public RTLImageView(Context context) {
        super(context);
    }

    public RTLImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RTLImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setImageDrawable(Drawable drawable) {
        drawable.setAutoMirrored(true);
        super.setImageDrawable(drawable);
    }
}
