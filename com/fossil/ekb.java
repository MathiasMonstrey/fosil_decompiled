package com.fossil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ekb extends eil {
    @cga("_embedded")
    Map<String, ArrayList<eke>> dJC;
    @cga("total_count")
    Integer dJD;

    private List<eke> aEb() {
        if (this.dJC == null) {
            return null;
        }
        return (List) this.dJC.get("remoteconnectiontypes");
    }

    public static ejx m10798a(ekb com_fossil_ekb) {
        ejx com_fossil_ejx = new ejx();
        for (eke a : com_fossil_ekb.aEb()) {
            try {
                com_fossil_ejx.m10758f(eke.m10802a(a));
            } catch (Throwable e) {
                ecq.m10489d("Error converting RemoteConnectionTypeTransferObject to RemoteConnectionTypeImpl.", e);
            }
        }
        com_fossil_ejx.m10510A(com_fossil_ekb.aDq());
        com_fossil_ejx.ok(com_fossil_ekb.dJD.intValue());
        return com_fossil_ejx;
    }
}
