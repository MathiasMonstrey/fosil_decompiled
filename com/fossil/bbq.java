package com.fossil;

import android.net.Uri;
import android.os.Bundle;
import java.util.List;

public class bbq {
    private final List<Uri> bpE;
    private final Bundle extras;
    private final String tag;

    public bbq(String str, Bundle bundle, List<Uri> list) {
        this.tag = str;
        this.extras = bundle;
        this.bpE = list;
    }

    public Bundle getExtras() {
        return this.extras;
    }
}
