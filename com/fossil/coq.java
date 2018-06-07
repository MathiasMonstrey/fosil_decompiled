package com.fossil;

import android.content.Context;
import com.fossil.wearables.fsl.fitness.DailyGoal;
import com.fossil.wearables.fsl.fitness.FitnessProviderImpl;
import com.fossil.wearables.fsl.fitness.SampleDay;
import com.fossil.wearables.fsl.fitness.SampleRaw;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.table.TableUtils;
import com.misfit.frameworks.common.log.MFLogger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

public class coq extends FitnessProviderImpl {
    public coq(Context context, String str) {
        super(context, str);
    }

    private Dao<SampleRaw, String> getSampleRawDao() throws SQLException {
        return this.databaseHelper.getDao(SampleRaw.class);
    }

    private Dao<SampleDay, String> getSampleDayDao() throws SQLException {
        return this.databaseHelper.getDao(SampleDay.class);
    }

    public void m7402a(SampleRaw sampleRaw) {
        try {
            if (((SampleRaw) getSampleRawDao().queryForId(sampleRaw.getUri().toASCIIString())) == null) {
                getSampleRawDao().create(sampleRaw);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveSampleDays(final List<SampleDay> list) {
        try {
            getSampleDayDao().callBatchTasks(new Callable(this) {
                final /* synthetic */ coq cBr;

                public Void call() throws SQLException {
                    for (SampleDay saveSampleDay : list) {
                        this.cBr.saveSampleDay(saveSampleDay);
                    }
                    return null;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveSampleDay(SampleDay sampleDay) {
        if (sampleDay != null) {
            try {
                SampleDay sampleDayByDate = getSampleDayByDate(sampleDay.getYear(), sampleDay.getMonth(), sampleDay.getDay());
                if (sampleDayByDate != null) {
                    sampleDay = updateSample(sampleDayByDate, sampleDay);
                } else {
                    updateDailyStepGoal(sampleDay.getYear(), sampleDay.getMonth(), sampleDay.getDay(), sampleDay.getStepGoal());
                }
                DailyGoal dailyGoal = getDailyGoal(sampleDay.getYear(), sampleDay.getMonth(), sampleDay.getDay());
                if (dailyGoal != null) {
                    sampleDay.setGoal(dailyGoal);
                }
                getSampleDayDao().createOrUpdate(sampleDay);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private SampleDay updateSample(SampleDay sampleDay, SampleDay sampleDay2) {
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

    public Date getStartDateOfSampleRaw() {
        Exception exception;
        Date date;
        Object obj;
        try {
            QueryBuilder queryBuilder = getSampleRawDao().queryBuilder();
            queryBuilder.orderBy(SampleRaw.COLUMN_START_TIME, true);
            SampleRaw sampleRaw = (SampleRaw) queryBuilder.queryForFirst();
            if (sampleRaw == null) {
                return null;
            }
            Date startTime = sampleRaw.getStartTime();
            try {
                return cmq.getStartOfDay(startTime);
            } catch (Exception e) {
                exception = e;
                date = startTime;
                Exception exception2 = exception;
                MFLogger.m12671e("ExtendFitnessProviderImpl", "Error inside " + "ExtendFitnessProviderImpl" + ".getLastSleepGoal() - e=" + obj);
                return date;
            }
        } catch (Exception e2) {
            exception = e2;
            date = null;
            obj = exception;
            MFLogger.m12671e("ExtendFitnessProviderImpl", "Error inside " + "ExtendFitnessProviderImpl" + ".getLastSleepGoal() - e=" + obj);
            return date;
        }
    }

    public Date getEndDateOfSampleRaw() {
        Exception exception;
        Date date;
        Object obj;
        try {
            QueryBuilder queryBuilder = getSampleRawDao().queryBuilder();
            queryBuilder.orderBy(SampleRaw.COLUMN_END_TIME, false);
            SampleRaw sampleRaw = (SampleRaw) queryBuilder.queryForFirst();
            if (sampleRaw == null) {
                return null;
            }
            Date endTime = sampleRaw.getEndTime();
            try {
                return cmq.getStartOfDay(endTime);
            } catch (Exception e) {
                exception = e;
                date = endTime;
                Exception exception2 = exception;
                MFLogger.m12671e("ExtendFitnessProviderImpl", "Error inside " + "ExtendFitnessProviderImpl" + ".getLastSleepGoal() - e=" + obj);
                return date;
            }
        } catch (Exception e2) {
            exception = e2;
            date = null;
            obj = exception;
            MFLogger.m12671e("ExtendFitnessProviderImpl", "Error inside " + "ExtendFitnessProviderImpl" + ".getLastSleepGoal() - e=" + obj);
            return date;
        }
    }

    public Date getStartDateOfSampleDay() {
        try {
            QueryBuilder queryBuilder = getSampleDayDao().queryBuilder();
            queryBuilder.orderBy("year", true);
            queryBuilder.orderBy("month", true);
            queryBuilder.orderBy("day", true);
            SampleDay sampleDay = (SampleDay) queryBuilder.queryForFirst();
            if (sampleDay != null) {
                Calendar instance = Calendar.getInstance();
                instance.set(sampleDay.getYear(), sampleDay.getMonth() - 1, sampleDay.getDay());
                return cmq.m7110b(instance).getTime();
            }
        } catch (Exception e) {
            MFLogger.m12671e("ExtendFitnessProviderImpl", "Error inside " + "ExtendFitnessProviderImpl" + ".getLastSleepGoal() - e=" + e);
        }
        return null;
    }

    public Date getEndDateOfSampleDay() {
        try {
            QueryBuilder queryBuilder = getSampleDayDao().queryBuilder();
            queryBuilder.orderBy("year", false);
            queryBuilder.orderBy("month", false);
            queryBuilder.orderBy("day", false);
            SampleDay sampleDay = (SampleDay) queryBuilder.queryForFirst();
            if (sampleDay != null) {
                Calendar instance = Calendar.getInstance();
                instance.set(sampleDay.getYear(), sampleDay.getMonth() - 1, sampleDay.getDay());
                return cmq.m7110b(instance).getTime();
            }
        } catch (Exception e) {
            MFLogger.m12671e("ExtendFitnessProviderImpl", "Error inside " + "ExtendFitnessProviderImpl" + ".getLastSleepGoal() - e=" + e);
        }
        return null;
    }

    public int getLastDailyGoal() {
        try {
            QueryBuilder queryBuilder = getDailyGoalDao().queryBuilder();
            queryBuilder.where().not().eq("steps", Integer.valueOf(0));
            queryBuilder.orderBy("year", false).orderBy("month", false).orderBy("day", false);
            DailyGoal dailyGoal = (DailyGoal) queryBuilder.queryForFirst();
            return dailyGoal == null ? FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL : dailyGoal.getSteps();
        } catch (Exception e) {
            MFLogger.m12671e("ExtendFitnessProviderImpl", "Error inside ExtendFitnessProviderImpl.getLastDailyGoal() - e=" + e);
            return FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL;
        }
    }

    public int getLastDailyGoalFromDate(Date date) {
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
            whereArr[0] = where.and(where.eq("year", Integer.valueOf(i)), where.eq("month", Integer.valueOf(i2 + 1)), new Where[]{where.le("day", Integer.valueOf(i3))});
            where.or(lt, and, whereArr);
            queryBuilder.orderBy("year", false).orderBy("month", false).orderBy("day", false);
            DailyGoal dailyGoal = (DailyGoal) queryBuilder.queryForFirst();
            MFLogger.m12670d("ExtendFitnessProviderImpl", "-------------- QUERY=" + queryBuilder.prepareStatementString());
            if (dailyGoal != null) {
                MFLogger.m12670d("ExtendFitnessProviderImpl", "------------ dailyGoal=" + dailyGoal.getDay() + "/" + dailyGoal.getMonth() + "/" + dailyGoal.getYear() + ", step=" + dailyGoal.getSteps());
            }
            return dailyGoal == null ? FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL : dailyGoal.getSteps();
        } catch (Exception e) {
            MFLogger.m12671e("ExtendFitnessProviderImpl", "Error inside ExtendFitnessProviderImpl.getLastDailyGoalFromDate() - e=" + e);
            return FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL;
        }
    }

    public List<DailyGoal> getDailyGoalInRange(Date date, Date date2) {
        String formatDate = formatDate(date);
        String formatDate2 = formatDate(date2);
        try {
            String format = String.format(Locale.US, "select * from %s where (substr('0000' || %s, -4, 4) || substr('00' || %s, -2, 2) || substr('00' || %s, -2, 2)) between ? and ? order by %s, %s, %s", new Object[]{DailyGoal.TABLE_NAME, "year", "month", "day", "year", "month", "day"});
            return getDailyGoalDao().queryRaw(format, getDailyGoalDao().getRawRowMapper(), new String[]{formatDate, formatDate2}).getResults();
        } catch (Exception e) {
            MFLogger.m12671e("ExtendFitnessProviderImpl", "Error inside ExtendFitnessProviderImpl.getLastDailyGoal() - e=" + e);
            return new ArrayList();
        }
    }

    private String formatDate(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int i = instance.get(1);
        int i2 = instance.get(2);
        int i3 = instance.get(5);
        return String.format(Locale.US, "%04d%02d%02d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2 + 1), Integer.valueOf(i3)});
    }

    public List<SampleRaw> getSampleRawsByIds(List<String> list) {
        try {
            QueryBuilder queryBuilder = getSampleRawDao().queryBuilder();
            queryBuilder.where().in("id", list);
            queryBuilder.orderBy("id", true);
            return queryBuilder.query();
        } catch (SQLException e) {
            MFLogger.m12671e("ExtendFitnessProviderImpl", "Error inside ExtendFitnessProviderImpl.getSampleRawsByListId() - e=" + e);
            return new ArrayList();
        }
    }

    public SampleDay getSampleDayByDate(int i, int i2, int i3) {
        try {
            QueryBuilder queryBuilder = getSampleDayDao().queryBuilder();
            queryBuilder.where().eq("year", Integer.valueOf(i)).and().eq("month", Integer.valueOf(i2)).and().eq("day", Integer.valueOf(i3));
            return (SampleDay) queryBuilder.queryForFirst();
        } catch (SQLException e) {
            MFLogger.m12671e("ExtendFitnessProviderImpl", "Error inside ExtendFitnessProviderImpl.getSampleDayByDate() - e=" + e);
            return null;
        }
    }

    public void aet() {
        MFLogger.m12670d("ExtendFitnessProviderImpl", "Inside .deleteAllActivities");
        try {
            TableUtils.clearTable(getSampleRawDao().getConnectionSource(), SampleRaw.class);
        } catch (Exception e) {
            MFLogger.m12671e("ExtendFitnessProviderImpl", "Error inside ExtendFitnessProviderImpl.deleteAllActivities - e=" + e);
        }
    }

    public void aeu() {
        MFLogger.m12670d("ExtendFitnessProviderImpl", "Inside .deleteAllSummaries");
        try {
            TableUtils.clearTable(getSampleDayDao().getConnectionSource(), SampleDay.class);
        } catch (Exception e) {
            MFLogger.m12671e("ExtendFitnessProviderImpl", "Error inside ExtendFitnessProviderImpl.deleteAllSummaries - e=" + e);
        }
    }

    public String getDbPath() {
        return this.databaseHelper.getDbPath();
    }
}
