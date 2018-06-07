package com.fossil.wearables.fsl.goaltracking;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.fossil.wearables.fsl.shared.BaseDbProvider;
import com.fossil.wearables.fsl.shared.UpgradeCommand;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoalTrackingProviderImpl extends BaseDbProvider implements GoalTrackingProvider {
    public static final String DB_NAME = "goal_tracking.db";

    class C41871 extends HashMap<Integer, UpgradeCommand> {

        class C41831 implements UpgradeCommand {
            C41831() {
            }

            public void execute(SQLiteDatabase sQLiteDatabase) {
                sQLiteDatabase.execSQL("ALTER TABLE goaltrackingevent ADD COLUMN counter INTEGER DEFAULT 1");
                sQLiteDatabase.execSQL("ALTER TABLE goaltrackingevent ADD COLUMN autoDetected INTEGER");
            }
        }

        class C41842 implements UpgradeCommand {
            C41842() {
            }

            public void execute(SQLiteDatabase sQLiteDatabase) {
                sQLiteDatabase.execSQL("ALTER TABLE goaltrackingevent ADD COLUMN uri VARCHAR PRIMARY KEY");
            }
        }

        class C41853 implements UpgradeCommand {
            C41853() {
            }

            public void execute(SQLiteDatabase sQLiteDatabase) {
                sQLiteDatabase.execSQL("ALTER TABLE goalphase ADD COLUMN startDay VARCHAR");
                sQLiteDatabase.execSQL("ALTER TABLE goalphase ADD COLUMN endDay VARCHAR");
            }
        }

        class C41864 implements UpgradeCommand {
            C41864() {
            }

            public void execute(SQLiteDatabase sQLiteDatabase) {
                sQLiteDatabase.execSQL("ALTER TABLE goaltracking ADD COLUMN pinType INTEGER DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE goaltrackingevent ADD COLUMN pinType INTEGER DEFAULT 0");
            }
        }

        C41871() {
            put(Integer.valueOf(2), new C41831());
            put(Integer.valueOf(3), new C41842());
            put(Integer.valueOf(4), new C41853());
            put(Integer.valueOf(5), new C41864());
        }
    }

    public GoalTrackingProviderImpl(Context context, String str) {
        super(context, str);
    }

    protected int getDbVersion() {
        return 5;
    }

    protected Class<?>[] getDbEntities() {
        return new Class[]{GoalTracking.class, GoalPhase.class, GoalTrackingEvent.class, GoalTrackingSummary.class};
    }

    protected Map<Integer, UpgradeCommand> getDbUpgrades() {
        return new C41871();
    }

    protected Dao<GoalTracking, Long> getGoalTrackingDao() throws SQLException {
        return this.databaseHelper.getDao(GoalTracking.class);
    }

    protected Dao<GoalTrackingSummary, Long> getGoalTrackingSummaryDao() throws SQLException {
        return this.databaseHelper.getDao(GoalTrackingSummary.class);
    }

    protected Dao<GoalTrackingEvent, Long> getGoalTrackingEventDao() throws SQLException {
        return this.databaseHelper.getDao(GoalTrackingEvent.class);
    }

    protected Dao<GoalPhase, Long> getGoalPhaseDao() throws SQLException {
        return this.databaseHelper.getDao(GoalPhase.class);
    }

    public void saveGoalTracking(GoalTracking goalTracking) {
        try {
            GoalTracking goalTracking2 = getGoalTracking(goalTracking.uri);
            if (goalTracking2 == null) {
                goalTracking2 = getGoalTrackingByServerId(goalTracking.getServerId());
            }
            if (goalTracking2 != null) {
                if (goalTracking.getId() > 0) {
                    goalTracking.setUpdatedAt(System.currentTimeMillis());
                } else if (TextUtils.isEmpty(goalTracking.getServerId())) {
                    goalTracking.setUpdatedAt(System.currentTimeMillis());
                }
                goalTracking.setId(goalTracking2.getId());
                getGoalTrackingDao().update((Object) goalTracking);
                return;
            }
            if (TextUtils.isEmpty(goalTracking.getServerId())) {
                goalTracking.setCreatedAt(System.currentTimeMillis());
            }
            getGoalTrackingDao().create((Object) goalTracking);
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".saveGoalTracking - e=" + e);
        }
    }

    public GoalTracking getActiveGoalTracking() {
        try {
            QueryBuilder queryBuilder = getGoalTrackingDao().queryBuilder();
            queryBuilder.where().eq("status", Integer.valueOf(GoalStatus.ACTIVE.getValue()));
            queryBuilder.orderBy("updatedAt", false);
            queryBuilder.orderBy("createdAt", false);
            List query = getGoalTrackingDao().query(queryBuilder.prepare());
            if (query != null && query.size() > 0) {
                return (GoalTracking) query.get(0);
            }
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".getActiveGoalTracking - e=" + e);
        }
        return null;
    }

    public String getDbPath() {
        return this.databaseHelper.getDbPath();
    }

    public void setGoalTrackingStatus(String str, GoalStatus goalStatus) {
        GoalTracking goalTracking = getGoalTracking(str);
        if (goalTracking != null) {
            goalTracking.setStatus(goalStatus);
            saveGoalTracking(goalTracking);
        }
    }

    public List<GoalTracking> getAllGoalTrackings() {
        try {
            return getGoalTrackingDao().queryForAll();
        } catch (Exception e) {
            return null;
        }
    }

    public List<GoalTracking> getGoalTracking(GoalStatus goalStatus) {
        List<GoalTracking> arrayList = new ArrayList();
        try {
            QueryBuilder queryBuilder = getGoalTrackingDao().queryBuilder();
            queryBuilder.where().eq("status", Integer.valueOf(goalStatus.getValue())).and().ne("pinType", Integer.valueOf(3));
            Collection query = getGoalTrackingDao().query(queryBuilder.prepare());
            if (query != null) {
                arrayList.addAll(query);
            }
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".getGoalTracking - e=" + e);
        }
        return arrayList;
    }

    public GoalTracking getGoalTracking(String str, Frequency frequency, int i) {
        try {
            QueryBuilder queryBuilder = getGoalTrackingDao().queryBuilder();
            queryBuilder.where().like("name", str.trim()).and().eq(GoalTracking.COLUMN_FREQUENCY, Integer.valueOf(frequency.getValue())).and().eq(GoalTracking.COLUMN_TARGET, Integer.valueOf(i)).and().gt("status", Integer.valueOf(GoalStatus.REMOVED.getValue())).and().ne("pinType", Integer.valueOf(3));
            queryBuilder.orderBy("createdAt", false);
            queryBuilder.orderBy("updatedAt", false);
            List query = getGoalTrackingDao().query(queryBuilder.prepare());
            if (query != null && query.size() > 0) {
                return (GoalTracking) query.get(0);
            }
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".getGoalTracking - e=" + e);
        }
        return null;
    }

    public GoalTracking getGoalTracking(String str) {
        try {
            QueryBuilder queryBuilder = getGoalTrackingDao().queryBuilder();
            queryBuilder.where().eq("uri", str).and().ne("pinType", Integer.valueOf(3));
            List query = getGoalTrackingDao().query(queryBuilder.prepare());
            if (query != null && query.size() > 0) {
                return (GoalTracking) query.get(0);
            }
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".getGoalTracking - e=" + e);
        }
        return null;
    }

    public GoalTracking getGoalTracking(long j) {
        try {
            QueryBuilder queryBuilder = getGoalTrackingDao().queryBuilder();
            queryBuilder.where().eq("id", Long.valueOf(j)).and().ne("pinType", Integer.valueOf(3));
            List query = getGoalTrackingDao().query(queryBuilder.prepare());
            if (query != null && query.size() > 0) {
                return (GoalTracking) query.get(0);
            }
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".getGoalTracking - e=" + e);
        }
        return null;
    }

    public GoalTracking getGoalTrackingByServerId(String str) {
        try {
            QueryBuilder queryBuilder = getGoalTrackingDao().queryBuilder();
            queryBuilder.where().eq("serverId", str).and().ne("pinType", Integer.valueOf(3));
            List query = getGoalTrackingDao().query(queryBuilder.prepare());
            if (query != null && query.size() > 0) {
                return (GoalTracking) query.get(0);
            }
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".getGoalTrackingByServerId - e=" + e);
        }
        return null;
    }

    public void saveGoalPhase(GoalPhase goalPhase) {
        try {
            QueryBuilder queryBuilder = getGoalPhaseDao().queryBuilder();
            queryBuilder.where().eq(GoalPhase.COLUMN_START_DATE, Long.valueOf(goalPhase.startDate)).and().eq(GoalPhase.COLUMN_END_DATE, Long.valueOf(goalPhase.endDate)).and().eq("goalId", Long.valueOf(goalPhase.goal.id));
            GoalPhase goalPhase2 = null;
            List query = getGoalPhaseDao().query(queryBuilder.prepare());
            if (query != null && query.size() > 0) {
                goalPhase2 = (GoalPhase) query.get(0);
            }
            if (goalPhase2 != null) {
                goalPhase.setId(goalPhase2.getId());
            }
            getGoalPhaseDao().createOrUpdate(goalPhase);
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".saveGoalPhase - e=" + e);
        }
    }

    public GoalPhase getGoalPhase(long j) {
        GoalPhase goalPhase;
        Exception exception;
        Object obj;
        GoalPhase goalPhase2 = null;
        try {
            QueryBuilder queryBuilder = getGoalPhaseDao().queryBuilder();
            Where where = queryBuilder.where();
            where.or(where.ge(GoalPhase.COLUMN_END_DATE, Long.valueOf(j)), where.eq(GoalPhase.COLUMN_END_DATE, Integer.valueOf(0)), new Where[0]);
            where.and().le(GoalPhase.COLUMN_START_DATE, Long.valueOf(j));
            queryBuilder.setWhere(where);
            List<GoalPhase> query = getGoalPhaseDao().query(queryBuilder.prepare());
            if (query == null || query.isEmpty()) {
                return null;
            }
            if (query.size() == 1) {
                return (GoalPhase) query.get(0);
            }
            for (GoalPhase goalPhase3 : query) {
                if (goalPhase3.getGoalTracking().getStatus() == GoalStatus.ACTIVE) {
                    goalPhase2 = goalPhase3;
                    break;
                }
            }
            if (goalPhase2 == null) {
                try {
                    if (query.size() > 0) {
                        return (GoalPhase) query.get(0);
                    }
                } catch (Exception e) {
                    exception = e;
                    goalPhase3 = goalPhase2;
                    Exception exception2 = exception;
                    Log.e(this.TAG, "Error inside " + this.TAG + ".getGoalTracking - e=" + obj);
                    return goalPhase3;
                }
            }
            return goalPhase2;
        } catch (Exception e2) {
            exception = e2;
            goalPhase3 = null;
            obj = exception;
            Log.e(this.TAG, "Error inside " + this.TAG + ".getGoalTracking - e=" + obj);
            return goalPhase3;
        }
    }

    public List<GoalPhase> getGoalPhases(long j, long j2) {
        List<GoalPhase> arrayList = new ArrayList();
        try {
            QueryBuilder queryBuilder = getGoalPhaseDao().queryBuilder();
            queryBuilder.where().between(GoalPhase.COLUMN_START_DATE, Long.valueOf(j), Long.valueOf(j2));
            queryBuilder.orderBy(GoalPhase.COLUMN_START_DATE, false);
            Collection query = getGoalPhaseDao().query(queryBuilder.prepare());
            if (query != null) {
                arrayList.addAll(query);
            }
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".getGoalPhases - e=" + e);
        }
        return arrayList;
    }

    public List<GoalPhase> getGoalPhases(long j) {
        List<GoalPhase> arrayList = new ArrayList();
        try {
            QueryBuilder queryBuilder = getGoalPhaseDao().queryBuilder();
            queryBuilder.where().eq("goalId", Long.valueOf(j));
            queryBuilder.orderBy(GoalPhase.COLUMN_START_DATE, false);
            Collection query = getGoalPhaseDao().query(queryBuilder.prepare());
            if (query != null) {
                arrayList.addAll(query);
            }
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".getGoalPhases - e=" + e);
        }
        return arrayList;
    }

    public void saveGoalTrackingEvent(GoalTrackingEvent goalTrackingEvent) {
        try {
            goalTrackingEvent.setTrackedAt((goalTrackingEvent.getTrackedAt() / 1000) * 1000);
            QueryBuilder queryBuilder = getGoalTrackingEventDao().queryBuilder();
            queryBuilder.where().eq(GoalTrackingEvent.COLUMN_TRACKED_AT, Long.valueOf(goalTrackingEvent.trackedAt)).and().eq("goalId", Long.valueOf(goalTrackingEvent.goalTracking.id));
            GoalTrackingEvent goalTrackingEvent2 = null;
            List query = getGoalTrackingEventDao().query(queryBuilder.prepare());
            if (query != null && query.size() > 0) {
                goalTrackingEvent2 = (GoalTrackingEvent) query.get(0);
            }
            if (goalTrackingEvent2 == null) {
                getGoalTrackingEventDao().create((Object) goalTrackingEvent);
            }
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".saveGoalTrackingEvent - e=" + e);
        }
    }

    public SparseArray<List<GoalTrackingEvent>> getGoalTrackingEvent(int i, int i2, long j) {
        SparseArray<List<GoalTrackingEvent>> sparseArray = new SparseArray();
        try {
            QueryBuilder queryBuilder = getGoalTrackingEventDao().queryBuilder();
            queryBuilder.where().between("date", Integer.valueOf(i), Integer.valueOf(i2)).and().eq("goalId", Long.valueOf(j));
            queryBuilder.orderBy("date", false);
            List<GoalTrackingEvent> query = getGoalTrackingEventDao().query(queryBuilder.prepare());
            if (query != null) {
                for (GoalTrackingEvent goalTrackingEvent : query) {
                    List list = (List) sparseArray.get(goalTrackingEvent.date);
                    if (list == null) {
                        list = new ArrayList();
                    }
                    list.add(goalTrackingEvent);
                    sparseArray.put(goalTrackingEvent.date, list);
                }
            }
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".getGoalTrackingEvent - e=" + e);
        }
        return sparseArray;
    }

    public SparseArray<List<GoalTrackingEvent>> getGoalTrackingEvent(long j) {
        SparseArray<List<GoalTrackingEvent>> sparseArray = new SparseArray();
        try {
            QueryBuilder queryBuilder = getGoalTrackingEventDao().queryBuilder();
            queryBuilder.where().eq("goalId", Long.valueOf(j));
            queryBuilder.orderBy("date", false);
            List<GoalTrackingEvent> query = getGoalTrackingEventDao().query(queryBuilder.prepare());
            if (query != null) {
                for (GoalTrackingEvent goalTrackingEvent : query) {
                    List list = (List) sparseArray.get(goalTrackingEvent.date);
                    if (list == null) {
                        list = new ArrayList();
                    }
                    list.add(goalTrackingEvent);
                    sparseArray.put(goalTrackingEvent.date, list);
                }
            }
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".getGoalTrackingEvent - e=" + e);
        }
        return sparseArray;
    }

    public List<Integer> getGoalTrackingEventDates(int i, int i2, long j) {
        List<Integer> arrayList = new ArrayList();
        try {
            QueryBuilder queryBuilder = getGoalTrackingEventDao().queryBuilder();
            queryBuilder.where().between("date", Integer.valueOf(i), Integer.valueOf(i2)).and().eq("goalId", Long.valueOf(j));
            queryBuilder.orderBy("date", false);
            queryBuilder.groupBy("date");
            List<GoalTrackingEvent> query = getGoalTrackingEventDao().query(queryBuilder.prepare());
            if (query != null) {
                for (GoalTrackingEvent date : query) {
                    arrayList.add(Integer.valueOf(date.getDate()));
                }
            }
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".getGoalTrackingEvent - e=" + e);
        }
        return arrayList;
    }

    public List<Integer> getGoalTrackingEventDates(long j) {
        List<Integer> arrayList = new ArrayList();
        try {
            QueryBuilder queryBuilder = getGoalTrackingEventDao().queryBuilder();
            queryBuilder.where().eq("goalId", Long.valueOf(j));
            queryBuilder.orderBy("date", false);
            queryBuilder.groupBy("date");
            List<GoalTrackingEvent> query = getGoalTrackingEventDao().query(queryBuilder.prepare());
            if (query != null) {
                for (GoalTrackingEvent date : query) {
                    arrayList.add(Integer.valueOf(date.getDate()));
                }
            }
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".getGoalTrackingEvent - e=" + e);
        }
        return arrayList;
    }

    public void saveGoalTrackingSummary(GoalTrackingSummary goalTrackingSummary) {
        try {
            GoalTrackingSummary goalTrackingSummary2 = getGoalTrackingSummary(goalTrackingSummary.getGoalTracking().id);
            if (goalTrackingSummary2 == null) {
                goalTrackingSummary.setCreatedAt(System.currentTimeMillis());
            } else {
                goalTrackingSummary.setId(goalTrackingSummary2.getId());
                goalTrackingSummary.setGoalTracking(goalTrackingSummary2.getGoalTracking());
                goalTrackingSummary.setCreatedAt(goalTrackingSummary2.getCreatedAt());
                goalTrackingSummary.setUpdatedAt(System.currentTimeMillis());
            }
            getGoalTrackingSummaryDao().createOrUpdate(goalTrackingSummary);
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".saveGoalTrackingSummary - e=" + e);
        }
    }

    public GoalTrackingSummary getGoalTrackingSummary(long j) {
        try {
            QueryBuilder queryBuilder = getGoalTrackingSummaryDao().queryBuilder();
            queryBuilder.where().eq("goalId", Long.valueOf(j));
            List query = getGoalTrackingSummaryDao().query(queryBuilder.prepare());
            if (query != null && query.size() > 0) {
                return (GoalTrackingSummary) query.get(0);
            }
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".getGoalTrackingSummary - e=" + e);
        }
        return null;
    }

    public List<GoalTrackingSummary> getGoalTrackingSummaries(long j, long j2) {
        List<GoalTrackingSummary> arrayList = new ArrayList();
        try {
            QueryBuilder queryBuilder = getGoalTrackingSummaryDao().queryBuilder();
            queryBuilder.where().between("date", Long.valueOf(j), Long.valueOf(j2));
            queryBuilder.orderBy("date", false);
            Collection query = getGoalTrackingSummaryDao().query(queryBuilder.prepare());
            if (query != null) {
                arrayList.addAll(query);
            }
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".getGoalTrackingSummaries - e=" + e);
        }
        return arrayList;
    }

    public List<GoalTrackingSummary> getGoalTrackingSummariesPaging(long j, long j2) {
        List<GoalTrackingSummary> arrayList = new ArrayList();
        try {
            QueryBuilder queryBuilder = getGoalTrackingSummaryDao().queryBuilder();
            queryBuilder.orderBy("date", false);
            queryBuilder.orderBy("updatedAt", false);
            queryBuilder.orderBy("createdAt", false);
            queryBuilder.offset(Long.valueOf(j));
            queryBuilder.limit(Long.valueOf(j2));
            Collection query = getGoalTrackingSummaryDao().query(queryBuilder.prepare());
            if (query != null) {
                arrayList.addAll(query);
            }
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".getGoalTrackingSummariesFromGoalId - e=" + e);
        }
        return arrayList;
    }

    public void deleteGoalTrackingSummary(long j) {
        try {
            DeleteBuilder deleteBuilder = getGoalTrackingSummaryDao().deleteBuilder();
            deleteBuilder.where().eq("goalId", Long.valueOf(j));
            getGoalTrackingSummaryDao().delete(deleteBuilder.prepare());
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".deleteGoalTrackingSummary - e=" + e);
        }
    }

    public void deleteAllGoalPhases(long j) {
        try {
            DeleteBuilder deleteBuilder = getGoalPhaseDao().deleteBuilder();
            deleteBuilder.where().eq("goalId", Long.valueOf(j));
            getGoalPhaseDao().delete(deleteBuilder.prepare());
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".delete all GoalPhase of GoalTracking, id=" + j + " - e=" + e);
        }
    }

    public void disposeGoalTrackingFromDB(String str) {
        GoalTracking goalTrackingsByServerIdIncludeDeleted = getGoalTrackingsByServerIdIncludeDeleted(str);
        if (goalTrackingsByServerIdIncludeDeleted != null) {
            DeleteBuilder deleteBuilder;
            long id = goalTrackingsByServerIdIncludeDeleted.getId();
            try {
                deleteBuilder = getGoalTrackingDao().deleteBuilder();
                deleteBuilder.where().eq("serverId", str);
                getGoalTrackingDao().delete(deleteBuilder.prepare());
            } catch (Exception e) {
                Log.e(this.TAG, "Error inside " + this.TAG + ".dispose GoalTracking (X), serverId=" + str + " - e=" + e);
            }
            try {
                deleteBuilder = getGoalPhaseDao().deleteBuilder();
                deleteBuilder.where().eq("goalId", Long.valueOf(id));
                getGoalPhaseDao().delete(deleteBuilder.prepare());
            } catch (Exception e2) {
                Log.e(this.TAG, "Error inside " + this.TAG + ".dispose GoalTracking Phases (X), serverId=" + str + ", goalId = " + id + " - e=" + e2);
            }
            try {
                deleteBuilder = getGoalTrackingEventDao().deleteBuilder();
                deleteBuilder.where().eq("goalId", Long.valueOf(id));
                getGoalTrackingEventDao().delete(deleteBuilder.prepare());
            } catch (Exception e22) {
                Log.e(this.TAG, "Error inside " + this.TAG + ".dispose GoalTracking Events (X), serverId=" + str + ", goalId = " + id + " - e=" + e22);
            }
            try {
                deleteBuilder = getGoalTrackingSummaryDao().deleteBuilder();
                deleteBuilder.where().eq("goalId", Long.valueOf(id));
                getGoalTrackingSummaryDao().delete(deleteBuilder.prepare());
            } catch (Exception e222) {
                Log.e(this.TAG, "Error inside " + this.TAG + ".dispose GoalTracking Summaries (X), serverId=" + str + ", goalId = " + id + " - e=" + e222);
            }
        }
    }

    public void disposeGoalTrackingFromDB(long j) {
        if (getGoalTrackingsByIdIncludeDeleted(j) != null) {
            DeleteBuilder deleteBuilder;
            try {
                deleteBuilder = getGoalTrackingDao().deleteBuilder();
                deleteBuilder.where().eq("id", Long.valueOf(j));
                getGoalTrackingDao().delete(deleteBuilder.prepare());
            } catch (Exception e) {
                Log.e(this.TAG, "Error inside " + this.TAG + ".dispose GoalTracking (X), goalId=" + j + " - e=" + e);
            }
            try {
                deleteBuilder = getGoalPhaseDao().deleteBuilder();
                deleteBuilder.where().eq("goalId", Long.valueOf(j));
                getGoalPhaseDao().delete(deleteBuilder.prepare());
            } catch (Exception e2) {
                Log.e(this.TAG, "Error inside " + this.TAG + ".dispose GoalTracking Phases (X), goalId = " + j + " - e=" + e2);
            }
            try {
                deleteBuilder = getGoalTrackingEventDao().deleteBuilder();
                deleteBuilder.where().eq("goalId", Long.valueOf(j));
                getGoalTrackingEventDao().delete(deleteBuilder.prepare());
            } catch (Exception e22) {
                Log.e(this.TAG, "Error inside " + this.TAG + ".dispose GoalTracking Events (X), goalId = " + j + " - e=" + e22);
            }
            try {
                deleteBuilder = getGoalTrackingSummaryDao().deleteBuilder();
                deleteBuilder.where().eq("goalId", Long.valueOf(j));
                getGoalTrackingSummaryDao().delete(deleteBuilder.prepare());
            } catch (Exception e222) {
                Log.e(this.TAG, "Error inside " + this.TAG + ".dispose GoalTracking Summaries (X), goalId = " + j + " - e=" + e222);
            }
        }
    }

    public GoalTracking getLatestEndedGoalTracking() {
        GoalPhase goalPhase;
        try {
            QueryBuilder queryBuilder = getGoalPhaseDao().queryBuilder();
            queryBuilder.where().ne("pinType", Integer.valueOf(3));
            queryBuilder.orderBy(GoalPhase.COLUMN_END_DATE, false);
            goalPhase = (GoalPhase) queryBuilder.queryForFirst();
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".get GoalPhase which has latest end.");
            goalPhase = null;
        }
        if (goalPhase != null) {
            return goalPhase.getGoalTracking();
        }
        return null;
    }

    public List<GoalTrackingEvent> getGoalTrackingEventByTrackingTimes(List<Long> list) {
        try {
            QueryBuilder queryBuilder = getGoalTrackingEventDao().queryBuilder();
            queryBuilder.where().in(GoalTrackingEvent.COLUMN_TRACKED_AT, (Iterable) list);
            queryBuilder.orderBy(GoalTrackingEvent.COLUMN_TRACKED_AT, true);
            return queryBuilder.query();
        } catch (SQLException e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".get getGoalTrackingEventByTrackingTimes, e = " + e);
            return new ArrayList();
        }
    }

    public GoalTracking getOldedGoalTracking() {
        try {
            QueryBuilder queryBuilder = getGoalTrackingDao().queryBuilder();
            queryBuilder.where().ne("pinType", Integer.valueOf(3));
            queryBuilder.orderBy("createdAt", true);
            return (GoalTracking) queryBuilder.queryForFirst();
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".getOldedGoalTracking - e=" + e);
            return null;
        }
    }

    public void clearData() {
        try {
            TableUtils.clearTable(this.databaseHelper.getConnectionSource(), GoalTrackingEvent.class);
            TableUtils.clearTable(this.databaseHelper.getConnectionSource(), GoalTrackingSummary.class);
            TableUtils.clearTable(this.databaseHelper.getConnectionSource(), GoalPhase.class);
            TableUtils.clearTable(this.databaseHelper.getConnectionSource(), GoalTracking.class);
        } catch (Exception e) {
            try {
                TableUtils.createTableIfNotExists(this.databaseHelper.getConnectionSource(), GoalTracking.class);
                TableUtils.createTableIfNotExists(this.databaseHelper.getConnectionSource(), GoalPhase.class);
                TableUtils.createTableIfNotExists(this.databaseHelper.getConnectionSource(), GoalTrackingSummary.class);
                TableUtils.createTableIfNotExists(this.databaseHelper.getConnectionSource(), GoalTrackingEvent.class);
            } catch (Exception e2) {
            }
            Log.e(this.TAG, "Failed to clear data");
        }
    }

    public void dropThenCreateTables() {
        try {
            this.databaseHelper.dropTables(getDbEntities());
            TableUtils.createTableIfNotExists(this.databaseHelper.getConnectionSource(), GoalTracking.class);
            TableUtils.createTableIfNotExists(this.databaseHelper.getConnectionSource(), GoalPhase.class);
            TableUtils.createTableIfNotExists(this.databaseHelper.getConnectionSource(), GoalTrackingSummary.class);
            TableUtils.createTableIfNotExists(this.databaseHelper.getConnectionSource(), GoalTrackingEvent.class);
        } catch (Exception e) {
            Log.e(this.TAG, "Failed to drop tables");
        }
    }

    public List<GoalTracking> getPendingGoalTracking() {
        try {
            QueryBuilder queryBuilder = getGoalTrackingDao().queryBuilder();
            queryBuilder.where().ne("pinType", Integer.valueOf(0));
            return getGoalTrackingDao().query(queryBuilder.prepare());
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".getPendingGoalTracking - e=" + e);
            return Collections.emptyList();
        }
    }

    public List<GoalTrackingEvent> getPendingGoalTrackingEvents() {
        try {
            QueryBuilder queryBuilder = getGoalTrackingEventDao().queryBuilder();
            queryBuilder.where().ne("pinType", Integer.valueOf(0));
            return getGoalTrackingEventDao().query(queryBuilder.prepare());
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".getPendingGoalTrackingEvents - e=" + e);
            return Collections.emptyList();
        }
    }

    public void updateGoalTrackingEvent(GoalTrackingEvent goalTrackingEvent) {
        try {
            QueryBuilder queryBuilder = getGoalTrackingEventDao().queryBuilder();
            queryBuilder.where().eq(GoalTrackingEvent.COLUMN_TRACKED_AT, Long.valueOf(goalTrackingEvent.getTrackedAt())).and().eq("goalId", Long.valueOf(goalTrackingEvent.getGoalTracking().getId()));
            if (((GoalTrackingEvent) getGoalTrackingEventDao().queryForFirst(queryBuilder.prepare())) != null) {
                getGoalTrackingEventDao().update((Object) goalTrackingEvent);
            }
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".updateGoalTrackingEvent - e=" + e);
        }
    }

    public GoalTracking getGoalTrackingsByServerIdIncludeDeleted(String str) {
        try {
            QueryBuilder queryBuilder = getGoalTrackingDao().queryBuilder();
            queryBuilder.where().eq("serverId", str);
            List query = getGoalTrackingDao().query(queryBuilder.prepare());
            if (query != null && query.size() > 0) {
                return (GoalTracking) query.get(0);
            }
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".getGoalTrackingByServerId - e=" + e);
        }
        return null;
    }

    public GoalTracking getGoalTrackingsByIdIncludeDeleted(long j) {
        try {
            QueryBuilder queryBuilder = getGoalTrackingDao().queryBuilder();
            queryBuilder.where().eq("id", Long.valueOf(j));
            List query = getGoalTrackingDao().query(queryBuilder.prepare());
            if (query != null && query.size() > 0) {
                return (GoalTracking) query.get(0);
            }
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".getGoalTrackingByServerId - e=" + e);
        }
        return null;
    }
}
