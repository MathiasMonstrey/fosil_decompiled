package com.fossil;

import android.location.Location;

final class bmn extends bxb {
    private final bgl<bus> buG;

    bmn(bgl<bus> com_fossil_bgl_com_fossil_bus) {
        this.buG = com_fossil_bgl_com_fossil_bus;
    }

    public final synchronized void onLocationChanged(Location location) {
        this.buG.m5138a(new bmo(this, location));
    }

    public final synchronized void release() {
        this.buG.clear();
    }
}
