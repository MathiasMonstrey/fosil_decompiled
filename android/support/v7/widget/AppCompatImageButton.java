package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import com.fossil.lf;
import com.fossil.op;
import com.fossil.pk.a;
import com.fossil.re;
import com.fossil.rh;
import com.fossil.st;

public class AppCompatImageButton extends ImageButton implements lf, op {
    private final re akh;
    private final rh zj;

    public AppCompatImageButton(Context context) {
        this(context, null);
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.imageButtonStyle);
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet, int i) {
        super(st.C(context), attributeSet, i);
        this.akh = new re(this);
        this.akh.a(attributeSet, i);
        this.zj = new rh(this);
        this.zj.a(attributeSet, i);
    }

    public void setImageResource(int i) {
        this.zj.setImageResource(i);
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.zj != null) {
            this.zj.ov();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.zj != null) {
            this.zj.ov();
        }
    }

    public void setImageIcon(Icon icon) {
        super.setImageIcon(icon);
        if (this.zj != null) {
            this.zj.ov();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        if (this.zj != null) {
            this.zj.ov();
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.akh != null) {
            this.akh.cQ(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.akh != null) {
            this.akh.o(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.akh != null) {
            this.akh.setSupportBackgroundTintList(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.akh != null ? this.akh.getSupportBackgroundTintList() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.akh != null) {
            this.akh.setSupportBackgroundTintMode(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.akh != null ? this.akh.getSupportBackgroundTintMode() : null;
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.zj != null) {
            this.zj.setSupportImageTintList(colorStateList);
        }
    }

    public ColorStateList getSupportImageTintList() {
        return this.zj != null ? this.zj.getSupportImageTintList() : null;
    }

    public void setSupportImageTintMode(Mode mode) {
        if (this.zj != null) {
            this.zj.setSupportImageTintMode(mode);
        }
    }

    public Mode getSupportImageTintMode() {
        return this.zj != null ? this.zj.getSupportImageTintMode() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.akh != null) {
            this.akh.op();
        }
        if (this.zj != null) {
            this.zj.ov();
        }
    }

    public boolean hasOverlappingRendering() {
        return this.zj.hasOverlappingRendering() && super.hasOverlappingRendering();
    }
}
