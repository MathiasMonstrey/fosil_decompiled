package com.fossil;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.internal.PlaceEntity;

public final class bvp extends bvz implements bvb {
    public bvp(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public final float ST() {
        return m5724a("place_likelihood", -1.0f);
    }

    public final buy SU() {
        return new bvw(this.bgD, this.bgT);
    }

    public final /* synthetic */ Object freeze() {
        PlaceEntity placeEntity = (PlaceEntity) SU().freeze();
        return new bvn((PlaceEntity) awa.bO(placeEntity), ST());
    }
}
