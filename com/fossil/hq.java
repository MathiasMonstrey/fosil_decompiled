package com.fossil;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.fossil.hp.C3652a;

@TargetApi(11)
class hq extends hp {

    static class C3654a extends C3652a {
        C3654a(C3652a c3652a, Resources resources) {
            super(c3652a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new hq(this, resources);
        }
    }

    hq(Drawable drawable) {
        super(drawable);
    }

    hq(C3652a c3652a, Resources resources) {
        super(c3652a, resources);
    }

    public void jumpToCurrentState() {
        this.Nt.jumpToCurrentState();
    }

    C3652a iN() {
        return new C3654a(this.Ns, null);
    }
}
