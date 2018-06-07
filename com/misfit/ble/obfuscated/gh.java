package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.ble.util.LogUtils;
import com.portfolio.platform.model.UAppSystemVersionModel;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class gh extends ew {
    private static final String TAG = LogUtils.m15475b(gh.class);
    private C4573a nv;

    public static class C4573a extends ey {
        public byte nw;
        public byte nx;
    }

    public /* synthetic */ ey getResponse() {
        return dg();
    }

    public C4573a dg() {
        return this.nv;
    }

    public String getRequestName() {
        return "readUAppSystemVersion";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    public byte bZ() {
        return (byte) 7;
    }

    public void ca() {
        ByteBuffer allocate = ByteBuffer.allocate(3);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 1);
        allocate.put(1, (byte) 7);
        allocate.put(2, (byte) 17);
        this.mRequestData = allocate.array();
    }

    public byte validateResponse(String str, byte[] bArr) {
        return ew.validateResponse(bArr, (byte) 3, bZ());
    }

    public void handleResponse(String str, byte[] bArr) {
        C4573a c4573a = new C4573a();
        c4573a.result = (byte) 0;
        if (bArr.length < 4) {
            c4573a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            c4573a.nw = wrap.get(2);
            c4573a.nx = wrap.get(3);
        }
        this.nv = c4573a;
        this.mIsCompleted = true;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.nv != null) {
                jSONObject.put(UAppSystemVersionModel.COLUMN_MAJOR_VERSION, this.nv.nw);
                jSONObject.put(UAppSystemVersionModel.COLUMN_MINOR_VERSION, this.nv.nx);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.READ_UAPP_SYSTEM_VERSION;
    }
}
