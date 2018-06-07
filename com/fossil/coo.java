package com.fossil;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.fossil.wearables.fsl.appfilter.AppFilter;
import com.fossil.wearables.fsl.appfilter.AppFilterProviderImpl;
import com.fossil.wearables.fsl.shared.BaseFeatureModel;
import com.fossil.wearables.fsl.shared.UpgradeCommand;
import com.misfit.frameworks.buttonservice.enums.MFDeviceFamily;
import com.misfit.frameworks.buttonservice.utils.DeviceIdentityUtils;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.helper.DeviceHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class coo extends AppFilterProviderImpl {
    public static final String TAG = coo.class.getSimpleName();
    private final String cBf = "appfilter";

    class C22601 implements UpgradeCommand {
        final /* synthetic */ coo cBg;

        C22601(coo com_fossil_coo) {
            this.cBg = com_fossil_coo;
        }

        public void execute(SQLiteDatabase sQLiteDatabase) {
            MFLogger.m12670d(coo.TAG, " ---- UPGRADE DB APPFILTER, table APPFILTER");
            sQLiteDatabase.execSQL("ALTER TABLE appfilter ADD COLUMN deviceFamily int");
            MFLogger.m12670d(coo.TAG, " ---- UPGRADE DB APPFILTER, table APPFILTER SUCCESS");
            StringBuilder stringBuilder = new StringBuilder();
            Object aaa = PortfolioApp.ZQ().aaa();
            if (TextUtils.isEmpty(aaa)) {
                this.cBg.removeAllAppFilters();
                return;
            }
            stringBuilder.append("UPDATE ").append("appfilter").append(" SET deviceFamily = ").append(DeviceIdentityUtils.getDeviceFamily(aaa).ordinal());
            sQLiteDatabase.execSQL(stringBuilder.toString());
        }
    }

    class C22612 implements UpgradeCommand {
        final /* synthetic */ coo cBg;

        C22612(coo com_fossil_coo) {
            this.cBg = com_fossil_coo;
        }

        public void execute(SQLiteDatabase sQLiteDatabase) {
            try {
                int i;
                MFLogger.m12670d(coo.TAG, "Inside .doInBackground upgrade appfilter");
                Cursor query = sQLiteDatabase.query(true, "appfilter", new String[]{"id", "type", BaseFeatureModel.COLUMN_COLOR, "name", BaseFeatureModel.COLUMN_HAPTIC, "timestamp", BaseFeatureModel.COLUMN_ENABLED, "deviceFamily"}, null, null, null, null, null, null);
                List<AppFilter> arrayList = new ArrayList();
                String aaa = PortfolioApp.ZQ().aaa();
                if (TextUtils.isEmpty(aaa)) {
                    i = -1;
                } else {
                    i = DeviceHelper.getDeviceFamily(aaa).getValue();
                }
                if (query != null && i > 0 && DeviceHelper.gf(aaa)) {
                    query.moveToFirst();
                    while (!query.isAfterLast()) {
                        aaa = query.getString(query.getColumnIndex("type"));
                        String string = query.getString(query.getColumnIndex(BaseFeatureModel.COLUMN_COLOR));
                        String string2 = query.getString(query.getColumnIndex("name"));
                        String string3 = query.getString(query.getColumnIndex(BaseFeatureModel.COLUMN_HAPTIC));
                        int i2 = query.getInt(query.getColumnIndex("timestamp"));
                        int i3 = query.getInt(query.getColumnIndex(BaseFeatureModel.COLUMN_ENABLED));
                        int i4 = query.getInt(query.getColumnIndex("deviceFamily"));
                        int i5 = query.getInt(query.getColumnIndex("id"));
                        if (i4 == i) {
                            AppFilter appFilter = new AppFilter();
                            appFilter.setType(aaa);
                            appFilter.setColor(string);
                            appFilter.setName(string2);
                            appFilter.setHaptic(string3);
                            appFilter.setTimestamp((long) i2);
                            appFilter.setEnabled(i3 == 1);
                            appFilter.setDeviceFamily(i4);
                            appFilter.setDbRowId(i5);
                            cos aA = cnq.acd().acy().aA(aaa, MFDeviceFamily.fromInt(appFilter.getDeviceFamily()).toString());
                            if (aA != null) {
                                appFilter.setHour(aA.getHour());
                                appFilter.setVibrationOnly(aA.isVibrationOnly());
                            }
                            MFLogger.m12670d(coo.TAG, "Add appfiler=" + appFilter);
                            if (!appFilter.isVibrationOnly()) {
                                arrayList.add(appFilter);
                            }
                        } else {
                            MFLogger.m12670d(coo.TAG, "Skip this app filter");
                        }
                        query.moveToNext();
                    }
                    query.close();
                }
                sQLiteDatabase.execSQL("CREATE TABLE appfilter_copy (id INTEGER PRIMARY KEY AUTOINCREMENT, type VARCHAR, color VARCHAR, haptic VARCHAR, timestamp BIGINT, enabled INTEGER, name VARCHAR, isVibrationOnly INTEGER, deviceFamily INTEGER, hour INTEGER);");
                if (!arrayList.isEmpty()) {
                    for (AppFilter appFilter2 : arrayList) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(BaseFeatureModel.COLUMN_COLOR, appFilter2.getColor());
                        contentValues.put(BaseFeatureModel.COLUMN_HAPTIC, appFilter2.getHaptic());
                        contentValues.put("timestamp", Long.valueOf(appFilter2.getTimestamp()));
                        contentValues.put("name", appFilter2.getName());
                        contentValues.put(BaseFeatureModel.COLUMN_ENABLED, Boolean.valueOf(appFilter2.isEnabled()));
                        contentValues.put("type", appFilter2.getType());
                        contentValues.put("id", Integer.valueOf(appFilter2.getDbRowId()));
                        contentValues.put(AppFilter.COLUMN_IS_VIBRATION_ONLY, Boolean.valueOf(appFilter2.isVibrationOnly()));
                        contentValues.put("deviceFamily", Integer.valueOf(MFDeviceFamily.DEVICE_FAMILY_SAM.getValue()));
                        contentValues.put(AppFilter.COLUMN_HOUR, Integer.valueOf(appFilter2.getHour()));
                        sQLiteDatabase.insert("appfilter_copy", null, contentValues);
                    }
                }
                sQLiteDatabase.execSQL("DROP TABLE appfilter;");
                sQLiteDatabase.execSQL("ALTER TABLE appfilter_copy RENAME TO appfilter;");
                MFLogger.m12670d(coo.TAG, "Migration complete");
            } catch (Exception e) {
                MFLogger.m12671e(coo.TAG, "Error inside " + coo.TAG + ".upgrade - e=" + e);
            }
        }
    }

    public coo(Context context, String str) {
        super(context, str);
    }

    protected Map<Integer, UpgradeCommand> getDbUpgrades() {
        Map<Integer, UpgradeCommand> dbUpgrades = super.getDbUpgrades();
        if (dbUpgrades == null) {
            dbUpgrades = new HashMap();
        }
        dbUpgrades.put(Integer.valueOf(2), new C22601(this));
        dbUpgrades.put(Integer.valueOf(4), new C22612(this));
        return dbUpgrades;
    }

    public String getDbPath() {
        return this.databaseHelper.getDbPath();
    }
}
