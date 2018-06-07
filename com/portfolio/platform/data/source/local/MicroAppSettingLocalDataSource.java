package com.portfolio.platform.data.source.local;

import android.text.TextUtils;
import com.fossil.cnq;
import com.fossil.cok;
import com.fossil.cpb;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.microapp.DeclarationFile;
import com.portfolio.platform.data.model.microapp.MicroApp;
import com.portfolio.platform.data.model.microapp.MicroAppSetting;
import com.portfolio.platform.data.model.microapp.MicroAppVariant;
import com.portfolio.platform.data.source.MicroAppSettingDataSource;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.AddOrUpdateDeclarationFileCallback;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.AddOrUpdateDeclarationFileListCallback;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.GetMicroAppCallback;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.GetMicroAppGalleryCallback;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.GetVariantCallback;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.GetVariantListCallback;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.MicroAppSettingCallback;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.MicroAppSettingListCallback;
import java.util.List;

public class MicroAppSettingLocalDataSource implements MicroAppSettingDataSource {
    private static final String TAG = MicroAppSettingLocalDataSource.class.getSimpleName();

    public void clearData() {
        cnq.acd().acv().aeH();
    }

    public void getMicroAppGallery(String str, GetMicroAppGalleryCallback getMicroAppGalleryCallback) {
        MFLogger.d(TAG, "getMicroAppGallery deviceSerial=" + str);
        if (TextUtils.isEmpty(str)) {
            MFLogger.d(TAG, "getMicroAppGallery deviceSerial=empty");
            getMicroAppGalleryCallback.onFail();
            return;
        }
        List hm = cnq.acd().acp().hm(str);
        if (hm == null || hm.isEmpty()) {
            MFLogger.d(TAG, "getMicroAppGallery onFail");
            getMicroAppGalleryCallback.onFail();
            return;
        }
        MFLogger.d(TAG, "getMicroAppGallery onSuccess");
        getMicroAppGalleryCallback.onSuccess(hm);
    }

    public void updateMicroApp(MicroApp microApp, GetMicroAppCallback getMicroAppCallback) {
        MFLogger.d(TAG, "updateMicroApp");
        if (cnq.acd().acp().b(microApp)) {
            getMicroAppCallback.onSuccess(microApp);
        } else {
            getMicroAppCallback.onFail();
        }
    }

    public void getMicroApp(String str, String str2, GetMicroAppCallback getMicroAppCallback) {
        MFLogger.d(TAG, "getMicroApp deviceSerial=" + str + " microAppId=" + str2);
        if (TextUtils.isEmpty(str)) {
            MFLogger.d(TAG, "getMicroApp deviceSerial=empty");
            getMicroAppCallback.onFail();
            return;
        }
        MicroApp ax = cnq.acd().acp().ax(str, str2);
        if (ax != null) {
            MFLogger.d(TAG, "getMicroApp onSuccess");
            getMicroAppCallback.onSuccess(ax);
            return;
        }
        MFLogger.d(TAG, "getMicroApp onFail");
        getMicroAppCallback.onFail();
    }

    public void updateListMicroApp(List<MicroApp> list) {
        if (list != null && !list.isEmpty()) {
            MFLogger.d(TAG, "updateListMicroApp microAppListSize=" + list.size());
            cnq.acd().acp().updateListMicroApp(list);
        }
    }

    public void getAllMicroAppVariants(String str, int i, int i2, GetVariantListCallback getVariantListCallback) {
        MFLogger.d(TAG, "getAllMicroAppVariants serial=" + str + " major=" + i + " minor=" + i2);
        List D = cnq.acd().acp().D(str, i);
        if (D == null || D.isEmpty()) {
            MFLogger.d(TAG, "getAllMicroAppVariants onFail serial=" + str);
            getVariantListCallback.onFail(601);
            return;
        }
        MFLogger.d(TAG, "getAllMicroAppVariants onSuccess serial=" + str);
        getVariantListCallback.onSuccess(D);
    }

    public void getMicroAppVariant(String str, String str2, String str3, int i, int i2, GetVariantCallback getVariantCallback) {
        MFLogger.d(TAG, "getMicroAppVariant serial=" + str + " microAppId=" + str2 + " major=" + i + " minor=" + i2);
        MicroAppVariant a = cnq.acd().acp().a(str2, str, i, str3);
        if (a != null) {
            MFLogger.d(TAG, "getMicroAppVariant onSuccess serial=" + str + " microAppId=" + str2);
            getVariantCallback.onSuccess(a);
            return;
        }
        MFLogger.d(TAG, "getMicroAppVariant onFail serial=" + str + " microAppId=" + str2);
        getVariantCallback.onFail(601);
    }

    public boolean addOrUpDateVariant(MicroAppVariant microAppVariant) {
        MFLogger.d(TAG, ".addOrUpDateVariant - serial=" + microAppVariant.getSerialNumbers() + ", major=" + microAppVariant.getMajorNumber() + " minor=" + microAppVariant.getMinorNumber());
        return cnq.acd().acp().a(microAppVariant);
    }

