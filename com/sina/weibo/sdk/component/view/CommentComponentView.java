package com.sina.weibo.sdk.component.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.fossil.dsp;
import com.fossil.dsx;
import com.fossil.dth;
import com.fossil.dtj;
import com.fossil.dum;

public class CommentComponentView extends FrameLayout {
    private C5058a drZ;
    private LinearLayout dsa;

    class C50571 implements OnClickListener {
        final /* synthetic */ CommentComponentView dsb;

        C50571(CommentComponentView commentComponentView) {
            this.dsb = commentComponentView;
        }

        public void onClick(View view) {
            this.dsb.axl();
        }
    }

    public enum Category {
        MOVIE("1001"),
        TRAVEL("1002");
        
        private String mVal;

        private Category(String str) {
            this.mVal = str;
        }

        public String getValue() {
            return this.mVal;
        }
    }

    public static class C5058a {
        private String dqh;
        private String dqm;
        private dsp drY;
        private String dsd;
        private String dse;
        private Category dsf;
    }

    public CommentComponentView(Context context) {
        super(context);
        init(context);
    }

    public CommentComponentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public CommentComponentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.dsa = new LinearLayout(context);
        this.dsa.setOrientation(0);
        this.dsa.setLayoutParams(new LayoutParams(-2, -2));
        View imageView = new ImageView(context);
        imageView.setImageDrawable(dum.O(context, "sdk_weibo_logo.png"));
        LayoutParams layoutParams = new LinearLayout.LayoutParams(dum.I(getContext(), 20), dum.I(getContext(), 20));
        layoutParams.gravity = 16;
        imageView.setLayoutParams(layoutParams);
        View textView = new TextView(context);
        textView.setText(dum.c(context, "Comment", "微博热评", "微博熱評"));
        textView.setTextColor(-32256);
        textView.setTextSize(2, 15.0f);
        textView.setIncludeFontPadding(false);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = dum.I(getContext(), 4);
        textView.setLayoutParams(layoutParams2);
        this.dsa.addView(imageView);
        this.dsa.addView(textView);
        addView(this.dsa);
        textView.setOnClickListener(new C50571(this));
    }

    public void setCommentParam(C5058a c5058a) {
        this.drZ = c5058a;
    }

    private void axl() {
        dsx.L(getContext(), this.drZ.dqh).awO();
        dtj com_fossil_dtj = new dtj(getContext());
        com_fossil_dtj.setUrl("http://widget.weibo.com/distribution/socail_comments_sdk.php");
        com_fossil_dtj.jG(dum.c(getContext(), "Comment", "微博热评", "微博熱評"));
        com_fossil_dtj.jU(this.drZ.dqh);
        com_fossil_dtj.jS(this.drZ.dsd);
        com_fossil_dtj.jR(this.drZ.dse);
        com_fossil_dtj.jT(this.drZ.dsf.getValue());
        com_fossil_dtj.c(this.drZ.drY);
        com_fossil_dtj.setToken(this.drZ.dqm);
        Bundle awS = com_fossil_dtj.awS();
        Intent intent = new Intent(getContext(), dth.class);
        intent.putExtras(awS);
        getContext().startActivity(intent);
    }
}
