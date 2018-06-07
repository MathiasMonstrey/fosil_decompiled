package com.fossil.wearables.fsl.countdown;

import android.content.Context;
import android.util.Log;
import com.fossil.wearables.fsl.shared.BaseDbProvider;
import com.fossil.wearables.fsl.shared.UpgradeCommand;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountDownProviderImpl extends BaseDbProvider implements CountDownProvider {
    public static final String DB_NAME = "countdown.db";

    class C41771 extends HashMap<Integer, UpgradeCommand> {
        C41771() {
        }
    }

    public CountDownProviderImpl(Context context, String str) {
        super(context, str);
    }

    protected int getDbVersion() {
        return 1;
    }

    protected Class<?>[] getDbEntities() {
        return new Class[]{CountDown.class};
    }

    protected Map<Integer, UpgradeCommand> getDbUpgrades() {
        return new C41771();
    }

    private Dao<CountDown, Long> getCountDownDao() throws SQLException {
        return this.databaseHelper.getDao(CountDown.class);
    }

    public void saveCountDown(CountDown countDown) {
        try {
            CountDown countDownByClientId = getCountDownByClientId(countDown.getUri());
            if (countDownByClientId != null) {
                countDown.setUpdatedAt(System.currentTimeMillis());
                countDown.setId(countDownByClientId.getId());
            } else {
                countDown.setCreatedAt(System.currentTimeMillis());
            }
            getCountDownDao().createOrUpdate(countDown);
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".saveCountDown - e=" + e);
        }
    }

    public CountDown getActiveCountDown() {
        try {
            QueryBuilder queryBuilder = getCountDownDao().queryBuilder();
            queryBuilder.where().eq("status", Integer.valueOf(CountDownStatus.ACTIVE.getValue()));
            return (CountDown) getCountDownDao().queryForFirst(queryBuilder.prepare());
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".getActiveCountDown - e=" + e);
            return null;
        }
    }

    public void setCountDownStatus(String str, CountDownStatus countDownStatus) {
        try {
            CountDown countDownByClientId = getCountDownByClientId(str);
            if (countDownByClientId != null) {
                countDownByClientId.setStatus(countDownStatus);
                saveCountDown(countDownByClientId);
            }
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".setCountDownStatus - e=" + e);
        }
    }

    public CountDown getCountDownById(long j) {
        try {
            QueryBuilder queryBuilder = getCountDownDao().queryBuilder();
            queryBuilder.where().eq("id", Long.valueOf(j));
            return (CountDown) getCountDownDao().queryForFirst(queryBuilder.prepare());
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".getCountDownByClientId - e=" + e);
            return null;
        }
    }

    public CountDown getCountDownByClientId(String str) {
        try {
            QueryBuilder queryBuilder = getCountDownDao().queryBuilder();
            queryBuilder.where().eq("uri", str);
            return (CountDown) getCountDownDao().queryForFirst(queryBuilder.prepare());
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".getCountDownByClientId - e=" + e);
            return null;
        }
    }

    public CountDown getCountDown(String str, long j) {
        try {
            QueryBuilder queryBuilder = getCountDownDao().queryBuilder();
            queryBuilder.where().eq("name", str).and().eq(CountDown.COLUMN_ENDED_AT, Long.valueOf(j));
            return (CountDown) getCountDownDao().queryForFirst(queryBuilder.prepare());
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".getCountDown - e=" + e);
            return null;
        }
    }

    public CountDown getCountDownByServerId(String str) {
        try {
            QueryBuilder queryBuilder = getCountDownDao().queryBuilder();
            queryBuilder.where().eq("serverId", str);
            return (CountDown) getCountDownDao().queryForFirst(queryBuilder.prepare());
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".getCountDown - e=" + e);
            return null;
        }
    }

    public List<CountDown> getCountDownsByStatus(int i) {
        List<CountDown> arrayList = new ArrayList();
        try {
            QueryBuilder queryBuilder = getCountDownDao().queryBuilder();
            queryBuilder.orderBy("updatedAt", false);
            queryBuilder.orderBy("createdAt", false);
            queryBuilder.where().eq("status", Integer.valueOf(i));
            Collection query = getCountDownDao().query(queryBuilder.prepare());
            if (query != null) {
                arrayList.addAll(query);
            }
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".getPastCountDownsPaging - e=" + e);
        }
        return arrayList;
    }

    public List<CountDown> getPastCountDownsPaging(long j, long j2) {
        List<CountDown> arrayList = new ArrayList();
        try {
            QueryBuilder queryBuilder = getCountDownDao().queryBuilder();
            queryBuilder.where().eq("status", Integer.valueOf(CountDownStatus.COMPLETED.getValue())).or().eq("status", Integer.valueOf(CountDownStatus.INACTIVE.getValue()));
            queryBuilder.orderBy("updatedAt", false);
            queryBuilder.orderBy("createdAt", false);
            queryBuilder.offset(Long.valueOf(j));
            queryBuilder.limit(Long.valueOf(j2));
            Collection query = getCountDownDao().query(queryBuilder.prepare());
            if (query != null) {
                arrayList.addAll(query);
            }
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".getPastCountDownsPaging - e=" + e);
        }
        return arrayList;
    }

    public List<CountDown> getAllCountDown() {
        try {
            return getCountDownDao().queryForAll();
        } catch (Exception e) {
            return null;
        }
    }

    public void deleteCountDown(String str) {
        try {
            DeleteBuilder deleteBuilder = getCountDownDao().deleteBuilder();
            deleteBuilder.where().eq("uri", str);
            getCountDownDao().delete(deleteBuilder.prepare());
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".deleteCountDown - e=" + e);
        }
    }

    public void deleteCountDown(long j) {
        try {
            DeleteBuilder deleteBuilder = getCountDownDao().deleteBuilder();
            deleteBuilder.where().eq("id", Long.valueOf(j));
            getCountDownDao().delete(deleteBuilder.prepare());
        } catch (Exception e) {
            Log.e(this.TAG, "Error inside " + this.TAG + ".deleteCountDown - e=" + e);
        }
    }

    public void clearData() {
        try {
            TableUtils.clearTable(this.databaseHelper.getConnectionSource(), CountDown.class);
        } catch (Exception e) {
            try {
                TableUtils.createTableIfNotExists(this.databaseHelper.getConnectionSource(), CountDown.class);
            } catch (Exception e2) {
            }
            Log.e(this.TAG, "Failed to clear data");
        }
    }

    public void dropThenCreateTables() {
        try {
            this.databaseHelper.dropTables(getDbEntities());
            TableUtils.createTableIfNotExists(this.databaseHelper.getConnectionSource(), CountDown.class);
        } catch (Exception e) {
            Log.e(this.TAG, "Failed to drop tables");
        }
    }
}
