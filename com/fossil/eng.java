package com.fossil;

import android.content.Context;
import android.os.Bundle;
import android.support.v8.renderscript.Allocation;
import android.text.TextUtils;
import io.fabric.sdk.android.services.common.CommonUtils;

public class eng {
    public String er(Context context) {
        Object es = es(context);
        if (TextUtils.isEmpty(es)) {
            es = et(context);
        }
        if (TextUtils.isEmpty(es)) {
            eu(context);
        }
        return es;
    }

    protected String es(Context context) {
        String str = null;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), Allocation.USAGE_SHARED).metaData;
            if (bundle != null) {
                str = bundle.getString("io.fabric.ApiKey");
                if (str == null) {
                    emm.aEU().mo2950d("Fabric", "Falling back to Crashlytics key lookup from Manifest");
                    str = bundle.getString("com.crashlytics.ApiKey");
                }
            }
        } catch (Exception e) {
            emm.aEU().mo2950d("Fabric", "Caught non-fatal exception while retrieving apiKey: " + e);
        }
        return str;
    }

    protected String et(Context context) {
        int n = CommonUtils.n(context, "io.fabric.ApiKey", "string");
        if (n == 0) {
            emm.aEU().mo2950d("Fabric", "Falling back to Crashlytics key lookup from Strings");
            n = CommonUtils.n(context, "com.crashlytics.ApiKey", "string");
        }
        if (n != 0) {
            return context.getResources().getString(n);
        }
        return null;
    }

    protected void eu(Context context) {
        if (emm.aEV() || CommonUtils.eD(context)) {
            throw new IllegalArgumentException(aFm());
        }
        emm.aEU().mo2951e("Fabric", aFm());
    }

    protected String aFm() {
        return "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>";
    }
}
