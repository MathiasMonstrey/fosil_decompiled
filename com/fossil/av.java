package com.fossil;

import android.annotation.TargetApi;
import android.graphics.Outline;

@TargetApi(21)
class av extends au {
    av() {
    }

    public void getOutline(Outline outline) {
        copyBounds(this.wy);
        outline.setOval(this.wy);
    }
}
