package com.fossil;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;

@TargetApi(19)
class gt {
    public static File[] m11534n(Context context) {
        return context.getExternalCacheDirs();
    }

    public static File[] m11533a(Context context, String str) {
        return context.getExternalFilesDirs(str);
    }
}
