package com.fossil;

import com.misfit.frameworks.common.enums.Action.Selfie;
import java.io.IOException;

public final class bsy extends bcj<bsy> {
    private static volatile bsy[] bEy;
    public bsv[] bEA;
    public bta[] bEB;
    public Long bEC;
    public Long bED;
    public Long bEE;
    public Long bEF;
    public Long bEG;
    public String bEH;
    public String bEI;
    public String bEJ;
    public String bEK;
    public Integer bEL;
    public String bEM;
    public Long bEN;
    public Long bEO;
    public String bEP;
    public Boolean bEQ;
    public String bER;
    public Long bES;
    public Integer bET;
    public Boolean bEU;
    public bsu[] bEV;
    public Integer bEW;
    private Integer bEX;
    private Integer bEY;
    public Long bEZ;
    public Integer bEz;
    public Long bFa;
    public String bFb;
    public String bpS;
    public String bxq;
    public String bxr;
    public String bxu;
    public String bxy;

    public bsy() {
        this.bEz = null;
        this.bEA = bsv.Sr();
        this.bEB = bta.Su();
        this.bEC = null;
        this.bED = null;
        this.bEE = null;
        this.bEF = null;
        this.bEG = null;
        this.bEH = null;
        this.bEI = null;
        this.bEJ = null;
        this.bEK = null;
        this.bEL = null;
        this.bxr = null;
        this.bEM = null;
        this.bpS = null;
        this.bEN = null;
        this.bEO = null;
        this.bEP = null;
        this.bEQ = null;
        this.bER = null;
        this.bES = null;
        this.bET = null;
        this.bxu = null;
        this.bxq = null;
        this.bEU = null;
        this.bEV = bsu.Sq();
        this.bxy = null;
        this.bEW = null;
        this.bEX = null;
        this.bEY = null;
        this.bEZ = null;
        this.bFa = null;
        this.bFb = null;
        this.bqp = null;
        this.bqy = -1;
    }

    public static bsy[] St() {
        if (bEy == null) {
            synchronized (bcn.bqx) {
                if (bEy == null) {
                    bEy = new bsy[0];
                }
            }
        }
        return bEy;
    }

    protected final int MR() {
        int i;
        int i2 = 0;
        int MR = super.MR();
        if (this.bEz != null) {
            MR += bci.bM(1, this.bEz.intValue());
        }
        if (this.bEA != null && this.bEA.length > 0) {
            i = MR;
            for (bco com_fossil_bco : this.bEA) {
                if (com_fossil_bco != null) {
                    i += bci.m4841b(2, com_fossil_bco);
                }
            }
            MR = i;
        }
        if (this.bEB != null && this.bEB.length > 0) {
            i = MR;
            for (bco com_fossil_bco2 : this.bEB) {
                if (com_fossil_bco2 != null) {
                    i += bci.m4841b(3, com_fossil_bco2);
                }
            }
            MR = i;
        }
        if (this.bEC != null) {
            MR += bci.m4844j(4, this.bEC.longValue());
        }
        if (this.bED != null) {
            MR += bci.m4844j(5, this.bED.longValue());
        }
        if (this.bEE != null) {
            MR += bci.m4844j(6, this.bEE.longValue());
        }
        if (this.bEG != null) {
            MR += bci.m4844j(7, this.bEG.longValue());
        }
        if (this.bEH != null) {
            MR += bci.m4845k(8, this.bEH);
        }
        if (this.bEI != null) {
            MR += bci.m4845k(9, this.bEI);
        }
        if (this.bEJ != null) {
            MR += bci.m4845k(10, this.bEJ);
        }
        if (this.bEK != null) {
            MR += bci.m4845k(11, this.bEK);
        }
        if (this.bEL != null) {
            MR += bci.bM(12, this.bEL.intValue());
        }
        if (this.bxr != null) {
            MR += bci.m4845k(13, this.bxr);
        }
        if (this.bEM != null) {
            MR += bci.m4845k(14, this.bEM);
        }
        if (this.bpS != null) {
            MR += bci.m4845k(16, this.bpS);
        }
        if (this.bEN != null) {
            MR += bci.m4844j(17, this.bEN.longValue());
        }
        if (this.bEO != null) {
            MR += bci.m4844j(18, this.bEO.longValue());
        }
        if (this.bEP != null) {
            MR += bci.m4845k(19, this.bEP);
        }
        if (this.bEQ != null) {
            this.bEQ.booleanValue();
            MR += bci.hT(20) + 1;
        }
        if (this.bER != null) {
            MR += bci.m4845k(21, this.bER);
        }
        if (this.bES != null) {
            MR += bci.m4844j(22, this.bES.longValue());
        }
        if (this.bET != null) {
            MR += bci.bM(23, this.bET.intValue());
        }
        if (this.bxu != null) {
            MR += bci.m4845k(24, this.bxu);
        }
        if (this.bxq != null) {
            MR += bci.m4845k(25, this.bxq);
        }
        if (this.bEF != null) {
            MR += bci.m4844j(26, this.bEF.longValue());
        }
        if (this.bEU != null) {
            this.bEU.booleanValue();
            MR += bci.hT(28) + 1;
        }
        if (this.bEV != null && this.bEV.length > 0) {
            while (i2 < this.bEV.length) {
                bco com_fossil_bco3 = this.bEV[i2];
                if (com_fossil_bco3 != null) {
                    MR += bci.m4841b(29, com_fossil_bco3);
                }
                i2++;
            }
        }
        if (this.bxy != null) {
            MR += bci.m4845k(30, this.bxy);
        }
        if (this.bEW != null) {
            MR += bci.bM(31, this.bEW.intValue());
        }
        if (this.bEX != null) {
            MR += bci.bM(32, this.bEX.intValue());
        }
        if (this.bEY != null) {
            MR += bci.bM(33, this.bEY.intValue());
        }
        if (this.bEZ != null) {
            MR += bci.m4844j(35, this.bEZ.longValue());
        }
        if (this.bFa != null) {
            MR += bci.m4844j(36, this.bFa.longValue());
        }
        return this.bFb != null ? MR + bci.m4845k(37, this.bFb) : MR;
    }

