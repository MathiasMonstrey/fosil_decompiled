package com.fossil;

import com.fossil.efg.C3368a;
import java.io.IOException;

public class efm extends cfw<C3368a> {
    public /* synthetic */ Object mo1657b(cgv com_fossil_cgv) throws IOException {
        return m10607K(com_fossil_cgv);
    }

    public void m10608a(cgw com_fossil_cgw, C3368a c3368a) throws IOException {
        if (c3368a != null) {
            com_fossil_cgw.Xc();
            m10606a(com_fossil_cgw, "steps", c3368a.dFK, c3368a.dFL);
            m10605a(com_fossil_cgw, "distance", c3368a.dFM, c3368a.dFN);
            m10605a(com_fossil_cgw, "calories", c3368a.dFO, c3368a.dFP);
            com_fossil_cgw.Xd();
            return;
        }
        com_fossil_cgw.Xe();
    }

    private void m10606a(cgw com_fossil_cgw, String str, long[] jArr, int[] iArr) throws IOException {
        if (jArr != null) {
            com_fossil_cgw.fu(str);
            com_fossil_cgw.Xc();
            com_fossil_cgw.fu("values");
            com_fossil_cgw.Xa();
            int length = jArr.length;
            for (int i = 0; i < length; i++) {
                com_fossil_cgw.Xa();
                com_fossil_cgw.ax(jArr[i]);
                com_fossil_cgw.ax((long) iArr[i]);
                com_fossil_cgw.Xb();
            }
            com_fossil_cgw.Xb();
            com_fossil_cgw.Xd();
        }
    }

    private void m10605a(cgw com_fossil_cgw, String str, long[] jArr, double[] dArr) throws IOException {
        if (jArr != null) {
            com_fossil_cgw.fu(str);
            com_fossil_cgw.Xc();
            com_fossil_cgw.fu("values");
            com_fossil_cgw.Xa();
            int length = jArr.length;
            for (int i = 0; i < length; i++) {
                com_fossil_cgw.Xa();
                com_fossil_cgw.ax(jArr[i]);
                com_fossil_cgw.mo1697h(dArr[i]);
                com_fossil_cgw.Xb();
            }
            com_fossil_cgw.Xb();
            com_fossil_cgw.Xd();
        }
    }

    public C3368a m10607K(cgv com_fossil_cgv) throws IOException {
        elu com_fossil_elu = null;
        C3368a c3368a = new C3368a();
        com_fossil_cgv.beginObject();
        elv com_fossil_elv = null;
        elw com_fossil_elw = null;
        while (com_fossil_cgv.hasNext()) {
            String nextName = com_fossil_cgv.nextName();
            if ("steps".equals(nextName)) {
                if (com_fossil_elw == null) {
                    com_fossil_elw = new elw();
                } else {
                    com_fossil_elw.clear();
                }
                if (com_fossil_elv == null) {
                    com_fossil_elv = new elv();
                } else {
                    com_fossil_elv.clear();
                }
                m10604a(com_fossil_cgv, com_fossil_elw, com_fossil_elv);
                c3368a.dFK = com_fossil_elw.toArray();
                c3368a.dFL = com_fossil_elv.toArray();
            } else if ("distance".equals(nextName)) {
                if (com_fossil_elw == null) {
                    com_fossil_elw = new elw();
                } else {
                    com_fossil_elw.clear();
                }
                if (com_fossil_elu == null) {
                    com_fossil_elu = new elu();
                } else {
                    com_fossil_elu.clear();
                }
                m10603a(com_fossil_cgv, com_fossil_elw, com_fossil_elu);
                c3368a.dFM = com_fossil_elw.toArray();
                c3368a.dFN = com_fossil_elu.toArray();
            } else if ("calories".equals(nextName)) {
                if (com_fossil_elw == null) {
                    com_fossil_elw = new elw();
                } else {
                    com_fossil_elw.clear();
                }
                if (com_fossil_elu == null) {
                    com_fossil_elu = new elu();
                } else {
                    com_fossil_elu.clear();
                }
                m10603a(com_fossil_cgv, com_fossil_elw, com_fossil_elu);
                c3368a.dFO = com_fossil_elw.toArray();
                c3368a.dFP = com_fossil_elu.toArray();
            } else {
                com_fossil_cgv.skipValue();
            }
        }
        com_fossil_cgv.endObject();
        return c3368a;
    }

    private void m10604a(cgv com_fossil_cgv, elw com_fossil_elw, elv com_fossil_elv) throws IOException {
        com_fossil_cgv.beginObject();
        while (com_fossil_cgv.hasNext()) {
            if ("values".equals(com_fossil_cgv.nextName())) {
                com_fossil_cgv.beginArray();
                while (com_fossil_cgv.hasNext()) {
                    com_fossil_cgv.beginArray();
                    long nextLong = com_fossil_cgv.nextLong();
                    int nextInt = com_fossil_cgv.nextInt();
                    com_fossil_elw.add(nextLong);
                    com_fossil_elv.oV(nextInt);
                    com_fossil_cgv.endArray();
                }
                com_fossil_cgv.endArray();
            } else {
                com_fossil_cgv.skipValue();
            }
        }
        com_fossil_cgv.endObject();
    }

    private void m10603a(cgv com_fossil_cgv, elw com_fossil_elw, elu com_fossil_elu) throws IOException {
        com_fossil_cgv.beginObject();
        while (com_fossil_cgv.hasNext()) {
            if ("values".equals(com_fossil_cgv.nextName())) {
                com_fossil_cgv.beginArray();
                while (com_fossil_cgv.hasNext()) {
                    com_fossil_cgv.beginArray();
                    long nextLong = com_fossil_cgv.nextLong();
                    double nextDouble = com_fossil_cgv.nextDouble();
                    com_fossil_elw.add(nextLong);
                    com_fossil_elu.add(nextDouble);
                    com_fossil_cgv.endArray();
                }
                com_fossil_cgv.endArray();
            } else {
                com_fossil_cgv.skipValue();
            }
        }
        com_fossil_cgv.endObject();
    }
}
