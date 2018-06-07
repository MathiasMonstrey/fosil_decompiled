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
import com.portfolio.platform.data.model.microapp.RecommendedPreset;
import com.portfolio.platform.data.model.microapp.SavedPreset;
import com.portfolio.platform.data.model.microapp.SavedPreset.MappingSetType;
import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.PresetDataSource.AddOrUpdateActivePresetCallback;
import com.portfolio.platform.data.source.PresetDataSource.GetRecommendedPresetListCallback;
import com.portfolio.platform.data.source.PresetDataSource.GetSavedPresetCallback;
import com.portfolio.platform.data.source.PresetRepository;
import com.portfolio.platform.data.source.UAppSystemVersionRepository;
import com.portfolio.platform.enums.PermissionCodes;
import java.util.ArrayList;
import java.util.List;

public class dki extends ckb<C2892b, C2893c, C2891a> {
    private static final String TAG = dki.class.getSimpleName();
    private BroadcastReceiver broadcastReceiver = new C28861(this);
    private gy cEa;
    private boolean cLc = false;
    private ActivePreset cYg;
    private PresetRepository czg;
    private MicroAppSettingRepository mMicroAppSettingRepository;
    private String mSerial;
    private UAppSystemVersionRepository mUAppSystemVersionRepository;

    class C28861 extends BroadcastReceiver {
        final /* synthetic */ dki cYh;

        C28861(dki com_fossil_dki) {
            this.cYh = com_fossil_dki;
        }

        public void onReceive(Context context, Intent intent) {
            MFLogger.m12670d(dki.TAG, "onReceive mIsExecuted=" + this.cYh.cLc);
            if (CommunicateMode.values()[intent.getIntExtra(ButtonService.SERVICE_BLE_PHASE, CommunicateMode.IDLE.ordinal())] == CommunicateMode.SET_LINK_MAPPING && this.cYh.cLc) {
                this.cYh.cLc = false;
                if (intent.getIntExtra(ButtonService.SERVICE_ACTION_RESULT, -1) == ServiceActionResult.SUCCEEDED.ordinal()) {
                    MFLogger.m12670d(dki.TAG, "onReceive success");
                    this.cYh.aqL();
                    return;
                }
                MFLogger.m12670d(dki.TAG, "onReceive failed");
                int intExtra = intent.getIntExtra(ButtonService.LAST_DEVICE_ERROR_STATE, -1);
                ArrayList integerArrayListExtra = intent.getIntegerArrayListExtra(ButtonService.LIST_ERROR_STATE);
                if (integerArrayListExtra == null) {
                    integerArrayListExtra = new ArrayList(intExtra);
                }
                this.cYh.abr().onError(new C2891a(2, intExtra, PermissionCodes.convertBLEPermissionErrorCode(integerArrayListExtra)));
            }
        }
    }

    class C28883 implements GetSavedPresetCallback {
        final /* synthetic */ dki cYh;

        C28883(dki com_fossil_dki) {
            this.cYh = com_fossil_dki;
        }

        public void onSuccess(SavedPreset savedPreset) {
            MFLogger.m12670d(dki.TAG, "getSavedPreset onSuccess");
            this.cYh.cYg = new ActivePreset();
            this.cYh.cYg.setSerialNumber(this.cYh.mSerial);
            this.cYh.cYg.setUpdateAt(System.currentTimeMillis());
            this.cYh.cYg.setButtons(savedPreset.getButtons());
            this.cYh.cYg.setOriginalId(savedPreset.getId());
            List a = this.cYh.an(this.cYh.cYg.getButtonMappingList());
            if (a.isEmpty()) {
                this.cYh.aqK();
                return;
            }
            this.cYh.abr().onError(new C2891a(4, a));
            this.cYh.cLc = false;
        }

        public void onFail() {
            MFLogger.m12670d(dki.TAG, "getSavedPreset onFail");
            this.cYh.abr().onError(new C2891a(601));
        }
    }

    class C28894 implements C2299b {
        final /* synthetic */ dki cYh;

        C28894(dki com_fossil_dki) {
            this.cYh = com_fossil_dki;
        }

        public void onSuccess(List<MicroAppMapping> list) {
            MFLogger.m12670d(dki.TAG, "setPresetToDevice InitMicroAppMappingCallback onSuccess");
            PortfolioApp.ZQ().m12697e(this.cYh.mSerial, (List) list);
        }

        public void onError(int i) {
            MFLogger.m12670d(dki.TAG, "setPresetToDevice InitMicroAppMappingCallback onError");
            this.cYh.abr().onError(new C2891a(i));
        }
    }

    class C28905 implements AddOrUpdateActivePresetCallback {
        final /* synthetic */ dki cYh;

        C28905(dki com_fossil_dki) {
            this.cYh = com_fossil_dki;
        }

        public void onSuccess(ActivePreset activePreset) {
            MFLogger.m12670d(dki.TAG, "executeUseCase setActiveSavedPreset onSuccess");
            this.cYh.abr().onSuccess(new C2893c(activePreset));
        }

        public void onFail() {
            MFLogger.m12670d(dki.TAG, "executeUseCase setActiveSavedPreset onFail");
            this.cYh.abr().onError(new C2891a(2));
        }
    }

    public static final class C2891a implements C2131a {
        private final int cJJ;
        private final List<PermissionCodes> cXV;
        private final int mErrorCode;

        public C2891a(int i) {
            this(i, -1, new ArrayList());
        }

        public C2891a(int i, List<PermissionCodes> list) {
            this(i, -1, list);
        }

