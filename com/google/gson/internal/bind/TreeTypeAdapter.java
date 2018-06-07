package com.google.gson.internal.bind;

import com.fossil.cfj;
import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.cfw;
import com.fossil.cfx;
import com.fossil.cgd;
import com.fossil.cgi;
import com.fossil.cgu;
import com.fossil.cgv;
import com.fossil.cgw;
import com.google.gson.JsonParseException;
import java.io.IOException;
import java.lang.reflect.Type;

public final class TreeTypeAdapter<T> extends cfw<T> {
    private cfw<T> bQX;
    private final cfv<T> bSF;
    private final cfo<T> bSG;
    private final cgu<T> bSH;
    private final cfx bSI;
    private final C4405a bSJ = new C4405a();
    private final cfj gson;

    static final class SingleTypeFactory implements cfx {
        private final cfv<?> bSF;
        private final cfo<?> bSG;
        private final cgu<?> bSL;
        private final boolean bSM;
        private final Class<?> bSN;

        SingleTypeFactory(Object obj, cgu<?> com_fossil_cgu_, boolean z, Class<?> cls) {
            this.bSF = obj instanceof cfv ? (cfv) obj : null;
            if (obj instanceof cfo) {
                obj = (cfo) obj;
            } else {
                obj = null;
            }
            this.bSG = obj;
            boolean z2 = (this.bSF == null && this.bSG == null) ? false : true;
            cgd.bz(z2);
            this.bSL = com_fossil_cgu_;
            this.bSM = z;
            this.bSN = cls;
        }

        public <T> cfw<T> m14622a(cfj com_fossil_cfj, cgu<T> com_fossil_cgu_T) {
            boolean isAssignableFrom = this.bSL != null ? this.bSL.equals(com_fossil_cgu_T) || (this.bSM && this.bSL.getType() == com_fossil_cgu_T.getRawType()) : this.bSN.isAssignableFrom(com_fossil_cgu_T.getRawType());
            return isAssignableFrom ? new TreeTypeAdapter(this.bSF, this.bSG, com_fossil_cfj, com_fossil_cgu_T, this) : null;
        }
    }

    final class C4405a implements cfn, cfu {
        final /* synthetic */ TreeTypeAdapter bSK;

        private C4405a(TreeTypeAdapter treeTypeAdapter) {
            this.bSK = treeTypeAdapter;
        }

        public cfp cI(Object obj) {
            return this.bSK.gson.cF(obj);
        }

        public cfp m14624c(Object obj, Type type) {
            return this.bSK.gson.a(obj, type);
        }

        public <R> R m14623b(cfp com_fossil_cfp, Type type) throws JsonParseException {
            return this.bSK.gson.a(com_fossil_cfp, type);
        }
    }

    public TreeTypeAdapter(cfv<T> com_fossil_cfv_T, cfo<T> com_fossil_cfo_T, cfj com_fossil_cfj, cgu<T> com_fossil_cgu_T, cfx com_fossil_cfx) {
        this.bSF = com_fossil_cfv_T;
        this.bSG = com_fossil_cfo_T;
        this.gson = com_fossil_cfj;
        this.bSH = com_fossil_cgu_T;
        this.bSI = com_fossil_cfx;
    }

    public T m14629b(cgv com_fossil_cgv) throws IOException {
        if (this.bSG == null) {
            return WO().b(com_fossil_cgv);
        }
        cfp g = cgi.g(com_fossil_cgv);
        if (g.Wz()) {
            return null;
        }
        return this.bSG.deserialize(g, this.bSH.getType(), this.bSJ);
    }

    public void m14628a(cgw com_fossil_cgw, T t) throws IOException {
        if (this.bSF == null) {
            WO().a(com_fossil_cgw, t);
        } else if (t == null) {
            com_fossil_cgw.Xe();
        } else {
            cgi.b(this.bSF.a(t, this.bSH.getType(), this.bSJ), com_fossil_cgw);
        }
    }

    private cfw<T> WO() {
        cfw<T> com_fossil_cfw_T = this.bQX;
        if (com_fossil_cfw_T != null) {
            return com_fossil_cfw_T;
        }
        com_fossil_cfw_T = this.gson.a(this.bSI, this.bSH);
        this.bQX = com_fossil_cfw_T;
        return com_fossil_cfw_T;
    }

    public static cfx m14626a(cgu<?> com_fossil_cgu_, Object obj) {
        return new SingleTypeFactory(obj, com_fossil_cgu_, false, null);
    }

    public static cfx m14627b(cgu<?> com_fossil_cgu_, Object obj) {
        return new SingleTypeFactory(obj, com_fossil_cgu_, com_fossil_cgu_.getType() == com_fossil_cgu_.getRawType(), null);
    }
}
