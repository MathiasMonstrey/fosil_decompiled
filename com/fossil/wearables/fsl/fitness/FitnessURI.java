package com.fossil.wearables.fsl.fitness;

import com.misfit.frameworks.buttonservice.model.Alarm;
import java.net.URI;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

class FitnessURI {
    static String uriSchemePrefix = "urn:fsl:fitness";

    FitnessURI() {
    }

    private static String formatDate(Date date) {
        DateFormat simpleDateFormat = new SimpleDateFormat(Alarm.FORMAT_DATE_ISO, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(date);
    }

    private static String formatDay(int i, int i2, int i3) {
        DecimalFormat decimalFormat = new DecimalFormat("0000");
        DecimalFormat decimalFormat2 = new DecimalFormat("00");
        return decimalFormat.format((long) i) + "-" + decimalFormat2.format((long) i2) + "-" + decimalFormat2.format((long) i3);
    }

    private static String formatDST(int i) {
        DecimalFormat decimalFormat = new DecimalFormat("0000");
        decimalFormat.setPositivePrefix("+");
        decimalFormat.setNegativePrefix("-");
        return decimalFormat.format((long) (i / 1000));
    }

    static URI generateURI(SampleRaw sampleRaw) {
        String str = "sample:" + sampleRaw.getSourceType().getName().toLowerCase();
        String sourceId = sampleRaw.getSourceId();
        return URI.create(uriSchemePrefix + ":" + str + ":" + sourceId + ":" + formatDate(sampleRaw.getStartTime()));
    }

    static URI generateURI(SampleDay sampleDay) {
        String formatDay = formatDay(sampleDay.year, sampleDay.month, sampleDay.day);
        String timezoneName = sampleDay.getTimezoneName();
        return URI.create(uriSchemePrefix + ":" + "sample:day" + ":" + formatDay + ":" + timezoneName + ":" + formatDST(sampleDay.getDstOffset()));
    }

    public static URI generateURI(DailyGoal dailyGoal) {
        return URI.create(uriSchemePrefix + ":" + "goal:day" + ":" + formatDay(dailyGoal.year, dailyGoal.month, dailyGoal.day));
    }
}
