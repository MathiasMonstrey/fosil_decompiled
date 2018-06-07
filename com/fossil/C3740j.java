package com.fossil;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.support.constraint.Guideline;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import com.fossil.C3777k.C3776a;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class C3740j {
    private static final int[] pO = new int[]{0, 4, 8};
    private static SparseIntArray pQ = new SparseIntArray();
    private HashMap<Integer, C3739a> pP = new HashMap();

    static class C3739a {
        public float alpha;
        public int bottomMargin;
        public float horizontalWeight;
        public int leftMargin;
        public int oR;
        public int oS;
        public float oT;
        public int oU;
        public int oV;
        public int oW;
        public int oX;
        public int oY;
        public int oZ;
        public int orientation;
        public int pA;
        public int pB;
        boolean pR;
        public int pS;
        public int pT;
        int pU;
        public int pV;
        public int pW;
        public boolean pX;
        public float pY;
        public float pZ;
        public int pa;
        public int pb;
        public int pc;
        public int pd;
        public int pe;
        public int pf;
        public int pg;
        public int ph;
        public int pi;
        public int pj;
        public int pk;
        public int pl;
        public int pm;
        public float pn;
        public float po;
        public String pp;
        public int ps;
        public int pt;
        public float qa;
        public float qb;
        public float qc;
        public float qd;
        public float qe;
        public float qf;
        public float qg;
        public float qh;
        public int qi;
        public int qj;
        public int qk;
        public int ql;
        public int qm;
        public int qn;
        public int rightMargin;
        public int topMargin;
        public float verticalWeight;
        public int visibility;

        private C3739a() {
            this.pR = false;
            this.oR = -1;
            this.oS = -1;
            this.oT = -1.0f;
            this.oU = -1;
            this.oV = -1;
            this.oW = -1;
            this.oX = -1;
            this.oY = -1;
            this.oZ = -1;
            this.pa = -1;
            this.pb = -1;
            this.pc = -1;
            this.pd = -1;
            this.pe = -1;
            this.pf = -1;
            this.pg = -1;
            this.pn = 0.5f;
            this.po = 0.5f;
            this.pp = null;
            this.pA = -1;
            this.pB = -1;
            this.orientation = -1;
            this.leftMargin = -1;
            this.rightMargin = -1;
            this.topMargin = -1;
            this.bottomMargin = -1;
            this.pV = -1;
            this.pW = -1;
            this.visibility = 0;
            this.ph = -1;
            this.pi = -1;
            this.pj = -1;
            this.pk = -1;
            this.pm = -1;
            this.pl = -1;
            this.verticalWeight = 0.0f;
            this.horizontalWeight = 0.0f;
            this.ps = 0;
            this.pt = 0;
            this.alpha = 1.0f;
            this.pX = false;
            this.pY = 0.0f;
            this.pZ = 0.0f;
            this.qa = 0.0f;
            this.qb = 1.0f;
            this.qc = 1.0f;
            this.qd = 0.0f;
            this.qe = 0.0f;
            this.qf = 0.0f;
            this.qg = 0.0f;
            this.qh = 0.0f;
            this.qi = -1;
            this.qj = -1;
            this.qk = -1;
            this.ql = -1;
            this.qm = -1;
            this.qn = -1;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return dJ();
        }

        public C3739a dJ() {
            C3739a c3739a = new C3739a();
            c3739a.pR = this.pR;
            c3739a.pS = this.pS;
            c3739a.pT = this.pT;
            c3739a.oR = this.oR;
            c3739a.oS = this.oS;
            c3739a.oT = this.oT;
            c3739a.oU = this.oU;
            c3739a.oV = this.oV;
            c3739a.oW = this.oW;
            c3739a.oX = this.oX;
            c3739a.oY = this.oY;
            c3739a.oZ = this.oZ;
            c3739a.pa = this.pa;
            c3739a.pb = this.pb;
            c3739a.pc = this.pc;
            c3739a.pd = this.pd;
            c3739a.pe = this.pe;
            c3739a.pf = this.pf;
            c3739a.pg = this.pg;
            c3739a.pn = this.pn;
            c3739a.po = this.po;
            c3739a.pp = this.pp;
            c3739a.pA = this.pA;
            c3739a.pB = this.pB;
            c3739a.pn = this.pn;
            c3739a.pn = this.pn;
            c3739a.pn = this.pn;
            c3739a.pn = this.pn;
            c3739a.pn = this.pn;
            c3739a.orientation = this.orientation;
            c3739a.leftMargin = this.leftMargin;
            c3739a.rightMargin = this.rightMargin;
            c3739a.topMargin = this.topMargin;
            c3739a.bottomMargin = this.bottomMargin;
            c3739a.pV = this.pV;
            c3739a.pW = this.pW;
            c3739a.visibility = this.visibility;
            c3739a.ph = this.ph;
            c3739a.pi = this.pi;
            c3739a.pj = this.pj;
            c3739a.pk = this.pk;
            c3739a.pm = this.pm;
            c3739a.pl = this.pl;
            c3739a.verticalWeight = this.verticalWeight;
            c3739a.horizontalWeight = this.horizontalWeight;
            c3739a.ps = this.ps;
            c3739a.pt = this.pt;
            c3739a.alpha = this.alpha;
            c3739a.pX = this.pX;
            c3739a.pY = this.pY;
            c3739a.pZ = this.pZ;
            c3739a.qa = this.qa;
            c3739a.qb = this.qb;
            c3739a.qc = this.qc;
            c3739a.qd = this.qd;
            c3739a.qe = this.qe;
            c3739a.qf = this.qf;
            c3739a.qg = this.qg;
            c3739a.qh = this.qh;
            c3739a.qi = this.qi;
            c3739a.qj = this.qj;
            c3739a.qk = this.qk;
            c3739a.ql = this.ql;
            c3739a.qm = this.qm;
            c3739a.qn = this.qn;
            return c3739a;
        }

        public void m11855a(LayoutParams layoutParams) {
            layoutParams.oU = this.oU;
            layoutParams.oV = this.oV;
            layoutParams.oW = this.oW;
            layoutParams.oX = this.oX;
            layoutParams.oY = this.oY;
            layoutParams.oZ = this.oZ;
            layoutParams.pa = this.pa;
            layoutParams.pb = this.pb;
            layoutParams.pc = this.pc;
            layoutParams.pd = this.pd;
            layoutParams.pe = this.pe;
            layoutParams.pf = this.pf;
            layoutParams.pg = this.pg;
            layoutParams.leftMargin = this.leftMargin;
            layoutParams.rightMargin = this.rightMargin;
            layoutParams.topMargin = this.topMargin;
            layoutParams.bottomMargin = this.bottomMargin;
            layoutParams.pl = this.pl;
            layoutParams.pm = this.pm;
            layoutParams.pn = this.pn;
            layoutParams.po = this.po;
            layoutParams.pp = this.pp;
            layoutParams.pA = this.pA;
            layoutParams.pB = this.pB;
            layoutParams.verticalWeight = this.verticalWeight;
            layoutParams.horizontalWeight = this.horizontalWeight;
            layoutParams.pt = this.pt;
            layoutParams.ps = this.ps;
            layoutParams.pu = this.qi;
            layoutParams.pv = this.qj;
            layoutParams.py = this.qk;
            layoutParams.pz = this.ql;
            layoutParams.pw = this.qm;
            layoutParams.px = this.qn;
            layoutParams.orientation = this.orientation;
            layoutParams.oT = this.oT;
            layoutParams.oR = this.oR;
            layoutParams.oS = this.oS;
            layoutParams.width = this.pS;
            layoutParams.height = this.pT;
            if (VERSION.SDK_INT >= 17) {
                layoutParams.setMarginStart(this.pW);
                layoutParams.setMarginEnd(this.pV);
            }
            layoutParams.validate();
        }
    }

    static {
        pQ.append(C3776a.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
        pQ.append(C3776a.ConstraintSet_layout_constraintLeft_toRightOf, 26);
        pQ.append(C3776a.ConstraintSet_layout_constraintRight_toLeftOf, 29);
        pQ.append(C3776a.ConstraintSet_layout_constraintRight_toRightOf, 30);
        pQ.append(C3776a.ConstraintSet_layout_constraintTop_toTopOf, 36);
        pQ.append(C3776a.ConstraintSet_layout_constraintTop_toBottomOf, 35);
        pQ.append(C3776a.ConstraintSet_layout_constraintBottom_toTopOf, 4);
        pQ.append(C3776a.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
        pQ.append(C3776a.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
        pQ.append(C3776a.ConstraintSet_layout_editor_absoluteX, 6);
        pQ.append(C3776a.ConstraintSet_layout_editor_absoluteY, 7);
        pQ.append(C3776a.ConstraintSet_layout_constraintGuide_begin, 17);
        pQ.append(C3776a.ConstraintSet_layout_constraintGuide_end, 18);
        pQ.append(C3776a.ConstraintSet_layout_constraintGuide_percent, 19);
        pQ.append(C3776a.ConstraintSet_android_orientation, 27);
        pQ.append(C3776a.ConstraintSet_layout_constraintStart_toEndOf, 32);
        pQ.append(C3776a.ConstraintSet_layout_constraintStart_toStartOf, 33);
        pQ.append(C3776a.ConstraintSet_layout_constraintEnd_toStartOf, 10);
        pQ.append(C3776a.ConstraintSet_layout_constraintEnd_toEndOf, 9);
        pQ.append(C3776a.ConstraintSet_layout_goneMarginLeft, 13);
        pQ.append(C3776a.ConstraintSet_layout_goneMarginTop, 16);
        pQ.append(C3776a.ConstraintSet_layout_goneMarginRight, 14);
        pQ.append(C3776a.ConstraintSet_layout_goneMarginBottom, 11);
        pQ.append(C3776a.ConstraintSet_layout_goneMarginStart, 15);
        pQ.append(C3776a.ConstraintSet_layout_goneMarginEnd, 12);
        pQ.append(C3776a.ConstraintSet_layout_constraintVertical_weight, 40);
        pQ.append(C3776a.ConstraintSet_layout_constraintHorizontal_weight, 39);
        pQ.append(C3776a.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
        pQ.append(C3776a.ConstraintSet_layout_constraintVertical_chainStyle, 42);
        pQ.append(C3776a.ConstraintSet_layout_constraintHorizontal_bias, 20);
        pQ.append(C3776a.ConstraintSet_layout_constraintVertical_bias, 37);
        pQ.append(C3776a.ConstraintSet_layout_constraintDimensionRatio, 5);
        pQ.append(C3776a.ConstraintSet_layout_constraintLeft_creator, 60);
        pQ.append(C3776a.ConstraintSet_layout_constraintTop_creator, 60);
        pQ.append(C3776a.ConstraintSet_layout_constraintRight_creator, 60);
        pQ.append(C3776a.ConstraintSet_layout_constraintBottom_creator, 60);
        pQ.append(C3776a.ConstraintSet_layout_constraintBaseline_creator, 60);
        pQ.append(C3776a.ConstraintSet_android_layout_marginLeft, 24);
        pQ.append(C3776a.ConstraintSet_android_layout_marginRight, 28);
        pQ.append(C3776a.ConstraintSet_android_layout_marginStart, 31);
        pQ.append(C3776a.ConstraintSet_android_layout_marginEnd, 8);
        pQ.append(C3776a.ConstraintSet_android_layout_marginTop, 34);
        pQ.append(C3776a.ConstraintSet_android_layout_marginBottom, 2);
        pQ.append(C3776a.ConstraintSet_android_layout_width, 23);
        pQ.append(C3776a.ConstraintSet_android_layout_height, 21);
        pQ.append(C3776a.ConstraintSet_android_visibility, 22);
        pQ.append(C3776a.ConstraintSet_android_alpha, 43);
        pQ.append(C3776a.ConstraintSet_android_elevation, 44);
        pQ.append(C3776a.ConstraintSet_android_rotationX, 45);
        pQ.append(C3776a.ConstraintSet_android_rotationY, 46);
        pQ.append(C3776a.ConstraintSet_android_scaleX, 47);
        pQ.append(C3776a.ConstraintSet_android_scaleY, 48);
        pQ.append(C3776a.ConstraintSet_android_transformPivotX, 49);
        pQ.append(C3776a.ConstraintSet_android_transformPivotY, 50);
        pQ.append(C3776a.ConstraintSet_android_translationX, 51);
        pQ.append(C3776a.ConstraintSet_android_translationY, 52);
        pQ.append(C3776a.ConstraintSet_android_translationZ, 53);
        pQ.append(C3776a.ConstraintSet_layout_constraintWidth_default, 54);
        pQ.append(C3776a.ConstraintSet_layout_constraintHeight_default, 55);
        pQ.append(C3776a.ConstraintSet_layout_constraintWidth_max, 56);
        pQ.append(C3776a.ConstraintSet_layout_constraintHeight_max, 57);
        pQ.append(C3776a.ConstraintSet_layout_constraintWidth_min, 58);
        pQ.append(C3776a.ConstraintSet_layout_constraintHeight_min, 59);
        pQ.append(C3776a.ConstraintSet_android_id, 38);
    }

    public void m11860a(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.pP.keySet());
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (this.pP.containsKey(Integer.valueOf(id))) {
                hashSet.remove(Integer.valueOf(id));
                C3739a c3739a = (C3739a) this.pP.get(Integer.valueOf(id));
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                c3739a.m11855a(layoutParams);
                childAt.setLayoutParams(layoutParams);
                childAt.setVisibility(c3739a.visibility);
                if (VERSION.SDK_INT >= 17) {
                    childAt.setAlpha(c3739a.alpha);
                    childAt.setRotationX(c3739a.pZ);
                    childAt.setRotationY(c3739a.qa);
                    childAt.setScaleX(c3739a.qb);
                    childAt.setScaleY(c3739a.qc);
                    childAt.setPivotX(c3739a.qd);
                    childAt.setPivotY(c3739a.qe);
                    childAt.setTranslationX(c3739a.qf);
                    childAt.setTranslationY(c3739a.qg);
                    if (VERSION.SDK_INT >= 21) {
                        childAt.setTranslationZ(c3739a.qh);
                        if (c3739a.pX) {
                            childAt.setElevation(c3739a.pY);
                        }
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            C3739a c3739a2 = (C3739a) this.pP.get(num);
            if (c3739a2.pR) {
                View guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ViewGroup.LayoutParams dI = constraintLayout.dI();
                c3739a2.m11855a(dI);
                constraintLayout.addView(guideline, dI);
            }
        }
    }

    public void m11859a(Context context, int i) {
        XmlPullParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                switch (eventType) {
                    case 0:
                        xml.getName();
                        break;
                    case 2:
                        String name = xml.getName();
                        C3739a a = m11857a(context, Xml.asAttributeSet(xml));
                        if (name.equalsIgnoreCase("Guideline")) {
                            a.pR = true;
                        }
                        this.pP.put(Integer.valueOf(a.pU), a);
                        break;
                    default:
                        break;
                }
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private static int m11856a(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        if (resourceId == -1) {
            return typedArray.getInt(i, -1);
        }
        return resourceId;
    }

    private C3739a m11857a(Context context, AttributeSet attributeSet) {
        C3739a c3739a = new C3739a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3776a.ConstraintSet);
        m11858a(c3739a, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return c3739a;
    }

    private void m11858a(C3739a c3739a, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            switch (pQ.get(index)) {
                case 1:
                    c3739a.pc = C3740j.m11856a(typedArray, index, c3739a.pc);
                    break;
                case 2:
                    c3739a.bottomMargin = typedArray.getDimensionPixelSize(index, c3739a.bottomMargin);
                    break;
                case 3:
                    c3739a.pb = C3740j.m11856a(typedArray, index, c3739a.pb);
                    break;
                case 4:
                    c3739a.pa = C3740j.m11856a(typedArray, index, c3739a.pa);
                    break;
                case 5:
                    c3739a.pp = typedArray.getString(index);
                    break;
                case 6:
                    c3739a.pA = typedArray.getDimensionPixelOffset(index, c3739a.pA);
                    break;
                case 7:
                    c3739a.pB = typedArray.getDimensionPixelOffset(index, c3739a.pB);
                    break;
                case 8:
                    c3739a.pV = typedArray.getDimensionPixelSize(index, c3739a.pV);
                    break;
                case 9:
                    c3739a.pa = C3740j.m11856a(typedArray, index, c3739a.pg);
                    break;
                case 10:
                    c3739a.pf = C3740j.m11856a(typedArray, index, c3739a.pf);
                    break;
                case 11:
                    c3739a.pk = typedArray.getDimensionPixelSize(index, c3739a.pk);
                    break;
                case 12:
                    c3739a.pm = typedArray.getDimensionPixelSize(index, c3739a.pm);
                    break;
                case 13:
                    c3739a.ph = typedArray.getDimensionPixelSize(index, c3739a.ph);
                    break;
                case 14:
                    c3739a.pj = typedArray.getDimensionPixelSize(index, c3739a.pj);
                    break;
                case 15:
                    c3739a.pl = typedArray.getDimensionPixelSize(index, c3739a.pl);
                    break;
                case 16:
                    c3739a.pi = typedArray.getDimensionPixelSize(index, c3739a.pi);
                    break;
                case 17:
                    c3739a.oR = typedArray.getDimensionPixelOffset(index, c3739a.oR);
                    break;
                case 18:
                    c3739a.oS = typedArray.getDimensionPixelOffset(index, c3739a.oS);
                    break;
                case 19:
                    c3739a.oT = typedArray.getFloat(index, c3739a.oT);
                    break;
                case 20:
                    c3739a.pn = typedArray.getFloat(index, c3739a.pn);
                    break;
                case 21:
                    c3739a.pT = typedArray.getLayoutDimension(index, c3739a.pT);
                    break;
                case 22:
                    c3739a.visibility = typedArray.getInt(index, c3739a.visibility);
                    c3739a.visibility = pO[c3739a.visibility];
                    break;
                case 23:
                    c3739a.pS = typedArray.getLayoutDimension(index, c3739a.pS);
                    break;
                case 24:
                    c3739a.leftMargin = typedArray.getDimensionPixelSize(index, c3739a.leftMargin);
                    break;
                case 25:
                    c3739a.oU = C3740j.m11856a(typedArray, index, c3739a.oU);
                    break;
                case 26:
                    c3739a.oV = C3740j.m11856a(typedArray, index, c3739a.oV);
                    break;
                case 27:
                    c3739a.orientation = typedArray.getInt(index, c3739a.orientation);
                    break;
                case 28:
                    c3739a.rightMargin = typedArray.getDimensionPixelSize(index, c3739a.rightMargin);
                    break;
                case 29:
                    c3739a.oW = C3740j.m11856a(typedArray, index, c3739a.oW);
                    break;
                case 30:
                    c3739a.oX = C3740j.m11856a(typedArray, index, c3739a.oX);
                    break;
                case 31:
                    c3739a.pW = typedArray.getDimensionPixelSize(index, c3739a.pW);
                    break;
                case 32:
                    c3739a.pd = C3740j.m11856a(typedArray, index, c3739a.pd);
                    break;
                case 33:
                    c3739a.pe = C3740j.m11856a(typedArray, index, c3739a.pe);
                    break;
                case 34:
                    c3739a.topMargin = typedArray.getDimensionPixelSize(index, c3739a.topMargin);
                    break;
                case 35:
                    c3739a.oZ = C3740j.m11856a(typedArray, index, c3739a.oZ);
                    break;
                case 36:
                    c3739a.oY = C3740j.m11856a(typedArray, index, c3739a.oY);
                    break;
                case 37:
                    c3739a.po = typedArray.getFloat(index, c3739a.po);
                    break;
                case 38:
                    c3739a.pU = typedArray.getResourceId(index, c3739a.pU);
                    break;
                case 39:
                    c3739a.horizontalWeight = typedArray.getFloat(index, c3739a.horizontalWeight);
                    break;
                case 40:
                    c3739a.verticalWeight = typedArray.getFloat(index, c3739a.verticalWeight);
                    break;
                case 41:
                    c3739a.ps = typedArray.getInt(index, c3739a.ps);
                    break;
                case 42:
                    c3739a.pt = typedArray.getInt(index, c3739a.pt);
                    break;
                case 43:
                    c3739a.alpha = typedArray.getFloat(index, c3739a.alpha);
                    break;
                case 44:
                    c3739a.pX = true;
                    c3739a.pY = typedArray.getFloat(index, c3739a.pY);
                    break;
                case 45:
                    c3739a.pZ = typedArray.getFloat(index, c3739a.pZ);
                    break;
                case 46:
                    c3739a.qa = typedArray.getFloat(index, c3739a.qa);
                    break;
                case 47:
                    c3739a.qb = typedArray.getFloat(index, c3739a.qb);
                    break;
                case 48:
                    c3739a.qc = typedArray.getFloat(index, c3739a.qc);
                    break;
                case 49:
                    c3739a.qd = typedArray.getFloat(index, c3739a.qd);
                    break;
                case 50:
                    c3739a.qe = typedArray.getFloat(index, c3739a.qe);
                    break;
                case 51:
                    c3739a.qf = typedArray.getFloat(index, c3739a.qf);
                    break;
                case 52:
                    c3739a.qg = typedArray.getFloat(index, c3739a.qg);
                    break;
                case 53:
                    c3739a.qh = typedArray.getFloat(index, c3739a.qh);
                    break;
                case 60:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + pQ.get(index));
                    break;
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + pQ.get(index));
                    break;
            }
        }
    }
}
