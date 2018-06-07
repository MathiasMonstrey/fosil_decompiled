package com.fossil;

import android.text.TextUtils;
import android.util.Log;
import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.fossil.clx.C2173l;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.Firmware;
import com.portfolio.platform.downloader.FileDownloader;
import com.portfolio.platform.downloader.FileDownloader.DownloadEvent;
import com.portfolio.platform.downloader.FileDownloader.a;
import com.portfolio.platform.response.firmware.MFFirmwareListResponse;
import java.util.List;

public class cyi extends ckb<C2510a, C2512c, C2511b> implements a {
    private static final String TAG = cyi.class.getSimpleName();
    private String cKT;
    private MFNetwork cKU;

    public static final class C2510a implements C2132b {
        private final String cCe;

        public C2510a(String str) {
            this.cCe = (String) cco.m5996s(str, "mDeviceModel cannot be null!");
        }

        public String getDeviceModel() {
            return this.cCe;
        }
    }

    public static final class C2511b implements C2131a {
    }

    public static final class C2512c implements C2133c {
        private final String cKX;

        public C2512c(String str) {
            this.cKX = (String) cco.m5996s(str, "mLatestFwVersion cannot be null!");
        }

        public String ajP() {
            return this.cKX;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m7900a((C2510a) c2132b);
    }

    public cyi(MFNetwork mFNetwork) {
        this.cKU = mFNetwork;
    }

    protected void m7900a(C2510a c2510a) {
        Log.d(TAG, "Download firmware of deviceModel=" + c2510a.getDeviceModel());
        final String deviceModel = c2510a.getDeviceModel();
        this.cKU.execute(new crn(PortfolioApp.ZQ(), deviceModel), new MFServerResultCallback(this) {
            final /* synthetic */ cyi cKW;

            public void onSuccess(MFResponse mFResponse) {
                List<Firmware> firmwareList = ((MFFirmwareListResponse) mFResponse).getFirmwareList();
                if (firmwareList.isEmpty()) {
                    this.cKW.abr().onError(new C2511b());
                }
                if (TextUtils.isEmpty(deviceModel)) {
                    this.cKW.abr().onError(new C2511b());
                }
                Firmware firmware = null;
                for (Firmware firmware2 : firmwareList) {
                    Firmware firmware22;
                    if (TextUtils.isEmpty(firmware22.getDeviceModel()) || !firmware22.getDeviceModel().contains(deviceModel)) {
                        firmware22 = firmware;
                    }
                    firmware = firmware22;
                }
                if (firmware != null) {
                    coz act = cnq.acd().act();
                    Firmware hr = act.hr(firmware.getDeviceModel());
                    MFLogger.m12670d(cyi.TAG, "Start download detail firmware=" + firmware.getDeviceModel() + ", localFw=" + hr + " from URL=" + firmware.getDownloadUrl());
                    if (hr == null || !hr.getVersionNumber().equalsIgnoreCase(firmware.getVersionNumber())) {
                        act.mo1992a(firmware);
                        this.cKW.cKT = firmware.getVersionNumber();
                        FileDownloader fileDownloader = new FileDownloader(firmware.getDownloadUrl(), firmware.getChecksum(), firmware.getVersionNumber(), DownloadEvent.FIRMWARE);
                        fileDownloader.a(this.cKW);
                        fileDownloader.execute(new String[0]);
                        return;
                    }
                    MFLogger.m12671e(cyi.TAG, "Local firmware of model=" + deviceModel + ", version= " + hr.getVersionNumber() + " is latest, no need to re-download");
                    this.cKW.abr().onSuccess(new C2512c(hr.getVersionNumber()));
                    return;
                }
                MFLogger.m12671e(cyi.TAG, "Latest firmware of model=" + deviceModel + " not found on server");
                this.cKW.abr().onError(new C2511b());
            }

            public void onFail(int i, MFResponse mFResponse) {
                MFLogger.m12671e(cyi.TAG, "Error when download list firmware, error=" + mFResponse.getHttpReturnCode());
                PortfolioApp.cL(new C2173l(false, DownloadEvent.FIRMWARE));
            }
        });
    }

    public void bP(boolean z) {
        if (z) {
            abr().onSuccess(new C2512c(this.cKT));
        } else {
            abr().onError(new C2511b());
        }
    }
}
