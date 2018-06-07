package com.jawbone.upplatformsdk.builders;

import com.jawbone.upplatformsdk.builders.Params.Builder;
import java.util.HashMap;

public class MoveListParams extends Params {
    private Builder mBuilder;
    private HashMap<String, Integer> moveListParams;

    public MoveListParams(Builder builder) {
        this.mBuilder = builder;
    }

    public HashMap<String, Integer> getMoveListParams() {
        return this.mBuilder.build();
    }
}
