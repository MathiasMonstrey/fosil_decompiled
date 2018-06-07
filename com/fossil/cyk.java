package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFResponse;
import com.misfit.frameworks.network.utils.NetworkUtils;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.Firmware;
import com.portfolio.platform.downloader.FileDownloader;
import com.portfolio.platform.downloader.FileDownloader.DownloadEvent;
import com.portfolio.platform.helper.DeviceHelper;
import com.portfolio.platform.response.firmware.MFFirmwareListResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class cyk extends ckb<C2514a, C2516c, C2515b> {
    private static final String TAG = cyk.class.getSimpleName();
    private MFNetwork cKU;

    class C25131 implements MFServerResultCallback {
        final /* synthetic */ cyk cLa;

        C25131(cyk com_fossil_cyk) {
            this.cLa = com_fossil_cyk;
        }

        public void onSuccess(MFResponse mFResponse) {
            List<Firmware> firmwareList = ((MFFirmwareListResponse) mFResponse).getFirmwareList();
            if (firmwareList.isEmpty()) {
                MFLogger.m12671e(cyk.TAG, "No firmware found on server");
                return;
            }
            for (Firmware a : firmwareList) {
                this.cLa.m7904b(a);
            }
            this.cLa.abr().onSuccess(new C2516c());
        }

        public void onFail(int i, MFResponse mFResponse) {
            MFLogger.m12671e(cyk.TAG, "Fail to check firmware due to error=" + i);
            cnq.acd().acf().removeDataVersion("firmwares");
            this.cLa.abr().onError(new C2515b());
        }
    }

    public static final class C2514a implements C2132b {
    }

    public static final class C2515b implements C2131a {
    }

    public static final class C2516c implements C2133c {
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m7905a((C2514a) c2132b);
    }

    public cyk(MFNetwork mFNetwork) {
        this.cKU = mFNetwork;
    }

    protected void m7905a(C2514a c2514a) {
        if (NetworkUtils.isNetworkAvailable(PortfolioApp.ZQ())) {
            List<String> arrayList = new ArrayList();
            arrayList.addAll(Arrays.asList(DeviceHelper.cye));
            for (String str : arrayList) {
                MFLogger.m12670d(TAG, "Start checking latest fw for model=" + str);
                this.cKU.execute(new crn(PortfolioApp.ZQ(), str), new C25131(this));
            }
            return;
        }
        abr().onError(new C2515b());
        cnq.acd().acf().removeDataVersion("firmwares");
    }

    private void m7904b(Firmware firmware) {
        coz act = cnq.acd().act();
        Firmware hr = act.hr(firmware.getDeviceModel());
        MFLogger.m12670d(TAG, "Start download detail firmware=" + firmware.getDeviceModel() + ", localFw=" + hr + " from URL=" + firmware.getDownloadUrl());
        if (hr == null || !hr.getVersionNumber().equalsIgnoreCase(firmware.getVersionNumber())) {
            act.mo1992a(firmware);
            new FileDownloader(firmware.getDownloadUrl(), firmware.getChecksum(), firmware.getVersionNumber(), DownloadEvent.FIRMWARE).execute(new String[0]);
            return;
        }
        MFLogger.m12670d(TAG, "Local fw of model=" + hr.getDeviceModel() + " is already latest, no need to re-download");
    }
}
