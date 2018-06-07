package com.fossil;

import com.squareup.okhttp.Protocol;
import java.io.IOException;
import java.net.ProtocolException;

public final class dxc {
    public final int drk;
    public final Protocol duW;
    public final String message;

    public dxc(Protocol protocol, int i, String str) {
        this.duW = protocol;
        this.drk = i;
        this.message = str;
    }

    public static dxc kV(String str) throws IOException {
        Protocol protocol;
        int i = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int charAt = str.charAt(7) - 48;
            if (charAt == 0) {
                protocol = Protocol.HTTP_1_0;
            } else if (charAt == 1) {
                protocol = Protocol.HTTP_1_1;
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else if (str.startsWith("ICY ")) {
            protocol = Protocol.HTTP_1_0;
            i = 4;
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        if (str.length() < i + 3) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        try {
            String str2;
            int parseInt = Integer.parseInt(str.substring(i, i + 3));
            String str3 = "";
            if (str.length() <= i + 3) {
                str2 = str3;
            } else if (str.charAt(i + 3) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            } else {
                str2 = str.substring(i + 4);
            }
            return new dxc(protocol, parseInt, str2);
        } catch (NumberFormatException e) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.duW == Protocol.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        stringBuilder.append(' ').append(this.drk);
        if (this.message != null) {
            stringBuilder.append(' ').append(this.message);
        }
        return stringBuilder.toString();
    }
}
