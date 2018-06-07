package com.portfolio.platform.ui.debug;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import com.fossil.ot;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;

public class DebugClearDataWarningActivity extends ot {

    class C49381 implements OnClickListener {
        final /* synthetic */ DebugClearDataWarningActivity cHN;

        class C49371 implements Runnable {
            final /* synthetic */ C49381 cHO;

            C49371(C49381 c49381) {
                this.cHO = c49381;
            }

            public void run() {
                PortfolioApp.ZQ().aai();
            }
        }

        C49381(DebugClearDataWarningActivity debugClearDataWarningActivity) {
            this.cHN = debugClearDataWarningActivity;
        }

        public void onClick(View view) {
            Toast.makeText(this.cHN, "The app is being restarted...", 1).show();
            new Handler().postDelayed(new C49371(this), 1500);
        }
    }

    public static void bF(Context context) {
        Intent intent = new Intent(context, DebugClearDataWarningActivity.class);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_debug_clear_data_warning);
        ((Button) findViewById(R.id.btn_got_it)).setOnClickListener(new C49381(this));
    }

    public void onBackPressed() {
    }
}
