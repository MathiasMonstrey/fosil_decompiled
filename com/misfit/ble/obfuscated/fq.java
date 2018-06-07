package com.misfit.ble.obfuscated;

import com.fossil.wearables.fsl.shared.BaseFeatureModel;
import com.misfit.ble.setting.pluto.GoalHitNotificationSettings;
import com.misfit.ble.shine.error.ShineError.Event;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class fq extends ew {
    private GoalHitNotificationSettings ni;

    public String getRequestName() {
        return "setGoalHitNotification";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    private byte cb() {
        return (byte) 2;
    }

    public byte bZ() {
        return (byte) 3;
    }

    public byte cc() {
        return (byte) 4;
    }

    public byte ce() {
        return (byte) 1;
    }

    public void m15100a(GoalHitNotificationSettings goalHitNotificationSettings) {
        this.ni = goalHitNotificationSettings;
        ByteBuffer allocate = ByteBuffer.allocate(12);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, cb());
        allocate.put(1, bZ());
        allocate.put(2, cc());
        allocate.put(3, ce());
        allocate.put(4, hb.m15167f(this.ni.getEnabled()));
        allocate.put(5, hb.m15166e(this.ni.getLEDSequence().getValue()));
        allocate.put(6, hb.m15166e(this.ni.getVibeSequence().getValue()));
        allocate.put(7, hb.m15166e(this.ni.getSoundSequence().getValue()));
        allocate.put(8, hb.m15166e(this.ni.getStartHour()));
        allocate.put(9, hb.m15166e(this.ni.getStartMinute()));
        allocate.put(10, hb.m15166e(this.ni.getEndHour()));
        allocate.put(11, hb.m15166e(this.ni.getEndMinute()));
        this.mRequestData = allocate.array();
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(BaseFeatureModel.COLUMN_ENABLED, this.ni.getEnabled());
            jSONObject.put("ledSequenceID", this.ni.getLEDSequence().getValue());
            jSONObject.put("vibeSequenceID", this.ni.getVibeSequence().getValue());
            jSONObject.put("soundSequenceID", this.ni.getSoundSequence().getValue());
            jSONObject.put("startHour", this.ni.getStartHour());
            jSONObject.put("startMinute", this.ni.getStartMinute());
            jSONObject.put("endHour", this.ni.getEndHour());
            jSONObject.put("endMinute", this.ni.getEndMinute());
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public void onRequestSent(int i) {
        this.mIsCompleted = true;
    }

    public Event getEventID() {
        return Event.SETUP_GOAL_HIT_NOTIFICATION;
    }
}
