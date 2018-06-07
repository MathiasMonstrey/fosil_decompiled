package com.misfit.ble.obfuscated;

import com.misfit.ble.obfuscated.ba.C4463a;
import com.misfit.ble.obfuscated.ba.C4464b;
import com.misfit.ble.obfuscated.dr.C4537a;
import com.misfit.ble.obfuscated.ec.C4550a;
import com.misfit.ble.shine.ShineActionID;
import com.misfit.ble.shine.ShineProfile.ActionResult;
import com.misfit.ble.shine.ShineProfile.ConfigurationCallback;
import com.misfit.ble.shine.ShineProfile.ResultCode;
import com.misfit.ble.shine.ShineProperty;
import com.misfit.ble.shine.ShineStreamingConfiguration;
import com.misfit.ble.shine.error.ShineError;
import com.misfit.ble.shine.error.ShineError.Domain;
import java.util.Hashtable;

public class ay extends ba {
    private ConfigurationCallback gO;
    private ShineStreamingConfiguration hc = new ShineStreamingConfiguration();

    public ay(C4463a c4463a, ConfigurationCallback configurationCallback) {
        super(ShineActionID.GET_STREAMING_CONFIGURATION, "phaseGetStreamingConfiguration", c4463a);
        this.gO = configurationCallback;
    }

    public void start() {
        super.start();
        aG();
    }

    public void mo4821a(boolean z) {
        super.mo4821a(z);
        this.gO.onConfigCompleted(aR(), new ActionResult(m14786c(z), this.fT), new Hashtable());
    }

    protected void mo4822b(ew ewVar, int i, ap apVar) {
        super.mo4822b(ewVar, i, apVar);
        if (i == 1) {
            this.hp = m14778a(apVar);
            this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), ewVar.getEventID(), aU());
            this.fG.mo4923f(this);
            this.gO.onConfigCompleted(aR(), new ActionResult(ResultCode.FAILED, this.fT), new Hashtable());
        } else if (i == 2) {
            this.hp = C4464b.RESULT_TIMED_OUT;
            this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), ewVar.getEventID(), aU());
            this.fG.mo4923f(this);
            this.gO.onConfigCompleted(aR(), new ActionResult(ResultCode.TIMED_OUT, this.fT), new Hashtable());
        } else if (i == 3) {
            aG();
        }
    }

    protected void mo4820a(ew ewVar, int i) {
        super.mo4820a(ewVar, i);
        if (i == 1) {
            this.hp = C4464b.RESULT_RECEIVE_RESPONSE_FAILED;
            this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), ewVar.getEventID(), aU());
            this.fG.mo4923f(this);
            this.gO.onConfigCompleted(aR(), new ActionResult(ResultCode.FAILED, this.fT), new Hashtable());
        } else if (i == 2) {
            this.hp = C4464b.RESULT_TIMED_OUT;
            this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), ewVar.getEventID(), aU());
            this.fG.mo4923f(this);
            this.gO.onConfigCompleted(aR(), new ActionResult(ResultCode.TIMED_OUT, this.fT), new Hashtable());
        } else {
            if (ewVar instanceof ec) {
                C4550a cM = ((ec) ewVar).cM();
                if (cM.result != (byte) 0) {
                    this.hp = C4464b.RESULT_REQUEST_ERROR;
                    this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), ewVar.getEventID(), aU());
                    this.fG.mo4923f(this);
                    this.gO.onConfigCompleted(aR(), new ActionResult(ResultCode.FAILED, this.fT), new Hashtable());
                    return;
                }
                this.hc.mNumberOfMappedEventPackets = cM.mk;
            } else if (ewVar instanceof dr) {
                C4537a cB = ((dr) ewVar).cB();
                if (cB.result != (byte) 0) {
                    this.hp = C4464b.RESULT_REQUEST_ERROR;
                    this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), ewVar.getEventID(), aU());
                    this.fG.mo4923f(this);
                    this.gO.onConfigCompleted(aR(), new ActionResult(ResultCode.FAILED, this.fT), new Hashtable());
                    return;
                }
                this.hc.mConnectionHeartbeatInterval = cB.lK;
            }
            aG();
        }
    }

    private ew m14812a(Class<? extends ew> cls) {
        ew ecVar;
        if (cls.equals(ec.class)) {
            ecVar = new ec();
            ecVar.ca();
            return ecVar;
        } else if (!cls.equals(dr.class)) {
            return null;
        } else {
            ecVar = new dr();
            ecVar.ca();
            return ecVar;
        }
    }

    private void aG() {
        ew ewVar = null;
        if (this.ho instanceof ei) {
            ewVar = m14812a(ec.class);
        } else if (this.ho instanceof ec) {
            ewVar = m14812a(dr.class);
        } else if (this.ho instanceof dr) {
            this.hp = C4464b.RESULT_SUCCESS;
            this.fT = null;
            this.fG.mo4922e(this);
            Hashtable hashtable = new Hashtable();
            hashtable.put(ShineProperty.STREAMING_CONFIGURATION, this.hc);
            this.gO.onConfigCompleted(aR(), new ActionResult(ResultCode.SUCCEEDED, this.fT), hashtable);
            return;
        }
        m14787c(ewVar);
    }
}
