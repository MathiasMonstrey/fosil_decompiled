package com.portfolio.platform.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.fossil.atv;
import com.fossil.atv.a;
import com.fossil.atz;
import com.fossil.aua;
import com.fossil.azu;
import com.fossil.baa;
import com.fossil.bab;
import com.fossil.bac;
import com.fossil.cmx;
import com.fossil.ecp;
import com.fossil.efd;
import com.fossil.efe;
import com.fossil.wearables.fossil.R;
import com.fossil.wearables.fsl.fitness.SampleRaw;
import com.fossil.wearables.fsl.fitness.exception.InvalidTimezoneIDException;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.jawbone.upplatformsdk.api.ApiManager;
import com.jawbone.upplatformsdk.api.response.OauthAccessTokenResponse;
import com.misfit.frameworks.buttonservice.utils.DeviceIdentityUtils;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.ua.sdk.UaException;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import retrofit.client.Response;
import retrofit.mime.TypedString;

public class ThirdPartyUploadIntentService extends IntentService {
    private static final String TAG = ThirdPartyUploadIntentService.class.getSimpleName();
    private String cDD;
    public ecp cDE;
    public cmx cDF;

    class C49181 implements aua<Status> {
        final /* synthetic */ ThirdPartyUploadIntentService cDG;

        C49181(ThirdPartyUploadIntentService thirdPartyUploadIntentService) {
            this.cDG = thirdPartyUploadIntentService;
        }

        public /* synthetic */ void m15672a(atz com_fossil_atz) {
            m15673p((Status) com_fossil_atz);
        }

        public void m15673p(Status status) {
            MFLogger.d(ThirdPartyUploadIntentService.TAG, "Status = " + status.Ka() + " - " + status.getStatusMessage());
        }
    }

    public static void m15675a(Context context, SampleRaw sampleRaw, String str) {
        Intent intent = new Intent(context, ThirdPartyUploadIntentService.class);
        intent.setAction("com.portfolio.service.action.Upload");
        intent.putExtra("com.portfolio.service.extra.Sample", sampleRaw);
        intent.putExtra("com.portfolio.service.extra.Serial", str);
        context.startService(intent);
    }

    public ThirdPartyUploadIntentService() {
        super(TAG);
        PortfolioApp.ZQ().aam().a(this);
    }

    protected void onHandleIntent(Intent intent) {
        MFLogger.d(TAG, "onHandleIntent()");
        if (intent != null) {
            if ("com.portfolio.service.action.Upload".equals(intent.getAction())) {
                MFLogger.d(TAG, "We have an upload action");
                SampleRaw sampleRaw = (SampleRaw) intent.getSerializableExtra("com.portfolio.service.extra.Sample");
                this.cDD = intent.getStringExtra("com.portfolio.service.extra.Serial");
                m15676c(sampleRaw);
            }
        }
    }

    private void m15676c(SampleRaw sampleRaw) {
        m15677d(sampleRaw);
        m15679f(sampleRaw);
        m15680g(sampleRaw);
    }

    private void m15677d(SampleRaw sampleRaw) {
        MFLogger.d(TAG, "Trying to save to Google Fit...");
        atv KI = new a(this).a(azu.bkq, new Scope[0]).a(azu.bkm, new Scope[0]).a(azu.bku, new Scope[0]).a(new Scope("https://www.googleapis.com/auth/fitness.activity.write")).KI();
        if (KI.KE().Kb() && KI.isConnected() && !TextUtils.isEmpty(this.cDD)) {
            azu.bkr.a(KI, m15678e(sampleRaw)).a(new C49181(this));
        } else {
            MFLogger.d(TAG, "Not sending data to Google Fit");
        }
    }

    private DataSet m15678e(SampleRaw sampleRaw) {
        int round = (int) Math.round(sampleRaw.getSteps());
        long time = sampleRaw.getStartTime().getTime();
        long time2 = sampleRaw.getEndTime().getTime();
        baa.a hF = new baa.a().aD(this).a(DataType.bkZ).dn(getString(R.string.app_name)).hF(0);
        if (this.cDD != null) {
            MFLogger.d(TAG, "We have an active device. Lets send it to Google Fit");
            hF.a(new bab("Fossil", DeviceIdentityUtils.getNameBySerial(this.cDD), this.cDD, 3));
        }
        DataSet b = DataSet.m14239b(hF.Mi());
        DataPoint a = b.LZ().m14236a(time, time2, TimeUnit.MILLISECONDS);
        a.m14235a(bac.bmj).hG(round);
        b.m14243a(a);
        return b;
    }

