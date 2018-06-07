package com.fossil;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;

@TargetApi(11)
final class boi extends SQLiteOpenHelper {
    private /* synthetic */ boh bzo;

    boi(boh com_fossil_boh, Context context, String str) {
        this.bzo = com_fossil_boh;
        super(context, str, null, 1);
    }

    public final SQLiteDatabase getWritableDatabase() {
        try {
            return super.getWritableDatabase();
        } catch (SQLiteException e) {
            if (VERSION.SDK_INT < 11 || !(e instanceof SQLiteDatabaseLockedException)) {
                this.bzo.Pf().Rc().log("Opening the local database failed, dropping and recreating it");
                String Qg = bnm.Qg();
                if (!this.bzo.getContext().getDatabasePath(Qg).delete()) {
                    this.bzo.Pf().Rc().m5439d("Failed to delete corrupted local db file", Qg);
                }
                try {
                    return super.getWritableDatabase();
                } catch (SQLiteException e2) {
                    this.bzo.Pf().Rc().m5439d("Failed to open local database. Events will bypass local storage", e2);
                    return null;
                }
            }
            throw e2;
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        bnn.m5339a(this.bzo.Pf(), sQLiteDatabase);
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (VERSION.SDK_INT < 15) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
            try {
                rawQuery.moveToFirst();
            } finally {
                rawQuery.close();
            }
        }
        bnn.m5340a(this.bzo.Pf(), sQLiteDatabase, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", null);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
