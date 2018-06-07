package com.fossil;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.support.v7.widget.RecyclerView.C1234a;
import android.support.v7.widget.RecyclerView.C1264v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.view.RingChart;
import com.portfolio.platform.view.recyclerview.RecyclerViewCalendar.a;
import java.lang.reflect.Array;
import java.util.Calendar;
import java.util.Map;
import java.util.TreeMap;

public class dsa extends C1234a<C1264v> {
    private Calendar doA;
    private Calendar doB;
    private Calendar doC;
    private int doD = -1;
    private Map<Long, Float> doE = new TreeMap();
    private int[] doF = new int[49];
    private int doG;
    private a doH;
    private final int doI;
    private final PorterDuffColorFilter doJ;
    private final PorterDuffColorFilter doK;
    private final Context mContext;

    class C3160a extends C1264v implements OnClickListener {
        RingChart cuO;
        TextView doL;
        View doM;
        final /* synthetic */ dsa doN;

        C3160a(dsa com_fossil_dsa, View view) {
            this.doN = com_fossil_dsa;
            super(view);
            this.doL = (TextView) view.findViewById(R.id.day);
            this.doM = view.findViewById(R.id.dot);
            this.cuO = (RingChart) view.findViewById(R.id.chart);
            view.setOnClickListener(this);
        }

        public void onClick(View view) {
            int rm = rm();
            if (this.doN.doH != null && rm != -1) {
                Calendar a = this.doN.md(rm);
                if (a != null && !a.before(this.doN.doA) && !a.after(this.doN.doB)) {
                    this.doN.doH.a(rm, a);
                }
            }
        }
    }

    class C3161b extends C1264v {
        TextView cSB;
        final /* synthetic */ dsa doN;

        C3161b(dsa com_fossil_dsa, View view) {
            this.doN = com_fossil_dsa;
            super(view);
            this.cSB = (TextView) view;
        }
    }

