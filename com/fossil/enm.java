package com.fossil;

import android.content.Context;

public class enm {
    private final emz<String> dOb = new C34771(this);
    private final emx<String> dOc = new emx();

    class C34771 implements emz<String> {
        final /* synthetic */ enm dOd;

        C34771(enm com_fossil_enm) {
            this.dOd = com_fossil_enm;
        }

        public /* synthetic */ Object mo812Q(Context context) throws Exception {
            return m10961O(context);
        }

        public String m10961O(Context context) throws Exception {
            String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
            return installerPackageName == null ? "" : installerPackageName;
        }
    }

    public String getInstallerPackageName(Context context) {
        try {
            String str = (String) this.dOc.mo2961a(context, this.dOb);
            if ("".equals(str)) {
                return null;
            }
            return str;
        } catch (Throwable e) {
            emm.aEU().mo2953g("Fabric", "Failed to determine installer package name", e);
            return null;
        }
    }
}
