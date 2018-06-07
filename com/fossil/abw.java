package com.fossil;

import com.crashlytics.android.answers.SamplingEventFilter$1;
import com.crashlytics.android.answers.SessionEvent;
import com.crashlytics.android.answers.SessionEvent.Type;
import java.util.Set;

public class abw implements abs {
    static final Set<Type> aHD = new SamplingEventFilter$1();
    final int aHC;

    public abw(int i) {
        this.aHC = i;
    }

    public boolean mo797b(SessionEvent sessionEvent) {
        if (m2900c(sessionEvent)) {
            return false;
        }
        return m2901d(sessionEvent);
    }

    boolean m2900c(SessionEvent sessionEvent) {
        return (aHD.contains(sessionEvent.aHK) && sessionEvent.aHJ.aHU == null) ? false : true;
    }

    boolean m2901d(SessionEvent sessionEvent) {
        return Math.abs(sessionEvent.aHJ.installationId.hashCode() % this.aHC) != 0;
    }
}
