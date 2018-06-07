package com.fossil;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

public class afi extends agp {
    protected JsonToken aMA;
    protected JsonToken aMB;
    protected afk aMC;
    protected boolean aMD;
    protected boolean aME;
    @Deprecated
    protected boolean aMF = false;
    protected afl aMG;
    protected afl aMH;
    protected afk aMI;

    public afi(JsonParser jsonParser, afk com_fossil_afk, boolean z, boolean z2) {
        super(jsonParser);
        this.aMC = com_fossil_afk;
        this.aMI = com_fossil_afk;
        this.aMG = afl.m3137a(com_fossil_afk);
        this.aME = z;
        this.aMD = z2;
    }

    public JsonToken zU() {
        return this.aMA;
    }

    public final int zV() {
        JsonToken jsonToken = this.aMA;
        return jsonToken == null ? 0 : jsonToken.id();
    }

    public boolean fn(int i) {
        JsonToken jsonToken = this.aMA;
        if (jsonToken == null) {
            if (i == 0) {
                return true;
            }
            return false;
        } else if (jsonToken.id() != i) {
            return false;
        } else {
            return true;
        }
    }

    public final boolean mo865a(JsonToken jsonToken) {
        return this.aMA == jsonToken;
    }

    public boolean Aa() {
        return this.aMA == JsonToken.START_ARRAY;
    }

    public boolean Ab() {
        return this.aMA == JsonToken.START_OBJECT;
    }

    public JsonLocation zZ() {
        return this.aPO.zZ();
    }

    public aez zX() {
        return Bf();
    }

    public String zW() throws IOException {
        aez Bf = Bf();
        if (this.aMA != JsonToken.START_OBJECT && this.aMA != JsonToken.START_ARRAY) {
            return Bf.zW();
        }
        Bf = Bf.Az();
        return Bf == null ? null : Bf.zW();
    }

    public void Ac() {
        if (this.aMA != null) {
            this.aMB = this.aMA;
            this.aMA = null;
        }
    }

    public JsonToken zP() throws IOException {
        JsonToken Bn;
        afl com_fossil_afl = this.aMH;
        if (com_fossil_afl != null) {
            do {
                Bn = com_fossil_afl.Bn();
                if (Bn != null) {
                    this.aMA = Bn;
                    return Bn;
                } else if (com_fossil_afl == this.aMG) {
                    this.aMH = null;
                    if (com_fossil_afl.AA()) {
                        Bn = this.aPO.zU();
                        this.aMA = Bn;
                        return Bn;
                    }
                } else {
                    com_fossil_afl = this.aMG.m3143c(com_fossil_afl);
                    this.aMH = com_fossil_afl;
                }
            } while (com_fossil_afl != null);
            throw aZ("Unexpected problem: chain of filtered context broken");
        }
        Bn = this.aPO.zP();
        if (Bn == null) {
            this.aMA = Bn;
            return Bn;
        }
        afk com_fossil_afk;
        afk Bl;
        switch (Bn.id()) {
            case 1:
                com_fossil_afk = this.aMI;
                if (com_fossil_afk == afk.aMK) {
                    this.aMG = this.aMG.m3142b(com_fossil_afk, true);
                    this.aMA = Bn;
                    return Bn;
                } else if (com_fossil_afk == null) {
                    this.aPO.zT();
                    break;
                } else {
                    com_fossil_afk = this.aMG.m3141b(com_fossil_afk);
                    if (com_fossil_afk == null) {
                        this.aPO.zT();
                        break;
                    }
                    if (com_fossil_afk != afk.aMK) {
                        com_fossil_afk = com_fossil_afk.Bh();
                    }
                    this.aMI = com_fossil_afk;
                    if (com_fossil_afk == afk.aMK) {
                        this.aMG = this.aMG.m3142b(com_fossil_afk, true);
                        this.aMA = Bn;
                        return Bn;
                    }
                    this.aMG = this.aMG.m3142b(com_fossil_afk, false);
                    if (this.aME) {
                        Bn = m3133a(this.aMG);
                        if (Bn != null) {
                            this.aMA = Bn;
                            return Bn;
                        }
                    }
                }
                break;
            case 2:
            case 4:
                boolean Bm = this.aMG.Bm();
                Bl = this.aMG.Bl();
                if (!(Bl == null || Bl == afk.aMK)) {
                    Bl.Bj();
                }
                this.aMG = this.aMG.Bk();
                this.aMI = this.aMG.Bl();
                if (Bm) {
                    this.aMA = Bn;
                    return Bn;
                }
                break;
            case 3:
                com_fossil_afk = this.aMI;
                if (com_fossil_afk == afk.aMK) {
                    this.aMG = this.aMG.m3139a(com_fossil_afk, true);
                    this.aMA = Bn;
                    return Bn;
                } else if (com_fossil_afk == null) {
                    this.aPO.zT();
                    break;
                } else {
                    com_fossil_afk = this.aMG.m3141b(com_fossil_afk);
                    if (com_fossil_afk == null) {
                        this.aPO.zT();
                        break;
                    }
                    if (com_fossil_afk != afk.aMK) {
                        com_fossil_afk = com_fossil_afk.Bg();
                    }
                    this.aMI = com_fossil_afk;
                    if (com_fossil_afk == afk.aMK) {
                        this.aMG = this.aMG.m3139a(com_fossil_afk, true);
                        this.aMA = Bn;
                        return Bn;
                    }
                    this.aMG = this.aMG.m3139a(com_fossil_afk, false);
                    if (this.aME) {
                        Bn = m3133a(this.aMG);
                        if (Bn != null) {
                            this.aMA = Bn;
                            return Bn;
                        }
                    }
                }
                break;
            case 5:
                String zW = this.aPO.zW();
                Bl = this.aMG.bi(zW);
                if (Bl == afk.aMK) {
                    JsonToken jsonToken;
                    this.aMI = Bl;
                    if (this.aME || !this.aMF || this.aMG.Bm()) {
                        jsonToken = Bn;
                    } else {
                        jsonToken = this.aMG.Bn();
                        this.aMH = this.aMG;
                    }
                    this.aMA = jsonToken;
                    return jsonToken;
                } else if (Bl == null) {
                    this.aPO.zP();
                    this.aPO.zT();
                    break;
                } else {
                    com_fossil_afk = Bl.bh(zW);
                    if (com_fossil_afk == null) {
                        this.aPO.zP();
                        this.aPO.zT();
                        break;
                    }
                    this.aMI = com_fossil_afk;
                    if (com_fossil_afk == afk.aMK && this.aME) {
                        this.aMA = Bn;
                        return Bn;
                    } else if (this.aME) {
                        Bn = m3133a(this.aMG);
                        if (Bn != null) {
                            this.aMA = Bn;
                            return Bn;
                        }
                    }
                }
                break;
            default:
                com_fossil_afk = this.aMI;
                if (com_fossil_afk == afk.aMK) {
                    this.aMA = Bn;
                    return Bn;
                } else if (com_fossil_afk != null) {
                    com_fossil_afk = this.aMG.m3141b(com_fossil_afk);
                    if (com_fossil_afk == afk.aMK || (com_fossil_afk != null && com_fossil_afk.m3136c(this.aPO))) {
                        this.aMA = Bn;
                        return Bn;
                    }
                }
                break;
        }
        return Be();
    }

