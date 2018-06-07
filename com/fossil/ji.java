package com.fossil;

import java.util.Locale;

public final class ji {
    public static final jh PF = new C3752e(null, false);
    public static final jh PG = new C3752e(null, true);
    public static final jh PH = new C3752e(C3750b.PP, false);
    public static final jh PI = new C3752e(C3750b.PP, true);
    public static final jh PJ = new C3752e(C3749a.PN, false);
    public static final jh PK = C3753f.PS;

    interface C3748c {
        int mo3235a(CharSequence charSequence, int i, int i2);
    }

    static class C3749a implements C3748c {
        public static final C3749a PN = new C3749a(true);
        public static final C3749a PO = new C3749a(false);
        private final boolean PL;

        public int mo3235a(CharSequence charSequence, int i, int i2) {
            int i3 = i + i2;
            int i4 = 0;
            while (i < i3) {
                switch (ji.bf(Character.getDirectionality(charSequence.charAt(i)))) {
                    case 0:
                        if (!this.PL) {
                            i4 = 1;
                            break;
                        }
                        return 0;
                    case 1:
                        if (this.PL) {
                            i4 = 1;
                            break;
                        }
                        return 1;
                    default:
                        break;
                }
                i++;
            }
            if (i4 == 0) {
                return 2;
            }
            if (this.PL) {
                return 1;
            }
            return 0;
        }

        private C3749a(boolean z) {
            this.PL = z;
        }
    }

    static class C3750b implements C3748c {
        public static final C3750b PP = new C3750b();

        public int mo3235a(CharSequence charSequence, int i, int i2) {
            int i3 = i + i2;
            int i4 = 2;
            while (i < i3 && i4 == 2) {
                i4 = ji.bg(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return i4;
        }

        private C3750b() {
        }
    }

    static abstract class C3751d implements jh {
        private final C3748c PQ;

        protected abstract boolean jl();

        public C3751d(C3748c c3748c) {
            this.PQ = c3748c;
        }

        public boolean isRtl(CharSequence charSequence, int i, int i2) {
            if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new IllegalArgumentException();
            } else if (this.PQ == null) {
                return jl();
            } else {
                return m11874b(charSequence, i, i2);
            }
        }

        private boolean m11874b(CharSequence charSequence, int i, int i2) {
            switch (this.PQ.mo3235a(charSequence, i, i2)) {
                case 0:
                    return true;
                case 1:
                    return false;
                default:
                    return jl();
            }
        }
    }

    static class C3752e extends C3751d {
        private final boolean PR;

        C3752e(C3748c c3748c, boolean z) {
            super(c3748c);
            this.PR = z;
        }

        protected boolean jl() {
            return this.PR;
        }
    }

    static class C3753f extends C3751d {
        public static final C3753f PS = new C3753f();

        public C3753f() {
            super(null);
        }

        protected boolean jl() {
            if (jj.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
                return true;
            }
            return false;
        }
    }

    static int bf(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
            case 2:
                return 0;
            default:
                return 2;
        }
    }

    static int bg(int i) {
        switch (i) {
            case 0:
            case 14:
            case 15:
                return 1;
            case 1:
            case 2:
            case 16:
            case 17:
                return 0;
            default:
                return 2;
        }
    }
}
