package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.fossil.wearables.fsl.contact.ContactGroup;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.List;

public class dcv extends ckb<C2676b, C2677c, C2675a> {
    public static final String TAG = dcv.class.getSimpleName();

    public static final class C2675a implements C2131a {
    }

    public static final class C2676b implements C2132b {
    }

    public static final class C2677c implements C2133c {
        private List<ContactGroup> cQC;

        public List<ContactGroup> amu() {
            return this.cQC;
        }

        public C2677c(List<ContactGroup> list) {
            this.cQC = list;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m8345a((C2676b) c2132b);
    }

    dcv() {
    }

    protected void m8345a(C2676b c2676b) {
        MFLogger.m12670d(TAG, "executeUseCase");
        abr().onSuccess(new C2677c(cnq.acd().ack().getAllContactGroups()));
    }
}
