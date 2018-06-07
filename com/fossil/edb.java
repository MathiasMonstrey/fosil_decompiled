package com.fossil;

import java.util.List;

public class edb extends eil {
    @cga("recorder_priorities")
    C3322a dDN;

    class C3322a {
        @cga("sleep")
        List<String> dDO;
        @cga("activity")
        List<String> dDP;
    }

    public static ecu m10545a(edb com_fossil_edb) {
        if (com_fossil_edb == null) {
            return null;
        }
        ecu com_fossil_ecu = new ecu();
        if (com_fossil_edb.dDN.dDO != null) {
            com_fossil_ecu.aF(com_fossil_edb.dDN.dDO);
        }
        if (com_fossil_edb.dDN.dDP == null) {
            return com_fossil_ecu;
        }
        com_fossil_ecu.aE(com_fossil_edb.dDN.dDP);
        return com_fossil_ecu;
    }
}
