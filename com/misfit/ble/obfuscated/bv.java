package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.firmware.FirmwareAPIErrorCode;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONObject;

public class bv {
    private static final String jq = "https://sdk-firmware.misfit.com/sdk/firmware";
    private static bv jr;
    static final /* synthetic */ boolean js = (!bv.class.desiredAssertionStatus());

    public class C4503a {
        public FirmwareAPIErrorCode jt;
        public byte[] ju;
        final /* synthetic */ bv jv;

        public C4503a(bv bvVar, byte[] bArr, FirmwareAPIErrorCode firmwareAPIErrorCode) {
            this.jv = bvVar;
            this.jt = firmwareAPIErrorCode;
            this.ju = bArr;
        }
    }

    public class C4504b {
        public FirmwareAPIErrorCode jt;
        final /* synthetic */ bv jv;
        public JSONObject jw;

        public C4504b(bv bvVar, JSONObject jSONObject, FirmwareAPIErrorCode firmwareAPIErrorCode) {
            this.jv = bvVar;
            this.jt = firmwareAPIErrorCode;
            this.jw = jSONObject;
        }
    }

    private bv() {
    }

    public static synchronized bv bv() {
        bv bvVar;
        synchronized (bv.class) {
            if (jr == null) {
                jr = new bv();
            }
            bvVar = jr;
        }
        return bvVar;
    }

    public C4504b m14969q(String str) {
        return m14967a(String.format("%s/%s/%s", new Object[]{jq, "current", str}), null);
    }

