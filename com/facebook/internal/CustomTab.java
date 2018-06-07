package com.facebook.internal;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.fossil.y;
import com.fossil.y.a;

public class CustomTab {
    private Uri uri;

    public CustomTab(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.uri = Utility.buildUri(ServerProtocol.getDialogAuthority(), FacebookSdk.getGraphApiVersion() + "/" + ServerProtocol.DIALOG_PATH + str, bundle);
    }

    public void openCustomTab(Activity activity, String str) {
        y eR = new a().eR();
        eR.intent.setPackage(str);
        eR.intent.addFlags(1073741824);
        eR.launchUrl(activity, this.uri);
    }
}
