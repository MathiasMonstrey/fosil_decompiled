package com.fossil;

import android.support.v4.app.Fragment;

class evf extends evc<Fragment> {
    public evf(Fragment fragment) {
        super(fragment);
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        return ((Fragment) getHost()).shouldShowRequestPermissionRationale(str);
    }
}
