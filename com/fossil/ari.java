package com.fossil;

import android.content.Context;
import android.widget.ImageView;
import com.fossil.cloudimagelib.Constants.CalibrationType;
import com.fossil.cloudimagelib.Constants.DeviceType;
import com.fossil.cloudimagelib.Constants.DownloadAssetType;
import com.fossil.cloudimagelib.Constants.Feature;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ari {
    private static final String TAG = ari.class.getSimpleName();
    private ExecutorService aIj;
    private String bcS;
    private String bcT;
    private WeakReference<ImageView> bcU;
    private int bcV;
    private C1856a bcW;
    private DeviceType bcX = DeviceType.NONE;
    private CalibrationType bcY = CalibrationType.NONE;
    private Context mContext;

    public interface C1856a {
        void mo1879C(String str, String str2);
    }

    public static ari Jl() {
        return new ari();
    }

    public ari ad(Context context) {
        this.mContext = context;
        return this;
    }

    public ari cG(String str) {
        this.bcS = str;
        return this;
    }

    public ari cH(String str) {
        this.bcT = str;
        return this;
    }

    public ari m4283a(DeviceType deviceType) {
        this.bcX = deviceType;
        return this;
    }

    public ari m4282a(CalibrationType calibrationType) {
        this.bcY = calibrationType;
        return this;
    }

    public ari m4280a(ImageView imageView, int i) {
        this.bcU = new WeakReference(imageView);
        this.bcV = i;
        return this;
    }

    public ari m4281a(C1856a c1856a) {
        this.bcW = c1856a;
        return this;
    }

    public void Jm() {
        if (!are.m4276a(this.mContext, this.bcS, this.bcT, arl.Js().getName(), this.bcX != DeviceType.NONE ? Feature.DEVICE.getFeature() : Feature.CALIBRATION.getFeature(), this.bcX != DeviceType.NONE ? this.bcX.getType() : this.bcY.getType(), this.bcW)) {
            Runnable com_fossil_arj;
            if (!(this.bcU == null || this.bcU.get() == null)) {
                ((ImageView) this.bcU.get()).setImageResource(this.bcV);
            }
            if (this.aIj == null || this.aIj.isShutdown()) {
                this.aIj = Executors.newSingleThreadExecutor();
            }
            if (this.bcX != DeviceType.NONE) {
                com_fossil_arj = new arj(this.mContext, this.bcS, this.bcT, arl.Js().getName(), DownloadAssetType.DEVICE, Feature.DEVICE.getFeature(), this.bcX.getType(), this.bcW);
            } else {
                com_fossil_arj = new arj(this.mContext, this.bcS, this.bcT, arl.Js().getName(), DownloadAssetType.CALIBRATION, Feature.CALIBRATION.getFeature(), this.bcY.getType(), this.bcW);
            }
            this.aIj.submit(com_fossil_arj);
        }
    }
}
