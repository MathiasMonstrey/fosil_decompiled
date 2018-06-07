package com.fossil;

import android.content.Context;
import android.support.v7.widget.RecyclerView.C1234a;
import android.support.v7.widget.RecyclerView.C1264v;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.buttonservice.model.Alarm;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class cwh extends C1234a<C2440b> {
    private List<Alarm> cIW;
    private C2438a cIX;
    private final int cIY = gn.m10634e(this.mContext, R.color.fossilOrange);
    private final int cIZ = gn.m10634e(this.mContext, R.color.fossilCoolGray);
    private Context mContext;

    interface C2438a {
        void kh(int i);

        void ki(int i);

        void mo2157x(int i, boolean z);
    }

    public class C2440b extends C1264v implements OnClickListener {
        private final TextView cJa;
        private final TextView cJb;
        private final View cJc;
        private final View cJd;
        private final TextView cJe;
        private final TextView cJf;
        private final TextView cJg;
        private final TextView cJh;
        private final TextView cJi;
        private final TextView cJj;
        private final TextView cJk;
        private final List<View> cJl;
        final /* synthetic */ cwh cJm;

        private C2440b(final cwh com_fossil_cwh, View view) {
            this.cJm = com_fossil_cwh;
            super(view);
            this.cJl = new ArrayList();
            this.cJd = view.findViewById(R.id.itemView);
            this.cJa = (TextView) view.findViewById(R.id.ftv_name);
            this.cJb = (TextView) view.findViewById(R.id.ftv_time);
            this.cJc = view.findViewById(R.id.v_enable);
            this.cJe = (TextView) view.findViewById(R.id.day_sunday);
            this.cJf = (TextView) view.findViewById(R.id.day_monday);
            this.cJg = (TextView) view.findViewById(R.id.day_tuesday);
            this.cJh = (TextView) view.findViewById(R.id.day_wednesday);
            this.cJi = (TextView) view.findViewById(R.id.day_thursday);
            this.cJj = (TextView) view.findViewById(R.id.day_friday);
            this.cJk = (TextView) view.findViewById(R.id.day_saturday);
            this.cJl.add(this.cJa);
            this.cJl.add(this.cJb);
            this.cJl.add(view.findViewById(R.id.ll_days_repeat));
            this.cJc.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ C2440b cJo;

                public void onClick(View view) {
                    view.setSelected(!view.isSelected());
                    this.cJo.cJm.cIX.mo2157x(this.cJo.rm(), view.isSelected());
                }
            });
            view.findViewById(R.id.aciv_remove).setOnClickListener(this);
            view.findViewById(R.id.itemView).setOnClickListener(this);
        }

        public void onClick(View view) {
            if (rm() != -1) {
                switch (view.getId()) {
                    case R.id.itemView:
                        this.cJm.cIX.kh(rm());
                        return;
                    case R.id.aciv_remove:
                        this.cJm.cIX.ki(rm());
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public /* synthetic */ C1264v mo1090c(ViewGroup viewGroup, int i) {
        return m7772n(viewGroup, i);
    }

    private cwh(Context context, List<Alarm> list, C2438a c2438a) {
        this.mContext = (Context) cco.m5996s(context, "context cannot be null!");
        this.cIW = (List) cco.m5996s(list, "alarms cannot be null!");
        this.cIX = (C2438a) cco.m5996s(c2438a, "listener cannot be null!");
    }

    public static cwh m7768a(Context context, List<Alarm> list, C2438a c2438a) {
        return new cwh(context, list, c2438a);
    }

    public C2440b m7772n(ViewGroup viewGroup, int i) {
        return new C2440b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.alarm_main_adapter, viewGroup, false));
    }

    public void m7770a(C2440b c2440b, int i) {
        int i2 = 12;
        Alarm alarm = (Alarm) this.cIW.get(i);
        c2440b.cJa.setText(alarm.getAlarmTitle());
        int alarmMinute = alarm.getAlarmMinute();
        int i3 = alarmMinute / 60;
        int i4 = alarmMinute % 60;
        if (DateFormat.is24HourFormat(this.mContext)) {
            c2440b.cJb.setText(String.format(Locale.getDefault(), "%02d", new Object[]{Integer.valueOf(i3)}) + ":" + String.format(Locale.getDefault(), "%02d", new Object[]{Integer.valueOf(i4)}));
        } else if (alarmMinute < 720) {
            if (i3 != 0) {
                i2 = i3;
            }
            c2440b.cJb.setText(cnd.m7187a(String.format(Locale.getDefault(), "%02d", new Object[]{Integer.valueOf(i2)}) + ":" + String.format(Locale.getDefault(), "%02d", new Object[]{Integer.valueOf(i4)}), arp.m4318u(this.mContext, R.string.Device_Alarm_Text_AM), 1.0f));
        } else {
            if (i3 > 12) {
                i2 = i3 - 12;
            }
            c2440b.cJb.setText(cnd.m7187a(String.format(Locale.getDefault(), "%02d", new Object[]{Integer.valueOf(i2)}) + ":" + String.format(Locale.getDefault(), "%02d", new Object[]{Integer.valueOf(i4)}), arp.m4318u(this.mContext, R.string.Device_Alarm_Text_PM), 1.0f));
        }
        boolean isActive = alarm.isActive();
        c2440b.cJc.setSelected(isActive);
        for (View view : c2440b.cJl) {
            float f;
            if (isActive) {
                f = 1.0f;
            } else {
                f = 0.4f;
            }
            view.setAlpha(f);
        }
        int[] days = alarm.getDays();
        if (days != null) {
            i3 = days.length;
        } else {
            i3 = 0;
        }
        if (i3 <= 0 || !alarm.isRepeat()) {
            c2440b.cJe.setTextColor(this.cIZ);
            c2440b.cJf.setTextColor(this.cIZ);
            c2440b.cJg.setTextColor(this.cIZ);
            c2440b.cJh.setTextColor(this.cIZ);
            c2440b.cJi.setTextColor(this.cIZ);
            c2440b.cJj.setTextColor(this.cIZ);
            c2440b.cJk.setTextColor(this.cIZ);
            return;
        }
        for (i2 = 1; i2 <= 7; i2++) {
            int i5 = 0;
            while (i5 < i3) {
                if (i2 == days[i5]) {
                    switch (i2) {
                        case 1:
                            c2440b.cJe.setTextColor(this.cIY);
                            break;
                        case 2:
                            c2440b.cJf.setTextColor(this.cIY);
                            break;
                        case 3:
                            c2440b.cJg.setTextColor(this.cIY);
                            break;
                        case 4:
                            c2440b.cJh.setTextColor(this.cIY);
                            break;
                        case 5:
                            c2440b.cJi.setTextColor(this.cIY);
                            break;
                        case 6:
                            c2440b.cJj.setTextColor(this.cIY);
                            break;
                        case 7:
                            c2440b.cJk.setTextColor(this.cIY);
                            break;
                        default:
                            break;
                    }
                } else {
                    if (i5 == i3 - 1) {
                        switch (i2) {
                            case 1:
                                c2440b.cJe.setTextColor(this.cIZ);
                                break;
                            case 2:
                                c2440b.cJf.setTextColor(this.cIZ);
                                break;
                            case 3:
                                c2440b.cJg.setTextColor(this.cIZ);
                                break;
                            case 4:
                                c2440b.cJh.setTextColor(this.cIZ);
                                break;
                            case 5:
                                c2440b.cJi.setTextColor(this.cIZ);
                                break;
                            case 6:
                                c2440b.cJj.setTextColor(this.cIZ);
                                break;
                            case 7:
                                c2440b.cJk.setTextColor(this.cIZ);
                                break;
                            default:
                                break;
                        }
                    }
                    i5++;
                }
            }
        }
    }

    public int getItemCount() {
        return this.cIW.size();
    }
}
