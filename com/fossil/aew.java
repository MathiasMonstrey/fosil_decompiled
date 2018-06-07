package com.fossil;

import com.fasterxml.jackson.core.Base64Variant;

public final class aew {
    public static final Base64Variant aLp = new Base64Variant("MIME", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
    public static final Base64Variant aLq = new Base64Variant(aLp, "MIME-NO-LINEFEEDS", Integer.MAX_VALUE);
    public static final Base64Variant aLr = new Base64Variant(aLp, "PEM", true, '=', 64);
    public static final Base64Variant aLs;

    static {
        StringBuilder stringBuilder = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
        stringBuilder.setCharAt(stringBuilder.indexOf("+"), '-');
        stringBuilder.setCharAt(stringBuilder.indexOf("/"), '_');
        aLs = new Base64Variant("MODIFIED-FOR-URL", stringBuilder.toString(), false, '\u0000', Integer.MAX_VALUE);
    }

    public static Base64Variant zz() {
        return aLq;
    }

    public static Base64Variant aP(String str) throws IllegalArgumentException {
        if (aLp._name.equals(str)) {
            return aLp;
        }
        if (aLq._name.equals(str)) {
            return aLq;
        }
        if (aLr._name.equals(str)) {
            return aLr;
        }
        if (aLs._name.equals(str)) {
            return aLs;
        }
        String str2;
        if (str == null) {
            str2 = "<null>";
        } else {
            str2 = "'" + str + "'";
        }
        throw new IllegalArgumentException("No Base64Variant with name " + str2);
    }
}
