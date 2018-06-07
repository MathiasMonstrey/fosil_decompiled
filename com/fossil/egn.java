package com.fossil;

import android.content.ContentValues;
import android.database.Cursor;

public abstract class egn<T> {
    private String columnName;
    private int dGW;

    public abstract void mo2863a(T t, ContentValues contentValues);

    public abstract String aDe();

    public abstract T mo2865i(Cursor cursor);

    public egn(int i, String str) {
        this.dGW = i;
        this.columnName = str;
    }

    public int getColumnIndex() {
        return this.dGW;
    }

    public String getColumnName() {
        return this.columnName;
    }

    public String toString() {
        return getColumnName();
    }
}
