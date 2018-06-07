package com.misfit.ble.obfuscated;

import com.misfit.ble.obfuscated.ba.C4463a;
import com.misfit.ble.obfuscated.ba.C4464b;
import com.misfit.ble.obfuscated.gf.C4571a;
import com.misfit.ble.obfuscated.gg.C4572a;
import com.misfit.ble.setting.uapp.UAppSystemVersion;
import com.misfit.ble.shine.ActionID;
import com.misfit.ble.shine.ShineProfile.ActionResult;
import com.misfit.ble.shine.ShineProfile.DataTransferCallback;
import com.misfit.ble.shine.ShineProfile.ResultCode;
import com.misfit.ble.util.LogUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class bs extends br {
    private static final String TAG = LogUtils.m15475b(bs.class);
    protected UAppSystemVersion bM;
    protected List<byte[]> iJ;
    protected int iK;
    protected byte[] iL;
    protected long iM;
    protected long iN;
    protected int iO;
    protected boolean iP;
    protected boolean iQ = true;
    protected short f1530if;

    public bs(ActionID actionID, String str, C4463a c4463a, DataTransferCallback dataTransferCallback, UAppSystemVersion uAppSystemVersion) {
        super(actionID, str, c4463a, dataTransferCallback);
        this.bM = uAppSystemVersion;
    }

    protected void m14907a(short s, List<byte[]> list) {
        this.f1530if = s;
        this.iJ = list;
        this.iK = -1;
        this.iN = 0;
        this.iM = 0;
        for (byte[] length : list) {
            this.iz += (long) length.length;
        }
    }

    public void start() {
        bq();
    }

    public void mo4821a(boolean z) {
        if (this.ho instanceof gg) {
            bn();
        }
        super.mo4821a(z);
    }

    public void mo4828a(int i, int i2, int i3) {
        if (i == 0) {
            this.iN = (long) ((this.iL.length - i2) + i3);
            this.iA = this.iM + this.iN;
            bm();
            if (i3 >= i2) {
                if (!this.iC) {
                    m14822e(this.ho);
                }
                bn();
            }
        } else if (!(this.ho instanceof gg)) {
            bn();
            m14820b(C4464b.RESULT_DATA_TRANSFER_FAILED);
        } else if (this.iy < 10) {
            this.iy++;
            bn();
            bo();
        } else {
            bn();
            m14820b(C4464b.RESULT_DATA_TRANSFER_FAILED);
        }
    }

    protected void mo4822b(ew ewVar, int i, ap apVar) {
        super.mo4822b(ewVar, i, apVar);
        if (i == 1) {
            m14820b(m14778a(apVar));
        } else if (i == 2) {
            m14820b(C4464b.RESULT_TIMED_OUT);
        } else if (i == 3) {
            m14820b(C4464b.RESULT_UNSUPPORTED);
        }
    }

    protected void mo4820a(ew ewVar, int i) {
        super.mo4820a(ewVar, i);
        if (i == 1) {
            m14820b(C4464b.RESULT_RECEIVE_RESPONSE_FAILED);
        } else if (i == 2) {
            m14820b(C4464b.RESULT_TIMED_OUT);
        } else if (ewVar instanceof gf) {
            C4571a de = ((gf) ewVar).de();
            if (de.result != (byte) 0 || this.f1530if == de.le) {
                this.iN = de.mA + de.nr;
            } else {
                this.iN = 0;
            }
            m14787c(mo4827a(gg.class));
        } else if (ewVar instanceof gg) {
            gg ggVar = (gg) ewVar;
            C4572a df = ggVar.df();
            if (df.result != (byte) 0) {
                if (this.iO < 3) {
                    this.iN = 0;
                    this.iP = true;
                    this.iO++;
                    bn();
                    m14787c(mo4827a(ge.class));
                    return;
                }
                bn();
                m14820b(C4464b.RESULT_REQUEST_ERROR);
            } else if (ggVar.mC) {
                this.iN = df.nu + ggVar.cW();
                bq();
            } else {
                m14817a(new cj(this.iL));
            }
        } else if ((ewVar instanceof ge) && ((ge) ewVar).dd().result == (byte) 0 && this.iP) {
            this.iP = false;
            m14787c(mo4827a(gg.class));
        }
    }

    private void bq() {
        this.iM += this.iN;
        this.iN = 0;
        this.iO = 0;
        this.iy = 0;
        this.iK++;
        if (this.iK >= this.iJ.size()) {
            m14820b(C4464b.RESULT_SUCCESS);
            return;
        }
        this.iL = (byte[]) this.iJ.get(this.iK);
        if (this.iL == null) {
            bq();
            return;
        }
        ew a;
        if (this.iK == 0 && this.iQ) {
            a = mo4827a(gf.class);
        } else {
            a = mo4827a(gg.class);
        }
        m14787c(a);
    }

    protected Class<? extends ew> aN() {
        return gf.class;
    }

    protected ew mo4827a(Class<? extends ew> cls) {
        ew ggVar;
        if (cls.equals(gg.class)) {
            ggVar = new gg();
            ggVar.m15135a(this.f1530if, this.iN, ((long) this.iL.length) - this.iN, (long) this.iL.length);
            return ggVar;
        } else if (cls.equals(gf.class)) {
            ggVar = new gf();
            ggVar.m15132c(this.f1530if);
            return ggVar;
        } else if (!cls.equals(ge.class)) {
            return null;
        } else {
            ggVar = new ge();
            ggVar.ca();
            return ggVar;
        }
    }

    public Set<String> aI() {
        return new HashSet(Arrays.asList(new String[]{"3dda0007-957f-7d4a-34a6-74696673696d"}));
    }

    public JSONObject aH() {
        JSONObject jSONObject;
        Throwable e;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("uAppSystemVersion", this.bM == null ? null : this.bM.toJSONObject());
                jSONObject.put("fileHandle", hb.m15164d(this.f1530if));
                jSONObject.put("numberOfPages", this.iJ == null ? 0 : this.iJ.size());
            } catch (JSONException e2) {
                e = e2;
                C4462b.m14831a(e, "");
                return jSONObject;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            jSONObject = jSONObject2;
            e = th;
            C4462b.m14831a(e, "");
            return jSONObject;
        }
        return jSONObject;
    }

    protected Class<? extends ew> aO() {
        return ge.class;
    }

    protected void aP() {
        this.iw.onDataTransferCompleted(aR(), new ActionResult(ResultCode.SUCCEEDED, this.fT));
    }

    protected void aQ() {
        this.iw.onDataTransferCompleted(aR(), new ActionResult(ResultCode.FAILED, this.fT));
    }
}
