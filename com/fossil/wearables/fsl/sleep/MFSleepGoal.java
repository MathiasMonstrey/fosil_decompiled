package com.fossil.wearables.fsl.sleep;

import com.fossil.wearables.fsl.shared.BaseModel;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "sleep_goal")
public class MFSleepGoal extends BaseModel {
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_MINUTE = "minute";
    public static final String COLUMN_TIMEZONE_OFFSET = "timezoneOffset";
    @DatabaseField(columnName = "date")
    private String date;
    @DatabaseField(columnName = "minute")
    private int minute;
    @DatabaseField(columnName = "timezoneOffset")
    private int timezoneOffset;

    public MFSleepGoal(String str, int i, int i2) {
        this.date = str;
        this.timezoneOffset = i2;
        this.minute = i;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public int getMinute() {
        return this.minute;
    }

    public void setMinute(int i) {
        this.minute = i;
    }

    public int getTimezoneOffset() {
        return this.timezoneOffset;
    }

    public void setTimezoneOffset(int i) {
        this.timezoneOffset = i;
    }
}
