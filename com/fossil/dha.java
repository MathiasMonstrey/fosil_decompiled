package com.fossil;

import com.portfolio.platform.data.model.microapp.MicroApp;
import com.portfolio.platform.data.model.microapp.MicroAppSetting;
import com.portfolio.platform.data.model.microapp.PusherConfiguration.Pusher;
import com.portfolio.platform.data.model.microapp.RecommendedPreset;
import com.portfolio.platform.data.model.microapp.SavedPreset;
import com.portfolio.platform.data.model.microapp.SavedPreset.MappingSetType;
import java.util.List;

public interface dha {

    public interface C2763a {
        void mo2407a(dhk com_fossil_dhk);

        boolean mo2409a(String str, Pusher pusher);

        void ai(List<Pusher> list);

        void aoh();

        void aoi();

        void aoj();

        void aok();

        void aol();

        void mo2429b(Pusher pusher);

        void mo2430b(MappingSetType mappingSetType, String str);

        void mo2431b(String str, MappingSetType mappingSetType);

        void cP(boolean z);

        void iz(String str);

        void setCurrentTab(int i);

        void stop();

        void sync();
    }

    public interface C2764b extends ctp<C2763a> {
        void mo2386a(MicroApp microApp, Pusher pusher);

        void mo2387a(MicroApp microApp, boolean z);

        void mo2390a(List<MicroApp> list, List<RecommendedPreset> list2, List<SavedPreset> list3);

        void afT();

        void afU();

        void aom();

        void aon();

        void aoo();

        void aop();

        void aoq();

        void aor();

        void aos();

        void aot();

        void aou();

        void mo2400b(MicroApp microApp, boolean z);

        void mo2401c(MicroApp microApp, boolean z);

        void cD(boolean z);

        void clearAnimation();

        void mo2404d(List<MicroApp> list, List<MicroAppSetting> list2);

        void kZ(int i);
    }
}
