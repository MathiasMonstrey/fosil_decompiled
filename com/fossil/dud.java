package com.fossil;

import android.content.Context;
import java.util.Map;

public class dud {
    public static void m9758a(Object obj, String str, Map<String, String> map) {
        if (obj == null) {
            duj.m9770e("WBAgent", "unexpected null page or activity in onEvent");
        } else if (str == null) {
            duj.m9770e("WBAgent", "unexpected null eventId in onEvent");
        } else {
            String name;
            if (obj instanceof Context) {
                name = obj.getClass().getName();
            } else {
                name = obj;
            }
            duf.axP().m9759a(name, str, map);
        }
    }
}
