package com.portfolio.platform.view.recyclerview;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.s;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.fossil.dqu;
import com.fossil.dsa;
import com.fossil.dsb;
import com.fossil.wearables.fossil.R;
import java.util.Calendar;
import java.util.Map;

public class RecyclerViewCalendar extends ConstraintLayout implements OnClickListener {
    private GridLayoutManager doU;
    private dsa doV;
    private dsb doW;
    private C5038b doX;
    private C5039c doY;
    private View doZ;
    private View dpa;
    private View dpb;
    private TextView dpc;

    class C50342 extends b {
        final /* synthetic */ RecyclerViewCalendar dpd;

        C50342(RecyclerViewCalendar recyclerViewCalendar) {
            this.dpd = recyclerViewCalendar;
        }

        public int dc(int i) {
            switch (this.dpd.doV.getItemViewType(i)) {
                case 0:
                    return 1;
                case 1:
                    return 2;
                default:
                    return -1;
            }
        }
    }

    class C50364 extends l {
        int doO = -1;
        final /* synthetic */ RecyclerViewCalendar dpd;

        C50364(RecyclerViewCalendar recyclerViewCalendar) {
            this.dpd = recyclerViewCalendar;
        }

        public void m16035g(RecyclerView recyclerView, int i, int i2) {
            int awn = this.dpd.doW.awn();
            if (awn != this.doO) {
                this.doO = awn;
                Calendar me = this.dpd.doV.me(awn);
                Calendar awl = this.dpd.doV.awl();
                this.dpd.m16042d(this.dpd.doV.awk(), awl);
                if (this.dpd.doX != null) {
                    this.dpd.doX.m16037h(me);
                }
            }
        }
    }

    public interface C5037a {
        void m16036a(int i, Calendar calendar);
    }

    public interface C5038b {
        void m16037h(Calendar calendar);
    }

    public interface C5039c {
        void arW();

        void arX();

        void ja();
    }

    public RecyclerViewCalendar(Context context) {
        this(context, null);
    }

    public RecyclerViewCalendar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerViewCalendar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    void init(Context context) {
        View inflate = inflate(context, R.layout.calendar_view, this);
        this.dpc = (TextView) inflate.findViewById(R.id.month);
        this.doZ = inflate.findViewById(R.id.next);
        this.dpa = inflate.findViewById(R.id.prev);
        this.dpb = inflate.findViewById(R.id.today);
        final RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.days);
        this.doV = new dsa(context);
        final Context context2 = context;
        this.doU = new GridLayoutManager(this, context, 13, 0, true) {
            final /* synthetic */ RecyclerViewCalendar dpd;

            protected int m16034c(s sVar) {
                return dqu.bQ(context2);
            }
        };
        this.doU.a(new C50342(this));
        recyclerView.setLayoutManager(this.doU);
        recyclerView.setItemAnimator(null);
        this.doW = new dsb();
        this.doW.o(recyclerView);
        recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
            final /* synthetic */ RecyclerViewCalendar dpd;

            public void onGlobalLayout() {
                this.dpd.doV.mf(recyclerView.getMeasuredWidth() / 7);
                recyclerView.setAdapter(this.dpd.doV);
                recyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
        recyclerView.a(new C50364(this));
        this.doZ.setOnClickListener(this);
        this.dpa.setOnClickListener(this);
        this.dpb.setOnClickListener(this);
    }

    public void setStartDate(Calendar calendar) {
        this.doV.i(calendar);
        this.doV.notifyDataSetChanged();
        m16042d(calendar, this.doV.awl());
    }

    public void setEndDate(Calendar calendar) {
        this.doV.j(calendar);
        this.doV.notifyDataSetChanged();
        m16042d(this.doV.awk(), calendar);
    }

    public void setSelectDate(Calendar calendar) {
        this.doV.setSelectDate(calendar);
        this.doV.notifyDataSetChanged();
        Calendar awl = this.doV.awl();
        this.doW.mg((((calendar.get(1) - awl.get(1)) * 12) + calendar.get(2)) - awl.get(2));
    }

    public void setSelectPosition(int i) {
        int awm = this.doV.awm();
        this.doV.setSelectPosition(i);
        this.doV.dr(awm);
        this.doV.dr(i);
    }

    private void m16042d(Calendar calendar, Calendar calendar2) {
        int i = 8;
        if (calendar != null && calendar2 != null) {
            Calendar me = this.doV.me(this.doW.awn());
            int i2 = me.get(2);
            int i3 = me.get(1);
            View view = this.dpa;
            int i4 = (i2 == calendar.get(2) && i3 == calendar.get(1)) ? 8 : 0;
            view.setVisibility(i4);
            view = this.doZ;
            if (i2 == calendar2.get(2) && i3 == calendar2.get(1)) {
                i4 = 8;
            } else {
                i4 = 0;
            }
            view.setVisibility(i4);
            View view2 = this.dpb;
            if (!(i2 == calendar2.get(2) && i3 == calendar2.get(1))) {
                i = 0;
            }
            view2.setVisibility(i);
            TextView textView = this.dpc;
            String str = "%tB %s";
            Object[] objArr = new Object[2];
            objArr[0] = me;
            objArr[1] = i3 != Calendar.getInstance().get(1) ? Integer.valueOf(i3) : "";
            textView.setText(String.format(str, objArr).trim());
        }
    }

    private void mh(int i) {
        if (this.doY != null) {
            switch (i) {
                case R.id.prev:
                    this.doY.arW();
                    return;
                case R.id.next:
                    this.doY.ja();
                    return;
                case R.id.today:
                    this.doY.arX();
                    return;
                default:
                    return;
            }
        }
    }

    public void setOnCalendarItemClickListener(C5037a c5037a) {
        this.doV.setOnCalendarItemClickListener(c5037a);
    }

    public void setOnCalendarMonthChanged(C5038b c5038b) {
        this.doX = c5038b;
    }

    public void setNavigatingListener(C5039c c5039c) {
        this.doY = c5039c;
    }

    public void setData(Map<Long, Float> map) {
        this.doV.setData(map);
        int po = this.doU.po();
        int pq = this.doU.pq();
        if (po != -1 && pq != -1) {
            this.doV.aw(po, (pq - po) + 1);
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.prev:
                this.doW.arW();
                break;
            case R.id.next:
                this.doW.ja();
                break;
            case R.id.today:
                this.doW.awo();
                break;
        }
        mh(view.getId());
    }
}
