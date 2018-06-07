package com.fossil;

import android.annotation.TargetApi;
import android.os.Bundle;
import com.facebook.applinks.AppLinkData;
import com.fossil.gd.C3617a;

@TargetApi(16)
class ge {
    static Bundle m11504a(C3617a c3617a) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", c3617a.getResultKey());
        bundle.putCharSequence("label", c3617a.getLabel());
        bundle.putCharSequenceArray("choices", c3617a.getChoices());
        bundle.putBoolean("allowFreeFormInput", c3617a.getAllowFreeFormInput());
        bundle.putBundle(AppLinkData.ARGUMENTS_EXTRAS_KEY, c3617a.getExtras());
        return bundle;
    }

    static Bundle[] m11505b(C3617a[] c3617aArr) {
        if (c3617aArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[c3617aArr.length];
        for (int i = 0; i < c3617aArr.length; i++) {
            bundleArr[i] = m11504a(c3617aArr[i]);
        }
        return bundleArr;
    }
}
