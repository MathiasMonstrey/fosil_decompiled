package com.portfolio.platform.data.source;

import android.text.TextUtils;
import com.fossil.ckb.d;
import com.fossil.ckc;
import com.fossil.cyk;
import com.fossil.cyk.a;
import com.fossil.cyk.b;
import com.fossil.cyk.c;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.DataVersion;
import com.portfolio.platform.data.source.DataVersioningDataSource.GetDataVersioningCallback;
import com.portfolio.platform.data.source.scope.Local;
import com.portfolio.platform.data.source.scope.Remote;
import com.portfolio.platform.model.UAppSystemVersionModel;
import java.util.ArrayList;
import java.util.List;

public class DataVersioningRepository implements DataVersioningDataSource {
    private static final String TAG = DataVersioningRepository.class.getSimpleName();
    private String[] deviceDataVersioningKey = new String[]{"active-presets", "recommended-presets", "micro-apps", "micro-app-variants", "firmwares"};
    private UAppSystemVersionRepository mAppSystemVersionRepository;
    private DeviceRepository mDeviceRepository;
    private ExploreRepository mExplorationRepository;
    private cyk mFetchFirmwareUseCase;
    private LandingPageRepository mLandingPageRepository;
    private DataVersioningDataSource mLocalDataSource;
    private MicroAppSettingRepository mMicroAppSettingRepository;
    private PresetRepository mPresetRepository;
    private DataVersioningDataSource mRemoteDataSource;
    private ckc mUseCaseHandler;
    private UserRepository mUserRepository;
    private WidgetRepository mWidgetRepository;

    class C47631 implements GetDataVersioningCallback {

        class C47621 implements d<c, b> {
            C47621() {
            }

            public void onSuccess(c cVar) {
            }

            public void onError(b bVar) {
            }
        }

        C47631() {
        }

