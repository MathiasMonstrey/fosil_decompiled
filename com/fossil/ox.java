package com.fossil;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.Window;
import android.view.Window.Callback;
import com.fossil.pa.C3948a;
import com.fossil.pb.C3968d;
import java.util.List;

@TargetApi(24)
class ox extends pa {

    class C3949a extends C3948a {
        final /* synthetic */ ox abz;

        C3949a(ox oxVar, Callback callback) {
            this.abz = oxVar;
            super(oxVar, callback);
        }

        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            C3968d g = this.abz.m12981g(0, true);
            if (g == null || g.acr == null) {
                super.onProvideKeyboardShortcuts(list, menu, i);
            } else {
                super.onProvideKeyboardShortcuts(list, g.acr, i);
            }
        }
    }

    ox(Context context, Window window, ou ouVar) {
        super(context, window, ouVar);
    }

    Callback mo3990a(Callback callback) {
        return new C3949a(this, callback);
    }
}
