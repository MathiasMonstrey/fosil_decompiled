package com.fossil;

import android.os.Bundle;
import com.fossil.dyr.C3306a;

public class dyq {

    public static class C3305a extends dyg {
        public String cCt;
        public String country;
        public dyr dAY;

        public C3305a(Bundle bundle) {
            mo2784Q(bundle);
        }

        public void mo2784Q(Bundle bundle) {
            super.mo2784Q(bundle);
            this.cCt = bundle.getString("_wxapi_showmessage_req_lang");
            this.country = bundle.getString("_wxapi_showmessage_req_country");
            this.dAY = C3306a.m10304R(bundle);
        }

        public boolean checkArgs() {
            return this.dAY == null ? false : this.dAY.checkArgs();
        }

        public int getType() {
            return 4;
        }

        public void mo2787o(Bundle bundle) {
            Bundle a = C3306a.m10305a(this.dAY);
            super.mo2787o(a);
            bundle.putString("_wxapi_showmessage_req_lang", this.cCt);
            bundle.putString("_wxapi_showmessage_req_country", this.country);
            bundle.putAll(a);
        }
    }
}
