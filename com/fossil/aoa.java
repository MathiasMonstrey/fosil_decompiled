package com.fossil;

import android.os.Build;
import android.os.Build.VERSION;
import com.flurry.sdk.ij;
import com.flurry.sdk.ji;
import com.flurry.sdk.jo;
import com.flurry.sdk.jq;
import com.flurry.sdk.kw.C1540a;
import com.fossil.aob.C1757a;
import com.fossil.apv.C1725a;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.zip.CRC32;

public class aoa {
    public static final String aWB = aoa.class.getName();
    private static aoa aYN = null;
    private boolean aWO;
    public String aWR;
    private api<List<aob>> aYO;
    private List<aob> aYP;

    class C17531 implements aqk<List<aob>> {
        final /* synthetic */ aoa aYQ;

        C17531(aoa com_fossil_aoa) {
            this.aYQ = com_fossil_aoa;
        }

        public final aqi<List<aob>> hi(int i) {
            return new aqh(new C1757a());
        }
    }

    class C17542 implements C1725a<byte[], Void> {
        final /* synthetic */ aoa aYQ;

        C17542(aoa com_fossil_aoa) {
            this.aYQ = com_fossil_aoa;
        }

        public final /* synthetic */ void mo1108a(apv com_fossil_apv, Object obj) {
            int i = com_fossil_apv.bbD;
            if (i <= 0) {
                app.m4178e(aoa.aWB, "Server Error: " + i);
            } else if (i < MFNetworkReturnCode.RESPONSE_OK || i >= 300) {
                app.m4180g(3, aoa.aWB, "Pulse logging report sent unsuccessfully, HTTP response:" + i);
            } else {
                app.m4180g(3, aoa.aWB, "Pulse logging report sent successfully HTTP response:" + i);
                this.aYQ.aYP.clear();
                this.aYQ.aYO.bJ(this.aYQ.aYP);
            }
        }
    }

    private aoa() {
    }

    public static synchronized aoa Ig() {
        aoa com_fossil_aoa;
        synchronized (aoa.class) {
            if (aYN == null) {
                aoa com_fossil_aoa2 = new aoa();
                aYN = com_fossil_aoa2;
                com_fossil_aoa2.aYO = new api(apc.IO().baD.getFileStreamPath(".yflurrypulselogging." + Long.toString(aqv.cC(apc.IO().f1440d), 16)), ".yflurrypulselogging.", 1, new C17531(com_fossil_aoa2));
                com_fossil_aoa2.aWO = ((Boolean) aqp.Jf().cw("UseHttps")).booleanValue();
                app.m4180g(4, aWB, "initSettings, UseHttps = " + com_fossil_aoa2.aWO);
                com_fossil_aoa2.aYP = (List) com_fossil_aoa2.aYO.IV();
                if (com_fossil_aoa2.aYP == null) {
                    com_fossil_aoa2.aYP = new ArrayList();
                }
            }
            com_fossil_aoa = aYN;
        }
        return com_fossil_aoa;
    }

    public final synchronized void m4069a(anz com_fossil_anz) {
        try {
            this.aYP.add(new aob(com_fossil_anz.If()));
            app.m4180g(4, aWB, "Saving persistent Pulse logging data.");
            this.aYO.bJ(this.aYP);
        } catch (IOException e) {
            app.m4180g(6, aWB, "Error when generating pulse log report in addReport part");
        }
    }

    public final synchronized void HO() {
        try {
            m4066X(If());
        } catch (IOException e) {
            app.m4180g(6, aWB, "Report not send due to exception in generate data");
        }
    }

    private synchronized void m4066X(byte[] bArr) {
        if (jo.ID().aXI) {
            if (bArr != null) {
                if (bArr.length != 0) {
                    String str;
                    if (this.aWR != null) {
                        str = this.aWR;
                    } else {
                        str = "https://data.flurry.com/pcr.do";
                    }
                    app.m4180g(4, aWB, "PulseLoggingManager: start upload data " + Arrays.toString(bArr) + " to " + str);
                    aqy com_fossil_apv = new apv();
                    com_fossil_apv.aYv = str;
                    com_fossil_apv.bcN = 100000;
                    com_fossil_apv.bbx = C1540a.kPost;
                    com_fossil_apv.aXT = true;
                    com_fossil_apv.m2786w("Content-Type", "application/octet-stream");
                    com_fossil_apv.baS = new aqe();
                    com_fossil_apv.bbo = bArr;
                    com_fossil_apv.bbn = new C17542(this);
                    apa.IK().m4151b(this, com_fossil_apv);
                }
            }
            app.m4180g(3, aWB, "No report need be sent");
        } else {
            app.m4180g(5, aWB, "Reports were not sent! No Internet connection!");
        }
    }

