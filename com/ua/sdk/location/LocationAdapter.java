package com.ua.sdk.location;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfr;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.ejd;
import com.fossil.eje;
import com.google.gson.JsonParseException;
import com.misfit.frameworks.common.constants.Constants;
import com.portfolio.platform.response.user.MFGetWechatUserInfoResponse;
import java.lang.reflect.Type;

public class LocationAdapter implements cfo<ejd>, cfv<ejd> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16208I(com_fossil_cfp, type, com_fossil_cfn);
    }

    public ejd m16208I(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        if (!com_fossil_cfp.Wx()) {
            return null;
        }
        cfr WA = com_fossil_cfp.WA();
        return new eje(m16207a(WA, MFGetWechatUserInfoResponse.COUNTRY), m16207a(WA, Constants.REGION), m16207a(WA, "locality"), m16207a(WA, "address"));
    }

    public cfp m16209a(ejd com_fossil_ejd, Type type, cfu com_fossil_cfu) {
        cfp com_fossil_cfr = new cfr();
        com_fossil_cfr.ak(MFGetWechatUserInfoResponse.COUNTRY, com_fossil_ejd.getCountry());
        com_fossil_cfr.ak(Constants.REGION, com_fossil_ejd.aDW());
        com_fossil_cfr.ak("locality", com_fossil_ejd.getLocality());
        com_fossil_cfr.ak("address", com_fossil_ejd.getAddress());
        return com_fossil_cfr;
    }

    private String m16207a(cfr com_fossil_cfr, String str) {
        cfp fq = com_fossil_cfr.fq(str);
        if (fq != null) {
            return fq.getAsString();
        }
        return null;
    }
}
