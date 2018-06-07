package com.misfit.frameworks.buttonservice.model.microapp;

import android.os.Parcel;
import com.misfit.ble.setting.uapp.UAppEnum.UAppID;
import com.misfit.ble.setting.uapp.UAppEnum.UAppVariant;
import com.misfit.ble.setting.uapp.instruction.UAppInstruction;
import com.misfit.ble.setting.uapp.instruction.builder.UAppInstructionFactory;
import java.util.List;

public class RingPhoneInstruction extends MicroAppInstruction {
    public RingPhoneInstruction() {
        super(UAppID.UAPP_RING_PHONE, UAppVariant.UAPP_VARIANT_STANDARD);
    }

    protected RingPhoneInstruction(Parcel parcel) {
        super(parcel);
    }

    public String toString() {
        return "[Ring phone Instruction]:[]";
    }

    public List<UAppInstruction> getInstructions() {
        return UAppInstructionFactory.buildRingPhoneInstructions();
    }
}
