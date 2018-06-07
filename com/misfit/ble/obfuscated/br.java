package com.misfit.ble.obfuscated;

import com.misfit.ble.obfuscated.ba.C4463a;
import com.misfit.ble.obfuscated.ba.C4464b;
import com.misfit.ble.shine.ActionID;
import com.misfit.ble.shine.ShineProfile.DataTransferCallback;
import com.misfit.ble.shine.error.ShineError;
import com.misfit.ble.shine.error.ShineError.Domain;
import com.misfit.ble.util.LogUtils;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class br extends ba {
    protected static final String TAG = LogUtils.m15475b(br.class);
    protected long iA = 0;
    protected float iB = 0.0f;
    protected boolean iC = bt.bs();
    private C4502b iD;
    protected C4501a iE;
    protected DataTransferCallback iw;
    protected ScheduledExecutorService ix;
    protected int iy = 0;
    protected long iz = 0;

    public class C4501a implements Runnable {
        final /* synthetic */ br iG;
        private boolean iH = true;
        private ew iI;

        public C4501a(br brVar, ew ewVar) {
            this.iG = brVar;
            this.iI = ewVar;
        }

        public void invalidate() {
            this.iH = false;
        }

        public void run() {
            if (this.iH) {
                this.iG.m14823f(this.iI);
            }
        }
    }

    public class C4502b implements Runnable {
        final /* synthetic */ br iG;
        private boolean iH = true;
        private ew iI;

        public C4502b(br brVar, ew ewVar) {
            this.iG = brVar;
            this.iI = ewVar;
        }

        public void invalidate() {
            this.iH = false;
        }

        public void run() {
            if (this.iH) {
                this.iG.m14821d(this.iI);
            }
        }
    }

    protected abstract ew mo4827a(Class<? extends ew> cls);

    protected abstract Class<? extends ew> aO();

    protected abstract void aP();

    protected abstract void aQ();

    protected br(ActionID actionID, String str, C4463a c4463a, DataTransferCallback dataTransferCallback) {
        super(actionID, str, c4463a);
        this.iw = dataTransferCallback;
    }

    public void mo4821a(boolean z) {
        if (this.ho != null) {
            this.ho.cancel();
            this.ho = new ei();
        }
        m14820b(m14783b(z));
    }

    protected void bm() {
        if (this.iw != null) {
            float min = Math.min((((float) this.iA) * 1.0f) / ((float) this.iz), 1.0f);
            if (Math.abs(this.iB - min) > 0.001f || this.iA >= this.iz) {
                this.iB = min;
                this.iw.onDataTransferProgressChanged(aR(), min);
            }
        }
    }

    protected void m14820b(C4464b c4464b) {
        this.hp = c4464b;
        if (this.hp != C4464b.RESULT_SUCCESS) {
            this.fT = new ShineError(Domain.PHASE_ACTION_ERROR, aR(), this.ho.getEventID(), aU());
            ew a = mo4827a(aO());
            if (a != null) {
                m14787c(a);
            }
            if (this.hp == C4464b.RESULT_UNKNOWN) {
                LogUtils.m15477e(TAG, "onPhaseControllerFinish - UNKNOWN RESULT CODE");
            }
            this.fG.mo4923f(this);
            aQ();
            return;
        }
        this.fT = null;
        this.fG.mo4922e(this);
        aP();
    }

    protected void m14817a(ci ciVar) throws IllegalArgumentException {
        if (ciVar == null) {
            throw new IllegalArgumentException("dataProtocol must not be null!");
        } else if (this.iC) {
            m14818a(this.ho, ((long) (((double) (4.0f + ((1.0f * ((float) ciVar.bS())) / ((float) ciVar.bU())))) * 48.5d)) + ba());
            this.fG.mo4917a((ba) this, ciVar);
        } else {
            this.fG.mo4919b(this, ciVar);
        }
    }

    protected long ba() {
        return 5000;
    }

    protected void bn() {
        if (this.iC) {
            this.fG.mo4920c(this);
        } else {
            this.fG.mo4921d(this);
        }
    }

    protected void m14818a(ew ewVar, long j) {
        if (this.iD != null) {
            this.iD.invalidate();
            this.iD = null;
        }
        this.iD = new C4502b(this, ewVar);
        hd.m15181do().postDelayed(this.iD, j);
    }

    protected void m14821d(ew ewVar) {
        if (!(this.ho instanceof ei) && this.ho.equals(ewVar) && this.ho.isWaitingForResponse() && this.hp == C4464b.RESULT_UNKNOWN) {
            LogUtils.m15479l(TAG, "onRequestTimeoutTimerFired");
            if (bf()) {
                this.iy++;
                bo();
                return;
            }
            m14820b(C4464b.RESULT_TIMED_OUT);
        }
    }

    protected void bo() {
        if (this.ix == null) {
            this.ix = Executors.newSingleThreadScheduledExecutor();
        }
        final ew a = mo4827a(aN());
        if (a != null) {
            this.ix.schedule(new Runnable(this) {
                final /* synthetic */ br iG;

                public void run() {
                    this.iG.m14787c(a);
                }
            }, bp(), TimeUnit.MILLISECONDS);
        }
    }

    protected void m14822e(ew ewVar) {
        if (this.iE != null) {
            this.iE.invalidate();
            this.iE = null;
        }
        this.iE = new C4501a(this, ewVar);
        hd.m15181do().postDelayed(this.iE, 5000);
    }

    protected void m14823f(ew ewVar) {
        if (!(this.ho instanceof ei) && this.ho.equals(ewVar) && this.ho.isWaitingForResponse() && this.hp == C4464b.RESULT_UNKNOWN) {
            LogUtils.m15479l(TAG, "onEOFTimeoutTimerFired");
            if (bf()) {
                this.iy++;
                bo();
                return;
            }
            m14820b(C4464b.RESULT_TIMED_OUT);
        }
    }

    protected Class<? extends ew> aN() {
        return null;
    }

    protected long bp() {
        return 1000;
    }

    protected boolean bf() {
        return this.iy < 10;
    }
}
