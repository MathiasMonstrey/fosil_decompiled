package com.ua.sdk.gear.user;

import com.fossil.cfm;
import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfr;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.ece;
import com.fossil.ehi;
import com.fossil.ehj;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.List;

public class UserGearAdapter implements cfo<ehi>, cfv<ehi> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16178y(com_fossil_cfp, type, com_fossil_cfn);
    }

    public ehi m16178y(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        cfp WA = com_fossil_cfp.WA();
        cfr fr = WA.fr("_embedded");
        if (fr != null) {
            cfp fr2 = fr.fr("gear");
            fr2.a("_links", fr.fr("_links"));
            WA.a("gear", fr2);
        }
        return (ehi) com_fossil_cfn.b(WA, ehj.class);
    }

    public cfp m16176a(ehi com_fossil_ehi, Type type, cfu com_fossil_cfu) {
        cfp WA = com_fossil_cfu.c(com_fossil_ehi, com_fossil_ehi.getClass()).WA();
        if (!(com_fossil_ehi.aDf() == null || com_fossil_ehi.aDf().aCt() == null)) {
            WA.a("gear", com_fossil_cfu.cI(com_fossil_ehi.aDf().aCt().getHref()));
        }
        if (com_fossil_ehi.aDg() != null) {
            WA.fp("_links");
            List<ece> aDg = com_fossil_ehi.aDg();
            cfp com_fossil_cfm = new cfm();
            for (ece href : aDg) {
                com_fossil_cfm.c(com_fossil_cfu.cI(href.getHref()));
            }
            WA.a("default_activities", com_fossil_cfm);
        }
        return WA;
    }
}
