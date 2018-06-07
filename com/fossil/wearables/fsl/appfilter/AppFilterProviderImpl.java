package com.fossil.wearables.fsl.appfilter;

import android.content.Context;
import android.util.Log;
import com.fossil.wearables.fsl.shared.BaseDbProvider;
import com.fossil.wearables.fsl.shared.BaseFeatureModel;
import com.fossil.wearables.fsl.shared.UpgradeCommand;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AppFilterProviderImpl extends BaseDbProvider implements AppFilterProvider {
    public static final String DB_NAME = "appfilter.db";

    public AppFilterProviderImpl(Context context, String str) {
        super(context, str);
    }

    protected int getDbVersion() {
        return 4;
    }

    protected Class<?>[] getDbEntities() {
        return new Class[]{AppFilter.class};
    }

    protected Map<Integer, UpgradeCommand> getDbUpgrades() {
        return null;
    }

    protected Dao<AppFilter, Integer> getAppFilterDao() throws SQLException {
        return this.databaseHelper.getDao(AppFilter.class);
    }

    public List<AppFilter> getAllAppFilters() {
        List<AppFilter> arrayList = new ArrayList();
        try {
            arrayList = getAppFilterDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public List<AppFilter> getAllAppFilters(int i) {
        List<AppFilter> arrayList = new ArrayList();
        try {
            arrayList = getAppFilterDao().queryForEq("deviceFamily", Integer.valueOf(i));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public AppFilter getAppFilter(int i) {
        try {
            return (AppFilter) getAppFilterDao().queryForId(Integer.valueOf(i));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public AppFilter getAppFilterMatchingType(String str) {
        try {
            QueryBuilder queryBuilder = getAppFilterDao().queryBuilder();
            queryBuilder.where().eq("type", str).and().eq(BaseFeatureModel.COLUMN_ENABLED, Boolean.valueOf(true));
            List query = getAppFilterDao().query(queryBuilder.prepare());
            if (query != null && query.size() > 0) {
                return (AppFilter) query.get(0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public AppFilter getAppFilterMatchingType(String str, int i) {
        try {
            QueryBuilder queryBuilder = getAppFilterDao().queryBuilder();
            queryBuilder.where().eq("deviceFamily", Integer.valueOf(i)).and().eq("type", str).and().eq(BaseFeatureModel.COLUMN_ENABLED, Boolean.valueOf(true));
            List query = getAppFilterDao().query(queryBuilder.prepare());
            if (query != null && query.size() > 0) {
                return (AppFilter) query.get(0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void clearAppFilterTable() {
        try {
            TableUtils.clearTable(getAppFilterDao().getConnectionSource(), AppFilter.class);
        } catch (Exception e) {
            Log.e(this.TAG, "clearAppFilterTable Exception=" + e);
        }
    }

    public void removeAppFilter(AppFilter appFilter) {
        if (appFilter != null) {
            try {
                getAppFilterDao().delete((Object) appFilter);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<AppFilter> getAllAppFiltersWithHour(int i, int i2) {
        try {
            QueryBuilder queryBuilder = getAppFilterDao().queryBuilder();
            queryBuilder.where().eq(AppFilter.COLUMN_HOUR, Integer.valueOf(i)).and().eq("deviceFamily", Integer.valueOf(i2));
            return queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public List<AppFilter> getAllAppFilterVibration(int i) {
        try {
            QueryBuilder queryBuilder = getAppFilterDao().queryBuilder();
            queryBuilder.where().eq(AppFilter.COLUMN_IS_VIBRATION_ONLY, Boolean.valueOf(true)).and().eq("deviceFamily", Integer.valueOf(i));
            return queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public void saveAppFilter(AppFilter appFilter) {
        if (appFilter != null) {
            try {
                QueryBuilder queryBuilder = getAppFilterDao().queryBuilder();
                queryBuilder.where().eq("type", appFilter.getType()).and().eq("deviceFamily", Integer.valueOf(appFilter.getDeviceFamily()));
                List query = getAppFilterDao().query(queryBuilder.prepare());
                if (query != null && query.size() > 0) {
                    AppFilter appFilter2 = (AppFilter) query.get(0);
                    if (appFilter2 != null) {
                        appFilter.setDbRowId(appFilter2.getDbRowId());
                    }
                }
                getAppFilterDao().createOrUpdate(appFilter);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void removeAllAppFilters() {
        for (AppFilter removeAppFilter : getAllAppFilters()) {
            removeAppFilter(removeAppFilter);
        }
    }

    public String getDbPath() {
        return this.databaseHelper.getDbPath();
    }
}
