package com.fossil;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.misfit.frameworks.common.constants.Constants;

public final class avd {
    private static final Uri bhx;
    private static final Uri bhy;

    static {
        Uri parse = Uri.parse("https://plus.google.com/");
        bhx = parse;
        bhy = parse.buildUpon().appendPath("circles").appendPath(Constants.FIND).build();
    }

    public static Intent KW() {
        Intent intent = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
        intent.setPackage("com.google.android.wearable.app");
        return intent;
    }

    public static Intent m4593N(String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW");
        Builder appendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter("id", str);
        if (!TextUtils.isEmpty(str2)) {
            appendQueryParameter.appendQueryParameter("pcampaignid", str2);
        }
        intent.setData(appendQueryParameter.build());
        intent.setPackage("com.android.vending");
        intent.addFlags(524288);
        return intent;
    }

    public static Intent de(String str) {
        Uri fromParts = Uri.fromParts("package", str, null);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(fromParts);
        return intent;
    }
}
