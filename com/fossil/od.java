package com.fossil;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.RelativeLayout;
import com.fossil.wearables.fossil.R;

public class od extends RelativeLayout {
    private AnimationDrawable Yc;
    private boolean Yd = false;

    public od(Context context) {
        super(context);
        View inflate = inflate(context, R.layout.view_refresh_header, this);
        inflate.setBackgroundColor(gn.e(getContext(), R.color.hexF6F1EC));
        this.Yc = (AnimationDrawable) inflate.findViewById(R.id.loading_animation).getBackground();
    }

    public void onStart() {
        if (!this.Yd) {
            this.Yc.start();
            this.Yd = true;
        }
    }

    public void onStop() {
        this.Yc.stop();
        this.Yd = false;
    }
}
