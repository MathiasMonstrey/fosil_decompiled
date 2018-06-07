package com.fossil;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class dwt {
    private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
    private static final ThreadLocal<DateFormat> dzv = new C32771();
    private static final String[] dzw = new String[]{"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
    private static final DateFormat[] dzx = new DateFormat[dzw.length];

    static class C32771 extends ThreadLocal<DateFormat> {
        C32771() {
        }

        protected DateFormat initialValue() {
            DateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(dwt.GMT);
            return simpleDateFormat;
        }
    }

    public static Date parse(String str) {
        int i = 0;
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = ((DateFormat) dzv.get()).parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return parse;
        }
        synchronized (dzw) {
            int length = dzw.length;
            while (i < length) {
                DateFormat dateFormat = dzx[i];
                if (dateFormat == null) {
                    dateFormat = new SimpleDateFormat(dzw[i], Locale.US);
                    dateFormat.setTimeZone(GMT);
                    dzx[i] = dateFormat;
                }
                parsePosition.setIndex(0);
                parse = dateFormat.parse(str, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return parse;
                }
                i++;
            }
            return null;
        }
    }
}
