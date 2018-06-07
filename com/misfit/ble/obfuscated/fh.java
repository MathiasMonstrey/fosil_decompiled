package com.misfit.ble.obfuscated;

import com.misfit.ble.setting.pluto.NotificationsSettings;
import com.misfit.ble.shine.error.ShineError.Event;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class fh extends ew {
    private NotificationsSettings nb;

    public String getRequestName() {
        return "setCallTextNotificationWindows";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    private byte cb() {
        return (byte) 2;
    }

    public byte bZ() {
        return (byte) 7;
    }

    public byte cc() {
        return (byte) 15;
    }

    public byte ce() {
        return (byte) 3;
    }

    public void m15091a(NotificationsSettings notificationsSettings) {
        this.nb = notificationsSettings;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, cb());
        allocate.put(1, bZ());
        allocate.put(2, cc());
        allocate.put(3, ce());
        allocate.put(4, hb.m15166e(this.nb.getStartHour()));
        allocate.put(5, hb.m15166e(this.nb.getStartMinute()));
        allocate.put(6, hb.m15166e(this.nb.getEndHour()));
        allocate.put(7, hb.m15166e(this.nb.getEndMinute()));
        this.mRequestData = allocate.array();
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("startHour", this.nb.getStartHour());
            jSONObject.put("startMinute", this.nb.getStartMinute());
            jSONObject.put("endHour", this.nb.getEndHour());
            jSONObject.put("endMinute", this.nb.getEndMinute());
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public void onRequestSent(int i) {
        this.mIsCompleted = true;
    }

    public Event getEventID() {
        return Event.SETUP_BLE_NOTIFICATION_TIME_WINDOW;
    }
}
