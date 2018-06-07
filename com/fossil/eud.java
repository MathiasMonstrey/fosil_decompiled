package com.fossil;

public class eud {
    public static final String OS_VERSION = mN("os.version");
    public static final String dTL = mN("line.separator");
    public static final String dUA = mN("java.vm.info");
    public static final String dUB = mN("java.vm.name");
    public static final String dUC = mN("java.vm.specification.name");
    public static final String dUD = mN("java.vm.specification.vendor");
    public static final String dUE = mN("java.vm.specification.version");
    public static final String dUF = mN("java.vm.vendor");
    public static final String dUG = mN("java.vm.version");
    public static final String dUH = mN("os.arch");
    public static final String dUI = mN("os.name");
    public static final String dUJ = mN("path.separator");
    public static final String dUK;
    public static final String dUL = mN("user.dir");
    public static final String dUM = mN("user.home");
    public static final String dUN = mN("user.language");
    public static final String dUO = mN("user.name");
    public static final String dUP = mN("user.timezone");
    public static final String dUQ = aHM();
    public static final float dUR = aHK();
    public static final int dUS = aHL();
    public static final boolean dUT = mL("1.1");
    public static final boolean dUU = mL("1.2");
    public static final boolean dUV = mL("1.3");
    public static final boolean dUW = mL("1.4");
    public static final boolean dUX = mL("1.5");
    public static final boolean dUY = mL("1.6");
    public static final boolean dUZ = mL("1.7");
    public static final String dUc = mN("awt.toolkit");
    public static final String dUd = mN("file.encoding");
    public static final String dUe = mN("file.separator");
    public static final String dUf = mN("java.awt.fonts");
    public static final String dUg = mN("java.awt.graphicsenv");
    public static final String dUh = mN("java.awt.headless");
    public static final String dUi = mN("java.awt.printerjob");
    public static final String dUj = mN("java.class.path");
    public static final String dUk = mN("java.class.version");
    public static final String dUl = mN("java.compiler");
    public static final String dUm = mN("java.endorsed.dirs");
    public static final String dUn = mN("java.ext.dirs");
    public static final String dUo = mN("java.home");
    public static final String dUp = mN("java.io.tmpdir");
    public static final String dUq = mN("java.library.path");
    public static final String dUr = mN("java.runtime.name");
    public static final String dUs = mN("java.runtime.version");
    public static final String dUt = mN("java.specification.name");
    public static final String dUu = mN("java.specification.vendor");
    public static final String dUv = mN("java.specification.version");
    public static final String dUw = mN("java.util.prefs.PreferencesFactory");
    public static final String dUx = mN("java.vendor");
    public static final String dUy = mN("java.vendor.url");
    public static final String dUz = mN("java.version");
    public static final boolean dVa = mM("AIX");
    public static final boolean dVb = mM("HP-UX");
    public static final boolean dVc = mM("Irix");
    public static final boolean dVd;
    public static final boolean dVe = mM("Mac");
    public static final boolean dVf = mM("Mac OS X");
    public static final boolean dVg = mM("OS/2");
    public static final boolean dVh = mM("Solaris");
    public static final boolean dVi = mM("SunOS");
    public static final boolean dVj;
    public static final boolean dVk = mM("Windows");
    public static final boolean dVl = bs("Windows", "5.0");
    public static final boolean dVm = bs("Windows 9", "4.0");
    public static final boolean dVn = bs("Windows 9", "4.1");
    public static final boolean dVo = bs("Windows", "4.9");
    public static final boolean dVp = mM("Windows NT");
    public static final boolean dVq = bs("Windows", "5.1");
    public static final boolean dVr = bs("Windows", "6.0");
    public static final boolean dVs = bs("Windows", "6.1");

    static {
        String mN;
        boolean z;
        boolean z2 = false;
        if (mN("user.country") == null) {
            mN = mN("user.region");
        } else {
            mN = mN("user.country");
        }
        dUK = mN;
        if (mM("Linux") || mM("LINUX")) {
            z = true;
        } else {
            z = false;
        }
        dVd = z;
        if (dVa || dVb || dVc || dVd || dVf || dVh || dVi) {
            z2 = true;
        }
        dVj = z2;
    }

    private static float aHK() {
        return m11211l(m11209Q(dUz, 3));
    }

    private static int aHL() {
        return m11212m(m11209Q(dUz, 3));
    }

    private static boolean mL(String str) {
        return bt(dUQ, str);
    }

    private static String aHM() {
        if (dUz != null) {
            for (int i = 0; i < dUz.length(); i++) {
                char charAt = dUz.charAt(i);
                if (charAt >= '0' && charAt <= '9') {
                    return dUz.substring(i);
                }
            }
        }
        return null;
    }

    private static boolean bs(String str, String str2) {
        return m11210b(dUI, OS_VERSION, str, str2);
    }

    private static boolean mM(String str) {
        return bu(dUI, str);
    }

    private static String mN(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException e) {
            System.err.println(new StringBuffer().append("Caught a SecurityException reading the system property '").append(str).append("'; the SystemUtils property value will default to null.").toString());
            return null;
        }
    }

    static boolean bt(String str, String str2) {
        if (str == null) {
            return false;
        }
        return str.startsWith(str2);
    }

    static boolean m11210b(String str, String str2, String str3, String str4) {
        if (str == null || str2 == null || !str.startsWith(str3) || !str2.startsWith(str4)) {
            return false;
        }
        return true;
    }

    static boolean bu(String str, String str2) {
        if (str == null) {
            return false;
        }
        return str.startsWith(str2);
    }

    private static int[] m11209Q(String str, int i) {
        if (str == null) {
            return eub.bWo;
        }
        String[] split = euc.split(str, "._- ");
        Object obj = new int[Math.min(i, split.length)];
        int i2 = 0;
        for (int i3 = 0; i3 < split.length && i2 < i; i3++) {
            String str2 = split[i3];
            if (str2.length() > 0) {
                try {
                    obj[i2] = Integer.parseInt(str2);
                    i2++;
                } catch (Exception e) {
                }
            }
        }
        if (obj.length <= i2) {
            return obj;
        }
        int[] iArr = new int[i2];
        System.arraycopy(obj, 0, iArr, 0, i2);
        return iArr;
    }

    private static float m11211l(int[] iArr) {
        int i = 1;
        if (iArr == null || iArr.length == 0) {
            return 0.0f;
        }
        if (iArr.length == 1) {
            return (float) iArr[0];
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(iArr[0]);
        stringBuffer.append('.');
        while (i < iArr.length) {
            stringBuffer.append(iArr[i]);
            i++;
        }
        try {
            return Float.parseFloat(stringBuffer.toString());
        } catch (Exception e) {
            return 0.0f;
        }
    }

    private static int m11212m(int[] iArr) {
        int i = 0;
        if (iArr == null) {
            return 0;
        }
        int length = iArr.length;
        if (length >= 1) {
            i = iArr[0] * 100;
        }
        if (length >= 2) {
            i += iArr[1] * 10;
        }
        if (length >= 3) {
            return i + iArr[2];
        }
        return i;
    }
}
