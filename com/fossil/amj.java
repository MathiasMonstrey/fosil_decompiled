package com.fossil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class amj {
    private static final amj aVI = new amj(1, 0, new Object[4]);
    private final Object[] _hashArea;
    private final int _hashMask;
    private final int _spillCount;

    private amj(int i, int i2, Object[] objArr) {
        this._hashMask = i;
        this._spillCount = i2;
        this._hashArea = objArr;
    }

    public static <T> amj m3877n(Map<String, T> map) {
        if (map.isEmpty()) {
            return aVI;
        }
        int gQ = gQ(map.size());
        int i = gQ - 1;
        Object[] objArr = new Object[(((gQ >> 1) + gQ) * 2)];
        int i2 = 0;
        Object[] objArr2 = objArr;
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            int hashCode = str.hashCode() & i;
            int i3 = hashCode + hashCode;
            if (objArr2[i3] != null) {
                i3 = ((hashCode >> 1) + gQ) << 1;
                if (objArr2[i3] != null) {
                    i3 = (((gQ >> 1) + gQ) << 1) + i2;
                    i2 += 2;
                    if (i3 >= objArr2.length) {
                        objArr2 = Arrays.copyOf(objArr2, objArr2.length + 4);
                    }
                }
            }
            objArr2[i3] = str;
            objArr2[i3 + 1] = entry.getValue();
        }
        return new amj(i, i2, objArr2);
    }

    private static final int gQ(int i) {
        if (i <= 5) {
            return 8;
        }
        if (i <= 12) {
            return 16;
        }
        int i2 = 32;
        while (i2 < i + (i >> 2)) {
            i2 += i2;
        }
        return i2;
    }

    public Object cb(String str) {
        int hashCode = str.hashCode() & this._hashMask;
        int i = hashCode << 1;
        String str2 = this._hashArea[i];
        if (str2 == str || str.equals(str2)) {
            return this._hashArea[i + 1];
        }
        return m3876b(str, hashCode, str2);
    }

    private final Object m3876b(String str, int i, Object obj) {
        if (obj == null) {
            return null;
        }
        int i2 = this._hashMask + 1;
        int i3 = ((i >> 1) + i2) << 1;
        Object obj2 = this._hashArea[i3];
        if (str.equals(obj2)) {
            return this._hashArea[i3 + 1];
        }
        if (obj2 == null) {
            return null;
        }
        i2 = (i2 + (i2 >> 1)) << 1;
        i3 = this._spillCount + i2;
        while (i2 < i3) {
            String str2 = this._hashArea[i2];
            if (str2 == str || str.equals(str2)) {
                return this._hashArea[i2 + 1];
            }
            i2 += 2;
        }
        return null;
    }

    public List<String> Hj() {
        int length = this._hashArea.length;
        List<String> arrayList = new ArrayList(length >> 2);
        for (int i = 0; i < length; i += 2) {
            Object obj = this._hashArea[i];
            if (obj != null) {
                arrayList.add((String) obj);
            }
        }
        return arrayList;
    }
}
