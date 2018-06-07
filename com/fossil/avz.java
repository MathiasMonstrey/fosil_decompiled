package com.fossil;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.ArrayList;
import java.util.List;

public final class avz {
    private final List<String> bhL;
    private final Object bhM;

    private avz(Object obj) {
        this.bhM = awa.bO(obj);
        this.bhL = new ArrayList();
    }

    public final avz m4608b(String str, Object obj) {
        List list = this.bhL;
        String str2 = (String) awa.bO(str);
        String valueOf = String.valueOf(String.valueOf(obj));
        list.add(new StringBuilder((String.valueOf(str2).length() + 1) + String.valueOf(valueOf).length()).append(str2).append(SimpleComparison.EQUAL_TO_OPERATION).append(valueOf).toString());
        return this;
    }

    public final String toString() {
        StringBuilder append = new StringBuilder(100).append(this.bhM.getClass().getSimpleName()).append('{');
        int size = this.bhL.size();
        for (int i = 0; i < size; i++) {
            append.append((String) this.bhL.get(i));
            if (i < size - 1) {
                append.append(", ");
            }
        }
        return append.append('}').toString();
    }
}
