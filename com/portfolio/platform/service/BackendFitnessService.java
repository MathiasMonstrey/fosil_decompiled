package com.portfolio.platform.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.fossil.cfj;
import com.fossil.cmq;
import com.fossil.cmt;
import com.fossil.cmv;
import com.fossil.cnq;
import com.fossil.cpf;
import com.fossil.cro;
import com.fossil.crp;
import com.fossil.crs;
import com.fossil.crt;
import com.fossil.gy;
import com.fossil.wearables.fsl.fitness.SampleDay;
import com.fossil.wearables.fsl.fitness.SampleRaw;
import com.fossil.wearables.fsl.goaltracking.GoalPhase;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.FailedDownloadRequest;
import com.portfolio.platform.data.model.PinObject;
import com.portfolio.platform.response.fitness.MFActivityStatisticRespond;
import com.portfolio.platform.response.fitness.MFSampleDayResponse;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BackendFitnessService extends IntentService {
    private static final String TAG = BackendFitnessService.class.getSimpleName();

    class C49082 implements MFServerResultCallback {
        final /* synthetic */ BackendFitnessService cCw;

        C49082(BackendFitnessService backendFitnessService) {
            this.cCw = backendFitnessService;
        }

        public void onSuccess(MFResponse mFResponse) {
            MFSampleDayResponse mFSampleDayResponse = (MFSampleDayResponse) mFResponse;
            if (mFSampleDayResponse != null) {
                SampleDay b = cmt.abK().b(mFSampleDayResponse.getSampleDayData());
                if (!cmt.abK().a(mFSampleDayResponse.getSampleDayData())) {
                    cmt.abK().a(b);
                }
            }
        }

        public void onFail(int i, MFResponse mFResponse) {
        }
    }

    class C49093 implements MFServerResultCallback {
        final /* synthetic */ BackendFitnessService cCw;

        C49093(BackendFitnessService backendFitnessService) {
            this.cCw = backendFitnessService;
        }

        public void onSuccess(MFResponse mFResponse) {
            MFActivityStatisticRespond mFActivityStatisticRespond = (MFActivityStatisticRespond) mFResponse;
            double d = 0.0d;
            if (mFActivityStatisticRespond != null) {
                d = mFActivityStatisticRespond.getBestDaySteps();
                float avgSteps = (float) mFActivityStatisticRespond.getAvgSteps();
            }
            Intent intent = new Intent("action.upload.synced.sampeRaw.finished");
            intent.putExtra("steps", d);
            gy.p(PortfolioApp.ZQ()).b(intent);
        }

        public void onFail(int i, MFResponse mFResponse) {
        }
    }

    class C4912a {
        final /* synthetic */ BackendFitnessService cCw;
        private Object cCx;
        private int cCy;
        private boolean cwY;

        private C4912a(BackendFitnessService backendFitnessService) {
            this.cCw = backendFitnessService;
            this.cCx = new Object();
            this.cCy = 0;
        }

        public int aeX() {
            return this.cCy;
        }

        public boolean m15649b(final SampleRaw sampleRaw) throws Exception {
            synchronized (this.cCx) {
                new Handler(this.cCw.getMainLooper()).postDelayed(new Runnable(this) {
                    final /* synthetic */ C4912a cCz;

                    class C49101 implements MFServerResultCallback {
                        final /* synthetic */ C49111 cCA;

                        C49101(C49111 c49111) {
                            this.cCA = c49111;
                        }

                        public void onSuccess(MFResponse mFResponse) {
                            this.cCA.cCz.cwY = true;
                            synchronized (this.cCA.cCz.cCx) {
                                this.cCA.cCz.cCx.notify();
                            }
                        }

                        public void onFail(int i, MFResponse mFResponse) {
                            MFLogger.e(BackendFitnessService.TAG, "Error while uploading SampleRaw - code=" + i + ", response=" + mFResponse);
                            this.cCA.cCz.cwY = false;
                            this.cCA.cCz.cCy = i;
                            synchronized (this.cCA.cCz.cCx) {
                                this.cCA.cCz.cCx.notify();
                            }
                        }
                    }

                    public void run() {
                        MFLogger.d(BackendFitnessService.TAG, "Uploading SampleRaw=" + sampleRaw);
                        MFNetwork.getInstance(this.cCz.cCw).execute(new crt(this.cCz.cCw, sampleRaw), new C49101(this));
                    }
                }, 100);
                this.cCx.wait();
            }
            return this.cwY;
        }
    }

    public static void m15653c(Context context, Bundle bundle) {
    }

    public static void m15650H(Context context, int i) {
        Intent intent = new Intent(context, BackendFitnessService.class);
        intent.setAction("com.portfolio.service.action.fitness.goal.pdate");
        intent.putExtra("com.portfolio.service.extra.Sample", i);
        context.startService(intent);
    }

    public static void bC(Context context) {
        Intent intent = new Intent(context, BackendFitnessService.class);
        intent.setAction("com.portfolio.service.action.fitness.statistic");
        context.startService(intent);
    }

    public BackendFitnessService() {
        super(TAG);
    }

    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if ("com.portfolio.service.action.fitness.upload".equals(action)) {
                m15655h(intent.getStringArrayListExtra("com.portfolio.service.extra.Sample"));
            } else if ("com.portfolio.service.action.fitness.statistic".equals(action)) {
                aeW();
            } else if ("com.portfolio.service.action.fitness.goal.pdate".equals(action)) {
                m15654c(Integer.valueOf(intent.getIntExtra("com.portfolio.service.extra.Sample", -1)));
            } else if ("com.portfolio.service.action.fitness.SampleDayMissingDownload".equals(action)) {
                m15651H(null);
            } else if ("com.portfolio.service.action.fitness.SampleRawMissingDownload".equals(action)) {
                m15652I(null);
            }
        }
    }

    private void m15655h(ArrayList<String> arrayList) {
        int i = 0;
        long currentTimeMillis = System.currentTimeMillis();
        MFLogger.d(TAG, "handleActionUpload method is called : " + currentTimeMillis);
        if (!(arrayList == null || arrayList.size() == 0)) {
            for (SampleRaw sampleRaw : cmt.abK().getSampleRawsByIds(arrayList)) {
                try {
                    cnq.acd().acq().a(new PinObject("FitnessSample", sampleRaw));
                } catch (Exception e) {
                    MFLogger.e(TAG, "Failed to pin raw: " + sampleRaw.getUri());
                    MFLogger.e(TAG, "ParseException: " + e);
                }
            }
        }
        List hu = cnq.acd().acq().hu("FitnessSample");
        Set hashSet = new HashSet();
        int size = hu.size();
        int i2 = 0;
        while (i2 < size) {
            int i3;
            try {
                PinObject pinObject = (PinObject) hu.get(i2);
                SampleRaw sampleRaw2 = (SampleRaw) new cfj().c(pinObject.getJsonData(), SampleRaw.class);
                C4912a c4912a = new C4912a();
                if (c4912a.m15649b(sampleRaw2)) {
                    hashSet.add(cmq.a(sampleRaw2.getStartTime()));
                    cnq.acd().acq().b(pinObject);
                    i3 = i;
                } else {
                    int aeX = c4912a.aeX();
                    if (aeX == MFNetworkReturnCode.ITEM_NAME_IN_USED || aeX == MFNetworkReturnCode.BAD_REQUEST || aeX == 404) {
                        cnq.acd().acq().b(pinObject);
                    }
                    i3 = i + 1;
                }
            } catch (Exception e2) {
                i3 = i;
            }
            i2++;
            i = i3;
        }
        if (size > 0) {
            aeW();
            if (i == 0) {
                m15656i(hashSet);
            }
        }
        MFLogger.d(TAG, "handleActionUpload method is done : " + currentTimeMillis);
    }

    private void m15654c(Integer num) {
        MFLogger.d(TAG, "handleActionUpload method is called : " + System.currentTimeMillis());
        cpf acq = cnq.acd().acq();
        if (num.intValue() > 0) {
            try {
                for (PinObject b : acq.hu("FitnessGoal")) {
                    final PinObject b2;
                    acq.b(b2);
                }
                acq.a(new PinObject("FitnessGoal", num));
            } catch (Exception e) {
                MFLogger.e(TAG, "Failed to pin step goal: " + num);
                MFLogger.e(TAG, "ParseException: " + e);
            }
        }
        List hu = acq.hu("FitnessGoal");
        int size = hu.size();
        for (int i = 0; i < size; i++) {
            try {
                b2 = (PinObject) hu.get(i);
                MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new crs(PortfolioApp.ZQ(), ((Integer) new cfj().c(b2.getJsonData(), Integer.class)).intValue()), new MFServerResultCallback(this) {
                    final /* synthetic */ BackendFitnessService cCw;

                    public void onSuccess(MFResponse mFResponse) {
                        cnq.acd().acq().b(b2);
                    }

                    public void onFail(int i, MFResponse mFResponse) {
                        if (i == MFNetworkReturnCode.ITEM_NAME_IN_USED || i == MFNetworkReturnCode.BAD_REQUEST || i == 404) {
                            cnq.acd().acq().b(b2);
                        }
                    }
                });
            } catch (Exception e2) {
            }
        }
        MFLogger.d(TAG, "handleActionStepGoalUpload method is done : " + System.currentTimeMillis());
    }

    private void m15656i(Set<String> set) {
        for (String com_fossil_crp : set) {
            MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new crp(PortfolioApp.ZQ(), com_fossil_crp), new C49082(this));
        }
    }

    private void aeW() {
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cro(PortfolioApp.ZQ()), new C49093(this));
    }

    private void m15651H(Bundle bundle) {
        MFLogger.d(TAG, "Begin download");
        if (bundle == null) {
            cpf acq = cnq.acd().acq();
            List<PinObject> hu = acq.hu("FitnessDayMissing");
            cfj com_fossil_cfj = new cfj();
            List arrayList = new ArrayList();
            if (hu.size() > 0) {
                for (PinObject pinObject : hu) {
                    arrayList.add((FailedDownloadRequest) com_fossil_cfj.c(pinObject.getJsonData(), FailedDownloadRequest.class));
                    acq.b(pinObject);
                }
                for (FailedDownloadRequest failedDownloadRequest : cmv.Q(arrayList)) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(GoalPhase.COLUMN_START_DATE, failedDownloadRequest.getFrom());
                    bundle2.putString(GoalPhase.COLUMN_END_DATE, failedDownloadRequest.getTo());
                }
            }
        }
    }

    private void m15652I(Bundle bundle) {
        MFLogger.d(TAG, "Begin download");
        if (bundle == null) {
            cpf acq = cnq.acd().acq();
            List<PinObject> hu = acq.hu("FitnessSampleMissing");
            cfj com_fossil_cfj = new cfj();
            List arrayList = new ArrayList();
            if (hu.size() > 0) {
                for (PinObject pinObject : hu) {
                    arrayList.add((FailedDownloadRequest) com_fossil_cfj.c(pinObject.getJsonData(), FailedDownloadRequest.class));
                    acq.b(pinObject);
                }
                for (FailedDownloadRequest failedDownloadRequest : cmv.Q(arrayList)) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(GoalPhase.COLUMN_START_DATE, failedDownloadRequest.getFrom());
                    bundle2.putString(GoalPhase.COLUMN_END_DATE, failedDownloadRequest.getTo());
                }
            }
        }
    }
}
