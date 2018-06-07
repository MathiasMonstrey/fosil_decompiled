package com.fossil;

import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.json.JSONObject;

class epl implements epj {
    private final emr dNl;

    public epl(emr com_fossil_emr) {
        this.dNl = com_fossil_emr;
    }

    public JSONObject aGv() {
        Closeable fileInputStream;
        Throwable e;
        Closeable closeable = null;
        emm.aEU().mo2950d("Fabric", "Reading cached settings...");
        try {
            JSONObject jSONObject;
            File file = new File(new epa(this.dNl).getFilesDir(), "com.crashlytics.settings.json");
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    jSONObject = new JSONObject(CommonUtils.w(fileInputStream));
                    closeable = fileInputStream;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        emm.aEU().mo2953g("Fabric", "Failed to fetch cached settings", e);
                        CommonUtils.a(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        closeable = fileInputStream;
                        CommonUtils.a(closeable, "Error while closing settings cache file.");
                        throw e;
                    }
                }
            }
            emm.aEU().mo2950d("Fabric", "No cached settings found.");
            jSONObject = null;
            CommonUtils.a(closeable, "Error while closing settings cache file.");
            return jSONObject;
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            emm.aEU().mo2953g("Fabric", "Failed to fetch cached settings", e);
            CommonUtils.a(fileInputStream, "Error while closing settings cache file.");
            return null;
        } catch (Throwable th2) {
            e = th2;
            CommonUtils.a(closeable, "Error while closing settings cache file.");
            throw e;
        }
    }

    public void mo2995a(long j, JSONObject jSONObject) {
        Closeable fileWriter;
        Throwable e;
        emm.aEU().mo2950d("Fabric", "Writing settings to cache file...");
        if (jSONObject != null) {
            Closeable closeable = null;
            try {
                jSONObject.put("expires_at", j);
                fileWriter = new FileWriter(new File(new epa(this.dNl).getFilesDir(), "com.crashlytics.settings.json"));
                try {
                    fileWriter.write(jSONObject.toString());
                    fileWriter.flush();
                    CommonUtils.a(fileWriter, "Failed to close settings writer.");
                } catch (Exception e2) {
                    e = e2;
                    try {
                        emm.aEU().mo2953g("Fabric", "Failed to cache settings", e);
                        CommonUtils.a(fileWriter, "Failed to close settings writer.");
                    } catch (Throwable th) {
                        e = th;
                        closeable = fileWriter;
                        CommonUtils.a(closeable, "Failed to close settings writer.");
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileWriter = null;
                emm.aEU().mo2953g("Fabric", "Failed to cache settings", e);
                CommonUtils.a(fileWriter, "Failed to close settings writer.");
            } catch (Throwable th2) {
                e = th2;
                CommonUtils.a(closeable, "Failed to close settings writer.");
                throw e;
            }
        }
    }
}
