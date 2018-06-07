package com.fossil;

import com.google.android.gms.common.api.Scope;
import java.util.Set;

public final class axv {
    public static String[] m4687g(Set<Scope> set) {
        awa.m4640p(set, "scopes can't be null.");
        Scope[] scopeArr = (Scope[]) set.toArray(new Scope[set.size()]);
        awa.m4640p(scopeArr, "scopes can't be null.");
        String[] strArr = new String[scopeArr.length];
        for (int i = 0; i < scopeArr.length; i++) {
            strArr[i] = scopeArr[i].KK();
        }
        return strArr;
    }
}
