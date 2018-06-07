package com.fossil.wearables.fsl.sleep;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.fossil.wearables.fsl.shared.BaseDbProvider;
import com.fossil.wearables.fsl.shared.UpgradeCommand;
import com.fossil.wearables.fsl.utils.TimeUtils;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.misfit.frameworks.common.log.MFLogger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.joda.time.DateTime;

public class MFSleepSessionProviderImp extends BaseDbProvider implements MFSleepSessionProvider {
    public static final String DB_NAME = "sleep.db";
    private static final int DEF_SLEEP_GOAL = 480;
    private static final String TAG = MFSleepSessionProviderImp.class.getSimpleName();

    class C41941 extends HashMap<Integer, UpgradeCommand> {

        class C41921 implements UpgradeCommand {
            C41921() {
            }

            public void execute(SQLiteDatabase sQLiteDatabase) {
                MFLogger.d(MFSleepSessionProviderImp.TAG, " ---- UPGRADE DB SLEEP");
                sQLiteDatabase.execSQL("ALTER TABLE sleep_session ADD COLUMN day VARCHAR");
                MFLogger.d(MFSleepSessionProviderImp.TAG, " ---- UPGRADE DB SLEEP SUCCESS");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("UPDATE sleep_session SET day = (select strftime('%Y-%m-%d', datetime((").append(MFSleepSession.COLUMN_EDITED_END_TIME).append(" + ").append("timezoneOffset").append(") , 'unixepoch')) from sleep_session b where sleep_session.id = b. id)");
                sQLiteDatabase.execSQL(stringBuilder.toString());
            }
        }

        class C41932 implements UpgradeCommand {
            C41932() {
            }

            public void execute(SQLiteDatabase sQLiteDatabase) {
                sQLiteDatabase.execSQL("ALTER TABLE sleep_session ADD COLUMN pinType INTEGER DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE sleep_date ADD COLUMN pinType INTEGER DEFAULT 0");
            }
        }

        C41941() {
            put(Integer.valueOf(2), new C41921());
            put(Integer.valueOf(3), new C41932());
        }
    }

    public MFSleepSessionProviderImp(Context context, String str) {
        super(context, str);
    }

    private Dao<MFSleepSession, Integer> getSleepSessionDao() throws SQLException {
        return this.databaseHelper.getDao(MFSleepSession.class);
    }

    private Dao<MFSleepDay, Integer> getSleepDao() throws SQLException {
        return this.databaseHelper.getDao(MFSleepDay.class);
    }

    private Dao<MFSleepGoal, Integer> getSleepGoalDao() throws SQLException {
        return this.databaseHelper.getDao(MFSleepGoal.class);
    }

    protected int getDbVersion() {
        return 3;
    }

    protected Class<?>[] getDbEntities() {
        return new Class[]{MFSleepSession.class, MFSleepDay.class, MFSleepGoal.class};
    }

    protected Map<Integer, UpgradeCommand> getDbUpgrades() {
        return new C41941();
    }

    public boolean addSleepSession(MFSleepSession mFSleepSession) {
        MFLogger.d(TAG, "addSleepSession - session=" + mFSleepSession);
        if (mFSleepSession == null) {
            return false;
        }
        try {
            QueryBuilder queryBuilder = getSleepSessionDao().queryBuilder();
            queryBuilder.where().eq(MFSleepSession.COLUMN_REAL_END_TIME, Integer.valueOf(mFSleepSession.getRealEndTime()));
            List query = getSleepSessionDao().query(queryBuilder.prepare());
            MFSleepSession mFSleepSession2 = null;
            if (query != null && query.size() > 0) {
                mFSleepSession2 = (MFSleepSession) query.get(0);
                if (mFSleepSession2 != null) {
                    mFSleepSession.setDbRowId(mFSleepSession2.getDbRowId());
                }
            }
            MFSleepDay sleepDay = getSleepDay(TimeUtils.getStringTimeYYYYMMDD(mFSleepSession.getDate()));
            if (sleepDay == null) {
                if (!addSleepDay(createMFSleepDayFromMFSleepSession(mFSleepSession))) {
                    return false;
                }
            } else if (mFSleepSession2 == null && !addSleepDay(editSleepDayWhenAddSleepSession(sleepDay, mFSleepSession))) {
                return false;
            }
            getSleepSessionDao().createOrUpdate(mFSleepSession);
            return true;
        } catch (Exception e) {
            MFLogger.e(TAG, "addSleepSession - e=" + e);
            return false;
        }
    }

