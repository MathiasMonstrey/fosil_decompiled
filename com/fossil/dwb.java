package com.fossil;

import com.facebook.internal.NativeProtocol;
import com.squareup.okhttp.internal.framed.ErrorCode;
import com.squareup.okhttp.internal.framed.HeadersMode;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

public final class dwb {
    static final /* synthetic */ boolean $assertionsDisabled = (!dwb.class.desiredAssertionStatus());
    private final dwa dxH;
    private final List<dwc> dxI;
    private List<dwc> dxJ;
    private final C3253b dxK;
    final C3252a dxL;
    private final C3254c dxM = new C3254c(this);
    private final C3254c dxN = new C3254c(this);
    private ErrorCode dxO = null;
    long dxj = 0;
    long dxk;
    private final int id;

    final class C3252a implements etu {
        static final /* synthetic */ boolean $assertionsDisabled = (!dwb.class.desiredAssertionStatus());
        private boolean closed;
        private final eth dxP = new eth();
        private boolean dxQ;
        final /* synthetic */ dwb dxR;

        C3252a(dwb com_fossil_dwb) {
            this.dxR = com_fossil_dwb;
        }

        public void mo2728a(eth com_fossil_eth, long j) throws IOException {
            if ($assertionsDisabled || !Thread.holdsLock(this.dxR)) {
                this.dxP.mo2728a(com_fossil_eth, j);
                while (this.dxP.size() >= 16384) {
                    dz(false);
                }
                return;
            }
            throw new AssertionError();
        }

        private void dz(boolean z) throws IOException {
            synchronized (this.dxR) {
                this.dxR.dxN.enter();
                while (this.dxR.dxk <= 0 && !this.dxQ && !this.closed && this.dxR.dxO == null) {
                    try {
                        this.dxR.aAe();
                    } catch (Throwable th) {
                        this.dxR.dxN.aAi();
                    }
                }
                this.dxR.dxN.aAi();
                this.dxR.aAd();
                long min = Math.min(this.dxR.dxk, this.dxP.size());
                dwb com_fossil_dwb = this.dxR;
                com_fossil_dwb.dxk -= min;
            }
            this.dxR.dxN.enter();
            try {
                dwa a = this.dxR.dxH;
                int b = this.dxR.id;
                boolean z2 = z && min == this.dxP.size();
                a.m10044a(b, z2, this.dxP, min);
            } finally {
                this.dxR.dxN.aAi();
            }
        }

        public void flush() throws IOException {
            if ($assertionsDisabled || !Thread.holdsLock(this.dxR)) {
                synchronized (this.dxR) {
                    this.dxR.aAd();
                }
                while (this.dxP.size() > 0) {
                    dz(false);
                    this.dxR.dxH.flush();
                }
                return;
            }
            throw new AssertionError();
        }

