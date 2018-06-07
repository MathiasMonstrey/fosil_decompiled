package com.fossil;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.appevents.AppEventsConstants;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.view.ClockView;
import com.portfolio.platform.view.ClockView.b;
import com.portfolio.platform.view.FlexibleTextView;
import java.util.HashMap;
import java.util.Map;

public class dbv extends drl implements b {
    private static final String TAG = dbv.class.getSimpleName();
    private String cON;
    private int cOO = -1;
    private boolean cOP;
    private C2637a cOQ;

    class C26351 implements OnClickListener {
        final /* synthetic */ dbv cOR;

        C26351(dbv com_fossil_dbv) {
            this.cOR = com_fossil_dbv;
        }

        public void onClick(View view) {
            this.cOR.dismiss();
            cmj.bs(PortfolioApp.ZQ()).logEvent("notifications_number_cancel");
        }
    }

    class C26362 implements OnClickListener {
        final /* synthetic */ dbv cOR;

        C26362(dbv com_fossil_dbv) {
            this.cOR = com_fossil_dbv;
        }

        public void onClick(View view) {
            if (!(this.cOR.cOQ == null || this.cOR.cOO == -1)) {
                this.cOR.cOQ.kr(this.cOR.cOO);
            }
            if (dch.class.getSimpleName().equals(this.cOR.cON) && this.cOR.cOP) {
                this.cOR.m7628n("notifications_reassign_choose_number", "Step", "2");
            }
        }
    }

    public interface C2637a {
        void kr(int i);
    }

    public dbv() {
        setStyle(0, R.style.BottomSheetTheme);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog asVar = new as(getContext(), getTheme());
        View inflate = View.inflate(getContext(), R.layout.bottom_sheet_hour_picker, null);
        ClockView clockView = (ClockView) inflate.findViewById(R.id.clock_picker);
        clockView.setShowHand(false);
        clockView.setCurrentHour(this.cOO);
        clockView.setClockOnTouchListener(this);
        inflate.findViewById(R.id.close_picker).setOnClickListener(new C26351(this));
        inflate.findViewById(R.id.fb_next).setOnClickListener(new C26362(this));
        if (this.cOP) {
            ((FlexibleTextView) inflate.findViewById(R.id.fb_next)).setText(PortfolioApp.ZQ().getResources().getString(R.string.Notifications_Preview_Assign_CTA_DONE));
        }
        asVar.setContentView(inflate);
        return asVar;
    }

    public void setCurrentHour(int i) {
        this.cOO = i;
    }

    public void cE(boolean z) {
        this.cOP = z;
    }

    public void hide() {
        dismiss();
    }

    public void kq(int i) {
        this.cOO = i;
        if (dby.class.getSimpleName().equals(this.cON)) {
            m7628n("notifications_number_choose", "Source", String.valueOf(i));
        } else if (dch.class.getSimpleName().equals(this.cON)) {
            Map hashMap = new HashMap();
            hashMap.put("Dest", String.valueOf(i));
            hashMap.put("Step", AppEventsConstants.EVENT_PARAM_VALUE_YES);
            m7627f("notifications_reassign_choose_number", hashMap);
        }
    }

    public void ip(String str) {
        this.cON = str;
    }

    public void m8183a(C2637a c2637a) {
        this.cOQ = c2637a;
    }
}
