package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.ble.util.LogUtils;
import com.misfit.frameworks.common.constants.Constants;
import org.json.JSONObject;

public abstract class dg extends ew {
    private static final String TAG = LogUtils.m15475b(dg.class);
    protected C4495a ih;
    protected short kQ;
    protected C4527b lp;

    public interface C4495a {
        void bk();

        void onStreamingEventData(byte[] bArr);
    }

    public static class C4527b extends ey {
        public byte kT;
        public short kU;
    }

    public abstract void mo4866c(short s);

    public /* synthetic */ ey getResponse() {
        return cr();
    }

    public C4527b cr() {
        return this.lp;
    }

    public dg(C4495a c4495a) {
        this.ih = c4495a;
    }

    public int getTimeOut() {
        return 0;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.lp != null) {
                jSONObject.put(Constants.RESULT, this.lp.result);
                jSONObject.put("status", this.lp.kT);
                jSONObject.put("handle", this.lp.kU);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.FILE_STREAMING;
    }
}
