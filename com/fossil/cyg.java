package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.OwnershipDeviceBox.OwnerShip;
import com.portfolio.platform.data.model.DeviceModel;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.response.device.MFGetWatchResponse;

public final class cyg extends ckb<C2506c, C2507d, C2505b> {
    private static final String TAG = TAG;
    public static final C2504a cKO = new C2504a();
    private UserRepository mUserRepository;

    public static final class C2504a {
        private C2504a() {
        }

        private final String getTAG() {
            return cyg.TAG;
        }
    }

    public static final class C2505b implements C2131a {
        private final OwnerShip cKP;
        private final String deviceId;

        public C2505b(String str, OwnerShip ownerShip) {
            esl.m11128j(str, "deviceId");
            this.deviceId = str;
            this.cKP = ownerShip;
        }

        public final OwnerShip ajN() {
            return this.cKP;
        }

        public final String getDeviceId() {
            return this.deviceId;
        }
    }

    public static final class C2506c implements C2132b {
        private final String deviceId;

        public C2506c(String str) {
            esl.m11128j(str, "deviceId");
            this.deviceId = str;
        }

        public final String getDeviceId() {
            return this.deviceId;
        }
    }

    public static final class C2507d implements C2133c {
        private final OwnerShip cKP;
        private final String deviceId;

        public C2507d(String str, OwnerShip ownerShip) {
            esl.m11128j(str, "deviceId");
            esl.m11128j(ownerShip, "ownerShip");
            this.deviceId = str;
            this.cKP = ownerShip;
        }

        public final OwnerShip ajN() {
            return this.cKP;
        }

        public final String getDeviceId() {
            return this.deviceId;
        }
    }

    public static final class C2508e implements MFServerResultCallback {
        final /* synthetic */ cyg cKQ;
        final /* synthetic */ String cKR;

        C2508e(cyg com_fossil_cyg, String str) {
            this.cKQ = com_fossil_cyg;
            this.cKR = str;
        }

        public void onSuccess(MFResponse mFResponse) {
            esl.m11128j(mFResponse, "mfResponse");
            MFLogger.m12670d(cyg.cKO.getTAG(), "onResponse - deviceId=" + this.cKR + ", success");
            DeviceModel deviceInformation = ((MFGetWatchResponse) mFResponse).getDeviceInformation();
            String owner = deviceInformation != null ? deviceInformation.getOwner() : null;
            MFUser currentUser = this.cKQ.mUserRepository.getCurrentUser();
            if (currentUser != null) {
                String userId = currentUser.getUserId();
                if (userId != null) {
                    MFLogger.m12670d(cyg.cKO.getTAG(), "onResponse - deviceId=" + this.cKR + ", resUserId=" + owner + ", curUserId=" + userId);
                    if (etc.m11134c(userId, owner, true)) {
                        this.cKQ.abr().onError(new C2505b(this.cKR, OwnerShip.MyOwn));
                    } else {
                        this.cKQ.abr().onSuccess(new C2507d(this.cKR, OwnerShip.None));
                    }
                }
            }
        }

        public void onFail(int i, MFResponse mFResponse) {
            esl.m11128j(mFResponse, "mfResponse");
            switch (mFResponse.getHttpReturnCode()) {
                case MFNetworkReturnCode.WRONG_PASSWORD /*403*/:
                    switch (mFResponse.getInternalErrorCode()) {
                        case 4030:
                            this.cKQ.abr().onSuccess(new C2507d(this.cKR, OwnerShip.OtherOwn));
                            return;
                        case 4031:
                            this.cKQ.abr().onError(new C2505b(this.cKR, null));
                            return;
                        default:
                            return;
                    }
                case 404:
                    this.cKQ.abr().onSuccess(new C2507d(this.cKR, OwnerShip.None));
                    return;
                default:
                    this.cKQ.abr().onError(new C2505b(this.cKR, OwnerShip.OtherOwn));
                    return;
            }
        }
    }

    public /* synthetic */ void mo2022b(C2132b c2132b) {
        m7896a((C2506c) c2132b);
    }

    public cyg(UserRepository userRepository) {
        esl.m11128j(userRepository, "mUserRepository");
        this.mUserRepository = userRepository;
    }

    protected void m7896a(C2506c c2506c) {
        esl.m11128j(c2506c, "requestValues");
        String deviceId = c2506c.getDeviceId();
        MFLogger.m12670d(cKO.getTAG(), "executeUseCase - deviceId=" + deviceId);
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new crh(PortfolioApp.ZQ(), deviceId), new C2508e(this, deviceId));
    }
}
