package com.fossil;

import java.util.concurrent.TimeUnit;

public final class duu {
    public static final duu dus = new C3212a().ayq().ays();
    public static final duu dut = new C3212a().ayr().m9795a(Integer.MAX_VALUE, TimeUnit.SECONDS).ays();
    private final boolean duA;
    private final int duB;
    private final int duC;
    private final boolean duD;
    private final boolean duE;
    String duF;
    private final boolean duu;
    private final boolean duv;
    private final int duw;
    private final int dux;
    private final boolean duy;
    private final boolean duz;

    public static final class C3212a {
        int duB = -1;
        int duC = -1;
        boolean duD;
        boolean duE;
        boolean duu;
        boolean duv;
        int duw = -1;

        public C3212a ayq() {
            this.duu = true;
            return this;
        }

        public C3212a m9795a(int i, TimeUnit timeUnit) {
            if (i < 0) {
                throw new IllegalArgumentException("maxStale < 0: " + i);
            }
            long toSeconds = timeUnit.toSeconds((long) i);
            this.duB = toSeconds > 2147483647L ? Integer.MAX_VALUE : (int) toSeconds;
            return this;
        }

        public C3212a ayr() {
            this.duD = true;
            return this;
        }

        public duu ays() {
            return new duu();
        }
    }

    private duu(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, String str) {
        this.duu = z;
        this.duv = z2;
        this.duw = i;
        this.dux = i2;
        this.duy = z3;
        this.duz = z4;
        this.duA = z5;
        this.duB = i3;
        this.duC = i4;
        this.duD = z6;
        this.duE = z7;
        this.duF = str;
    }

    private duu(C3212a c3212a) {
        this.duu = c3212a.duu;
        this.duv = c3212a.duv;
        this.duw = c3212a.duw;
        this.dux = -1;
        this.duy = false;
        this.duz = false;
        this.duA = false;
        this.duB = c3212a.duB;
        this.duC = c3212a.duC;
        this.duD = c3212a.duD;
        this.duE = c3212a.duE;
    }

    public boolean ayi() {
        return this.duu;
    }

    public boolean ayj() {
        return this.duv;
    }

    public int ayk() {
        return this.duw;
    }

    public boolean isPrivate() {
        return this.duy;
    }

    public boolean isPublic() {
        return this.duz;
    }

    public boolean ayl() {
        return this.duA;
    }

    public int aym() {
        return this.duB;
    }

    public int ayn() {
        return this.duC;
    }

    public boolean ayo() {
        return this.duD;
    }

    public static duu m9796a(dve com_fossil_dve) {
        String mz;
        boolean z = false;
        int i = -1;
        int i2 = -1;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        int i3 = -1;
        int i4 = -1;
        boolean z5 = false;
        boolean z6 = false;
        Object obj = 1;
        int size = com_fossil_dve.size();
        int i5 = 0;
        String str = null;
        boolean z7 = false;
        while (i5 < size) {
            boolean z8;
            String my = com_fossil_dve.my(i5);
            mz = com_fossil_dve.mz(i5);
            if (my.equalsIgnoreCase("Cache-Control")) {
                if (str != null) {
                    obj = null;
                } else {
                    str = mz;
                }
            } else if (my.equalsIgnoreCase("Pragma")) {
                obj = null;
            } else {
                z8 = z7;
                i5++;
                z7 = z8;
            }
            z8 = z7;
            int i6 = 0;
            while (i6 < mz.length()) {
                String str2;
                int b = dwr.m10190b(mz, i6, "=,;");
                String trim = mz.substring(i6, b).trim();
                if (b == mz.length() || mz.charAt(b) == ',' || mz.charAt(b) == ';') {
                    i6 = b + 1;
                    str2 = null;
                } else {
                    i6 = dwr.m10188K(mz, b + 1);
                    String trim2;
                    if (i6 >= mz.length() || mz.charAt(i6) != '\"') {
                        b = dwr.m10190b(mz, i6, ",;");
                        trim2 = mz.substring(i6, b).trim();
                        i6 = b;
                        str2 = trim2;
                    } else {
                        i6++;
                        b = dwr.m10190b(mz, i6, "\"");
                        trim2 = mz.substring(i6, b);
                        i6 = b + 1;
                        str2 = trim2;
                    }
                }
                if ("no-cache".equalsIgnoreCase(trim)) {
                    z8 = true;
                } else if ("no-store".equalsIgnoreCase(trim)) {
                    z = true;
                } else if ("max-age".equalsIgnoreCase(trim)) {
                    i = dwr.m10189L(str2, -1);
                } else if ("s-maxage".equalsIgnoreCase(trim)) {
                    i2 = dwr.m10189L(str2, -1);
                } else if ("private".equalsIgnoreCase(trim)) {
                    z2 = true;
                } else if ("public".equalsIgnoreCase(trim)) {
                    z3 = true;
                } else if ("must-revalidate".equalsIgnoreCase(trim)) {
                    z4 = true;
                } else if ("max-stale".equalsIgnoreCase(trim)) {
                    i3 = dwr.m10189L(str2, Integer.MAX_VALUE);
                } else if ("min-fresh".equalsIgnoreCase(trim)) {
                    i4 = dwr.m10189L(str2, -1);
                } else if ("only-if-cached".equalsIgnoreCase(trim)) {
                    z5 = true;
                } else if ("no-transform".equalsIgnoreCase(trim)) {
                    z6 = true;
                }
            }
            i5++;
            z7 = z8;
        }
        if (obj == null) {
            mz = null;
        } else {
            mz = str;
        }
        return new duu(z7, z, i, i2, z2, z3, z4, i3, i4, z5, z6, mz);
    }

    public String toString() {
        String str = this.duF;
        if (str != null) {
            return str;
        }
        str = ayp();
        this.duF = str;
        return str;
    }

    private String ayp() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.duu) {
            stringBuilder.append("no-cache, ");
        }
        if (this.duv) {
            stringBuilder.append("no-store, ");
        }
        if (this.duw != -1) {
            stringBuilder.append("max-age=").append(this.duw).append(", ");
        }
        if (this.dux != -1) {
            stringBuilder.append("s-maxage=").append(this.dux).append(", ");
        }
        if (this.duy) {
            stringBuilder.append("private, ");
        }
        if (this.duz) {
            stringBuilder.append("public, ");
        }
        if (this.duA) {
            stringBuilder.append("must-revalidate, ");
        }
        if (this.duB != -1) {
            stringBuilder.append("max-stale=").append(this.duB).append(", ");
        }
        if (this.duC != -1) {
            stringBuilder.append("min-fresh=").append(this.duC).append(", ");
        }
        if (this.duD) {
            stringBuilder.append("only-if-cached, ");
        }
        if (this.duE) {
            stringBuilder.append("no-transform, ");
        }
        if (stringBuilder.length() == 0) {
            return "";
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        return stringBuilder.toString();
    }
}
