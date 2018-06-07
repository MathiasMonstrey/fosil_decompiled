package com.misfit.ble.obfuscated;

import com.misfit.ble.obfuscated.ba.C4463a;
import com.misfit.ble.obfuscated.ba.C4464b;
import com.misfit.ble.obfuscated.ds.C4538a;
import com.misfit.ble.obfuscated.ex.C4562a;
import com.misfit.ble.shine.ShineConnectionParameters;
import com.misfit.ble.shine.ShineProfile.ActionResult;
import com.misfit.ble.shine.ShineProfile.ConfigurationCallback;
import com.misfit.ble.shine.ShineProfile.ResultCode;
import com.misfit.ble.shine.ShineProperty;
import com.misfit.ble.shine.error.ShineError;
import com.misfit.ble.shine.error.ShineError.Domain;
import com.misfit.ble.util.LogUtils;
import java.util.Hashtable;

public class bi extends bh {
    private static final String TAG = LogUtils.m15475b(bi.class);

    public bi(C4463a c4463a, ConfigurationCallback configurationCallback, ShineConnectionParameters shineConnectionParameters) {
        super(c4463a, configurationCallback, shineConnectionParameters);
    }

    protected void mo4820a(ew ewVar, int i) {
        if (i == 1) {
            bg.m14912b(this, this.hV);
            this.hp = C4464b.RESULT_RECEIVE_RESPONSE_FAILED;
            this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), ewVar.getEventID(), aU());
            this.fG.mo4923f(this);
            this.gO.onConfigCompleted(aR(), new ActionResult(ResultCode.FAILED, this.fT), new Hashtable());
        } else if (i == 2) {
            bg.m14912b(this, this.hV);
            this.hp = C4464b.RESULT_TIMED_OUT;
            this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), ewVar.getEventID(), aU());
            this.fG.mo4923f(this);
            this.gO.onConfigCompleted(aR(), new ActionResult(ResultCode.TIMED_OUT, this.fT), new Hashtable());
        } else if (ewVar instanceof ds) {
            C4538a cC = ((ds) ewVar).cC();
            if (cC.result != (byte) 0) {
                bg.m14912b(this, this.hV);
                this.hp = C4464b.RESULT_REQUEST_ERROR;
                this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), ewVar.getEventID(), aU());
                this.fG.mo4923f(this);
                this.gO.onConfigCompleted(aR(), new ActionResult(ResultCode.FAILED, this.fT), new Hashtable());
                return;
            }
            this.hW = new ShineConnectionParameters(cC.lM, cC.lN, cC.lO);
            if (mo4834a(this.hV, this.hW)) {
                LogUtils.m15478k(TAG, "Already at requested connection parameters!");
                bg.m14913c(this, this.hV);
                this.hp = C4464b.RESULT_SUCCESS;
                this.fT = null;
                this.fG.mo4922e(this);
                r0 = new Hashtable();
                r0.put(ShineProperty.CONNECTION_PARAMETERS, this.hW);
                this.gO.onConfigCompleted(aR(), new ActionResult(ResultCode.SUCCEEDED, this.fT), r0);
                return;
            }
            ew exVar = new ex();
            exVar.m15080i(m14919b(this.hV));
            m14787c(exVar);
        } else if (ewVar instanceof ex) {
            C4562a da = ((ex) ewVar).da();
            this.hW = new ShineConnectionParameters(da.lM, da.lN, da.lO);
            if (da.result != (byte) 0) {
                bg.m14912b(this, this.hV);
                this.hp = C4464b.RESULT_REQUEST_ERROR;
                this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), this.ho.getEventID(), aU());
                this.fG.mo4923f(this);
                this.gO.onConfigCompleted(aR(), new ActionResult(ResultCode.FAILED, this.fT), new Hashtable());
                return;
            }
            bg.m14913c(this, this.hV);
            this.hp = C4464b.RESULT_SUCCESS;
            this.fT = null;
            this.fG.mo4922e(this);
            r0 = new Hashtable();
            r0.put(ShineProperty.CONNECTION_PARAMETERS, this.hW);
            this.gO.onConfigCompleted(aR(), new ActionResult(ResultCode.SUCCEEDED, this.fT), r0);
        }
    }

    protected boolean mo4834a(ShineConnectionParameters shineConnectionParameters, ShineConnectionParameters shineConnectionParameters2) {
        return m14919b(shineConnectionParameters) == m14919b(shineConnectionParameters2);
    }

    private int m14919b(ShineConnectionParameters shineConnectionParameters) {
        double connectionInterval = shineConnectionParameters.getConnectionInterval();
        if (connectionInterval < 30.0d) {
            return 1;
        }
        if (30.0d > connectionInterval || connectionInterval > 100.0d) {
            return 2;
        }
        return 0;
    }
}
