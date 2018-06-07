package com.fossil;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Set;

public class dtq {
    private String dqh;
    private LinkedHashMap<String, Object> dsy = new LinkedHashMap();

    public dtq(String str) {
        this.dqh = str;
    }

    public String awy() {
        return this.dqh;
    }

    public void put(String str, String str2) {
        this.dsy.put(str, str2);
    }

    public Object get(String str) {
        return this.dsy.get(str);
    }

    public void remove(String str) {
        if (this.dsy.containsKey(str)) {
            this.dsy.remove(str);
            this.dsy.remove(this.dsy.get(str));
        }
    }

    public Set<String> keySet() {
        return this.dsy.keySet();
    }

    public String axw() {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (String str : this.dsy.keySet()) {
            Object obj2;
            if (obj != null) {
                obj2 = null;
            } else {
                stringBuilder.append("&");
                obj2 = obj;
            }
            obj = this.dsy.get(str);
            if (obj instanceof String) {
                String str2 = (String) obj;
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        stringBuilder.append(URLEncoder.encode(str, "UTF-8") + SimpleComparison.EQUAL_TO_OPERATION + URLEncoder.encode(str2, "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                duj.m9771i("encodeUrl", stringBuilder.toString());
            }
            obj = obj2;
        }
        return stringBuilder.toString();
    }

    public boolean axx() {
        for (String str : this.dsy.keySet()) {
            Object obj = this.dsy.get(str);
            if (!(obj instanceof ByteArrayOutputStream)) {
                if (obj instanceof Bitmap) {
                }
            }
            return true;
        }
        return false;
    }
}
