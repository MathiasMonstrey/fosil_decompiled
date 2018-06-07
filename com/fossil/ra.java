package com.fossil;

import android.annotation.TargetApi;
import android.graphics.Outline;
import android.support.v7.widget.ActionBarContainer;

@TargetApi(21)
public class ra extends qz {
    public ra(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    public void getOutline(Outline outline) {
        if (this.ahD.ahK) {
            if (this.ahD.ahJ != null) {
                this.ahD.ahJ.getOutline(outline);
            }
        } else if (this.ahD.aga != null) {
            this.ahD.aga.getOutline(outline);
        }
    }
}
