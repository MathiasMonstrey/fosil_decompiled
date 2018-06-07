package com.fossil.wearables.fsl.fitness;

import android.util.Log;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Duration;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.ReadableInstant;
import org.joda.time.chrono.GregorianChronology;

public class Interpolator {
    private static final String TAG = Interpolator.class.getSimpleName();

    public static List<SampleRaw> interpolateSampleHalfHour(Date date, Date date2, TimeZone timeZone, String str, FitnessSourceType fitnessSourceType, FitnessMovementType fitnessMovementType, double d, double d2, double d3) {
        List arrayList = new ArrayList();
        Chronology instance = GregorianChronology.getInstance(DateTimeZone.forTimeZone(timeZone));
        Object dateTime = new DateTime(date, instance);
        DateTime dateTime2 = new DateTime(date2, instance);
        MathContext mathContext = new MathContext(4, RoundingMode.HALF_UP);
        if (dateTime.isBefore(dateTime2)) {
            long millis = new Duration(dateTime, dateTime2).getMillis();
            BigDecimal bigDecimal = new BigDecimal(d / ((double) millis));
            bigDecimal = new BigDecimal(d2 / ((double) millis));
            bigDecimal = new BigDecimal(d3 / ((double) millis));
            Object dateTime3 = new DateTime(dateTime, dateTime.getChronology());
            while (dateTime2.isAfter(dateTime3)) {
                DateTime dateTime4;
                DateTime dateTime5 = new DateTime(dateTime3, dateTime3.getChronology());
                if (dateTime3.getMinuteOfHour() < 30) {
                    dateTime5 = dateTime5.withMinuteOfHour(29).withSecondOfMinute(59).withMillisOfSecond(999);
                } else {
                    dateTime5 = dateTime5.withMinuteOfHour(59).withSecondOfMinute(59).withMillisOfSecond(999);
                }
                if (dateTime5.isAfter(dateTime2)) {
                    dateTime4 = dateTime2;
                } else {
                    dateTime4 = dateTime5;
                }
                BigDecimal bigDecimal2 = new BigDecimal((double) new Period(dateTime3, dateTime4, PeriodType.millis()).getMillis());
                double doubleValue = bigDecimal.multiply(bigDecimal2, mathContext).setScale(2, 4).doubleValue();
                double doubleValue2 = bigDecimal.multiply(bigDecimal2, mathContext).setScale(2, 4).doubleValue();
                double doubleValue3 = bigDecimal.multiply(bigDecimal2, mathContext).setScale(2, 4).doubleValue();
                try {
                    arrayList.add(new SampleRaw(dateTime3.toDate(), dateTime4.toDate(), timeZone.getID(), str, fitnessSourceType, fitnessMovementType, doubleValue, doubleValue2, doubleValue3));
                } catch (Exception e) {
                    Log.e(TAG, "Error inside " + TAG + ".interpolateHours - e=" + e);
                }
                dateTime3 = dateTime4.plusMillis(1);
            }
        }
        return arrayList;
    }

    public static List<SampleDay> interpolateDays(Date date, Date date2, TimeZone timeZone, double d, double d2, double d3) {
        Chronology instance = GregorianChronology.getInstance(DateTimeZone.forTimeZone(timeZone));
        Object dateTime = new DateTime(date, instance);
        ReadableInstant dateTime2 = new DateTime(date2, instance);
        List<SampleDay> arrayList = new ArrayList();
        MathContext mathContext = new MathContext(4, RoundingMode.HALF_UP);
        if (dateTime.isBefore(dateTime2)) {
            long millis = new Duration(dateTime, dateTime2).getMillis();
            BigDecimal bigDecimal = new BigDecimal(d / ((double) millis));
            BigDecimal bigDecimal2 = new BigDecimal(d2 / ((double) millis));
            BigDecimal bigDecimal3 = new BigDecimal(d3 / ((double) millis));
            while (dateTime2.isAfter(dateTime)) {
                Object cursorEndDateTime = getCursorEndDateTime(dateTime);
                if (cursorEndDateTime.isAfter(dateTime2)) {
                    cursorEndDateTime = dateTime2;
                }
                BigDecimal bigDecimal4 = new BigDecimal((double) new Period(dateTime, cursorEndDateTime, PeriodType.millis()).getMillis());
                arrayList.add(createSample(dateTime, bigDecimal.multiply(bigDecimal4, mathContext).setScale(2, 4).doubleValue(), bigDecimal2.multiply(bigDecimal4, mathContext).setScale(2, 4).doubleValue(), bigDecimal3.multiply(bigDecimal4, mathContext).setScale(2, 4).doubleValue()));
                dateTime = cursorEndDateTime.plusMillis(1);
            }
        }
        return arrayList;
    }

    private static DateTime getCursorEndDateTime(DateTime dateTime) {
        return new DateTime(dateTime, dateTime.getChronology()).withHourOfDay(23).withMinuteOfHour(59).withSecondOfMinute(59).withMillisOfSecond(999);
    }

    private static DateTime getCursorEndHourTime(DateTime dateTime) {
        return new DateTime(dateTime, dateTime.getChronology()).withMinuteOfHour(59).withSecondOfMinute(59).withMillisOfSecond(999);
    }

    private static DateTime resetHour(DateTime dateTime) {
        return new DateTime(dateTime, dateTime.getChronology()).withMinuteOfHour(0).withSecondOfMinute(0).withMillisOfSecond(0);
    }

    private static SampleDay createSample(DateTime dateTime, double d, double d2, double d3) {
        TimeZone toTimeZone = dateTime.getZone().toTimeZone();
        return new SampleDay(dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(), toTimeZone.getID(), toTimeZone.inDaylightTime(dateTime.toDate()) ? toTimeZone.getDSTSavings() : 0, d, d2, d3);
    }
}
