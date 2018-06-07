package com.misfit.frameworks.buttonservice.db;

import android.content.Context;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.misfit.frameworks.common.log.MFLogger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataLogServiceProvider extends BaseDbProvider {
    public static final String DB_NAME = "log_service.db";
    public static final int KEY_NOTIFICATION_DEBUGLOG_ID = 999;
    private static final String TAG = DataLogServiceProvider.class.getSimpleName();
    private static DataLogServiceProvider sInstance;

    class C47081 extends HashMap<Integer, UpgradeCommand> {
        C47081() {
        }
    }

    public static DataLogServiceProvider getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DataLogServiceProvider(context, DB_NAME);
        }
        return sInstance;
    }

    public synchronized void addNotificationDebugLog(String str) {
        MFLogger.d(TAG, "addNotificationDebugLog - content=" + str);
        Object dataLogServiceById = getDataLogServiceById(999);
        if (dataLogServiceById != null) {
            try {
                dataLogServiceById.setContent(dataLogServiceById.getContent() + str);
                getDataLogServicesDAO().update(dataLogServiceById);
            } catch (Exception e) {
                e.printStackTrace();
                MFLogger.e(TAG, "addNotificationDebugLog - e=" + e);
            }
        } else {
            dataLogServiceById = new DataLogService();
            dataLogServiceById.setContent(str);
            dataLogServiceById.setId(999);
            getDataLogServicesDAO().create(dataLogServiceById);
        }
    }

    private DataLogServiceProvider(Context context, String str) {
        super(context, str);
    }

    protected int getDbVersion() {
        return 3;
    }

    protected Class<?>[] getDbEntities() {
        return new Class[]{DataLogService.class};
    }

    protected Map<Integer, UpgradeCommand> getDbUpgrades() {
        return new C47081();
    }

    private Dao<DataLogService, Integer> getDataLogServicesDAO() throws SQLException {
        return this.databaseHelper.getDao(DataLogService.class);
    }

    public synchronized void createOrUpdate(DataLogService dataLogService) {
        if (dataLogService == null) {
            MFLogger.e(TAG, "createOrUpdate - dataLogService=null");
        } else {
            int id = dataLogService.getId();
            MFLogger.d(TAG, "createOrUpdate - logId=" + id);
            DataLogService dataLogServiceById = getDataLogServiceById(id);
            try {
                if (dataLogService.getContent() == null || dataLogService.getContent().getBytes().length <= 819200) {
                    if (dataLogServiceById != null) {
                        getDataLogServicesDAO().update((Object) dataLogService);
                    } else {
                        getDataLogServicesDAO().create((Object) dataLogService);
                    }
                    MFLogger.d(TAG, "createOrUpdate - logId=" + id + ", currentTimeMillis=" + System.currentTimeMillis());
                } else {
                    MFLogger.e(TAG, "createOrUpdate - content data log > 800Kb");
                }
            } catch (Exception e) {
                e.printStackTrace();
                MFLogger.e(TAG, "createOrUpdate - logId=" + id + ", e=" + e);
            }
        }
    }

    public void remove(DataLogService dataLogService) {
        MFLogger.d(TAG, "remove - dataLogService=" + dataLogService);
        if (dataLogService != null) {
            try {
                DeleteBuilder deleteBuilder = getDataLogServicesDAO().deleteBuilder();
                deleteBuilder.where().eq("id", Integer.valueOf(dataLogService.getId()));
                deleteBuilder.delete();
            } catch (Exception e) {
                e.printStackTrace();
                MFLogger.e(TAG, "remove - e=" + e);
            }
        }
    }

    public void removeById(int i) {
        MFLogger.d(TAG, "removeById - id=" + i);
        try {
            DeleteBuilder deleteBuilder = getDataLogServicesDAO().deleteBuilder();
            deleteBuilder.where().eq("id", Integer.valueOf(i));
            deleteBuilder.delete();
        } catch (Exception e) {
            e.printStackTrace();
            MFLogger.e(TAG, "removeById - e=" + e);
        }
    }

    public List<DataLogService> getAllDataLogServiceByStatus(int i) {
        MFLogger.d(TAG, "getAllDataLogServiceByStatus - status=" + i);
        List<DataLogService> arrayList = new ArrayList();
        try {
            QueryBuilder queryBuilder = getDataLogServicesDAO().queryBuilder();
            queryBuilder.where().eq("status", Integer.valueOf(i));
            arrayList = queryBuilder.query();
        } catch (Exception e) {
            e.printStackTrace();
            MFLogger.e(TAG, "getAllDataLogServiceByStatus - e=" + e);
        }
        return arrayList;
    }

    public List<DataLogService> getAllDataLogServiceByStatusAndLogStyle(int i, int i2) {
        MFLogger.d(TAG, "getAllDataLogServiceByStatusAndLogStyle - status=" + i + ", logStyle=" + i2);
        List<DataLogService> arrayList = new ArrayList();
        try {
            QueryBuilder queryBuilder = getDataLogServicesDAO().queryBuilder();
            queryBuilder.where().eq("status", Integer.valueOf(i)).and().eq(DataLogService.COLUMN_LOG_STYLE, Integer.valueOf(i2));
            arrayList = queryBuilder.query();
        } catch (Exception e) {
            e.printStackTrace();
            MFLogger.e(TAG, "getAllDataLogServiceByStatusAndLogStyle - e=" + e);
        }
        return arrayList;
    }

    public DataLogService getDataLogServiceById(int i) {
        MFLogger.d(TAG, "getDataLogServiceById - id=" + i);
        try {
            return (DataLogService) getDataLogServicesDAO().queryBuilder().where().eq("id", Integer.valueOf(i)).queryForFirst();
        } catch (Exception e) {
            e.printStackTrace();
            MFLogger.e(TAG, "getDataLogServiceById - e=" + e);
            return null;
        }
    }
}
