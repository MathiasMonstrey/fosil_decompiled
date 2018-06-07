package com.fossil;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.fossil.wearables.fsl.shared.BaseDbProvider;
import com.fossil.wearables.fsl.shared.UpgradeCommand;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.table.TableUtils;
import com.misfit.frameworks.buttonservice.enums.MFDeviceFamily;
import com.misfit.frameworks.buttonservice.model.MisfitDeviceProfile;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.DeviceModel;
import com.portfolio.platform.data.model.SKUModel;
import com.portfolio.platform.data.model.microapp.ActivePreset;
import com.portfolio.platform.data.model.microapp.DeclarationFile;
import com.portfolio.platform.data.model.microapp.MappingSet;
import com.portfolio.platform.data.model.microapp.MicroApp;
import com.portfolio.platform.data.model.microapp.MicroAppVariant;
import com.portfolio.platform.data.model.microapp.RecommendedPreset;
import com.portfolio.platform.data.model.microapp.SavedPreset;
import com.portfolio.platform.data.model.microapp.SavedPreset.MappingSetType;
import com.portfolio.platform.helper.DeviceHelper;
import com.portfolio.platform.model.UAppSystemVersionModel;
import com.portfolio.platform.provider.DeviceProviderImp.1;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class col extends BaseDbProvider implements cok {
    private static final String TAG = col.class.getSimpleName();

    public col(Context context, String str) {
        super(context, str);
    }

    protected int getDbVersion() {
        return 11;
    }

    protected Class<?>[] getDbEntities() {
        return new Class[]{DeviceModel.class, SavedPreset.class, RecommendedPreset.class, SKUModel.class, MicroApp.class, UAppSystemVersionModel.class, MicroAppVariant.class, DeclarationFile.class, ActivePreset.class, MappingSet.class};
    }

    private Dao<DeviceModel, Integer> aef() throws SQLException {
        return this.databaseHelper.getDao(DeviceModel.class);
    }

    private Dao<SavedPreset, Integer> aeg() throws SQLException {
        return this.databaseHelper.getDao(SavedPreset.class);
    }

    private Dao<ActivePreset, Integer> aeh() throws SQLException {
        return this.databaseHelper.getDao(ActivePreset.class);
    }

    private Dao<RecommendedPreset, Integer> aei() throws SQLException {
        return this.databaseHelper.getDao(RecommendedPreset.class);
    }

    private Dao<SKUModel, Integer> aej() throws SQLException {
        return this.databaseHelper.getDao(SKUModel.class);
    }

    private Dao<MicroApp, Integer> aek() throws SQLException {
        return this.databaseHelper.getDao(MicroApp.class);
    }

    private Dao<MicroAppVariant, Integer> ael() throws SQLException {
        return this.databaseHelper.getDao(MicroAppVariant.class);
    }

    private Dao<DeclarationFile, Integer> aem() throws SQLException {
        return this.databaseHelper.getDao(DeclarationFile.class);
    }

    private Dao<UAppSystemVersionModel, Integer> aen() throws SQLException {
        return this.databaseHelper.getDao(UAppSystemVersionModel.class);
    }

    private Dao<MappingSet, Integer> aeo() throws SQLException {
        return this.databaseHelper.getDao(MappingSet.class);
    }

    protected Map<Integer, UpgradeCommand> getDbUpgrades() {
        return new 1(this);
    }

    public void mo1944a(DeviceModel deviceModel) {
        if (deviceModel != null) {
            try {
                Object macAddress = deviceModel.getMacAddress();
                if (TextUtils.isEmpty(deviceModel.getMacAddress())) {
                    MisfitDeviceProfile gb = DeviceHelper.abH().gb(deviceModel.getDeviceId());
                    if (gb != null) {
                        macAddress = gb.getAddress();
                    }
                }
                MFLogger.m12670d(TAG, "---Inside .addOrUpdateDevice deviceId: " + deviceModel.getDeviceId() + ", macAddress=" + deviceModel.getMacAddress() + " fwVersion: " + deviceModel.getFirmwareRevision() + " batLevel: " + deviceModel.getBatteryLevel());
                DeviceModel hd = hd(deviceModel.getDeviceId());
                if (hd != null && TextUtils.isEmpty(deviceModel.getFirmwareRevision())) {
                    deviceModel.setFirmwareRevision(hd.getFirmwareRevision());
                }
                if (hd == null || deviceModel.getBatteryLevel() > 0) {
                    deviceModel.setCreatedAt(String.valueOf(cmq.m7131i(new Date())));
                } else {
                    deviceModel.setBatteryLevel(hd.getBatteryLevel());
                }
                if (deviceModel.getBatteryLevel() > 100) {
                    deviceModel.setBatteryLevel(100);
                }
                if (!TextUtils.isEmpty(macAddress)) {
                    deviceModel.setMacAddress(macAddress);
                }
                deviceModel.setUpdateAt(String.valueOf(cmq.m7131i(new Date())));
                aef().createOrUpdate(deviceModel);
                return;
            } catch (Exception e) {
                MFLogger.m12671e(TAG, "Error inside " + TAG + ".addDevice - e=" + e);
                return;
            }
        }
        MFLogger.m12671e(TAG, "Can't add or update null device");
    }

    public DeviceModel hd(String str) {
        if (TextUtils.isEmpty(str)) {
            MFLogger.m12671e(TAG, "Error when get device, deviceId " + str);
        }
        try {
            MFLogger.m12670d(TAG, "---Inside .getDeviceById deviceId: " + str);
            QueryBuilder queryBuilder = aef().queryBuilder();
            queryBuilder.where().eq("deviceId", str);
            return (DeviceModel) queryBuilder.queryForFirst();
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".getDeviceById - e=" + e);
            return null;
        }
    }

    public void he(String str) {
        if (TextUtils.isEmpty(str)) {
            MFLogger.m12671e(TAG, "Error when deleteAlarm device, deviceId " + str);
        }
        try {
            MFLogger.m12670d(TAG, "---Inside .removeDevice deviceId: " + str);
            DeleteBuilder deleteBuilder = aef().deleteBuilder();
            deleteBuilder.where().eq("deviceId", str);
            deleteBuilder.delete();
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".removeDevice - e=" + e);
        }
    }

    public List<DeviceModel> adS() {
        List<DeviceModel> arrayList = new ArrayList();
        try {
            arrayList = aef().query(aef().queryBuilder().prepare());
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Error when get all device " + e);
        }
        return arrayList;
    }

    public void mo1938C(String str, int i) {
        DeviceModel hd = hd(str);
        if (hd != null && i > 0) {
            hd.setBatteryLevel(i);
            mo1944a(hd);
        }
    }

    public boolean mo1965b(SavedPreset savedPreset) {
        if (savedPreset == null) {
            return false;
        }
        MFLogger.m12670d(TAG, ".addOrUpdateSavedPreset, presetId=" + savedPreset.getId());
        try {
            savedPreset.setUpdateAt(System.currentTimeMillis());
            aeg().createOrUpdate(savedPreset);
            return true;
        } catch (Exception e) {
            MFLogger.m12671e(TAG, ".addOrUpdateSavedPreset - e=" + e.toString());
            return false;
        }
    }

    public boolean mo1945a(ActivePreset activePreset) {
        if (activePreset == null) {
            return false;
        }
        MFLogger.m12670d(TAG, ".addOrUpdateSavedPreset, serialNumber=" + activePreset.getSerialNumber());
        try {
            activePreset.setUpdateAt(System.currentTimeMillis());
            aeh().createOrUpdate(activePreset);
            return true;
        } catch (Exception e) {
            MFLogger.m12671e(TAG, ".addOrUpdateSavedPreset - e=" + e.toString());
            return false;
        }
    }

    public boolean mo1964b(RecommendedPreset recommendedPreset) {
        if (recommendedPreset == null) {
            return false;
        }
        MFLogger.m12670d(TAG, ".addOrUpdateRecommendedPreset - mappingSetId=" + recommendedPreset.getId() + ", deviceFamily=" + recommendedPreset.getSerialNumber() + ", id=" + recommendedPreset.getId());
        try {
            recommendedPreset.setUpdateAt(System.currentTimeMillis());
            aei().createOrUpdate(recommendedPreset);
            return true;
        } catch (Exception e) {
            MFLogger.m12671e(TAG, ".addOrUpdateSavedPreset - e=" + e.toString());
            return false;
        }
    }

    public List<SavedPreset> adT() {
        MFLogger.m12670d(TAG, ".getAllUserPresets");
        try {
            Dao aeg = aeg();
            QueryBuilder queryBuilder = aeg.queryBuilder();
            queryBuilder.where().ne("pinType", Integer.valueOf(3));
            return aeg.query(queryBuilder.prepare());
        } catch (Exception e) {
            MFLogger.m12671e(TAG, ".getAllUserPresets - ex=" + e.toString());
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public boolean hg(String str) {
        MFLogger.m12670d(TAG, ".deleteSavedPreset - savedPresetId=" + str);
        try {
            DeleteBuilder deleteBuilder = aeg().deleteBuilder();
            deleteBuilder.where().eq("id", str);
            deleteBuilder.delete();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean hh(String str) {
        MFLogger.m12670d(TAG, ".deleteRecommendedPreset - serial=" + str);
        try {
            DeleteBuilder deleteBuilder = aei().deleteBuilder();
            deleteBuilder.where().eq("serialNumber", str);
            deleteBuilder.delete();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public SavedPreset hi(String str) {
        MFLogger.m12670d(TAG, ".getSavedPresetById - mappingSetId=" + str);
        try {
            QueryBuilder queryBuilder = aeg().queryBuilder();
            queryBuilder.where().eq("id", str);
            return (SavedPreset) queryBuilder.queryForFirst();
        } catch (Exception e) {
            MFLogger.m12671e(TAG, ".getSavedPresetById - ex=" + e.toString());
            return null;
        }
    }

    public ActivePreset hj(String str) {
        MFLogger.m12671e(TAG, ".getActiveUserPreset deviceSerial=" + str);
        try {
            QueryBuilder queryBuilder = aeh().queryBuilder();
            queryBuilder.where().eq("serialNumber", str);
            return (ActivePreset) queryBuilder.queryForFirst();
        } catch (Exception e) {
            MFLogger.m12671e(TAG, ".getActiveUserPreset - ex=" + e);
            return null;
        }
    }

    public List<ActivePreset> adU() {
        MFLogger.m12670d(TAG, ".getPendingActivePresets, get all of pending activePreset");
        try {
            QueryBuilder queryBuilder = aeh().queryBuilder();
            queryBuilder.where().ne("pinType", Integer.valueOf(0));
            List<ActivePreset> query = queryBuilder.query();
            if (query != null) {
                return query;
            }
            return new ArrayList();
        } catch (Exception e) {
            MFLogger.m12671e(TAG, ".getActiveUserPreset - ex=" + e);
            return new ArrayList();
        }
    }

    public List<SavedPreset> adV() {
        MFLogger.m12670d(TAG, ".getPendingSavedPresets, get all of pending savedPreset");
        try {
            QueryBuilder queryBuilder = aeg().queryBuilder();
            queryBuilder.where().ne("pinType", Integer.valueOf(0));
            List<SavedPreset> query = queryBuilder.query();
            if (query != null) {
                return query;
            }
            return new ArrayList();
        } catch (Exception e) {
            MFLogger.m12671e(TAG, ".getActiveUserPreset - ex=" + e);
            return new ArrayList();
        }
    }

    public boolean adY() {
        MFLogger.m12671e(TAG, "clearSavedPreset");
        try {
            TableUtils.clearTable(aeg().getConnectionSource(), SavedPreset.class);
            return true;
        } catch (Exception e) {
            MFLogger.m12671e(TAG, ".clearSavedPreset - ex=" + e);
            return false;
        }
    }

    public boolean aea() {
        MFLogger.m12671e(TAG, "clearActivePreset");
        try {
            TableUtils.clearTable(aeh().getConnectionSource(), ActivePreset.class);
            return true;
        } catch (Exception e) {
            MFLogger.m12671e(TAG, ".clearActivePreset - ex=" + e);
            return false;
        }
    }

    public boolean adZ() {
        MFLogger.m12671e(TAG, "clearRecommendedPreset");
        try {
            TableUtils.clearTable(aei().getConnectionSource(), RecommendedPreset.class);
            return true;
        } catch (Exception e) {
            MFLogger.m12671e(TAG, ".clearRecommendedPreset - ex=" + e);
            return false;
        }
    }

    public boolean aeb() {
        Log.e(TAG, "getAllMicroAppSettingList");
        try {
            TableUtils.clearTable(aek().getConnectionSource(), MicroApp.class);
            return true;
        } catch (Exception e) {
            Log.e(TAG, "getAllMicroAppSettingList Exception=" + e);
            return false;
        }
    }

    public List<RecommendedPreset> hf(String str) {
        MFLogger.m12671e(TAG, ".getListFeatureMappingSetByDeviceFamily - serial=" + str);
        try {
            QueryBuilder queryBuilder = aei().queryBuilder();
            queryBuilder.where().eq("type", MappingSetType.RECOMMENDED.getValue()).and().eq("serialNumber", str);
            return queryBuilder.query();
        } catch (Exception e) {
            MFLogger.m12671e(TAG, ".getListFeatureMappingSetByDeviceFamily - ex=" + e.toString());
            return new ArrayList();
        }
    }

    public RecommendedPreset hk(String str) {
        MFLogger.m12671e(TAG, ".getDefaultPreset - serial=" + str);
        try {
            QueryBuilder queryBuilder = aei().queryBuilder();
            queryBuilder.where().eq("type", MappingSetType.DEFAULT.getValue()).and().eq("serialNumber", str);
            return (RecommendedPreset) queryBuilder.queryForFirst();
        } catch (Exception e) {
            MFLogger.m12671e(TAG, ".getDefaultPreset - ex=" + e.toString());
            return null;
        }
    }

    public List<MicroApp> hm(String str) {
        MFLogger.m12671e(TAG, ".getListMicroApp - serial=" + str);
        try {
            QueryBuilder queryBuilder = aek().queryBuilder();
            queryBuilder.where().eq(MicroApp.COLUMN_PLATFORM, str);
            return queryBuilder.query();
        } catch (Exception e) {
            MFLogger.m12671e(TAG, ".getListMicroApp - ex=" + e.toString());
            return new ArrayList();
        }
    }

    public MicroApp ax(String str, String str2) {
        MFLogger.m12671e(TAG, ".getListMicroApp - serial=" + str);
        try {
            QueryBuilder queryBuilder = aek().queryBuilder();
            queryBuilder.where().eq(MicroApp.COLUMN_PLATFORM, str).and().eq("appId", str2);
            return (MicroApp) queryBuilder.queryForFirst();
        } catch (Exception e) {
            MFLogger.m12671e(TAG, ".getListMicroApp - ex=" + e.toString());
            return null;
        }
    }

    public void updateListMicroApp(List<MicroApp> list) {
        int i = 0;
        if (list != null && !list.isEmpty()) {
            MFLogger.m12671e(TAG, ".updateListMicroApp - platform=" + ((MicroApp) list.get(0)).getPlatform());
            while (i < list.size()) {
                mo1963b((MicroApp) list.get(i));
                i++;
            }
        }
    }

    public boolean mo1963b(MicroApp microApp) {
        if (microApp == null) {
            return false;
        }
        MFLogger.m12670d(TAG, ".addOrUpdateMicroApp - microAppId=" + microApp.getId() + ", serialNumber=" + microApp.getPlatform() + ", appId=" + microApp.getAppId());
        try {
            MicroApp ay = ay(microApp.getAppId(), microApp.getPlatform());
            if (ay != null) {
                microApp.setId(ay.getId());
            }
            aek().createOrUpdate(microApp);
            return true;
        } catch (Exception e) {
            MFLogger.m12671e(TAG, ".addOrUpdateSavedPreset - e=" + e.toString());
            return false;
        }
    }

    public boolean hn(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        MFLogger.m12670d(TAG, ".deleteMicroAppList - serialNumber=" + str);
        try {
            DeleteBuilder deleteBuilder = aek().deleteBuilder();
            deleteBuilder.where().eq(MicroApp.COLUMN_PLATFORM, str);
            deleteBuilder.delete();
            return true;
        } catch (Exception e) {
            MFLogger.m12671e(TAG, ".deleteMicroAppList - e=" + e.toString());
            return false;
        }
    }

    private MicroApp ay(String str, String str2) {
        MFLogger.m12670d(TAG, "getMicroAppByAppIdAndSerial - appId=" + str + " serial=" + str2);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            QueryBuilder queryBuilder = aek().queryBuilder();
            queryBuilder.where().eq("appId", str).and().eq(MicroApp.COLUMN_PLATFORM, str2);
            return (MicroApp) queryBuilder.queryForFirst();
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "getMicroAppByAppIdAndSerial - ex=" + e.toString());
            return null;
        }
    }

    public boolean mo1947a(MicroAppVariant microAppVariant) {
        if (microAppVariant == null) {
            return false;
        }
        MFLogger.m12670d(TAG, ".addOrUpdateMicroAppVariant - microAppId=" + microAppVariant.getAppId() + ", major=" + microAppVariant.getMajorNumber() + ", minor=" + microAppVariant.getMinorNumber());
        try {
            Object obj;
            QueryBuilder queryBuilder = ael().queryBuilder();
            queryBuilder.where().eq("appId", microAppVariant.getAppId()).and().eq("name", microAppVariant.getName()).and().eq("serialNumber", microAppVariant.getSerialNumbers()).and().eq(MicroAppVariant.COLUMN_MAJOR_NUMBER, Integer.valueOf(microAppVariant.getMajorNumber()));
            MicroAppVariant microAppVariant2 = (MicroAppVariant) queryBuilder.queryForFirst();
            if (microAppVariant2 != null) {
                microAppVariant.setId(microAppVariant2.getId());
                obj = 1;
            } else {
                obj = null;
            }
            ael().createOrUpdate(microAppVariant);
            if (obj != null) {
                m7378b(microAppVariant2);
            }
            return true;
        } catch (Exception e) {
            MFLogger.m12671e(TAG, ".addOrUpdateMicroAppVariant - e=" + e.toString());
            return false;
        }
    }

    public MicroAppVariant mo1942a(String str, String str2, int i, String str3) {
        MFLogger.m12670d(TAG, ".getMicroAppVariant - microAppId=" + str + ", serialNumber=" + str2);
        try {
            QueryBuilder queryBuilder = ael().queryBuilder();
            if (str3 == null || str3.isEmpty()) {
                queryBuilder.where().eq("appId", str).and().eq("serialNumber", str2).and().eq(MicroAppVariant.COLUMN_MAJOR_NUMBER, Integer.valueOf(i));
            } else {
                queryBuilder.where().eq("appId", str).and().eq("serialNumber", str2).and().eq(MicroAppVariant.COLUMN_MAJOR_NUMBER, Integer.valueOf(i)).and().eq("name", str3);
            }
            return (MicroAppVariant) queryBuilder.queryForFirst();
        } catch (Exception e) {
            MFLogger.m12671e(TAG, ".getMicroAppVariant - e=" + e.toString());
            return null;
        }
    }

    public List<MicroAppVariant> mo1939D(String str, int i) {
        MFLogger.m12670d(TAG, ".getMicroAppVariant - major=" + i + ", serialNumber=" + str);
        try {
            QueryBuilder queryBuilder = ael().queryBuilder();
            queryBuilder.where().eq(MicroAppVariant.COLUMN_MAJOR_NUMBER, Integer.valueOf(i)).and().eq("serialNumber", str);
            return queryBuilder.query();
        } catch (Exception e) {
            MFLogger.m12671e(TAG, ".getAllMicroAppVariant - e=" + e.toString());
            return null;
        }
    }

    public boolean aec() {
        Log.e(TAG, "clearVariant");
        try {
            TableUtils.clearTable(ael().getConnectionSource(), MicroAppVariant.class);
            return true;
        } catch (Exception e) {
            Log.e(TAG, "clearVariant Exception=" + e);
            return false;
        }
    }

    public boolean aed() {
        Log.e(TAG, "clearDeclarationFiles");
        try {
            TableUtils.clearTable(aem().getConnectionSource(), DeclarationFile.class);
            return true;
        } catch (Exception e) {
            Log.e(TAG, "clearDeclarationFiles Exception=" + e);
            return false;
        }
    }

    public boolean aee() {
        Log.e(TAG, "clearAllDevices");
        try {
            TableUtils.clearTable(aef().getConnectionSource(), DeviceModel.class);
            return true;
        } catch (Exception e) {
            Log.e(TAG, "clearAllDevices Exception=" + e);
            return false;
        }
    }

    public boolean mo1946a(DeclarationFile declarationFile) {
        if (declarationFile == null) {
            return false;
        }
        MFLogger.m12670d(TAG, ".addOrUpdateDeclarationFile - fileId=" + declarationFile.getFileId() + ", description=" + declarationFile.getDescription() + ", content=" + declarationFile.getContent());
        try {
            aem().createOrUpdate(declarationFile);
            return true;
        } catch (Exception e) {
            MFLogger.m12671e(TAG, ".addOrUpdateDeclarationFile - e=" + e.toString());
            return false;
        }
    }

    public boolean m7378b(MicroAppVariant microAppVariant) {
        if (microAppVariant == null || microAppVariant.getId().isEmpty()) {
            return false;
        }
        MFLogger.m12670d(TAG, ".deleteDeclarationFileByVariantId - variantId=" + microAppVariant.getId());
        try {
            DeleteBuilder deleteBuilder = aem().deleteBuilder();
            deleteBuilder.where().eq(DeclarationFile.COLUMN_VARIANT, microAppVariant);
            deleteBuilder.delete();
            return true;
        } catch (Exception e) {
            MFLogger.m12671e(TAG, ".deleteDeclarationFileByVariant - e=" + e.toString());
            return false;
        }
    }

    public void mo1940S(List<SKUModel> list) {
        MFLogger.m12670d(TAG, ".setListSKUsSupported");
        if (list != null && !list.isEmpty()) {
            try {
                for (SKUModel sKUModel : list) {
                    if (!TextUtils.isEmpty(sKUModel.getSku())) {
                        aej().createOrUpdate(sKUModel);
                    }
                }
            } catch (Exception e) {
                MFLogger.m12671e(TAG, ".setListSKUsSupported - ex=" + e.toString());
            }
        }
    }

    public List<SKUModel> adW() {
        MFLogger.m12671e(TAG, ".getListSKUsSupported");
        try {
            return aej().queryBuilder().query();
        } catch (Exception e) {
            MFLogger.m12671e(TAG, ".getListSKUsSupported - ex=" + e.toString());
            return new ArrayList();
        }
    }

    public SKUModel hl(String str) {
        try {
            String toUpperCase = str.toUpperCase();
            QueryBuilder queryBuilder = aej().queryBuilder();
            queryBuilder.where().eq(SKUModel.COLUMN_SERIAL_NUMBER_PREFIX, toUpperCase);
            return (SKUModel) queryBuilder.queryForFirst();
        } catch (Exception e) {
            MFLogger.m12671e(TAG, ".getSKUModelBySerialNumberPrefix - ex=" + e.toString());
            return null;
        }
    }

    public boolean adX() {
        MFLogger.m12670d(TAG, ".clearListSKUsSupported");
        try {
            aej().deleteBuilder().delete();
            return true;
        } catch (Exception e) {
            MFLogger.m12671e(TAG, ".clearListSKUsSupported - e=" + e.toString());
            return false;
        }
    }

    public UAppSystemVersionModel getUAppSystemVersionModel(String str) {
        MFLogger.m12671e(TAG, "getUAppSystemVersionModel - serial=" + str);
        try {
            QueryBuilder queryBuilder = aen().queryBuilder();
            queryBuilder.where().eq("deviceId", str);
            return (UAppSystemVersionModel) queryBuilder.queryForFirst();
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "getUAppSystemVersionModel - ex=" + e.toString());
            return null;
        }
    }

    public void addOrUpdateUAppSystemVersionModel(UAppSystemVersionModel uAppSystemVersionModel) {
        if (uAppSystemVersionModel != null) {
            MFLogger.m12670d(TAG, "addOrUpdateUAppSystemVersionModel - serial=" + uAppSystemVersionModel.getDeviceId() + ", uappMajorVersion=" + uAppSystemVersionModel.getMajorVersion() + ", uappMinorVersion=" + uAppSystemVersionModel.getMinorVersion() + ", pinType=" + uAppSystemVersionModel.getPinType());
            try {
                aen().createOrUpdate(uAppSystemVersionModel);
            } catch (Exception e) {
                MFLogger.m12671e(TAG, "addOrUpdateUAppSystemVersionModel - ex=" + e.toString());
            }
        }
    }

    public MappingSet mo1941a(MFDeviceFamily mFDeviceFamily) {
        MFLogger.m12671e(TAG, ".getActiveMappingSetByDeviceFamily - MFDeviceFamily=" + mFDeviceFamily);
        try {
            QueryBuilder queryBuilder = aeo().queryBuilder();
            queryBuilder.where().eq(MappingSet.COLUMN_IS_ACTIVE, Boolean.valueOf(true)).and().eq("deviceFamily", Integer.valueOf(mFDeviceFamily.getValue()));
            return (MappingSet) queryBuilder.queryForFirst();
        } catch (Exception e) {
            MFLogger.m12671e(TAG, ".getActiveMappingSetByDeviceFamily - ex=" + e);
            return null;
        }
    }

    public List<MappingSet> mo1943a(MappingSet.MappingSetType mappingSetType) {
        MFLogger.m12671e(TAG, ".getMappingSetByType - mappingSetType=" + mappingSetType);
        try {
            QueryBuilder queryBuilder = aeo().queryBuilder();
            queryBuilder.where().eq("type", Integer.valueOf(mappingSetType.getValue()));
            return queryBuilder.query();
        } catch (Exception e) {
            MFLogger.m12671e(TAG, ".getMappingSetByType - ex=" + e.toString());
            return null;
        }
    }

    public String getDbPath() {
        return this.databaseHelper.getDbPath();
    }
}
