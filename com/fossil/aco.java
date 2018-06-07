package com.fossil;

import android.util.Log;
import com.crashlytics.android.core.CrashlyticsMissingDependencyException;
import io.fabric.sdk.android.services.common.CommonUtils;

class aco {
    private final String aHV;
    private final boolean aIu;

    public aco(String str, boolean z) {
        this.aHV = str;
        this.aIu = z;
    }

    public void m2944m(String str, String str2) {
        if (CommonUtils.isNullOrEmpty(this.aHV) && this.aIu) {
            String n = m2945n(str, str2);
            Log.e("Fabric", ".");
            Log.e("Fabric", ".     |  | ");
            Log.e("Fabric", ".     |  |");
            Log.e("Fabric", ".     |  |");
            Log.e("Fabric", ".   \\ |  | /");
            Log.e("Fabric", ".    \\    /");
            Log.e("Fabric", ".     \\  /");
            Log.e("Fabric", ".      \\/");
            Log.e("Fabric", ".");
            Log.e("Fabric", n);
            Log.e("Fabric", ".");
            Log.e("Fabric", ".      /\\");
            Log.e("Fabric", ".     /  \\");
            Log.e("Fabric", ".    /    \\");
            Log.e("Fabric", ".   / |  | \\");
            Log.e("Fabric", ".     |  |");
            Log.e("Fabric", ".     |  |");
            Log.e("Fabric", ".     |  |");
            Log.e("Fabric", ".");
            throw new CrashlyticsMissingDependencyException(n);
        } else if (!this.aIu) {
            emm.aEU().mo2950d("Fabric", "Configured not to require a build ID.");
        }
    }

    protected String m2945n(String str, String str2) {
        return "This app relies on Crashlytics. Please sign up for access at https://fabric.io/sign_up,\ninstall an Android build tool and ask a team member to invite you to this app's organization.";
    }
}
