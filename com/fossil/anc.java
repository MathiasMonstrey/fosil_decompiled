package com.fossil;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class anc {
    private static final String aWB = anc.class.getSimpleName();

    public static Map<String, List<String>> ch(String str) {
        app.m4180g(3, aWB, "Parsing referrer map");
        if (str == null) {
            return Collections.emptyMap();
        }
        Map<String, List<String>> hashMap = new HashMap();
        for (String str2 : str.split("&")) {
            String str22;
            String[] split = str22.split(SimpleComparison.EQUAL_TO_OPERATION);
            if (split.length != 2) {
                app.m4180g(5, aWB, "Invalid referrer Element: " + str22 + " in referrer tag " + str);
            } else {
                str22 = URLDecoder.decode(split[0]);
                String decode = URLDecoder.decode(split[1]);
                if (hashMap.get(str22) == null) {
                    hashMap.put(str22, new ArrayList());
                }
                ((List) hashMap.get(str22)).add(decode);
            }
        }
        for (Entry entry : hashMap.entrySet()) {
            app.m4180g(3, aWB, "entry: " + ((String) entry.getKey()) + SimpleComparison.EQUAL_TO_OPERATION + entry.getValue());
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (hashMap.get("utm_source") == null) {
            stringBuilder.append("Campaign Source is missing.\n");
        }
        if (hashMap.get("utm_medium") == null) {
            stringBuilder.append("Campaign Medium is missing.\n");
        }
        if (hashMap.get("utm_campaign") == null) {
            stringBuilder.append("Campaign Name is missing.\n");
        }
        if (stringBuilder.length() > 0) {
            app.m4180g(5, aWB, "Detected missing referrer keys : " + stringBuilder.toString());
        }
        return hashMap;
    }
}
