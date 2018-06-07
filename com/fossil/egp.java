package com.fossil;

import android.content.ContentValues;
import android.database.Cursor;

public class egp extends egn<Double> {
    public /* synthetic */ Object mo2865i(Cursor cursor) {
        return m10718k(cursor);
    }

    public egp(int i, String str) {
        super(i, str);
    }

    public String aDe() {
        return "REAL";
    }

    public Double m10718k(Cursor cursor) {
        return egl.m10684d(getColumnIndex(), cursor);
    }

    public void m10715a(Double d, ContentValues contentValues) {
        egl.m10671a(contentValues, getColumnName(), d);
    }
}