    public dsa(Context context) {
        int i;
        this.mContext = context;
        this.doI = gn.m10634e(this.mContext, R.color.fossilOrange);
        this.doK = new PorterDuffColorFilter(this.doI, Mode.CLEAR);
        this.doJ = new PorterDuffColorFilter(this.doI, Mode.SRC_ATOP);
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{7, 7});
        for (i = 0; i < 7; i++) {
            for (int i2 = 0; i2 < 7; i2++) {
                iArr[i][i2] = (i * 7) + i2;
            }
        }
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{7, 7});
        for (int i3 = 0; i3 < 7; i3++) {
            for (i = 0; i < 7; i++) {
                iArr2[i3][i] = iArr[i][6 - i3];
            }
        }
        for (int i4 = 0; i4 < 7; i4++) {
            System.arraycopy(iArr2[i4], 0, this.doF, (i4 * 7) + 1, 6);
        }
    }

    public int getItemViewType(int i) {
        return i % 7 == 0 ? 0 : 1;
    }

    public C1264v mo1090c(ViewGroup viewGroup, int i) {
        View inflate;
        switch (i) {
            case 0:
                inflate = LayoutInflater.from(this.mContext).inflate(R.layout.title_view_holder, viewGroup, false);
                inflate.getLayoutParams().width = this.doG;
                return new C3161b(this, inflate);
            default:
                inflate = LayoutInflater.from(this.mContext).inflate(R.layout.day_view_holder, viewGroup, false);
                inflate.getLayoutParams().width = this.doG;
                return new C3160a(this, inflate);
        }
    }

    public void mo1089a(C1264v c1264v, int i) {
        switch (c1264v.rp()) {
            case 0:
                CharSequence charSequence = "";
                switch ((i / 7) % 7) {
                    case 0:
                        charSequence = arp.m4318u(this.mContext, R.string.Stats_Activity_Accuracy_Label_S_1);
                        break;
                    case 1:
                        charSequence = arp.m4318u(this.mContext, R.string.Stats_Activity_Accuracy_Label_F);
                        break;
                    case 2:
                        charSequence = arp.m4318u(this.mContext, R.string.Stats_Activity_Accuracy_Label_T_1);
                        break;
                    case 3:
                        charSequence = arp.m4318u(this.mContext, R.string.Stats_Activity_Accuracy_Label_W);
                        break;
                    case 4:
                        charSequence = arp.m4318u(this.mContext, R.string.Stats_Activity_Accuracy_Label_T);
                        break;
                    case 5:
                        charSequence = arp.m4318u(this.mContext, R.string.Stats_Activity_Accuracy_Label_M);
                        break;
                    case 6:
                        charSequence = arp.m4318u(this.mContext, R.string.Stats_Activity_Accuracy_Label_S);
                        break;
                }
                ((C3161b) c1264v).cSB.setText(charSequence);
                return;
            case 1:
                Calendar me = me(i);
                C3160a c3160a = (C3160a) c1264v;
                int i2 = me.get(7) - 1;
                int i3 = this.doF[i % 49];
                if (i3 < i2 || i3 >= me.getActualMaximum(5) + i2) {
                    c3160a.doL.setVisibility(4);
                    c3160a.doL.getBackground().setColorFilter(this.doK);
                    c3160a.doM.setVisibility(8);
                    c3160a.cuO.setVisibility(8);
                    return;
                }
                me.add(5, i3 - i2);
                if (this.doD == -1 && cmq.m7108a(this.doC.getTime(), me.getTime())) {
                    this.doD = i;
                }
                c3160a.doL.setVisibility(0);
                c3160a.doL.setText(String.valueOf(me.get(5)));
                c3160a.doL.setTextColor(gn.m10634e(this.mContext, this.doD == i ? R.color.white : R.color.fossilCharcoal));
                c3160a.doL.getBackground().setColorFilter(this.doD == i ? this.doJ : this.doK);
                View view = c3160a.doM;
                if (cmq.m7108a(Calendar.getInstance().getTime(), me.getTime())) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                view.setVisibility(i2);
                Float f = (Float) this.doE.get(Long.valueOf(cmq.m7110b(me).getTimeInMillis()));
                if (f != null) {
                    c3160a.cuO.clearData();
                    c3160a.cuO.setVisibility(0);
                    c3160a.cuO.setGoal(1);
                    if (f.floatValue() < 1.0f) {
                        c3160a.cuO.f(f.floatValue(), this.doI);
                        c3160a.cuO.setAlpha(0.65f);
                    } else {
                        c3160a.cuO.f(1.0f, this.doI);
                        c3160a.cuO.setAlpha(1.0f);
                    }
                    c3160a.cuO.XT();
                    return;
                }
                c3160a.cuO.setVisibility(8);
                return;
            default:
                return;
        }
    }

    public int getItemCount() {
        if (this.doA == null || this.doB == null) {
            return 0;
        }
        return (((((this.doB.get(1) - this.doA.get(1)) * 12) + this.doB.get(2)) - this.doA.get(2)) + 1) * 49;
    }

    public void setOnCalendarItemClickListener(a aVar) {
        this.doH = aVar;
    }

    private Calendar md(int i) {
        Calendar me = me(i);
        int i2 = this.doF[i % 49];
        int i3 = me.get(7) - 1;
        if (i2 < i3 || i2 >= me.getActualMaximum(5) + i3) {
            return null;
        }
        me.add(5, i2 - i3);
        return me;
    }

    public Calendar me(int i) {
        Calendar calendar = (Calendar) this.doB.clone();
        int i2 = (-i) / 49;
        calendar.add(1, i2 / 12);
        calendar.add(2, i2 % 12);
        calendar.set(5, 1);
        return calendar;
    }

    public Calendar awk() {
        return this.doA;
    }

    public void m9585i(Calendar calendar) {
        this.doA = calendar;
    }

    public Calendar awl() {
        return this.doB;
    }

    public void m9586j(Calendar calendar) {
        this.doB = calendar;
    }

    public void setSelectDate(Calendar calendar) {
        this.doC = calendar;
        if (this.doA == null) {
            this.doA = this.doC;
        }
        if (this.doB == null) {
            this.doB = this.doC;
        }
    }

    public int awm() {
        return this.doD;
    }

    public void setSelectPosition(int i) {
        this.doD = i;
    }

    public void mf(int i) {
        this.doG = i;
    }

    public void setData(Map<Long, Float> map) {
        this.doE.putAll(map);
    }
}
