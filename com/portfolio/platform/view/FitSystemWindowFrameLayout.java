package com.portfolio.platform.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
import android.widget.FrameLayout;

public class FitSystemWindowFrameLayout extends FrameLayout {
    public FitSystemWindowFrameLayout(Context context) {
        super(context);
    }

    public FitSystemWindowFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FitSystemWindowFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(20)
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).dispatchApplyWindowInsets(windowInsets);
        }
        return windowInsets;
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (VERSION.SDK_INT >= 20) {
            requestApplyInsets();
        }
    }
}