    public boolean editSleepSession(MFSleepSession mFSleepSession) {
        MFLogger.d(TAG, "editSleepSession - session=" + mFSleepSession);
        if (mFSleepSession == null) {
            return false;
        }
        try {
            MFSleepDay sleepDay = getSleepDay(TimeUtils.getStringTimeYYYYMMDD(mFSleepSession.getDate()));
            MFSleepSession sleepSession = getSleepSession((long) mFSleepSession.getRealEndTime());
            if (sleepDay == null || !addSleepDay(editSleepDayWhenEditSleepSession(sleepDay, sleepSession, mFSleepSession))) {
                return false;
            }
            if (sleepSession != null) {
                mFSleepSession.setDbRowId(sleepSession.getDbRowId());
            }
            getSleepSessionDao().createOrUpdate(mFSleepSession);
            return true;
        } catch (Exception e) {
            MFLogger.e(TAG, "editSleepSession - e=" + e);
            return false;
        }
    }

    public MFSleepSession getSleepSession(long j) {
        MFLogger.d(TAG, "getSleepSession - realEndTime=" + j);
        try {
            QueryBuilder queryBuilder = getSleepSessionDao().queryBuilder();
            queryBuilder.where().eq(MFSleepSession.COLUMN_REAL_END_TIME, Long.valueOf(j));
            return (MFSleepSession) queryBuilder.queryForFirst();
        } catch (Exception e) {
            Log.e(TAG, "getSleepSession - e=" + e);
            return null;
        }
    }

    public String getDbPath() {
        return this.databaseHelper.getDbPath();
    }

    public List<MFSleepSession> getSleepSessions(long j, long j2) {
        MFLogger.d(TAG, "getSleepSessions - fromDate=" + j + ", toDate=" + j2);
        ArrayList arrayList = new ArrayList();
        try {
            QueryBuilder queryBuilder = getSleepSessionDao().queryBuilder();
            queryBuilder.orderBy(MFSleepSession.COLUMN_EDITED_START_TIME, true);
            Where where = queryBuilder.where();
            where.between("date", Long.valueOf(j), Long.valueOf(j2));
            List<MFSleepSession> query = where.query();
            if (query != null && query.size() > 0) {
                return query;
            }
        } catch (Exception e) {
            MFLogger.e(TAG, "getSleepSessions - e=" + e);
        }
        return arrayList;
    }

