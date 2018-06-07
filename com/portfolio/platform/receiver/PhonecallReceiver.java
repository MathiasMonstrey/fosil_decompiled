package com.portfolio.platform.receiver;

import android.content.Context;
import com.fossil.cnj;
import com.fossil.cpo;
import com.fossil.dri;
import com.fossil.euj;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.NotificationSource;
import com.portfolio.platform.data.model.NotificationInfo;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class PhonecallReceiver extends cpo {
    private static final String TAG = PhonecallReceiver.class.getSimpleName();
    private static final HashMap<String, Long> cBH = new HashMap();

    protected void m15638a(Context context, String str, Date date) {
        MFLogger.d(TAG, "Phone Receiver : onIncomingCallStarted : " + str);
        String ju = dri.ju(str);
        boolean a = dri.a(TAG, ju, true, hv(ju));
        synchronized (cBH) {
            cBH.put(ju, Long.valueOf(System.currentTimeMillis()));
        }
        if (!a) {
            cnj.abR().a(new NotificationInfo(NotificationSource.CALL, ju, "", ""));
            aeT();
        }
    }

    protected void m15640b(Context context, String str, Date date) {
    }

    protected void m15639a(Context context, String str, Date date, Date date2) {
    }

    protected void m15641b(Context context, String str, Date date, Date date2) {
    }

    protected void m15642c(Context context, String str, Date date) {
    }

    private boolean hv(String str) {
        boolean z;
        synchronized (cBH) {
            MFLogger.d(TAG, "isRepeatedCall() - " + str);
            Long l = (Long) cBH.get(str);
            if (l != null) {
                MFLogger.d(TAG, "We have an old call with the same hash");
                if (System.currentTimeMillis() - l.longValue() > 900000) {
                    MFLogger.d(TAG, "We are older than 900000 milliseconds.");
                } else {
                    MFLogger.d(TAG, "Repeated call in " + euj.bm(Math.abs(900000 - (System.currentTimeMillis() - l.longValue()))) + ", call: " + str);
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }

    private void aeT() {
        synchronized (cBH) {
            long currentTimeMillis = System.currentTimeMillis();
            MFLogger.d(TAG, "Clean past call. Size = " + cBH.size());
            List<String> linkedList = new LinkedList();
            for (Entry entry : cBH.entrySet()) {
                String str = (String) entry.getKey();
                if (currentTimeMillis - ((Long) entry.getValue()).longValue() > 900000) {
                    MFLogger.d(TAG, "Adding key to remove - key = " + str);
                    linkedList.add(str);
                }
            }
            for (String str2 : linkedList) {
                MFLogger.d(TAG, "Dumping old call");
                cBH.remove(str2);
            }
        }
    }
}
