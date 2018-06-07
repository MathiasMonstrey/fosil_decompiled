package com.fossil;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;

public class ato extends DialogFragment {
    private OnCancelListener bfL = null;
    private Dialog mDialog = null;

    public static ato m4434a(Dialog dialog, OnCancelListener onCancelListener) {
        ato com_fossil_ato = new ato();
        Dialog dialog2 = (Dialog) awa.m4640p(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        com_fossil_ato.mDialog = dialog2;
        if (onCancelListener != null) {
            com_fossil_ato.bfL = onCancelListener;
        }
        return com_fossil_ato;
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

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
