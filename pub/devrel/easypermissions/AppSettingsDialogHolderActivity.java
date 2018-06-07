package pub.devrel.easypermissions;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.fossil.eva;
import com.fossil.os;
import com.fossil.ot;

public class AppSettingsDialogHolderActivity extends ot implements OnClickListener {
    private os agL;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.agL = eva.a(getIntent(), this).a(this, this);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.agL != null && this.agL.isShowing()) {
            this.agL.dismiss();
        }
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            startActivityForResult(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.fromParts("package", getPackageName(), null)), 7534);
        } else if (i == -2) {
            setResult(0);
            finish();
        } else {
            throw new IllegalStateException("Unknown button type: " + i);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        setResult(i2, intent);
        finish();
    }
}
