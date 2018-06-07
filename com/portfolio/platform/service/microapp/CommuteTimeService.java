package com.portfolio.platform.service.microapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import com.fossil.atn;
import com.fossil.atv;
import com.fossil.atv.b;
import com.fossil.atv.c;
import com.fossil.bus;
import com.fossil.but;
import com.fossil.bvd;
import com.fossil.cfj;
import com.fossil.ckb.a;
import com.fossil.ckb.d;
import com.fossil.ckc;
import com.fossil.csy;
import com.fossil.cta;
import com.fossil.djk;
import com.fossil.eg;
import com.fossil.gy;
import com.google.android.gms.location.LocationRequest;
import com.misfit.frameworks.buttonservice.ButtonService;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.enums.ServiceActionResult;
import com.misfit.frameworks.buttonservice.model.microapp.CommuteETAInstruction;
import com.misfit.frameworks.buttonservice.model.microapp.CommuteTravelTimeInstruction;
import com.misfit.frameworks.buttonservice.utils.LocationUtils;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.enums.Action.MicroAppAction;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.microapp.CommuteTimeSettings;
import com.portfolio.platform.data.model.microapp.CommuteTimeSettings$TIME_FORMAT;
import java.util.Calendar;

public class CommuteTimeService extends csy implements LocationListener, b, c, bus {
    public static final String TAG = CommuteTimeService.class.getSimpleName();
    private long CZ;
    private LocationManager adf;
    private Location cDW;
    private Location cDX;
    private CommuteTimeSettings cDY;
    private String cDZ;
    public gy cEa;
    public djk cEb;
    public PortfolioApp cEc;
    private LocationRequest cEd;
    private BroadcastReceiver cEe = new C49261(this);
    protected atv cph;
    private Handler mHandler;
    protected String mSerial;
    public ckc mUseCaseHandler;

    class C49261 extends BroadcastReceiver {
        final /* synthetic */ CommuteTimeService cEf;

        C49261(CommuteTimeService commuteTimeService) {
            this.cEf = commuteTimeService;
        }

        public void onReceive(Context context, Intent intent) {
            MFLogger.d(CommuteTimeService.TAG, "onReceive");
            if (CommunicateMode.values()[intent.getIntExtra(ButtonService.SERVICE_BLE_PHASE, CommunicateMode.IDLE.ordinal())] != CommunicateMode.MICRO_APP_MOVE_HAND) {
                return;
            }
            if (intent.getIntExtra(ButtonService.SERVICE_ACTION_RESULT, -1) == ServiceActionResult.SUCCEEDED.ordinal()) {
                MFLogger.d(CommuteTimeService.TAG, "onReceive MICRO_APP_MOVE_HAND success");
            } else {
                MFLogger.d(CommuteTimeService.TAG, "onReceive MICRO_APP_MOVE_HAND failed");
            }
        }
    }

    class C49272 implements Runnable {
        final /* synthetic */ CommuteTimeService cEf;

        C49272(CommuteTimeService commuteTimeService) {
            this.cEf = commuteTimeService;
        }

        public void run() {
            MFLogger.d(CommuteTimeService.TAG, "Runnable after 5s");
            if (this.cEf.cDW == null && this.cEf.adf != null) {
                this.cEf.adf.removeUpdates(this.cEf);
                if (eg.b(PortfolioApp.ZQ(), "android.permission.ACCESS_FINE_LOCATION") == 0 && eg.b(PortfolioApp.ZQ(), "android.permission.ACCESS_COARSE_LOCATION") == 0 && LocationUtils.isLocationEnable(PortfolioApp.ZQ())) {
                    this.cEf.cDX = this.cEf.adf.getLastKnownLocation(this.cEf.cDZ);
                    if (this.cEf.cDX != null) {
                        this.cEf.cDX = this.cEf.m15709a(this.cEf.cDX, but.bGD.g(this.cEf.cph));
                        if (System.currentTimeMillis() - this.cEf.cDX.getTime() > 300000) {
                            MFLogger.d(CommuteTimeService.TAG, "Runnable after 5s over 5 mins not trust");
                            this.cEf.finish();
                            return;
                        }
                        this.cEf.m15711b(this.cEf.cDX);
                        return;
                    }
                    this.cEf.finish();
                    return;
                }
                MFLogger.d(CommuteTimeService.TAG, "Runnable after 5s permission not granted");
                this.cEf.finish();
            }
        }
    }

    class C49283 implements d<djk.b, a> {
        final /* synthetic */ CommuteTimeService cEf;

        C49283(CommuteTimeService commuteTimeService) {
            this.cEf = commuteTimeService;
        }

