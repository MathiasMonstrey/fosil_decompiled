package com.fossil;

import com.fossil.dvj.C3227a;
import com.fossil.dvl.C3232a;
import com.fossil.wearables.fsl.dial.ConfigItem;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.enums.Action.Apps;
import com.misfit.frameworks.common.enums.Action.Presenter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public final class dwp {
    public final dvl dws;
    public final dvj dza;

    public static class C3269a {
        final dvj duK;
        final dvl dws;
        final long dzb;
        private Date dzc;
        private String dzd;
        private Date dze;
        private String dzf;
        private long dzg;
        private long dzh;
        private int dzi = -1;
        private String etag;
        private Date expires;

        public C3269a(long j, dvj com_fossil_dvj, dvl com_fossil_dvl) {
            this.dzb = j;
            this.duK = com_fossil_dvj;
            this.dws = com_fossil_dvl;
            if (com_fossil_dvl != null) {
                dve azt = com_fossil_dvl.azt();
                int size = azt.size();
                for (int i = 0; i < size; i++) {
                    String my = azt.my(i);
                    String mz = azt.mz(i);
                    if (ConfigItem.KEY_DATE.equalsIgnoreCase(my)) {
                        this.dzc = dwt.parse(mz);
                        this.dzd = mz;
                    } else if ("Expires".equalsIgnoreCase(my)) {
                        this.expires = dwt.parse(mz);
                    } else if ("Last-Modified".equalsIgnoreCase(my)) {
                        this.dze = dwt.parse(mz);
                        this.dzf = mz;
                    } else if ("ETag".equalsIgnoreCase(my)) {
                        this.etag = mz;
                    } else if ("Age".equalsIgnoreCase(my)) {
                        this.dzi = dwr.m10189L(mz, -1);
                    } else if (dwx.dzR.equalsIgnoreCase(my)) {
                        this.dzg = Long.parseLong(mz);
                    } else if (dwx.dzS.equalsIgnoreCase(my)) {
                        this.dzh = Long.parseLong(mz);
                    }
                }
            }
        }

        public dwp aAD() {
            dwp aAE = aAE();
            if (aAE.dza == null || !this.duK.azw().ayo()) {
                return aAE;
            }
            return new dwp(null, null);
        }

        private dwp aAE() {
            long j = 0;
            if (this.dws == null) {
                return new dwp(this.duK, null);
            }
            if (this.duK.ayS() && this.dws.azB() == null) {
                return new dwp(this.duK, null);
            }
            if (!dwp.m10176a(this.dws, this.duK)) {
                return new dwp(this.duK, null);
            }
            duu azw = this.duK.azw();
            if (azw.ayi() || C3269a.m10175l(this.duK)) {
                return new dwp(this.duK, null);
            }
            long toMillis;
            long aAG = aAG();
            long aAF = aAF();
            if (azw.ayk() != -1) {
                aAF = Math.min(aAF, TimeUnit.SECONDS.toMillis((long) azw.ayk()));
            }
            if (azw.ayn() != -1) {
                toMillis = TimeUnit.SECONDS.toMillis((long) azw.ayn());
            } else {
                toMillis = 0;
            }
            duu azw2 = this.dws.azw();
            if (!(azw2.ayl() || azw.aym() == -1)) {
                j = TimeUnit.SECONDS.toMillis((long) azw.aym());
            }
            if (azw2.ayi() || aAG + toMillis >= r4 + aAF) {
                C3227a azv = this.duK.azv();
                if (this.etag != null) {
                    azv.aY("If-None-Match", this.etag);
                } else if (this.dze != null) {
                    azv.aY("If-Modified-Since", this.dzf);
                } else if (this.dzc != null) {
                    azv.aY("If-Modified-Since", this.dzd);
                }
                dvj azx = azv.azx();
                if (C3269a.m10175l(azx)) {
                    return new dwp(azx, this.dws);
                }
                return new dwp(azx, null);
            }
            C3232a azD = this.dws.azD();
            if (toMillis + aAG >= aAF) {
                azD.bc("Warning", "110 HttpURLConnection \"Response is stale\"");
            }
            if (aAG > 86400000 && aAH()) {
                azD.bc("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
            }
            return new dwp(null, azD.azF());
        }

        private long aAF() {
            duu azw = this.dws.azw();
            if (azw.ayk() != -1) {
                return TimeUnit.SECONDS.toMillis((long) azw.ayk());
            }
            long time;
            if (this.expires != null) {
                time = this.expires.getTime() - (this.dzc != null ? this.dzc.getTime() : this.dzh);
                if (time <= 0) {
                    time = 0;
                }
                return time;
            } else if (this.dze == null || this.dws.azy().azq().aza() != null) {
                return 0;
            } else {
                time = (this.dzc != null ? this.dzc.getTime() : this.dzg) - this.dze.getTime();
                if (time > 0) {
                    return time / 10;
                }
                return 0;
            }
        }

        private long aAG() {
            long j = 0;
            if (this.dzc != null) {
                j = Math.max(0, this.dzh - this.dzc.getTime());
            }
            if (this.dzi != -1) {
                j = Math.max(j, TimeUnit.SECONDS.toMillis((long) this.dzi));
            }
            return (j + (this.dzh - this.dzg)) + (this.dzb - this.dzh);
        }

        private boolean aAH() {
            return this.dws.azw().ayk() == -1 && this.expires == null;
        }

        private static boolean m10175l(dvj com_fossil_dvj) {
            return (com_fossil_dvj.kK("If-Modified-Since") == null && com_fossil_dvj.kK("If-None-Match") == null) ? false : true;
        }
    }

    private dwp(dvj com_fossil_dvj, dvl com_fossil_dvl) {
        this.dza = com_fossil_dvj;
        this.dws = com_fossil_dvl;
    }

    public static boolean m10176a(dvl com_fossil_dvl, dvj com_fossil_dvj) {
        switch (com_fossil_dvl.azA()) {
            case MFNetworkReturnCode.RESPONSE_OK /*200*/:
            case 203:
            case 204:
            case 300:
            case Presenter.NEXT /*301*/:
            case 308:
            case 404:
            case 405:
            case 410:
            case 414:
            case Apps.BOLT /*501*/:
                break;
            case Presenter.PREVIOUS /*302*/:
            case 307:
                if (com_fossil_dvl.kK("Expires") == null && com_fossil_dvl.azw().ayk() == -1 && !com_fossil_dvl.azw().isPublic() && !com_fossil_dvl.azw().isPrivate()) {
                    return false;
                }
            default:
                return false;
        }
        return (com_fossil_dvl.azw().ayj() || com_fossil_dvj.azw().ayj()) ? false : true;
    }
}
