package com.fossil;

import android.annotation.TargetApi;
import android.view.View;

@TargetApi(15)
class ln {
    public static boolean av(View view) {
        return view.hasOnClickListeners();
    }
}
