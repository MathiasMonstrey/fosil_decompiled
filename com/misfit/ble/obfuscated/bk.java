package com.misfit.ble.obfuscated;

import com.misfit.ble.obfuscated.ba.C4463a;
import com.misfit.ble.obfuscated.ba.C4464b;
import com.misfit.ble.shine.ShineActionID;
import com.misfit.ble.shine.ShineProfile.ActionResult;
import com.misfit.ble.shine.ShineProfile.ConfigurationCallback;
import com.misfit.ble.shine.ShineProfile.ResultCode;
import com.misfit.ble.shine.ShineStreamingConfiguration;
import com.misfit.ble.shine.error.ShineError;
import com.misfit.ble.shine.error.ShineError.Domain;
import java.util.Hashtable;

public class bk extends ba {
    private ConfigurationCallback gO;
    private ShineStreamingConfiguration hc;

    public bk(C4463a c4463a, ConfigurationCallback configurationCallback, ShineStreamingConfiguration shineStreamingConfiguration) {
        super(ShineActionID.SET_STREAMING_CONFIGURATION, "phaseSetStreamingConfiguration", c4463a);
        this.gO = configurationCallback;
        this.hc = shineStreamingConfiguration;
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
            this.hp = C4464b.RESULT_UNSUPPORTED;
            this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), ewVar.getEventID(), aU());
            this.fG.mo4923f(this);
            this.gO.onConfigCompleted(aR(), new ActionResult(ResultCode.UNSUPPORTED, this.fT), new Hashtable());
        } else {
            aG();
        }
    }

    private ew m14927a(Class<? extends ew> cls) {
        ew fvVar;
        if (cls.equals(fv.class)) {
            fvVar = new fv();
            fvVar.m15105i(this.hc.mNumberOfMappedEventPackets);
            return fvVar;
        } else if (!cls.equals(fk.class)) {
            return null;
        } else {
            fvVar = new fk();
            fvVar.m15094f(this.hc.mConnectionHeartbeatInterval);
            return fvVar;
        }
    }

    private void aG() {
        ew ewVar = null;
        if (this.ho instanceof ei) {
            ewVar = m14927a(fv.class);
        } else if (this.ho instanceof fv) {
            ewVar = m14927a(fk.class);
        } else if (this.ho instanceof fk) {
            this.hp = C4464b.RESULT_SUCCESS;
            this.fT = null;
            this.fG.mo4922e(this);
            this.gO.onConfigCompleted(aR(), new ActionResult(ResultCode.SUCCEEDED, this.fT), new Hashtable());
            return;
        }
        m14787c(ewVar);
    }
}
