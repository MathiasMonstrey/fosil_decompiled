package com.misfit.ble.obfuscated;

import com.misfit.ble.obfuscated.av.C4455a;
import com.misfit.ble.obfuscated.ba.C4463a;
import com.misfit.ble.setting.eventmapping.EventMapping;
import com.misfit.ble.setting.flashlink.EventMappingEnum.C4601a;
import com.misfit.ble.setting.flashlink.EventMappingEnum.MemEventNumber;
import com.misfit.ble.shine.ShineActionID;
import com.misfit.ble.shine.ShineProfile;
import com.misfit.ble.shine.ShineProfile.ActionResult;
import com.misfit.ble.shine.ShineProfile.ConfigurationCallback;
import com.misfit.ble.shine.ShineProperty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ax {
    private C4463a fG;

    public ax(C4463a c4463a) {
        this.fG = c4463a;
    }

    public ba m14810a(final List<EventMapping> list, boolean z, final ConfigurationCallback configurationCallback) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Throwable e;
        Hashtable a;
        List arrayList;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("shouldClearEventOnButton", z);
                jSONObject2 = jSONObject;
            } catch (JSONException e2) {
                e = e2;
                C4462b.m14831a(e, "");
                jSONObject2 = jSONObject;
                a = m14805a((List) list, z);
                arrayList = new ArrayList();
                for (C4601a c4601a : a.keySet()) {
                    arrayList.addAll(m14806h((List) a.get(c4601a)));
                }
                return new av(ShineActionID.SET_EVENT_MAPPING, "phaseSetEventMapping", arrayList, this.fG, new C4455a(this) {
                    final /* synthetic */ ax hb;

                    public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                        Hashtable hashtable = new Hashtable();
                        hashtable.put(ShineProperty.EVENT_MAPPINGS, list);
                        configurationCallback.onConfigCompleted(baVar.aR(), actionResult, hashtable);
                        this.hb.fG.mo4916a(baVar, (long) ShineProfile.LOG_UPLOADING_DELAY);
                    }
                }, jSONObject2);
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            jSONObject = null;
            e = th;
            C4462b.m14831a(e, "");
            jSONObject2 = jSONObject;
            a = m14805a((List) list, z);
            arrayList = new ArrayList();
            while (r2.hasNext()) {
                arrayList.addAll(m14806h((List) a.get(c4601a)));
            }
            return new av(ShineActionID.SET_EVENT_MAPPING, "phaseSetEventMapping", arrayList, this.fG, /* anonymous class already generated */, jSONObject2);
        }
        a = m14805a((List) list, z);
        arrayList = new ArrayList();
        while (r2.hasNext()) {
            arrayList.addAll(m14806h((List) a.get(c4601a)));
        }
        return new av(ShineActionID.SET_EVENT_MAPPING, "phaseSetEventMapping", arrayList, this.fG, /* anonymous class already generated */, jSONObject2);
    }

    public ba m14809a(final ConfigurationCallback configurationCallback) {
        new gc().ca();
        return new av(ShineActionID.UNMAP_ALL_BUTTON_EVENTS, "phaseUnmapAllButtonEvents", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ ax hb;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, new Hashtable());
            }
        }, new JSONObject[0]);
    }

    public ba m14808a(MemEventNumber memEventNumber, final ConfigurationCallback configurationCallback) {
        new gd().m15129b(memEventNumber);
        return new av(ShineActionID.UNMAP_BUTTON_EVENT, "phaseUnmapButtonEvent", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ ax hb;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, new Hashtable());
            }
        }, new JSONObject[0]);
    }

    public ba m14811a(short s, short s2, final ConfigurationCallback configurationCallback) {
        new eq().m15073b(s, s2);
        return new av(ShineActionID.PLAY_BUTTON_EVENT_ANIMATION, "phasePlayButtonEventAnimation", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ ax hb;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, new Hashtable());
            }
        }, new JSONObject[0]);
    }

    public ba m14807a(byte b, final ConfigurationCallback configurationCallback) {
        new ct().m15021b(b);
        return new av(ShineActionID.EVENT_MAPPING_SYSTEM_CONTROL, "phaseEventMappingSystemControl", Arrays.asList(new ew[]{r0}), this.fG, new C4455a(this) {
            final /* synthetic */ ax hb;

            public void mo4826a(ba baVar, List<ew> list, ActionResult actionResult) {
                configurationCallback.onConfigCompleted(baVar.aR(), actionResult, new Hashtable());
            }
        }, new JSONObject[0]);
    }

    private Hashtable<C4601a, List<EventMapping>> m14805a(List<EventMapping> list, boolean z) {
        Hashtable<C4601a, List<EventMapping>> hashtable = new Hashtable();
        for (EventMapping eventMapping : list) {
            if (eventMapping != null) {
                C4601a a = C4601a.m15238a(eventMapping.getEventNumber());
                List list2 = (List) hashtable.get(a);
                if (list2 == null) {
                    list2 = new ArrayList();
                    if (z) {
                        list2.add(new C4593t(a));
                    }
                    hashtable.put(a, list2);
                }
                list2.add(eventMapping);
            }
        }
        return hashtable;
    }

    private List<ew> m14806h(List<EventMapping> list) {
        List<ew> arrayList = new ArrayList();
        int size = list.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            int i3 = 0;
            int i4 = i;
            while (i4 < size) {
                EventMapping eventMapping = (EventMapping) list.get(i4);
                if (eventMapping.payload().length + i3 > 18) {
                    break;
                }
                i4++;
                i3 = eventMapping.payload().length + i3;
            }
            fn fnVar = new fn();
            fnVar.m15097a(list.subList(i2, i4), i3);
            arrayList.add(fnVar);
            i = i4;
            i2 = i4;
        }
        return arrayList;
    }
}
