package com.fossil;

import android.content.Context;
import com.crashlytics.android.answers.SessionEvent;
import java.io.IOException;
import java.util.UUID;

class abx extends eoi<SessionEvent> {
    private epe aHE;

    abx(Context context, acc com_fossil_acc, enj com_fossil_enj, eol com_fossil_eol) throws IOException {
        super(context, com_fossil_acc, com_fossil_enj, com_fossil_eol, 100);
    }

    protected String xo() {
        return "sa" + "_" + UUID.randomUUID().toString() + "_" + this.aIg.aFr() + ".tap";
    }

    protected int xp() {
        return this.aHE == null ? super.xp() : this.aHE.dPR;
    }

    protected int xq() {
        return this.aHE == null ? super.xq() : this.aHE.dPP;
    }

    void m2903a(epe com_fossil_epe) {
        this.aHE = com_fossil_epe;
    }
}
