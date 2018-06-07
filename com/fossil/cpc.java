package com.fossil;

import android.content.Context;
import android.util.Log;
import com.fossil.wearables.fsl.shared.BaseDbProvider;
import com.fossil.wearables.fsl.shared.UpgradeCommand;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.table.TableUtils;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.microapp.MicroAppSetting;
import com.portfolio.platform.provider.MicroAppSettingProviderImp.1;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class cpc extends BaseDbProvider implements cpb {
    private static final String TAG = cpc.class.getSimpleName();

    public cpc(Context context, String str) {
        super(context, str);
    }

    private Dao<MicroAppSetting, Integer> aeI() throws SQLException {
        return this.databaseHelper.getDao(MicroAppSetting.class);
    }

    protected int getDbVersion() {
        return 2;
    }

    protected Class<?>[] getDbEntities() {
        return new Class[]{MicroAppSetting.class};
    }

    protected Map<Integer, UpgradeCommand> getDbUpgrades() {
        return new 1(this);
    }

    public boolean mo1996b(MicroAppSetting microAppSetting) {
        if (microAppSetting != null) {
            try {
                MFLogger.m12670d(TAG, "addOrUpdateSetting microAppId=" + microAppSetting.getMicroAppId() + ", setting=" + microAppSetting.getSetting());
                aeI().createOrUpdate(microAppSetting);
                return true;
            } catch (Exception e) {
                Log.e(TAG, "addOrUpdateSetting Exception=" + e);
                return false;
            }
        }
        Log.e(TAG, "addOrUpdateSetting microAppSetting null");
        return false;
    }

    public void updateMicroAppSettingPinType(String str, int i) {
        MicroAppSetting hs = hs(str);
        if (hs != null) {
            hs.setPinType(i);
            mo1996b(hs);
        }
    }

    public MicroAppSetting hs(String str) {
        Log.e(TAG, "getSettingByMicroAppId microAppId=" + str);
        try {
            QueryBuilder queryBuilder = aeI().queryBuilder();
            queryBuilder.where().eq("appId", str);
            MicroAppSetting microAppSetting = (MicroAppSetting) queryBuilder.queryForFirst();
            MFLogger.m12670d(TAG, "Inside .getSettingByMicroAppId in thread=" + Thread.currentThread().getName());
            if (microAppSetting != null) {
                return microAppSetting;
            }
            Log.e(TAG, "getSettingByMicroAppId microAppSetting null");
            return null;
        } catch (Exception e) {
            Log.e(TAG, "getSettingByMicroAppId Exception=" + e);
            return null;
        }
    }

    public List<MicroAppSetting> aeG() {
        Log.e(TAG, "getAllMicroAppSettingList");
        try {
            List<MicroAppSetting> query = aeI().queryBuilder().query();
            if (query != null) {
                return query;
            }
            Log.e(TAG, "getAllMicroAppSettingList microAppSetting null");
            return new ArrayList();
        } catch (Exception e) {
            Log.e(TAG, "getAllMicroAppSettingList Exception=" + e);
            return null;
        }
    }

    public List<MicroAppSetting> getPendingMicroAppSettings() {
        Log.e(TAG, "getPendingMicroAppSettings");
        try {
            QueryBuilder queryBuilder = aeI().queryBuilder();
            queryBuilder.where().ne("pinType", Integer.valueOf(0));
            List<MicroAppSetting> query = queryBuilder.query();
            if (query != null) {
                return query;
            }
            Log.e(TAG, "getPendingMicroAppSettings microAppSetting null");
            return new ArrayList();
        } catch (Exception e) {
            Log.e(TAG, "getPendingMicroAppSettings Exception=" + e);
            return new ArrayList();
        }
    }

    public boolean aeH() {
        Log.e(TAG, "getAllMicroAppSettingList");
        try {
            TableUtils.clearTable(aeI().getConnectionSource(), MicroAppSetting.class);
            return true;
        } catch (Exception e) {
            Log.e(TAG, "getAllMicroAppSettingList Exception=" + e);
            return false;
        }
    }

    public String getDbPath() {
        return this.databaseHelper.getDbPath();
    }
}
