package com.fossil;

import android.os.Bundle;
import org.joda.time.DateTimeConstants;

public final class bbx {
    public static final bbx bpH = new bbx(0, 30, DateTimeConstants.SECONDS_PER_HOUR);
    private static bbx bpI = new bbx(1, 30, DateTimeConstants.SECONDS_PER_HOUR);
    private final int bpJ;
    private final int bpK = 30;
    private final int bpL = DateTimeConstants.SECONDS_PER_HOUR;

    private bbx(int i, int i2, int i3) {
        this.bpJ = i;
    }

    public final int MA() {
        return this.bpL;
    }

    public final int My() {
        return this.bpJ;
    }

    public final int Mz() {
        return this.bpK;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bbx)) {
            return false;
        }
        bbx com_fossil_bbx = (bbx) obj;
        return com_fossil_bbx.bpJ == this.bpJ && com_fossil_bbx.bpK == this.bpK && com_fossil_bbx.bpL == this.bpL;
    }

    public final int hashCode() {
        return (((((this.bpJ + 1) ^ 1000003) * 1000003) ^ this.bpK) * 1000003) ^ this.bpL;
    }

    public final String toString() {
        int i = this.bpJ;
        int i2 = this.bpK;
        return "policy=" + i + " initial_backoff=" + i2 + " maximum_backoff=" + this.bpL;
    }

    public final Bundle m4822u(Bundle bundle) {
        bundle.putInt("retry_policy", this.bpJ);
        bundle.putInt("initial_backoff_seconds", this.bpK);
        bundle.putInt("maximum_backoff_seconds", this.bpL);
        return bundle;
    }
}
