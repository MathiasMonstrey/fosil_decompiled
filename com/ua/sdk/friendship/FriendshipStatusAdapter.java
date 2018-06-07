package com.ua.sdk.friendship;

import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cft;
import com.fossil.cfu;
import com.fossil.cfv;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class FriendshipStatusAdapter implements cfo<FriendshipStatus>, cfv<FriendshipStatus> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16169v(com_fossil_cfp, type, com_fossil_cfn);
    }

    public FriendshipStatus m16169v(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return FriendshipStatus.getStatusFromString(com_fossil_cfp.getAsString());
    }

    public cfp m16167a(FriendshipStatus friendshipStatus, Type type, cfu com_fossil_cfu) {
        return new cft(friendshipStatus.getValue());
    }
}
