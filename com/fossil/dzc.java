package com.fossil;

import android.app.ListActivity;

public class dzc extends ListActivity {
    protected void onPause() {
        super.onPause();
        dzf.dr(this);
    }

    protected void onResume() {
        super.onResume();
        dzf.dq(this);
    }
}
