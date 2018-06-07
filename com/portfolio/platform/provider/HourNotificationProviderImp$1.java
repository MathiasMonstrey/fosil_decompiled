package com.portfolio.platform.provider;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import com.fossil.cos;
import com.fossil.cou;
import com.fossil.wearables.fsl.appfilter.AppFilter;
import com.fossil.wearables.fsl.shared.UpgradeCommand;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HourNotificationProviderImp$1 extends HashMap<Integer, UpgradeCommand> {
    final /* synthetic */ cou this$0;

    class C49001 implements UpgradeCommand {
        final /* synthetic */ HourNotificationProviderImp$1 cBu;

        C49001(HourNotificationProviderImp$1 hourNotificationProviderImp$1) {
            this.cBu = hourNotificationProviderImp$1;
        }

        public void execute(final SQLiteDatabase sQLiteDatabase) {
            new AsyncTask<Void, Void, Void>(this) {
                final /* synthetic */ C49001 cBv;

                protected /* synthetic */ Object doInBackground(Object[] objArr) {
                    return m15633c((Void[]) objArr);
                }

                protected Void m15633c(Void... voidArr) {
                    try {
                        MFLogger.d(cou.access$000(), "Inside upgrade db from 1 to 2");
                        Cursor query = sQLiteDatabase.query(true, "hourNotification", new String[]{"extraId", "createdAt", AppFilter.COLUMN_HOUR, AppFilter.COLUMN_IS_VIBRATION_ONLY}, null, null, null, null, null, null);
                        List arrayList = new ArrayList();
                        if (query != null) {
                            query.moveToFirst();
                            while (!query.isAfterLast()) {
                                String string = query.getString(query.getColumnIndex("extraId"));
                                String string2 = query.getString(query.getColumnIndex("createdAt"));
                                int i = query.getInt(query.getColumnIndex(AppFilter.COLUMN_HOUR));
                                int i2 = query.getInt(query.getColumnIndex(AppFilter.COLUMN_IS_VIBRATION_ONLY));
                                cos com_fossil_cos = new cos();
                                com_fossil_cos.hp(string);
                                com_fossil_cos.setCreatedAt(Long.valueOf(string2).longValue());
                                com_fossil_cos.setHour(i);
                                com_fossil_cos.setVibrationOnly(i2 == 1);
                                arrayList.add(com_fossil_cos);
                                query.moveToNext();
                            }
                            query.close();
                        }
                        MFLogger.d(cou.access$000(), "Inside upgrade db from 1 to 2, creating hour notification copy table");
                        sQLiteDatabase.execSQL("CREATE TABLE hour_notification_copy (id VARCHAR PRIMARY KEY, extraId VARCHAR, hour INTEGER, createdAt VARCHAR, isVibrationOnly INTEGER, deviceFamily VARCHAR);");
                        if (!arrayList.isEmpty()) {
                            arrayList = cou.a(this.cBv.cBu.this$0, arrayList);
                        }
                        if (!r0.isEmpty()) {
                            for (cos com_fossil_cos2 : r0) {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("extraId", com_fossil_cos2.aex());
                                contentValues.put(AppFilter.COLUMN_HOUR, Integer.valueOf(com_fossil_cos2.getHour()));
                                contentValues.put("createdAt", Long.valueOf(com_fossil_cos2.getCreatedAt()));
                                contentValues.put("deviceFamily", com_fossil_cos2.getDeviceFamily());
                                contentValues.put(AppFilter.COLUMN_IS_VIBRATION_ONLY, Boolean.valueOf(com_fossil_cos2.isVibrationOnly()));
                                contentValues.put("id", com_fossil_cos2.getId());
                                MFLogger.d(cou.access$000(), "Insert new values " + contentValues + " into copy table");
                                sQLiteDatabase.insert("hour_notification_copy", null, contentValues);
                            }
                        }
                        sQLiteDatabase.execSQL("DROP TABLE hourNotification;");
                        sQLiteDatabase.execSQL("ALTER TABLE hour_notification_copy RENAME TO hourNotification;");
                    } catch (Exception e) {
                        MFLogger.e(cou.access$000(), "Error inside " + cou.access$000() + ".upgrade - e=" + e);
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public HourNotificationProviderImp$1(cou com_fossil_cou) {
        this.this$0 = com_fossil_cou;
        put(Integer.valueOf(2), new C49001(this));
    }
}
