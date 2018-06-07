package com.flurry.sdk;

import com.fossil.apg;
import com.fossil.app;
import com.fossil.apw;
import com.fossil.aqv;
import com.fossil.aqy;
import com.fossil.wearables.fsl.fitness.FitnessProviderImpl;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map.Entry;

public class kw extends aqy {
    public static final String aWX = kw.class.getSimpleName();
    public boolean aXT = true;
    public long aXW = -1;
    public boolean aYq;
    public String aYv;
    public boolean aZh;
    private boolean bbA;
    public long bbB = -1;
    public Exception bbC;
    public int bbD = -1;
    public int bbE = 25000;
    private apw bbF = new apw(this);
    public boolean bbG;
    private final Object bbo = new Object();
    private final apg<String, String> bbv = new apg();
    public final apg<String, String> bbw = new apg();
    public C1540a bbx;
    public C1541b bby;
    private HttpURLConnection bbz;
    private int f1343c;
    private int f1344d;
    public int f1345i = FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL;
    public int f1346j = 15000;
    private boolean f1347w;

    class C15381 extends Thread {
        final /* synthetic */ kw bbH;

        C15381(kw kwVar) {
            this.bbH = kwVar;
        }

        public final void run() {
            try {
                if (this.bbH.bbz != null) {
                    this.bbH.bbz.disconnect();
                }
            } catch (Throwable th) {
            }
        }
    }

    public enum C1540a {
        kUnknown,
        kGet,
        kPost,
        kPut,
        kDelete,
        kHead;

        public final String toString() {
            switch (this) {
                case kPost:
                    return "POST";
                case kPut:
                    return "PUT";
                case kDelete:
                    return "DELETE";
                case kHead:
                    return "HEAD";
                case kGet:
                    return "GET";
                default:
                    return null;
            }
        }
    }

    public interface C1541b {
        void mo1119a(kw kwVar);

        void mo1120a(kw kwVar, InputStream inputStream) throws Exception;

        void mo1121e(OutputStream outputStream) throws Exception;
    }

    public final void m2786w(String str, String str2) {
        this.bbv.m4164n(str, str2);
    }

    public final boolean Ie() {
        return !m2785c() && IY();
    }

    public final boolean m2785c() {
        return this.bbC != null;
    }

    public final boolean IY() {
        return this.bbD >= MFNetworkReturnCode.RESPONSE_OK && this.bbD < MFNetworkReturnCode.BAD_REQUEST && !this.bbG;
    }

    public final List<String> cm(String str) {
        return this.bbw.bH(str);
    }

    public final void HK() {
        if (this.bby != null && !IZ()) {
            this.bby.mo1119a(this);
        }
    }

    public final void HW() {
        app.m4180g(3, aWX, "Cancelling http request: " + this.aYv);
        synchronized (this.bbo) {
            this.bbA = true;
        }
        if (!this.f1347w) {
            this.f1347w = true;
            if (this.bbz != null) {
                new C15381(this).start();
            }
        }
    }

    public final boolean IZ() {
        boolean z;
        synchronized (this.bbo) {
            z = this.bbA;
        }
        return z;
    }

    public void HJ() {
        try {
            if (this.aYv != null) {
                if (jo.ID().aXI) {
                    if (this.bbx == null || C1540a.kUnknown.equals(this.bbx)) {
                        this.bbx = C1540a.kGet;
                    }
                    HP();
                    app.m4180g(4, aWX, "HTTP status: " + this.bbD + " for url: " + this.aYv);
                    this.bbF.HJ();
                    HK();
                    return;
                }
                app.m4180g(3, aWX, "Network not available, aborting http request: " + this.aYv);
                this.bbF.HJ();
                HK();
            }
        } catch (Throwable e) {
            app.m4180g(4, aWX, "HTTP status: " + this.bbD + " for url: " + this.aYv);
            app.m4174b(3, aWX, "Exception during http request: " + this.aYv, e);
            if (this.bbz != null) {
                this.f1344d = this.bbz.getReadTimeout();
                this.f1343c = this.bbz.getConnectTimeout();
            }
            this.bbC = e;
        } finally {
            this.bbF.HJ();
            HK();
        }
    }

