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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@DatabaseTable(tableName = "activePreset")
public class ActivePreset implements Parcelable {
    public static final String COLUMN_BUTTONS = "buttons";
    public static final String COLUMN_CREATE_AT = "createAt";
    public static final String COLUMN_ORIGINAL_ID = "originalId";
    public static final String COLUMN_PIN_TYPE = "pinType";
    public static final String COLUMN_SERIAL = "serialNumber";
    public static final String COLUMN_UPDATE_AT = "updatedAt";
    public static final Creator<ActivePreset> CREATOR = new 1();
    public static final String TABLE_NAME = "activePreset";
    private List<ButtonMapping> buttonMappingList;
    @cga("buttons")
    @DatabaseField(columnName = "buttons")
    private String buttons;
    @cga("createAt")
    @DatabaseField(columnName = "createAt")
    private long createAt;
    @cga("originalId")
    @DatabaseField(columnName = "originalId")
    private String originalId;
    @DatabaseField(columnName = "pinType")
    private int pinType;
    @cga("serialNumber")
    @DatabaseField(columnName = "serialNumber", id = true)
    private String serialNumber;
    @cga("updatedAt")
    @DatabaseField(columnName = "updatedAt")
    private long updateAt;

    public ActivePreset() {
        this.buttonMappingList = new ArrayList();
        this.pinType = 0;
        this.originalId = "";
    }

    public ActivePreset(ActivePreset activePreset) {
        this.buttonMappingList = new ArrayList();
        this.createAt = activePreset.createAt;
        this.updateAt = activePreset.updateAt;
        this.originalId = activePreset.originalId;
        this.serialNumber = activePreset.serialNumber;
        this.originalId = activePreset.originalId;
        setButtons(activePreset.buttons);
        this.pinType = 0;
    }

    protected ActivePreset(Parcel parcel) {
        this.buttonMappingList = new ArrayList();
        parcel.readTypedList(this.buttonMappingList, ButtonMapping.CREATOR);
        this.buttons = parcel.readString();
        this.createAt = parcel.readLong();
        this.updateAt = parcel.readLong();
        this.originalId = parcel.readString();
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
        if (!TextUtils.isEmpty(str)) {
            this.buttonMappingList = new ArrayList(getListMappingFromJson());
        }
    }

    public List<ButtonMapping> getButtonMappingList() {
        if (this.buttonMappingList.size() == 0 && !TextUtils.isEmpty(this.buttons)) {
            this.buttonMappingList = new ArrayList(getListMappingFromJson());
        }
        return this.buttonMappingList;
    }

    public void setButtonMappingList(List<ButtonMapping> list) throws IOException {
        Writer stringWriter = new StringWriter();
        write(new cgw(stringWriter), list);
        this.buttons = stringWriter.toString();
        this.buttonMappingList.clear();
        this.buttonMappingList.addAll(list);
    }

    private void write(cgw com_fossil_cgw, List<ButtonMapping> list) throws IOException {
        com_fossil_cgw.Xa();
        for (ButtonMapping buttonMapping : list) {
            com_fossil_cgw.Xc();
            com_fossil_cgw.fu(ButtonMapping.BUTTON).fv(buttonMapping.getButton());
            com_fossil_cgw.fu("appId").fv(buttonMapping.getMicroAppId());
            com_fossil_cgw.Xd();
        }
        com_fossil_cgw.Xb();
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

    public String getButtons() {
        return this.buttons;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public void setSerialNumber(String str) {
        this.serialNumber = str;
    }

    public String getOriginalId() {
        return this.originalId;
    }

    public void setOriginalId(String str) {
        this.originalId = str;
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
        parcel.writeString(this.buttons);
        parcel.writeLong(this.createAt);
        parcel.writeLong(this.updateAt);
        parcel.writeString(this.originalId);
        parcel.writeInt(this.pinType);
    }
}
