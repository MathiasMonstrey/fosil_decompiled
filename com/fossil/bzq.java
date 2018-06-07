package com.fossil;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class bzq extends FrameLayout {

    interface C1974d {
        Drawable getDrawable(int i);

        boolean isValid();
    }

    static class C1975a implements C1974d {
        private Context mContext;

        private C1975a(Context context) {
            this.mContext = context;
        }

        public final Drawable getDrawable(int i) {
            return this.mContext.getResources().getDrawable(17301508);
        }

        public final boolean isValid() {
            return true;
        }
    }

    static class C1976b implements C1974d {
        private Context mContext;

        private C1976b(Context context) {
            this.mContext = context;
        }

        public final Drawable getDrawable(int i) {
            try {
                String str;
                Resources resources = this.mContext.createPackageContext("com.google.android.gms", 4).getResources();
                String str2 = "com.google.android.gms";
                switch (i) {
                    case 0:
                        str = "ic_plusone_small";
                        break;
                    case 1:
                        str = "ic_plusone_medium";
                        break;
                    case 2:
                        str = "ic_plusone_tall";
                        break;
                    default:
                        str = "ic_plusone_standard";
                        break;
                }
                return resources.getDrawable(resources.getIdentifier(str, "drawable", str2));
            } catch (NameNotFoundException e) {
                return null;
            }
        }

        public final boolean isValid() {
            try {
                this.mContext.createPackageContext("com.google.android.gms", 4).getResources();
                return true;
            } catch (NameNotFoundException e) {
                return false;
            }
        }
    }

    static class C1977c implements C1974d {
        private Context mContext;

        private C1977c(Context context) {
            this.mContext = context;
        }

        public final Drawable getDrawable(int i) {
            String str;
            switch (i) {
                case 0:
                    str = "ic_plusone_small_off_client";
                    break;
                case 1:
                    str = "ic_plusone_medium_off_client";
                    break;
                case 2:
                    str = "ic_plusone_tall_off_client";
                    break;
                default:
                    str = "ic_plusone_standard_off_client";
                    break;
            }
            return this.mContext.getResources().getDrawable(this.mContext.getResources().getIdentifier(str, "drawable", this.mContext.getPackageName()));
        }

        public final boolean isValid() {
            return (this.mContext.getResources().getIdentifier("ic_plusone_small_off_client", "drawable", this.mContext.getPackageName()) == 0 || this.mContext.getResources().getIdentifier("ic_plusone_medium_off_client", "drawable", this.mContext.getPackageName()) == 0 || this.mContext.getResources().getIdentifier("ic_plusone_tall_off_client", "drawable", this.mContext.getPackageName()) == 0 || this.mContext.getResources().getIdentifier("ic_plusone_standard_off_client", "drawable", this.mContext.getPackageName()) == 0) ? false : true;
        }
    }

    public bzq(Context context, int i) {
        int i2;
        int i3 = 24;
        super(context);
        View button = new Button(context);
        button.setEnabled(false);
        C1974d c1976b = new C1976b(getContext());
        if (!c1976b.isValid()) {
            c1976b = new C1977c(getContext());
        }
        if (!c1976b.isValid()) {
            c1976b = new C1975a(getContext());
        }
        button.setBackgroundDrawable(c1976b.getDrawable(i));
        Point point = new Point();
        switch (i) {
            case 0:
                i2 = 14;
                break;
            case 1:
                i3 = 32;
                i2 = 20;
                break;
            case 2:
                i3 = 50;
                i2 = 20;
                break;
            default:
                i3 = 38;
                i2 = 24;
                break;
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float applyDimension = TypedValue.applyDimension(1, (float) i3, displayMetrics);
        float applyDimension2 = TypedValue.applyDimension(1, (float) i2, displayMetrics);
        point.x = (int) (((double) applyDimension) + 0.5d);
        point.y = (int) (((double) applyDimension2) + 0.5d);
        addView(button, new LayoutParams(point.x, point.y, 17));
    }
}
