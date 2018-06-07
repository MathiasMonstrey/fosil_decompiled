package com.fossil;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class aqq {
    private Map<String, List<C1543a>> aWW = new HashMap();
    private Map<String, Object> aZV = new HashMap();

    public interface C1543a {
        void mo761a(String str, Object obj);
    }

    public final synchronized void m4242a(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            Object obj2 = this.aZV.get(str);
            if (obj == obj2 || (obj != null && obj.equals(obj2))) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 == null) {
                if (obj == null) {
                    this.aZV.remove(str);
                } else {
                    this.aZV.put(str, obj);
                }
                if (this.aWW.get(str) != null) {
                    for (C1543a a : (List) this.aWW.get(str)) {
                        a.mo761a(str, obj);
                    }
                }
            }
        }
    }

    public final synchronized Object cw(String str) {
        return this.aZV.get(str);
    }

    public final synchronized void m4241a(String str, C1543a c1543a) {
        if (!(TextUtils.isEmpty(str) || c1543a == null)) {
            List list = (List) this.aWW.get(str);
            if (list == null) {
                list = new LinkedList();
            }
            list.add(c1543a);
            this.aWW.put(str, list);
        }
    }

    public final synchronized boolean m4243b(String str, C1543a c1543a) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            z = false;
        } else if (c1543a == null) {
            z = false;
        } else {
            List list = (List) this.aWW.get(str);
            z = list == null ? false : list.remove(c1543a);
        }
        return z;
    }
}
