package com.fossil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import com.fossil.dry.C3151a;

public class drv {
    private static final String TAG = drv.class.getSimpleName();

    public static class C3153a {
        private Bitmap bitmap;
        private Context context;
        private drx dnV;
        private boolean dnW;
        private C3155a dnX;

        public C3153a(Context context, Bitmap bitmap, drx com_fossil_drx, boolean z, C3155a c3155a) {
            this.context = context;
            this.bitmap = bitmap;
            this.dnV = com_fossil_drx;
            this.dnW = z;
            this.dnX = c3155a;
        }

        public void m9560d(final ImageView imageView) {
            this.dnV.width = this.bitmap.getWidth();
            this.dnV.height = this.bitmap.getHeight();
            if (this.dnW) {
                new dry(imageView.getContext(), this.bitmap, this.dnV, new C3151a(this) {
                    final /* synthetic */ C3153a dnZ;

                    public void mo2675a(BitmapDrawable bitmapDrawable) {
                        if (this.dnZ.dnX == null) {
                            imageView.setImageDrawable(bitmapDrawable);
                        } else {
                            this.dnZ.dnX.m9562b(bitmapDrawable);
                        }
                    }
                }).execute();
            } else {
                imageView.setImageDrawable(new BitmapDrawable(this.context.getResources(), dru.m9555a(imageView.getContext(), this.bitmap, this.dnV)));
            }
        }
    }

    public static class C3154b {
        private Context context;
        private drx dnV;
        private boolean dnW;
        private C3155a dnX;
        private View doa;
        private int duration = 300;

        public C3154b(Context context) {
            this.context = context;
            this.doa = new View(context);
            this.doa.setTag(drv.TAG);
            this.dnV = new drx();
        }

        public C3154b lV(int i) {
            this.dnV.radius = i;
            return this;
        }

        public C3154b lW(int i) {
            this.dnV.dob = i;
            return this;
        }

        public C3153a m9561v(Bitmap bitmap) {
            return new C3153a(this.context, bitmap, this.dnV, this.dnW, this.dnX);
        }
    }

    public static class C3156c {

        public interface C3155a {
            void m9562b(BitmapDrawable bitmapDrawable);
        }
    }

    public static C3154b cE(Context context) {
        return new C3154b(context);
    }
}
