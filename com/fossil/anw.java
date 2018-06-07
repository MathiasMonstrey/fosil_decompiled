package com.fossil;

import com.flurry.sdk.is;
import com.fossil.anx.C1741a;
import com.misfit.ble.shine.ShineProfile;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class anw extends apy {
    private static final String aYl = anw.class.getName();
    String aWJ;
    final Map<String, String> aWU;
    final long aXm;
    final is aXo;
    public ArrayList<anx> aYm = new ArrayList();
    public anz aYn;
    long aYo = ShineProfile.LOG_UPLOADING_DELAY;
    String aYp;
    boolean aYq;
    final int f1394b;
    final int f1395c;
    int f1396i;
    int f1397j;

    public static class C1738a implements aqi<anw> {
        aqh<anx> aYr = new aqh(new C1741a());

        public final /* synthetic */ void mo1105a(OutputStream outputStream, Object obj) throws IOException {
            anw com_fossil_anw = (anw) obj;
            if (outputStream != null && com_fossil_anw != null) {
                DataOutputStream c17361 = new DataOutputStream(this, outputStream) {
                    final /* synthetic */ C1738a aYs;

                    public final void close() {
                    }
                };
                if (com_fossil_anw.aYp != null) {
                    c17361.writeUTF(com_fossil_anw.aYp);
                } else {
                    c17361.writeUTF("");
                }
                if (com_fossil_anw.bbL != null) {
                    c17361.writeUTF(com_fossil_anw.bbL);
                } else {
                    c17361.writeUTF("");
                }
                c17361.writeLong(com_fossil_anw.aXW);
                c17361.writeInt(com_fossil_anw.bbJ);
                c17361.writeLong(com_fossil_anw.aXm);
                c17361.writeInt(com_fossil_anw.f1394b);
                c17361.writeInt(com_fossil_anw.f1395c);
                c17361.writeInt(com_fossil_anw.aXo.f1300e);
                Map f = com_fossil_anw.aWU;
                if (f != null) {
                    c17361.writeInt(com_fossil_anw.aWU.size());
                    for (String str : com_fossil_anw.aWU.keySet()) {
                        c17361.writeUTF(str);
                        c17361.writeUTF((String) f.get(str));
                    }
                } else {
                    c17361.writeInt(0);
                }
                c17361.writeLong(com_fossil_anw.aYo);
                c17361.writeInt(com_fossil_anw.f1396i);
                c17361.writeInt(com_fossil_anw.f1397j);
                if (com_fossil_anw.aWJ != null) {
                    c17361.writeUTF(com_fossil_anw.aWJ);
                } else {
                    c17361.writeUTF("");
                }
                c17361.writeBoolean(com_fossil_anw.aYq);
                c17361.flush();
                this.aYr.m4219a(outputStream, com_fossil_anw.aYm);
            }
        }

        public final /* synthetic */ Object mo1106j(InputStream inputStream) throws IOException {
            if (inputStream == null) {
                return null;
            }
            DataInputStream c17372 = new DataInputStream(this, inputStream) {
                final /* synthetic */ C1738a aYs;

                public final void close() {
                }
            };
            String readUTF = c17372.readUTF();
            if (readUTF.equals("")) {
                readUTF = null;
            }
            String readUTF2 = c17372.readUTF();
            long readLong = c17372.readLong();
            int readInt = c17372.readInt();
            long readLong2 = c17372.readLong();
            int readInt2 = c17372.readInt();
            int readInt3 = c17372.readInt();
            is a = is.m2768a(c17372.readInt());
            Map map = null;
            int readInt4 = c17372.readInt();
            if (readInt4 != 0) {
                map = new HashMap();
                for (int i = 0; i < readInt4; i++) {
                    map.put(c17372.readUTF(), c17372.readUTF());
                }
            }
            long readLong3 = c17372.readLong();
            readInt4 = c17372.readInt();
            int readInt5 = c17372.readInt();
            String readUTF3 = c17372.readUTF();
            if (readUTF3.equals("")) {
                readUTF3 = null;
            }
            boolean readBoolean = c17372.readBoolean();
            anw com_fossil_anw = new anw(readUTF, readLong2, readUTF2, readLong, readInt2, readInt3, a, map, readInt4, readInt5, readUTF3);
            com_fossil_anw.aYo = readLong3;
            com_fossil_anw.aYq = readBoolean;
            com_fossil_anw.bbJ = readInt;
            com_fossil_anw.aYm = (ArrayList) this.aYr.m4221l(inputStream);
            com_fossil_anw.m4033d();
            return com_fossil_anw;
        }
    }

    public anw(String str, long j, String str2, long j2, int i, int i2, is isVar, Map<String, String> map, int i3, int i4, String str3) {
        cg(str2);
        this.aXW = j2;
        HV();
        this.aYp = str;
        this.aXm = j;
        this.bbE = i;
        this.f1394b = i;
        this.f1395c = i2;
        this.aXo = isVar;
        this.aWU = map;
        this.f1396i = i3;
        this.f1397j = i4;
        this.aWJ = str3;
    }

    public final void HV() {
        super.HV();
        if (this.bbJ != 1) {
            this.aYo *= 3;
        }
    }

    public final synchronized void HH() {
        this.aYn.HH();
    }

    public final void m4033d() {
        Iterator it = this.aYm.iterator();
        while (it.hasNext()) {
            ((anx) it.next()).aYz = this;
        }
    }
}
