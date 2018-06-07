package org.apache.commons.lang.exception;

import com.fossil.eue;
import com.fossil.euf;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NestableDelegate implements Serializable {
    static Class class$org$apache$commons$lang$exception$Nestable = null;
    public static boolean matchSubclasses = true;
    private static final long serialVersionUID = 1;
    public static boolean topDown = true;
    public static boolean trimStackFrames = true;
    private Throwable nestable = null;

    public NestableDelegate(euf com_fossil_euf) {
        if (com_fossil_euf instanceof Throwable) {
            this.nestable = (Throwable) com_fossil_euf;
            return;
        }
        throw new IllegalArgumentException("The Nestable implementation passed to the NestableDelegate(Nestable) constructor must extend java.lang.Throwable");
    }

    public String getMessage(int i) {
        Class class$;
        Throwable throwable = getThrowable(i);
        if (class$org$apache$commons$lang$exception$Nestable == null) {
            class$ = class$("com.fossil.euf");
            class$org$apache$commons$lang$exception$Nestable = class$;
        } else {
            class$ = class$org$apache$commons$lang$exception$Nestable;
        }
        if (class$.isInstance(throwable)) {
            return ((euf) throwable).getMessage(0);
        }
        return throwable.getMessage();
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public String getMessage(String str) {
        Throwable s = eue.s(this.nestable);
        String message = s == null ? null : s.getMessage();
        if (s == null || message == null) {
            return str;
        }
        if (str == null) {
            return message;
        }
        return new StringBuffer().append(str).append(": ").append(message).toString();
    }

    public String[] getMessages() {
        Throwable[] throwables = getThrowables();
        String[] strArr = new String[throwables.length];
        for (int i = 0; i < throwables.length; i++) {
            Class class$;
            if (class$org$apache$commons$lang$exception$Nestable == null) {
                class$ = class$("com.fossil.euf");
                class$org$apache$commons$lang$exception$Nestable = class$;
            } else {
                class$ = class$org$apache$commons$lang$exception$Nestable;
            }
            strArr[i] = class$.isInstance(throwables[i]) ? ((euf) throwables[i]).getMessage(0) : throwables[i].getMessage();
        }
        return strArr;
    }

    public Throwable getThrowable(int i) {
        if (i == 0) {
            return this.nestable;
        }
        return getThrowables()[i];
    }

    public int getThrowableCount() {
        return eue.u(this.nestable);
    }

    public Throwable[] getThrowables() {
        return eue.v(this.nestable);
    }

    public int indexOfThrowable(Class cls, int i) {
        if (cls == null) {
            return -1;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("The start index was out of bounds: ").append(i).toString());
        }
        Throwable[] v = eue.v(this.nestable);
        if (i >= v.length) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("The start index was out of bounds: ").append(i).append(" >= ").append(v.length).toString());
        }
        if (matchSubclasses) {
            while (i < v.length) {
                if (cls.isAssignableFrom(v[i].getClass())) {
                    return i;
                }
                i++;
            }
        } else {
            while (i < v.length) {
                if (cls.equals(v[i].getClass())) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        synchronized (printStream) {
            PrintWriter printWriter = new PrintWriter(printStream, false);
            printStackTrace(printWriter);
            printWriter.flush();
        }
    }

    public void printStackTrace(PrintWriter printWriter) {
        Throwable th = this.nestable;
        if (!eue.aHN()) {
            List arrayList = new ArrayList();
            while (th != null) {
                arrayList.add(getStackFrames(th));
                th = eue.s(th);
            }
            String str = "Caused by: ";
            if (!topDown) {
                str = "Rethrown as: ";
                Collections.reverse(arrayList);
            }
            String str2 = str;
            if (trimStackFrames) {
                trimStackFrames(arrayList);
            }
            synchronized (printWriter) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    for (String println : (String[]) it.next()) {
                        printWriter.println(println);
                    }
                    if (it.hasNext()) {
                        printWriter.print(str2);
                    }
                }
            }
        } else if (th instanceof euf) {
            ((euf) th).printPartialStackTrace(printWriter);
        } else {
            th.printStackTrace(printWriter);
        }
    }

    protected String[] getStackFrames(Throwable th) {
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter, true);
        if (th instanceof euf) {
            ((euf) th).printPartialStackTrace(printWriter);
        } else {
            th.printStackTrace(printWriter);
        }
        return eue.mO(stringWriter.getBuffer().toString());
    }

    protected void trimStackFrames(List list) {
        for (int size = list.size() - 1; size > 0; size--) {
            String[] strArr = (String[]) list.get(size);
            String[] strArr2 = (String[]) list.get(size - 1);
            List arrayList = new ArrayList(Arrays.asList(strArr));
            eue.e(arrayList, new ArrayList(Arrays.asList(strArr2)));
            int length = strArr.length - arrayList.size();
            if (length > 0) {
                arrayList.add(new StringBuffer().append("\t... ").append(length).append(" more").toString());
                list.set(size, arrayList.toArray(new String[arrayList.size()]));
            }
        }
    }
}
