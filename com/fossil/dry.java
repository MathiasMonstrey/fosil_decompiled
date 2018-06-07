package com.fossil;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class dry {
    private static ExecutorService dof = Executors.newCachedThreadPool();
    private Bitmap bitmap;
    private drx dnV;
    private Resources doc;
    private WeakReference<Context> dod;
    private C3151a doe;

    public interface C3151a {
        void mo2675a(BitmapDrawable bitmapDrawable);
    }

    class C31581 implements Runnable {
        final /* synthetic */ dry dog;

        C31581(dry com_fossil_dry) {
            this.dog = com_fossil_dry;
        }

        public void run() {
            final BitmapDrawable bitmapDrawable = new BitmapDrawable(this.dog.doc, dru.m9555a((Context) this.dog.dod.get(), this.dog.bitmap, this.dog.dnV));
            if (this.dog.doe != null) {
                new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ C31581 doi;

                    public void run() {
                        this.doi.dog.doe.mo2675a(bitmapDrawable);
                    }
                });
            }
        }
    }

    public dry(Context context, Bitmap bitmap, drx com_fossil_drx, C3151a c3151a) {
        this.doc = context.getResources();
        this.dnV = com_fossil_drx;
        this.doe = c3151a;
        this.dod = new WeakReference(context);
        this.bitmap = bitmap;
    }

    public void execute() {
        dof.execute(new C31581(this));
    }
}
