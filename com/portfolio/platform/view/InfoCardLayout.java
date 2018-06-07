package com.portfolio.platform.view;

import android.content.Context;
import android.support.design.widget.BottomSheetBehavior;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import com.fossil.esl;
import com.misfit.frameworks.common.constants.Constants;

public final class InfoCardLayout extends FrameLayout {
    private BottomSheetBehavior<FrameLayout> djL;

    public InfoCardLayout(Context context, AttributeSet attributeSet) {
        esl.j(context, "context");
        super(context, attributeSet);
        getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                InfoCardLayout infoCardLayout = this;
                BottomSheetBehavior i = BottomSheetBehavior.i(this);
                esl.i(i, "BottomSheetBehavior.from(this@InfoCardLayout)");
                infoCardLayout.djL = i;
                InfoCardLayout.m15894a(this).setHideable(false);
                InfoCardLayout.m15894a(this).setPeekHeight(0);
            }
        });
    }

    public static final /* synthetic */ BottomSheetBehavior m15894a(InfoCardLayout infoCardLayout) {
        BottomSheetBehavior bottomSheetBehavior = infoCardLayout.djL;
        if (bottomSheetBehavior == null) {
            esl.mF("mBottomSheetBehavior");
        }
        return bottomSheetBehavior;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        esl.j(motionEvent, Constants.EVENT);
        return true;
    }

    public final void setHideable(boolean z) {
        BottomSheetBehavior bottomSheetBehavior = this.djL;
        if (bottomSheetBehavior == null) {
            esl.mF("mBottomSheetBehavior");
        }
        bottomSheetBehavior.setHideable(z);
    }

    public final void setPeekHeight(int i) {
        BottomSheetBehavior bottomSheetBehavior = this.djL;
        if (bottomSheetBehavior == null) {
            esl.mF("mBottomSheetBehavior");
        }
        bottomSheetBehavior.setPeekHeight(i);
    }
}
