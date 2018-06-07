package com.misfit.ble.sync.obfuscated;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.misfit.ble.shine.sync.result.MinuteData;
import com.misfit.frameworks.common.constants.Constants;
import java.util.ArrayList;
import java.util.List;

class C4645a extends SQLiteOpenHelper {
    private static final String TAG = C4648d.m15471a(C4645a.class);

    public C4645a(Context context) {
        super(context, "ShineData.db", null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE minute_data ( minute_id INTEGER PRIMARY KEY NOT NULL UNIQUE, start_time INTEGER, n_steps INTEGER, n_points INTEGER )");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Log.d(TAG, "DBHelper: onUpgrade");
    }

    public int m15464a(List<MinuteData> list) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        writableDatabase.beginTransaction();
        for (MinuteData minuteData : list) {
            contentValues.put("minute_id", Long.valueOf(minuteData.getMinuteId()));
            contentValues.put(Constants.START_TIME, Long.valueOf(minuteData.getStartTime()));
            contentValues.put("n_steps", Long.valueOf(minuteData.getStep()));
            contentValues.put("n_points", Long.valueOf(minuteData.getPoint()));
            long insertWithOnConflict = writableDatabase.insertWithOnConflict("minute_data", null, contentValues, 5);
            contentValues.clear();
            if (insertWithOnConflict == -1) {
                return -1;
            }
        }
        writableDatabase.setTransactionSuccessful();
        if (writableDatabase.inTransaction()) {
            writableDatabase.endTransaction();
        }
        return list.size();
    }

    public int m15463a(String str, String[] strArr) {
        return getWritableDatabase().delete("minute_data", str, strArr);
    }

    public List<MinuteData> m15465a(String str, String[] strArr, String str2, String str3) {
        Cursor query = getReadableDatabase().query("minute_data", new String[]{"minute_id", Constants.START_TIME, "n_steps", "n_points"}, str, strArr, null, null, str2, str3);
        List<MinuteData> arrayList = new ArrayList();
        if (query != null && query.moveToFirst()) {
            while (!query.isAfterLast()) {
                arrayList.add(new MinuteData(query.getLong(query.getColumnIndex("minute_id")), query.getLong(query.getColumnIndex(Constants.START_TIME)), query.getLong(query.getColumnIndex("n_steps")), query.getLong(query.getColumnIndex("n_points"))));
                query.moveToNext();
            }
        }
        query.close();
        return arrayList;
    }

    public void close() {
        getWritableDatabase().close();
    }
}
