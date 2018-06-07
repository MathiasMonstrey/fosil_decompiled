package android.support.constraint;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.constraint.solver.widgets.ConstraintAnchor.Strength;
import android.support.constraint.solver.widgets.ConstraintAnchor.Type;
import android.support.constraint.solver.widgets.ConstraintWidget;
import android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.fossil.C3740j;
import com.fossil.C3777k.C3776a;
import com.fossil.r;
import com.fossil.s;
import java.util.ArrayList;

public class ConstraintLayout extends ViewGroup {
    private int mMaxWidth = Integer.MAX_VALUE;
    SparseArray<View> oI = new SparseArray();
    private final ArrayList<ConstraintWidget> oJ = new ArrayList(100);
    r oK = new r();
    private int oL = 0;
    private int oM = 0;
    private int oN = Integer.MAX_VALUE;
    private boolean oO = true;
    private int oP = 2;
    private C3740j oQ = null;

    public static class LayoutParams extends MarginLayoutParams {
        public float horizontalWeight = 0.0f;
        public int oR = -1;
        public int oS = -1;
        public float oT = -1.0f;
        public int oU = -1;
        public int oV = -1;
        public int oW = -1;
        public int oX = -1;
        public int oY = -1;
        public int oZ = -1;
        public int orientation = -1;
        public int pA = -1;
        public int pB = -1;
        boolean pC = true;
        boolean pD = true;
        boolean pE = false;
        boolean pF = false;
        int pG = -1;
        int pH = -1;
        int pI = -1;
        int pJ = -1;
        int pK = -1;
        int pL = -1;
        float pM = 0.5f;
        ConstraintWidget pN = new ConstraintWidget();
        public int pa = -1;
        public int pb = -1;
        public int pc = -1;
        public int pd = -1;
        public int pe = -1;
        public int pf = -1;
        public int pg = -1;
        public int ph = -1;
        public int pi = -1;
        public int pj = -1;
        public int pk = -1;
        public int pl = -1;
        public int pm = -1;
        public float pn = 0.5f;
        public float po = 0.5f;
        public String pp = null;
        float pq = 0.0f;
        int pr = 1;
        public int ps = 0;
        public int pt = 0;
        public int pu = 0;
        public int pv = 0;
        public int pw = 0;
        public int px = 0;
        public int py = 0;
        public int pz = 0;
        public float verticalWeight = 0.0f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3776a.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C3776a.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf) {
                    this.oU = obtainStyledAttributes.getResourceId(index, this.oU);
                    if (this.oU == -1) {
                        this.oU = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == C3776a.ConstraintLayout_Layout_layout_constraintLeft_toRightOf) {
                    this.oV = obtainStyledAttributes.getResourceId(index, this.oV);
                    if (this.oV == -1) {
                        this.oV = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == C3776a.ConstraintLayout_Layout_layout_constraintRight_toLeftOf) {
                    this.oW = obtainStyledAttributes.getResourceId(index, this.oW);
                    if (this.oW == -1) {
                        this.oW = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == C3776a.ConstraintLayout_Layout_layout_constraintRight_toRightOf) {
                    this.oX = obtainStyledAttributes.getResourceId(index, this.oX);
                    if (this.oX == -1) {
                        this.oX = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == C3776a.ConstraintLayout_Layout_layout_constraintTop_toTopOf) {
                    this.oY = obtainStyledAttributes.getResourceId(index, this.oY);
                    if (this.oY == -1) {
                        this.oY = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == C3776a.ConstraintLayout_Layout_layout_constraintTop_toBottomOf) {
                    this.oZ = obtainStyledAttributes.getResourceId(index, this.oZ);
                    if (this.oZ == -1) {
                        this.oZ = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == C3776a.ConstraintLayout_Layout_layout_constraintBottom_toTopOf) {
                    this.pa = obtainStyledAttributes.getResourceId(index, this.pa);
                    if (this.pa == -1) {
                        this.pa = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == C3776a.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf) {
                    this.pb = obtainStyledAttributes.getResourceId(index, this.pb);
                    if (this.pb == -1) {
                        this.pb = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == C3776a.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf) {
                    this.pc = obtainStyledAttributes.getResourceId(index, this.pc);
                    if (this.pc == -1) {
                        this.pc = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == C3776a.ConstraintLayout_Layout_layout_editor_absoluteX) {
                    this.pA = obtainStyledAttributes.getDimensionPixelOffset(index, this.pA);
                } else if (index == C3776a.ConstraintLayout_Layout_layout_editor_absoluteY) {
                    this.pB = obtainStyledAttributes.getDimensionPixelOffset(index, this.pB);
                } else if (index == C3776a.ConstraintLayout_Layout_layout_constraintGuide_begin) {
                    this.oR = obtainStyledAttributes.getDimensionPixelOffset(index, this.oR);
                } else if (index == C3776a.ConstraintLayout_Layout_layout_constraintGuide_end) {
                    this.oS = obtainStyledAttributes.getDimensionPixelOffset(index, this.oS);
                } else if (index == C3776a.ConstraintLayout_Layout_layout_constraintGuide_percent) {
                    this.oT = obtainStyledAttributes.getFloat(index, this.oT);
                } else if (index == C3776a.ConstraintLayout_Layout_android_orientation) {
                    this.orientation = obtainStyledAttributes.getInt(index, this.orientation);
                } else if (index == C3776a.ConstraintLayout_Layout_layout_constraintStart_toEndOf) {
                    this.pd = obtainStyledAttributes.getResourceId(index, this.pd);
                    if (this.pd == -1) {
                        this.pd = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == C3776a.ConstraintLayout_Layout_layout_constraintStart_toStartOf) {
                    this.pe = obtainStyledAttributes.getResourceId(index, this.pe);
                    if (this.pe == -1) {
                        this.pe = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == C3776a.ConstraintLayout_Layout_layout_constraintEnd_toStartOf) {
                    this.pf = obtainStyledAttributes.getResourceId(index, this.pf);
                    if (this.pf == -1) {
                        this.pf = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == C3776a.ConstraintLayout_Layout_layout_constraintEnd_toEndOf) {
                    this.pg = obtainStyledAttributes.getResourceId(index, this.pg);
                    if (this.pg == -1) {
                        this.pg = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == C3776a.ConstraintLayout_Layout_layout_goneMarginLeft) {
                    this.ph = obtainStyledAttributes.getDimensionPixelSize(index, this.ph);
                } else if (index == C3776a.ConstraintLayout_Layout_layout_goneMarginTop) {
                    this.pi = obtainStyledAttributes.getDimensionPixelSize(index, this.pi);
                } else if (index == C3776a.ConstraintLayout_Layout_layout_goneMarginRight) {
                    this.pj = obtainStyledAttributes.getDimensionPixelSize(index, this.pj);
                } else if (index == C3776a.ConstraintLayout_Layout_layout_goneMarginBottom) {
                    this.pk = obtainStyledAttributes.getDimensionPixelSize(index, this.pk);
                } else if (index == C3776a.ConstraintLayout_Layout_layout_goneMarginStart) {
                    this.pl = obtainStyledAttributes.getDimensionPixelSize(index, this.pl);
                } else if (index == C3776a.ConstraintLayout_Layout_layout_goneMarginEnd) {
                    this.pm = obtainStyledAttributes.getDimensionPixelSize(index, this.pm);
                } else if (index == C3776a.ConstraintLayout_Layout_layout_constraintHorizontal_bias) {
                    this.pn = obtainStyledAttributes.getFloat(index, this.pn);
                } else if (index == C3776a.ConstraintLayout_Layout_layout_constraintVertical_bias) {
                    this.po = obtainStyledAttributes.getFloat(index, this.po);
                } else if (index == C3776a.ConstraintLayout_Layout_layout_constraintDimensionRatio) {
                    this.pp = obtainStyledAttributes.getString(index);
                    this.pq = Float.NaN;
                    this.pr = -1;
                    if (this.pp != null) {
                        int length = this.pp.length();
                        index = this.pp.indexOf(44);
                        if (index <= 0 || index >= length - 1) {
                            index = 0;
                        } else {
                            String substring = this.pp.substring(0, index);
                            if (substring.equalsIgnoreCase("W")) {
                                this.pr = 0;
                            } else if (substring.equalsIgnoreCase("H")) {
                                this.pr = 1;
                            }
                            index++;
                        }
                        int indexOf = this.pp.indexOf(58);
                        String substring2;
                        if (indexOf < 0 || indexOf >= length - 1) {
                            substring2 = this.pp.substring(index);
                            if (substring2.length() > 0) {
                                try {
                                    this.pq = Float.parseFloat(substring2);
                                } catch (NumberFormatException e) {
                                }
                            }
                        } else {
                            substring2 = this.pp.substring(index, indexOf);
                            String substring3 = this.pp.substring(indexOf + 1);
                            if (substring2.length() > 0 && substring3.length() > 0) {
                                try {
                                    float parseFloat = Float.parseFloat(substring2);
                                    float parseFloat2 = Float.parseFloat(substring3);
                                    if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                        if (this.pr == 1) {
                                            this.pq = Math.abs(parseFloat2 / parseFloat);
                                        } else {
                                            this.pq = Math.abs(parseFloat / parseFloat2);
                                        }
                                    }
                                } catch (NumberFormatException e2) {
                                }
                            }
                        }
                    }
                } else if (index == C3776a.ConstraintLayout_Layout_layout_constraintHorizontal_weight) {
                    this.horizontalWeight = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == C3776a.ConstraintLayout_Layout_layout_constraintVertical_weight) {
                    this.verticalWeight = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == C3776a.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle) {
                    this.ps = obtainStyledAttributes.getInt(index, 0);
                } else if (index == C3776a.ConstraintLayout_Layout_layout_constraintVertical_chainStyle) {
                    this.pt = obtainStyledAttributes.getInt(index, 0);
                } else if (index == C3776a.ConstraintLayout_Layout_layout_constraintWidth_default) {
                    this.pu = obtainStyledAttributes.getInt(index, 0);
                } else if (index == C3776a.ConstraintLayout_Layout_layout_constraintHeight_default) {
                    this.pv = obtainStyledAttributes.getInt(index, 0);
                } else if (index == C3776a.ConstraintLayout_Layout_layout_constraintWidth_min) {
                    this.pw = obtainStyledAttributes.getDimensionPixelSize(index, this.pw);
                } else if (index == C3776a.ConstraintLayout_Layout_layout_constraintWidth_max) {
                    this.py = obtainStyledAttributes.getDimensionPixelSize(index, this.py);
                } else if (index == C3776a.ConstraintLayout_Layout_layout_constraintHeight_min) {
                    this.px = obtainStyledAttributes.getDimensionPixelSize(index, this.px);
                } else if (index == C3776a.ConstraintLayout_Layout_layout_constraintHeight_max) {
                    this.pz = obtainStyledAttributes.getDimensionPixelSize(index, this.pz);
                } else if (!(index == C3776a.ConstraintLayout_Layout_layout_constraintLeft_creator || index == C3776a.ConstraintLayout_Layout_layout_constraintTop_creator || index == C3776a.ConstraintLayout_Layout_layout_constraintRight_creator || index == C3776a.ConstraintLayout_Layout_layout_constraintBottom_creator || index != C3776a.ConstraintLayout_Layout_layout_constraintBaseline_creator)) {
                }
            }
            obtainStyledAttributes.recycle();
            validate();
        }

        public void validate() {
            this.pF = false;
            this.pC = true;
            this.pD = true;
            if (this.width == 0 || this.width == -1) {
                this.pC = false;
            }
            if (this.height == 0 || this.height == -1) {
                this.pD = false;
            }
            if (this.oT != -1.0f || this.oR != -1 || this.oS != -1) {
                this.pF = true;
                this.pC = true;
                this.pD = true;
                if (!(this.pN instanceof s)) {
                    this.pN = new s();
                }
                ((s) this.pN).setOrientation(this.orientation);
            }
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        @TargetApi(17)
        public void resolveLayoutDirection(int i) {
            Object obj = 1;
            super.resolveLayoutDirection(i);
            this.pI = -1;
            this.pJ = -1;
            this.pG = -1;
            this.pH = -1;
            this.pK = -1;
            this.pL = -1;
            this.pK = this.ph;
            this.pL = this.pj;
            this.pM = this.pn;
            if (1 != getLayoutDirection()) {
                obj = null;
            }
            if (obj != null) {
                if (this.pd != -1) {
                    this.pI = this.pd;
                } else if (this.pe != -1) {
                    this.pJ = this.pe;
                }
                if (this.pf != -1) {
                    this.pH = this.pf;
                }
                if (this.pg != -1) {
                    this.pG = this.pg;
                }
                if (this.pl != -1) {
                    this.pL = this.pl;
                }
                if (this.pm != -1) {
                    this.pK = this.pm;
                }
                this.pM = 1.0f - this.pn;
            } else {
                if (this.pd != -1) {
                    this.pH = this.pd;
                }
                if (this.pe != -1) {
                    this.pG = this.pe;
                }
                if (this.pf != -1) {
                    this.pI = this.pf;
                }
                if (this.pg != -1) {
                    this.pJ = this.pg;
                }
                if (this.pl != -1) {
                    this.pK = this.pl;
                }
                if (this.pm != -1) {
                    this.pL = this.pm;
                }
            }
            if (this.pf == -1 && this.pg == -1) {
                if (this.oW != -1) {
                    this.pI = this.oW;
                } else if (this.oX != -1) {
                    this.pJ = this.oX;
                }
            }
            if (this.pe != -1 || this.pd != -1) {
                return;
            }
            if (this.oU != -1) {
                this.pG = this.oU;
            } else if (this.oV != -1) {
                this.pH = this.oV;
            }
        }
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return dI();
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m1641b(attributeSet);
    }

    public ConstraintLayout(Context context) {
        super(context);
        m1636a(null);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1636a(attributeSet);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1636a(attributeSet);
    }

    public void setId(int i) {
        this.oI.remove(getId());
        super.setId(i);
        this.oI.put(getId(), this);
    }

    private void m1636a(AttributeSet attributeSet) {
        this.oK.f(this);
        this.oI.put(getId(), this);
        this.oQ = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C3776a.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C3776a.ConstraintLayout_Layout_android_minWidth) {
                    this.oL = obtainStyledAttributes.getDimensionPixelOffset(index, this.oL);
                } else if (index == C3776a.ConstraintLayout_Layout_android_minHeight) {
                    this.oM = obtainStyledAttributes.getDimensionPixelOffset(index, this.oM);
                } else if (index == C3776a.ConstraintLayout_Layout_android_maxWidth) {
                    this.mMaxWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                } else if (index == C3776a.ConstraintLayout_Layout_android_maxHeight) {
                    this.oN = obtainStyledAttributes.getDimensionPixelOffset(index, this.oN);
                } else if (index == C3776a.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.oP = obtainStyledAttributes.getInt(index, this.oP);
                } else if (index == C3776a.ConstraintLayout_Layout_constraintSet) {
                    index = obtainStyledAttributes.getResourceId(index, 0);
                    this.oQ = new C3740j();
                    this.oQ.m11859a(getContext(), index);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.oK.setOptimizationLevel(this.oP);
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (VERSION.SDK_INT < 14) {
            onViewAdded(view);
        }
    }

    public void removeView(View view) {
        super.removeView(view);
        if (VERSION.SDK_INT < 14) {
            onViewRemoved(view);
        }
    }

    public void onViewAdded(View view) {
        if (VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        ConstraintWidget c = m1637c(view);
        if ((view instanceof Guideline) && !(c instanceof s)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.pN = new s();
            layoutParams.pF = true;
            ((s) layoutParams.pN).setOrientation(layoutParams.orientation);
            c = layoutParams.pN;
        }
        this.oI.put(view.getId(), view);
        this.oO = true;
    }

    public void onViewRemoved(View view) {
        if (VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.oI.remove(view.getId());
        this.oK.g(m1637c(view));
        this.oO = true;
    }

    public void setMinWidth(int i) {
        if (i != this.oL) {
            this.oL = i;
            requestLayout();
        }
    }

    public void setMinHeight(int i) {
        if (i != this.oM) {
            this.oM = i;
            requestLayout();
        }
    }

    public int getMinWidth() {
        return this.oL;
    }

    public int getMinHeight() {
        return this.oM;
    }

    public void setMaxWidth(int i) {
        if (i != this.mMaxWidth) {
            this.mMaxWidth = i;
            requestLayout();
        }
    }

    public void setMaxHeight(int i) {
        if (i != this.oN) {
            this.oN = i;
            requestLayout();
        }
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMaxHeight() {
        return this.oN;
    }

    private void dF() {
        Object obj = null;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).isLayoutRequested()) {
                obj = 1;
                break;
            }
        }
        if (obj != null) {
            this.oJ.clear();
            dG();
        }
    }

    private void dG() {
        if (this.oQ != null) {
            this.oQ.m11860a(this);
        }
        int childCount = getChildCount();
        this.oK.eQ();
        for (int i = 0; i < childCount; i++) {
            Object childAt = getChildAt(i);
            ConstraintWidget c = m1637c(childAt);
            if (c != null) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                c.reset();
                c.setVisibility(childAt.getVisibility());
                c.m1669f(childAt);
                this.oK.f(c);
                if (!(layoutParams.pD && layoutParams.pC)) {
                    this.oJ.add(c);
                }
                if (layoutParams.pF) {
                    s sVar = (s) c;
                    if (layoutParams.oR != -1) {
                        sVar.z(layoutParams.oR);
                    }
                    if (layoutParams.oS != -1) {
                        sVar.A(layoutParams.oS);
                    }
                    if (layoutParams.oT != -1.0f) {
                        sVar.g(layoutParams.oT);
                    }
                } else if (layoutParams.pG != -1 || layoutParams.pH != -1 || layoutParams.pI != -1 || layoutParams.pJ != -1 || layoutParams.oY != -1 || layoutParams.oZ != -1 || layoutParams.pa != -1 || layoutParams.pb != -1 || layoutParams.pc != -1 || layoutParams.pA != -1 || layoutParams.pB != -1 || layoutParams.width == -1 || layoutParams.height == -1) {
                    float f;
                    int i2;
                    int i3;
                    ConstraintWidget q;
                    View view;
                    LayoutParams layoutParams2;
                    int i4 = layoutParams.pG;
                    int i5 = layoutParams.pH;
                    int i6 = layoutParams.pI;
                    int i7 = layoutParams.pJ;
                    int i8 = layoutParams.pK;
                    int i9 = layoutParams.pL;
                    float f2 = layoutParams.pM;
                    if (VERSION.SDK_INT < 17) {
                        i4 = layoutParams.oU;
                        i5 = layoutParams.oV;
                        i6 = layoutParams.oW;
                        i7 = layoutParams.oX;
                        i8 = layoutParams.ph;
                        i9 = layoutParams.pj;
                        f2 = layoutParams.pn;
                        if (i4 == -1 && i5 == -1) {
                            if (layoutParams.pe != -1) {
                                i4 = layoutParams.pe;
                            } else if (layoutParams.pd != -1) {
                                i5 = layoutParams.pd;
                            }
                        }
                        if (i6 == -1 && i7 == -1) {
                            if (layoutParams.pf != -1) {
                                f = f2;
                                i2 = layoutParams.pf;
                                i3 = i5;
                                i5 = i9;
                                i9 = i4;
                                i4 = i7;
                            } else if (layoutParams.pg != -1) {
                                f = f2;
                                i2 = i6;
                                i3 = i5;
                                i5 = i9;
                                i9 = i4;
                                i4 = layoutParams.pg;
                            }
                            if (i9 != -1) {
                                q = m1640q(i9);
                                if (q != null) {
                                    c.m1655a(Type.LEFT, q, Type.LEFT, layoutParams.leftMargin, i8);
                                }
                            } else if (i3 != -1) {
                                q = m1640q(i3);
                                if (q != null) {
                                    c.m1655a(Type.LEFT, q, Type.RIGHT, layoutParams.leftMargin, i8);
                                }
                            }
                            if (i2 != -1) {
                                q = m1640q(i2);
                                if (q != null) {
                                    c.m1655a(Type.RIGHT, q, Type.LEFT, layoutParams.rightMargin, i5);
                                }
                            } else if (i4 != -1) {
                                q = m1640q(i4);
                                if (q != null) {
                                    c.m1655a(Type.RIGHT, q, Type.RIGHT, layoutParams.rightMargin, i5);
                                }
                            }
                            if (layoutParams.oY != -1) {
                                q = m1640q(layoutParams.oY);
                                if (q != null) {
                                    c.m1655a(Type.TOP, q, Type.TOP, layoutParams.topMargin, layoutParams.pi);
                                }
                            } else if (layoutParams.oZ != -1) {
                                q = m1640q(layoutParams.oZ);
                                if (q != null) {
                                    c.m1655a(Type.TOP, q, Type.BOTTOM, layoutParams.topMargin, layoutParams.pi);
                                }
                            }
                            if (layoutParams.pa != -1) {
                                q = m1640q(layoutParams.pa);
                                if (q != null) {
                                    c.m1655a(Type.BOTTOM, q, Type.TOP, layoutParams.bottomMargin, layoutParams.pk);
                                }
                            } else if (layoutParams.pb != -1) {
                                q = m1640q(layoutParams.pb);
                                if (q != null) {
                                    c.m1655a(Type.BOTTOM, q, Type.BOTTOM, layoutParams.bottomMargin, layoutParams.pk);
                                }
                            }
                            if (layoutParams.pc != -1) {
                                view = (View) this.oI.get(layoutParams.pc);
                                q = m1640q(layoutParams.pc);
                                if (!(q == null || view == null || !(view.getLayoutParams() instanceof LayoutParams))) {
                                    layoutParams2 = (LayoutParams) view.getLayoutParams();
                                    layoutParams.pE = true;
                                    layoutParams2.pE = true;
                                    c.m1653a(Type.BASELINE).m1649a(q.m1653a(Type.BASELINE), 0, -1, Strength.STRONG, 0, true);
                                    c.m1653a(Type.TOP).reset();
                                    c.m1653a(Type.BOTTOM).reset();
                                }
                            }
                            if (f >= 0.0f && f != 0.5f) {
                                c.m1663c(f);
                            }
                            if (layoutParams.po >= 0.0f && layoutParams.po != 0.5f) {
                                c.m1665d(layoutParams.po);
                            }
                            if (isInEditMode() && !(layoutParams.pA == -1 && layoutParams.pB == -1)) {
                                c.m1668f(layoutParams.pA, layoutParams.pB);
                            }
                            if (!layoutParams.pC) {
                                c.m1656a(DimensionBehaviour.FIXED);
                                c.setWidth(layoutParams.width);
                            } else if (layoutParams.width != -1) {
                                c.m1656a(DimensionBehaviour.MATCH_PARENT);
                                c.m1653a(Type.LEFT).rk = layoutParams.leftMargin;
                                c.m1653a(Type.RIGHT).rk = layoutParams.rightMargin;
                            } else {
                                c.m1656a(DimensionBehaviour.MATCH_CONSTRAINT);
                                c.setWidth(0);
                            }
                            if (!layoutParams.pD) {
                                c.m1660b(DimensionBehaviour.FIXED);
                                c.setHeight(layoutParams.height);
                            } else if (layoutParams.height != -1) {
                                c.m1660b(DimensionBehaviour.MATCH_PARENT);
                                c.m1653a(Type.TOP).rk = layoutParams.topMargin;
                                c.m1653a(Type.BOTTOM).rk = layoutParams.bottomMargin;
                            } else {
                                c.m1660b(DimensionBehaviour.MATCH_CONSTRAINT);
                                c.setHeight(0);
                            }
                            if (layoutParams.pp != null) {
                                c.m1652N(layoutParams.pp);
                            }
                            c.m1666e(layoutParams.horizontalWeight);
                            c.m1667f(layoutParams.verticalWeight);
                            c.m1676x(layoutParams.ps);
                            c.m1677y(layoutParams.pt);
                            c.m1659b(layoutParams.pu, layoutParams.pw, layoutParams.py);
                            c.m1664c(layoutParams.pv, layoutParams.px, layoutParams.pz);
                        }
                    }
                    f = f2;
                    i2 = i6;
                    i3 = i5;
                    i5 = i9;
                    i9 = i4;
                    i4 = i7;
                    if (i9 != -1) {
                        q = m1640q(i9);
                        if (q != null) {
                            c.m1655a(Type.LEFT, q, Type.LEFT, layoutParams.leftMargin, i8);
                        }
                    } else if (i3 != -1) {
                        q = m1640q(i3);
                        if (q != null) {
                            c.m1655a(Type.LEFT, q, Type.RIGHT, layoutParams.leftMargin, i8);
                        }
                    }
                    if (i2 != -1) {
                        q = m1640q(i2);
                        if (q != null) {
                            c.m1655a(Type.RIGHT, q, Type.LEFT, layoutParams.rightMargin, i5);
                        }
                    } else if (i4 != -1) {
                        q = m1640q(i4);
                        if (q != null) {
                            c.m1655a(Type.RIGHT, q, Type.RIGHT, layoutParams.rightMargin, i5);
                        }
                    }
                    if (layoutParams.oY != -1) {
                        q = m1640q(layoutParams.oY);
                        if (q != null) {
                            c.m1655a(Type.TOP, q, Type.TOP, layoutParams.topMargin, layoutParams.pi);
                        }
                    } else if (layoutParams.oZ != -1) {
                        q = m1640q(layoutParams.oZ);
                        if (q != null) {
                            c.m1655a(Type.TOP, q, Type.BOTTOM, layoutParams.topMargin, layoutParams.pi);
                        }
                    }
                    if (layoutParams.pa != -1) {
                        q = m1640q(layoutParams.pa);
                        if (q != null) {
                            c.m1655a(Type.BOTTOM, q, Type.TOP, layoutParams.bottomMargin, layoutParams.pk);
                        }
                    } else if (layoutParams.pb != -1) {
                        q = m1640q(layoutParams.pb);
                        if (q != null) {
                            c.m1655a(Type.BOTTOM, q, Type.BOTTOM, layoutParams.bottomMargin, layoutParams.pk);
                        }
                    }
                    if (layoutParams.pc != -1) {
                        view = (View) this.oI.get(layoutParams.pc);
                        q = m1640q(layoutParams.pc);
                        layoutParams2 = (LayoutParams) view.getLayoutParams();
                        layoutParams.pE = true;
                        layoutParams2.pE = true;
                        c.m1653a(Type.BASELINE).m1649a(q.m1653a(Type.BASELINE), 0, -1, Strength.STRONG, 0, true);
                        c.m1653a(Type.TOP).reset();
                        c.m1653a(Type.BOTTOM).reset();
                    }
                    c.m1663c(f);
                    c.m1665d(layoutParams.po);
                    c.m1668f(layoutParams.pA, layoutParams.pB);
                    if (!layoutParams.pC) {
                        c.m1656a(DimensionBehaviour.FIXED);
                        c.setWidth(layoutParams.width);
                    } else if (layoutParams.width != -1) {
                        c.m1656a(DimensionBehaviour.MATCH_CONSTRAINT);
                        c.setWidth(0);
                    } else {
                        c.m1656a(DimensionBehaviour.MATCH_PARENT);
                        c.m1653a(Type.LEFT).rk = layoutParams.leftMargin;
                        c.m1653a(Type.RIGHT).rk = layoutParams.rightMargin;
                    }
                    if (!layoutParams.pD) {
                        c.m1660b(DimensionBehaviour.FIXED);
                        c.setHeight(layoutParams.height);
                    } else if (layoutParams.height != -1) {
                        c.m1660b(DimensionBehaviour.MATCH_CONSTRAINT);
                        c.setHeight(0);
                    } else {
                        c.m1660b(DimensionBehaviour.MATCH_PARENT);
                        c.m1653a(Type.TOP).rk = layoutParams.topMargin;
                        c.m1653a(Type.BOTTOM).rk = layoutParams.bottomMargin;
                    }
                    if (layoutParams.pp != null) {
                        c.m1652N(layoutParams.pp);
                    }
                    c.m1666e(layoutParams.horizontalWeight);
                    c.m1667f(layoutParams.verticalWeight);
                    c.m1676x(layoutParams.ps);
                    c.m1677y(layoutParams.pt);
                    c.m1659b(layoutParams.pu, layoutParams.pw, layoutParams.py);
                    c.m1664c(layoutParams.pv, layoutParams.px, layoutParams.pz);
                }
            }
        }
    }

    private final ConstraintWidget m1640q(int i) {
        if (i == 0) {
            return this.oK;
        }
        View view = (View) this.oI.get(i);
        if (view == this) {
            return this.oK;
        }
        return view == null ? null : ((LayoutParams) view.getLayoutParams()).pN;
    }

    private final ConstraintWidget m1637c(View view) {
        if (view == this) {
            return this.oK;
        }
        return view == null ? null : ((LayoutParams) view.getLayoutParams()).pN;
    }

    private void m1638d(int i, int i2) {
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                ConstraintWidget constraintWidget = layoutParams.pN;
                if (!layoutParams.pF) {
                    Object obj;
                    int i4 = layoutParams.width;
                    int i5 = layoutParams.height;
                    if (layoutParams.pC || layoutParams.pD || ((!layoutParams.pC && layoutParams.pu == 1) || layoutParams.width == -1 || (!layoutParams.pD && (layoutParams.pv == 1 || layoutParams.height == -1)))) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    Object obj2 = null;
                    Object obj3 = null;
                    if (obj != null) {
                        Object obj4;
                        int childMeasureSpec;
                        int childMeasureSpec2;
                        if (i4 == 0 || i4 == -1) {
                            obj4 = 1;
                            childMeasureSpec = getChildMeasureSpec(i, paddingLeft, -2);
                        } else {
                            childMeasureSpec = getChildMeasureSpec(i, paddingLeft, i4);
                            obj4 = null;
                        }
                        if (i5 == 0 || i5 == -1) {
                            childMeasureSpec2 = getChildMeasureSpec(i2, paddingTop, -2);
                            obj3 = 1;
                        } else {
                            childMeasureSpec2 = getChildMeasureSpec(i2, paddingTop, i5);
                        }
                        childAt.measure(childMeasureSpec, childMeasureSpec2);
                        i5 = childAt.getMeasuredWidth();
                        Object obj5 = obj4;
                        i4 = childAt.getMeasuredHeight();
                        obj2 = obj5;
                    } else {
                        int i6 = i5;
                        i5 = i4;
                        i4 = i6;
                    }
                    constraintWidget.setWidth(i5);
                    constraintWidget.setHeight(i4);
                    if (obj2 != null) {
                        constraintWidget.m1673u(i5);
                    }
                    if (obj3 != null) {
                        constraintWidget.m1674v(i4);
                    }
                    if (layoutParams.pE) {
                        int baseline = childAt.getBaseline();
                        if (baseline != -1) {
                            constraintWidget.m1675w(baseline);
                        }
                    }
                }
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        this.oK.setX(paddingLeft);
        this.oK.setY(paddingTop);
        m1639e(i, i2);
        if (this.oO) {
            this.oO = false;
            dF();
        }
        m1638d(i, i2);
        if (getChildCount() > 0) {
            dH();
        }
        int i3 = 0;
        int size = this.oJ.size();
        int paddingBottom = paddingTop + getPaddingBottom();
        int paddingRight = paddingLeft + getPaddingRight();
        if (size > 0) {
            Object obj = null;
            Object obj2 = this.oK.eF() == DimensionBehaviour.WRAP_CONTENT ? 1 : null;
            Object obj3 = this.oK.eG() == DimensionBehaviour.WRAP_CONTENT ? 1 : null;
            int i4 = 0;
            while (i4 < size) {
                ConstraintWidget constraintWidget = (ConstraintWidget) this.oJ.get(i4);
                if (constraintWidget instanceof s) {
                    paddingLeft = i3;
                } else {
                    View view = (View) constraintWidget.eB();
                    if (view == null) {
                        paddingLeft = i3;
                    } else if (view.getVisibility() == 8) {
                        paddingLeft = i3;
                    } else {
                        int childMeasureSpec;
                        int childMeasureSpec2;
                        Object obj4;
                        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                        if (layoutParams.width == -2) {
                            childMeasureSpec = getChildMeasureSpec(i, paddingRight, layoutParams.width);
                        } else {
                            childMeasureSpec = MeasureSpec.makeMeasureSpec(constraintWidget.getWidth(), 1073741824);
                        }
                        if (layoutParams.height == -2) {
                            childMeasureSpec2 = getChildMeasureSpec(i2, paddingBottom, layoutParams.height);
                        } else {
                            childMeasureSpec2 = MeasureSpec.makeMeasureSpec(constraintWidget.getHeight(), 1073741824);
                        }
                        view.measure(childMeasureSpec, childMeasureSpec2);
                        childMeasureSpec = view.getMeasuredWidth();
                        childMeasureSpec2 = view.getMeasuredHeight();
                        if (childMeasureSpec != constraintWidget.getWidth()) {
                            constraintWidget.setWidth(childMeasureSpec);
                            if (obj2 != null && constraintWidget.getRight() > this.oK.getWidth()) {
                                this.oK.setWidth(Math.max(this.oL, constraintWidget.getRight() + constraintWidget.m1653a(Type.RIGHT).eg()));
                            }
                            obj4 = 1;
                        } else {
                            obj4 = obj;
                        }
                        if (childMeasureSpec2 != constraintWidget.getHeight()) {
                            constraintWidget.setHeight(childMeasureSpec2);
                            if (obj3 != null && constraintWidget.getBottom() > this.oK.getHeight()) {
                                this.oK.setHeight(Math.max(this.oM, constraintWidget.getBottom() + constraintWidget.m1653a(Type.BOTTOM).eg()));
                            }
                            obj4 = 1;
                        }
                        if (layoutParams.pE) {
                            int baseline = view.getBaseline();
                            if (!(baseline == -1 || baseline == constraintWidget.eA())) {
                                constraintWidget.m1675w(baseline);
                                obj4 = 1;
                            }
                        }
                        if (VERSION.SDK_INT >= 11) {
                            paddingLeft = combineMeasuredStates(i3, view.getMeasuredState());
                            obj = obj4;
                        } else {
                            obj = obj4;
                            paddingLeft = i3;
                        }
                    }
                }
                i4++;
                i3 = paddingLeft;
            }
            if (obj != null) {
                dH();
            }
        }
        paddingLeft = this.oK.getWidth() + paddingRight;
        paddingTop = this.oK.getHeight() + paddingBottom;
        if (VERSION.SDK_INT >= 11) {
            paddingLeft = Math.min(this.mMaxWidth, resolveSizeAndState(paddingLeft, i, i3)) & 16777215;
            paddingTop = Math.min(this.oN, resolveSizeAndState(paddingTop, i2, i3 << 16)) & 16777215;
            if (this.oK.eH()) {
                paddingLeft |= 16777216;
            }
            if (this.oK.eI()) {
                paddingTop |= 16777216;
            }
            setMeasuredDimension(paddingLeft, paddingTop);
            return;
        }
        setMeasuredDimension(paddingLeft, paddingTop);
    }

    private void m1639e(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.FIXED;
        getLayoutParams();
        switch (mode) {
            case Integer.MIN_VALUE:
                dimensionBehaviour = DimensionBehaviour.WRAP_CONTENT;
                break;
            case 0:
                dimensionBehaviour = DimensionBehaviour.WRAP_CONTENT;
                size = 0;
                break;
            case 1073741824:
                size = Math.min(this.mMaxWidth, size) - paddingLeft;
                break;
            default:
                size = 0;
                break;
        }
        switch (mode2) {
            case Integer.MIN_VALUE:
                dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
                break;
            case 0:
                dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
                size2 = 0;
                break;
            case 1073741824:
                size2 = Math.min(this.oN, size2) - paddingTop;
                break;
            default:
                size2 = 0;
                break;
        }
        this.oK.setMinWidth(0);
        this.oK.setMinHeight(0);
        this.oK.a(dimensionBehaviour);
        this.oK.setWidth(size);
        this.oK.b(dimensionBehaviour2);
        this.oK.setHeight(size2);
        this.oK.setMinWidth((this.oL - getPaddingLeft()) - getPaddingRight());
        this.oK.setMinHeight((this.oM - getPaddingTop()) - getPaddingBottom());
    }

    protected void dH() {
        this.oK.eJ();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8 || layoutParams.pF || isInEditMode) {
                ConstraintWidget constraintWidget = layoutParams.pN;
                int et = constraintWidget.et();
                int eu = constraintWidget.eu();
                childAt.layout(et, eu, constraintWidget.getWidth() + et, constraintWidget.getHeight() + eu);
            }
        }
    }

    public void setOptimizationLevel(int i) {
        this.oK.setOptimizationLevel(i);
    }

    public LayoutParams m1641b(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public LayoutParams dI() {
        return new LayoutParams(-2, -2);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void setConstraintSet(C3740j c3740j) {
        this.oQ = c3740j;
    }

    public void requestLayout() {
        super.requestLayout();
        this.oO = true;
    }
}
