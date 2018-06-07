package com.fossil;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

public class uv implements us<InputStream> {
    private static final C4138b aBh = new C4139a();
    private final wh aBi;
    private final C4138b aBj;
    private HttpURLConnection aBk;
    private volatile boolean isCancelled;
    private InputStream stream;

    interface C4138b {
        HttpURLConnection mo4193a(URL url) throws IOException;
    }

    static class C4139a implements C4138b {
        private C4139a() {
        }

        public HttpURLConnection mo4193a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    public /* synthetic */ Object mo4186d(Priority priority) throws Exception {
        return m13851e(priority);
    }

    public uv(wh whVar) {
        this(whVar, aBh);
    }

    uv(wh whVar, C4138b c4138b) {
        this.aBi = whVar;
        this.aBj = c4138b;
    }

    public InputStream m13851e(Priority priority) throws Exception {
        return m13849a(this.aBi.toURL(), 0, null, this.aBi.getHeaders());
    }

    private InputStream m13849a(URL url, int i, URL url2, Map<String, String> map) throws IOException {
        if (i >= 5) {
            throw new IOException("Too many (> 5) redirects!");
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new IOException("In re-direct loop");
                }
            } catch (URISyntaxException e) {
            }
        }
        this.aBk = this.aBj.mo4193a(url);
        for (Entry entry : map.entrySet()) {
            this.aBk.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        this.aBk.setConnectTimeout(2500);
        this.aBk.setReadTimeout(2500);
        this.aBk.setUseCaches(false);
        this.aBk.setDoInput(true);
        this.aBk.connect();
        if (this.isCancelled) {
            return null;
        }
        int responseCode = this.aBk.getResponseCode();
        if (responseCode / 100 == 2) {
            return m13848a(this.aBk);
        }
        if (responseCode / 100 == 3) {
            Object headerField = this.aBk.getHeaderField("Location");
            if (!TextUtils.isEmpty(headerField)) {
                return m13849a(new URL(url, headerField), i + 1, url, map);
            }
            throw new IOException("Received empty or null redirect url");
        } else if (responseCode == -1) {
            throw new IOException("Unable to retrieve response code from HttpUrlConnection.");
        } else {
            throw new IOException("Request failed " + responseCode + ": " + this.aBk.getResponseMessage());
        }
    }

    private InputStream m13848a(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.stream = abf.a(httpURLConnection.getInputStream(), (long) httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            this.stream = httpURLConnection.getInputStream();
        }
        return this.stream;
    }

    public void lG() {
        if (this.stream != null) {
            try {
                this.stream.close();
            } catch (IOException e) {
            }
        }
        if (this.aBk != null) {
            this.aBk.disconnect();
        }
    }

    public String getId() {
        return this.aBi.vt();
    }

    public void cancel() {
        this.isCancelled = true;
    }
}
