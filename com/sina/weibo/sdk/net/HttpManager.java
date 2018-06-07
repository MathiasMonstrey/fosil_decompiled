package com.sina.weibo.sdk.net;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.facebook.internal.Utility;
import com.fossil.dtm;
import com.fossil.dtp;
import com.fossil.dtq;
import com.fossil.duj;
import com.fossil.dul;
import com.fossil.duq;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkConstants;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.exception.WeiboHttpException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class HttpManager {
    private static final String BOUNDARY = axt();
    private static final String dsr = ("--" + BOUNDARY);
    private static final String dss = ("--" + BOUNDARY + "--");
    private static SSLSocketFactory dst;

    class C50631 extends dtm {
        C50631() {
        }

        public boolean jW(String str) {
            return true;
        }

        public void axr() {
        }
    }

    private static native String calcOauthSignNative(Context context, String str, String str2);

    static {
        System.loadLibrary("weibosdkcore");
    }

    public static String m16078a(Context context, String str, String str2, dtq com_fossil_dtq) throws WeiboException {
        String a = m16080a(m16085b(context, str, str2, com_fossil_dtq));
        duj.d("HttpManager", "Response : " + a);
        return a;
    }

    private static HttpResponse m16085b(Context context, String str, String str2, dtq com_fossil_dtq) {
        OutputStream outputStream;
        Throwable e;
        HttpClient httpClient;
        ByteArrayOutputStream byteArrayOutputStream = null;
        HttpClient axs;
        try {
            axs = axs();
            try {
                HttpUriRequest httpGet;
                axs.getParams().setParameter("http.route.default-proxy", NetStateManager.axv());
                m16081a(context, com_fossil_dtq);
                if (str2.equals("GET")) {
                    String stringBuilder = new StringBuilder(String.valueOf(str)).append("?").append(com_fossil_dtq.axw()).toString();
                    httpGet = new HttpGet(stringBuilder);
                    duj.d("HttpManager", "requestHttpExecute GET Url : " + stringBuilder);
                } else if (str2.equals("POST")) {
                    duj.d("HttpManager", "requestHttpExecute POST Url : " + str);
                    HttpPost httpPost = new HttpPost(str);
                    OutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        Object obj;
                        if (com_fossil_dtq.axx()) {
                            httpPost.setHeader("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
                            m16082a(byteArrayOutputStream2, com_fossil_dtq);
                        } else {
                            obj = com_fossil_dtq.get("content-type");
                            if (obj == null || !(obj instanceof String)) {
                                httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
                            } else {
                                com_fossil_dtq.remove("content-type");
                                httpPost.setHeader("Content-Type", (String) obj);
                            }
                            String axw = com_fossil_dtq.axw();
                            duj.d("HttpManager", "requestHttpExecute POST postParam : " + axw);
                            byteArrayOutputStream2.write(axw.getBytes("UTF-8"));
                        }
                        httpPost.setEntity(new ByteArrayEntity(byteArrayOutputStream2.toByteArray()));
                        obj = httpPost;
                        outputStream = byteArrayOutputStream2;
                    } catch (IOException e2) {
                        e = e2;
                        outputStream = byteArrayOutputStream2;
                        httpClient = axs;
                        try {
                            e.printStackTrace();
                            throw new WeiboException(e);
                        } catch (Throwable th) {
                            e = th;
                            axs = httpClient;
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e3) {
                                }
                            }
                            m16083a(axs);
                            throw e;
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        outputStream = byteArrayOutputStream2;
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        m16083a(axs);
                        throw e;
                    }
                } else if (str2.equals("DELETE")) {
                    httpGet = new HttpDelete(str);
                } else {
                    httpGet = null;
                }
                HttpResponse execute = axs.execute(httpGet);
                int statusCode = execute.getStatusLine().getStatusCode();
                if (statusCode != MFNetworkReturnCode.RESPONSE_OK) {
                    throw new WeiboHttpException(m16080a(execute), statusCode);
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e4) {
                    }
                }
                m16083a(axs);
                return execute;
            } catch (IOException e5) {
                e = e5;
                httpClient = axs;
                e.printStackTrace();
                throw new WeiboException(e);
            } catch (Throwable th3) {
                e = th3;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                m16083a(axs);
                throw e;
            }
        } catch (IOException e6) {
            e = e6;
            Object obj2 = null;
            e.printStackTrace();
            throw new WeiboException(e);
        } catch (Throwable th4) {
            e = th4;
            axs = null;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            m16083a(axs);
            throw e;
        }
    }

    private static void m16081a(Context context, dtq com_fossil_dtq) {
        String str = "";
        if (!TextUtils.isEmpty(com_fossil_dtq.awy())) {
            str = duq.U(context, com_fossil_dtq.awy());
            if (!TextUtils.isEmpty(str)) {
                com_fossil_dtq.put("aid", str);
            }
        }
        String str2 = str;
        String timestamp = getTimestamp();
        com_fossil_dtq.put("oauth_timestamp", timestamp);
        String str3 = "";
        Object obj = com_fossil_dtq.get("access_token");
        Object obj2 = com_fossil_dtq.get(UpPlatformSdkConstants.UP_PLATFORM_REFRESH_TOKEN);
        Object obj3 = com_fossil_dtq.get("phone");
        str = (obj == null || !(obj instanceof String)) ? (obj2 == null || !(obj2 instanceof String)) ? (obj3 == null || !(obj3 instanceof String)) ? str3 : (String) obj3 : (String) obj2 : (String) obj;
        com_fossil_dtq.put("oauth_sign", m16084b(context, str2, str, com_fossil_dtq.awy(), timestamp));
    }

    public static void m16083a(HttpClient httpClient) {
        if (httpClient != null) {
            try {
                httpClient.getConnectionManager().closeExpiredConnections();
            } catch (Exception e) {
            }
        }
    }

    public static String m16086c(Context context, String str, String str2, dtq com_fossil_dtq) {
        Throwable th;
        Throwable th2;
        HttpClient httpClient = null;
        try {
            Object c50631 = new C50631();
            HttpClient httpClient2 = (DefaultHttpClient) axs();
            try {
                HttpUriRequest httpGet;
                httpClient2.setRedirectHandler(c50631);
                m16081a(context, com_fossil_dtq);
                httpClient2.getParams().setParameter("http.route.default-proxy", NetStateManager.axv());
                if (str2.equals("GET")) {
                    httpGet = new HttpGet(new StringBuilder(String.valueOf(str)).append("?").append(com_fossil_dtq.axw()).toString());
                } else if (str2.equals("POST")) {
                    httpGet = new HttpPost(str);
                }
                httpGet.setHeader("User-Agent", dul.df(context));
                httpClient2.execute(httpGet);
                String redirectUrl = c50631.getRedirectUrl();
                m16083a(httpClient2);
                return redirectUrl;
            } catch (Throwable e) {
                th = e;
                httpClient = httpClient2;
                th2 = th;
                try {
                    throw new WeiboException(th2);
                } catch (Throwable th3) {
                    th2 = th3;
                    m16083a(httpClient);
                    throw th2;
                }
            } catch (Throwable e2) {
                th = e2;
                httpClient = httpClient2;
                th2 = th;
                m16083a(httpClient);
                throw th2;
            }
        } catch (IOException e3) {
            th2 = e3;
            throw new WeiboException(th2);
        }
    }

    public static synchronized String m16079a(Context context, String str, String str2, String str3) throws WeiboException {
        String path;
        synchronized (HttpManager.class) {
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, str3);
            if (file2.exists()) {
                path = file2.getPath();
            } else if (URLUtil.isValidUrl(str)) {
                HttpClient axs = axs();
                long j = 0;
                File file3 = new File(str2, new StringBuilder(String.valueOf(str3)).append("_temp").toString());
                try {
                    long parseLong;
                    long j2;
                    InputStream content;
                    if (file3.exists()) {
                        j = file3.length();
                    } else {
                        file3.createNewFile();
                    }
                    HttpUriRequest httpGet = new HttpGet(str);
                    httpGet.setHeader("RANGE", "bytes=" + j + "-");
                    HttpResponse execute = axs.execute(httpGet);
                    int statusCode = execute.getStatusLine().getStatusCode();
                    if (statusCode == 206) {
                        Header[] headers = execute.getHeaders("Content-Range");
                        if (!(headers == null || headers.length == 0)) {
                            String value = headers[0].getValue();
                            parseLong = Long.parseLong(value.substring(value.indexOf(47) + 1));
                            j2 = j;
                        }
                        parseLong = 0;
                        j2 = j;
                    } else if (statusCode == MFNetworkReturnCode.RESPONSE_OK) {
                        j = 0;
                        Header firstHeader = execute.getFirstHeader("Content-Length");
                        if (firstHeader != null) {
                            parseLong = (long) Integer.valueOf(firstHeader.getValue()).intValue();
                            j2 = 0;
                        }
                        parseLong = 0;
                        j2 = j;
                    } else {
                        throw new WeiboHttpException(m16080a(execute), statusCode);
                    }
                    HttpEntity entity = execute.getEntity();
                    Header firstHeader2 = execute.getFirstHeader("Content-Encoding");
                    if (firstHeader2 == null || firstHeader2.getValue().toLowerCase().indexOf("gzip") <= -1) {
                        content = entity.getContent();
                    } else {
                        content = new GZIPInputStream(entity.getContent());
                    }
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
                    randomAccessFile.seek(j2);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = content.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        randomAccessFile.write(bArr, 0, read);
                    }
                    randomAccessFile.close();
                    content.close();
                    if (parseLong == 0 || file3.length() < parseLong) {
                        file3.delete();
                        if (axs != null) {
                            axs.getConnectionManager().closeExpiredConnections();
                            axs.getConnectionManager().closeIdleConnections(300, TimeUnit.SECONDS);
                        }
                        path = "";
                    } else {
                        file3.renameTo(file2);
                        path = file2.getPath();
                        if (axs != null) {
                            axs.getConnectionManager().closeExpiredConnections();
                            axs.getConnectionManager().closeIdleConnections(300, TimeUnit.SECONDS);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    file3.delete();
                    if (axs != null) {
                        axs.getConnectionManager().closeExpiredConnections();
                        axs.getConnectionManager().closeIdleConnections(300, TimeUnit.SECONDS);
                    }
                } catch (Throwable th) {
                    if (axs != null) {
                        axs.getConnectionManager().closeExpiredConnections();
                        axs.getConnectionManager().closeIdleConnections(300, TimeUnit.SECONDS);
                    }
                }
            } else {
                path = "";
            }
        }
        return path;
    }

    public static HttpClient axs() {
        try {
            HttpParams basicHttpParams = new BasicHttpParams();
            HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeRegistry.register(new Scheme(UpPlatformSdkConstants.URI_SCHEME, axu(), 443));
            ClientConnectionManager threadSafeClientConnManager = new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 25000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
            return new DefaultHttpClient(threadSafeClientConnManager, basicHttpParams);
        } catch (Exception e) {
            return new DefaultHttpClient();
        }
    }

    public static void m16082a(OutputStream outputStream, dtq com_fossil_dtq) throws WeiboException {
        try {
            StringBuilder stringBuilder;
            Set<String> keySet = com_fossil_dtq.keySet();
            for (String str : keySet) {
                if (com_fossil_dtq.get(str) instanceof String) {
                    stringBuilder = new StringBuilder(100);
                    stringBuilder.setLength(0);
                    stringBuilder.append(dsr).append("\r\n");
                    stringBuilder.append("content-disposition: form-data; name=\"").append(str).append("\"\r\n\r\n");
                    stringBuilder.append(com_fossil_dtq.get(str)).append("\r\n");
                    outputStream.write(stringBuilder.toString().getBytes());
                }
            }
            for (String str2 : keySet) {
                Object obj = com_fossil_dtq.get(str2);
                if (obj instanceof Bitmap) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(dsr).append("\r\n");
                    stringBuilder.append("content-disposition: form-data; name=\"").append(str2).append("\"; filename=\"file\"\r\n");
                    stringBuilder.append("Content-Type: application/octet-stream; charset=utf-8\r\n\r\n");
                    outputStream.write(stringBuilder.toString().getBytes());
                    Bitmap bitmap = (Bitmap) obj;
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                    outputStream.write(byteArrayOutputStream.toByteArray());
                    outputStream.write("\r\n".getBytes());
                } else if (obj instanceof ByteArrayOutputStream) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(dsr).append("\r\n");
                    stringBuilder.append("content-disposition: form-data; name=\"").append(str2).append("\"; filename=\"file\"\r\n");
                    stringBuilder.append("Content-Type: application/octet-stream; charset=utf-8\r\n\r\n");
                    outputStream.write(stringBuilder.toString().getBytes());
                    ByteArrayOutputStream byteArrayOutputStream2 = (ByteArrayOutputStream) obj;
                    outputStream.write(byteArrayOutputStream2.toByteArray());
                    outputStream.write("\r\n".getBytes());
                    byteArrayOutputStream2.close();
                }
            }
            outputStream.write(("\r\n" + dss).getBytes());
        } catch (Throwable e) {
            throw new WeiboException(e);
        }
    }

    public static String m16080a(HttpResponse httpResponse) throws WeiboException {
        Throwable e;
        Throwable th;
        String str = null;
        if (httpResponse != null) {
            HttpEntity entity = httpResponse.getEntity();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            InputStream content;
            try {
                content = entity.getContent();
                try {
                    Header firstHeader = httpResponse.getFirstHeader("Content-Encoding");
                    if (firstHeader != null && firstHeader.getValue().toLowerCase().indexOf("gzip") > -1) {
                        content = new GZIPInputStream(content);
                    }
                    byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
                    while (true) {
                        int read = content.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                    duj.d("HttpManager", "readRsponse result : " + str);
                    if (content != null) {
                        try {
                            content.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                }
            } catch (Throwable e4) {
                th = e4;
                content = null;
                e = th;
                try {
                    throw new WeiboException(e);
                } catch (Throwable th2) {
                    e = th2;
                    if (content != null) {
                        try {
                            content.close();
                        } catch (IOException e222) {
                            e222.printStackTrace();
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e2222) {
                            e2222.printStackTrace();
                        }
                    }
                    throw e;
                }
            } catch (Throwable e42) {
                th = e42;
                content = null;
                e = th;
                if (content != null) {
                    content.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw e;
            }
        }
        return str;
    }

    public static String axt() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i < 12; i++) {
            long currentTimeMillis = System.currentTimeMillis() + ((long) i);
            if (currentTimeMillis % 3 == 0) {
                stringBuffer.append(((char) ((int) currentTimeMillis)) % 9);
            } else if (currentTimeMillis % 3 == 1) {
                stringBuffer.append((char) ((int) ((currentTimeMillis % 26) + 65)));
            } else {
                stringBuffer.append((char) ((int) ((currentTimeMillis % 26) + 97)));
            }
        }
        return stringBuffer.toString();
    }

    private static SSLSocketFactory axu() {
        if (dst == null) {
            try {
                KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
                instance.load(null, null);
                Certificate certificate = getCertificate("cacert_cn.cer");
                Certificate certificate2 = getCertificate("cacert_com.cer");
                instance.setCertificateEntry("cnca", certificate);
                instance.setCertificateEntry("comca", certificate2);
                dst = new dtp(instance);
                duj.d("HttpManager", "getSSLSocketFactory noraml !!!!!");
            } catch (Exception e) {
                e.printStackTrace();
                dst = SSLSocketFactory.getSocketFactory();
                duj.d("HttpManager", "getSSLSocketFactory error default !!!!!");
            }
        }
        return dst;
    }

    private static Certificate getCertificate(String str) throws CertificateException, IOException {
        CertificateFactory instance = CertificateFactory.getInstance("X.509");
        InputStream resourceAsStream = HttpManager.class.getResourceAsStream(str);
        try {
            Certificate generateCertificate = instance.generateCertificate(resourceAsStream);
            return generateCertificate;
        } finally {
            if (resourceAsStream != null) {
                resourceAsStream.close();
            }
        }
    }

    private static String getTimestamp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    private static String m16084b(Context context, String str, String str2, String str3, String str4) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            stringBuilder.append(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            stringBuilder.append(str3);
        }
        return calcOauthSignNative(context, stringBuilder.toString(), str4);
    }
}
