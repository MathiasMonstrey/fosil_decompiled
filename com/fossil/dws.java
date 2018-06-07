package com.fossil;

import com.fossil.dve.C3222a;
import com.fossil.dvl.C3232a;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

public final class dws {
    private final duz duR;
    private final Socket duT;
    private final eti dyA;
    private final etj dyk;
    private final duy dzn;
    private int dzo = 0;
    private int state = 0;

    abstract class C3271a implements etv {
        protected boolean closed;
        protected final etm dzp;
        final /* synthetic */ dws dzq;

        private C3271a(dws com_fossil_dws) {
            this.dzq = com_fossil_dws;
            this.dzp = new etm(this.dzq.dyk.aAf());
        }

        public etw aAf() {
            return this.dzp;
        }

        protected final void dA(boolean z) throws IOException {
            if (this.dzq.state != 5) {
                throw new IllegalStateException("state: " + this.dzq.state);
            }
            this.dzq.m10199a(this.dzp);
            this.dzq.state = 0;
            if (z && this.dzq.dzo == 1) {
                this.dzq.dzo = 0;
                dvp.dwA.mo2696a(this.dzq.duR, this.dzq.dzn);
            } else if (this.dzq.dzo == 2) {
                this.dzq.state = 6;
                this.dzq.dzn.getSocket().close();
            }
        }

        protected final void aAS() {
            dvw.m9969a(this.dzq.dzn.getSocket());
            this.dzq.state = 6;
        }
    }

    final class C3272b implements etu {
        private boolean closed;
        private final etm dzp;
        final /* synthetic */ dws dzq;

        private C3272b(dws com_fossil_dws) {
            this.dzq = com_fossil_dws;
            this.dzp = new etm(this.dzq.dyA.aAf());
        }

        public etw aAf() {
            return this.dzp;
        }

        public void mo2728a(eth com_fossil_eth, long j) throws IOException {
            if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (j != 0) {
                this.dzq.dyA.bj(j);
                this.dzq.dyA.mI("\r\n");
                this.dzq.dyA.mo2728a(com_fossil_eth, j);
                this.dzq.dyA.mI("\r\n");
            }
        }

        public synchronized void flush() throws IOException {
            if (!this.closed) {
                this.dzq.dyA.flush();
            }
        }

