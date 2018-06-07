package com.fasterxml.jackson.databind.util;

import com.fossil.afr;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class StdDateFormat extends DateFormat {
    protected static final String[] ALL_FORMATS = new String[]{DATE_FORMAT_STR_ISO8601, "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", DATE_FORMAT_STR_RFC1123, DATE_FORMAT_STR_PLAIN};
    protected static final DateFormat DATE_FORMAT_ISO8601 = new SimpleDateFormat(DATE_FORMAT_STR_ISO8601, aWg);
    protected static final DateFormat DATE_FORMAT_ISO8601_Z = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", aWg);
    protected static final DateFormat DATE_FORMAT_PLAIN = new SimpleDateFormat(DATE_FORMAT_STR_PLAIN, aWg);
    protected static final DateFormat DATE_FORMAT_RFC1123 = new SimpleDateFormat(DATE_FORMAT_STR_RFC1123, aWg);
    protected static final String DATE_FORMAT_STR_ISO8601 = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    protected static final String DATE_FORMAT_STR_ISO8601_Z = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    protected static final String DATE_FORMAT_STR_PLAIN = "yyyy-MM-dd";
    protected static final String DATE_FORMAT_STR_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";
    private static final TimeZone aWf = TimeZone.getTimeZone("GMT");
    private static final Locale aWg = Locale.US;
    public static final StdDateFormat instance = new StdDateFormat();
    protected transient DateFormat _formatISO8601;
    protected transient DateFormat _formatISO8601_z;
    protected transient DateFormat _formatPlain;
    protected transient DateFormat _formatRFC1123;
    protected final Locale _locale;
    protected transient TimeZone _timezone;

    static {
        DATE_FORMAT_RFC1123.setTimeZone(aWf);
        DATE_FORMAT_ISO8601.setTimeZone(aWf);
        DATE_FORMAT_ISO8601_Z.setTimeZone(aWf);
        DATE_FORMAT_PLAIN.setTimeZone(aWf);
    }

    public StdDateFormat() {
        this._locale = aWg;
    }

    @Deprecated
    public StdDateFormat(TimeZone timeZone) {
        this(timeZone, aWg);
    }

    public StdDateFormat(TimeZone timeZone, Locale locale) {
        this._timezone = timeZone;
        this._locale = locale;
    }

    public static TimeZone getDefaultTimeZone() {
        return aWf;
    }

    public StdDateFormat withTimeZone(TimeZone timeZone) {
        if (timeZone == null) {
            timeZone = aWf;
        }
        return timeZone.equals(this._timezone) ? this : new StdDateFormat(timeZone, this._locale);
    }

    public StdDateFormat withLocale(Locale locale) {
        return locale.equals(this._locale) ? this : new StdDateFormat(this._timezone, locale);
    }

    public StdDateFormat clone() {
        return new StdDateFormat(this._timezone, this._locale);
    }

    @Deprecated
    public static DateFormat getBlueprintISO8601Format() {
        return DATE_FORMAT_ISO8601;
    }

    @Deprecated
    public static DateFormat getISO8601Format(TimeZone timeZone) {
        return getISO8601Format(timeZone, aWg);
    }

    public static DateFormat getISO8601Format(TimeZone timeZone, Locale locale) {
        return m2766a(DATE_FORMAT_ISO8601, DATE_FORMAT_STR_ISO8601, timeZone, locale);
    }

    @Deprecated
    public static DateFormat getBlueprintRFC1123Format() {
        return DATE_FORMAT_RFC1123;
    }

    public static DateFormat getRFC1123Format(TimeZone timeZone, Locale locale) {
        return m2766a(DATE_FORMAT_RFC1123, DATE_FORMAT_STR_RFC1123, timeZone, locale);
    }

    @Deprecated
    public static DateFormat getRFC1123Format(TimeZone timeZone) {
        return getRFC1123Format(timeZone, aWg);
    }

    public TimeZone getTimeZone() {
        return this._timezone;
    }

    public void setTimeZone(TimeZone timeZone) {
        if (!timeZone.equals(this._timezone)) {
            this._formatRFC1123 = null;
            this._formatISO8601 = null;
            this._formatISO8601_z = null;
            this._formatPlain = null;
            this._timezone = timeZone;
        }
    }

    public Date parse(String str) throws ParseException {
        String trim = str.trim();
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = parse(trim, parsePosition);
        if (parse != null) {
            return parse;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str2 : ALL_FORMATS) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("\", \"");
            } else {
                stringBuilder.append('\"');
            }
            stringBuilder.append(str2);
        }
        stringBuilder.append('\"');
        throw new ParseException(String.format("Can not parse date \"%s\": not compatible with any of standard forms (%s)", new Object[]{trim, stringBuilder.toString()}), parsePosition.getErrorIndex());
    }

    public Date parse(String str, ParsePosition parsePosition) {
        if (looksLikeISO8601(str)) {
            return parseAsISO8601(str, parsePosition);
        }
        int length = str.length();
        while (true) {
            length--;
            if (length < 0) {
                break;
            }
            char charAt = str.charAt(length);
            if ((charAt < '0' || charAt > '9') && (length > 0 || charAt != '-')) {
                break;
            }
        }
        if (length >= 0 || (str.charAt(0) != '-' && !afr.m3158b(str, false))) {
            return parseAsRFC1123(str, parsePosition);
        }
        return new Date(Long.parseLong(str));
    }

    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (this._formatISO8601 == null) {
            this._formatISO8601 = m2766a(DATE_FORMAT_ISO8601, DATE_FORMAT_STR_ISO8601, this._timezone, this._locale);
        }
        return this._formatISO8601.format(date, stringBuffer, fieldPosition);
    }

    public String toString() {
        String str = "DateFormat " + getClass().getName();
        TimeZone timeZone = this._timezone;
        if (timeZone != null) {
            str = str + " (timezone: " + timeZone + ")";
        }
        return str + "(locale: " + this._locale + ")";
    }

    protected boolean looksLikeISO8601(String str) {
        if (str.length() >= 5 && Character.isDigit(str.charAt(0)) && Character.isDigit(str.charAt(3)) && str.charAt(4) == '-') {
            return true;
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected java.util.Date parseAsISO8601(java.lang.String r9, java.text.ParsePosition r10) {
        /*
        r8 = this;
        r7 = 90;
        r6 = 84;
        r5 = 58;
        r4 = 12;
        r3 = 48;
        r1 = r9.length();
        r0 = r1 + -1;
        r0 = r9.charAt(r0);
        r2 = 10;
        if (r1 > r2) goto L_0x0035;
    L_0x0018:
        r2 = java.lang.Character.isDigit(r0);
        if (r2 == 0) goto L_0x0035;
    L_0x001e:
        r0 = r8._formatPlain;
        if (r0 != 0) goto L_0x0030;
    L_0x0022:
        r0 = DATE_FORMAT_PLAIN;
        r1 = "yyyy-MM-dd";
        r2 = r8._timezone;
        r3 = r8._locale;
        r0 = m2766a(r0, r1, r2, r3);
        r8._formatPlain = r0;
    L_0x0030:
        r0 = r0.parse(r9, r10);
        return r0;
    L_0x0035:
        if (r0 != r7) goto L_0x0062;
    L_0x0037:
        r0 = r8._formatISO8601_z;
        if (r0 != 0) goto L_0x0049;
    L_0x003b:
        r0 = DATE_FORMAT_ISO8601_Z;
        r2 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
        r3 = r8._timezone;
        r4 = r8._locale;
        r0 = m2766a(r0, r2, r3, r4);
        r8._formatISO8601_z = r0;
    L_0x0049:
        r2 = r1 + -4;
        r2 = r9.charAt(r2);
        if (r2 != r5) goto L_0x0030;
    L_0x0051:
        r2 = new java.lang.StringBuilder;
        r2.<init>(r9);
        r1 = r1 + -1;
        r3 = ".000";
        r2.insert(r1, r3);
        r9 = r2.toString();
        goto L_0x0030;
    L_0x0062:
        r0 = cd(r9);
        if (r0 == 0) goto L_0x00ee;
    L_0x0068:
        r0 = r1 + -3;
        r0 = r9.charAt(r0);
        if (r0 != r5) goto L_0x00b1;
    L_0x0070:
        r0 = new java.lang.StringBuilder;
        r0.<init>(r9);
        r2 = r1 + -3;
        r1 = r1 + -2;
        r0.delete(r2, r1);
        r9 = r0.toString();
    L_0x0080:
        r0 = r9.length();
        r1 = r9.lastIndexOf(r6);
        r1 = r0 - r1;
        r1 = r1 + -6;
        if (r1 >= r4) goto L_0x009c;
    L_0x008e:
        r0 = r0 + -5;
        r2 = new java.lang.StringBuilder;
        r2.<init>(r9);
        switch(r1) {
            case 5: goto L_0x00e8;
            case 6: goto L_0x00e3;
            case 7: goto L_0x0098;
            case 8: goto L_0x00dd;
            case 9: goto L_0x00d7;
            case 10: goto L_0x00d1;
            case 11: goto L_0x00cd;
            default: goto L_0x0098;
        };
    L_0x0098:
        r9 = r2.toString();
    L_0x009c:
        r0 = r8._formatISO8601;
        r1 = r8._formatISO8601;
        if (r1 != 0) goto L_0x0030;
    L_0x00a2:
        r0 = DATE_FORMAT_ISO8601;
        r1 = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
        r2 = r8._timezone;
        r3 = r8._locale;
        r0 = m2766a(r0, r1, r2, r3);
        r8._formatISO8601 = r0;
        goto L_0x0030;
    L_0x00b1:
        r1 = 43;
        if (r0 == r1) goto L_0x00b9;
    L_0x00b5:
        r1 = 45;
        if (r0 != r1) goto L_0x0080;
    L_0x00b9:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0 = r0.append(r9);
        r1 = "00";
        r0 = r0.append(r1);
        r9 = r0.toString();
        goto L_0x0080;
    L_0x00cd:
        r2.insert(r0, r3);
        goto L_0x0098;
    L_0x00d1:
        r1 = "00";
        r2.insert(r0, r1);
        goto L_0x0098;
    L_0x00d7:
        r1 = "000";
        r2.insert(r0, r1);
        goto L_0x0098;
    L_0x00dd:
        r1 = ".000";
        r2.insert(r0, r1);
        goto L_0x0098;
    L_0x00e3:
        r1 = "00.000";
        r2.insert(r0, r1);
    L_0x00e8:
        r1 = ":00.000";
        r2.insert(r0, r1);
        goto L_0x0098;
    L_0x00ee:
        r0 = new java.lang.StringBuilder;
        r0.<init>(r9);
        r2 = r9.lastIndexOf(r6);
        r1 = r1 - r2;
        r1 = r1 + -1;
        if (r1 >= r4) goto L_0x0104;
    L_0x00fc:
        switch(r1) {
            case 9: goto L_0x0125;
            case 10: goto L_0x0122;
            case 11: goto L_0x011f;
            default: goto L_0x00ff;
        };
    L_0x00ff:
        r1 = ".000";
        r0.append(r1);
    L_0x0104:
        r0.append(r7);
        r9 = r0.toString();
        r0 = r8._formatISO8601_z;
        if (r0 != 0) goto L_0x0030;
    L_0x010f:
        r0 = DATE_FORMAT_ISO8601_Z;
        r1 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
        r2 = r8._timezone;
        r3 = r8._locale;
        r0 = m2766a(r0, r1, r2, r3);
        r8._formatISO8601_z = r0;
        goto L_0x0030;
    L_0x011f:
        r0.append(r3);
    L_0x0122:
        r0.append(r3);
    L_0x0125:
        r0.append(r3);
        goto L_0x0104;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.util.StdDateFormat.parseAsISO8601(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    protected Date parseAsRFC1123(String str, ParsePosition parsePosition) {
        if (this._formatRFC1123 == null) {
            this._formatRFC1123 = m2766a(DATE_FORMAT_RFC1123, DATE_FORMAT_STR_RFC1123, this._timezone, this._locale);
        }
        return this._formatRFC1123.parse(str, parsePosition);
    }

    private static final boolean cd(String str) {
        int length = str.length();
        if (length >= 6) {
            char charAt = str.charAt(length - 6);
            if (charAt == '+' || charAt == '-') {
                return true;
            }
            charAt = str.charAt(length - 5);
            if (charAt == '+' || charAt == '-') {
                return true;
            }
            char charAt2 = str.charAt(length - 3);
            if (charAt2 == '+' || charAt2 == '-') {
                return true;
            }
        }
        return false;
    }

    private static final DateFormat m2766a(DateFormat dateFormat, String str, TimeZone timeZone, Locale locale) {
        DateFormat dateFormat2;
        if (locale.equals(aWg)) {
            dateFormat2 = (DateFormat) dateFormat.clone();
            if (timeZone != null) {
                dateFormat2.setTimeZone(timeZone);
            }
        } else {
            dateFormat2 = new SimpleDateFormat(str, locale);
            if (timeZone == null) {
                timeZone = aWf;
            }
            dateFormat2.setTimeZone(timeZone);
        }
        return dateFormat2;
    }
}
