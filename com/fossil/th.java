package com.fossil;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.applinks.AppLinkData;

public final class th {
    public static Bundle m13675f(Intent intent) {
        return intent.getBundleExtra("al_applink_data");
    }

    public static Bundle m13676g(Intent intent) {
        Bundle f = m13675f(intent);
        if (f == null) {
            return null;
        }
        return f.getBundle(AppLinkData.ARGUMENTS_EXTRAS_KEY);
    }
}
