package com.misfit.frameworks.buttonservice.model.microapp.mapping;

import android.os.Parcel;
import com.misfit.frameworks.buttonservice.model.microapp.MicroAppInstruction.MicroAppID;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.customization.BLECustomization;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.customization.BLENonCustomization;
import com.misfit.frameworks.common.enums.Gesture;
import java.util.ArrayList;
import java.util.List;

public class MicroAppMapping extends BLEMapping implements Comparable {
    private BLECustomization customization;
    private String[] declarationFiles;
    private Gesture gesture;
    private String microAppId;

    public MicroAppMapping(Gesture gesture, String str, String str2) {
        super(2);
        this.gesture = gesture;
        this.microAppId = str;
        this.declarationFiles = new String[1];
        this.declarationFiles[0] = str2;
        this.customization = new BLENonCustomization();
    }

    public MicroAppMapping(Gesture gesture, String str, String[] strArr) {
        super(2);
        this.gesture = gesture;
        this.microAppId = str;
        this.declarationFiles = strArr;
        this.customization = new BLENonCustomization();
    }

    public MicroAppMapping(Gesture gesture, String str, String[] strArr, BLECustomization bLECustomization) {
        this(gesture, str, strArr);
        this.customization = bLECustomization;
    }

    protected MicroAppMapping(Parcel parcel) {
        super(parcel);
        this.gesture = Gesture.fromInt(parcel.readInt());
        this.microAppId = parcel.readString();
        int readInt = parcel.readInt();
        this.declarationFiles = new String[readInt];
        for (int i = 0; i < readInt; i++) {
            this.declarationFiles[i] = parcel.readString();
        }
        this.customization = (BLECustomization) BLECustomization.CREATOR.createFromParcel(parcel);
    }

    public Gesture getGesture() {
        return this.gesture;
    }

    public void setGesture(Gesture gesture) {
        this.gesture = gesture;
    }

    public String getMicroAppId() {
        return this.microAppId;
    }

    public void setMicroAppId(String str) {
        this.microAppId = str;
    }

    public String[] getDeclarationFiles() {
        return this.declarationFiles;
    }

    public BLECustomization getCustomization() {
        return this.customization;
    }

    public void setCustomization(BLECustomization bLECustomization) {
        this.customization = bLECustomization;
    }

    public int compareTo(Object obj) {
        if (obj == null || !(obj instanceof MicroAppMapping)) {
            return 1;
        }
        MicroAppMapping microAppMapping = (MicroAppMapping) obj;
        if (microAppMapping.getGesture() == getGesture()) {
            return 0;
        }
        if (microAppMapping.getGesture().getValue() > getGesture().getValue()) {
            return -1;
        }
        return 1;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.gesture.getValue());
        parcel.writeString(this.microAppId);
        parcel.writeInt(this.declarationFiles.length);
        for (String writeString : this.declarationFiles) {
            parcel.writeString(writeString);
        }
        this.customization.writeToParcel(parcel, i);
    }

    public boolean isNeedStreaming() {
        return MicroAppID.getMicroAppId(this.microAppId).isNeedStreaming();
    }

    public boolean isNeedHID() {
        return MicroAppID.getMicroAppId(this.microAppId).isNeedHID();
    }

    protected String getHash() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mType).append(":").append(this.gesture).append(":").append(this.microAppId).append(":");
        for (String append : this.declarationFiles) {
            stringBuilder.append(append).append(":");
        }
        stringBuilder.append(this.customization.getHash());
        return stringBuilder.toString();
    }

    public static List<MicroAppMapping> convertToMicroAppMapping(List<BLEMapping> list) {
        List<MicroAppMapping> arrayList = new ArrayList();
        for (BLEMapping bLEMapping : list) {
            arrayList.add((MicroAppMapping) bLEMapping);
        }
        return arrayList;
    }

    public static List<BLEMapping> convertToBLEMapping(List<MicroAppMapping> list) {
        List<BLEMapping> arrayList = new ArrayList();
        arrayList.addAll(list);
        return arrayList;
    }
}
