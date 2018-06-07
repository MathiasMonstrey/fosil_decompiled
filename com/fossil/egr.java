package com.fossil;

import android.content.ContentValues;
import android.database.Cursor;

public class egr extends egn<ech> {
    public /* synthetic */ Object mo2865i(Cursor cursor) {
        return m10726m(cursor);
    }

    public egr(int i, String str) {
        super(i, str);
    }

    public String aDe() {
        return "TEXT";
    }

    public ech m10726m(Cursor cursor) {
        return egl.m10687f(getColumnIndex(), cursor);
    }

    public void m10723a(ech com_fossil_ech, ContentValues contentValues) {
        egl.m10669a(contentValues, getColumnName(), com_fossil_ech);
    }
}
