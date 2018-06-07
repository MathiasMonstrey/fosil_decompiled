package com.misfit.ble.obfuscated;

import android.os.Bundle;
import com.misfit.ble.obfuscated.ba.C4463a;
import com.misfit.ble.obfuscated.ba.C4464b;
import com.misfit.ble.shine.ActionID;
import com.misfit.ble.shine.ShineProfile.ActionResult;
import com.misfit.ble.shine.ShineProfile.ResultCode;
import com.misfit.ble.shine.error.ShineError;
import com.misfit.ble.shine.error.ShineError.Domain;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

public class av extends ba {
    private List<ew> gP;
    private int gQ;
    private int gR;
    private C4455a gS;
    private JSONObject gT;
    private boolean gU;
    private ActionResult gV;
    private C4464b gW;

    public interface C4455a {
        void mo4826a(ba baVar, List<ew> list, ActionResult actionResult);
    }

    public av(ActionID actionID, String str, List<ew> list, C4463a c4463a, C4455a c4455a, JSONObject... jSONObjectArr) {
        super(actionID, str, c4463a);
        this.gT = null;
        this.gP = list;
        this.gR = this.gP.size();
        this.gQ = 0;
        this.gS = c4455a;
        this.gV = null;
        this.gW = C4464b.RESULT_UNKNOWN;
        if (jSONObjectArr != null && jSONObjectArr.length > 0) {
            this.gT = jSONObjectArr[0];
        }
    }

    public av(ActionID actionID, String str, List<ew> list, C4463a c4463a, C4455a c4455a, Bundle bundle, JSONObject... jSONObjectArr) {
        this(actionID, str, list, c4463a, c4455a, jSONObjectArr);
        if (bundle != null) {
            this.gU = bundle.getBoolean("com.misfit.ble.shine.controller.runOptionSkipFailRequest", false);
        }
    }

    public JSONObject aH() {
        return this.gT;
    }

    public void start() {
        super.start();
        m14794f(0);
    }

    public void mo4821a(boolean z) {
        super.mo4821a(z);
        this.gS.mo4826a(this, this.gP, new ActionResult(m14786c(z), this.fT));
    }

    public Set<String> aI() {
        Set<String> hashSet = new HashSet();
        for (ew characteristicUUID : this.gP) {
            hashSet.add(characteristicUUID.getCharacteristicUUID());
        }
        return hashSet;
    }

    protected void mo4822b(ew ewVar, int i, ap apVar) {
        super.mo4822b(ewVar, i, apVar);
        if (this.gW == C4464b.RESULT_UNKNOWN) {
            if (i == 1) {
                this.gW = m14778a(apVar);
                this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), ewVar.getEventID(), m14779a(this.gW));
                this.gV = new ActionResult(ResultCode.FAILED, this.fT);
            } else if (i == 2) {
                this.gW = C4464b.RESULT_TIMED_OUT;
                this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), ewVar.getEventID(), m14779a(this.gW));
                this.gV = new ActionResult(ResultCode.TIMED_OUT, this.fT);
            } else if (i == 3) {
                this.gW = C4464b.RESULT_UNSUPPORTED;
                this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), ewVar.getEventID(), m14779a(this.gW));
                this.gV = new ActionResult(ResultCode.UNSUPPORTED, this.fT);
            }
        }
        if (!ewVar.isWaitingForResponse()) {
            m14794f(i);
        }
    }

    protected void mo4820a(ew ewVar, int i) {
        super.mo4820a(ewVar, i);
        if (this.gW == C4464b.RESULT_UNKNOWN) {
            if (i == 1) {
                this.gW = C4464b.RESULT_RECEIVE_RESPONSE_FAILED;
                this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), ewVar.getEventID(), m14779a(this.gW));
                this.gV = new ActionResult(ResultCode.FAILED, this.fT);
            } else if (i == 2) {
                this.gW = C4464b.RESULT_TIMED_OUT;
                this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), ewVar.getEventID(), m14779a(this.gW));
                this.gV = new ActionResult(ResultCode.TIMED_OUT, this.fT);
            }
            if (ewVar.getResponse() == null || ewVar.getResponse().result != (byte) 0) {
                this.gW = C4464b.RESULT_REQUEST_ERROR;
                this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), ewVar.getEventID(), m14779a(this.gW));
                this.gV = new ActionResult(ResultCode.FAILED, this.fT);
            }
        }
        m14794f(i);
    }

    private void m14794f(int i) {
        if (i != 0 && !this.gU) {
            this.hp = this.gW;
            this.fG.mo4923f(this);
            this.gS.mo4826a(this, this.gP, this.gV);
        } else if (this.gQ < this.gR) {
            m14787c((ew) this.gP.get(this.gQ));
            this.gQ++;
        } else if (this.gQ != this.gR) {
            this.hp = C4464b.RESULT_FLOW_BROKEN;
            this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), this.ho.getEventID(), aU());
            this.fG.mo4923f(this);
            this.gS.mo4826a(this, this.gP, new ActionResult(ResultCode.INTERNAL_ERROR, this.fT));
        } else if (this.gW == C4464b.RESULT_UNKNOWN) {
            this.hp = C4464b.RESULT_SUCCESS;
            this.fT = null;
            aT().mo4922e(this);
            this.gS.mo4826a(this, this.gP, new ActionResult(ResultCode.SUCCEEDED, this.fT));
        } else {
            this.hp = this.gW;
            aT().mo4923f(this);
            this.gS.mo4826a(this, this.gP, this.gV);
        }
    }
}
