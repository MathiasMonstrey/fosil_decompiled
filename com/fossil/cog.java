package com.fossil;

import com.fossil.wearables.fsl.BaseProvider;
import com.portfolio.platform.data.model.buddychallenge.BCChallenge;
import com.portfolio.platform.data.model.buddychallenge.BCHeartbeatStep;
import com.portfolio.platform.data.model.buddychallenge.BCInvitation;
import com.portfolio.platform.data.model.buddychallenge.BCOpponent;
import com.portfolio.platform.data.model.buddychallenge.BCPlayer;
import java.util.List;

public interface cog extends BaseProvider {
    void mo1921a(BCChallenge bCChallenge);

    void mo1922a(BCHeartbeatStep bCHeartbeatStep);

    void mo1923a(BCInvitation bCInvitation);

    void mo1924a(BCOpponent bCOpponent);

    BCHeartbeatStep aH(long j);

    BCPlayer adI();

    void adJ();

    List<BCChallenge> adK();

    void mo1929b(BCChallenge bCChallenge);

    void mo1930b(BCInvitation bCInvitation);

    void mo1931b(BCPlayer bCPlayer);

    String getDbPath();

    BCChallenge ha(String str);

    BCOpponent hb(String str);
}
