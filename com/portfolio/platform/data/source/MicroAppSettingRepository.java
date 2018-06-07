package com.portfolio.platform.data.source;

import android.text.TextUtils;
import com.fossil.ciw;
import com.fossil.cjy;
import com.fossil.cnq;
import com.fossil.cst;
import com.fossil.emj;
import com.misfit.frameworks.buttonservice.model.microapp.MicroAppInstruction$MicroAppID;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.DataVersion;
import com.portfolio.platform.data.model.microapp.DeclarationFile;
import com.portfolio.platform.data.model.microapp.MicroApp;
import com.portfolio.platform.data.model.microapp.MicroAppSetting;
import com.portfolio.platform.data.model.microapp.MicroAppVariant;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.AddOrUpdateDeclarationFileCallback;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.AddOrUpdateDeclarationFileListCallback;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.GetMicroAppCallback;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.GetMicroAppGalleryCallback;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.GetVariantCallback;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.GetVariantListCallback;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.GetVariantListRemoteCallback;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.MicroAppSettingCallback;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.MicroAppSettingListCallback;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.PushMicroAppSettingToServerCallback;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.PushPendingMicroAppSettingsCallback;
import com.portfolio.platform.data.source.interfaces.ShortcutDownloadingObserver;
import com.portfolio.platform.data.source.local.MicroAppSettingLocalDataSource;
import com.portfolio.platform.data.source.remote.MicroAppSettingRemoteDataSource;
import com.portfolio.platform.data.source.scope.Local;
import com.portfolio.platform.data.source.scope.Remote;
import com.portfolio.platform.model.UAppSystemVersionModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class MicroAppSettingRepository implements MicroAppSettingDataSource {
    private static final String TAG = MicroAppSettingRepository.class.getSimpleName();
    private final ciw mAppExecutors;
    private MicroAppSetting mCachedSetting;
    private List<MicroAppSetting> mCachedSettingList;
    private boolean mIsCachedDirty;
    private boolean mIsCachedListDirty;
    private final MicroAppSettingDataSource mMicroAppSettingLocalDataSource;
    private final MicroAppSettingDataSource mMicroAppSettingRemoteDataSource;
    private List<ShortcutDownloadingObserver> mShortcutDownloadingObservers;
    private final UAppSystemVersionRepository mUAppSystemVersionRepository;
    private List<MicroAppSettingRepositoryObserver> microAppSettingRepositoryObservers = new ArrayList();

    class C47896 implements AddOrUpdateDeclarationFileCallback {
        C47896() {
        }

        public void onSuccess(DeclarationFile declarationFile) {
            MFLogger.d(MicroAppSettingRepository.TAG, "save microAppDeclarationFile onSuccess");
        }

        public void onFail() {
            MFLogger.d(MicroAppSettingRepository.TAG, "save microAppDeclarationFile onFail");
        }
    }

    public interface MicroAppSettingRepositoryObserver {
        void onMicroAppChanged();
    }

    public MicroAppSettingRepository(@Remote MicroAppSettingDataSource microAppSettingDataSource, @Local MicroAppSettingDataSource microAppSettingDataSource2, UAppSystemVersionRepository uAppSystemVersionRepository, ciw com_fossil_ciw) {
        this.mMicroAppSettingRemoteDataSource = (MicroAppSettingDataSource) emj.f(microAppSettingDataSource, "mappingRemoteSetDataSource cannot be null!");
        this.mMicroAppSettingLocalDataSource = (MicroAppSettingDataSource) emj.f(microAppSettingDataSource2, "mappingLocalSetDataSource cannot be null!");
        this.mUAppSystemVersionRepository = (UAppSystemVersionRepository) emj.f(uAppSystemVersionRepository, "uAppSystemVersionRepository cannot be null!");
        this.mAppExecutors = (ciw) emj.f(com_fossil_ciw, "appExecutors cannot be null!");
    }

    public void addMicroAppSettingRepositoryObserver(MicroAppSettingRepositoryObserver microAppSettingRepositoryObserver) {
        if (!this.microAppSettingRepositoryObservers.contains(microAppSettingRepositoryObserver)) {
            this.microAppSettingRepositoryObservers.add(microAppSettingRepositoryObserver);
        }
    }

    public void removeMicroAppSettingRepositoryObserver(MicroAppSettingRepositoryObserver microAppSettingRepositoryObserver) {
        if (this.microAppSettingRepositoryObservers.contains(microAppSettingRepositoryObserver)) {
            this.microAppSettingRepositoryObservers.remove(microAppSettingRepositoryObserver);
        }
    }

    public void notifyStatusChanged(String str, String str2) {
        if (this.mShortcutDownloadingObservers != null && !this.mShortcutDownloadingObservers.isEmpty()) {
            for (ShortcutDownloadingObserver onStatusChanged : this.mShortcutDownloadingObservers) {
                onStatusChanged.onStatusChanged(str, str2);
            }
        }
    }

    public void addStatusObserver(ShortcutDownloadingObserver shortcutDownloadingObserver) {
        if (this.mShortcutDownloadingObservers == null) {
            this.mShortcutDownloadingObservers = new ArrayList();
        }
        this.mShortcutDownloadingObservers.add(shortcutDownloadingObserver);
    }

    public void removeStatusObserver(ShortcutDownloadingObserver shortcutDownloadingObserver) {
        if (this.mShortcutDownloadingObservers != null && this.mShortcutDownloadingObservers.contains(shortcutDownloadingObserver)) {
            this.mShortcutDownloadingObservers.remove(shortcutDownloadingObserver);
        }
    }

    public void getMicroAppGallery(final String str, final GetMicroAppGalleryCallback getMicroAppGalleryCallback) {
        if (TextUtils.isEmpty(str)) {
            getMicroAppGalleryCallback.onFail();
            return;
        }
        MFLogger.d(TAG, "getMicroAppGallery deviceSerial=" + str);
        this.mMicroAppSettingLocalDataSource.getMicroAppGallery(str, new GetMicroAppGalleryCallback() {
            public void onSuccess(List<MicroApp> list) {
                MFLogger.d(MicroAppSettingRepository.TAG, "getMicroAppGallery deviceSerial=" + str + " local onSuccess");
                getMicroAppGalleryCallback.onSuccess(list);
            }

            public void onFail() {
                MFLogger.d(MicroAppSettingRepository.TAG, "getMicroAppGallery deviceSerial=" + str + " local onFail");
                DataVersion hc = cnq.acd().acf().hc("micro-apps");
                if (hc == null || hc.getTimestamp() == 0) {
                    MFLogger.d(MicroAppSettingRepository.TAG, "getMicroAppGallery onFail downloadMicroAppGallery");
                    MicroAppSettingRepository.this.downloadMicroAppGallery(str, getMicroAppGalleryCallback);
                    return;
                }
                MFLogger.d(MicroAppSettingRepository.TAG, "getMicroAppGallery onFail");
                getMicroAppGalleryCallback.onFail();
            }
        });
    }

    public void downloadMicroAppGallery(final String str, final GetMicroAppGalleryCallback getMicroAppGalleryCallback) {
        if (!TextUtils.isEmpty(str)) {
            MFLogger.d(TAG, "downloadMicroAppGallery deviceSerial=" + str);
            this.mMicroAppSettingRemoteDataSource.getMicroAppGallery(str, new GetMicroAppGalleryCallback() {
                public void onSuccess(List<MicroApp> list) {
                    final List arrayList = new ArrayList();
                    MFLogger.d(MicroAppSettingRepository.TAG, "downloadMicroAppGallery deviceSerial=" + str + " remote onSuccess");
                    for (MicroApp microApp : list) {
                        if (cjy.cnN.abn().contains(microApp.getAppId())) {
                            MFLogger.d(MicroAppSettingRepository.TAG, "Ignore micro app id=" + microApp.getAppId());
                        } else {
                            MFLogger.d(MicroAppSettingRepository.TAG, "Add micro app id=" + microApp.getAppId());
                            microApp.setPlatform(str);
                            arrayList.add(microApp);
                        }
                    }
                    if (getMicroAppGalleryCallback != null) {
                        getMicroAppGalleryCallback.onSuccess(arrayList);
                    }
                    MicroAppSettingRepository.this.mAppExecutors.YQ().execute(new Runnable() {
                        public void run() {
                            MicroAppSettingRepository.this.deleteListMicroApp(str);
                            MicroAppSettingRepository.this.updateListMicroApp(arrayList);
                        }
                    });
                }

                public void onFail() {
                    MFLogger.d(MicroAppSettingRepository.TAG, "downloadMicroAppGallery deviceSerial=" + str + " remote onFail");
                    if (getMicroAppGalleryCallback != null) {
                        getMicroAppGalleryCallback.onFail();
                    }
                }
            });
        } else if (getMicroAppGalleryCallback != null) {
            getMicroAppGalleryCallback.onFail();
        }
    }

    public void updateMicroApp(MicroApp microApp, GetMicroAppCallback getMicroAppCallback) {
        MFLogger.d(TAG, "updateMicroApp microApp=" + microApp.getAppId());
        this.mMicroAppSettingLocalDataSource.updateMicroApp(microApp, getMicroAppCallback);
    }

    public void getMicroApp(final String str, final String str2, final GetMicroAppCallback getMicroAppCallback) {
        if (TextUtils.isEmpty(str)) {
            getMicroAppCallback.onFail();
        } else {
            this.mMicroAppSettingLocalDataSource.getMicroApp(str, str2, new GetMicroAppCallback() {

                class C47831 implements GetMicroAppGalleryCallback {
                    C47831() {
                    }

                    public void onSuccess(final List<MicroApp> list) {
                        MFLogger.d(MicroAppSettingRepository.TAG, "getMicroApp microAppId=" + str2 + " remote onSuccess");
                        for (int i = 0; i < list.size(); i++) {
                            ((MicroApp) list.get(i)).setPlatform(str);
                            if (((MicroApp) list.get(i)).getAppId().equals(str2)) {
                                getMicroAppCallback.onSuccess((MicroApp) list.get(i));
                                break;
                            }
                        }
                        MicroAppSettingRepository.this.mAppExecutors.YQ().execute(new Runnable() {
                            public void run() {
                                MicroAppSettingRepository.this.updateListMicroApp(list);
                            }
                        });
                    }

                    public void onFail() {
                        MFLogger.d(MicroAppSettingRepository.TAG, "getMicroApp microAppId=" + str2 + " remote onFail");
                        getMicroAppCallback.onFail();
                    }
                }

                public void onSuccess(MicroApp microApp) {
                    MFLogger.d(MicroAppSettingRepository.TAG, "getMicroApp microAppId=" + str2 + " local onSuccess");
                    getMicroAppCallback.onSuccess(microApp);
                }

                public void onFail() {
                    MFLogger.d(MicroAppSettingRepository.TAG, "getMicroApp microAppId=" + str2 + " local onFail");
                    MicroAppSettingRepository.this.mMicroAppSettingRemoteDataSource.getMicroAppGallery(str, new C47831());
                }
            });
        }
    }

    public void updateListMicroApp(List<MicroApp> list) {
        MFLogger.d(TAG, "updateListMicroApp microAppListSize=" + list.size());
        this.mMicroAppSettingLocalDataSource.updateListMicroApp(list);
    }

    public void deleteListMicroApp(String str) {
        MFLogger.d(TAG, "deleteListMicroApp serial=" + str);
        this.mMicroAppSettingLocalDataSource.deleteListMicroApp(str);
    }

    public void getAllMicroAppVariants(String str, int i, int i2, GetVariantListCallback getVariantListCallback) {
        MFLogger.d(TAG, "getAllMicroAppVariants serialNumber=" + str + " major=" + i + " minor=" + i2);
        final String str2 = str;
        final int i3 = i;
        final int i4 = i2;
        final GetVariantListCallback getVariantListCallback2 = getVariantListCallback;
        this.mMicroAppSettingLocalDataSource.getAllMicroAppVariants(str, i, i2, new GetVariantListCallback() {
            public void onSuccess(List<MicroAppVariant> list) {
                MFLogger.d(MicroAppSettingRepository.TAG, "getAllMicroAppVariants local serialNumber=" + str2 + " major=" + i3 + " minor=" + i4 + " onSuccess");
                MicroAppSettingRepository.this.notifyStatusChanged("DECLARATION_FILES_DOWNLOADED", str2);
                getVariantListCallback2.onSuccess(list);
            }

            public void onFail(int i) {
                MFLogger.d(MicroAppSettingRepository.TAG, "getAllMicroAppVariants local serialNumber=" + str2 + " major=" + i3 + " minor=" + i4 + " onFail");
                DataVersion hc = cnq.acd().acf().hc("micro-app-variants");
                if (hc == null || hc.getTimestamp() == 0) {
                    MFLogger.d(MicroAppSettingRepository.TAG, "getAllMicroAppVariants onFail downloadAllVariants");
                    MicroAppSettingRepository.this.notifyStatusChanged("DECLARATION_FILES_DOWNLOADING", str2);
                    MicroAppSettingRepository.this.downloadAllVariants(str2, i3, i4, getVariantListCallback2);
                    return;
                }
                MFLogger.d(MicroAppSettingRepository.TAG, "getAllMicroAppVariants onFail");
                getVariantListCallback2.onFail(i);
            }
        });
    }

    private void downloadAllVariants(String str, int i, int i2, GetVariantListCallback getVariantListCallback) {
        final String str2 = str;
        final int i3 = i;
        final int i4 = i2;
        final GetVariantListCallback getVariantListCallback2 = getVariantListCallback;
        this.mMicroAppSettingRemoteDataSource.getAllMicroAppVariants(str, i, i2, new GetVariantListRemoteCallback() {
            public void onSuccess(final ArrayList<cst> arrayList) {
                MFLogger.d(MicroAppSettingRepository.TAG, "getAllMicroAppVariants remote serialNumber=" + str2 + " major=" + i3 + " minor=" + i4 + " onSuccess");
                MicroAppSettingRepository.this.mAppExecutors.YQ().execute(new Runnable() {
                    public void run() {
                        final List access$500 = MicroAppSettingRepository.this.saveMicroAppVariant(str2, MicroAppSettingRepository.this.filterVariantList(arrayList));
                        UAppSystemVersionModel uAppSystemVersionModel = MicroAppSettingRepository.this.mUAppSystemVersionRepository.getUAppSystemVersionModel(str2);
                        if (uAppSystemVersionModel != null && uAppSystemVersionModel.getMajorVersion() == i3 && uAppSystemVersionModel.getMinorVersion() == i4) {
                            uAppSystemVersionModel.setPinType(0);
                            MicroAppSettingRepository.this.mUAppSystemVersionRepository.addOrUpdateUAppSystemVersionModel(uAppSystemVersionModel);
                        }
                        MicroAppSettingRepository.this.notifyStatusChanged("DECLARATION_FILES_DOWNLOADED", str2);
                        if (getVariantListCallback2 != null) {
                            MicroAppSettingRepository.this.mAppExecutors.YS().execute(new Runnable() {
                                public void run() {
                                    getVariantListCallback2.onSuccess(access$500);
                                }
                            });
                        }
                    }
                });
            }

            public void onSuccess(List<MicroAppVariant> list) {
            }

            public void onFail(int i) {
                MFLogger.d(MicroAppSettingRepository.TAG, "getAllMicroAppVariants remote serialNumber=" + str2 + " major=" + i3 + " minor=" + i4 + " onFail");
                if (getVariantListCallback2 != null) {
                    getVariantListCallback2.onFail(i);
                }
            }
        });
    }

    private List<MicroAppVariant> saveMicroAppVariant(String str, List<cst> list) {
        List<MicroAppVariant> arrayList = new ArrayList();
        for (cst com_fossil_cst : list) {
            com_fossil_cst.setSerialNumbers(str);
            MicroAppVariant aeV = com_fossil_cst.aeV();
            ((MicroAppSettingLocalDataSource) this.mMicroAppSettingLocalDataSource).addOrUpDateVariant(aeV);
            saveDeclarationFileList(com_fossil_cst.getDeclarationFiles(), aeV);
            arrayList.add(aeV);
        }
        return arrayList;
    }

    private ArrayList<cst> filterVariantList(List<cst> list) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            cst com_fossil_cst = (cst) list.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                cst com_fossil_cst2 = (cst) list.get(i2);
                if (com_fossil_cst2.getAppId().equals(com_fossil_cst.getAppId()) && com_fossil_cst2.getName().equals(com_fossil_cst.getName()) && com_fossil_cst2.getMinorNumber() > com_fossil_cst.getMinorNumber()) {
                    com_fossil_cst = com_fossil_cst2;
                }
            }
            hashMap.put(com_fossil_cst.getAppId() + com_fossil_cst.getName(), com_fossil_cst);
        }
        return new ArrayList(hashMap.values());
    }

    private void saveDeclarationFileList(List<DeclarationFile> list, MicroAppVariant microAppVariant) {
        for (DeclarationFile declarationFile : list) {
            declarationFile.setMicroAppVariant(microAppVariant);
            addOrUpdateDeclarationFile(declarationFile, new C47896());
        }
    }

    public void getMicroAppVariant(String str, String str2, String str3, int i, int i2, GetVariantCallback getVariantCallback) {
        MFLogger.d(TAG, "getMicroAppVariant serialNumber=" + str + "microAppId=" + str2 + " major=" + i + " minor=" + i2 + " name=" + str3);
        final String str4 = str;
        final int i3 = i;
        final int i4 = i2;
        final GetVariantCallback getVariantCallback2 = getVariantCallback;
        final String str5 = str2;
        final String str6 = str3;
        this.mMicroAppSettingLocalDataSource.getMicroAppVariant(str, str2, str3, i, i2, new GetVariantCallback() {
            public void onSuccess(MicroAppVariant microAppVariant) {
                MFLogger.d(MicroAppSettingRepository.TAG, "getMicroAppVariant local serialNumber=" + str4 + " major=" + i3 + " minor=" + i4 + " onSuccess");
                getVariantCallback2.onSuccess(microAppVariant);
            }

            public void onFail(int i) {
                MFLogger.d(MicroAppSettingRepository.TAG, "getMicroAppVariant local serialNumber=" + str4 + " major=" + i3 + " minor=" + i4 + " onFail");
                MicroAppSettingRepository.this.downloadMicroAppVariant(str4, str5, str6, i3, i4, getVariantCallback2);
            }
        });
    }

    private void downloadMicroAppVariant(String str, String str2, String str3, int i, int i2, GetVariantCallback getVariantCallback) {
        final String str4 = str;
        final int i3 = i;
        final int i4 = i2;
        final String str5 = str2;
        final String str6 = str3;
        final GetVariantCallback getVariantCallback2 = getVariantCallback;
        ((MicroAppSettingRemoteDataSource) this.mMicroAppSettingRemoteDataSource).getMicroAppVariant(str, str2, i, i2, new GetVariantListRemoteCallback() {
            public void onSuccess(final ArrayList<cst> arrayList) {
                MFLogger.d(MicroAppSettingRepository.TAG, "getMicroAppVariant remote serialNumber=" + str4 + " major=" + i3 + " minor=" + i4 + " onSuccess");
                MicroAppSettingRepository.this.mAppExecutors.YQ().execute(new Runnable() {

                    class C47931 implements GetVariantCallback {
                        C47931() {
                        }

                        public void onSuccess(final MicroAppVariant microAppVariant) {
                            MicroAppSettingRepository.this.mAppExecutors.YS().execute(new Runnable() {
                                public void run() {
                                    getVariantCallback2.onSuccess(microAppVariant);
                                }
                            });
                        }

                        public void onFail(final int i) {
                            MicroAppSettingRepository.this.mAppExecutors.YS().execute(new Runnable() {
                                public void run() {
                                    getVariantCallback2.onFail(i);
                                }
                            });
                        }
                    }

                    class C47942 implements Runnable {
                        C47942() {
                        }

                        public void run() {
                            getVariantCallback2.onFail(2);
                        }
                    }

                    public void run() {
                        boolean z = false;
                        switch (MicroAppInstruction$MicroAppID.getMicroAppId(str5)) {
                            case UAPP_COMMUTE_TIME:
                                if (MicroAppSettingRepository.this.getCommuteVariant(MicroAppSettingRepository.this.saveMicroAppVariant(str4, MicroAppSettingRepository.this.filterVariantList(arrayList)), str6) != null) {
                                    z = true;
                                    break;
                                } else {
                                    MFLogger.d(MicroAppSettingRepository.TAG, "getMicroAppVariant variant null serialNumber=" + str4 + " major=" + i3 + " minor=" + i4 + " onSuccess");
                                    break;
                                }
                            default:
                                cst access$900 = MicroAppSettingRepository.this.getBiggestMinorVariant(arrayList);
                                if (access$900 != null) {
                                    MicroAppVariant aeV = access$900.aeV();
                                    aeV.setSerialNumbers(str4);
                                    z = ((MicroAppSettingLocalDataSource) MicroAppSettingRepository.this.mMicroAppSettingLocalDataSource).addOrUpDateVariant(aeV);
                                    MicroAppSettingRepository.this.saveDeclarationFileList(access$900.getDeclarationFiles(), aeV);
                                    break;
                                }
                                break;
                        }
                        if (z) {
                            MFLogger.d(MicroAppSettingRepository.TAG, "getMicroAppVariant serialNumber=" + str4 + " major=" + i3 + " minor=" + i4 + " onSuccess");
                            MicroAppSettingRepository.this.mMicroAppSettingLocalDataSource.getMicroAppVariant(str4, str5, str6, i3, i4, new C47931());
                            return;
                        }
                        MFLogger.d(MicroAppSettingRepository.TAG, "getMicroAppVariant serialNumber=" + str4 + " major=" + i3 + " minor=" + i4 + " onFail");
                        MicroAppSettingRepository.this.mAppExecutors.YS().execute(new C47942());
                    }
                });
            }

            public void onSuccess(List<MicroAppVariant> list) {
            }

            public void onFail(int i) {
                MFLogger.d(MicroAppSettingRepository.TAG, "getMicroAppVariant remote serialNumber=" + str4 + " major=" + i3 + " minor=" + i4 + " onFail");
                getVariantCallback2.onFail(i);
            }
        });
    }

    private MicroAppVariant getCommuteVariant(List<MicroAppVariant> list, String str) {
        for (MicroAppVariant microAppVariant : list) {
            if (microAppVariant.getName().equals(str)) {
                return microAppVariant;
            }
        }
        return null;
    }

    private cst getBiggestMinorVariant(List<cst> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        cst com_fossil_cst = (cst) list.get(0);
        cst com_fossil_cst2 = com_fossil_cst;
        for (cst com_fossil_cst3 : list) {
            if (com_fossil_cst3.getMinorNumber() <= com_fossil_cst2.getMinorNumber()) {
                com_fossil_cst3 = com_fossil_cst2;
            }
            com_fossil_cst2 = com_fossil_cst3;
        }
        return com_fossil_cst2;
    }

    public void addOrUpdateMicroAppSetting(final MicroAppSetting microAppSetting, final MicroAppSettingCallback microAppSettingCallback) {
        MFLogger.d(TAG, "addOrUpdateMicroAppSetting microAppSetting=" + microAppSetting.getSetting());
        microAppSetting.setPinType(2);
        this.mMicroAppSettingLocalDataSource.addOrUpdateMicroAppSetting(microAppSetting, new MicroAppSettingCallback() {
            public void onSuccess(MicroAppSetting microAppSetting) {
                MFLogger.d(MicroAppSettingRepository.TAG, "addOrUpdateMicroAppSetting local onSuccess microAppSetting=" + microAppSetting.getSetting());
                MicroAppSettingRepository.this.mIsCachedDirty = true;
                MicroAppSettingRepository.this.mIsCachedListDirty = true;
                MicroAppSettingRepository.this.pushMicroAppSettingToServer(microAppSetting, null);
                MicroAppSettingRepository.this.notifyMicroAppSettingObservers();
                microAppSettingCallback.onSuccess(microAppSetting);
            }

            public void onFail() {
                MFLogger.d(MicroAppSettingRepository.TAG, "addOrUpdateMicroAppSetting local onSuccess microAppSetting=" + microAppSetting.getSetting());
                microAppSettingCallback.onFail();
            }
        });
    }

    public void getMicroAppSettingList(final MicroAppSettingListCallback microAppSettingListCallback) {
        this.mMicroAppSettingLocalDataSource.getMicroAppSettingList(new MicroAppSettingListCallback() {
            public void onSuccess(List<MicroAppSetting> list) {
                MFLogger.d(MicroAppSettingRepository.TAG, "getMicroAppSettingList local onSuccess getMicroAppSettingListSize=" + list.size());
                microAppSettingListCallback.onSuccess(list);
            }

            public void onFail() {
                MFLogger.d(MicroAppSettingRepository.TAG, "getMicroAppSettingList local onFail");
                DataVersion hc = cnq.acd().acf().hc("micro-app-settings");
                if (hc == null || hc.getTimestamp() == 0) {
                    MFLogger.d(MicroAppSettingRepository.TAG, "getMicroAppSettingList onFail downloadMicroAppSettingList");
                    MicroAppSettingRepository.this.downloadMicroAppSettingList(microAppSettingListCallback);
                    return;
                }
                MFLogger.d(MicroAppSettingRepository.TAG, "getMicroAppSettingList onFail");
                microAppSettingListCallback.onFail();
            }
        });
    }

    public void getMicroAppSetting(final String str, final MicroAppSettingCallback microAppSettingCallback) {
        MFLogger.d(TAG, "getMicroAppSetting microAppId=" + str);
        this.mMicroAppSettingLocalDataSource.getMicroAppSetting(str, new MicroAppSettingCallback() {

            class C47751 implements MicroAppSettingListCallback {
                C47751() {
                }

                public void onSuccess(List<MicroAppSetting> list) {
                    MFLogger.d(MicroAppSettingRepository.TAG, "getMicroAppSetting getMicroAppSettingList onSuccess size=" + list.size());
                    for (MicroAppSetting microAppSetting : list) {
                        if (microAppSetting.getMicroAppId().equals(str)) {
                            microAppSettingCallback.onSuccess(microAppSetting);
                            return;
                        }
                    }
                    microAppSettingCallback.onFail();
                }

                public void onFail() {
                    MFLogger.d(MicroAppSettingRepository.TAG, "getMicroAppSetting getMicroAppSettingList onFailed");
                    microAppSettingCallback.onFail();
                }
            }

            public void onSuccess(MicroAppSetting microAppSetting) {
                MFLogger.d(MicroAppSettingRepository.TAG, "getMicroAppSetting local onSuccess microAppId=" + str);
                microAppSettingCallback.onSuccess(microAppSetting);
            }

            public void onFail() {
                MFLogger.d(MicroAppSettingRepository.TAG, "getMicroAppSetting onFail onSuccess microAppId=" + str);
                MicroAppSettingRepository.this.getMicroAppSettingList(new C47751());
            }
        });
    }

    public void addOrUpdateDeclarationFile(DeclarationFile declarationFile, AddOrUpdateDeclarationFileCallback addOrUpdateDeclarationFileCallback) {
        MFLogger.d(TAG, "addOrUpdateDeclarationFile fileId=" + declarationFile.getId());
        this.mMicroAppSettingLocalDataSource.addOrUpdateDeclarationFile(declarationFile, addOrUpdateDeclarationFileCallback);
    }

    public void addOrUpdateDeclarationFiles(List<DeclarationFile> list, AddOrUpdateDeclarationFileListCallback addOrUpdateDeclarationFileListCallback) {
        MFLogger.d(TAG, "addOrUpdateDeclarationFiles declarationFileSize=" + list.size());
        this.mMicroAppSettingLocalDataSource.addOrUpdateDeclarationFiles(list, addOrUpdateDeclarationFileListCallback);
    }

    public void fetchAllMicroAppVariants(String str, int i, int i2, GetVariantListCallback getVariantListCallback) {
        notifyStatusChanged("DECLARATION_FILES_DOWNLOADING", str);
        downloadAllVariants(str, i, i2, getVariantListCallback);
    }

    public void downloadMicroAppSettingList(final MicroAppSettingListCallback microAppSettingListCallback) {
        this.mMicroAppSettingRemoteDataSource.getMicroAppSettingList(new MicroAppSettingListCallback() {
            public void onSuccess(final List<MicroAppSetting> list) {
                if (microAppSettingListCallback != null) {
                    microAppSettingListCallback.onSuccess(list);
                }
                MicroAppSettingRepository.this.mAppExecutors.YQ().execute(new Runnable() {
                    public void run() {
                        MFLogger.d(MicroAppSettingRepository.TAG, "getMicroAppSettingList remote onSuccess getMicroAppSettingListSize=" + list.size());
                        for (final MicroAppSetting microAppSetting : list) {
                            MicroAppSettingRepository.this.mMicroAppSettingLocalDataSource.migrateMicroAppSetting(microAppSetting, new MicroAppSettingCallback() {
                                public void onSuccess(MicroAppSetting microAppSetting) {
                                    MFLogger.d(MicroAppSettingRepository.TAG, "getMicroAppSettingList migrateMicroAppSetting onSuccess setting=" + microAppSetting.getSetting());
                                }

                                public void onFail() {
                                    MFLogger.d(MicroAppSettingRepository.TAG, "getMicroAppSettingList migrateMicroAppSetting onFail setting=" + microAppSetting.getSetting());
                                }
                            });
                        }
                        MicroAppSettingRepository.this.notifyMicroAppSettingObservers();
                    }
                });
            }

            public void onFail() {
                MFLogger.d(MicroAppSettingRepository.TAG, "getMicroAppSettingList remote onFail");
                if (microAppSettingListCallback != null) {
                    microAppSettingListCallback.onFail();
                }
            }
        });
    }

    public void migrateMicroAppSetting(MicroAppSetting microAppSetting, MicroAppSettingCallback microAppSettingCallback) {
        MFLogger.d(TAG, "migrateMicroAppSetting");
        this.mMicroAppSettingLocalDataSource.migrateMicroAppSetting(microAppSetting, microAppSettingCallback);
    }

    private void notifyMicroAppSettingObservers() {
        MFLogger.d(TAG, "notifyMicroAppSettingObservers, observerSize=" + this.microAppSettingRepositoryObservers.size());
        for (MicroAppSettingRepositoryObserver onMicroAppChanged : this.microAppSettingRepositoryObservers) {
            onMicroAppChanged.onMicroAppChanged();
        }
    }

    public void getMicroAppSettingInDB(final String str, final MicroAppSettingCallback microAppSettingCallback) {
        MFLogger.d(TAG, "Inside .getMicroAppSettingInDB microAppId=" + str + ", isCacheDirty=" + this.mIsCachedDirty);
        if (this.mIsCachedDirty || this.mCachedSetting == null || !this.mCachedSetting.getMicroAppId().equals(str) || microAppSettingCallback == null) {
            MFLogger.d(TAG, "getMicroAppSettingInDB microAppId=" + str);
            this.mMicroAppSettingLocalDataSource.getMicroAppSetting(str, new MicroAppSettingCallback() {
                public void onSuccess(MicroAppSetting microAppSetting) {
                    MFLogger.d(MicroAppSettingRepository.TAG, "getMicroAppSettingInDB onSuccess microAppId=" + str);
                    MicroAppSettingRepository.this.processLoadedSetting(microAppSetting);
                    if (microAppSettingCallback != null) {
                        microAppSettingCallback.onSuccess(microAppSetting);
                    }
                }

                public void onFail() {
                    MFLogger.d(MicroAppSettingRepository.TAG, "getMicroAppSettingInDB onFail microAppId=" + str);
                    if (microAppSettingCallback != null) {
                        microAppSettingCallback.onFail();
                    }
                }
            });
            return;
        }
        MFLogger.d(TAG, "Inside .getMicroAppSettingInDB get from cache cachedSetting=" + this.mCachedSetting.getSetting());
        microAppSettingCallback.onSuccess(getCachedSetting());
    }

    public void getMicroAppSettingListInDB(final MicroAppSettingListCallback microAppSettingListCallback) {
        MFLogger.d(TAG, "Inside .getMicroAppSettingListInDB isCacheDirty=" + this.mIsCachedDirty);
        if (this.mIsCachedListDirty || this.mCachedSettingList == null || microAppSettingListCallback == null) {
            MFLogger.d(TAG, "getMicroAppSettingListInDB");
            this.mMicroAppSettingLocalDataSource.getMicroAppSettingList(new MicroAppSettingListCallback() {
                public void onSuccess(List<MicroAppSetting> list) {
                    MFLogger.d(MicroAppSettingRepository.TAG, "getMicroAppSettingListInDB onSuccess");
                    MicroAppSettingRepository.this.processLoadedSettingList(list);
                    if (microAppSettingListCallback != null) {
                        microAppSettingListCallback.onSuccess(list);
                    }
                }

                public void onFail() {
                    MFLogger.d(MicroAppSettingRepository.TAG, "getMicroAppSettingListInDB onFail");
                    if (microAppSettingListCallback != null) {
                        microAppSettingListCallback.onFail();
                    }
                }
            });
            return;
        }
        MFLogger.d(TAG, "Inside .getMicroAppSettingListInDB get from cache cachedSettingListSize=" + this.mCachedSettingList.size());
        microAppSettingListCallback.onSuccess(getCachedSettingList());
    }

    public void pushPendingMicroAppSettings(PushPendingMicroAppSettingsCallback pushPendingMicroAppSettingsCallback) {
        CountDownLatch countDownLatch;
        MFLogger.d(TAG, "pushPendingMicroAppSettings");
        List<MicroAppSetting> pendingMicroAppSettings = ((MicroAppSettingLocalDataSource) this.mMicroAppSettingLocalDataSource).getPendingMicroAppSettings();
        if (pushPendingMicroAppSettingsCallback == null || pendingMicroAppSettings.size() <= 0) {
            countDownLatch = null;
        } else {
            countDownLatch = new CountDownLatch(pendingMicroAppSettings.size());
        }
        for (MicroAppSetting pushMicroAppSettingToServer : pendingMicroAppSettings) {
            pushMicroAppSettingToServer(pushMicroAppSettingToServer, new PushMicroAppSettingToServerCallback() {
                public void onSuccess() {
                    MFLogger.d(MicroAppSettingRepository.TAG, "pushMicroAppSettingToServer success, bravo!!!");
                    if (countDownLatch != null) {
                        countDownLatch.countDown();
                    }
                }

                public void onFail() {
                    MFLogger.d(MicroAppSettingRepository.TAG, "pushMicroAppSettingToServer failed");
                    if (countDownLatch != null) {
                        countDownLatch.countDown();
                    }
                }
            });
        }
        if (countDownLatch != null) {
            try {
                MFLogger.d(TAG, "Await on thread=" + Thread.currentThread().getName());
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
        if (pushPendingMicroAppSettingsCallback != null) {
            pushPendingMicroAppSettingsCallback.onDone();
        }
    }

    private void pushMicroAppSettingToServer(MicroAppSetting microAppSetting, final PushMicroAppSettingToServerCallback pushMicroAppSettingToServerCallback) {
        this.mMicroAppSettingRemoteDataSource.addOrUpdateMicroAppSetting(microAppSetting, new MicroAppSettingCallback() {
            public void onSuccess(final MicroAppSetting microAppSetting) {
                if (pushMicroAppSettingToServerCallback != null) {
                    pushMicroAppSettingToServerCallback.onSuccess();
                }
                MicroAppSettingRepository.this.mAppExecutors.YQ().execute(new Runnable() {
                    public void run() {
                        ((MicroAppSettingLocalDataSource) MicroAppSettingRepository.this.mMicroAppSettingLocalDataSource).updateMicroAppSettingPinType(microAppSetting.getMicroAppId(), 0);
                    }
                });
            }

            public void onFail() {
                if (pushMicroAppSettingToServerCallback != null) {
                    pushMicroAppSettingToServerCallback.onFail();
                }
            }
        });
    }

    public boolean isCachedSettingAvailable(String str) {
        return (this.mCachedSetting == null || this.mIsCachedDirty || !this.mCachedSetting.getMicroAppId().equals(str)) ? false : true;
    }

    public boolean isCachedSettingListAvailable() {
        return (this.mCachedSettingList == null || this.mIsCachedListDirty) ? false : true;
    }

    private void processLoadedSetting(MicroAppSetting microAppSetting) {
        MFLogger.d(TAG, "processLoadedSetting microAppSetting=" + microAppSetting);
        this.mIsCachedDirty = false;
        if (microAppSetting == null) {
            this.mCachedSetting = null;
            return;
        }
        MFLogger.d(TAG, "processLoadedSetting microAppSetting=" + microAppSetting.getSetting());
        this.mCachedSetting = microAppSetting;
    }

    private void processLoadedSettingList(List<MicroAppSetting> list) {
        MFLogger.d(TAG, "processLoadedSettingList");
        this.mIsCachedListDirty = false;
        this.mCachedSettingList = list;
    }

    public MicroAppSetting getCachedSetting() {
        return this.mCachedSetting;
    }

    public List<MicroAppSetting> getCachedSettingList() {
        return this.mCachedSettingList == null ? new ArrayList() : this.mCachedSettingList;
    }

    public void clearData() {
        this.mMicroAppSettingLocalDataSource.clearData();
        this.mCachedSetting = null;
        this.mIsCachedDirty = true;
        this.mCachedSettingList = null;
        this.mIsCachedListDirty = true;
    }
}
