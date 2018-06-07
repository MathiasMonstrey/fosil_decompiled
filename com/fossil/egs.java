package com.fossil;

import android.content.ContentValues;
import android.database.Cursor;

public class egs extends egn<Long> {
    public /* synthetic */ Object mo2865i(Cursor cursor) {
        return m10730n(cursor);
    }

    public egs(int i, String str) {
        super(i, str);
    }

    public String aDe() {
        return "INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL";
    }

    public Long m10730n(Cursor cursor) {
        return egl.m10683c(getColumnIndex(), cursor);
    }

    public void m10727a(Long l, ContentValues contentValues) {
        egl.m10673a(contentValues, getColumnName(), l);
    }
}
