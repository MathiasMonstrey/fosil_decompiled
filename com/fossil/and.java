package com.fossil;

import com.fossil.aom.C1777a;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

public final class and {
    private static final String aWB = and.class.getSimpleName();

    public static aom m3957s(File file) {
        Closeable fileInputStream;
        Closeable dataInputStream;
        Throwable e;
        aom com_fossil_aom;
        if (file == null || !file.exists()) {
            return null;
        }
        aqi c1777a = new C1777a();
        try {
            fileInputStream = new FileInputStream(file);
            try {
                dataInputStream = new DataInputStream(fileInputStream);
            } catch (Exception e2) {
                e = e2;
                dataInputStream = null;
                try {
                    app.m4174b(3, aWB, "Error loading legacy agent data.", e);
                    aqv.m4252a(dataInputStream);
                    aqv.m4252a(fileInputStream);
                    com_fossil_aom = null;
                    return com_fossil_aom;
                } catch (Throwable th) {
                    e = th;
                    aqv.m4252a(dataInputStream);
                    aqv.m4252a(fileInputStream);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                dataInputStream = null;
                aqv.m4252a(dataInputStream);
                aqv.m4252a(fileInputStream);
                throw e;
            }
            try {
                if (dataInputStream.readUnsignedShort() != 46586) {
                    app.m4180g(3, aWB, "Unexpected file type");
                    aqv.m4252a(dataInputStream);
                    aqv.m4252a(fileInputStream);
                    return null;
                }
                int readUnsignedShort = dataInputStream.readUnsignedShort();
                if (readUnsignedShort != 2) {
                    app.m4180g(6, aWB, "Unknown agent file version: " + readUnsignedShort);
                    aqv.m4252a(dataInputStream);
                    aqv.m4252a(fileInputStream);
                    return null;
                }
                com_fossil_aom = (aom) c1777a.mo1106j(dataInputStream);
                aqv.m4252a(dataInputStream);
                aqv.m4252a(fileInputStream);
                return com_fossil_aom;
            } catch (Exception e3) {
                e = e3;
                app.m4174b(3, aWB, "Error loading legacy agent data.", e);
                aqv.m4252a(dataInputStream);
                aqv.m4252a(fileInputStream);
                com_fossil_aom = null;
                return com_fossil_aom;
            }
        } catch (Exception e4) {
            e = e4;
            dataInputStream = null;
            fileInputStream = null;
            app.m4174b(3, aWB, "Error loading legacy agent data.", e);
            aqv.m4252a(dataInputStream);
            aqv.m4252a(fileInputStream);
            com_fossil_aom = null;
            return com_fossil_aom;
        } catch (Throwable th3) {
            e = th3;
            dataInputStream = null;
            fileInputStream = null;
            aqv.m4252a(dataInputStream);
            aqv.m4252a(fileInputStream);
            throw e;
        }
    }
}
