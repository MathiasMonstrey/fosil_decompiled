package com.fossil;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;

public class atr extends ev {
    private OnCancelListener bfL = null;
    private Dialog mDialog = null;

    public static atr m4456b(Dialog dialog, OnCancelListener onCancelListener) {
        atr com_fossil_atr = new atr();
        Dialog dialog2 = (Dialog) awa.m4640p(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        com_fossil_atr.mDialog = dialog2;
        if (onCancelListener != null) {
            com_fossil_atr.bfL = onCancelListener;
        }
        return com_fossil_atr;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.bfL != null) {
            this.bfL.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.mDialog == null) {
            setShowsDialog(false);
        }
        return this.mDialog;
    }

    public void show(fa faVar, String str) {
        super.show(faVar, str);
    }
}
