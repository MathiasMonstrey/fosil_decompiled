package com.portfolio.platform.data.source.remote;

import com.fossil.cnq;
import com.fossil.crx;
import com.fossil.cry;
import com.fossil.crz;
import com.fossil.csb;
import com.fossil.csd;
import com.fossil.csf;
import com.fossil.csh;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.DataVersion;
import com.portfolio.platform.data.model.microapp.ActivePreset;
import com.portfolio.platform.data.model.microapp.Range;
import com.portfolio.platform.data.model.microapp.RecommendedPreset;
import com.portfolio.platform.data.model.microapp.SavedPreset;
import com.portfolio.platform.data.source.PresetDataSource;
import com.portfolio.platform.data.source.PresetDataSource.AddOrUpdateActivePresetCallback;
import com.portfolio.platform.data.source.PresetDataSource.AddOrUpdateSavedPresetCallback;
import com.portfolio.platform.data.source.PresetDataSource.AddOrUpdateSavedPresetListCallback;
import com.portfolio.platform.data.source.PresetDataSource.DeleteMappingSetCallback;
import com.portfolio.platform.data.source.PresetDataSource.GetActivePresetCallback;
import com.portfolio.platform.data.source.PresetDataSource.GetActivePresetListCallback;
import com.portfolio.platform.data.source.PresetDataSource.GetRecommendedPresetCallback;
import com.portfolio.platform.data.source.PresetDataSource.GetRecommendedPresetListCallback;
import com.portfolio.platform.data.source.PresetDataSource.GetSavedPresetCallback;
import com.portfolio.platform.data.source.PresetDataSource.GetSavedPresetListCallback;
import com.portfolio.platform.response.microapp.MFDeleteUserPresetListResponse;
import com.portfolio.platform.response.microapp.MFGetActivePresetListResponse;
import com.portfolio.platform.response.microapp.MFGetDefaultPresetResponse;
import com.portfolio.platform.response.microapp.MFGetRecommendedPresetsResponse;
import com.portfolio.platform.response.microapp.MFGetUserPresetsResponse;
import com.portfolio.platform.response.microapp.MFUpsertActivePresetResponse;
import com.portfolio.platform.response.microapp.MFUpsertPresetResponse;
import java.util.ArrayList;
import java.util.List;

public class PresetRemoteDataSource implements PresetDataSource {
    private static final String TAG = PresetRemoteDataSource.class.getSimpleName();

    public void getAllSavedPresets(GetSavedPresetListCallback getSavedPresetListCallback) {
    }

