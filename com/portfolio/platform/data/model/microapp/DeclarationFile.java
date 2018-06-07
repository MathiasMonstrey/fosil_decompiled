package com.portfolio.platform.data.model.microapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fossil.cga;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.UUID;

@DatabaseTable(tableName = "declarationFile")
public class DeclarationFile implements Parcelable {
    public static final String COLUMN_CONTENT = "content";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_FILE_ID = "fileId";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_VARIANT = "variant";
    public static final Creator<DeclarationFile> CREATOR = new 1();
    @cga("content")
    @DatabaseField(columnName = "content")
    private String content;
    @cga("description")
    @DatabaseField(columnName = "description")
    private String description;
    @cga("fileId")
    @DatabaseField(columnName = "fileId")
    private String fileId;
    @cga("id")
    @DatabaseField(columnName = "id", id = true)
    private String id;
    @DatabaseField(columnName = "variant", foreign = true, foreignAutoRefresh = true)
    private MicroAppVariant microAppVariant;

    public DeclarationFile() {
        this.id = UUID.randomUUID().toString();
        this.id = UUID.randomUUID().toString();
    }

    protected DeclarationFile(Parcel parcel) {
        this.id = UUID.randomUUID().toString();
        this.id = parcel.readString();
        this.fileId = parcel.readString();
        this.description = parcel.readString();
        this.content = parcel.readString();
        this.content = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.fileId);
        parcel.writeString(this.description);
        parcel.writeString(this.content);
    }

    public String getId() {
        return this.id;
    }

    public String getFileId() {
        return this.fileId;
    }

    public void setFileId(String str) {
        this.fileId = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public MicroAppVariant getMicroAppVariant() {
        return this.microAppVariant;
    }

    public void setMicroAppVariant(MicroAppVariant microAppVariant) {
        this.microAppVariant = microAppVariant;
    }
}
