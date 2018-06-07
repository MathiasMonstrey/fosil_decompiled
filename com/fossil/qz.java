package com.fossil;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.ActionBarContainer;

@TargetApi(9)
public class qz extends Drawable {
    final ActionBarContainer ahD;

    public qz(ActionBarContainer actionBarContainer) {
        this.ahD = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        if (!this.ahD.ahK) {
            if (this.ahD.aga != null) {
                this.ahD.aga.draw(canvas);
            }
            if (this.ahD.ahI != null && this.ahD.ahL) {
                this.ahD.ahI.draw(canvas);
            }
        } else if (this.ahD.ahJ != null) {
            this.ahD.ahJ.draw(canvas);
        }
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
