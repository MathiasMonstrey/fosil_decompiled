package com.misfit.frameworks.network.enums;

import android.os.Build;
import android.os.Build.VERSION;

public class MFNetworkConstants {
    public static final String CUCUMBER_USER_AGENT = ("MisfitCycling/Android##Cucumber;1.0;" + Build.MODEL + ";Android " + VERSION.RELEASE);
    public static final String USER_AGENT = ("MisfitLink/Android##LinkButton;1.0;" + Build.MODEL + ";Android " + VERSION.RELEASE);
}
