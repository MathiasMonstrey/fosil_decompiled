package com.fossil;

import com.fossil.dvg.C3213a;
import com.fossil.dvj.C3227a;
import com.squareup.okhttp.internal.http.RequestException;
import com.squareup.okhttp.internal.http.RouteException;
import java.io.IOException;
import java.net.ProtocolException;

public class duv {
    private final dvi client;
    private boolean duG;
    volatile boolean duH;
    dvj duI;
    dwu duJ;

    class C3214a implements C3213a {
        private final dvj duK;
        private final boolean duL;
        final /* synthetic */ duv duM;
        private final int index;

        C3214a(duv com_fossil_duv, int i, dvj com_fossil_dvj, boolean z) {
            this.duM = com_fossil_duv;
            this.index = i;
            this.duK = com_fossil_dvj;
            this.duL = z;
        }

        public dvl mo2693a(dvj com_fossil_dvj) throws IOException {
            if (this.index >= this.duM.client.azm().size()) {
                return this.duM.m9800a(com_fossil_dvj, this.duL);
            }
            return ((dvg) this.duM.client.azm().get(this.index)).m9866a(new C3214a(this.duM, this.index + 1, com_fossil_dvj, this.duL));
        }
    }

    protected duv(dvi com_fossil_dvi, dvj com_fossil_dvj) {
        this.client = com_fossil_dvi.azo();
        this.duI = com_fossil_dvj;
    }

    public dvl ayt() throws IOException {
        synchronized (this) {
            if (this.duG) {
                throw new IllegalStateException("Already Executed");
            }
            this.duG = true;
        }
        try {
            this.client.azl().m9837b(this);
            dvl dw = dw(false);
            if (dw != null) {
                return dw;
            }
            throw new IOException("Canceled");
        } finally {
            this.client.azl().m9838c(this);
        }
    }

    private dvl dw(boolean z) throws IOException {
        return new C3214a(this, 0, this.duI, z).mo2693a(this.duI);
    }

    dvl m9800a(dvj com_fossil_dvj, boolean z) throws IOException {
        dvj azx;
        dwu a;
        dvk azu = com_fossil_dvj.azu();
        if (azu != null) {
            C3227a azv = com_fossil_dvj.azv();
            dvh contentType = azu.contentType();
            if (contentType != null) {
                azv.aY("Content-Type", contentType.toString());
            }
            long contentLength = azu.contentLength();
            if (contentLength != -1) {
                azv.aY("Content-Length", Long.toString(contentLength));
                azv.kM("Transfer-Encoding");
            } else {
                azv.aY("Transfer-Encoding", "chunked");
                azv.kM("Content-Length");
            }
            azx = azv.azx();
        } else {
            azx = com_fossil_dvj;
        }
        this.duJ = new dwu(this.client, azx, false, false, z, null, null, null, null);
        int i = 0;
        while (!this.duH) {
            try {
                this.duJ.aAV();
                this.duJ.aBe();
                dvl aBa = this.duJ.aBa();
                azx = this.duJ.aBg();
                if (azx == null) {
                    if (!z) {
                        this.duJ.releaseConnection();
                    }
                    return aBa;
                }
                int i2 = i + 1;
                if (i2 > 20) {
                    throw new ProtocolException("Too many follow-up requests: " + i2);
                }
                if (!this.duJ.m10230f(azx.azq())) {
                    this.duJ.releaseConnection();
                }
                this.duJ = new dwu(this.client, azx, false, false, z, this.duJ.aBd(), null, null, aBa);
                i = i2;
            } catch (RequestException e) {
                throw e.getCause();
            } catch (RouteException e2) {
                a = this.duJ.m10227a(e2);
                if (a != null) {
                    this.duJ = a;
                } else {
                    throw e2.getLastConnectException();
                }
            } catch (IOException e3) {
                a = this.duJ.m10228a(e3, null);
                if (a != null) {
                    this.duJ = a;
                } else {
                    throw e3;
                }
            }
        }
        this.duJ.releaseConnection();
        throw new IOException("Canceled");
    }
}
