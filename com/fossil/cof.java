package com.fossil;

import android.content.Context;
import android.util.Log;
import com.fossil.wearables.fsl.shared.BaseDbProvider;
import com.fossil.wearables.fsl.shared.UpgradeCommand;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.table.TableUtils;
import com.misfit.frameworks.buttonservice.model.Alarm;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.provider.AlarmProviderImp.1;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class cof extends BaseDbProvider implements coe {
    private static final String TAG = cof.class.getSimpleName();

    public cof(Context context, String str) {
        super(context, str);
    }

    protected int getDbVersion() {
        return 4;
    }

    protected Class<?>[] getDbEntities() {
        return new Class[]{Alarm.class};
    }

    private Dao<Alarm, Integer> adH() throws SQLException {
        return this.databaseHelper.getDao(Alarm.class);
    }

    protected Map<Integer, UpgradeCommand> getDbUpgrades() {
        return new 1(this);
    }

    public void mo1916d(Alarm alarm) {
        if (alarm != null) {
            try {
                adH().createOrUpdate(alarm);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                MFLogger.m12671e(TAG, "addOrUpdateAlarm - e" + e);
                return;
            }
        }
        MFLogger.m12672i(TAG, "addOrUpdateAlarm - ALARM=NULL!!!");
    }

    public List<Alarm> adE() {
        List<Alarm> arrayList = new ArrayList();
        try {
            arrayList = adH().queryBuilder().orderBy("isActiveAlarm", false).orderBy(Alarm.COLUMN_ALARM_MINUTE, true).query();
        } catch (Exception e) {
            e.printStackTrace();
            MFLogger.m12671e(TAG, "getAllAlarm - e=" + e);
        }
        return arrayList;
    }

    public List<Alarm> jL(int i) {
        MFLogger.m12670d(TAG, "getAlarmsIgnorePinType - pinType=" + i);
        List<Alarm> arrayList = new ArrayList();
        try {
            QueryBuilder orderBy = adH().queryBuilder().orderBy("isActiveAlarm", false).orderBy(Alarm.COLUMN_ALARM_MINUTE, true);
            orderBy.where().ne("pinType", Integer.valueOf(i));
            arrayList = orderBy.query();
        } catch (Exception e) {
            e.printStackTrace();
            MFLogger.m12671e(TAG, "getAlarmsIgnorePinType - e=" + e);
        }
        return arrayList;
    }

    public void gZ(String str) {
        MFLogger.m12670d(TAG, "removeAlarm - id=" + str);
        try {
            DeleteBuilder deleteBuilder = adH().deleteBuilder();
            deleteBuilder.where().eq("uri", str);
            deleteBuilder.delete();
        } catch (Exception e) {
            e.printStackTrace();
            MFLogger.m12671e(TAG, "removeAlarm - e=" + e);
        }
    }

    public Alarm findAlarm(String str) {
        MFLogger.m12670d(TAG, "findAlarm - id=" + str);
        try {
            QueryBuilder queryBuilder = adH().queryBuilder();
            queryBuilder.where().eq("uri", str);
            return (Alarm) queryBuilder.queryForFirst();
        } catch (Exception e) {
            e.printStackTrace();
            MFLogger.m12670d(TAG, "findAlarm - e=" + e);
            return null;
        }
    }

    public Alarm adF() {
        try {
            Calendar instance = Calendar.getInstance();
            int i = (instance.get(11) * 60) + instance.get(12);
            QueryBuilder orderBy = adH().queryBuilder().orderBy(Alarm.COLUMN_ALARM_MINUTE, true);
            orderBy.where().eq("isActiveAlarm", Boolean.valueOf(true));
            List<Alarm> query = orderBy.query();
            if (!(query == null || query.isEmpty())) {
                for (Alarm alarm : query) {
                    if (alarm.getAlarmMinute() > i) {
                        return alarm;
                    }
                }
                return (Alarm) query.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            MFLogger.m12670d(TAG, "findNextActiveAlarm - e=" + e);
        }
        return null;
    }

    public List<Alarm> adG() {
        try {
            QueryBuilder orderBy = adH().queryBuilder().orderBy(Alarm.COLUMN_ALARM_MINUTE, true);
            orderBy.where().eq("isActiveAlarm", Boolean.valueOf(true)).and().ne("pinType", Integer.valueOf(3));
            return orderBy.query();
        } catch (Exception e) {
            e.printStackTrace();
            MFLogger.m12670d(TAG, "getActiveAlarms - e=" + e);
            return null;
        }
    }

    public void cleanUp() {
        MFLogger.m12671e(TAG, "cleanUp alarm db");
        try {
            TableUtils.clearTable(adH().getConnectionSource(), Alarm.class);
        } catch (Exception e) {
            Log.e(TAG, "cleanUp alarm db Exception=" + e);
        }
    }

    public String getDbPath() {
        return this.databaseHelper.getDbPath();
    }
}
