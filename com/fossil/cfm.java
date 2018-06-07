package com.fossil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class cfm extends cfp implements Iterable<cfp> {
    private final List<cfp> bRi = new ArrayList();

    public void m6210c(cfp com_fossil_cfp) {
        if (com_fossil_cfp == null) {
            com_fossil_cfp = cfq.bRj;
        }
        this.bRi.add(com_fossil_cfp);
    }

    public Iterator<cfp> iterator() {
        return this.bRi.iterator();
    }

    public Number Wv() {
        if (this.bRi.size() == 1) {
            return ((cfp) this.bRi.get(0)).Wv();
        }
        throw new IllegalStateException();
    }

    public String getAsString() {
        if (this.bRi.size() == 1) {
            return ((cfp) this.bRi.get(0)).getAsString();
        }
        throw new IllegalStateException();
    }

    public double getAsDouble() {
        if (this.bRi.size() == 1) {
            return ((cfp) this.bRi.get(0)).getAsDouble();
        }
        throw new IllegalStateException();
    }

    public long getAsLong() {
        if (this.bRi.size() == 1) {
            return ((cfp) this.bRi.get(0)).getAsLong();
        }
        throw new IllegalStateException();
    }

    public int getAsInt() {
        if (this.bRi.size() == 1) {
            return ((cfp) this.bRi.get(0)).getAsInt();
        }
        throw new IllegalStateException();
    }

    public boolean getAsBoolean() {
        if (this.bRi.size() == 1) {
            return ((cfp) this.bRi.get(0)).getAsBoolean();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof cfm) && ((cfm) obj).bRi.equals(this.bRi));
    }

    public int hashCode() {
        return this.bRi.hashCode();
    }
}
