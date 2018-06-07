package com.fossil;

import android.content.Context;
import android.content.IntentFilter;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;
import org.json.JSONObject;

public class dzi {
    private static dzi dBW = null;
    private List<String> aWP = null;
    private volatile String aWS = "";
    private volatile int f1481b = 2;
    private volatile HttpHost dBU = null;
    private eav dBV = null;
    private Context dBX = null;
    private eaq dBY = null;
    private int f1482f = 0;

    private dzi(Context context) {
        this.dBX = context.getApplicationContext();
        this.dBV = new eav();
        ebo.m10457a(context);
        this.dBY = ebb.aCr();
        HS();
        HP();
        HM();
    }

    private void HP() {
        this.aWP = new ArrayList(10);
        this.aWP.add("117.135.169.101");
        this.aWP.add("140.207.54.125");
        this.aWP.add("180.153.8.53");
        this.aWP.add("120.198.203.175");
        this.aWP.add("14.17.43.18");
        this.aWP.add("163.177.71.186");
        this.aWP.add("111.30.131.31");
        this.aWP.add("123.126.121.167");
        this.aWP.add("123.151.152.111");
        this.aWP.add("113.142.45.79");
        this.aWP.add("123.138.162.90");
        this.aWP.add("103.7.30.94");
    }

    private void HR() {
        String aCb = aCb();
        if (dze.aBG()) {
            this.dBY.cY("remoteIp ip is " + aCb);
        }
        if (ebb.cn(aCb)) {
            String str;
            if (this.aWP.contains(aCb)) {
                str = aCb;
            } else {
                str = (String) this.aWP.get(this.f1482f);
                if (dze.aBG()) {
                    this.dBY.cZ(aCb + " not in ip list, change to:" + str);
                }
            }
            dze.lj("http://" + str + ":80/mstat/report");
        }
    }

    private void HS() {
        this.f1481b = 0;
        this.dBU = null;
        this.aWS = null;
    }

    private String aCb() {
        try {
            String str = "pingma.qq.com";
            if (!la(str)) {
                return InetAddress.getByName(str).getHostAddress();
            }
        } catch (Throwable e) {
            this.dBY.m10419g(e);
        }
        return "";
    }

    public static dzi dx(Context context) {
        if (dBW == null) {
            synchronized (dzi.class) {
                if (dBW == null) {
                    dBW = new dzi(context);
                }
            }
        }
        return dBW;
    }

    private boolean la(String str) {
        return Pattern.compile("(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})").matcher(str).matches();
    }

    public int HF() {
        return this.f1481b;
    }

    public String HI() {
        return this.aWS;
    }

    void HM() {
        if (ebh.eg(this.dBX)) {
            if (dze.aWF) {
                HR();
            }
            this.aWS = ebb.dK(this.dBX);
            if (dze.aBG()) {
                this.dBY.cY("NETWORK name:" + this.aWS);
            }
            if (ebb.cn(this.aWS)) {
                if ("WIFI".equalsIgnoreCase(this.aWS)) {
                    this.f1481b = 1;
                } else {
                    this.f1481b = 2;
                }
                this.dBU = ebb.dB(this.dBX);
            }
            if (dzg.Ja()) {
                dzg.m10366d(this.dBX);
                return;
            }
            return;
        }
        if (dze.aBG()) {
            this.dBY.cY("NETWORK TYPE: network is close.");
        }
        HS();
    }

    public void HN() {
        this.dBX.getApplicationContext().registerReceiver(new eaj(this), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public HttpHost aCh() {
        return this.dBU;
    }

    public boolean aCi() {
        return this.f1481b == 1;
    }

    public boolean aCj() {
        return this.f1481b != 0;
    }

    public void cg(String str) {
        if (dze.aBG()) {
            this.dBY.cY("updateIpList " + str);
        }
        try {
            if (ebb.cn(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.length() > 0) {
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String string = jSONObject.getString((String) keys.next());
                        if (ebb.cn(string)) {
                            for (String str2 : string.split(";")) {
                                String str22;
                                if (ebb.cn(str22)) {
                                    String[] split = str22.split(":");
                                    if (split.length > 1) {
                                        str22 = split[0];
                                        if (la(str22) && !this.aWP.contains(str22)) {
                                            if (dze.aBG()) {
                                                this.dBY.cY("add new ip:" + str22);
                                            }
                                            this.aWP.add(str22);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable e) {
            this.dBY.m10419g(e);
        }
        this.f1482f = new Random().nextInt(this.aWP.size());
    }

    public void m10368d() {
        this.f1482f = (this.f1482f + 1) % this.aWP.size();
    }
}
