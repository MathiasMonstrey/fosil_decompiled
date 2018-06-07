package com.fossil;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.flurry.sdk.jq;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class aoh {
    private static final String aWR = aoh.class.getSimpleName();
    public byte[] aYe = null;

    public aoh(String str, String str2, boolean z, boolean z2, long j, long j2, List<aoj> list, Map<jq, byte[]> map, Map<String, List<String>> map2, Map<String, List<String>> map3, Map<String, Map<String, String>> map4, long j3, aqp com_fossil_aqp, boolean z3) throws IOException {
        byte[] bArr;
        Throwable th;
        Closeable closeable = null;
        Closeable dataOutputStream;
        try {
            MessageDigest com_fossil_aph = new aph();
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            OutputStream digestOutputStream = new DigestOutputStream(byteArrayOutputStream, com_fossil_aph);
            dataOutputStream = new DataOutputStream(digestOutputStream);
            try {
                int size;
                int size2;
                dataOutputStream.writeShort(33);
                dataOutputStream.writeShort(0);
                dataOutputStream.writeLong(0);
                dataOutputStream.writeShort(0);
                dataOutputStream.writeShort(3);
                dataOutputStream.writeShort(apd.Iz());
                dataOutputStream.writeLong(j3);
                dataOutputStream.writeUTF(str);
                dataOutputStream.writeUTF(str2);
                String str3 = (String) com_fossil_aqp.cw("VersionName");
                if (TextUtils.isEmpty(str3)) {
                    dataOutputStream.writeUTF("");
                } else {
                    dataOutputStream.writeUTF(str3);
                }
                Context context = apc.IO().baD;
                dataOutputStream.writeUTF(String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
                dataOutputStream.writeByte(1);
                dataOutputStream.writeShort(map.size());
                for (Entry entry : map.entrySet()) {
                    dataOutputStream.writeShort(((jq) entry.getKey()).f1321d);
                    bArr = (byte[]) entry.getValue();
                    dataOutputStream.writeShort(bArr.length);
                    dataOutputStream.write(bArr);
                }
                dataOutputStream.writeByte(0);
                dataOutputStream.writeBoolean(z);
                dataOutputStream.writeBoolean(z2);
                dataOutputStream.writeLong(j);
                dataOutputStream.writeLong(j2);
                if (z3) {
                    dataOutputStream.writeByte(2);
                } else {
                    dataOutputStream.writeByte(0);
                }
                dataOutputStream.writeBoolean(((Boolean) com_fossil_aqp.cw("IncludeBackgroundSessionsInMetrics")).booleanValue());
                dataOutputStream.writeShort(7);
                dataOutputStream.writeUTF("device.model");
                dataOutputStream.writeUTF(Build.MODEL);
                dataOutputStream.writeByte(0);
                dataOutputStream.writeUTF("build.brand");
                dataOutputStream.writeUTF(Build.BRAND);
                dataOutputStream.writeByte(0);
                dataOutputStream.writeUTF("build.id");
                dataOutputStream.writeUTF(Build.ID);
                dataOutputStream.writeByte(0);
                dataOutputStream.writeUTF("version.release");
                dataOutputStream.writeUTF(VERSION.RELEASE);
                dataOutputStream.writeByte(0);
                dataOutputStream.writeUTF("build.device");
                dataOutputStream.writeUTF(Build.DEVICE);
                dataOutputStream.writeByte(0);
                dataOutputStream.writeUTF("build.product");
                dataOutputStream.writeUTF(Build.PRODUCT);
                dataOutputStream.writeByte(0);
                dataOutputStream.writeUTF("proguard.build.uuid");
                aoo.It();
                context = apc.IO().baD;
                if (context != null) {
                    int identifier = context.getResources().getIdentifier("com.flurry.crash.map_id", "string", context.getPackageName());
                    if (identifier != 0) {
                        str3 = context.getResources().getString(identifier);
                        dataOutputStream.writeUTF(str3);
                        dataOutputStream.writeByte(0);
                        dataOutputStream.writeShort(map2 == null ? map2.keySet().size() : 0);
                        if (map2 != null) {
                            app.m4180g(3, aWR, "sending referrer values because it exists");
                            for (Entry entry2 : map2.entrySet()) {
                                app.m4180g(3, aWR, "Referrer Entry:  " + ((String) entry2.getKey()) + SimpleComparison.EQUAL_TO_OPERATION + entry2.getValue());
                                dataOutputStream.writeUTF((String) entry2.getKey());
                                app.m4180g(3, aWR, "referrer key is :" + ((String) entry2.getKey()));
                                dataOutputStream.writeShort(((List) entry2.getValue()).size());
                                for (String str32 : (List) entry2.getValue()) {
                                    dataOutputStream.writeUTF(str32);
                                    app.m4180g(3, aWR, "referrer value is :" + str32);
                                }
                            }
                        }
                        str32 = (String) com_fossil_aqp.cw("notificationToken");
                        if (TextUtils.isEmpty(str32)) {
                            dataOutputStream.writeBoolean(true);
                            dataOutputStream.writeUTF(str32);
                        } else {
                            dataOutputStream.writeBoolean(false);
                        }
                        dataOutputStream.writeBoolean(((Boolean) com_fossil_aqp.cw("notificationsEnabled")).booleanValue());
                        if (map3 == null) {
                            size = map3.keySet().size();
                        } else {
                            size = 0;
                        }
                        app.m4180g(3, aWR, "optionsMapSize is:  " + size);
                        dataOutputStream.writeShort(size);
                        if (map3 != null) {
                            app.m4180g(3, aWR, "sending launch options");
                            for (Entry entry22 : map3.entrySet()) {
                                app.m4180g(3, aWR, "Launch Options Key:  " + ((String) entry22.getKey()));
                                dataOutputStream.writeUTF((String) entry22.getKey());
                                dataOutputStream.writeShort(((List) entry22.getValue()).size());
                                for (String str322 : (List) entry22.getValue()) {
                                    dataOutputStream.writeUTF(str322);
                                    app.m4180g(3, aWR, "Launch Options value is :" + str322);
                                }
                            }
                        }
                        size2 = map4 == null ? map4.keySet().size() : 0;
                        app.m4180g(3, aWR, "numOriginAttributions is:  " + size);
                        dataOutputStream.writeShort(size2);
                        if (map4 != null) {
                            for (Entry entry3 : map4.entrySet()) {
                                app.m4180g(3, aWR, "Origin Atttribute Key:  " + ((String) entry3.getKey()));
                                dataOutputStream.writeUTF((String) entry3.getKey());
                                dataOutputStream.writeShort(((Map) entry3.getValue()).size());
                                app.m4180g(3, aWR, "Origin Attribute Map Size for " + ((String) entry3.getKey()) + ":  " + ((Map) entry3.getValue()).size());
                                for (Entry entry4 : ((Map) entry3.getValue()).entrySet()) {
                                    app.m4180g(3, aWR, "Origin Atttribute for " + ((String) entry3.getKey()) + ":  " + ((String) entry4.getKey()) + ":" + ((String) entry4.getValue()));
                                    dataOutputStream.writeUTF(entry4.getKey() == null ? (String) entry4.getKey() : "");
                                    if (entry4.getValue() == null) {
                                        str322 = (String) entry4.getValue();
                                    } else {
                                        str322 = "";
                                    }
                                    dataOutputStream.writeUTF(str322);
                                }
                            }
                        }
                        dataOutputStream.writeUTF(aqs.m4244Y(apc.IO().baD));
                        dataOutputStream.writeShort(list.size());
                        for (aoj com_fossil_aoj : list) {
                            dataOutputStream.write(com_fossil_aoj.aYe);
                        }
                        dataOutputStream.writeShort(0);
                        dataOutputStream.writeShort(0);
                        digestOutputStream.on(false);
                        dataOutputStream.write(com_fossil_aph.Ii());
                        dataOutputStream.close();
                        bArr = byteArrayOutputStream.toByteArray();
                        aqv.m4252a(dataOutputStream);
                        this.aYe = bArr;
                    }
                }
                str322 = "";
                dataOutputStream.writeUTF(str322);
                dataOutputStream.writeByte(0);
                if (map2 == null) {
                }
                dataOutputStream.writeShort(map2 == null ? map2.keySet().size() : 0);
                if (map2 != null) {
                    app.m4180g(3, aWR, "sending referrer values because it exists");
                    for (Entry entry222 : map2.entrySet()) {
                        app.m4180g(3, aWR, "Referrer Entry:  " + ((String) entry222.getKey()) + SimpleComparison.EQUAL_TO_OPERATION + entry222.getValue());
                        dataOutputStream.writeUTF((String) entry222.getKey());
                        app.m4180g(3, aWR, "referrer key is :" + ((String) entry222.getKey()));
                        dataOutputStream.writeShort(((List) entry222.getValue()).size());
                        for (String str3222 : (List) entry222.getValue()) {
                            dataOutputStream.writeUTF(str3222);
                            app.m4180g(3, aWR, "referrer value is :" + str3222);
                        }
                    }
                }
                str3222 = (String) com_fossil_aqp.cw("notificationToken");
                if (TextUtils.isEmpty(str3222)) {
                    dataOutputStream.writeBoolean(false);
                } else {
                    dataOutputStream.writeBoolean(true);
                    dataOutputStream.writeUTF(str3222);
                }
                dataOutputStream.writeBoolean(((Boolean) com_fossil_aqp.cw("notificationsEnabled")).booleanValue());
                if (map3 == null) {
                    size = 0;
                } else {
                    size = map3.keySet().size();
                }
                app.m4180g(3, aWR, "optionsMapSize is:  " + size);
                dataOutputStream.writeShort(size);
                if (map3 != null) {
                    app.m4180g(3, aWR, "sending launch options");
                    for (Entry entry2222 : map3.entrySet()) {
                        app.m4180g(3, aWR, "Launch Options Key:  " + ((String) entry2222.getKey()));
                        dataOutputStream.writeUTF((String) entry2222.getKey());
                        dataOutputStream.writeShort(((List) entry2222.getValue()).size());
                        for (String str32222 : (List) entry2222.getValue()) {
                            dataOutputStream.writeUTF(str32222);
                            app.m4180g(3, aWR, "Launch Options value is :" + str32222);
                        }
                    }
                }
                if (map4 == null) {
                }
                app.m4180g(3, aWR, "numOriginAttributions is:  " + size);
                dataOutputStream.writeShort(size2);
                if (map4 != null) {
                    for (Entry entry32 : map4.entrySet()) {
                        app.m4180g(3, aWR, "Origin Atttribute Key:  " + ((String) entry32.getKey()));
                        dataOutputStream.writeUTF((String) entry32.getKey());
                        dataOutputStream.writeShort(((Map) entry32.getValue()).size());
                        app.m4180g(3, aWR, "Origin Attribute Map Size for " + ((String) entry32.getKey()) + ":  " + ((Map) entry32.getValue()).size());
                        for (Entry entry42 : ((Map) entry32.getValue()).entrySet()) {
                            app.m4180g(3, aWR, "Origin Atttribute for " + ((String) entry32.getKey()) + ":  " + ((String) entry42.getKey()) + ":" + ((String) entry42.getValue()));
                            if (entry42.getKey() == null) {
                            }
                            dataOutputStream.writeUTF(entry42.getKey() == null ? (String) entry42.getKey() : "");
                            if (entry42.getValue() == null) {
                                str32222 = "";
                            } else {
                                str32222 = (String) entry42.getValue();
                            }
                            dataOutputStream.writeUTF(str32222);
                        }
                    }
                }
                dataOutputStream.writeUTF(aqs.m4244Y(apc.IO().baD));
                dataOutputStream.writeShort(list.size());
                while (r3.hasNext()) {
                    dataOutputStream.write(com_fossil_aoj.aYe);
                }
                dataOutputStream.writeShort(0);
                dataOutputStream.writeShort(0);
                digestOutputStream.on(false);
                dataOutputStream.write(com_fossil_aph.Ii());
                dataOutputStream.close();
                bArr = byteArrayOutputStream.toByteArray();
                aqv.m4252a(dataOutputStream);
            } catch (Throwable th2) {
                th = th2;
                aqv.m4252a(dataOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            dataOutputStream = null;
            aqv.m4252a(dataOutputStream);
            throw th;
        }
        this.aYe = bArr;
    }
}
