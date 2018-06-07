package com.misfit.frameworks.buttonservice.model.microapp.mapping;

import android.util.Log;
import com.fossil.cfk;
import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.google.gson.JsonParseException;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.customization.BLECustomization;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.customization.BLECustomizationDeserializer;
import java.lang.reflect.Type;

public class BLEMappingDeserializer implements cfo<BLEMapping> {
    public BLEMapping deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        Log.d(BLEMappingDeserializer.class.getName(), com_fossil_cfp.toString());
        int asInt = com_fossil_cfp.WA().fq("mType").getAsInt();
        cfk com_fossil_cfk = new cfk();
        com_fossil_cfk.a(BLECustomization.class, new BLECustomizationDeserializer());
        switch (asInt) {
            case 1:
                return (BLEMapping) com_fossil_cfk.Wu().a(com_fossil_cfp, LinkMapping.class);
            case 2:
                return (BLEMapping) com_fossil_cfk.Wu().a(com_fossil_cfp, MicroAppMapping.class);
            default:
                return null;
        }
    }
}
