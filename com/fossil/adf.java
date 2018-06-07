package com.fossil;

import com.crashlytics.android.core.CodedOutputStream;
import com.fossil.adv.C1615a;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

class adf {
    private static final adu aJE = new adu("", "", 0);
    private static final C1598j[] aJF = new C1598j[0];
    private static final C1610m[] aJG = new C1610m[0];
    private static final C1605g[] aJH = new C1605g[0];
    private static final C1600b[] aJI = new C1600b[0];
    private static final C1601c[] aJJ = new C1601c[0];

    static abstract class C1598j {
        private final C1598j[] aJX;
        private final int tag;

        public C1598j(int i, C1598j... c1598jArr) {
            this.tag = i;
            if (c1598jArr == null) {
                c1598jArr = adf.aJF;
            }
            this.aJX = c1598jArr;
        }

        public int getSize() {
            int yB = yB();
            return (yB + CodedOutputStream.fe(yB)) + CodedOutputStream.fc(this.tag);
        }

        public int yB() {
            int yA = yA();
            for (C1598j size : this.aJX) {
                yA += size.getSize();
            }
            return yA;
        }

        public void mo832b(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.bn(this.tag, 2);
            codedOutputStream.fd(yB());
            mo830a(codedOutputStream);
            for (C1598j b : this.aJX) {
                b.mo832b(codedOutputStream);
            }
        }

        public int yA() {
            return 0;
        }

        public void mo830a(CodedOutputStream codedOutputStream) throws IOException {
        }
    }

    static final class C1599a extends C1598j {
        public C1599a(C1604f c1604f, C1608k c1608k) {
            super(3, c1604f, c1608k);
        }
    }

    static final class C1600b extends C1598j {
        private final long aJK;
        private final long aJL;
        private final String aJM;
        private final String uuid;

        public C1600b(adq com_fossil_adq) {
            super(4, new C1598j[0]);
            this.aJK = com_fossil_adq.aKD;
            this.aJL = com_fossil_adq.Fs;
            this.aJM = com_fossil_adq.aKE;
            this.uuid = com_fossil_adq.id;
        }

        public int yA() {
            int g = CodedOutputStream.m2634g(1, this.aJK);
            return ((g + CodedOutputStream.m2630b(3, acp.ar(this.aJM))) + CodedOutputStream.m2634g(2, this.aJL)) + CodedOutputStream.m2630b(4, acp.ar(this.uuid));
        }

        public void mo830a(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.m2647f(1, this.aJK);
            codedOutputStream.m2647f(2, this.aJL);
            codedOutputStream.m2640a(3, acp.ar(this.aJM));
            codedOutputStream.m2640a(4, acp.ar(this.uuid));
        }
    }

    static final class C1601c extends C1598j {
        private final String key;
        private final String value;

        public C1601c(adr com_fossil_adr) {
            super(2, new C1598j[0]);
            this.key = com_fossil_adr.key;
            this.value = com_fossil_adr.value;
        }

        public int yA() {
            return CodedOutputStream.m2630b(2, acp.ar(this.value == null ? "" : this.value)) + CodedOutputStream.m2630b(1, acp.ar(this.key));
        }

        public void mo830a(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.m2640a(1, acp.ar(this.key));
            codedOutputStream.m2640a(2, acp.ar(this.value == null ? "" : this.value));
        }
    }

    static final class C1602d extends C1598j {
        private final float aJN;
        private final int aJO;
        private final boolean aJP;
        private final long aJQ;
        private final long aJR;
        private final int orientation;

        public C1602d(float f, int i, boolean z, int i2, long j, long j2) {
            super(5, new C1598j[0]);
            this.aJN = f;
            this.aJO = i;
            this.aJP = z;
            this.orientation = i2;
            this.aJQ = j;
            this.aJR = j2;
        }

        public int yA() {
            return (((((0 + CodedOutputStream.m2633f(1, this.aJN)) + CodedOutputStream.bm(2, this.aJO)) + CodedOutputStream.m2635p(3, this.aJP)) + CodedOutputStream.bk(4, this.orientation)) + CodedOutputStream.m2634g(5, this.aJQ)) + CodedOutputStream.m2634g(6, this.aJR);
        }

        public void mo830a(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.m2646e(1, this.aJN);
            codedOutputStream.bj(2, this.aJO);
            codedOutputStream.m2649o(3, this.aJP);
            codedOutputStream.bh(4, this.orientation);
            codedOutputStream.m2647f(5, this.aJQ);
            codedOutputStream.m2647f(6, this.aJR);
        }
    }

