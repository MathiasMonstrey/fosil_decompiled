package com.sina.weibo.sdk.component.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class ResizeableLayout extends RelativeLayout {
    private C5060a dsi = null;
    private int pS = 0;
    private int pT = 0;

    public interface C5060a {
        void onSizeChanged(int i, int i2, int i3, int i4);
    }

    public ResizeableLayout(Context context) {
        super(context);
    }

    public ResizeableLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ResizeableLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.dsi != null) {
            this.dsi.onSizeChanged(getWidth(), getHeight(), this.pS, this.pT);
        }
        this.pT = getHeight();
        this.pS = getWidth();
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setSizeChangeListener(C5060a c5060a) {
        this.dsi = c5060a;
    }
}
