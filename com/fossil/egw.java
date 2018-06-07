package com.fossil;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.fossil.ecp.C2701c;
import com.fossil.ecp.C2703b;
import com.ua.sdk.UaException;
import java.util.List;

public class egw extends Handler {
    private static final egw dGY = new egw();

    static class C3389a {
        final Object dGZ;
        final UaException dHa;
        final Object value;

        private C3389a(Object obj, Object obj2, UaException uaException) {
            this.dGZ = obj;
            this.value = obj2;
            this.dHa = uaException;
        }
    }

    private egw() {
        super(Looper.getMainLooper());
    }

    public void handleMessage(Message message) {
        try {
            eiy.aDw();
            C3389a c3389a;
            switch (message.what) {
                case 0:
                    c3389a = (C3389a) message.obj;
                    ((ebz) c3389a.dGZ).m10468a((ecm) c3389a.value, c3389a.dHa);
                    return;
                case 1:
                    c3389a = (C3389a) message.obj;
                    ((ecf) c3389a.dGZ).m10471b((ecm) c3389a.value, c3389a.dHa);
                    return;
                case 2:
                    c3389a = (C3389a) message.obj;
                    ((ecn) c3389a.dGZ).m10476c((ecm) c3389a.value, c3389a.dHa);
                    return;
                case 3:
                    c3389a = (C3389a) message.obj;
                    ((eca) c3389a.dGZ).m10470a((ecj) c3389a.value, c3389a.dHa);
                    return;
                case 4:
                    c3389a = (C3389a) message.obj;
                    ((C2703b) c3389a.dGZ).mo2339a((ekn) c3389a.value, c3389a.dHa);
                    return;
                case 5:
                    c3389a = (C3389a) message.obj;
                    ((C2701c) c3389a.dGZ).mo2338a(c3389a.dHa);
                    return;
                case 6:
                    c3389a = (C3389a) message.obj;
                    ((ecl) c3389a.dGZ).m10475b(c3389a.dHa);
                    return;
                case 8:
                    c3389a = (C3389a) message.obj;
                    ((ecr) c3389a.dGZ).aS(((Long) c3389a.value).longValue());
                    return;
                case 9:
                    c3389a = (C3389a) message.obj;
                    ((ecr) c3389a.dGZ).m10493d((ecm) c3389a.value, c3389a.dHa);
                    return;
                case 10:
                    c3389a = (C3389a) message.obj;
                    ((eci) c3389a.dGZ).m10474a((List) c3389a.value, c3389a.dHa);
                    return;
                default:
                    return;
            }
        } catch (Throwable th) {
            ecq.m10489d("Error handling callback.", th);
        }
        ecq.m10489d("Error handling callback.", th);
    }

    public static void m10740a(ekn com_fossil_ekn, UaException uaException, C2703b c2703b) {
        if (c2703b != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                c2703b.mo2339a(com_fossil_ekn, uaException);
                return;
            }
            dGY.sendMessage(dGY.obtainMessage(4, new C3389a(c2703b, com_fossil_ekn, uaException)));
        }
    }

    public static void m10741a(UaException uaException, C2701c c2701c) {
        if (c2701c != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                c2701c.mo2338a(uaException);
                return;
            }
            dGY.sendMessage(dGY.obtainMessage(5, new C3389a(c2701c, null, uaException)));
        }
    }
}
