package com.misfit.ble.obfuscated;

import com.misfit.ble.obfuscated.ba.C4463a;
import com.misfit.ble.obfuscated.ba.C4464b;
import com.misfit.ble.obfuscated.ek.C4557a;
import com.misfit.ble.obfuscated.el.C4558a;
import com.misfit.ble.obfuscated.eo.C4560a;
import com.misfit.ble.obfuscated.ep.C4561a;
import com.misfit.ble.shine.ShineActionID;
import com.misfit.ble.shine.ShineProfile;
import com.misfit.ble.shine.ShineProfile.ActionResult;
import com.misfit.ble.shine.ShineProfile.DataTransferCallback;
import com.misfit.ble.shine.ShineProfile.ResultCode;
import com.misfit.ble.util.LogUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class az extends br {
    protected static final String TAG = LogUtils.m15475b(az.class);
    private String fa;
    private byte[] hd;
    private ShineProfile he;
    private long hf;
    private long hg;
    private long hh;
    private long hi;
    private int hj;
    private volatile boolean hk = false;
    private boolean hl;
    private volatile boolean hm = true;
    private long hn;

    public az(C4463a c4463a, DataTransferCallback dataTransferCallback, byte[] bArr, ShineProfile shineProfile, String str, boolean z) {
        super(ShineActionID.OTA, "phaseOTA", c4463a, dataTransferCallback);
        this.hd = bArr;
        this.he = shineProfile;
        this.fa = str;
        this.hl = z;
        this.hn = 6144;
        this.iz = (long) this.hd.length;
    }

    public void start() {
        m14787c(mo4827a(ej.class));
    }

    public void mo4821a(boolean z) {
        if (this.ho instanceof em) {
            bn();
        }
        super.mo4821a(z);
    }

    public void mo4828a(int i, int i2, int i3) {
        if (i == 0) {
            if (((long) this.hd.length) - this.hh > 0) {
                this.iA = (((long) i3) + this.hi) + this.hh;
                bm();
            }
            if (i3 >= i2) {
                if (!this.iC) {
                    m14822e(this.ho);
                }
                bn();
            }
        } else if (!(this.ho instanceof em)) {
            bn();
            m14820b(C4464b.RESULT_DATA_TRANSFER_FAILED);
        } else if (this.iy < 10) {
            this.hk = true;
            this.iy++;
            bn();
            m14787c(mo4827a(cv.class));
        } else {
            bn();
            m14820b(C4464b.RESULT_DATA_TRANSFER_FAILED);
        }
    }

    protected Class<? extends ew> aN() {
        return el.class;
    }

    protected void mo4822b(ew ewVar, int i, ap apVar) {
        super.mo4822b(ewVar, i, apVar);
        if (ar.m14766a(ewVar, this.he, this.fa)) {
            m14820b(C4464b.RESULT_SUCCESS);
        } else if (i == 1) {
            m14820b(m14778a(apVar));
        } else if (i == 2) {
            m14820b(C4464b.RESULT_TIMED_OUT);
        } else if (i == 3) {
            m14820b(C4464b.RESULT_UNSUPPORTED);
        } else if (ewVar instanceof en) {
            m14820b(C4464b.RESULT_SUCCESS);
        } else if ((ewVar instanceof cu) && this.hk) {
            this.hk = false;
            bo();
        }
    }

    protected void mo4820a(ew ewVar, int i) {
        super.mo4820a(ewVar, i);
        if (i == 1) {
            m14820b(C4464b.RESULT_RECEIVE_RESPONSE_FAILED);
        } else if (i == 2) {
            m14820b(C4464b.RESULT_TIMED_OUT);
        } else if (ewVar instanceof ej) {
            if (((ej) ewVar).cS().result != (byte) 0) {
                m14820b(C4464b.RESULT_REQUEST_ERROR);
            } else {
                m14787c(mo4827a(el.class));
            }
        } else if (ewVar instanceof el) {
            C4558a cU = ((el) ewVar).cU();
            if (cU.result == (byte) 0) {
                Class cls;
                this.hg = 0;
                this.hh = 0;
                this.hi = 0;
                if (this.hl && this.hm) {
                    this.hf = 0;
                } else {
                    this.hf = cU.mA;
                }
                if (this.hf > ((long) this.hd.length)) {
                    cls = em.class;
                } else if (this.hf <= 0) {
                    cls = em.class;
                } else if (this.hf == ((long) this.hd.length)) {
                    cls = eo.class;
                } else {
                    this.hg = this.hf;
                    cls = ep.class;
                }
                this.hm = true;
                m14787c(mo4827a(cls));
            } else if (cU.kT == (byte) 4) {
                this.hk = true;
                m14787c(mo4827a(cv.class));
            } else {
                m14820b(C4464b.RESULT_REQUEST_ERROR);
            }
        } else if (ewVar instanceof ep) {
            C4561a cZ = ((ep) ewVar).cZ();
            if (cZ.result != (byte) 0 && cZ.result != (byte) 3) {
                m14820b(C4464b.RESULT_REQUEST_ERROR);
            } else if (cZ.result == (byte) 3) {
                this.hg = Math.max(0, this.hg - this.hn);
                if (this.hg <= 0) {
                    this.hh = 0;
                    m14787c(mo4827a(em.class));
                    return;
                }
                m14787c(mo4827a(ep.class));
            } else {
                this.hh = this.hg;
                if (this.hf != this.hh) {
                    m14787c(mo4827a(ek.class));
                } else if (this.hh == ((long) this.hd.length)) {
                    m14787c(mo4827a(eo.class));
                } else {
                    m14787c(mo4827a(em.class));
                }
            }
        } else if (ewVar instanceof ek) {
            C4557a cT = ((ek) ewVar).cT();
            if (cT.result != (byte) 0) {
                m14820b(C4464b.RESULT_REQUEST_ERROR);
                return;
            }
            this.hf = cT.my;
            if (this.hh >= this.hf) {
                this.hh = this.hf;
                m14787c(mo4827a(em.class));
                return;
            }
            m14787c(mo4827a(ek.class));
        } else if (ewVar instanceof em) {
            em emVar = (em) ewVar;
            if (emVar.cV().result != (byte) 0) {
                bn();
                if (this.iy < 10) {
                    this.iy++;
                    bo();
                    return;
                }
                m14820b(C4464b.RESULT_REQUEST_ERROR);
            } else if (emVar.mC) {
                bt.bu();
                this.hi += emVar.cX();
                if (this.hh + this.hi >= ((long) this.hd.length)) {
                    this.hi = 0;
                    m14787c(mo4827a(eo.class));
                    return;
                }
                m14787c(mo4827a(em.class));
            } else {
                byte[] bArr;
                long cW = emVar.cW();
                long cX = emVar.cX();
                if (cW == 0 && cX == ((long) this.hd.length)) {
                    bArr = this.hd;
                } else {
                    bArr = Arrays.copyOfRange(this.hd, hb.m15168g(cW), Math.min(this.hd.length, hb.m15168g(cW + cX)));
                }
                m14817a(new ck(bArr));
            }
        } else if (ewVar instanceof eo) {
            C4560a cY = ((eo) ewVar).cY();
            if (cY.result != (byte) 0 && cY.kT != (byte) 5) {
                m14820b(C4464b.RESULT_REQUEST_ERROR);
            } else if (cY.kT != (byte) 5) {
                m14787c(mo4827a(en.class));
            } else if (this.hj < 2) {
                this.hj++;
                int length = this.hd.length;
                this.hf = (long) length;
                this.hg = ((long) length) - (((long) length) % this.hn);
                m14787c(mo4827a(ep.class));
            } else {
                m14820b(C4464b.RESULT_RECEIVE_RESPONSE_FAILED);
            }
        }
    }

    protected ew mo4827a(Class<? extends ew> cls) {
        ew ejVar;
        if (cls.equals(ej.class)) {
            ejVar = new ej();
            ejVar.ca();
            return ejVar;
        } else if (cls.equals(em.class)) {
            r2 = this.hh + this.hi;
            long min = Math.min(this.hn, ((long) this.hd.length) - r2);
            ejVar = new em();
            ejVar.m15069a((short) 23131, r2, min, (long) this.hd.length);
            return ejVar;
        } else if (cls.equals(eo.class)) {
            ejVar = new eo();
            ejVar.ca();
            return ejVar;
        } else if (cls.equals(en.class)) {
            ejVar = new en();
            ejVar.ca();
            return ejVar;
        } else if (cls.equals(el.class)) {
            ejVar = new el();
            ejVar.ca();
            return ejVar;
        } else if (cls.equals(ek.class)) {
            r2 = Math.max(0, this.hf - 4);
            ejVar = new ek();
            ejVar.m15064f(r2);
            return ejVar;
        } else if (cls.equals(ep.class)) {
            ejVar = new ep();
            ejVar.m15071a(this.hd, 0, this.hg, (long) this.hd.length);
            return ejVar;
        } else if (!cls.equals(cv.class)) {
            return null;
        } else {
            ejVar = new cv();
            ejVar.m15022c((short) 23131);
            return ejVar;
        }
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
                jSONObject.put("skipResume", this.hl);
                jSONObject.put("firmwareSize", this.iz);
                jSONObject.put("firmwareChecksum", hd.m15175G(this.hd));
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

    protected Class<? extends ew> aO() {
        return cv.class;
    }

    protected void aP() {
        this.fG.mo4924g(this);
        this.iw.onDataTransferCompleted(aR(), new ActionResult(ResultCode.SUCCEEDED, this.fT));
    }

    protected void aQ() {
        if (this.iC && (this.hp == C4464b.RESULT_DATA_TRANSFER_FAILED || this.hp == C4464b.RESULT_TIMED_OUT)) {
            bt.bt();
        }
        this.iw.onDataTransferCompleted(aR(), new ActionResult(ResultCode.FAILED, this.fT));
    }
}
