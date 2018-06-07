package com.fossil;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import com.fossil.gd.C3617a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@TargetApi(9)
public class fu {
    private static Method LT;

    public static abstract class C3585a {

        public interface C3583a {
        }

        public abstract boolean getAllowGeneratedReplies();

        public abstract Bundle getExtras();

        public abstract int getIcon();

        public abstract CharSequence getTitle();

        public abstract PendingIntent iB();

        public abstract C3617a[] iD();
    }

    public static Notification m11488a(Notification notification, Context context, CharSequence charSequence, CharSequence charSequence2, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        Throwable e;
        if (LT == null) {
            try {
                LT = Notification.class.getMethod("setLatestEventInfo", new Class[]{Context.class, CharSequence.class, CharSequence.class, PendingIntent.class});
            } catch (Throwable e2) {
                throw new RuntimeException(e2);
            }
        }
        try {
            LT.invoke(notification, new Object[]{context, charSequence, charSequence2, pendingIntent});
            notification.fullScreenIntent = pendingIntent2;
            return notification;
        } catch (IllegalAccessException e3) {
            e2 = e3;
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e4) {
            e2 = e4;
            throw new RuntimeException(e2);
        }
    }
}
