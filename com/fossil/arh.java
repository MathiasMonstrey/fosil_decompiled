package com.fossil;

import android.content.Context;
import com.misfit.frameworks.network.configuration.MFConfiguration;

public class arh {
    private static arh bcR;
    private MFConfiguration configuration;

    public static arh Jj() {
        if (bcR == null) {
            bcR = new arh();
        }
        return bcR;
    }

    public void m4278a(MFConfiguration mFConfiguration) {
        this.configuration = mFConfiguration;
    }

    public void ac(Context context) {
        arl.ac(context);
    }

    public MFConfiguration Jk() {
        return this.configuration;
    }
}
