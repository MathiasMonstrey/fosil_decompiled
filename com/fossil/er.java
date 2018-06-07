package com.fossil;

import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;

abstract class er extends eq {
    boolean mStartedActivityFromFragment;

    er() {
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (!(this.mStartedActivityFromFragment || i == -1)) {
            ep.checkForValidRequestCode(i);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws SendIntentException {
        if (!(this.mStartedIntentSenderFromFragment || i == -1)) {
            ep.checkForValidRequestCode(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}
