package com.misfit.chart.lib;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.fossil.cig;
import com.fossil.cih;
import com.fossil.cis;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import java.util.ArrayList;
import java.util.List;

public class BarChart extends BaseBarChart {
    private static int bWY = MFNetworkReturnCode.REQUEST_NOT_FOUND;
    private List<cig> bWZ;

    public BarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bXm = (float) bWY;
        XS();
    }

    public void m15499a(cig com_fossil_cig) {
        this.bWZ.add(com_fossil_cig);
        XT();
    }

    public List<cig> getData() {
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
        if (isInEditMode()) {
            m15499a(new cig(100.0f));
            m15499a(new cig(100.0f));
            m15499a(new cig(100.0f));
            m15499a(new cig(100.0f));
            m15499a(new cig(100.0f));
            m15499a(new cig(100.0f));
            m15499a(new cig(100.0f));
        }
    }

    protected void XT() {
        aj((float) this.bWZ.size());
        super.XT();
    }

    protected void mo4949z(float f, float f2) {
        float f3 = ((float) this.bXF) / this.bXm;
        int i = 0;
        for (cig com_fossil_cig : this.bWZ) {
            i = (int) (((float) i) + (f2 / 2.0f));
            com_fossil_cig.a(new RectF((float) i, ((float) this.bXF) - (com_fossil_cig.Ym() * f3), ((float) i) + f, (float) this.bXF));
            com_fossil_cig.b(new RectF((float) i, 0.0f, ((float) i) + f, this.bXJ));
            i = (int) (((float) i) + ((f2 / 2.0f) + f));
        }
        cis.a(this.bWZ, 0.0f, (float) this.bXb.width(), this.bXd);
    }

    protected void mo4945d(Canvas canvas) {
        for (cig com_fossil_cig : this.bWZ) {
            RectF Yn = com_fossil_cig.Yn();
            this.bXc.setColor(com_fossil_cig.getColor());
            canvas.drawRect(Yn.left, Yn.bottom - (Yn.height() * this.bXT), Yn.right, Yn.bottom, this.bXc);
        }
    }

    protected boolean mo4942r(MotionEvent motionEvent) {
        return false;
    }

    protected List<? extends cih> getLegendData() {
        return this.bWZ;
    }

    protected List<RectF> getBarBounds() {
        List arrayList = new ArrayList();
        for (cig Yn : this.bWZ) {
            arrayList.add(Yn.Yn());
        }
        return arrayList;
    }
}
