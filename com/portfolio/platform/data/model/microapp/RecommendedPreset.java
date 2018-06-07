package com.portfolio.platform.data.model.microapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.fossil.cgw;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.portfolio.platform.data.model.microapp.SavedPreset.MappingSetType;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@DatabaseTable(tableName = "recommendedPreset")
public class RecommendedPreset implements Parcelable {
    public static final String COLUMN_BUTTONS = "buttons";
    public static final String COLUMN_CREATE_AT = "createAt";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_OBJECT_ID = "objectId";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_UPDATE_AT = "updatedAt";
    public static final Creator<RecommendedPreset> CREATOR = new 1();
    public static final String SERIAL_NUMBER = "serialNumber";
    private List<ButtonMapping> buttonMappingList;
    @DatabaseField(columnName = "buttons")
    private String buttons;
    @DatabaseField(columnName = "createAt")
    private long createAt;
    @DatabaseField(columnName = "description")
    private String description;
    @DatabaseField(columnName = "id", id = true)
    private String id;
    @DatabaseField(columnName = "name")
    private String name;
    @DatabaseField(columnName = "serialNumber")
    private String serialNumber;
    @DatabaseField(columnName = "type")
    private String type;
    @DatabaseField(columnName = "updatedAt")
    private long updateAt;

    public RecommendedPreset() {
        this.buttonMappingList = new ArrayList();
    }

    public RecommendedPreset(RecommendedPreset recommendedPreset) {
        this.buttonMappingList = new ArrayList();
        this.type = recommendedPreset.type;
        this.name = recommendedPreset.name;
        this.description = recommendedPreset.description;
        this.createAt = recommendedPreset.createAt;
        this.updateAt = recommendedPreset.updateAt;
        this.serialNumber = recommendedPreset.serialNumber;
    }

    private RecommendedPreset(Parcel parcel) {
        this.buttonMappingList = new ArrayList();
        parcel.readTypedList(this.buttonMappingList, ButtonMapping.CREATOR);
        this.name = parcel.readString();
        this.description = parcel.readString();
        this.buttons = parcel.readString();
        this.serialNumber = parcel.readString();
        this.createAt = parcel.readLong();
        this.updateAt = parcel.readLong();
        this.id = parcel.readString();
        this.type = parcel.readString();
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

    public List<ButtonMapping> getButtonMappingList() {
        if ((this.buttonMappingList == null || this.buttonMappingList.size() == 0) && !TextUtils.isEmpty(this.buttons)) {
            this.buttonMappingList = new ArrayList(getListMappingFromJson());
        }
        return this.buttonMappingList;
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
        this.createAt = j;
    }

    public long getUpdateAt() {
        return this.updateAt;
    }

    public void setUpdateAt(long j) {
        this.updateAt = j;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public MappingSetType getType() {
        return MappingSetType.fromString(this.type);
    }

    public void setType(MappingSetType mappingSetType) {
        this.type = mappingSetType.getValue();
    }

    public void setButtons(String str) {
        this.buttons = str;
        getButtonMappingList();
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

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.buttonMappingList);
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeString(this.buttons);
        parcel.writeString(this.serialNumber);
        parcel.writeLong(this.createAt);
        parcel.writeLong(this.updateAt);
        parcel.writeString(this.id);
        parcel.writeString(this.type);
    }
}
