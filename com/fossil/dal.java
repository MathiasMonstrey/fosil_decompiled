package com.fossil;

import android.content.Context;
import android.os.Handler;
import com.fossil.ckb.C2126d;
import com.fossil.ckb.C2131a;
import com.fossil.daj.C2601a;
import com.fossil.daj.C2602b;
import com.fossil.dar.C2611a;
import com.fossil.dar.C2612b;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.utils.NetworkUtils;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.source.UserRepository;
import java.util.concurrent.TimeUnit;

public class dal implements C2601a {
    private static final long cNw = TimeUnit.SECONDS.toMillis(1);
    private final String TAG = "DeviceLocateProximityPresenter";
    private final C2602b cNx;
    private final dar cNy;
    private final Runnable cNz = new C26091(this);
    private Context mApplicationContext;
    private final String mDeviceId;
    private final Handler mHandler = new Handler();
    private int mRssi;
    private final cnr mSharedPreferencesManager;
    private final ckc mUseCaseHandler;
    private UserRepository mUserRepository;

    class C26091 implements Runnable {
        final /* synthetic */ dal cNA;

        class C26081 implements C2126d<C2612b, C2131a> {
            final /* synthetic */ C26091 cNB;

            C26081(C26091 c26091) {
                this.cNB = c26091;
            }

            public /* synthetic */ void onError(Object obj) {
                m8088a((C2131a) obj);
            }

            public /* synthetic */ void onSuccess(Object obj) {
                m8089a((C2612b) obj);
            }

            public void m8089a(C2612b c2612b) {
                int rssi = c2612b.getRssi();
                MFLogger.m12670d("DeviceLocateProximityPresenter", "getRssi onSuccess - rssi: " + rssi);
                this.cNB.cNA.mRssi = rssi;
                this.cNB.cNA.updateRssi(rssi);
            }

            public void m8088a(C2131a c2131a) {
                MFLogger.m12670d("DeviceLocateProximityPresenter", "getRssi onError");
                this.cNB.cNA.mRssi = 0;
                this.cNB.cNA.updateRssi(0);
            }
        }

        C26091(dal com_fossil_dal) {
            this.cNA = com_fossil_dal;
        }

        public void run() {
            this.cNA.mUseCaseHandler.m6886a(this.cNA.cNy, new C2611a(this.cNA.mDeviceId), new C26081(this));
        }
    }

    dal(Context context, cnr com_fossil_cnr, String str, C2602b c2602b, ckc com_fossil_ckc, UserRepository userRepository, dar com_fossil_dar) {
        this.mApplicationContext = (Context) cco.m5996s(context, "applicationContext cannot be null!");
        this.mSharedPreferencesManager = (cnr) cco.m5996s(com_fossil_cnr, "sharedPreferencesManager cannot be null!");
        this.cNx = (C2602b) cco.m5996s(c2602b, "view cannot be null!");
        this.mUserRepository = userRepository;
        this.mDeviceId = (String) cco.m5996s(str, "deviceId cannot be null!");
        this.mUseCaseHandler = (ckc) cco.m5996s(com_fossil_ckc, "useCaseHandler cannot be null!");
        this.cNy = (dar) cco.m5996s(com_fossil_dar, "getRssi cannot be null!");
    }

    public void ahu() {
        this.cNx.cK(this);
    }

    public void start() {
        this.cNy.ajd();
        boolean ade = this.mSharedPreferencesManager.ade();
        updateRssi(this.mRssi);
        this.cNx.mo2229j(ade, false);
        MFUser currentUser = this.mUserRepository.getCurrentUser();
        if (currentUser != null) {
            this.cNx.mo2228d(currentUser);
        }
    }

    public void stop() {
        this.cNy.aje();
    }

    public void cC(boolean z) {
        MFLogger.m12670d("DeviceLocateProximityPresenter", "enableLocate: enable = " + z);
        this.mSharedPreferencesManager.cb(z);
        this.cNx.mo2229j(z, this.mSharedPreferencesManager.adi());
        if (z) {
            updateRssi(this.mRssi);
        }
    }

    public void akR() {
        MFLogger.m12670d("DeviceLocateProximityPresenter", "locateOnMap");
        if (!NetworkUtils.isNetworkAvailable(this.mApplicationContext)) {
            this.cNx.jV(601);
        } else if (!dre.dff.cx(this.mApplicationContext)) {
            this.cNx.akS();
        } else if (dre.dff.auC()) {
            this.cNx.akU();
        } else {
            this.cNx.akT();
        }
    }

    private void updateRssi(int i) {
        this.cNx.ko(i);
        this.mHandler.removeCallbacks(this.cNz);
        this.mHandler.postDelayed(this.cNz, cNw);
    }
}
