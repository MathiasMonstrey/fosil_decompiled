package com.fossil.wearables.fsl.fitness;

import android.content.Context;

public class FitnessProviderFactory {
    public static final String DB_NAME = "fitness.db";

    public static FitnessProvider createInstance(Context context, String str) {
        return new FitnessProviderImpl(context, str);
    }
}
