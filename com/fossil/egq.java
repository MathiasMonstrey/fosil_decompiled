package com.fossil;

import android.content.ContentValues;
import android.database.Cursor;

public class egq<T extends Enum<T>> extends egn<T> {
    private Class<T> clazz;

    public /* synthetic */ Object mo2865i(Cursor cursor) {
        return m10722l(cursor);
    }

    public egq(int i, String str, Class<T> cls) {
        super(i, str);
        this.clazz = cls;
    }

    public String aDe() {
        return "TEXT";
    }

    public T m10722l(Cursor cursor) {
        return egl.m10665a(getColumnIndex(), cursor, this.clazz);
    }

    public void m10719a(T t, ContentValues contentValues) {
        egl.m10672a(contentValues, getColumnName(), (Enum) t);
    }
}
