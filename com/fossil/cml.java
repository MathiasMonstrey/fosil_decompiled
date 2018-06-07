package com.fossil;

import android.content.Intent;
import com.fossil.wearables.fsl.fitness.SampleRaw;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.buddychallenge.BCChallenge;
import com.portfolio.platform.data.model.buddychallenge.BCHeartbeatStep;
import com.portfolio.platform.data.model.buddychallenge.BCPlayer;
import com.portfolio.platform.data.source.ActivitiesRepository;
import com.portfolio.platform.response.buddychallenge.MFUpdateBCAccountInfoResponse;
import com.portfolio.platform.response.buddychallenge.MFUpdateChallengeResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class cml {
    private static final String TAG = cml.class.getSimpleName();
    private static cml cxH;
    cnr cmQ;
    ActivitiesRepository cxG;
    cnq mProviderManager;

    class C21982 implements MFServerResultCallback {
        final /* synthetic */ cml cxJ;

        C21982(cml com_fossil_cml) {
            this.cxJ = com_fossil_cml;
        }

        public void onSuccess(MFResponse mFResponse) {
            MFLogger.m12670d(cml.TAG, "updateBCPlayerInfo onSuccess");
            this.cxJ.m7095a(((MFUpdateBCAccountInfoResponse) mFResponse).getBuddyChallengeAccount());
        }

        public void onFail(int i, MFResponse mFResponse) {
            MFLogger.m12670d(cml.TAG, "updateBCPlayerInfo onFailed");
        }
    }

    public static synchronized cml abG() {
        cml com_fossil_cml;
        synchronized (cml.class) {
            if (cxH == null) {
                cxH = new cml();
            }
            com_fossil_cml = cxH;
        }
        return com_fossil_cml;
    }

    private cml() {
        PortfolioApp.ZQ().aam().mo1827a(this);
    }

    public void m7096a(BCHeartbeatStep bCHeartbeatStep) {
        if (clw.cwB.booleanValue()) {
            MFLogger.m12670d(TAG, "saveHeartbeat:  heartbeatStep = " + bCHeartbeatStep);
            if (bCHeartbeatStep != null) {
                cog acw = this.mProviderManager.acw();
                Object obj = null;
                for (BCChallenge bCChallenge : acw.adK()) {
                    Object obj2;
                    long lastHeartbeatStamp = bCHeartbeatStep.getLastHeartbeatStamp();
                    long gp = cnf.gp(bCChallenge.getStartTime());
                    long gp2 = cnf.gp(bCChallenge.getEndTime());
                    long gp3 = cnf.gp(bCChallenge.getCloseTime());
                    if (lastHeartbeatStamp >= gp && lastHeartbeatStamp <= gp3) {
                        Date date;
                        List<SampleRaw> activityList;
                        List arrayList = new ArrayList();
                        gp3 = 0;
                        while (!cmq.m7122e(gp, Math.min(gp2, lastHeartbeatStamp))) {
                            date = new Date(gp);
                            activityList = this.cxG.getActivityList(cmq.getStartOfDay(date), cmq.getEndOfDay(date));
                            double d = 0.0d;
                            if (!(activityList == null || activityList.isEmpty())) {
                                long j = gp3;
                                double d2 = 0.0d;
                                for (SampleRaw sampleRaw : activityList) {
                                    d2 += sampleRaw.getSteps();
                                    j = Math.max(sampleRaw.getEndTime().getTime(), j);
                                }
                                double d3 = d2;
                                gp3 = j;
                                d = d3;
                            }
                            arrayList.add(Integer.valueOf((int) d));
                            gp += TimeUnit.DAYS.toMillis(1);
                        }
                        if (lastHeartbeatStamp <= gp2) {
                            BCHeartbeatStep aH = acw.aH(bCHeartbeatStep.getLastHeartbeatStamp());
                            if (obj == null) {
                                if (aH != null) {
                                    aH.updateHeartbeat(bCHeartbeatStep);
                                    acw.mo1922a(aH);
                                } else {
                                    acw.mo1922a(bCHeartbeatStep);
                                }
                                obj = 1;
                            }
                            if (aH != null) {
                                arrayList.add(Integer.valueOf(aH.getHeartbeatSteps()));
                                m7094a(bCChallenge, arrayList, aH.getLastHeartbeatStamp());
                            } else {
                                arrayList.add(Integer.valueOf(bCHeartbeatStep.getHeartbeatSteps()));
                                m7094a(bCChallenge, arrayList, bCHeartbeatStep.getLastHeartbeatStamp());
                            }
                            obj2 = obj;
                            obj = obj2;
                        } else {
                            date = new Date(gp2);
                            Date endOfDay = cmq.getEndOfDay(date);
                            activityList = this.cxG.getActivityList(cmq.getStartOfDay(date), endOfDay);
                            if (!(activityList == null || activityList.isEmpty())) {
                                double d4 = 0.0d;
                                for (SampleRaw sampleRaw2 : activityList) {
                                    d4 += sampleRaw2.getSteps();
                                    gp3 = Math.max(sampleRaw2.getEndTime().getTime(), gp3);
                                }
                                arrayList.add(Integer.valueOf((int) d4));
                                if (gp3 == 0) {
                                    gp3 = endOfDay.getTime();
                                }
                                m7094a(bCChallenge, arrayList, gp3);
                            }
                        }
                    }
                    obj2 = obj;
                    obj = obj2;
                }
            }
        }
    }

    private void m7094a(final BCChallenge bCChallenge, List<Integer> list, long j) {
        List arrayList;
        List list2 = null;
        MFLogger.m12670d(TAG, "updateStepForChallenge: challenge = " + bCChallenge + ", heartbeatStepsDays = " + list);
        int i;
        if (cnq.acd().acw().adI().getUserId().equals(bCChallenge.getSenderId())) {
            arrayList = new ArrayList(bCChallenge.getSenderStepsDays());
            for (i = 0; i < list.size(); i++) {
                int intValue = ((Integer) list.get(i)).intValue();
                if (arrayList.size() <= i) {
                    arrayList.add(Integer.valueOf(intValue));
                } else if (((Integer) arrayList.get(i)).intValue() < intValue) {
                    arrayList.set(i, Integer.valueOf(intValue));
                }
            }
            bCChallenge.setSenderStepsDays(arrayList);
            bCChallenge.setUpdatedAt(cnf.aF(j));
        } else {
            List arrayList2 = new ArrayList(bCChallenge.getReceiverStepsDays());
            for (i = 0; i < list.size(); i++) {
                int intValue2 = ((Integer) list.get(i)).intValue();
                if (arrayList2.size() <= i) {
                    arrayList2.add(Integer.valueOf(intValue2));
                } else if (((Integer) arrayList2.get(i)).intValue() < intValue2) {
                    arrayList2.set(i, Integer.valueOf(intValue2));
                }
            }
            bCChallenge.setReceiverStepsDays(arrayList2);
            bCChallenge.setUpdatedAt(cnf.aF(j));
            arrayList = null;
            list2 = arrayList2;
        }
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new crd(PortfolioApp.ZQ(), bCChallenge.getChallengeId(), arrayList, list2, cmq.m7131i(new Date(j))), new MFServerResultCallback(this) {
            final /* synthetic */ cml cxJ;

            public void onSuccess(MFResponse mFResponse) {
                MFLogger.m12670d(cml.TAG, "updateStepForChallenge onSuccess");
                BCChallenge challenge = ((MFUpdateChallengeResponse) mFResponse).getChallenge();
                challenge.setPinType(0);
                this.cxJ.mProviderManager.acw().mo1921a(challenge);
                Intent intent = new Intent();
                intent.putExtra("BC_HEARTBEAT_STEP_EXTRA", challenge);
                intent.setAction("BC_HEARTBEAT_STEP_ACTION");
                PortfolioApp.ZQ().sendBroadcast(intent);
            }

            public void onFail(int i, MFResponse mFResponse) {
                MFLogger.m12670d(cml.TAG, "updateStepForChallenge onFailed");
                bCChallenge.setPinType(2);
                this.cxJ.mProviderManager.acw().mo1921a(bCChallenge);
                Intent intent = new Intent();
                intent.putExtra("BC_HEARTBEAT_STEP_EXTRA", bCChallenge);
                intent.setAction("BC_HEARTBEAT_STEP_ACTION");
                PortfolioApp.ZQ().sendBroadcast(intent);
            }
        });
    }

    public void m7097i(int i, int i2, String str) {
        if (cnq.acd().acw().adI() != null) {
            MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new crc(PortfolioApp.ZQ(), i, i2, str), new C21982(this));
        }
    }

    private void m7095a(BCPlayer bCPlayer) {
        this.mProviderManager.acw().mo1931b(bCPlayer);
    }
}
