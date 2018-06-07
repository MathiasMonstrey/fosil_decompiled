package com.portfolio.platform.data.model.microapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.fossil.cfj;
import com.fossil.cfm;
import com.fossil.cfp;
import com.fossil.cfs;
import com.fossil.drb;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.misfit.frameworks.buttonservice.enums.MFDeviceFamily;
import com.misfit.frameworks.buttonservice.model.Mapping;
import com.misfit.frameworks.buttonservice.model.microapp.MicroAppInstruction.MicroAppID;
import com.misfit.frameworks.common.enums.Action.DisplayMode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@DatabaseTable(tableName = "mappingSet")
public class MappingSet implements Parcelable {
    public static final String COLUMN_CHECKSUM = "checksum";
    public static final String COLUMN_CREATE_AT = "createAt";
    public static final String COLUMN_DEVICE_FAMILY = "deviceFamily";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_IS_ACTIVE = "isActive";
    public static final String COLUMN_LIST_MAPPING_JSON = "listMappingJson";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_OBJECT_ID = "objectId";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_UPDATE_AT = "updatedAt";
    public static final String COLUMN_URI = "uri";
    public static final Creator<MappingSet> CREATOR = new 1();
    @DatabaseField(columnName = "checksum")
    private String checkSum;
    @DatabaseField(columnName = "createAt")
    private long createAt;
    @DatabaseField(columnName = "deviceFamily")
    private int deviceFamily;
    @DatabaseField(columnName = "id", id = true)
    private String id;
    @DatabaseField(columnName = "isActive")
    private boolean isActive;
    private List<Mapping> mappingList = new ArrayList();
    @DatabaseField(columnName = "listMappingJson")
    private String mappingListJsonString;
    @DatabaseField(columnName = "name")
    private String name;
    @DatabaseField(columnName = "objectId")
    private String objectId;
    @DatabaseField(columnName = "type")
    private int type;
    @DatabaseField(columnName = "updatedAt")
    private long updateAt;
    @DatabaseField(columnName = "uri")
    private String uri;

    protected MappingSet(Parcel parcel) {
        parcel.readTypedList(this.mappingList, Mapping.CREATOR);
        this.name = parcel.readString();
        this.mappingListJsonString = parcel.readString();
        this.deviceFamily = parcel.readInt();
        this.createAt = parcel.readLong();
        this.updateAt = parcel.readLong();
        this.id = parcel.readString();
        this.isActive = parcel.readByte() != (byte) 0;
        this.type = parcel.readInt();
        this.uri = parcel.readString();
        this.objectId = parcel.readString();
        this.checkSum = parcel.readString();
    }

    private List<Mapping> getListMappingFromJson() {
        cfj com_fossil_cfj = new cfj();
        cfm WB = new cfs().fs(this.mappingListJsonString).WB();
        List<Mapping> arrayList = new ArrayList();
        Iterator it = WB.iterator();
        while (it.hasNext()) {
            arrayList.add((Mapping) com_fossil_cfj.m6193a((cfp) it.next(), Mapping.class));
        }
        return arrayList;
    }

    public List<Mapping> getMappingList() {
        if ((this.mappingList == null || this.mappingList.size() == 0) && !TextUtils.isEmpty(this.mappingListJsonString)) {
            this.mappingList = new ArrayList(getListMappingFromJson());
        }
        return this.mappingList;
    }

    public MFDeviceFamily getDeviceFamily() {
        return MFDeviceFamily.fromInt(this.deviceFamily);
    }

    public void setDeviceFamily(MFDeviceFamily mFDeviceFamily) {
        this.deviceFamily = mFDeviceFamily.getValue();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
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

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void setActive(boolean z) {
        this.isActive = z;
    }

    public MappingSetType getType() {
        return MappingSetType.fromInt(this.type);
    }

    public void setType(MappingSetType mappingSetType) {
        this.type = mappingSetType.getValue();
    }

    public String getUri() {
        return this.uri;
    }

    public void setUri(String str) {
        this.uri = str;
    }

    public String getCheckSum() {
        return this.checkSum;
    }

    public void setCheckSum(String str) {
        this.checkSum = str;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public void setObjectId(String str) {
        this.objectId = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.mappingList);
        parcel.writeString(this.name);
        parcel.writeString(this.mappingListJsonString);
        parcel.writeInt(this.deviceFamily);
        parcel.writeLong(this.createAt);
        parcel.writeLong(this.updateAt);
        parcel.writeString(this.id);
        parcel.writeByte((byte) (this.isActive ? 1 : 0));
        parcel.writeInt(this.type);
        parcel.writeString(this.uri);
        parcel.writeString(this.objectId);
        parcel.writeString(this.checkSum);
    }

    public boolean isSameMappingList(MappingSet mappingSet) {
        if (mappingSet == null || mappingSet.getMappingList() == null || getMappingList() == null || getMappingList().size() != mappingSet.getMappingList().size()) {
            return false;
        }
        boolean z = true;
        for (int i = 0; i < getMappingList().size(); i++) {
            if (((Mapping) getMappingList().get(i)).getAction() != ((Mapping) mappingSet.getMappingList().get(i)).getAction()) {
                z = false;
            }
        }
        return z;
    }

    public SavedPreset convertToSavedPreset() {
        SavedPreset savedPreset = new SavedPreset();
        savedPreset.setCreateAt(System.currentTimeMillis());
        savedPreset.setUpdateAt(System.currentTimeMillis());
        savedPreset.setName(this.name);
        List arrayList = new ArrayList();
        for (Mapping mapping : getMappingList()) {
            if (mapping.getAction() == DisplayMode.ALARM) {
                return null;
            }
            MicroAppID lz = drb.lz(mapping.getAction());
            if (lz != null) {
                ButtonMapping buttonMapping = new ButtonMapping();
                buttonMapping.setMicroAppId(lz.getValue());
                buttonMapping.setButton(PusherConfiguration.getPusherByGesture(mapping.getGesture()).getValue());
                arrayList.add(buttonMapping);
            }
        }
        try {
            savedPreset.setButtonMappingList(arrayList);
            return savedPreset;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ActivePreset convertToActivePreset(String str) {
        ActivePreset activePreset = new ActivePreset();
        activePreset.setCreateAt(System.currentTimeMillis());
        activePreset.setUpdateAt(System.currentTimeMillis());
        activePreset.setSerialNumber(str);
        List arrayList = new ArrayList();
        for (Mapping mapping : getMappingList()) {
            if (mapping.getAction() == DisplayMode.ALARM) {
                return null;
            }
            MicroAppID lz = drb.lz(mapping.getAction());
            if (lz != null) {
                ButtonMapping buttonMapping = new ButtonMapping();
                buttonMapping.setMicroAppId(lz.getValue());
                buttonMapping.setButton(PusherConfiguration.getPusherByGesture(mapping.getGesture()).getValue());
                arrayList.add(buttonMapping);
            }
        }
        try {
            activePreset.setButtonMappingList(arrayList);
            return activePreset;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
