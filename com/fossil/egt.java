package com.fossil;

import android.content.ContentValues;
import android.database.Cursor;

public class egt extends egn<String> {
    public /* synthetic */ Object mo2865i(Cursor cursor) {
        return m10734o(cursor);
    }

    public egt(int i, String str) {
        super(i, str);
    }

    public String aDe() {
        return "TEXT";
    }

    public String m10734o(Cursor cursor) {
        return egl.m10667a(getColumnIndex(), cursor);
    }

    public void m10732a(String str, ContentValues contentValues) {
        egl.m10674a(contentValues, getColumnName(), str);
    }
}
