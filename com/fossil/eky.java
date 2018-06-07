package com.fossil;

import com.ua.sdk.UaException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class eky extends eil {
    @cga("_embedded")
    public Map<String, ArrayList<elc>> dLw;
    @cga("total_count")
    public Integer dLx;

    private ArrayList<elc> aEE() {
        if (this.dLw == null) {
            return null;
        }
        return (ArrayList) this.dLw.get("user");
    }

    public static eku m10844a(eky com_fossil_eky) throws UaException {
        eku com_fossil_eku = new eku();
        Iterator it = com_fossil_eky.aEE().iterator();
        while (it.hasNext()) {
            com_fossil_eku.m10758f(elc.m10853a((elc) it.next()));
        }
        com_fossil_eku.m10510A(com_fossil_eky.aDq());
        com_fossil_eku.ok(com_fossil_eky.dLx.intValue());
        return com_fossil_eku;
    }
}
