package com.fossil;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.widget.Toast;

public class dup {
    public static void m9790j(Context context, String str, String str2) {
        if (context != null) {
            new Builder(context).setTitle(str).setMessage(str2).create().show();
        }
    }

    public static void m9789a(Context context, CharSequence charSequence, int i) {
        if (context != null) {
            Toast.makeText(context, charSequence, i).show();
        }
    }
}
