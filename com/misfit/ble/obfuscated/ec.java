package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class ec extends ew {
    private C4550a mj;

    public static class C4550a extends ey {
        public int mk;
    }

    public /* synthetic */ ey getResponse() {
        return cM();
    }

    public C4550a cM() {
        return this.mj;
    }

    public String getRequestName() {
        return "getNumberOfMappedEventPackets";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    public void ca() {
        ByteBuffer allocate = ByteBuffer.allocate(3);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 1);
        allocate.put(1, (byte) 12);
        allocate.put(2, (byte) -32);
        this.mRequestData = allocate.array();
    }

    public byte validateResponse(String str, byte[] bArr) {
        return ew.validateResponse(bArr, (byte) 3, (byte) 12);
    }

    public void handleResponse(String str, byte[] bArr) {
        C4550a c4550a = new C4550a();
        c4550a.result = (byte) 0;
        if (bArr.length < 4) {
            c4550a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            c4550a.mk = wrap.getShort(2);
        }
        this.mj = c4550a;
        this.mIsCompleted = true;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.mj != null) {
                jSONObject.put(Constants.RESULT, this.mj.result);
                jSONObject.put("numberOfMappedEventPackets", this.mj.mk);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.SET_FILE_STREAMING_NUMBER_OF_PACKET_EVENTS;
    }
}
