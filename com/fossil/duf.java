package com.fossil;

import com.sina.weibo.sdk.statistic.LogType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class duf {
    private static int MAX_CACHE_SIZE = 5;
    private static duf dtI;
    private static List<duc> dtJ;
    private static Map<String, duc> dtK;

    public static synchronized duf axP() {
        duf com_fossil_duf;
        synchronized (duf.class) {
            if (dtI == null) {
                dtI = new duf();
            }
            com_fossil_duf = dtI;
        }
        return com_fossil_duf;
    }

    private duf() {
        dtJ = new ArrayList();
        dtK = new HashMap();
        duj.m9771i("WBAgent", "init handler");
    }

    public void m9759a(String str, String str2, Map<String, String> map) {
        dty com_fossil_dty = new dty(str, str2, map);
        com_fossil_dty.m9754a(LogType.EVENT);
        synchronized (dtJ) {
            dtJ.add(com_fossil_dty);
        }
        if (map == null) {
            duj.m9769d("WBAgent", "event--- page:" + str + " ,event name:" + str2);
        } else {
            duj.m9769d("WBAgent", "event--- page:" + str + " ,event name:" + str2 + " ,extend:" + map.toString());
        }
        if (dtJ.size() >= MAX_CACHE_SIZE) {
            av(dtJ);
            dtJ.clear();
        }
    }

    private synchronized void av(List<duc> list) {
        final String au = dtz.au(list);
        due.execute(new Runnable(this) {
            final /* synthetic */ duf dtL;

            public void run() {
                dua.m9757b(dua.kd("app_logs"), au, true);
            }
        });
    }
}
