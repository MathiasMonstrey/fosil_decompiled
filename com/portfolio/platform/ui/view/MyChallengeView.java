package com.portfolio.platform.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fossil.arp;
import com.fossil.gn;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.view.CircleImageViewProgressBar;
import com.portfolio.platform.view.FlexibleTextView;

public class MyChallengeView extends RelativeLayout {
    OnClickListener cHs;
    CircleImageViewProgressBar ddH;
    CircleImageViewProgressBar ddI;
    TextView ddJ;
    TextView ddK;
    View ddL;

    class C49561 implements OnClickListener {
        final /* synthetic */ MyChallengeView ddM;

        C49561(MyChallengeView myChallengeView) {
            this.ddM = myChallengeView;
        }

        public void onClick(View view) {
            this.ddM.cHs.onClick(this.ddM);
        }
    }

    class C49572 implements OnClickListener {
        final /* synthetic */ MyChallengeView ddM;

        C49572(MyChallengeView myChallengeView) {
            this.ddM = myChallengeView;
        }

        public void onClick(View view) {
            this.ddM.cHs.onClick(this.ddM);
        }
    }

    public MyChallengeView(Context context) {
        super(context);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.my_challenge_item, this, true);
        init();
    }

    public MyChallengeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.my_challenge_item, this, true);
        init();
    }

    private void init() {
        this.ddH = (CircleImageViewProgressBar) findViewById(R.id.user_avatar);
        this.ddI = (CircleImageViewProgressBar) findViewById(R.id.opponent_avatar);
        this.ddJ = (TextView) findViewById(R.id.user_steps);
        this.ddK = (TextView) findViewById(R.id.opponent_steps);
        this.ddL = findViewById(R.id.tv_view_details);
        this.ddH.setBorderWidth(10);
        this.ddH.setInnrCircleDiammeter(1.0f);
        this.ddH.setBorderColor(-1);
        this.ddH.setBorderProgressColor(gn.e(getContext(), R.color.fossilOrange));
        this.ddI.setBorderWidth(10);
        this.ddI.setInnrCircleDiammeter(1.0f);
        this.ddI.setBorderColor(-1);
        this.ddI.setBorderProgressColor(gn.e(getContext(), R.color.fossilOrange));
        if (this.cHs != null) {
            this.ddL.setOnClickListener(new C49561(this));
        }
    }

    public void setDetailPressed(OnClickListener onClickListener) {
        this.cHs = onClickListener;
        if (this.ddL != null) {
            this.ddL.setOnClickListener(new C49572(this));
        }
    }

    public void setChallengeTitle(String str) {
        ((FlexibleTextView) findViewById(R.id.ftv_challenge_title)).setText(str);
        invalidate();
    }

    public void aI(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            this.ddH.setBorderWidth(3);
            this.ddH.setBorderColor(gn.e(getContext(), R.color.coolGrey));
            return;
        }
        this.ddH.setBorderWidth(3);
        this.ddH.setBorderColor(gn.e(getContext(), R.color.transparent));
    }

    public void setUserProgress(int i) {
        this.ddH.setProgressBorderWidth(10);
        this.ddH.setInnrCircleDiammeter(1.0f);
        this.ddH.setProgressValue((float) i);
    }

    public void setUserName(String str) {
        ((FlexibleTextView) findViewById(R.id.user_name)).setText(str);
        invalidate();
    }

    public void aJ(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            this.ddI.setBorderWidth(3);
            this.ddI.setBorderColor(gn.e(getContext(), R.color.coolGrey));
            return;
        }
        this.ddI.setBorderWidth(3);
        this.ddI.setBorderColor(gn.e(getContext(), R.color.transparent));
    }

    public void setOpponentName(String str) {
        ((FlexibleTextView) findViewById(R.id.opponent_name)).setText(str);
        invalidate();
    }

    public void setOpponentProgress(int i) {
        this.ddI.setProgressBorderWidth(10);
        this.ddI.setInnrCircleDiammeter(1.0f);
        this.ddI.setProgressValue((float) i);
        invalidate();
    }

    public void atZ() {
        this.ddJ.setVisibility(8);
        this.ddK.setVisibility(8);
    }

    public void setUserSteps(int i) {
        this.ddJ.setVisibility(0);
        this.ddJ.setText(String.format(arp.u(getContext(), R.string.Stats_BC_Lose_Text_Steps), new Object[]{Integer.valueOf(i)}));
    }

    public void setOpponentSteps(int i) {
        this.ddK.setVisibility(0);
        this.ddK.setText(String.format(arp.u(getContext(), R.string.Stats_BC_Lose_Text_Steps), new Object[]{Integer.valueOf(i)}));
    }
}
