package com.misfit.ble.obfuscated;

import com.fossil.jt;
import com.misfit.ble.shine.ActionID;
import java.util.Hashtable;
import java.util.Map.Entry;

public class ch {
    private Hashtable<String, jt<ba, ci>> kK;
    private C4445a kL;

    public interface C4445a {
        void mo4809a(String str, byte[] bArr);

        void mo4810b(ba baVar, int i, int i2, int i3, int i4);
    }

    public ch(C4445a c4445a) throws IllegalArgumentException {
        if (c4445a == null) {
            throw new IllegalArgumentException("callback must not be null.");
        }
        this.kK = new Hashtable();
        this.kL = c4445a;
    }

    public void bR() {
        this.kK.clear();
    }

    public void m15017e(ba baVar, ci ciVar) throws IllegalArgumentException {
        if (baVar == null) {
            throw new IllegalArgumentException("phaseController must not be null.");
        } else if (ciVar == null) {
            throw new IllegalArgumentException("protocol must not be null.");
        } else {
            String characteristicUUID = ciVar.getCharacteristicUUID();
            if (!this.kK.containsKey(characteristicUUID)) {
                this.kK.put(characteristicUUID, new jt(baVar, ciVar));
                m15014a(characteristicUUID, ciVar);
            }
        }
    }

    public void m15016d(ActionID actionID) {
        for (Entry entry : this.kK.entrySet()) {
            if (((ba) ((jt) entry.getValue()).first).aR() == actionID) {
                this.kK.remove(entry.getKey());
                return;
            }
        }
    }

    public void m15015a(String str, int i) {
        jt jtVar = (jt) this.kK.get(str);
        if (jtVar != null) {
            ba baVar = (ba) jtVar.first;
            ci ciVar = (ci) jtVar.second;
            if (baVar != null && ciVar != null) {
                this.kL.mo4810b(baVar, i == 0 ? 0 : 1, i, ciVar.bS(), ciVar.bT());
                if (i == 0) {
                    m15014a(str, ciVar);
                }
            }
        }
    }

    private void m15014a(String str, ci ciVar) {
        if (str != null && ciVar != null && ciVar.bW()) {
            this.kL.mo4809a(str, ciVar.bX());
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        bR();
        this.kL = null;
    }
}
