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

public class cwr extends ckb<C2451b, C2452c, C2450a> {
    private gy cEa;
    private BroadcastReceiver cEe = new C24491(this);
    private boolean cJG;
    private AlarmsRepository cxw;

    class C24491 extends BroadcastReceiver {
        final /* synthetic */ cwr cJH;

        C24491(cwr com_fossil_cwr) {
            this.cJH = com_fossil_cwr;
        }

        public void onReceive(Context context, Intent intent) {
            if (CommunicateMode.values()[intent.getIntExtra(ButtonService.SERVICE_BLE_PHASE, CommunicateMode.IDLE.ordinal())] == CommunicateMode.SET_LIST_ALARM && this.cJH.cJG) {
                this.cJH.cJG = false;
                MFLogger.m12670d("DeleteAlarm", "onReceive");
                Alarm alarm = ((C2451b) this.cJH.abq()).getAlarm();
                if (intent.getIntExtra(ButtonService.SERVICE_ACTION_RESULT, -1) == ServiceActionResult.SUCCEEDED.ordinal()) {
                    MFLogger.m12670d("DeleteAlarm", "onReceive success");
                    this.cJH.cxw.deleteAlarm(alarm, null);
                    this.cJH.abr().onSuccess(new C2452c(alarm));
                    return;
                }
                int intExtra = intent.getIntExtra(ButtonService.LAST_DEVICE_ERROR_STATE, -1);
                MFLogger.m12670d("DeleteAlarm", "onReceive error - errorCode = " + intExtra);
                ArrayList integerArrayListExtra = intent.getIntegerArrayListExtra(ButtonService.LIST_ERROR_STATE);
                if (integerArrayListExtra == null) {
                    integerArrayListExtra = new ArrayList(intExtra);
                }
                this.cJH.abr().onError(new C2450a(alarm, intExtra, integerArrayListExtra));
            }
        }
    }

    public static final class C2450a implements C2131a {
        private final Alarm cJI;
        private final int cJJ;
        private final ArrayList<Integer> cJK;

        public C2450a(Alarm alarm, int i, ArrayList<Integer> arrayList) {
            this.cJI = (Alarm) cco.m5996s(alarm, "alarm cannot be null!");
            this.cJJ = i;
            this.cJK = arrayList;
        }

        public ArrayList<Integer> ajf() {
            return this.cJK;
        }

        public int ajg() {
            return this.cJJ;
        }
    }

    public static final class C2451b implements C2132b {
        private final List<Alarm> cIW;
        private final Alarm cJI;
        private final String mDeviceId;

        public C2451b(String str, List<Alarm> list, Alarm alarm) {
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
            return this.cJI.clone();
        }
    }

    public static final class C2452c implements C2133c {
        private final Alarm cJI;

        public C2452c(Alarm alarm) {
            this.cJI = (Alarm) cco.m5996s(alarm, "alarm cannot be null!");
        }

        public Alarm getAlarm() {
            return this.cJI;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m7807a((C2451b) c2132b);
    }

    cwr(gy gyVar, AlarmsRepository alarmsRepository) {
        this.cEa = (gy) cco.m5996s(gyVar, "localBroadcastManager cannot be null!");
        this.cxw = (AlarmsRepository) cco.m5996s(alarmsRepository, "alarmsRepository cannot be null!");
    }

    protected void m7807a(C2451b c2451b) {
        MFLogger.m12670d("DeleteAlarm", "executeUseCase");
        this.cJG = true;
        Alarm alarm = c2451b.getAlarm();
        if (alarm.isActive()) {
            List arrayList = new ArrayList();
            for (Object obj : c2451b.aiX()) {
                Object obj2;
                Alarm findAlarm = this.cxw.findAlarm(obj2.getUri());
                if (!alarm.is(findAlarm)) {
                    if (findAlarm != null) {
                        findAlarm.update(obj2);
                        obj2 = findAlarm;
                    }
                    arrayList.add(obj2);
                }
            }
            m7803Y(arrayList);
            return;
        }
        this.cxw.deleteAlarm(alarm, null);
        abr().onSuccess(new C2452c(alarm));
    }

    public void ajd() {
        this.cEa.m11537a(this.cEe, new IntentFilter(PortfolioApp.ZQ().getPackageName() + ButtonService.ACTION_SERVICE_BLE_RESPONSE));
    }

    public void aje() {
        this.cEa.unregisterReceiver(this.cEe);
    }

    private void m7803Y(List<Alarm> list) {
        MFLogger.m12670d("DeleteAlarm", "setAlarms - alarms=" + list);
        List arrayList = new ArrayList();
        for (Alarm alarm : list) {
            if (alarm.isActive()) {
                arrayList.add(alarm);
            }
        }
        PortfolioApp.ZQ().m12696d(((C2451b) abq()).getDeviceId(), arrayList);
    }
}
