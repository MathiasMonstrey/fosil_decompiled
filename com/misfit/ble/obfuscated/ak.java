package com.misfit.ble.obfuscated;

import com.misfit.ble.obfuscated.ai.C4439a;
import com.misfit.ble.obfuscated.al.C4440a;
import com.misfit.ble.obfuscated.al.C4441b;
import com.misfit.ble.obfuscated.al.C4442c;
import com.misfit.ble.obfuscated.al.C4443d;
import com.misfit.ble.obfuscated.al.C4444e;
import com.misfit.ble.setting.uapp.instruction.UAppInstruction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ak {
    private List<al> cW = Arrays.asList(new al[]{new al(C4440a.HOUR, 0, C4443d.POSITION, C4444e.PRESET, C4441b.SHORTEST_PATH, C4442c.FULL), new al(C4440a.MINUTE, 0, C4443d.POSITION, C4444e.PRESET, C4441b.SHORTEST_PATH, C4442c.FULL)});
    private double cX = 1.0d;
    private C4439a cY = C4439a.READY;
    private List<al> cZ = new ArrayList();
    private double da = 5.0d;

    public ak m14691c(List<al> list) {
        if (list == null) {
            this.cW = new ArrayList();
        }
        this.cW = list;
        return this;
    }

    public ak m14688a(double d) {
        this.cX = d;
        return this;
    }

    public ak m14689a(C4439a c4439a) {
        this.cY = c4439a;
        return this;
    }

    public ak m14692d(List<al> list) {
        if (list == null) {
            this.cZ = new ArrayList();
        }
        this.cZ = list;
        return this;
    }

    public ak m14690b(double d) {
        this.da = d;
        return this;
    }

    public List<UAppInstruction> m14687N() {
        List arrayList = new ArrayList();
        arrayList.add(new ah());
        if (!(this.cW == null || this.cW.isEmpty())) {
            arrayList.add(new ag(this.cW));
        }
        if (this.cX > 0.0d) {
            arrayList.add(new af(this.cX));
        }
        if (this.cY != null) {
            arrayList.add(new ai(this.cY));
        }
        if (!(this.cZ == null || this.cZ.isEmpty())) {
            arrayList.add(new ag(this.cZ));
        }
        if (this.da > 0.0d) {
            arrayList.add(new af(this.da));
        }
        arrayList.add(new aj());
        return arrayList;
    }
}
