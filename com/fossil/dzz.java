package com.fossil;

import android.content.Context;
import com.tencent.wxop.stat.StatReportStrategy;

class dzz {
    private static volatile long f1487f = 0;
    private boolean aWM = false;
    private long aWN = System.currentTimeMillis();
    private dzm dCn;
    private StatReportStrategy dCo = null;
    private Context dCp = null;

    public dzz(dzm com_fossil_dzm) {
        this.dCn = com_fossil_dzm;
        this.dCo = dze.aBF();
        this.aWM = com_fossil_dzm.aCj();
        this.dCp = com_fossil_dzm.aBW();
    }

    private void HH() {
        if (ead.aCn().f1488a <= 0 || !dze.aXU) {
            m10380a(new eac(this));
            return;
        }
        ead.aCn().m10412b(this.dCn, null, this.aWM, true);
        ead.aCn().m10410a(-1);
    }

    private void HO() {
        if (this.dCn.aCm() != null && this.dCn.aCm().aCe()) {
            this.dCo = StatReportStrategy.INSTANT;
        }
        if (dze.aYx && dzi.dx(dzg.dBT).aCi()) {
            this.dCo = StatReportStrategy.INSTANT;
        }
        if (dze.aBG()) {
            dzg.dBR.cY("strategy=" + this.dCo.name());
        }
        switch (dzt.f1486a[this.dCo.ordinal()]) {
            case 1:
                HH();
                return;
            case 2:
                ead.dy(this.dCp).m10412b(this.dCn, null, this.aWM, false);
                if (dze.aBG()) {
                    dzg.dBR.cY("PERIOD currTime=" + this.aWN + ",nextPeriodSendTs=" + dzg.aXw + ",difftime=" + (dzg.aXw - this.aWN));
                }
                if (dzg.aXw == 0) {
                    dzg.aXw = ebg.m10443a(this.dCp, "last_period_ts", 0);
                    if (this.aWN > dzg.aXw) {
                        dzg.m10353X(this.dCp);
                    }
                    long aBO = this.aWN + ((long) ((dze.aBO() * 60) * 1000));
                    if (dzg.aXw > aBO) {
                        dzg.aXw = aBO;
                    }
                    ebj.eh(this.dCp).HJ();
                }
                if (dze.aBG()) {
                    dzg.dBR.cY("PERIOD currTime=" + this.aWN + ",nextPeriodSendTs=" + dzg.aXw + ",difftime=" + (dzg.aXw - this.aWN));
                }
                if (this.aWN > dzg.aXw) {
                    dzg.m10353X(this.dCp);
                    return;
                }
                return;
            case 3:
            case 4:
                ead.dy(this.dCp).m10412b(this.dCn, null, this.aWM, false);
                return;
            case 5:
                ead.dy(this.dCp).m10412b(this.dCn, new eaa(this), this.aWM, true);
                return;
            case 6:
                if (dzi.dx(dzg.dBT).HF() == 1) {
                    HH();
                    return;
                } else {
                    ead.dy(this.dCp).m10412b(this.dCn, null, this.aWM, false);
                    return;
                }
            case 7:
                if (ebb.m10440e(this.dCp)) {
                    m10380a(new eab(this));
                    return;
                }
                return;
            default:
                dzg.dBR.error("Invalid stat strategy:" + dze.aBF());
                return;
        }
    }

    private boolean IY() {
        if (dze.aXp > 0) {
            if (this.aWN > dzg.aYo) {
                dzg.aYF.clear();
                dzg.aYo = this.aWN + dze.aYw;
                if (dze.aBG()) {
                    dzg.dBR.cY("clear methodsCalledLimitMap, nextLimitCallClearTime=" + dzg.aYo);
                }
            }
            Integer valueOf = Integer.valueOf(this.dCn.aCl().a());
            Integer num = (Integer) dzg.aYF.get(valueOf);
            if (num != null) {
                dzg.aYF.put(valueOf, Integer.valueOf(num.intValue() + 1));
                if (num.intValue() > dze.aXp) {
                    if (dze.aBG()) {
                        dzg.dBR.da("event " + this.dCn.Iw() + " was discard, cause of called limit, current:" + num + ", limit:" + dze.aXp + ", period:" + dze.aYw + " ms");
                    }
                    return true;
                }
            }
            dzg.aYF.put(valueOf, Integer.valueOf(1));
        }
        return false;
    }

    private void m10380a(ebn com_fossil_ebn) {
        ebo.ei(dzg.dBT).m10459a(this.dCn, com_fossil_ebn);
    }

    public void HJ() {
        if (!IY()) {
            if (dze.bai > 0 && this.aWN >= f1487f) {
                dzg.dw(this.dCp);
                f1487f = this.aWN + dze.aXW;
                if (dze.aBG()) {
                    dzg.dBR.cY("nextFlushTime=" + f1487f);
                }
            }
            if (dzi.dx(this.dCp).aCj()) {
                if (dze.aBG()) {
                    dzg.dBR.cY("sendFailedCount=" + dzg.f1478a);
                }
                if (dzg.Ja()) {
                    ead.dy(this.dCp).m10412b(this.dCn, null, this.aWM, false);
                    if (this.aWN - dzg.aXv > 1800000) {
                        dzg.m10366d(this.dCp);
                        return;
                    }
                    return;
                }
                HO();
                return;
            }
            ead.dy(this.dCp).m10412b(this.dCn, null, this.aWM, false);
        }
    }
}
