package com.fossil;

import android.view.View;
import android.view.animation.Animation;
import com.fossil.aal.C1552a;

public class aao<R> implements aal<R> {
    private final C1550a aGC;

    interface C1550a {
        Animation wJ();
    }

    aao(C1550a c1550a) {
        this.aGC = c1550a;
    }

    public boolean mo777a(R r, C1552a c1552a) {
        View view = c1552a.getView();
        if (view != null) {
            view.clearAnimation();
            view.startAnimation(this.aGC.wJ());
        }
        return false;
    }
}
