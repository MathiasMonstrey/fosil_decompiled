package com.misfit.ble.obfuscated;

import com.misfit.ble.obfuscated.ao.C4452c;
import com.misfit.ble.shine.ActionID;
import com.misfit.ble.shine.ShineProfile.ResultCode;
import com.misfit.ble.shine.error.ShineError;
import com.misfit.ble.shine.error.ShineError.Domain;
import com.misfit.ble.shine.error.ShineError.Reason;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public abstract class ba {
    protected C4463a fG;
    protected ShineError fT;
    protected ew ho = new ei();
    protected C4464b hp;
    private ActionID hq = null;
    private String hr = null;

    public interface C4463a {
        void mo4916a(ba baVar, long j);

        void mo4917a(ba baVar, ci ciVar);

        void mo4918a(ba baVar, ew ewVar);

        void mo4919b(ba baVar, ci ciVar);

        void mo4920c(ba baVar);

        void mo4921d(ba baVar);

        void mo4922e(ba baVar);

        void mo4923f(ba baVar);

        void mo4924g(ba baVar);

        void mo4925h(ba baVar);
    }

    public enum C4464b {
        RESULT_UNKNOWN(-1),
        RESULT_SUCCESS(0),
        RESULT_SENDING_REQUEST_FAILED(12),
        RESULT_SENDING_REQUEST_FAILED_WITH_UNKNOWN_ERROR(2),
        RESULT_RECEIVE_RESPONSE_FAILED(15),
        RESULT_TIMED_OUT(13),
        RESULT_REQUEST_ERROR(23),
        RESULT_RESPONSE_PARSE_ERROR(16),
        RESULT_FLOW_BROKEN(22),
        RESULT_INTERRUPTED(19),
        RESULT_DATA_TRANSFER_FAILED(18),
        RESULT_UNSUPPORTED(14),
        RESULT_WRITE_CHARACTERISTIC_FAILED(26),
        RESULT_INCOMPATIBLE_PARAMS(27),
        RESULT_CONNECTION_DROPPED(28),
        RESULT_REQUEST_VALUE_OUT_OF_RANGE_ERROR(11),
        RESULT_FUNCTION_NOT_IMPLEMENTED_ERROR(24),
        RESULT_RESOURCE_UNAVAILABLE_ERROR(20),
        RESULT_BLE_STACK_ERROR(21);
        
        private static final Map<Integer, C4464b> aD = null;
        private int eo;

        static {
            aD = new HashMap();
            Iterator it = EnumSet.allOf(C4464b.class).iterator();
            while (it.hasNext()) {
                C4464b c4464b = (C4464b) it.next();
                aD.put(Integer.valueOf(c4464b.getId()), c4464b);
            }
        }

        private C4464b(int i) {
            this.eo = i;
        }

        public int getId() {
            return this.eo;
        }
    }

    public ActionID aR() {
        return this.hq;
    }

    public String aS() {
        return this.hr;
    }

    public C4463a aT() {
        return this.fG;
    }

    protected ba(ActionID actionID, String str, C4463a c4463a) {
        this.hq = actionID;
        this.hr = str;
        this.fG = c4463a;
        this.hp = C4464b.RESULT_UNKNOWN;
    }

    public void start() {
    }

    public void mo4821a(boolean z) {
        this.hp = m14783b(z);
        this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), this.ho.getEventID(), aU());
        this.fG.mo4923f(this);
        if (this.ho != null) {
            this.ho.cancel();
            this.ho = new ei();
        }
    }

    protected C4464b m14783b(boolean z) {
        return z ? C4464b.RESULT_CONNECTION_DROPPED : C4464b.RESULT_INTERRUPTED;
    }

    protected ResultCode m14786c(boolean z) {
        return z ? ResultCode.CONNECTION_DROPPED : ResultCode.INTERRUPTED;
    }

    public void m14784b(ew ewVar, int i) {
        if (!hasFinished() && ewVar != null && ewVar.equals(this.ho)) {
            mo4820a(ewVar, i);
        }
    }

    protected void mo4820a(ew ewVar, int i) {
    }

    public void m14788c(ew ewVar, int i, ap apVar) {
        if (!hasFinished() && ewVar != null && ewVar.equals(this.ho)) {
            mo4822b(ewVar, i, apVar);
        }
    }

    protected void mo4822b(ew ewVar, int i, ap apVar) {
    }

    public int getResultCode() {
        if (this.hp == null) {
            return -1;
        }
        if (this.hp != C4464b.RESULT_SUCCESS) {
            return 1;
        }
        return C4464b.RESULT_SUCCESS.getId();
    }

    public boolean hasFinished() {
        return this.hp != C4464b.RESULT_UNKNOWN;
    }

    public Reason aU() {
        return m14779a(this.hp);
    }

    public Reason m14779a(C4464b c4464b) {
        if (c4464b == null) {
            return Reason.UNKNOWN;
        }
        if (c4464b == C4464b.RESULT_SUCCESS) {
            return null;
        }
        if (c4464b == C4464b.RESULT_SENDING_REQUEST_FAILED) {
            return Reason.SENDING_REQUEST_FAILED;
        }
        if (c4464b == C4464b.RESULT_SENDING_REQUEST_FAILED_WITH_UNKNOWN_ERROR) {
            return Reason.SENDING_REQUEST_FAILED_WITH_UNKNOWN_ERROR;
        }
        if (c4464b == C4464b.RESULT_RECEIVE_RESPONSE_FAILED) {
            return Reason.RECEIVE_RESPONSE_FAILED;
        }
        if (c4464b == C4464b.RESULT_TIMED_OUT) {
            return Reason.TIMED_OUT;
        }
        if (c4464b == C4464b.RESULT_REQUEST_ERROR) {
            return Reason.REQUEST_ERROR;
        }
        if (c4464b == C4464b.RESULT_RESPONSE_PARSE_ERROR) {
            return Reason.RESPONSE_PARSE_ERROR;
        }
        if (c4464b == C4464b.RESULT_FLOW_BROKEN) {
            return Reason.FLOW_BROKEN;
        }
        if (c4464b == C4464b.RESULT_INTERRUPTED) {
            return Reason.INTERRUPTED;
        }
        if (this.hp == C4464b.RESULT_CONNECTION_DROPPED) {
            return Reason.CONNECTION_DROPPED;
        }
        if (this.hp == C4464b.RESULT_DATA_TRANSFER_FAILED) {
            return Reason.DATA_TRANSFER_FAILED;
        }
        if (c4464b == C4464b.RESULT_UNSUPPORTED) {
            return Reason.UNSUPPORTED;
        }
        if (c4464b == C4464b.RESULT_REQUEST_VALUE_OUT_OF_RANGE_ERROR) {
            return Reason.REQUEST_VALUE_OUT_OF_RANGE_ERROR;
        }
        if (c4464b == C4464b.RESULT_FUNCTION_NOT_IMPLEMENTED_ERROR) {
            return Reason.FUNCTION_NOT_IMPLEMENTED_ERROR;
        }
        if (c4464b == C4464b.RESULT_BLE_STACK_ERROR) {
            return Reason.BLE_STACK_ERROR;
        }
        if (c4464b == C4464b.RESULT_RESOURCE_UNAVAILABLE_ERROR) {
            return Reason.RESOURCE_UNAVAILABLE_ERROR;
        }
        if (c4464b == C4464b.RESULT_WRITE_CHARACTERISTIC_FAILED) {
            return Reason.WRITE_CHARACTERISTIC_FAILED;
        }
        if (c4464b == C4464b.RESULT_INCOMPATIBLE_PARAMS) {
            return Reason.INCOMPATIBLE_PARAMS;
        }
        return Reason.UNKNOWN;
    }

    public Set<String> aI() {
        return new HashSet(Arrays.asList(new String[]{"3dda0002-957f-7d4a-34a6-74696673696d"}));
    }

    public void m14787c(ew ewVar) {
        if (ewVar != null) {
            this.ho = ewVar;
            this.fG.mo4918a(this, ewVar);
            return;
        }
        this.hp = C4464b.RESULT_FLOW_BROKEN;
        this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), this.ho.getEventID(), aU());
        this.fG.mo4923f(this);
    }

    public JSONObject aH() {
        return null;
    }

    public JSONObject aV() {
        if (this.fT == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error", this.fT.toJSON());
            return jSONObject;
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
            return jSONObject;
        }
    }

    public void mo4828a(int i, int i2, int i3) {
    }

    public void aW() {
        if (!hasFinished()) {
            aX();
        }
    }

    protected void aX() {
    }

    public C4464b m14778a(ap apVar) {
        if (apVar == null) {
            return C4464b.RESULT_SENDING_REQUEST_FAILED;
        }
        if (apVar.getId() == am.RESULT_MP_ERR_ST_VALUE_RANGE.getId()) {
            return C4464b.RESULT_REQUEST_VALUE_OUT_OF_RANGE_ERROR;
        }
        if (apVar.getId() == am.RESULT_MP_ERR_ST_FUNCTION_NOT_IMPLEMENTED.getId()) {
            return C4464b.RESULT_FUNCTION_NOT_IMPLEMENTED_ERROR;
        }
        if (apVar.getId() == am.RESULT_MP_ERR_ST_RESOURCE_UNAVAILABLE.getId()) {
            return C4464b.RESULT_RESOURCE_UNAVAILABLE_ERROR;
        }
        if (apVar.getId() == C4452c.CHARACTERISTIC_WRITING_FAILED.getId()) {
            return C4464b.RESULT_WRITE_CHARACTERISTIC_FAILED;
        }
        return C4464b.RESULT_BLE_STACK_ERROR;
    }
}
