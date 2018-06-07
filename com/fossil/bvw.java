package com.fossil;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.internal.PlaceEntity;
import com.google.android.gms.location.places.internal.PlaceEntity.a;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public final class bvw extends bvz implements buy {
    private final bvl bHo;
    private final String bwK = af("place_id", "");

    public bvw(DataHolder dataHolder, int i) {
        bvl com_fossil_bvl;
        String str = null;
        super(dataHolder, i);
        Object obj = (SM().size() > 0 || ((SQ() != null && SQ().length() > 0) || (!(SO() == null || SO().equals(Uri.EMPTY)) || getRating() >= 0.0f || SP() >= 0))) ? 1 : null;
        if (obj != null) {
            List SM = SM();
            if (SQ() != null) {
                str = SQ().toString();
            }
            com_fossil_bvl = new bvl(SM, str, SO(), getRating(), SP());
        } else {
            com_fossil_bvl = null;
        }
        this.bHo = com_fossil_bvl;
    }

    private final List<String> SV() {
        return m5728c("place_attributions", Collections.emptyList());
    }

    public final List<Integer> SM() {
        return m5727b("place_types", Collections.emptyList());
    }

    public final LatLngBounds SN() {
        return (LatLngBounds) m5725a("place_viewport", LatLngBounds.CREATOR);
    }

    public final Uri SO() {
        String af = af("place_website_uri", null);
        return af == null ? null : Uri.parse(af);
    }

    public final int SP() {
        return m5729u("place_price_level", -1);
    }

    public final CharSequence SQ() {
        return af("place_phone_number", "");
    }

    public final CharSequence SR() {
        return af("place_address", "");
    }

    public final /* synthetic */ Object freeze() {
        a eP = new a().eR(SR().toString()).D(SV()).eP(getId());
        String str = "place_is_permanently_closed";
        boolean z = (!da(str) || db(str)) ? false : getBoolean(str);
        PlaceEntity SS = eP.bk(z).a(getLatLng()).W(m5724a("place_level_number", 0.0f)).eQ(getName().toString()).eS(SQ().toString()).ip(SP()).X(getRating()).C(SM()).a(SN()).k(SO()).a((bvs) m5725a("place_opening_hours", bvs.CREATOR)).a(this.bHo).SS();
        SS.setLocale(getLocale());
        return SS;
    }

    public final String getId() {
        return this.bwK;
    }

    public final LatLng getLatLng() {
        return (LatLng) m5725a("place_lat_lng", LatLng.CREATOR);
    }

    public final Locale getLocale() {
        Object af = af("place_locale_language", "");
        if (!TextUtils.isEmpty(af)) {
            return new Locale(af, af("place_locale_country", ""));
        }
        af = af("place_locale", "");
        return !TextUtils.isEmpty(af) ? new Locale(af) : Locale.getDefault();
    }

    public final CharSequence getName() {
        return af("place_name", "");
    }

    public final float getRating() {
        return m5724a("place_rating", -1.0f);
    }
}