    private void HP() throws Exception {
        Throwable th;
        Closeable closeable = null;
        if (!this.bbA) {
            this.aYv = aqv.m4251a(this.aYv);
            this.bbz = (HttpURLConnection) new URL(this.aYv).openConnection();
            this.bbz.setConnectTimeout(this.f1345i);
            this.bbz.setReadTimeout(this.f1346j);
            this.bbz.setRequestMethod(this.bbx.toString());
            this.bbz.setInstanceFollowRedirects(this.aXT);
            this.bbz.setDoOutput(C1540a.kPost.equals(this.bbx));
            this.bbz.setDoInput(true);
            for (Entry entry : this.bbv.IU()) {
                this.bbz.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            if (!(C1540a.kGet.equals(this.bbx) || C1540a.kPost.equals(this.bbx))) {
                this.bbz.setRequestProperty("Accept-Encoding", "");
            }
            if (this.bbA) {
                HQ();
                return;
            }
            Closeable outputStream;
            Closeable bufferedOutputStream;
            if (C1540a.kPost.equals(this.bbx)) {
                try {
                    outputStream = this.bbz.getOutputStream();
                    try {
                        bufferedOutputStream = new BufferedOutputStream(outputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedOutputStream = null;
                        closeable = outputStream;
                        aqv.m4252a(bufferedOutputStream);
                        aqv.m4252a(closeable);
                        throw th;
                    }
                    try {
                        if (!(this.bby == null || IZ())) {
                            this.bby.mo1121e(bufferedOutputStream);
                        }
                        aqv.m4252a(bufferedOutputStream);
                        aqv.m4252a(outputStream);
                    } catch (Throwable th3) {
                        th = th3;
                        closeable = outputStream;
                        aqv.m4252a(bufferedOutputStream);
                        aqv.m4252a(closeable);
                        throw th;
                    }
                } catch (Throwable th4) {
                    HQ();
                }
            }
            if (this.aYq) {
                this.aXW = System.currentTimeMillis();
            }
            if (this.aZh) {
                this.bbF.m4198a((long) this.bbE);
            }
            this.bbD = this.bbz.getResponseCode();
            if (this.aYq && this.aXW != -1) {
                this.bbB = System.currentTimeMillis() - this.aXW;
            }
            this.bbF.HJ();
            for (Entry entry2 : this.bbz.getHeaderFields().entrySet()) {
                for (String n : (List) entry2.getValue()) {
                    this.bbw.m4164n(entry2.getKey(), n);
                }
            }
            if (!C1540a.kGet.equals(this.bbx) && !C1540a.kPost.equals(this.bbx)) {
                HQ();
            } else if (this.bbA) {
                HQ();
            } else {
                try {
                    bufferedOutputStream = this.bbz.getInputStream();
                    try {
                        outputStream = new BufferedInputStream(bufferedOutputStream);
                        try {
                            if (!(this.bby == null || IZ())) {
                                this.bby.mo1120a(this, outputStream);
                            }
                            aqv.m4252a(outputStream);
                            aqv.m4252a(bufferedOutputStream);
                            HQ();
                        } catch (Throwable th5) {
                            th = th5;
                            closeable = bufferedOutputStream;
                            bufferedOutputStream = outputStream;
                            aqv.m4252a(bufferedOutputStream);
                            aqv.m4252a(closeable);
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        Closeable closeable2 = bufferedOutputStream;
                        bufferedOutputStream = null;
                        closeable = closeable2;
                        aqv.m4252a(bufferedOutputStream);
                        aqv.m4252a(closeable);
                        throw th;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    bufferedOutputStream = null;
                    aqv.m4252a(bufferedOutputStream);
                    aqv.m4252a(closeable);
                    throw th;
                }
            }
        }
    }

    private void HQ() {
        if (!this.f1347w) {
            this.f1347w = true;
            if (this.bbz != null) {
                this.bbz.disconnect();
            }
        }
    }

    public final void HN() {
        HW();
    }
}
