package com.fossil;

import android.content.Context;
import android.text.TextUtils;
import com.fossil.wearables.fsl.shared.BaseDbProvider;
import com.fossil.wearables.fsl.shared.UpgradeCommand;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.DataVersion;
import java.sql.SQLException;
import java.util.Map;

public class coj extends BaseDbProvider implements coi {
    private static final String TAG = coj.class.getSimpleName();

    public coj(Context context, String str) {
        super(context, str);
    }

    protected int getDbVersion() {
        return 1;
    }

    protected Class<?>[] getDbEntities() {
        return new Class[]{DataVersion.class};
    }

    protected Map<Integer, UpgradeCommand> getDbUpgrades() {
        return null;
    }

    private Dao<DataVersion, Integer> adR() throws SQLException {
        return this.databaseHelper.getDao(DataVersion.class);
    }

    public void addOrUpdateDataVersioning(DataVersion dataVersion) {
        if (dataVersion != null) {
            try {
                adR().createOrUpdate(dataVersion);
            } catch (Exception e) {
                MFLogger.m12671e(TAG, "Error inside " + TAG + ".addOrUpdateDataVersioning - e=" + e);
            }
        }
    }

    public DataVersion hc(String str) {
        MFLogger.m12670d(TAG, "---Inside .getDataVersioningByKey key: " + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            QueryBuilder queryBuilder = adR().queryBuilder();
            queryBuilder.where().eq(DataVersion.COLUMN_DATA_VERSION, str);
            return (DataVersion) queryBuilder.queryForFirst();
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".getDataVersioningByKey - e=" + e);
            return null;
        }
    }

    public void removeDataVersion(String str) {
        try {
            MFLogger.m12670d(TAG, "---Inside .deleteDataVersioning=" + str);
            DeleteBuilder deleteBuilder = adR().deleteBuilder();
            deleteBuilder.where().eq(DataVersion.COLUMN_DATA_VERSION, str);
            deleteBuilder.delete();
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".deleteDataVersioning - e=" + e);
        }
    }

    public void adQ() {
        MFLogger.m12670d(TAG, "Inside .deleteAllDataVersioning");
        try {
            adR().deleteBuilder().delete();
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".deleteAllDataVersioning - e=" + e);
        }
    }

    public String getDbPath() {
        return this.databaseHelper.getDbPath();
    }
}
