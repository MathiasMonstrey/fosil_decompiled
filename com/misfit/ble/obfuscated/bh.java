package com.misfit.ble.obfuscated;

import com.misfit.ble.obfuscated.ba.C4463a;
import com.misfit.ble.obfuscated.ba.C4464b;
import com.misfit.ble.obfuscated.ds.C4538a;
import com.misfit.ble.obfuscated.fl.C4566a;
import com.misfit.ble.shine.ShineActionID;
import com.misfit.ble.shine.ShineConnectionParameters;
import com.misfit.ble.shine.ShineProfile.ActionResult;
import com.misfit.ble.shine.ShineProfile.ConfigurationCallback;
import com.misfit.ble.shine.ShineProfile.ResultCode;
import com.misfit.ble.shine.ShineProperty;
import com.misfit.ble.shine.error.ShineError;
import com.misfit.ble.shine.error.ShineError.Domain;
import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.ble.util.LogUtils;
import java.util.Hashtable;
import org.json.JSONException;
import org.json.JSONObject;

public class bh extends ba {
    private static final String TAG = LogUtils.m15475b(bh.class);
    protected ConfigurationCallback gO;
    protected ShineConnectionParameters hV;
    protected ShineConnectionParameters hW;
    private int hX = 0;

    public bh(C4463a c4463a, ConfigurationCallback configurationCallback, ShineConnectionParameters shineConnectionParameters) {
        super(ShineActionID.SET_CONNECTION_PARAMETERS, "phaseSetConnectionParameters", c4463a);
        this.hV = shineConnectionParameters;
        this.gO = configurationCallback;
    }

    public void start() {
        super.start();
        if (bg.m14911a(this, this.hV)) {
            ew dsVar = new ds();
            dsVar.ca();
            m14787c(dsVar);
            return;
        }
        this.hp = C4464b.RESULT_INCOMPATIBLE_PARAMS;
        this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), Event.NONE, aU());
        this.fG.mo4923f(this);
        this.gO.onConfigCompleted(aR(), new ActionResult(ResultCode.FAILED, this.fT), new Hashtable());
    }

    public void mo4821a(boolean z) {
        super.mo4821a(z);
        this.gO.onConfigCompleted(aR(), new ActionResult(m14786c(z), this.fT), new Hashtable());
    }

    protected void mo4822b(ew ewVar, int i, ap apVar) {
        super.mo4822b(ewVar, i, apVar);
        if (i == 1) {
            bg.m14912b(this, this.hV);
            this.hp = m14778a(apVar);
            this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), ewVar.getEventID(), aU());
            this.fG.mo4923f(this);
            this.gO.onConfigCompleted(aR(), new ActionResult(ResultCode.FAILED, this.fT), new Hashtable());
        } else if (i == 2) {
            bg.m14912b(this, this.hV);
            this.hp = C4464b.RESULT_TIMED_OUT;
            this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), ewVar.getEventID(), aU());
            this.fG.mo4923f(this);
            this.gO.onConfigCompleted(aR(), new ActionResult(ResultCode.TIMED_OUT, this.fT), new Hashtable());
        } else if (i == 3) {
            bg.m14912b(this, this.hV);
            this.hp = C4464b.RESULT_UNSUPPORTED;
            this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), ewVar.getEventID(), aU());
            this.fG.mo4923f(this);
            this.gO.onConfigCompleted(aR(), new ActionResult(ResultCode.UNSUPPORTED, this.fT), new Hashtable());
        }
    }

    protected void mo4820a(ew ewVar, int i) {
        super.mo4820a(ewVar, i);
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
            m14914g(i);
        } else if (ewVar instanceof fl) {
            C4566a dc = ((fl) ewVar).dc();
            this.hW = new ShineConnectionParameters(dc.lM, dc.lN, dc.lO);
            if (dc.result != (byte) 0) {
                m14914g(i);
            } else if (mo4834a(this.hW, this.hV)) {
                bg.m14913c(this, this.hV);
                this.hp = C4464b.RESULT_SUCCESS;
                this.fT = null;
                this.fG.mo4922e(this);
                Hashtable hashtable = new Hashtable();
                hashtable.put(ShineProperty.CONNECTION_PARAMETERS, this.hW);
                this.gO.onConfigCompleted(aR(), new ActionResult(ResultCode.SUCCEEDED, this.fT), hashtable);
            } else {
                m14914g(i);
            }
        }
    }

    protected boolean mo4834a(ShineConnectionParameters shineConnectionParameters, ShineConnectionParameters shineConnectionParameters2) {
        int floor = (int) Math.floor(shineConnectionParameters.getConnectionInterval() / 3.75d);
        int floor2 = (int) Math.floor(shineConnectionParameters2.getConnectionInterval() / 3.75d);
        int floor3 = (int) Math.floor((((double) shineConnectionParameters.getSupervisionTimeout()) * 1.0d) / 10.0d);
        floor3 = (int) Math.floor((((double) shineConnectionParameters2.getSupervisionTimeout()) * 1.0d) / 10.0d);
        Object obj = (this.hV.getConnectionInterval() <= 0.0d || this.hV.getConnectionInterval() > 25.0d || this.hW.getConnectionInterval() <= 0.0d || this.hW.getConnectionInterval() > 25.0d || this.hV.getConnectionLatency() != this.hW.getConnectionLatency()) ? null : 1;
        if ((floor != floor2 || this.hV.getConnectionLatency() != this.hW.getConnectionLatency()) && obj == null) {
            return false;
        }
        return true;
    }

    private void m14914g(int i) {
        if (this.hX >= 5) {
            bg.m14912b(this, this.hV);
            this.hp = C4464b.RESULT_REQUEST_ERROR;
            this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), this.ho.getEventID(), aU());
            this.fG.mo4923f(this);
            this.gO.onConfigCompleted(aR(), new ActionResult(ResultCode.FAILED, this.fT), new Hashtable());
            return;
        }
        ew bd = bd();
        if (bd == null) {
            bg.m14913c(this, this.hV);
            this.hp = C4464b.RESULT_SUCCESS;
            this.fT = null;
            this.fG.mo4922e(this);
            Hashtable hashtable = new Hashtable();
            hashtable.put(ShineProperty.CONNECTION_PARAMETERS, this.hW);
            this.gO.onConfigCompleted(aR(), new ActionResult(ResultCode.SUCCEEDED, this.fT), hashtable);
            return;
        }
        m14787c(bd);
        this.hX++;
    }

    private ew bd() {
        double connectionInterval = ((double) (((float) this.hX) * 3.75f)) + this.hV.getConnectionInterval();
        double d = (3.75d + connectionInterval) - 0.009999999776482582d;
        if (mo4834a(new ShineConnectionParameters(connectionInterval, this.hV.getConnectionLatency(), this.hV.getSupervisionTimeout()), this.hW)) {
            LogUtils.m15478k(TAG, "Already at requested connection parameters!");
            return null;
        }
        ew flVar = new fl();
        flVar.m15095a(connectionInterval, d, this.hV.getConnectionLatency(), this.hV.getSupervisionTimeout());
        return flVar;
    }

    public JSONObject aH() {
        JSONObject jSONObject;
        Throwable e;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("connectionInterval", this.hV.getConnectionInterval());
                jSONObject.put("connectionLatency", this.hV.getConnectionLatency());
                jSONObject.put("supervisionTimeout", this.hV.getSupervisionTimeout());
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
