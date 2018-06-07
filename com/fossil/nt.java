package com.fossil;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.ImageView;

class nt {
    static ColorStateList m12823a(ImageView imageView) {
        return imageView.getImageTintList();
    }

    static void m12824a(ImageView imageView, ColorStateList colorStateList) {
        imageView.setImageTintList(colorStateList);
        if (VERSION.SDK_INT == 21) {
            Drawable drawable = imageView.getDrawable();
            Object obj = (imageView.getImageTintList() == null || imageView.getImageTintMode() == null) ? null : 1;
            if (drawable != null && obj != null) {
                if (drawable.isStateful()) {
                    drawable.setState(imageView.getDrawableState());
                }
                imageView.setImageDrawable(drawable);
            }
        }
    }

    static Mode m12826b(ImageView imageView) {
        return imageView.getImageTintMode();
    }

    static void m12825a(ImageView imageView, Mode mode) {
        imageView.setImageTintMode(mode);
        if (VERSION.SDK_INT == 21) {
            Drawable drawable = imageView.getDrawable();
            Object obj = (imageView.getImageTintList() == null || imageView.getImageTintMode() == null) ? null : 1;
            if (drawable != null && obj != null) {
                if (drawable.isStateful()) {
                    drawable.setState(imageView.getDrawableState());
                }
                imageView.setImageDrawable(drawable);
            }
        }
    }
}
