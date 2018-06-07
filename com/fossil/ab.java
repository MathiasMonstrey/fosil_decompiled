package com.fossil;

import android.os.IBinder;

public class ab {
    private final ac tA;
    private final x tB = new C15561(this);

    class C15561 extends x {
        final /* synthetic */ ab tC;

        C15561(ab abVar) {
            this.tC = abVar;
        }
    }

    ab(ac acVar) {
        this.tA = acVar;
    }

    IBinder eS() {
        return this.tA.asBinder();
    }

    public int hashCode() {
        return eS().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof ab) {
            return ((ab) obj).eS().equals(this.tA.asBinder());
        }
        return false;
    }
}
