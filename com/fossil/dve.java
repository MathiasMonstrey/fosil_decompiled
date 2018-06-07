package com.fossil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public final class dve {
    private final String[] dvx;

    public static final class C3222a {
        private final List<String> dvy = new ArrayList(20);

        C3222a kw(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                return aV(str.substring(0, indexOf), str.substring(indexOf + 1));
            }
            if (str.startsWith(":")) {
                return aV("", str.substring(1));
            }
            return aV("", str);
        }

        public C3222a aU(String str, String str2) {
            aX(str, str2);
            return aV(str, str2);
        }

        C3222a aV(String str, String str2) {
            this.dvy.add(str);
            this.dvy.add(str2.trim());
            return this;
        }

        public C3222a kx(String str) {
            int i = 0;
            while (i < this.dvy.size()) {
                if (str.equalsIgnoreCase((String) this.dvy.get(i))) {
                    this.dvy.remove(i);
                    this.dvy.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public C3222a aW(String str, String str2) {
            aX(str, str2);
            kx(str);
            aV(str, str2);
            return this;
        }

        private void aX(String str, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("name == null");
            } else if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            } else {
                int i;
                char charAt;
                int length = str.length();
                for (i = 0; i < length; i++) {
                    charAt = str.charAt(i);
                    if (charAt <= '\u001f' || charAt >= '') {
                        throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header name: %s", new Object[]{Integer.valueOf(charAt), Integer.valueOf(i), str}));
                    }
                }
                if (str2 == null) {
                    throw new IllegalArgumentException("value == null");
                }
                length = str2.length();
                for (i = 0; i < length; i++) {
                    charAt = str2.charAt(i);
                    if (charAt <= '\u001f' || charAt >= '') {
                        throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header value: %s", new Object[]{Integer.valueOf(charAt), Integer.valueOf(i), str2}));
                    }
                }
            }
        }

        public dve ayO() {
            return new dve();
        }
    }

    private dve(C3222a c3222a) {
        this.dvx = (String[]) c3222a.dvy.toArray(new String[c3222a.dvy.size()]);
    }

    public String get(String str) {
        return m9841a(this.dvx, str);
    }

    public Date kv(String str) {
        String str2 = get(str);
        return str2 != null ? dwt.parse(str2) : null;
    }

    public int size() {
        return this.dvx.length / 2;
    }

    public String my(int i) {
        int i2 = i * 2;
        if (i2 < 0 || i2 >= this.dvx.length) {
            return null;
        }
        return this.dvx[i2];
    }

    public String mz(int i) {
        int i2 = (i * 2) + 1;
        if (i2 < 0 || i2 >= this.dvx.length) {
            return null;
        }
        return this.dvx[i2];
    }

    public C3222a ayN() {
        C3222a c3222a = new C3222a();
        Collections.addAll(c3222a.dvy, this.dvx);
        return c3222a;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int size = size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(my(i)).append(": ").append(mz(i)).append("\n");
        }
        return stringBuilder.toString();
    }

    private static String m9841a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }
}
