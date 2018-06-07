package com.fossil;

import android.os.Bundle;

public final class dyr {
    public String dAW;
    public String dAX;
    public int dAZ;
    public C3307b dBa;
    public String dBb;
    public String description;
    public byte[] thumbData;
    public String title;

    public static class C3306a {
        public static dyr m10304R(Bundle bundle) {
            dyr com_fossil_dyr = new dyr();
            com_fossil_dyr.dAZ = bundle.getInt("_wxobject_sdkVer");
            com_fossil_dyr.title = bundle.getString("_wxobject_title");
            com_fossil_dyr.description = bundle.getString("_wxobject_description");
            com_fossil_dyr.thumbData = bundle.getByteArray("_wxobject_thumbdata");
            com_fossil_dyr.dBb = bundle.getString("_wxobject_mediatagname");
            com_fossil_dyr.dAW = bundle.getString("_wxobject_message_action");
            com_fossil_dyr.dAX = bundle.getString("_wxobject_message_ext");
            String le = C3306a.le(bundle.getString("_wxobject_identifier_"));
            if (le == null || le.length() <= 0) {
                return com_fossil_dyr;
            }
            try {
                com_fossil_dyr.dBa = (C3307b) Class.forName(le).newInstance();
                com_fossil_dyr.dBa.m10307T(bundle);
                return com_fossil_dyr;
            } catch (Exception e) {
                e.printStackTrace();
                dyc.m10282x("MicroMsg.SDK.WXMediaMessage", "get media object from bundle failed: unknown ident " + le + ", ex = " + e.getMessage());
                return com_fossil_dyr;
            }
        }

        public static Bundle m10305a(dyr com_fossil_dyr) {
            Bundle bundle = new Bundle();
            bundle.putInt("_wxobject_sdkVer", com_fossil_dyr.dAZ);
            bundle.putString("_wxobject_title", com_fossil_dyr.title);
            bundle.putString("_wxobject_description", com_fossil_dyr.description);
            bundle.putByteArray("_wxobject_thumbdata", com_fossil_dyr.thumbData);
            if (com_fossil_dyr.dBa != null) {
                bundle.putString("_wxobject_identifier_", C3306a.ld(com_fossil_dyr.dBa.getClass().getName()));
                com_fossil_dyr.dBa.m10306S(bundle);
            }
            bundle.putString("_wxobject_mediatagname", com_fossil_dyr.dBb);
            bundle.putString("_wxobject_message_action", com_fossil_dyr.dAW);
            bundle.putString("_wxobject_message_ext", com_fossil_dyr.dAX);
            return bundle;
        }

        private static String ld(String str) {
            if (str != null && str.length() != 0) {
                return str.replace("com.tencent.mm.sdk.modelmsg", "com.tencent.mm.sdk.openapi");
            }
            dyc.m10282x("MicroMsg.SDK.WXMediaMessage", "pathNewToOld fail, newPath is null");
            return str;
        }

        private static String le(String str) {
            if (str != null && str.length() != 0) {
                return str.replace("com.tencent.mm.sdk.openapi", "com.tencent.mm.sdk.modelmsg");
            }
            dyc.m10282x("MicroMsg.SDK.WXMediaMessage", "pathOldToNew fail, oldPath is null");
            return str;
        }
    }

    public interface C3307b {
        void m10306S(Bundle bundle);

        void m10307T(Bundle bundle);

        int aBC();

        boolean checkArgs();
    }

    public dyr() {
        this(null);
    }

    public dyr(C3307b c3307b) {
        this.dBa = c3307b;
    }

    final boolean checkArgs() {
        if (getType() == 8 && (this.thumbData == null || this.thumbData.length == 0)) {
            dyc.m10282x("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, thumbData should not be null when send emoji");
            return false;
        } else if (this.thumbData != null && this.thumbData.length > 32768) {
            dyc.m10282x("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, thumbData is invalid");
            return false;
        } else if (this.title != null && this.title.length() > 512) {
            dyc.m10282x("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, title is invalid");
            return false;
        } else if (this.description != null && this.description.length() > 1024) {
            dyc.m10282x("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, description is invalid");
            return false;
        } else if (this.dBa == null) {
            dyc.m10282x("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, mediaObject is null");
            return false;
        } else if (this.dBb != null && this.dBb.length() > 64) {
            dyc.m10282x("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, mediaTagName is too long");
            return false;
        } else if (this.dAW != null && this.dAW.length() > 2048) {
            dyc.m10282x("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, messageAction is too long");
            return false;
        } else if (this.dAX == null || this.dAX.length() <= 2048) {
            return this.dBa.checkArgs();
        } else {
            dyc.m10282x("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, messageExt is too long");
            return false;
        }
    }

    public final int getType() {
        return this.dBa == null ? 0 : this.dBa.aBC();
    }
}
