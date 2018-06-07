package com.fossil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;

public class afl extends aez {
    protected afk _filter;
    protected final afl aML;
    protected afl aMM = null;
    protected String aMN;
    protected boolean aMO;
    protected boolean aMP;

    public /* synthetic */ aez Az() {
        return Bk();
    }

    protected afl(int i, afl com_fossil_afl, afk com_fossil_afk, boolean z) {
        this._type = i;
        this.aML = com_fossil_afl;
        this._filter = com_fossil_afk;
        this._index = -1;
        this.aMO = z;
        this.aMP = false;
    }

    protected afl m3138a(int i, afk com_fossil_afk, boolean z) {
        this._type = i;
        this._filter = com_fossil_afk;
        this._index = -1;
        this.aMN = null;
        this.aMO = z;
        this.aMP = false;
        return this;
    }

    public static afl m3137a(afk com_fossil_afk) {
        return new afl(0, null, com_fossil_afk, true);
    }

    public afl m3139a(afk com_fossil_afk, boolean z) {
        afl com_fossil_afl = this.aMM;
        if (com_fossil_afl != null) {
            return com_fossil_afl.m3138a(1, com_fossil_afk, z);
        }
        com_fossil_afl = new afl(1, this, com_fossil_afk, z);
        this.aMM = com_fossil_afl;
        return com_fossil_afl;
    }

    public afl m3142b(afk com_fossil_afk, boolean z) {
        afl com_fossil_afl = this.aMM;
        if (com_fossil_afl != null) {
            return com_fossil_afl.m3138a(2, com_fossil_afk, z);
        }
        com_fossil_afl = new afl(2, this, com_fossil_afk, z);
        this.aMM = com_fossil_afl;
        return com_fossil_afl;
    }

    public afk bi(String str) throws JsonProcessingException {
        this.aMN = str;
        this.aMP = true;
        return this._filter;
    }

    public afk m3141b(afk com_fossil_afk) {
        if (this._type == 2) {
            return com_fossil_afk;
        }
        int i = this._index + 1;
        this._index = i;
        if (this._type == 1) {
            return com_fossil_afk.fv(i);
        }
        return com_fossil_afk.fw(i);
    }

    public void bm(Object obj) {
    }

    public final afl Bk() {
        return this.aML;
    }

    public final String zW() {
        return this.aMN;
    }

    public afk Bl() {
        return this._filter;
    }

    public boolean Bm() {
        return this.aMO;
    }

    public JsonToken Bn() {
        if (!this.aMO) {
            this.aMO = true;
            if (this._type == 2) {
                return JsonToken.START_OBJECT;
            }
            return JsonToken.START_ARRAY;
        } else if (!this.aMP || this._type != 2) {
            return null;
        } else {
            this.aMP = false;
            return JsonToken.FIELD_NAME;
        }
    }

    public afl m3143c(afl com_fossil_afl) {
        if (this.aML == com_fossil_afl) {
            return this;
        }
        this = this.aML;
        while (this != null) {
            afl com_fossil_afl2 = this.aML;
            if (com_fossil_afl2 == com_fossil_afl) {
                return this;
            }
            this = com_fossil_afl2;
        }
        return null;
    }

    protected void m3140a(StringBuilder stringBuilder) {
        if (this.aML != null) {
            this.aML.m3140a(stringBuilder);
        }
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
        m3140a(stringBuilder);
        return stringBuilder.toString();
    }
}
