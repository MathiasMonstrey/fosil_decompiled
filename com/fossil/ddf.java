package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.source.NotificationsRepository;
import com.portfolio.platform.model.PhoneFavoritesContact;
import java.util.List;

public class ddf extends ckb<C2684a, C2133c, C2131a> {
    private static final String TAG = ddf.class.getSimpleName();
    private NotificationsRepository mRepository;

    public static final class C2684a implements C2132b {
        private final List<PhoneFavoritesContact> cQM;

        public List<PhoneFavoritesContact> amE() {
            return this.cQM;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m8363a((C2684a) c2132b);
    }

    public ddf(NotificationsRepository notificationsRepository) {
        this.mRepository = (NotificationsRepository) cco.ce(notificationsRepository);
    }

    protected void m8363a(C2684a c2684a) {
        MFLogger.m12670d(TAG, "executeUseCase");
        m8361a(this.mRepository);
        m8362a(this.mRepository, c2684a.amE());
        abr().onSuccess(null);
    }

    public static void m8361a(NotificationsRepository notificationsRepository) {
        notificationsRepository.clearAllPhoneFavoritesContacts();
    }

    public static void m8362a(NotificationsRepository notificationsRepository, List<PhoneFavoritesContact> list) {
        for (PhoneFavoritesContact savePhoneFavoritesContact : list) {
            notificationsRepository.savePhoneFavoritesContact(savePhoneFavoritesContact);
        }
    }
}
