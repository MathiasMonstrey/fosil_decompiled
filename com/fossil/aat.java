package com.fossil;

import android.widget.ImageView;

public class aat extends aau<yf> {
    private int aEF;
    private yf aGF;

    protected /* synthetic */ void bi(Object obj) {
        m2841a((yf) obj);
    }

    public aat(ImageView imageView) {
        this(imageView, -1);
    }

    public aat(ImageView imageView, int i) {
        super(imageView);
        this.aEF = i;
    }

    public void m2842a(yf yfVar, aal<? super yf> com_fossil_aal__super_com_fossil_yf) {
        Object com_fossil_aay;
        if (!yfVar.vJ()) {
            float intrinsicWidth = ((float) yfVar.getIntrinsicWidth()) / ((float) yfVar.getIntrinsicHeight());
            if (Math.abs((((float) ((ImageView) this.view).getWidth()) / ((float) ((ImageView) this.view).getHeight())) - 1.0f) <= 0.05f && Math.abs(intrinsicWidth - 1.0f) <= 0.05f) {
                com_fossil_aay = new aay(yfVar, ((ImageView) this.view).getWidth());
            }
        }
        super.mo766a(com_fossil_aay, (aal) com_fossil_aal__super_com_fossil_yf);
        this.aGF = com_fossil_aay;
        com_fossil_aay.eI(this.aEF);
        com_fossil_aay.start();
    }

    protected void m2841a(yf yfVar) {
        ((ImageView) this.view).setImageDrawable(yfVar);
    }

    public void onStart() {
        if (this.aGF != null) {
            this.aGF.start();
        }
    }

    public void onStop() {
        if (this.aGF != null) {
            this.aGF.stop();
        }
    }
}
