package com.misfit.ble.shine.controller;

import com.misfit.ble.obfuscated.C4462b;
import com.misfit.ble.shine.ShineConfiguration;
import org.json.JSONObject;

public abstract class ConfigurationSession {
    public static final int DEFAULT_PARTIAL_SECOND = -1;
    public static final long DEFAULT_TIMESTAMP = -1;
    public static final short DEFAULT_TIME_ZONE_OFFSET = (short) 1024;
    public int mPartialSecond = -1;
    public ShineConfiguration mShineConfiguration;
    public short mTimeZoneOffset = (short) 1024;
    public long mTimestamp = -1;

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.mTimestamp != -1) {
                jSONObject.put("timestamp", this.mTimestamp);
            }
            if (this.mPartialSecond != -1) {
                jSONObject.put("partialSecond", this.mPartialSecond);
            }
            if (this.mTimeZoneOffset != (short) 1024) {
                jSONObject.put("timezoneOffset", this.mTimeZoneOffset);
            }
            jSONObject.put("shineConfiguration", this.mShineConfiguration.toJSON());
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }
}
