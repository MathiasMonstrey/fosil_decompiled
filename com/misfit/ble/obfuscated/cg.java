package com.misfit.ble.obfuscated;

import com.fossil.wearables.fsl.fitness.FitnessProviderImpl;
import com.misfit.ble.shine.log.LogManager;
import com.misfit.ble.util.LogUtils;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

public class cg {
    private static final String TAG = LogUtils.m15475b(cg.class);
    int kC = 0;
    String kD;
    File kE;
    String kw;

    public class C4515a {
        public String kF;
        public int kG = -1;
        public String kH;
        private int kI = -1;
        final /* synthetic */ cg kJ;

        public C4515a(cg cgVar) {
            this.kJ = cgVar;
        }

        public boolean bP() {
            return this.kG == MFNetworkReturnCode.RESPONSE_OK;
        }

        public boolean bQ() {
            return this.kG == MFNetworkReturnCode.BAD_REQUEST;
        }

        public String toString() {
            return "PostTaskResult{mFilename='" + this.kF + '\'' + ", mResponseMessage='" + this.kH + '\'' + ", mResponseCode=" + this.kG + ", mErrorCode=" + this.kI + '}';
        }

        public int getErrorCode() {
            try {
                this.kI = new JSONObject(this.kH).getInt("error");
            } catch (Throwable e) {
                C4462b.m14831a(e, "");
            }
            return this.kI;
        }
    }

    public cg(String str, String str2, File file) {
        this.kD = str;
        this.kw = str2;
        this.kE = file;
    }

    public C4515a bN() {
        C4515a bO;
        do {
            bO = bO();
            if (bO.bP()) {
                break;
            }
            this.kC--;
        } while (this.kC > 0);
        return bO;
    }

    private C4515a bO() {
        String e;
        Throwable th;
        Throwable th2;
        HttpsURLConnection httpsURLConnection = null;
        String name = this.kE.getName();
        C4515a c4515a = new C4515a(this);
        c4515a.kF = name;
        try {
            HttpsURLConnection httpsURLConnection2;
            String str = this.kw;
            String e2 = hd.m15182e(this.kE);
            e = C4589k.m15217e(e2);
            if (e != null) {
                e2 = e;
            }
            e2 = LogManager.bA().m15452g(name, e2);
            if (e2 != null) {
                byte[] bytes = e2.getBytes("UTF-8");
                httpsURLConnection2 = (HttpsURLConnection) new URL(this.kD).openConnection();
                try {
                    InputStream inputStream;
                    String b;
                    httpsURLConnection2.setRequestMethod("POST");
                    httpsURLConnection2.setRequestProperty("Content-Type", "application/json");
                    httpsURLConnection2.setRequestProperty("Content-Encoding", "gzip");
                    httpsURLConnection2.setRequestProperty("access_key_id", str);
                    httpsURLConnection2.setConnectTimeout(FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL);
                    httpsURLConnection2.setReadTimeout(15000);
                    httpsURLConnection2.setDoOutput(true);
                    httpsURLConnection2.setChunkedStreamingMode(0);
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(httpsURLConnection2.getOutputStream());
                    gZIPOutputStream.write(bytes);
                    gZIPOutputStream.flush();
                    gZIPOutputStream.close();
                    c4515a.kG = httpsURLConnection2.getResponseCode();
                    if (c4515a.kG == MFNetworkReturnCode.RESPONSE_OK) {
                        inputStream = httpsURLConnection2.getInputStream();
                    } else {
                        inputStream = httpsURLConnection2.getErrorStream();
                    }
                    if (inputStream != null) {
                        b = m15013b(inputStream);
                    }
                    c4515a.kH = b;
                } catch (Throwable e3) {
                    th = e3;
                    httpsURLConnection = httpsURLConnection2;
                    th2 = th;
                    try {
                        LogUtils.m15477e(TAG, th2.toString());
                        C4462b.m14831a(th2, "");
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        return c4515a;
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        throw th2;
                    }
                } catch (Throwable e32) {
                    th = e32;
                    httpsURLConnection = httpsURLConnection2;
                    th2 = th;
                    LogUtils.m15477e(TAG, th2.toString());
                    C4462b.m14831a(th2, "");
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    return c4515a;
                } catch (Throwable e322) {
                    th = e322;
                    httpsURLConnection = httpsURLConnection2;
                    th2 = th;
                    LogUtils.m15477e(TAG, th2.toString());
                    C4462b.m14831a(th2, "");
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    return c4515a;
                } catch (Throwable e3222) {
                    th = e3222;
                    httpsURLConnection = httpsURLConnection2;
                    th2 = th;
                    e = th2.toString();
                    LogUtils.m15477e(TAG, e);
                    C4462b.m14831a(th2, "");
                    if (e != null && e.contains("authentication challenge")) {
                        c4515a.kG = 401;
                    }
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    return c4515a;
                } catch (Throwable e32222) {
                    th = e32222;
                    httpsURLConnection = httpsURLConnection2;
                    th2 = th;
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    throw th2;
                }
            }
            httpsURLConnection2 = null;
            if (httpsURLConnection2 != null) {
                httpsURLConnection2.disconnect();
            }
        } catch (MalformedURLException e4) {
            th2 = e4;
            LogUtils.m15477e(TAG, th2.toString());
            C4462b.m14831a(th2, "");
            if (httpsURLConnection != null) {
                httpsURLConnection.disconnect();
            }
            return c4515a;
        } catch (UnsupportedEncodingException e5) {
            th2 = e5;
            LogUtils.m15477e(TAG, th2.toString());
            C4462b.m14831a(th2, "");
            if (httpsURLConnection != null) {
                httpsURLConnection.disconnect();
            }
            return c4515a;
        } catch (SecurityException e6) {
            th2 = e6;
            LogUtils.m15477e(TAG, th2.toString());
            C4462b.m14831a(th2, "");
            if (httpsURLConnection != null) {
                httpsURLConnection.disconnect();
            }
            return c4515a;
        } catch (IOException e7) {
            th2 = e7;
            e = th2.toString();
            LogUtils.m15477e(TAG, e);
            C4462b.m14831a(th2, "");
            c4515a.kG = 401;
            if (httpsURLConnection != null) {
                httpsURLConnection.disconnect();
            }
            return c4515a;
        }
        return c4515a;
    }

    private static String m15013b(InputStream inputStream) {
        BufferedReader bufferedReader;
        Throwable e;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuilder.append(readLine);
                } catch (IOException e2) {
                    e = e2;
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable e3) {
                    C4462b.m14831a(e3, "");
                }
            }
        } catch (IOException e4) {
            e3 = e4;
            bufferedReader = null;
            try {
                C4462b.m14831a(e3, "");
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable e32) {
                        C4462b.m14831a(e32, "");
                    }
                }
                return stringBuilder.toString();
            } catch (Throwable th) {
                e32 = th;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable e5) {
                        C4462b.m14831a(e5, "");
                    }
                }
                throw e32;
            }
        } catch (Throwable th2) {
            e32 = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw e32;
        }
        return stringBuilder.toString();
    }
}
