package com.fossil.wearables.fsl.fitness;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Pair;
import com.fossil.wearables.fsl.shared.BaseDbProvider;
import com.fossil.wearables.fsl.shared.UpgradeCommand;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.misfit.frameworks.common.log.MFLogger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.Callable;

public class FitnessProviderImpl extends BaseDbProvider implements FitnessProvider {
    public static final int DEFAULT_DAILY_STEP_GOAL = 10000;
    private static final String TAG = "FitnessProviderImpl";

    class C41801 extends HashMap<Integer, UpgradeCommand> {

        class C41781 implements UpgradeCommand {
            C41781() {
            }

            public void execute(SQLiteDatabase sQLiteDatabase) {
                sQLiteDatabase.execSQL("ALTER TABLE sampleday ADD COLUMN createdAt BIGINT");
                sQLiteDatabase.execSQL("ALTER TABLE sampleday ADD COLUMN updatedAt BIGINT");
            }
        }

        class C41792 implements UpgradeCommand {
            C41792() {
            }

            public void execute(SQLiteDatabase sQLiteDatabase) {
                sQLiteDatabase.execSQL("ALTER TABLE sampleraw ADD COLUMN pinType INTEGER DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE sampleday ADD COLUMN pinType INTEGER DEFAULT 0");
            }
        }

        C41801() {
            put(Integer.valueOf(2), new C41781());
            put(Integer.valueOf(3), new C41792());
        }
    }

    protected FitnessProviderImpl(Context context, String str) {
        super(context, str);
    }

    protected int getDbVersion() {
        return 3;
    }

    protected Class<?>[] getDbEntities() {
        return new Class[]{SampleDay.class, SampleRaw.class, DailyGoal.class};
    }

    protected Map<Integer, UpgradeCommand> getDbUpgrades() {
        return new C41801();
    }

    private Dao<SampleRaw, String> getSampleRawDao() throws SQLException {
        return this.databaseHelper.getDao(SampleRaw.class);
    }

    private Dao<SampleDay, String> getSampleDayDao() throws SQLException {
        return this.databaseHelper.getDao(SampleDay.class);
    }

    public Dao<DailyGoal, String> getDailyGoalDao() throws SQLException {
        return this.databaseHelper.getDao(DailyGoal.class);
    }

