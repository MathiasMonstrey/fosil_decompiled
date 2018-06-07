package com.fossil;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.fossil.ari.C1856a;
import com.fossil.ark.C1860b;
import com.fossil.arm.C1861a;
import com.fossil.arn.C1862a;
import com.fossil.cloudimagelib.AssetsDeviceResponse;
import com.fossil.cloudimagelib.Constants.DownloadAssetType;
import com.misfit.frameworks.common.log.MFLogger;

public class arj implements C1860b, C1861a, C1862a, Runnable {
    private static final String TAG = arj.class.getSimpleName();
    private C1856a bcW;
    private String bcZ;
    private int bda;
    private int bdb;
    private DownloadAssetType bdc;
    private Context context;
    private String feature;
    private String resolution;
    private String serialNumber;
    private String type;

    public arj(Context context) {
        this.bda = 0;
        this.bdb = 0;
        this.bdc = DownloadAssetType.BOTH;
        this.context = context;
    }

    public arj(Context context, String str, String str2, String str3) {
        this(context);
        this.serialNumber = str;
        this.bcZ = str2;
        this.resolution = str3;
    }

    public arj(Context context, String str, String str2, String str3, DownloadAssetType downloadAssetType, String str4, String str5, C1856a c1856a) {
        this(context, str, str2, str3);
        this.bdc = downloadAssetType;
        this.feature = str4;
        this.type = str5;
        this.bcW = c1856a;
    }

    public void run() {
        Jn();
    }

    private void Jn() {
        switch (this.bdc) {
            case DEVICE:
                Jo();
                return;
            case CALIBRATION:
                Jp();
                return;
            default:
                Jo();
                Jp();
                return;
        }
    }

    private void Jo() {
        String str = this.context.getFilesDir().getAbsolutePath() + "/" + this.bcZ + "-" + this.resolution + "-" + this.feature + ".zip";
        String str2 = this.context.getFilesDir().getAbsolutePath() + "/" + this.bcZ + "-" + this.resolution + "-" + this.feature;
        arm Jq = Jq();
        Jq.m4309a(str, str2, this.serialNumber, this.feature, this.resolution);
        Jq.execute();
    }

    private void Jp() {
        String str = this.context.getFilesDir().getAbsolutePath() + "/" + this.bcZ + "-" + this.resolution + "-" + this.feature + ".zip";
        String str2 = this.context.getFilesDir().getAbsolutePath() + "/" + this.bcZ + "-" + this.resolution + "-" + this.feature;
        arm Jq = Jq();
        Jq.m4309a(str, str2, this.serialNumber, this.feature, this.resolution);
        Jq.execute();
    }

    private arm Jq() {
        arm Jt = arm.Jt();
        Jt.setContext(this.context);
        Jt.m4308a((C1861a) this);
        return Jt;
    }

    public void mo1138a(String str, String str2, AssetsDeviceResponse assetsDeviceResponse) {
        ark Jr = ark.Jr();
        Jr.m4299a((C1860b) this);
        Jr.m4300c(str, str2, assetsDeviceResponse);
        Jr.execute();
    }

    public void mo1135D(String str, String str2) {
        arn Jv = arn.Jv();
        Jv.m4315a((C1862a) this);
        Jv.m4314G(str, str2);
        Jv.execute();
    }

    public void mo1139b(String str, String str2, AssetsDeviceResponse assetsDeviceResponse) {
        this.bda++;
        if (this.bda >= 3) {
            MFLogger.m12670d(TAG, "onDownloadFail: retry reaches max retry for serialNumber = [" + assetsDeviceResponse.getSerialNumber() + "]");
            this.bda = 0;
            return;
        }
        mo1138a(str, str2, assetsDeviceResponse);
    }

    public void mo1136E(String str, String str2) {
        cI(str2);
    }

    private void cI(String str) {
        final String str2 = str + "/" + this.type + ".webp";
        if (!are.cF(str2)) {
            str2 = str + "/" + this.type + ".png";
            if (are.cF(str2) && this.bcW != null) {
                new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ arj bde;

                    public void run() {
                        this.bde.bcW.mo1879C(this.bde.serialNumber, str2);
                    }
                });
            }
        } else if (this.bcW != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ arj bde;

                public void run() {
                    this.bde.bcW.mo1879C(this.bde.serialNumber, str2);
                }
            });
        }
    }

    public void mo1137F(String str, String str2) {
        this.bdb++;
        if (this.bdb >= 3) {
            MFLogger.m12670d(TAG, "onUnzipFail: retry reach max retry!");
            this.bdb = 0;
            return;
        }
        mo1135D(str, str2);
    }
}
