package com.fossil;

import android.annotation.TargetApi;
import android.app.UiModeManager;
import android.content.Context;
import android.view.ActionMode;
import android.view.Window;
import android.view.Window.Callback;
import com.fossil.oz.C3947a;

@TargetApi(23)
class pa extends oz {
    private final UiModeManager abK;

    class C3948a extends C3947a {
        final /* synthetic */ pa abL;

        C3948a(pa paVar, Callback callback) {
            this.abL = paVar;
            super(paVar, callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (this.abL.lA()) {
                switch (i) {
                    case 0:
                        return m12957a(callback);
                }
            }
            return super.onWindowStartingActionMode(callback, i);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }
    }

    pa(Context context, Window window, ou ouVar) {
        super(context, window, ouVar);
        this.abK = (UiModeManager) context.getSystemService("uimode");
    }

    Callback mo3990a(Callback callback) {
        return new C3948a(this, callback);
    }

    int ck(int i) {
        if (i == 0 && this.abK.getNightMode() == 0) {
            return -1;
        }
        return super.ck(i);
    }
}
