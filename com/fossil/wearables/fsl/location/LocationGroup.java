package com.fossil.wearables.fsl.location;

import com.fossil.wearables.fsl.shared.BaseFeatureModel;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.ForeignCollectionField;
import java.util.ArrayList;
import java.util.List;

public class LocationGroup extends BaseFeatureModel {
    @ForeignCollectionField(eager = true)
    private ForeignCollection<Location> locations;

    public List<Location> getLocations() {
        List<Location> arrayList = new ArrayList();
        if (this.locations == null || this.locations.size() <= 0) {
            return arrayList;
        }
        return new ArrayList(this.locations);
    }
}
