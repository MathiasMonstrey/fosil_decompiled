package com.fossil.wearables.fsl.history;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.fossil.wearables.fsl.shared.BaseDbProvider;
import com.fossil.wearables.fsl.shared.BaseModel;
import com.fossil.wearables.fsl.shared.UpgradeCommand;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistoryProviderImpl extends BaseDbProvider implements HistoryProvider {
    public static final String DB_NAME = "history.db";

    class C41891 extends HashMap<Integer, UpgradeCommand> {

        class C41881 implements UpgradeCommand {
            C41881() {
            }

            public void execute(SQLiteDatabase sQLiteDatabase) {
                try {
                    HistoryProviderImpl.this.databaseHelper.dropTables(HistoryProviderImpl.this.getDbEntities());
                    HistoryProviderImpl.this.databaseHelper.createTables(HistoryProviderImpl.this.getDbEntities());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        C41891() {
            put(Integer.valueOf(2), new C41881());
        }
    }

    protected int getDbVersion() {
        return 2;
    }

    protected Class<?>[] getDbEntities() {
        return new Class[]{HistoryItem.class};
    }

    protected Map<Integer, UpgradeCommand> getDbUpgrades() {
        return new C41891();
    }

    private Dao<HistoryItem, Integer> getHistoryItemDao() throws SQLException {
        return this.databaseHelper.getDao(HistoryItem.class);
    }

    public HistoryProviderImpl(Context context, String str) {
        super(context, str);
    }

    public void saveItem(HistoryItem historyItem) {
        if (historyItem != null) {
            Log.d(this.TAG, "Trying to save history item item " + historyItem.getType());
            try {
                Object queryForSameId = getHistoryItemDao().queryForSameId(historyItem);
                if (queryForSameId != null) {
                    try {
                        historyItem.setDbRowId(((BaseModel) queryForSameId).getDbRowId());
                    } catch (ClassCastException e) {
                        Log.w(this.TAG, "Could not check if id exists. Trying ref...");
                        try {
                            Field declaredField = queryForSameId.getClass().getDeclaredField("dbRowId");
                            declaredField.setAccessible(true);
                            historyItem.setDbRowId(declaredField.getInt(queryForSameId));
                        } catch (Exception e2) {
                            Log.e(this.TAG, "Reflection failed! " + e.getMessage());
                        }
                    }
                }
                getHistoryItemDao().createOrUpdate(historyItem);
                return;
            } catch (SQLException e3) {
                Log.e(this.TAG, "Error saving history item: " + e3.getMessage());
                e3.printStackTrace();
                return;
            }
        }
        Log.e(this.TAG, "Cannot save a null history item!");
    }

    public List<HistoryItem> getLatestItems(long j) {
        List<HistoryItem> arrayList = new ArrayList();
        try {
            QueryBuilder queryBuilder = getHistoryItemDao().queryBuilder();
            queryBuilder.limit(Long.valueOf(j));
            queryBuilder.orderBy("timestamp", false);
            arrayList = getHistoryItemDao().query(queryBuilder.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public List<HistoryItem> getAllItems() {
        List<HistoryItem> arrayList = new ArrayList();
        try {
            arrayList = getHistoryItemDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public List<HistoryItem> getItems(Calendar calendar) {
        List<HistoryItem> arrayList = new ArrayList();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        calendar.add(5, 1);
        calendar.add(14, -1);
        long timeInMillis2 = calendar.getTimeInMillis();
        try {
            QueryBuilder queryBuilder = getHistoryItemDao().queryBuilder();
            queryBuilder.where().ge("timestamp", Long.valueOf(timeInMillis)).and().le("timestamp", Long.valueOf(timeInMillis2));
            arrayList.addAll(getHistoryItemDao().query(queryBuilder.prepare()));
        } catch (Exception e) {
            Log.w(this.TAG, "Something bad happened " + e.getMessage());
        }
        return arrayList;
    }

    public void removeAllItems() {
        removeItems(getAllItems());
    }

    public void removeItems(List<HistoryItem> list) {
        if (list != null && list.size() > 0) {
            try {
                getHistoryItemDao().delete((Collection) list);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void removeItem(HistoryItem historyItem) {
        if (historyItem != null) {
            try {
                getHistoryItemDao().delete((Object) historyItem);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
