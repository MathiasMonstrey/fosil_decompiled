package com.portfolio.platform.enums;

import com.fossil.cco;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public enum PermissionCodes {
    BLUETOOTH_OFF(0),
    LOCATION_PERMISSION_OFF(1),
    LOCATION_SERVICE_OFF(2),
    LOCATION_PERMISSION_FEATURE_OFF(3),
    LOCATION_SERVICE_FEATURE_OFF(4);
    
    private int mCode;

    private PermissionCodes(int i) {
        this.mCode = i;
    }

    public static List<PermissionCodes> convertBLEPermissionErrorCode(ArrayList<Integer> arrayList) {
        cco.ce(arrayList);
        List<PermissionCodes> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            switch (((Integer) it.next()).intValue()) {
                case FailureCode.BLUETOOTH_IS_DISABLED /*1101*/:
                    arrayList2.add(BLUETOOTH_OFF);
                    break;
                case FailureCode.LOCATION_SERVICE_DISABLED /*1112*/:
                    arrayList2.add(LOCATION_SERVICE_OFF);
                    break;
                case FailureCode.LOCATION_ACCESS_DENIED /*1113*/:
                    arrayList2.add(LOCATION_PERMISSION_OFF);
                    break;
                default:
                    break;
            }
        }
        return arrayList2;
    }

    public int getCode() {
        return this.mCode;
    }
}
