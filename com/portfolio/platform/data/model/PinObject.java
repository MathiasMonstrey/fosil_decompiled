package com.portfolio.platform.data.model;

import com.fossil.cfj;
import com.fossil.cfk;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.helper.GsonConvertDateTime;
import java.util.UUID;
import org.joda.time.DateTime;

@DatabaseTable(tableName = "pin_object")
public class PinObject {
    public static final String COLUMN_CLASS_NAME = "className";
    public static final String COLUMN_JSON_DATA = "json";
    public static final String COLUMN_UUID = "uuid";
    private static final String TAG = PinObject.class.getSimpleName();
    @DatabaseField(columnName = "className")
    private String className;
    @DatabaseField(columnName = "json")
    private String jsonData;
    @DatabaseField(columnName = "uuid", id = true)
    private String uuid;

    public PinObject(String str, Object obj) {
        this.className = str;
        this.jsonData = new cfk().m6207a(DateTime.class, new GsonConvertDateTime()).Wu().toJson(obj);
        this.uuid = UUID.randomUUID().toString();
        MFLogger.m12670d(TAG, "Init new " + TAG + " - uuid=" + this.uuid + ", className=" + str + ", json=" + this.jsonData);
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String str) {
        this.className = str;
    }

    public String getJsonData() {
        return this.jsonData;
    }

    public void setJsonData(String str) {
        this.jsonData = str;
    }

    public void setJsonData(Object obj) {
        this.jsonData = new cfj().toJson(obj);
    }
}
