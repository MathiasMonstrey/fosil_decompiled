package com.fossil;

import com.facebook.internal.FacebookRequestErrorClassification;

public class etd extends etc {
    public static final int m11136K(CharSequence charSequence) {
        esl.m11128j(charSequence, "$receiver");
        return charSequence.length() - 1;
    }

    public static final boolean m11141a(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        esl.m11128j(charSequence, "$receiver");
        esl.m11128j(charSequence2, FacebookRequestErrorClassification.KEY_OTHER);
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        int i4 = i3 - 1;
        if (0 <= i4) {
            int i5 = 0;
            while (esv.m11131a(charSequence.charAt(i + i5), charSequence2.charAt(i2 + i5), z)) {
                if (i5 != i4) {
                    i5++;
                }
            }
            return false;
        }
        return true;
    }

    static /* bridge */ /* synthetic */ int m11138a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        return m11137a(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final int m11137a(java.lang.CharSequence r8, java.lang.CharSequence r9, int r10, int r11, boolean r12, boolean r13) {
        /*
        r1 = 0;
        if (r13 != 0) goto L_0x0040;
    L_0x0003:
        r2 = com.fossil.ess.cw(r10, r1);
        r0 = new com.fossil.esp;
        r3 = r8.length();
        r3 = com.fossil.ess.cx(r11, r3);
        r0.<init>(r2, r3);
        r0 = (com.fossil.esn) r0;
    L_0x0016:
        r2 = r8 instanceof java.lang.String;
        if (r2 == 0) goto L_0x0059;
    L_0x001a:
        r2 = r9 instanceof java.lang.String;
        if (r2 == 0) goto L_0x0059;
    L_0x001e:
        r3 = r0.aGX();
        r6 = r0.aGY();
        r7 = r0.aGZ();
        if (r7 <= 0) goto L_0x0051;
    L_0x002c:
        if (r3 > r6) goto L_0x0053;
    L_0x002e:
        r0 = r9;
        r0 = (java.lang.String) r0;
        r2 = r8;
        r2 = (java.lang.String) r2;
        r4 = r9.length();
        r5 = r12;
        r0 = com.fossil.etc.m11132a(r0, r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x0055;
    L_0x003f:
        return r3;
    L_0x0040:
        r0 = m11136K(r8);
        r0 = com.fossil.ess.cx(r10, r0);
        r2 = com.fossil.ess.cw(r11, r1);
        r0 = com.fossil.ess.cv(r0, r2);
        goto L_0x0016;
    L_0x0051:
        if (r3 >= r6) goto L_0x002e;
    L_0x0053:
        r3 = -1;
        goto L_0x003f;
    L_0x0055:
        if (r3 == r6) goto L_0x0053;
    L_0x0057:
        r3 = r3 + r7;
        goto L_0x002e;
    L_0x0059:
        r3 = r0.aGX();
        r6 = r0.aGY();
        r7 = r0.aGZ();
        if (r7 <= 0) goto L_0x007a;
    L_0x0067:
        if (r3 > r6) goto L_0x0053;
    L_0x0069:
        r4 = r9.length();
        r0 = r9;
        r2 = r8;
        r5 = r12;
        r0 = m11141a(r0, r1, r2, r3, r4, r5);
        if (r0 != 0) goto L_0x003f;
    L_0x0076:
        if (r3 == r6) goto L_0x0053;
    L_0x0078:
        r3 = r3 + r7;
        goto L_0x0069;
    L_0x007a:
        if (r3 < r6) goto L_0x0053;
    L_0x007c:
        goto L_0x0069;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.etd.a(java.lang.CharSequence, java.lang.CharSequence, int, int, boolean, boolean):int");
    }

    public static final int m11139a(CharSequence charSequence, String str, int i, boolean z) {
        esl.m11128j(charSequence, "$receiver");
        esl.m11128j(str, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i);
        }
        return m11138a(charSequence, str, i, charSequence.length(), z, false, 16, null);
    }

    public static /* bridge */ /* synthetic */ boolean m11143a(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m11142a(charSequence, charSequence2, z);
    }

    public static final boolean m11142a(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        esl.m11128j(charSequence, "$receiver");
        esl.m11128j(charSequence2, FacebookRequestErrorClassification.KEY_OTHER);
        if (charSequence2 instanceof String) {
            return m11140a(charSequence, (String) charSequence2, 0, z, 2, null) >= 0;
        } else {
            return m11138a(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, null) >= 0;
        }
    }

    public static final CharSequence trim(CharSequence charSequence) {
        Object obj = null;
        esl.m11128j(charSequence, "$receiver");
        int length = charSequence.length() - 1;
        int i = 0;
        while (i <= length) {
            Object obj2;
            boolean isWhitespace = esu.isWhitespace(charSequence.charAt(obj == null ? i : length));
            if (obj == null) {
                if (isWhitespace) {
                    i++;
                    obj2 = obj;
                } else {
                    obj2 = 1;
                }
            } else if (!isWhitespace) {
                break;
            } else {
                length--;
                obj2 = obj;
            }
            obj = obj2;
        }
        return charSequence.subSequence(i, length + 1);
    }
}
