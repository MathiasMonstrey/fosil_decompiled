package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.portfolio.platform.data.model.Ringtone;
import java.util.ArrayList;

public class djw extends ckb<C2132b, C2856a, C2131a> {

    public static final class C2856a implements C2133c {
        private ArrayList<Ringtone> cXK;

        public C2856a(ArrayList<Ringtone> arrayList) {
            this.cXK = arrayList;
        }

        public ArrayList<Ringtone> aqB() {
            return this.cXK;
        }
    }

    protected void mo2022b(C2132b c2132b) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(cmk.abF());
        abr().onSuccess(new C2856a(arrayList));
    }
}
