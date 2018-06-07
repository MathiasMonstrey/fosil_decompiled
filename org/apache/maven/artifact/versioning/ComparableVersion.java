package org.apache.maven.artifact.versioning;

import com.facebook.appevents.AppEventsConstants;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Properties;
import java.util.Stack;

public class ComparableVersion implements Comparable<ComparableVersion> {
    private String dVU;
    private ListItem dVV;
    private String value;

    interface C5097b {
        int compareTo(C5097b c5097b);

        int getType();

        boolean isNull();
    }

    static class ListItem extends ArrayList<C5097b> implements C5097b {
        private ListItem() {
        }

        public int getType() {
            return 2;
        }

        public boolean isNull() {
            return size() == 0;
        }

        void normalize() {
            ListIterator listIterator = listIterator(size());
            while (listIterator.hasPrevious() && ((C5097b) listIterator.previous()).isNull()) {
                listIterator.remove();
            }
        }

        public int compareTo(C5097b c5097b) {
            if (c5097b != null) {
                switch (c5097b.getType()) {
                    case 0:
                        return -1;
                    case 1:
                        return 1;
                    case 2:
                        int compareTo;
                        Iterator it = iterator();
                        Iterator it2 = ((ListItem) c5097b).iterator();
                        do {
                            if (!it.hasNext() && !it2.hasNext()) {
                                return 0;
                            }
                            C5097b c5097b2;
                            C5097b c5097b3 = it.hasNext() ? (C5097b) it.next() : null;
                            if (it2.hasNext()) {
                                c5097b2 = (C5097b) it2.next();
                            } else {
                                c5097b2 = null;
                            }
                            if (c5097b3 == null) {
                                compareTo = c5097b2.compareTo(c5097b3) * -1;
                                continue;
                            } else {
                                compareTo = c5097b3.compareTo(c5097b2);
                                continue;
                            }
                        } while (compareTo == 0);
                        return compareTo;
                    default:
                        throw new RuntimeException("invalid item: " + c5097b.getClass());
                }
            } else if (size() == 0) {
                return 0;
            } else {
                return ((C5097b) get(0)).compareTo(null);
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("(");
            Iterator it = iterator();
            while (it.hasNext()) {
                stringBuilder.append(it.next());
                if (it.hasNext()) {
                    stringBuilder.append(',');
                }
            }
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }

    static class C5098a implements C5097b {
        private static final BigInteger dVW = new BigInteger(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        public static final C5098a dVY = new C5098a();
        private final BigInteger dVX;

        private C5098a() {
            this.dVX = dVW;
        }

        public C5098a(String str) {
            this.dVX = new BigInteger(str);
        }

        public int getType() {
            return 0;
        }

        public boolean isNull() {
            return dVW.equals(this.dVX);
        }

        public int compareTo(C5097b c5097b) {
            if (c5097b != null) {
                switch (c5097b.getType()) {
                    case 0:
                        return this.dVX.compareTo(((C5098a) c5097b).dVX);
                    case 1:
                    case 2:
                        return 1;
                    default:
                        throw new RuntimeException("invalid item: " + c5097b.getClass());
                }
            } else if (dVW.equals(this.dVX)) {
                return 0;
            } else {
                return 1;
            }
        }

        public String toString() {
            return this.dVX.toString();
        }
    }

    static class C5099c implements C5097b {
        private static final String[] dVZ = new String[]{"alpha", "beta", "milestone", "rc", "snapshot", "", "sp"};
        private static final List<String> dWa = Arrays.asList(dVZ);
        private static final Properties dWb = new Properties();
        private static final String dWc = String.valueOf(dWa.indexOf(""));
        private String value;

        static {
            dWb.put("ga", "");
            dWb.put("final", "");
            dWb.put("cr", "rc");
        }

        public C5099c(String str, boolean z) {
            if (z && str.length() == 1) {
                switch (str.charAt(0)) {
                    case 'a':
                        str = "alpha";
                        break;
                    case 'b':
                        str = "beta";
                        break;
                    case 'm':
                        str = "milestone";
                        break;
                }
            }
            this.value = dWb.getProperty(str, str);
        }

        public int getType() {
            return 1;
        }

        public boolean isNull() {
            return C5099c.mS(this.value).compareTo(dWc) == 0;
        }

        public static String mS(String str) {
            int indexOf = dWa.indexOf(str);
            return indexOf == -1 ? dWa.size() + "-" + str : String.valueOf(indexOf);
        }

        public int compareTo(C5097b c5097b) {
            if (c5097b == null) {
                return C5099c.mS(this.value).compareTo(dWc);
            }
            switch (c5097b.getType()) {
                case 0:
                case 2:
                    return -1;
                case 1:
                    return C5099c.mS(this.value).compareTo(C5099c.mS(((C5099c) c5097b).value));
                default:
                    throw new RuntimeException("invalid item: " + c5097b.getClass());
            }
        }

        public String toString() {
            return this.value;
        }
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m16332a((ComparableVersion) obj);
    }

    public ComparableVersion(String str) {
        mR(str);
    }

    public final void mR(String str) {
        this.value = str;
        this.dVV = new ListItem();
        String toLowerCase = str.toLowerCase(Locale.ENGLISH);
        ListItem listItem = this.dVV;
        Stack stack = new Stack();
        stack.push(listItem);
        int i = 0;
        boolean z = false;
        ListItem listItem2 = listItem;
        int i2 = 0;
        while (i2 < toLowerCase.length()) {
            char charAt = toLowerCase.charAt(i2);
            if (charAt == '.') {
                if (i2 == i) {
                    listItem2.add(C5098a.dVY);
                } else {
                    listItem2.add(m16331c(z, toLowerCase.substring(i, i2)));
                }
                i = i2 + 1;
            } else if (charAt == '-') {
                if (i2 == i) {
                    listItem2.add(C5098a.dVY);
                } else {
                    listItem2.add(m16331c(z, toLowerCase.substring(i, i2)));
                }
                i = i2 + 1;
                if (z) {
                    listItem2.normalize();
                    if (i2 + 1 < toLowerCase.length() && Character.isDigit(toLowerCase.charAt(i2 + 1))) {
                        ListItem listItem3 = new ListItem();
                        listItem2.add(listItem3);
                        stack.push(listItem3);
                        listItem2 = listItem3;
                    }
                }
            } else if (Character.isDigit(charAt)) {
                if (!z && i2 > i) {
                    listItem2.add(new C5099c(toLowerCase.substring(i, i2), true));
                    i = i2;
                }
                z = true;
            } else {
                if (z && i2 > i) {
                    listItem2.add(m16331c(true, toLowerCase.substring(i, i2)));
                    i = i2;
                }
                z = false;
            }
            i2++;
        }
        if (toLowerCase.length() > i) {
            listItem2.add(m16331c(z, toLowerCase.substring(i)));
        }
        while (!stack.isEmpty()) {
            ((ListItem) stack.pop()).normalize();
        }
        this.dVU = this.dVV.toString();
    }

    private static C5097b m16331c(boolean z, String str) {
        return z ? new C5098a(str) : new C5099c(str, false);
    }

    public int m16332a(ComparableVersion comparableVersion) {
        return this.dVV.compareTo(comparableVersion.dVV);
    }

    public String toString() {
        return this.value;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ComparableVersion) && this.dVU.equals(((ComparableVersion) obj).dVU);
    }

    public int hashCode() {
        return this.dVU.hashCode();
    }
}
