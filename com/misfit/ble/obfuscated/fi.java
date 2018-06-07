package com.misfit.ble.obfuscated;

import com.misfit.ble.setting.pluto.NotificationsSettings;
import com.misfit.ble.shine.error.ShineError.Event;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class fi extends ew {
    private NotificationsSettings nb;

    public String getRequestName() {
        return "setCallTextNotifications";
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
        return (byte) 1;
    }

    public void m15092a(NotificationsSettings notificationsSettings) {
        this.nb = notificationsSettings;
        ByteBuffer allocate = ByteBuffer.allocate(10);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, cb());
        allocate.put(1, bZ());
        allocate.put(2, cc());
        allocate.put(3, ce());
        allocate.put(4, hb.m15166e(this.nb.getCallLEDSequence().getValue()));
        allocate.put(5, hb.m15166e(this.nb.getCallVibeSequence().getValue()));
        allocate.put(6, hb.m15166e(this.nb.getCallSoundSequence().getValue()));
        allocate.put(7, hb.m15166e(this.nb.getTextLEDSequence().getValue()));
        allocate.put(8, hb.m15166e(this.nb.getTextVibeSequence().getValue()));
        allocate.put(9, hb.m15166e(this.nb.getTextSoundSequence().getValue()));
        this.mRequestData = allocate.array();
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("callLEDSequence", this.nb.getCallLEDSequence().getValue());
            jSONObject.put("callVibeSequence", this.nb.getCallVibeSequence().getValue());
            jSONObject.put("callSoundSequence", this.nb.getCallSoundSequence().getValue());
            jSONObject.put("textLEDSequence", this.nb.getTextLEDSequence().getValue());
            jSONObject.put("textVibeSequence", this.nb.getTextVibeSequence().getValue());
            jSONObject.put("textSoundSequence", this.nb.getTextSoundSequence().getValue());
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public void onRequestSent(int i) {
        this.mIsCompleted = true;
    }

    public Event getEventID() {
        return Event.SETUP_BLE_NOTIFICATION;
    }
}
