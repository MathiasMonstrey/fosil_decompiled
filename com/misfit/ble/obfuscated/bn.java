package com.misfit.ble.obfuscated;

import com.misfit.ble.obfuscated.ba.C4463a;
import com.misfit.ble.obfuscated.ba.C4464b;
import com.misfit.ble.obfuscated.dg.C4495a;
import com.misfit.ble.shine.ShineActionID;
import com.misfit.ble.shine.ShineProfile.ActionResult;
import com.misfit.ble.shine.ShineProfile.ResultCode;
import com.misfit.ble.shine.error.ShineError;
import com.misfit.ble.shine.error.ShineError.Domain;
import com.misfit.ble.util.LogUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class bn extends ba {
    private static final String TAG = bn.class.getName();
    private C4497a fH;
    private dg ie;
    private short f1531if;
    private boolean ig = false;
    private C4495a ih = new C44961(this);

    class C44961 implements C4495a {
        final /* synthetic */ bn ii;

        C44961(bn bnVar) {
            this.ii = bnVar;
        }

        public void bk() {
            if (this.ii.fH != null) {
                this.ii.fT = null;
                this.ii.fH.onStreamingStarted(new ActionResult(ResultCode.SUCCEEDED, this.ii.fT));
            }
        }

        public void onStreamingEventData(byte[] bArr) {
            if (this.ii.fH != null) {
                this.ii.fH.mo4926b(this.ii.f1531if, bArr);
            }
        }
    }

    public interface C4497a {
        void mo4926b(short s, byte[] bArr);

        void onStreamingStarted(ActionResult actionResult);

        void onStreamingStopped(ActionResult actionResult);
    }

    public bn(C4463a c4463a, C4497a c4497a, short s) {
        super(ShineActionID.STREAM_USER_INPUT_EVENTS, "phaseStreamUserInputEvents", c4463a);
        this.fH = c4497a;
        this.f1531if = s;
    }

    private boolean bh() {
        return this.f1531if == (short) 4;
    }

    private dg bi() {
        if (bh()) {
            return new di(this.ih);
        }
        return new dh(this.ih);
    }

    private cu bj() {
        if (bh()) {
            return new cw();
        }
        return new cv();
    }

    public void start() {
        super.start();
        this.ie = bi();
        this.ie.mo4866c(this.f1531if);
        m14787c(this.ie);
    }

    public void mo4821a(boolean z) {
        if (this.ie != null) {
            this.ie.cancel();
            this.ie = null;
        }
        this.ig = z;
        ew bj = bj();
        bj.m15022c(this.f1531if);
        m14787c(bj);
        this.hp = m14783b(this.ig);
        this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), this.ho.getEventID(), aU());
        this.fG.mo4923f(this);
        this.fG.mo4916a((ba) this, 0);
        this.fH.onStreamingStopped(new ActionResult(m14786c(this.ig), this.fT));
    }

    public Set<String> aI() {
        if (bh()) {
            return new HashSet(Arrays.asList(new String[]{"3dda0006-957f-7d4a-34a6-74696673696d"}));
        }
        return new HashSet(Arrays.asList(new String[]{"3dda0003-957f-7d4a-34a6-74696673696d", "3dda0004-957f-7d4a-34a6-74696673696d"}));
    }

    protected void mo4822b(ew ewVar, int i, ap apVar) {
        super.mo4822b(ewVar, i, apVar);
        if (i == 1) {
            this.hp = m14778a(apVar);
            this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), this.ho.getEventID(), aU());
            this.fG.mo4923f(this);
            this.fH.onStreamingStopped(new ActionResult(ResultCode.FAILED, this.fT));
        } else if (i == 2) {
            this.hp = C4464b.RESULT_TIMED_OUT;
            this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), this.ho.getEventID(), aU());
            this.fG.mo4923f(this);
            this.fH.onStreamingStopped(new ActionResult(ResultCode.TIMED_OUT, this.fT));
        } else if (i == 3) {
            this.hp = C4464b.RESULT_UNSUPPORTED;
            this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), this.ho.getEventID(), aU());
            this.fG.mo4923f(this);
            this.fH.onStreamingStopped(new ActionResult(ResultCode.UNSUPPORTED, this.fT));
        }
    }

    protected void mo4820a(ew ewVar, int i) {
        super.mo4820a(ewVar, i);
        if (i == 1) {
            this.hp = C4464b.RESULT_RECEIVE_RESPONSE_FAILED;
            this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), this.ho.getEventID(), aU());
            this.fG.mo4923f(this);
            this.fH.onStreamingStopped(new ActionResult(ResultCode.FAILED, this.fT));
        } else if (i == 2) {
            this.hp = C4464b.RESULT_TIMED_OUT;
            this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), this.ho.getEventID(), aU());
            this.fG.mo4923f(this);
            this.fH.onStreamingStopped(new ActionResult(ResultCode.TIMED_OUT, this.fT));
        } else if (!(ewVar instanceof dg)) {
        } else {
            if (((dg) ewVar).cr().result != (byte) 0) {
                this.hp = C4464b.RESULT_REQUEST_ERROR;
                this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), this.ho.getEventID(), aU());
                this.fG.mo4923f(this);
                this.fG.mo4916a((ba) this, 0);
                this.fH.onStreamingStarted(new ActionResult(ResultCode.FAILED, this.fT));
            } else if (ewVar instanceof di) {
                this.fG.mo4922e(this);
            } else {
                LogUtils.m15477e(TAG, "Unexpected streaming response!");
            }
        }
    }
}
