package com.misfit.ble.obfuscated;

import com.misfit.ble.obfuscated.ba.C4463a;
import com.misfit.ble.obfuscated.ba.C4464b;
import com.misfit.ble.obfuscated.db.C4522a;
import com.misfit.ble.shine.ShineActionID;
import com.misfit.ble.shine.ShineProfile;
import com.misfit.ble.shine.ShineProfile.ActionResult;
import com.misfit.ble.shine.ShineProfile.ResultCode;
import com.misfit.ble.shine.ShineProfile.RetrieveHardwareLogCallback;
import com.misfit.ble.shine.error.ShineError;
import com.misfit.ble.shine.error.ShineError.Domain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class bd extends ba {
    private List<ew> gP = new ArrayList();
    private RetrieveHardwareLogCallback hO;
    private byte[] hP;
    private boolean hQ;
    private boolean hR;

    public bd(C4463a c4463a, RetrieveHardwareLogCallback retrieveHardwareLogCallback, boolean z, boolean z2) {
        super(ShineActionID.RETRIEVE_HARDWARE_LOG, "phaseRetrieveHardwareLog", c4463a);
        this.hO = retrieveHardwareLogCallback;
        this.hQ = z;
        this.hR = z2;
        if (!z) {
            db dbVar = new db(this);
            dbVar.ca();
            this.gP.add(dbVar);
        }
        if (!z2) {
            cy cyVar = new cy();
            cyVar.ca();
            this.gP.add(cyVar);
        }
        this.hP = new byte[0];
    }

    public void start() {
        super.start();
        aY();
    }

    public void mo4821a(boolean z) {
        if (this.ho != null) {
            this.ho.cancel();
            this.ho = new ei();
        }
        m14878b(m14783b(z));
    }

    protected void mo4822b(ew ewVar, int i, ap apVar) {
        super.mo4822b(ewVar, i, apVar);
        if (i == 1) {
            m14878b(m14778a(apVar));
        } else if (i == 2) {
            m14878b(C4464b.RESULT_TIMED_OUT);
        } else if (i == 3) {
            m14878b(C4464b.RESULT_UNSUPPORTED);
        } else if (!ewVar.isWaitingForResponse()) {
            aY();
        }
    }

    protected void mo4820a(ew ewVar, int i) {
        super.mo4820a(ewVar, i);
        if (i == 1) {
            m14878b(C4464b.RESULT_RECEIVE_RESPONSE_FAILED);
        } else if (i == 2) {
            m14878b(C4464b.RESULT_TIMED_OUT);
        } else {
            if (ewVar instanceof db) {
                C4522a cm = ((db) ewVar).cm();
                if (cm.result != (byte) 0) {
                    m14878b(C4464b.RESULT_REQUEST_ERROR);
                    return;
                }
                this.hP = cm.ju;
            } else if ((ewVar instanceof cy) && ((cy) ewVar).ci().result != (byte) 0) {
                m14878b(C4464b.RESULT_REQUEST_ERROR);
                return;
            }
            aY();
        }
    }

    private void aY() {
        if (this.gP == null || this.gP.isEmpty()) {
            m14878b(C4464b.RESULT_SUCCESS);
            return;
        }
        ew ewVar = (ew) this.gP.get(0);
        this.gP.remove(ewVar);
        m14787c(ewVar);
    }

    private void m14878b(C4464b c4464b) {
        this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), this.ho.getEventID(), aU());
        if (c4464b != C4464b.RESULT_SUCCESS) {
            ew cvVar = new cv();
            cvVar.m15022c((short) 16);
            m14787c(cvVar);
        } else {
            this.fT = null;
        }
        this.hp = c4464b;
        if (this.hp == C4464b.RESULT_SUCCESS) {
            this.fG.mo4922e(this);
            this.hO.onRetrievingHardwareLogCompleted(new ActionResult(ResultCode.SUCCEEDED, this.fT), this.hP);
        } else if (this.hp == C4464b.RESULT_INTERRUPTED || this.hp == C4464b.RESULT_CONNECTION_DROPPED) {
            this.fG.mo4923f(this);
            this.hO.onRetrievingHardwareLogCompleted(new ActionResult(this.hp == C4464b.RESULT_INTERRUPTED ? ResultCode.INTERRUPTED : ResultCode.CONNECTION_DROPPED, this.fT), this.hP);
        } else if (this.hp == C4464b.RESULT_TIMED_OUT) {
            this.fG.mo4923f(this);
            this.hO.onRetrievingHardwareLogCompleted(new ActionResult(ResultCode.TIMED_OUT, this.fT), this.hP);
        } else if (this.hp == C4464b.RESULT_UNSUPPORTED) {
            this.fG.mo4923f(this);
            this.hO.onRetrievingHardwareLogCompleted(new ActionResult(ResultCode.UNSUPPORTED, this.fT), this.hP);
        } else {
            this.fG.mo4923f(this);
            this.hO.onRetrievingHardwareLogCompleted(new ActionResult(ResultCode.FAILED, this.fT), this.hP);
        }
        this.fG.mo4916a((ba) this, (long) ShineProfile.LOG_UPLOADING_DELAY);
    }

    public Set<String> aI() {
        return new HashSet(Arrays.asList(new String[]{"3dda0003-957f-7d4a-34a6-74696673696d", "3dda0004-957f-7d4a-34a6-74696673696d"}));
    }

    public JSONObject aH() {
        JSONObject jSONObject;
        Throwable e;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("skipRead", this.hQ);
                jSONObject.put("skipErase", this.hR);
            } catch (JSONException e2) {
                e = e2;
                C4462b.m14831a(e, "");
                return jSONObject;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            jSONObject = null;
            e = th;
            C4462b.m14831a(e, "");
            return jSONObject;
        }
        return jSONObject;
    }
}
