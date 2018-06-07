package com.misfit.ble.obfuscated;

import android.os.Bundle;
import com.misfit.ble.obfuscated.ba.C4463a;
import com.misfit.ble.obfuscated.ba.C4464b;
import com.misfit.ble.shine.ShineActionID;
import com.misfit.ble.shine.ShineProfile.ActionResult;
import com.misfit.ble.shine.ShineProfile.ResultCode;
import com.misfit.ble.shine.ShineProfile.SyncCallback;
import com.misfit.ble.shine.error.ShineError;
import com.misfit.ble.shine.error.ShineError.Domain;
import com.misfit.ble.util.MutableBoolean;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class bo extends ba {
    protected volatile boolean hk = false;
    protected C4499b ij;
    protected C4498a ik;
    protected SyncCallback il;
    protected boolean im;
    protected boolean in;

    public interface C4498a {
        void mo4929a(bo boVar, byte[] bArr, Bundle bundle, MutableBoolean mutableBoolean, SyncCallback syncCallback);
    }

    public class C4499b {
        public short io;
        public short ip;
        public short iq;
        public long ir;
        final /* synthetic */ bo is;

        public C4499b(bo boVar) {
            this.is = boVar;
        }
    }

    public bo(C4463a c4463a, SyncCallback syncCallback, C4498a c4498a, boolean z, boolean z2) {
        super(ShineActionID.SYNC, "phaseSync", c4463a);
        this.il = syncCallback;
        this.ik = c4498a;
        this.im = z;
        this.in = z2;
    }

    public void start() {
        super.start();
        if (this.im && this.in) {
            m14963c(C4464b.RESULT_SUCCESS);
            return;
        }
        this.ij = new C4499b(this);
        m14787c(m14960a(de.class));
    }

    public void mo4821a(boolean z) {
        if (this.ho != null) {
            this.ho.cancel();
            this.ho = new ei();
        }
        m14963c(m14783b(z));
    }

    protected void mo4822b(ew ewVar, int i, ap apVar) {
        super.mo4822b(ewVar, i, apVar);
        if (i == 1) {
            m14963c(m14778a(apVar));
        } else if (i == 2) {
            m14963c(C4464b.RESULT_TIMED_OUT);
        } else if (i == 3) {
            m14963c(C4464b.RESULT_UNSUPPORTED);
        } else if ((ewVar instanceof cu) && this.hk) {
            this.hk = false;
            m14787c(m14960a(de.class));
        }
    }

    protected ew m14960a(Class<? extends ew> cls) {
        ew deVar;
        if (cls.equals(de.class)) {
            deVar = new de();
            deVar.ca();
            return deVar;
        } else if (cls.equals(da.class)) {
            deVar = new da(this);
            deVar.m15039c((short) ((this.ij.ip + 256) + 1));
            return deVar;
        } else if (cls.equals(cx.class)) {
            deVar = new cx();
            deVar.ca();
            return deVar;
        } else if (cls.equals(df.class)) {
            deVar = new df();
            deVar.m15048c((short) ((this.ij.ip + 256) + 1));
            return deVar;
        } else if (cls.equals(dc.class)) {
            deVar = new dc();
            deVar.ca();
            return deVar;
        } else if (cls.equals(cu.class)) {
            deVar = new cv();
            deVar.m15022c((short) ((this.ij.ip + 256) + 1));
            return deVar;
        } else if (!cls.equals(cp.class)) {
            return null;
        } else {
            deVar = new cp();
            deVar.ca();
            return deVar;
        }
    }

    protected void bl() {
        C4499b c4499b = this.ij;
        c4499b.ip = (short) (c4499b.ip + 1);
        if (this.ij.ip < this.ij.io) {
            m14787c(m14960a(da.class));
        } else if (this.in) {
            m14963c(C4464b.RESULT_SUCCESS);
        } else {
            m14787c(m14960a(cx.class));
        }
    }

    protected void m14963c(C4464b c4464b) {
        if (c4464b != C4464b.RESULT_SUCCESS) {
            m14787c(m14960a(cu.class));
            this.hp = c4464b;
            this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), this.ho.getEventID(), aU());
        } else {
            this.hp = c4464b;
            this.fT = null;
        }
        if (this.hp == C4464b.RESULT_SUCCESS) {
            this.fG.mo4922e(this);
            this.il.onSyncCompleted(new ActionResult(ResultCode.SUCCEEDED, this.fT));
        } else if (this.hp == C4464b.RESULT_INTERRUPTED || this.hp == C4464b.RESULT_CONNECTION_DROPPED) {
            this.fG.mo4923f(this);
            this.il.onSyncCompleted(new ActionResult(this.hp == C4464b.RESULT_INTERRUPTED ? ResultCode.INTERRUPTED : ResultCode.CONNECTION_DROPPED, this.fT));
        } else if (this.hp == C4464b.RESULT_TIMED_OUT) {
            this.fG.mo4923f(this);
            this.il.onSyncCompleted(new ActionResult(ResultCode.TIMED_OUT, this.fT));
        } else if (this.hp == C4464b.RESULT_UNSUPPORTED) {
            this.fG.mo4923f(this);
            this.il.onSyncCompleted(new ActionResult(ResultCode.UNSUPPORTED, this.fT));
        } else {
            this.fG.mo4923f(this);
            this.il.onSyncCompleted(new ActionResult(ResultCode.FAILED, this.fT));
        }
        this.fG.mo4916a((ba) this, 0);
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
                jSONObject.put("skipRead", this.im);
                jSONObject.put("skipErase", this.in);
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

    protected void aX() {
        m14963c(C4464b.RESULT_TIMED_OUT);
    }
}
