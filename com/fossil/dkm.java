package com.fossil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.fossil.drf.C2299b;
import com.misfit.frameworks.buttonservice.ButtonService;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.enums.ServiceActionResult;
import com.misfit.frameworks.buttonservice.model.microapp.MicroAppInstruction.MicroAppID;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.MicroAppMapping;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.microapp.ActivePreset;
import com.portfolio.platform.data.model.microapp.ButtonMapping;
import com.portfolio.platform.data.model.microapp.PusherConfiguration.Pusher;
import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.PresetDataSource.AddOrUpdateActivePresetCallback;
import com.portfolio.platform.data.source.PresetDataSource.GetActivePresetCallback;
import com.portfolio.platform.data.source.PresetRepository;
import com.portfolio.platform.data.source.UAppSystemVersionRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class dkm extends ckb<C2902b, C2903c, C2901a> {
    private static final String TAG = dkm.class.getSimpleName();
    private BroadcastReceiver broadcastReceiver = new C28971(this);
    private gy cEa;
    private ActivePreset cYg;
    private boolean cYm = false;
    private PresetRepository czg;
    private MicroAppSettingRepository mMicroAppSettingRepository;
    private String mSerial;
    private UAppSystemVersionRepository mUAppSystemVersionRepository;

    class C28971 extends BroadcastReceiver {
        final /* synthetic */ dkm cYn;

        C28971(dkm com_fossil_dkm) {
            this.cYn = com_fossil_dkm;
        }

        public void onReceive(Context context, Intent intent) {
            MFLogger.m12670d(dkm.TAG, "onReceive mIsExecuted=" + this.cYn.cYm);
            if (CommunicateMode.values()[intent.getIntExtra(ButtonService.SERVICE_BLE_PHASE, CommunicateMode.IDLE.ordinal())] == CommunicateMode.SET_LINK_MAPPING && this.cYn.cYm) {
                this.cYn.cYm = false;
                if (intent.getIntExtra(ButtonService.SERVICE_ACTION_RESULT, -1) == ServiceActionResult.SUCCEEDED.ordinal()) {
                    MFLogger.m12670d(dkm.TAG, "onReceive success");
                    this.cYn.aqL();
                    return;
                }
                MFLogger.m12670d(dkm.TAG, "onReceive failed");
                int intExtra = intent.getIntExtra(ButtonService.LAST_DEVICE_ERROR_STATE, -1);
                ArrayList integerArrayListExtra = intent.getIntegerArrayListExtra(ButtonService.LIST_ERROR_STATE);
                if (integerArrayListExtra == null) {
                    integerArrayListExtra = new ArrayList(intExtra);
                }
                this.cYn.abr().onError(new C2901a(2, intExtra, integerArrayListExtra));
            }
        }
    }

    class C28993 implements C2299b {
        final /* synthetic */ dkm cYn;

        C28993(dkm com_fossil_dkm) {
            this.cYn = com_fossil_dkm;
        }

        public void onSuccess(List<MicroAppMapping> list) {
            this.cYn.cYm = true;
            PortfolioApp.ZQ().m12697e(this.cYn.mSerial, (List) list);
        }

        public void onError(int i) {
            this.cYn.abr().onError(new C2901a(i));
        }
    }

    class C29004 implements AddOrUpdateActivePresetCallback {
        final /* synthetic */ dkm cYn;

        C29004(dkm com_fossil_dkm) {
            this.cYn = com_fossil_dkm;
        }

        public void onSuccess(ActivePreset activePreset) {
            MFLogger.m12670d(dkm.TAG, "executeUseCase addOrUpdateSavedPreset onSuccess");
            this.cYn.abr().onSuccess(new C2903c(activePreset));
        }

        public void onFail() {
            MFLogger.m12670d(dkm.TAG, "executeUseCase addOrUpdateSavedPreset onFail");
            this.cYn.abr().onError(new C2901a(601));
        }
    }

    public static final class C2901a implements C2131a {
        private final int cJJ;
        private final ArrayList<Integer> cJK;
        private final int mErrorCode;

        public C2901a(int i) {
            this(i, -1, new ArrayList());
        }

        public C2901a(int i, int i2, ArrayList<Integer> arrayList) {
            this.mErrorCode = i;
            this.cJJ = i2;
            this.cJK = arrayList;
        }

        public int getErrorCode() {
            return this.mErrorCode;
        }

        public ArrayList<Integer> ajf() {
            return this.cJK;
        }

        public int ajg() {
            return this.cJJ;
        }
    }

    public static final class C2902b implements C2132b {
        private final String cFB;
        private final List<Pusher> cYp;

        public C2902b(String str, List<Pusher> list) {
            this.cFB = (String) cco.m5996s(str, "serial cannot be null!");
            this.cYp = (List) cco.m5996s(list, "pusherList cannot be null!");
        }
    }

    public static final class C2903c implements C2133c {
        private final ActivePreset cEs;

        public C2903c(ActivePreset activePreset) {
            this.cEs = activePreset;
        }

        public ActivePreset aqN() {
            return this.cEs;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m8934a((C2902b) c2132b);
    }

    dkm(PresetRepository presetRepository, MicroAppSettingRepository microAppSettingRepository, UAppSystemVersionRepository uAppSystemVersionRepository, gy gyVar) {
        this.czg = (PresetRepository) cco.m5996s(presetRepository, "mappingSetRepository cannot be null!");
        this.mMicroAppSettingRepository = (MicroAppSettingRepository) cco.m5996s(microAppSettingRepository, "microAppSettingRepository cannot be null!");
        this.mUAppSystemVersionRepository = (UAppSystemVersionRepository) cco.m5996s(uAppSystemVersionRepository, "uAppSystemVersionRepository cannot be null!");
        this.cEa = (gy) cco.m5996s(gyVar, "mLocalBroadcastManager cannot be null!");
    }

    protected void m8934a(final C2902b c2902b) {
        MFLogger.m12670d(TAG, "executeUseCase");
        this.mSerial = c2902b.cFB;
        int fS = PortfolioApp.ZQ().fS(PortfolioApp.ZQ().aaa());
        MFLogger.m12670d(TAG, "Inside .setPresetToDevice currentDeviceSession=" + fS);
        if (fS == CommunicateMode.OTA.getValue()) {
            abr().onError(new C2901a(3));
        } else {
            this.czg.getActivePreset(this.mSerial, new GetActivePresetCallback(this) {
                final /* synthetic */ dkm cYn;

                public void onSuccess(ActivePreset activePreset) {
                    MFLogger.m12670d(dkm.TAG, "executeUseCase getActivePreset onSuccess buttons=" + activePreset.getButtons());
                    this.cYn.m8929a(activePreset, c2902b.cYp);
                }

                public void onFail() {
                    MFLogger.m12670d(dkm.TAG, "executeUseCase getActivePreset onFail");
                    this.cYn.abr().onError(new C2901a(601));
                }
            });
        }
    }

    private void m8929a(ActivePreset activePreset, List<Pusher> list) {
        MFLogger.m12670d(TAG, "createNewPreset pusherList[0]=" + list.get(0) + " pusherList[1]=" + list.get(1) + "pusherList[2]=" + list.get(2));
        this.cYg = new ActivePreset(activePreset);
        List arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String a = m8927a(activePreset, (Pusher) list.get(i));
            String lj = lj(i);
            if (!a.equalsIgnoreCase(MicroAppID.UAPP_UNKNOWN.getValue())) {
                arrayList.add(new ButtonMapping(lj, a));
            }
        }
        try {
            this.cYg.setButtonMappingList(arrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        aqK();
    }

    private String lj(int i) {
        switch (i) {
            case 0:
                return Pusher.TOP_PUSHER.getValue();
            case 1:
                return Pusher.MID_PUSHER.getValue();
            case 2:
                return Pusher.BOTTOM_PUSHER.getValue();
            default:
                return "";
        }
    }

    private String m8927a(ActivePreset activePreset, Pusher pusher) {
        for (ButtonMapping buttonMapping : activePreset.getButtonMappingList()) {
            if (buttonMapping.getButton().equals(pusher.getValue())) {
                return buttonMapping.getMicroAppId();
            }
        }
        return MicroAppID.UAPP_UNKNOWN.getValue();
    }

    private void aqK() {
        MFLogger.m12670d(TAG, "setPresetToDevice");
        drf.m9470a(this.mSerial, this.cYg.getButtonMappingList(), this.mMicroAppSettingRepository, this.mUAppSystemVersionRepository, new C28993(this));
    }

    private void aqL() {
        MFLogger.m12670d(TAG, "savePresetToDB");
        this.czg.setIsActivePresetCacheDirty(true);
        this.czg.addOrUpdateActivePreset(this.cYg, new C29004(this));
    }

    public void ajd() {
        this.cEa.m11537a(this.broadcastReceiver, new IntentFilter(PortfolioApp.ZQ().getPackageName().concat(ButtonService.ACTION_SERVICE_BLE_RESPONSE)));
    }

    public void aje() {
        this.cEa.unregisterReceiver(this.broadcastReceiver);
    }
}
