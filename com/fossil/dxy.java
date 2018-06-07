package com.fossil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public final class dxy {

    public static class C3288a {
        public String f1466W;
        public String dAC;
        public String dAD;
        public Bundle dAE;
        public int flags = -1;

        public final String toString() {
            return "targetPkgName:" + this.f1466W + ", targetClassName:" + this.dAC + ", content:" + this.dAD + ", flags:" + this.flags + ", bundle:" + this.dAE;
        }
    }

    public static boolean m10272a(Context context, C3288a c3288a) {
        if (context == null) {
            dyc.m10282x("MicroMsg.SDK.MMessageAct", "send fail, invalid argument");
            return false;
        } else if (dye.lc(c3288a.f1466W)) {
            dyc.m10282x("MicroMsg.SDK.MMessageAct", "send fail, invalid targetPkgName, targetPkgName = " + c3288a.f1466W);
            return false;
        } else {
            if (dye.lc(c3288a.dAC)) {
                c3288a.dAC = c3288a.f1466W + ".wxapi.WXEntryActivity";
            }
            dyc.m10281e("MicroMsg.SDK.MMessageAct", "send, targetPkgName = " + c3288a.f1466W + ", targetClassName = " + c3288a.dAC);
            Intent intent = new Intent();
            intent.setClassName(c3288a.f1466W, c3288a.dAC);
            if (c3288a.dAE != null) {
                intent.putExtras(c3288a.dAE);
            }
            String packageName = context.getPackageName();
            intent.putExtra("_mmessage_sdkVersion", 587268097);
            intent.putExtra("_mmessage_appPackage", packageName);
            intent.putExtra("_mmessage_content", c3288a.dAD);
            intent.putExtra("_mmessage_checksum", dya.m10275c(c3288a.dAD, 587268097, packageName));
            if (c3288a.flags == -1) {
                intent.addFlags(268435456).addFlags(134217728);
            } else {
                intent.setFlags(c3288a.flags);
            }
            try {
                context.startActivity(intent);
                dyc.m10281e("MicroMsg.SDK.MMessageAct", "send mm message, intent=" + intent);
                return true;
            } catch (Exception e) {
                dyc.m10279a("MicroMsg.SDK.MMessageAct", "send fail, ex = %s", e.getMessage());
                return false;
            }
        }
    }
}
