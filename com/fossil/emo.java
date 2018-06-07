package com.fossil;

import android.os.SystemClock;
import android.text.TextUtils;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.Closeable;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

class emo implements Callable<Map<String, emt>> {
    final String dNj;

    public /* synthetic */ Object call() throws Exception {
        return aEX();
    }

    emo(String str) {
        this.dNj = str;
    }

    public Map<String, emt> aEX() throws Exception {
        Map<String, emt> hashMap = new HashMap();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        ZipFile aEY = aEY();
        Enumeration entries = aEY.entries();
        int i = 0;
        while (entries.hasMoreElements()) {
            int i2 = i + 1;
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            if (zipEntry.getName().startsWith("fabric/")) {
                emt a = m10909a(zipEntry, aEY);
                if (a != null) {
                    hashMap.put(a.getIdentifier(), a);
                    emm.aEU().mo2956v("Fabric", String.format("Found kit:[%s] version:[%s]", new Object[]{a.getIdentifier(), a.getVersion()}));
                }
            }
            i = i2;
        }
        if (aEY != null) {
            try {
                aEY.close();
            } catch (IOException e) {
            }
        }
        emm.aEU().mo2956v("Fabric", "finish scanning in " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " reading:" + i);
        return hashMap;
    }

    private emt m10909a(ZipEntry zipEntry, ZipFile zipFile) {
        Closeable inputStream;
        Throwable e;
        try {
            inputStream = zipFile.getInputStream(zipEntry);
            try {
                Properties properties = new Properties();
                properties.load(inputStream);
                Object property = properties.getProperty("fabric-identifier");
                Object property2 = properties.getProperty("fabric-version");
                String property3 = properties.getProperty("fabric-build-type");
                if (TextUtils.isEmpty(property) || TextUtils.isEmpty(property2)) {
                    throw new IllegalStateException("Invalid format of fabric file," + zipEntry.getName());
                }
                emt com_fossil_emt = new emt(property, property2, property3);
                CommonUtils.closeQuietly(inputStream);
                return com_fossil_emt;
            } catch (IOException e2) {
                e = e2;
                try {
                    emm.aEU().mo2953g("Fabric", "Error when parsing fabric properties " + zipEntry.getName(), e);
                    CommonUtils.closeQuietly(inputStream);
                    return null;
                } catch (Throwable th) {
                    e = th;
                    CommonUtils.closeQuietly(inputStream);
                    throw e;
                }
            }
        } catch (IOException e3) {
            e = e3;
            inputStream = null;
            emm.aEU().mo2953g("Fabric", "Error when parsing fabric properties " + zipEntry.getName(), e);
            CommonUtils.closeQuietly(inputStream);
            return null;
        } catch (Throwable th2) {
            e = th2;
            inputStream = null;
            CommonUtils.closeQuietly(inputStream);
            throw e;
        }
    }

    protected ZipFile aEY() throws IOException {
        return new ZipFile(this.dNj);
    }
}
