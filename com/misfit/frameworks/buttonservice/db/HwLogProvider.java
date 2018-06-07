package com.misfit.frameworks.buttonservice.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.misfit.frameworks.common.log.MFLogger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HwLogProvider extends BaseDbProvider {
    public static final String DB_NAME = "hw_log.db";
    private static HwLogProvider sInstance;

    class C47101 extends HashMap<Integer, UpgradeCommand> {

        class C47091 implements UpgradeCommand {
            C47091() {
            }

            public void execute(SQLiteDatabase sQLiteDatabase) {
                sQLiteDatabase.execSQL("ALTER TABLE hardwarelog ADD COLUMN read INTEGER");
            }
        }

        C47101() {
            put(Integer.valueOf(2), new C47091());
        }
    }

    public static synchronized HwLogProvider getInstance(Context context) {
        HwLogProvider hwLogProvider;
        synchronized (HwLogProvider.class) {
            if (sInstance == null) {
                sInstance = new HwLogProvider(context, DB_NAME);
            }
            hwLogProvider = sInstance;
        }
        return hwLogProvider;
    }

    protected HwLogProvider(Context context, String str) {
        super(context, str);
    }

    protected int getDbVersion() {
        return 2;
    }

    protected Class<?>[] getDbEntities() {
        return new Class[]{HardwareLog.class};
    }

    protected Map<Integer, UpgradeCommand> getDbUpgrades() {
        return new C47101();
    }

    private Dao<HardwareLog, String> getHardwareLogDao() throws SQLException {
        return this.databaseHelper.getDao(HardwareLog.class);
    }

    protected void saveHwLog(HardwareLog hardwareLog) {
        try {
            getHardwareLogDao().create((Object) hardwareLog);
        } catch (Exception e) {
            MFLogger.e(this.TAG, "Error inside " + this.TAG + ".saveHwLog - e=" + e);
        }
    }

    public HardwareLog getHardwareLog(String str) {
        try {
            QueryBuilder queryBuilder = getHardwareLogDao().queryBuilder();
            queryBuilder.where().eq("serial", str);
            return (HardwareLog) getHardwareLogDao().queryForFirst(queryBuilder.prepare());
        } catch (Exception e) {
            MFLogger.e(this.TAG, "Error inside " + this.TAG + ".getHardwareLog - =e" + e);
            return null;
        }
    }

    public List<HardwareLog> getAllHardwareLogs() {
        List<HardwareLog> arrayList = new ArrayList();
        try {
            QueryBuilder queryBuilder = getHardwareLogDao().queryBuilder();
            queryBuilder.where().eq(HardwareLog.COLUMN_READ, Boolean.valueOf(false));
            Collection query = getHardwareLogDao().query(queryBuilder.prepare());
            if (query != null) {
                arrayList.addAll(query);
            }
        } catch (Exception e) {
            MFLogger.e(this.TAG, "Error inside " + this.TAG + ".getAllHardwareLogs - e=" + e);
        }
        return arrayList;
    }

    public List<HardwareLog> getAllHardwareLogs(String str) {
        List<HardwareLog> arrayList = new ArrayList();
        try {
            QueryBuilder queryBuilder = getHardwareLogDao().queryBuilder();
            queryBuilder.where().lt("serial", str);
            Collection query = getHardwareLogDao().query(queryBuilder.prepare());
            if (query != null) {
                arrayList.addAll(query);
            }
        } catch (Exception e) {
            MFLogger.e(this.TAG, "Error inside " + this.TAG + ".getAllHardwareLogs - e=" + e);
        }
        return arrayList;
    }

    public void clearHwLog() {
        try {
            MFLogger.i(this.TAG, "Inside " + this.TAG + ".clearHwLog");
            getHardwareLogDao().deleteBuilder().delete();
        } catch (Exception e) {
            MFLogger.e(this.TAG, "Error inside " + this.TAG + ".clearHwLog - e=" + e);
        }
    }

    public void setHardwareLogRead() {
        try {
            MFLogger.i(this.TAG, "Inside " + this.TAG + ".setHardwareLogRead");
            UpdateBuilder updateBuilder = getHardwareLogDao().updateBuilder();
            updateBuilder.updateColumnValue(HardwareLog.COLUMN_READ, Boolean.valueOf(true));
            updateBuilder.update();
        } catch (Exception e) {
            MFLogger.e(this.TAG, "Error inside " + this.TAG + ".setHardwareLogRead - e=" + e);
        }
    }
}