        public /* synthetic */ void onError(Object obj) {
            m15698a((a) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m15699a((djk.b) obj);
        }

        public void m15699a(djk.b bVar) {
            MFLogger.d(CommuteTimeService.TAG, "getDurationTime duration " + bVar.getDuration());
            this.cEf.CZ = bVar.getDuration();
            if (this.cEf.CZ < 60) {
                this.cEf.CZ = 60;
            }
            this.cEf.afA();
        }

        public void m15698a(a aVar) {
            this.cEf.finish();
        }
    }

    public static void m15702a(Context context, Bundle bundle, cta com_fossil_cta) {
        Intent intent = new Intent(context, CommuteTimeService.class);
        intent.putExtras(bundle);
        context.startService(intent);
        a(com_fossil_cta);
    }

    public void onCreate() {
        super.onCreate();
        MFLogger.d(TAG, "onCreate");
        PortfolioApp.ZQ().aam().a(this);
        this.mHandler = new Handler();
        this.mSerial = PortfolioApp.ZQ().aaa();
        afu();
        afv();
        this.cEa.a(this.cEe, new IntentFilter(PortfolioApp.ZQ().getPackageName().concat(ButtonService.ACTION_SERVICE_BLE_RESPONSE)));
    }

    private void afu() {
        MFLogger.d(TAG, "initGoogleApiClient");
        this.cph = new atv.a(this).b(this).c(this).c(bvd.bGP).c(but.bfF).KI();
        this.cph.connect();
        afw();
    }

    private void afv() {
        MFLogger.d(TAG, "initLocationManager");
        if (eg.b(this.cEc, "android.permission.ACCESS_FINE_LOCATION") == 0 || eg.b(this.cEc, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            Criteria criteria = new Criteria();
            criteria.setPowerRequirement(1);
            this.adf = (LocationManager) getSystemService("location");
            if (this.adf.isProviderEnabled("network")) {
                criteria.setAccuracy(2);
            } else {
                criteria.setAccuracy(1);
            }
            this.cDZ = this.adf.getBestProvider(criteria, true);
            if (this.adf != null) {
                MFLogger.d(TAG, "mLocationManager");
                this.adf.requestLocationUpdates(this.cDZ, 0, 0.0f, this);
                return;
            }
            return;
        }
        finish();
    }

    private void afw() {
        MFLogger.d(TAG, "createLocationRequest");
        this.cEd = new LocationRequest();
        this.cEd.ar(1000);
        this.cEd.as(1000);
        this.cEd.ik(100);
        this.cEd.m14249V(50.0f);
    }

    protected void afx() {
        MFLogger.d(TAG, "startLocationUpdates");
        if (eg.b(PortfolioApp.ZQ(), "android.permission.ACCESS_FINE_LOCATION") == 0 && eg.b(PortfolioApp.ZQ(), "android.permission.ACCESS_COARSE_LOCATION") == 0 && LocationUtils.isLocationEnable(PortfolioApp.ZQ())) {
            but.bGD.a(this.cph, this.cEd, this);
            return;
        }
        MFLogger.d(TAG, "startLocationUpdates permission not granted");
        finish();
    }

    public void onDestroy() {
        MFLogger.d(TAG, "onDestroy");
        super.onDestroy();
        this.cph.disconnect();
        this.cEa.unregisterReceiver(this.cEe);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.adf != null) {
            this.adf.removeUpdates(this);
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        MFLogger.d(TAG, "onStartCommand");
        this.cDU = MicroAppAction.SHOW_COMMUTE;
        super.afr();
        if (this.cDY == null) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                String string = extras.getString(Constants.EXTRA_INFO);
                MFLogger.d(TAG, "onStartCommand json=" + string);
                this.cDY = (CommuteTimeSettings) new cfj().c(string, CommuteTimeSettings.class);
                this.mHandler.postDelayed(new C49272(this), 5000);
            }
        }
        return 2;
    }

