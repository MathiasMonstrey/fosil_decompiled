package com.fossil;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.widget.ImageView;

class ns {
    static ColorStateList m12819a(ImageView imageView) {
        return imageView instanceof op ? ((op) imageView).getSupportImageTintList() : null;
    }

    static void m12820a(ImageView imageView, ColorStateList colorStateList) {
        if (imageView instanceof op) {
            ((op) imageView).setSupportImageTintList(colorStateList);
        }
    }

    static Mode m12822b(ImageView imageView) {
        return imageView instanceof op ? ((op) imageView).getSupportImageTintMode() : null;
    }

    static void m12821a(ImageView imageView, Mode mode) {
        if (imageView instanceof op) {
            ((op) imageView).setSupportImageTintMode(mode);
        }
    }
}
