package com.fossil;

import android.annotation.TargetApi;
import android.view.LayoutInflater;
import com.fossil.kk.C3797a;

@TargetApi(21)
class kl {
    static void m11978a(LayoutInflater layoutInflater, km kmVar) {
        layoutInflater.setFactory2(kmVar != null ? new C3797a(kmVar) : null);
    }
}
