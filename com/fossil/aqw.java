package com.fossil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class aqw {
    public static Map<String, String> m4257a(JSONObject jSONObject) throws JSONException {
        Map<String, String> hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            Object next = keys.next();
            if (next instanceof String) {
                String str = (String) next;
                Object obj = jSONObject.get(str);
                if (obj instanceof String) {
                    hashMap.put(str, (String) obj);
                } else {
                    throw new JSONException("JSONObject contains unsupported type for value in the map.");
                }
            }
            throw new JSONException("JSONObject contains unsupported type for key in the map.");
        }
        return hashMap;
    }
}
