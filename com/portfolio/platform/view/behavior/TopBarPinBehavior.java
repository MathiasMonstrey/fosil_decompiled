package com.portfolio.platform.view.behavior;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.c;
import android.util.AttributeSet;
import android.view.View;

public class TopBarPinBehavior extends Behavior<ConstraintLayout> {
    private int dnA;
    private int dnz;
    private Context mContext;

    public /* synthetic */ boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return m16006a(coordinatorLayout, (ConstraintLayout) view, view2);
    }

    public /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return m16007b(coordinatorLayout, (ConstraintLayout) view, view2);
    }

    public TopBarPinBehavior(Context context, AttributeSet attributeSet) {
        this.mContext = context;
    }

    private void m16005a(ConstraintLayout constraintLayout, AppBarLayout appBarLayout) {
        if (this.dnz == 0) {
            this.dnz = constraintLayout.getHeight();
        }
        if (this.dnA == 0) {
            this.dnA = appBarLayout.getTotalScrollRange();
        }
    }

    public boolean m16006a(CoordinatorLayout coordinatorLayout, ConstraintLayout constraintLayout, View view) {
        return view instanceof ConstraintLayout;
    }

    public boolean m16007b(CoordinatorLayout coordinatorLayout, ConstraintLayout constraintLayout, View view) {
        m16005a(constraintLayout, (AppBarLayout) view);
        if (view.getBottom() <= this.dnA) {
            constraintLayout.setX(0.0f);
            constraintLayout.setY(0.0f);
            c cVar = (c) constraintLayout.getLayoutParams();
            cVar.height = 100;
            cVar.width = -1;
            constraintLayout.setLayoutParams(cVar);
        }
        return true;
    }
}
