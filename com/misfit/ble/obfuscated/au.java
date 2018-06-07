package com.misfit.ble.obfuscated;

import com.misfit.ble.obfuscated.ba.C4463a;
import com.misfit.ble.obfuscated.ba.C4464b;
import com.misfit.ble.obfuscated.fc.C4565a;
import com.misfit.ble.shine.ShineActionID;
import com.misfit.ble.shine.ShineProfile.ActionResult;
import com.misfit.ble.shine.ShineProfile.ConfigurationCallback;
import com.misfit.ble.shine.ShineProfile.ResultCode;
import com.misfit.ble.shine.error.ShineError;
import com.misfit.ble.shine.error.ShineError.Domain;
import java.util.Hashtable;

public class au extends ba {
    private String eK;
    private boolean gM = false;
    private String gN;
    private ConfigurationCallback gO;

    public au(C4463a c4463a, ConfigurationCallback configurationCallback, String str, String str2) {
        super(ShineActionID.CHANGE_SERIAL_NUMBER, "phaseChangeSerialNumber", c4463a);
        this.gO = configurationCallback;
        this.eK = str;
        this.gN = str2;
    }

    public String getSerialNumber() {
        return this.eK;
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
            this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), this.ho.getEventID(), aU());
            this.fG.mo4923f(this);
            this.gO.onConfigCompleted(aR(), new ActionResult(ResultCode.FAILED, this.fT), new Hashtable());
        } else if (i == 2) {
            this.hp = C4464b.RESULT_TIMED_OUT;
            this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), this.ho.getEventID(), aU());
            this.fG.mo4923f(this);
            this.gO.onConfigCompleted(aR(), new ActionResult(ResultCode.TIMED_OUT, this.fT), new Hashtable());
        } else if (i == 3) {
            this.hp = C4464b.RESULT_UNSUPPORTED;
            this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), this.ho.getEventID(), aU());
            this.fG.mo4923f(this);
            this.gO.onConfigCompleted(aR(), new ActionResult(ResultCode.UNSUPPORTED, this.fT), new Hashtable());
        } else {
            if (ewVar instanceof fb) {
                aG();
            }
            if (ewVar instanceof fd) {
                aG();
            }
        }
    }

    protected void mo4820a(ew ewVar, int i) {
        super.mo4820a(ewVar, i);
        if (i == 1) {
            this.hp = C4464b.RESULT_RECEIVE_RESPONSE_FAILED;
            this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), this.ho.getEventID(), aU());
            this.fG.mo4923f(this);
            this.gO.onConfigCompleted(aR(), new ActionResult(ResultCode.FAILED, this.fT), new Hashtable());
        } else if (i == 2) {
            this.hp = C4464b.RESULT_TIMED_OUT;
            this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), this.ho.getEventID(), aU());
            this.fG.mo4923f(this);
            this.gO.onConfigCompleted(aR(), new ActionResult(ResultCode.TIMED_OUT, this.fT), new Hashtable());
        } else if (ewVar instanceof fc) {
            C4565a db = ((fc) ewVar).db();
            if (db.result != (byte) 0) {
                this.hp = C4464b.RESULT_REQUEST_ERROR;
                this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), this.ho.getEventID(), aU());
                this.fG.mo4923f(this);
                this.gO.onConfigCompleted(aR(), new ActionResult(ResultCode.FAILED, this.fT), new Hashtable());
                return;
            }
            this.gM = db.mY;
            aG();
        }
    }

    private void aG() {
        ew ewVar = null;
        if (this.ho instanceof ei) {
            ewVar = this.gN.equals("9876543210") ? m14789a(fd.class) : m14789a(fc.class);
        } else if (this.ho instanceof fc) {
            if (!this.gM) {
                ewVar = m14789a(fb.class);
            }
        } else if (this.ho instanceof fb) {
            this.hp = C4464b.RESULT_SUCCESS;
            this.fT = null;
            this.fG.mo4922e(this);
            this.gO.onConfigCompleted(aR(), new ActionResult(ResultCode.SUCCEEDED, this.fT), new Hashtable());
            return;
        } else if (this.ho instanceof fd) {
            this.hp = C4464b.RESULT_SUCCESS;
            this.fT = null;
            this.fG.mo4922e(this);
            this.fG.mo4925h(this);
            this.gO.onConfigCompleted(aR(), new ActionResult(ResultCode.SUCCEEDED, this.fT), new Hashtable());
            return;
        }
        m14787c(ewVar);
    }

    private ew m14789a(Class<? extends ew> cls) {
        if (cls.equals(fc.class)) {
            ew fcVar = new fc();
            fcVar.ca();
            return fcVar;
        } else if (cls.equals(fb.class)) {
            r0 = new fb();
            if (!r0.m15086F(this.eK)) {
                r0 = null;
            }
            return r0;
        } else if (!cls.equals(fd.class)) {
            return null;
        } else {
            r0 = new fd();
            if (r0.m15087F(this.eK)) {
                return r0;
            }
            return null;
        }
    }
}
