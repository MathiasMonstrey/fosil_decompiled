package com.fossil;

import android.annotation.TargetApi;
import android.app.Activity;
import com.fossil.emk.C1565b;
import java.util.concurrent.ExecutorService;

@TargetApi(14)
class acf extends ace {
    private final C1565b aIi = new C15661(this);
    private final ExecutorService aIj;

    class C15661 extends C1565b {
        final /* synthetic */ acf aIk;

        class C15641 implements Runnable {
            final /* synthetic */ C15661 aIl;

            C15641(C15661 c15661) {
                this.aIl = c15661;
            }

            public void run() {
                this.aIl.aIk.xv();
            }
        }

        C15661(acf com_fossil_acf) {
            this.aIk = com_fossil_acf;
        }

        public void onActivityStarted(Activity activity) {
            if (this.aIk.xt()) {
                this.aIk.aIj.submit(new C15641(this));
            }
        }
    }

    public acf(emk com_fossil_emk, ExecutorService executorService) {
        this.aIj = executorService;
        com_fossil_emk.m10876a(this.aIi);
    }
}
