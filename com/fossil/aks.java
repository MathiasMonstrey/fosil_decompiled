package com.fossil;

import com.fasterxml.jackson.core.JsonToken;
import java.util.Iterator;
import java.util.Map.Entry;

abstract class aks extends aez {
    protected String aMN;
    protected Object aOk;
    protected final aks aTQ;

    public static final class C1667a extends aks {
        protected Iterator<agz> aTR;
        protected agz aTS;

        public /* synthetic */ aez Az() {
            return super.Gn();
        }

        public C1667a(agz com_fossil_agz, aks com_fossil_aks) {
            super(1, com_fossil_aks);
            this.aTR = com_fossil_agz.DQ();
        }

        public JsonToken zP() {
            if (this.aTR.hasNext()) {
                this.aTS = (agz) this.aTR.next();
                return this.aTS.AE();
            }
            this.aTS = null;
            return null;
        }

        public JsonToken Go() {
            return JsonToken.END_ARRAY;
        }

        public agz Gp() {
            return this.aTS;
        }

        public boolean Gq() {
            return ((akm) Gp()).size() > 0;
        }
    }

    public static final class C1668b extends aks {
        protected Iterator<Entry<String, agz>> aTR;
        protected Entry<String, agz> aTT;
        protected boolean aTU = true;

        public /* synthetic */ aez Az() {
            return super.Gn();
        }

        public C1668b(agz com_fossil_agz, aks com_fossil_aks) {
            super(2, com_fossil_aks);
            this.aTR = ((akv) com_fossil_agz).DR();
        }

        public JsonToken zP() {
            if (!this.aTU) {
                this.aTU = true;
                return ((agz) this.aTT.getValue()).AE();
            } else if (this.aTR.hasNext()) {
                this.aTU = false;
                this.aTT = (Entry) this.aTR.next();
                this.aMN = this.aTT == null ? null : (String) this.aTT.getKey();
                return JsonToken.FIELD_NAME;
            } else {
                this.aMN = null;
                this.aTT = null;
                return null;
            }
        }

        public JsonToken Go() {
            return JsonToken.END_OBJECT;
        }

        public agz Gp() {
            return this.aTT == null ? null : (agz) this.aTT.getValue();
        }

        public boolean Gq() {
            return ((akm) Gp()).size() > 0;
        }
    }

    public static final class C1669c extends aks {
        protected agz aTV;
        protected boolean aTW = false;

        public /* synthetic */ aez Az() {
            return super.Gn();
        }

        public C1669c(agz com_fossil_agz, aks com_fossil_aks) {
            super(0, com_fossil_aks);
            this.aTV = com_fossil_agz;
        }

        public JsonToken zP() {
            if (this.aTW) {
                this.aTV = null;
                return null;
            }
            this.aTW = true;
            return this.aTV.AE();
        }

        public JsonToken Go() {
            return null;
        }

        public agz Gp() {
            return this.aTV;
        }

        public boolean Gq() {
            return false;
        }
    }

    public abstract JsonToken Go();

    public abstract agz Gp();

    public abstract boolean Gq();

    public abstract JsonToken zP();

    public /* synthetic */ aez Az() {
        return Gn();
    }

    public aks(int i, aks com_fossil_aks) {
        this._type = i;
        this._index = -1;
        this.aTQ = com_fossil_aks;
    }

    public final aks Gn() {
        return this.aTQ;
    }

    public final String zW() {
        return this.aMN;
    }

    public void bm(Object obj) {
        this.aOk = obj;
    }

    public final aks Gr() {
        agz Gp = Gp();
        if (Gp == null) {
            throw new IllegalStateException("No current node");
        } else if (Gp.isArray()) {
            return new C1667a(Gp, this);
        } else {
            if (Gp.DF()) {
                return new C1668b(Gp, this);
            }
            throw new IllegalStateException("Current node of type " + Gp.getClass().getName());
        }
    }
}
