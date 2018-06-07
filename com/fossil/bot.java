package com.fossil;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Map.Entry;
import org.joda.time.DateTimeConstants;

final class bot implements Runnable {
    private final String bhE;
    private final URL bzL;
    private final byte[] bzM;
    private final bor bzN;
    private final Map<String, String> bzO;
    private /* synthetic */ bop bzP;

    public bot(bop com_fossil_bop, String str, URL url, byte[] bArr, Map<String, String> map, bor com_fossil_bor) {
        this.bzP = com_fossil_bop;
        awa.df(str);
        awa.bO(url);
        awa.bO(com_fossil_bor);
        this.bzL = url;
        this.bzM = bArr;
        this.bzN = com_fossil_bor;
        this.bhE = str;
        this.bzO = map;
    }

    public final void run() {
        HttpURLConnection httpURLConnection;
        OutputStream outputStream;
        Throwable e;
        Map map;
        int i;
        HttpURLConnection httpURLConnection2;
        OutputStream outputStream2;
        Throwable th;
        Map map2;
        int i2 = 0;
        this.bzP.OO();
        try {
            URLConnection openConnection = this.bzL.openConnection();
            if (openConnection instanceof HttpURLConnection) {
                httpURLConnection = (HttpURLConnection) openConnection;
                httpURLConnection.setDefaultUseCaches(false);
                bnm.Qc();
                httpURLConnection.setConnectTimeout(DateTimeConstants.MILLIS_PER_MINUTE);
                bnm.Qd();
                httpURLConnection.setReadTimeout(61000);
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setDoInput(true);
                try {
                    if (this.bzO != null) {
                        for (Entry entry : this.bzO.entrySet()) {
                            httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        }
                    }
                    if (this.bzM != null) {
                        byte[] ai = this.bzP.Pb().ai(this.bzM);
                        this.bzP.Pf().Ri().m5439d("Uploading data. size", Integer.valueOf(ai.length));
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.addRequestProperty("Content-Encoding", "gzip");
                        httpURLConnection.setFixedLengthStreamingMode(ai.length);
                        httpURLConnection.connect();
                        outputStream = httpURLConnection.getOutputStream();
                        try {
                            outputStream.write(ai);
                            outputStream.close();
                        } catch (IOException e2) {
                            e = e2;
                            map = null;
                            i = 0;
                            OutputStream outputStream3 = outputStream;
                            httpURLConnection2 = httpURLConnection;
                            outputStream2 = outputStream3;
                            if (outputStream2 != null) {
                                try {
                                    outputStream2.close();
                                } catch (IOException e3) {
                                    this.bzP.Pf().Rc().m5437a("Error closing HTTP compressed POST connection output stream. appId", bol.ei(this.bhE), e3);
                                }
                            }
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            this.bzP.Pe().m5469h(new bos(this.bhE, this.bzN, i, e, null, map));
                        } catch (Throwable th2) {
                            th = th2;
                            map2 = null;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e4) {
                                    this.bzP.Pf().Rc().m5437a("Error closing HTTP compressed POST connection output stream. appId", bol.ei(this.bhE), e4);
                                }
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            this.bzP.Pe().m5469h(new bos(this.bhE, this.bzN, i2, null, null, map2));
                            throw th;
                        }
                    }
                    i2 = httpURLConnection.getResponseCode();
                    map2 = httpURLConnection.getHeaderFields();
                } catch (IOException e5) {
                    e = e5;
                    map = null;
                    i = i2;
                    httpURLConnection2 = httpURLConnection;
                    outputStream2 = null;
                    if (outputStream2 != null) {
                        outputStream2.close();
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    this.bzP.Pe().m5469h(new bos(this.bhE, this.bzN, i, e, null, map));
                } catch (Throwable th3) {
                    th = th3;
                    map2 = null;
                    outputStream = null;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    this.bzP.Pe().m5469h(new bos(this.bhE, this.bzN, i2, null, null, map2));
                    throw th;
                }
                try {
                    byte[] a = bop.m5442b(httpURLConnection);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    this.bzP.Pe().m5469h(new bos(this.bhE, this.bzN, i2, null, a, map2));
                    return;
                } catch (IOException e6) {
                    e = e6;
                    map = map2;
                    i = i2;
                    httpURLConnection2 = httpURLConnection;
                    outputStream2 = null;
                    if (outputStream2 != null) {
                        outputStream2.close();
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    this.bzP.Pe().m5469h(new bos(this.bhE, this.bzN, i, e, null, map));
                } catch (Throwable th32) {
                    th = th32;
                    outputStream = null;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    this.bzP.Pe().m5469h(new bos(this.bhE, this.bzN, i2, null, null, map2));
                    throw th;
                }
            }
            throw new IOException("Failed to obtain HTTP connection");
        } catch (IOException e7) {
            e = e7;
            map = null;
            i = 0;
            outputStream2 = null;
            httpURLConnection2 = null;
            if (outputStream2 != null) {
                outputStream2.close();
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            this.bzP.Pe().m5469h(new bos(this.bhE, this.bzN, i, e, null, map));
        } catch (Throwable th4) {
            th = th4;
            map2 = null;
            outputStream = null;
            httpURLConnection = null;
            if (outputStream != null) {
                outputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            this.bzP.Pe().m5469h(new bos(this.bhE, this.bzN, i2, null, null, map2));
            throw th;
        }
    }
}
