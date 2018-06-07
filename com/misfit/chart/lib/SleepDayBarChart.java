package com.misfit.chart.lib;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.fossil.chr;
import com.fossil.cig;
import com.fossil.cih;
import com.fossil.cii;
import com.fossil.cis;
import com.misfit.frameworks.buttonservice.utils.DeviceIdentityUtils;
import java.util.ArrayList;
import java.util.List;

public class SleepDayBarChart extends BaseBarChart {
    private static int bWY = 10;
    protected List<cii> bWZ;
    protected Paint bYV;
    protected chr bYW;
    public boolean bYY;
    List<cii> bYZ;
    protected boolean bYq;
    int bZe;
    C4663a ccQ;
    protected boolean ccR;

    public interface C4663a {
    }

    public SleepDayBarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bYW = null;
        this.bYY = false;
        this.bYZ = new ArrayList();
        this.bYq = true;
        this.ccR = true;
        this.bZe = 0;
        this.bXm = (float) bWY;
        XS();
    }

    public void setChangeColorWhenTouchingOn(boolean z) {
        this.ccR = z;
    }

    public chr getOnBarClickedListener() {
        return this.bYW;
    }

    public void setOnBarClickedListener(chr com_fossil_chr) {
        this.bYW = com_fossil_chr;
    }

    public float getTextSize() {
        return this.bXl;
    }

    public void setTextSize(float f) {
        this.bXl = cis.at(f);
        XT();
    }

    public void m15561a(cii com_fossil_cii, boolean z) {
        this.bYq = z;
        this.bWZ.add(com_fossil_cii);
        XT();
    }

    public void m15560a(cii com_fossil_cii) {
        m15561a(com_fossil_cii, true);
    }

    public List<cii> getData() {
        return this.bWZ;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void setAnimationListener(C4663a c4663a) {
        this.ccQ = c4663a;
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
        if (isInEditMode()) {
            cii com_fossil_cii = new cii("Su");
            com_fossil_cii.a(new cig(2.3f, this.bXi));
            com_fossil_cii.a(new cig(2.3f, this.bXk));
            com_fossil_cii.a(new cig(2.3f, this.bXi));
            cii com_fossil_cii2 = new cii("M");
            com_fossil_cii2.a(new cig(1.1f, this.bXi));
            com_fossil_cii2.a(new cig(2.7f, this.bXk));
            com_fossil_cii2.a(new cig(0.7f, this.bXi));
            cii com_fossil_cii3 = new cii("T");
            com_fossil_cii3.a(new cig(2.3f, this.bXi));
            com_fossil_cii3.a(new cig(2.0f, this.bXk));
            com_fossil_cii3.a(new cig(3.3f, this.bXi));
            cii com_fossil_cii4 = new cii("W");
            com_fossil_cii4.a(new cig(1.0f, this.bXi));
            com_fossil_cii4.a(new cig(4.2f, this.bXk));
            com_fossil_cii4.a(new cig(2.1f, this.bXi));
            cii com_fossil_cii5 = new cii("Th");
            com_fossil_cii5.a(new cig(32.3f, this.bXi));
            com_fossil_cii5.a(new cig(12.0f, this.bXk));
            com_fossil_cii5.a(new cig(22.3f, this.bXi));
            cii com_fossil_cii6 = new cii(DeviceIdentityUtils.FLASH_SERIAL_NUMBER_PREFIX);
            com_fossil_cii6.a(new cig(3.0f, this.bXi));
            com_fossil_cii6.a(new cig(0.7f, this.bXk));
            com_fossil_cii6.a(new cig(1.7f, this.bXi));
            cii com_fossil_cii7 = new cii(DeviceIdentityUtils.SHINE_SERIAL_NUMBER_PREFIX);
            com_fossil_cii7.a(new cig(2.3f, this.bXi));
            com_fossil_cii7.a(new cig(2.0f, this.bXk));
            com_fossil_cii7.a(new cig(3.3f, this.bXi));
            cii com_fossil_cii8 = new cii("Su");
            com_fossil_cii8.a(new cig(5.4f, this.bXi));
            com_fossil_cii8.a(new cig(2.7f, this.bXk));
            com_fossil_cii8.a(new cig(3.4f, this.bXi));
            m15560a(com_fossil_cii);
            m15560a(com_fossil_cii2);
            m15560a(com_fossil_cii3);
            m15560a(com_fossil_cii4);
            m15560a(com_fossil_cii5);
            m15560a(com_fossil_cii6);
            m15560a(com_fossil_cii7);
            m15560a(com_fossil_cii8);
        }
    }

    protected void XT() {
        aj((float) this.bWZ.size());
        super.XT();
    }

    protected void mo4949z(float f, float f2) {
        int i = 0;
        for (cii com_fossil_cii : this.bWZ) {
            float f3 = 0.0f;
            for (cig Ym : com_fossil_cii.Yt()) {
                f3 = Ym.Ym() + f3;
            }
            if (((double) f3) < 0.1d) {
                f3 = 0.1f;
            }
            int i2 = (int) (((float) i) + (f2 / 2.0f));
            float f4 = 0.0f;
            for (cig Ym2 : com_fossil_cii.Yt()) {
                float Ym3 = (((Ym2.Ym() * ((float) this.bXF)) * f3) / (this.bXm * f3)) + f4;
                float f5 = Ym3 - f4;
                Rect rect = new Rect();
                String valueOf = String.valueOf(Ym2.Ym());
                this.bYV.getTextBounds(valueOf, 0, valueOf.length(), rect);
                if (((float) rect.height()) * 1.5f < f5 && ((float) rect.width()) * 1.1f < f) {
                    Ym2.bK(true);
                    Ym2.l(rect);
                }
                Ym2.a(new RectF((float) i2, f4, ((float) i2) + f, Ym3));
                f4 = Ym3;
            }
            com_fossil_cii.b(new RectF((float) i2, 0.0f, ((float) i2) + f, this.bXJ));
            i = (int) ((((float) i2) + f) + (f2 / 2.0f));
        }
        cis.a(this.bWZ, 0.0f, (float) this.bXb.width(), this.bXd);
    }

    protected void mo4945d(Canvas canvas) {
        for (cii com_fossil_cii : this.bWZ) {
            float f = (float) this.bXF;
            for (int i = 0; i < com_fossil_cii.Yt().size(); i++) {
                cig com_fossil_cig = (cig) com_fossil_cii.Yt().get(i);
                RectF Yn = com_fossil_cig.Yn();
                if (Yn != null) {
                    this.bXc.setColor(com_fossil_cig.getColor());
                    float height = Yn.height() * this.bXT;
                    float f2 = f - height;
                    if (this.bYq && height > 0.0f) {
                        if (this.bXu) {
                            height = Yn.width() / 2.0f;
                            canvas.drawCircle(Yn.left + height, f2 + height, height, this.bXc);
                            canvas.drawCircle(Yn.left + height, (height / 2.0f) + f, height, this.bXc);
                            float f3 = Yn.left;
                            canvas.drawRect(f3, f2 + height, Yn.right, f + (height / 2.0f), this.bXc);
                        } else {
                            canvas.drawRect(Yn.left, f2, Yn.right, f, this.bXc);
                        }
                    }
                    if (this.Ci != null) {
                        this.bYV.setTypeface(this.Ci);
                    }
                    f = f2;
                }
            }
        }
    }

    protected void mo4939f(Canvas canvas) {
        super.mo4939f(canvas);
        if (this.bXH) {
            for (cih com_fossil_cih : getLegendData()) {
                if (com_fossil_cih.Yp()) {
                    RectF Yr = com_fossil_cih.Yr();
                    this.bXd.setColor(this.bXL);
                    this.bXd.setTextSize(this.bXK);
                    canvas.drawText(com_fossil_cih.Yo(), (float) com_fossil_cih.Yq(), Yr.bottom - this.bXR, this.bXd);
                }
            }
        }
    }

    protected List<? extends cih> getLegendData() {
        return this.bWZ;
    }

    protected List<RectF> getBarBounds() {
        List arrayList = new ArrayList();
        for (cii com_fossil_cii : this.bWZ) {
            RectF rectF = new RectF();
            rectF.left = com_fossil_cii.Yu().left;
            rectF.right = com_fossil_cii.Yu().right;
            rectF.top = ((float) this.bXF) - com_fossil_cii.Yu().bottom;
            rectF.bottom = (float) this.bXF;
            arrayList.add(rectF);
        }
        return arrayList;
    }

    protected boolean mo4942r(MotionEvent motionEvent) {
        int i = 0;
        if (this.bYY) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (this.bYW == null) {
                    onTouchEvent(motionEvent);
                    return false;
                }
                float x = this.bXa.left + motionEvent.getX();
                float y = motionEvent.getY() + this.bXa.top;
                this.bXy = 0;
                for (RectF rectF : getBarBounds()) {
                    if (cis.a(rectF, x, true)) {
                        if (this.ccR) {
                            List Yt = ((cii) this.bWZ.get(this.bXy)).Yt();
                            while (i < Yt.size()) {
                                ((cig) Yt.get(i)).setColor(this.bXh);
                                i++;
                            }
                        }
                        update();
                        this.bYW.a(this.bXy, rectF.centerX(), rectF.centerY());
                        return true;
                    }
                    this.bXy++;
                }
                this.bXy = 0;
                return false;
            case 1:
            case 3:
                if (this.ccR) {
                    for (int i2 = 0; i2 < this.bWZ.size(); i2++) {
                        List Yt2 = ((cii) this.bWZ.get(i2)).Yt();
                        for (int i3 = 0; i3 < Yt2.size(); i3++) {
                            switch (i3) {
                                case 0:
                                    ((cig) Yt2.get(i3)).setColor(this.bXi);
                                    break;
                                case 1:
                                    ((cig) Yt2.get(i3)).setColor(this.bXk);
                                    break;
                                case 2:
                                    ((cig) Yt2.get(i3)).setColor(this.bXj);
                                    break;
                                default:
                                    ((cig) Yt2.get(i3)).setColor(this.bXi);
                                    break;
                            }
                        }
                    }
                }
                update();
                this.bYW.jh(this.bXy);
                return true;
            default:
                return false;
        }
    }
}
