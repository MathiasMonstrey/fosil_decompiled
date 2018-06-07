package com.fossil;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.fossil.hp.C3652a;

@TargetApi(19)
class hr extends hq {

    static class C3655a extends C3652a {
        C3655a(C3652a c3652a, Resources resources) {
            super(c3652a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new hr(this, resources);
        }
    }

    hr(Drawable drawable) {
        super(drawable);
    }

    hr(C3652a c3652a, Resources resources) {
        super(c3652a, resources);
    }

    public void setAutoMirrored(boolean z) {
        this.Nt.setAutoMirrored(z);
    }

    public boolean isAutoMirrored() {
        return this.Nt.isAutoMirrored();
    }

    C3652a iN() {
        return new C3655a(this.Ns, null);
    }
}
