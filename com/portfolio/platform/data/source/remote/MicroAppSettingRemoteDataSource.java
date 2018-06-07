package com.portfolio.platform.data.source.remote;

import com.fossil.cnq;
import com.fossil.csa;
import com.fossil.csc;
import com.fossil.cse;
import com.fossil.csg;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.DataVersion;
import com.portfolio.platform.data.model.microapp.DeclarationFile;
import com.portfolio.platform.data.model.microapp.MicroApp;
import com.portfolio.platform.data.model.microapp.MicroAppSetting;
import com.portfolio.platform.data.model.microapp.Range;
import com.portfolio.platform.data.source.MicroAppSettingDataSource;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.AddOrUpdateDeclarationFileCallback;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.AddOrUpdateDeclarationFileListCallback;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.GetMicroAppCallback;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.GetMicroAppGalleryCallback;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.GetVariantCallback;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.GetVariantListCallback;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.GetVariantListRemoteCallback;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.MicroAppSettingCallback;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.MicroAppSettingListCallback;
import com.portfolio.platform.response.microapp.MFGetListMicroAppResponse;
import com.portfolio.platform.response.microapp.MFGetSettingListResponse;
import com.portfolio.platform.response.microapp.MFGetVariantsResponse;
import com.portfolio.platform.response.microapp.MFUpsertMicroAppSettingResponse;
import java.util.ArrayList;
import java.util.List;

public class MicroAppSettingRemoteDataSource implements MicroAppSettingDataSource {
    private static final String TAG = MicroAppSettingRemoteDataSource.class.getSimpleName();

    public void clearData() {
    }

    public void getMicroAppGallery(final String str, final GetMicroAppGalleryCallback getMicroAppGalleryCallback) {
        MFLogger.d(TAG, "getMicroAppGallery deviceSerial=" + str);
        final List arrayList = new ArrayList();
        getSupportMicroApp(str, 0, 100, new MFServerResultCallback() {
            public void onSuccess(MFResponse mFResponse) {
                MFLogger.d(MicroAppSettingRemoteDataSource.TAG, "getMicroAppGallery deviceSerial=" + str + " onSuccess");
                if (mFResponse instanceof MFGetListMicroAppResponse) {
                    MFGetListMicroAppResponse mFGetListMicroAppResponse = (MFGetListMicroAppResponse) mFResponse;
                    arrayList.addAll(((MFGetListMicroAppResponse) mFResponse).getMicroAppList());
                    Range range = mFGetListMicroAppResponse.getRange();
                    if (range != null && range.isHasNext()) {
                        MFLogger.d(MicroAppSettingRemoteDataSource.TAG, "getMicroAppGallery deviceSerial=" + str + " onSuccess hasNext=true");
                        MicroAppSettingRemoteDataSource.this.getSupportMicroApp(str, range.getOffset() + range.getLimit(), range.getLimit(), this);
                    } else if (getMicroAppGalleryCallback != null) {
                        MFLogger.d(MicroAppSettingRemoteDataSource.TAG, "getMicroAppGallery deviceSerial=" + str + " onSuccess hasNext=false");
                        if (arrayList.isEmpty()) {
                            getMicroAppGalleryCallback.onFail();
                        } else {
                            getMicroAppGalleryCallback.onSuccess(arrayList);
                        }
                    }
                }
            }

            public void onFail(int i, MFResponse mFResponse) {
                MFLogger.d(MicroAppSettingRemoteDataSource.TAG, "getMicroAppGallery deviceSerial=" + str + " onFail");
                if (arrayList.isEmpty()) {
                    MFLogger.d(MicroAppSettingRemoteDataSource.TAG, "getMicroAppGallery deviceSerial=" + str + " onFail microAppList is null");
                    if (getMicroAppGalleryCallback != null) {
                        getMicroAppGalleryCallback.onFail();
                    }
                } else {
                    MFLogger.d(MicroAppSettingRemoteDataSource.TAG, "getMicroAppGallery deviceSerial=" + str + " onFail microAppList not null");
                    if (getMicroAppGalleryCallback != null) {
                        getMicroAppGalleryCallback.onSuccess(arrayList);
                    }
                }
                cnq.acd().acf().addOrUpdateDataVersioning(new DataVersion("micro-apps", 0));
            }
        });
    }