    public void addOrUpdateMicroAppSetting(MicroAppSetting microAppSetting, MicroAppSettingCallback microAppSettingCallback) {
        MFLogger.d(TAG, "addOrUpdateMicroAppSetting microAppSetting=" + microAppSetting.getSetting() + "microAppId=" + microAppSetting.getMicroAppId());
        cpb acv = cnq.acd().acv();
        MicroAppSetting hs = acv.hs(microAppSetting.getMicroAppId());
        if (hs != null && hs.getFirstUsed() > 0) {
            microAppSetting.setFirstUsed(hs.getFirstUsed());
        }
        microAppSetting.setUpdatedAt(System.currentTimeMillis());
        if (acv.b(microAppSetting)) {
            MFLogger.d(TAG, "addOrUpdateMicroAppSetting onSuccess microAppSetting=" + microAppSetting.getSetting());
            microAppSettingCallback.onSuccess(microAppSetting);
            return;
        }
        MFLogger.d(TAG, "addOrUpdateMicroAppSetting onFail microAppSetting=" + microAppSetting.getSetting());
        microAppSettingCallback.onFail();
    }

    public void migrateMicroAppSetting(MicroAppSetting microAppSetting, MicroAppSettingCallback microAppSettingCallback) {
        MFLogger.d(TAG, "migrateMicroAppSetting microAppSetting=" + microAppSetting.getSetting());
        cpb acv = cnq.acd().acv();
        MicroAppSetting hs = acv.hs(microAppSetting.getMicroAppId());
        if (hs != null) {
            if (hs.getUpdatedAt() > microAppSetting.getUpdatedAt()) {
                microAppSetting.setCreatedAt(hs.getCreatedAt());
                microAppSetting.setSetting(hs.getSetting());
                microAppSetting.setLike(hs.isLike());
            }
            if (hs.getFirstUsed() > 0) {
                microAppSetting.setFirstUsed(hs.getFirstUsed());
            }
        }
        microAppSetting.setUpdatedAt(System.currentTimeMillis());
        if (acv.b(microAppSetting)) {
            MFLogger.d(TAG, "migrateMicroAppSetting onSuccess microAppSetting=" + microAppSetting.getSetting());
            microAppSettingCallback.onSuccess(microAppSetting);
            return;
        }
        MFLogger.d(TAG, "migrateMicroAppSetting onFail microAppSetting=" + microAppSetting.getSetting());
        microAppSettingCallback.onFail();
    }

    public void deleteListMicroApp(String str) {
        MFLogger.d(TAG, "deleteListMicroApp serial=" + str);
        cnq.acd().acp().hn(str);
    }

    public void updateMicroAppSettingPinType(String str, int i) {
        cnq.acd().acv().updateMicroAppSettingPinType(str, i);
    }

    public List<MicroAppSetting> getPendingMicroAppSettings() {
        return cnq.acd().acv().getPendingMicroAppSettings();
    }

    public void getMicroAppSetting(String str, MicroAppSettingCallback microAppSettingCallback) {
        MFLogger.d(TAG, "getMicroAppSetting getMicroAppId=" + str);
        if (TextUtils.isEmpty(str)) {
            MFLogger.d(TAG, "getMicroAppSetting onFail getMicroAppId=" + str);
            microAppSettingCallback.onFail();
            return;
        }
        MicroAppSetting hs = cnq.acd().acv().hs(str);
        if (hs != null) {
            MFLogger.d(TAG, "getMicroAppSetting onSuccess getMicroAppId=" + str);
            microAppSettingCallback.onSuccess(hs);
            return;
        }
        MFLogger.d(TAG, "getMicroAppSetting onFail getMicroAppId=" + str);
        microAppSettingCallback.onFail();
    }

    public void addOrUpdateDeclarationFile(DeclarationFile declarationFile, AddOrUpdateDeclarationFileCallback addOrUpdateDeclarationFileCallback) {
        MFLogger.d(TAG, "addOrUpdateDeclarationFile declarationFileId=" + declarationFile.getFileId());
        if (cnq.acd().acp().a(declarationFile)) {
            MFLogger.d(TAG, "addOrUpdateMicroAppSetting onSuccess fileId=" + declarationFile.getFileId());
            addOrUpdateDeclarationFileCallback.onSuccess(declarationFile);
            return;
        }
        MFLogger.d(TAG, "addOrUpdateMicroAppSetting onFail fildId=" + declarationFile.getFileId());
        addOrUpdateDeclarationFileCallback.onFail();
    }

    public void addOrUpdateDeclarationFiles(List<DeclarationFile> list, AddOrUpdateDeclarationFileListCallback addOrUpdateDeclarationFileListCallback) {
        MFLogger.d(TAG, "addOrUpdateDeclarationFiles declarationFileSize=" + list.size());
        cok acp = cnq.acd().acp();
        for (int i = 0; i < list.size(); i++) {
            acp.a((DeclarationFile) list.get(i));
        }
        MFLogger.d(TAG, "addOrUpdateDeclarationFiles onSuccess declarationFileSize=" + list.size());
        addOrUpdateDeclarationFileListCallback.onSuccess(list);
    }

    public void fetchAllMicroAppVariants(String str, int i, int i2, GetVariantListCallback getVariantListCallback) {
    }

    public void downloadMicroAppSettingList(MicroAppSettingListCallback microAppSettingListCallback) {
    }

    public void getMicroAppSettingList(MicroAppSettingListCallback microAppSettingListCallback) {
        MFLogger.d(TAG, "getMicroAppSettingList");
        List aeG = cnq.acd().acv().aeG();
        if (aeG == null || aeG.isEmpty()) {
            MFLogger.d(TAG, "getMicroAppSettingList onFail");
            microAppSettingListCallback.onFail();
            return;
        }
        MFLogger.d(TAG, "getMicroAppSettingList onSuccess microAppSettingListSize=" + aeG.size());
        microAppSettingListCallback.onSuccess(aeG);
    }
}
