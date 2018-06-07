package com.fossil;

import java.io.IOException;
import org.json.JSONObject;

class ack {
    ack() {
    }

    public acj m2938d(JSONObject jSONObject) throws IOException {
        if (jSONObject == null) {
            return null;
        }
        return new acj(jSONObject.optString("url", null), jSONObject.optString("version_string", null), jSONObject.optString("display_version", null), jSONObject.optString("build_version", null), jSONObject.optString("identifier", null), jSONObject.optString("instance_identifier", null));
    }
}
