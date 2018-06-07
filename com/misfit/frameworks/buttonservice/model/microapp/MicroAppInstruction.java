package com.misfit.frameworks.buttonservice.model.microapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.misfit.ble.setting.uapp.UAppEnum.UAppID;
import com.misfit.ble.setting.uapp.UAppEnum.UAppVariant;
import com.misfit.ble.setting.uapp.instruction.UAppInstruction;
import java.util.List;

public abstract class MicroAppInstruction implements Parcelable {
    public static Creator<MicroAppInstruction> CREATOR = new 1();
    private final String className = getClass().getName();
    private UAppID mDeclarationID;
    private UAppVariant mVariantID;

    public abstract List<UAppInstruction> getInstructions();

    protected MicroAppInstruction(UAppID uAppID, UAppVariant uAppVariant) {
        this.mDeclarationID = uAppID;
        this.mVariantID = uAppVariant;
    }

    protected MicroAppInstruction(Parcel parcel) {
        this.mDeclarationID = UAppID.values()[parcel.readInt()];
        this.mVariantID = UAppVariant.values()[parcel.readInt()];
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.className);
        parcel.writeInt(this.mDeclarationID.ordinal());
        parcel.writeInt(this.mVariantID.ordinal());
    }

    public UAppID getDeclarationID() {
        return this.mDeclarationID;
    }

    public void setDeclarationID(UAppID uAppID) {
        this.mDeclarationID = uAppID;
    }

    public UAppVariant getVariantID() {
        return this.mVariantID;
    }

    public void setVariantID(UAppVariant uAppVariant) {
        this.mVariantID = uAppVariant;
    }
}
