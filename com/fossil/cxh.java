package com.fossil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.buttonservice.ButtonService;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.enums.ServiceActionResult;
import com.misfit.frameworks.buttonservice.model.Alarm;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.source.AlarmsRepository;
import java.util.ArrayList;
import java.util.List;

public class cxh extends ckb<C2476b, C2133c, C2475a> {
    private final gy cEa;
    private BroadcastReceiver cEe = new C24741(this);
    private final PortfolioApp cIo;
    private boolean cJG;
    private final AlarmsRepository cxw;

    class C24741 extends BroadcastReceiver {
        final /* synthetic */ cxh cKe;

        C24741(cxh com_fossil_cxh) {
            this.cKe = com_fossil_cxh;
        }

        public void onReceive(Context context, Intent intent) {
            if (CommunicateMode.values()[intent.getIntExtra(ButtonService.SERVICE_BLE_PHASE, CommunicateMode.IDLE.ordinal())] == CommunicateMode.SET_LIST_ALARM && this.cKe.cJG) {
                this.cKe.cJG = false;
                if (intent.getIntExtra(ButtonService.SERVICE_ACTION_RESULT, -1) == ServiceActionResult.SUCCEEDED.ordinal()) {
                    MFLogger.m12670d("SetAlarms", "onReceive success");
                    this.cKe.cxw.setAlarm(((C2476b) this.cKe.abq()).getAlarm(), null);
                    this.cKe.abr().onSuccess(new C2477c(((C2476b) this.cKe.abq()).getAlarm()));
                    return;
                }
                MFLogger.m12670d("SetAlarms", "onReceive failed");
                Alarm clone = ((C2476b) this.cKe.abq()).getAlarm().clone();
                Alarm findAlarm = this.cKe.cxw.findAlarm(((C2476b) this.cKe.abq()).getAlarm().getUri());
                if (findAlarm == null) {
                    clone.setActive(false);
                    this.cKe.cxw.setAlarm(clone, null);
                    this.cKe.m7845a(intent, clone);
                    return;
                }
                findAlarm.setSynced(true);
                this.cKe.m7845a(intent, findAlarm);
            }
        }
    }

    public static final class C2475a implements C2131a {
        private final Alarm cJI;
        private final int cJJ;
        private final ArrayList<Integer> cJK;

        public C2475a(Alarm alarm, int i, ArrayList<Integer> arrayList) {
            this.cJI = (Alarm) cco.m5996s(alarm, "alarm cannot be null!");
            this.cJJ = i;
            this.cJK = arrayList;
        }

        public Alarm getAlarm() {
            return this.cJI;
        }

        public ArrayList<Integer> ajf() {
            return this.cJK;
        }

        public int ajg() {
            return this.cJJ;
        }
    }

    public static final class C2476b implements C2132b {
        private final List<Alarm> cIW;
        private final Alarm cJI;
        private final String mDeviceId;

        public C2476b(String str, List<Alarm> list, Alarm alarm) {
            this.mDeviceId = (String) cco.m5996s(str, "deviceId cannot be null!");
            this.cIW = (List) cco.m5996s(list, "alarms cannot be null!");
            this.cJI = (Alarm) cco.m5996s(alarm, "alarm cannot be null!");
        }

        public String getDeviceId() {
            return this.mDeviceId;
        }

        public List<Alarm> aiX() {
            return this.cIW;
        }

        public Alarm getAlarm() {
            return this.cJI;
        }
    }

    public static final class C2477c implements C2133c {
        private final Alarm cJI;

        public C2477c(Alarm alarm) {
            this.cJI = alarm;
        }

        public Alarm getAlarm() {
            return this.cJI;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m7851a((C2476b) c2132b);
    }

    private void m7845a(Intent intent, Alarm alarm) {
        int intExtra = intent.getIntExtra(ButtonService.LAST_DEVICE_ERROR_STATE, -1);
        MFLogger.m12670d("SetAlarms", "processBLEErrorCodes() - errorCode = " + intExtra);
        ArrayList integerArrayListExtra = intent.getIntegerArrayListExtra(ButtonService.LIST_ERROR_STATE);
        if (integerArrayListExtra == null) {
            integerArrayListExtra = new ArrayList(intExtra);
        }
        abr().onError(new C2475a(alarm, intExtra, integerArrayListExtra));
    }

    cxh(PortfolioApp portfolioApp, gy gyVar, AlarmsRepository alarmsRepository) {
        this.cIo = portfolioApp;
        this.cEa = (gy) cco.m5996s(gyVar, "localBroadcastManager cannot be null!");
        this.cxw = (AlarmsRepository) cco.m5996s(alarmsRepository, "alarmsRepository cannot be null!");
    }

    protected void m7851a(C2476b c2476b) {
        MFLogger.m12670d("SetAlarms", "executeUseCase");
        this.cJG = true;
        Alarm alarm = c2476b.getAlarm();
        Alarm findAlarm = this.cxw.findAlarm(alarm.getUri());
        if (findAlarm == null || findAlarm.isActive() || alarm.isActive()) {
            m7850b(c2476b);
            return;
        }
        this.cxw.setAlarm(alarm, null);
        abr().onSuccess(new C2477c(alarm));
    }

    public void ajd() {
        this.cEa.m11537a(this.cEe, new IntentFilter(PortfolioApp.ZQ().getPackageName() + ButtonService.ACTION_SERVICE_BLE_RESPONSE));
    }

    public void aje() {
        this.cEa.unregisterReceiver(this.cEe);
    }

    private void m7850b(C2476b c2476b) {
        List arrayList = new ArrayList();
        for (Alarm alarm : c2476b.aiX()) {
            if (alarm.isActive()) {
                arrayList.add(alarm);
            }
        }
        this.cIo.m12696d(c2476b.getDeviceId(), arrayList);
    }
}
