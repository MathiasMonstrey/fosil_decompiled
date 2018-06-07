package com.misfit.chart.lib;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.fossil.chr;
import com.fossil.cih;
import com.fossil.cim;
import com.fossil.cip;
import com.fossil.cis;
import java.util.ArrayList;
import java.util.List;

public class SleepWeeklyBarChart extends BaseBarChart {
    private static final String TAG = SleepWeeklyBarChart.class.getSimpleName();
    private static int bWY = 10;
    private static int bWx = -14216046;
    private static int bWy = -10863620;
    private static int bWz = -1;
    private List<cim> bWZ;
    private Paint bYV;
    protected chr bYW;

    public chr getOnBarClickedListener() {
        return this.bYW;
    }

    public void setOnBarClickedListener(chr com_fossil_chr) {
        this.bYW = com_fossil_chr;
    }

    public SleepWeeklyBarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bYW = null;
        this.bXm = (float) bWY;
        XS();
    }

    public void m15596a(ArrayList<cim> arrayList, boolean z) {
        this.bWZ = new ArrayList();
        this.bWZ.addAll(arrayList);
        for (cim com_fossil_cim : this.bWZ) {
            switch (com_fossil_cim.YC().getState()) {
                case 0:
                    com_fossil_cim.setColor(bWx);
                    break;
                case 1:
                    com_fossil_cim.setColor(bWy);
                    break;
                case 2:
                    com_fossil_cim.setColor(bWz);
                    break;
                default:
                    break;
            }
        }
        if (z) {
            XT();
        }
    }

    public void m15599f(ArrayList<cim> arrayList) {
        m15596a(arrayList, true);
    }

    public List<cim> getData() {
        return this.bWZ;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        performClick();
        return true;
    }

    protected void XS() {
        super.XS();
        this.bWZ = new ArrayList();
        this.bYV = new Paint(1);
        this.bYV.setTextSize(this.bXl);
        this.bYV.setTextAlign(Align.CENTER);
        this.bYV.setColor(-1);
        if (this.Ci != null) {
            this.bYV.setTypeface(this.Ci);
        }
    }

    protected void XT() {
        aj((float) this.bWZ.size());
        super.XT();
    }

    protected void mo4949z(float f, float f2) {
        float f3 = ((float) this.bXE) / this.bXm;
        int i = 0;
        float f4 = 0.0f;
        float f5 = 0.0f;
        for (cim com_fossil_cim : this.bWZ) {
            cip YC = com_fossil_cim.YC();
            float endIndex = ((float) ((YC.getEndIndex() - YC.YJ()) + 1)) * f3;
            switch (YC.getState()) {
                case 0:
                    f5 = (float) this.bXF;
                    f4 = 100.0f;
                    break;
                case 1:
                    f5 = (float) (this.bXF - ((this.bXF / 12) * 5));
                    f4 = 100.0f;
                    break;
                case 2:
                    f4 = 0.0f;
                    f5 = 100.0f;
                    break;
                default:
                    break;
            }
            com_fossil_cim.a(new RectF((float) i, f4, ((float) i) + endIndex, f5));
            com_fossil_cim.b(new RectF((float) i, 0.0f, ((float) i) + endIndex, this.bXJ));
            i = (int) (((float) i) + endIndex);
        }
        cis.a(this.bWZ, 0.0f, (float) this.bXb.width(), this.bXd);
    }

    protected void mo4945d(Canvas canvas) {
        for (cim com_fossil_cim : this.bWZ) {
            RectF Yn = com_fossil_cim.Yn();
            this.bXc.setColor(com_fossil_cim.getColor());
            canvas.drawRect(Yn.left, Yn.top, Yn.right, Yn.bottom, this.bXc);
        }
    }

    protected void mo4939f(Canvas canvas) {
        super.mo4939f(canvas);
        int i = -1;
        Object obj = 1;
        this.bXd.setColor(this.bXL);
        this.bXd.setTextSize(this.bXK);
        String str = "";
        int i2 = 0;
        while (i2 < this.bWZ.size()) {
            int sessionNumber;
            Object obj2;
            cim com_fossil_cim = (cim) this.bWZ.get(i2);
            cip YC = com_fossil_cim.YC();
            RectF Yr = com_fossil_cim.Yr();
            if (i < YC.getSessionNumber()) {
                sessionNumber = YC.getSessionNumber();
                String ay = cis.ay(com_fossil_cim.getStartTime() + ((long) ((YC.YJ() * 60) * 1000)));
                cis.b(this.bXd, ay);
                canvas.drawText(ay, (float) com_fossil_cim.Yq(), Yr.bottom - this.bXR, this.bXd);
                obj2 = obj;
            } else {
                if (i == YC.getSessionNumber() && obj != null) {
                    sessionNumber = i2 + 1;
                    String ay2;
                    if (sessionNumber >= this.bWZ.size()) {
                        sessionNumber = YC.getSessionNumber();
                        ay2 = cis.ay(com_fossil_cim.getStartTime() + ((long) (((YC.getEndIndex() + 1) * 60) * 1000)));
                        canvas.drawText(ay2, com_fossil_cim.Yn().right - cis.b(this.bXd, ay2), Yr.bottom - this.bXR, this.bXd);
                        obj2 = null;
                    } else if (i < ((cim) this.bWZ.get(sessionNumber)).YC().getSessionNumber()) {
                        sessionNumber = YC.getSessionNumber();
                        ay2 = cis.ay(com_fossil_cim.getStartTime() + ((long) (((YC.getEndIndex() + 1) * 60) * 1000)));
                        canvas.drawText(ay2, com_fossil_cim.Yn().bottom - cis.b(this.bXd, ay2), Yr.bottom - this.bXR, this.bXd);
                        obj2 = null;
                    }
                }
                obj2 = obj;
                sessionNumber = i;
            }
            i2++;
            i = sessionNumber;
            obj = obj2;
        }
    }

    protected List<? extends cih> getLegendData() {
        return this.bWZ;
    }

    protected List<RectF> getBarBounds() {
        List arrayList = new ArrayList();
        for (cim Yn : this.bWZ) {
            arrayList.add(Yn.Yn());
        }
        return arrayList;
    }

    protected boolean mo4942r(MotionEvent motionEvent) {
        boolean z;
        switch (motionEvent.getAction()) {
            case 0:
                if (this.bYW != null) {
                    float x = this.bXa.left + motionEvent.getX();
                    float y = this.bXa.top + motionEvent.getY();
                    this.bXy = 0;
                    for (RectF b : getBarBounds()) {
                        if (cis.b(b, x, y)) {
                            ((cim) this.bWZ.get(this.bXy)).setColor(this.bXh);
                            update();
                            return true;
                        }
                    }
                    this.bXy = 0;
                    z = true;
                    break;
                }
                onTouchEvent(motionEvent);
                z = true;
                break;
            case 1:
            case 3:
                if (this.bYW != null) {
                    cim com_fossil_cim = (cim) this.bWZ.get(this.bXy);
                    switch (com_fossil_cim.YC().getState()) {
                        case 0:
                            com_fossil_cim.setColor(bWx);
                            break;
                        case 1:
                            com_fossil_cim.setColor(bWy);
                            break;
                        case 2:
                            com_fossil_cim.setColor(bWz);
                            break;
                        default:
                            com_fossil_cim.setColor(bWx);
                            break;
                    }
                    update();
                    z = true;
                    break;
                }
                onTouchEvent(motionEvent);
                z = true;
                break;
            default:
                z = false;
                break;
        }
        return z;
    }
}
