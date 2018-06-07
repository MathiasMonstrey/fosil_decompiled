package com.fossil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
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
import com.portfolio.platform.data.model.microapp.MicroAppSetting;
import com.portfolio.platform.data.model.microapp.PusherConfiguration.Pusher;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.MicroAppSettingCallback;
import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.PresetDataSource.AddOrUpdateActivePresetCallback;
import com.portfolio.platform.data.source.PresetDataSource.GetActivePresetCallback;
import com.portfolio.platform.data.source.PresetRepository;
import com.portfolio.platform.data.source.UAppSystemVersionRepository;
import com.portfolio.platform.enums.PermissionCodes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class dkg extends ckb<C2884b, C2885c, C2883a> {
    private static final String TAG = dkg.class.getSimpleName();
    private BroadcastReceiver broadcastReceiver = new C28771(this);
    private gy cEa;
    private boolean cLc = false;
    private ActivePreset cVB;
    private PresetRepository czg;
    private String mMicroAppId;
    private MicroAppSettingRepository mMicroAppSettingRepository;
    private String mSerial;
    private UAppSystemVersionRepository mUAppSystemVersionRepository;

    class C28771 extends BroadcastReceiver {
        final /* synthetic */ dkg cYc;

        C28771(dkg com_fossil_dkg) {
            this.cYc = com_fossil_dkg;
        }

        public void onReceive(Context context, Intent intent) {
            MFLogger.m12670d(dkg.TAG, "onReceive mIsExecuted=" + this.cYc.cLc);
            if (CommunicateMode.values()[intent.getIntExtra(ButtonService.SERVICE_BLE_PHASE, CommunicateMode.IDLE.ordinal())] == CommunicateMode.SET_LINK_MAPPING && this.cYc.cLc) {
                this.cYc.cLc = false;
                if (intent.getIntExtra(ButtonService.SERVICE_ACTION_RESULT, -1) == ServiceActionResult.SUCCEEDED.ordinal()) {
                    MFLogger.m12670d(dkg.TAG, "onReceive success");
                    this.cYc.aqL();
                    return;
                }
                MFLogger.m12670d(dkg.TAG, "onReceive failed");
                int intExtra = intent.getIntExtra(ButtonService.LAST_DEVICE_ERROR_STATE, -1);
                ArrayList integerArrayListExtra = intent.getIntegerArrayListExtra(ButtonService.LIST_ERROR_STATE);
                if (integerArrayListExtra == null) {
                    integerArrayListExtra = new ArrayList(intExtra);
                }
                this.cYc.abr().onError(new C2883a(2, intExtra, PermissionCodes.convertBLEPermissionErrorCode(integerArrayListExtra)));
            }
        }
    }

    class C28793 implements C2299b {
        final /* synthetic */ dkg cYc;

        C28793(dkg com_fossil_dkg) {
            this.cYc = com_fossil_dkg;
        }

        public void onSuccess(List<MicroAppMapping> list) {
            MFLogger.m12670d(dkg.TAG, "initMicroAppMapping onSuccess");
            PortfolioApp.ZQ().m12697e(this.cYc.mSerial, (List) list);
        }

        public void onError(int i) {
            MFLogger.m12670d(dkg.TAG, "initMicroAppMapping onError error=" + i);
            this.cYc.abr().onError(new C2883a(i));
        }
    }

    class C28804 implements AddOrUpdateActivePresetCallback {
        final /* synthetic */ dkg cYc;

        C28804(dkg com_fossil_dkg) {
            this.cYc = com_fossil_dkg;
        }

        public void onSuccess(ActivePreset activePreset) {
            MFLogger.m12670d(dkg.TAG, "executeUseCase addOrUpdateSavedPreset onSuccess");
            this.cYc.m8896b(this.cYc.mMicroAppId, this.cYc.cVB);
        }

        public void onFail() {
            MFLogger.m12670d(dkg.TAG, "executeUseCase addOrUpdateSavedPreset onFail");
            this.cYc.abr().onError(new C2883a(2));
        }
    }

    class C28826 implements MicroAppSettingCallback {
        final /* synthetic */ dkg cYc;

        C28826(dkg com_fossil_dkg) {
            this.cYc = com_fossil_dkg;
        }

        public void onSuccess(MicroAppSetting microAppSetting) {
            MFLogger.m12670d(dkg.TAG, "addOrUpdateMicroAppSetting onSuccess");
        }

        public void onFail() {
            MFLogger.m12670d(dkg.TAG, "addOrUpdateMicroAppSetting onFail");
        }
    }

    public static final class C2883a implements C2131a {
        private final int cJJ;
        private final List<PermissionCodes> cXV;
        private final int mErrorCode;

        public C2883a(int i, int i2, List<PermissionCodes> list) {
            this.mErrorCode = i;
            this.cJJ = i2;
            this.cXV = list;
        }

        public C2883a(int i) {
            this(i, -1, new ArrayList());
        }

        public C2883a(int i, List<PermissionCodes> list) {
            this(i, -1, list);
        }

        public int getErrorCode() {
            return this.mErrorCode;
        }

        public List<PermissionCodes> aqG() {
            return this.cXV;
        }

        public int ajg() {
            return this.cJJ;
        }
    }

    public static final class C2884b implements C2132b {
        private final Pusher cVs;
        private final String mDeviceId;
        private final String mMicroAppId;

        public C2884b(String str, String str2, Pusher pusher) {
            this.mDeviceId = (String) cco.m5996s(str, "deviceId cannot be null!");
            this.mMicroAppId = (String) cco.ce(str2);
            this.cVs = (Pusher) cco.ce(pusher);
        }

        public String getDeviceId() {
            return this.mDeviceId;
        }
    }

    public static final class C2885c implements C2133c {
        private final ActivePreset cYe;

        public C2885c(ActivePreset activePreset) {
            this.cYe = activePreset;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m8902a((C2884b) c2132b);
    }

    dkg(PresetRepository presetRepository, MicroAppSettingRepository microAppSettingRepository, UAppSystemVersionRepository uAppSystemVersionRepository, gy gyVar) {
        this.czg = (PresetRepository) cco.m5996s(presetRepository, "mMappingSetRepository cannot be null!");
        this.mMicroAppSettingRepository = (MicroAppSettingRepository) cco.m5996s(microAppSettingRepository, "microAppSettingRepository cannot be null!");
        this.mUAppSystemVersionRepository = (UAppSystemVersionRepository) cco.m5996s(uAppSystemVersionRepository, "uAppSystemVersionRepository cannot be null!");
        this.cEa = (gy) cco.m5996s(gyVar, "mLocalBroadcastManager cannot be null!");
    }

    protected void m8902a(final C2884b c2884b) {
        this.cLc = true;
        MFLogger.m12670d(TAG, "executeUseCase serial=" + c2884b.getDeviceId());
        this.mSerial = c2884b.mDeviceId;
        this.mMicroAppId = c2884b.mMicroAppId;
        int fS = PortfolioApp.ZQ().fS(PortfolioApp.ZQ().aaa());
        MFLogger.m12670d(TAG, "Inside .setPresetToDevice currentDeviceSession=" + fS);
        if (fS == CommunicateMode.OTA.getValue()) {
            abr().onError(new C2883a(3));
            this.cLc = false;
            return;
        }
        if (MicroAppID.UAPP_COMMUTE_TIME.getValue().equalsIgnoreCase(this.mMicroAppId)) {
            List arrayList = new ArrayList();
            if (!dre.dff.auD()) {
                arrayList.add(PermissionCodes.BLUETOOTH_OFF);
            }
            if (!dre.dff.cx(PortfolioApp.ZQ())) {
                arrayList.add(PermissionCodes.LOCATION_PERMISSION_FEATURE_OFF);
            }
            if (!dre.dff.auC()) {
                arrayList.add(PermissionCodes.LOCATION_SERVICE_FEATURE_OFF);
            }
            if (!arrayList.isEmpty()) {
                abr().onError(new C2883a(4, arrayList));
                this.cLc = false;
                return;
            }
        }
        this.czg.getActivePreset(this.mSerial, new GetActivePresetCallback(this) {
            final /* synthetic */ dkg cYc;

            public void onSuccess(ActivePreset activePreset) {
                MFLogger.m12670d(dkg.TAG, "executeUseCase getActivePreset onSuccess");
                this.cYc.cVB = new ActivePreset();
                this.cYc.cVB.setUpdateAt(System.currentTimeMillis());
                this.cYc.cVB.setSerialNumber(activePreset.getSerialNumber());
                this.cYc.cVB.setCreateAt(activePreset.getCreateAt());
                this.cYc.cVB.setOriginalId("");
                try {
                    this.cYc.cVB.setButtonMappingList(this.cYc.m8890a(activePreset.getButtonMappingList(), c2884b.cVs, c2884b.mMicroAppId));
                    this.cYc.cVB.setUpdateAt(System.currentTimeMillis());
                    this.cYc.aqK();
                } catch (IOException e) {
                    e.printStackTrace();
                    this.cYc.abr().onError(new C2883a(2));
                }
            }

            public void onFail() {
                MFLogger.m12670d(dkg.TAG, "executeUseCase getActivePreset onFail");
                this.cYc.abr().onError(new C2883a(601));
            }
        });
    }

    private void aqK() {
        MFLogger.m12670d(TAG, "setPresetToDevice");
        drf.m9470a(this.mSerial, this.cVB.getButtonMappingList(), this.mMicroAppSettingRepository, this.mUAppSystemVersionRepository, new C28793(this));
    }

    private List<ButtonMapping> m8890a(List<ButtonMapping> list, Pusher pusher, String str) {
        MFLogger.m12670d(TAG, "updateButtonMappingList");
        List<ButtonMapping> arrayList = new ArrayList(list);
        ButtonMapping buttonMapping = new ButtonMapping(pusher.getValue(), str);
        int i = 0;
        while (i < arrayList.size()) {
            if (((ButtonMapping) arrayList.get(i)).getButton().equals(pusher.getValue())) {
                break;
            }
            i++;
        }
        i = -1;
        if (i == -1) {
            arrayList.add(buttonMapping);
        } else {
            arrayList.set(i, buttonMapping);
        }
        return arrayList;
    }

    private void aqL() {
        MFLogger.m12670d(TAG, "savePresetToDB");
        this.czg.setIsActivePresetCacheDirty(true);
        this.czg.addOrUpdateActivePreset(this.cVB, new C28804(this));
    }

    private void m8896b(final String str, final ActivePreset activePreset) {
        MFLogger.m12670d(TAG, "updateFirstUsedIfNeed");
        this.mMicroAppSettingRepository.getMicroAppSetting(str, new MicroAppSettingCallback(this) {
            final /* synthetic */ dkg cYc;

            public void onSuccess(MicroAppSetting microAppSetting) {
                MFLogger.m12670d(dkg.TAG, "updateFirstUsedIfNeed " + microAppSetting.getMicroAppId() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + microAppSetting.getFirstUsed() + " onSuccess");
                if (microAppSetting.getFirstUsed() <= 0) {
                    microAppSetting.setFirstUsed(System.currentTimeMillis());
                    this.cYc.m8901k(microAppSetting);
                }
                this.cYc.abr().onSuccess(new C2885c(activePreset));
            }

            public void onFail() {
                MFLogger.m12670d(dkg.TAG, "updateFirstUsedIfNeed getMicroAppSetting onFail");
                MicroAppSetting microAppSetting = new MicroAppSetting(str);
                microAppSetting.setFirstUsed(System.currentTimeMillis());
                this.cYc.m8901k(microAppSetting);
                this.cYc.abr().onSuccess(new C2885c(activePreset));
            }
        });
    }

    private void m8901k(MicroAppSetting microAppSetting) {
        this.mMicroAppSettingRepository.addOrUpdateMicroAppSetting(microAppSetting, new C28826(this));
    }

    public void ajd() {
        MFLogger.m12670d(TAG, "registerBroadcastReceiver");
        this.cEa.m11537a(this.broadcastReceiver, new IntentFilter(PortfolioApp.ZQ().getPackageName().concat(ButtonService.ACTION_SERVICE_BLE_RESPONSE)));
    }

    public void aje() {
        MFLogger.m12670d(TAG, "unregisterBroadcastReceiver");
        this.cEa.unregisterReceiver(this.broadcastReceiver);
    }
}
