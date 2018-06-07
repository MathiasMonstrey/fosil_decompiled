package com.fossil;

import java.io.UnsupportedEncodingException;
import okio.ByteString;

public final class dvb {
    public static String aT(String str, String str2) {
        try {
            return "Basic " + ByteString.of((str + ":" + str2).getBytes("ISO-8859-1")).base64();
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError();
        }
    }
}
