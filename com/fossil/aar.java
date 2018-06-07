package com.fossil;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class aar extends aau<Bitmap> {
    protected /* synthetic */ void bi(Object obj) {
        m2839o((Bitmap) obj);
    }

    public aar(ImageView imageView) {
        super(imageView);
    }

    protected void m2839o(Bitmap bitmap) {
        ((ImageView) this.view).setImageBitmap(bitmap);
    }
}
