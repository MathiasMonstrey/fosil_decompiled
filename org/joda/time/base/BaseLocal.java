package org.joda.time.base;

public abstract class BaseLocal extends AbstractPartial {
    private static final long serialVersionUID = 276453175381783L;

    public abstract long getLocalMillis();

    protected BaseLocal() {
    }
}
