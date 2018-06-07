package com.fossil;

import android.os.Bundle;

public final class dym {

    public static class C3300a extends dyg {
        public String cCt;
        public String country;

        public C3300a(Bundle bundle) {
            mo2784Q(bundle);
        }

        public void mo2784Q(Bundle bundle) {
            super.mo2784Q(bundle);
            this.cCt = bundle.getString("_wxapi_getmessage_req_lang");
            this.country = bundle.getString("_wxapi_getmessage_req_country");
        }

        public boolean checkArgs() {
            return true;
        }

        public int getType() {
            return 3;
        }

        public void mo2787o(Bundle bundle) {
            super.mo2787o(bundle);
            bundle.putString("_wxapi_getmessage_req_lang", this.cCt);
            bundle.putString("_wxapi_getmessage_req_country", this.country);
        }
    }
}