    private byte[] If() throws IOException {
        Closeable dataOutputStream;
        Throwable e;
        Closeable closeable = null;
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                byte[] toByteArray;
                if (this.aYP == null || this.aYP.isEmpty()) {
                    toByteArray = byteArrayOutputStream.toByteArray();
                    aqv.m4252a(dataOutputStream);
                } else {
                    dataOutputStream.writeShort(1);
                    dataOutputStream.writeShort(1);
                    dataOutputStream.writeLong(System.currentTimeMillis());
                    dataOutputStream.writeUTF(apc.IO().f1440d);
                    dataOutputStream.writeUTF(aov.IF().Iw());
                    dataOutputStream.writeShort(apd.Iz());
                    dataOutputStream.writeShort(3);
                    aov.IF();
                    dataOutputStream.writeUTF(aov.Ih());
                    dataOutputStream.writeBoolean(ji.Iu().m2776c());
                    List<anj> arrayList = new ArrayList();
                    for (Entry entry : Collections.unmodifiableMap(ji.Iu().aZV).entrySet()) {
                        anj com_fossil_anj = new anj();
                        com_fossil_anj.f1388a = ((jq) entry.getKey()).f1321d;
                        if (((jq) entry.getKey()).f1322e) {
                            com_fossil_anj.aWR = new String((byte[]) entry.getValue());
                        } else {
                            com_fossil_anj.aWR = aqv.ab((byte[]) entry.getValue());
                        }
                        arrayList.add(com_fossil_anj);
                    }
                    dataOutputStream.writeShort(arrayList.size());
                    for (anj com_fossil_anj2 : arrayList) {
                        dataOutputStream.writeShort(com_fossil_anj2.f1388a);
                        toByteArray = com_fossil_anj2.aWR.getBytes();
                        dataOutputStream.writeShort(toByteArray.length);
                        dataOutputStream.write(toByteArray);
                    }
                    dataOutputStream.writeShort(6);
                    dataOutputStream.writeShort(ij.f1285b - 1);
                    dataOutputStream.writeUTF(Build.MODEL);
                    dataOutputStream.writeShort(ij.f1286c - 1);
                    dataOutputStream.writeUTF(Build.BOARD);
                    dataOutputStream.writeShort(ij.f1287d - 1);
                    dataOutputStream.writeUTF(Build.ID);
                    dataOutputStream.writeShort(ij.f1288e - 1);
                    dataOutputStream.writeUTF(Build.DEVICE);
                    dataOutputStream.writeShort(ij.f1289f - 1);
                    dataOutputStream.writeUTF(Build.PRODUCT);
                    dataOutputStream.writeShort(ij.f1290g - 1);
                    dataOutputStream.writeUTF(VERSION.RELEASE);
                    dataOutputStream.writeShort(this.aYP.size());
                    for (aob com_fossil_aob : this.aYP) {
                        dataOutputStream.write(com_fossil_aob.aYe);
                    }
                    toByteArray = byteArrayOutputStream.toByteArray();
                    CRC32 crc32 = new CRC32();
                    crc32.update(toByteArray);
                    dataOutputStream.writeInt((int) crc32.getValue());
                    toByteArray = byteArrayOutputStream.toByteArray();
                    aqv.m4252a(dataOutputStream);
                }
                return toByteArray;
            } catch (IOException e2) {
                e = e2;
                closeable = dataOutputStream;
            } catch (Throwable th) {
                e = th;
            }
        } catch (IOException e3) {
            e = e3;
            try {
                app.m4174b(6, aWB, "Error when generating report", e);
                throw e;
            } catch (Throwable th2) {
                e = th2;
                dataOutputStream = closeable;
                aqv.m4252a(dataOutputStream);
                throw e;
            }
        } catch (Throwable th3) {
            e = th3;
            dataOutputStream = null;
            aqv.m4252a(dataOutputStream);
            throw e;
        }
    }
}
