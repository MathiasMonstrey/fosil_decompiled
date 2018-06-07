package com.fossil;

import android.app.Activity;

public class dzb extends Activity {
    protected void onPause() {
        super.onPause();
        dzf.dr(this);
    }

    protected void onResume() {
        super.onResume();
        dzf.dq(this);
    }
}
