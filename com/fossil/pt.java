package com.fossil;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.view.ViewConfiguration;
import com.fossil.pk.C3982a;
import com.fossil.pk.C3983b;
import com.fossil.pk.C3985d;
import com.fossil.pk.C3991j;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;

public class pt {
    private Context mContext;

    public static pt m13087w(Context context) {
        return new pt(context);
    }

    private pt(Context context) {
        this.mContext = context;
    }

    public int mh() {
        Resources resources = this.mContext.getResources();
        int b = hb.b(resources);
        int a = hb.a(resources);
        if (hb.c(resources) > 600 || b > 600 || ((b > 960 && a > 720) || (b > 720 && a > 960))) {
            return 5;
        }
        if (b >= MFNetworkReturnCode.INTERNAL_SERVER_ERROR || ((b > 640 && a > 480) || (b > 480 && a > 640))) {
            return 4;
        }
        if (b >= 360) {
            return 3;
        }
        return 2;
    }

    public boolean mi() {
        if (VERSION.SDK_INT < 19 && lt.b(ViewConfiguration.get(this.mContext))) {
            return false;
        }
        return true;
    }

    public int mj() {
        return this.mContext.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean mk() {
        return this.mContext.getResources().getBoolean(C3983b.abc_action_bar_embed_tabs);
    }

    public int ml() {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(null, C3991j.ActionBar, C3982a.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(C3991j.ActionBar_height, 0);
        Resources resources = this.mContext.getResources();
        if (!mk()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(C3985d.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean mm() {
        return this.mContext.getApplicationInfo().targetSdkVersion < 14;
    }

    public int mn() {
        return this.mContext.getResources().getDimensionPixelSize(C3985d.abc_action_bar_stacked_tab_max_width);
    }
}
