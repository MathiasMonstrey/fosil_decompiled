package com.fossil;

import com.fossil.wearables.fsl.shared.BaseFeatureModel;
import java.util.List;

public class cme {
    private final List<BaseFeatureModel> bWZ;

    public cme(List<BaseFeatureModel> list) {
        this.bWZ = list;
    }

    public List<BaseFeatureModel> getData() {
        return this.bWZ;
    }
}
