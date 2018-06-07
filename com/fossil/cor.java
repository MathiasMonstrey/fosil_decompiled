package com.fossil;

import android.content.Context;
import com.fossil.wearables.fsl.sleep.MFSleepDay;
import com.fossil.wearables.fsl.sleep.MFSleepGoal;
import com.fossil.wearables.fsl.sleep.MFSleepSession;
import com.fossil.wearables.fsl.sleep.MFSleepSessionProviderImp;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.table.TableUtils;
import com.misfit.frameworks.common.log.MFLogger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class cor extends MFSleepSessionProviderImp {
    private static final String TAG = cor.class.getName();

    public cor(Context context, String str) {
        super(context, str);
    }

    private Dao<MFSleepSession, Integer> getSleepSessionDao() throws SQLException {
        return this.databaseHelper.getDao(MFSleepSession.class);
    }

    private Dao<MFSleepGoal, Integer> getSleepGoalDao() throws SQLException {
        return this.databaseHelper.getDao(MFSleepGoal.class);
    }

    private Dao<MFSleepDay, Integer> getSleepDao() throws SQLException {
        return this.databaseHelper.getDao(MFSleepDay.class);
    }

    public boolean m7403a(MFSleepSession mFSleepSession) {
        if (mFSleepSession == null) {
            return false;
        }
        try {
            QueryBuilder queryBuilder = getSleepSessionDao().queryBuilder();
            queryBuilder.where().eq(MFSleepSession.COLUMN_REAL_END_TIME, Integer.valueOf(mFSleepSession.getRealEndTime()));
            List query = getSleepSessionDao().query(queryBuilder.prepare());
            if (query != null && query.size() > 0) {
                MFSleepSession mFSleepSession2 = (MFSleepSession) query.get(0);
                if (mFSleepSession2 != null) {
                    mFSleepSession.setDbRowId(mFSleepSession2.getDbRowId());
                }
            }
            getSleepSessionDao().createOrUpdate(mFSleepSession);
            return true;
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".addSleepSession - e=" + e);
            return false;
        }
    }

    public int ho(String str) {
        try {
            QueryBuilder queryBuilder = getSleepGoalDao().queryBuilder();
            queryBuilder.where().not().gt("date", str);
            queryBuilder.orderBy("date", false);
            MFSleepGoal mFSleepGoal = (MFSleepGoal) queryBuilder.queryForFirst();
            return mFSleepGoal == null ? 480 : mFSleepGoal.getMinute();
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".getLastSleepGoal() - e=" + e);
            return 480;
        }
    }

    public List<MFSleepDay> az(String str, String str2) {
        List<MFSleepDay> query;
        ArrayList arrayList = new ArrayList();
        try {
            QueryBuilder queryBuilder = getSleepDao().queryBuilder();
            queryBuilder.where().between("date", str, str2);
            queryBuilder.orderBy("date", true);
            query = queryBuilder.query();
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".getLastSleepGoal() - e=" + e);
            Object obj = arrayList;
        }
        return query != null ? query : new ArrayList();
    }

    public String getDbPath() {
        return this.databaseHelper.getDbPath();
    }

    public void aev() {
        MFLogger.m12670d(TAG, "deleteAllSleepSessions");
        try {
            TableUtils.clearTable(getSleepSessionDao().getConnectionSource(), MFSleepSession.class);
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".deleteAllSleepSessions - e=" + e);
        }
    }

    public void aew() {
        MFLogger.m12670d(TAG, "deleteAllSleepSummaries");
        try {
            TableUtils.clearTable(getSleepDao().getConnectionSource(), MFSleepDay.class);
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".deleteAllSleepSummaries - e=" + e);
        }
    }
}
