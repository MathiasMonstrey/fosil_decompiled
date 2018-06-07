package com.fossil;

import android.os.Bundle;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fossil.wearables.fossil.R;
import com.fossil.wearables.fsl.goaltracking.GoalPhase;
import com.misfit.frameworks.buttonservice.model.Alarm;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.ReadableInstant;
import org.joda.time.chrono.GregorianChronology;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.ISODateTimeFormat;

public class cmq {
    private static final String TAG = cmq.class.getSimpleName();
    private static final ThreadLocal<SimpleDateFormat> ceo = new C22078();
    private static final ThreadLocal<SimpleDateFormat> cxM = new C22001();
    private static final ThreadLocal<SimpleDateFormat> cxN = new C22089();
    private static final ThreadLocal<SimpleDateFormat> cxO = new ThreadLocal<SimpleDateFormat>() {
        protected /* synthetic */ Object initialValue() {
            return YL();
        }

        protected SimpleDateFormat YL() {
            return new SimpleDateFormat("EEE, MMM dd", Locale.US);
        }
    };
    private static final ThreadLocal<SimpleDateFormat> cxP = new ThreadLocal<SimpleDateFormat>() {
        protected /* synthetic */ Object initialValue() {
            return YL();
        }

        protected SimpleDateFormat YL() {
            return new SimpleDateFormat("MMM dd, yyyy", Locale.US);
        }
    };
    private static final ThreadLocal<SimpleDateFormat> cxQ = new ThreadLocal<SimpleDateFormat>() {
        protected /* synthetic */ Object initialValue() {
            return YL();
        }

        protected SimpleDateFormat YL() {
            return new SimpleDateFormat("MMM dd", Locale.US);
        }
    };
    private static final ThreadLocal<SimpleDateFormat> cxR = new ThreadLocal<SimpleDateFormat>() {
        protected /* synthetic */ Object initialValue() {
            return YL();
        }

        protected SimpleDateFormat YL() {
            return new SimpleDateFormat("EEE, MMMM d", Locale.US);
        }
    };
    private static final ThreadLocal<SimpleDateFormat> cxS = new ThreadLocal<SimpleDateFormat>() {
        protected /* synthetic */ Object initialValue() {
            return YL();
        }

        protected SimpleDateFormat YL() {
            return new SimpleDateFormat("MMMM", Locale.US);
        }
    };
    private static final ThreadLocal<SimpleDateFormat> cxT = new ThreadLocal<SimpleDateFormat>() {
        protected /* synthetic */ Object initialValue() {
            return YL();
        }

        protected SimpleDateFormat YL() {
            return new SimpleDateFormat("MMMM yyyy", Locale.US);
        }
    };
    private static final ThreadLocal<SimpleDateFormat> cxU = new C22012();
    private static final ThreadLocal<SimpleDateFormat> cxV = new C22023();
    private static final ThreadLocal<SimpleDateFormat> cxW = new C22034();
    private static final ThreadLocal<SimpleDateFormat> cxX = new C22045();
    private static final ThreadLocal<SimpleDateFormat> cxY = new C22056();
    private static final ThreadLocal<SimpleDateFormat> cxZ = new C22067();

    static class C22001 extends ThreadLocal<SimpleDateFormat> {
        C22001() {
        }

        protected /* synthetic */ Object initialValue() {
            return YL();
        }

        protected SimpleDateFormat YL() {
            return new SimpleDateFormat("yyyy-ww", Locale.US);
        }
    }

    static class C22012 extends ThreadLocal<SimpleDateFormat> {
        C22012() {
        }

        protected /* synthetic */ Object initialValue() {
            return YL();
        }

        protected SimpleDateFormat YL() {
            return new SimpleDateFormat("kk:mm:ss", Locale.US);
        }
    }

    static class C22023 extends ThreadLocal<SimpleDateFormat> {
        C22023() {
        }

        protected /* synthetic */ Object initialValue() {
            return YL();
        }

        protected SimpleDateFormat YL() {
            return new SimpleDateFormat("h:mmaa", Locale.US);
        }
    }

    static class C22034 extends ThreadLocal<SimpleDateFormat> {
        C22034() {
        }

        protected /* synthetic */ Object initialValue() {
            return YL();
        }

