package com.jawbone.upplatformsdk.endpointModels.body;

import com.fossil.cga;

public class BodyDetails {
    @cga("tz")
    String timeZone;

    public String getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(String str) {
        this.timeZone = str;
    }

    public String toString() {
        return "BodyDetails {\n\ttimeZone='" + this.timeZone + '\'' + "\n}\n";
    }
}
