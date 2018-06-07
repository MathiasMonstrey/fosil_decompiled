package com.fossil;

import android.app.Dialog;
import android.os.Bundle;

public class pd extends ev {
    public Dialog onCreateDialog(Bundle bundle) {
        return new pc(getContext(), getTheme());
    }

    public void setupDialog(Dialog dialog, int i) {
        if (dialog instanceof pc) {
            pc pcVar = (pc) dialog;
            switch (i) {
                case 1:
                case 2:
                    break;
                case 3:
                    dialog.getWindow().addFlags(24);
                    break;
                default:
                    return;
            }
            pcVar.cp(1);
            return;
        }
        super.setupDialog(dialog, i);
    }
}
