package com.fossil;

final class ett {
    static ets dTA;
    static long dTC;

    private ett() {
    }

    static ets aHI() {
        synchronized (ett.class) {
            if (dTA != null) {
                ets com_fossil_ets = dTA;
                dTA = com_fossil_ets.dTA;
                com_fossil_ets.dTA = null;
                dTC -= 2048;
                return com_fossil_ets;
            }
            return new ets();
        }
    }

    static void m11195b(ets com_fossil_ets) {
        if (com_fossil_ets.dTA != null || com_fossil_ets.dTB != null) {
            throw new IllegalArgumentException();
        } else if (!com_fossil_ets.dTy) {
            synchronized (ett.class) {
                if (dTC + 2048 > 65536) {
                    return;
                }
                dTC += 2048;
                com_fossil_ets.dTA = dTA;
                com_fossil_ets.limit = 0;
                com_fossil_ets.pos = 0;
                dTA = com_fossil_ets;
            }
        }
    }
}
