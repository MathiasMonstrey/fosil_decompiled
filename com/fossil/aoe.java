package com.fossil;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class aoe {
    public String aWB;
    private String aWX;
    private long aXw;
    private Map<String, String> aYF = new HashMap();
    private Throwable aYV;
    private Map<String, String> aYW = new HashMap();
    private int f1407b;
    private String f1408d;

    public aoe(int i, long j, String str, String str2, String str3, Throwable th, Map<String, String> map, Map<String, String> map2) {
        this.f1407b = i;
        this.aXw = j;
        this.aWB = str;
        this.f1408d = str2;
        this.aWX = str3;
        this.aYV = th;
        if (map != null) {
            this.aYF = map;
        }
        if (map2 != null) {
            this.aYW = map2;
        }
    }

    public final byte[] Ii() {
        byte[] bytes;
        Closeable closeable;
        Throwable th;
        Closeable dataOutputStream;
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeShort(this.f1407b);
                dataOutputStream.writeLong(this.aXw);
                dataOutputStream.writeUTF(this.aWB);
                dataOutputStream.writeUTF(this.f1408d);
                dataOutputStream.writeUTF(this.aWX);
                dataOutputStream.writeShort(this.aYF.size());
                for (Entry entry : this.aYF.entrySet()) {
                    dataOutputStream.writeUTF((String) entry.getKey());
                    dataOutputStream.writeUTF((String) entry.getValue());
                }
                dataOutputStream.writeShort(this.aYW.size());
                for (Entry entry2 : this.aYW.entrySet()) {
                    dataOutputStream.writeUTF((String) entry2.getKey());
                    dataOutputStream.writeUTF((String) entry2.getValue());
                }
                if (this.aYV != null) {
                    if ("uncaught".equals(this.aWB)) {
                        dataOutputStream.writeByte(3);
                    } else {
                        dataOutputStream.writeByte(2);
                    }
                    dataOutputStream.writeByte(2);
                    StringBuilder stringBuilder = new StringBuilder("");
                    String property = System.getProperty("line.separator");
                    for (Object append : this.aYV.getStackTrace()) {
                        stringBuilder.append(append);
                        stringBuilder.append(property);
                    }
                    if (this.aYV.getCause() != null) {
                        stringBuilder.append(property);
                        stringBuilder.append("Caused by: ");
                        for (Object append2 : this.aYV.getCause().getStackTrace()) {
                            stringBuilder.append(append2);
                            stringBuilder.append(property);
                        }
                    }
                    bytes = stringBuilder.toString().getBytes();
                    dataOutputStream.writeInt(bytes.length);
                    dataOutputStream.write(bytes);
                } else {
                    dataOutputStream.writeByte(1);
                    dataOutputStream.writeByte(0);
                }
                dataOutputStream.flush();
                bytes = byteArrayOutputStream.toByteArray();
                aqv.m4252a(dataOutputStream);
            } catch (IOException e) {
                closeable = dataOutputStream;
                try {
                    bytes = new byte[0];
                    aqv.m4252a(closeable);
                    return bytes;
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
            bytes = new byte[0];
            aqv.m4252a(closeable);
            return bytes;
        } catch (Throwable th4) {
            dataOutputStream = null;
            th = th4;
            aqv.m4252a(dataOutputStream);
            throw th;
        }
        return bytes;
    }
}
