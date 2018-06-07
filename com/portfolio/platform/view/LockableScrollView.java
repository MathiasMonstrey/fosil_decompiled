package com.portfolio.platform.view;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class LockableScrollView extends NestedScrollView {
    private boolean djR = true;

    public LockableScrollView(Context context) {
        super(context);
    }

    public LockableScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LockableScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setScrollable(boolean z) {
        this.djR = z;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.djR) {
                    return super.onTouchEvent(motionEvent);
                }
                return false;
            default:
                return super.onTouchEvent(motionEvent);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.djR && super.onInterceptTouchEvent(motionEvent);
    }
}
