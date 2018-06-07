package com.fossil.wearables.fsl.goaltracking;

import com.misfit.frameworks.buttonservice.model.Alarm;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class GoalTrackingURI {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(Alarm.FORMAT_DATE_ISO, Locale.US);
    private static String uriEventSchemePrefix = "urn:fsl:goal_tracking_event";
    private static String uriSchemePrefix = "urn:fsl:goal_tracking";

    public static URI generateURI(GoalTracking goalTracking) {
        StringBuffer stringBuffer = new StringBuffer(uriSchemePrefix);
        stringBuffer.append(":" + DATE_FORMAT.format(new Date()));
        stringBuffer.append(":");
        stringBuffer.append(goalTracking.getTarget());
        stringBuffer.append(":");
        stringBuffer.append(goalTracking.getFrequency());
        return URI.create(stringBuffer.toString());
    }

    public static URI generateEventURI(GoalTrackingEvent goalTrackingEvent) {
        StringBuffer stringBuffer = new StringBuffer(uriEventSchemePrefix);
        stringBuffer.append(":" + DATE_FORMAT.format(new Date()));
        return URI.create(stringBuffer.toString());
    }
}