        public etw aAf() {
            return this.dxR.dxN;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() throws java.io.IOException {
            /*
            r6 = this;
            r4 = 0;
            r2 = 1;
            r0 = $assertionsDisabled;
            if (r0 != 0) goto L_0x0015;
        L_0x0007:
            r0 = r6.dxR;
            r0 = java.lang.Thread.holdsLock(r0);
            if (r0 == 0) goto L_0x0015;
        L_0x000f:
            r0 = new java.lang.AssertionError;
            r0.<init>();
            throw r0;
        L_0x0015:
            r1 = r6.dxR;
            monitor-enter(r1);
            r0 = r6.closed;	 Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x001e;
        L_0x001c:
            monitor-exit(r1);	 Catch:{ all -> 0x003f }
        L_0x001d:
            return;
        L_0x001e:
            monitor-exit(r1);	 Catch:{ all -> 0x003f }
            r0 = r6.dxR;
            r0 = r0.dxL;
            r0 = r0.dxQ;
            if (r0 != 0) goto L_0x0052;
        L_0x0027:
            r0 = r6.dxP;
            r0 = r0.size();
            r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
            if (r0 <= 0) goto L_0x0042;
        L_0x0031:
            r0 = r6.dxP;
            r0 = r0.size();
            r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
            if (r0 <= 0) goto L_0x0052;
        L_0x003b:
            r6.dz(r2);
            goto L_0x0031;
        L_0x003f:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x003f }
            throw r0;
        L_0x0042:
            r0 = r6.dxR;
            r0 = r0.dxH;
            r1 = r6.dxR;
            r1 = r1.id;
            r3 = 0;
            r0.m10044a(r1, r2, r3, r4);
        L_0x0052:
            r1 = r6.dxR;
            monitor-enter(r1);
            r0 = 1;
            r6.closed = r0;	 Catch:{ all -> 0x0068 }
            monitor-exit(r1);	 Catch:{ all -> 0x0068 }
            r0 = r6.dxR;
            r0 = r0.dxH;
            r0.flush();
            r0 = r6.dxR;
            r0.aAc();
            goto L_0x001d;
        L_0x0068:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0068 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fossil.dwb.a.close():void");
        }
    }

    final class C3253b implements etv {
        static final /* synthetic */ boolean $assertionsDisabled = (!dwb.class.desiredAssertionStatus());
        private boolean closed;
        private boolean dxQ;
        final /* synthetic */ dwb dxR;
        private final eth dxS;
        private final eth dxT;
        private final long dxU;

        private C3253b(dwb com_fossil_dwb, long j) {
            this.dxR = com_fossil_dwb;
            this.dxS = new eth();
            this.dxT = new eth();
            this.dxU = j;
        }

        public long mo2733b(eth com_fossil_eth, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            long j2;
            synchronized (this.dxR) {
                aAg();
                ua();
                if (this.dxT.size() == 0) {
                    j2 = -1;
                } else {
                    j2 = this.dxT.mo2733b(com_fossil_eth, Math.min(j, this.dxT.size()));
                    dwb com_fossil_dwb = this.dxR;
                    com_fossil_dwb.dxj += j2;
                    if (this.dxR.dxj >= ((long) (this.dxR.dxH.dxl.mR(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) / 2))) {
                        this.dxR.dxH.m10049l(this.dxR.id, this.dxR.dxj);
                        this.dxR.dxj = 0;
                    }
                    synchronized (this.dxR.dxH) {
                        dwa a = this.dxR.dxH;
                        a.dxj += j2;
                        if (this.dxR.dxH.dxj >= ((long) (this.dxR.dxH.dxl.mR(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) / 2))) {
                            this.dxR.dxH.m10049l(0, this.dxR.dxH.dxj);
                            this.dxR.dxH.dxj = 0;
                        }
                    }
                }
            }
            return j2;
        }

        private void aAg() throws IOException {
            this.dxR.dxM.enter();
            while (this.dxT.size() == 0 && !this.dxQ && !this.closed && this.dxR.dxO == null) {
                try {
                    this.dxR.aAe();
                } catch (Throwable th) {
                    this.dxR.dxM.aAi();
                }
            }
            this.dxR.dxM.aAi();
        }

        void m10059a(etj com_fossil_etj, long j) throws IOException {
            if ($assertionsDisabled || !Thread.holdsLock(this.dxR)) {
                while (j > 0) {
                    boolean z;
                    Object obj;
                    synchronized (this.dxR) {
                        z = this.dxQ;
                        obj = this.dxT.size() + j > this.dxU ? 1 : null;
                    }
                    if (obj != null) {
                        com_fossil_etj.bh(j);
                        this.dxR.m10081c(ErrorCode.FLOW_CONTROL_ERROR);
                        return;
                    } else if (z) {
                        com_fossil_etj.bh(j);
                        return;
                    } else {
                        long b = com_fossil_etj.mo2733b(this.dxS, j);
                        if (b == -1) {
                            throw new EOFException();
                        }
                        j -= b;
                        synchronized (this.dxR) {
                            if (this.dxT.size() == 0) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                            this.dxT.mo3040b(this.dxS);
                            if (obj != null) {
                                this.dxR.notifyAll();
                            }
                        }
                    }
                }
                return;
            }
            throw new AssertionError();
        }

        public etw aAf() {
            return this.dxR.dxM;
        }

        public void close() throws IOException {
            synchronized (this.dxR) {
                this.closed = true;
                this.dxT.clear();
                this.dxR.notifyAll();
            }
            this.dxR.aAc();
        }

        private void ua() throws IOException {
            if (this.closed) {
                throw new IOException("stream closed");
            } else if (this.dxR.dxO != null) {
                throw new IOException("stream was reset: " + this.dxR.dxO);
            }
        }
    }

    class C3254c extends etf {
        final /* synthetic */ dwb dxR;

        C3254c(dwb com_fossil_dwb) {
            this.dxR = com_fossil_dwb;
        }

        protected void aAh() {
            this.dxR.m10081c(ErrorCode.CANCEL);
        }

        protected IOException mo2736c(IOException iOException) {
            IOException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public void aAi() throws IOException {
            if (aHb()) {
                throw mo2736c(null);
            }
        }
    }

    dwb(int i, dwa com_fossil_dwa, boolean z, boolean z2, List<dwc> list) {
        if (com_fossil_dwa == null) {
            throw new NullPointerException("connection == null");
        } else if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        } else {
            this.id = i;
            this.dxH = com_fossil_dwa;
            this.dxk = (long) com_fossil_dwa.dxm.mR(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
            this.dxK = new C3253b((long) com_fossil_dwa.dxl.mR(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST));
            this.dxL = new C3252a(this);
            this.dxK.dxQ = z2;
            this.dxL.dxQ = z;
            this.dxI = list;
        }
    }

    public int getId() {
        return this.id;
    }

    public synchronized boolean isOpen() {
        boolean z = false;
        synchronized (this) {
            if (this.dxO == null) {
                if (!(this.dxK.dxQ || this.dxK.closed) || (!(this.dxL.dxQ || this.dxL.closed) || this.dxJ == null)) {
                    z = true;
                }
            }
        }
        return z;
    }

    public boolean azW() {
        boolean z;
        if ((this.id & 1) == 1) {
            z = true;
        } else {
            z = false;
        }
        return this.dxH.dwY == z;
    }

    public synchronized List<dwc> azX() throws IOException {
        this.dxM.enter();
        while (this.dxJ == null && this.dxO == null) {
            try {
                aAe();
            } catch (Throwable th) {
                this.dxM.aAi();
            }
        }
        this.dxM.aAi();
        if (this.dxJ != null) {
        } else {
            throw new IOException("stream was reset: " + this.dxO);
        }
        return this.dxJ;
    }

    public etw azY() {
        return this.dxM;
    }

    public etv azZ() {
        return this.dxK;
    }

    public etu aAa() {
        synchronized (this) {
            if (this.dxJ != null || azW()) {
            } else {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.dxL;
    }

    public void m10080b(ErrorCode errorCode) throws IOException {
        if (m10073d(errorCode)) {
            this.dxH.m10048c(this.id, errorCode);
        }
    }

    public void m10081c(ErrorCode errorCode) {
        if (m10073d(errorCode)) {
            this.dxH.m10047b(this.id, errorCode);
        }
    }

    private boolean m10073d(ErrorCode errorCode) {
        if ($assertionsDisabled || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.dxO != null) {
                    return false;
                } else if (this.dxK.dxQ && this.dxL.dxQ) {
                    return false;
                } else {
                    this.dxO = errorCode;
                    notifyAll();
                    this.dxH.mD(this.id);
                    return true;
                }
            }
        }
        throw new AssertionError();
    }

    void m10079a(List<dwc> list, HeadersMode headersMode) {
        if ($assertionsDisabled || !Thread.holdsLock(this)) {
            ErrorCode errorCode = null;
            boolean z = true;
            synchronized (this) {
                if (this.dxJ == null) {
                    if (headersMode.failIfHeadersAbsent()) {
                        errorCode = ErrorCode.PROTOCOL_ERROR;
                    } else {
                        this.dxJ = list;
                        z = isOpen();
                        notifyAll();
                    }
                } else if (headersMode.failIfHeadersPresent()) {
                    errorCode = ErrorCode.STREAM_IN_USE;
                } else {
                    List arrayList = new ArrayList();
                    arrayList.addAll(this.dxJ);
                    arrayList.addAll(list);
                    this.dxJ = arrayList;
                }
            }
            if (errorCode != null) {
                m10081c(errorCode);
                return;
            } else if (!z) {
                this.dxH.mD(this.id);
                return;
            } else {
                return;
            }
        }
        throw new AssertionError();
    }

    void m10078a(etj com_fossil_etj, int i) throws IOException {
        if ($assertionsDisabled || !Thread.holdsLock(this)) {
            this.dxK.m10059a(com_fossil_etj, (long) i);
            return;
        }
        throw new AssertionError();
    }

    void aAb() {
        if ($assertionsDisabled || !Thread.holdsLock(this)) {
            boolean isOpen;
            synchronized (this) {
                this.dxK.dxQ = true;
                isOpen = isOpen();
                notifyAll();
            }
            if (!isOpen) {
                this.dxH.mD(this.id);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    synchronized void m10082e(ErrorCode errorCode) {
        if (this.dxO == null) {
            this.dxO = errorCode;
            notifyAll();
        }
    }

    private void aAc() throws IOException {
        if ($assertionsDisabled || !Thread.holdsLock(this)) {
            Object obj;
            boolean isOpen;
            synchronized (this) {
                obj = (!this.dxK.dxQ && this.dxK.closed && (this.dxL.dxQ || this.dxL.closed)) ? 1 : null;
                isOpen = isOpen();
            }
            if (obj != null) {
                m10080b(ErrorCode.CANCEL);
                return;
            } else if (!isOpen) {
                this.dxH.mD(this.id);
                return;
            } else {
                return;
            }
        }
        throw new AssertionError();
    }

    void aM(long j) {
        this.dxk += j;
        if (j > 0) {
            notifyAll();
        }
    }

    private void aAd() throws IOException {
        if (this.dxL.closed) {
            throw new IOException("stream closed");
        } else if (this.dxL.dxQ) {
            throw new IOException("stream finished");
        } else if (this.dxO != null) {
            throw new IOException("stream was reset: " + this.dxO);
        }
    }

    private void aAe() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException e) {
            throw new InterruptedIOException();
        }
    }
}
