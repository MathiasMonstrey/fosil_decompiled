package com.fossil;

import android.content.Context;
import com.facebook.internal.ServerProtocol;
import com.fossil.wearables.fsl.fitness.FitnessProviderImpl;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.portfolio.platform.data.model.PinObject;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

class ebo {
    private static eaq dCK = ebb.aCr();
    private static ebo dDl = null;
    private static Context dDm = null;
    DefaultHttpClient dDi = null;
    eav dDj = null;
    StringBuilder dDk = new StringBuilder(4096);
    private long f1512g = 0;

    private ebo(Context context) {
        try {
            dDm = context.getApplicationContext();
            this.f1512g = System.currentTimeMillis() / 1000;
            this.dDj = new eav();
            if (dze.aBG()) {
                try {
                    Logger.getLogger("org.apache.http.wire").setLevel(Level.FINER);
                    Logger.getLogger("org.apache.http.headers").setLevel(Level.FINER);
                    System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
                    System.setProperty("org.apache.commons.logging.simplelog.showdatetime", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                    System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire", "debug");
                    System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "debug");
                    System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.headers", "debug");
                } catch (Throwable th) {
                }
            }
            HttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, false);
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL);
            HttpConnectionParams.setSoTimeout(basicHttpParams, FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL);
            this.dDi = new DefaultHttpClient(basicHttpParams);
            this.dDi.setKeepAliveStrategy(new ebp(this));
        } catch (Throwable th2) {
            dCK.m10419g(th2);
        }
    }

    static void m10457a(Context context) {
        dDm = context.getApplicationContext();
    }

    static Context aCs() {
        return dDm;
    }

    static ebo ei(Context context) {
        if (dDl == null) {
            synchronized (ebo.class) {
                if (dDl == null) {
                    dDl = new ebo(context);
                }
            }
        }
        return dDl;
    }

    private void m10458f(JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("mid");
            if (dxw.cn(optString)) {
                if (dze.aBG()) {
                    dCK.cY("update mid:" + optString);
                }
                dxv.dk(dDm).cg(optString);
            }
            if (!jSONObject.isNull("cfg")) {
                dze.m10342a(dDm, jSONObject.getJSONObject("cfg"));
            }
            if (!jSONObject.isNull("ncts")) {
                int i = jSONObject.getInt("ncts");
                int currentTimeMillis = (int) (((long) i) - (System.currentTimeMillis() / 1000));
                if (dze.aBG()) {
                    dCK.cY("server time:" + i + ", diff time:" + currentTimeMillis);
                }
                ebb.dZ(dDm);
                ebb.m10434K(dDm, currentTimeMillis);
            }
        } catch (Throwable th) {
            dCK.cZ(th);
        }
    }

    void m10459a(dzm com_fossil_dzm, ebn com_fossil_ebn) {
        m10461b(Arrays.asList(new String[]{com_fossil_dzm.Iw()}), com_fossil_ebn);
    }

    void m10460a(List<?> list, ebn com_fossil_ebn) {
        int i = 0;
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            list.get(0);
            Throwable th;
            try {
                String str;
                this.dDk.delete(0, this.dDk.length());
                this.dDk.append("[");
                String str2 = "rc4";
                for (int i2 = 0; i2 < size; i2++) {
                    this.dDk.append(list.get(i2).toString());
                    if (i2 != size - 1) {
                        this.dDk.append(",");
                    }
                }
                this.dDk.append("]");
                String stringBuilder = this.dDk.toString();
                size = stringBuilder.length();
                String str3 = dze.aBR() + "/?index=" + this.f1512g;
                this.f1512g++;
                if (dze.aBG()) {
                    dCK.cY("[" + str3 + "]Send request(" + size + "bytes), content:" + stringBuilder);
                }
                HttpPost httpPost = new HttpPost(str3);
                httpPost.addHeader("Accept-Encoding", "gzip");
                httpPost.setHeader("Connection", "Keep-Alive");
                httpPost.removeHeaders("Cache-Control");
                HttpHost aCh = dzi.dx(dDm).aCh();
                httpPost.addHeader("Content-Encoding", str2);
                if (aCh == null) {
                    this.dDi.getParams().removeParameter("http.route.default-proxy");
                } else {
                    if (dze.aBG()) {
                        dCK.db("proxy:" + aCh.toHostString());
                    }
                    httpPost.addHeader("X-Content-Encoding", str2);
                    this.dDi.getParams().setParameter("http.route.default-proxy", aCh);
                    httpPost.addHeader("X-Online-Host", dze.aWJ);
                    httpPost.addHeader("Accept", "*/*");
                    httpPost.addHeader("Content-Type", PinObject.COLUMN_JSON_DATA);
                }
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream(size);
                byte[] bytes = stringBuilder.getBytes("UTF-8");
                int length = bytes.length;
                if (size > dze.aZe) {
                    i = 1;
                }
                if (i != 0) {
                    httpPost.removeHeaders("Content-Encoding");
                    str = str2 + ",gzip";
                    httpPost.addHeader("Content-Encoding", str);
                    if (aCh != null) {
                        httpPost.removeHeaders("X-Content-Encoding");
                        httpPost.addHeader("X-Content-Encoding", str);
                    }
                    byteArrayOutputStream.write(new byte[4]);
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    gZIPOutputStream.write(bytes);
                    gZIPOutputStream.close();
                    bytes = byteArrayOutputStream.toByteArray();
                    ByteBuffer.wrap(bytes, 0, 4).putInt(length);
                    if (dze.aBG()) {
                        dCK.db("before Gzip:" + length + " bytes, after Gzip:" + bytes.length + " bytes");
                    }
                }
                httpPost.setEntity(new ByteArrayEntity(eaw.at(bytes)));
                HttpResponse execute = this.dDi.execute(httpPost);
                HttpEntity entity = execute.getEntity();
                size = execute.getStatusLine().getStatusCode();
                long contentLength = entity.getContentLength();
                if (dze.aBG()) {
                    dCK.cY("http recv response status code:" + size + ", content length:" + contentLength);
                }
                if (contentLength <= 0) {
                    dCK.da("Server response no data.");
                    if (com_fossil_ebn != null) {
                        com_fossil_ebn.HO();
                    }
                    EntityUtils.toString(entity);
                    return;
                }
                if (contentLength > 0) {
                    InputStream content = entity.getContent();
                    DataInputStream dataInputStream = new DataInputStream(content);
                    bytes = new byte[((int) entity.getContentLength())];
                    dataInputStream.readFully(bytes);
                    content.close();
                    dataInputStream.close();
                    Header firstHeader = execute.getFirstHeader("Content-Encoding");
                    if (firstHeader != null) {
                        if (firstHeader.getValue().equalsIgnoreCase("gzip,rc4")) {
                            bytes = eaw.m10425b(ebb.at(bytes));
                        } else if (firstHeader.getValue().equalsIgnoreCase("rc4,gzip")) {
                            bytes = ebb.at(eaw.m10425b(bytes));
                        } else if (firstHeader.getValue().equalsIgnoreCase("gzip")) {
                            bytes = ebb.at(bytes);
                        } else if (firstHeader.getValue().equalsIgnoreCase("rc4")) {
                            bytes = eaw.m10425b(bytes);
                        }
                    }
                    str = new String(bytes, "UTF-8");
                    if (dze.aBG()) {
                        dCK.cY("http get response data:" + str);
                    }
                    JSONObject jSONObject = new JSONObject(str);
                    if (size == MFNetworkReturnCode.RESPONSE_OK) {
                        m10458f(jSONObject);
                        if (com_fossil_ebn != null) {
                            if (jSONObject.optInt("ret") == 0) {
                                com_fossil_ebn.HJ();
                            } else {
                                dCK.error("response error data.");
                                com_fossil_ebn.HO();
                            }
                        }
                    } else {
                        dCK.error("Server response error code:" + size + ", error:" + new String(bytes, "UTF-8"));
                        if (com_fossil_ebn != null) {
                            com_fossil_ebn.HO();
                        }
                    }
                    content.close();
                } else {
                    EntityUtils.toString(entity);
                }
                byteArrayOutputStream.close();
                th = null;
                if (th != null) {
                    dCK.m10418f(th);
                    if (com_fossil_ebn != null) {
                        try {
                            com_fossil_ebn.HO();
                        } catch (Throwable th2) {
                            dCK.m10419g(th2);
                        }
                    }
                    if (th instanceof OutOfMemoryError) {
                        System.gc();
                        this.dDk = null;
                        this.dDk = new StringBuilder(2048);
                    }
                    dzi.dx(dDm).m10368d();
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    void m10461b(List<?> list, ebn com_fossil_ebn) {
        if (this.dDj != null) {
            this.dDj.m10423a(new ebq(this, list, com_fossil_ebn));
        }
    }
}
