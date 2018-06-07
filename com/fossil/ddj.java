package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.source.NotificationsRepository;
import com.portfolio.platform.model.PhoneFavoritesContact;
import java.util.ArrayList;
import java.util.List;

public class ddj extends ckb<C2686a, C2133c, C2131a> {
    private static final String TAG = ddj.class.getSimpleName();
    private NotificationsRepository mRepository;

    public static final class C2686a implements C2132b {
        private List<String> cQQ;
        private boolean cQm;

        public C2686a(List<String> list, boolean z) {
            this.cQQ = (List) cco.m5996s(list, "contactPhone cannot be null!");
            this.cQm = ((Boolean) cco.m5996s(Boolean.valueOf(z), "isFavorites cannot be null!")).booleanValue();
        }

        public List<String> amI() {
            return this.cQQ;
        }

        public boolean isFavorites() {
            return this.cQm;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m8373a((C2686a) c2132b);
    }

    public ddj(NotificationsRepository notificationsRepository) {
        this.mRepository = (NotificationsRepository) cco.ce(notificationsRepository);
    }

    protected void m8373a(C2686a c2686a) {
        MFLogger.m12670d(TAG, "executeUseCase");
        m8372a(this.mRepository, c2686a.amI(), c2686a.isFavorites());
        abr().onSuccess(null);
    }

    private static void m8372a(NotificationsRepository notificationsRepository, List<String> list, boolean z) {
        for (String str : new ArrayList(list)) {
            if (z) {
                notificationsRepository.savePhoneFavoritesContact(new PhoneFavoritesContact(dri.ju(str)));
            } else {
                notificationsRepository.removePhoneFavoritesContact(dri.ju(str));
            }
        }
    }
}
