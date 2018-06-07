package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.buttonservice.model.Alarm;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.source.AlarmsDataSource.LoadAlarmsCallback;
import com.portfolio.platform.data.source.AlarmsRepository;
import java.util.List;

public class cwt extends ckb<C2132b, C2454a, C2131a> {
    private AlarmsRepository cxw;

    class C24531 implements LoadAlarmsCallback {
        final /* synthetic */ cwt cJM;

        C24531(cwt com_fossil_cwt) {
            this.cJM = com_fossil_cwt;
        }

        public void onAlarmsLoaded(List<Alarm> list) {
            this.cJM.abr().onSuccess(new C2454a(this.cJM, list));
        }

        public void onDataNotAvailable() {
            this.cJM.abr().onError(null);
        }
    }

    public final class C2454a implements C2133c {
        private final List<Alarm> cIW;
        final /* synthetic */ cwt cJM;

        public C2454a(cwt com_fossil_cwt, List<Alarm> list) {
            this.cJM = com_fossil_cwt;
            this.cIW = list;
        }

        public List<Alarm> aiX() {
            return this.cIW;
        }
    }

    cwt(AlarmsRepository alarmsRepository) {
        this.cxw = (AlarmsRepository) cco.m5996s(alarmsRepository, "alarmsRepository cannot be null!");
    }

    protected void mo2022b(C2132b c2132b) {
        MFLogger.m12670d("GetAlarms", "executeUseCase");
        this.cxw.getAlarms(new C24531(this));
    }
}
