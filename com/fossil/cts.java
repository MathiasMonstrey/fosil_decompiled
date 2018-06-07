package com.fossil;

import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.model.buddychallenge.BCChallenge;
import com.portfolio.platform.data.model.buddychallenge.BCInvitation;
import com.portfolio.platform.data.model.buddychallenge.BCNotifications;
import com.portfolio.platform.data.model.buddychallenge.BCOpponent;
import java.util.HashMap;

public class cts {

    public interface C2310a extends cjs {
        void mo2063a(BCNotifications bCNotifications, BCOpponent bCOpponent, String str);

        void mo2064a(String str, BCNotifications bCNotifications, BCInvitation bCInvitation, BCChallenge bCChallenge);

        void agj();

        void agk();

        void hH(String str);

        void jR(int i);
    }

    public interface C2311b extends ctp<C2310a> {
        void mo2031a(BCNotifications bCNotifications);

        void mo2032a(BCNotifications bCNotifications, BCChallenge bCChallenge, BCOpponent bCOpponent);

        void mo2033a(BCNotifications bCNotifications, BCInvitation bCInvitation, BCChallenge bCChallenge, BCOpponent bCOpponent);

        void agA();

        void agl();

        void agm();

        void agn();

        void ago();

        void agp();

        void agq();

        void agr();

        void ags();

        void agt();

        void agu();

        void agv();

        void agw();

        void agx();

        void agy();

        void agz();

        void mo2055c(MFUser mFUser);

        void mo2057d(HashMap<String, String> hashMap);

        void hI(String str);

        void jS(int i);

        void jT(int i);

        void restart();
    }
}
