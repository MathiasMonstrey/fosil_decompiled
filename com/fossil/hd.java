package com.fossil;

import android.annotation.TargetApi;
import android.content.res.Resources;

@TargetApi(13)
class hd {
    static int m11558a(Resources resources) {
        return resources.getConfiguration().screenHeightDp;
    }

    static int m11559b(Resources resources) {
        return resources.getConfiguration().screenWidthDp;
    }

    static int m11560c(Resources resources) {
        return resources.getConfiguration().smallestScreenWidthDp;
    }
}