    static final class C1603e extends C1598j {
        private final String aJS;
        private final long time;

        public C1603e(long j, String str, C1598j... c1598jArr) {
            super(10, c1598jArr);
            this.time = j;
            this.aJS = str;
        }

        public int yA() {
            return CodedOutputStream.m2634g(1, this.time) + CodedOutputStream.m2630b(2, acp.ar(this.aJS));
        }

        public void mo830a(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.m2647f(1, this.time);
            codedOutputStream.m2640a(2, acp.ar(this.aJS));
        }
    }

    static final class C1604f extends C1598j {
        public C1604f(C1609l c1609l, C1608k c1608k, C1608k c1608k2) {
            super(1, c1608k, c1609l, c1608k2);
        }
    }

    static final class C1605g extends C1598j {
        private final long Fr;
        private final long aJT;
        private final String aJU;
        private final String aJV;
        private final int importance;

        public C1605g(C1615a c1615a) {
            super(3, new C1598j[0]);
            this.aJT = c1615a.aJT;
            this.aJU = c1615a.aJU;
            this.aJV = c1615a.aJV;
            this.Fr = c1615a.Fr;
            this.importance = c1615a.importance;
        }

        public int yA() {
            return (((CodedOutputStream.m2634g(1, this.aJT) + CodedOutputStream.m2630b(2, acp.ar(this.aJU))) + CodedOutputStream.m2630b(3, acp.ar(this.aJV))) + CodedOutputStream.m2634g(4, this.Fr)) + CodedOutputStream.bk(5, this.importance);
        }

        public void mo830a(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.m2647f(1, this.aJT);
            codedOutputStream.m2640a(2, acp.ar(this.aJU));
            codedOutputStream.m2640a(3, acp.ar(this.aJV));
            codedOutputStream.m2647f(4, this.Fr);
            codedOutputStream.bh(5, this.importance);
        }
    }

    static final class C1606h extends C1598j {
        acp aJW;

        public C1606h(acp com_fossil_acp) {
            super(6, new C1598j[0]);
            this.aJW = com_fossil_acp;
        }

        public int yA() {
            return CodedOutputStream.m2630b(1, this.aJW);
        }

        public void mo830a(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.m2640a(1, this.aJW);
        }
    }

    static final class C1607i extends C1598j {
        public C1607i() {
            super(0, new C1598j[0]);
        }

        public void mo832b(CodedOutputStream codedOutputStream) throws IOException {
        }
    }

    static final class C1608k extends C1598j {
        private final C1598j[] aJY;

        public C1608k(C1598j... c1598jArr) {
            super(0, new C1598j[0]);
            this.aJY = c1598jArr;
        }

        public void mo832b(CodedOutputStream codedOutputStream) throws IOException {
            for (C1598j b : this.aJY) {
                b.mo832b(codedOutputStream);
            }
        }

        public int getSize() {
            int i = 0;
            C1598j[] c1598jArr = this.aJY;
            int i2 = 0;
            while (i < c1598jArr.length) {
                i2 += c1598jArr[i].getSize();
                i++;
            }
            return i2;
        }
    }

    static final class C1609l extends C1598j {
        private final String aJZ;
        private final String aKa;
        private final long aKb;

        public C1609l(adu com_fossil_adu) {
            super(3, new C1598j[0]);
            this.aJZ = com_fossil_adu.name;
            this.aKa = com_fossil_adu.code;
            this.aKb = com_fossil_adu.aKQ;
        }

        public int yA() {
            return (CodedOutputStream.m2630b(1, acp.ar(this.aJZ)) + CodedOutputStream.m2630b(2, acp.ar(this.aKa))) + CodedOutputStream.m2634g(3, this.aKb);
        }

        public void mo830a(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.m2640a(1, acp.ar(this.aJZ));
            codedOutputStream.m2640a(2, acp.ar(this.aKa));
            codedOutputStream.m2647f(3, this.aKb);
        }
    }

    static final class C1610m extends C1598j {
        private final int importance;
        private final String name;

        public C1610m(adv com_fossil_adv, C1608k c1608k) {
            super(1, c1608k);
            this.name = com_fossil_adv.name;
            this.importance = com_fossil_adv.importance;
        }

        public int yA() {
            return (hasName() ? CodedOutputStream.m2630b(1, acp.ar(this.name)) : 0) + CodedOutputStream.bk(2, this.importance);
        }

