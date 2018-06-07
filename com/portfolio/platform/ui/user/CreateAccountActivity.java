package com.portfolio.platform.ui.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.fossil.cki;
import com.fossil.cmj;
import com.fossil.ctj;
import com.fossil.fj;
import com.fossil.fj.a;
import com.fossil.gx;
import com.fossil.tx;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.Explore;
import com.portfolio.platform.data.source.loader.ExploreLoader;
import com.portfolio.platform.view.FlexibleButton;
import com.portfolio.platform.view.indicator.CirclePageIndicator;
import com.portfolio.platform.view.recyclerview.RecyclerViewPager;
import java.util.ArrayList;
import java.util.List;

public class CreateAccountActivity extends ctj implements OnClickListener, a<List<Explore>> {
    private List<Explore> bWZ = new ArrayList();
    private fj cFC;
    protected CirclePageIndicator cNF;
    private RecyclerViewPager cQT;
    private cki cQU;
    private ExploreLoader cQW;
    private FlexibleButton daU;
    private FlexibleButton daV;
    private ImageView daW;

    public static void bF(Context context) {
        context.startActivity(new Intent(context, CreateAccountActivity.class));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_onboarding_create_account);
        this.daU = (FlexibleButton) findViewById(R.id.fb_log_in);
        this.daV = (FlexibleButton) findViewById(R.id.fb_sign_up);
        this.cQT = (RecyclerViewPager) findViewById(R.id.view_pager);
        this.cNF = (CirclePageIndicator) findViewById(R.id.indicator);
        this.daW = (ImageView) findViewById(R.id.iv_toolbar_left);
        this.daU.setOnClickListener(this);
        this.daV.setOnClickListener(this);
        this.daW.setOnClickListener(this);
        this.cFC = getSupportLoaderManager();
        this.cFC.a(14, null, this);
        this.cQW = new ExploreLoader(this);
        this.cQT.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.cQU = new cki(this.bWZ, tx.m13754a(this));
        this.cQT.setAdapter(this.cQU);
        this.cNF.setVisibility(0);
        this.cNF.m16025d(this.cQT, 0);
    }

    protected void onResume() {
        super.onResume();
    }

    private List<Explore> asA() {
        List<Explore> arrayList = new ArrayList();
        arrayList.add(new Explore("account", R.drawable.background_create_account1, getResources().getString(R.string.Onboarding_Create_Account_Header_Your_Watch_Your_Way), getResources().getString(R.string.Onboarding_Create_Account_Text_We_customize_your_data_and)));
        arrayList.add(new Explore("account", R.drawable.create_account_2, getResources().getString(R.string.Onboarding_Create_Account_Header_Your_Watch_Your_Way), getResources().getString(R.string.Onboarding_Create_Account_Text_We_customize_your_data_and)));
        arrayList.add(new Explore("account", R.drawable.create_account_3, getResources().getString(R.string.Onboarding_Create_Account_Header_Your_Watch_Your_Way), getResources().getString(R.string.Onboarding_Create_Account_Text_We_customize_your_data_and)));
        return arrayList;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_toolbar_left:
                finish();
                return;
            case R.id.fb_log_in:
                cmj.bs(PortfolioApp.ZQ()).logEvent("login_landing");
                LoginActivity.bF(this);
                return;
            case R.id.fb_sign_up:
                cmj.bs(PortfolioApp.ZQ()).logEvent("signup_landing");
                SignUpActivity.bF(this);
                return;
            default:
                return;
        }
    }

    public gx<List<Explore>> m15753b(int i, Bundle bundle) {
        return this.cQW;
    }

    public void m15752a(gx<List<Explore>> gxVar, List<Explore> list) {
        if (list == null || list.isEmpty()) {
            MFLogger.d(this.TAG, "Inside .onLoadFinished render with bundle content");
            this.bWZ = asA();
        } else {
            MFLogger.d(this.TAG, "Inside .onLoadFinished render with server content");
            this.bWZ.clear();
            for (Explore explore : list) {
                if (explore.getType().equalsIgnoreCase("account")) {
                    this.bWZ.add(explore);
                }
            }
        }
        this.cQU.N(this.bWZ);
        this.cQU.notifyDataSetChanged();
    }

    public void m15750a(gx<List<Explore>> gxVar) {
    }
}
