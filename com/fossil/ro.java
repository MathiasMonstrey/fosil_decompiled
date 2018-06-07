package com.fossil;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.fossil.sk.C4046a;

@TargetApi(9)
public class ro implements rp {
    final RectF alM = new RectF();

    class C40471 implements C4046a {
        final /* synthetic */ ro alN;

        C40471(ro roVar) {
            this.alN = roVar;
        }

        public void mo4089a(Canvas canvas, RectF rectF, float f, Paint paint) {
            float f2 = 2.0f * f;
            float width = (rectF.width() - f2) - 1.0f;
            float height = (rectF.height() - f2) - 1.0f;
            if (f >= 1.0f) {
                float f3 = f + 0.5f;
                this.alN.alM.set(-f3, -f3, f3, f3);
                int save = canvas.save();
                canvas.translate(rectF.left + f3, rectF.top + f3);
                canvas.drawArc(this.alN.alM, 180.0f, 90.0f, true, paint);
                canvas.translate(width, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(this.alN.alM, 180.0f, 90.0f, true, paint);
                canvas.translate(height, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(this.alN.alM, 180.0f, 90.0f, true, paint);
                canvas.translate(width, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(this.alN.alM, 180.0f, 90.0f, true, paint);
                canvas.restoreToCount(save);
                canvas.drawRect((rectF.left + f3) - 1.0f, rectF.top, 1.0f + (rectF.right - f3), rectF.top + f3, paint);
                canvas.drawRect((rectF.left + f3) - 1.0f, rectF.bottom - f3, 1.0f + (rectF.right - f3), rectF.bottom, paint);
            }
            canvas.drawRect(rectF.left, rectF.top + f, rectF.right, rectF.bottom - f, paint);
        }
    }

    public void oF() {
        sk.asu = new C40471(this);
    }

    public void mo4076a(rn rnVar, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        Drawable a = m13391a(context, colorStateList, f, f2, f3);
        a.m13548o(rnVar.getPreventCornerOverlap());
        rnVar.m13388s(a);
        mo4084f(rnVar);
    }

    private sk m13391a(Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        return new sk(context.getResources(), colorStateList, f, f2, f3);
    }

    public void mo4084f(rn rnVar) {
        Rect rect = new Rect();
        m13392k(rnVar).m13547k(rect);
        rnVar.ab((int) Math.ceil((double) mo4078b(rnVar)), (int) Math.ceil((double) mo4080c(rnVar)));
        rnVar.m13387f(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void mo4085g(rn rnVar) {
    }

    public void mo4086h(rn rnVar) {
        m13392k(rnVar).m13548o(rnVar.getPreventCornerOverlap());
        mo4084f(rnVar);
    }

    public void mo4077a(rn rnVar, ColorStateList colorStateList) {
        m13392k(rnVar).setColor(colorStateList);
    }

    public ColorStateList mo4087i(rn rnVar) {
        return m13392k(rnVar).getColor();
    }

    public void mo4075a(rn rnVar, float f) {
        m13392k(rnVar).setCornerRadius(f);
        mo4084f(rnVar);
    }

    public float mo4082d(rn rnVar) {
        return m13392k(rnVar).getCornerRadius();
    }

    public void mo4081c(rn rnVar, float f) {
        m13392k(rnVar).m13549r(f);
    }

    public float mo4083e(rn rnVar) {
        return m13392k(rnVar).gA();
    }

    public void mo4079b(rn rnVar, float f) {
        m13392k(rnVar).m13545N(f);
        mo4084f(rnVar);
    }

    public float mo4074a(rn rnVar) {
        return m13392k(rnVar).rG();
    }

    public float mo4078b(rn rnVar) {
        return m13392k(rnVar).rH();
    }

    public float mo4080c(rn rnVar) {
        return m13392k(rnVar).rI();
    }

    private sk m13392k(rn rnVar) {
        return (sk) rnVar.oD();
    }
}
