package com.fossil;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.fossil.ag.C1621b;
import com.fossil.ag.C1626g;

@TargetApi(21)
public class bq {
    private static final int[] Dq = new int[]{16843848};

    public static void m5522y(View view) {
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    public static void m5520a(View view, AttributeSet attributeSet, int i, int i2) {
        Context context = view.getContext();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Dq, i, i2);
        try {
            if (obtainStyledAttributes.hasValue(0)) {
                view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, obtainStyledAttributes.getResourceId(0, 0)));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    public static void m5521d(View view, float f) {
        int integer = view.getResources().getInteger(C1626g.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(new int[]{16842766, C1621b.state_collapsible, -C1621b.state_collapsed}, ObjectAnimator.ofFloat(view, "elevation", new float[]{0.0f}).setDuration((long) integer));
        stateListAnimator.addState(new int[]{16842766}, ObjectAnimator.ofFloat(view, "elevation", new float[]{f}).setDuration((long) integer));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", new float[]{0.0f}).setDuration(0));
        view.setStateListAnimator(stateListAnimator);
    }
}
