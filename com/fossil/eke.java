package com.fossil;

import com.ua.sdk.UaException;

public class eke extends eil {
    @cga("recorder_type_key")
    String dDM;
    @cga("disconnect_cancel")
    String dJG;
    @cga("oauth_connect_link")
    String dJH;
    @cga("disconnect_confirm")
    String dJI;
    @cga("disconnect_copy")
    String dJJ;
    @cga("intro_copy_heading")
    String dJK;
    @cga("intro_copy_body")
    String dJL;
    @cga("logo_link")
    String dJz;
    @cga("name")
    String name;
    @cga("type")
    String type;

    public static ejv m10802a(eke com_fossil_eke) throws UaException {
        if (com_fossil_eke == null) {
            return null;
        }
        ejv com_fossil_ejv = new ejv();
        com_fossil_ejv.setType(com_fossil_eke.type);
        com_fossil_ejv.lM(com_fossil_eke.dDM);
        com_fossil_ejv.setName(com_fossil_eke.name);
        com_fossil_ejv.lN(com_fossil_eke.dJK);
        com_fossil_ejv.lO(com_fossil_eke.dJL);
        com_fossil_ejv.lP(com_fossil_eke.dJJ);
        com_fossil_ejv.lQ(com_fossil_eke.dJG);
        com_fossil_ejv.lR(com_fossil_eke.dJI);
        com_fossil_ejv.lS(com_fossil_eke.dJz);
        com_fossil_ejv.lT(com_fossil_eke.dJz);
        com_fossil_ejv.lU(com_fossil_eke.dJH);
        for (String str : com_fossil_eke.aDr()) {
            com_fossil_ejv.m10512b(str, com_fossil_eke.lz(str));
        }
        return com_fossil_ejv;
    }
}