    private void m15679f(SampleRaw sampleRaw) {
        ecp com_fossil_ecp = this.cDE;
        if (!com_fossil_ecp.abM()) {
            MFLogger.d(TAG, "Not logged in to UA");
        } else if (TextUtils.isEmpty(this.cDD)) {
            MFLogger.e(TAG, "Current device serial is null?");
        } else {
            efd a = m15674a(sampleRaw, com_fossil_ecp);
            if (a == null) {
                MFLogger.e(TAG, "UA Time series activity is null?");
                return;
            }
            MFLogger.d(TAG, "Saving " + sampleRaw.getSteps() + " to UnderArmor");
            try {
                com_fossil_ecp.aCA().a(a);
            } catch (UaException e) {
                MFLogger.e(TAG, "Error saving to UA");
                e.printStackTrace();
            }
            MFLogger.d(TAG, "Save to UA complete");
        }
    }

    private efd m15674a(SampleRaw sampleRaw, ecp com_fossil_ecp) {
        efe aCQ = com_fossil_ecp.aCA().aCQ();
        aCQ.lr("fossil_q");
        aCQ.ls(Secure.getString(getContentResolver(), "android_id"));
        long time = sampleRaw.getStartTime().getTime() / 1000;
        MFLogger.d(TAG, " time = " + time);
        try {
            aCQ.c(time, (int) sampleRaw.getSteps());
            aCQ.b(time, sampleRaw.getDistance());
            aCQ.a(time, sampleRaw.getCalories());
            return aCQ.aCO();
        } catch (Exception e) {
            MFLogger.e(TAG, "Failed to generate time series.");
            return null;
        }
    }

    private void m15680g(SampleRaw sampleRaw) {
        if (!this.cDF.abM()) {
            MFLogger.d(TAG, "Not logged in to JB");
        } else if (TextUtils.isEmpty(this.cDD)) {
            MFLogger.d(TAG, "Current device serial is null?");
        } else {
            String id;
            MFLogger.d(TAG, "Saving " + sampleRaw.getSteps() + " to JawBone");
            try {
                id = sampleRaw.getTimeZone().getID();
            } catch (InvalidTimezoneIDException e) {
                id = TimeZone.getDefault().getID();
            }
            TypedString typedString = new TypedString("source_type=0&source_id=" + this.cDD + "&data=[{\"type\": \"steps\", \"data\":[[" + (sampleRaw.getStartTime().getTime() / 1000) + "," + sampleRaw.getSteps() + "]]}, {\"type\": \"calories\", \"data\":[[" + (sampleRaw.getStartTime().getTime() / 1000) + "," + sampleRaw.getCalories() + "]]}, {\"type\": \"distance\", \"data\":[[" + (sampleRaw.getStartTime().getTime() / 1000) + "," + sampleRaw.getDistance() + "]]}]&tz=" + id);
            ApiManager.getRequestInterceptor().setAccessToken(this.cDF.getAccessToken());
            Response postTimeSeriesData;
            try {
                postTimeSeriesData = ApiManager.getRestApiInterface().postTimeSeriesData(typedString);
                if (postTimeSeriesData.getStatus() == 201) {
                    MFLogger.d(TAG, "JB upload successful");
                    return;
                }
                MFLogger.e(TAG, "JB upload failed");
                MFLogger.e(TAG, "Response Status" + postTimeSeriesData.getStatus());
            } catch (Exception e2) {
                MFLogger.e(TAG, "Retrofit Error " + e2.getMessage());
                if (e2.getMessage().contains("401")) {
                    MFLogger.d(TAG, "Attempting to refresh token...");
                    try {
                        ApiManager.getRequestInterceptor().clearAccessToken();
                        OauthAccessTokenResponse refreshAccessToken = ApiManager.getRestApiInterface().refreshAccessToken("tgj1k5_6wy4", "99d234a7cfcce6ecc7c1ae58a6f381deaa30c7ac", this.cDF.getRefreshToken());
                        if (refreshAccessToken.access_token != null) {
                            this.cDF.a(refreshAccessToken);
                            MFLogger.d(TAG, "accessToken:" + refreshAccessToken.access_token);
                            MFLogger.d(TAG, "retrying upload...");
                            ApiManager.getRequestInterceptor().setAccessToken(this.cDF.getAccessToken());
                            try {
                                postTimeSeriesData = ApiManager.getRestApiInterface().postTimeSeriesData(typedString);
                                if (postTimeSeriesData.getStatus() == 201) {
                                    MFLogger.d(TAG, "JB upload successful");
                                    return;
                                }
                                MFLogger.e(TAG, "JB upload failed");
                                MFLogger.e(TAG, "Response Status" + postTimeSeriesData.getStatus());
                                return;
                            } catch (Exception e22) {
                                MFLogger.e(TAG, "Retrofit Error " + e22.getMessage());
                                return;
                            }
                        }
                        MFLogger.e(TAG, "accessToken not returned by Oauth call, logging out...");
                        this.cDF.logout();
                    } catch (Exception e222) {
                        MFLogger.e(TAG, "failed to refresh accessToken:" + e222.getMessage());
                        if (e222.getMessage().contains("401")) {
                            this.cDF.logout();
                        }
                    }
                }
            }
        }
    }
}
