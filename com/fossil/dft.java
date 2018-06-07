package com.fossil;

import android.content.Context;
import android.util.Log;
import com.fossil.ckb.C2126d;
import com.fossil.dfp.C2726a;
import com.fossil.dfp.C2727b;
import com.fossil.dpl.C3059a;
import com.fossil.dpl.C3060b;
import com.fossil.dpl.C3061c;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.model.UserSettings;
import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.response.user.MFGetCurrentUserSettingResponse;

public class dft implements C2726a {
    private static final String TAG = dft.class.getSimpleName();
    private final dpf cSm;
    private final dpl cSn;
    private final C2727b cTg;
    private MFUser cTi;
    private UserSettings cTj;
    private final Context mContext;
    private final ckc mUseCaseHandler;
    UserRepository mUserRepository;

    class C27331 implements MFServerResultCallback {
        final /* synthetic */ dft cTk;

        C27331(dft com_fossil_dft) {
            this.cTk = com_fossil_dft;
        }

        public void onSuccess(MFResponse mFResponse) {
            this.cTk.cTj = ((MFGetCurrentUserSettingResponse) mFResponse).getUserSettings();
            this.cTk.cTg.cM(this.cTk.cTj.isEnableNotification());
        }

        public void onFail(int i, MFResponse mFResponse) {
            Log.d(dft.TAG, "onFail() called with: i = [" + i + "], mfResponse = [" + mFResponse + "]");
        }
    }

    dft(C2727b c2727b, ckc com_fossil_ckc, dpf com_fossil_dpf, dpl com_fossil_dpl, Context context) {
        this.cTg = (C2727b) cco.m5996s(c2727b, "view cannot be null!");
        this.mUseCaseHandler = (ckc) cco.m5996s(com_fossil_ckc, "useCaseHandler cannot be null!");
        this.cSm = (dpf) cco.m5996s(com_fossil_dpf, "getUser cannot be null!");
        this.cSn = (dpl) cco.m5996s(com_fossil_dpl, "updateAvatar cannot be null!");
        this.mContext = (Context) cco.m5996s(context, "context cannot be null!");
    }

    public void ahu() {
        this.cTg.cK(this);
    }

    public void start() {
        Log.d(TAG, "presenter starts: Get user information");
        this.cTi = this.mUserRepository.getCurrentUser();
        if (this.cTi != null) {
            this.cTg.cN(this.cTi.isEmailOptIn());
            this.cTg.cO(this.cTi.isDiagnosticEnabled());
        }
        MFNetwork.getInstance(this.mContext).execute(new csq(this.mContext), new C27331(this));
    }

    public void stop() {
        Log.d(TAG, "presenter stop");
    }

    public void cM(final boolean z) {
        MFLogger.m12670d(TAG, "setReceivePushNotification() called with: checked = [" + z + "]");
        this.cTg.afT();
        if (this.cTj == null) {
            this.cTj = new UserSettings();
        }
        this.cTj.setEnableNotification(z);
        MFNetwork.getInstance(this.mContext).execute(new css(this.mContext, this.cTj), new MFServerResultCallback(this) {
            final /* synthetic */ dft cTk;

            public void onSuccess(MFResponse mFResponse) {
                this.cTk.cTj = ((MFGetCurrentUserSettingResponse) mFResponse).getUserSettings();
                this.cTk.cTg.afU();
            }

            public void onFail(int i, MFResponse mFResponse) {
                Log.d(dft.TAG, "onFail() called with: i = [" + i + "], mfResponse = [" + mFResponse + "]");
                this.cTk.cTg.cM(!z);
                this.cTk.cTg.afU();
            }
        });
    }

    public void cN(final boolean z) {
        if (this.cTi != null) {
            MFLogger.m12670d(TAG, "setReceiveOccasionalEmail() called with: checked = [" + z + "]");
            this.cTi.setEmailOptIn(z);
            this.cTg.afT();
            this.mUseCaseHandler.m6886a(this.cSn, new C3059a(this.cTi), new C2126d<C3061c, C3060b>(this) {
                final /* synthetic */ dft cTk;

                public /* synthetic */ void onError(Object obj) {
                    m8485a((C3060b) obj);
                }

                public /* synthetic */ void onSuccess(Object obj) {
                    m8486a((C3061c) obj);
                }

                public void m8486a(C3061c c3061c) {
                    this.cTk.cTg.afU();
                }

                public void m8485a(C3060b c3060b) {
                    this.cTk.cTg.cN(!z);
                    this.cTk.cTg.afU();
                }
            });
        }
    }

    public void cO(final boolean z) {
        if (this.cTi != null) {
            MFLogger.m12670d(TAG, "setAnonymouslySendUsageData() called with: checked = [" + z + "]");
            this.cTi.setDiagnosticEnabled(z);
            this.cTg.afT();
            this.mUseCaseHandler.m6886a(this.cSn, new C3059a(this.cTi), new C2126d<C3061c, C3060b>(this) {
                final /* synthetic */ dft cTk;

                public /* synthetic */ void onError(Object obj) {
                    m8487a((C3060b) obj);
                }

                public /* synthetic */ void onSuccess(Object obj) {
                    m8488a((C3061c) obj);
                }

                public void m8488a(C3061c c3061c) {
                    this.cTk.cTg.afU();
                }

                public void m8487a(C3060b c3060b) {
                    this.cTk.cTg.cO(!z);
                    this.cTk.cTg.afU();
                }
            });
        }
    }
}
