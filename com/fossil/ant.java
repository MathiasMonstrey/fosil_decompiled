package com.fossil;

import java.util.Map;

public class ant extends apu {
    private static final String aWB = ant.class.getSimpleName();

    public final String m3964b(String str, Map<String, String> map) {
        CharSequence a = m3963a(str);
        while (a != null) {
            String valueOf;
            if (apu.m3962z("timestamp_epoch_millis", a)) {
                valueOf = String.valueOf(System.currentTimeMillis());
                app.m4180g(3, aWB, "Replacing param timestamp_epoch_millis with: " + valueOf);
                valueOf = str.replace(a, aqv.cy(valueOf));
            } else if (apu.m3962z("session_duration_millis", a)) {
                aon.Il();
                valueOf = Long.toString(aon.Ip());
                app.m4180g(3, aWB, "Replacing param session_duration_millis with: " + valueOf);
                valueOf = str.replace(a, aqv.cy(valueOf));
            } else if (apu.m3962z("fg_timespent_millis", a)) {
                aon.Il();
                valueOf = Long.toString(aon.Ip());
                app.m4180g(3, aWB, "Replacing param fg_timespent_millis with: " + valueOf);
                valueOf = str.replace(a, aqv.cy(valueOf));
            } else if (apu.m3962z("install_referrer", a)) {
                valueOf = new anb().HI();
                if (valueOf == null) {
                    valueOf = "";
                }
                app.m4180g(3, aWB, "Replacing param install_referrer with: " + valueOf);
                valueOf = str.replace(a, aqv.cy(valueOf));
            } else if (apu.m3962z("geo_latitude", a)) {
                r2 = aos.Iy().IB();
                valueOf = "";
                if (r2 != null) {
                    valueOf = valueOf + aqv.m4250a(r2.getLatitude(), aos.IA());
                }
                app.m4180g(3, aWB, "Replacing param geo_latitude with: " + valueOf);
                valueOf = str.replace(a, aqv.cy(valueOf));
            } else if (apu.m3962z("geo_longitude", a)) {
                r2 = aos.Iy().IB();
                valueOf = "";
                if (r2 != null) {
                    valueOf = valueOf + aqv.m4250a(r2.getLongitude(), aos.IA());
                }
                app.m4180g(3, aWB, "Replacing param geo_longitude with: " + valueOf);
                valueOf = str.replace(a, aqv.cy(valueOf));
            } else if (apu.m3962z("publisher_user_id", a)) {
                valueOf = (String) aqp.Jf().cw("UserId");
                app.m4180g(3, aWB, "Replacing param publisher_user_id with: " + valueOf);
                valueOf = str.replace(a, aqv.cy(valueOf));
            } else if (apu.m3962z("event_name", a)) {
                if (map.containsKey("event_name")) {
                    app.m4180g(3, aWB, "Replacing param event_name with: " + ((String) map.get("event_name")));
                    valueOf = str.replace(a, aqv.cy((String) map.get("event_name")));
                } else {
                    app.m4180g(3, aWB, "Replacing param event_name with empty string");
                    valueOf = str.replace(a, "");
                }
            } else if (!apu.m3962z("event_time_millis", a)) {
                app.m4180g(3, aWB, "Unknown param: " + a);
                valueOf = str.replace(a, "");
            } else if (map.containsKey("event_time_millis")) {
                app.m4180g(3, aWB, "Replacing param event_time_millis with: " + ((String) map.get("event_time_millis")));
                valueOf = str.replace(a, aqv.cy((String) map.get("event_time_millis")));
            } else {
                app.m4180g(3, aWB, "Replacing param event_time_millis with empty string");
                valueOf = str.replace(a, "");
            }
            a = m3963a(valueOf);
            str = valueOf;
        }
        return str;
    }
}
