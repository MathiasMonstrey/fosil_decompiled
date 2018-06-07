package com.misfit.chart.lib;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.fossil.cig;
import com.fossil.cii;
import com.fossil.cis;

public class MultiGoalSleepDayBarChart extends SleepDayBarChart {
    protected String caK = "";
    protected String caL = "";
    protected float caM;
    protected float caN;
    protected float caO;
    protected boolean caP = true;
    protected boolean caQ = true;
    protected DashPathEffect caR;

    public void setMarginTextGoalLeftRight(float f) {
        this.caO = f;
    }

    public void setDashLineEffect(DashPathEffect dashPathEffect) {
        this.caR = dashPathEffect;
    }

    public void setLegendLineFull(boolean z) {
        this.caQ = z;
    }

    public String getGoalLeftStr() {
        return this.caK;
    }

    public void setGoalLeftStr(String str) {
        this.caK = str;
    }

    public String getGoalRigthStr() {
        return this.caL;
    }

    public void setGoalRigthStr(String str) {
        this.caL = str;
    }

    public float getMaxGoal() {
        return this.caM;
    }

    public void setMaxGoal(float f) {
        this.caM = f;
    }

    public void setDashLineGoalEnable(boolean z) {
        this.caP = z;
    }

    public void setMarginBetweenModelsInColumn(float f) {
        this.caN = f;
    }

    public MultiGoalSleepDayBarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void m15566a(Canvas canvas, String str, float f, float f2) {
        canvas.drawText(str, f, f2, this.bXd);
    }

