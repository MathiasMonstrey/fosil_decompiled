package com.fossil;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.misfit.frameworks.common.constants.Constants;
import java.util.ArrayList;
import java.util.List;

class eam extends SQLiteOpenHelper {
    private String aWB = "";
    private Context bcp = null;

    public eam(Context context, String str) {
        super(context, str, null, 3);
        this.aWB = str;
        this.bcp = context.getApplicationContext();
        if (dze.aBG()) {
            ead.dCu.cY("SQLiteOpenHelper " + this.aWB);
        }
    }

    private void m10416b(SQLiteDatabase sQLiteDatabase) {
        Throwable th;
        String str = null;
        Cursor query;
        try {
            query = sQLiteDatabase.query("user", null, null, null, null, null, null);
            try {
                ContentValues contentValues = new ContentValues();
                if (query.moveToNext()) {
                    str = query.getString(0);
                    query.getInt(1);
                    query.getString(2);
                    query.getLong(3);
                    contentValues.put(Constants.PROFILE_KEY_UID, ebh.cx(str));
                }
                if (str != null) {
                    sQLiteDatabase.update("user", contentValues, "uid=?", new String[]{str});
                }
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    ead.dCu.m10419g(th);
                    if (query != null) {
                        query.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    private void m10417c(SQLiteDatabase sQLiteDatabase) {
        Cursor query;
        Throwable th;
        Cursor cursor;
        try {
            query = sQLiteDatabase.query("events", null, null, null, null, null, null);
            try {
                List<ean> arrayList = new ArrayList();
                while (query.moveToNext()) {
                    arrayList.add(new ean(query.getLong(0), query.getString(1), query.getInt(2), query.getInt(3)));
                }
                ContentValues contentValues = new ContentValues();
                for (ean com_fossil_ean : arrayList) {
                    contentValues.put("content", ebh.cx(com_fossil_ean.aWR));
                    sQLiteDatabase.update("events", contentValues, "event_id=?", new String[]{Long.toString(com_fossil_ean.aXm)});
                }
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public synchronized void close() {
        super.close();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists events(event_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, content TEXT, status INTEGER, send_count INTEGER, timestamp LONG)");
        sQLiteDatabase.execSQL("create table if not exists user(uid TEXT PRIMARY KEY, user_type INTEGER, app_ver TEXT, ts INTEGER)");
        sQLiteDatabase.execSQL("create table if not exists config(type INTEGER PRIMARY KEY NOT NULL, content TEXT, md5sum TEXT, version INTEGER)");
        sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
        sQLiteDatabase.execSQL("CREATE INDEX if not exists status_idx ON events(status)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        ead.dCu.debug("upgrade DB from oldVersion " + i + " to newVersion " + i2);
        if (i == 1) {
            sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
            m10416b(sQLiteDatabase);
            m10417c(sQLiteDatabase);
        }
        if (i == 2) {
            m10416b(sQLiteDatabase);
            m10417c(sQLiteDatabase);
        }
    }
}
