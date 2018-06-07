package com.fossil;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.fossil.sk.C4046a;

@TargetApi(17)
public class rq extends ro {

    class C40481 implements C4046a {
        final /* synthetic */ rq alO;

        C40481(rq rqVar) {
            this.alO = rqVar;
        }

        public void mo4089a(Canvas canvas, RectF rectF, float f, Paint paint) {
            canvas.drawRoundRect(rectF, f, f, paint);
        }
    }

    public void oF() {
        sk.asu = new C40481(this);
    }
}