    public final /* synthetic */ bco mo1266a(bch com_fossil_bch) throws IOException {
        while (true) {
            int MF = com_fossil_bch.MF();
            int b;
            Object obj;
            switch (MF) {
                case 0:
                    break;
                case 8:
                    this.bEz = Integer.valueOf(com_fossil_bch.MJ());
                    continue;
                case 18:
                    b = bcr.m4872b(com_fossil_bch, 18);
                    MF = this.bEA == null ? 0 : this.bEA.length;
                    obj = new bsv[(b + MF)];
                    if (MF != 0) {
                        System.arraycopy(this.bEA, 0, obj, 0, MF);
                    }
                    while (MF < obj.length - 1) {
                        obj[MF] = new bsv();
                        com_fossil_bch.m4835a(obj[MF]);
                        com_fossil_bch.MF();
                        MF++;
                    }
                    obj[MF] = new bsv();
                    com_fossil_bch.m4835a(obj[MF]);
                    this.bEA = obj;
                    continue;
                case 26:
                    b = bcr.m4872b(com_fossil_bch, 26);
                    MF = this.bEB == null ? 0 : this.bEB.length;
                    obj = new bta[(b + MF)];
                    if (MF != 0) {
                        System.arraycopy(this.bEB, 0, obj, 0, MF);
                    }
                    while (MF < obj.length - 1) {
                        obj[MF] = new bta();
                        com_fossil_bch.m4835a(obj[MF]);
                        com_fossil_bch.MF();
                        MF++;
                    }
                    obj[MF] = new bta();
                    com_fossil_bch.m4835a(obj[MF]);
                    this.bEB = obj;
                    continue;
                case 32:
                    this.bEC = Long.valueOf(com_fossil_bch.MK());
                    continue;
                case 40:
                    this.bED = Long.valueOf(com_fossil_bch.MK());
                    continue;
                case 48:
                    this.bEE = Long.valueOf(com_fossil_bch.MK());
                    continue;
                case 56:
                    this.bEG = Long.valueOf(com_fossil_bch.MK());
                    continue;
                case 66:
                    this.bEH = com_fossil_bch.readString();
                    continue;
                case 74:
                    this.bEI = com_fossil_bch.readString();
                    continue;
                case 82:
                    this.bEJ = com_fossil_bch.readString();
                    continue;
                case 90:
                    this.bEK = com_fossil_bch.readString();
                    continue;
                case 96:
                    this.bEL = Integer.valueOf(com_fossil_bch.MJ());
                    continue;
                case 106:
                    this.bxr = com_fossil_bch.readString();
                    continue;
                case 114:
                    this.bEM = com_fossil_bch.readString();
                    continue;
                case 130:
                    this.bpS = com_fossil_bch.readString();
                    continue;
                case 136:
                    this.bEN = Long.valueOf(com_fossil_bch.MK());
                    continue;
                case 144:
                    this.bEO = Long.valueOf(com_fossil_bch.MK());
                    continue;
                case 154:
                    this.bEP = com_fossil_bch.readString();
                    continue;
                case 160:
                    this.bEQ = Boolean.valueOf(com_fossil_bch.MI());
                    continue;
                case 170:
                    this.bER = com_fossil_bch.readString();
                    continue;
                case 176:
                    this.bES = Long.valueOf(com_fossil_bch.MK());
                    continue;
                case 184:
                    this.bET = Integer.valueOf(com_fossil_bch.MJ());
                    continue;
                case 194:
                    this.bxu = com_fossil_bch.readString();
                    continue;
                case Selfie.TAKE_BURST /*202*/:
                    this.bxq = com_fossil_bch.readString();
                    continue;
                case 208:
                    this.bEF = Long.valueOf(com_fossil_bch.MK());
                    continue;
                case 224:
                    this.bEU = Boolean.valueOf(com_fossil_bch.MI());
                    continue;
                case 234:
                    b = bcr.m4872b(com_fossil_bch, 234);
                    MF = this.bEV == null ? 0 : this.bEV.length;
                    obj = new bsu[(b + MF)];
                    if (MF != 0) {
                        System.arraycopy(this.bEV, 0, obj, 0, MF);
                    }
                    while (MF < obj.length - 1) {
                        obj[MF] = new bsu();
                        com_fossil_bch.m4835a(obj[MF]);
                        com_fossil_bch.MF();
                        MF++;
                    }
                    obj[MF] = new bsu();
                    com_fossil_bch.m4835a(obj[MF]);
                    this.bEV = obj;
                    continue;
                case 242:
                    this.bxy = com_fossil_bch.readString();
                    continue;
                case 248:
                    this.bEW = Integer.valueOf(com_fossil_bch.MJ());
                    continue;
                case 256:
                    this.bEX = Integer.valueOf(com_fossil_bch.MJ());
                    continue;
                case 264:
                    this.bEY = Integer.valueOf(com_fossil_bch.MJ());
                    continue;
                case 280:
                    this.bEZ = Long.valueOf(com_fossil_bch.MK());
                    continue;
                case 288:
                    this.bFa = Long.valueOf(com_fossil_bch.MK());
                    continue;
                case 298:
                    this.bFb = com_fossil_bch.readString();
                    continue;
                default:
                    if (!super.m4861a(com_fossil_bch, MF)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public final void mo1264a(bci com_fossil_bci) throws IOException {
        int i = 0;
        if (this.bEz != null) {
            com_fossil_bci.bL(1, this.bEz.intValue());
        }
        if (this.bEA != null && this.bEA.length > 0) {
            for (bco com_fossil_bco : this.bEA) {
                if (com_fossil_bco != null) {
                    com_fossil_bci.m4848a(2, com_fossil_bco);
                }
            }
        }
        if (this.bEB != null && this.bEB.length > 0) {
            for (bco com_fossil_bco2 : this.bEB) {
                if (com_fossil_bco2 != null) {
                    com_fossil_bci.m4848a(3, com_fossil_bco2);
                }
            }
        }
        if (this.bEC != null) {
            com_fossil_bci.m4853i(4, this.bEC.longValue());
        }
        if (this.bED != null) {
            com_fossil_bci.m4853i(5, this.bED.longValue());
        }
        if (this.bEE != null) {
            com_fossil_bci.m4853i(6, this.bEE.longValue());
        }
        if (this.bEG != null) {
            com_fossil_bci.m4853i(7, this.bEG.longValue());
        }
        if (this.bEH != null) {
            com_fossil_bci.m4854j(8, this.bEH);
        }
        if (this.bEI != null) {
            com_fossil_bci.m4854j(9, this.bEI);
        }
        if (this.bEJ != null) {
            com_fossil_bci.m4854j(10, this.bEJ);
        }
        if (this.bEK != null) {
            com_fossil_bci.m4854j(11, this.bEK);
        }
        if (this.bEL != null) {
            com_fossil_bci.bL(12, this.bEL.intValue());
        }
        if (this.bxr != null) {
            com_fossil_bci.m4854j(13, this.bxr);
        }
        if (this.bEM != null) {
            com_fossil_bci.m4854j(14, this.bEM);
        }
        if (this.bpS != null) {
            com_fossil_bci.m4854j(16, this.bpS);
        }
        if (this.bEN != null) {
            com_fossil_bci.m4853i(17, this.bEN.longValue());
        }
        if (this.bEO != null) {
            com_fossil_bci.m4853i(18, this.bEO.longValue());
        }
        if (this.bEP != null) {
            com_fossil_bci.m4854j(19, this.bEP);
        }
        if (this.bEQ != null) {
            com_fossil_bci.m4855r(20, this.bEQ.booleanValue());
        }
        if (this.bER != null) {
            com_fossil_bci.m4854j(21, this.bER);
        }
        if (this.bES != null) {
            com_fossil_bci.m4853i(22, this.bES.longValue());
        }
        if (this.bET != null) {
            com_fossil_bci.bL(23, this.bET.intValue());
        }
        if (this.bxu != null) {
            com_fossil_bci.m4854j(24, this.bxu);
        }
        if (this.bxq != null) {
            com_fossil_bci.m4854j(25, this.bxq);
        }
        if (this.bEF != null) {
            com_fossil_bci.m4853i(26, this.bEF.longValue());
        }
        if (this.bEU != null) {
            com_fossil_bci.m4855r(28, this.bEU.booleanValue());
        }
        if (this.bEV != null && this.bEV.length > 0) {
            while (i < this.bEV.length) {
                bco com_fossil_bco3 = this.bEV[i];
                if (com_fossil_bco3 != null) {
                    com_fossil_bci.m4848a(29, com_fossil_bco3);
                }
                i++;
            }
        }
        if (this.bxy != null) {
            com_fossil_bci.m4854j(30, this.bxy);
        }
        if (this.bEW != null) {
            com_fossil_bci.bL(31, this.bEW.intValue());
        }
        if (this.bEX != null) {
            com_fossil_bci.bL(32, this.bEX.intValue());
        }
        if (this.bEY != null) {
            com_fossil_bci.bL(33, this.bEY.intValue());
        }
        if (this.bEZ != null) {
            com_fossil_bci.m4853i(35, this.bEZ.longValue());
        }
        if (this.bFa != null) {
            com_fossil_bci.m4853i(36, this.bFa.longValue());
        }
        if (this.bFb != null) {
            com_fossil_bci.m4854j(37, this.bFb);
        }
        super.mo1264a(com_fossil_bci);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bsy)) {
            return false;
        }
        bsy com_fossil_bsy = (bsy) obj;
        if (this.bEz == null) {
            if (com_fossil_bsy.bEz != null) {
                return false;
            }
        } else if (!this.bEz.equals(com_fossil_bsy.bEz)) {
            return false;
        }
        if (!bcn.equals(this.bEA, com_fossil_bsy.bEA)) {
            return false;
        }
        if (!bcn.equals(this.bEB, com_fossil_bsy.bEB)) {
            return false;
        }
        if (this.bEC == null) {
            if (com_fossil_bsy.bEC != null) {
                return false;
            }
        } else if (!this.bEC.equals(com_fossil_bsy.bEC)) {
            return false;
        }
        if (this.bED == null) {
            if (com_fossil_bsy.bED != null) {
                return false;
            }
        } else if (!this.bED.equals(com_fossil_bsy.bED)) {
            return false;
        }
        if (this.bEE == null) {
            if (com_fossil_bsy.bEE != null) {
                return false;
            }
        } else if (!this.bEE.equals(com_fossil_bsy.bEE)) {
            return false;
        }
        if (this.bEF == null) {
            if (com_fossil_bsy.bEF != null) {
                return false;
            }
        } else if (!this.bEF.equals(com_fossil_bsy.bEF)) {
            return false;
        }
        if (this.bEG == null) {
            if (com_fossil_bsy.bEG != null) {
                return false;
            }
        } else if (!this.bEG.equals(com_fossil_bsy.bEG)) {
            return false;
        }
        if (this.bEH == null) {
            if (com_fossil_bsy.bEH != null) {
                return false;
            }
        } else if (!this.bEH.equals(com_fossil_bsy.bEH)) {
            return false;
        }
        if (this.bEI == null) {
            if (com_fossil_bsy.bEI != null) {
                return false;
            }
        } else if (!this.bEI.equals(com_fossil_bsy.bEI)) {
            return false;
        }
        if (this.bEJ == null) {
            if (com_fossil_bsy.bEJ != null) {
                return false;
            }
        } else if (!this.bEJ.equals(com_fossil_bsy.bEJ)) {
            return false;
        }
        if (this.bEK == null) {
            if (com_fossil_bsy.bEK != null) {
                return false;
            }
        } else if (!this.bEK.equals(com_fossil_bsy.bEK)) {
            return false;
        }
        if (this.bEL == null) {
            if (com_fossil_bsy.bEL != null) {
                return false;
            }
        } else if (!this.bEL.equals(com_fossil_bsy.bEL)) {
            return false;
        }
        if (this.bxr == null) {
            if (com_fossil_bsy.bxr != null) {
                return false;
            }
        } else if (!this.bxr.equals(com_fossil_bsy.bxr)) {
            return false;
        }
        if (this.bEM == null) {
            if (com_fossil_bsy.bEM != null) {
                return false;
            }
        } else if (!this.bEM.equals(com_fossil_bsy.bEM)) {
            return false;
        }
        if (this.bpS == null) {
            if (com_fossil_bsy.bpS != null) {
                return false;
            }
        } else if (!this.bpS.equals(com_fossil_bsy.bpS)) {
            return false;
        }
        if (this.bEN == null) {
            if (com_fossil_bsy.bEN != null) {
                return false;
            }
        } else if (!this.bEN.equals(com_fossil_bsy.bEN)) {
            return false;
        }
        if (this.bEO == null) {
            if (com_fossil_bsy.bEO != null) {
                return false;
            }
        } else if (!this.bEO.equals(com_fossil_bsy.bEO)) {
            return false;
        }
        if (this.bEP == null) {
            if (com_fossil_bsy.bEP != null) {
                return false;
            }
        } else if (!this.bEP.equals(com_fossil_bsy.bEP)) {
            return false;
        }
        if (this.bEQ == null) {
            if (com_fossil_bsy.bEQ != null) {
                return false;
            }
        } else if (!this.bEQ.equals(com_fossil_bsy.bEQ)) {
            return false;
        }
        if (this.bER == null) {
            if (com_fossil_bsy.bER != null) {
                return false;
            }
        } else if (!this.bER.equals(com_fossil_bsy.bER)) {
            return false;
        }
        if (this.bES == null) {
            if (com_fossil_bsy.bES != null) {
                return false;
            }
        } else if (!this.bES.equals(com_fossil_bsy.bES)) {
            return false;
        }
        if (this.bET == null) {
            if (com_fossil_bsy.bET != null) {
                return false;
            }
        } else if (!this.bET.equals(com_fossil_bsy.bET)) {
            return false;
        }
        if (this.bxu == null) {
            if (com_fossil_bsy.bxu != null) {
                return false;
            }
        } else if (!this.bxu.equals(com_fossil_bsy.bxu)) {
            return false;
        }
        if (this.bxq == null) {
            if (com_fossil_bsy.bxq != null) {
                return false;
            }
        } else if (!this.bxq.equals(com_fossil_bsy.bxq)) {
            return false;
        }
        if (this.bEU == null) {
            if (com_fossil_bsy.bEU != null) {
                return false;
            }
        } else if (!this.bEU.equals(com_fossil_bsy.bEU)) {
            return false;
        }
        if (!bcn.equals(this.bEV, com_fossil_bsy.bEV)) {
            return false;
        }
        if (this.bxy == null) {
            if (com_fossil_bsy.bxy != null) {
                return false;
            }
        } else if (!this.bxy.equals(com_fossil_bsy.bxy)) {
            return false;
        }
        if (this.bEW == null) {
            if (com_fossil_bsy.bEW != null) {
                return false;
            }
        } else if (!this.bEW.equals(com_fossil_bsy.bEW)) {
            return false;
        }
        if (this.bEX == null) {
            if (com_fossil_bsy.bEX != null) {
                return false;
            }
        } else if (!this.bEX.equals(com_fossil_bsy.bEX)) {
            return false;
        }
        if (this.bEY == null) {
            if (com_fossil_bsy.bEY != null) {
                return false;
            }
        } else if (!this.bEY.equals(com_fossil_bsy.bEY)) {
            return false;
        }
        if (this.bEZ == null) {
            if (com_fossil_bsy.bEZ != null) {
                return false;
            }
        } else if (!this.bEZ.equals(com_fossil_bsy.bEZ)) {
            return false;
        }
        if (this.bFa == null) {
            if (com_fossil_bsy.bFa != null) {
                return false;
            }
        } else if (!this.bFa.equals(com_fossil_bsy.bFa)) {
            return false;
        }
        if (this.bFb == null) {
            if (com_fossil_bsy.bFb != null) {
                return false;
            }
        } else if (!this.bFb.equals(com_fossil_bsy.bFb)) {
            return false;
        }
        return (this.bqp == null || this.bqp.isEmpty()) ? com_fossil_bsy.bqp == null || com_fossil_bsy.bqp.isEmpty() : this.bqp.equals(com_fossil_bsy.bqp);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.bFb == null ? 0 : this.bFb.hashCode()) + (((this.bFa == null ? 0 : this.bFa.hashCode()) + (((this.bEZ == null ? 0 : this.bEZ.hashCode()) + (((this.bEY == null ? 0 : this.bEY.hashCode()) + (((this.bEX == null ? 0 : this.bEX.hashCode()) + (((this.bEW == null ? 0 : this.bEW.hashCode()) + (((this.bxy == null ? 0 : this.bxy.hashCode()) + (((((this.bEU == null ? 0 : this.bEU.hashCode()) + (((this.bxq == null ? 0 : this.bxq.hashCode()) + (((this.bxu == null ? 0 : this.bxu.hashCode()) + (((this.bET == null ? 0 : this.bET.hashCode()) + (((this.bES == null ? 0 : this.bES.hashCode()) + (((this.bER == null ? 0 : this.bER.hashCode()) + (((this.bEQ == null ? 0 : this.bEQ.hashCode()) + (((this.bEP == null ? 0 : this.bEP.hashCode()) + (((this.bEO == null ? 0 : this.bEO.hashCode()) + (((this.bEN == null ? 0 : this.bEN.hashCode()) + (((this.bpS == null ? 0 : this.bpS.hashCode()) + (((this.bEM == null ? 0 : this.bEM.hashCode()) + (((this.bxr == null ? 0 : this.bxr.hashCode()) + (((this.bEL == null ? 0 : this.bEL.hashCode()) + (((this.bEK == null ? 0 : this.bEK.hashCode()) + (((this.bEJ == null ? 0 : this.bEJ.hashCode()) + (((this.bEI == null ? 0 : this.bEI.hashCode()) + (((this.bEH == null ? 0 : this.bEH.hashCode()) + (((this.bEG == null ? 0 : this.bEG.hashCode()) + (((this.bEF == null ? 0 : this.bEF.hashCode()) + (((this.bEE == null ? 0 : this.bEE.hashCode()) + (((this.bED == null ? 0 : this.bED.hashCode()) + (((this.bEC == null ? 0 : this.bEC.hashCode()) + (((((((this.bEz == null ? 0 : this.bEz.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + bcn.hashCode(this.bEA)) * 31) + bcn.hashCode(this.bEB)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + bcn.hashCode(this.bEV)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (!(this.bqp == null || this.bqp.isEmpty())) {
            i = this.bqp.hashCode();
        }
        return hashCode + i;
    }
}
