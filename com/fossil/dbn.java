package com.fossil;

import com.portfolio.platform.data.model.LandingPage;
import com.portfolio.platform.data.model.microapp.ActivePreset;
import com.portfolio.platform.data.model.microapp.MicroApp;
import com.portfolio.platform.data.model.microapp.PusherConfiguration.Pusher;

public interface dbn {

    public interface C2623a extends cjs {
        void mo2243a(Pusher pusher);

        MicroApp fT(String str);
    }

    public interface C2624b extends cjt<C2623a> {
        void mo2240G(String str, int i);

        void mo2241b(LandingPage landingPage);

        void mo2242c(ActivePreset activePreset);
    }
}
