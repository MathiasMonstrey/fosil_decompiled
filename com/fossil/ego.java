package com.fossil;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.Date;

public class ego extends egn<Date> {
    public /* synthetic */ Object mo2865i(Cursor cursor) {
        return m10714j(cursor);
    }

    public ego(int i, String str) {
        super(i, str);
    }

    public String aDe() {
        return "INTEGER";
    }

    public Date m10714j(Cursor cursor) {
        return egl.m10685e(getColumnIndex(), cursor);
    }

    public void m10712a(Date date, ContentValues contentValues) {
        egl.m10675a(contentValues, getColumnName(), date);
    }
}
