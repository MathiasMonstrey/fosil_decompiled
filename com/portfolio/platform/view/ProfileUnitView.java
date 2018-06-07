package com.portfolio.platform.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import com.fossil.cjz.a;

public class ProfileUnitView extends ConstraintLayout {
    private boolean dmc;

    public ProfileUnitView(Context context) {
        super(context);
    }

    public ProfileUnitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.ProfileUnit, 0, 0);
        try {
            cA(context);
            this.dmc = obtainStyledAttributes.getBoolean(0, false);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void cA(Context context) {
    }
}
