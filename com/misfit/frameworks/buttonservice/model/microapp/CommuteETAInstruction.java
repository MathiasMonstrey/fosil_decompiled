package com.misfit.frameworks.buttonservice.model.microapp;

import android.os.Parcel;
import com.misfit.ble.setting.uapp.UAppEnum.UAppID;
import com.misfit.ble.setting.uapp.UAppEnum.UAppVariant;
import com.misfit.ble.setting.uapp.instruction.UAppInstruction;
import com.misfit.ble.setting.uapp.instruction.builder.UAppInstructionFactory;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.List;

public class CommuteETAInstruction extends MicroAppInstruction {
    private static final String TAG = CommuteETAInstruction.class.getSimpleName();
    private int mHour;
    private int mMinute;

    public CommuteETAInstruction(int i, int i2) throws IllegalArgumentException {
        super(UAppID.UAPP_COMMUTE_TIME, UAppVariant.UAPP_VARIANT_ETA);
        this.mHour = i;
        this.mMinute = i2;
        verifyData();
    }

    protected CommuteETAInstruction(Parcel parcel) {
        super(parcel);
        this.mHour = parcel.readInt();
        this.mMinute = parcel.readInt();
    }

    private void verifyData() throws IllegalArgumentException {
        if (this.mHour < 0 || this.mHour > 11) {
            throw new IllegalArgumentException("The hour value must be between 0 and 11.");
        } else if (this.mMinute < 0 || this.mMinute > 59) {
            throw new IllegalArgumentException("The minute value must be between 0 and 59.");
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.mHour);
        parcel.writeInt(this.mMinute);
    }

    public List<UAppInstruction> getInstructions() {
        try {
            return UAppInstructionFactory.buildETAInstructions(this.mHour, this.mMinute);
        } catch (IllegalArgumentException e) {
            MFLogger.e(TAG, "Inside " + TAG + ".getInstructions, error=" + e.getMessage());
            return ErrorInstructionFactory.getErrorInstructions(0).getInstructions();
        }
    }

    public String toString() {
        return "[Commute ETA Instruction]:[hour: " + this.mHour + ", minute:" + this.mMinute + "]";
    }

    public int getHour() {
        return this.mHour;
    }

    public void setHour(int i) {
        this.mHour = i;
    }

    public int getMinute() {
        return this.mMinute;
    }

    public void setMinute(int i) {
        this.mMinute = i;
    }
}
