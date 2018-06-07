package com.fossil;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import android.util.SparseArray;

public abstract class ha extends BroadcastReceiver {
    private static final SparseArray<WakeLock> Ni = new SparseArray();
    private static int Nj = 1;

    public static ComponentName m4806a(Context context, Intent intent) {
        synchronized (Ni) {
            int i = Nj;
            Nj++;
            if (Nj <= 0) {
                Nj = 1;
            }
            intent.putExtra("android.support.content.wakelockid", i);
            ComponentName startService = context.startService(intent);
            if (startService == null) {
                return null;
            }
            WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:" + startService.flattenToShortString());
            newWakeLock.setReferenceCounted(false);
            newWakeLock.acquire(60000);
            Ni.put(i, newWakeLock);
            return startService;
        }
    }

    public static boolean m4807c(Intent intent) {
        int intExtra = intent.getIntExtra("android.support.content.wakelockid", 0);
        if (intExtra == 0) {
            return false;
        }
        synchronized (Ni) {
            WakeLock wakeLock = (WakeLock) Ni.get(intExtra);
            if (wakeLock != null) {
                wakeLock.release();
                Ni.remove(intExtra);
                return true;
            }
            Log.w("WakefulBroadcastReceiver", "No active wake lock id #" + intExtra);
            return true;
        }
    }
}
