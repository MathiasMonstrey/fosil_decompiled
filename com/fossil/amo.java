package com.fossil;

public abstract class amo {
    public static final amo aVN = new C17041();

    static class C17041 extends amo {
        C17041() {
        }

        public String cc(String str) {
            return str;
        }
    }

    public static class C1708a extends amo {
        protected final amo aVQ;
        protected final amo aVR;

        public C1708a(amo com_fossil_amo, amo com_fossil_amo2) {
            this.aVQ = com_fossil_amo;
            this.aVR = com_fossil_amo2;
        }

        public String cc(String str) {
            return this.aVQ.cc(this.aVR.cc(str));
        }

        public String toString() {
            return "[ChainedTransformer(" + this.aVQ + ", " + this.aVR + ")]";
        }
    }

    public abstract String cc(String str);

    protected amo() {
    }

    public static amo m3885u(final String str, final String str2) {
        Object obj = 1;
        Object obj2 = (str == null || str.length() <= 0) ? null : 1;
        if (str2 == null || str2.length() <= 0) {
            obj = null;
        }
        if (obj2 == null) {
            return obj != null ? new amo() {
                public String cc(String str) {
                    return str + str2;
                }

                public String toString() {
                    return "[SuffixTransformer('" + str2 + "')]";
                }
            } : aVN;
        } else {
            if (obj != null) {
                return new amo() {
                    public String cc(String str) {
                        return str + str + str2;
                    }

                    public String toString() {
                        return "[PreAndSuffixTransformer('" + str + "','" + str2 + "')]";
                    }
                };
            }
            return new amo() {
                public String cc(String str) {
                    return str + str;
                }

                public String toString() {
                    return "[PrefixTransformer('" + str + "')]";
                }
            };
        }
    }

    public static amo m3884a(amo com_fossil_amo, amo com_fossil_amo2) {
        return new C1708a(com_fossil_amo, com_fossil_amo2);
    }
}
