package com.fossil;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Intent;

@TargetApi(11)
class gw {
    public static Intent makeMainActivity(ComponentName componentName) {
        return Intent.makeMainActivity(componentName);
    }
}
