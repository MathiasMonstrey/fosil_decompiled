package com.fossil;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import org.joda.time.DateTimeConstants;

public class ebx {
    private static final TimeZone dDr = TimeZone.getTimeZone("GMT");

    public static String m10465c(Date date, boolean z) {
        return m10462a(date, z, dDr);
    }

    public static String m10462a(Date date, boolean z, TimeZone timeZone) {
        int length;
        Calendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        int length2 = "yyyy-MM-ddThh:mm:ss".length() + (z ? ".sss".length() : 0);
        if (timeZone.getRawOffset() == 0) {
            length = "Z".length();
        } else {
            length = "+hh:mm".length();
        }
        StringBuilder stringBuilder = new StringBuilder(length + length2);
        m10463a(stringBuilder, gregorianCalendar.get(1), "yyyy".length());
        stringBuilder.append('-');
        m10463a(stringBuilder, gregorianCalendar.get(2) + 1, "MM".length());
        stringBuilder.append('-');
        m10463a(stringBuilder, gregorianCalendar.get(5), "dd".length());
        stringBuilder.append('T');
        m10463a(stringBuilder, gregorianCalendar.get(11), "hh".length());
        stringBuilder.append(':');
        m10463a(stringBuilder, gregorianCalendar.get(12), "mm".length());
        stringBuilder.append(':');
        m10463a(stringBuilder, gregorianCalendar.get(13), "ss".length());
        if (z) {
            stringBuilder.append('.');
            m10463a(stringBuilder, gregorianCalendar.get(14), "sss".length());
        }
        length = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (length != 0) {
            int abs = Math.abs((length / DateTimeConstants.MILLIS_PER_MINUTE) / 60);
            int abs2 = Math.abs((length / DateTimeConstants.MILLIS_PER_MINUTE) % 60);
            stringBuilder.append(length < 0 ? '-' : '+');
            m10463a(stringBuilder, abs, "hh".length());
            stringBuilder.append(':');
            m10463a(stringBuilder, abs2, "mm".length());
        } else {
            stringBuilder.append('Z');
        }
        return stringBuilder.toString();
    }

    public static Date parse(String str) {
        Throwable th;
        try {
            int parseInt;
            String str2;
            int parseInt2 = parseInt(str, 0, 4);
            m10464b(str, 4, '-');
            int parseInt3 = parseInt(str, 5, 7);
            m10464b(str, 7, '-');
            int parseInt4 = parseInt(str, 8, 10);
            m10464b(str, 10, 'T');
            int parseInt5 = parseInt(str, 11, 13);
            m10464b(str, 13, ':');
            int parseInt6 = parseInt(str, 14, 16);
            m10464b(str, 16, ':');
            int i = 19;
            int parseInt7 = parseInt(str, 17, 19);
            if (str.charAt(19) == '.') {
                m10464b(str, 19, '.');
                i = 23;
                parseInt = parseInt(str, 20, 23);
            } else {
                parseInt = 0;
            }
            char charAt = str.charAt(i);
            while (charAt != '+' && charAt != '-' && charAt != 'Z') {
                i++;
                if (i == str.length()) {
                    throw new IndexOutOfBoundsException("Invalid time zone indicator " + charAt);
                }
                charAt = str.charAt(i);
            }
            if (charAt == '+' || charAt == '-') {
                str2 = "GMT" + str.substring(i);
            } else {
                str2 = "GMT";
            }
            TimeZone timeZone = TimeZone.getTimeZone(str2);
            if (timeZone.getID().equals(str2)) {
                Calendar gregorianCalendar = new GregorianCalendar(timeZone);
                gregorianCalendar.setLenient(false);
                gregorianCalendar.set(1, parseInt2);
                gregorianCalendar.set(2, parseInt3 - 1);
                gregorianCalendar.set(5, parseInt4);
                gregorianCalendar.set(11, parseInt5);
                gregorianCalendar.set(12, parseInt6);
                gregorianCalendar.set(13, parseInt7);
                gregorianCalendar.set(14, parseInt);
                return gregorianCalendar.getTime();
            }
            throw new IndexOutOfBoundsException();
        } catch (Throwable e) {
            th = e;
        } catch (Throwable e2) {
            th = e2;
        } catch (Throwable e22) {
            th = e22;
        }
        throw new IllegalArgumentException("Failed to parse date [" + (str == null ? null : '\"' + str + "'") + "]: " + th.getMessage(), th);
    }

    private static void m10464b(String str, int i, char c) throws IndexOutOfBoundsException {
        char charAt = str.charAt(i);
        if (charAt != c) {
            throw new IndexOutOfBoundsException("Expected '" + c + "' character but found '" + charAt + "'");
        }
    }

    private static int parseInt(String str, int i, int i2) throws NumberFormatException {
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        int i3;
        int i4 = 0;
        if (i < i2) {
            i3 = i + 1;
            i4 = Character.digit(str.charAt(i), 10);
            if (i4 < 0) {
                throw new NumberFormatException("Invalid number: " + str);
            }
            i4 = -i4;
            i = i3;
        }
        while (i < i2) {
            i3 = i + 1;
            int digit = Character.digit(str.charAt(i), 10);
            if (digit < 0) {
                throw new NumberFormatException("Invalid number: " + str);
            }
            i4 = (i4 * 10) - digit;
            i = i3;
        }
        return -i4;
    }

    private static void m10463a(StringBuilder stringBuilder, int i, int i2) {
        String num = Integer.toString(i);
        for (int length = i2 - num.length(); length > 0; length--) {
            stringBuilder.append('0');
        }
        stringBuilder.append(num);
    }
}
