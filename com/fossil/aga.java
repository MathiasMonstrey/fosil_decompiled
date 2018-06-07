package com.fossil;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;

public class aga extends aez {
    protected String aMN;
    protected afx aOi;
    protected Object aOk;
    protected final aga aOl;
    protected aga aOm = null;
    protected boolean aOn;

    public /* synthetic */ aez Az() {
        return BV();
    }

    protected aga(int i, aga com_fossil_aga, afx com_fossil_afx) {
        this._type = i;
        this.aOl = com_fossil_aga;
        this.aOi = com_fossil_afx;
        this._index = -1;
    }

    protected aga fJ(int i) {
        this._type = i;
        this._index = -1;
        this.aMN = null;
        this.aOn = false;
        this.aOk = null;
        if (this.aOi != null) {
            this.aOi.reset();
        }
        return this;
    }

    public aga m3192c(afx com_fossil_afx) {
        this.aOi = com_fossil_afx;
        return this;
    }

    public void bm(Object obj) {
        this.aOk = obj;
    }

    public static aga m3190d(afx com_fossil_afx) {
        return new aga(0, null, com_fossil_afx);
    }

    public aga BT() {
        aga com_fossil_aga = this.aOm;
        if (com_fossil_aga != null) {
            return com_fossil_aga.fJ(1);
        }
        aga com_fossil_aga2 = new aga(1, this, this.aOi == null ? null : this.aOi.BO());
        this.aOm = com_fossil_aga2;
        return com_fossil_aga2;
    }

    public aga BU() {
        aga com_fossil_aga = this.aOm;
        if (com_fossil_aga != null) {
            return com_fossil_aga.fJ(2);
        }
        aga com_fossil_aga2 = new aga(2, this, this.aOi == null ? null : this.aOi.BO());
        this.aOm = com_fossil_aga2;
        return com_fossil_aga2;
    }

    public final aga BV() {
        return this.aOl;
    }

    public final String zW() {
        return this.aMN;
    }

    public afx BR() {
        return this.aOi;
    }

    public int br(String str) throws JsonProcessingException {
        if (this.aOn) {
            return 4;
        }
        this.aOn = true;
        this.aMN = str;
        if (this.aOi != null) {
            m3189a(this.aOi, str);
        }
        if (this._index < 0) {
            return 0;
        }
        return 1;
    }

    private final void m3189a(afx com_fossil_afx, String str) throws JsonProcessingException {
        if (com_fossil_afx.bp(str)) {
            throw new JsonGenerationException("Duplicate field '" + str + "'");
        }
    }

    public int BW() {
        if (this._type == 2) {
            if (!this.aOn) {
                return 5;
            }
            this.aOn = false;
            this._index++;
            return 2;
        } else if (this._type == 1) {
            int i = this._index;
            this._index++;
            if (i >= 0) {
                return 1;
            }
            return 0;
        } else {
            this._index++;
            if (this._index != 0) {
                return 3;
            }
            return 0;
        }
    }

    protected void m3191a(StringBuilder stringBuilder) {
        if (this._type == 2) {
            stringBuilder.append('{');
            if (this.aMN != null) {
                stringBuilder.append('\"');
                stringBuilder.append(this.aMN);
                stringBuilder.append('\"');
            } else {
                stringBuilder.append('?');
            }
            stringBuilder.append('}');
        } else if (this._type == 1) {
            stringBuilder.append('[');
            stringBuilder.append(getCurrentIndex());
            stringBuilder.append(']');
        } else {
            stringBuilder.append("/");
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        m3191a(stringBuilder);
        return stringBuilder.toString();
    }
}
