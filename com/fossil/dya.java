package com.fossil;

public final class dya {
    public static byte[] m10275c(String str, int i, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(i);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        return dxx.as(stringBuffer.toString().substring(1, 9).getBytes()).getBytes();
    }
}
