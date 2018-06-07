package com.fossil;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class aav {
    public <Z> aaz<Z> m2844b(ImageView imageView, Class<Z> cls) {
        if (yf.class.isAssignableFrom(cls)) {
            return new aat(imageView);
        }
        if (Bitmap.class.equals(cls)) {
            return new aar(imageView);
        }
        if (Drawable.class.isAssignableFrom(cls)) {
            return new aas(imageView);
        }
        throw new IllegalArgumentException("Unhandled class: " + cls + ", try .as*(Class).transcode(ResourceTranscoder)");
    }
}
