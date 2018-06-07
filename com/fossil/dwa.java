package com.fossil;

import com.facebook.internal.NativeProtocol;
import com.fossil.dvy.C3238a;
import com.misfit.frameworks.buttonservice.ButtonService;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.framed.ErrorCode;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okio.ByteString;

public final class dwa implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final ExecutorService dwX = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), dvw.m9977t("OkHttp FramedConnection", true));
    final Socket duT;
    final Protocol duW;
    private long duX;
    final boolean dwY;
    private final dwg dwZ;
    private final Map<Integer, dwb> dxa;
    private final String dxb;
    private int dxc;
    private int dxd;
    private boolean dxe;
    private final ExecutorService dxf;
    private Map<Integer, dwi> dxg;
    private final dwj dxh;
    private int dxi;
    long dxj;
    long dxk;
    final dwk dxl;
    final dwk dxm;
    private boolean dxn;
    final dwm dxo;
    final dvz dxp;
    final C3250b dxq;
    private final Set<Integer> dxr;

    public static class C3247a {
        private Socket duT;
        private Protocol duW = Protocol.SPDY_3;
        private boolean dwY;
        private dwg dwZ = dwg.dyL;
        private String dxb;
        private dwj dxh = dwj.dyR;

        public C3247a(String str, boolean z, Socket socket) throws IOException {
            this.dxb = str;
            this.dwY = z;
            this.duT = socket;
        }

        public C3247a m10004c(Protocol protocol) {
            this.duW = protocol;
            return this;
        }

        public dwa azV() throws IOException {
            return new dwa();
        }
    }

    class C3250b extends dvr implements C3238a {
        dvy dxD;
        final /* synthetic */ dwa dxu;

        private C3250b(dwa com_fossil_dwa) {
            this.dxu = com_fossil_dwa;
            super("OkHttp %s", com_fossil_dwa.dxb);
        }

        protected void execute() {
            ErrorCode errorCode;
            Throwable th;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            ErrorCode errorCode3 = ErrorCode.INTERNAL_ERROR;
            try {
                this.dxD = this.dxu.dxo.mo2751a(etp.m11180c(etp.m11181c(this.dxu.duT)), this.dxu.dwY);
                if (!this.dxu.dwY) {
                    this.dxD.azP();
                }
                do {
                } while (this.dxD.mo2737a(this));
                try {
                    this.dxu.m10025a(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
                } catch (IOException e) {
                }
                dvw.closeQuietly(this.dxD);
            } catch (IOException e2) {
                errorCode = ErrorCode.PROTOCOL_ERROR;
                try {
                    this.dxu.m10025a(errorCode, ErrorCode.PROTOCOL_ERROR);
                } catch (IOException e3) {
                }
                dvw.closeQuietly(this.dxD);
            } catch (Throwable th2) {
                th = th2;
                this.dxu.m10025a(errorCode, errorCode3);
                dvw.closeQuietly(this.dxD);
                throw th;
            }
        }

        public void mo2720a(boolean z, int i, etj com_fossil_etj, int i2) throws IOException {
            if (this.dxu.mF(i)) {
                this.dxu.m10017a(i, com_fossil_etj, i2, z);
                return;
            }
            dwb mC = this.dxu.mC(i);
            if (mC == null) {
                this.dxu.m10047b(i, ErrorCode.INVALID_STREAM);
                com_fossil_etj.bh((long) i2);
                return;
            }
            mC.m10078a(com_fossil_etj, i2);
            if (z) {
                mC.aAb();
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo2722a(boolean r9, boolean r10, int r11, int r12, java.util.List<com.fossil.dwc> r13, com.squareup.okhttp.internal.framed.HeadersMode r14) {
            /*
            r8 = this;
            r0 = r8.dxu;
            r0 = r0.mF(r11);
            if (r0 == 0) goto L_0x000e;
        L_0x0008:
            r0 = r8.dxu;
            r0.m10018a(r11, r13, r10);
        L_0x000d:
            return;
        L_0x000e:
            r6 = r8.dxu;
            monitor-enter(r6);
            r0 = r8.dxu;	 Catch:{ all -> 0x001b }
            r0 = r0.dxe;	 Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x001e;
        L_0x0019:
            monitor-exit(r6);	 Catch:{ all -> 0x001b }
            goto L_0x000d;
        L_0x001b:
            r0 = move-exception;
            monitor-exit(r6);	 Catch:{ all -> 0x001b }
            throw r0;
        L_0x001e:
            r0 = r8.dxu;	 Catch:{ all -> 0x001b }
            r0 = r0.mC(r11);	 Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x008d;
        L_0x0026:
            r0 = r14.failIfStreamAbsent();	 Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x0035;
        L_0x002c:
            r0 = r8.dxu;	 Catch:{ all -> 0x001b }
            r1 = com.squareup.okhttp.internal.framed.ErrorCode.INVALID_STREAM;	 Catch:{ all -> 0x001b }
            r0.m10047b(r11, r1);	 Catch:{ all -> 0x001b }
            monitor-exit(r6);	 Catch:{ all -> 0x001b }
            goto L_0x000d;
        L_0x0035:
            r0 = r8.dxu;	 Catch:{ all -> 0x001b }
            r0 = r0.dxc;	 Catch:{ all -> 0x001b }
            if (r11 > r0) goto L_0x003f;
        L_0x003d:
            monitor-exit(r6);	 Catch:{ all -> 0x001b }
            goto L_0x000d;
        L_0x003f:
            r0 = r11 % 2;
            r1 = r8.dxu;	 Catch:{ all -> 0x001b }
            r1 = r1.dxd;	 Catch:{ all -> 0x001b }
            r1 = r1 % 2;
            if (r0 != r1) goto L_0x004d;
        L_0x004b:
            monitor-exit(r6);	 Catch:{ all -> 0x001b }
            goto L_0x000d;
        L_0x004d:
            r0 = new com.fossil.dwb;	 Catch:{ all -> 0x001b }
            r2 = r8.dxu;	 Catch:{ all -> 0x001b }
            r1 = r11;
            r3 = r9;
            r4 = r10;
            r5 = r13;
            r0.<init>(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x001b }
            r1 = r8.dxu;	 Catch:{ all -> 0x001b }
            r1.dxc = r11;	 Catch:{ all -> 0x001b }
            r1 = r8.dxu;	 Catch:{ all -> 0x001b }
            r1 = r1.dxa;	 Catch:{ all -> 0x001b }
            r2 = java.lang.Integer.valueOf(r11);	 Catch:{ all -> 0x001b }
            r1.put(r2, r0);	 Catch:{ all -> 0x001b }
            r1 = com.fossil.dwa.dwX;	 Catch:{ all -> 0x001b }
            r2 = new com.fossil.dwa$b$1;	 Catch:{ all -> 0x001b }
            r3 = "OkHttp %s stream %d";
            r4 = 2;
            r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x001b }
            r5 = 0;
            r7 = r8.dxu;	 Catch:{ all -> 0x001b }
            r7 = r7.dxb;	 Catch:{ all -> 0x001b }
            r4[r5] = r7;	 Catch:{ all -> 0x001b }
            r5 = 1;
            r7 = java.lang.Integer.valueOf(r11);	 Catch:{ all -> 0x001b }
            r4[r5] = r7;	 Catch:{ all -> 0x001b }
            r2.<init>(r8, r3, r4, r0);	 Catch:{ all -> 0x001b }
            r1.execute(r2);	 Catch:{ all -> 0x001b }
            monitor-exit(r6);	 Catch:{ all -> 0x001b }
            goto L_0x000d;
        L_0x008d:
            monitor-exit(r6);	 Catch:{ all -> 0x001b }
            r1 = r14.failIfStreamPresent();
            if (r1 == 0) goto L_0x00a0;
        L_0x0094:
            r1 = com.squareup.okhttp.internal.framed.ErrorCode.PROTOCOL_ERROR;
            r0.m10081c(r1);
            r0 = r8.dxu;
            r0.mD(r11);
            goto L_0x000d;
        L_0x00a0:
            r0.m10079a(r13, r14);
            if (r10 == 0) goto L_0x000d;
        L_0x00a5:
            r0.aAb();
            goto L_0x000d;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fossil.dwa.b.a(boolean, boolean, int, int, java.util.List, com.squareup.okhttp.internal.framed.HeadersMode):void");
        }

        public void mo2718a(int i, ErrorCode errorCode) {
            if (this.dxu.mF(i)) {
                this.dxu.m10038d(i, errorCode);
                return;
            }
            dwb mD = this.dxu.mD(i);
            if (mD != null) {
                mD.m10082e(errorCode);
            }
        }

        public void mo2721a(boolean z, dwk com_fossil_dwk) {
            dwb[] com_fossil_dwbArr;
            long j;
            synchronized (this.dxu) {
                int mR = this.dxu.dxm.mR(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
                if (z) {
                    this.dxu.dxm.clear();
                }
                this.dxu.dxm.m10149d(com_fossil_dwk);
                if (this.dxu.ayB() == Protocol.HTTP_2) {
                    m10005c(com_fossil_dwk);
                }
                int mR2 = this.dxu.dxm.mR(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
                if (mR2 == -1 || mR2 == mR) {
                    com_fossil_dwbArr = null;
                    j = 0;
                } else {
                    j = (long) (mR2 - mR);
                    if (!this.dxu.dxn) {
                        this.dxu.aM(j);
                        this.dxu.dxn = true;
                    }
                    com_fossil_dwbArr = !this.dxu.dxa.isEmpty() ? (dwb[]) this.dxu.dxa.values().toArray(new dwb[this.dxu.dxa.size()]) : null;
                }
            }
            if (com_fossil_dwbArr != null && j != 0) {
                for (dwb com_fossil_dwb : com_fossil_dwbArr) {
                    synchronized (com_fossil_dwb) {
                        com_fossil_dwb.aM(j);
                    }
                }
            }
        }

        private void m10005c(final dwk com_fossil_dwk) {
            dwa.dwX.execute(new dvr(this, "OkHttp %s ACK Settings", new Object[]{this.dxu.dxb}) {
                final /* synthetic */ C3250b dxF;

                public void execute() {
                    try {
                        this.dxF.dxu.dxp.mo2741a(com_fossil_dwk);
                    } catch (IOException e) {
                    }
                }
            });
        }

        public void azQ() {
        }

        public void mo2726c(boolean z, int i, int i2) {
            if (z) {
                dwi c = this.dxu.mE(i);
                if (c != null) {
                    c.aAA();
                    return;
                }
                return;
            }
            this.dxu.m10026a(true, i, i2, null);
        }

        public void mo2719a(int i, ErrorCode errorCode, ByteString byteString) {
            if (byteString.size() > 0) {
            }
            synchronized (this.dxu) {
                dwb[] com_fossil_dwbArr = (dwb[]) this.dxu.dxa.values().toArray(new dwb[this.dxu.dxa.size()]);
                this.dxu.dxe = true;
            }
            for (dwb com_fossil_dwb : com_fossil_dwbArr) {
                if (com_fossil_dwb.getId() > i && com_fossil_dwb.azW()) {
                    com_fossil_dwb.m10082e(ErrorCode.REFUSED_STREAM);
                    this.dxu.mD(com_fossil_dwb.getId());
                }
            }
        }

        public void mo2727k(int i, long j) {
            if (i == 0) {
                synchronized (this.dxu) {
                    dwa com_fossil_dwa = this.dxu;
                    com_fossil_dwa.dxk += j;
                    this.dxu.notifyAll();
                }
                return;
            }
            dwb mC = this.dxu.mC(i);
            if (mC != null) {
                synchronized (mC) {
                    mC.aM(j);
                }
            }
        }

        public void mo2724b(int i, int i2, int i3, boolean z) {
        }

        public void mo2725b(int i, int i2, List<dwc> list) {
            this.dxu.m10036c(i2, (List) list);
        }
    }

    static {
        boolean z;
        if (dwa.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        $assertionsDisabled = z;
    }

    private dwa(C3247a c3247a) throws IOException {
        int i = 2;
        this.dxa = new HashMap();
        this.duX = System.nanoTime();
        this.dxj = 0;
        this.dxl = new dwk();
        this.dxm = new dwk();
        this.dxn = false;
        this.dxr = new LinkedHashSet();
        this.duW = c3247a.duW;
        this.dxh = c3247a.dxh;
        this.dwY = c3247a.dwY;
        this.dwZ = c3247a.dwZ;
        this.dxd = c3247a.dwY ? 1 : 2;
        if (c3247a.dwY && this.duW == Protocol.HTTP_2) {
            this.dxd += 2;
        }
        if (c3247a.dwY) {
            i = 1;
        }
        this.dxi = i;
        if (c3247a.dwY) {
            this.dxl.m10148J(7, 0, 16777216);
        }
        this.dxb = c3247a.dxb;
        if (this.duW == Protocol.HTTP_2) {
            this.dxo = new dwe();
            this.dxf = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), dvw.m9977t(String.format("OkHttp %s Push Observer", new Object[]{this.dxb}), true));
            this.dxm.m10148J(7, 0, 65535);
            this.dxm.m10148J(5, 0, 16384);
        } else if (this.duW == Protocol.SPDY_3) {
            this.dxo = new dwl();
            this.dxf = null;
        } else {
            throw new AssertionError(this.duW);
        }
        this.dxk = (long) this.dxm.mR(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        this.duT = c3247a.duT;
        this.dxp = this.dxo.mo2752a(etp.m11179c(etp.m11178b(c3247a.duT)), this.dwY);
        this.dxq = new C3250b();
        new Thread(this.dxq).start();
    }

    public Protocol ayB() {
        return this.duW;
    }

    synchronized dwb mC(int i) {
        return (dwb) this.dxa.get(Integer.valueOf(i));
    }

    synchronized dwb mD(int i) {
        dwb com_fossil_dwb;
        com_fossil_dwb = (dwb) this.dxa.remove(Integer.valueOf(i));
        if (com_fossil_dwb != null && this.dxa.isEmpty()) {
            dy(true);
        }
        notifyAll();
        return com_fossil_dwb;
    }

    private synchronized void dy(boolean z) {
        this.duX = z ? System.nanoTime() : ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
    }

    public synchronized boolean isIdle() {
        return this.duX != ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
    }

    public synchronized long ayy() {
        return this.duX;
    }

    public dwb m10046b(List<dwc> list, boolean z, boolean z2) throws IOException {
        return m10015a(0, (List) list, z, z2);
    }

    private dwb m10015a(int i, List<dwc> list, boolean z, boolean z2) throws IOException {
        dwb com_fossil_dwb;
        boolean z3 = true;
        boolean z4 = !z;
        if (z2) {
            z3 = false;
        }
        synchronized (this.dxp) {
            synchronized (this) {
                if (this.dxe) {
                    throw new IOException("shutdown");
                }
                int i2 = this.dxd;
                this.dxd += 2;
                com_fossil_dwb = new dwb(i2, this, z4, z3, list);
                if (com_fossil_dwb.isOpen()) {
                    this.dxa.put(Integer.valueOf(i2), com_fossil_dwb);
                    dy(false);
                }
            }
            if (i == 0) {
                this.dxp.mo2743a(z4, z3, i2, i, list);
            } else if (this.dwY) {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            } else {
                this.dxp.mo2746b(i, i2, list);
            }
        }
        if (!z) {
            this.dxp.flush();
        }
        return com_fossil_dwb;
    }

    public void m10044a(int i, boolean z, eth com_fossil_eth, long j) throws IOException {
        if (j == 0) {
            this.dxp.mo2742a(z, i, com_fossil_eth, 0);
            return;
        }
        while (j > 0) {
            int min;
            boolean z2;
            synchronized (this) {
                while (this.dxk <= 0) {
                    try {
                        if (this.dxa.containsKey(Integer.valueOf(i))) {
                            wait();
                        } else {
                            throw new IOException("stream closed");
                        }
                    } catch (InterruptedException e) {
                        throw new InterruptedIOException();
                    }
                }
                min = Math.min((int) Math.min(j, this.dxk), this.dxp.azS());
                this.dxk -= (long) min;
            }
            j -= (long) min;
            dvz com_fossil_dvz = this.dxp;
            if (z && j == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            com_fossil_dvz.mo2742a(z2, i, com_fossil_eth, min);
        }
    }

    void aM(long j) {
        this.dxk += j;
        if (j > 0) {
            notifyAll();
        }
    }

    void m10047b(int i, ErrorCode errorCode) {
        final int i2 = i;
        final ErrorCode errorCode2 = errorCode;
        dwX.submit(new dvr(this, "OkHttp %s stream %d", new Object[]{this.dxb, Integer.valueOf(i)}) {
            final /* synthetic */ dwa dxu;

            public void execute() {
                try {
                    this.dxu.m10048c(i2, errorCode2);
                } catch (IOException e) {
                }
            }
        });
    }

    void m10048c(int i, ErrorCode errorCode) throws IOException {
        this.dxp.mo2739a(i, errorCode);
    }

    void m10049l(int i, long j) {
        final int i2 = i;
        final long j2 = j;
        dwX.execute(new dvr(this, "OkHttp Window Update %s stream %d", new Object[]{this.dxb, Integer.valueOf(i)}) {
            final /* synthetic */ dwa dxu;

            public void execute() {
                try {
                    this.dxu.dxp.mo2750k(i2, j2);
                } catch (IOException e) {
                }
            }
        });
    }

    private void m10026a(boolean z, int i, int i2, dwi com_fossil_dwi) {
        final boolean z2 = z;
        final int i3 = i;
        final int i4 = i2;
        final dwi com_fossil_dwi2 = com_fossil_dwi;
        dwX.execute(new dvr(this, "OkHttp %s ping %08x%08x", new Object[]{this.dxb, Integer.valueOf(i), Integer.valueOf(i2)}) {
            final /* synthetic */ dwa dxu;

            public void execute() {
                try {
                    this.dxu.m10031b(z2, i3, i4, com_fossil_dwi2);
                } catch (IOException e) {
                }
            }
        });
    }

    private void m10031b(boolean z, int i, int i2, dwi com_fossil_dwi) throws IOException {
        synchronized (this.dxp) {
            if (com_fossil_dwi != null) {
                com_fossil_dwi.send();
            }
            this.dxp.mo2748c(z, i, i2);
        }
    }

    private synchronized dwi mE(int i) {
        return this.dxg != null ? (dwi) this.dxg.remove(Integer.valueOf(i)) : null;
    }

    public void flush() throws IOException {
        this.dxp.flush();
    }

    public void m10045a(ErrorCode errorCode) throws IOException {
        synchronized (this.dxp) {
            synchronized (this) {
                if (this.dxe) {
                    return;
                }
                this.dxe = true;
                int i = this.dxc;
                this.dxp.mo2740a(i, errorCode, dvw.dwU);
            }
        }
    }

    public void close() throws IOException {
        m10025a(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    private void m10025a(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        IOException iOException;
        IOException e;
        if ($assertionsDisabled || !Thread.holdsLock(this)) {
            dwb[] com_fossil_dwbArr;
            dwi[] com_fossil_dwiArr;
            try {
                m10045a(errorCode);
                iOException = null;
            } catch (IOException e2) {
                iOException = e2;
            }
            synchronized (this) {
                if (this.dxa.isEmpty()) {
                    com_fossil_dwbArr = null;
                } else {
                    dwb[] com_fossil_dwbArr2 = (dwb[]) this.dxa.values().toArray(new dwb[this.dxa.size()]);
                    this.dxa.clear();
                    dy(false);
                    com_fossil_dwbArr = com_fossil_dwbArr2;
                }
                if (this.dxg != null) {
                    dwi[] com_fossil_dwiArr2 = (dwi[]) this.dxg.values().toArray(new dwi[this.dxg.size()]);
                    this.dxg = null;
                    com_fossil_dwiArr = com_fossil_dwiArr2;
                } else {
                    com_fossil_dwiArr = null;
                }
            }
            if (com_fossil_dwbArr != null) {
                e2 = iOException;
                for (dwb b : com_fossil_dwbArr) {
                    try {
                        b.m10080b(errorCode2);
                    } catch (IOException iOException2) {
                        if (e2 != null) {
                            e2 = iOException2;
                        }
                    }
                }
                iOException2 = e2;
            }
            if (com_fossil_dwiArr != null) {
                for (dwi cancel : com_fossil_dwiArr) {
                    cancel.cancel();
                }
            }
            try {
                this.dxp.close();
                e2 = iOException2;
            } catch (IOException e3) {
                e2 = e3;
                if (iOException2 != null) {
                    e2 = iOException2;
                }
            }
            try {
                this.duT.close();
            } catch (IOException e4) {
                e2 = e4;
            }
            if (e2 != null) {
                throw e2;
            }
            return;
        }
        throw new AssertionError();
    }

    public void azT() throws IOException {
        this.dxp.azR();
        this.dxp.mo2747b(this.dxl);
        int mR = this.dxl.mR(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        if (mR != NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) {
            this.dxp.mo2750k(0, (long) (mR - NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST));
        }
    }

    private boolean mF(int i) {
        return this.duW == Protocol.HTTP_2 && i != 0 && (i & 1) == 0;
    }

    private void m10036c(int i, List<dwc> list) {
        synchronized (this) {
            if (this.dxr.contains(Integer.valueOf(i))) {
                m10047b(i, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.dxr.add(Integer.valueOf(i));
            final int i2 = i;
            final List<dwc> list2 = list;
            this.dxf.execute(new dvr(this, "OkHttp %s Push Request[%s]", new Object[]{this.dxb, Integer.valueOf(i)}) {
                final /* synthetic */ dwa dxu;

                public void execute() {
                    if (this.dxu.dxh.mo2756d(i2, list2)) {
                        try {
                            this.dxu.dxp.mo2739a(i2, ErrorCode.CANCEL);
                            synchronized (this.dxu) {
                                this.dxu.dxr.remove(Integer.valueOf(i2));
                            }
                        } catch (IOException e) {
                        }
                    }
                }
            });
        }
    }

    private void m10018a(int i, List<dwc> list, boolean z) {
        final int i2 = i;
        final List<dwc> list2 = list;
        final boolean z2 = z;
        this.dxf.execute(new dvr(this, "OkHttp %s Push Headers[%s]", new Object[]{this.dxb, Integer.valueOf(i)}) {
            final /* synthetic */ dwa dxu;

            public void execute() {
                boolean b = this.dxu.dxh.mo2755b(i2, list2, z2);
                if (b) {
                    try {
                        this.dxu.dxp.mo2739a(i2, ErrorCode.CANCEL);
                    } catch (IOException e) {
                        return;
                    }
                }
                if (b || z2) {
                    synchronized (this.dxu) {
                        this.dxu.dxr.remove(Integer.valueOf(i2));
                    }
                }
            }
        });
    }

    private void m10017a(int i, etj com_fossil_etj, int i2, boolean z) throws IOException {
        final eth com_fossil_eth = new eth();
        com_fossil_etj.bb((long) i2);
        com_fossil_etj.mo2733b(com_fossil_eth, (long) i2);
        if (com_fossil_eth.size() != ((long) i2)) {
            throw new IOException(com_fossil_eth.size() + " != " + i2);
        }
        final int i3 = i;
        final int i4 = i2;
        final boolean z2 = z;
        this.dxf.execute(new dvr(this, "OkHttp %s Push Data[%s]", new Object[]{this.dxb, Integer.valueOf(i)}) {
            final /* synthetic */ dwa dxu;

            public void execute() {
                try {
                    boolean b = this.dxu.dxh.mo2754b(i3, com_fossil_eth, i4, z2);
                    if (b) {
                        this.dxu.dxp.mo2739a(i3, ErrorCode.CANCEL);
                    }
                    if (b || z2) {
                        synchronized (this.dxu) {
                            this.dxu.dxr.remove(Integer.valueOf(i3));
                        }
                    }
                } catch (IOException e) {
                }
            }
        });
    }

    private void m10038d(int i, ErrorCode errorCode) {
        final int i2 = i;
        final ErrorCode errorCode2 = errorCode;
        this.dxf.execute(new dvr(this, "OkHttp %s Push Reset[%s]", new Object[]{this.dxb, Integer.valueOf(i)}) {
            final /* synthetic */ dwa dxu;

            public void execute() {
                this.dxu.dxh.mo2757e(i2, errorCode2);
                synchronized (this.dxu) {
                    this.dxu.dxr.remove(Integer.valueOf(i2));
                }
            }
        });
    }
}
