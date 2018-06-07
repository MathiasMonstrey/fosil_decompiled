package com.misfit.frameworks.buttonservice.model.microapp;

import android.os.Parcel;
import com.misfit.ble.setting.uapp.UAppEnum.UAppID;
import com.misfit.ble.setting.uapp.UAppEnum.UAppVariant;
import com.misfit.ble.setting.uapp.instruction.UAppInstruction;
import com.misfit.ble.setting.uapp.instruction.builder.UAppInstructionFactory;
import com.misfit.ble.setting.uapp.instruction.builder.UAppInstructionFactory.UAppErrorInstructionType;
import java.util.List;

public class ErrorInstruction extends MicroAppInstruction {
    ErrorInstruction(UAppID uAppID, UAppVariant uAppVariant) {
        super(uAppID, uAppVariant);
    }

    protected ErrorInstruction(Parcel parcel) {
        super(parcel);
    }

    public List<UAppInstruction> getInstructions() {
        switch (1.$SwitchMap$com$misfit$ble$setting$uapp$UAppEnum$UAppID[getDeclarationID().ordinal()]) {
            case 1:
                if (getVariantID() == UAppVariant.UAPP_VARIANT_ETA) {
                    return UAppInstructionFactory.buildErrorInstruction(UAppErrorInstructionType.ETA);
                }
                if (getVariantID() == UAppVariant.UAPP_VARIANT_TRAVEL) {
                    return UAppInstructionFactory.buildErrorInstruction(UAppErrorInstructionType.TRAVEL_TIME);
                }
                return null;
            case 2:
                return UAppInstructionFactory.buildErrorInstruction(UAppErrorInstructionType.WEATHER);
            default:
                return UAppInstructionFactory.buildErrorInstruction(UAppErrorInstructionType.WEATHER);
        }
    }
}
