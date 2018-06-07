package com.misfit.frameworks.buttonservice.model.microapp.mapping;

import android.os.Parcel;
import com.misfit.frameworks.common.enums.Action.HIDAction;
import com.misfit.frameworks.common.enums.Action.StreamingAction;
import com.misfit.frameworks.common.enums.Gesture;
import java.util.ArrayList;
import java.util.List;

public class LinkMapping extends BLEMapping {
    private int action;
    private String extraInfo;
    private Gesture gesture;

    public LinkMapping(Gesture gesture, int i, String str) {
        super(1);
        this.gesture = gesture;
        this.action = i;
        this.extraInfo = str;
    }

    protected LinkMapping(Parcel parcel) {
        super(parcel);
        this.gesture = Gesture.fromInt(parcel.readInt());
        this.action = parcel.readInt();
        this.extraInfo = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.gesture.getValue());
        parcel.writeInt(this.action);
        parcel.writeString(this.extraInfo);
    }

    public boolean isNeedStreaming() {
        return StreamingAction.isActionBelongToThisType(this.action);
    }

    public boolean isNeedHID() {
        return HIDAction.isActionBelongToThisType(this.action);
    }

    protected String getHash() {
        return this.mType + ":" + getGesture().getValue() + ":" + this.action + ":" + this.extraInfo;
    }

    public Gesture getGesture() {
        return this.gesture;
    }

    public void setGesture(Gesture gesture) {
        this.gesture = gesture;
    }

    public int getAction() {
        return this.action;
    }

    public void setAction(int i) {
        this.action = i;
    }

    public String getExtraInfo() {
        return this.extraInfo;
    }

    public void setExtraInfo(String str) {
        this.extraInfo = str;
    }

    public static List<LinkMapping> convertToLinkMapping(List<BLEMapping> list) {
        List<LinkMapping> arrayList = new ArrayList();
        for (BLEMapping bLEMapping : list) {
            arrayList.add((LinkMapping) bLEMapping);
        }
        return arrayList;
    }

    public static List<BLEMapping> convertToBLEMapping(List<LinkMapping> list) {
        List<BLEMapping> arrayList = new ArrayList();
        arrayList.addAll(list);
        return arrayList;
    }
}
