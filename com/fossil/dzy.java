package com.fossil;

import android.content.Context;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;

class dzy implements Runnable {
    private Map<String, Integer> aWW = null;
    private Context baD = null;
    private dzh dCl = null;

    public dzy(Context context, Map<String, Integer> map, dzh com_fossil_dzh) {
        this.baD = context;
        this.dCl = com_fossil_dzh;
        if (map != null) {
            this.aWW = map;
        }
    }

    private Map<String, Integer> HG() {
        Map<String, Integer> hashMap = new HashMap();
        String bh = dze.bh("__MTA_TEST_SPEED__", null);
        if (!(bh == null || bh.trim().length() == 0)) {
            for (String bh2 : bh2.split(";")) {
                String[] split = bh2.split(",");
                if (split != null && split.length == 2) {
                    String str = split[0];
                    if (!(str == null || str.trim().length() == 0)) {
                        try {
                            hashMap.put(str, Integer.valueOf(Integer.valueOf(split[1]).intValue()));
                        } catch (Throwable e) {
                            dzg.dBR.m10419g(e);
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    private dzd m10378M(String str, int i) {
        Throwable th;
        dzd com_fossil_dzd = new dzd();
        Socket socket = new Socket();
        int i2 = 0;
        try {
            com_fossil_dzd.setDomain(str);
            com_fossil_dzd.setPort(i);
            long currentTimeMillis = System.currentTimeMillis();
            SocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            socket.connect(inetSocketAddress, 30000);
            com_fossil_dzd.aP(System.currentTimeMillis() - currentTimeMillis);
            com_fossil_dzd.lg(inetSocketAddress.getAddress().getHostAddress());
            socket.close();
            try {
                socket.close();
            } catch (Throwable th2) {
                dzg.dBR.m10419g(th2);
            }
        } catch (Throwable e) {
            th2 = e;
            i2 = -1;
            dzg.dBR.m10419g(th2);
            socket.close();
        } catch (Throwable th22) {
            dzg.dBR.m10419g(th22);
        }
        com_fossil_dzd.setStatusCode(i2);
        return com_fossil_dzd;
    }

    public void run() {
        try {
            if (this.aWW == null) {
                this.aWW = HG();
            }
            if (this.aWW == null || this.aWW.size() == 0) {
                dzg.dBR.cY("empty domain list.");
                return;
            }
            JSONArray jSONArray = new JSONArray();
            for (Entry entry : this.aWW.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null || str.length() == 0) {
                    dzg.dBR.cZ("empty domain name.");
                } else if (((Integer) entry.getValue()) == null) {
                    dzg.dBR.cZ("port is null for " + str);
                } else {
                    jSONArray.put(m10378M((String) entry.getKey(), ((Integer) entry.getValue()).intValue()).toJSONObject());
                }
            }
            if (jSONArray.length() != 0) {
                dzm com_fossil_dzo = new dzo(this.baD, dzg.m10354a(this.baD, false, this.dCl), this.dCl);
                com_fossil_dzo.cg(jSONArray.toString());
                new dzz(com_fossil_dzo).HJ();
            }
        } catch (Throwable th) {
            dzg.dBR.m10419g(th);
        }
    }
}
