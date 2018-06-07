package com.fossil;

import java.io.IOException;
import java.io.InterruptedIOException;

public class etf extends etw {
    private static etf dSX;
    private boolean dSY;
    private etf dSZ;
    private long dTa;

    static final class C3539a extends Thread {
        public C3539a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        public void run() {
            while (true) {
                try {
                    etf aHd = etf.aHc();
                    if (aHd != null) {
                        aHd.aAh();
                    }
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public final void enter() {
        if (this.dSY) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long aHv = aHv();
        boolean aHw = aHw();
        if (aHv != 0 || aHw) {
            this.dSY = true;
            m10062a(this, aHv, aHw);
        }
    }

    private static synchronized void m10062a(etf com_fossil_etf, long j, boolean z) {
        synchronized (etf.class) {
            if (dSX == null) {
                dSX = new etf();
                new C3539a().start();
            }
            long nanoTime = System.nanoTime();
            if (j != 0 && z) {
                com_fossil_etf.dTa = Math.min(j, com_fossil_etf.aHx() - nanoTime) + nanoTime;
            } else if (j != 0) {
                com_fossil_etf.dTa = nanoTime + j;
            } else if (z) {
                com_fossil_etf.dTa = com_fossil_etf.aHx();
            } else {
                throw new AssertionError();
            }
            long ba = com_fossil_etf.ba(nanoTime);
            etf com_fossil_etf2 = dSX;
            while (com_fossil_etf2.dSZ != null && ba >= com_fossil_etf2.dSZ.ba(nanoTime)) {
                com_fossil_etf2 = com_fossil_etf2.dSZ;
            }
            com_fossil_etf.dSZ = com_fossil_etf2.dSZ;
            com_fossil_etf2.dSZ = com_fossil_etf;
            if (com_fossil_etf2 == dSX) {
                etf.class.notify();
            }
        }
    }

    public final boolean aHb() {
        if (!this.dSY) {
            return false;
        }
        this.dSY = false;
        return m10063a(this);
    }

    private static synchronized boolean m10063a(etf com_fossil_etf) {
        boolean z;
        synchronized (etf.class) {
            for (etf com_fossil_etf2 = dSX; com_fossil_etf2 != null; com_fossil_etf2 = com_fossil_etf2.dSZ) {
                if (com_fossil_etf2.dSZ == com_fossil_etf) {
                    com_fossil_etf2.dSZ = com_fossil_etf.dSZ;
                    com_fossil_etf.dSZ = null;
                    z = false;
                    break;
                }
            }
            z = true;
        }
        return z;
    }

    private long ba(long j) {
        return this.dTa - j;
    }

    protected void aAh() {
    }

    public final etu m10065b(final etu com_fossil_etu) {
        return new etu(this) {
            final /* synthetic */ etf dTc;

            public void mo2728a(eth com_fossil_eth, long j) throws IOException {
                this.dTc.enter();
                try {
                    com_fossil_etu.mo2728a(com_fossil_eth, j);
                    this.dTc.dL(true);
                } catch (IOException e) {
                    throw this.dTc.m10067e(e);
                } catch (Throwable th) {
                    this.dTc.dL(false);
                }
            }

            public void flush() throws IOException {
                this.dTc.enter();
                try {
                    com_fossil_etu.flush();
                    this.dTc.dL(true);
                } catch (IOException e) {
                    throw this.dTc.m10067e(e);
                } catch (Throwable th) {
                    this.dTc.dL(false);
                }
            }

            public void close() throws IOException {
                this.dTc.enter();
                try {
                    com_fossil_etu.close();
                    this.dTc.dL(true);
                } catch (IOException e) {
                    throw this.dTc.m10067e(e);
                } catch (Throwable th) {
                    this.dTc.dL(false);
                }
            }

            public etw aAf() {
                return this.dTc;
            }

            public String toString() {
                return "AsyncTimeout.sink(" + com_fossil_etu + ")";
            }
        };
    }

    public final etv m10064a(final etv com_fossil_etv) {
        return new etv(this) {
            final /* synthetic */ etf dTc;

            public long mo2733b(eth com_fossil_eth, long j) throws IOException {
                this.dTc.enter();
                try {
                    long b = com_fossil_etv.mo2733b(com_fossil_eth, j);
                    this.dTc.dL(true);
                    return b;
                } catch (IOException e) {
                    throw this.dTc.m10067e(e);
                } catch (Throwable th) {
                    this.dTc.dL(false);
                }
            }

            public void close() throws IOException {
                try {
                    com_fossil_etv.close();
                    this.dTc.dL(true);
                } catch (IOException e) {
                    throw this.dTc.m10067e(e);
                } catch (Throwable th) {
                    this.dTc.dL(false);
                }
            }

            public etw aAf() {
                return this.dTc;
            }

            public String toString() {
                return "AsyncTimeout.source(" + com_fossil_etv + ")";
            }
        };
    }

    final void dL(boolean z) throws IOException {
        if (aHb() && z) {
            throw mo2736c(null);
        }
    }

    final IOException m10067e(IOException iOException) throws IOException {
        return !aHb() ? iOException : mo2736c(iOException);
    }

    protected IOException mo2736c(IOException iOException) {
        IOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    private static synchronized etf aHc() throws InterruptedException {
        etf com_fossil_etf = null;
        synchronized (etf.class) {
            etf com_fossil_etf2 = dSX.dSZ;
            if (com_fossil_etf2 == null) {
                etf.class.wait();
            } else {
                long ba = com_fossil_etf2.ba(System.nanoTime());
                if (ba > 0) {
                    long j = ba / 1000000;
                    etf.class.wait(j, (int) (ba - (1000000 * j)));
                } else {
                    dSX.dSZ = com_fossil_etf2.dSZ;
                    com_fossil_etf2.dSZ = null;
                    com_fossil_etf = com_fossil_etf2;
                }
            }
        }
        return com_fossil_etf;
    }
}
