package com.fossil;

import android.content.Context;
import android.os.Build.VERSION;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.executor.FifoPriorityThreadPoolExecutor;
import com.fossil.vs.C4167a;
import java.util.concurrent.ExecutorService;

public class ty {
    private vl axR;
    private DecodeFormat axT;
    private va ayH;
    private vz ayI;
    private ExecutorService ayS;
    private ExecutorService ayT;
    private C4167a ayU;
    private final Context context;

    public ty(Context context) {
        this.context = context.getApplicationContext();
    }

    tx tO() {
        if (this.ayS == null) {
            this.ayS = new FifoPriorityThreadPoolExecutor(Math.max(1, Runtime.getRuntime().availableProcessors()));
        }
        if (this.ayT == null) {
            this.ayT = new FifoPriorityThreadPoolExecutor(1);
        }
        wa waVar = new wa(this.context);
        if (this.axR == null) {
            if (VERSION.SDK_INT >= 11) {
                this.axR = new vo(waVar.vo());
            } else {
                this.axR = new vm();
            }
        }
        if (this.ayI == null) {
            this.ayI = new vy(waVar.vn());
        }
        if (this.ayU == null) {
            this.ayU = new vx(this.context);
        }
        if (this.ayH == null) {
            this.ayH = new va(this.ayI, this.ayU, this.ayT, this.ayS);
        }
        if (this.axT == null) {
            this.axT = DecodeFormat.DEFAULT;
        }
        return new tx(this.ayH, this.ayI, this.axR, this.context, this.axT);
    }
}
