package com.fossil;

import com.misfit.ble.shine.ShineProfile;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.FutureTask;

final class bpj extends Thread {
    private /* synthetic */ bpg bAX;
    private final Object bBa = new Object();
    private final BlockingQueue<FutureTask<?>> bBb;

    public bpj(bpg com_fossil_bpg, String str, BlockingQueue<FutureTask<?>> blockingQueue) {
        this.bAX = com_fossil_bpg;
        awa.bO(str);
        awa.bO(blockingQueue);
        this.bBb = blockingQueue;
        setName(str);
    }

    private final void m5471a(InterruptedException interruptedException) {
        this.bAX.Pf().Re().m5439d(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    public final void Rz() {
        synchronized (this.bBa) {
            this.bBa.notifyAll();
        }
    }

    public final void run() {
        Object obj = null;
        while (obj == null) {
            try {
                this.bAX.bAT.acquire();
                obj = 1;
            } catch (InterruptedException e) {
                m5471a(e);
            }
        }
        while (true) {
            try {
                FutureTask futureTask = (FutureTask) this.bBb.poll();
                if (futureTask != null) {
                    futureTask.run();
                } else {
                    synchronized (this.bBa) {
                        if (this.bBb.peek() == null && !this.bAX.bAU) {
                            try {
                                this.bBa.wait(ShineProfile.LOG_UPLOADING_DELAY);
                            } catch (InterruptedException e2) {
                                m5471a(e2);
                            }
                        }
                    }
                    synchronized (this.bAX.bAS) {
                        if (this.bBb.peek() == null) {
                            break;
                        }
                    }
                }
            } catch (Throwable th) {
                synchronized (this.bAX.bAS) {
                    this.bAX.bAT.release();
                    this.bAX.bAS.notifyAll();
                    if (this == this.bAX.bAM) {
                        this.bAX.bAM = null;
                    } else if (this == this.bAX.bAN) {
                        this.bAX.bAN = null;
                    } else {
                        this.bAX.Pf().Rc().log("Current scheduler thread is neither worker nor network");
                    }
                }
            }
        }
        synchronized (this.bAX.bAS) {
            this.bAX.bAT.release();
            this.bAX.bAS.notifyAll();
            if (this == this.bAX.bAM) {
                this.bAX.bAM = null;
            } else if (this == this.bAX.bAN) {
                this.bAX.bAN = null;
            } else {
                this.bAX.Pf().Rc().log("Current scheduler thread is neither worker nor network");
            }
        }
    }
}
