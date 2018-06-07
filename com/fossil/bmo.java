package com.fossil;

import android.location.Location;

final class bmo implements bgo<bus> {
    private /* synthetic */ Location bwr;

    bmo(bmn com_fossil_bmn, Location location) {
        this.bwr = location;
    }

    public final void Oo() {
    }

    public final /* synthetic */ void bW(Object obj) {
        ((bus) obj).onLocationChanged(this.bwr);
    }
}
