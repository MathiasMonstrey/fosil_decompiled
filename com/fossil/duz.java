package com.fossil;

import java.net.SocketException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class duz {
    private static final duz dvb;
    private final int dvc;
    private final long dvd;
    private final LinkedList<duy> dve = new LinkedList();
    private final Runnable dvf = new C32171(this);
    private Executor executor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), dvw.m9977t("OkHttp ConnectionPool", true));

    class C32171 implements Runnable {
        final /* synthetic */ duz dvg;

        C32171(duz com_fossil_duz) {
            this.dvg = com_fossil_duz;
        }

        public void run() {
            this.dvg.ayF();
        }
    }

    static {
        String property = System.getProperty("http.keepAlive");
        String property2 = System.getProperty("http.keepAliveDuration");
        String property3 = System.getProperty("http.maxConnections");
        long parseLong = property2 != null ? Long.parseLong(property2) : 300000;
        if (property != null && !Boolean.parseBoolean(property)) {
            dvb = new duz(0, parseLong);
        } else if (property3 != null) {
            dvb = new duz(Integer.parseInt(property3), parseLong);
        } else {
            dvb = new duz(5, parseLong);
        }
    }

    public duz(int i, long j) {
        this.dvc = i;
        this.dvd = (j * 1000) * 1000;
    }

    public static duz ayE() {
        return dvb;
    }

    public synchronized duy m9815a(dur com_fossil_dur) {
        duy com_fossil_duy;
        ListIterator listIterator = this.dve.listIterator(this.dve.size());
        while (listIterator.hasPrevious()) {
            com_fossil_duy = (duy) listIterator.previous();
            if (com_fossil_duy.ayw().azI().equals(com_fossil_dur) && com_fossil_duy.isAlive() && System.nanoTime() - com_fossil_duy.ayy() < this.dvd) {
                listIterator.remove();
                if (com_fossil_duy.ayA()) {
                    break;
                }
                try {
                    dvu.azM().tagSocket(com_fossil_duy.getSocket());
                    break;
                } catch (SocketException e) {
                    dvw.m9969a(com_fossil_duy.getSocket());
                    dvu.azM().kP("Unable to tagSocket(): " + e);
                }
            }
        }
        com_fossil_duy = null;
        if (com_fossil_duy != null) {
            if (com_fossil_duy.ayA()) {
                this.dve.addFirst(com_fossil_duy);
            }
        }
        return com_fossil_duy;
    }

    void m9816a(duy com_fossil_duy) {
        if (com_fossil_duy.ayA() || !com_fossil_duy.ayv()) {
            return;
        }
        if (com_fossil_duy.isAlive()) {
            try {
                dvu.azM().untagSocket(com_fossil_duy.getSocket());
                synchronized (this) {
                    m9814b(com_fossil_duy);
                    com_fossil_duy.ayC();
                    com_fossil_duy.ayx();
                }
                return;
            } catch (SocketException e) {
                dvu.azM().kP("Unable to untagSocket(): " + e);
                dvw.m9969a(com_fossil_duy.getSocket());
                return;
            }
        }
        dvw.m9969a(com_fossil_duy.getSocket());
    }

    private void m9814b(duy com_fossil_duy) {
        boolean isEmpty = this.dve.isEmpty();
        this.dve.addFirst(com_fossil_duy);
        if (isEmpty) {
            this.executor.execute(this.dvf);
        } else {
            notifyAll();
        }
    }

    void m9817c(duy com_fossil_duy) {
        if (!com_fossil_duy.ayA()) {
            throw new IllegalArgumentException();
        } else if (com_fossil_duy.isAlive()) {
            synchronized (this) {
                m9814b(com_fossil_duy);
            }
        }
    }

    private void ayF() {
        do {
        } while (ayG());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    boolean ayG() {
        /*
        r18 = this;
        monitor-enter(r18);
        r0 = r18;
        r2 = r0.dve;	 Catch:{ all -> 0x00b9 }
        r2 = r2.isEmpty();	 Catch:{ all -> 0x00b9 }
        if (r2 == 0) goto L_0x000e;
    L_0x000b:
        r2 = 0;
        monitor-exit(r18);	 Catch:{ all -> 0x00b9 }
    L_0x000d:
        return r2;
    L_0x000e:
        r7 = new java.util.ArrayList;	 Catch:{ all -> 0x00b9 }
        r7.<init>();	 Catch:{ all -> 0x00b9 }
        r3 = 0;
        r8 = java.lang.System.nanoTime();	 Catch:{ all -> 0x00b9 }
        r0 = r18;
        r4 = r0.dvd;	 Catch:{ all -> 0x00b9 }
        r0 = r18;
        r2 = r0.dve;	 Catch:{ all -> 0x00b9 }
        r0 = r18;
        r6 = r0.dve;	 Catch:{ all -> 0x00b9 }
        r6 = r6.size();	 Catch:{ all -> 0x00b9 }
        r10 = r2.listIterator(r6);	 Catch:{ all -> 0x00b9 }
    L_0x002c:
        r2 = r10.hasPrevious();	 Catch:{ all -> 0x00b9 }
        if (r2 == 0) goto L_0x006d;
    L_0x0032:
        r2 = r10.previous();	 Catch:{ all -> 0x00b9 }
        r2 = (com.fossil.duy) r2;	 Catch:{ all -> 0x00b9 }
        r12 = r2.ayy();	 Catch:{ all -> 0x00b9 }
        r0 = r18;
        r14 = r0.dvd;	 Catch:{ all -> 0x00b9 }
        r12 = r12 + r14;
        r12 = r12 - r8;
        r14 = 0;
        r6 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1));
        if (r6 <= 0) goto L_0x004e;
    L_0x0048:
        r6 = r2.isAlive();	 Catch:{ all -> 0x00b9 }
        if (r6 != 0) goto L_0x005f;
    L_0x004e:
        r10.remove();	 Catch:{ all -> 0x00b9 }
        r7.add(r2);	 Catch:{ all -> 0x00b9 }
        r16 = r4;
        r4 = r3;
        r2 = r16;
    L_0x0059:
        r16 = r2;
        r3 = r4;
        r4 = r16;
        goto L_0x002c;
    L_0x005f:
        r2 = r2.isIdle();	 Catch:{ all -> 0x00b9 }
        if (r2 == 0) goto L_0x00dc;
    L_0x0065:
        r6 = r3 + 1;
        r2 = java.lang.Math.min(r4, r12);	 Catch:{ all -> 0x00b9 }
        r4 = r6;
        goto L_0x0059;
    L_0x006d:
        r0 = r18;
        r2 = r0.dve;	 Catch:{ all -> 0x00b9 }
        r0 = r18;
        r6 = r0.dve;	 Catch:{ all -> 0x00b9 }
        r6 = r6.size();	 Catch:{ all -> 0x00b9 }
        r6 = r2.listIterator(r6);	 Catch:{ all -> 0x00b9 }
    L_0x007d:
        r2 = r6.hasPrevious();	 Catch:{ all -> 0x00b9 }
        if (r2 == 0) goto L_0x009f;
    L_0x0083:
        r0 = r18;
        r2 = r0.dvc;	 Catch:{ all -> 0x00b9 }
        if (r3 <= r2) goto L_0x009f;
    L_0x0089:
        r2 = r6.previous();	 Catch:{ all -> 0x00b9 }
        r2 = (com.fossil.duy) r2;	 Catch:{ all -> 0x00b9 }
        r8 = r2.isIdle();	 Catch:{ all -> 0x00b9 }
        if (r8 == 0) goto L_0x00da;
    L_0x0095:
        r7.add(r2);	 Catch:{ all -> 0x00b9 }
        r6.remove();	 Catch:{ all -> 0x00b9 }
        r2 = r3 + -1;
    L_0x009d:
        r3 = r2;
        goto L_0x007d;
    L_0x009f:
        r2 = r7.isEmpty();	 Catch:{ all -> 0x00b9 }
        if (r2 == 0) goto L_0x00bd;
    L_0x00a5:
        r2 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        r2 = r4 / r2;
        r8 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        r8 = r8 * r2;
        r4 = r4 - r8;
        r4 = (int) r4;	 Catch:{ InterruptedException -> 0x00bc }
        r0 = r18;
        r0.wait(r2, r4);	 Catch:{ InterruptedException -> 0x00bc }
        r2 = 1;
        monitor-exit(r18);	 Catch:{ all -> 0x00b9 }
        goto L_0x000d;
    L_0x00b9:
        r2 = move-exception;
        monitor-exit(r18);	 Catch:{ all -> 0x00b9 }
        throw r2;
    L_0x00bc:
        r2 = move-exception;
    L_0x00bd:
        monitor-exit(r18);	 Catch:{ all -> 0x00b9 }
        r2 = 0;
        r4 = r7.size();
        r3 = r2;
    L_0x00c4:
        if (r3 >= r4) goto L_0x00d7;
    L_0x00c6:
        r2 = r7.get(r3);
        r2 = (com.fossil.duy) r2;
        r2 = r2.getSocket();
        com.fossil.dvw.m9969a(r2);
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x00c4;
    L_0x00d7:
        r2 = 1;
        goto L_0x000d;
    L_0x00da:
        r2 = r3;
        goto L_0x009d;
    L_0x00dc:
        r16 = r4;
        r4 = r3;
        r2 = r16;
        goto L_0x0059;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.duz.ayG():boolean");
    }
}
