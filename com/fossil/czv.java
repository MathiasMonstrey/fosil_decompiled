package com.fossil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.fossil.ckb.C2126d;
import com.fossil.ckb.C2131a;
import com.fossil.czt.C2583a;
import com.fossil.czt.C2584b;
import com.fossil.dab.C2593a;
import com.fossil.dab.C2594b;
import com.fossil.dab.C2595c;
import com.fossil.dad.C2596a;
import com.fossil.dad.C2597b;
import com.fossil.daf.C2599a;
import com.fossil.daf.C2600b;
import com.fossil.wearables.fsl.location.DeviceLocation;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.service.MFDeviceService;

public class czv implements C2583a {
    private final gy cEa;
    private BroadcastReceiver cEe = new C25891(this);
    private final C2584b cNa;
    private final dad cNb;
    private final daf cNc;
    private final dab cNd;
    private DeviceLocation cNe;
    private final String mDeviceId;
    private final ckc mUseCaseHandler;

    class C25891 extends BroadcastReceiver {
        final /* synthetic */ czv cNf;

        C25891(czv com_fossil_czv) {
            this.cNf = com_fossil_czv;
        }

        public void onReceive(Context context, Intent intent) {
            DeviceLocation deviceLocation = (DeviceLocation) intent.getParcelableExtra("EXTRA_DEVICE_LOCATION");
            MFLogger.m12670d("DeviceLocateMapPresenter", "onReceive - location: " + deviceLocation);
            if (deviceLocation != null) {
                this.cNf.cNe = deviceLocation;
                this.cNf.m8057a(this.cNf.cNe);
            }
        }
    }

    class C25902 implements C2126d<C2597b, C2131a> {
        final /* synthetic */ czv cNf;

        C25902(czv com_fossil_czv) {
            this.cNf = com_fossil_czv;
        }

        public /* synthetic */ void onError(Object obj) {
            m8049a((C2131a) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m8050a((C2597b) obj);
        }

        public void m8050a(C2597b c2597b) {
            MFLogger.m12670d("DeviceLocateMapPresenter", "GetLocation onSuccess");
            this.cNf.cNe = c2597b.akO();
            this.cNf.m8057a(this.cNf.cNe);
        }

        public void m8049a(C2131a c2131a) {
            MFLogger.m12670d("DeviceLocateMapPresenter", "GetLocation onError");
            this.cNf.akJ();
        }
    }

    class C25913 implements C2126d<C2595c, C2594b> {
        final /* synthetic */ czv cNf;

        C25913(czv com_fossil_czv) {
            this.cNf = com_fossil_czv;
        }

        public /* synthetic */ void onError(Object obj) {
            m8051a((C2594b) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m8052a((C2595c) obj);
        }

        public void m8052a(C2595c c2595c) {
            String address = c2595c.getAddress();
            MFLogger.m12670d("DeviceLocateMapPresenter", "GetCityName onSuccess - address: " + address);
            this.cNf.cNa.im(address);
        }

        public void m8051a(C2594b c2594b) {
            MFLogger.m12670d("DeviceLocateMapPresenter", "GetCityName onError code=" + c2594b.getErrorCode());
        }
    }

    class C25924 implements C2126d<C2600b, C2131a> {
        final /* synthetic */ czv cNf;

        C25924(czv com_fossil_czv) {
            this.cNf = com_fossil_czv;
        }

        public /* synthetic */ void onError(Object obj) {
            m8053a((C2131a) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m8054a((C2600b) obj);
        }

        public void m8054a(C2600b c2600b) {
            MFLogger.m12670d("DeviceLocateMapPresenter", "loadLocation onSuccess lastLocation Longitude=" + this.cNf.cNe.getLongitude() + ", Latitude=" + this.cNf.cNe.getLatitude());
            this.cNf.cNe = c2600b.akO();
            if (this.cNf.cNa.isActive()) {
                this.cNf.m8057a(this.cNf.cNe);
            }
        }

        public void m8053a(C2131a c2131a) {
            MFLogger.m12670d("DeviceLocateMapPresenter", "loadLocation onError");
        }
    }

    czv(gy gyVar, String str, C2584b c2584b, ckc com_fossil_ckc, dad com_fossil_dad, daf com_fossil_daf, dab com_fossil_dab) {
        this.cEa = (gy) cco.m5996s(gyVar, "localBroadcastManager cannot be null!");
        this.cNa = (C2584b) cco.m5996s(c2584b, "view cannot be null!");
        this.mDeviceId = (String) cco.m5996s(str, "deviceId cannot be null!");
        this.mUseCaseHandler = (ckc) cco.m5996s(com_fossil_ckc, "useCaseHandler cannot be null!");
        this.cNb = (dad) cco.m5996s(com_fossil_dad, "getLocation cannot be null!");
        this.cNc = (daf) cco.m5996s(com_fossil_daf, "loadLocation cannot be null!");
        this.cNd = (dab) cco.m5996s(com_fossil_dab, "getAddress cannot be null!");
    }

    public void ahu() {
        this.cNa.cK(this);
    }

    public void start() {
        this.cEa.m11537a(this.cEe, new IntentFilter(MFDeviceService.LOCATION_UPDATED));
        MFLogger.m12670d("DeviceLocateMapPresenter", "GetLocation");
        this.mUseCaseHandler.m6886a(this.cNb, new C2596a(this.mDeviceId), new C25902(this));
    }

    public void stop() {
        this.cEa.unregisterReceiver(this.cEe);
    }

    private void m8057a(DeviceLocation deviceLocation) {
        this.cNa.aK(deviceLocation.getTimeStamp());
        double latitude = deviceLocation.getLatitude();
        double longitude = deviceLocation.getLongitude();
        MFLogger.m12670d("DeviceLocateMapPresenter", "handleLocation latitude=" + latitude + ", longitude=" + longitude);
        if (latitude == 0.0d || longitude == 0.0d) {
            akJ();
            return;
        }
        this.cNa.mo2221a(latitude, longitude);
        MFLogger.m12670d("DeviceLocateMapPresenter", "GetCityName");
        this.mUseCaseHandler.m6886a(this.cNd, new C2593a(latitude, longitude), new C25913(this));
    }

    private void akJ() {
        MFLogger.m12670d("DeviceLocateMapPresenter", "loadLocation");
        this.mUseCaseHandler.m6886a(this.cNc, new C2599a(), new C25924(this));
    }
}