    public List<MFSleepSession> getSleepSessions(long j) {
        MFLogger.d(TAG, "getSleepSessions - time=" + j);
        ArrayList arrayList = new ArrayList();
        Date date = new Date(j);
        long time = TimeUtils.getStartOfDay(date).getTime();
        long time2 = TimeUtils.getEndOfDay(date).getTime();
        try {
            QueryBuilder queryBuilder = getSleepSessionDao().queryBuilder();
            queryBuilder.orderBy(MFSleepSession.COLUMN_EDITED_START_TIME, true);
            Where where = queryBuilder.where();
            where.between("date", Long.valueOf(time), Long.valueOf(time2));
            List<MFSleepSession> query = where.query();
            if (query != null && query.size() > 0) {
                return query;
            }
        } catch (Exception e) {
            MFLogger.e(TAG, "getSleepSessions - e=" + e);
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.fossil.wearables.fsl.sleep.MFSleepSession> getSleepSessions(java.lang.String r6) {
        /*
        r5 = this;
        r0 = TAG;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "getSleepSessions - day=";
        r1 = r1.append(r2);
        r1 = r1.append(r6);
        r1 = r1.toString();
        com.misfit.frameworks.common.log.MFLogger.d(r0, r1);
        r1 = new java.util.ArrayList;
        r1.<init>();
        r0 = r5.getSleepSessionDao();	 Catch:{ Exception -> 0x005d }
        r0 = r0.queryBuilder();	 Catch:{ Exception -> 0x005d }
        r2 = "editedStartTime";
        r3 = 1;
        r0.orderBy(r2, r3);	 Catch:{ Exception -> 0x005d }
        r0 = r0.where();	 Catch:{ Exception -> 0x005d }
        r2 = "day";
        r0.eq(r2, r6);	 Catch:{ Exception -> 0x005d }
        r0 = r0.query();	 Catch:{ Exception -> 0x005d }
        if (r0 == 0) goto L_0x0076;
    L_0x003a:
        r2 = r0.size();	 Catch:{ Exception -> 0x005d }
        if (r2 <= 0) goto L_0x0076;
    L_0x0040:
        r1 = TAG;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "getSleepSessions - sleepSessions.size=";
        r2 = r2.append(r3);
        r3 = r0.size();
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.misfit.frameworks.common.log.MFLogger.d(r1, r2);
        return r0;
    L_0x005d:
        r0 = move-exception;
        r2 = TAG;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "getSleepSessions - e=";
        r3 = r3.append(r4);
        r0 = r3.append(r0);
        r0 = r0.toString();
        com.misfit.frameworks.common.log.MFLogger.e(r2, r0);
    L_0x0076:
        r0 = r1;
        goto L_0x0040;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.wearables.fsl.sleep.MFSleepSessionProviderImp.getSleepSessions(java.lang.String):java.util.List<com.fossil.wearables.fsl.sleep.MFSleepSession>");
    }

    public boolean deleteSleepSession(long j) {
        MFLogger.d(TAG, "deleteSleepSession - realEndTime=" + j);
        MFSleepSession sleepSession = getSleepSession(j);
        MFSleepDay sleepDay = getSleepDay(TimeUtils.getStringTimeYYYYMMDD(sleepSession.getDate()));
        if (sleepSession == null || sleepDay == null) {
            return false;
        }
        MFSleepDay editSleepDayWhenDeleteSleepSession = editSleepDayWhenDeleteSleepSession(sleepDay, sleepSession);
        if (editSleepDayWhenDeleteSleepSession == null || !addSleepDay(editSleepDayWhenDeleteSleepSession)) {
            return false;
        }
        try {
            DeleteBuilder deleteBuilder = getSleepSessionDao().deleteBuilder();
            deleteBuilder.where().eq(MFSleepSession.COLUMN_REAL_END_TIME, Long.valueOf(j));
            deleteBuilder.delete();
            return true;
        } catch (SQLException e) {
            MFLogger.e(TAG, "deleteSleepSession - e=" + e);
            return false;
        }
    }

    public boolean deleteSleepSession(MFSleepSession mFSleepSession) {
        MFLogger.d(TAG, "deleteSleepSession - objectId=" + mFSleepSession.getObjectId());
        MFSleepDay sleepDay = getSleepDay(TimeUtils.getStringTimeYYYYMMDD(mFSleepSession.getDate()));
        if (sleepDay == null) {
            return false;
        }
        sleepDay = editSleepDayWhenDeleteSleepSession(sleepDay, mFSleepSession);
        if (sleepDay == null || !addSleepDay(sleepDay)) {
            return false;
        }
        try {
            DeleteBuilder deleteBuilder = getSleepSessionDao().deleteBuilder();
            deleteBuilder.where().eq("date", Long.valueOf(mFSleepSession.getDate()));
            deleteBuilder.delete();
            return true;
        } catch (SQLException e) {
            MFLogger.e(TAG, "deleteSleepSession - e=" + e);
            return false;
        }
    }

    public boolean addSleepDay(MFSleepDay mFSleepDay) {
        MFLogger.d(TAG, "addSleepDay - sleep=" + mFSleepDay);
        if (mFSleepDay == null) {
            return false;
        }
        try {
            QueryBuilder queryBuilder = getSleepDao().queryBuilder();
            queryBuilder.where().eq("date", mFSleepDay.getDate());
            List query = getSleepDao().query(queryBuilder.prepare());
            if (query != null && query.size() > 0) {
                MFSleepDay mFSleepDay2 = (MFSleepDay) query.get(0);
                if (mFSleepDay2 != null) {
                    mFSleepDay.setDbRowId(mFSleepDay2.getDbRowId());
                }
            }
            getSleepDao().createOrUpdate(mFSleepDay);
            return true;
        } catch (Exception e) {
            MFLogger.e(TAG, "addSleepDay - e=" + e);
            return false;
        }
    }

    public MFSleepDay getSleepDay(String str) {
        MFLogger.d(TAG, "getSleepDay - dateTime=" + str);
        try {
            QueryBuilder queryBuilder = getSleepDao().queryBuilder();
            queryBuilder.where().eq("date", str);
            return (MFSleepDay) queryBuilder.queryForFirst();
        } catch (Exception e) {
            MFLogger.e(TAG, "getSleepDay - dateTime=" + str + ", e=" + e);
            return null;
        }
    }

    public List<MFSleepDay> getSleepDays(long j, long j2) {
        MFLogger.d(TAG, "getSleepDays - fromDate=" + j + ", toDate=" + j2);
        ArrayList arrayList = new ArrayList();
        try {
            QueryBuilder queryBuilder = getSleepDao().queryBuilder();
            queryBuilder.orderBy("date", true);
            Where where = queryBuilder.where();
            where.between("date", Long.valueOf(j), Long.valueOf(j2));
            List<MFSleepDay> query = where.query();
            if (query != null && query.size() > 0) {
                return query;
            }
        } catch (Exception e) {
            MFLogger.e(TAG, "getSleepDays - e=" + e);
        }
        return arrayList;
    }

    public int getSleepSessionNumberFromSleepDay(long j) {
        MFLogger.d(TAG, "getSleepSessionNumberFromSleepDay - time=" + j);
        List sleepSessions = getSleepSessions(TimeUtils.getStartOfDay(new Date(j)).getTime(), TimeUtils.getEndOfDay(new Date(j)).getTime());
        if (sleepSessions == null || sleepSessions.size() <= 0) {
            return 0;
        }
        return sleepSessions.size();
    }

    public void updateSleepDay(MFSleepDay mFSleepDay) {
        MFLogger.d(TAG, "updateSleepDay - sleepDay=" + mFSleepDay);
        try {
            getSleepDao().update((Object) mFSleepDay);
        } catch (Exception e) {
            MFLogger.d(TAG, "updateSleepDay - e=" + e);
        }
    }

    private MFSleepDay createMFSleepDayFromMFSleepSession(MFSleepSession mFSleepSession) {
        Log.i(TAG, "Create SleepDay - date=" + TimeUtils.getStringTimeYYYYMMDD(mFSleepSession.getDate()));
        return new MFSleepDay(TimeUtils.getStringTimeYYYYMMDD(mFSleepSession.getDate()), TimeUtils.getTimezoneOffset(), getLastSleepGoal(), mFSleepSession.getEditedSleepMinutes(), mFSleepSession.getEditedSleepStateDistInMinute(), mFSleepSession.getUpdatedAt());
    }

    private MFSleepDay editSleepDayWhenDeleteSleepSession(MFSleepDay mFSleepDay, MFSleepSession mFSleepSession) {
        SleepDistribution sleepDistributionByString = SleepDistribution.getSleepDistributionByString(mFSleepDay.getSleepStateDistInMinute());
        SleepDistribution sleepDistributionByString2 = SleepDistribution.getSleepDistributionByString(mFSleepSession.getEditedSleepStateDistInMinute());
        if (sleepDistributionByString2 != null) {
            sleepDistributionByString.setAwake(sleepDistributionByString.getAwake() - sleepDistributionByString2.getAwake());
            sleepDistributionByString.setLight(sleepDistributionByString.getLight() - sleepDistributionByString2.getLight());
            sleepDistributionByString.setDeep(sleepDistributionByString.getDeep() - sleepDistributionByString2.getDeep());
            mFSleepDay.setSleepMinutes(mFSleepDay.getSleepMinutes() - mFSleepSession.getEditedSleepMinutes());
            mFSleepDay.setSleepStateDistInMinute(sleepDistributionByString.getSleepDistribution());
            mFSleepDay.setUpdatedAt(new DateTime(Calendar.getInstance().getTimeInMillis()));
        }
        return mFSleepDay;
    }

    private MFSleepDay editSleepDayWhenAddSleepSession(MFSleepDay mFSleepDay, MFSleepSession mFSleepSession) {
        Log.i(TAG, "editSleepDayWhenAddSleepSession - date=" + TimeUtils.getStringTimeYYYYMMDD(mFSleepSession.getDate()));
        SleepDistribution sleepDistributionByString = SleepDistribution.getSleepDistributionByString(mFSleepDay.getSleepStateDistInMinute());
        SleepDistribution sleepDistributionByString2 = SleepDistribution.getSleepDistributionByString(mFSleepSession.getEditedSleepStateDistInMinute());
        if (sleepDistributionByString != null && sleepDistributionByString2 != null) {
            sleepDistributionByString.setAwake(sleepDistributionByString.getAwake() + sleepDistributionByString2.getAwake());
            sleepDistributionByString.setLight(sleepDistributionByString.getLight() + sleepDistributionByString2.getLight());
            sleepDistributionByString.setDeep(sleepDistributionByString2.getDeep() + sleepDistributionByString.getDeep());
        } else if (sleepDistributionByString2 != null) {
            sleepDistributionByString = new SleepDistribution(sleepDistributionByString2.getAwake(), sleepDistributionByString2.getLight(), sleepDistributionByString2.getDeep());
        }
        mFSleepDay.setSleepMinutes(mFSleepDay.getSleepMinutes() + mFSleepSession.getEditedSleepMinutes());
        if (sleepDistributionByString != null) {
            mFSleepDay.setSleepStateDistInMinute(sleepDistributionByString.getSleepDistribution());
        }
        mFSleepDay.setUpdatedAt(new DateTime(Calendar.getInstance().getTimeInMillis()));
        return mFSleepDay;
    }

    private MFSleepDay editSleepDayWhenEditSleepSession(MFSleepDay mFSleepDay, MFSleepSession mFSleepSession, MFSleepSession mFSleepSession2) {
        return editSleepDayWhenAddSleepSession(editSleepDayWhenDeleteSleepSession(mFSleepDay, mFSleepSession), mFSleepSession2);
    }

    public MFSleepGoal updateDailySleepGoal(MFSleepGoal mFSleepGoal) {
        MFLogger.d(TAG, "updateDailySleepGoal - sleepGoal=" + mFSleepGoal);
        try {
            QueryBuilder queryBuilder = getSleepGoalDao().queryBuilder();
            queryBuilder.where().eq("date", mFSleepGoal.getDate()).and().eq("timezoneOffset", Integer.valueOf(TimeUtils.getTimezoneOffset()));
            List query = getSleepGoalDao().query(queryBuilder.prepare());
            if (query != null && query.size() > 0) {
                MFSleepGoal mFSleepGoal2 = (MFSleepGoal) query.get(0);
                if (mFSleepGoal2 != null) {
                    mFSleepGoal.setDbRowId(mFSleepGoal2.getDbRowId());
                    mFSleepGoal.setDate(mFSleepGoal2.getDate());
                }
            }
            getSleepGoalDao().createOrUpdate(mFSleepGoal);
        } catch (Exception e) {
            MFLogger.e(TAG, "updateDailySleepGoal - dateTime=" + mFSleepGoal.getDate() + ", e=" + e);
        }
        return mFSleepGoal;
    }

    public MFSleepGoal getDailySleepGoal(String str) {
        MFLogger.d(TAG, "getDailySleepGoal - date=" + str);
        try {
            QueryBuilder queryBuilder = getSleepGoalDao().queryBuilder();
            queryBuilder.where().le("date", str);
            return (MFSleepGoal) queryBuilder.queryForFirst();
        } catch (Exception e) {
            MFLogger.e(TAG, "getDailySleepGoal - e=" + e);
            return null;
        }
    }

    public int getTodaySleepGoal() {
        MFLogger.d(TAG, "getTodaySleepGoal");
        MFSleepGoal dailySleepGoal = getDailySleepGoal(TimeUtils.getStringCurrentTimeYYYYMMDD());
        if (dailySleepGoal == null) {
            return DEF_SLEEP_GOAL;
        }
        return dailySleepGoal.getMinute();
    }

    public int getLastSleepGoal() {
        MFLogger.d(TAG, "getLastSleepGoal");
        try {
            QueryBuilder queryBuilder = getSleepGoalDao().queryBuilder();
            queryBuilder.orderBy("date", false);
            MFSleepGoal mFSleepGoal = (MFSleepGoal) queryBuilder.queryForFirst();
            return mFSleepGoal == null ? DEF_SLEEP_GOAL : mFSleepGoal.getMinute();
        } catch (Exception e) {
            MFLogger.e(TAG, "getLastSleepGoal - e=" + e);
            return DEF_SLEEP_GOAL;
        }
    }

    public List<MFSleepSession> getPendingSleepSessions() {
        MFLogger.d(TAG, "getPendingSleepSessions");
        try {
            QueryBuilder queryBuilder = getSleepSessionDao().queryBuilder();
            queryBuilder.where().ne("pinType", Integer.valueOf(0));
            return queryBuilder.query();
        } catch (SQLException e) {
            MFLogger.e(TAG, "getPendingSleepSessions - e=" + e);
            return new ArrayList();
        }
    }

    public void updateSleepSessionPinType(MFSleepSession mFSleepSession, int i) {
        try {
            Object sleepSession = getSleepSession((long) mFSleepSession.getRealEndTime());
            if (sleepSession != null) {
                sleepSession.setPinType(i);
                getSleepSessionDao().update(sleepSession);
            }
        } catch (Exception e) {
            MFLogger.e(TAG, "updateSleepSessionPinType - e=" + e);
        }
    }
}
