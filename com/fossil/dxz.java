package com.fossil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public final class dxz {

    public static class C3289a {
        public String dAD;
        public Bundle dAE;
        public String dAF;
        public String dAG;
    }

    public static boolean m10273a(Context context, C3289a c3289a) {
        if (context == null) {
            dyc.m10282x("MicroMsg.SDK.MMessage", "send fail, invalid argument");
            return false;
        } else if (dye.lc(c3289a.dAG)) {
            dyc.m10282x("MicroMsg.SDK.MMessage", "send fail, action is null");
            return false;
        } else {
            String str = null;
            if (!dye.lc(c3289a.dAF)) {
                str = c3289a.dAF + ".permission.MM_MESSAGE";
            }
            Intent intent = new Intent(c3289a.dAG);
            if (c3289a.dAE != null) {
                intent.putExtras(c3289a.dAE);
            }
            String packageName = context.getPackageName();
            intent.putExtra("_mmessage_sdkVersion", 587268097);
            intent.putExtra("_mmessage_appPackage", packageName);
            intent.putExtra("_mmessage_content", c3289a.dAD);
            intent.putExtra("_mmessage_checksum", dya.m10275c(c3289a.dAD, 587268097, packageName));
            context.sendBroadcast(intent, str);
            dyc.m10281e("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str);
            return true;
        }
    }
}
