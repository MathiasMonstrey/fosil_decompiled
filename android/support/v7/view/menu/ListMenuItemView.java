package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.fossil.li;
import com.fossil.pk;
import com.fossil.pk.f;
import com.fossil.pk.g;
import com.fossil.pk.j;
import com.fossil.ql;
import com.fossil.qr.a;
import com.fossil.sw;

public class ListMenuItemView extends LinearLayout implements a {
    private ImageView BX;
    private LayoutInflater Yg;
    private TextView aak;
    private boolean afJ;
    private RadioButton afW;
    private CheckBox afX;
    private TextView afY;
    private ImageView afZ;
    private Drawable aga;
    private Context agb;
    private boolean agc;
    private Drawable agd;
    private int agf;
    private ql tR;
    private int uH;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, pk.a.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        sw a = sw.a(getContext(), attributeSet, j.MenuView, i, 0);
        this.aga = a.getDrawable(j.MenuView_android_itemBackground);
        this.uH = a.getResourceId(j.MenuView_android_itemTextAppearance, -1);
        this.agc = a.getBoolean(j.MenuView_preserveIconSpacing, false);
        this.agb = context;
        this.agd = a.getDrawable(j.MenuView_subMenuArrow);
        a.recycle();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        li.m12248a((View) this, this.aga);
        this.aak = (TextView) findViewById(f.title);
        if (this.uH != -1) {
            this.aak.setTextAppearance(this.agb, this.uH);
        }
        this.afY = (TextView) findViewById(f.shortcut);
        this.afZ = (ImageView) findViewById(f.submenuarrow);
        if (this.afZ != null) {
            this.afZ.setImageDrawable(this.agd);
        }
    }

    public void m2180a(ql qlVar, int i) {
        this.tR = qlVar;
        this.agf = i;
        setVisibility(qlVar.isVisible() ? 0 : 8);
        setTitle(qlVar.m12648a((a) this));
        setCheckable(qlVar.isCheckable());
        m2181a(qlVar.nh(), qlVar.nf());
        setIcon(qlVar.getIcon());
        setEnabled(qlVar.isEnabled());
        setSubMenuArrowVisible(qlVar.hasSubMenu());
    }

    public void setForceShowIcon(boolean z) {
        this.afJ = z;
        this.agc = z;
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.aak.setText(charSequence);
            if (this.aak.getVisibility() != 0) {
                this.aak.setVisibility(0);
            }
        } else if (this.aak.getVisibility() != 8) {
            this.aak.setVisibility(8);
        }
    }

    public ql getItemData() {
        return this.tR;
    }

    public void setCheckable(boolean z) {
        if (z || this.afW != null || this.afX != null) {
            CompoundButton compoundButton;
            CompoundButton compoundButton2;
            if (this.tR.ni()) {
                if (this.afW == null) {
                    mK();
                }
                compoundButton = this.afW;
                compoundButton2 = this.afX;
            } else {
                if (this.afX == null) {
                    mL();
                }
                compoundButton = this.afX;
                compoundButton2 = this.afW;
            }
            if (z) {
                int i;
                compoundButton.setChecked(this.tR.isChecked());
                if (z) {
                    i = 0;
                } else {
                    i = 8;
                }
                if (compoundButton.getVisibility() != i) {
                    compoundButton.setVisibility(i);
                }
                if (compoundButton2 != null && compoundButton2.getVisibility() != 8) {
                    compoundButton2.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.afX != null) {
                this.afX.setVisibility(8);
            }
            if (this.afW != null) {
                this.afW.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.tR.ni()) {
            if (this.afW == null) {
                mK();
            }
            compoundButton = this.afW;
        } else {
            if (this.afX == null) {
                mL();
            }
            compoundButton = this.afX;
        }
        compoundButton.setChecked(z);
    }

    private void setSubMenuArrowVisible(boolean z) {
        if (this.afZ != null) {
            this.afZ.setVisibility(z ? 0 : 8);
        }
    }

    public void m2181a(boolean z, char c) {
        int i = (z && this.tR.nh()) ? 0 : 8;
        if (i == 0) {
            this.afY.setText(this.tR.ng());
        }
        if (this.afY.getVisibility() != i) {
            this.afY.setVisibility(i);
        }
    }

    public void setIcon(Drawable drawable) {
        int i = (this.tR.nk() || this.afJ) ? 1 : 0;
        if (i == 0 && !this.agc) {
            return;
        }
        if (this.BX != null || drawable != null || this.agc) {
            if (this.BX == null) {
                mJ();
            }
            if (drawable != null || this.agc) {
                ImageView imageView = this.BX;
                if (i == 0) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.BX.getVisibility() != 0) {
                    this.BX.setVisibility(0);
                    return;
                }
                return;
            }
            this.BX.setVisibility(8);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.BX != null && this.agc) {
            LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.BX.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    private void mJ() {
        this.BX = (ImageView) getInflater().inflate(g.abc_list_menu_item_icon, this, false);
        addView(this.BX, 0);
    }

    private void mK() {
        this.afW = (RadioButton) getInflater().inflate(g.abc_list_menu_item_radio, this, false);
        addView(this.afW);
    }

    private void mL() {
        this.afX = (CheckBox) getInflater().inflate(g.abc_list_menu_item_checkbox, this, false);
        addView(this.afX);
    }

    public boolean eT() {
        return false;
    }

    private LayoutInflater getInflater() {
        if (this.Yg == null) {
            this.Yg = LayoutInflater.from(getContext());
        }
        return this.Yg;
    }
}
