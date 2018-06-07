package com.fossil;

import android.os.Bundle;
import android.text.TextUtils;
import com.fossil.clx.C2176o;
import com.fossil.clx.C2177p;
import com.fossil.clx.C2187z;
import com.misfit.frameworks.buttonservice.model.microapp.MicroAppInstruction.MicroAppID;
import com.misfit.frameworks.buttonservice.model.microapp.RingPhoneInstruction;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.enums.Gesture;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.Ringtone;
import com.portfolio.platform.data.model.microapp.ActivePreset;
import com.portfolio.platform.data.model.microapp.ButtonMapping;
import com.portfolio.platform.data.model.microapp.MicroAppSetting;
import com.portfolio.platform.data.model.microapp.PusherConfiguration;
import com.portfolio.platform.data.model.microapp.PusherConfiguration.Pusher;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.MicroAppSettingCallback;
import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.PresetDataSource.GetActivePresetCallback;
import com.portfolio.platform.data.source.PresetRepository;
import com.portfolio.platform.service.microapp.CommuteTimeService;
import com.portfolio.platform.service.microapp.enums.ServiceStatus;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class cnk implements cta {
    private static final String TAG = cnk.class.getCanonicalName();
    private static cnk cze;
    private CopyOnWriteArrayList<csy> czf = new CopyOnWriteArrayList();
    PresetRepository czg;
    MicroAppSettingRepository mMicroAppSettingRepository;

    static /* synthetic */ class C22212 {
        static final /* synthetic */ int[] f1455xb89372e = new int[MicroAppID.values().length];

        static {
            try {
                f1455xb89372e[MicroAppID.UAPP_RING_PHONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1455xb89372e[MicroAppID.UAPP_WEATHER_STANDARD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1455xb89372e[MicroAppID.UAPP_COMMUTE_TIME.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    class C2223a implements Runnable {
        final /* synthetic */ cnk czh;
        private int event;
        private String serial;

        class C22221 implements GetActivePresetCallback {
            final /* synthetic */ C2223a czi;

            C22221(C2223a c2223a) {
                this.czi = c2223a;
            }

            public void onSuccess(ActivePreset activePreset) {
                MFLogger.m12670d(cnk.TAG, "getActivePreset onSuccess serial=" + this.czi.serial);
                if (activePreset != null) {
                    for (ButtonMapping buttonMapping : activePreset.getButtonMappingList()) {
                        if (Pusher.getPusherFromValue(buttonMapping.getButton()) == PusherConfiguration.getPusherByGesture(Gesture.fromInt(this.czi.event))) {
                            this.czi.czh.au(this.czi.serial, buttonMapping.getMicroAppId());
                            return;
                        }
                    }
                }
            }

            public void onFail() {
                MFLogger.m12670d(cnk.TAG, "getActivePreset onFail serial=" + this.czi.serial);
            }
        }

        C2223a(cnk com_fossil_cnk, String str, int i) {
            this.czh = com_fossil_cnk;
            this.serial = str;
            this.event = i;
        }

        public void run() {
            MFLogger.m12670d(cnk.TAG, "Inside SteamingAction .run - event=" + this.event + ", serial=" + this.serial);
            if (TextUtils.isEmpty(this.serial)) {
                MFLogger.m12671e(cnk.TAG, "Inside .onStreamingEvent of " + this.serial + " no active device");
            } else {
                this.czh.czg.getActivePreset(PortfolioApp.ZQ().aaa(), new C22221(this));
            }
        }
    }

    private cnk() {
        PortfolioApp.cM(this);
        PortfolioApp.ZQ().aam().mo1830a(this);
    }

    public static synchronized cnk abV() {
        cnk com_fossil_cnk;
        synchronized (cnk.class) {
            if (cze == null) {
                cze = new cnk();
            }
            com_fossil_cnk = cze;
        }
        return com_fossil_cnk;
    }

    @dxn
    public void onStreamingEvent(C2187z c2187z) {
        MFLogger.m12670d(TAG, "Inside " + TAG + ".onStreamingEvent - event=" + c2187z.abw() + ", serial=" + c2187z.getSerial());
        new Thread(new C2223a(this, c2187z.getSerial(), c2187z.abw())).start();
    }

    @dxn
    public void onMicroAppEvent(C2177p c2177p) {
        MFLogger.m12670d(TAG, "Inside " + TAG + ".onMicroAppEvent - event=" + c2177p.abw() + ", serial=" + c2177p.getSerial());
        new Thread(new C2223a(this, c2177p.getSerial(), c2177p.abw())).start();
    }

    @dxn
    public void onMicroAppCancelEvent(C2176o c2176o) {
        MFLogger.m12670d(TAG, "Inside " + TAG + ".onMicroAppCancelEvent - event=" + c2176o.abw() + ", serial=" + c2176o.getSerial());
        m7211R(this.czf);
    }

    public void mo1890a(int i, ServiceStatus serviceStatus) {
        MFLogger.m12670d(TAG, "onStatusChanged action " + i);
    }

    public void mo1891a(csy com_fossil_csy) {
        MFLogger.m12670d(TAG, "addObject");
        if (this.czf != null && !this.czf.contains(com_fossil_csy)) {
            MFLogger.m12670d(TAG, "addObject service actionId " + com_fossil_csy.afs());
            this.czf.add(com_fossil_csy);
        }
    }

    public void mo1892b(csy com_fossil_csy) {
        MFLogger.m12670d(TAG, "removeObject");
        if (this.czf != null && !this.czf.isEmpty()) {
            MFLogger.m12670d(TAG, "removeObject mServiceListSize=" + this.czf.size());
            Iterator it = this.czf.iterator();
            while (it.hasNext()) {
                csy com_fossil_csy2 = (csy) it.next();
                if (com_fossil_csy2.afs() == com_fossil_csy.afs()) {
                    MFLogger.m12670d(TAG, "removeObject actionId " + com_fossil_csy.afs());
                    this.czf.remove(com_fossil_csy2);
                }
            }
        }
    }

    private void m7211R(List<csy> list) {
        if (list != null && this.czf.size() > 0) {
            MFLogger.m12670d(TAG, "stopServices serviceListSize=" + this.czf.size());
            for (csy aft : list) {
                aft.aft();
            }
        }
    }

    private void au(final String str, final String str2) {
        this.mMicroAppSettingRepository.getMicroAppSetting(str2, new MicroAppSettingCallback(this) {
            final /* synthetic */ cnk czh;

            public void onSuccess(MicroAppSetting microAppSetting) {
                MFLogger.m12670d(cnk.TAG, "getMicroAppSetting onSuccess");
                switch (C22212.f1455xb89372e[MicroAppID.getMicroAppId(str2).ordinal()]) {
                    case 1:
                        MFLogger.m12670d(cnk.TAG, "Inside " + cnk.TAG + ".MicroAppAction.run UAPP_RING_PHONE microAppSetting=" + microAppSetting.getSetting());
                        this.czh.m7214a(str, microAppSetting);
                        return;
                    case 2:
                        MFLogger.m12670d(cnk.TAG, "Inside SteamingAction .run WEATHER_ACTION microAppSetting=" + microAppSetting.getSetting());
                        new Bundle().putString(Constants.EXTRA_INFO, microAppSetting.getSetting());
                        return;
                    case 3:
                        MFLogger.m12670d(cnk.TAG, "Inside SteamingAction .run COMMUTE_ACTION microAppSetting=" + microAppSetting.getSetting());
                        Bundle bundle = new Bundle();
                        bundle.putString(Constants.EXTRA_INFO, microAppSetting.getSetting());
                        CommuteTimeService.a(PortfolioApp.ZQ(), bundle, cnk.cze);
                        return;
                    default:
                        return;
                }
            }

            public void onFail() {
                MFLogger.m12670d(cnk.TAG, "getMicroAppSetting onFail");
                switch (C22212.f1455xb89372e[MicroAppID.getMicroAppId(str2).ordinal()]) {
                    case 1:
                        this.czh.m7214a(str, new MicroAppSetting(MicroAppID.UAPP_RING_PHONE.getValue(), new cfj().toJson(new Ringtone("", Constants.RINGTONE_DEFAULT))));
                        return;
                    default:
                        return;
                }
            }
        });
    }

    private void m7214a(String str, MicroAppSetting microAppSetting) {
        MFLogger.m12670d(TAG, "startRingMyPhone");
        try {
            Ringtone ringtone = (Ringtone) new cfj().m6205c(microAppSetting.getSetting(), Ringtone.class);
            MFLogger.m12670d(TAG, "Inside " + TAG + ".MicroAppAction.run - ringtone=" + microAppSetting.getSetting());
            PortfolioApp.ZQ().sendMicroAppRemoteActivity(str, new RingPhoneInstruction());
            List<Ringtone> abF = cmk.abF();
            if (abF.size() > 0) {
                for (Ringtone ringtone2 : abF) {
                    if (ringtone2.getName().equals(ringtone.getName())) {
                        ringtone2.setExtension(Constants.MP3_EXTENSION);
                        cns.adq().m7260a(ringtone2);
                        return;
                    }
                }
            }
            cns.adq().m7260a(new Ringtone("", Constants.RINGTONE_DEFAULT));
        } catch (Exception e) {
            MFLogger.m12670d("AppUtil", "Error when read asset file - ex=" + e.toString());
        }
    }
}