        public void mo830a(CodedOutputStream codedOutputStream) throws IOException {
            if (hasName()) {
                codedOutputStream.m2640a(1, acp.ar(this.name));
            }
            codedOutputStream.bh(2, this.importance);
        }

        private boolean hasName() {
            return this.name != null && this.name.length() > 0;
        }
    }

    private static C1603e m3048a(adt com_fossil_adt, add com_fossil_add, Map<String, String> map) throws IOException {
        C1599a c1599a = new C1599a(new C1604f(new C1609l(com_fossil_adt.aKL != null ? com_fossil_adt.aKL : aJE), m3052a(com_fossil_adt.aKM), m3049a(com_fossil_adt.aKN)), m3050a(m3054a(com_fossil_adt.aKO, map)));
        C1602d a = m3047a(com_fossil_adt.aKP);
        acp yv = com_fossil_add.yv();
        if (yv == null) {
            emm.aEU().mo2950d("Fabric", "No log data to include with this event.");
        }
        com_fossil_add.yw();
        C1606h c1606h = yv != null ? new C1606h(yv) : new C1607i();
        return new C1603e(com_fossil_adt.timestamp, "ndk-crash", c1599a, a, c1606h);
    }

    private static adr[] m3054a(adr[] com_fossil_adrArr, Map<String, String> map) {
        int i;
        Map treeMap = new TreeMap(map);
        if (com_fossil_adrArr != null) {
            for (adr com_fossil_adr : com_fossil_adrArr) {
                treeMap.put(com_fossil_adr.key, com_fossil_adr.value);
            }
        }
        Entry[] entryArr = (Entry[]) treeMap.entrySet().toArray(new Entry[treeMap.size()]);
        adr[] com_fossil_adrArr2 = new adr[entryArr.length];
        for (i = 0; i < com_fossil_adrArr2.length; i++) {
            com_fossil_adrArr2[i] = new adr((String) entryArr[i].getKey(), (String) entryArr[i].getValue());
        }
        return com_fossil_adrArr2;
    }

    private static C1602d m3047a(ads com_fossil_ads) {
        return new C1602d(((float) com_fossil_ads.aKJ) / 100.0f, com_fossil_ads.aJO, com_fossil_ads.aKK, com_fossil_ads.orientation, com_fossil_ads.aKF - com_fossil_ads.aKH, com_fossil_ads.aKG - com_fossil_ads.aKI);
    }

    private static C1608k m3052a(adv[] com_fossil_advArr) {
        C1598j[] c1598jArr = com_fossil_advArr != null ? new C1610m[com_fossil_advArr.length] : aJG;
        for (int i = 0; i < c1598jArr.length; i++) {
            adv com_fossil_adv = com_fossil_advArr[i];
            c1598jArr[i] = new C1610m(com_fossil_adv, m3051a(com_fossil_adv.aKR));
        }
        return new C1608k(c1598jArr);
    }

    private static C1608k m3051a(C1615a[] c1615aArr) {
        C1598j[] c1598jArr = c1615aArr != null ? new C1605g[c1615aArr.length] : aJH;
        for (int i = 0; i < c1598jArr.length; i++) {
            c1598jArr[i] = new C1605g(c1615aArr[i]);
        }
        return new C1608k(c1598jArr);
    }

    private static C1608k m3049a(adq[] com_fossil_adqArr) {
        C1598j[] c1598jArr = com_fossil_adqArr != null ? new C1600b[com_fossil_adqArr.length] : aJI;
        for (int i = 0; i < c1598jArr.length; i++) {
            c1598jArr[i] = new C1600b(com_fossil_adqArr[i]);
        }
        return new C1608k(c1598jArr);
    }

    private static C1608k m3050a(adr[] com_fossil_adrArr) {
        C1598j[] c1598jArr = com_fossil_adrArr != null ? new C1601c[com_fossil_adrArr.length] : aJJ;
        for (int i = 0; i < c1598jArr.length; i++) {
            c1598jArr[i] = new C1601c(com_fossil_adrArr[i]);
        }
        return new C1608k(c1598jArr);
    }

    public static void m3053a(adt com_fossil_adt, add com_fossil_add, Map<String, String> map, CodedOutputStream codedOutputStream) throws IOException {
        m3048a(com_fossil_adt, com_fossil_add, map).mo832b(codedOutputStream);
    }
}
