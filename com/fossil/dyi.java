package com.fossil;

import android.os.Bundle;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class dyi {

    public static class C3295a extends dyh {
        public List<C3296b> dAQ;

        public C3295a(Bundle bundle) {
            mo2782Q(bundle);
        }

        public void mo2782Q(Bundle bundle) {
            super.mo2782Q(bundle);
            if (this.dAQ == null) {
                this.dAQ = new LinkedList();
            }
            String string = bundle.getString("_wxapi_add_card_to_wx_card_list");
            if (string != null && string.length() > 0) {
                try {
                    JSONArray jSONArray = ((JSONObject) new JSONTokener(string).nextValue()).getJSONArray("card_list");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        C3296b c3296b = new C3296b();
                        c3296b.dAR = jSONObject.optString("card_id");
                        c3296b.dAS = jSONObject.optString("card_ext");
                        c3296b.dAT = jSONObject.optInt("is_succ");
                        this.dAQ.add(c3296b);
                    }
                } catch (Exception e) {
                }
            }
        }

        public int getType() {
            return 9;
        }
    }

    public static final class C3296b {
        public String dAR;
        public String dAS;
        public int dAT;
    }
}
