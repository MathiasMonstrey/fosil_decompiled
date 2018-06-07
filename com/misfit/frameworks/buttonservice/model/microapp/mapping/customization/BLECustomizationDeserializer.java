package com.misfit.frameworks.buttonservice.model.microapp.mapping.customization;

import android.util.Log;
import com.fossil.cfj;
import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class BLECustomizationDeserializer implements cfo<BLECustomization> {
    public BLECustomization deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        Log.d(BLECustomizationDeserializer.class.getName(), com_fossil_cfp.toString());
        switch (com_fossil_cfp.WA().fq("mType").getAsInt()) {
            case 1:
                return (BLECustomization) new cfj().a(com_fossil_cfp, BLEGoalTrackingCustomization.class);
            default:
                return new BLENonCustomization();
        }
    }
}
