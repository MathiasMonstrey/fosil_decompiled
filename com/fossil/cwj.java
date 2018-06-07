package com.fossil;

import com.misfit.frameworks.buttonservice.model.Alarm;
import java.util.List;

public interface cwj {

    public interface C2441a extends cjs {
        void mo2158a(Alarm alarm, boolean z);

        void mo2159b(Alarm alarm, boolean z);

        void mo2160e(Alarm alarm);

        void kj(int i);

        void stop();
    }

    public interface C2442b extends ctp<C2441a> {
        void mo2151a(List<Alarm> list, int i, boolean z);

        void afT();

        void afU();

        void aiP();

        void aiQ();

        void setDeviceId(String str);
    }
}
