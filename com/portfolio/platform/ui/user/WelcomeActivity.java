package com.portfolio.platform.ui.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.fossil.arp;
import com.fossil.cmj;
import com.fossil.ctj;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.ui.MainActivity;
import com.portfolio.platform.view.FlexibleButton;
import com.portfolio.platform.view.FlexibleTextView;

public class WelcomeActivity extends ctj implements OnClickListener {
    private FlexibleTextView cpC;
    private FlexibleTextView cqZ;
    private FlexibleButton dcA;
    private FlexibleTextView dcz;

    public static void bF(Context context) {
        context.startActivity(new Intent(context, WelcomeActivity.class));
    }

    public static void bJ(Context context) {
        Intent intent = new Intent(context, WelcomeActivity.class);
        intent.addFlags(268468224);
        context.startActivity(intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_onboarding_welcome);
        this.dcA = (FlexibleButton) findViewById(R.id.fb_get_started);
        this.cpC = (FlexibleTextView) findViewById(R.id.ftv_title);
        this.cqZ = (FlexibleTextView) findViewById(R.id.ftv_description);
        this.dcz = (FlexibleTextView) findViewById(R.id.ftv_continue);
        this.dcA.setOnClickListener(this);
        this.dcz.setOnClickListener(this);
        this.cpC.setText(String.format(arp.u(PortfolioApp.ZQ(), R.string.Onboarding_Welcome_Title_Welcome_to_BRAND), new Object[]{getString(R.string.brand_name)}));
        this.cqZ.setText(String.format(arp.u(PortfolioApp.ZQ(), R.string.Onboarding_Welcome_Text_Step_into_a_new_world), new Object[]{getString(R.string.brand_name)}));
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fb_get_started:
                cmj.bs(PortfolioApp.ZQ()).l("onboarding_continue", "Device", "No_Device");
                CreateAccountActivity.bF(this);
                return;
            case R.id.ftv_continue:
                cmj.bs(PortfolioApp.ZQ()).l("onboarding_continue", "Device", "Device");
                MainActivity.bF(this);
                return;
            default:
                return;
        }
    }
}
