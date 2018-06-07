package com.portfolio.platform.model;

import com.fossil.cfj;
import com.fossil.cga;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "PhoneFavoritesContact")
public class PhoneFavoritesContact {
    public static final String COLUMN_PHONE_NUMBER = "phoneNumber";
    public static final String TABLE_NAME = "PhoneFavoritesContact";
    @cga("phoneNumber")
    @DatabaseField(columnName = "phoneNumber", id = true)
    private String phoneNumber;

    public PhoneFavoritesContact(String str) {
        this.phoneNumber = str;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public String toString() {
        return new cfj().toJson(this);
    }
}
