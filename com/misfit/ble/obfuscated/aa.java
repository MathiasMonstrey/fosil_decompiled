package com.misfit.ble.obfuscated;

import com.misfit.ble.setting.eventmapping.GoalTrackingEventMapping;
import com.misfit.ble.setting.uapp.UAppEnum$UAppSystemLevelEvent;
import com.misfit.ble.setting.uapp.UAppEventSetting;
import com.misfit.ble.setting.uapp.UAppSystemVersion;
import com.misfit.ble.setting.uapp.files.customization.UAppCustomizationFrame;
import com.misfit.ble.setting.uapp.files.declaration.UAppDeclarationFrame;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class aa extends C4436x {
    protected LinkedHashSet<ae> bR;
    protected LinkedHashSet<UAppDeclarationFrame> bS;
    protected LinkedHashSet<UAppCustomizationFrame> bT;

    protected aa() {
        m14675a(new UAppSystemVersion(GoalTrackingEventMapping.INVALID_GOAL_ID_NUMBER, GoalTrackingEventMapping.INVALID_GOAL_ID_NUMBER), (byte) 0);
        m14679a(new LinkedHashSet());
    }

    public aa(UAppSystemVersion uAppSystemVersion, Set<UAppEventSetting> set) throws IllegalArgumentException {
        if (uAppSystemVersion == null) {
            throw new IllegalArgumentException("uAppSystemVersion must not be null or empty.");
        } else if (set == null || set.isEmpty()) {
            throw new IllegalArgumentException("uAppEventMappings must not be null or empty.");
        } else {
            m14675a(uAppSystemVersion, (byte) 0);
            m14679a(set);
        }
    }

    protected void m14679a(Set<UAppEventSetting> set) {
        this.bR = new LinkedHashSet();
        this.bS = new LinkedHashSet();
        this.bT = new LinkedHashSet();
        if (set != null && !set.isEmpty()) {
            for (UAppEventSetting uAppEventSetting : set) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Collection linkedHashSet2 = new LinkedHashSet();
                for (UAppDeclarationFrame uAppDeclarationFrame : uAppEventSetting.getUAppDeclarationFrameList()) {
                    if (uAppDeclarationFrame.isCustomizationRequired()) {
                        UAppCustomizationFrame customizationFrame = uAppDeclarationFrame.getCustomizationFrame();
                        if (customizationFrame == null) {
                            throw new IllegalArgumentException("UApp " + uAppDeclarationFrame.getUAppId() + "-" + uAppDeclarationFrame.getUAppVariant() + "required customization.");
                        }
                        linkedHashSet2.add(customizationFrame);
                    }
                    linkedHashSet.add(new C4596v(uAppDeclarationFrame.m15252E()));
                }
                this.bR.add(new ae(UAppEnum$UAppSystemLevelEvent.get(uAppEventSetting.getUAppButtonEvent().getId()), linkedHashSet));
                this.bS.addAll(uAppEventSetting.getUAppDeclarationFrameList());
                this.bT.addAll(linkedHashSet2);
            }
        }
    }

    public byte[] getData() throws IllegalArgumentException {
        ByteBuffer allocate = ByteBuffer.allocate(2048);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        byte[] G = m14676G();
        byte[] H = m14677H();
        byte[] I = m14678I();
        try {
            allocate.put(G);
            allocate.put(H);
            allocate.put(I);
            int position = allocate.position();
            H = new byte[position];
            allocate.rewind();
            allocate.get(H, 0, position);
            return H;
        } catch (Exception e) {
            throw new IllegalArgumentException("Configuration File data length exceeds 2048 bytes");
        }
    }

    protected byte[] m14676G() {
        return new ad(this.bM, this.bR).getData();
    }

    protected byte[] m14677H() {
        return new ac(this.bM, this.bS).getData();
    }

    protected byte[] m14678I() {
        return new ab(this.bM, this.bT).getData();
    }
}
