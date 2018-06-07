package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.responses.MFResponse;
import com.misfit.frameworks.network.utils.NetworkUtils;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.DeviceModel;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.source.DataVersioningRepository;
import com.portfolio.platform.data.source.DeviceDataSource.RemoveDeviceCallback;
import com.portfolio.platform.data.source.DeviceRepository;
import com.portfolio.platform.data.source.UserDataSource.OnUpdateUserComplete;
import com.portfolio.platform.data.source.UserRepository;

public class cyy extends ckb<C2555a, C2557c, C2556b> {
    private static final String TAG = cyy.class.getSimpleName();
    private DataVersioningRepository czr;
    private DeviceRepository mDeviceRepository;
    private UserRepository mUserRepository;

    class C25542 implements OnUpdateUserComplete {
        final /* synthetic */ cyy cLL;

        C25542(cyy com_fossil_cyy) {
            this.cLL = com_fossil_cyy;
        }

        public void onComplete(MFResponse mFResponse, boolean z, MFUser mFUser) {
        }
    }

    public static final class C2555a implements C2132b {
        private final String cFB;

        public C2555a(String str) {
            this.cFB = (String) cco.m5996s(str, "device serial cannot be null!");
        }

        public String getDeviceSerial() {
            return this.cFB;
        }
    }

    public static final class C2556b implements C2131a {
        private int errorCode;

        public C2556b(int i) {
            this.errorCode = i;
        }

        public int getErrorCode() {
            return this.errorCode;
        }
    }

    public static final class C2557c implements C2133c {
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m7954a((C2555a) c2132b);
    }

    public cyy(DeviceRepository deviceRepository, UserRepository userRepository, DataVersioningRepository dataVersioningRepository) {
        this.mDeviceRepository = deviceRepository;
        this.mUserRepository = userRepository;
        this.czr = dataVersioningRepository;
    }

    protected void m7954a(C2555a c2555a) {
        if (NetworkUtils.isNetworkAvailable(PortfolioApp.ZQ())) {
            DeviceModel hd = cnq.acd().acp().hd(c2555a.getDeviceSerial());
            final String aaa = PortfolioApp.ZQ().aaa();
            if (hd == null) {
                ie(aaa);
                return;
            } else {
                this.mDeviceRepository.removeDevice(hd, new RemoveDeviceCallback(this) {
                    final /* synthetic */ cyy cLL;

                    public void onSuccess() {
                        this.cLL.ie(aaa);
                    }

                    public void onFailed(int i) {
                        MFLogger.m12671e(cyy.TAG, "Error inside " + cyy.TAG + ".unlinkDevice failed! on server, error=" + i);
                        this.cLL.abr().onError(new C2556b(i));
                    }
                });
                return;
            }
        }
        abr().onError(new C2556b(601));
    }

    private void ie(String str) {
        try {
            this.czr.clearDeviceDataVersioning();
            PortfolioApp.ZQ().fP(((C2555a) abq()).getDeviceSerial());
            if (str.equalsIgnoreCase(((C2555a) abq()).getDeviceSerial())) {
                String nextActiveDevice = this.mDeviceRepository.getNextActiveDevice();
                PortfolioApp.ZQ().fO(nextActiveDevice);
                MFLogger.m12670d(TAG, "We just removed active device, automatically set next device as active if possible, nextActive=" + nextActiveDevice);
            }
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".unlinkDevice success on server but failed on BLE - e=" + e);
        }
        akc();
        abr().onSuccess(new C2557c());
    }

    private void akc() {
        MFUser currentUser = this.mUserRepository.getCurrentUser();
        if (currentUser != null) {
            currentUser.setActiveDeviceId(PortfolioApp.ZQ().aaa());
            this.mUserRepository.addOrUpdateUser(currentUser, new C25542(this));
        }
    }
}
