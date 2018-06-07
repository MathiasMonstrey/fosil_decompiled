package com.fossil;

import android.os.Bundle;

public class dyn {

    public static class C3301a extends dyg {
        public String cCt;
        public String country;
        public String dAW;
        public String dAX;

        public C3301a(Bundle bundle) {
            mo2784Q(bundle);
        }

        public void mo2784Q(Bundle bundle) {
            super.mo2784Q(bundle);
            this.dAW = bundle.getString("_wxobject_message_action");
            this.dAX = bundle.getString("_wxobject_message_ext");
            this.cCt = bundle.getString("_wxapi_launch_req_lang");
            this.country = bundle.getString("_wxapi_launch_req_country");
        }

        public boolean checkArgs() {
            if (this.dAW != null && this.dAW.length() > 2048) {
                dyc.m10282x("MicroMsg.SDK.LaunchFromWX.Req", "checkArgs fail, messageAction is too long");
                return false;
            } else if (this.dAX == null || this.dAX.length() <= 2048) {
                return true;
            } else {
                dyc.m10282x("MicroMsg.SDK.LaunchFromWX.Req", "checkArgs fail, messageExt is too long");
                return false;
            }
        }

        public int getType() {
            return 6;
        }

        public void mo2787o(Bundle bundle) {
            super.mo2787o(bundle);
            bundle.putString("_wxobject_message_action", this.dAW);
            bundle.putString("_wxobject_message_ext", this.dAX);
            bundle.putString("_wxapi_launch_req_lang", this.cCt);
            bundle.putString("_wxapi_launch_req_country", this.country);
        }
    }
}
