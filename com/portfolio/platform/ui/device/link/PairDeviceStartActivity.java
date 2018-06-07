package com.portfolio.platform.ui.device.link;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import com.fossil.ctj;
import com.fossil.czh;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;

public class PairDeviceStartActivity extends ctj implements OnClickListener {
    private static final String TAG = PairDeviceStartActivity.class.getSimpleName();

    public static void bH(Context context) {
        Intent intent = new Intent(context, PairDeviceStartActivity.class);
        intent.addFlags(268468224);
        context.startActivity(intent);
    }

    public static void bF(Context context) {
        context.startActivity(new Intent(context, PairDeviceStartActivity.class));
    }

    public static void bI(Context context) {
        Intent intent = new Intent(context, PairDeviceStartActivity.class);
        intent.putExtra("IS_FROM_DEVICE_LIST", true);
        context.startActivity(intent);
    }

    protected void onCreate(Bundle bundle) {
        MFLogger.d(TAG, "onCreate()");
        super.onCreate(bundle);
        setContentView(R.layout.base_activity);
        if (((czh) getSupportFragmentManager().aF(R.id.content)) == null) {
            a(czh.cMj.aku(), R.id.content);
        }
    }
}
