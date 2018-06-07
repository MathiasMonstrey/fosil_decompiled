package com.fossil.wearables.fsl.countdown;

import com.misfit.frameworks.buttonservice.model.Alarm;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CountDownUri {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(Alarm.FORMAT_DATE_ISO, Locale.US);
    private static String uriSchemePrefix = "urn:fsl:countdown";

    public static URI generateURI(CountDown countDown) {
        StringBuffer stringBuffer = new StringBuffer(uriSchemePrefix);
        stringBuffer.append(":" + DATE_FORMAT.format(new Date()));
        return URI.create(stringBuffer.toString());
    }
}
