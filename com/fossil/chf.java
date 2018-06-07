package com.fossil;

import android.support.v8.renderscript.ScriptIntrinsicBLAS;
import com.misfit.frameworks.common.enums.Action.Selfie;
import java.io.IOException;

public interface chf {

    public static final class C2065a extends chi {
        private static volatile C2065a[] bVq;
        public String aKZ;
        public String[] bVr;
        public String bVs;
        public boolean bVt;
        public String bVu;
        public String format;

        public /* synthetic */ chi mo1701b(chg com_fossil_chg) throws IOException {
            return m6407a(com_fossil_chg);
        }

        public static C2065a[] Xz() {
            if (bVq == null) {
                synchronized (chh.bWm) {
                    if (bVq == null) {
                        bVq = new C2065a[0];
                    }
                }
            }
            return bVq;
        }

        public C2065a() {
            XA();
        }

        public C2065a XA() {
            this.aKZ = "";
            this.format = "";
            this.bVr = chk.bqJ;
            this.bVs = "";
            this.bVt = false;
            this.bVu = "";
            this.bWn = -1;
            return this;
        }

        public C2065a m6407a(chg com_fossil_chg) throws IOException {
            while (true) {
                int XF = com_fossil_chg.XF();
                switch (XF) {
                    case 0:
                        break;
                    case 10:
                        this.aKZ = com_fossil_chg.readString();
                        continue;
                    case 18:
                        this.format = com_fossil_chg.readString();
                        continue;
                    case 26:
                        int b = chk.m6421b(com_fossil_chg, 26);
                        XF = this.bVr == null ? 0 : this.bVr.length;
                        Object obj = new String[(b + XF)];
                        if (XF != 0) {
                            System.arraycopy(this.bVr, 0, obj, 0, XF);
                        }
                        while (XF < obj.length - 1) {
                            obj[XF] = com_fossil_chg.readString();
                            com_fossil_chg.XF();
                            XF++;
                        }
                        obj[XF] = com_fossil_chg.readString();
                        this.bVr = obj;
                        continue;
                    case 34:
                        this.bVs = com_fossil_chg.readString();
                        continue;
                    case 42:
                        this.bVu = com_fossil_chg.readString();
                        continue;
                    case 48:
                        this.bVt = com_fossil_chg.XI();
                        continue;
                    default:
                        if (!chk.m6420a(com_fossil_chg, XF)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }
    }

    public static final class C2066b extends chi {
        private static volatile C2066b[] bVv;
        public C2068d bVA;
        public C2068d bVB;
        public C2068d bVC;
        public C2068d bVD;
        public C2068d bVE;
        public C2068d bVF;
        public C2068d bVG;
        public C2068d bVH;
        public C2068d bVI;
        public C2068d bVJ;
        public C2068d bVK;
        public C2068d bVL;
        public int bVM;
        public String bVN;
        public String bVO;
        public String bVP;
        public String bVQ;
        public String bVR;
        public String bVS;
        public boolean bVT;
        public C2065a[] bVU;
        public C2065a[] bVV;
        public boolean bVW;
        public String bVX;
        public boolean bVY;
        public boolean bVZ;
        public C2068d bVw;
        public C2068d bVx;
        public C2068d bVy;
        public C2068d bVz;
        public String id;

        public /* synthetic */ chi mo1701b(chg com_fossil_chg) throws IOException {
            return m6410c(com_fossil_chg);
        }

        public static C2066b[] XB() {
            if (bVv == null) {
                synchronized (chh.bWm) {
                    if (bVv == null) {
                        bVv = new C2066b[0];
                    }
                }
            }
            return bVv;
        }

        public C2066b() {
            XC();
        }

        public C2066b XC() {
            this.bVw = null;
            this.bVx = null;
            this.bVy = null;
            this.bVz = null;
            this.bVA = null;
            this.bVB = null;
            this.bVC = null;
            this.bVD = null;
            this.bVE = null;
            this.bVF = null;
            this.bVG = null;
            this.bVH = null;
            this.bVI = null;
            this.bVJ = null;
            this.bVK = null;
            this.bVL = null;
            this.id = "";
            this.bVM = 0;
            this.bVN = "";
            this.bVO = "";
            this.bVP = "";
            this.bVQ = "";
            this.bVR = "";
            this.bVS = "";
            this.bVT = false;
            this.bVU = C2065a.Xz();
            this.bVV = C2065a.Xz();
            this.bVW = false;
            this.bVX = "";
            this.bVY = false;
            this.bVZ = false;
            this.bWn = -1;
            return this;
        }

        public C2066b m6410c(chg com_fossil_chg) throws IOException {
            while (true) {
                int XF = com_fossil_chg.XF();
                int b;
                Object obj;
                switch (XF) {
                    case 0:
                        break;
                    case 10:
                        if (this.bVw == null) {
                            this.bVw = new C2068d();
                        }
                        com_fossil_chg.m6416a(this.bVw);
                        continue;
                    case 18:
                        if (this.bVx == null) {
                            this.bVx = new C2068d();
                        }
                        com_fossil_chg.m6416a(this.bVx);
                        continue;
                    case 26:
                        if (this.bVy == null) {
                            this.bVy = new C2068d();
                        }
                        com_fossil_chg.m6416a(this.bVy);
                        continue;
                    case 34:
                        if (this.bVz == null) {
                            this.bVz = new C2068d();
                        }
                        com_fossil_chg.m6416a(this.bVz);
                        continue;
                    case 42:
                        if (this.bVA == null) {
                            this.bVA = new C2068d();
                        }
                        com_fossil_chg.m6416a(this.bVA);
                        continue;
                    case 50:
                        if (this.bVB == null) {
                            this.bVB = new C2068d();
                        }
                        com_fossil_chg.m6416a(this.bVB);
                        continue;
                    case 58:
                        if (this.bVC == null) {
                            this.bVC = new C2068d();
                        }
                        com_fossil_chg.m6416a(this.bVC);
                        continue;
                    case 66:
                        if (this.bVD == null) {
                            this.bVD = new C2068d();
                        }
                        com_fossil_chg.m6416a(this.bVD);
                        continue;
                    case 74:
                        this.id = com_fossil_chg.readString();
                        continue;
                    case 80:
                        this.bVM = com_fossil_chg.XH();
                        continue;
                    case 90:
                        this.bVN = com_fossil_chg.readString();
                        continue;
                    case 98:
                        this.bVP = com_fossil_chg.readString();
                        continue;
                    case 106:
                        this.bVQ = com_fossil_chg.readString();
                        continue;
                    case ScriptIntrinsicBLAS.LOWER /*122*/:
                        this.bVR = com_fossil_chg.readString();
                        continue;
                    case 130:
                        this.bVS = com_fossil_chg.readString();
                        continue;
                    case 138:
                        this.bVO = com_fossil_chg.readString();
                        continue;
                    case 144:
                        this.bVT = com_fossil_chg.XI();
                        continue;
                    case 154:
                        b = chk.m6421b(com_fossil_chg, 154);
                        if (this.bVU == null) {
                            XF = 0;
                        } else {
                            XF = this.bVU.length;
                        }
                        obj = new C2065a[(b + XF)];
                        if (XF != 0) {
                            System.arraycopy(this.bVU, 0, obj, 0, XF);
                        }
                        while (XF < obj.length - 1) {
                            obj[XF] = new C2065a();
                            com_fossil_chg.m6416a(obj[XF]);
                            com_fossil_chg.XF();
                            XF++;
                        }
                        obj[XF] = new C2065a();
                        com_fossil_chg.m6416a(obj[XF]);
                        this.bVU = obj;
                        continue;
                    case 162:
                        b = chk.m6421b(com_fossil_chg, 162);
                        if (this.bVV == null) {
                            XF = 0;
                        } else {
                            XF = this.bVV.length;
                        }
                        obj = new C2065a[(b + XF)];
                        if (XF != 0) {
                            System.arraycopy(this.bVV, 0, obj, 0, XF);
                        }
                        while (XF < obj.length - 1) {
                            obj[XF] = new C2065a();
                            com_fossil_chg.m6416a(obj[XF]);
                            com_fossil_chg.XF();
                            XF++;
                        }
                        obj[XF] = new C2065a();
                        com_fossil_chg.m6416a(obj[XF]);
                        this.bVV = obj;
                        continue;
                    case 170:
                        if (this.bVE == null) {
                            this.bVE = new C2068d();
                        }
                        com_fossil_chg.m6416a(this.bVE);
                        continue;
                    case 176:
                        this.bVW = com_fossil_chg.XI();
                        continue;
                    case 186:
                        this.bVX = com_fossil_chg.readString();
                        continue;
                    case 194:
                        if (this.bVL == null) {
                            this.bVL = new C2068d();
                        }
                        com_fossil_chg.m6416a(this.bVL);
                        continue;
                    case Selfie.TAKE_BURST /*202*/:
                        if (this.bVF == null) {
                            this.bVF = new C2068d();
                        }
                        com_fossil_chg.m6416a(this.bVF);
                        continue;
                    case 208:
                        this.bVY = com_fossil_chg.XI();
                        continue;
                    case 218:
                        if (this.bVG == null) {
                            this.bVG = new C2068d();
                        }
                        com_fossil_chg.m6416a(this.bVG);
                        continue;
                    case 226:
                        if (this.bVH == null) {
                            this.bVH = new C2068d();
                        }
                        com_fossil_chg.m6416a(this.bVH);
                        continue;
                    case 234:
                        if (this.bVI == null) {
                            this.bVI = new C2068d();
                        }
                        com_fossil_chg.m6416a(this.bVI);
                        continue;
                    case 242:
                        if (this.bVJ == null) {
                            this.bVJ = new C2068d();
                        }
                        com_fossil_chg.m6416a(this.bVJ);
                        continue;
                    case 250:
                        if (this.bVK == null) {
                            this.bVK = new C2068d();
                        }
                        com_fossil_chg.m6416a(this.bVK);
                        continue;
                    case 256:
                        this.bVZ = com_fossil_chg.XI();
                        continue;
                    default:
                        if (!chk.m6420a(com_fossil_chg, XF)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }
    }

    public static final class C2067c extends chi {
        public C2066b[] bWa;

        public /* synthetic */ chi mo1701b(chg com_fossil_chg) throws IOException {
            return m6412d(com_fossil_chg);
        }

        public C2067c() {
            XD();
        }

        public C2067c XD() {
            this.bWa = C2066b.XB();
            this.bWn = -1;
            return this;
        }

        public C2067c m6412d(chg com_fossil_chg) throws IOException {
            while (true) {
                int XF = com_fossil_chg.XF();
                switch (XF) {
                    case 0:
                        break;
                    case 10:
                        int b = chk.m6421b(com_fossil_chg, 10);
                        if (this.bWa == null) {
                            XF = 0;
                        } else {
                            XF = this.bWa.length;
                        }
                        Object obj = new C2066b[(b + XF)];
                        if (XF != 0) {
                            System.arraycopy(this.bWa, 0, obj, 0, XF);
                        }
                        while (XF < obj.length - 1) {
                            obj[XF] = new C2066b();
                            com_fossil_chg.m6416a(obj[XF]);
                            com_fossil_chg.XF();
                            XF++;
                        }
                        obj[XF] = new C2066b();
                        com_fossil_chg.m6416a(obj[XF]);
                        this.bWa = obj;
                        continue;
                    default:
                        if (!chk.m6420a(com_fossil_chg, XF)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }
    }

    public static final class C2068d extends chi {
        public String bWb;
        public String bWc;
        public String bWd;

        public /* synthetic */ chi mo1701b(chg com_fossil_chg) throws IOException {
            return m6414e(com_fossil_chg);
        }

        public C2068d() {
            XE();
        }

        public C2068d XE() {
            this.bWb = "";
            this.bWc = "";
            this.bWd = "";
            this.bWn = -1;
            return this;
        }

        public C2068d m6414e(chg com_fossil_chg) throws IOException {
            while (true) {
                int XF = com_fossil_chg.XF();
                switch (XF) {
                    case 0:
                        break;
                    case 18:
                        this.bWb = com_fossil_chg.readString();
                        continue;
                    case 26:
                        this.bWc = com_fossil_chg.readString();
                        continue;
                    case 50:
                        this.bWd = com_fossil_chg.readString();
                        continue;
                    default:
                        if (!chk.m6420a(com_fossil_chg, XF)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }
    }
}
