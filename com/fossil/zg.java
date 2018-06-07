package com.fossil;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

class zg implements zm {
    private boolean aED;
    private final Set<zn> aFy = Collections.newSetFromMap(new WeakHashMap());
    private boolean aFz;

    zg() {
    }

    public void mo4445a(zn znVar) {
        this.aFy.add(znVar);
        if (this.aFz) {
            znVar.onDestroy();
        } else if (this.aED) {
            znVar.onStart();
        } else {
            znVar.onStop();
        }
    }

    void onStart() {
        this.aED = true;
        for (zn onStart : abl.a(this.aFy)) {
            onStart.onStart();
        }
    }

    void onStop() {
        this.aED = false;
        for (zn onStop : abl.a(this.aFy)) {
            onStop.onStop();
        }
    }

    void onDestroy() {
        this.aFz = true;
        for (zn onDestroy : abl.a(this.aFy)) {
            onDestroy.onDestroy();
        }
    }
}