    protected final JsonToken Be() throws IOException {
        while (true) {
            JsonToken zP = this.aPO.zP();
            if (zP == null) {
                this.aMA = zP;
                return zP;
            }
            afk com_fossil_afk;
            JsonToken a;
            afk Bl;
            switch (zP.id()) {
                case 1:
                    com_fossil_afk = this.aMI;
                    if (com_fossil_afk == afk.aMK) {
                        this.aMG = this.aMG.m3142b(com_fossil_afk, true);
                        this.aMA = zP;
                        return zP;
                    } else if (com_fossil_afk == null) {
                        this.aPO.zT();
                        break;
                    } else {
                        com_fossil_afk = this.aMG.m3141b(com_fossil_afk);
                        if (com_fossil_afk == null) {
                            this.aPO.zT();
                            break;
                        }
                        if (com_fossil_afk != afk.aMK) {
                            com_fossil_afk = com_fossil_afk.Bh();
                        }
                        this.aMI = com_fossil_afk;
                        if (com_fossil_afk == afk.aMK) {
                            this.aMG = this.aMG.m3142b(com_fossil_afk, true);
                            this.aMA = zP;
                            return zP;
                        }
                        this.aMG = this.aMG.m3142b(com_fossil_afk, false);
                        if (this.aME) {
                            a = m3133a(this.aMG);
                            if (a == null) {
                                break;
                            }
                            this.aMA = a;
                            return a;
                        }
                        continue;
                    }
                case 2:
                case 4:
                    boolean Bm = this.aMG.Bm();
                    Bl = this.aMG.Bl();
                    if (!(Bl == null || Bl == afk.aMK)) {
                        Bl.Bj();
                    }
                    this.aMG = this.aMG.Bk();
                    this.aMI = this.aMG.Bl();
                    if (!Bm) {
                        break;
                    }
                    this.aMA = zP;
                    return zP;
                case 3:
                    com_fossil_afk = this.aMI;
                    if (com_fossil_afk == afk.aMK) {
                        this.aMG = this.aMG.m3139a(com_fossil_afk, true);
                        this.aMA = zP;
                        return zP;
                    } else if (com_fossil_afk == null) {
                        this.aPO.zT();
                        break;
                    } else {
                        com_fossil_afk = this.aMG.m3141b(com_fossil_afk);
                        if (com_fossil_afk == null) {
                            this.aPO.zT();
                            break;
                        }
                        if (com_fossil_afk != afk.aMK) {
                            com_fossil_afk = com_fossil_afk.Bg();
                        }
                        this.aMI = com_fossil_afk;
                        if (com_fossil_afk == afk.aMK) {
                            this.aMG = this.aMG.m3139a(com_fossil_afk, true);
                            this.aMA = zP;
                            return zP;
                        }
                        this.aMG = this.aMG.m3139a(com_fossil_afk, false);
                        if (this.aME) {
                            a = m3133a(this.aMG);
                            if (a == null) {
                                break;
                            }
                            this.aMA = a;
                            return a;
                        }
                        continue;
                    }
                case 5:
                    String zW = this.aPO.zW();
                    Bl = this.aMG.bi(zW);
                    if (Bl == afk.aMK) {
                        this.aMI = Bl;
                        this.aMA = zP;
                        return zP;
                    } else if (Bl == null) {
                        this.aPO.zP();
                        this.aPO.zT();
                        break;
                    } else {
                        com_fossil_afk = Bl.bh(zW);
                        if (com_fossil_afk == null) {
                            this.aPO.zP();
                            this.aPO.zT();
                            break;
                        }
                        this.aMI = com_fossil_afk;
                        if (com_fossil_afk == afk.aMK) {
                            if (!this.aME) {
                                break;
                            }
                            this.aMA = zP;
                            return zP;
                        } else if (this.aME) {
                            a = m3133a(this.aMG);
                            if (a == null) {
                                break;
                            }
                            this.aMA = a;
                            return a;
                        } else {
                            continue;
                        }
                    }
                default:
                    com_fossil_afk = this.aMI;
                    if (com_fossil_afk == afk.aMK) {
                        this.aMA = zP;
                        return zP;
                    } else if (com_fossil_afk != null) {
                        com_fossil_afk = this.aMG.m3141b(com_fossil_afk);
                        if (com_fossil_afk == afk.aMK || (com_fossil_afk != null && com_fossil_afk.m3136c(this.aPO))) {
                            this.aMA = zP;
                            return zP;
                        }
                    } else {
                        continue;
                    }
            }
        }
    }

