package com.fossil;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

public class ccl {
    private final String separator;

    public static ccl fc(String str) {
        return new ccl(str);
    }

    public static ccl m5972c(char c) {
        return new ccl(String.valueOf(c));
    }

    private ccl(String str) {
        this.separator = (String) cco.ce(str);
    }

    private ccl(ccl com_fossil_ccl) {
        this.separator = com_fossil_ccl.separator;
    }

    public <A extends Appendable> A m5973a(A a, Iterator<?> it) throws IOException {
        cco.ce(a);
        if (it.hasNext()) {
            a.append(ca(it.next()));
            while (it.hasNext()) {
                a.append(this.separator);
                a.append(ca(it.next()));
            }
        }
        return a;
    }

    public final StringBuilder m5975a(StringBuilder stringBuilder, Iterator<?> it) {
        try {
            m5973a((Appendable) stringBuilder, (Iterator) it);
            return stringBuilder;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public final String m5976b(Iterable<?> iterable) {
        return m5974a(iterable.iterator());
    }

    public final String m5974a(Iterator<?> it) {
        return m5975a(new StringBuilder(), (Iterator) it).toString();
    }

    public final String m5977d(Object[] objArr) {
        return m5976b(Arrays.asList(objArr));
    }

    public ccl fd(final String str) {
        cco.ce(str);
        return new ccl(this, this) {
            final /* synthetic */ ccl bLC;

            CharSequence ca(Object obj) {
                return obj == null ? str : this.bLC.ca(obj);
            }

            public ccl fd(String str) {
                throw new UnsupportedOperationException("already specified useForNull");
            }
        };
    }

    CharSequence ca(Object obj) {
        cco.ce(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }
}
