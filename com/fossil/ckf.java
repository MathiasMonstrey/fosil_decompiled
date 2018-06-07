package com.fossil;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.fossil.wearables.fossil.R;
import com.fossil.wearables.fsl.fitness.FitnessProviderImpl;
import com.fossil.wearables.fsl.fitness.SampleDay;
import com.portfolio.platform.view.CalendarView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ckf extends BaseAdapter {
    private static final String TAG = ckf.class.getSimpleName();
    private ArrayList<SampleDay> coh;
    private ArrayList<View> coi = new ArrayList();
    private LayoutInflater coj;
    private SimpleDateFormat cok = new SimpleDateFormat("MMddyyyy");
    private CalendarView col;
    C2141b com;
    int con = 192;
    private Context context;

    public class C2140a {
        final /* synthetic */ ckf coq;
        TextView cor;
        View cos;

        public C2140a(ckf com_fossil_ckf) {
            this.coq = com_fossil_ckf;
        }
    }

    public interface C2141b {
        void abs();

        void m6891b(Date date);
    }

    public ckf(Context context, ArrayList<SampleDay> arrayList, CalendarView calendarView) {
        this.context = context;
        this.coh = arrayList;
        this.coj = (LayoutInflater) context.getSystemService("layout_inflater");
        this.col = calendarView;
    }

    public void setOnCalendarTouchListener(C2141b c2141b) {
        this.com = c2141b;
    }

    public int getCount() {
        return this.coh.size();
    }

    public Object getItem(int i) {
        return this.coh.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C2140a c2140a;
        SampleDay sampleDay = (SampleDay) this.coh.get(i);
        Calendar instance = Calendar.getInstance();
        instance.set(sampleDay.getYear(), sampleDay.getMonth() - 1, sampleDay.getDay());
        final Date time = instance.getTime();
        Date date = new Date();
        Date time2 = this.col.getCurrentCalendar().getTime();
        if (view == null) {
            view = this.coj.inflate(R.layout.control_calendar_view, viewGroup, false);
            C2140a c2140a2 = new C2140a(this);
            c2140a2.cor = (TextView) view.findViewById(R.id.tv_day);
            c2140a2.cos = view.findViewById(R.id.v_progress_circle);
            view.setTag(c2140a2);
            c2140a = c2140a2;
        } else {
            c2140a = (C2140a) view.getTag();
        }
        if (time.getMonth() == time2.getMonth()) {
            int upcomingTextColor;
            int i2;
            c2140a.cor.setText(String.valueOf(time.getDate()));
            final String format = this.cok.format(time);
            final String format2 = this.cok.format(date);
            if (format.compareTo(format2) > 0) {
                upcomingTextColor = this.col.getUpcomingTextColor();
                c2140a.cos.setBackgroundDrawable(m6892j(0.0d));
                c2140a.cos.setTag(Integer.valueOf(-1));
                i2 = 0;
            } else {
                if (format.equals(format2)) {
                    i2 = c2140a.cor.getPaintFlags() | 8;
                    upcomingTextColor = this.col.getTodayTextColor();
                } else {
                    upcomingTextColor = this.col.getPreviousTextColor();
                    i2 = 0;
                }
                double steps = sampleDay.getSteps();
                int stepGoal = sampleDay.getStepGoal();
                if (stepGoal == 0) {
                    stepGoal = FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL;
                }
                steps = (steps / ((double) stepGoal)) * 100.0d;
                c2140a.cos.setBackgroundDrawable(m6892j(steps));
                c2140a.cos.setTag(Double.valueOf(steps));
                c2140a.cos.setOnTouchListener(new OnTouchListener(this) {
                    final /* synthetic */ ckf coq;

                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                            view.setScaleX(1.0f);
                            view.setScaleY(1.0f);
                            if (format.compareTo(format2) > 0 || ((Double) view.getTag()).doubleValue() == 0.0d) {
                                view.setBackgroundResource(0);
                            }
                            this.coq.com.abs();
                            return true;
                        } else if (motionEvent.getAction() == 0) {
                            view.setScaleX(1.5f);
                            view.setScaleY(1.5f);
                            if (format.compareTo(format2) > 0 || ((Double) view.getTag()).doubleValue() == 0.0d) {
                                if (this.coq.con == 192) {
                                    view.setBackgroundResource(R.drawable.calendar_circle_nodata_progress_with_stroke_dark);
                                } else {
                                    view.setBackgroundResource(R.drawable.calendar_circle_nodata_progress_with_stroke_light);
                                }
                            }
                            this.coq.com.m6891b(time);
                            return true;
                        } else if (motionEvent.getAction() == 2) {
                            return false;
                        } else {
                            return false;
                        }
                    }
                });
            }
            c2140a.cor.setPaintFlags(i2);
            c2140a.cor.setTextColor(upcomingTextColor);
        } else {
            c2140a.cor.setText("");
        }
        this.coi.add(c2140a.cos);
        view.setEnabled(false);
        return view;
    }

    private Drawable m6892j(double d) {
        int completedColor;
        Drawable drawable = this.context.getResources().getDrawable(R.drawable.calendar_circle_progress);
        if (d >= 100.0d) {
            completedColor = this.col.getCompletedColor();
        } else if (d <= 0.0d || d >= 100.0d) {
            completedColor = this.col.getNoDataColor();
        } else {
            completedColor = this.col.getIncompletedColor();
        }
        drawable.setColorFilter(completedColor, Mode.MULTIPLY);
        return drawable;
    }

    public void m6893g(ArrayList<SampleDay> arrayList) {
        this.coh = arrayList;
        notifyDataSetChanged();
    }

    public void setFragmentType(int i) {
        this.con = i;
    }
}