    private void getUserPresets(int i, int i2, MFServerResultCallback mFServerResultCallback) {
        MFLogger.d(TAG, "getUserPresets offset=" + i + " size=" + i2);
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new csd(PortfolioApp.ZQ(), i, i2), mFServerResultCallback);
    }

    public void addOrUpdateSavedPreset(final SavedPreset savedPreset, final AddOrUpdateSavedPresetCallback addOrUpdateSavedPresetCallback) {
        MFLogger.d(TAG, "addOrUpdateSavedPreset mappingSetId=" + savedPreset.getId() + " mappingSetName=" + savedPreset.getName());
        List arrayList = new ArrayList();
        arrayList.add(savedPreset);
        addOrUpdateUserPresetList(arrayList, new AddOrUpdateSavedPresetListCallback() {
            public void onSuccess(List<SavedPreset> list) {
                MFLogger.d(PresetRemoteDataSource.TAG, "addOrUpdateSavedPreset onSuccess mappingSetId=" + savedPreset.getId() + " mappingSetName=" + savedPreset.getName());
                if (list.isEmpty()) {
                    if (addOrUpdateSavedPresetCallback != null) {
                        addOrUpdateSavedPresetCallback.onFail();
                    }
                } else if (addOrUpdateSavedPresetCallback != null) {
                    addOrUpdateSavedPresetCallback.onSuccess((SavedPreset) list.get(0));
                }
            }

            public void onFail() {
                MFLogger.d(PresetRemoteDataSource.TAG, "addOrUpdateSavedPreset onFail mappingSetId=" + savedPreset.getId() + " mappingSetName=" + savedPreset.getName());
                if (addOrUpdateSavedPresetCallback != null) {
                    addOrUpdateSavedPresetCallback.onFail();
                }
            }
        });
    }

    public void addOrUpdateActivePreset(final ActivePreset activePreset, final AddOrUpdateActivePresetCallback addOrUpdateActivePresetCallback) {
        MFLogger.d(TAG, "addOrUpdateActivePreset serialNumber=" + activePreset.getSerialNumber() + " originalId=" + activePreset.getOriginalId());
        List arrayList = new ArrayList();
        arrayList.add(activePreset);
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new csf(PortfolioApp.ZQ(), arrayList), new MFServerResultCallback() {
            public void onSuccess(MFResponse mFResponse) {
                MFLogger.d(PresetRemoteDataSource.TAG, "addOrUpdateActivePreset onSuccess serialNumber=" + activePreset.getSerialNumber() + " originalId=" + activePreset.getOriginalId());
                if (mFResponse instanceof MFUpsertActivePresetResponse) {
                    MFUpsertActivePresetResponse mFUpsertActivePresetResponse = (MFUpsertActivePresetResponse) mFResponse;
                    if (addOrUpdateActivePresetCallback != null) {
                        addOrUpdateActivePresetCallback.onSuccess((ActivePreset) mFUpsertActivePresetResponse.getmActivePresetList().get(0));
                    }
                }
            }

            public void onFail(int i, MFResponse mFResponse) {
                MFLogger.d(PresetRemoteDataSource.TAG, "addOrUpdateActivePreset onFail serialNumber=" + activePreset.getSerialNumber() + " originalId=" + activePreset.getOriginalId());
                if (addOrUpdateActivePresetCallback != null) {
                    addOrUpdateActivePresetCallback.onFail();
                }
            }
        });
    }

    public void addOrUpdateUserPresetList(final List<SavedPreset> list, final AddOrUpdateSavedPresetListCallback addOrUpdateSavedPresetListCallback) {
        MFLogger.d(TAG, "addOrUpdateUserPresetList presetListSize=" + list.size());
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new csh(PortfolioApp.ZQ(), list), new MFServerResultCallback() {
            public void onSuccess(MFResponse mFResponse) {
                MFLogger.d(PresetRemoteDataSource.TAG, "addOrUpdateUserPresetList onSuccess presetListSize=" + list.size());
                if (mFResponse instanceof MFUpsertPresetResponse) {
                    MFUpsertPresetResponse mFUpsertPresetResponse = (MFUpsertPresetResponse) mFResponse;
                    if (addOrUpdateSavedPresetListCallback != null) {
                        addOrUpdateSavedPresetListCallback.onSuccess(mFUpsertPresetResponse.getSavedPresetList());
                    }
                }
            }

            public void onFail(int i, MFResponse mFResponse) {
                MFLogger.d(PresetRemoteDataSource.TAG, "addOrUpdateUserPresetList onFail presetListSize=" + list.size());
                if (addOrUpdateSavedPresetListCallback != null) {
                    addOrUpdateSavedPresetListCallback.onFail();
                }
            }
        });
    }

    public void downloadRecommendPreset(final String str, final GetRecommendedPresetListCallback getRecommendedPresetListCallback) {
        MFLogger.d(TAG, "downloadRecommendPreset deviceSerial=" + str);
        final List arrayList = new ArrayList();
        getRecommendedPresets(str, 0, 100, new MFServerResultCallback() {
            public void onSuccess(MFResponse mFResponse) {
                MFLogger.d(PresetRemoteDataSource.TAG, "downloadRecommendPreset deviceSerial=" + str + " onSuccess");
                if (mFResponse instanceof MFGetRecommendedPresetsResponse) {
                    MFGetRecommendedPresetsResponse mFGetRecommendedPresetsResponse = (MFGetRecommendedPresetsResponse) mFResponse;
                    arrayList.addAll(mFGetRecommendedPresetsResponse.getRecommendedPresets());
                    Range range = mFGetRecommendedPresetsResponse.getRange();
                    if (range != null && range.isHasNext()) {
                        MFLogger.d(PresetRemoteDataSource.TAG, "downloadRecommendPreset deviceSerial=" + str + " onSuccess hasNext=true");
                        PresetRemoteDataSource.this.getRecommendedPresets(str, (range.getOffset() + range.getLimit()) + 1, range.getLimit(), this);
                    } else if (getRecommendedPresetListCallback != null) {
                        MFLogger.d(PresetRemoteDataSource.TAG, "downloadRecommendPreset deviceSerial=" + str + " onSuccess hasNext=false");
                        if (arrayList.isEmpty()) {
                            getRecommendedPresetListCallback.onFail();
                        } else {
                            getRecommendedPresetListCallback.onSuccess(arrayList);
                        }
                    }
                }
            }

            public void onFail(int i, MFResponse mFResponse) {
                MFLogger.d(PresetRemoteDataSource.TAG, "downloadRecommendPreset deviceSerial=" + str + " onFail error=" + i);
                if (arrayList.isEmpty()) {
                    MFLogger.d(PresetRemoteDataSource.TAG, "downloadRecommendPreset deviceSerial=" + str + " onFail mappingSetList is null");
                    if (getRecommendedPresetListCallback != null) {
                        getRecommendedPresetListCallback.onFail();
                    }
                } else {
                    MFLogger.d(PresetRemoteDataSource.TAG, "downloadRecommendPreset deviceSerial=" + str + " onFail mappingSetList not null");
                    if (getRecommendedPresetListCallback != null) {
                        getRecommendedPresetListCallback.onSuccess(arrayList);
                    }
                }
                cnq.acd().acf().addOrUpdateDataVersioning(new DataVersion("recommended-presets", 0));
            }
        });
    }

    public void downloadSavedPreset(final GetSavedPresetListCallback getSavedPresetListCallback) {
        MFLogger.d(TAG, "downloadSavedPreset");
        final List arrayList = new ArrayList();
        getUserPresets(0, 100, new MFServerResultCallback() {
            public void onSuccess(MFResponse mFResponse) {
                MFLogger.d(PresetRemoteDataSource.TAG, "downloadSavedPreset onSuccess");
                if (mFResponse instanceof MFGetUserPresetsResponse) {
                    MFGetUserPresetsResponse mFGetUserPresetsResponse = (MFGetUserPresetsResponse) mFResponse;
                    arrayList.addAll(mFGetUserPresetsResponse.getSavedPresetList());
                    Range range = mFGetUserPresetsResponse.getRange();
                    if (range != null && range.isHasNext()) {
                        MFLogger.d(PresetRemoteDataSource.TAG, "downloadSavedPreset onSuccess hasNext=true");
                        PresetRemoteDataSource.this.getUserPresets((range.getOffset() + range.getLimit()) + 1, range.getLimit(), this);
                    } else if (getSavedPresetListCallback != null) {
                        MFLogger.d(PresetRemoteDataSource.TAG, "downloadSavedPreset onSuccess hasNext=false");
                        if (arrayList.isEmpty()) {
                            getSavedPresetListCallback.onFail();
                        } else {
                            getSavedPresetListCallback.onSuccess(arrayList);
                        }
                    }
                }
            }

            public void onFail(int i, MFResponse mFResponse) {
                MFLogger.d(PresetRemoteDataSource.TAG, "downloadSavedPreset onFail");
                if (arrayList.isEmpty()) {
                    MFLogger.d(PresetRemoteDataSource.TAG, "downloadSavedPreset onFail presetList is null");
                    if (getSavedPresetListCallback != null) {
                        getSavedPresetListCallback.onFail();
                    }
                } else {
                    MFLogger.d(PresetRemoteDataSource.TAG, "downloadSavedPreset onFail presetList not null");
                    if (getSavedPresetListCallback != null) {
                        getSavedPresetListCallback.onSuccess(arrayList);
                    }
                }
                cnq.acd().acf().addOrUpdateDataVersioning(new DataVersion("user-presets", 0));
            }
        });
    }

    public void deleteSavedPreset(final SavedPreset savedPreset, final DeleteMappingSetCallback deleteMappingSetCallback) {
        MFLogger.d(TAG, "deleteSavedPreset presetId=" + savedPreset.getId());
        List arrayList = new ArrayList();
        arrayList.add(savedPreset.getId());
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new crx(PortfolioApp.ZQ(), arrayList), new MFServerResultCallback() {
            public void onSuccess(MFResponse mFResponse) {
                MFLogger.d(PresetRemoteDataSource.TAG, "deleteSavedPreset onSuccess presetId=" + savedPreset.getId());
                if ((mFResponse instanceof MFDeleteUserPresetListResponse) && deleteMappingSetCallback != null) {
                    deleteMappingSetCallback.onSuccess();
                }
            }

            public void onFail(int i, MFResponse mFResponse) {
                MFLogger.d(PresetRemoteDataSource.TAG, "deleteSavedPreset onFail presetId=" + savedPreset.getId());
                if (deleteMappingSetCallback != null) {
                    deleteMappingSetCallback.onFail();
                }
            }
        });
    }

    public void deleteAllRecommendedPresets(String str, DeleteMappingSetCallback deleteMappingSetCallback) {
    }

    public void getActivePreset(String str, GetActivePresetCallback getActivePresetCallback) {
    }

    public void downloadActivePresetList(final GetActivePresetListCallback getActivePresetListCallback) {
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cry(PortfolioApp.ZQ()), new MFServerResultCallback() {
            public void onSuccess(MFResponse mFResponse) {
                MFLogger.d(PresetRemoteDataSource.TAG, "downloadActivePresetList onSuccess");
                if (mFResponse instanceof MFGetActivePresetListResponse) {
                    MFGetActivePresetListResponse mFGetActivePresetListResponse = (MFGetActivePresetListResponse) mFResponse;
                    List activePresetList = mFGetActivePresetListResponse.getActivePresetList();
                    if (activePresetList == null || activePresetList.isEmpty()) {
                        MFLogger.d(PresetRemoteDataSource.TAG, "downloadActivePresetList onFaild");
                        if (getActivePresetListCallback != null) {
                            getActivePresetListCallback.onFail();
                            return;
                        }
                        return;
                    }
                    MFLogger.d(PresetRemoteDataSource.TAG, "downloadActivePresetList onSuccess activePresetListSize=" + activePresetList.size());
                    if (getActivePresetListCallback != null) {
                        getActivePresetListCallback.onSuccess(mFGetActivePresetListResponse.getActivePresetList());
                    }
                }
            }

            public void onFail(int i, MFResponse mFResponse) {
                MFLogger.d(PresetRemoteDataSource.TAG, "downloadActivePresetList onFail");
                if (getActivePresetListCallback != null) {
                    getActivePresetListCallback.onFail();
                }
                cnq.acd().acf().addOrUpdateDataVersioning(new DataVersion("active-presets", 0));
            }
        });
    }

    public void clearData() {
    }

    public void getRecommendedPresets(String str, GetRecommendedPresetListCallback getRecommendedPresetListCallback) {
    }

    private void getRecommendedPresets(String str, int i, int i2, MFServerResultCallback mFServerResultCallback) {
        MFLogger.d(TAG, "getRecommendedPresets deviceSerial=" + str + " offset=" + i + " size=" + i2);
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new csb(PortfolioApp.ZQ(), str, i, i2), mFServerResultCallback);
    }

    public void getDefaultPreset(final String str, final GetRecommendedPresetCallback getRecommendedPresetCallback, boolean z) {
        MFLogger.d(TAG, "getDefaultPreset deviceSerial=" + str);
        final List arrayList = new ArrayList();
        getDefaultPreset(str, 0, 100, new MFServerResultCallback() {
            public void onSuccess(MFResponse mFResponse) {
                MFLogger.d(PresetRemoteDataSource.TAG, "getDefaultPreset deviceSerial=" + str + " onSuccess");
                if (mFResponse instanceof MFGetDefaultPresetResponse) {
                    MFGetDefaultPresetResponse mFGetDefaultPresetResponse = (MFGetDefaultPresetResponse) mFResponse;
                    arrayList.addAll(((MFGetDefaultPresetResponse) mFResponse).getRecommendedPresets());
                    Range range = mFGetDefaultPresetResponse.getRange();
                    if (range != null && range.isHasNext()) {
                        MFLogger.d(PresetRemoteDataSource.TAG, "getDefaultPreset deviceSerial=" + str + " onSuccess hasNext=true");
                        PresetRemoteDataSource.this.getDefaultPreset(str, range.getOffset() + range.getLimit(), range.getLimit(), this);
                    } else if (getRecommendedPresetCallback != null) {
                        MFLogger.d(PresetRemoteDataSource.TAG, "getDefaultPreset deviceSerial=" + str + " onSuccess hasNext=false");
                        if (arrayList.isEmpty()) {
                            getRecommendedPresetCallback.onFail();
                        } else {
                            getRecommendedPresetCallback.onSuccess((RecommendedPreset) arrayList.get(0));
                        }
                    }
                }
            }

            public void onFail(int i, MFResponse mFResponse) {
                MFLogger.d(PresetRemoteDataSource.TAG, "getDefaultPreset deviceSerial=" + str + " onFail");
                if (arrayList.isEmpty()) {
                    MFLogger.d(PresetRemoteDataSource.TAG, "getDefaultPreset deviceSerial=" + str + " onFail mappingSetList is null");
                    if (getRecommendedPresetCallback != null) {
                        getRecommendedPresetCallback.onFail();
                        return;
                    }
                    return;
                }
                MFLogger.d(PresetRemoteDataSource.TAG, "getDefaultPreset deviceSerial=" + str + " onFail mappingSetList not null");
                if (getRecommendedPresetCallback != null) {
                    getRecommendedPresetCallback.onSuccess((RecommendedPreset) arrayList.get(0));
                }
            }
        });
    }

    public void getSavedPreset(String str, GetSavedPresetCallback getSavedPresetCallback) {
    }

    private void getDefaultPreset(String str, int i, int i2, MFServerResultCallback mFServerResultCallback) {
        MFLogger.d(TAG, "getDefaultPreset deviceSerial=" + str + " offset=" + i + " size=" + i2);
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new crz(PortfolioApp.ZQ(), str, i, i2), mFServerResultCallback);
    }
}
