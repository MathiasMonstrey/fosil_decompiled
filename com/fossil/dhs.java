package com.fossil;

import android.os.Bundle;
import com.portfolio.platform.data.model.microapp.CommuteTimeSettings;
import com.portfolio.platform.data.model.microapp.CommuteTimeSettings.TIME_FORMAT;

public interface dhs {

    public interface C2796a {
        void mo2463a(TIME_FORMAT time_format);

        void apk();

        void apl();

        void cW(boolean z);

        void iJ(String str);

        boolean lM();

        void onActivityCreated(Bundle bundle);

        void onSaveInstanceState(Bundle bundle);

        void setDestination(String str);
    }

    public interface C2800b extends cjt<C2796a> {
        void apc();

        void mo2492b(CommuteTimeSettings commuteTimeSettings);
    }
}
