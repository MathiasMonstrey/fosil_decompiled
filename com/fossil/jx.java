package com.fossil;

import java.io.PrintWriter;
import org.joda.time.DateTimeConstants;

public final class jx {
    private static final Object QJ = new Object();
    private static char[] QK = new char[24];

    private static int m11901a(int i, int i2, boolean z, int i3) {
        if (i > 99 || (z && i3 >= 3)) {
            return i2 + 3;
        }
        if (i > 9 || (z && i3 >= 2)) {
            return i2 + 2;
        }
        if (z || i > 0) {
            return i2 + 1;
        }
        return 0;
    }

    private static int m11903a(char[] cArr, int i, char c, int i2, boolean z, int i3) {
        if (!z && i <= 0) {
            return i2;
        }
        int i4;
        int i5;
        if ((!z || i3 < 3) && i <= 99) {
            i4 = i2;
            i5 = i;
        } else {
            i5 = i / 100;
            cArr[i2] = (char) (i5 + 48);
            i4 = i2 + 1;
            i5 = i - (i5 * 100);
        }
        if ((z && i3 >= 2) || i5 > 9 || i2 != i4) {
            int i6 = i5 / 10;
            cArr[i4] = (char) (i6 + 48);
            i4++;
            i5 -= i6 * 10;
        }
        cArr[i4] = (char) (i5 + 48);
        i4++;
        cArr[i4] = c;
        return i4 + 1;
    }

    private static int m11902a(long j, int i) {
        if (QK.length < i) {
            QK = new char[i];
        }
        char[] cArr = QK;
        if (j == 0) {
            int i2 = i - 1;
            while (0 < i2) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        char c;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        if (j > 0) {
            c = '+';
        } else {
            j = -j;
            c = '-';
        }
        int i8 = (int) (j % 1000);
        int floor = (int) Math.floor((double) (j / 1000));
        int i9 = 0;
        if (floor > DateTimeConstants.SECONDS_PER_DAY) {
            i9 = floor / DateTimeConstants.SECONDS_PER_DAY;
            floor -= DateTimeConstants.SECONDS_PER_DAY * i9;
        }
        if (floor > DateTimeConstants.SECONDS_PER_HOUR) {
            i3 = floor / DateTimeConstants.SECONDS_PER_HOUR;
            i4 = i3;
            i3 = floor - (i3 * DateTimeConstants.SECONDS_PER_HOUR);
        } else {
            i4 = 0;
            i3 = floor;
        }
        if (i3 > 60) {
            i5 = i3 / 60;
            i6 = i5;
            i7 = i3 - (i5 * 60);
        } else {
            i6 = 0;
            i7 = i3;
        }
        if (i != 0) {
            floor = m11901a(i9, 1, false, 0);
            floor += m11901a(i4, 1, floor > 0, 2);
            floor += m11901a(i6, 1, floor > 0, 2);
            floor += m11901a(i7, 1, floor > 0, 2);
            i5 = 0;
            i3 = (m11901a(i8, 2, true, floor > 0 ? 3 : 0) + 1) + floor;
            while (i3 < i) {
                cArr[i5] = ' ';
                i3++;
                i5++;
            }
        } else {
            i5 = 0;
        }
        cArr[i5] = c;
        i5++;
        Object obj = i != 0 ? 1 : null;
        int a = m11903a(cArr, i9, 'd', i5, false, 0);
        a = m11903a(cArr, i4, 'h', a, a != i5, obj != null ? 2 : 0);
        a = m11903a(cArr, i6, 'm', a, a != i5, obj != null ? 2 : 0);
        int a2 = m11903a(cArr, i7, 's', a, a != i5, obj != null ? 2 : 0);
        floor = (obj == null || a2 == i5) ? 0 : 3;
        i9 = m11903a(cArr, i8, 'm', a2, true, floor);
        cArr[i9] = 's';
        return i9 + 1;
    }

    public static void m11906a(long j, PrintWriter printWriter, int i) {
        synchronized (QJ) {
            printWriter.print(new String(QK, 0, m11902a(j, i)));
        }
    }

    public static void m11905a(long j, PrintWriter printWriter) {
        m11906a(j, printWriter, 0);
    }

    public static void m11904a(long j, long j2, PrintWriter printWriter) {
        if (j == 0) {
            printWriter.print("--");
        } else {
            m11906a(j - j2, printWriter, 0);
        }
    }
}
