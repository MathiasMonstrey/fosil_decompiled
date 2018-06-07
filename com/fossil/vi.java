package com.fossil;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;

class vi {
    private boolean aCj;
    private final Handler handler = new Handler(Looper.getMainLooper(), new C4157a());

    static class C4157a implements Callback {
        private C4157a() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((vh) message.obj).recycle();
            return true;
        }
    }

    vi() {
    }

    public void m13904i(vh<?> vhVar) {
        abl.wX();
        if (this.aCj) {
            this.handler.obtainMessage(1, vhVar).sendToTarget();
            return;
        }
        this.aCj = true;
        vhVar.recycle();
        this.aCj = false;
    }
}
