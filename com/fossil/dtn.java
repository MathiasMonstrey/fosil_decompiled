package com.fossil;

import android.content.Context;
import com.fossil.dtl.C3190b;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.HttpManager;

public class dtn {
    public static String m9732d(Context context, String str, String str2, dtq com_fossil_dtq) {
        return HttpManager.c(context, str, str2, com_fossil_dtq);
    }

    public static String m9731b(Context context, String str, String str2, String str3) throws WeiboException {
        return HttpManager.a(context, str, str2, str3);
    }

    public static String m9733e(Context context, String str, String str2, dtq com_fossil_dtq) {
        return HttpManager.a(context, str, str2, com_fossil_dtq);
    }

    public static void m9730a(Context context, String str, dtq com_fossil_dtq, String str2, dto com_fossil_dto) {
        new C3190b(context, str, com_fossil_dtq, str2, com_fossil_dto).execute(new Void[1]);
    }
}
