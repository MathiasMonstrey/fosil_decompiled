package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.ShineProfile.State;
import com.misfit.frameworks.common.constants.Constants;
import org.json.JSONObject;

public class bz extends ca {
    public C4507b jU;
    public C4506a jV;
    public C4509d jW;
    public C4508c jX;

    public static class C4506a {
        public long jS = System.currentTimeMillis();
        public JSONObject jT;
        public Object jY;

        public C4506a(Object obj) {
            this.jY = obj;
        }

        public C4506a(Object obj, JSONObject jSONObject) {
            this.jY = obj;
            this.jT = jSONObject;
        }

        public JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("timestamp", (((double) this.jS) * 1.0d) / 1000.0d);
                jSONObject.put(Constants.RESULT, this.jY);
                jSONObject.put("value", this.jT);
            } catch (Throwable e) {
                C4462b.m14831a(e, "");
            }
            return jSONObject;
        }
    }

    public static class C4507b {
        public State eZ;
        public long jS = System.currentTimeMillis();
        public JSONObject jT;

        public C4507b(State state, JSONObject jSONObject) {
            this.jT = jSONObject;
            this.eZ = state;
        }

        public JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("timestamp", (((double) this.jS) * 1.0d) / 1000.0d);
                jSONObject.put("value", this.jT);
                jSONObject.put("state", this.eZ);
            } catch (Throwable e) {
                C4462b.m14831a(e, "");
            }
            return jSONObject;
        }
    }

    public static class C4508c {
        public long jS = System.currentTimeMillis();
        public JSONObject jT;
        public Object jY;

        public C4508c(Object obj, JSONObject jSONObject) {
            this.jY = obj;
            this.jT = jSONObject;
        }

        public JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("timestamp", (((double) this.jS) * 1.0d) / 1000.0d);
                jSONObject.put(Constants.RESULT, this.jY);
                jSONObject.put("value", this.jT);
            } catch (Throwable e) {
                C4462b.m14831a(e, "");
            }
            return jSONObject;
        }
    }

    public static class C4509d {
        public long jS = System.currentTimeMillis();
        public JSONObject jT;
        public Object jY;

        public C4509d(Object obj, JSONObject jSONObject) {
            this.jY = obj;
            this.jT = jSONObject;
        }

        public JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("timestamp", (((double) this.jS) * 1.0d) / 1000.0d);
                jSONObject.put(Constants.RESULT, this.jY);
                jSONObject.put("value", this.jT);
            } catch (Throwable e) {
                C4462b.m14831a(e, "");
            }
            return jSONObject;
        }
    }

    public bz(String str) {
        super(str);
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.EVENT, this.jR);
            if (this.jU != null) {
                jSONObject.put("requestStarted", this.jU.toJSONObject());
            }
            if (this.jV != null) {
                jSONObject.put("requestFinished", this.jV.toJSONObject());
            }
            if (this.jW != null) {
                jSONObject.put("responseStarted", this.jW.toJSONObject());
            }
            if (this.jX != null) {
                jSONObject.put("responseFinished", this.jX.toJSONObject());
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }
}
