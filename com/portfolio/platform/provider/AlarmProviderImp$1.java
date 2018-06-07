package com.portfolio.platform.provider;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.fossil.cmq;
import com.fossil.cof;
import com.fossil.wearables.fsl.shared.UpgradeCommand;
import com.misfit.frameworks.buttonservice.model.Alarm;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;

public class AlarmProviderImp$1 extends HashMap<Integer, UpgradeCommand> {
    final /* synthetic */ cof this$0;

    class C48951 implements UpgradeCommand {
        final /* synthetic */ AlarmProviderImp$1 cBd;

        C48951(AlarmProviderImp$1 alarmProviderImp$1) {
            this.cBd = alarmProviderImp$1;
        }

        public void execute(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE " + Alarm.TABLE_NAME + " ADD COLUMN " + Alarm.COLUMN_DAYS + " VARCHAR;");
                Cursor query = sQLiteDatabase.query(true, Alarm.TABLE_NAME, new String[]{"objectId", "updatedAt", "createdAt", Alarm.COLUMN_ALARM_TITLE, Alarm.COLUMN_ALARM_MINUTE, "isActiveAlarm", Alarm.COLUMN_IS_REPEAT_ALARM, "uri"}, null, null, null, null, null, null);
                MFLogger.i(cof.access$000(), "getDbUpgrades - cursor size=" + (query != null ? query.getCount() : 0));
                if (query != null) {
                    query.moveToFirst();
                    while (!query.isAfterLast()) {
                        Object obj;
                        int[] iArr;
                        if (query.getInt(query.getColumnIndex(Alarm.COLUMN_IS_REPEAT_ALARM)) == 1) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        String string = query.getString(query.getColumnIndex("uri"));
                        if (obj != null) {
                            iArr = new int[]{1, 2, 3, 4, 5, 6, 7};
                        } else {
                            iArr = null;
                        }
                        sQLiteDatabase.execSQL("UPDATE " + Alarm.TABLE_NAME + " SET " + Alarm.COLUMN_DAYS + " = \"" + Arrays.toString(iArr) + "\" , " + "updatedAt" + " = \"" + cmq.i(Calendar.getInstance().getTime()) + "\" WHERE " + "uri" + " == \"" + string + "\"");
                        query.moveToNext();
                    }
                    query.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                MFLogger.e(cof.access$000(), "getDbUpgrades - e=" + e.toString());
            }
        }
    }

    class C48962 implements UpgradeCommand {
        final /* synthetic */ AlarmProviderImp$1 cBd;

        C48962(AlarmProviderImp$1 alarmProviderImp$1) {
            this.cBd = alarmProviderImp$1;
        }

        public void execute(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE " + Alarm.TABLE_NAME + " ADD COLUMN " + Alarm.COLUMN_DAYS + " VARCHAR;");
                Cursor query = sQLiteDatabase.query(true, Alarm.TABLE_NAME, new String[]{"objectId", "updatedAt", "createdAt", Alarm.COLUMN_ALARM_TITLE, Alarm.COLUMN_ALARM_MINUTE, "isActiveAlarm", Alarm.COLUMN_IS_REPEAT_ALARM, "uri"}, null, null, null, null, null, null);
                MFLogger.e(cof.access$000(), ".getDbUpgrades - cursor size=" + (query != null ? query.getCount() : 0));
                if (query != null) {
                    query.moveToFirst();
                    while (!query.isAfterLast()) {
                        Object obj;
                        int[] iArr;
                        if (query.getInt(query.getColumnIndex(Alarm.COLUMN_IS_REPEAT_ALARM)) == 1) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        String string = query.getString(query.getColumnIndex("uri"));
                        if (obj != null) {
                            iArr = new int[]{1, 2, 3, 4, 5, 6, 7};
                        } else {
                            iArr = null;
                        }
                        sQLiteDatabase.execSQL("UPDATE " + Alarm.TABLE_NAME + " SET " + Alarm.COLUMN_DAYS + " = \"" + Arrays.toString(iArr) + "\" , " + "updatedAt" + " = \"" + cmq.i(Calendar.getInstance().getTime()) + "\" WHERE " + "uri" + " == \"" + string + "\"");
                        query.moveToNext();
                    }
                    query.close();
                }
            } catch (Exception e) {
                MFLogger.e(cof.access$000(), ".getDbUpgrades - ex=" + e.toString());
            }
        }
    }

    class C48973 implements UpgradeCommand {
        final /* synthetic */ AlarmProviderImp$1 cBd;

        C48973(AlarmProviderImp$1 alarmProviderImp$1) {
            this.cBd = alarmProviderImp$1;
        }

        public void execute(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE " + Alarm.TABLE_NAME + " ADD COLUMN " + "pinType" + " INTEGER;");
                Cursor query = sQLiteDatabase.query(true, Alarm.TABLE_NAME, new String[]{Alarm.COLUMN_ALARM_TITLE, Alarm.COLUMN_ALARM_MINUTE, "createdAt", "updatedAt", Alarm.COLUMN_DAYS, "isActiveAlarm", Alarm.COLUMN_IS_REPEAT_ALARM, "objectId", "uri"}, null, null, null, null, null, null);
                MFLogger.i(cof.access$000(), "getDbUpgrades - cursor size=" + (query != null ? query.getCount() : 0));
                if (query != null) {
                    query.moveToFirst();
                    while (!query.isAfterLast()) {
                        int i;
                        String string = query.getString(query.getColumnIndex("uri"));
                        CharSequence string2 = query.getString(query.getColumnIndex("objectId"));
                        StringBuilder append = new StringBuilder().append("UPDATE ").append(Alarm.TABLE_NAME).append(" SET ").append("pinType").append(" = \"");
                        if (TextUtils.isEmpty(string2)) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        sQLiteDatabase.execSQL(append.append(i).append("\" WHERE ").append("uri").append(" == \"").append(string).append("\"").toString());
                        query.moveToNext();
                    }
                    query.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                MFLogger.e(cof.access$000(), ".getDbUpgrades - version(4) - e=" + e.toString());
            }
        }
    }

    public AlarmProviderImp$1(cof com_fossil_cof) {
        this.this$0 = com_fossil_cof;
        put(Integer.valueOf(2), new C48951(this));
        put(Integer.valueOf(3), new C48962(this));
        put(Integer.valueOf(4), new C48973(this));
    }
}
