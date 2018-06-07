package com.fossil;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;

public final class afz extends aez {
    protected int _columnNr;
    protected int _lineNr;
    protected String aMN;
    protected final afz aOh;
    protected afx aOi;
    protected afz aOj = null;
    protected Object aOk;

    public /* synthetic */ aez Az() {
        return BQ();
    }

    public afz(afz com_fossil_afz, afx com_fossil_afx, int i, int i2, int i3) {
        this.aOh = com_fossil_afz;
        this.aOi = com_fossil_afx;
        this._type = i;
        this._lineNr = i2;
        this._columnNr = i3;
        this._index = -1;
    }

    protected void m3188t(int i, int i2, int i3) {
        this._type = i;
        this._index = -1;
        this._lineNr = i2;
        this._columnNr = i3;
        this.aMN = null;
        this.aOk = null;
        if (this.aOi != null) {
            this.aOi.reset();
        }
    }

    public afz m3187a(afx com_fossil_afx) {
        this.aOi = com_fossil_afx;
        return this;
    }

    public void bm(Object obj) {
        this.aOk = obj;
    }

    public static afz m3186b(afx com_fossil_afx) {
        return new afz(null, com_fossil_afx, 0, 1, 0);
    }

    public afz bs(int i, int i2) {
        afz com_fossil_afz = this.aOj;
        if (com_fossil_afz == null) {
            com_fossil_afz = new afz(this, this.aOi == null ? null : this.aOi.BO(), 1, i, i2);
            this.aOj = com_fossil_afz;
        } else {
            com_fossil_afz.m3188t(1, i, i2);
        }
        return com_fossil_afz;
    }

    public afz bt(int i, int i2) {
        afz com_fossil_afz = this.aOj;
        if (com_fossil_afz == null) {
            com_fossil_afz = new afz(this, this.aOi == null ? null : this.aOi.BO(), 2, i, i2);
            this.aOj = com_fossil_afz;
        } else {
            com_fossil_afz.m3188t(2, i, i2);
        }
        return com_fossil_afz;
    }

    public String zW() {
        return this.aMN;
    }

    public afz BQ() {
        return this.aOh;
    }

    public JsonLocation bs(Object obj) {
        return new JsonLocation(obj, -1, this._lineNr, this._columnNr);
    }

    public afx BR() {
        return this.aOi;
    }

    public boolean BS() {
        int i = this._index + 1;
        this._index = i;
        return this._type != 0 && i > 0;
    }

    public void bq(String str) throws JsonProcessingException {
        this.aMN = str;
        if (this.aOi != null) {
            m3185a(this.aOi, str);
        }
    }

    private void m3185a(afx com_fossil_afx, String str) throws JsonProcessingException {
        if (com_fossil_afx.bp(str)) {
            throw new JsonParseException("Duplicate field '" + str + "'", com_fossil_afx.BP());
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        switch (this._type) {
            case 0:
                stringBuilder.append("/");
                break;
            case 1:
                stringBuilder.append('[');
                stringBuilder.append(getCurrentIndex());
                stringBuilder.append(']');
                break;
            case 2:
                stringBuilder.append('{');
                if (this.aMN != null) {
                    stringBuilder.append('\"');
                    afn.m3144a(stringBuilder, this.aMN);
                    stringBuilder.append('\"');
                } else {
                    stringBuilder.append('?');
                }
                stringBuilder.append('}');
                break;
        }
        return stringBuilder.toString();
    }
}
