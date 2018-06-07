package com.fossil;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fossil.dvj.C3227a;
import java.io.IOException;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public final class dwx {
    static final String PREFIX = dvu.azM().getPrefix();
    private static final Comparator<String> dzQ = new C32811();
    public static final String dzR = (PREFIX + "-Sent-Millis");
    public static final String dzS = (PREFIX + "-Received-Millis");
    public static final String dzT = (PREFIX + "-Selected-Protocol");

    static class C32811 implements Comparator<String> {
        C32811() {
        }

        public int compare(String str, String str2) {
            if (str == str2) {
                return 0;
            }
            if (str == null) {
                return -1;
            }
            if (str2 == null) {
                return 1;
            }
            return String.CASE_INSENSITIVE_ORDER.compare(str, str2);
        }
    }

    public static long m10241o(dvj com_fossil_dvj) {
        return m10240d(com_fossil_dvj.azt());
    }

    public static long m10242u(dvl com_fossil_dvl) {
        return m10240d(com_fossil_dvl.azt());
    }

    public static long m10240d(dve com_fossil_dve) {
        return kT(com_fossil_dve.get("Content-Length"));
    }

    private static long kT(String str) {
        long j = -1;
        if (str != null) {
            try {
                j = Long.parseLong(str);
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }

    public static Map<String, List<String>> m10238b(dve com_fossil_dve, String str) {
        Map treeMap = new TreeMap(dzQ);
        int size = com_fossil_dve.size();
        for (int i = 0; i < size; i++) {
            String my = com_fossil_dve.my(i);
            String mz = com_fossil_dve.mz(i);
            List arrayList = new ArrayList();
            List list = (List) treeMap.get(my);
            if (list != null) {
                arrayList.addAll(list);
            }
            arrayList.add(mz);
            treeMap.put(my, Collections.unmodifiableList(arrayList));
        }
        if (str != null) {
            treeMap.put(null, Collections.unmodifiableList(Collections.singletonList(str)));
        }
        return Collections.unmodifiableMap(treeMap);
    }

    public static void m10237a(C3227a c3227a, Map<String, List<String>> map) {
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (("Cookie".equalsIgnoreCase(str) || "Cookie2".equalsIgnoreCase(str)) && !((List) entry.getValue()).isEmpty()) {
                c3227a.aZ(str, aB((List) entry.getValue()));
            }
        }
    }

    private static String aB(List<String> list) {
        if (list.size() == 1) {
            return (String) list.get(0);
        }
        StringBuilder stringBuilder = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append("; ");
            }
            stringBuilder.append((String) list.get(i));
        }
        return stringBuilder.toString();
    }

    static boolean kU(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    public static List<dux> m10239c(dve com_fossil_dve, String str) {
        List<dux> arrayList = new ArrayList();
        int size = com_fossil_dve.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(com_fossil_dve.my(i))) {
                String mz = com_fossil_dve.mz(i);
                int i2 = 0;
                while (i2 < mz.length()) {
                    int b = dwr.m10190b(mz, i2, MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    String trim = mz.substring(i2, b).trim();
                    b = dwr.m10188K(mz, b);
                    if (!mz.regionMatches(true, b, "realm=\"", 0, "realm=\"".length())) {
                        break;
                    }
                    i2 = "realm=\"".length() + b;
                    b = dwr.m10190b(mz, i2, "\"");
                    String substring = mz.substring(i2, b);
                    i2 = dwr.m10188K(mz, dwr.m10190b(mz, b + 1, ",") + 1);
                    arrayList.add(new dux(trim, substring));
                }
            }
        }
        return arrayList;
    }

    public static dvj m10236a(dus com_fossil_dus, dvl com_fossil_dvl, Proxy proxy) throws IOException {
        if (com_fossil_dvl.azA() == 407) {
            return com_fossil_dus.mo2759b(proxy, com_fossil_dvl);
        }
        return com_fossil_dus.mo2758a(proxy, com_fossil_dvl);
    }
}
