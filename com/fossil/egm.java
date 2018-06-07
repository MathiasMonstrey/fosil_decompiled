package com.fossil;

import android.content.ContentValues;
import android.database.Cursor;

public class egm extends egn<Boolean> {
    public /* synthetic */ Object mo2865i(Cursor cursor) {
        return m10709h(cursor);
    }

    public egm(int i, String str) {
        super(i, str);
    }

    public String aDe() {
        return "INTEGER";
    }

    public Boolean m10709h(Cursor cursor) {
        return egl.m10682b(getColumnIndex(), cursor);
    }

    public void m10707a(Boolean bool, ContentValues contentValues) {
        egl.m10670a(contentValues, getColumnName(), bool);
    }
}
