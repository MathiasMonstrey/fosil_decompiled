package com.fossil;

import com.misfit.frameworks.common.constants.Constants;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class eue {
    private static final Object dVt = new Object();
    private static String[] dVu = new String[]{"getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable"};
    private static final Method dVv;
    private static final Method dVw;
    static Class dVx;

    static {
        Class class$;
        Method method;
        Method method2 = null;
        try {
            if (dVx == null) {
                class$ = class$("java.lang.Throwable");
                dVx = class$;
            } else {
                class$ = dVx;
            }
            method = class$.getMethod("getCause", null);
        } catch (Exception e) {
            method = null;
        }
        dVv = method;
        try {
            Class cls;
            if (dVx == null) {
                class$ = class$("java.lang.Throwable");
                dVx = class$;
                cls = class$;
            } else {
                cls = dVx;
            }
            String str = "initCause";
            Class[] clsArr = new Class[1];
            if (dVx == null) {
                class$ = class$("java.lang.Throwable");
                dVx = class$;
            } else {
                class$ = dVx;
            }
            clsArr[0] = class$;
            method2 = cls.getMethod(str, clsArr);
        } catch (Exception e2) {
        }
        dVw = method2;
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    private static String[] aJ(List list) {
        return (String[]) list.toArray(new String[list.size()]);
    }

    public static Throwable m11217s(Throwable th) {
        Throwable a;
        synchronized (dVt) {
            a = m11213a(th, dVu);
        }
        return a;
    }

    public static Throwable m11213a(Throwable th, String[] strArr) {
        if (th == null) {
            return null;
        }
        Throwable t = m11218t(th);
        if (t != null) {
            return t;
        }
        if (strArr == null) {
            synchronized (dVt) {
                strArr = dVu;
            }
        }
        for (String str : strArr) {
            if (str != null) {
                t = m11214e(th, str);
                if (t != null) {
                    break;
                }
            }
        }
        if (t == null) {
            return m11216f(th, Constants.DETAIL);
        }
        return t;
    }

    private static Throwable m11218t(Throwable th) {
        if (th instanceof euf) {
            return ((euf) th).getCause();
        }
        if (th instanceof SQLException) {
            return ((SQLException) th).getNextException();
        }
        if (th instanceof InvocationTargetException) {
            return ((InvocationTargetException) th).getTargetException();
        }
        return null;
    }

    private static Throwable m11214e(Throwable th, String str) {
        Method method;
        try {
            method = th.getClass().getMethod(str, null);
        } catch (NoSuchMethodException e) {
            method = null;
        } catch (SecurityException e2) {
            method = null;
        }
        if (method != null) {
            Class class$;
            if (dVx == null) {
                class$ = class$("java.lang.Throwable");
                dVx = class$;
            } else {
                class$ = dVx;
            }
            if (class$.isAssignableFrom(method.getReturnType())) {
                try {
                    return (Throwable) method.invoke(th, eub.dTQ);
                } catch (IllegalAccessException e3) {
                } catch (IllegalArgumentException e4) {
                } catch (InvocationTargetException e5) {
                }
            }
        }
        return null;
    }

    private static Throwable m11216f(Throwable th, String str) {
        Field field;
        try {
            field = th.getClass().getField(str);
        } catch (NoSuchFieldException e) {
            field = null;
        } catch (SecurityException e2) {
            field = null;
        }
        if (field != null) {
            Class class$;
            if (dVx == null) {
                class$ = class$("java.lang.Throwable");
                dVx = class$;
            } else {
                class$ = dVx;
            }
            if (class$.isAssignableFrom(field.getType())) {
                try {
                    return (Throwable) field.get(th);
                } catch (IllegalAccessException e3) {
                } catch (IllegalArgumentException e4) {
                }
            }
        }
        return null;
    }

    public static boolean aHN() {
        return dVv != null;
    }

    public static int m11219u(Throwable th) {
        return m11221w(th).size();
    }

    public static Throwable[] m11220v(Throwable th) {
        List w = m11221w(th);
        return (Throwable[]) w.toArray(new Throwable[w.size()]);
    }

    public static List m11221w(Throwable th) {
        List arrayList = new ArrayList();
        while (th != null && !arrayList.contains(th)) {
            arrayList.add(th);
            th = m11217s(th);
        }
        return arrayList;
    }

    public static void m11215e(List list, List list2) {
        if (list == null || list2 == null) {
            throw new IllegalArgumentException("The List must not be null");
        }
        int size = list2.size() - 1;
        for (int size2 = list.size() - 1; size2 >= 0 && size >= 0; size2--) {
            if (((String) list.get(size2)).equals((String) list2.get(size))) {
                list.remove(size2);
            }
            size--;
        }
    }

    public static String[] mO(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, eud.dTL);
        List arrayList = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return aJ(arrayList);
    }
}
