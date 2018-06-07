package com.fossil;

import com.fossil.dvl.C3232a;
import java.io.IOException;

public final class dww implements dxd {
    private final dws duU;
    private final dwu dzl;

    public dww(dwu com_fossil_dwu, dws com_fossil_dws) {
        this.dzl = com_fossil_dwu;
        this.duU = com_fossil_dws;
    }

    public etu mo2760a(dvj com_fossil_dvj, long j) throws IOException {
        if ("chunked".equalsIgnoreCase(com_fossil_dvj.kK("Transfer-Encoding"))) {
            return this.duU.aAQ();
        }
        if (j != -1) {
            return this.duU.aN(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public void aAI() throws IOException {
        this.duU.flush();
    }

    public void mo2761a(dxa com_fossil_dxa) throws IOException {
        this.duU.m10207a(com_fossil_dxa);
    }

    public void mo2766m(dvj com_fossil_dvj) throws IOException {
        this.dzl.aAX();
        this.duU.m10206a(com_fossil_dvj.azt(), dwz.m10243a(com_fossil_dvj, this.dzl.aBb().ayw().ayg().type(), this.dzl.aBb().ayB()));
    }

    public C3232a aAJ() throws IOException {
        return this.duU.aAP();
    }

    public void aAK() throws IOException {
        if (aAL()) {
            this.duU.aAM();
        } else {
            this.duU.aAN();
        }
    }

    public boolean aAL() {
        if ("close".equalsIgnoreCase(this.dzl.aAZ().kK("Connection")) || "close".equalsIgnoreCase(this.dzl.aBa().kK("Connection")) || this.duU.isClosed()) {
            return false;
        }
        return true;
    }

    public dvm mo2767p(dvl com_fossil_dvl) throws IOException {
        return new dwy(com_fossil_dvl.azt(), etp.m11180c(m10231t(com_fossil_dvl)));
    }

    private etv m10231t(dvl com_fossil_dvl) throws IOException {
        if (!dwu.m10226s(com_fossil_dvl)) {
            return this.duU.aO(0);
        }
        if ("chunked".equalsIgnoreCase(com_fossil_dvl.kK("Transfer-Encoding"))) {
            return this.duU.m10208b(this.dzl);
        }
        long u = dwx.m10242u(com_fossil_dvl);
        if (u != -1) {
            return this.duU.aO(u);
        }
        return this.duU.aAR();
    }
}
