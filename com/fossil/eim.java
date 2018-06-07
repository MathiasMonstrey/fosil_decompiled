package com.fossil;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;

public class eim {
    private String dIm;
    private boolean dIn = false;
    private boolean dIo = false;
    private int dIp = 0;
    private boolean dIq = false;
    ArrayList<C3414a> dIr = null;
    ArrayList<String> dIs = null;
    private String href;

    public static class C3414a {
        boolean dIt;
        String key;
        String value;

        private C3414a(String str, String str2) {
            this.key = str;
            this.value = str2;
        }

        private String aDt() {
            int i = 0;
            int length = this.value.length();
            if (length <= 1 || this.value.charAt(0) != '{' || this.value.charAt(length - 1) != '}') {
                return null;
            }
            while (this.value.charAt(i) == '{') {
                i++;
            }
            while (this.value.charAt(length - 1) == '}') {
                length--;
            }
            return this.value.substring(i, length);
        }
    }

    protected eim(String str) {
        if (str == null) {
            str = "";
        }
        this.dIm = str;
        this.dIp += str.length();
    }

    protected void m10614O(String str, int i) {
        bi(str, String.valueOf(i));
    }

    protected void bi(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                if (this.dIr == null) {
                    this.dIr = new ArrayList(8);
                }
                this.dIn = true;
                C3414a lC = lC(str);
                if (lC == null) {
                    this.dIr.add(new C3414a(str, str2));
                    this.dIp += (str.length() + str2.length()) + 2;
                    return;
                }
                this.dIp += str2.length() - lC.value.length();
                lC.value = str2;
            } else if (lB(str) != null) {
                this.dIn = true;
            }
        }
    }

    protected void aDs() {
        int i = 1;
        if (!this.dIq) {
            this.dIq = true;
            int indexOf = this.dIm.indexOf(63);
            if (indexOf >= 0) {
                String substring = this.dIm.substring(indexOf);
                this.dIm = this.dIm.substring(0, indexOf);
                this.dIn = true;
                indexOf = substring.length();
                while (i < indexOf) {
                    int indexOf2 = substring.indexOf(61, i);
                    if (indexOf2 < 0) {
                        throw new IllegalArgumentException(this.dIm + " is incorrectly formatted.");
                    }
                    String substring2 = substring.substring(i, indexOf2);
                    i = substring.indexOf(38, i);
                    if (i < 0) {
                        i = indexOf;
                    }
                    bi(substring2, substring.substring(indexOf2 + 1, i));
                    i++;
                }
            }
        }
    }

    public String getHref() {
        if (this.dIn) {
            if (this.dIo) {
                this.dIp += "self".length();
            }
            StringBuilder stringBuilder = new StringBuilder(this.dIp);
            m10611e(stringBuilder);
            m10612f(stringBuilder);
            m10613g(stringBuilder);
            return stringBuilder.toString();
        }
        if (this.href == null) {
            this.href = this.dIm;
        }
        return this.href;
    }

    protected C3414a lB(String str) {
        aDs();
        if (this.dIr == null) {
            return null;
        }
        int size = this.dIr.size();
        for (int i = 0; i < size; i++) {
            C3414a c3414a = (C3414a) this.dIr.get(i);
            if (c3414a.key.equals(str)) {
                this.dIr.remove(i);
                this.dIp -= (c3414a.key.length() + c3414a.value.length()) + 2;
                return c3414a;
            }
        }
        return null;
    }

    protected C3414a lC(String str) {
        aDs();
        if (this.dIr == null) {
            return null;
        }
        int size = this.dIr.size();
        for (int i = 0; i < size; i++) {
            C3414a c3414a = (C3414a) this.dIr.get(i);
            if (c3414a.key.equals(str)) {
                return c3414a;
            }
        }
        return null;
    }

    private void m10611e(StringBuilder stringBuilder) {
        String str = this.dIm;
        int length = str.length();
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            if (!z) {
                switch (charAt) {
                    case '\\':
                        stringBuilder.append(charAt);
                        z = true;
                        break;
                    case '{':
                        i3++;
                        if (i3 != 1) {
                            break;
                        }
                        i = i4;
                        break;
                    case '}':
                        if (i3 <= 0) {
                            stringBuilder.append(charAt);
                            break;
                        }
                        i2++;
                        if (i3 != i2) {
                            break;
                        }
                        C3414a lC = lC(str.substring(i + i3, (i4 + 1) - i2));
                        lC.dIt = true;
                        if (lC == null) {
                            stringBuilder.append("null");
                        } else {
                            stringBuilder.append(lD(lC.value));
                        }
                        i = -1;
                        i2 = 0;
                        i3 = 0;
                        break;
                    default:
                        if (i >= 0) {
                            break;
                        }
                        stringBuilder.append(charAt);
                        break;
                }
            }
            stringBuilder.append(charAt);
            z = false;
        }
    }

    private void m10612f(StringBuilder stringBuilder) {
        char c = '?';
        int size = this.dIr.size();
        int i = 0;
        while (i < size) {
            char c2;
            C3414a c3414a = (C3414a) this.dIr.get(i);
            if (!c3414a.dIt) {
                stringBuilder.append(c);
                c = '&';
                stringBuilder.append(c3414a.key);
                stringBuilder.append('=');
                String a = c3414a.aDt();
                if (a != null) {
                    C3414a lC = lC(a);
                    if (lC != null) {
                        lC.dIt = true;
                        stringBuilder.append(lD(lC.value));
                    } else {
                        stringBuilder.append(lD(c3414a.value));
                    }
                    c2 = '&';
                    i++;
                    c = c2;
                } else {
                    stringBuilder.append(lD(c3414a.value));
                }
            }
            c2 = c;
            i++;
            c = c2;
        }
    }

    private void m10613g(StringBuilder stringBuilder) {
        if (this.dIo) {
            StringBuilder stringBuilder2 = new StringBuilder();
            Iterator it = this.dIs.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (stringBuilder2.length() > 0) {
                    stringBuilder2.append(",");
                }
                stringBuilder2.append(str);
            }
            if (stringBuilder2.length() > 0) {
                stringBuilder.append(this.dIr.isEmpty() ? '?' : '&').append("self").append(SimpleComparison.EQUAL_TO_OPERATION).append(stringBuilder2.toString());
            }
        }
    }

    private static String lD(String str) {
        try {
            str = URLEncoder.encode(str, "UTF-8");
        } catch (Throwable e) {
            ecq.m10489d("UrlEncode error", e);
        }
        return str;
    }
}
