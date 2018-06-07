package com.fossil;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;

abstract class eq extends ep {
    eq() {
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        if (dispatchFragmentsOnCreateView != null || VERSION.SDK_INT < 11) {
            return dispatchFragmentsOnCreateView;
        }
        return super.onCreateView(view, str, context, attributeSet);
    }
}