package com.portfolio.platform.data.source;

import com.fossil.cst;
import com.portfolio.platform.data.model.microapp.DeclarationFile;
import com.portfolio.platform.data.model.microapp.MicroApp;
import com.portfolio.platform.data.model.microapp.MicroAppSetting;
import com.portfolio.platform.data.model.microapp.MicroAppVariant;
import java.util.ArrayList;
import java.util.List;

public interface MicroAppSettingDataSource {

    public interface AddOrUpdateDeclarationFileCallback {
        void onFail();

        void onSuccess(DeclarationFile declarationFile);
    }

    public interface AddOrUpdateDeclarationFileListCallback {
        void onFail();

        void onSuccess(List<DeclarationFile> list);
    }

    public interface GetMicroAppCallback {
        void onFail();

        void onSuccess(MicroApp microApp);
    }

    public interface GetMicroAppGalleryCallback {
        void onFail();

        void onSuccess(List<MicroApp> list);
    }

    public interface GetVariantCallback {
        void onFail(int i);

        void onSuccess(MicroAppVariant microAppVariant);
    }

    public interface GetVariantListCallback {
        void onFail(int i);

        void onSuccess(List<MicroAppVariant> list);
    }

    public interface GetVariantListRemoteCallback extends GetVariantListCallback {
        void onSuccess(ArrayList<cst> arrayList);
    }

    public interface MicroAppSettingCallback {
        void onFail();

        void onSuccess(MicroAppSetting microAppSetting);
    }

    public interface MicroAppSettingListCallback {
        void onFail();

        void onSuccess(List<MicroAppSetting> list);
    }

    public interface PushMicroAppSettingToServerCallback {
        void onFail();

        void onSuccess();
    }

    public interface PushPendingMicroAppSettingsCallback {
        void onDone();
    }

    void addOrUpdateDeclarationFile(DeclarationFile declarationFile, AddOrUpdateDeclarationFileCallback addOrUpdateDeclarationFileCallback);

    void addOrUpdateDeclarationFiles(List<DeclarationFile> list, AddOrUpdateDeclarationFileListCallback addOrUpdateDeclarationFileListCallback);

    void addOrUpdateMicroAppSetting(MicroAppSetting microAppSetting, MicroAppSettingCallback microAppSettingCallback);

    void clearData();

    void deleteListMicroApp(String str);

    void downloadMicroAppSettingList(MicroAppSettingListCallback microAppSettingListCallback);

    void fetchAllMicroAppVariants(String str, int i, int i2, GetVariantListCallback getVariantListCallback);

    void getAllMicroAppVariants(String str, int i, int i2, GetVariantListCallback getVariantListCallback);

    void getMicroApp(String str, String str2, GetMicroAppCallback getMicroAppCallback);

    void getMicroAppGallery(String str, GetMicroAppGalleryCallback getMicroAppGalleryCallback);

    void getMicroAppSetting(String str, MicroAppSettingCallback microAppSettingCallback);

    void getMicroAppSettingList(MicroAppSettingListCallback microAppSettingListCallback);

    void getMicroAppVariant(String str, String str2, String str3, int i, int i2, GetVariantCallback getVariantCallback);

    void migrateMicroAppSetting(MicroAppSetting microAppSetting, MicroAppSettingCallback microAppSettingCallback);

    void updateListMicroApp(List<MicroApp> list);

    void updateMicroApp(MicroApp microApp, GetMicroAppCallback getMicroAppCallback);
}