        public synchronized void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                this.dzq.dyA.mI("0\r\n\r\n");
                this.dzq.m10199a(this.dzp);
                this.dzq.state = 3;
            }
        }
    }

    class C3273c extends C3271a {
        private final dwu dzl;
        final /* synthetic */ dws dzq;
        private long dzr = -1;
        private boolean dzs = true;

        C3273c(dws com_fossil_dws, dwu com_fossil_dwu) throws IOException {
            this.dzq = com_fossil_dws;
            super();
            this.dzl = com_fossil_dwu;
        }

        public long mo2733b(eth com_fossil_eth, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (!this.dzs) {
                return -1;
            } else {
                if (this.dzr == 0 || this.dzr == -1) {
                    aAT();
                    if (!this.dzs) {
                        return -1;
                    }
                }
                long b = this.dzq.dyk.mo2733b(com_fossil_eth, Math.min(j, this.dzr));
                if (b == -1) {
                    aAS();
                    throw new ProtocolException("unexpected end of stream");
                }
                this.dzr -= b;
                return b;
            }
        }

        private void aAT() throws IOException {
            if (this.dzr != -1) {
                this.dzq.dyk.aHp();
            }
            try {
                this.dzr = this.dzq.dyk.aHn();
                String trim = this.dzq.dyk.aHp().trim();
                if (this.dzr < 0 || !(trim.isEmpty() || trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.dzr + trim + "\"");
                } else if (this.dzr == 0) {
                    this.dzs = false;
                    C3222a c3222a = new C3222a();
                    this.dzq.m10209b(c3222a);
                    this.dzl.m10229c(c3222a.ayO());
                    dA(true);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (this.dzs && !dvw.m9970a((etv) this, 100, TimeUnit.MILLISECONDS)) {
                    aAS();
                }
                this.closed = true;
            }
        }
    }

    final class C3274d implements etu {
        private boolean closed;
        private final etm dzp;
        final /* synthetic */ dws dzq;
        private long dzt;

        private C3274d(dws com_fossil_dws, long j) {
            this.dzq = com_fossil_dws;
            this.dzp = new etm(this.dzq.dyA.aAf());
            this.dzt = j;
        }

        public etw aAf() {
            return this.dzp;
        }

        public void mo2728a(eth com_fossil_eth, long j) throws IOException {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            dvw.m9973b(com_fossil_eth.size(), 0, j);
            if (j > this.dzt) {
                throw new ProtocolException("expected " + this.dzt + " bytes but received " + j);
            }
            this.dzq.dyA.mo2728a(com_fossil_eth, j);
            this.dzt -= j;
        }

        public void flush() throws IOException {
            if (!this.closed) {
                this.dzq.dyA.flush();
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                if (this.dzt > 0) {
                    throw new ProtocolException("unexpected end of stream");
                }
                this.dzq.m10199a(this.dzp);
                this.dzq.state = 3;
            }
        }
    }

    class C3275e extends C3271a {
        final /* synthetic */ dws dzq;
        private long dzt;

        public C3275e(dws com_fossil_dws, long j) throws IOException {
            this.dzq = com_fossil_dws;
            super();
            this.dzt = j;
            if (this.dzt == 0) {
                dA(true);
            }
        }

        public long mo2733b(eth com_fossil_eth, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (this.dzt == 0) {
                return -1;
            } else {
                long b = this.dzq.dyk.mo2733b(com_fossil_eth, Math.min(this.dzt, j));
                if (b == -1) {
                    aAS();
                    throw new ProtocolException("unexpected end of stream");
                }
                this.dzt -= b;
                if (this.dzt == 0) {
                    dA(true);
                }
                return b;
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (!(this.dzt == 0 || dvw.m9970a((etv) this, 100, TimeUnit.MILLISECONDS))) {
                    aAS();
                }
                this.closed = true;
            }
        }
    }

    class C3276f extends C3271a {
        final /* synthetic */ dws dzq;
        private boolean dzu;

        private C3276f(dws com_fossil_dws) {
            this.dzq = com_fossil_dws;
            super();
        }

        public long mo2733b(eth com_fossil_eth, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (this.dzu) {
                return -1;
            } else {
                long b = this.dzq.dyk.mo2733b(com_fossil_eth, j);
                if (b != -1) {
                    return b;
                }
                this.dzu = true;
                dA(false);
                return -1;
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (!this.dzu) {
                    aAS();
                }
                this.closed = true;
            }
        }
    }

    public dws(duz com_fossil_duz, duy com_fossil_duy, Socket socket) throws IOException {
        this.duR = com_fossil_duz;
        this.dzn = com_fossil_duy;
        this.duT = socket;
        this.dyk = etp.m11180c(etp.m11181c(socket));
        this.dyA = etp.m11179c(etp.m11178b(socket));
    }

    public void cm(int i, int i2) {
        if (i != 0) {
            this.dyk.aAf().mo3063f((long) i, TimeUnit.MILLISECONDS);
        }
        if (i2 != 0) {
            this.dyA.aAf().mo3063f((long) i2, TimeUnit.MILLISECONDS);
        }
    }

    public void aAM() {
        this.dzo = 1;
        if (this.state == 0) {
            this.dzo = 0;
            dvp.dwA.mo2696a(this.duR, this.dzn);
        }
    }

    public void aAN() throws IOException {
        this.dzo = 2;
        if (this.state == 0) {
            this.state = 6;
            this.dzn.getSocket().close();
        }
    }

    public boolean isClosed() {
        return this.state == 6;
    }

    public void flush() throws IOException {
        this.dyA.flush();
    }

    public long aAO() {
        return this.dyk.aHe().size();
    }

    public boolean isReadable() {
        int soTimeout;
        try {
            soTimeout = this.duT.getSoTimeout();
            this.duT.setSoTimeout(1);
            if (this.dyk.aHi()) {
                this.duT.setSoTimeout(soTimeout);
                return false;
            }
            this.duT.setSoTimeout(soTimeout);
            return true;
        } catch (SocketTimeoutException e) {
            return true;
        } catch (IOException e2) {
            return false;
        } catch (Throwable th) {
            this.duT.setSoTimeout(soTimeout);
        }
    }

    public void m10206a(dve com_fossil_dve, String str) throws IOException {
        if (this.state != 0) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.dyA.mI(str).mI("\r\n");
        int size = com_fossil_dve.size();
        for (int i = 0; i < size; i++) {
            this.dyA.mI(com_fossil_dve.my(i)).mI(": ").mI(com_fossil_dve.mz(i)).mI("\r\n");
        }
        this.dyA.mI("\r\n");
        this.state = 1;
    }

    public C3232a aAP() throws IOException {
        if (this.state == 1 || this.state == 3) {
            C3232a kN;
            dxc kV;
            do {
                try {
                    kV = dxc.kV(this.dyk.aHp());
                    kN = new C3232a().m9924b(kV.duW).mB(kV.drk).kN(kV.message);
                    C3222a c3222a = new C3222a();
                    m10209b(c3222a);
                    c3222a.aU(dwx.dzT, kV.duW.toString());
                    kN.m9923b(c3222a.ayO());
                } catch (Throwable e) {
                    IOException iOException = new IOException("unexpected end of stream on " + this.dzn + " (recycle count=" + dvp.dwA.mo2705e(this.dzn) + ")");
                    iOException.initCause(e);
                    throw iOException;
                }
            } while (kV.drk == 100);
            this.state = 4;
            return kN;
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public void m10209b(C3222a c3222a) throws IOException {
        while (true) {
            String aHp = this.dyk.aHp();
            if (aHp.length() != 0) {
                dvp.dwA.mo2698a(c3222a, aHp);
            } else {
                return;
            }
        }
    }

    public etu aAQ() {
        if (this.state != 1) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.state = 2;
        return new C3272b();
    }

    public etu aN(long j) {
        if (this.state != 1) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.state = 2;
        return new C3274d(j);
    }

    public void m10207a(dxa com_fossil_dxa) throws IOException {
        if (this.state != 1) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.state = 3;
        com_fossil_dxa.m10249a(this.dyA);
    }

    public etv aO(long j) throws IOException {
        if (this.state != 4) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.state = 5;
        return new C3275e(this, j);
    }

    public etv m10208b(dwu com_fossil_dwu) throws IOException {
        if (this.state != 4) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.state = 5;
        return new C3273c(this, com_fossil_dwu);
    }

    public etv aAR() throws IOException {
        if (this.state != 4) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.state = 5;
        return new C3276f();
    }

    private void m10199a(etm com_fossil_etm) {
        etw aHu = com_fossil_etm.aHu();
        com_fossil_etm.m11166a(etw.dTD);
        aHu.aHz();
        aHu.aHy();
    }
}