    protected void mo4940g(Canvas canvas) {
        cii com_fossil_cii;
        int Yv;
        int i = this.bXF - ((int) ((this.bXn * ((float) this.bXF)) / this.bXm));
        this.bXc.setStrokeWidth(this.bXp);
        this.bXc.setColor(this.bXw);
        this.bXd.setColor(this.bXx);
        this.bXd.setTextSize(this.bXq);
        if (this.bXo) {
            if (this.bXr != null) {
                m15566a(canvas, this.bXr, (((float) canvas.getWidth()) - cis.b(this.bXd, this.bXr)) - this.bXt, ((float) i) - this.bXt);
            }
            if (this.bXs != null) {
                Path path = new Path();
                path.moveTo(0.0f, 0.0f);
                if (!(this.bWZ == null || this.bWZ.size() <= 0 || this.bWZ.get(0) == null)) {
                    com_fossil_cii = (cii) this.bWZ.get(0);
                    if (com_fossil_cii != null) {
                        float f;
                        Yv = (int) com_fossil_cii.Yv();
                        String str = this.caK;
                        float a = cis.a(this.bXd, str);
                        float b = cis.b(this.bXd, str);
                        float f2 = (float) (this.bXF - ((int) ((((float) Yv) / this.caM) * ((this.bXn * ((float) this.bXF)) / this.bXm))));
                        m15566a(canvas, str, this.bXt + 30.0f, ((a / 2.0f) + f2) - this.bXd.getStrokeWidth());
                        path.moveTo(0.0f, f2);
                        path.lineTo((this.bXt + 30.0f) - (str.isEmpty() ? 0.0f : this.caO), f2);
                        path.moveTo((str.isEmpty() ? 0.0f : this.caO) + (b + (this.bXt + 30.0f)), f2);
                        a = ((cii) this.bWZ.get(0)).Yu().left;
                        b = getBarMargin() / 2.0f;
                        for (cii com_fossil_cii2 : this.bWZ) {
                            int Yv2 = (int) com_fossil_cii2.Yv();
                            if (Yv2 != Yv) {
                                f = com_fossil_cii2.Yu().left - b;
                                path.lineTo(f, f2);
                                a = (float) (this.bXF - ((int) ((((float) Yv2) / this.caM) * ((this.bXn * ((float) this.bXF)) / this.bXm))));
                                path.moveTo(f, a);
                            } else {
                                a = f2;
                            }
                            f2 = a;
                            Yv = Yv2;
                        }
                        String str2 = this.caL;
                        f2 = cis.a(this.bXd, str2);
                        float b2 = cis.b(this.bXd, str2);
                        f = (float) (this.bXF - ((int) ((((float) Yv) / this.caM) * ((this.bXn * ((float) this.bXF)) / this.bXm))));
                        m15566a(canvas, str2, ((((float) this.bXE) - b2) - this.bXt) - 30.0f, ((f2 / 2.0f) + f) - this.bXd.getStrokeWidth());
                        path.lineTo((((((float) this.bXE) - b2) - this.bXt) - 30.0f) - this.caO, f);
                        path.moveTo(((((float) this.bXE) - this.bXt) - 30.0f) + this.caO, f);
                        path.lineTo((float) this.bXE, f);
                        Paint paint = new Paint(1);
                        paint.setStrokeWidth(this.bXp);
                        paint.setColor(this.bXw);
                        paint.setStyle(Style.STROKE);
                        if (this.caP) {
                            if (this.caR == null) {
                                this.caR = new DashPathEffect(new float[]{4.0f, 10.0f}, 0.0f);
                            }
                            paint.setPathEffect(this.caR);
                        }
                        canvas.drawPath(path, paint);
                    }
                }
            }
        }
        Yv = this.bWZ.size();
        if (this.caQ) {
            canvas.drawLine(0.0f, this.bXv + ((float) this.bXF), (float) canvas.getWidth(), this.bXv + ((float) this.bXF), this.bXc);
        } else if (this.bWZ != null && Yv > 0 && this.bWZ.get(0) != null && ((cii) this.bWZ.get(0)).Yr() != null) {
            cii com_fossil_cii3;
            com_fossil_cii2 = (cii) this.bWZ.get(0);
            cii com_fossil_cii4 = (cii) this.bWZ.get(0);
            if (Yv <= 1 || this.bWZ.get(Yv - 1) == null || ((cii) this.bWZ.get(Yv - 1)).Yr() == null) {
                com_fossil_cii3 = com_fossil_cii4;
            } else {
                com_fossil_cii3 = (cii) this.bWZ.get(Yv - 1);
            }
            canvas.drawLine(com_fossil_cii2.Yr().left, this.bXv + ((float) this.bXF), com_fossil_cii3.Yr().right, this.bXv + ((float) this.bXF), this.bXc);
        }
    }

    protected void mo4945d(Canvas canvas) {
        for (cii com_fossil_cii : this.bWZ) {
            float f = (float) this.bXF;
            for (int i = 0; i < com_fossil_cii.Yt().size(); i++) {
                cig com_fossil_cig = (cig) com_fossil_cii.Yt().get(i);
                RectF Yn = com_fossil_cig.Yn();
                if (Yn != null) {
                    this.bXc.setColor(com_fossil_cig.getColor());
                    float height = f - (Yn.height() * this.bXT);
                    if (this.bYq && com_fossil_cig.Ym() > 0.0f) {
                        if (this.bXu) {
                            float width = Yn.width() / 2.0f;
                            canvas.drawCircle(Yn.left + width, height + width, width, this.bXc);
                            canvas.drawCircle(Yn.left + width, (width / 2.0f) + f, width, this.bXc);
                            canvas.drawRect(Yn.left, height + width, Yn.right, f + (width / 2.0f), this.bXc);
                        } else if (i == 0) {
                            canvas.drawRect(Yn.left, height + (this.caN / 2.0f), Yn.right, f, this.bXc);
                        } else {
                            canvas.drawRect(Yn.left, height + (this.caN / 2.0f), Yn.right, f - (this.caN / 2.0f), this.bXc);
                        }
                    }
                    if (this.Ci != null) {
                        this.bYV.setTypeface(this.Ci);
                    }
                    f = height;
                }
            }
        }
    }
}
