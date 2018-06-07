package com.portfolio.platform.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.GridView;
import android.widget.LinearLayout;
import com.fossil.cjz.a;
import com.fossil.ckf;
import com.fossil.ckf.b;
import com.fossil.cnq;
import com.fossil.wearables.fossil.R;
import com.fossil.wearables.fsl.fitness.FitnessProvider;
import com.fossil.wearables.fsl.fitness.Interpolator;
import com.fossil.wearables.fsl.fitness.SampleDay;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

public class CalendarView extends LinearLayout {
    private static final String TAG = CalendarView.class.getSimpleName();
    private ArrayList<SampleDay> coh;
    protected GridView dgA;
    private int dgB;
    private int dgC;
    private int dgD;
    private int dgE;
    private int dgF;
    private int dgG;
    private Calendar dgz;

    class C49751 implements OnTouchListener {
        final /* synthetic */ CalendarView dgH;

        C49751(CalendarView calendarView) {
            this.dgH = calendarView;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return motionEvent.getAction() == 2;
        }
    }

    public void setCompletedColor(int i) {
        this.dgB = i;
    }

    public void setIncompletedColor(int i) {
        this.dgC = i;
    }

    public void setNoDataColor(int i) {
        this.dgD = i;
    }

    public void setTodayTextColor(int i) {
        this.dgE = i;
    }

    public void setPreviousTextColor(int i) {
        this.dgF = i;
    }

    public void setUpcomingTextColor(int i) {
        this.dgG = i;
    }

    public CalendarView(Context context) {
        super(context);
        this.coh = new ArrayList();
        cz(context);
    }

    public CalendarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.calendarStyle);
    }

    public CalendarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.coh = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.RecyclerViewCalendar, i, 0);
        this.dgB = obtainStyledAttributes.getColor(0, 0);
        this.dgC = obtainStyledAttributes.getColor(1, 0);
        this.dgD = obtainStyledAttributes.getColor(2, 0);
        this.dgE = obtainStyledAttributes.getColor(3, 0);
        this.dgF = obtainStyledAttributes.getColor(4, 0);
        this.dgG = obtainStyledAttributes.getColor(5, 0);
        obtainStyledAttributes.recycle();
        cz(context);
    }

    public Calendar getCurrentCalendar() {
        return this.dgz;
    }

    private void cz(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.view_calendar, this);
        this.dgA = (GridView) findViewById(R.id.grid);
        this.dgA.setAdapter(new ckf(context, new ArrayList(), this));
        this.dgA.setOnTouchListener(new C49751(this));
        this.dgz = Calendar.getInstance();
        auW();
    }

    public int getCompletedColor() {
        return this.dgB;
    }

    public int getIncompletedColor() {
        return this.dgC;
    }

    public int getNoDataColor() {
        return this.dgD;
    }

    public int getTodayTextColor() {
        return this.dgE;
    }

    public int getPreviousTextColor() {
        return this.dgF;
    }

    public int getUpcomingTextColor() {
        return this.dgG;
    }

    private void auW() {
        this.coh = new ArrayList();
        Calendar calendar = (Calendar) this.dgz.clone();
        calendar.set(5, 1);
        calendar.add(5, -(calendar.get(7) - 1));
        while (this.coh.size() < 42) {
            this.coh.add(m15822A(calendar.getTime()));
            calendar.add(5, 1);
        }
        ((ckf) this.dgA.getAdapter()).g(this.coh);
    }

    public void setOnCalendarTouchListener(b bVar) {
        ((ckf) this.dgA.getAdapter()).setOnCalendarTouchListener(bVar);
    }

    public void setFragmentType(int i) {
        ((ckf) this.dgA.getAdapter()).setFragmentType(i);
    }

    private SampleDay m15822A(Date date) {
        int distance;
        int calories;
        int steps;
        FitnessProvider acr = cnq.acd().acr();
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        SampleDay samplesForDay = acr.getSamplesForDay(instance);
        if (samplesForDay != null) {
            distance = (int) (((double) null) + samplesForDay.getDistance());
            calories = (int) (((double) null) + samplesForDay.getCalories());
            steps = (int) (((double) null) + samplesForDay.getSteps());
        } else {
            calories = 0;
            distance = 0;
            steps = 0;
        }
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date);
        instance2.add(12, 1);
        double d = (double) distance;
        Date date2 = date;
        List interpolateDays = Interpolator.interpolateDays(date2, instance2.getTime(), TimeZone.getDefault(), (double) steps, (double) calories, d);
        if (interpolateDays.size() > 0) {
            return (SampleDay) interpolateDays.get(0);
        }
        return samplesForDay;
    }

    public List<SampleDay> getCalendarData() {
        int i = this.dgz.get(2);
        List<SampleDay> arrayList = new ArrayList();
        Iterator it = this.coh.iterator();
        while (it.hasNext()) {
            SampleDay sampleDay = (SampleDay) it.next();
            if (sampleDay.getMonth() - 1 == i) {
                arrayList.add(sampleDay);
            }
        }
        return arrayList;
    }
}
