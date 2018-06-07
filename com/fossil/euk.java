package com.fossil;

public class euk {
    private final eul dVF;
    private final eur dVG;
    private final String name;

    public euk(String str, eur com_fossil_eur) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        } else if (com_fossil_eur == null) {
            throw new IllegalArgumentException("Body may not be null");
        } else {
            this.name = str;
            this.dVG = com_fossil_eur;
            this.dVF = new eul();
            m11235a(com_fossil_eur);
            m11236b(com_fossil_eur);
            m11237c(com_fossil_eur);
        }
    }

    public String getName() {
        return this.name;
    }

    public eur aHO() {
        return this.dVG;
    }

    public eul aHP() {
        return this.dVF;
    }

    public void addField(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Field name may not be null");
        }
        this.dVF.m11238a(new euo(str, str2));
    }

    protected void m11235a(eur com_fossil_eur) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("form-data; name=\"");
        stringBuilder.append(getName());
        stringBuilder.append("\"");
        if (com_fossil_eur.aHT() != null) {
            stringBuilder.append("; filename=\"");
            stringBuilder.append(com_fossil_eur.aHT());
            stringBuilder.append("\"");
        }
        addField("Content-Disposition", stringBuilder.toString());
    }

    protected void m11236b(eur com_fossil_eur) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(com_fossil_eur.getMimeType());
        if (com_fossil_eur.aHU() != null) {
            stringBuilder.append("; charset=");
            stringBuilder.append(com_fossil_eur.aHU());
        }
        addField("Content-Type", stringBuilder.toString());
    }

    protected void m11237c(eur com_fossil_eur) {
        addField("Content-Transfer-Encoding", com_fossil_eur.getTransferEncoding());
    }
}
