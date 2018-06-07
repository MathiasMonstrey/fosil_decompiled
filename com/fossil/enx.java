package com.fossil;

import io.fabric.sdk.android.services.concurrency.Priority;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class enx implements enr<enz>, enw, enz {
    private final List<enz> dOL = new ArrayList();
    private final AtomicBoolean dOM = new AtomicBoolean(false);
    private final AtomicReference<Throwable> dON = new AtomicReference(null);

    public /* synthetic */ void df(Object obj) {
        m2954a((enz) obj);
    }

    public synchronized Collection<enz> aFc() {
        return Collections.unmodifiableCollection(this.dOL);
    }

    public synchronized void m2954a(enz com_fossil_enz) {
        this.dOL.add(com_fossil_enz);
    }

    public boolean aFI() {
        for (enz isFinished : aFc()) {
            if (!isFinished.isFinished()) {
                return false;
            }
        }
        return true;
    }

    public synchronized void dJ(boolean z) {
        this.dOM.set(z);
    }

    public boolean isFinished() {
        return this.dOM.get();
    }

    public Priority xS() {
        return Priority.NORMAL;
    }

    public void mo817h(Throwable th) {
        this.dON.set(th);
    }

    public int compareTo(Object obj) {
        return Priority.compareTo(this, obj);
    }

    public static boolean dh(Object obj) {
        try {
            enr com_fossil_enr = (enr) obj;
            enz com_fossil_enz = (enz) obj;
            enw com_fossil_enw = (enw) obj;
            if (com_fossil_enr == null || com_fossil_enz == null || com_fossil_enw == null) {
                return false;
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }
}