        public C2891a(int i, int i2, List<PermissionCodes> list) {
            this.mErrorCode = i;
            this.cJJ = i2;
            this.cXV = list;
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

    public static final class C2892b implements C2132b {
        private final String coS;
        private final MappingSetType coT;
        private final String mDeviceId;

        public C2892b(String str, String str2, MappingSetType mappingSetType) {
            this.mDeviceId = (String) cco.m5996s(str, "deviceId cannot be null!");
            this.coT = (MappingSetType) cco.m5996s(mappingSetType, "mappingSetType cannot be null!");
            this.coS = str2;
        }

        public String getDeviceId() {
            return this.mDeviceId;
        }
    }

    public static final class C2893c implements C2133c {
        private final ActivePreset cEs;

        public C2893c(ActivePreset activePreset) {
            this.cEs = activePreset;
        }

        public ActivePreset aqN() {
            return this.cEs;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m8915a((C2892b) c2132b);
    }

    dki(PresetRepository presetRepository, MicroAppSettingRepository microAppSettingRepository, UAppSystemVersionRepository uAppSystemVersionRepository, gy gyVar) {
        this.czg = (PresetRepository) cco.m5996s(presetRepository, "mMappingSetRepository cannot be null!");
        this.mMicroAppSettingRepository = (MicroAppSettingRepository) cco.m5996s(microAppSettingRepository, "microAppSettingRepository cannot be null!");
        this.mUAppSystemVersionRepository = (UAppSystemVersionRepository) cco.m5996s(uAppSystemVersionRepository, "uAppSystemVersionRepository cannot be null!");
        this.cEa = (gy) cco.m5996s(gyVar, "mLocalBroadcastManager cannot be null!");
    }

    protected void m8915a(final C2892b c2892b) {
        MFLogger.m12670d(TAG, "executeUseCase");
        this.cLc = true;
        this.mSerial = c2892b.mDeviceId;
        int fS = PortfolioApp.ZQ().fS(PortfolioApp.ZQ().aaa());
        MFLogger.m12670d(TAG, "Inside .setPresetToDevice currentDeviceSession=" + fS);
        if (fS == CommunicateMode.OTA.getValue()) {
            abr().onError(new C2891a(3));
        } else if (c2892b.coT == MappingSetType.RECOMMENDED) {
            MFLogger.m12670d(TAG, "executeUseCase mappingSetType=" + MappingSetType.RECOMMENDED);
            this.czg.getRecommendedPresets(c2892b.getDeviceId(), new GetRecommendedPresetListCallback(this) {
                final /* synthetic */ dki cYh;

                public void onSuccess(List<RecommendedPreset> list) {
                    MFLogger.m12670d(dki.TAG, "executeUseCase getRecommendedPresets recommendedPresetListSize=" + list.size());
                    this.cYh.cYg = new ActivePreset();
                    for (RecommendedPreset recommendedPreset : list) {
                        if (recommendedPreset.getId().equals(c2892b.coS)) {
                            this.cYh.cYg.setCreateAt(System.currentTimeMillis());
                            this.cYh.cYg.setUpdateAt(System.currentTimeMillis());
                            this.cYh.cYg.setOriginalId(recommendedPreset.getId());
                            this.cYh.cYg.setSerialNumber(recommendedPreset.getSerialNumber());
                            this.cYh.cYg.setButtons(recommendedPreset.getButtons());
                            break;
                        }
                    }
                    List a = this.cYh.an(this.cYh.cYg.getButtonMappingList());
                    if (a.isEmpty()) {
                        this.cYh.aqK();
                        return;
                    }
                    this.cYh.abr().onError(new C2891a(4, a));
                    this.cYh.cLc = false;
                }

                public void onFail() {
                    MFLogger.m12670d(dki.TAG, "executeUseCase getRecommendedPresets onFail");
                    this.cYh.abr().onError(new C2891a(601));
                }
            });
        } else {
            this.czg.getSavedPreset(c2892b.coS, new C28883(this));
        }
    }

    private List<PermissionCodes> an(List<ButtonMapping> list) {
        cco.ce(list);
        List<PermissionCodes> arrayList = new ArrayList();
        boolean auD = dre.dff.auD();
        boolean cx = dre.dff.cx(PortfolioApp.ZQ());
        boolean auC = dre.dff.auC();
        for (ButtonMapping microAppId : list) {
            if (MicroAppID.UAPP_COMMUTE_TIME.getValue().equalsIgnoreCase(microAppId.getMicroAppId())) {
                if (!(auD || arrayList.contains(PermissionCodes.BLUETOOTH_OFF))) {
                    arrayList.add(PermissionCodes.BLUETOOTH_OFF);
                }
                if (!(cx || arrayList.contains(PermissionCodes.BLUETOOTH_OFF))) {
                    arrayList.add(PermissionCodes.LOCATION_PERMISSION_FEATURE_OFF);
                }
                if (!(auC || arrayList.contains(PermissionCodes.BLUETOOTH_OFF))) {
                    arrayList.add(PermissionCodes.LOCATION_SERVICE_FEATURE_OFF);
                }
            } else if (!(auD || arrayList.contains(PermissionCodes.BLUETOOTH_OFF))) {
                arrayList.add(PermissionCodes.BLUETOOTH_OFF);
            }
        }
        return arrayList;
    }

    private void aqK() {
        MFLogger.m12670d(TAG, "setPresetToDevice");
        drf.m9470a(this.mSerial, this.cYg.getButtonMappingList(), this.mMicroAppSettingRepository, this.mUAppSystemVersionRepository, new C28894(this));
    }

    private void aqL() {
        MFLogger.m12670d(TAG, "executeUseCase savePresetToDB");
        this.czg.setIsActivePresetCacheDirty(true);
        this.czg.addOrUpdateActivePreset(this.cYg, new C28905(this));
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
