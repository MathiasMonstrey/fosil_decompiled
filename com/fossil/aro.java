package com.fossil;

import android.database.SQLException;
import android.util.LruCache;

public class aro {
    private static final aro bdy = new aro();
    private LruCache<String, String> bdx = new LruCache(5242880);

    private aro() {
    }

    public static aro Jw() {
        return bdy;
    }

    public void m4316H(String str, String str2) {
        this.bdx.put(str, str2);
    }

    public String cK(String str) {
        String cP;
        SQLException e;
        if (str == null || str.equals("")) {
            return "";
        }
        String str2 = (String) this.bdx.get(str);
        if (str2 == null || str2.equals("")) {
            try {
                cP = aru.cP(str);
                if (cP != null) {
                    try {
                        this.bdx.put(str, cP);
                    } catch (SQLException e2) {
                        e = e2;
                        e.printStackTrace();
                        str2 = cP;
                        return str2 != null ? str2 : str2;
                    }
                }
                str2 = cP;
            } catch (SQLException e3) {
                SQLException sQLException = e3;
                cP = str2;
                e = sQLException;
                e.printStackTrace();
                str2 = cP;
                if (str2 != null) {
                }
            }
        }
        if (str2 != null && !str2.equals("")) {
            if (str2.contains("\\n")) {
                str2 = str2.replace("\\n", "\n");
            }
            return str2.replaceAll("\\\\", "");
        }
    }

    public boolean cL(String str) {
        if (str == null || str.equals("")) {
            return false;
        }
        String str2 = (String) this.bdx.get(str);
        return (str2 == null || str2.equals("")) ? false : true;
    }

    public String cM(String str) {
        return (String) this.bdx.remove(str);
    }

    public void clearCache() {
        this.bdx.evictAll();
    }
}
