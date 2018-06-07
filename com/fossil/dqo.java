package com.fossil;

import android.support.v4.app.Fragment;
import com.fossil.fa.C3106a;

public class dqo<T> {
    private T value;

    public dqo(final Fragment fragment, T t) {
        final fa fragmentManager = fragment.getFragmentManager();
        fragmentManager.mo3088a(new C3106a(this) {
            final /* synthetic */ dqo deO;

            public void mo2664e(fa faVar, Fragment fragment) {
                if (fragment == fragment) {
                    this.deO.value = null;
                    fragmentManager.mo3087a(this);
                }
            }
        }, false);
        this.value = t;
    }

    public T get() {
        return this.value;
    }
}