    protected final JsonToken m3133a(afl com_fossil_afl) throws IOException {
        while (true) {
            JsonToken zP = this.aPO.zP();
            if (zP == null) {
                return zP;
            }
            afk com_fossil_afk;
            switch (zP.id()) {
                case 1:
                    com_fossil_afk = this.aMI;
                    if (com_fossil_afk != afk.aMK) {
                        if (com_fossil_afk != null) {
                            com_fossil_afk = this.aMG.m3141b(com_fossil_afk);
                            if (com_fossil_afk != null) {
                                if (com_fossil_afk != afk.aMK) {
                                    com_fossil_afk = com_fossil_afk.Bh();
                                }
                                this.aMI = com_fossil_afk;
                                if (com_fossil_afk != afk.aMK) {
                                    this.aMG = this.aMG.m3142b(com_fossil_afk, false);
                                    break;
                                }
                                this.aMG = this.aMG.m3142b(com_fossil_afk, true);
                                return m3131b(com_fossil_afl);
                            }
                            this.aPO.zT();
                            break;
                        }
                        this.aPO.zT();
                        break;
                    }
                    this.aMG = this.aMG.m3142b(com_fossil_afk, true);
                    return zP;
                case 2:
                case 4:
                    boolean z;
                    com_fossil_afk = this.aMG.Bl();
                    if (!(com_fossil_afk == null || com_fossil_afk == afk.aMK)) {
                        com_fossil_afk.Bj();
                    }
                    boolean z2 = this.aMG == com_fossil_afl;
                    if (z2 && this.aMG.Bm()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.aMG = this.aMG.Bk();
                    this.aMI = this.aMG.Bl();
                    if (!z) {
                        if (!z2 && this.aMG != com_fossil_afl) {
                            break;
                        }
                        return null;
                    }
                    return zP;
                case 3:
                    com_fossil_afk = this.aMG.m3141b(this.aMI);
                    if (com_fossil_afk != null) {
                        if (com_fossil_afk != afk.aMK) {
                            com_fossil_afk = com_fossil_afk.Bg();
                        }
                        this.aMI = com_fossil_afk;
                        if (com_fossil_afk != afk.aMK) {
                            this.aMG = this.aMG.m3139a(com_fossil_afk, false);
                            break;
                        }
                        this.aMG = this.aMG.m3139a(com_fossil_afk, true);
                        return m3131b(com_fossil_afl);
                    }
                    this.aPO.zT();
                    break;
                case 5:
                    String zW = this.aPO.zW();
                    afk bi = this.aMG.bi(zW);
                    if (bi != afk.aMK) {
                        if (bi != null) {
                            com_fossil_afk = bi.bh(zW);
                            if (com_fossil_afk != null) {
                                this.aMI = com_fossil_afk;
                                if (com_fossil_afk != afk.aMK) {
                                    break;
                                }
                                return m3131b(com_fossil_afl);
                            }
                            this.aPO.zP();
                            this.aPO.zT();
                            break;
                        }
                        this.aPO.zP();
                        this.aPO.zT();
                        break;
                    }
                    this.aMI = bi;
                    return m3131b(com_fossil_afl);
                default:
                    com_fossil_afk = this.aMI;
                    if (com_fossil_afk == afk.aMK) {
                        return m3131b(com_fossil_afl);
                    }
                    if (com_fossil_afk != null) {
                        com_fossil_afk = this.aMG.m3141b(com_fossil_afk);
                        if (com_fossil_afk == afk.aMK || (com_fossil_afk != null && com_fossil_afk.m3136c(this.aPO))) {
                            return m3131b(com_fossil_afl);
                        }
                    }
                    continue;
            }
        }
    }

    private JsonToken m3131b(afl com_fossil_afl) throws IOException {
        this.aMH = com_fossil_afl;
        JsonToken Bn = com_fossil_afl.Bn();
        if (Bn == null) {
            while (com_fossil_afl != this.aMG) {
                com_fossil_afl = this.aMH.m3143c(com_fossil_afl);
                this.aMH = com_fossil_afl;
                if (com_fossil_afl == null) {
                    throw aZ("Unexpected problem: chain of filtered context broken");
                }
                Bn = this.aMH.Bn();
                if (Bn != null) {
                }
            }
            throw aZ("Internal error: failed to locate expected buffered tokens");
        }
        return Bn;
    }

    public JsonToken zQ() throws IOException {
        JsonToken zP = zP();
        if (zP == JsonToken.FIELD_NAME) {
            return zP();
        }
        return zP;
    }

    public JsonParser zT() throws IOException {
        if (this.aMA == JsonToken.START_OBJECT || this.aMA == JsonToken.START_ARRAY) {
            int i = 1;
            while (true) {
                JsonToken zP = zP();
                if (zP == null) {
                    break;
                } else if (zP.isStructStart()) {
                    i++;
                } else if (zP.isStructEnd()) {
                    i--;
                    if (i == 0) {
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        return this;
    }

    public String getText() throws IOException {
        return this.aPO.getText();
    }

    public boolean Ag() {
        return this.aPO.Ag();
    }

    public char[] Ad() throws IOException {
        return this.aPO.Ad();
    }

    public int Ae() throws IOException {
        return this.aPO.Ae();
    }

    public int Af() throws IOException {
        return this.aPO.Af();
    }

    public BigInteger Am() throws IOException {
        return this.aPO.Am();
    }

    public byte Aj() throws IOException {
        return this.aPO.Aj();
    }

    public short Ak() throws IOException {
        return this.aPO.Ak();
    }

    public BigDecimal Ap() throws IOException {
        return this.aPO.Ap();
    }

    public double Ao() throws IOException {
        return this.aPO.Ao();
    }

    public float An() throws IOException {
        return this.aPO.An();
    }

    public int getIntValue() throws IOException {
        return this.aPO.getIntValue();
    }

    public long Al() throws IOException {
        return this.aPO.Al();
    }

    public NumberType Ai() throws IOException {
        return this.aPO.Ai();
    }

    public Number Ah() throws IOException {
        return this.aPO.Ah();
    }

    public int As() throws IOException {
        return this.aPO.As();
    }

    public int fo(int i) throws IOException {
        return this.aPO.fo(i);
    }

    public long At() throws IOException {
        return this.aPO.At();
    }

    public long getValueAsLong(long j) throws IOException {
        return this.aPO.getValueAsLong(j);
    }

    public String Au() throws IOException {
        return this.aPO.Au();
    }

    public String aY(String str) throws IOException {
        return this.aPO.aY(str);
    }

    public Object Aq() throws IOException {
        return this.aPO.Aq();
    }

    public byte[] mo906a(Base64Variant base64Variant) throws IOException {
        return this.aPO.mo906a(base64Variant);
    }

    public int mo904a(Base64Variant base64Variant, OutputStream outputStream) throws IOException {
        return this.aPO.mo904a(base64Variant, outputStream);
    }

    public JsonLocation zY() {
        return this.aPO.zY();
    }

    protected aez Bf() {
        if (this.aMH != null) {
            return this.aMH;
        }
        return this.aMG;
    }
}
