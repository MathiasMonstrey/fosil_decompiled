package com.fossil;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class aog {
    public String aWB;
    public boolean aWM;
    private final Map<String, String> aWU = new HashMap();
    public boolean aXI;
    public long aYX;
    private int f1410f;
    private long f1411g;

    public aog(int i, String str, Map<String, String> map, long j, boolean z) {
        this.f1410f = i;
        this.aWB = str;
        if (map != null) {
            this.aWU.putAll(map);
        }
        this.f1411g = j;
        this.aXI = z;
        this.aWM = !this.aXI;
    }

    public final void m4080a(long j) {
        this.aWM = true;
        this.aYX = j - this.f1411g;
        app.m4180g(3, "FlurryAgent", "Ended event '" + this.aWB + "' (" + this.f1411g + ") after " + this.aYX + "ms");
    }

    public final synchronized void m4081o(Map<String, String> map) {
        if (map != null) {
            this.aWU.putAll(map);
        }
    }

    public final synchronized Map<String, String> HG() {
        return new HashMap(this.aWU);
    }

    public final synchronized void m4082p(Map<String, String> map) {
        this.aWU.clear();
        if (map != null) {
            this.aWU.putAll(map);
        }
    }

    public final synchronized byte[] Ij() {
        byte[] toByteArray;
        Closeable closeable;
        Throwable th;
        Closeable dataOutputStream;
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeShort(this.f1410f);
                dataOutputStream.writeUTF(this.aWB);
                dataOutputStream.writeShort(this.aWU.size());
                for (Entry entry : this.aWU.entrySet()) {
                    dataOutputStream.writeUTF(aqv.cx((String) entry.getKey()));
                    dataOutputStream.writeUTF(aqv.cx((String) entry.getValue()));
                }
                dataOutputStream.writeLong(this.f1411g);
                dataOutputStream.writeLong(this.aYX);
                dataOutputStream.flush();
                toByteArray = byteArrayOutputStream.toByteArray();
                aqv.m4252a(dataOutputStream);
            } catch (IOException e) {
                closeable = dataOutputStream;
                try {
                    toByteArray = new byte[0];
                    aqv.m4252a(closeable);
                    return toByteArray;
                } catch (Throwable th2) {
                    th = th2;
                    dataOutputStream = closeable;
                    aqv.m4252a(dataOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                aqv.m4252a(dataOutputStream);
                throw th;
            }
        } catch (IOException e2) {
            closeable = null;
            toByteArray = new byte[0];
            aqv.m4252a(closeable);
            return toByteArray;
        } catch (Throwable th4) {
            dataOutputStream = null;
            th = th4;
            aqv.m4252a(dataOutputStream);
            throw th;
        }
        return toByteArray;
    }
}
