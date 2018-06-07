package com.portfolio.platform.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View.OnClickListener;
import com.fossil.cnp;
import com.fossil.ctj;
import com.fossil.cts.b;
import com.fossil.ctt;
import com.fossil.ctv;
import com.fossil.ctx;
import com.fossil.e;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.buddychallenge.BCNotifications;
import java.util.HashMap;

public class MainActivity extends ctj implements OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    public ctx cES;

    public static void bF(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(268468224);
        context.startActivity(intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e.a(this, R.layout.base_activity);
        b bVar = (ctt) getSupportFragmentManager().aF(R.id.content);
        if (bVar == null) {
            bVar = ctt.cFl.agH();
            a(bVar, R.id.content);
        }
        PortfolioApp.ZQ().aam().a(new ctv(bVar, PortfolioApp.ZQ().aaa(), getSupportLoaderManager())).a(this);
        if (bundle != null) {
            this.cES.jR(bundle.getInt("OUT_STATE_DASHBOARD_CURRENT_TAB", 0));
        }
    }

    protected void onResume() {
        Log.d(TAG, "MainActivity onResume");
        super.onResume();
        Intent intent = getIntent();
        if (intent.hasExtra("NOTIFICATION")) {
            BCNotifications bCNotifications = (BCNotifications) intent.getParcelableExtra("NOTIFICATION");
            if (bCNotifications != null) {
                this.cES.b(bCNotifications);
                intent.removeExtra("NOTIFICATION");
            }
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("OUT_STATE_DASHBOARD_CURRENT_TAB", this.cES.agR());
        super.onSaveInstanceState(bundle);
    }

    protected void onNewIntent(Intent intent) {
        Log.d(TAG, "MainActivity onNewIntent");
        super.onNewIntent(intent);
        setIntent(intent);
        if (intent != null && intent.getData() != null && intent.getAction() != null && intent.getAction().equals("android.intent.action.VIEW")) {
            HashMap gv = cnp.acc().gv(intent.getData().toString());
            if (gv != null && !gv.isEmpty()) {
                this.cES.e(gv);
            }
        }
    }

    protected void onStop() {
        Log.d(TAG, "MainActivity onStop");
        super.onStop();
    }
}
