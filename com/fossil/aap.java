package com.fossil;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.fossil.aao.C1550a;

public class aap<R> implements aam<R> {
    private final C1550a aGC;
    private aal<R> aGD;

    static class C1554a implements C1550a {
        private final int aGE;
        private final Context context;

        public C1554a(Context context, int i) {
            this.context = context.getApplicationContext();
            this.aGE = i;
        }

        public Animation wJ() {
            return AnimationUtils.loadAnimation(this.context, this.aGE);
        }
    }

    public aap(Context context, int i) {
        this(new C1554a(context, i));
    }

    aap(C1550a c1550a) {
        this.aGC = c1550a;
    }

    public aal<R> mo776i(boolean z, boolean z2) {
        if (z || !z2) {
            return aan.wM();
        }
        if (this.aGD == null) {
            this.aGD = new aao(this.aGC);
        }
        return this.aGD;
    }
}
