package com.fossil;

import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class ade {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final File aJe;

    public ade(File file) {
        this.aJe = file;
    }

    public void m3033a(String str, adm com_fossil_adm) {
        Throwable e;
        File aK = aK(str);
        Closeable closeable = null;
        Closeable bufferedWriter;
        try {
            String a = m3030a(com_fossil_adm);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aK), UTF_8));
            try {
                bufferedWriter.write(a);
                bufferedWriter.flush();
                CommonUtils.a(bufferedWriter, "Failed to close user metadata file.");
            } catch (Exception e2) {
                e = e2;
                try {
                    emm.aEU().mo2953g("Fabric", "Error serializing user metadata.", e);
                    CommonUtils.a(bufferedWriter, "Failed to close user metadata file.");
                } catch (Throwable th) {
                    e = th;
                    closeable = bufferedWriter;
                    CommonUtils.a(closeable, "Failed to close user metadata file.");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            bufferedWriter = null;
            emm.aEU().mo2953g("Fabric", "Error serializing user metadata.", e);
            CommonUtils.a(bufferedWriter, "Failed to close user metadata file.");
        } catch (Throwable th2) {
            e = th2;
            CommonUtils.a(closeable, "Failed to close user metadata file.");
            throw e;
        }
    }

    public adm aI(String str) {
        Throwable e;
        File aK = aK(str);
        if (!aK.exists()) {
            return adm.aKy;
        }
        Closeable fileInputStream;
        try {
            fileInputStream = new FileInputStream(aK);
            try {
                adm aM = aM(CommonUtils.w(fileInputStream));
                CommonUtils.a(fileInputStream, "Failed to close user metadata file.");
                return aM;
            } catch (Exception e2) {
                e = e2;
                try {
                    emm.aEU().mo2953g("Fabric", "Error deserializing user metadata.", e);
                    CommonUtils.a(fileInputStream, "Failed to close user metadata file.");
                    return adm.aKy;
                } catch (Throwable th) {
                    e = th;
                    CommonUtils.a(fileInputStream, "Failed to close user metadata file.");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            emm.aEU().mo2953g("Fabric", "Error deserializing user metadata.", e);
            CommonUtils.a(fileInputStream, "Failed to close user metadata file.");
            return adm.aKy;
        } catch (Throwable th2) {
            e = th2;
            fileInputStream = null;
            CommonUtils.a(fileInputStream, "Failed to close user metadata file.");
            throw e;
        }
    }

    public void m3034a(String str, Map<String, String> map) {
        Closeable bufferedWriter;
        Throwable e;
        File aL = aL(str);
        Closeable closeable = null;
        try {
            String b = m3032b(map);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aL), UTF_8));
            try {
                bufferedWriter.write(b);
                bufferedWriter.flush();
                CommonUtils.a(bufferedWriter, "Failed to close key/value metadata file.");
            } catch (Exception e2) {
                e = e2;
                try {
                    emm.aEU().mo2953g("Fabric", "Error serializing key/value metadata.", e);
                    CommonUtils.a(bufferedWriter, "Failed to close key/value metadata file.");
                } catch (Throwable th) {
                    e = th;
                    closeable = bufferedWriter;
                    CommonUtils.a(closeable, "Failed to close key/value metadata file.");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            bufferedWriter = null;
            emm.aEU().mo2953g("Fabric", "Error serializing key/value metadata.", e);
            CommonUtils.a(bufferedWriter, "Failed to close key/value metadata file.");
        } catch (Throwable th2) {
            e = th2;
            CommonUtils.a(closeable, "Failed to close key/value metadata file.");
            throw e;
        }
    }

    public Map<String, String> aJ(String str) {
        Closeable fileInputStream;
        Throwable e;
        File aL = aL(str);
        if (!aL.exists()) {
            return Collections.emptyMap();
        }
        try {
            fileInputStream = new FileInputStream(aL);
            try {
                Map<String, String> aN = aN(CommonUtils.w(fileInputStream));
                CommonUtils.a(fileInputStream, "Failed to close user metadata file.");
                return aN;
            } catch (Exception e2) {
                e = e2;
                try {
                    emm.aEU().mo2953g("Fabric", "Error deserializing user metadata.", e);
                    CommonUtils.a(fileInputStream, "Failed to close user metadata file.");
                    return Collections.emptyMap();
                } catch (Throwable th) {
                    e = th;
                    CommonUtils.a(fileInputStream, "Failed to close user metadata file.");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            emm.aEU().mo2953g("Fabric", "Error deserializing user metadata.", e);
            CommonUtils.a(fileInputStream, "Failed to close user metadata file.");
            return Collections.emptyMap();
        } catch (Throwable th2) {
            e = th2;
            fileInputStream = null;
            CommonUtils.a(fileInputStream, "Failed to close user metadata file.");
            throw e;
        }
    }

    private File aK(String str) {
        return new File(this.aJe, str + "user" + ".meta");
    }

    private File aL(String str) {
        return new File(this.aJe, str + "keys" + ".meta");
    }

    private static adm aM(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        return new adm(m3031a(jSONObject, "userId"), m3031a(jSONObject, "userName"), m3031a(jSONObject, "userEmail"));
    }

    private static String m3030a(final adm com_fossil_adm) throws JSONException {
        return new JSONObject() {
        }.toString();
    }

    private static Map<String, String> aN(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        Map<String, String> hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            hashMap.put(str2, m3031a(jSONObject, str2));
        }
        return hashMap;
    }

    private static String m3032b(Map<String, String> map) throws JSONException {
        return new JSONObject(map).toString();
    }

    private static String m3031a(JSONObject jSONObject, String str) {
        return !jSONObject.isNull(str) ? jSONObject.optString(str, null) : null;
    }
}