    public C4504b m14970r(String str) {
        return m14967a(String.format("%s/%s", new Object[]{jq, str}), null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.misfit.ble.obfuscated.bv.C4503a m14971s(java.lang.String r7) {
        /*
        r6 = this;
        r2 = 0;
        r0 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x0044 }
        r0.<init>(r7);	 Catch:{ MalformedURLException -> 0x0044 }
        r0 = r0.openConnection();	 Catch:{ IOException -> 0x0052 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ IOException -> 0x0052 }
        r0.connect();	 Catch:{ IOException -> 0x0032 }
        r1 = r0.getResponseCode();	 Catch:{ IOException -> 0x0032 }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r1 != r2) goto L_0x0071;
    L_0x0017:
        r1 = r0.getInputStream();	 Catch:{ IOException -> 0x0032 }
        r2 = new java.io.ByteArrayOutputStream;	 Catch:{ IOException -> 0x0032 }
        r2.<init>();	 Catch:{ IOException -> 0x0032 }
        r3 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;
        r3 = new byte[r3];	 Catch:{ IOException -> 0x0032 }
    L_0x0024:
        r4 = 0;
        r5 = r3.length;	 Catch:{ IOException -> 0x0032 }
        r4 = r1.read(r3, r4, r5);	 Catch:{ IOException -> 0x0032 }
        r5 = -1;
        if (r4 == r5) goto L_0x0060;
    L_0x002d:
        r5 = 0;
        r2.write(r3, r5, r4);	 Catch:{ IOException -> 0x0032 }
        goto L_0x0024;
    L_0x0032:
        r1 = move-exception;
        r2 = "";
        com.misfit.ble.obfuscated.C4462b.m14831a(r1, r2);	 Catch:{ all -> 0x007a }
        r1 = new com.misfit.ble.obfuscated.bv$a;	 Catch:{ all -> 0x007a }
        r2 = 0;
        r3 = com.misfit.ble.shine.firmware.FirmwareAPIErrorCode.NETWORK_ERROR;	 Catch:{ all -> 0x007a }
        r1.<init>(r6, r2, r3);	 Catch:{ all -> 0x007a }
        r0.disconnect();
    L_0x0043:
        return r1;
    L_0x0044:
        r0 = move-exception;
        r1 = "";
        com.misfit.ble.obfuscated.C4462b.m14831a(r0, r1);
        r1 = new com.misfit.ble.obfuscated.bv$a;
        r0 = com.misfit.ble.shine.firmware.FirmwareAPIErrorCode.UNEXPECTED_RESPONSE;
        r1.<init>(r6, r2, r0);
        goto L_0x0043;
    L_0x0052:
        r0 = move-exception;
        r1 = "";
        com.misfit.ble.obfuscated.C4462b.m14831a(r0, r1);
        r1 = new com.misfit.ble.obfuscated.bv$a;
        r0 = com.misfit.ble.shine.firmware.FirmwareAPIErrorCode.NETWORK_ERROR;
        r1.<init>(r6, r2, r0);
        goto L_0x0043;
    L_0x0060:
        r2.flush();	 Catch:{ IOException -> 0x0032 }
        r1 = new com.misfit.ble.obfuscated.bv$a;	 Catch:{ IOException -> 0x0032 }
        r2 = r2.toByteArray();	 Catch:{ IOException -> 0x0032 }
        r3 = 0;
        r1.<init>(r6, r2, r3);	 Catch:{ IOException -> 0x0032 }
    L_0x006d:
        r0.disconnect();
        goto L_0x0043;
    L_0x0071:
        r1 = new com.misfit.ble.obfuscated.bv$a;	 Catch:{ IOException -> 0x0032 }
        r2 = 0;
        r3 = com.misfit.ble.shine.firmware.FirmwareAPIErrorCode.UNEXPECTED_RESPONSE;	 Catch:{ IOException -> 0x0032 }
        r1.<init>(r6, r2, r3);	 Catch:{ IOException -> 0x0032 }
        goto L_0x006d;
    L_0x007a:
        r1 = move-exception;
        r0.disconnect();
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.misfit.ble.obfuscated.bv.s(java.lang.String):com.misfit.ble.obfuscated.bv$a");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.misfit.ble.obfuscated.bv.C4504b m14967a(java.lang.String r6, android.os.Bundle r7) {
        /*
        r5 = this;
        r4 = 0;
        r0 = new android.net.Uri$Builder;
        r0.<init>();
        r1 = r0.encodedPath(r6);
        if (r7 == 0) goto L_0x0028;
    L_0x000c:
        r0 = r7.keySet();
        r2 = r0.iterator();
    L_0x0014:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x0028;
    L_0x001a:
        r0 = r2.next();
        r0 = (java.lang.String) r0;
        r3 = r7.getString(r0);
        r1.appendQueryParameter(r0, r3);
        goto L_0x0014;
    L_0x0028:
        r0 = r1.toString();
        r1 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x0064 }
        r1.<init>(r0);	 Catch:{ MalformedURLException -> 0x0064 }
        r0 = r1.openConnection();	 Catch:{ IOException -> 0x0072 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ IOException -> 0x0072 }
        r0.connect();	 Catch:{ IOException -> 0x0089, JSONException -> 0x00a4 }
        r1 = r0.getResponseCode();	 Catch:{ IOException -> 0x0089, JSONException -> 0x00a4 }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r1 != r2) goto L_0x009b;
    L_0x0042:
        r1 = r0.getInputStream();	 Catch:{ IOException -> 0x0089, JSONException -> 0x00a4 }
        r1 = m14968a(r1);	 Catch:{ IOException -> 0x0089, JSONException -> 0x00a4 }
        r2 = new org.json.JSONTokener;	 Catch:{ IOException -> 0x0089, JSONException -> 0x00a4 }
        r2.<init>(r1);	 Catch:{ IOException -> 0x0089, JSONException -> 0x00a4 }
        r1 = r2.nextValue();	 Catch:{ IOException -> 0x0089, JSONException -> 0x00a4 }
        r2 = r1 instanceof org.json.JSONObject;	 Catch:{ IOException -> 0x0089, JSONException -> 0x00a4 }
        if (r2 == 0) goto L_0x0080;
    L_0x0057:
        r2 = new com.misfit.ble.obfuscated.bv$b;	 Catch:{ IOException -> 0x0089, JSONException -> 0x00a4 }
        r1 = (org.json.JSONObject) r1;	 Catch:{ IOException -> 0x0089, JSONException -> 0x00a4 }
        r3 = 0;
        r2.<init>(r5, r1, r3);	 Catch:{ IOException -> 0x0089, JSONException -> 0x00a4 }
        r1 = r2;
    L_0x0060:
        r0.disconnect();
    L_0x0063:
        return r1;
    L_0x0064:
        r0 = move-exception;
        r1 = "";
        com.misfit.ble.obfuscated.C4462b.m14831a(r0, r1);
        r1 = new com.misfit.ble.obfuscated.bv$b;
        r0 = com.misfit.ble.shine.firmware.FirmwareAPIErrorCode.UNEXPECTED_RESPONSE;
        r1.<init>(r5, r4, r0);
        goto L_0x0063;
    L_0x0072:
        r0 = move-exception;
        r1 = "";
        com.misfit.ble.obfuscated.C4462b.m14831a(r0, r1);
        r1 = new com.misfit.ble.obfuscated.bv$b;
        r0 = com.misfit.ble.shine.firmware.FirmwareAPIErrorCode.NETWORK_ERROR;
        r1.<init>(r5, r4, r0);
        goto L_0x0063;
    L_0x0080:
        r1 = new com.misfit.ble.obfuscated.bv$b;	 Catch:{ IOException -> 0x0089, JSONException -> 0x00a4 }
        r2 = 0;
        r3 = com.misfit.ble.shine.firmware.FirmwareAPIErrorCode.UNEXPECTED_RESPONSE;	 Catch:{ IOException -> 0x0089, JSONException -> 0x00a4 }
        r1.<init>(r5, r2, r3);	 Catch:{ IOException -> 0x0089, JSONException -> 0x00a4 }
        goto L_0x0060;
    L_0x0089:
        r1 = move-exception;
        r2 = "";
        com.misfit.ble.obfuscated.C4462b.m14831a(r1, r2);	 Catch:{ all -> 0x00b6 }
        r1 = new com.misfit.ble.obfuscated.bv$b;	 Catch:{ all -> 0x00b6 }
        r2 = 0;
        r3 = com.misfit.ble.shine.firmware.FirmwareAPIErrorCode.NETWORK_ERROR;	 Catch:{ all -> 0x00b6 }
        r1.<init>(r5, r2, r3);	 Catch:{ all -> 0x00b6 }
        r0.disconnect();
        goto L_0x0063;
    L_0x009b:
        r1 = new com.misfit.ble.obfuscated.bv$b;	 Catch:{ IOException -> 0x0089, JSONException -> 0x00a4 }
        r2 = 0;
        r3 = com.misfit.ble.shine.firmware.FirmwareAPIErrorCode.UNEXPECTED_RESPONSE;	 Catch:{ IOException -> 0x0089, JSONException -> 0x00a4 }
        r1.<init>(r5, r2, r3);	 Catch:{ IOException -> 0x0089, JSONException -> 0x00a4 }
        goto L_0x0060;
    L_0x00a4:
        r1 = move-exception;
        r2 = "";
        com.misfit.ble.obfuscated.C4462b.m14831a(r1, r2);	 Catch:{ all -> 0x00b6 }
        r1 = new com.misfit.ble.obfuscated.bv$b;	 Catch:{ all -> 0x00b6 }
        r2 = 0;
        r3 = com.misfit.ble.shine.firmware.FirmwareAPIErrorCode.UNEXPECTED_RESPONSE;	 Catch:{ all -> 0x00b6 }
        r1.<init>(r5, r2, r3);	 Catch:{ all -> 0x00b6 }
        r0.disconnect();
        goto L_0x0063;
    L_0x00b6:
        r1 = move-exception;
        r0.disconnect();
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.misfit.ble.obfuscated.bv.a(java.lang.String, android.os.Bundle):com.misfit.ble.obfuscated.bv$b");
    }

    private static String m14968a(InputStream inputStream) throws IOException {
        Throwable th;
        BufferedInputStream bufferedInputStream = null;
        InputStreamReader inputStreamReader;
        try {
            InputStream bufferedInputStream2 = new BufferedInputStream(inputStream);
            try {
                inputStreamReader = new InputStreamReader(bufferedInputStream2);
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    char[] cArr = new char[2048];
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        if (read == -1) {
                            break;
                        }
                        stringBuilder.append(cArr, 0, read);
                    }
                    String stringBuilder2 = stringBuilder.toString();
                    if (js || bufferedInputStream2 != null) {
                        bufferedInputStream2.close();
                        if (js || inputStreamReader != null) {
                            inputStreamReader.close();
                            return stringBuilder2;
                        }
                        throw new AssertionError();
                    }
                    throw new AssertionError();
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = bufferedInputStream2;
                    if (!js) {
                    }
                    bufferedInputStream.close();
                    if (!js) {
                    }
                    inputStreamReader.close();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStreamReader = null;
                InputStream inputStream2 = bufferedInputStream2;
                if (js) {
                }
                bufferedInputStream.close();
                if (js) {
                }
                inputStreamReader.close();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStreamReader = null;
            if (js || bufferedInputStream != null) {
                bufferedInputStream.close();
                if (js || inputStreamReader != null) {
                    inputStreamReader.close();
                    throw th;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
    }
}
