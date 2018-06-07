package com.fossil;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class eul implements Iterable<euo> {
    private final List<euo> dVH = new LinkedList();
    private final Map<String, List<euo>> dVI = new HashMap();

    public void m11238a(euo com_fossil_euo) {
        if (com_fossil_euo != null) {
            String toLowerCase = com_fossil_euo.getName().toLowerCase(Locale.US);
            List list = (List) this.dVI.get(toLowerCase);
            if (list == null) {
                list = new LinkedList();
                this.dVI.put(toLowerCase, list);
            }
            list.add(com_fossil_euo);
            this.dVH.add(com_fossil_euo);
        }
    }

    public euo mQ(String str) {
        if (str == null) {
            return null;
        }
        List list = (List) this.dVI.get(str.toLowerCase(Locale.US));
        return (list == null || list.isEmpty()) ? null : (euo) list.get(0);
    }

    public Iterator<euo> iterator() {
        return Collections.unmodifiableList(this.dVH).iterator();
    }

    public String toString() {
        return this.dVH.toString();
    }
}
