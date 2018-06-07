package com.fossil;

import android.os.Looper;

public final class bgl<L> {
    private volatile L biy;
    private final bgm buy;
    private final bgn<L> buz;

    bgl(Looper looper, L l, String str) {
        this.buy = new bgm(this, looper);
        this.biy = awa.m4640p(l, "Listener must not be null");
        this.buz = new bgn(l, awa.df(str));
    }

    public final bgn<L> On() {
        return this.buz;
    }

    public final void m5138a(bgo<? super L> com_fossil_bgo__super_L) {
        awa.m4640p(com_fossil_bgo__super_L, "Notifier must not be null");
        this.buy.sendMessage(this.buy.obtainMessage(1, com_fossil_bgo__super_L));
    }

    final void m5139b(bgo<? super L> com_fossil_bgo__super_L) {
        Object obj = this.biy;
        if (obj == null) {
            com_fossil_bgo__super_L.Oo();
            return;
        }
        try {
            com_fossil_bgo__super_L.bW(obj);
        } catch (RuntimeException e) {
            com_fossil_bgo__super_L.Oo();
            throw e;
        }
    }

    public final void clear() {
        this.biy = null;
    }
}
