package com.fossil;

import com.jawbone.upplatformsdk.utils.UpPlatformSdkConstants;
import java.net.IDN;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public final class dvf {
    private static final char[] HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final String cBN;
    private final String dqH;
    private final List<String> dvA;
    private final List<String> dvB;
    private final String dvz;
    private final String fragment;
    private final int port;
    private final String url;
    private final String username;

    public static final class C3224a {
        String dqH;
        String dvC = "";
        String dvD = "";
        final List<String> dvE = new ArrayList();
        List<String> dvF;
        String dvG;
        String dvz;
        int port = -1;

        public C3224a() {
            this.dvE.add("");
        }

        public C3224a kD(String str) {
            if (str == null) {
                throw new IllegalArgumentException("scheme == null");
            }
            if (str.equalsIgnoreCase("http")) {
                this.dqH = "http";
            } else if (str.equalsIgnoreCase(UpPlatformSdkConstants.URI_SCHEME)) {
                this.dqH = UpPlatformSdkConstants.URI_SCHEME;
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + str);
            }
            return this;
        }

        public C3224a kE(String str) {
            if (str == null) {
                throw new IllegalArgumentException("host == null");
            }
            String z = C3224a.m9852z(str, 0, str.length());
            if (z == null) {
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            this.dvz = z;
            return this;
        }

        public C3224a mA(int i) {
            if (i <= 0 || i > 65535) {
                throw new IllegalArgumentException("unexpected port: " + i);
            }
            this.port = i;
            return this;
        }

        int azb() {
            return this.port != -1 ? this.port : dvf.ky(this.dqH);
        }

        public C3224a kF(String str) {
            this.dvF = str != null ? dvf.kz(dvf.m9862b(str, " \"'<>#", true, true)) : null;
            return this;
        }

        public dvf azc() {
            if (this.dqH == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.dvz != null) {
                return new dvf();
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.dqH);
            stringBuilder.append("://");
            if (!(this.dvC.isEmpty() && this.dvD.isEmpty())) {
                stringBuilder.append(this.dvC);
                if (!this.dvD.isEmpty()) {
                    stringBuilder.append(':');
                    stringBuilder.append(this.dvD);
                }
                stringBuilder.append('@');
            }
            if (this.dvz.indexOf(58) != -1) {
                stringBuilder.append('[');
                stringBuilder.append(this.dvz);
                stringBuilder.append(']');
            } else {
                stringBuilder.append(this.dvz);
            }
            int azb = azb();
            if (azb != dvf.ky(this.dqH)) {
                stringBuilder.append(':');
                stringBuilder.append(azb);
            }
            dvf.m9859a(stringBuilder, this.dvE);
            if (this.dvF != null) {
                stringBuilder.append('?');
                dvf.m9863b(stringBuilder, this.dvF);
            }
            if (this.dvG != null) {
                stringBuilder.append('#');
                stringBuilder.append(this.dvG);
            }
            return stringBuilder.toString();
        }

        dvf m9853a(dvf com_fossil_dvf, String str) {
            int y;
            int u = m9847u(str, 0, str.length());
            int v = m9848v(str, u, str.length());
            if (C3224a.m9849w(str, u, v) != -1) {
                if (str.regionMatches(true, u, "https:", 0, 6)) {
                    this.dqH = UpPlatformSdkConstants.URI_SCHEME;
                    u += "https:".length();
                } else {
                    if (!str.regionMatches(true, u, "http:", 0, 5)) {
                        return null;
                    }
                    this.dqH = "http";
                    u += "http:".length();
                }
            } else if (com_fossil_dvf == null) {
                return null;
            } else {
                this.dqH = com_fossil_dvf.dqH;
            }
            int x = C3224a.m9850x(str, u, v);
            if (x >= 2 || com_fossil_dvf == null || !com_fossil_dvf.dqH.equals(this.dqH)) {
                Object obj = null;
                Object obj2 = null;
                int i = u + x;
                while (true) {
                    Object obj3;
                    Object obj4;
                    int b = dvf.m9854a(str, i, v, "@/\\?#");
                    switch (b != v ? str.charAt(b) : '￿') {
                        case '￿':
                        case '#':
                        case '/':
                        case '?':
                        case '\\':
                            y = C3224a.m9851y(str, i, b);
                            if (y + 1 < b) {
                                this.dvz = C3224a.m9852z(str, i, y);
                                this.port = C3224a.m9843B(str, y + 1, b);
                                if (this.port == -1) {
                                    return null;
                                }
                            }
                            this.dvz = C3224a.m9852z(str, i, y);
                            this.port = dvf.ky(this.dqH);
                            if (this.dvz != null) {
                                u = b;
                                break;
                            }
                            return null;
                        case '@':
                            if (obj == null) {
                                u = dvf.m9854a(str, i, b, ":");
                                String a = dvf.m9856a(str, i, u, " \"':;<=>@[]^`{}|/\\?#", true, false);
                                if (obj2 != null) {
                                    a = this.dvC + "%40" + a;
                                }
                                this.dvC = a;
                                if (u != b) {
                                    obj = 1;
                                    this.dvD = dvf.m9856a(str, u + 1, b, " \"':;<=>@[]^`{}|/\\?#", true, false);
                                }
                                obj2 = 1;
                            } else {
                                this.dvD += "%40" + dvf.m9856a(str, i, b, " \"':;<=>@[]^`{}|/\\?#", true, false);
                            }
                            u = b + 1;
                            obj3 = obj;
                            obj4 = obj2;
                            continue;
                        default:
                            obj3 = obj;
                            u = i;
                            obj4 = obj2;
                            continue;
                    }
                    obj = obj3;
                    obj2 = obj4;
                    i = u;
                }
            } else {
                this.dvC = com_fossil_dvf.ayT();
                this.dvD = com_fossil_dvf.ayU();
                this.dvz = com_fossil_dvf.dvz;
                this.port = com_fossil_dvf.port;
                this.dvE.clear();
                this.dvE.addAll(com_fossil_dvf.ayY());
                if (u == v || str.charAt(u) == '#') {
                    kF(com_fossil_dvf.ayZ());
                }
            }
            y = dvf.m9854a(str, u, v, "?#");
            m9846t(str, u, y);
            if (y >= v || str.charAt(y) != '?') {
                u = y;
            } else {
                u = dvf.m9854a(str, y, v, "#");
                this.dvF = dvf.kz(dvf.m9856a(str, y + 1, u, " \"'<>#", true, true));
            }
            if (u < v && str.charAt(u) == '#') {
                this.dvG = dvf.m9856a(str, u + 1, v, "", true, false);
            }
            return azc();
        }

        private void m9846t(String str, int i, int i2) {
            if (i != i2) {
                char charAt = str.charAt(i);
                if (charAt == '/' || charAt == '\\') {
                    this.dvE.clear();
                    this.dvE.add("");
                    i++;
                } else {
                    this.dvE.set(this.dvE.size() - 1, "");
                }
                int i3 = i;
                while (i3 < i2) {
                    int b = dvf.m9854a(str, i3, i2, "/\\");
                    boolean z = b < i2;
                    m9844a(str, i3, b, z, true);
                    if (z) {
                        b++;
                    }
                    i3 = b;
                }
            }
        }

        private void m9844a(String str, int i, int i2, boolean z, boolean z2) {
            String a = dvf.m9856a(str, i, i2, " \"<>^`{}|/\\?#", z2, false);
            if (!kG(a)) {
                if (kH(a)) {
                    azd();
                    return;
                }
                if (((String) this.dvE.get(this.dvE.size() - 1)).isEmpty()) {
                    this.dvE.set(this.dvE.size() - 1, a);
                } else {
                    this.dvE.add(a);
                }
                if (z) {
                    this.dvE.add("");
                }
            }
        }

        private boolean kG(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean kH(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private void azd() {
            if (!((String) this.dvE.remove(this.dvE.size() - 1)).isEmpty() || this.dvE.isEmpty()) {
                this.dvE.add("");
            } else {
                this.dvE.set(this.dvE.size() - 1, "");
            }
        }

        private int m9847u(String str, int i, int i2) {
            int i3 = i;
            while (i3 < i2) {
                switch (str.charAt(i3)) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                        i3++;
                    default:
                        return i3;
                }
            }
            return i2;
        }

        private int m9848v(String str, int i, int i2) {
            int i3 = i2 - 1;
            while (i3 >= i) {
                switch (str.charAt(i3)) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                        i3--;
                    default:
                        return i3 + 1;
                }
            }
            return i;
        }

        private static int m9849w(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')) {
                return -1;
            }
            int i3 = i + 1;
            while (i3 < i2) {
                char charAt2 = str.charAt(i3);
                if ((charAt2 >= 'a' && charAt2 <= 'z') || ((charAt2 >= 'A' && charAt2 <= 'Z') || charAt2 == '+' || charAt2 == '-' || charAt2 == '.')) {
                    i3++;
                } else if (charAt2 == ':') {
                    return i3;
                } else {
                    return -1;
                }
            }
            return -1;
        }

        private static int m9850x(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static int m9851y(java.lang.String r3, int r4, int r5) {
            /*
            r0 = r4;
        L_0x0001:
            if (r0 >= r5) goto L_0x001a;
        L_0x0003:
            r1 = r3.charAt(r0);
            switch(r1) {
                case 58: goto L_0x001b;
                case 91: goto L_0x000d;
                default: goto L_0x000a;
            };
        L_0x000a:
            r0 = r0 + 1;
            goto L_0x0001;
        L_0x000d:
            r0 = r0 + 1;
            if (r0 >= r5) goto L_0x000a;
        L_0x0011:
            r1 = r3.charAt(r0);
            r2 = 93;
            if (r1 != r2) goto L_0x000d;
        L_0x0019:
            goto L_0x000a;
        L_0x001a:
            r0 = r5;
        L_0x001b:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fossil.dvf.a.y(java.lang.String, int, int):int");
        }

        private static String m9852z(String str, int i, int i2) {
            String s = dvf.m9865s(str, i, i2);
            if (s.startsWith("[") && s.endsWith("]")) {
                InetAddress A = C3224a.m9842A(s, 1, s.length() - 1);
                if (A == null) {
                    return null;
                }
                byte[] address = A.getAddress();
                if (address.length == 16) {
                    return C3224a.ar(address);
                }
                throw new AssertionError();
            }
            s = C3224a.kI(s);
            if (s == null) {
                return null;
            }
            int length = s.length();
            if (dvf.m9854a(s, 0, length, "\u0000\t\n\r #%/:?@[\\]") == length) {
                return s;
            }
            return null;
        }

        private static InetAddress m9842A(String str, int i, int i2) {
            byte[] bArr = new byte[16];
            int i3 = i;
            int i4 = -1;
            int i5 = -1;
            int i6 = 0;
            while (i3 < i2) {
                if (i6 == bArr.length) {
                    return null;
                }
                int decodeHexDigit;
                if (i3 + 2 > i2 || !str.regionMatches(i3, "::", 0, 2)) {
                    if (i6 != 0) {
                        if (str.regionMatches(i3, ":", 0, 1)) {
                            i3++;
                        } else if (!str.regionMatches(i3, ".", 0, 1)) {
                            return null;
                        } else {
                            if (!C3224a.m9845a(str, i4, i2, bArr, i6 - 2)) {
                                return null;
                            }
                            i6 += 2;
                        }
                    }
                } else if (i5 != -1) {
                    return null;
                } else {
                    i3 += 2;
                    i5 = i6 + 2;
                    if (i3 == i2) {
                        i6 = i5;
                        break;
                    }
                    i6 = i5;
                }
                i4 = 0;
                int i7 = i3;
                while (i7 < i2) {
                    decodeHexDigit = dvf.decodeHexDigit(str.charAt(i7));
                    if (decodeHexDigit == -1) {
                        break;
                    }
                    i4 = (i4 << 4) + decodeHexDigit;
                    i7++;
                }
                decodeHexDigit = i7 - i3;
                if (decodeHexDigit == 0 || decodeHexDigit > 4) {
                    return null;
                }
                decodeHexDigit = i6 + 1;
                bArr[i6] = (byte) ((i4 >>> 8) & 255);
                i6 = decodeHexDigit + 1;
                bArr[decodeHexDigit] = (byte) (i4 & 255);
                i4 = i3;
                i3 = i7;
            }
            if (i6 != bArr.length) {
                if (i5 == -1) {
                    return null;
                }
                System.arraycopy(bArr, i5, bArr, bArr.length - (i6 - i5), i6 - i5);
                Arrays.fill(bArr, i5, (bArr.length - i6) + i5, (byte) 0);
            }
            try {
                return InetAddress.getByAddress(bArr);
            } catch (UnknownHostException e) {
                throw new AssertionError();
            }
        }

        private static boolean m9845a(String str, int i, int i2, byte[] bArr, int i3) {
            int i4 = i;
            int i5 = i3;
            while (i4 < i2) {
                if (i5 == bArr.length) {
                    return false;
                }
                if (i5 != i3) {
                    if (str.charAt(i4) != '.') {
                        return false;
                    }
                    i4++;
                }
                int i6 = 0;
                int i7 = i4;
                while (i7 < i2) {
                    char charAt = str.charAt(i7);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    } else if (i6 == 0 && i4 != i7) {
                        return false;
                    } else {
                        i6 = ((i6 * 10) + charAt) - 48;
                        if (i6 > 255) {
                            return false;
                        }
                        i7++;
                    }
                }
                if (i7 - i4 == 0) {
                    return false;
                }
                i4 = i5 + 1;
                bArr[i5] = (byte) i6;
                i5 = i4;
                i4 = i7;
            }
            if (i5 != i3 + 4) {
                return false;
            }
            return true;
        }

        private static String kI(String str) {
            try {
                String toLowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (toLowerCase.isEmpty()) {
                    return null;
                }
                return toLowerCase;
            } catch (IllegalArgumentException e) {
                return null;
            }
        }

        private static String ar(byte[] bArr) {
            int i = 0;
            int i2 = 0;
            int i3 = -1;
            int i4 = 0;
            while (i4 < bArr.length) {
                int i5 = i4;
                while (i5 < 16 && bArr[i5] == (byte) 0 && bArr[i5 + 1] == (byte) 0) {
                    i5 += 2;
                }
                int i6 = i5 - i4;
                if (i6 > i2) {
                    i2 = i6;
                    i3 = i4;
                }
                i4 = i5 + 2;
            }
            eth com_fossil_eth = new eth();
            while (i < bArr.length) {
                if (i == i3) {
                    com_fossil_eth.pr(58);
                    i += i2;
                    if (i == 16) {
                        com_fossil_eth.pr(58);
                    }
                } else {
                    if (i > 0) {
                        com_fossil_eth.pr(58);
                    }
                    com_fossil_eth.bi((long) (((bArr[i] & 255) << 8) | (bArr[i + 1] & 255)));
                    i += 2;
                }
            }
            return com_fossil_eth.aHo();
        }

        private static int m9843B(String str, int i, int i2) {
            try {
                int parseInt = Integer.parseInt(dvf.m9856a(str, i, i2, "", false, false));
                return (parseInt <= 0 || parseInt > 65535) ? -1 : parseInt;
            } catch (NumberFormatException e) {
                return -1;
            }
        }
    }

    private dvf(C3224a c3224a) {
        String str = null;
        this.dqH = c3224a.dqH;
        this.username = kC(c3224a.dvC);
        this.cBN = kC(c3224a.dvD);
        this.dvz = c3224a.dvz;
        this.port = c3224a.azb();
        this.dvA = aw(c3224a.dvE);
        this.dvB = c3224a.dvF != null ? aw(c3224a.dvF) : null;
        if (c3224a.dvG != null) {
            str = kC(c3224a.dvG);
        }
        this.fragment = str;
        this.url = c3224a.toString();
    }

    public URL ayP() {
        try {
            return new URL(this.url);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public URI ayQ() {
        try {
            return new URI(this.url);
        } catch (URISyntaxException e) {
            throw new IllegalStateException("not valid as a java.net.URI: " + this.url);
        }
    }

    public String ayR() {
        return this.dqH;
    }

    public boolean ayS() {
        return this.dqH.equals(UpPlatformSdkConstants.URI_SCHEME);
    }

    public String ayT() {
        if (this.username.isEmpty()) {
            return "";
        }
        int length = this.dqH.length() + 3;
        return this.url.substring(length, m9854a(this.url, length, this.url.length(), ":@"));
    }

    public String ayU() {
        if (this.cBN.isEmpty()) {
            return "";
        }
        return this.url.substring(this.url.indexOf(58, this.dqH.length() + 3) + 1, this.url.indexOf(64));
    }

    public String ayV() {
        return this.dvz;
    }

    public int ayW() {
        return this.port;
    }

    public static int ky(String str) {
        if (str.equals("http")) {
            return 80;
        }
        if (str.equals(UpPlatformSdkConstants.URI_SCHEME)) {
            return 443;
        }
        return -1;
    }

    public String ayX() {
        int indexOf = this.url.indexOf(47, this.dqH.length() + 3);
        return this.url.substring(indexOf, m9854a(this.url, indexOf, this.url.length(), "?#"));
    }

    static void m9859a(StringBuilder stringBuilder, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append('/');
            stringBuilder.append((String) list.get(i));
        }
    }

    public List<String> ayY() {
        int indexOf = this.url.indexOf(47, this.dqH.length() + 3);
        int a = m9854a(this.url, indexOf, this.url.length(), "?#");
        List<String> arrayList = new ArrayList();
        while (indexOf < a) {
            int i = indexOf + 1;
            indexOf = m9854a(this.url, i, a, "/");
            arrayList.add(this.url.substring(i, indexOf));
        }
        return arrayList;
    }

    public String ayZ() {
        if (this.dvB == null) {
            return null;
        }
        int indexOf = this.url.indexOf(63) + 1;
        return this.url.substring(indexOf, m9854a(this.url, indexOf + 1, this.url.length(), "#"));
    }

    static void m9863b(StringBuilder stringBuilder, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = (String) list.get(i);
            String str2 = (String) list.get(i + 1);
            if (i > 0) {
                stringBuilder.append('&');
            }
            stringBuilder.append(str);
            if (str2 != null) {
                stringBuilder.append('=');
                stringBuilder.append(str2);
            }
        }
    }

    static List<String> kz(String str) {
        List<String> arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    public String aza() {
        if (this.dvB == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        m9863b(stringBuilder, this.dvB);
        return stringBuilder.toString();
    }

    public dvf kA(String str) {
        return new C3224a().m9853a(this, str);
    }

    public static dvf kB(String str) {
        return new C3224a().m9853a(null, str);
    }

    public boolean equals(Object obj) {
        return (obj instanceof dvf) && ((dvf) obj).url.equals(this.url);
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String toString() {
        return this.url;
    }

    private static int m9854a(String str, int i, int i2, String str2) {
        for (int i3 = i; i3 < i2; i3++) {
            if (str2.indexOf(str.charAt(i3)) != -1) {
                return i3;
            }
        }
        return i2;
    }

    static String kC(String str) {
        return m9865s(str, 0, str.length());
    }

    private List<String> aw(List<String> list) {
        List arrayList = new ArrayList(list.size());
        for (String str : list) {
            arrayList.add(str != null ? kC(str) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static String m9865s(String str, int i, int i2) {
        for (int i3 = i; i3 < i2; i3++) {
            if (str.charAt(i3) == '%') {
                eth com_fossil_eth = new eth();
                com_fossil_eth.m11153C(str, i, i3);
                m9857a(com_fossil_eth, str, i3, i2);
                return com_fossil_eth.aHo();
            }
        }
        return str.substring(i, i2);
    }

    static void m9857a(eth com_fossil_eth, String str, int i, int i2) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt == 37 && i3 + 2 < i2) {
                int decodeHexDigit = decodeHexDigit(str.charAt(i3 + 1));
                int decodeHexDigit2 = decodeHexDigit(str.charAt(i3 + 2));
                if (!(decodeHexDigit == -1 || decodeHexDigit2 == -1)) {
                    com_fossil_eth.pr((decodeHexDigit << 4) + decodeHexDigit2);
                    i3 += 2;
                    i3 += Character.charCount(codePointAt);
                }
            }
            com_fossil_eth.pq(codePointAt);
            i3 += Character.charCount(codePointAt);
        }
    }

    static int decodeHexDigit(char c) {
        if (c >= '0' && c <= '9') {
            return c - 48;
        }
        if (c >= 'a' && c <= 'f') {
            return (c - 97) + 10;
        }
        if (c < 'A' || c > 'F') {
            return -1;
        }
        return (c - 65) + 10;
    }

    static String m9856a(String str, int i, int i2, String str2, boolean z, boolean z2) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt < 32 || codePointAt >= 127 || str2.indexOf(codePointAt) != -1 || ((codePointAt == 37 && !z) || (z2 && codePointAt == 43))) {
                eth com_fossil_eth = new eth();
                com_fossil_eth.m11153C(str, i, i3);
                m9858a(com_fossil_eth, str, i3, i2, str2, z, z2);
                return com_fossil_eth.aHo();
            }
            i3 += Character.charCount(codePointAt);
        }
        return str.substring(i, i2);
    }

    static void m9858a(eth com_fossil_eth, String str, int i, int i2, String str2, boolean z, boolean z2) {
        eth com_fossil_eth2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!(z && (codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13))) {
                if (z2 && codePointAt == 43) {
                    com_fossil_eth.mH(z ? "%20" : "%2B");
                } else if (codePointAt < 32 || codePointAt >= 127 || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && !z)) {
                    if (com_fossil_eth2 == null) {
                        com_fossil_eth2 = new eth();
                    }
                    com_fossil_eth2.pq(codePointAt);
                    while (!com_fossil_eth2.aHi()) {
                        int readByte = com_fossil_eth2.readByte() & 255;
                        com_fossil_eth.pr(37);
                        com_fossil_eth.pr(HEX_DIGITS[(readByte >> 4) & 15]);
                        com_fossil_eth.pr(HEX_DIGITS[readByte & 15]);
                    }
                } else {
                    com_fossil_eth.pq(codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    static String m9862b(String str, String str2, boolean z, boolean z2) {
        return m9856a(str, 0, str.length(), str2, z, z2);
    }
}
