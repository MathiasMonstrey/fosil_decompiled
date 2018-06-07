package com.fossil;

import android.app.Dialog;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.fossil.wearables.fossil.R;

public class drq extends ev {
    public static final String TAG = drq.class.getSimpleName();
    private AnimationDrawable dmd;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, 16973840);
        setCancelable(false);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_loading_dialog, viewGroup, false);
        this.dmd = (AnimationDrawable) inflate.findViewById(R.id.loading_dialog_image).getBackground();
        return inflate;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.requestWindowFeature(1);
        Window window = onCreateDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(Integer.MIN_VALUE));
            window.setLayout(-1, -1);
        }
        return onCreateDialog;
    }

    public void onResume() {
        super.onResume();
        this.dmd.start();
    }

    public void onPause() {
        super.onPause();
        this.dmd.stop();
    }
}
