package com.fossil;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import com.fossil.aal.C1552a;

public class aak<T extends Drawable> implements aal<T> {
    private final aal<T> aGz;
    private final int duration;

    public aak(aal<T> com_fossil_aal_T, int i) {
        this.aGz = com_fossil_aal_T;
        this.duration = i;
    }

    public boolean m2823a(T t, C1552a c1552a) {
        if (c1552a.wK() != null) {
            Drawable transitionDrawable = new TransitionDrawable(new Drawable[]{c1552a.wK(), t});
            transitionDrawable.setCrossFadeEnabled(true);
            transitionDrawable.startTransition(this.duration);
            c1552a.setDrawable(transitionDrawable);
            return true;
        }
        this.aGz.mo777a(t, c1552a);
        return false;
    }
}
