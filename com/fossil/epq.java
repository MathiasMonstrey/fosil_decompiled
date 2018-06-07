package com.fossil;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import io.fabric.sdk.android.services.common.CommonUtils;

public class epq {
    public final String dPT;
    public final int dQn;
    public final int height;
    public final int width;

    public epq(String str, int i, int i2, int i3) {
        this.dPT = str;
        this.dQn = i;
        this.width = i2;
        this.height = i3;
    }

    public static epq ac(Context context, String str) {
        if (str != null) {
            try {
                int eG = CommonUtils.eG(context);
                emm.aEU().mo2950d("Fabric", "App icon resource ID is " + eG);
                Options options = new Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeResource(context.getResources(), eG, options);
                return new epq(str, eG, options.outWidth, options.outHeight);
            } catch (Throwable e) {
                emm.aEU().mo2953g("Fabric", "Failed to load icon", e);
            }
        }
        return null;
    }
}
