package com.fossil;

import android.util.SparseArray;
import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.fossil.wearables.fsl.shared.BaseFeatureModel;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.source.NotificationsRepository;
import java.util.List;

public class dcx extends ckb<C2132b, C2678a, C2131a> {
    public static final String TAG = dcx.class.getSimpleName();
    private NotificationsRepository mRepository;

    public static final class C2678a implements C2133c {
        SparseArray<List<BaseFeatureModel>> arB;

        public SparseArray<List<BaseFeatureModel>> amw() {
            return this.arB;
        }

        C2678a(SparseArray<List<BaseFeatureModel>> sparseArray) {
            this.arB = sparseArray;
        }
    }

    public dcx(NotificationsRepository notificationsRepository) {
        this.mRepository = (NotificationsRepository) cco.ce(notificationsRepository);
    }

    protected void mo2022b(C2132b c2132b) {
        MFLogger.m12670d(TAG, "executeUseCase");
        abr().onSuccess(new C2678a(this.mRepository.getAllNotificationsByHour(PortfolioApp.ZQ().aaa())));
    }
}
