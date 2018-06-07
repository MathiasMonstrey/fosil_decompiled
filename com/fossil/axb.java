package com.fossil;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.util.Log;

public abstract class axb implements OnClickListener {
    public static axb m4674a(Activity activity, Intent intent, int i) {
        return new axc(intent, activity, i);
    }

    public static axb m4675a(bgi com_fossil_bgi, Intent intent, int i) {
        return new axd(intent, com_fossil_bgi, 2);
    }

    protected abstract void LB();

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            LB();
        } catch (Throwable e) {
            Log.e("DialogRedirect", "Failed to start resolution intent", e);
        } finally {
            dialogInterface.dismiss();
        }
    }
}