    public void m15712l(Bundle bundle) {
        MFLogger.d(TAG, "onConnected GoogleAPIClient");
        if (eg.b(this.cEc, "android.permission.ACCESS_FINE_LOCATION") != 0 && eg.b(this.cEc, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            finish();
        } else if (LocationUtils.isLocationEnable(PortfolioApp.ZQ())) {
            afx();
        } else {
            finish();
        }
    }

    public void onLocationChanged(Location location) {
        MFLogger.d(TAG, "onLocationChanged");
        if (!(this.cDY == null || location == null || this.cDW != null)) {
            MFLogger.d(TAG, "onLocationChanged location=lat: " + location.getLatitude() + " long: " + location.getLongitude());
            this.cDW = location;
            m15711b(this.cDW);
        }
        if (this.adf != null) {
            this.adf.removeUpdates(this);
        }
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
        MFLogger.d(TAG, "onStatusChanged status=" + i);
    }

    public void onProviderEnabled(String str) {
        MFLogger.d(TAG, "onProviderEnabled provider=" + str);
    }

    public void onProviderDisabled(String str) {
        MFLogger.d(TAG, "onProviderDisabled provider=" + str);
    }

    public void m15711b(Location location) {
        MFLogger.d(TAG, "getDurationTime location long=" + location.getLongitude() + " lat=" + location.getLatitude());
        if (this.cDY != null && !this.cDY.getDestination().isEmpty()) {
            this.mUseCaseHandler.a(this.cEb, new djk.a(location.getLatitude(), location.getLongitude(), this.cDY.getDestination(), this.cDY.isIsAvoidTolls()), new C49283(this));
        }
    }

    private void afy() {
        MFLogger.d(TAG, "playHandsMinute");
        try {
            PortfolioApp.ZQ().sendMicroAppRemoteActivity(this.mSerial, new CommuteTravelTimeInstruction((int) (this.CZ / 60)));
        } catch (IllegalArgumentException e) {
            MFLogger.d(TAG, "playHandsMinute exception exception=" + e.getMessage());
        }
        finish();
    }

    private void afz() {
        MFLogger.d(TAG, "playHandsETA");
        long currentTimeMillis = System.currentTimeMillis() + (this.CZ * 1000);
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(currentTimeMillis);
        int i = instance.get(11) % 12;
        int i2 = instance.get(12);
        MFLogger.d(TAG, "playHandsETA - duration=" + this.CZ + ", hour=" + i + ", minute=" + i2);
        try {
            PortfolioApp.ZQ().sendMicroAppRemoteActivity(this.mSerial, new CommuteETAInstruction(i, i2));
        } catch (IllegalArgumentException e) {
            MFLogger.d(TAG, "playHandsETA exception exception=" + e.getMessage());
        }
        finish();
    }

    private void afA() {
        MFLogger.d(TAG, "playHands");
        if (this.cDY.getTimeFormat() == CommuteTimeSettings$TIME_FORMAT.TRAVEL) {
            afy();
        } else {
            afz();
        }
    }

    public void hr(int i) {
        MFLogger.d(TAG, "onConnectionSuspended GoogleAPIClient");
        if (eg.b(this.cEc, "android.permission.ACCESS_FINE_LOCATION") != 0 && eg.b(this.cEc, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            finish();
        }
    }

    public void m15710a(atn com_fossil_atn) {
        MFLogger.d(TAG, "onConnectionFailed GoogleAPIClient");
        if (eg.b(this.cEc, "android.permission.ACCESS_FINE_LOCATION") != 0 && eg.b(this.cEc, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            finish();
        }
    }

    public void finish() {
        MFLogger.d(TAG, "finish");
        super.finish();
        stopSelf();
    }

    public void aft() {
        MFLogger.d(TAG, "forceStop");
        finish();
    }

    protected Location m15709a(Location location, Location location2) {
        Object obj = 1;
        MFLogger.d(TAG, "isBetterLocation location long=" + location.getLongitude() + " lat=" + location.getLatitude() + " time=" + location.getTime());
        if (location2 == null) {
            MFLogger.d(TAG, "isBetterLocation currentBestLocation null");
            return location;
        }
        Object obj2;
        Object obj3;
        MFLogger.d(TAG, "isBetterLocation currentBestLocation long=" + location2.getLongitude() + " lat=" + location2.getLatitude() + " time=" + location2.getTime());
        long time = location.getTime() - location2.getTime();
        Object obj4 = time > 120000 ? 1 : null;
        if (time < -120000) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (time > 0) {
            obj3 = 1;
        } else {
            obj3 = null;
        }
        if (obj4 != null) {
            MFLogger.d(TAG, "isBetterLocation isSignificantlyNewer");
            return location;
        } else if (obj2 != null) {
            MFLogger.d(TAG, "isBetterLocation isSignificantlyOlder");
            return location2;
        } else {
            MFLogger.d(TAG, "isBetterLocation accuracy location=" + location.getAccuracy() + " currentBestLocation=" + location2.getAccuracy());
            int accuracy = (int) (location.getAccuracy() - location2.getAccuracy());
            obj4 = accuracy > 0 ? 1 : null;
            if (accuracy < 0) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (accuracy <= MFNetworkReturnCode.RESPONSE_OK) {
                obj = null;
            }
            boolean aB = aB(location.getProvider(), location2.getProvider());
            if (obj2 != null) {
                MFLogger.d(TAG, "isBetterLocation isMoreAccurate");
                return location;
            } else if (obj3 != null && obj4 == null) {
                MFLogger.d(TAG, "isBetterLocation isNewer && isLessAccurate=false");
                return location;
            } else if (obj3 == null || r0 != null || !aB) {
                return location2;
            } else {
                MFLogger.d(TAG, "isBetterLocation isNewer && isSignificantlyLessAccurate=false && isFromSameProvider");
                return location;
            }
        }
    }

    private boolean aB(String str, String str2) {
        MFLogger.d(TAG, "isSameProvider");
        if (str == null) {
            return str2 == null;
        } else {
            return str.equals(str2);
        }
    }
}
