package com.fossil;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Map;

@TargetApi(14)
public class ap extends cw {
    public void mo1117a(dn dnVar) {
        m4140c(dnVar);
    }

    public void mo1118b(dn dnVar) {
        m4140c(dnVar);
    }

    private void m4140c(dn dnVar) {
        if (dnVar.view instanceof TextView) {
            dnVar.values.put("android:textscale:scale", Float.valueOf(((TextView) dnVar.view).getScaleX()));
        }
    }

    public Animator mo1116a(ViewGroup viewGroup, dn dnVar, dn dnVar2) {
        float f = 1.0f;
        if (dnVar == null || dnVar2 == null || !(dnVar.view instanceof TextView) || !(dnVar2.view instanceof TextView)) {
            return null;
        }
        final TextView textView = (TextView) dnVar2.view;
        Map map = dnVar.values;
        Map map2 = dnVar2.values;
        float floatValue = map.get("android:textscale:scale") != null ? ((Float) map.get("android:textscale:scale")).floatValue() : 1.0f;
        if (map2.get("android:textscale:scale") != null) {
            f = ((Float) map2.get("android:textscale:scale")).floatValue();
        }
        if (floatValue == f) {
            return null;
        }
        Animator ofFloat = ValueAnimator.ofFloat(new float[]{floatValue, f});
        ofFloat.addUpdateListener(new AnimatorUpdateListener(this) {
            final /* synthetic */ ap va;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                textView.setScaleX(floatValue);
                textView.setScaleY(floatValue);
            }
        });
        return ofFloat;
    }
}