    public void addSample(SampleRaw sampleRaw) {
        MFLogger.d(TAG, "addSample - sample=" + sampleRaw);
        try {
            if (((SampleRaw) getSampleRawDao().queryForId(sampleRaw.getUri().toASCIIString())) == null) {
                sampleRaw.setTimeZone(TimeZone.getDefault().getID());
                getSampleRawDao().create((Object) sampleRaw);
                saveSampleDays(Interpolator.interpolateDays(sampleRaw.startTime, sampleRaw.endTime, sampleRaw.getTimeZone(), sampleRaw.steps, sampleRaw.calories, sampleRaw.distance));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            MFLogger.e(TAG, "addSample - e=" + e.toString());
        } catch (Exception e2) {
            MFLogger.e(TAG, "addSample - ex=" + e2.toString());
        }
    }

    public String getDbPath() {
        return this.databaseHelper.getDbPath();
    }

    public void updateSampleRawPinType(String str, int i) {
        MFLogger.d(TAG, "updateSampleRawPinType - sampleRawId=" + str + ", pinType=" + i);
        try {
            Object obj = (SampleRaw) getSampleRawDao().queryForId(str);
            if (obj != null) {
                obj.setPinType(i);
                getSampleRawDao().update(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            MFLogger.e(TAG, "updateSampleRawPinType - e=" + e.toString());
        }
    }

    List<SampleRaw> getRawSamplesOverlapping(Date date, Date date2) {
        MFLogger.d(TAG, "getRawSamplesOverlapping - start=" + date + ", end=" + date2);
        List<SampleRaw> arrayList = new ArrayList();
        try {
            Dao sampleRawDao = getSampleRawDao();
            QueryBuilder queryBuilder = sampleRawDao.queryBuilder();
            Where where = queryBuilder.where();
            where.or(where.and(where.ge(SampleRaw.COLUMN_START_TIME, date), where.lt(SampleRaw.COLUMN_START_TIME, date2), new Where[0]), where.and(where.ge(SampleRaw.COLUMN_END_TIME, date), where.lt(SampleRaw.COLUMN_END_TIME, date2), new Where[0]), new Where[0]);
            queryBuilder.setWhere(where);
            arrayList = sampleRawDao.query(queryBuilder.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
            MFLogger.e(TAG, "getRawSamplesOverlapping - e=" + e.toString());
        } catch (Exception e2) {
            MFLogger.e(TAG, "getRawSamplesOverlapping - ex=" + e2.toString());
        }
        return arrayList;
    }

    public List<SampleRaw> getRawSamples(Date date, Date date2) {
        MFLogger.d(TAG, "getRawSamples - start=" + date + ", end=" + date2);
        List<SampleRaw> arrayList = new ArrayList();
        try {
            Dao sampleRawDao = getSampleRawDao();
            QueryBuilder queryBuilder = sampleRawDao.queryBuilder();
            Where where = queryBuilder.where();
            where.and(where.ge(SampleRaw.COLUMN_START_TIME, date), where.lt(SampleRaw.COLUMN_START_TIME, date2), new Where[0]);
            queryBuilder.setWhere(where);
            queryBuilder.orderBy(SampleRaw.COLUMN_START_TIME, true);
            arrayList = sampleRawDao.query(queryBuilder.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
            MFLogger.e(TAG, "getRawSamples - e=" + e.toString());
        } catch (Exception e2) {
            MFLogger.e(TAG, "getRawSamples - ex=" + e2.toString());
        }
        return arrayList;
    }

    public SampleDay getSamplesForDay(int i, int i2, int i3) {
        SampleDay sampleDay;
        SQLException e;
        Exception e2;
        MFLogger.d(TAG, "getSamplesForDay - day=" + i + ", month=" + i2 + ", year=" + i3);
        try {
            QueryBuilder queryBuilder = getSampleDayDao().queryBuilder();
            Where where = queryBuilder.where();
            where.and(where.eq("year", Integer.valueOf(i3)), where.eq("month", Integer.valueOf(i2)), where.eq("day", Integer.valueOf(i)));
            queryBuilder.setWhere(where);
            queryBuilder.orderBy("year", true).orderBy("month", true).orderBy("day", true);
            sampleDay = (SampleDay) getSampleDayDao().queryForFirst(queryBuilder.prepare());
            try {
                sampleDay.goal = getDailyGoal(i3, i2, i);
            } catch (SQLException e3) {
                e = e3;
                e.printStackTrace();
                MFLogger.e(TAG, "getSamplesForDay - e=" + e.toString());
                return sampleDay;
            } catch (Exception e4) {
                e2 = e4;
                MFLogger.e(TAG, "getSamplesForDay - ex=" + e2.toString());
                return sampleDay;
            }
        } catch (SQLException e5) {
            SQLException sQLException = e5;
            sampleDay = null;
            e = sQLException;
            e.printStackTrace();
            MFLogger.e(TAG, "getSamplesForDay - e=" + e.toString());
            return sampleDay;
        } catch (Exception e6) {
            Exception exception = e6;
            sampleDay = null;
            e2 = exception;
            MFLogger.e(TAG, "getSamplesForDay - ex=" + e2.toString());
            return sampleDay;
        }
        return sampleDay;
    }

    public SampleDay getSamplesForDay(Calendar calendar) {
        MFLogger.d(TAG, "getSamplesForDay - calendar=" + calendar);
        return getSamplesForDay(calendar.get(5), calendar.get(2) + 1, calendar.get(1));
    }

    public List<SampleDay> getSampleDays(Calendar calendar, Calendar calendar2) {
        List<SampleDay> query;
        SQLException e;
        Exception e2;
        MFLogger.d(TAG, "getSampleDays - startCalendar=" + calendar + ", endCalendar=" + calendar2);
        ArrayList arrayList = new ArrayList();
        int i = calendar.get(1);
        int i2 = calendar.get(2) + 1;
        int i3 = calendar.get(5);
        int i4 = calendar2.get(1);
        int i5 = calendar2.get(2) + 1;
        int i6 = calendar2.get(5);
        try {
            QueryBuilder queryBuilder = getSampleDayDao().queryBuilder();
            Where where = queryBuilder.where();
            where.and(where.or(where.and(where.eq("year", Integer.valueOf(i)), where.eq("month", Integer.valueOf(i2)), where.ge("day", Integer.valueOf(i3))), where.and(where.eq("year", Integer.valueOf(i)), where.gt("month", Integer.valueOf(i2)), new Where[0]), where.gt("year", Integer.valueOf(i))), where.or(where.and(where.eq("year", Integer.valueOf(i4)), where.eq("month", Integer.valueOf(i5)), where.lt("day", Integer.valueOf(i6))), where.and(where.eq("year", Integer.valueOf(i4)), where.lt("month", Integer.valueOf(i5)), new Where[0]), where.lt("year", Integer.valueOf(i4))), new Where[0]);
            queryBuilder.setWhere(where);
            queryBuilder.orderBy("year", true).orderBy("month", true).orderBy("day", true);
            query = getSampleDayDao().query(queryBuilder.prepare());
            try {
                matchWithDailyGoals(query);
            } catch (SQLException e3) {
                e = e3;
                e.printStackTrace();
                MFLogger.e(TAG, "getSampleDays - e=" + e.toString());
                return query;
            } catch (Exception e4) {
                e2 = e4;
                MFLogger.e(TAG, "getSampleDays - ex=" + e2.toString());
                return query;
            }
        } catch (SQLException e5) {
            SQLException sQLException = e5;
            query = arrayList;
            e = sQLException;
            e.printStackTrace();
            MFLogger.e(TAG, "getSampleDays - e=" + e.toString());
            return query;
        } catch (Exception e6) {
            Exception exception = e6;
            query = arrayList;
            e2 = exception;
            MFLogger.e(TAG, "getSampleDays - ex=" + e2.toString());
            return query;
        }
        return query;
    }

    public List<SampleDay> getAllSampleDays() {
        List<SampleDay> query;
        SQLException e;
        Exception e2;
        MFLogger.d(TAG, "getAllSampleDays");
        ArrayList arrayList = new ArrayList();
        try {
            QueryBuilder queryBuilder = getSampleDayDao().queryBuilder();
            queryBuilder.orderBy("year", true).orderBy("month", true).orderBy("day", true);
            query = getSampleDayDao().query(queryBuilder.prepare());
            try {
                matchWithDailyGoals(query);
            } catch (SQLException e3) {
                e = e3;
                e.printStackTrace();
                MFLogger.e(TAG, "getAllSampleDays - e=" + e.toString());
                return query;
            } catch (Exception e4) {
                e2 = e4;
                MFLogger.e(TAG, "getAllSampleDays - ex=" + e2.toString());
                return query;
            }
        } catch (SQLException e5) {
            SQLException sQLException = e5;
            query = arrayList;
            e = sQLException;
            e.printStackTrace();
            MFLogger.e(TAG, "getAllSampleDays - e=" + e.toString());
            return query;
        } catch (Exception e6) {
            Exception exception = e6;
            query = arrayList;
            e2 = exception;
            MFLogger.e(TAG, "getAllSampleDays - ex=" + e2.toString());
            return query;
        }
        return query;
    }

    public DailyGoal updateDailyStepGoal(int i, Calendar calendar) {
        MFLogger.e(TAG, "updateDailyStepGoal - steps=" + i + ", day=" + calendar);
        DailyGoal dailyGoal = new DailyGoal(calendar.get(1), calendar.get(2) + 1, calendar.get(5), i);
        try {
            getDailyGoalDao().createOrUpdate(dailyGoal);
        } catch (SQLException e) {
            e.printStackTrace();
            MFLogger.e(TAG, "updateDailyStepGoal - e=" + e.toString());
        } catch (Exception e2) {
            MFLogger.e(TAG, "updateDailyStepGoal - ex=" + e2.toString());
        }
        return dailyGoal;
    }

    public DailyGoal updateDailyStepGoal(int i, int i2, int i3, int i4) {
        MFLogger.e(TAG, "updateDailyStepGoal - year=" + i + ", month=" + i2 + ", day=" + i3 + ", stepGoal=" + i4);
        DailyGoal dailyGoal = new DailyGoal(i, i2, i3, i4);
        try {
            getDailyGoalDao().createOrUpdate(dailyGoal);
        } catch (SQLException e) {
            e.printStackTrace();
            MFLogger.e(TAG, "updateDailyStepGoal - e=" + e.toString());
        } catch (Exception e2) {
            MFLogger.e(TAG, "updateDailyStepGoal - ex=" + e2.toString());
        }
        return dailyGoal;
    }

    public List<DailyGoal> getAllDailyGoals() {
        MFLogger.d(TAG, "getAllDailyGoals");
        List<DailyGoal> arrayList = new ArrayList();
        try {
            QueryBuilder queryBuilder = getDailyGoalDao().queryBuilder();
            queryBuilder.orderBy("year", true).orderBy("month", true).orderBy("day", true);
            arrayList = getDailyGoalDao().query(queryBuilder.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
            MFLogger.e(TAG, "getAllDailyGoals - e=" + e.toString());
        } catch (Exception e2) {
            MFLogger.e(TAG, "getAllDailyGoals - ex=" + e2.toString());
        }
        return arrayList;
    }

    public DailyGoal getDailyGoal(Calendar calendar) {
        MFLogger.d(TAG, "getDailyGoal - calendarDay=" + calendar);
        return getDailyGoal(calendar.get(1), calendar.get(2) + 1, calendar.get(5));
    }

    public DailyGoal getDailyGoal(int i, int i2, int i3) {
        MFLogger.e(TAG, "getDailyGoal - year=" + i + ", month=" + i2 + ", day=" + i3);
        List arrayList = new ArrayList();
        try {
            Dao dailyGoalDao = getDailyGoalDao();
            QueryBuilder queryBuilder = dailyGoalDao.queryBuilder();
            Where where = queryBuilder.where();
            where.or(where.and(where.eq("year", Integer.valueOf(i)), where.eq("month", Integer.valueOf(i2)), where.le("day", Integer.valueOf(i3))), where.and(where.eq("year", Integer.valueOf(i)), where.lt("month", Integer.valueOf(i2)), new Where[0]), where.lt("year", Integer.valueOf(i)));
            queryBuilder.setWhere(where);
            queryBuilder.orderBy("year", false).orderBy("month", false).orderBy("day", false);
            queryBuilder.limit(Long.valueOf(1));
            arrayList = dailyGoalDao.query(queryBuilder.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
            MFLogger.e(TAG, "getDailyGoal - e=" + e.toString());
        } catch (Exception e2) {
            MFLogger.e(TAG, "getDailyGoal - ex=" + e2.toString());
        }
        if (arrayList.size() > 0) {
            return (DailyGoal) arrayList.get(0);
        }
        MFLogger.d(TAG, "getDailyGoal - goals=NULL!!!");
        return null;
    }

    public Pair<Integer, Integer> getTodayStepCountAndGoal() {
        MFLogger.d(TAG, "getTodayStepCountAndGoal");
        Object valueOf = Integer.valueOf(0);
        Object valueOf2 = Integer.valueOf(DEFAULT_DAILY_STEP_GOAL);
        SampleDay samplesForDay = getSamplesForDay(Calendar.getInstance());
        if (samplesForDay != null) {
            valueOf = Integer.valueOf((int) samplesForDay.getSteps());
            if (samplesForDay.getGoal() != null) {
                valueOf2 = Integer.valueOf(samplesForDay.getGoal().getSteps());
            }
        }
        return new Pair(valueOf, valueOf2);
    }

    public int getTodayStepGoal() {
        MFLogger.d(TAG, "getTodayStepGoal");
        DailyGoal dailyGoal = getDailyGoal(Calendar.getInstance());
        if (dailyGoal == null) {
            return DEFAULT_DAILY_STEP_GOAL;
        }
        return dailyGoal.getSteps();
    }

    public SampleRaw getLastSampleRaw() {
        MFLogger.d(TAG, "getLastSampleRaw");
        try {
            QueryBuilder queryBuilder = getSampleRawDao().queryBuilder();
            queryBuilder.orderBy(SampleRaw.COLUMN_END_TIME, false);
            return (SampleRaw) queryBuilder.queryForFirst();
        } catch (Exception e) {
            MFLogger.e(TAG, "getLastSampleRaw - e=" + e.toString());
            return null;
        }
    }

    public void addDownloadedSampleRaw(SampleRaw sampleRaw) {
        MFLogger.d(TAG, "addDownloadedSampleRaw - sample=" + sampleRaw);
        try {
            if (((SampleRaw) getSampleRawDao().queryForId(sampleRaw.getUri().toASCIIString())) == null) {
                getSampleRawDao().create((Object) sampleRaw);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            MFLogger.e(TAG, "addDownloadedSampleRaw - e=" + e.toString());
        }
    }

    public void saveSampleDays(final List<SampleDay> list) {
        MFLogger.d(TAG, "saveSampleDays - sampleDays=" + list);
        try {
            getSampleDayDao().callBatchTasks(new Callable() {
                public Void call() throws SQLException {
                    for (SampleDay saveSampleDay : list) {
                        FitnessProviderImpl.this.saveSampleDay(saveSampleDay);
                    }
                    return null;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            MFLogger.e(TAG, "saveSampleDays - ex=" + e.toString());
        }
    }

    public void saveSampleDay(SampleDay sampleDay) {
        MFLogger.d(TAG, "saveSampleDay - sample=" + sampleDay);
        if (sampleDay != null) {
            try {
                SampleDay sampleDayByDate = getSampleDayByDate(sampleDay.getYear(), sampleDay.getMonth(), sampleDay.getDay());
                if (sampleDayByDate != null) {
                    sampleDay = updateSample(sampleDayByDate, sampleDay);
                } else {
                    updateDailyStepGoal(sampleDay.getYear(), sampleDay.getMonth(), sampleDay.getDay(), sampleDay.getStepGoal());
                    sampleDay.setCreatedAt(System.currentTimeMillis());
                    sampleDay.setUpdatedAt(System.currentTimeMillis());
                }
                DailyGoal dailyGoal = getDailyGoal(sampleDay.getYear(), sampleDay.getMonth(), sampleDay.getDay());
                if (dailyGoal != null) {
                    sampleDay.setGoal(dailyGoal);
                }
                MFLogger.d(TAG, "saveSampleDay - sample to createOrUpdate=" + sampleDay);
                getSampleDayDao().createOrUpdate(sampleDay);
            } catch (Exception e) {
                e.printStackTrace();
                MFLogger.e(TAG, "saveSampleDay - ex=" + e.toString());
            }
        }
    }

    public Date getStartDateOfSampleRaw() {
        MFLogger.d(TAG, "getStartDateOfSampleRaw");
        try {
            QueryBuilder queryBuilder = getSampleRawDao().queryBuilder();
            queryBuilder.orderBy(SampleRaw.COLUMN_START_TIME, true);
            SampleRaw sampleRaw = (SampleRaw) queryBuilder.queryForFirst();
            if (sampleRaw != null) {
                return sampleRaw.getStartTime();
            }
        } catch (Exception e) {
            e.printStackTrace();
            MFLogger.e(TAG, "getStartDateOfSampleRaw - ex=" + e.toString());
        }
        return null;
    }

    public Date getEndDateOfSampleRaw() {
        MFLogger.d(TAG, "getEndDateOfSampleRaw");
        try {
            QueryBuilder queryBuilder = getSampleRawDao().queryBuilder();
            queryBuilder.orderBy(SampleRaw.COLUMN_END_TIME, false);
            SampleRaw sampleRaw = (SampleRaw) queryBuilder.queryForFirst();
            if (sampleRaw != null) {
                return sampleRaw.getEndTime();
            }
        } catch (Exception e) {
            e.printStackTrace();
            MFLogger.e(TAG, "getEndDateOfSampleRaw - ex=" + e.toString());
        }
        return null;
    }

    public Date getStartDateOfSampleDay() {
        MFLogger.d(TAG, "getStartDateOfSampleDay");
        try {
            QueryBuilder queryBuilder = getSampleDayDao().queryBuilder();
            queryBuilder.orderBy("year", true);
            queryBuilder.orderBy("month", true);
            queryBuilder.orderBy("day", true);
            SampleDay sampleDay = (SampleDay) queryBuilder.queryForFirst();
            if (sampleDay != null) {
                Calendar instance = Calendar.getInstance();
                instance.set(sampleDay.getYear(), sampleDay.getMonth() - 1, sampleDay.getDay());
                return instance.getTime();
            }
        } catch (Exception e) {
            e.printStackTrace();
            MFLogger.e(TAG, "getStartDateOfSampleDay - ex=" + e.toString());
        }
        return null;
    }

    public Date getEndDateOfSampleDay() {
        MFLogger.d(TAG, "getEndDateOfSampleDay");
        try {
            QueryBuilder queryBuilder = getSampleDayDao().queryBuilder();
            queryBuilder.orderBy("year", false);
            queryBuilder.orderBy("month", false);
            queryBuilder.orderBy("day", false);
            SampleDay sampleDay = (SampleDay) queryBuilder.queryForFirst();
            if (sampleDay != null) {
                Calendar instance = Calendar.getInstance();
                instance.set(sampleDay.getYear(), sampleDay.getMonth() - 1, sampleDay.getDay());
                return instance.getTime();
            }
        } catch (Exception e) {
            e.printStackTrace();
            MFLogger.e(TAG, "getEndDateOfSampleDay - ex=" + e.toString());
        }
        return null;
    }

    public int getLastDailyGoal() {
        MFLogger.d(TAG, "getLastDailyGoal");
        try {
            QueryBuilder queryBuilder = getDailyGoalDao().queryBuilder();
            queryBuilder.where().not().eq("steps", Integer.valueOf(0));
            queryBuilder.orderBy("year", false).orderBy("month", false).orderBy("day", false);
            DailyGoal dailyGoal = (DailyGoal) queryBuilder.queryForFirst();
            return dailyGoal == null ? DEFAULT_DAILY_STEP_GOAL : dailyGoal.getSteps();
        } catch (Exception e) {
            e.printStackTrace();
            MFLogger.e(TAG, "getLastDailyGoal - ex=" + e.toString());
            return DEFAULT_DAILY_STEP_GOAL;
        }
    }

    public int getLastDailyGoalFromDate(Date date) {
        MFLogger.d(TAG, "getLastDailyGoalFromDate - date=" + date);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int i = instance.get(1);
        int i2 = instance.get(2);
        int i3 = instance.get(5);
        try {
            QueryBuilder queryBuilder = getDailyGoalDao().queryBuilder();
            Where where = queryBuilder.where();
            Where lt = where.lt("year", Integer.valueOf(i));
            Where and = where.and(where.eq("year", Integer.valueOf(i)), where.lt("month", Integer.valueOf(i2 + 1)), new Where[0]);
            Where[] whereArr = new Where[1];
            whereArr[0] = where.and(where.eq("year", Integer.valueOf(i)), where.eq("month", Integer.valueOf(i2 + 1)), where.le("day", Integer.valueOf(i3)));
            where.or(lt, and, whereArr);
            queryBuilder.orderBy("year", false).orderBy("month", false).orderBy("day", false);
            DailyGoal dailyGoal = (DailyGoal) queryBuilder.queryForFirst();
            MFLogger.d(TAG, "getLastDailyGoalFromDate - QUERY=" + queryBuilder.prepareStatementString());
            if (dailyGoal != null) {
                MFLogger.d(TAG, "getLastDailyGoalFromDate - dailyGoal=" + dailyGoal.getDay() + "/" + dailyGoal.getMonth() + "/" + dailyGoal.getYear() + ", step=" + dailyGoal.getSteps());
            }
            return dailyGoal == null ? DEFAULT_DAILY_STEP_GOAL : dailyGoal.getSteps();
        } catch (Exception e) {
            e.printStackTrace();
            MFLogger.e(TAG, "getLastDailyGoalFromDate - ex=" + e.toString());
            return DEFAULT_DAILY_STEP_GOAL;
        }
    }

    public List<DailyGoal> getDailyGoalInRange(Date date, Date date2) {
        MFLogger.d(TAG, "getDailyGoalInRange - fromDate=" + date + ", toDate=" + date2);
        String formatDate = formatDate(date);
        String formatDate2 = formatDate(date2);
        try {
            String format = String.format(Locale.US, "select * from %s where (substr('0000' || %s, -4, 4) || substr('00' || %s, -2, 2) || substr('00' || %s, -2, 2)) between ? and ? order by %s, %s, %s", new Object[]{DailyGoal.TABLE_NAME, "year", "month", "day", "year", "month", "day"});
            return getDailyGoalDao().queryRaw(format, getDailyGoalDao().getRawRowMapper(), formatDate, formatDate2).getResults();
        } catch (Exception e) {
            e.printStackTrace();
            MFLogger.e(TAG, "getDailyGoalInRange - ex=" + e.toString());
            return new ArrayList();
        }
    }

    public SampleDay getSampleDayByDate(int i, int i2, int i3) {
        MFLogger.d(TAG, "getSampleDayByDate - year=" + i + ", month=" + i2 + ", day=" + i3);
        try {
            QueryBuilder queryBuilder = getSampleDayDao().queryBuilder();
            queryBuilder.where().eq("year", Integer.valueOf(i)).and().eq("month", Integer.valueOf(i2)).and().eq("day", Integer.valueOf(i3));
            return (SampleDay) queryBuilder.queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
            MFLogger.e(TAG, "getSampleDayByDate - ex=" + e.toString());
            return null;
        }
    }

    public List<SampleRaw> getSampleRawsByIds(List<String> list) {
        MFLogger.d(TAG, "getSampleRawsByIds - ids=" + list);
        try {
            QueryBuilder queryBuilder = getSampleRawDao().queryBuilder();
            queryBuilder.where().in("id", (Iterable) list);
            queryBuilder.orderBy("id", true);
            return queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
            MFLogger.e(TAG, "getSampleRawsByIds - ex=" + e.toString());
            return new ArrayList();
        }
    }

    public List<SampleRaw> getPendingSampleRaws() {
        MFLogger.d(TAG, "getPendingSampleRaws");
        try {
            QueryBuilder queryBuilder = getSampleRawDao().queryBuilder();
            queryBuilder.where().ne("pinType", Integer.valueOf(0));
            return queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
            MFLogger.e(TAG, "getPendingSampleRaws - ex=" + e.toString());
            return new ArrayList();
        }
    }

    private void matchWithDailyGoals(List<SampleDay> list) {
        MFLogger.d(TAG, "matchWithDailyGoals - sampleDays=" + list);
        List allDailyGoals = getAllDailyGoals();
        if (allDailyGoals.size() != 0) {
            Iterator it = allDailyGoals.iterator();
            DailyGoal dailyGoal = (DailyGoal) it.next();
            DailyGoal dailyGoal2 = dailyGoal;
            DailyGoal dailyGoal3 = dailyGoal;
            for (SampleDay sampleDay : list) {
                DailyGoal dailyGoal4 = dailyGoal2;
                dailyGoal2 = dailyGoal3;
                dailyGoal3 = dailyGoal4;
                while (!isGoalLaterThanSample(dailyGoal3, sampleDay)) {
                    if (!it.hasNext()) {
                        dailyGoal2 = dailyGoal3;
                        break;
                    }
                    dailyGoal2 = dailyGoal3;
                    dailyGoal3 = (DailyGoal) it.next();
                }
                sampleDay.goal = dailyGoal2;
                dailyGoal4 = dailyGoal3;
                dailyGoal3 = dailyGoal2;
                dailyGoal2 = dailyGoal4;
            }
        }
    }

    private boolean isGoalLaterThanSample(DailyGoal dailyGoal, SampleDay sampleDay) {
        MFLogger.d(TAG, "isGoalLaterThanSample - goal=" + dailyGoal + ", sample=" + sampleDay);
        return dailyGoal.year > sampleDay.year || ((dailyGoal.year == sampleDay.year && dailyGoal.month > sampleDay.month) || (dailyGoal.year == sampleDay.year && dailyGoal.month == sampleDay.month && dailyGoal.day > sampleDay.day));
    }

    private SampleDay updateSample(SampleDay sampleDay, SampleDay sampleDay2) {
        MFLogger.d(TAG, "updateSample - currentSample=" + sampleDay + ", newSample=" + sampleDay2);
        if (sampleDay.getUpdatedAt() < sampleDay2.getUpdatedAt()) {
            sampleDay.setDistance(sampleDay2.getDistance());
            sampleDay.setSteps(sampleDay2.getSteps());
            sampleDay.setCalories(sampleDay2.getCalories());
            sampleDay.setUpdatedAt(sampleDay2.getUpdatedAt());
            if (getDailyGoal(sampleDay.getYear(), sampleDay.getMonth(), sampleDay.getDay()).getSteps() != sampleDay2.getStepGoal()) {
                updateDailyStepGoal(sampleDay2.getYear(), sampleDay2.getMonth(), sampleDay2.getDay(), sampleDay2.getStepGoal());
            }
        }
        return sampleDay;
    }

    private String formatDate(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int i = instance.get(1);
        int i2 = instance.get(2);
        int i3 = instance.get(5);
        return String.format(Locale.US, "%04d%02d%02d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2 + 1), Integer.valueOf(i3)});
    }
}
