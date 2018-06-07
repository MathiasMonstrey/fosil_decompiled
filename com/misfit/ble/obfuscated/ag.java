package com.misfit.ble.obfuscated;

import com.misfit.ble.setting.uapp.instruction.UAppInstruction;
import com.misfit.ble.setting.uapp.instruction.UAppInstruction.C4606a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONObject;

public class ag extends UAppInstruction {
    private C4438a cj;
    private List<al> ck;

    class C44371 implements Comparator<al> {
        final /* synthetic */ ag cl;

        C44371(ag agVar) {
            this.cl = agVar;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m14683a((al) obj, (al) obj2);
        }

        public int m14683a(al alVar, al alVar2) {
            return alVar.m14693O().compareTo(alVar2.m14693O());
        }
    }

    public enum C4438a {
        SIMPLE_MOVEMENT((byte) 1);
        
        private final byte ax;

        private C4438a(byte b) {
            this.ax = b;
        }

        public byte getId() {
            return this.ax;
        }
    }

    public ag(List<al> list) throws IllegalArgumentException {
        if (list == null) {
            throw new IllegalArgumentException("uAppHandSettings must not be null.");
        }
        this.cp = C4606a.DO_ANIMATION_INSTRUCTION;
        this.cj = C4438a.SIMPLE_MOVEMENT;
        this.ck = m14684b(list);
    }

    protected byte[] mo4806K() {
        ByteBuffer allocate = ByteBuffer.allocate((this.ck.size() * 3) + 2);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(this.cj.getId());
        allocate.put((byte) 0);
        byte b = (byte) 0;
        for (int i = 0; i < this.ck.size(); i++) {
            al alVar = (al) this.ck.get(i);
            b = (byte) (b | alVar.m14693O().getId());
            allocate.put(alVar.getData());
        }
        allocate.put(1, b);
        return allocate.array();
    }

    private List<al> m14684b(List<al> list) {
        if (list == null) {
            return null;
        }
        Collection treeSet = new TreeSet(new C44371(this));
        treeSet.addAll(list);
        return new ArrayList(treeSet);
    }

    public JSONObject toJSONObject() {
        JSONObject toJSONObject = super.toJSONObject();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("animationType", this.cj);
            JSONArray jSONArray = new JSONArray();
            for (al toJSONObject2 : this.ck) {
                jSONArray.put(toJSONObject2.toJSONObject());
            }
            jSONObject.put("handSettings", jSONArray);
            toJSONObject.put("parameters", jSONObject);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return toJSONObject;
    }
}
