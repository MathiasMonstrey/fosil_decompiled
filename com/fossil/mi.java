package com.fossil;

import android.annotation.TargetApi;
import android.view.WindowInsets;

@TargetApi(21)
class mi {
    public static boolean am(Object obj) {
        return ((WindowInsets) obj).isConsumed();
    }
}
