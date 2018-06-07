package com.fossil;

import com.flurry.sdk.it;
import com.fossil.anw.C1738a;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

public final class anz {
    private static final String aXl = aoa.class.getName();
    private boolean aWH;
    Map<Long, anw> aWU;
    public long aXm;
    private AtomicInteger aYL;
    private long aYo;
    it f1402b;
    int f1403c;
    public String f1404d;
    private long f1405g = System.currentTimeMillis();
    private int f1406j;

    public static class C1751a implements aqi<anz> {
        aqh<anw> aYr = new aqh(new C1738a());

        public final /* synthetic */ void mo1105a(OutputStream outputStream, Object obj) throws IOException {
            anz com_fossil_anz = (anz) obj;
            if (outputStream != null && com_fossil_anz != null) {
                DataOutputStream c17491 = new DataOutputStream(this, outputStream) {
                    final /* synthetic */ C1751a aYM;

                    public final void close() {
                    }
                };
                c17491.writeLong(com_fossil_anz.aXm);
                c17491.writeLong(com_fossil_anz.f1405g);
                c17491.writeLong(com_fossil_anz.aYo);
                c17491.writeInt(com_fossil_anz.f1402b.f1305e);
                c17491.writeBoolean(com_fossil_anz.aWH);
                c17491.writeInt(com_fossil_anz.f1403c);
                if (com_fossil_anz.f1404d != null) {
                    c17491.writeUTF(com_fossil_anz.f1404d);
                } else {
                    c17491.writeUTF("");
                }
                c17491.writeInt(com_fossil_anz.f1406j);
                c17491.writeInt(com_fossil_anz.aYL.intValue());
                c17491.flush();
                this.aYr.m4219a(outputStream, com_fossil_anz.Id());
            }
        }

        public final /* synthetic */ Object mo1106j(InputStream inputStream) throws IOException {
            if (inputStream == null) {
                return null;
            }
            DataInputStream c17502 = new DataInputStream(this, inputStream) {
                final /* synthetic */ C1751a aYM;

                public final void close() {
                }
            };
            long readLong = c17502.readLong();
            long readLong2 = c17502.readLong();
            long readLong3 = c17502.readLong();
            it a = it.m2769a(c17502.readInt());
            boolean readBoolean = c17502.readBoolean();
            int readInt = c17502.readInt();
            String readUTF = c17502.readUTF();
            int readInt2 = c17502.readInt();
            int readInt3 = c17502.readInt();
            anz com_fossil_anz = new anz(readUTF, readBoolean, readLong, readLong3, a, null);
            com_fossil_anz.f1405g = readLong2;
            com_fossil_anz.f1403c = readInt;
            com_fossil_anz.f1406j = readInt2;
            com_fossil_anz.aYL = new AtomicInteger(readInt3);
            List<anw> l = this.aYr.m4221l(inputStream);
            if (l != null) {
                com_fossil_anz.aWU = new HashMap();
                for (anw com_fossil_anw : l) {
                    com_fossil_anw.aYn = com_fossil_anz;
                    com_fossil_anz.aWU.put(Long.valueOf(com_fossil_anw.aXm), com_fossil_anw);
                }
            }
            return com_fossil_anz;
        }
    }

    public anz(String str, boolean z, long j, long j2, it itVar, Map<Long, anw> map) {
        this.f1404d = str;
        this.aWH = z;
        this.aXm = j;
        this.aYo = j2;
        this.f1402b = itVar;
        this.aWU = map;
        if (map != null) {
            for (Long l : map.keySet()) {
                ((anw) map.get(l)).aYn = this;
            }
            this.f1406j = map.size();
        } else {
            this.f1406j = 0;
        }
        this.aYL = new AtomicInteger(0);
    }

    public final List<anw> Id() {
        if (this.aWU != null) {
            return new ArrayList(this.aWU.values());
        }
        return Collections.emptyList();
    }

    public final synchronized boolean Ie() {
        return this.aYL.intValue() >= this.f1406j;
    }

    public final synchronized void HH() {
        this.aYL.incrementAndGet();
    }

    public final byte[] If() throws IOException {
        Closeable dataOutputStream;
        Throwable e;
        Closeable closeable = null;
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeShort(this.f1402b.f1305e);
                dataOutputStream.writeLong(this.aXm);
                dataOutputStream.writeLong(this.aYo);
                dataOutputStream.writeBoolean(this.aWH);
                if (this.aWH) {
                    dataOutputStream.writeShort(this.f1403c);
                    dataOutputStream.writeUTF(this.f1404d);
                }
                dataOutputStream.writeShort(this.aWU.size());
                if (this.aWU != null) {
                    for (Entry entry : this.aWU.entrySet()) {
                        anw com_fossil_anw = (anw) entry.getValue();
                        dataOutputStream.writeLong(((Long) entry.getKey()).longValue());
                        dataOutputStream.writeUTF(com_fossil_anw.bbL);
                        dataOutputStream.writeShort(com_fossil_anw.aYm.size());
                        Iterator it = com_fossil_anw.aYm.iterator();
                        while (it.hasNext()) {
                            anx com_fossil_anx = (anx) it.next();
                            dataOutputStream.writeShort(com_fossil_anx.f1398a);
                            dataOutputStream.writeLong(com_fossil_anx.aXv);
                            dataOutputStream.writeLong(com_fossil_anx.aXw);
                            dataOutputStream.writeBoolean(com_fossil_anx.aWE);
                            dataOutputStream.writeShort(com_fossil_anx.f1399e);
                            dataOutputStream.writeShort(com_fossil_anx.aYu.f1295e);
                            if ((com_fossil_anx.f1399e < MFNetworkReturnCode.RESPONSE_OK || com_fossil_anx.f1399e >= MFNetworkReturnCode.BAD_REQUEST) && com_fossil_anx.aYv != null) {
                                byte[] bytes = com_fossil_anx.aYv.getBytes();
                                dataOutputStream.writeShort(bytes.length);
                                dataOutputStream.write(bytes);
                            }
                            dataOutputStream.writeShort(com_fossil_anx.aXp);
                            dataOutputStream.writeInt((int) com_fossil_anx.aYy);
                        }
                    }
                }
                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                aqv.m4252a(dataOutputStream);
                return toByteArray;
            } catch (IOException e2) {
                e = e2;
                closeable = dataOutputStream;
                try {
                    app.m4174b(6, aXl, "Error when generating report", e);
                    throw e;
                } catch (Throwable th) {
                    e = th;
                    dataOutputStream = closeable;
                    aqv.m4252a(dataOutputStream);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                aqv.m4252a(dataOutputStream);
                throw e;
            }
        } catch (IOException e3) {
            e = e3;
            app.m4174b(6, aXl, "Error when generating report", e);
            throw e;
        } catch (Throwable th3) {
            e = th3;
            dataOutputStream = null;
            aqv.m4252a(dataOutputStream);
            throw e;
        }
    }
}