    public void updateMicroApp(MicroApp microApp, GetMicroAppCallback getMicroAppCallback) {
    }

    public void getMicroApp(String str, String str2, GetMicroAppCallback getMicroAppCallback) {
    }

    public void updateListMicroApp(List<MicroApp> list) {
    }

    private void getSupportMicroApp(String str, int i, int i2, MFServerResultCallback mFServerResultCallback) {
        MFLogger.d(TAG, "getMicroAppGallery deviceSerial=" + str + " offset=" + i + " size=" + i2);
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new csa(PortfolioApp.ZQ(), i, i2, str), mFServerResultCallback);
    }

    public void getAllMicroAppVariants(String str, int i, int i2, GetVariantListCallback getVariantListCallback) {
        MFLogger.d(TAG, "getAllMicroAppVariants serialNumber=" + str);
        final ArrayList arrayList = new ArrayList();
        final String str2 = str;
        final int i3 = i;
        final int i4 = i2;
        final GetVariantListCallback getVariantListCallback2 = getVariantListCallback;
        C48672 c48672 = new MFServerResultCallback() {
            public void onSuccess(MFResponse mFResponse) {
                MFLogger.d(MicroAppSettingRemoteDataSource.TAG, "getAllMicroAppVariants deviceSerial=" + str2 + " onSuccess");
                if (mFResponse instanceof MFGetVariantsResponse) {
                    MFGetVariantsResponse mFGetVariantsResponse = (MFGetVariantsResponse) mFResponse;
                    arrayList.addAll(mFGetVariantsResponse.getMicroAppVariations());
                    Range range = mFGetVariantsResponse.getRange();
                    if (range != null && range.isHasNext()) {
                        MFLogger.d(MicroAppSettingRemoteDataSource.TAG, "getAllMicroAppVariants deviceSerial=" + str2 + " onSuccess hasNext=true");
                        MicroAppSettingRemoteDataSource.this.getAllMicroAppVariants(str2, "", i3, i4, range.getOffset() + range.getLimit(), range.getLimit(), this);
                    } else if (getVariantListCallback2 != null) {
                        MFLogger.d(MicroAppSettingRemoteDataSource.TAG, "getAllMicroAppVariants deviceSerial=" + str2 + " onSuccess hasNext=false");
                        if (arrayList.isEmpty()) {
                            getVariantListCallback2.onFail(404);
                        } else {
                            ((GetVariantListRemoteCallback) getVariantListCallback2).onSuccess(arrayList);
                        }
                    }
                }
            }

            public void onFail(int i, MFResponse mFResponse) {
                MFLogger.d(MicroAppSettingRemoteDataSource.TAG, "getAllMicroAppVariants deviceSerial=" + str2 + " onFail");
                if (arrayList.isEmpty()) {
                    MFLogger.d(MicroAppSettingRemoteDataSource.TAG, "getAllMicroAppVariants deviceSerial=" + str2 + " onFail microAppVariants is null");
                    if (getVariantListCallback2 != null) {
                        getVariantListCallback2.onFail(i);
                    }
                } else {
                    MFLogger.d(MicroAppSettingRemoteDataSource.TAG, "getAllMicroAppVariants deviceSerial=" + str2 + " onFail microAppVariants not null");
                    if (getVariantListCallback2 != null) {
                        ((GetVariantListRemoteCallback) getVariantListCallback2).onSuccess(arrayList);
                    }
                }
                cnq.acd().acf().addOrUpdateDataVersioning(new DataVersion("micro-app-variants", 0));
            }
        };
        getAllMicroAppVariants(str, "", i, i2, 0, 100, c48672);
    }

    public void getMicroAppVariant(String str, String str2, String str3, int i, int i2, GetVariantCallback getVariantCallback) {
    }

    public void getMicroAppVariant(String str, String str2, int i, int i2, GetVariantListCallback getVariantListCallback) {
        MFLogger.d(TAG, "getMicroAppVariant serialNumber=" + str + " microAppId=" + str2);
        final ArrayList arrayList = new ArrayList();
        final String str3 = str;
        final String str4 = str2;
        final int i3 = i;
        final int i4 = i2;
        final GetVariantListCallback getVariantListCallback2 = getVariantListCallback;
        getAllMicroAppVariants(str, str2, i, i2, 0, 100, new MFServerResultCallback() {
            public void onSuccess(MFResponse mFResponse) {
                MFLogger.d(MicroAppSettingRemoteDataSource.TAG, "getAllMicroAppVariants deviceSerial=" + str3 + " onSuccess");
                if (mFResponse instanceof MFGetVariantsResponse) {
                    MFGetVariantsResponse mFGetVariantsResponse = (MFGetVariantsResponse) mFResponse;
                    arrayList.addAll(mFGetVariantsResponse.getMicroAppVariations());
                    Range range = mFGetVariantsResponse.getRange();
                    if (range != null && range.isHasNext()) {
                        MFLogger.d(MicroAppSettingRemoteDataSource.TAG, "getAllMicroAppVariants deviceSerial=" + str3 + " onSuccess hasNext=true");
                        MicroAppSettingRemoteDataSource.this.getAllMicroAppVariants(str3, str4, i3, i4, range.getOffset() + range.getLimit(), range.getLimit(), this);
                    } else if (arrayList.isEmpty()) {
                        getVariantListCallback2.onFail(404);
                    } else {
                        MFLogger.d(MicroAppSettingRemoteDataSource.TAG, "getAllMicroAppVariants deviceSerial=" + str3 + " onSuccess hasNext=false");
                        ((GetVariantListRemoteCallback) getVariantListCallback2).onSuccess(arrayList);
                    }
                }
            }

            public void onFail(int i, MFResponse mFResponse) {
                MFLogger.d(MicroAppSettingRemoteDataSource.TAG, "getAllMicroAppVariants deviceSerial=" + str3 + " onFail");
                if (arrayList.isEmpty()) {
                    MFLogger.d(MicroAppSettingRemoteDataSource.TAG, "getAllMicroAppVariants deviceSerial=" + str3 + " onFail microAppVariants is null");
                    getVariantListCallback2.onFail(i);
                    return;
                }
                MFLogger.d(MicroAppSettingRemoteDataSource.TAG, "getAllMicroAppVariants deviceSerial=" + str3 + " onFail microAppVariants not null");
                ((GetVariantListRemoteCallback) getVariantListCallback2).onSuccess(arrayList);
            }
        });
    }

    private void getAllMicroAppVariants(String str, String str2, int i, int i2, int i3, int i4, MFServerResultCallback mFServerResultCallback) {
        MFLogger.d(TAG, "getAllMicroAppVariants deviceSerial=" + str + " microAppId=" + str2 + " majorNumber=" + i + " minorNumber=" + i2);
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cse(PortfolioApp.ZQ(), str, str2, i, i2, i3, i4), mFServerResultCallback);
    }

    public void addOrUpdateMicroAppSetting(final MicroAppSetting microAppSetting, final MicroAppSettingCallback microAppSettingCallback) {
        MFLogger.d(TAG, "addOrUpdateMicroAppSetting microAppSetting=" + microAppSetting.getSetting() + " microAppId=" + microAppSetting.getMicroAppId());
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new csg(PortfolioApp.ZQ(), microAppSetting), new MFServerResultCallback() {
            public void onSuccess(MFResponse mFResponse) {
                MFLogger.d(MicroAppSettingRemoteDataSource.TAG, "addOrUpdateMicroAppSetting onSuccess microAppSetting=" + microAppSetting.getSetting() + " microAppId=" + microAppSetting.getMicroAppId());
                if (mFResponse instanceof MFUpsertMicroAppSettingResponse) {
                    microAppSettingCallback.onSuccess((MicroAppSetting) ((MFUpsertMicroAppSettingResponse) mFResponse).getMicroAppSettingList().get(0));
                }
            }

            public void onFail(int i, MFResponse mFResponse) {
                MFLogger.d(MicroAppSettingRemoteDataSource.TAG, "addOrUpdateMicroAppSetting onSuccess microAppSetting=" + microAppSetting.getSetting() + " microAppId=" + microAppSetting.getMicroAppId());
                microAppSettingCallback.onFail();
            }
        });
    }

    public void getMicroAppSettingList(final MicroAppSettingListCallback microAppSettingListCallback) {
        MFLogger.d(TAG, "getMicroAppSettingList");
        final List arrayList = new ArrayList();
        getMicroAppSettingList(0, 100, new MFServerResultCallback() {
            public void onSuccess(MFResponse mFResponse) {
                MFLogger.d(MicroAppSettingRemoteDataSource.TAG, "getMicroAppSettingList onSuccess");
                if (mFResponse instanceof MFGetSettingListResponse) {
                    MFGetSettingListResponse mFGetSettingListResponse = (MFGetSettingListResponse) mFResponse;
                    arrayList.addAll(mFGetSettingListResponse.getMicroAppSettingList());
                    Range range = mFGetSettingListResponse.getRange();
                    if (range != null && range.isHasNext()) {
                        MFLogger.d(MicroAppSettingRemoteDataSource.TAG, "getMicroAppSettingList onSuccess hasNext=true");
                        MicroAppSettingRemoteDataSource.this.getMicroAppSettingList((range.getOffset() + range.getLimit()) + 1, range.getLimit(), this);
                    } else if (microAppSettingListCallback != null) {
                        MFLogger.d(MicroAppSettingRemoteDataSource.TAG, "getMicroAppSettingList onSuccess hasNext=false");
                        if (arrayList.isEmpty()) {
                            microAppSettingListCallback.onFail();
                        } else {
                            microAppSettingListCallback.onSuccess(arrayList);
                        }
                    }
                }
            }

            public void onFail(int i, MFResponse mFResponse) {
                MFLogger.d(MicroAppSettingRemoteDataSource.TAG, "getMicroAppSettingList onFail");
                if (arrayList.isEmpty()) {
                    MFLogger.d(MicroAppSettingRemoteDataSource.TAG, "getMicroAppSettingList onFail presetList is null");
                    if (microAppSettingListCallback != null) {
                        microAppSettingListCallback.onFail();
                    }
                } else {
                    MFLogger.d(MicroAppSettingRemoteDataSource.TAG, "getMicroAppSettingList onFail presetList not null");
                    if (microAppSettingListCallback != null) {
                        microAppSettingListCallback.onSuccess(arrayList);
                    }
                }
                cnq.acd().acf().addOrUpdateDataVersioning(new DataVersion("micro-app-settings", 0));
            }
        });
    }

    public void getMicroAppSetting(String str, MicroAppSettingCallback microAppSettingCallback) {
    }

    public void addOrUpdateDeclarationFile(DeclarationFile declarationFile, AddOrUpdateDeclarationFileCallback addOrUpdateDeclarationFileCallback) {
    }

    public void addOrUpdateDeclarationFiles(List<DeclarationFile> list, AddOrUpdateDeclarationFileListCallback addOrUpdateDeclarationFileListCallback) {
    }

    public void fetchAllMicroAppVariants(String str, int i, int i2, GetVariantListCallback getVariantListCallback) {
        getAllMicroAppVariants(str, i, i2, getVariantListCallback);
    }

    public void downloadMicroAppSettingList(MicroAppSettingListCallback microAppSettingListCallback) {
    }

    public void migrateMicroAppSetting(MicroAppSetting microAppSetting, MicroAppSettingCallback microAppSettingCallback) {
    }

    public void deleteListMicroApp(String str) {
    }

    private void getMicroAppSettingList(int i, int i2, MFServerResultCallback mFServerResultCallback) {
        MFLogger.d(TAG, "getMicroAppSettingList offset=" + i + " size=" + i2);
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new csc(PortfolioApp.ZQ(), i, i2), mFServerResultCallback);
    }
}
