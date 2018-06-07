package com.fossil;

import android.support.v4.app.Fragment;
import android.view.View;

public class ckm {
    private final Fragment fragment;

    ckm(Fragment fragment) {
        this.fragment = fragment;
    }

    public void m6988F(View view, int i) {
        tx.t(this.fragment).a(Integer.valueOf(i)).a(new aba<View, yf>(this, view) {
            final /* synthetic */ ckm cpE;

            public void m6986a(yf yfVar, aal com_fossil_aal) {
                this.view.setBackground(yfVar);
            }
        });
    }
}
