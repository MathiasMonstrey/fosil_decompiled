package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.facebook.internal.NativeProtocol;
import com.fossil.atn;
import com.fossil.atp;
import com.fossil.bfs;

public class GoogleApiActivity extends Activity implements OnCancelListener {
    private int bgc = 0;

    public static PendingIntent m14204a(Context context, PendingIntent pendingIntent, int i) {
        return PendingIntent.getActivity(context, 0, m14205a(context, pendingIntent, i, true), 134217728);
    }

    public static Intent m14205a(Context context, PendingIntent pendingIntent, int i, boolean z) {
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i);
        intent.putExtra("notify_manager", z);
        return intent;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.bgc = 0;
            setResult(i2, intent);
            if (booleanExtra) {
                bfs aM = bfs.aM(this);
                switch (i2) {
                    case -1:
                        aM.MZ();
                        break;
                    case 0:
                        aM.a(new atn(13, null), getIntent().getIntExtra("failing_client_id", -1));
                        break;
                }
            }
        } else if (i == 2) {
            this.bgc = 0;
            setResult(i2, intent);
        }
        finish();
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.bgc = 0;
        setResult(0);
        finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.bgc = bundle.getInt("resolution");
        }
        if (this.bgc != 1) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                Log.e("GoogleApiActivity", "Activity started without extras");
                finish();
                return;
            }
            PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
            Integer num = (Integer) extras.get(NativeProtocol.BRIDGE_ARG_ERROR_CODE);
            if (pendingIntent == null && num == null) {
                Log.e("GoogleApiActivity", "Activity started without resolution");
                finish();
            } else if (pendingIntent != null) {
                try {
                    startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                    this.bgc = 1;
                } catch (Throwable e) {
                    Log.e("GoogleApiActivity", "Failed to launch pendingIntent", e);
                    finish();
                }
            } else {
                atp.Ku().b(this, num.intValue(), 2, this);
                this.bgc = 1;
            }
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.bgc);
        super.onSaveInstanceState(bundle);
    }
}
