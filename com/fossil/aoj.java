package com.fossil;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class aoj {
    private static final String aWR = aoj.class.getSimpleName();
    byte[] aYe;

    public static class C1764a implements aqi<aoj> {
        public final /* synthetic */ void mo1105a(OutputStream outputStream, Object obj) throws IOException {
            aoj com_fossil_aoj = (aoj) obj;
            if (outputStream != null && com_fossil_aoj != null) {
                DataOutputStream c17621 = new DataOutputStream(this, outputStream) {
                    final /* synthetic */ C1764a aZa;

                    public final void close() {
                    }
                };
                int i = 0;
                if (com_fossil_aoj.aYe != null) {
                    i = com_fossil_aoj.aYe.length;
                }
                c17621.writeShort(i);
                if (i > 0) {
                    c17621.write(com_fossil_aoj.aYe);
                }
                c17621.flush();
            }
        }

        public final /* synthetic */ Object mo1106j(InputStream inputStream) throws IOException {
            if (inputStream == null) {
                return null;
            }
            DataInputStream c17632 = new DataInputStream(this, inputStream) {
                final /* synthetic */ C1764a aZa;

                public final void close() {
                }
            };
            Object com_fossil_aoj = new aoj();
            int readUnsignedShort = c17632.readUnsignedShort();
            if (readUnsignedShort <= 0) {
                return com_fossil_aoj;
            }
            byte[] bArr = new byte[readUnsignedShort];
            c17632.readFully(bArr);
            com_fossil_aoj.aYe = bArr;
            return com_fossil_aoj;
        }
    }

    private aoj() {
    }

    public aoj(byte[] bArr) {
        this.aYe = bArr;
    }

    @SuppressLint({"NewApi"})
    public aoj(aok com_fossil_aok) throws IOException {
        byte[] bArr;
        Throwable e;
        Closeable dataOutputStream;
        try {
            Closeable closeable;
            int Iz;
            boolean z;
            List<aog> list;
            List<aoe> list2;
            int i;
            int length;
            List<String> list3;
            byte[] bytes;
            Object obj;
            String[] split;
            int length2;
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeShort(13);
            dataOutputStream.writeUTF(com_fossil_aok.aWB);
            dataOutputStream.writeUTF("");
            dataOutputStream.writeUTF("8020000");
            dataOutputStream.writeLong(com_fossil_aok.aXv);
            dataOutputStream.writeLong(com_fossil_aok.aXw);
            dataOutputStream.writeLong(com_fossil_aok.aYX);
            dataOutputStream.writeBoolean(true);
            if (com_fossil_aok.aZh) {
                dataOutputStream.writeByte(2);
            } else {
                dataOutputStream.writeByte(0);
            }
            dataOutputStream.writeBoolean(com_fossil_aok.aZi);
            if (TextUtils.isEmpty(com_fossil_aok.aXl)) {
                dataOutputStream.writeBoolean(false);
            } else {
                dataOutputStream.writeBoolean(true);
                dataOutputStream.writeUTF(com_fossil_aok.aXl);
            }
            if (TextUtils.isEmpty(com_fossil_aok.aYv)) {
                dataOutputStream.writeBoolean(false);
            } else {
                dataOutputStream.writeBoolean(true);
                dataOutputStream.writeUTF(com_fossil_aok.aYv);
            }
            Map map = com_fossil_aok.aYW;
            if (map == null) {
                dataOutputStream.writeShort(0);
            } else {
                dataOutputStream.writeShort(map.size());
                for (Entry entry : map.entrySet()) {
                    dataOutputStream.writeUTF((String) entry.getKey());
                    dataOutputStream.writeUTF((String) entry.getValue());
                }
            }
            map = com_fossil_aok.aWU;
            if (map == null) {
                dataOutputStream.writeShort(0);
            } else {
                dataOutputStream.writeShort(map.size());
                for (Entry entry2 : map.entrySet()) {
                    dataOutputStream.writeUTF((String) entry2.getKey());
                    dataOutputStream.writeUTF((String) entry2.getValue());
                    dataOutputStream.writeByte(0);
                }
            }
            dataOutputStream.writeUTF(com_fossil_aok.aZb);
            dataOutputStream.writeUTF(com_fossil_aok.aXS);
            dataOutputStream.writeByte(com_fossil_aok.f1414k);
            dataOutputStream.writeByte(com_fossil_aok.aZc);
            dataOutputStream.writeUTF(com_fossil_aok.aYt);
            if (com_fossil_aok.aZd == null) {
                closeable = dataOutputStream;
            } else {
                Iz = aos.Iz();
                dataOutputStream.writeBoolean(true);
                Location location = com_fossil_aok.aZd;
                dataOutputStream.writeDouble(aqv.m4250a(location.getLatitude(), Iz));
                dataOutputStream.writeDouble(aqv.m4250a(location.getLongitude(), Iz));
                dataOutputStream.writeFloat(location.getAccuracy());
                dataOutputStream.writeLong(location.getTime());
                dataOutputStream.writeDouble(location.getAltitude());
                if (VERSION.SDK_INT >= 26) {
                    dataOutputStream.writeFloat(location.getVerticalAccuracyMeters());
                } else {
                    dataOutputStream.writeFloat(0.0f);
                }
                dataOutputStream.writeFloat(location.getBearing());
                dataOutputStream.writeFloat(location.getSpeed());
                if (VERSION.SDK_INT >= 26) {
                    if (location.hasBearingAccuracy() && location.hasSpeedAccuracy()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    dataOutputStream.writeBoolean(z);
                    if (z) {
                        dataOutputStream.writeFloat(location.getBearingAccuracyDegrees());
                        dataOutputStream.writeFloat(location.getSpeedAccuracyMetersPerSecond());
                    }
                } else {
                    dataOutputStream.writeBoolean(false);
                }
                if (Iz != -1) {
                    z = true;
                    Closeable closeable2 = dataOutputStream;
                    r3.writeBoolean(z);
                    dataOutputStream.writeInt(com_fossil_aok.aZe);
                    dataOutputStream.writeByte(com_fossil_aok.f1416x);
                    dataOutputStream.writeByte(-1);
                    dataOutputStream.writeByte(-1);
                    dataOutputStream.writeByte(com_fossil_aok.aZf);
                    if (com_fossil_aok.aZg != null) {
                        dataOutputStream.writeBoolean(false);
                    } else {
                        dataOutputStream.writeBoolean(true);
                        dataOutputStream.writeLong(com_fossil_aok.aZg.longValue());
                    }
                    map = com_fossil_aok.aZj;
                    if (map != null) {
                        dataOutputStream.writeShort(0);
                    } else {
                        dataOutputStream.writeShort(map.size());
                        for (Entry entry3 : map.entrySet()) {
                            dataOutputStream.writeUTF((String) entry3.getKey());
                            dataOutputStream.writeInt(((aof) entry3.getValue()).f1409a);
                        }
                    }
                    list = com_fossil_aok.aZk;
                    if (list != null) {
                        dataOutputStream.writeShort(0);
                    } else {
                        dataOutputStream.writeShort(list.size());
                        for (aog Ij : list) {
                            dataOutputStream.write(Ij.Ij());
                        }
                    }
                    dataOutputStream.writeBoolean(com_fossil_aok.f1415w);
                    list2 = com_fossil_aok.aZm;
                    if (list2 == null) {
                        Iz = 0;
                        i = 0;
                        for (aoe Ii : list2) {
                            length = Ii.Ii().length + i;
                            if (length > 160000) {
                                app.m4180g(5, aWR, "Error Log size exceeded. No more event details logged.");
                                i = Iz;
                                break;
                            }
                            Iz++;
                            i = length;
                        }
                        i = Iz;
                    } else {
                        i = 0;
                    }
                    dataOutputStream.writeInt(com_fossil_aok.f1417y);
                    dataOutputStream.writeShort(i);
                    for (Iz = 0; Iz < i; Iz++) {
                        dataOutputStream.write(((aoe) list2.get(Iz)).Ii());
                    }
                    dataOutputStream.writeInt(0);
                    dataOutputStream.writeShort(0);
                    dataOutputStream.writeShort(0);
                    dataOutputStream.writeShort(0);
                    list3 = com_fossil_aok.aZl;
                    dataOutputStream.writeShort(list3.size());
                    for (String bytes2 : list3) {
                        bArr = new byte[0];
                        try {
                            bytes = bytes2.getBytes("UTF8");
                        } catch (UnsupportedEncodingException e2) {
                            app.m4180g(6, aWR, "Error encoding purchase receipt.");
                            bytes = bArr;
                        }
                        try {
                            dataOutputStream.writeByte(2);
                            dataOutputStream.writeInt(bytes.length);
                            dataOutputStream.write(bytes);
                        } catch (IOException e3) {
                            e = e3;
                        }
                    }
                    obj = com_fossil_aok.aZn;
                    if (TextUtils.isEmpty(obj)) {
                        split = obj.split(",");
                        if (split.length % 2 != 1) {
                            dataOutputStream.writeShort(Short.parseShort(split[0]));
                            length2 = split.length - 1;
                            length = 1;
                            while (length < length2) {
                                dataOutputStream.writeShort(1);
                                dataOutputStream.writeLong(Long.parseLong(split[length]));
                                length++;
                                dataOutputStream.writeInt(Integer.parseInt(split[length]));
                                length++;
                            }
                        } else {
                            app.m4180g(6, aWR, "Error variant IDs.");
                            dataOutputStream.writeShort(0);
                        }
                    } else {
                        dataOutputStream.writeShort(0);
                    }
                    this.aYe = byteArrayOutputStream.toByteArray();
                    aqv.m4252a(dataOutputStream);
                }
                closeable = dataOutputStream;
            }
            DataOutputStream dataOutputStream2 = closeable;
            z = false;
            dataOutputStream2.writeBoolean(z);
            dataOutputStream.writeInt(com_fossil_aok.aZe);
            dataOutputStream.writeByte(com_fossil_aok.f1416x);
            dataOutputStream.writeByte(-1);
            dataOutputStream.writeByte(-1);
            dataOutputStream.writeByte(com_fossil_aok.aZf);
            if (com_fossil_aok.aZg != null) {
                dataOutputStream.writeBoolean(true);
                dataOutputStream.writeLong(com_fossil_aok.aZg.longValue());
            } else {
                dataOutputStream.writeBoolean(false);
            }
            map = com_fossil_aok.aZj;
            if (map != null) {
                dataOutputStream.writeShort(map.size());
                for (Entry entry32 : map.entrySet()) {
                    dataOutputStream.writeUTF((String) entry32.getKey());
                    dataOutputStream.writeInt(((aof) entry32.getValue()).f1409a);
                }
            } else {
                dataOutputStream.writeShort(0);
            }
            list = com_fossil_aok.aZk;
            if (list != null) {
                dataOutputStream.writeShort(list.size());
                while (r3.hasNext()) {
                    dataOutputStream.write(Ij.Ij());
                }
            } else {
                dataOutputStream.writeShort(0);
            }
            dataOutputStream.writeBoolean(com_fossil_aok.f1415w);
            list2 = com_fossil_aok.aZm;
            if (list2 == null) {
                i = 0;
            } else {
                Iz = 0;
                i = 0;
                while (r10.hasNext()) {
                    length = Ii.Ii().length + i;
                    if (length > 160000) {
                        app.m4180g(5, aWR, "Error Log size exceeded. No more event details logged.");
                        i = Iz;
                        break;
                    }
                    Iz++;
                    i = length;
                }
                i = Iz;
            }
            dataOutputStream.writeInt(com_fossil_aok.f1417y);
            dataOutputStream.writeShort(i);
            for (Iz = 0; Iz < i; Iz++) {
                dataOutputStream.write(((aoe) list2.get(Iz)).Ii());
            }
            dataOutputStream.writeInt(0);
            dataOutputStream.writeShort(0);
            dataOutputStream.writeShort(0);
            dataOutputStream.writeShort(0);
            list3 = com_fossil_aok.aZl;
            dataOutputStream.writeShort(list3.size());
            while (r6.hasNext()) {
                bArr = new byte[0];
                bytes = bytes2.getBytes("UTF8");
                dataOutputStream.writeByte(2);
                dataOutputStream.writeInt(bytes.length);
                dataOutputStream.write(bytes);
            }
            obj = com_fossil_aok.aZn;
            if (TextUtils.isEmpty(obj)) {
                split = obj.split(",");
                if (split.length % 2 != 1) {
                    app.m4180g(6, aWR, "Error variant IDs.");
                    dataOutputStream.writeShort(0);
                } else {
                    dataOutputStream.writeShort(Short.parseShort(split[0]));
                    length2 = split.length - 1;
                    length = 1;
                    while (length < length2) {
                        dataOutputStream.writeShort(1);
                        dataOutputStream.writeLong(Long.parseLong(split[length]));
                        length++;
                        dataOutputStream.writeInt(Integer.parseInt(split[length]));
                        length++;
                    }
                }
            } else {
                dataOutputStream.writeShort(0);
            }
            this.aYe = byteArrayOutputStream.toByteArray();
            aqv.m4252a(dataOutputStream);
        } catch (IOException e4) {
            e = e4;
            dataOutputStream = null;
            try {
                app.m4174b(6, aWR, "", e);
                throw e;
            } catch (Throwable th) {
                e = th;
                aqv.m4252a(dataOutputStream);
                throw e;
            }
        } catch (Throwable th2) {
            e = th2;
            dataOutputStream = null;
            aqv.m4252a(dataOutputStream);
            throw e;
        }
    }
}
