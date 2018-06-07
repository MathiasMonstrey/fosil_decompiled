package io.fabric.sdk.android.services.network;

import com.facebook.internal.Utility;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.zip.GZIPInputStream;

public class HttpRequest {
    private static final String[] Gi = new String[0];
    private static C5089b dPq = C5089b.dPB;
    private int bufferSize = Utility.DEFAULT_STREAM_BUFFER_SIZE;
    private HttpURLConnection connection = null;
    private C5091d dPr;
    private boolean dPs;
    private boolean dPt = true;
    private boolean dPu = false;
    private String dPv;
    private int dPw;
    private final String requestMethod;
    public final URL url;

    public static abstract class C5086c<V> implements Callable<V> {
        protected abstract void done() throws IOException;

        protected abstract V run() throws HttpRequestException, IOException;

        protected C5086c() {
        }

        public V call() throws HttpRequestException {
            Throwable th;
            Object obj = 1;
            try {
                V run = run();
                try {
                    done();
                    return run;
                } catch (IOException e) {
                    throw new HttpRequestException(e);
                }
            } catch (HttpRequestException e2) {
                throw e2;
            } catch (IOException e3) {
                throw new HttpRequestException(e3);
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                done();
            } catch (IOException e4) {
                if (obj == null) {
                    throw new HttpRequestException(e4);
                }
            }
            throw th;
        }
    }

    public static abstract class C5087a<V> extends C5086c<V> {
        private final Closeable dPA;
        private final boolean dPt;

        protected C5087a(Closeable closeable, boolean z) {
            this.dPA = closeable;
            this.dPt = z;
        }

        protected void done() throws IOException {
            if (this.dPA instanceof Flushable) {
                ((Flushable) this.dPA).flush();
            }
            if (this.dPt) {
                try {
                    this.dPA.close();
                    return;
                } catch (IOException e) {
                    return;
                }
            }
            this.dPA.close();
        }
    }

    public static class HttpRequestException extends RuntimeException {
        private static final long serialVersionUID = -1170466989781746231L;

        protected HttpRequestException(IOException iOException) {
            super(iOException);
        }

        public IOException getCause() {
            return (IOException) super.getCause();
        }
    }

    public interface C5089b {
        public static final C5089b dPB = new C50901();

        static class C50901 implements C5089b {
            C50901() {
            }

            public HttpURLConnection mo5442c(URL url) throws IOException {
                return (HttpURLConnection) url.openConnection();
            }

            public HttpURLConnection mo5441a(URL url, Proxy proxy) throws IOException {
                return (HttpURLConnection) url.openConnection(proxy);
            }
        }

        HttpURLConnection mo5441a(URL url, Proxy proxy) throws IOException;

        HttpURLConnection mo5442c(URL url) throws IOException;
    }

    public static class C5091d extends BufferedOutputStream {
        private final CharsetEncoder dPC;

        public C5091d(OutputStream outputStream, String str, int i) {
            super(outputStream, i);
            this.dPC = Charset.forName(HttpRequest.mv(str)).newEncoder();
        }

        public C5091d mA(String str) throws IOException {
            ByteBuffer encode = this.dPC.encode(CharBuffer.wrap(str));
            super.write(encode.array(), 0, encode.limit());
            return this;
        }
    }

    private static String mv(String str) {
        return (str == null || str.length() <= 0) ? "UTF-8" : str;
    }

    private static StringBuilder m16311b(String str, StringBuilder stringBuilder) {
        if (str.indexOf(58) + 2 == str.lastIndexOf(47)) {
            stringBuilder.append('/');
        }
        return stringBuilder;
    }

    private static StringBuilder m16312c(String str, StringBuilder stringBuilder) {
        int indexOf = str.indexOf(63);
        int length = stringBuilder.length() - 1;
        if (indexOf == -1) {
            stringBuilder.append('?');
        } else if (indexOf < length && str.charAt(length) != '&') {
            stringBuilder.append('&');
        }
        return stringBuilder;
    }

