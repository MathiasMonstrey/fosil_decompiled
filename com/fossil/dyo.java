package com.fossil;

import android.os.Bundle;

public final class dyo {

    public static class C3302a extends dyg {
        public String cAX;
        public String state;

        public void mo2784Q(Bundle bundle) {
            super.mo2784Q(bundle);
            this.cAX = bundle.getString("_wxapi_sendauth_req_scope");
            this.state = bundle.getString("_wxapi_sendauth_req_state");
        }

        public boolean checkArgs() {
            if (this.cAX == null || this.cAX.length() == 0 || this.cAX.length() > 1024) {
                dyc.m10282x("MicroMsg.SDK.SendAuth.Req", "checkArgs fail, scope is invalid");
                return false;
            } else if (this.state == null || this.state.length() <= 1024) {
                return true;
            } else {
                dyc.m10282x("MicroMsg.SDK.SendAuth.Req", "checkArgs fail, state is invalid");
                return false;
            }
        }

        public int getType() {
            return 1;
        }

        public void mo2787o(Bundle bundle) {
            super.mo2787o(bundle);
            bundle.putString("_wxapi_sendauth_req_scope", this.cAX);
            bundle.putString("_wxapi_sendauth_req_state", this.state);
        }
    }

    public static class C3303b extends dyh {
        public String cCt;
        public String code;
        public String country;
        public String state;
        public String url;

        public C3303b(Bundle bundle) {
            mo2782Q(bundle);
        }

        public void mo2782Q(Bundle bundle) {
            super.mo2782Q(bundle);
            this.code = bundle.getString("_wxapi_sendauth_resp_token");
            this.state = bundle.getString("_wxapi_sendauth_resp_state");
            this.url = bundle.getString("_wxapi_sendauth_resp_url");
            this.cCt = bundle.getString("_wxapi_sendauth_resp_lang");
            this.country = bundle.getString("_wxapi_sendauth_resp_country");
        }

        public int getType() {
            return 1;
        }
    }
}
