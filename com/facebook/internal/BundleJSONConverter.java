package com.facebook.internal;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BundleJSONConverter {
    private static final Map<Class<?>, Setter> SETTERS = new HashMap();

    public interface Setter {
        void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException;

        void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException;
    }

    static class C13521 implements Setter {
        C13521() {
        }

        public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
        }

        public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
            jSONObject.put(str, obj);
        }
    }

    static class C13532 implements Setter {
        C13532() {
        }

        public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
            bundle.putInt(str, ((Integer) obj).intValue());
        }

        public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
            jSONObject.put(str, obj);
        }
    }

    static class C13543 implements Setter {
        C13543() {
        }

        public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
            bundle.putLong(str, ((Long) obj).longValue());
        }

        public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
            jSONObject.put(str, obj);
        }
    }

    static class C13554 implements Setter {
        C13554() {
        }

        public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        }

        public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
            jSONObject.put(str, obj);
        }
    }

    static class C13565 implements Setter {
        C13565() {
        }

        public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
            bundle.putString(str, (String) obj);
        }

        public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
            jSONObject.put(str, obj);
        }
    }

    static class C13576 implements Setter {
        C13576() {
        }

        public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
            throw new IllegalArgumentException("Unexpected type from JSON");
        }

        public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
            JSONArray jSONArray = new JSONArray();
            for (Object put : (String[]) obj) {
                jSONArray.put(put);
            }
            jSONObject.put(str, jSONArray);
        }
    }

    static class C13587 implements Setter {
        C13587() {
        }

        public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
            JSONArray jSONArray = (JSONArray) obj;
            ArrayList arrayList = new ArrayList();
            if (jSONArray.length() == 0) {
                bundle.putStringArrayList(str, arrayList);
                return;
            }
            int i = 0;
            while (i < jSONArray.length()) {
                Object obj2 = jSONArray.get(i);
                if (obj2 instanceof String) {
                    arrayList.add((String) obj2);
                    i++;
                } else {
                    throw new IllegalArgumentException("Unexpected type in an array: " + obj2.getClass());
                }
            }
            bundle.putStringArrayList(str, arrayList);
        }

        public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
            throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
        }
    }

    static {
        SETTERS.put(Boolean.class, new C13521());
        SETTERS.put(Integer.class, new C13532());
        SETTERS.put(Long.class, new C13543());
        SETTERS.put(Double.class, new C13554());
        SETTERS.put(String.class, new C13565());
        SETTERS.put(String[].class, new C13576());
        SETTERS.put(JSONArray.class, new C13587());
    }

    public static JSONObject convertToJSON(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null) {
                if (obj instanceof List) {
                    JSONArray jSONArray = new JSONArray();
                    for (String put : (List) obj) {
                        jSONArray.put(put);
                    }
                    jSONObject.put(str, jSONArray);
                } else if (obj instanceof Bundle) {
                    jSONObject.put(str, convertToJSON((Bundle) obj));
                } else {
                    Setter setter = (Setter) SETTERS.get(obj.getClass());
                    if (setter == null) {
                        throw new IllegalArgumentException("Unsupported type: " + obj.getClass());
                    }
                    setter.setOnJSON(jSONObject, str, obj);
                }
            }
        }
        return jSONObject;
    }

    public static Bundle convertToBundle(JSONObject jSONObject) throws JSONException {
        Bundle bundle = new Bundle();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object obj = jSONObject.get(str);
            if (!(obj == null || obj == JSONObject.NULL)) {
                if (obj instanceof JSONObject) {
                    bundle.putBundle(str, convertToBundle((JSONObject) obj));
                } else {
                    Setter setter = (Setter) SETTERS.get(obj.getClass());
                    if (setter == null) {
                        throw new IllegalArgumentException("Unsupported type: " + obj.getClass());
                    }
                    setter.setOnBundle(bundle, str, obj);
                }
            }
        }
        return bundle;
    }
}