        protected SimpleDateFormat YL() {
            return new SimpleDateFormat("MMM dd, yyyy", Locale.US);
        }
    }

    static class C22045 extends ThreadLocal<SimpleDateFormat> {
        C22045() {
        }

        protected /* synthetic */ Object initialValue() {
            return YL();
        }

        protected SimpleDateFormat YL() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        }
    }

    static class C22056 extends ThreadLocal<SimpleDateFormat> {
        C22056() {
        }

        protected /* synthetic */ Object initialValue() {
            return YL();
        }

        protected SimpleDateFormat YL() {
            return new SimpleDateFormat("HH:mm", Locale.US);
        }
    }

    static class C22067 extends ThreadLocal<SimpleDateFormat> {
        C22067() {
        }

        protected /* synthetic */ Object initialValue() {
            return YL();
        }

        protected SimpleDateFormat YL() {
            return new SimpleDateFormat("KK:mm aa", Locale.US);
        }
    }

    static class C22078 extends ThreadLocal<SimpleDateFormat> {
        C22078() {
        }

        protected /* synthetic */ Object initialValue() {
            return YL();
        }

        protected SimpleDateFormat YL() {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        }
    }

    static class C22089 extends ThreadLocal<SimpleDateFormat> {
        C22089() {
        }

        protected /* synthetic */ Object initialValue() {
            return YL();
        }

        protected SimpleDateFormat YL() {
            return new SimpleDateFormat("yyyyMMdd", Locale.US);
        }
    }

    public static Boolean m7114c(Date date) {
        return Boolean.valueOf(m7124f(date).equals(m7124f(new Date())));
    }

    public static String jx(int i) {
        return jy(i * 60);
    }

    public static String jy(int i) {
        String str = "";
        int i2 = (i % DateTimeConstants.SECONDS_PER_HOUR) / 60;
        int i3 = i / DateTimeConstants.SECONDS_PER_HOUR;
        if (i3 > 0) {
            str = i3 + arp.m4318u(PortfolioApp.ZQ(), R.string.General_Time_Abbreviations_Hour_H);
        }
        return str + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + i2 + arp.m4318u(PortfolioApp.ZQ(), R.string.General_Time_Abbreviations_Minute_M);
    }

    public static Boolean m7118d(Date date) {
        if (date == null) {
            return Boolean.valueOf(false);
        }
        Calendar instance = Calendar.getInstance(Locale.US);
        instance.setTime(date);
        Calendar instance2 = Calendar.getInstance(Locale.US);
        instance2.setTime(new Date());
        return Boolean.valueOf(m7116c(instance, instance2));
    }

    public static Boolean m7120e(Date date) {
        if (date == null) {
            return Boolean.valueOf(false);
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int i = instance.get(1);
        int i2 = instance.get(2);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(new Date());
        int i3 = instance2.get(1);
        int i4 = instance2.get(2);
        if (i == i3 && i2 == i4) {
            return Boolean.valueOf(true);
        }
        return Boolean.valueOf(false);
    }

    public static String m7124f(Date date) {
        ((SimpleDateFormat) cxN.get()).setTimeZone(TimeZone.getDefault());
        return ((SimpleDateFormat) cxN.get()).format(date);
    }

    public static Date fX(String str) {
        try {
            return ((SimpleDateFormat) cxN.get()).parse(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean m7108a(Date date, Date date2) {
        return m7124f(date).equals(m7124f(date2));
    }

    public static boolean m7122e(long j, long j2) {
        return m7108a(new Date(j), new Date(j2));
    }

    public static String m7105a(Date date) {
        ((SimpleDateFormat) ceo.get()).setTimeZone(TimeZone.getDefault());
        return ((SimpleDateFormat) ceo.get()).format(date);
    }

    public static Date fY(String str) throws ParseException {
        return ((SimpleDateFormat) ceo.get()).parse(str);
    }

    public static int m7112c(int i, long j, long j2) {
        Calendar instance = Calendar.getInstance(Locale.US);
        instance.setTimeInMillis(j);
        Calendar instance2 = Calendar.getInstance(Locale.US);
        instance2.setTimeInMillis(j2);
        if (i == 0) {
            return Days.daysBetween(new DateTime(m7110b(instance).getTime()), new DateTime(m7110b(instance2).getTime())).getDays() + 1;
        }
        if (i == 1) {
            return m7104a(instance, instance2);
        }
        return m7109b(instance, instance2);
    }

    private static int m7104a(Calendar calendar, Calendar calendar2) {
        List arrayList = new ArrayList();
        calendar.set(7, 1);
        calendar2.set(7, 1);
        ((SimpleDateFormat) cxM.get()).setTimeZone(TimeZone.getDefault());
        while (calendar.compareTo(calendar2) <= 0) {
            arrayList.add(((SimpleDateFormat) cxM.get()).format(calendar2.getTime()));
            calendar2.add(6, -7);
        }
        return arrayList.size();
    }

    private static int m7109b(Calendar calendar, Calendar calendar2) {
        List arrayList = new ArrayList();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        calendar.set(5, 1);
        calendar2.set(5, 1);
        while (calendar.compareTo(calendar2) <= 0) {
            arrayList.add(simpleDateFormat.format(calendar2.getTime()));
            calendar2.add(2, -1);
        }
        return arrayList.size();
    }

    public static boolean m7126f(long j, long j2) {
        Calendar instance = Calendar.getInstance(Locale.US);
        instance.setTimeInMillis(j);
        Calendar instance2 = Calendar.getInstance(Locale.US);
        instance2.setTimeInMillis(j2);
        return m7116c(instance, instance2);
    }

    private static boolean m7116c(Calendar calendar, Calendar calendar2) {
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar.set(7, calendar.getFirstDayOfWeek());
        calendar2.set(11, 0);
        calendar2.set(12, 0);
        calendar2.set(13, 0);
        calendar2.set(14, 0);
        int toDays = ((int) TimeUnit.MILLISECONDS.toDays(calendar2.getTimeInMillis())) - ((int) TimeUnit.MILLISECONDS.toDays(calendar.getTimeInMillis()));
        if (toDays < 0 || toDays >= 7) {
            return false;
        }
        return true;
    }

    public static boolean m7111b(Date date, Date date2) {
        return m7126f(date.getTime(), date2.getTime());
    }

    public static boolean m7129g(long j, long j2) {
        Calendar instance = Calendar.getInstance(Locale.US);
        instance.setTimeInMillis(j);
        Calendar instance2 = Calendar.getInstance(Locale.US);
        instance2.setTimeInMillis(j2);
        if (instance.get(1) == instance2.get(1) && instance.get(2) == instance2.get(2)) {
            return true;
        }
        return false;
    }

    public static Calendar m7110b(Calendar calendar) {
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar;
    }

    public static Date getStartOfDay(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return m7110b(instance).getTime();
    }

    public static Calendar m7115c(Calendar calendar) {
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, 999);
        return calendar;
    }

    public static Date getEndOfDay(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return m7115c(instance).getTime();
    }

    public static Date m7128g(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(5, -1);
        return instance.getTime();
    }

    public static Date m7130h(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(5, 1);
        return instance.getTime();
    }

    public static int m7113c(Date date, Date date2) {
        int abs = Math.abs((int) ((date2.getTime() - date.getTime()) / TimeUnit.MINUTES.toMillis(1)));
        return abs == 0 ? 1 : abs;
    }

    public static int m7117d(Date date, Date date2) {
        return (int) ((getStartOfDay(date2).getTime() - getStartOfDay(date).getTime()) / TimeUnit.DAYS.toMillis(1));
    }

    public static boolean m7123e(Date date, Date date2) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.getTime();
        instance = m7110b(instance);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date2);
        instance2.getTime();
        return instance.after(m7110b(instance2));
    }

    public static Date aq(String str, String str2) {
        try {
            DateTime parseDateTime = ISODateTimeFormat.dateTime().withZone(DateTimeZone.forID(str)).parseDateTime(str2);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            simpleDateFormat.setTimeZone(DateTimeZone.forID(str).toTimeZone());
            return ((SimpleDateFormat) cxX.get()).parse(simpleDateFormat.format(Long.valueOf(parseDateTime.getMillis())));
        } catch (Exception e) {
            MFLogger.m12670d(TAG, " --- INSIDE " + TAG + " cannot parse date = " + str2 + ", timezone = " + str);
            Calendar instance = Calendar.getInstance();
            instance.set(1990, 0, 1);
            return instance.getTime();
        }
    }

    public static Date fZ(String str) {
        return ISODateTimeFormat.dateTime().parseDateTime(str).toDate();
    }

    public static String m7106a(Date date, TimeZone timeZone) {
        return ISODateTimeFormat.dateTime().withZoneUTC().print(new DateTime((Object) date, GregorianChronology.getInstance(DateTimeZone.forTimeZone(timeZone))));
    }

    public static String m7131i(Date date) {
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Alarm.FORMAT_DATE_ISO, Locale.US);
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(date);
    }

    public static Bundle m7132j(Date date) {
        Date endDateOfSampleDay = cnq.acd().acs().getEndDateOfSampleDay();
        if (endDateOfSampleDay == null) {
            return m7133k(date);
        }
        if (14 < TimeUnit.DAYS.convert(date.getTime() - endDateOfSampleDay.getTime(), TimeUnit.MILLISECONDS)) {
            return m7133k(date);
        }
        MFLogger.m12670d("DateHelper", "Start download SampleDay from " + m7105a(endDateOfSampleDay) + " to " + m7105a(date));
        Bundle bundle = new Bundle();
        bundle.putString(GoalPhase.COLUMN_START_DATE, ((SimpleDateFormat) ceo.get()).format(endDateOfSampleDay));
        bundle.putString(GoalPhase.COLUMN_END_DATE, ((SimpleDateFormat) ceo.get()).format(Long.valueOf(date.getTime())));
        return bundle;
    }

    public static Bundle m7133k(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        Calendar b = m7110b(instance);
        b.setFirstDayOfWeek(2);
        b.add(5, (-b.get(5)) + 1);
        b.add(2, -2);
        MFLogger.m12670d("DateHelper", "Start download SampleDay from " + m7105a(b.getTime()) + " to " + m7105a(Calendar.getInstance().getTime()));
        Bundle bundle = new Bundle();
        bundle.putString(GoalPhase.COLUMN_START_DATE, ((SimpleDateFormat) ceo.get()).format(b.getTime()));
        bundle.putString(GoalPhase.COLUMN_END_DATE, ((SimpleDateFormat) ceo.get()).format(Long.valueOf(date.getTime())));
        return bundle;
    }

    public static Calendar m7134l(Date date) {
        Calendar instance = Calendar.getInstance(Locale.US);
        instance.setTime(date);
        return m7119d(instance);
    }

    public static Calendar m7119d(Calendar calendar) {
        Calendar calendar2 = (Calendar) calendar.clone();
        calendar2.add(5, -(calendar2.get(7) - 1));
        return m7110b(calendar2);
    }

    public static Calendar m7135m(Date date) {
        Calendar instance = Calendar.getInstance(Locale.US);
        instance.setTime(date);
        return m7121e(instance);
    }

    public static Calendar m7121e(Calendar calendar) {
        Calendar calendar2 = (Calendar) calendar.clone();
        calendar2.add(5, -(calendar2.get(7) - 7));
        return m7115c(calendar2);
    }

    public static Calendar m7136n(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return m7125f(instance);
    }

    public static Calendar m7125f(Calendar calendar) {
        Calendar calendar2 = (Calendar) calendar.clone();
        calendar2.set(5, 1);
        return m7110b(calendar2);
    }

    public static Calendar m7137o(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return m7127g(instance);
    }

    public static Calendar m7127g(Calendar calendar) {
        Calendar calendar2 = (Calendar) calendar.clone();
        calendar2.set(5, calendar2.getActualMaximum(5));
        return m7110b(calendar2);
    }

    public static String m7138p(Date date) {
        ((SimpleDateFormat) cxX.get()).setTimeZone(TimeZone.getDefault());
        return ((SimpleDateFormat) cxX.get()).format(date);
    }

    public static String m7107a(DateTime dateTime) {
        if (dateTime == null) {
            return "";
        }
        return DateTimeFormat.forPattern("EEE, dd MMM yyyy HH:mm:ss 'GMT'").withZoneUTC().withLocale(Locale.US).print((ReadableInstant) dateTime);
    }
}
