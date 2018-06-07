package com.misfit.frameworks.buttonservice.model.microapp;

import android.os.Parcel;
import com.misfit.ble.setting.uapp.UAppEnum.UAppID;
import com.misfit.ble.setting.uapp.UAppEnum.UAppVariant;
import com.misfit.ble.setting.uapp.instruction.UAppInstruction;
import com.misfit.ble.setting.uapp.instruction.builder.UAppInstructionFactory;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.List;

public class CommuteTravelTimeInstruction extends MicroAppInstruction {
    private static final String TAG = CommuteTravelTimeInstruction.class.getSimpleName();
    private int mTravelTimeInMinute;

    public CommuteTravelTimeInstruction(int i) throws IllegalArgumentException {
        super(UAppID.UAPP_COMMUTE_TIME, UAppVariant.UAPP_VARIANT_TRAVEL);
        this.mTravelTimeInMinute = i;
        verifyData();
    }

    protected CommuteTravelTimeInstruction(Parcel parcel) {
        super(parcel);
        this.mTravelTimeInMinute = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.mTravelTimeInMinute);
    }

    private void verifyData() throws IllegalArgumentException {
        if (this.mTravelTimeInMinute < 0 || this.mTravelTimeInMinute > 719) {
            throw new IllegalArgumentException("The travel time minute value must be between 0 and 719.");
        }
    }

    public List<UAppInstruction> getInstructions() {
        try {
            return UAppInstructionFactory.buildTravelTimeInstructions(this.mTravelTimeInMinute);
        } catch (IllegalArgumentException e) {
            MFLogger.e(TAG, "Inside " + TAG + ".getInstructions, error=" + e.getMessage());
            return ErrorInstructionFactory.getErrorInstructions(1).getInstructions();
        }
    }

    public String toString() {
        return "[Commute Travel Time Instruction]:[travelInMinute: " + this.mTravelTimeInMinute + "]";
    }

    public int getTravelTimeInMinute() {
        return this.mTravelTimeInMinute;
    }

    public void setTravelTimeInMinute(int i) {
        this.mTravelTimeInMinute = i;
    }
}
