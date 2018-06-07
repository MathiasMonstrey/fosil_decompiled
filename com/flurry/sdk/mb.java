package com.flurry.sdk;

import android.content.Context;
import com.fossil.app;
import com.fossil.atp;

public class mb {
    public static final String aWB = mb.class.getSimpleName();

    public enum C1545a {
        UNKNOWN(-1),
        ACTIVE(0),
        INACTIVE(1),
        BACKGROUND(2);
        
        public int f1364e;

        private C1545a(int i) {
            this.f1364e = i;
        }
    }

    public enum C1546b {
        UNAVAILABLE(-2),
        UNKNOWN(-1),
        SUCCESS(0),
        SERVICE_MISSING(1),
        SERVICE_UPDATING(2),
        SERVICE_VERSION_UPDATE_REQUIRED(3),
        SERVICE_DISABLED(4),
        SERVICE_INVALID(5);
        
        public int f1373i;

        private C1546b(int i) {
            this.f1373i = i;
        }
    }

    public static C1546b ab(Context context) {
        try {
            switch (atp.Ku().aj(context)) {
                case 0:
                    return C1546b.SUCCESS;
                case 1:
                    return C1546b.SERVICE_MISSING;
                case 2:
                    return C1546b.SERVICE_VERSION_UPDATE_REQUIRED;
                case 3:
                    return C1546b.SERVICE_DISABLED;
                case 9:
                    return C1546b.SERVICE_INVALID;
                case 18:
                    return C1546b.SERVICE_UPDATING;
                default:
                    return C1546b.UNAVAILABLE;
            }
        } catch (NoClassDefFoundError e) {
            app.m4181w(aWB, "Error retrieving Google Play Services Availability. This probably means google play services is unavailable.");
            return C1546b.UNAVAILABLE;
        } catch (Exception e2) {
            app.m4181w(aWB, "Error retrieving Google Play Services Availability. This probably means google play services is unavailable.");
            return C1546b.UNAVAILABLE;
        }
    }
}
