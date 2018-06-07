package com.fossil;

import android.content.Context;
import com.fossil.ckb.C2126d;
import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2133c;
import com.fossil.cwj.C2441a;
import com.fossil.cwj.C2442b;
import com.fossil.cwr.C2450a;
import com.fossil.cwr.C2451b;
import com.fossil.cwr.C2452c;
import com.fossil.cwt.C2454a;
import com.fossil.cxh.C2475a;
import com.fossil.cxh.C2476b;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.model.Alarm;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.enums.PermissionCodes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class cwl implements C2441a {
    private final String TAG = "AlarmMainPresenter";
    private List<Alarm> cIW;
    private int cJA;
    private final cmj cJv;
    private final C2442b cJw;
    private final cwt cJx;
    private final cxh cJy;
    private final cwr cJz;
    private final cmi cmS;
    private Context mApplicationContext;
    private String mDeviceId;
    private final cnr mSharedPreferencesManager;
    private final ckc mUseCaseHandler;

    class C24461 implements C2126d<C2454a, C2131a> {
        final /* synthetic */ cwl cJB;

        C24461(cwl com_fossil_cwl) {
            this.cJB = com_fossil_cwl;
        }

        public /* synthetic */ void onError(Object obj) {
            m7784a((C2131a) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m7785a((C2454a) obj);
        }

        public void m7785a(C2454a c2454a) {
            MFLogger.m12670d("AlarmMainPresenter", "GetAlarms onSuccess");
            this.cJB.cJw.afU();
            this.cJB.cIW = new ArrayList();
            for (Alarm clone : c2454a.aiX()) {
                this.cJB.cIW.add(clone.clone());
            }
            Collections.sort(this.cJB.cIW);
            this.cJB.cJA = 0;
            if (this.cJB.cIW.isEmpty()) {
                this.cJB.cJw.aiP();
            } else {
                this.cJB.cJw.mo2151a(this.cJB.cIW, this.cJB.cJA, false);
            }
        }

        public void m7784a(C2131a c2131a) {
            MFLogger.m12670d("AlarmMainPresenter", "GetAlarms onError");
            this.cJB.cJw.afU();
            this.cJB.cIW = new ArrayList();
            this.cJB.cJw.aiP();
        }
    }

    cwl(Context context, cmj com_fossil_cmj, C2442b c2442b, cmi com_fossil_cmi, cnr com_fossil_cnr, String str, ckc com_fossil_ckc, cwt com_fossil_cwt, cxh com_fossil_cxh, cwr com_fossil_cwr) {
        this.mApplicationContext = (Context) cco.m5996s(context, "applicationContext cannot be null!");
        this.cJv = (cmj) cco.m5996s(com_fossil_cmj, "analyticsHelper cannot be null!");
        this.cJw = (C2442b) cco.m5996s(c2442b, "view cannot be null!");
        this.cmS = com_fossil_cmi;
        this.mSharedPreferencesManager = com_fossil_cnr;
        this.mDeviceId = (String) cco.m5996s(str, "deviceId cannot be null!");
        this.mUseCaseHandler = (ckc) cco.m5996s(com_fossil_ckc, "useCaseHandler cannot be null!");
        this.cJx = (cwt) cco.m5996s(com_fossil_cwt, "getAlarms cannot be null!");
        this.cJy = (cxh) cco.m5996s(com_fossil_cxh, "setAlarms cannot be null!");
        this.cJz = (cwr) cco.m5996s(com_fossil_cwr, "deleteAlarm cannot be null!");
    }

    public void ahu() {
        this.cJw.cK(this);
    }

    public void start() {
        this.cJy.ajd();
        this.cJz.ajd();
        if (this.cIW == null) {
            MFLogger.m12670d("AlarmMainPresenter", "GetAlarms");
            this.cJw.afT();
            this.mUseCaseHandler.m6886a(this.cJx, null, new C24461(this));
        } else if (this.cIW.isEmpty()) {
            this.cJw.aiP();
        } else {
            this.cJw.mo2151a(this.cIW, this.cJA, false);
        }
        this.cJw.setDeviceId(this.mDeviceId);
        PortfolioApp.ZQ().m12685I(Collections.singletonList(CommunicateMode.SET_LIST_ALARM));
    }

    public void stop() {
        this.cJy.aje();
        this.cJz.aje();
    }

    public void mo2160e(Alarm alarm) {
        if (alarm.isSynced()) {
            for (Alarm synced : this.cIW) {
                synced.setSynced(true);
            }
            aiW();
        }
        this.cIW.add(alarm);
        Collections.sort(this.cIW);
        this.cJA = this.cIW.indexOf(alarm);
        this.cJw.mo2151a(this.cIW, this.cJA, true);
    }

    public void mo2158a(Alarm alarm, boolean z) {
        for (Alarm alarm2 : this.cIW) {
            if (alarm2.is(alarm)) {
                this.cIW.set(this.cIW.indexOf(alarm2), alarm);
                if (!z) {
                    break;
                }
                aiW();
            } else if (z) {
                alarm2.setSynced(true);
            }
        }
        Collections.sort(this.cIW);
        this.cJA = this.cIW.indexOf(alarm);
        this.cJw.mo2151a(this.cIW, this.cJA, false);
    }

    public synchronized void mo2159b(final Alarm alarm, boolean z) {
        MFLogger.m12670d("AlarmMainPresenter", "enableAlarm - alarm: " + alarm.getAlarmTitle() + " - enable: " + z);
        alarm.setActive(z);
        this.cJw.afT();
        this.mUseCaseHandler.m6886a(this.cJy, new C2476b(this.mDeviceId, this.cIW, alarm), new C2126d<C2133c, C2475a>(this) {
            final /* synthetic */ cwl cJB;

            public /* synthetic */ void onError(Object obj) {
                m7787a((C2475a) obj);
            }

            public /* synthetic */ void onSuccess(Object obj) {
                m7786a((C2133c) obj);
            }

            public void m7786a(C2133c c2133c) {
                MFLogger.m12670d("AlarmMainPresenter", "enableAlarm - onSuccess");
                this.cJB.cJw.afU();
                alarm.setSynced(true);
                this.cJB.mo2158a(alarm, true);
            }

            public void m7787a(C2475a c2475a) {
                MFLogger.m12670d("AlarmMainPresenter", "enableAlarm - onError");
                this.cJB.cJw.afU();
                int ajg = c2475a.ajg();
                MFLogger.m12670d("AlarmMainPresenter", "enableAlarm() - SetAlarms - onError - lastErrorCode = " + ajg);
                if (ajg == FailureCode.BLUETOOTH_IS_DISABLED || ajg == FailureCode.LOCATION_SERVICE_DISABLED || ajg == FailureCode.LOCATION_ACCESS_DENIED) {
                    this.cJB.cJw.m7524a((PermissionCodes[]) PermissionCodes.convertBLEPermissionErrorCode(c2475a.ajf()).toArray(new PermissionCodes[0]));
                } else {
                    this.cJB.cJw.aiQ();
                }
                this.cJB.mo2158a(c2475a.getAlarm(), false);
            }
        });
    }

    public synchronized void kj(final int i) {
        this.cJw.afT();
        this.mUseCaseHandler.m6886a(this.cJz, new C2451b(this.mDeviceId, this.cIW, (Alarm) this.cIW.get(i)), new C2126d<C2452c, C2450a>(this) {
            final /* synthetic */ cwl cJB;

            public /* synthetic */ void onError(Object obj) {
                m7788a((C2450a) obj);
            }

            public /* synthetic */ void onSuccess(Object obj) {
                m7789a((C2452c) obj);
            }

            public void m7789a(C2452c c2452c) {
                this.cJB.cJw.afU();
                if (c2452c != null) {
                    this.cJB.cIW.remove(c2452c.getAlarm());
                }
                for (Alarm synced : this.cJB.cIW) {
                    synced.setSynced(true);
                }
                if (this.cJB.cIW.isEmpty()) {
                    this.cJB.cJw.aiP();
                } else {
                    this.cJB.cJw.mo2151a(this.cJB.cIW, i, false);
                }
            }

            public void m7788a(C2450a c2450a) {
                this.cJB.cJw.afU();
                int ajg = c2450a.ajg();
                MFLogger.m12670d("AlarmMainPresenter", "deleteAlarm() - deleteAlarm - onError - lastErrorCode = " + ajg);
                if (ajg == FailureCode.BLUETOOTH_IS_DISABLED || ajg == FailureCode.LOCATION_SERVICE_DISABLED || ajg == FailureCode.LOCATION_ACCESS_DENIED) {
                    this.cJB.cJw.m7524a((PermissionCodes[]) PermissionCodes.convertBLEPermissionErrorCode(c2450a.ajf()).toArray(new PermissionCodes[0]));
                    return;
                }
                this.cJB.cJw.aiQ();
            }
        });
    }

    private void aiW() {
        MFLogger.m12670d("AlarmMainPresenter", "onSetAlarmsSuccess");
        this.cmS.bp(this.mApplicationContext);
        PortfolioApp.ZQ().fR(this.mDeviceId);
    }

    public List<Alarm> aiX() {
        return this.cIW;
    }

    public void m7795Y(List<Alarm> list) {
        this.cIW = list;
    }

    public String getDeviceId() {
        return this.mDeviceId;
    }

    public void setDeviceId(String str) {
        this.mDeviceId = str;
    }
}
