package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.source.UserRepository;

public class dpf extends ckb<C2132b, C3051a, C2131a> {
    private final UserRepository mUserRepository;

    public static class C3051a implements C2133c {
        private final MFUser cTi;

        public C3051a(MFUser mFUser) {
            this.cTi = mFUser;
        }

        public MFUser atE() {
            return this.cTi;
        }
    }

    dpf(UserRepository userRepository) {
        this.mUserRepository = userRepository;
    }

    protected void mo2022b(C2132b c2132b) {
        abr().onSuccess(new C3051a(this.mUserRepository.getCurrentUser()));
    }
}
