package com.portfolio.platform.data.model.microapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.fossil.cga;
import com.fossil.cgw;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@DatabaseTable(tableName = "savedPreset")
public class SavedPreset implements Parcelable {
    public static final String COLUMN_BUTTONS = "buttons";
    public static final String COLUMN_CREATE_AT = "createAt";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PIN_TYPE = "pinType";
    public static final String COLUMN_UPDATE_AT = "updatedAt";
    public static final Creator<SavedPreset> CREATOR = new 1();
    public static final String TABLE_NAME = "savedPreset";
    private List<ButtonMapping> buttonMappingList;
    @cga("buttons")
    @DatabaseField(columnName = "buttons")
    private String buttons;
    @cga("createAt")
    @DatabaseField(columnName = "createAt")
    private long createAt;
    @cga("id")
    @DatabaseField(columnName = "id", id = true)
    private String id;
    @cga("name")
    @DatabaseField(columnName = "name")
    private String name;
    @DatabaseField(columnName = "pinType")
    private int pinType;
    @cga("updatedAt")
    @DatabaseField(columnName = "updatedAt")
    private long updateAt;

    public SavedPreset() {
        this.buttonMappingList = new ArrayList();
        this.id = UUID.randomUUID().toString();
        this.id = UUID.randomUUID().toString();
        this.pinType = 0;
    }

    public SavedPreset(SavedPreset savedPreset) {
        this.buttonMappingList = new ArrayList();
        this.id = UUID.randomUUID().toString();
        this.id = UUID.randomUUID().toString();
        this.name = savedPreset.name;
        this.createAt = savedPreset.createAt;
        this.updateAt = savedPreset.updateAt;
        this.pinType = 0;
        setButtons(savedPreset.buttons);
    }

    protected SavedPreset(Parcel parcel) {
        this.buttonMappingList = new ArrayList();
        this.id = UUID.randomUUID().toString();
        parcel.readTypedList(this.buttonMappingList, ButtonMapping.CREATOR);
        this.name = parcel.readString();
        this.buttons = parcel.readString();
        this.createAt = parcel.readLong();
        this.updateAt = parcel.readLong();
        this.id = parcel.readString();
        this.pinType = parcel.readInt();
    }

    private List<ButtonMapping> getListMappingFromJson() {
        List<ButtonMapping> arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(this.buttons);
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    ButtonMapping buttonMapping = new ButtonMapping();
                    if (jSONObject.has(ButtonMapping.BUTTON)) {
                        buttonMapping.setButton(jSONObject.getString(ButtonMapping.BUTTON));
                    }
                    if (jSONObject.has("appId")) {
                        buttonMapping.setMicroAppId(jSONObject.getString("appId"));
                    }
                    arrayList.add(buttonMapping);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public void setButtons(String str) {
        this.buttons = str;
        getButtonMappingList();
    }

    public List<ButtonMapping> getButtonMappingList() {
        if ((this.buttonMappingList == null || this.buttonMappingList.size() == 0) && !TextUtils.isEmpty(this.buttons)) {
            this.buttonMappingList = new ArrayList(getListMappingFromJson());
        }
        return this.buttonMappingList;
    }

    public void setButtonMappingList(List<ButtonMapping> list) throws IOException {
        if (this.buttonMappingList == null) {
            this.buttonMappingList = new ArrayList();
        }
        Writer stringWriter = new StringWriter();
        write(new cgw(stringWriter), list);
        this.buttons = stringWriter.toString();
        this.buttonMappingList.clear();
        this.buttonMappingList.addAll(list);
    }

    public void write(cgw com_fossil_cgw, List<ButtonMapping> list) throws IOException {
        com_fossil_cgw.Xa();
        for (ButtonMapping buttonMapping : list) {
            com_fossil_cgw.Xc();
            com_fossil_cgw.fu(ButtonMapping.BUTTON).fv(buttonMapping.getButton());
            com_fossil_cgw.fu("appId").fv(buttonMapping.getMicroAppId());
            com_fossil_cgw.Xd();
        }
        com_fossil_cgw.Xb();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setCreateAt(long j) {
        this.createAt = j / 1000;
    }

    public long getCreateAt() {
        return this.createAt;
    }

    public long getUpdateAt() {
        return this.updateAt;
    }

    public void setUpdateAt(long j) {
        this.updateAt = j / 1000;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getButtons() {
        return this.buttons;
    }

    public int getPinType() {
        return this.pinType;
    }

    public void setPinType(int i) {
        this.pinType = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.buttonMappingList);
        parcel.writeString(this.name);
        parcel.writeString(this.buttons);
        parcel.writeLong(this.createAt);
        parcel.writeLong(this.updateAt);
        parcel.writeString(this.id);
        parcel.writeInt(this.pinType);
    }
}
