package com.fossil;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

@TargetApi(21)
public class rm implements rp {
    public void mo4076a(rn rnVar, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        rnVar.m13388s(new sj(colorStateList, f));
        View oE = rnVar.oE();
        oE.setClipToOutline(true);
        oE.setElevation(f2);
        mo4079b(rnVar, f3);
    }

    public void mo4075a(rn rnVar, float f) {
        m13372j(rnVar).setRadius(f);
    }

    public void oF() {
    }

    public void mo4079b(rn rnVar, float f) {
        m13372j(rnVar).m13538a(f, rnVar.getUseCompatPadding(), rnVar.getPreventCornerOverlap());
        mo4084f(rnVar);
    }

    public float mo4074a(rn rnVar) {
        return m13372j(rnVar).rF();
    }

    public float mo4078b(rn rnVar) {
        return mo4082d(rnVar) * 2.0f;
    }

    public float mo4080c(rn rnVar) {
        return mo4082d(rnVar) * 2.0f;
    }

    public float mo4082d(rn rnVar) {
        return m13372j(rnVar).getRadius();
    }

    public void mo4081c(rn rnVar, float f) {
        rnVar.oE().setElevation(f);
    }

    public float mo4083e(rn rnVar) {
        return rnVar.oE().getElevation();
    }

    public void mo4084f(rn rnVar) {
        if (rnVar.getUseCompatPadding()) {
            float a = mo4074a(rnVar);
            float d = mo4082d(rnVar);
            int ceil = (int) Math.ceil((double) sk.m13541b(a, d, rnVar.getPreventCornerOverlap()));
            int ceil2 = (int) Math.ceil((double) sk.m13539a(a, d, rnVar.getPreventCornerOverlap()));
            rnVar.m13387f(ceil, ceil2, ceil, ceil2);
            return;
        }
        rnVar.m13387f(0, 0, 0, 0);
    }

    public void mo4085g(rn rnVar) {
        mo4079b(rnVar, mo4074a(rnVar));
    }

    public void mo4086h(rn rnVar) {
        mo4079b(rnVar, mo4074a(rnVar));
    }

    public void mo4077a(rn rnVar, ColorStateList colorStateList) {
        m13372j(rnVar).setColor(colorStateList);
    }

    public ColorStateList mo4087i(rn rnVar) {
        return m13372j(rnVar).getColor();
    }

    private sj m13372j(rn rnVar) {
        return (sj) rnVar.oD();
    }
}
