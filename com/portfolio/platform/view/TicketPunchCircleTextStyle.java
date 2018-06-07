package com.portfolio.platform.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fossil.arp;
import com.fossil.cjz.a;
import com.fossil.gn;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;

public class TicketPunchCircleTextStyle extends FrameLayout {
    private TextView dnq = ((TextView) findViewById(R.id.tv_ticket_punch));
    private RelativeLayout dnr = ((RelativeLayout) findViewById(R.id.rl_ticket_box));
    private TicketState dns;

    public enum TicketState {
        DESELECT,
        SELECT
    }

    public TicketPunchCircleTextStyle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        inflate(context, R.layout.view_ticket_punch_circle_text_style, this);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.TitlePunchCircleWidget);
        cl(obtainStyledAttributes.getResourceId(0, -1), obtainStyledAttributes.getColor(1, -1));
        obtainStyledAttributes.recycle();
        setTicketState(TicketState.DESELECT);
    }

    private void cl(int i, int i2) {
        if (i != -1) {
            this.dnq.setText(arp.u(PortfolioApp.ZQ(), i));
            this.dnq.setTextColor(i2);
        }
    }

    public TicketState getTicketState() {
        return this.dns;
    }

    public void setTicketState(TicketState ticketState) {
        int i = R.drawable.bg_item_unit_disable;
        this.dns = ticketState;
        switch (ticketState) {
            case SELECT:
                i = R.drawable.bg_item_unit_enable;
                break;
        }
        this.dnr.setBackground(gn.c(getContext(), i));
    }
}
