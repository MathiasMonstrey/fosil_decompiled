package com.fossil;

import android.content.Context;
import android.content.res.Resources;
import com.fossil.arv.C1875c;

public final class awk {
    private final Resources bhX;
    private final String bhY = this.bhX.getResourcePackageName(C1875c.common_google_play_services_unknown_issue);

    public awk(Context context) {
        awa.bO(context);
        this.bhX = context.getResources();
    }

    public final String getString(String str) {
        int identifier = this.bhX.getIdentifier(str, "string", this.bhY);
        return identifier == 0 ? null : this.bhX.getString(identifier);
    }
}