        public void onSuccess(List<DataVersion> list) {
            MFLogger.d(DataVersioningRepository.TAG, "Inside .checkDataVersioning success dataVersions=" + list);
            if (list != null && !list.isEmpty()) {
                List<DataVersion> arrayList = new ArrayList();
                for (DataVersion dataVersion : list) {
                    DataVersion dataVersioning = DataVersioningRepository.this.mLocalDataSource.getDataVersioning(dataVersion.getDataVersion());
                    if (dataVersioning == null || dataVersioning.getTimestamp() == 0 || dataVersioning.getTimestamp() != dataVersion.getTimestamp()) {
                        arrayList.add(dataVersion);
                        DataVersioningRepository.this.mLocalDataSource.addOrUpdateDataVersioning(dataVersion);
                    }
                }
                MFLogger.d(DataVersioningRepository.TAG, "Inside .checkDataVersioning updatedDataVersion=" + arrayList);
                if (!arrayList.isEmpty()) {
                    Object aaa = PortfolioApp.ZQ().aaa();
                    for (DataVersion dataVersion2 : arrayList) {
                        MFLogger.d(DataVersioningRepository.TAG, "Inside .checkDataVersioning re-download data of " + dataVersion2.getDataVersion());
                        String dataVersion3 = dataVersion2.getDataVersion();
                        Object obj = -1;
                        switch (dataVersion3.hashCode()) {
                            case -2037557584:
                                if (dataVersion3.equals("explorations")) {
                                    obj = 2;
                                    break;
                                }
                                break;
                            case -1759124701:
                                if (dataVersion3.equals("micro-app-variants")) {
                                    obj = 4;
                                    break;
                                }
                                break;
                            case -1645826046:
                                if (dataVersion3.equals("recommended-presets")) {
                                    obj = 6;
                                    break;
                                }
                                break;
                            case -1468566099:
                                if (dataVersion3.equals("active-presets")) {
                                    obj = 9;
                                    break;
                                }
                                break;
                            case -35586536:
                                if (dataVersion3.equals("firmwares")) {
                                    obj = 10;
                                    break;
                                }
                                break;
                            case -33796750:
                                if (dataVersion3.equals("user-presets")) {
                                    obj = 7;
                                    break;
                                }
                                break;
                            case -14544754:
                                if (dataVersion3.equals("landing-pages")) {
                                    obj = 1;
                                    break;
                                }
                                break;
                            case 113949:
                                if (dataVersion3.equals("sku")) {
                                    obj = 12;
                                    break;
                                }
                                break;
                            case 111578632:
                                if (dataVersion3.equals("users")) {
                                    obj = 8;
                                    break;
                                }
                                break;
                            case 925081272:
                                if (dataVersion3.equals("micro-app-settings")) {
                                    obj = 3;
                                    break;
                                }
                                break;
                            case 1054768900:
                                if (dataVersion3.equals("device/watches")) {
                                    obj = 11;
                                    break;
                                }
                                break;
                            case 1308837851:
                                if (dataVersion3.equals("micro-apps")) {
                                    obj = 5;
                                    break;
                                }
                                break;
                            case 1340337839:
                                if (dataVersion3.equals("widgets")) {
                                    obj = null;
                                    break;
                                }
                                break;
                        }
                        switch (obj) {
                            case null:
                                DataVersioningRepository.this.mWidgetRepository.refreshWidget();
                                break;
                            case 1:
                                DataVersioningRepository.this.mLandingPageRepository.refreshLandingPage();
                                break;
                            case 2:
                                DataVersioningRepository.this.mExplorationRepository.refreshExplore();
                                break;
                            case 3:
                                DataVersioningRepository.this.mMicroAppSettingRepository.downloadMicroAppSettingList(null);
                                break;
                            case 4:
                                if (!TextUtils.isEmpty(aaa)) {
                                    UAppSystemVersionModel uAppSystemVersionModel = DataVersioningRepository.this.mAppSystemVersionRepository.getUAppSystemVersionModel(aaa);
                                    if (uAppSystemVersionModel == null) {
                                        break;
                                    }
                                    MFLogger.d(DataVersioningRepository.TAG, "Inside .downloadMicroAppVariants serial=" + aaa + ", major=" + uAppSystemVersionModel.getMajorVersion() + ", minor=" + uAppSystemVersionModel.getMinorVersion());
                                    DataVersioningRepository.this.mMicroAppSettingRepository.fetchAllMicroAppVariants(uAppSystemVersionModel.getDeviceId(), uAppSystemVersionModel.getMajorVersion(), uAppSystemVersionModel.getMinorVersion(), null);
                                    break;
                                }
                                DataVersioningRepository.this.mLocalDataSource.removeDataVersion("micro-app-variants");
                                break;
                            case 5:
                                if (!TextUtils.isEmpty(aaa)) {
                                    DataVersioningRepository.this.mMicroAppSettingRepository.downloadMicroAppGallery(aaa, null);
                                    break;
                                } else {
                                    DataVersioningRepository.this.mLocalDataSource.removeDataVersion("micro-apps");
                                    break;
                                }
                            case 6:
                                if (!TextUtils.isEmpty(aaa)) {
                                    DataVersioningRepository.this.mPresetRepository.downloadRecommendPreset(aaa, null);
                                    break;
                                } else {
                                    DataVersioningRepository.this.mLocalDataSource.removeDataVersion("recommended-presets");
                                    break;
                                }
                            case 7:
                                DataVersioningRepository.this.mPresetRepository.downloadSavedPreset(null);
                                break;
                            case 8:
                                DataVersioningRepository.this.mUserRepository.refreshUser();
                                break;
                            case 9:
                                DataVersioningRepository.this.mPresetRepository.downloadActivePresetList(null);
                                break;
                            case 10:
                                DataVersioningRepository.this.mUseCaseHandler.a(DataVersioningRepository.this.mFetchFirmwareUseCase, new a(), new C47621());
                                break;
                            case 11:
                                DataVersioningRepository.this.mDeviceRepository.reDownloadDevice();
                                break;
                            case 12:
                                DataVersioningRepository.this.mDeviceRepository.fetchSupportedSkus();
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }

        public void onFailed(int i) {
            MFLogger.d(DataVersioningRepository.TAG, "Inside .checkDataVersioning failed!!! errorCode=" + i);
        }
    }

    public DataVersioningRepository(@Local DataVersioningDataSource dataVersioningDataSource, @Remote DataVersioningDataSource dataVersioningDataSource2, WidgetRepository widgetRepository, LandingPageRepository landingPageRepository, MicroAppSettingRepository microAppSettingRepository, PresetRepository presetRepository, UserRepository userRepository, ckc com_fossil_ckc, DeviceRepository deviceRepository, cyk com_fossil_cyk, UAppSystemVersionRepository uAppSystemVersionRepository, ExploreRepository exploreRepository) {
        this.mLocalDataSource = dataVersioningDataSource;
        this.mRemoteDataSource = dataVersioningDataSource2;
        this.mWidgetRepository = widgetRepository;
        this.mMicroAppSettingRepository = microAppSettingRepository;
        this.mUserRepository = userRepository;
        this.mAppSystemVersionRepository = uAppSystemVersionRepository;
        this.mPresetRepository = presetRepository;
        this.mLandingPageRepository = landingPageRepository;
        this.mUseCaseHandler = com_fossil_ckc;
        this.mFetchFirmwareUseCase = com_fossil_cyk;
        this.mExplorationRepository = exploreRepository;
        this.mDeviceRepository = deviceRepository;
    }

    public void addOrUpdateDataVersioning(DataVersion dataVersion) {
        MFLogger.d(TAG, "Inside .addOrUpdateDataVersioning dataVersion=" + dataVersion);
        this.mLocalDataSource.addOrUpdateDataVersioning(dataVersion);
    }

    public DataVersion getDataVersioning(String str) {
        return this.mLocalDataSource.getDataVersioning(str);
    }

    public void checkDataVersioning(GetDataVersioningCallback getDataVersioningCallback) {
        this.mRemoteDataSource.checkDataVersioning(new C47631());
    }

    public void clearAllDataVersioning() {
        MFLogger.d(TAG, "Inside .clearAllDataVersioning");
        this.mLocalDataSource.clearAllDataVersioning();
    }

    public void removeDataVersion(String str) {
        MFLogger.d(TAG, "Inside .removeDataVersion key=" + str);
        this.mLocalDataSource.removeDataVersion(str);
    }

    public void clearDeviceDataVersioning() {
        MFLogger.d(TAG, "clearDeviceDataVersioning");
        for (String removeDataVersion : this.deviceDataVersioningKey) {
            this.mLocalDataSource.removeDataVersion(removeDataVersion);
        }
    }

    public DataVersion getDataVersion(String str) {
        return this.mLocalDataSource.getDataVersioning(str);
    }
}
