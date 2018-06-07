package com.fossil;

import com.misfit.frameworks.common.constants.Constants;

public class ecy extends eil {
    @cga("recorder_type_key")
    String dDM;
    @cga("qs_type")
    String type;

    public static ecy m10513a(ect com_fossil_ect) {
        ecy com_fossil_ecy = new ecy();
        if (com_fossil_ect.aCF() != null && com_fossil_ect.aCF().get(0) != null) {
            com_fossil_ecy.type = Constants.ACTIVITY;
            com_fossil_ecy.dDM = (String) com_fossil_ect.aCF().get(0);
        } else if (!(com_fossil_ect.aCE() == null || com_fossil_ect.aCE().get(0) == null)) {
            com_fossil_ecy.type = "sleep";
            com_fossil_ecy.dDM = (String) com_fossil_ect.aCE().get(0);
        }
        return com_fossil_ecy;
    }
}
