package com.portfolio.platform.data.model.microapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fossil.cga;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@DatabaseTable(tableName = "microAppVariant")
public class MicroAppVariant implements Parcelable {
    public static final String COLUMN_APP_ID = "appId";
    public static final String COLUMN_CREATE_AT = "createdAt";
    public static final String COLUMN_DECLARATION_FILES = "declarationFiles";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_MAJOR_NUMBER = "majorNumber";
    public static final String COLUMN_MINOR_NUMBER = "minorNumber";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_SERIAL_NUMBER = "serialNumber";
    public static final String COLUMN_UPDATE_AT = "updatedAt";
    public static final Creator<MicroAppVariant> CREATOR = new 1();
    @cga("appId")
    @DatabaseField(columnName = "appId")
    private String appId;
    @cga("createdAt")
    @DatabaseField(columnName = "createdAt")
    private long createAt;
    @ForeignCollectionField(columnName = "declarationFiles", eager = true)
    private ForeignCollection<DeclarationFile> declarationFiles;
    @cga("description")
    @DatabaseField(columnName = "description")
    private String description;
    @DatabaseField(columnName = "id", id = true)
    private String id;
    @cga("majorNumber")
    @DatabaseField(columnName = "majorNumber")
    private int majorNumber;
    @cga("minorNumber")
    @DatabaseField(columnName = "minorNumber")
    private int minorNumber;
    @cga("name")
    @DatabaseField(columnName = "name")
    private String name;
    @cga("serialNumber")
    @DatabaseField(columnName = "serialNumber")
    private String serialNumbers;
    @cga("updatedAt")
    @DatabaseField(columnName = "updatedAt")
    private long updateAt;

    protected MicroAppVariant(Parcel parcel) {
        this.id = parcel.readString();
        this.appId = parcel.readString();
        this.name = parcel.readString();
        this.description = parcel.readString();
        Collection arrayList = new ArrayList();
        parcel.readList(arrayList, String.class.getClassLoader());
        this.declarationFiles.addAll(arrayList);
        this.createAt = parcel.readLong();
        this.updateAt = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.appId);
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeList((List) this.declarationFiles);
        parcel.writeLong(this.createAt);
        parcel.writeLong(this.updateAt);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public List<DeclarationFile> getDeclarationFiles() {
        List<DeclarationFile> arrayList = new ArrayList();
        if (this.declarationFiles == null || this.declarationFiles.size() <= 0) {
            return arrayList;
        }
        return new ArrayList(this.declarationFiles);
    }

    public void setDeclarationFiles(List<DeclarationFile> list) {
        this.declarationFiles.addAll(list);
    }

    public long getCreateAt() {
        return this.createAt;
    }

    public void setCreateAt(long j) {
        this.createAt = j;
    }

    public long getUpdateAt() {
        return this.updateAt;
    }

    public void setUpdateAt(long j) {
        this.updateAt = j;
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public String getSerialNumbers() {
        return this.serialNumbers;
    }

    public void setSerialNumbers(String str) {
        this.serialNumbers = str;
    }

    public int getMajorNumber() {
        return this.majorNumber;
    }

    public void setMajorNumber(int i) {
        this.majorNumber = i;
    }

    public int getMinorNumber() {
        return this.minorNumber;
    }

    public void setMinorNumber(int i) {
        this.minorNumber = i;
    }
}
