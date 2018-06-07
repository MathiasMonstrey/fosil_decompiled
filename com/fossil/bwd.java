package com.fossil;

import android.text.style.CharacterStyle;
import com.google.android.gms.common.data.DataHolder;
import java.util.Collections;
import java.util.List;

public final class bwd extends bvz implements buv {
    public bwd(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    private final String SW() {
        return af("ap_description", "");
    }

    private final String SX() {
        return af("ap_primary_text", "");
    }

    private final String SY() {
        return af("ap_secondary_text", "");
    }

    private final List<bwb> SZ() {
        return m5726a("ap_matched_subscriptions", bwb.CREATOR, Collections.emptyList());
    }

    private final List<bwb> Ta() {
        return m5726a("ap_primary_text_matched", bwb.CREATOR, Collections.emptyList());
    }

    private final List<bwb> Tb() {
        return m5726a("ap_secondary_text_matched", bwb.CREATOR, Collections.emptyList());
    }

    public final List<Integer> SM() {
        return m5727b("ap_place_types", Collections.emptyList());
    }

    public final CharSequence mo1489a(CharacterStyle characterStyle) {
        return bwg.m5733a(SW(), SZ(), characterStyle);
    }

    public final CharSequence mo1490b(CharacterStyle characterStyle) {
        return bwg.m5733a(SX(), Ta(), characterStyle);
    }

    public final CharSequence mo1491c(CharacterStyle characterStyle) {
        return bwg.m5733a(SY(), Tb(), characterStyle);
    }

    public final /* synthetic */ Object freeze() {
        String placeId = getPlaceId();
        List SM = SM();
        int u = m5729u("ap_personalization_type", 6);
        String SW = SW();
        return new bvg(placeId, SM, u, (String) awa.bO(SW), SZ(), SX(), Ta(), SY(), Tb());
    }

    public final String getPlaceId() {
        return af("ap_place_id", null);
    }
}
