package com.fossil;

import java.util.Arrays;

public final class ccm {

    public static final class C1996a {
        private final C1995a bLD;
        private C1995a bLE;
        private boolean bLF;
        private final String className;

        static final class C1995a {
            C1995a bLG;
            String name;
            Object value;

            private C1995a() {
            }
        }

        private C1996a(String str) {
            this.bLD = new C1995a();
            this.bLE = this.bLD;
            this.bLF = false;
            this.className = (String) cco.ce(str);
        }

        public C1996a m5979h(String str, Object obj) {
            return m5978i(str, obj);
        }

        public C1996a m5980v(String str, int i) {
            return m5978i(str, String.valueOf(i));
        }

        public C1996a cc(Object obj) {
            return cd(obj);
        }

        public String toString() {
            boolean z = this.bLF;
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            String str = "";
            for (C1995a c1995a = this.bLD.bLG; c1995a != null; c1995a = c1995a.bLG) {
                Object obj = c1995a.value;
                if (!z || obj != null) {
                    append.append(str);
                    str = ", ";
                    if (c1995a.name != null) {
                        append.append(c1995a.name).append('=');
                    }
                    if (obj == null || !obj.getClass().isArray()) {
                        append.append(obj);
                    } else {
                        CharSequence deepToString = Arrays.deepToString(new Object[]{obj});
                        append.append(deepToString, 1, deepToString.length() - 1);
                    }
                }
            }
            return append.append('}').toString();
        }

        private C1995a Ud() {
            C1995a c1995a = new C1995a();
            this.bLE.bLG = c1995a;
            this.bLE = c1995a;
            return c1995a;
        }

        private C1996a cd(Object obj) {
            Ud().value = obj;
            return this;
        }

        private C1996a m5978i(String str, Object obj) {
            C1995a Ud = Ud();
            Ud.value = obj;
            Ud.name = (String) cco.ce(str);
            return this;
        }
    }

    public static <T> T m5981r(T t, T t2) {
        return t != null ? t : cco.ce(t2);
    }

    public static C1996a cb(Object obj) {
        return new C1996a(obj.getClass().getSimpleName());
    }
}
