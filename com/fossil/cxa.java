package com.fossil;

import com.fossil.cwx.C2456b;
import com.misfit.frameworks.buttonservice.model.Alarm;
import java.util.List;

public class cxa {
    private final List<Alarm> cIW;
    private final Alarm cJI;
    private final C2456b cJV;
    private final String mDeviceId;

    public cxa(C2456b c2456b, String str, List<Alarm> list, Alarm alarm) {
        this.cJV = c2456b;
        this.mDeviceId = str;
        this.cIW = list;
        this.cJI = alarm;
    }

    C2456b ajo() {
        return this.cJV;
    }

    String aiZ() {
        return this.mDeviceId;
    }

    List<Alarm> ajp() {
        return this.cIW;
    }

    Alarm ajq() {
        return this.cJI;
    }
}
