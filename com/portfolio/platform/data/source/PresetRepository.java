package com.portfolio.platform.data.source;

import com.fossil.arp;
import com.fossil.ciw;
import com.fossil.clz;
import com.fossil.cnq;
import com.fossil.emj;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.DataVersion;
import com.portfolio.platform.data.model.microapp.ActivePreset;
import com.portfolio.platform.data.model.microapp.RecommendedPreset;
import com.portfolio.platform.data.model.microapp.SavedPreset;
import com.portfolio.platform.data.model.microapp.SavedPreset$MappingSetType;
import com.portfolio.platform.data.source.PresetDataSource.AddOrUpdateActivePresetCallback;
import com.portfolio.platform.data.source.PresetDataSource.AddOrUpdateSavedPresetCallback;
import com.portfolio.platform.data.source.PresetDataSource.AddOrUpdateSavedPresetListCallback;
import com.portfolio.platform.data.source.PresetDataSource.DeleteMappingSetCallback;
import com.portfolio.platform.data.source.PresetDataSource.DeleteSavedPresetInServerCallback;
import com.portfolio.platform.data.source.PresetDataSource.GetActivePresetCallback;
import com.portfolio.platform.data.source.PresetDataSource.GetActivePresetListCallback;
import com.portfolio.platform.data.source.PresetDataSource.GetRecommendedPresetCallback;
import com.portfolio.platform.data.source.PresetDataSource.GetRecommendedPresetListCallback;
import com.portfolio.platform.data.source.PresetDataSource.GetSavedPresetCallback;
import com.portfolio.platform.data.source.PresetDataSource.GetSavedPresetListCallback;
import com.portfolio.platform.data.source.PresetDataSource.PushActivePresetToServerCallback;
import com.portfolio.platform.data.source.PresetDataSource.PushPendingActivePresetsCallback;
import com.portfolio.platform.data.source.PresetDataSource.PushPendingSavedPresetsCallback;
import com.portfolio.platform.data.source.PresetDataSource.PushSavedPresetToServerCallback;
import com.portfolio.platform.data.source.interfaces.ShortcutDownloadingObserver;
import com.portfolio.platform.data.source.local.PresetLocalDataSource;
import com.portfolio.platform.data.source.scope.Local;
import com.portfolio.platform.data.source.scope.Remote;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public class PresetRepository implements PresetDataSource {
    private static final String CACHE_MAPPING_SET_KEY = "cacheMappingSetKey";
    private static final String TAG = PresetRepository.class.getSimpleName();
    private List<ActivePresetRepositoryObserver> mActivePresetObservers = new ArrayList();
    private final ciw mAppExecutors;
    private boolean mCacheIsDirty;
    private ActivePreset mCachedActivePreset;
    private Map<String, List<SavedPreset>> mCachedSavedPresetList;
    private boolean mIsActivePresetCacheDirty;
    private final PresetDataSource mMappingSetLocalDataSource;
    private final PresetDataSource mMappingSetRemoteDataSource;
    private List<SavedPresetRepositoryObserver> mSavedPresetObservers = new ArrayList();
    private List<ShortcutDownloadingObserver> mShortcutDownloadingObservers;

    public interface ActivePresetRepositoryObserver {
        void onActivePresetChange();
    }

    public interface SavedPresetRepositoryObserver {
        void onSavedPresetChange();
    }

    public PresetRepository(@Remote PresetDataSource presetDataSource, @Local PresetDataSource presetDataSource2, ciw com_fossil_ciw) {
        this.mMappingSetRemoteDataSource = (PresetDataSource) emj.f(presetDataSource, "mappingRemoteSetDataSource cannot be null!");
        this.mMappingSetLocalDataSource = (PresetDataSource) emj.f(presetDataSource2, "mappingLocalSetDataSource cannot be null!");
        this.mAppExecutors = (ciw) emj.f(com_fossil_ciw, "appExecutors cannot be null!");
    }

    public void addSavedPresetObserver(SavedPresetRepositoryObserver savedPresetRepositoryObserver) {
        if (!this.mSavedPresetObservers.contains(savedPresetRepositoryObserver)) {
            this.mSavedPresetObservers.add(savedPresetRepositoryObserver);
        }
    }

    public void removeSavedPresetObserver(SavedPresetRepositoryObserver savedPresetRepositoryObserver) {
        if (this.mSavedPresetObservers.contains(savedPresetRepositoryObserver)) {
            this.mSavedPresetObservers.remove(savedPresetRepositoryObserver);
        }
    }

    public void notifySavedPresetObserver() {
        MFLogger.d(TAG, "notifySavedPresetObserver, observerSize=" + this.mSavedPresetObservers.size());
        for (SavedPresetRepositoryObserver onSavedPresetChange : this.mSavedPresetObservers) {
            onSavedPresetChange.onSavedPresetChange();
        }
    }

    public boolean isCachedMappingSetAvailable() {
        return (this.mCachedSavedPresetList == null || this.mCacheIsDirty) ? false : true;
    }

    public void addActivePresetObserver(ActivePresetRepositoryObserver activePresetRepositoryObserver) {
        if (!this.mActivePresetObservers.contains(activePresetRepositoryObserver)) {
            this.mActivePresetObservers.add(activePresetRepositoryObserver);
        }
    }

    public void removeActivePresetObserver(ActivePresetRepositoryObserver activePresetRepositoryObserver) {
        if (this.mActivePresetObservers.contains(activePresetRepositoryObserver)) {
            this.mActivePresetObservers.remove(activePresetRepositoryObserver);
        }
    }

    public void notifyActivePresetObserver() {
        MFLogger.d(TAG, "notifyActivePresetObserver, observerSize=" + this.mActivePresetObservers.size());
        for (ActivePresetRepositoryObserver onActivePresetChange : this.mActivePresetObservers) {
            onActivePresetChange.onActivePresetChange();
        }
    }

    public boolean isCachedActivePreset() {
        return (this.mCachedActivePreset == null || this.mIsActivePresetCacheDirty) ? false : true;
    }

    public List<SavedPreset> getCachedMappingSetList() {
        if (this.mCachedSavedPresetList != null) {
            return (List) this.mCachedSavedPresetList.get(CACHE_MAPPING_SET_KEY);
        }
        return new ArrayList();
    }

    public ActivePreset getCachedActivepreset() {
        return this.mCachedActivePreset;
    }

    private void processLoadedMappingSetList(List<SavedPreset> list) {
        setCacheIsDirty(false);
        if (list == null) {
            this.mCachedSavedPresetList = null;
            return;
        }
        if (this.mCachedSavedPresetList == null) {
            this.mCachedSavedPresetList = new LinkedHashMap();
        }
        this.mCachedSavedPresetList.clear();
        this.mCachedSavedPresetList.put(CACHE_MAPPING_SET_KEY, list);
    }

    private void processLoadedActivePreset(ActivePreset activePreset) {
        setIsActivePresetCacheDirty(false);
        if (activePreset == null) {
            this.mCachedActivePreset = null;
        } else {
            this.mCachedActivePreset = activePreset;
        }
    }

    public void getAllSavedPresets(final GetSavedPresetListCallback getSavedPresetListCallback) {
        MFLogger.d(TAG, "Inside .getAllUserPresets deviceSerial=,isCacheDirty=" + this.mCacheIsDirty + ", mCachedList=" + this.mCachedSavedPresetList);
        this.mMappingSetLocalDataSource.getAllSavedPresets(new GetSavedPresetListCallback() {
            public void onSuccess(List<SavedPreset> list) {
                MFLogger.d(PresetRepository.TAG, "Inside .getAllUserPresets get from local DB, result=" + list);
                if (getSavedPresetListCallback != null) {
                    getSavedPresetListCallback.onSuccess(list);
                }
            }

            public void onFail() {
                DataVersion hc = cnq.acd().acf().hc("user-presets");
                if (hc == null || hc.getTimestamp() == 0) {
                    MFLogger.d(PresetRepository.TAG, "Inside .getAllUserPresets get from local DB, fail downloadSavedPreset");
                    PresetRepository.this.downloadSavedPreset(getSavedPresetListCallback);
                    return;
                }
                MFLogger.d(PresetRepository.TAG, "Inside .getAllUserPresets get from local DB, fail");
                if (getSavedPresetListCallback != null) {
                    getSavedPresetListCallback.onFail();
                }
            }
        });
    }

    public void addOrUpdateActivePreset(final ActivePreset activePreset, final AddOrUpdateActivePresetCallback addOrUpdateActivePresetCallback) {
        MFLogger.d(TAG, "Inside .addOrUpdateActivePreset activePreset=" + activePreset.getSerialNumber());
        emj.f(addOrUpdateActivePresetCallback, "AddOrUpdateActivePresetCallback can not be null");
        activePreset.setPinType(2);
        this.mMappingSetLocalDataSource.addOrUpdateActivePreset(activePreset, new AddOrUpdateActivePresetCallback() {
            public void onSuccess(ActivePreset activePreset) {
                MFLogger.d(PresetRepository.TAG, "Inside .addOrUpdateActivePreset local onSuccess activePreset=" + activePreset.getSerialNumber());
                PresetRepository.this.pushActivePresetToServer(activePreset, null);
                PresetRepository.this.mIsActivePresetCacheDirty = true;
                PresetRepository.this.notifyActivePresetObserver();
                addOrUpdateActivePresetCallback.onSuccess(activePreset);
            }

            public void onFail() {
                MFLogger.d(PresetRepository.TAG, "Inside .addOrUpdateActivePreset local onFail activePreset=" + activePreset.getSerialNumber());
                addOrUpdateActivePresetCallback.onFail();
            }
        });
    }

    public void addOrUpdateSavedPreset(final SavedPreset savedPreset, final AddOrUpdateSavedPresetCallback addOrUpdateSavedPresetCallback) {
        MFLogger.d(TAG, "Inside .addOrUpdateSavedPreset");
        emj.f(addOrUpdateSavedPresetCallback, "AddOrUpdateSavedPresetCallback can not be null");
        MFLogger.d(TAG, "addOrUpdateSavedPreset");
        savedPreset.setPinType(2);
        this.mMappingSetLocalDataSource.addOrUpdateSavedPreset(savedPreset, new AddOrUpdateSavedPresetCallback() {
            public void onSuccess(SavedPreset savedPreset) {
                emj.f(addOrUpdateSavedPresetCallback, "addOrUpdateSavedPreset local success presetID=" + savedPreset.getId());
                PresetRepository.this.notifySavedPresetObserver();
                PresetRepository.this.pushSavedPresetToServer(savedPreset, null);
                addOrUpdateSavedPresetCallback.onSuccess(savedPreset);
            }

            public void onFail() {
                emj.f(addOrUpdateSavedPresetCallback, "addOrUpdateSavedPreset local failed presetID=" + savedPreset.getId());
                addOrUpdateSavedPresetCallback.onFail();
            }
        });
    }

    public void deleteSavedPreset(final SavedPreset savedPreset, final DeleteMappingSetCallback deleteMappingSetCallback) {
        MFLogger.d(TAG, "deleteSavedPreset Id=" + savedPreset.getId());
        emj.f(deleteMappingSetCallback, "DeleteMappingSetCallback can not be null");
        if (savedPreset.getPinType() != 0) {
            MFLogger.d(TAG, "deleteSavedPreset PinType.TYPE_PIN_EDIT id=" + savedPreset.getId());
            this.mMappingSetLocalDataSource.deleteSavedPreset(savedPreset, new DeleteMappingSetCallback() {
                public void onSuccess() {
                    MFLogger.d(PresetRepository.TAG, "deleteSavedPreset onSuccess PinType.TYPE_PIN_EDIT id=" + savedPreset.getId());
                    PresetRepository.this.mCacheIsDirty = true;
                    PresetRepository.this.notifySavedPresetObserver();
                    deleteMappingSetCallback.onSuccess();
                }

                public void onFail() {
                    MFLogger.d(PresetRepository.TAG, "deleteSavedPreset onFail");
                    deleteMappingSetCallback.onFail();
                }
            });
            return;
        }
        savedPreset.setPinType(3);
        this.mMappingSetLocalDataSource.addOrUpdateSavedPreset(savedPreset, new AddOrUpdateSavedPresetCallback() {
            public void onSuccess(SavedPreset savedPreset) {
                MFLogger.d(PresetRepository.TAG, "Inside .deleteSavedPreset delete successfully on local");
                PresetRepository.this.mCacheIsDirty = true;
                PresetRepository.this.notifySavedPresetObserver();
                PresetRepository.this.deleteSavedPresetInServer(savedPreset, null);
                deleteMappingSetCallback.onSuccess();
            }

            public void onFail() {
                MFLogger.d(PresetRepository.TAG, "Inside .deleteSavedPreset delete failed on local");
                deleteMappingSetCallback.onFail();
            }
        });
    }

    public void deleteAllRecommendedPresets(String str, DeleteMappingSetCallback deleteMappingSetCallback) {
        MFLogger.d(TAG, "Inside .deleteAllRecommendedPresets serial=" + str);
        this.mMappingSetLocalDataSource.deleteAllRecommendedPresets(str, deleteMappingSetCallback);
    }

    public void getActivePresetFromDB(String str, final GetActivePresetCallback getActivePresetCallback) {
        MFLogger.d(TAG, "Inside .getActivePreset");
        if (this.mIsActivePresetCacheDirty || this.mCachedActivePreset == null || getActivePresetCallback == null) {
            this.mMappingSetLocalDataSource.getActivePreset(str, new GetActivePresetCallback() {
                public void onSuccess(ActivePreset activePreset) {
                    MFLogger.d(PresetRepository.TAG, "Inside .getActivePreset on DB onSuccess");
                    PresetRepository.this.processLoadedActivePreset(activePreset);
                    if (getActivePresetCallback != null) {
                        getActivePresetCallback.onSuccess(activePreset);
                    }
                }

                public void onFail() {
                    MFLogger.d(PresetRepository.TAG, "Inside .getActivePreset on DB onFail");
                    if (getActivePresetCallback != null) {
                        getActivePresetCallback.onFail();
                    }
                }
            });
            return;
        }
        MFLogger.d(TAG, "Inside .getAllUserPresetsFromDB get from cache, result=" + getCachedActivepreset());
        getActivePresetCallback.onSuccess(this.mCachedActivePreset);
    }

    public void getActivePreset(final String str, final GetActivePresetCallback getActivePresetCallback) {
        MFLogger.d(TAG, "Inside .getActivePreset");
        this.mMappingSetLocalDataSource.getActivePreset(str, new GetActivePresetCallback() {

            class C48261 implements GetActivePresetListCallback {
                C48261() {
                }

                public void onSuccess(final List<ActivePreset> list) {
                    MFLogger.d(PresetRepository.TAG, "Inside .getActivePreset download on remote onSuccess");
                    PresetRepository.this.mAppExecutors.YQ().execute(new Runnable() {
                        public void run() {
                            MFLogger.d(PresetRepository.TAG, "diskIO enter onFail onSuccess getActivePreset");
                            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                            for (final ActivePreset activePreset : list) {
                                PresetRepository.this.mMappingSetLocalDataSource.addOrUpdateActivePreset(activePreset, new AddOrUpdateActivePresetCallback() {
                                    public void onSuccess(ActivePreset activePreset) {
                                        MFLogger.d(PresetRepository.TAG, "Inside .getActivePreset save to local onSuccess serial=" + activePreset.getSerialNumber());
                                        if (activePreset.getSerialNumber().equals(str)) {
                                            PresetRepository.this.notifyStatusChanged("ACTIVE_PRESET_DOWNLOADED", str);
                                            atomicBoolean.getAndSet(true);
                                            getActivePresetCallback.onSuccess(activePreset);
                                        }
                                    }

                                    public void onFail() {
                                        MFLogger.d(PresetRepository.TAG, "Inside .getActivePreset save to local onFail serial=" + activePreset.getSerialNumber());
                                    }
                                });
                            }
                            MFLogger.d(PresetRepository.TAG, "Inside .getActivePreset done update on local isSuccess=" + atomicBoolean.get());
                            if (!atomicBoolean.get()) {
                                getActivePresetCallback.onFail();
                            }
                            MFLogger.d(PresetRepository.TAG, "diskIO exit onFail onSuccess getActivePreset");
                        }
                    });
                }

                public void onFail() {
                    MFLogger.d(PresetRepository.TAG, "Inside .getActivePreset download on remote onFail");
                    getActivePresetCallback.onFail();
                }
            }

            public void onSuccess(ActivePreset activePreset) {
                MFLogger.d(PresetRepository.TAG, "Inside .getActivePreset on DB onSuccess");
                PresetRepository.this.notifyStatusChanged("ACTIVE_PRESET_DOWNLOADED", str);
                PresetRepository.this.processLoadedActivePreset(activePreset);
                getActivePresetCallback.onSuccess(activePreset);
            }

            public void onFail() {
                MFLogger.d(PresetRepository.TAG, "Inside .getActivePreset on DB onFail");
                PresetRepository.this.notifyStatusChanged("PRESETS_DOWNLOADING", str);
                PresetRepository.this.mMappingSetRemoteDataSource.downloadActivePresetList(new C48261());
            }
        });
    }

    private void notifyStatusChanged(String str, String str2) {
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

    public void activateDefaultPreset(final RecommendedPreset recommendedPreset, final GetActivePresetCallback getActivePresetCallback) {
        MFLogger.d(TAG, "activateDefaultPreset mappingSetId=" + recommendedPreset.getId());
        ActivePreset activePreset = new ActivePreset();
        activePreset.setCreateAt(System.currentTimeMillis());
        activePreset.setButtons(recommendedPreset.getButtons());
        activePreset.setOriginalId(recommendedPreset.getId());
        activePreset.setSerialNumber(recommendedPreset.getSerialNumber());
        addOrUpdateActivePreset(activePreset, new AddOrUpdateActivePresetCallback() {
            public void onSuccess(ActivePreset activePreset) {
                MFLogger.d(PresetRepository.TAG, "activateDefaultPreset save activePreset to DB onSuccess");
                PresetRepository.this.notifyStatusChanged("ACTIVE_PRESET_DOWNLOADED", recommendedPreset.getSerialNumber());
                getActivePresetCallback.onSuccess(activePreset);
            }

            public void onFail() {
                MFLogger.d(PresetRepository.TAG, "activateDefaultPreset save activePreset to DB onFail");
                getActivePresetCallback.onFail();
            }
        });
    }

    public void getRecommendedPresets(final String str, final GetRecommendedPresetListCallback getRecommendedPresetListCallback) {
        MFLogger.d(TAG, "Inside .getRecommendedPresets deviceSerial=" + str);
        if (str == null || !str.isEmpty()) {
            this.mMappingSetLocalDataSource.getRecommendedPresets(str, new GetRecommendedPresetListCallback() {
                public void onSuccess(List<RecommendedPreset> list) {
                    MFLogger.d(PresetRepository.TAG, "getRecommendedPresets on local onSuccess deviceSerial=" + str);
                    getRecommendedPresetListCallback.onSuccess(list);
                }

                public void onFail() {
                    DataVersion hc = cnq.acd().acf().hc("recommended-presets");
                    if (hc == null || hc.getTimestamp() == 0) {
                        MFLogger.d(PresetRepository.TAG, "getRecommendedPresets on local onFail downloadRecommendPreset deviceSerial=" + str);
                        PresetRepository.this.downloadRecommendPreset(str, getRecommendedPresetListCallback);
                        return;
                    }
                    MFLogger.d(PresetRepository.TAG, "getRecommendedPresets on local onFail deviceSerial=" + str);
                    getRecommendedPresetListCallback.onFail();
                }
            });
        } else {
            getRecommendedPresetListCallback.onFail();
        }
    }

    public void getDefaultPreset(String str, GetRecommendedPresetCallback getRecommendedPresetCallback, boolean z) {
        MFLogger.d(TAG, "Inside .getDefaultPreset deviceSerial=" + str);
        if (str != null && str.isEmpty()) {
            getRecommendedPresetCallback.onFail();
        }
        if (z) {
            downloadDefaultMappingSet(str, getRecommendedPresetCallback);
        } else {
            getDefaultMappingSet(str, getRecommendedPresetCallback);
        }
    }

    public void getSavedPreset(String str, GetSavedPresetCallback getSavedPresetCallback) {
        MFLogger.d(TAG, "Inside .getSavedPreset mappingSetId=" + str);
        this.mMappingSetLocalDataSource.getSavedPreset(str, getSavedPresetCallback);
    }

    public void addOrUpdateUserPresetList(List<SavedPreset> list, final AddOrUpdateSavedPresetListCallback addOrUpdateSavedPresetListCallback) {
        MFLogger.d(TAG, "Inside .addOrUpdateUserPresetList savedPresetListSize=" + list.size());
        this.mMappingSetLocalDataSource.addOrUpdateUserPresetList(list, new AddOrUpdateSavedPresetListCallback() {

            class C48021 implements AddOrUpdateSavedPresetListCallback {
                C48021() {
                }

                public void onSuccess(List<SavedPreset> list) {
                    MFLogger.d(PresetRepository.TAG, "Inside .addOrUpdateUserPresetList onRemote success");
                }

                public void onFail() {
                    MFLogger.d(PresetRepository.TAG, "Inside .addOrUpdateUserPresetList onRemote onFail");
                }
            }

            public void onSuccess(List<SavedPreset> list) {
                MFLogger.d(PresetRepository.TAG, "Inside .addOrUpdateUserPresetList onLocal onSuccess savedPresetListSize=" + list.size());
                PresetRepository.this.mMappingSetRemoteDataSource.addOrUpdateUserPresetList(list, new C48021());
                PresetRepository.this.mCacheIsDirty = true;
                PresetRepository.this.notifySavedPresetObserver();
                addOrUpdateSavedPresetListCallback.onSuccess(list);
            }

            public void onFail() {
                MFLogger.d(PresetRepository.TAG, "Inside .addOrUpdateUserPresetList onLocal onFail");
                addOrUpdateSavedPresetListCallback.onFail();
            }
        });
    }

    public void downloadRecommendPreset(final String str, final GetRecommendedPresetListCallback getRecommendedPresetListCallback) {
        MFLogger.d(TAG, "downloadRecommendPreset serial=" + str);
        this.mMappingSetRemoteDataSource.downloadRecommendPreset(str, new GetRecommendedPresetListCallback() {
            public void onSuccess(final List<RecommendedPreset> list) {
                MFLogger.d(PresetRepository.TAG, "downloadRecommendPreset on remote onSuccess deviceSerial=" + str);
                if (getRecommendedPresetListCallback != null) {
                    getRecommendedPresetListCallback.onSuccess(list);
                }
                PresetRepository.this.mAppExecutors.YQ().execute(new Runnable() {

                    class C48031 implements DeleteMappingSetCallback {
                        C48031() {
                        }

                        public void onSuccess() {
                            MFLogger.d(PresetRepository.TAG, "deleteAllRecommendedPresets onSuccess deviceSerial=" + str);
                            PresetRepository.this.saveRecommendedPresetList(str, list);
                        }

                        public void onFail() {
                            MFLogger.d(PresetRepository.TAG, "deleteAllRecommendedPresets onFail deviceSerial=" + str);
                            PresetRepository.this.saveRecommendedPresetList(str, list);
                        }
                    }

                    public void run() {
                        PresetRepository.this.mMappingSetLocalDataSource.deleteAllRecommendedPresets(str, new C48031());
                    }
                });
            }

            public void onFail() {
                MFLogger.d(PresetRepository.TAG, "downloadRecommendPreset on remote onFail deviceSerial=" + str);
                if (getRecommendedPresetListCallback != null) {
                    getRecommendedPresetListCallback.onFail();
                }
            }
        });
    }

    private void saveRecommendedPresetList(String str, List<RecommendedPreset> list) {
        MFLogger.d(TAG, "saveRecommendedPresetList serial=" + str);
        for (int i = 0; i < list.size(); i++) {
            ((RecommendedPreset) list.get(i)).setSerialNumber(str);
        }
        if (((PresetLocalDataSource) this.mMappingSetLocalDataSource).addOrUpdateRecommendedPresets(list)) {
            MFLogger.d(TAG, "saveRecommendedPresetList saveDB success");
            this.mCacheIsDirty = true;
            notifySavedPresetObserver();
        }
    }

    public void downloadSavedPreset(final GetSavedPresetListCallback getSavedPresetListCallback) {
        this.mMappingSetRemoteDataSource.downloadSavedPreset(new GetSavedPresetListCallback() {
            public void onSuccess(final List<SavedPreset> list) {
                MFLogger.d(PresetRepository.TAG, "Inside .getAllUserPresets get from remote, success");
                MFLogger.d(PresetRepository.TAG, "Inside .getAllUserPresets save Preset to DB success");
                if (getSavedPresetListCallback != null) {
                    getSavedPresetListCallback.onSuccess(list);
                }
                PresetRepository.this.mAppExecutors.YQ().execute(new Runnable() {

                    class C48061 implements GetSavedPresetListCallback {

                        class C48051 implements AddOrUpdateSavedPresetListCallback {
                            C48051() {
                            }

                            public void onSuccess(List<SavedPreset> list) {
                                MFLogger.d(PresetRepository.TAG, "Inside .addOrUpdateUserPresetList success");
                                PresetRepository.this.mCacheIsDirty = true;
                                PresetRepository.this.notifySavedPresetObserver();
                            }

                            public void onFail() {
                            }
                        }

                        C48061() {
                        }

                        public void onSuccess(List<SavedPreset> list) {
                            if (list == null || list.isEmpty()) {
                                MFLogger.d(PresetRepository.TAG, "Inside .onSuccess Server preset list is empty");
                                return;
                            }
                            for (SavedPreset savedPreset : list) {
                                SavedPreset access$1200 = PresetRepository.this.findLocalPreset(savedPreset.getId(), list);
                                MFLogger.d(PresetRepository.TAG, "Merge savedPreset localPreset=" + access$1200 + ", serverPresetUpdatedAt=" + savedPreset.getUpdateAt() + ", localUpdatedAt=" + (access$1200 != null ? Long.valueOf(access$1200.getUpdateAt()) : WeiboAuthException.DEFAULT_AUTH_ERROR_CODE));
                                if (access$1200 == null || access$1200.getUpdateAt() <= savedPreset.getUpdateAt()) {
                                    savedPreset.setPinType(0);
                                    PresetRepository.this.mMappingSetLocalDataSource.addOrUpdateSavedPreset(savedPreset, null);
                                    PresetRepository.this.mCacheIsDirty = true;
                                    PresetRepository.this.notifySavedPresetObserver();
                                }
                            }
                        }

                        public void onFail() {
                            if (list == null || list.isEmpty()) {
                                MFLogger.d(PresetRepository.TAG, "Inside .onFail Server preset list is empty");
                            } else {
                                PresetRepository.this.mMappingSetLocalDataSource.addOrUpdateUserPresetList(list, new C48051());
                            }
                        }
                    }

                    public void run() {
                        PresetRepository.this.mMappingSetLocalDataSource.getAllSavedPresets(new C48061());
                    }
                });
            }

            public void onFail() {
                MFLogger.d(PresetRepository.TAG, "Inside .getAllUserPresets get from remote, fail");
                if (getSavedPresetListCallback != null) {
                    getSavedPresetListCallback.onFail();
                }
            }
        });
    }

    private SavedPreset findLocalPreset(String str, List<SavedPreset> list) {
        for (SavedPreset savedPreset : list) {
            if (savedPreset.getId().equalsIgnoreCase(str)) {
                return savedPreset;
            }
        }
        return null;
    }

    public void downloadActivePresetList(final GetActivePresetListCallback getActivePresetListCallback) {
        MFLogger.d(TAG, "downloadActivePresetList");
        this.mMappingSetRemoteDataSource.downloadActivePresetList(new GetActivePresetListCallback() {
            public void onSuccess(final List<ActivePreset> list) {
                MFLogger.d(PresetRepository.TAG, "downloadActivePresetList onSuccess size=" + list.size());
                if (getActivePresetListCallback != null) {
                    getActivePresetListCallback.onSuccess(list);
                }
                PresetRepository.this.mAppExecutors.YQ().execute(new Runnable() {
                    public void run() {
                        for (final ActivePreset activePreset : list) {
                            PresetRepository.this.mMappingSetLocalDataSource.addOrUpdateActivePreset(activePreset, new AddOrUpdateActivePresetCallback() {
                                public void onSuccess(ActivePreset activePreset) {
                                    MFLogger.d(PresetRepository.TAG, "downloadActivePresetList save DB Success serial=" + activePreset.getSerialNumber());
                                    PresetRepository.this.mIsActivePresetCacheDirty = true;
                                    PresetRepository.this.notifyActivePresetObserver();
                                }

                                public void onFail() {
                                    MFLogger.d(PresetRepository.TAG, "downloadActivePresetList save DB Failed serial=" + activePreset.getSerialNumber());
                                }
                            });
                        }
                    }
                });
            }

            public void onFail() {
                MFLogger.d(PresetRepository.TAG, "downloadActivePresetList onFail");
                if (getActivePresetListCallback != null) {
                    getActivePresetListCallback.onFail();
                }
            }
        });
    }

    private void getDefaultMappingSet(final String str, final GetRecommendedPresetCallback getRecommendedPresetCallback) {
        MFLogger.d(TAG, "Inside .getDefaultPreset serial=" + str);
        if (str != null && str.isEmpty()) {
            getRecommendedPresetCallback.onFail();
        }
        this.mMappingSetLocalDataSource.getDefaultPreset(str, new GetRecommendedPresetCallback() {

            class C48101 implements GetRecommendedPresetCallback {
                C48101() {
                }

                public void onSuccess(RecommendedPreset recommendedPreset) {
                    MFLogger.d(PresetRepository.TAG, "Inside .getDefaultPreset downloadDefaultMappingSet onSuccess");
                    getRecommendedPresetCallback.onSuccess(recommendedPreset);
                }

                public void onFail() {
                    MFLogger.d(PresetRepository.TAG, "Inside .getDefaultPreset downloadDefaultMappingSet onFail");
                    getRecommendedPresetCallback.onFail();
                }
            }

            public void onSuccess(RecommendedPreset recommendedPreset) {
                MFLogger.d(PresetRepository.TAG, "Inside .getDefaultPreset onSuccess serial=" + str);
                getRecommendedPresetCallback.onSuccess(recommendedPreset);
            }

            public void onFail() {
                MFLogger.d(PresetRepository.TAG, "Inside .getDefaultPreset onFail serial=" + str);
                PresetRepository.this.downloadDefaultMappingSet(str, new C48101());
            }
        }, true);
    }

    private void downloadDefaultMappingSet(final String str, final GetRecommendedPresetCallback getRecommendedPresetCallback) {
        MFLogger.d(TAG, "Inside .downloadDefaultMappingSet");
        this.mMappingSetRemoteDataSource.getDefaultPreset(str, new GetRecommendedPresetCallback() {
            public void onSuccess(final RecommendedPreset recommendedPreset) {
                if (recommendedPreset != null) {
                    recommendedPreset.setSerialNumber(str);
                    getRecommendedPresetCallback.onSuccess(recommendedPreset);
                    PresetRepository.this.mAppExecutors.YQ().execute(new Runnable() {
                        public void run() {
                            MFLogger.d(PresetRepository.TAG, "Download default mapping set from server success, defaultPresetId=" + recommendedPreset.getId());
                            if (((PresetLocalDataSource) PresetRepository.this.mMappingSetLocalDataSource).addOrUpdateDefaultPreset(recommendedPreset)) {
                                MFLogger.d(PresetRepository.TAG, "getRecommendedPresets on remote onSuccess saveDB success");
                                PresetRepository.this.mCacheIsDirty = true;
                                PresetRepository.this.notifySavedPresetObserver();
                            }
                        }
                    });
                    return;
                }
                PresetRepository.this.generateDefaultMappingSet(str, getRecommendedPresetCallback);
            }

            public void onFail() {
                PresetRepository.this.generateDefaultMappingSet(str, getRecommendedPresetCallback);
            }
        }, true);
    }

    public void pushPendingActivePresets(PushPendingActivePresetsCallback pushPendingActivePresetsCallback) {
        CountDownLatch countDownLatch;
        MFLogger.d(TAG, "pushPendingActivePresets");
        List<ActivePreset> allPendingActivePresets = ((PresetLocalDataSource) this.mMappingSetLocalDataSource).getAllPendingActivePresets();
        if (pushPendingActivePresetsCallback == null || allPendingActivePresets.size() <= 0) {
            countDownLatch = null;
        } else {
            countDownLatch = new CountDownLatch(allPendingActivePresets.size());
        }
        for (ActivePreset activePreset : allPendingActivePresets) {
            MFLogger.d(TAG, "pushPendingActivePresets serial=" + activePreset.getSerialNumber() + " pinType=" + activePreset.getPinType());
            pushActivePresetToServer(activePreset, new PushActivePresetToServerCallback() {
                public void onSuccess() {
                    MFLogger.d(PresetRepository.TAG, "pushActivePresetToServer success, bravo!!!");
                    if (countDownLatch != null) {
                        countDownLatch.countDown();
                    }
                }

                public void onFail() {
                    MFLogger.d(PresetRepository.TAG, "pushActivePresetToServer failed :(((");
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
        if (pushPendingActivePresetsCallback != null) {
            pushPendingActivePresetsCallback.onDone();
        }
    }

    public void pushPendingSavedPresets(PushPendingSavedPresetsCallback pushPendingSavedPresetsCallback) {
        CountDownLatch countDownLatch;
        MFLogger.d(TAG, "pushPendingSavedPresets");
        List<SavedPreset> allPendingSavedPresets = ((PresetLocalDataSource) this.mMappingSetLocalDataSource).getAllPendingSavedPresets();
        if (pushPendingSavedPresetsCallback == null || allPendingSavedPresets.size() <= 0) {
            MFLogger.d(TAG, "Pending saved preset is empty, moving forward");
            countDownLatch = null;
        } else {
            CountDownLatch countDownLatch2 = new CountDownLatch(allPendingSavedPresets.size());
            MFLogger.d(TAG, "Pending saved preset size=" + allPendingSavedPresets.size());
            countDownLatch = countDownLatch2;
        }
        for (SavedPreset savedPreset : allPendingSavedPresets) {
            MFLogger.d(TAG, "pushPendingSavedPresets id=" + savedPreset.getId() + " pinType=" + savedPreset.getPinType());
            if (savedPreset.getPinType() == 3) {
                deleteSavedPresetInServer(savedPreset, new DeleteSavedPresetInServerCallback() {
                    public void onSuccess() {
                        MFLogger.d(PresetRepository.TAG, "deleteSavedPresetInServer success, bravo!!!");
                        if (countDownLatch != null) {
                            countDownLatch.countDown();
                        }
                    }

                    public void onFail() {
                        MFLogger.d(PresetRepository.TAG, "deleteSavedPresetInServer failed");
                        if (countDownLatch != null) {
                            countDownLatch.countDown();
                        }
                    }
                });
            } else {
                pushSavedPresetToServer(savedPreset, new PushSavedPresetToServerCallback() {
                    public void onSuccess() {
                        MFLogger.d(PresetRepository.TAG, "pushSavedPresetToServer success, bravo!!!");
                        if (countDownLatch != null) {
                            countDownLatch.countDown();
                        }
                    }

                    public void onFail() {
                        MFLogger.d(PresetRepository.TAG, "pushSavedPresetToServer failed");
                        if (countDownLatch != null) {
                            countDownLatch.countDown();
                        }
                    }
                });
            }
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
        if (pushPendingSavedPresetsCallback != null) {
            pushPendingSavedPresetsCallback.onDone();
        }
    }

    private void pushActivePresetToServer(final ActivePreset activePreset, final PushActivePresetToServerCallback pushActivePresetToServerCallback) {
        this.mMappingSetRemoteDataSource.addOrUpdateActivePreset(activePreset, new AddOrUpdateActivePresetCallback() {
            public void onSuccess(final ActivePreset activePreset) {
                MFLogger.d(PresetRepository.TAG, "pushActivePresetToServer onSuccess serial=" + activePreset.getSerialNumber());
                if (pushActivePresetToServerCallback != null) {
                    pushActivePresetToServerCallback.onSuccess();
                }
                PresetRepository.this.mAppExecutors.YQ().execute(new Runnable() {
                    public void run() {
                        ((PresetLocalDataSource) PresetRepository.this.mMappingSetLocalDataSource).updateActivePresetPinType(activePreset.getSerialNumber(), 0);
                    }
                });
            }

            public void onFail() {
                MFLogger.d(PresetRepository.TAG, "pushActivePresetToServer onFail serial=" + activePreset.getSerialNumber());
                if (pushActivePresetToServerCallback != null) {
                    pushActivePresetToServerCallback.onFail();
                }
            }
        });
    }

    private void pushSavedPresetToServer(final SavedPreset savedPreset, final PushSavedPresetToServerCallback pushSavedPresetToServerCallback) {
        this.mMappingSetRemoteDataSource.addOrUpdateSavedPreset(savedPreset, new AddOrUpdateSavedPresetCallback() {
            public void onSuccess(final SavedPreset savedPreset) {
                MFLogger.d(PresetRepository.TAG, "addOrUpdateSavedPreset remote success id=" + savedPreset.getId());
                if (pushSavedPresetToServerCallback != null) {
                    pushSavedPresetToServerCallback.onSuccess();
                }
                PresetRepository.this.mAppExecutors.YQ().execute(new Runnable() {
                    public void run() {
                        ((PresetLocalDataSource) PresetRepository.this.mMappingSetLocalDataSource).updateSavedPresetPinType(savedPreset.getId(), 0);
                    }
                });
            }

            public void onFail() {
                MFLogger.d(PresetRepository.TAG, "addOrUpdateSavedPreset remote failed objectId=" + savedPreset.getId());
                if (pushSavedPresetToServerCallback != null) {
                    pushSavedPresetToServerCallback.onFail();
                }
            }
        });
    }

    private void deleteSavedPresetInServer(SavedPreset savedPreset, final DeleteSavedPresetInServerCallback deleteSavedPresetInServerCallback) {
        final SavedPreset savedPreset2 = (SavedPreset) emj.ce(savedPreset);
        this.mMappingSetRemoteDataSource.deleteSavedPreset(savedPreset2, new DeleteMappingSetCallback() {

            class C48181 implements Runnable {

                class C48171 implements DeleteMappingSetCallback {

                    class C48151 implements Runnable {
                        C48151() {
                        }

                        public void run() {
                            deleteSavedPresetInServerCallback.onSuccess();
                        }
                    }

                    class C48162 implements Runnable {
                        C48162() {
                        }

                        public void run() {
                            deleteSavedPresetInServerCallback.onFail();
                        }
                    }

                    C48171() {
                    }

                    public void onSuccess() {
                        if (deleteSavedPresetInServerCallback != null) {
                            PresetRepository.this.mAppExecutors.YS().execute(new C48151());
                        }
                    }

                    public void onFail() {
                        if (deleteSavedPresetInServerCallback != null) {
                            PresetRepository.this.mAppExecutors.YS().execute(new C48162());
                        }
                    }
                }

                C48181() {
                }

                public void run() {
                    PresetRepository.this.mMappingSetLocalDataSource.deleteSavedPreset(savedPreset2, new C48171());
                }
            }

            public void onSuccess() {
                MFLogger.d(PresetRepository.TAG, "Inside .deleteSavedPreset delete failed on remote");
                PresetRepository.this.mAppExecutors.YQ().execute(new C48181());
            }

            public void onFail() {
                MFLogger.d(PresetRepository.TAG, "Inside .deleteSavedPreset delete failed on remote");
                if (deleteSavedPresetInServerCallback != null) {
                    deleteSavedPresetInServerCallback.onFail();
                }
            }
        });
    }

    private void generateDefaultMappingSet(String str, GetRecommendedPresetCallback getRecommendedPresetCallback) {
        MFLogger.d(TAG, "Inside start .generateDefaultMappingSet deviceSerial=" + str);
        List abx = new clz(str).abx();
        final RecommendedPreset recommendedPreset = new RecommendedPreset();
        recommendedPreset.setName(arp.u(PortfolioApp.ZQ(), R.string.General_Presets_Label_FAVORITES));
        recommendedPreset.setCreateAt(System.currentTimeMillis());
        try {
            recommendedPreset.setButtonMappingList(abx);
        } catch (IOException e) {
            e.printStackTrace();
        }
        recommendedPreset.setType(SavedPreset$MappingSetType.DEFAULT);
        recommendedPreset.setSerialNumber(str);
        getRecommendedPresetCallback.onSuccess(recommendedPreset);
        this.mAppExecutors.YQ().execute(new Runnable() {
            public void run() {
                if (((PresetLocalDataSource) PresetRepository.this.mMappingSetLocalDataSource).addOrUpdateDefaultPreset(recommendedPreset)) {
                    MFLogger.d(PresetRepository.TAG, "getRecommendedPresets generateDefaultMappingSet saveDB success");
                    PresetRepository.this.mCacheIsDirty = true;
                    PresetRepository.this.notifySavedPresetObserver();
                }
            }
        });
    }

    public void getAllUserPresetsFromDB(String str, final GetSavedPresetListCallback getSavedPresetListCallback) {
        MFLogger.d(TAG, "Inside .getAllUserPresetsFromDB deviceSerial=" + str + ",isCacheDirty=" + this.mCacheIsDirty + ", mCachedList=" + this.mCachedSavedPresetList);
        if (this.mCacheIsDirty || this.mCachedSavedPresetList == null || getSavedPresetListCallback == null) {
            this.mMappingSetLocalDataSource.getAllSavedPresets(new GetSavedPresetListCallback() {
                public void onSuccess(List<SavedPreset> list) {
                    MFLogger.d(PresetRepository.TAG, "Inside .getAllUserPresetsFromDB get from local DB, result=" + list);
                    PresetRepository.this.processLoadedMappingSetList(list);
                    if (getSavedPresetListCallback != null) {
                        getSavedPresetListCallback.onSuccess(PresetRepository.this.getCachedMappingSetList());
                    }
                }

                public void onFail() {
                    MFLogger.d(PresetRepository.TAG, "Inside .getAllUserPresetsFromDB get from local DB, fail");
                    if (getSavedPresetListCallback != null) {
                        getSavedPresetListCallback.onFail();
                    }
                }
            });
            return;
        }
        MFLogger.d(TAG, "Inside .getAllUserPresetsFromDB get from cache, result=" + getCachedMappingSetList());
        getSavedPresetListCallback.onSuccess(getCachedMappingSetList());
    }

    public void clearData() {
        this.mMappingSetLocalDataSource.clearData();
        this.mCachedActivePreset = null;
        this.mCachedSavedPresetList = null;
        this.mIsActivePresetCacheDirty = true;
        this.mCacheIsDirty = true;
    }

    public void setCacheIsDirty(boolean z) {
        this.mCacheIsDirty = z;
    }

    public void setIsActivePresetCacheDirty(boolean z) {
        this.mIsActivePresetCacheDirty = z;
    }
}
