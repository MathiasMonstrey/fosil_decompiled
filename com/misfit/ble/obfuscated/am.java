package com.misfit.ble.obfuscated;

import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.ScriptIntrinsicBLAS;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum am implements ap {
    RESULT_ATT_SUCCESS(0),
    RESULT_ATT_ERR_HANDLE(1),
    RESULT_ATT_ERR_READ(2),
    RESULT_ATT_ERR_WRITE(3),
    RESULT_ATT_ERR_INVALID_PDU(4),
    RESULT_ATT_ERR_AUTH(5),
    RESULT_ATT_ERR_NOT_SUP(6),
    RESULT_ATT_ERR_OFFSET(7),
    RESULT_ATT_ERR_AUTHOR(8),
    RESULT_ATT_ERR_QUEUE_FULL(9),
    RESULT_ATT_ERR_NOT_FOUND(10),
    RESULT_ATT_ERR_NOT_LONG(11),
    RESULT_ATT_ERR_KEY_SIZE(12),
    RESULT_ATT_ERR_LENGTH(13),
    RESULT_ATT_ERR_UNLIKELY(14),
    RESULT_ATT_ERR_ENC(15),
    RESULT_ATT_ERR_GROUP_TYPE(16),
    RESULT_ATT_ERR_RESOURCES(17),
    RESULT_ATT_ERR_CCCD(253),
    RESULT_ATT_ERR_IN_PROGRESS(254),
    RESULT_ATT_ERR_RANGE(255),
    RESULT_ATT_ERR_MEMORY(112),
    RESULT_ATT_ERR_TIMEOUT(113),
    RESULT_ATT_ERR_OVERFLOW(114),
    RESULT_ATT_ERR_INVALID_RSP(115),
    RESULT_ATT_ERR_CANCELLED(116),
    RESULT_ATT_ERR_UNDEFINED(117),
    RESULT_ATT_ERR_REQ_NOT_FOUND(118),
    RESULT_ATT_ERR_MTU_EXCEEDED(119),
    RESULT_ATT_CONTINUING(120),
    RESULT_MP_ERR_ST_VALUE_RANGE(Allocation.USAGE_SHARED),
    RESULT_MP_ERR_ST_FUNCTION_NOT_IMPLEMENTED(129),
    RESULT_MP_ERR_ST_INVALID_FUNCTION(130),
    RESULT_MP_APP_AUTH_REQUIRED(ScriptIntrinsicBLAS.NON_UNIT),
    RESULT_MP_AU_ST_INVALID_MESSAGE(ScriptIntrinsicBLAS.UNIT),
    RESULT_MP_AU_ST_INVALID_STATE(133),
    RESULT_MP_AU_ST_AUTH_FAILED(134),
    RESULT_MP_ERR_ST_RESOURCE_UNAVAILABLE(135);
    
    private static final Map<Integer, am> aD = null;
    private int eo;

    static {
        aD = new HashMap();
        Iterator it = EnumSet.allOf(am.class).iterator();
        while (it.hasNext()) {
            am amVar = (am) it.next();
            aD.put(Integer.valueOf(amVar.getId()), amVar);
        }
    }

    private am(int i) {
        this.eo = i;
    }

    public static am m14694c(int i) {
        return (am) aD.get(Integer.valueOf(i));
    }

    public int getId() {
        return this.eo;
    }
}
