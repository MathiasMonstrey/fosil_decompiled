package com.fossil;

import com.misfit.frameworks.common.log.MFLogger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ars {
    public static Date cN(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.US);
        Date date = new Date();
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException e) {
            MFLogger.m12671e(ars.class.getSimpleName(), "String format is not valid ex=" + e);
        }
        return date;
    }
}
