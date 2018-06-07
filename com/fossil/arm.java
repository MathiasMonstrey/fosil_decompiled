package com.fossil;

import android.content.Context;
import com.fossil.cloudimagelib.AssetsDeviceResponse;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFResponse;
import java.io.File;

public class arm {
    private static final String TAG = ("CloudImage_" + arm.class.getSimpleName());
    private String bdm;
    private String bdn;
    private C1861a bds;
    private Context context;
    private String feature;
    private String resolution;
    private String serialNumber;

    interface C1861a {
        void mo1138a(String str, String str2, AssetsDeviceResponse assetsDeviceResponse);
    }

    class C18641 implements MFServerResultCallback {
        final /* synthetic */ arm bdu;

        C18641(arm com_fossil_arm) {
            this.bdu = com_fossil_arm;
        }

        public void onSuccess(MFResponse mFResponse) {
            AssetsDeviceResponse assetsDeviceResponse = (AssetsDeviceResponse) mFResponse;
            if (!this.bdu.m4303a(this.bdu.bdm, assetsDeviceResponse)) {
                MFLogger.m12670d(arm.TAG, "onSuccess: The assets with serialNumber = [" + this.bdu.serialNumber + "] for feature =[" + this.bdu.feature + "] is the latest, no need to download!");
            } else if (this.bdu.bds != null) {
                this.bdu.bds.mo1138a(this.bdu.bdm, this.bdu.bdn, assetsDeviceResponse);
            }
        }

        public void onFail(int i, MFResponse mFResponse) {
            MFLogger.m12671e(arm.TAG, "onFail: serialNumber = [" + this.bdu.serialNumber + "], feature = [" + this.bdu.feature + "], error = [" + i + "]");
        }
    }

    public static arm Jt() {
        return new arm();
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void m4308a(C1861a c1861a) {
        this.bds = c1861a;
    }

    public void m4309a(String str, String str2, String str3, String str4, String str5) {
        this.bdm = str;
        this.bdn = str2;
        this.serialNumber = str3;
        this.feature = str4;
        this.resolution = str5;
    }

    public void execute() {
        MFLogger.m12670d(TAG, "execute() called with serialNumber = [" + this.serialNumber + "], feature = [" + this.feature + "]");
        MFNetwork.getInstance(this.context).execute(new arf(this.context, this.serialNumber, this.feature, this.resolution), new C18641(this));
    }

    private boolean m4303a(String str, AssetsDeviceResponse assetsDeviceResponse) {
        if (new File(str).exists() && arg.m4277B(str, assetsDeviceResponse.getChecksum())) {
            return false;
        }
        return true;
    }
}
