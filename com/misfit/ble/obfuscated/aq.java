package com.misfit.ble.obfuscated;

import android.os.Bundle;
import android.os.Parcelable;
import com.misfit.ble.setting.uapp.UAppNotification;
import com.misfit.ble.shine.ShineProfile.StreamingCallback;
import com.misfit.ble.shine.ShineProfile.StreamingCallback.StreamingEventType;
import com.misfit.ble.util.LogUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashMap;

public class aq {
    private static final String TAG = LogUtils.m15475b(aq.class);
    private static byte gF = (byte) -1;
    private static HashMap<String, Short> gG = new HashMap();
    private static HashMap<String, Short> gH = new HashMap();
    private static HashMap<String, UAppNotification> gI = new HashMap();

    public static class C4454a {
        public StreamingEventType gJ;
        public Bundle gK;

        public C4454a(StreamingEventType streamingEventType, Bundle bundle) {
            this.gJ = streamingEventType;
            this.gK = bundle;
        }
    }

    public static boolean m14765b(String str, byte[] bArr) {
        if ("3dda0006-957f-7d4a-34a6-74696673696d".equalsIgnoreCase(str) && ((byte) (bArr[0] & 64)) == (byte) 0) {
            return true;
        }
        return false;
    }

    public static C4454a m14764a(String str, short s, byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            LogUtils.m15479l(TAG, "Invalid packet.");
            return null;
        }
        if (!gG.containsKey(str)) {
            gG.put(str, Short.valueOf((short) -1));
        }
        if (!gH.containsKey(str)) {
            gH.put(str, Short.valueOf((short) -1));
        }
        if (!gI.containsKey(str)) {
            gI.put(str, null);
        }
        byte b = (byte) (bArr[0] & 63);
        if (b == gF) {
            LogUtils.m15476d(TAG, "Previous sequence number: " + b + ", skip.");
            return null;
        }
        byte b2 = (byte) ((gF + 1) & 63);
        if (!(gF == (byte) -1 || b == b2)) {
            LogUtils.m15479l(TAG, "WRONG sequence number: " + b + " - expected: " + b2);
        }
        gF = b;
        Bundle bundle = new Bundle();
        b = bArr[1];
        if (b == (byte) -1 || b == (byte) -2) {
            LogUtils.m15478k(TAG, "Receive Legacy Heartbeat...");
            return new C4454a(StreamingEventType.HEARTBEAT, bundle);
        } else if (b == (byte) -3) {
            if (14 != bArr.length) {
                LogUtils.m15479l(TAG, "Invalid event packet.");
                return null;
            }
            r0 = ((Short) gH.get(str)).shortValue();
            r3 = hb.m15163c(bArr[2]);
            if (r3 == r0) {
                LogUtils.m15476d(TAG, "Previous New Heartbeat sequence number: " + r0 + ", skip.");
                return null;
            }
            r1 = (short) ((r0 + 1) & -1);
            if (!(r0 == (short) -1 || r3 == r1)) {
                LogUtils.m15479l(TAG, "WRONG New Heartbeat sequence number: " + r3 + " - expected: " + r1);
            }
            gH.put(str, Short.valueOf(r3));
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.put(Arrays.copyOfRange(bArr, 3, 5));
            allocate.put((byte) 0);
            allocate.put(bArr[5]);
            allocate.put(Arrays.copyOfRange(bArr, 6, 8));
            allocate.put((byte) 0);
            allocate.put((byte) 0);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            int i = allocate.getInt(0);
            int i2 = allocate.getInt(4);
            LogUtils.m15476d(TAG, "Received New Heartbeat, daily steps: " + i + ", daily points: " + i2);
            bundle.putInt(StreamingCallback.EXTRA_HEARTBEAT_DAILY_STEPS, i);
            bundle.putInt(StreamingCallback.EXTRA_HEARTBEAT_DAILY_POINTS, i2);
            bundle.putByte("event_sequence_number", hb.m15166e(r3));
            return new C4454a(StreamingEventType.HEARTBEAT, bundle);
        } else if (b == (byte) -32) {
            if ((6 == bArr.length && (short) -28943 == s) || ((4 == bArr.length && ((short) -29184 == s || (short) -28944 == s)) || ((4 == bArr.length || 6 == bArr.length) && (short) 4 == s))) {
                r0 = ((Short) gG.get(str)).shortValue();
                r3 = hb.m15163c(bArr[2]);
                if (r3 == r0) {
                    LogUtils.m15476d(TAG, "Previous event sequence number: " + r0 + ", skip.");
                    return null;
                }
                r1 = (short) ((r0 + 1) & -1);
                if (!(r0 == (short) -1 || r3 == r1)) {
                    LogUtils.m15479l(TAG, "WRONG event sequence number: " + r3 + " - expected: " + r1);
                }
                gG.put(str, Short.valueOf(r3));
                b = bArr[3];
                LogUtils.m15476d(TAG, "Received User Input event: " + b);
                bundle.putInt(StreamingCallback.EXTRA_BUTTON_EVENT_ID, b);
                return new C4454a(StreamingEventType.BUTTON_EVENT, bundle);
            }
            LogUtils.m15479l(TAG, "Invalid event packet.");
            return null;
        } else if (b != (byte) -31) {
            return null;
        } else {
            if (11 != bArr.length) {
                LogUtils.m15479l(TAG, "Invalid event packet.");
                return null;
            }
            Parcelable uAppNotification = new UAppNotification(Arrays.copyOfRange(bArr, 2, 11));
            UAppNotification uAppNotification2 = (UAppNotification) gI.get(str);
            if (uAppNotification.equals(uAppNotification2)) {
                LogUtils.m15476d(TAG, "Previous: uApp Notification: " + uAppNotification2.toString() + ", skip.");
                return null;
            }
            gI.put(str, uAppNotification);
            LogUtils.m15476d(TAG, "Received BLE stream event: uApp Notification: " + uAppNotification.toString());
            bundle.putParcelable(StreamingCallback.EXTRA_UAPP_NOTIFICATION, uAppNotification);
            return new C4454a(StreamingEventType.UAPP_NOTIFICATION, bundle);
        }
    }
}
