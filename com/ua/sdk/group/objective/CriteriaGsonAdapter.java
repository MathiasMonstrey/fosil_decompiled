package com.ua.sdk.group.objective;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfr;
import com.fossil.cft;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.ehr;
import com.fossil.ehs;
import com.fossil.eht;
import com.fossil.ehu;
import com.fossil.ehv;
import com.fossil.ehw;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.Map.Entry;

public class CriteriaGsonAdapter implements cfo<ehs>, cfv<ehs> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16188C(com_fossil_cfp, type, com_fossil_cfn);
    }

    public ehs m16188C(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        cfr WA = com_fossil_cfp.WA();
        ehs com_fossil_eht = new eht();
        for (Entry entry : WA.entrySet()) {
            ehu com_fossil_ehr;
            String str = (String) entry.getKey();
            if (ehw.dHK.equals(str)) {
                com_fossil_ehr = new ehr();
                com_fossil_ehr.setValue(Integer.valueOf(((cfp) entry.getValue()).getAsInt()));
            } else if (ehw.dHL.equals(str)) {
                com_fossil_ehr = new SortCriteriaItem();
                com_fossil_ehr.setValue(((cfp) entry.getValue()).getAsString());
            } else {
                com_fossil_ehr = new ehv();
                ((ehv) com_fossil_ehr).setValue(((cfp) entry.getValue()).toString());
                ((ehv) com_fossil_ehr).name = str;
                com_fossil_ehr.setValue(((cfp) entry.getValue()).toString());
            }
            com_fossil_eht.a(com_fossil_ehr);
        }
        return com_fossil_eht;
    }

    public cfp m16189a(ehs com_fossil_ehs, Type type, cfu com_fossil_cfu) {
        cfp com_fossil_cfr = new cfr();
        for (String str : ((eht) com_fossil_ehs).dHJ.keySet()) {
            if (ehw.dHK.equals(str)) {
                com_fossil_cfr.a(str, new cft((Integer) ((ehu) ((eht) com_fossil_ehs).dHJ.get(str)).getValue()));
            } else if (ehw.dHL.equals(str)) {
                com_fossil_cfr.a(str, new cft((String) ((ehu) ((eht) com_fossil_ehs).dHJ.get(str)).getValue()));
            } else {
                com_fossil_cfr.a(str, new cft((String) ((ehu) ((eht) com_fossil_ehs).dHJ.get(str)).getValue()));
            }
        }
        return com_fossil_cfr;
    }
}
