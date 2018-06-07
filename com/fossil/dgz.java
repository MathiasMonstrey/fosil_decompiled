package com.fossil;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.view.FlexibleEditText;

public class dgz extends ev {
    private static final String TAG = dgz.class.getSimpleName();
    private C2759a cTT;
    private String cTU;

    class C27561 implements TextWatcher {
        final /* synthetic */ dgz cTV;

        C27561(dgz com_fossil_dgz) {
            this.cTV = com_fossil_dgz;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            this.cTV.cTU = editable.toString().trim();
        }
    }

    class C27572 implements OnClickListener {
        final /* synthetic */ dgz cTV;

        C27572(dgz com_fossil_dgz) {
            this.cTV = com_fossil_dgz;
        }

        public void onClick(View view) {
            this.cTV.ab(true);
        }
    }

    class C27583 implements OnClickListener {
        final /* synthetic */ dgz cTV;

        C27583(dgz com_fossil_dgz) {
            this.cTV = com_fossil_dgz;
        }

        public void onClick(View view) {
            if (this.cTV.cTU != null && !this.cTV.cTU.isEmpty()) {
                this.cTV.ab(false);
            }
        }
    }

    public interface C2759a {
        void iy(String str);

        void onCancel();
    }

    public static dgz m8541a(C2759a c2759a) {
        dgz com_fossil_dgz = new dgz();
        com_fossil_dgz.cTT = c2759a;
        return com_fossil_dgz;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, 16973830);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_name_your_preset, viewGroup);
        ((FlexibleEditText) inflate.findViewById(R.id.preset_name_et)).addTextChangedListener(new C27561(this));
        inflate.findViewById(R.id.close_iv).setOnClickListener(new C27572(this));
        inflate.findViewById(R.id.save_tv).setOnClickListener(new C27583(this));
        return inflate;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.requestWindowFeature(1);
        onCreateDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        onCreateDialog.getWindow().setLayout(-1, -1);
        return onCreateDialog;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    private void ab(boolean z) {
        if (this.cTT != null) {
            if (z) {
                this.cTT.onCancel();
            } else {
                this.cTT.iy(this.cTU);
            }
        }
        dismiss();
    }
}
