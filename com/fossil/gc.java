package com.fossil;

import android.annotation.TargetApi;
import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import com.fossil.gd.C3617a;

@TargetApi(20)
class gc {
    static RemoteInput[] m11503a(C3617a[] c3617aArr) {
        if (c3617aArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[c3617aArr.length];
        for (int i = 0; i < c3617aArr.length; i++) {
            C3617a c3617a = c3617aArr[i];
            remoteInputArr[i] = new Builder(c3617a.getResultKey()).setLabel(c3617a.getLabel()).setChoices(c3617a.getChoices()).setAllowFreeFormInput(c3617a.getAllowFreeFormInput()).addExtras(c3617a.getExtras()).build();
        }
        return remoteInputArr;
    }
}
