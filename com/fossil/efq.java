package com.fossil;

import java.util.List;

public class efq extends eil {
    @cga("mets")
    Double dGa;
    @cga("mets_speed")
    List<C3373a> dGb;
    @cga("short_name")
    String dGc;
    @cga("has_children")
    Boolean dGd;
    @cga("name")
    String name;

    class C3373a {
        @cga("mets")
        String dGe;
        @cga("speed")
        Double dGf;
    }

    public static efo m10617a(efq com_fossil_efq) {
        if (com_fossil_efq == null) {
            return null;
        }
        efo com_fossil_efo = new efo(com_fossil_efq.aCV(), com_fossil_efq.aCW(), com_fossil_efq.name, com_fossil_efq.dGc, com_fossil_efq.dGa, com_fossil_efq.aCX(), com_fossil_efq.dGd, null);
        com_fossil_efo.m10510A(com_fossil_efq.aDq());
        return com_fossil_efo;
    }

    private String lw(String str) {
        eiu lA = lA(str);
        return lA == null ? null : lA.getId();
    }

    public String aCV() {
        return lw("self");
    }

    public String aCW() {
        return lw("parent");
    }

    public String aCX() {
        if (this.dGb == null || this.dGb.isEmpty()) {
            return "{}";
        }
        int size = this.dGb.size();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append(',');
            }
            C3373a c3373a = (C3373a) this.dGb.get(i);
            stringBuilder.append("\"").append(c3373a.dGe).append("\"").append(":").append(c3373a.dGf);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
