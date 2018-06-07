package com.fossil;

import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;

public class dzk {
    public String aWB;
    public JSONArray dCa;
    public JSONObject dCb = null;

    public dzk(String str, String[] strArr, Properties properties) {
        this.aWB = str;
        if (properties != null) {
            this.dCb = new JSONObject(properties);
        } else if (strArr != null) {
            this.dCa = new JSONArray();
            for (Object put : strArr) {
                this.dCa.put(put);
            }
        } else {
            this.dCb = new JSONObject();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dzk)) {
            return false;
        }
        return toString().equals(((dzk) obj).toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append(this.aWB).append(",");
        if (this.dCa != null) {
            stringBuilder.append(this.dCa.toString());
        }
        if (this.dCb != null) {
            stringBuilder.append(this.dCb.toString());
        }
        return stringBuilder.toString();
    }
}
