package com.fossil;

import com.squareup.okhttp.Protocol;
import java.net.Proxy.Type;

public final class dwz {
    static String m10243a(dvj com_fossil_dvj, Type type, Protocol protocol) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(com_fossil_dvj.azs());
        stringBuilder.append(' ');
        if (m10244a(com_fossil_dvj, type)) {
            stringBuilder.append(com_fossil_dvj.azq());
        } else {
            stringBuilder.append(m10246g(com_fossil_dvj.azq()));
        }
        stringBuilder.append(' ');
        stringBuilder.append(m10245d(protocol));
        return stringBuilder.toString();
    }

    private static boolean m10244a(dvj com_fossil_dvj, Type type) {
        return !com_fossil_dvj.ayS() && type == Type.HTTP;
    }

    public static String m10246g(dvf com_fossil_dvf) {
        String ayX = com_fossil_dvf.ayX();
        String ayZ = com_fossil_dvf.ayZ();
        return ayZ != null ? ayX + '?' + ayZ : ayX;
    }

    public static String m10245d(Protocol protocol) {
        return protocol == Protocol.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1";
    }
}