    public static String m16302E(CharSequence charSequence) throws HttpRequestException {
        try {
            URL url = new URL(charSequence.toString());
            String host = url.getHost();
            int port = url.getPort();
            if (port != -1) {
                host = host + ':' + Integer.toString(port);
            }
            try {
                String toASCIIString = new URI(url.getProtocol(), host, url.getPath(), url.getQuery(), null).toASCIIString();
                int indexOf = toASCIIString.indexOf(63);
                if (indexOf > 0 && indexOf + 1 < toASCIIString.length()) {
                    toASCIIString = toASCIIString.substring(0, indexOf + 1) + toASCIIString.substring(indexOf + 1).replace("+", "%2B");
                }
                return toASCIIString;
            } catch (Throwable e) {
                IOException iOException = new IOException("Parsing URI failed");
                iOException.initCause(e);
                throw new HttpRequestException(iOException);
            }
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public static String m16309a(CharSequence charSequence, Map<?, ?> map) {
        String charSequence2 = charSequence.toString();
        if (map == null || map.isEmpty()) {
            return charSequence2;
        }
        StringBuilder stringBuilder = new StringBuilder(charSequence2);
        m16311b(charSequence2, stringBuilder);
        m16312c(charSequence2, stringBuilder);
        Iterator it = map.entrySet().iterator();
        Entry entry = (Entry) it.next();
        stringBuilder.append(entry.getKey().toString());
        stringBuilder.append('=');
        Object value = entry.getValue();
        if (value != null) {
            stringBuilder.append(value);
        }
        while (it.hasNext()) {
            stringBuilder.append('&');
            entry = (Entry) it.next();
            stringBuilder.append(entry.getKey().toString());
            stringBuilder.append('=');
            value = entry.getValue();
            if (value != null) {
                stringBuilder.append(value);
            }
        }
        return stringBuilder.toString();
    }

    public static HttpRequest m16303F(CharSequence charSequence) throws HttpRequestException {
        return new HttpRequest(charSequence, "GET");
    }

    public static HttpRequest m16308a(CharSequence charSequence, Map<?, ?> map, boolean z) {
        CharSequence a = m16309a(charSequence, (Map) map);
        if (z) {
            a = m16302E(a);
        }
        return m16303F(a);
    }

    public static HttpRequest m16304G(CharSequence charSequence) throws HttpRequestException {
        return new HttpRequest(charSequence, "POST");
    }

    public static HttpRequest m16310b(CharSequence charSequence, Map<?, ?> map, boolean z) {
        CharSequence a = m16309a(charSequence, (Map) map);
        if (z) {
            a = m16302E(a);
        }
        return m16304G(a);
    }

    public static HttpRequest m16305H(CharSequence charSequence) throws HttpRequestException {
        return new HttpRequest(charSequence, "PUT");
    }

    public static HttpRequest m16306I(CharSequence charSequence) throws HttpRequestException {
        return new HttpRequest(charSequence, "DELETE");
    }

    public HttpRequest(CharSequence charSequence, String str) throws HttpRequestException {
        try {
            this.url = new URL(charSequence.toString());
            this.requestMethod = str;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    private Proxy aGf() {
        return new Proxy(Type.HTTP, new InetSocketAddress(this.dPv, this.dPw));
    }

    private HttpURLConnection aGg() {
        try {
            HttpURLConnection a;
            if (this.dPv != null) {
                a = dPq.mo5441a(this.url, aGf());
            } else {
                a = dPq.mo5442c(this.url);
            }
            a.setRequestMethod(this.requestMethod);
            return a;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public String toString() {
        return azs() + ' ' + ayP();
    }

    public HttpURLConnection getConnection() {
        if (this.connection == null) {
            this.connection = aGg();
        }
        return this.connection;
    }

    public int azA() throws HttpRequestException {
        try {
            aGp();
            return getConnection().getResponseCode();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public boolean aGh() throws HttpRequestException {
        return MFNetworkReturnCode.RESPONSE_OK == azA();
    }

    protected ByteArrayOutputStream aGi() {
        int aGo = aGo();
        if (aGo > 0) {
            return new ByteArrayOutputStream(aGo);
        }
        return new ByteArrayOutputStream();
    }

    public String mw(String str) throws HttpRequestException {
        OutputStream aGi = aGi();
        try {
            m16320c(aGk(), aGi);
            return aGi.toString(mv(str));
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public String aGj() throws HttpRequestException {
        return mw(aGm());
    }

    public BufferedInputStream aGk() throws HttpRequestException {
        return new BufferedInputStream(aGl(), this.bufferSize);
    }

    public InputStream aGl() throws HttpRequestException {
        if (azA() < MFNetworkReturnCode.BAD_REQUEST) {
            try {
                InputStream inputStream = getConnection().getInputStream();
            } catch (IOException e) {
                throw new HttpRequestException(e);
            }
        }
        inputStream = getConnection().getErrorStream();
        if (inputStream == null) {
            try {
                inputStream = getConnection().getInputStream();
            } catch (IOException e2) {
                throw new HttpRequestException(e2);
            }
        }
        if (!this.dPu || !"gzip".equals(aGn())) {
            return inputStream;
        }
        try {
            return new GZIPInputStream(inputStream);
        } catch (IOException e22) {
            throw new HttpRequestException(e22);
        }
    }

    public HttpRequest pk(int i) {
        getConnection().setConnectTimeout(i);
        return this;
    }

    public HttpRequest bm(String str, String str2) {
        getConnection().setRequestProperty(str, str2);
        return this;
    }

    public HttpRequest m16321h(Entry<String, String> entry) {
        return bm((String) entry.getKey(), (String) entry.getValue());
    }

    public String kK(String str) throws HttpRequestException {
        aGq();
        return getConnection().getHeaderField(str);
    }

    public int mx(String str) throws HttpRequestException {
        return m16314P(str, -1);
    }

    public int m16314P(String str, int i) throws HttpRequestException {
        aGq();
        return getConnection().getHeaderFieldInt(str, i);
    }

    public String bn(String str, String str2) {
        return bo(kK(str), str2);
    }

    protected String bo(String str, String str2) {
        if (str == null || str.length() == 0) {
            return null;
        }
        int length = str.length();
        int indexOf = str.indexOf(59) + 1;
        if (indexOf == 0 || indexOf == length) {
            return null;
        }
        int indexOf2 = str.indexOf(59, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = indexOf;
            indexOf = length;
        } else {
            int i = indexOf2;
            indexOf2 = indexOf;
            indexOf = i;
        }
        while (indexOf2 < indexOf) {
            int indexOf3 = str.indexOf(61, indexOf2);
            if (indexOf3 != -1 && indexOf3 < indexOf && str2.equals(str.substring(indexOf2, indexOf3).trim())) {
                String trim = str.substring(indexOf3 + 1, indexOf).trim();
                indexOf3 = trim.length();
                if (indexOf3 != 0) {
                    if (indexOf3 > 2 && '\"' == trim.charAt(0) && '\"' == trim.charAt(indexOf3 - 1)) {
                        return trim.substring(1, indexOf3 - 1);
                    }
                    return trim;
                }
            }
            indexOf++;
            indexOf2 = str.indexOf(59, indexOf);
            if (indexOf2 == -1) {
                indexOf2 = length;
            }
            i = indexOf2;
            indexOf2 = indexOf;
            indexOf = i;
        }
        return null;
    }

    public String aGm() {
        return bn("Content-Type", "charset");
    }

    public HttpRequest dK(boolean z) {
        getConnection().setUseCaches(z);
        return this;
    }

    public String aGn() {
        return kK("Content-Encoding");
    }

    public HttpRequest my(String str) {
        return bp(str, null);
    }

    public HttpRequest bp(String str, String str2) {
        if (str2 == null || str2.length() <= 0) {
            return bm("Content-Type", str);
        }
        String str3 = "; charset=";
        return bm("Content-Type", str + "; charset=" + str2);
    }

    public int aGo() {
        return mx("Content-Length");
    }

    protected HttpRequest m16320c(InputStream inputStream, OutputStream outputStream) throws IOException {
        final InputStream inputStream2 = inputStream;
        final OutputStream outputStream2 = outputStream;
        return (HttpRequest) new C5087a<HttpRequest>(this, inputStream, this.dPt) {
            final /* synthetic */ HttpRequest dPz;

            public /* synthetic */ Object run() throws HttpRequestException, IOException {
                return aGt();
            }

            public HttpRequest aGt() throws IOException {
                byte[] bArr = new byte[this.dPz.bufferSize];
                while (true) {
                    int read = inputStream2.read(bArr);
                    if (read == -1) {
                        return this.dPz;
                    }
                    outputStream2.write(bArr, 0, read);
                }
            }
        }.call();
    }

    protected HttpRequest aGp() throws IOException {
        if (this.dPr != null) {
            if (this.dPs) {
                this.dPr.mA("\r\n--00content0boundary00--\r\n");
            }
            if (this.dPt) {
                try {
                    this.dPr.close();
                } catch (IOException e) {
                }
            } else {
                this.dPr.close();
            }
            this.dPr = null;
        }
        return this;
    }

    protected HttpRequest aGq() throws HttpRequestException {
        try {
            return aGp();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    protected HttpRequest aGr() throws IOException {
        if (this.dPr == null) {
            getConnection().setDoOutput(true);
            this.dPr = new C5091d(getConnection().getOutputStream(), bo(getConnection().getRequestProperty("Content-Type"), "charset"), this.bufferSize);
        }
        return this;
    }

    protected HttpRequest aGs() throws IOException {
        if (this.dPs) {
            this.dPr.mA("\r\n--00content0boundary00\r\n");
        } else {
            this.dPs = true;
            my("multipart/form-data; boundary=00content0boundary00").aGr();
            this.dPr.mA("--00content0boundary00\r\n");
        }
        return this;
    }

    protected HttpRequest m16322p(String str, String str2, String str3) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("form-data; name=\"").append(str);
        if (str2 != null) {
            stringBuilder.append("\"; filename=\"").append(str2);
        }
        stringBuilder.append('\"');
        br("Content-Disposition", stringBuilder.toString());
        if (str3 != null) {
            br("Content-Type", str3);
        }
        return m16313J("\r\n");
    }

    public HttpRequest bq(String str, String str2) {
        return m16323q(str, null, str2);
    }

    public HttpRequest m16323q(String str, String str2, String str3) throws HttpRequestException {
        return m16319a(str, str2, null, str3);
    }

    public HttpRequest m16319a(String str, String str2, String str3, String str4) throws HttpRequestException {
        try {
            aGs();
            m16322p(str, str2, str3);
            this.dPr.mA(str4);
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest m16315a(String str, Number number) throws HttpRequestException {
        return m16316a(str, null, number);
    }

    public HttpRequest m16316a(String str, String str2, Number number) throws HttpRequestException {
        return m16323q(str, str2, number != null ? number.toString() : null);
    }

    public HttpRequest m16317a(String str, String str2, String str3, File file) throws HttpRequestException {
        InputStream bufferedInputStream;
        IOException e;
        Throwable th;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                HttpRequest a = m16318a(str, str2, str3, bufferedInputStream);
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e2) {
                    }
                }
                return a;
            } catch (IOException e3) {
                e = e3;
                try {
                    throw new HttpRequestException(e);
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            e = e5;
            bufferedInputStream = null;
            throw new HttpRequestException(e);
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw th;
        }
    }

    public HttpRequest m16318a(String str, String str2, String str3, InputStream inputStream) throws HttpRequestException {
        try {
            aGs();
            m16322p(str, str2, str3);
            m16320c(inputStream, this.dPr);
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest br(String str, String str2) throws HttpRequestException {
        return m16313J(str).m16313J(": ").m16313J(str2).m16313J("\r\n");
    }

    public HttpRequest m16313J(CharSequence charSequence) throws HttpRequestException {
        try {
            aGr();
            this.dPr.mA(charSequence.toString());
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public URL ayP() {
        return getConnection().getURL();
    }

    public String azs() {
        return getConnection().getRequestMethod();
    }
}
