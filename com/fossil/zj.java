package com.fossil;

import android.content.Context;
import com.fossil.zi.C4128a;

public class zj {
    public zi m14151a(Context context, C4128a c4128a) {
        if ((context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 ? 1 : null) != null) {
            return new zk(context, c4128a);
        }
        return new zo();
    }
}
