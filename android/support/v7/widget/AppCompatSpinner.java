package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import com.fossil.lf;
import com.fossil.li;
import com.fossil.pk.a;
import com.fossil.pk.g;
import com.fossil.pk.j;
import com.fossil.pn;
import com.fossil.pw;
import com.fossil.qu;
import com.fossil.re;
import com.fossil.ry;
import com.fossil.ss;
import com.fossil.sw;
import com.fossil.tb;

public class AppCompatSpinner extends Spinner implements lf {
    private static final int[] ald = new int[]{16843505};
    private ry afd;
    private final Context ahu;
    private final re akh;
    private SpinnerAdapter ale;
    private final boolean alf;
    private C1216b alg;
    private int alh;
    private final Rect uU;

    static class C1212a implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter alk;
        private ListAdapter alm;

        public C1212a(SpinnerAdapter spinnerAdapter, Theme theme) {
            this.alk = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.alm = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            } else if (spinnerAdapter instanceof ss) {
                ss ssVar = (ss) spinnerAdapter;
                if (ssVar.getDropDownViewTheme() == null) {
                    ssVar.setDropDownViewTheme(theme);
                }
            }
        }

        public int getCount() {
            return this.alk == null ? 0 : this.alk.getCount();
        }

        public Object getItem(int i) {
            return this.alk == null ? null : this.alk.getItem(i);
        }

        public long getItemId(int i) {
            return this.alk == null ? -1 : this.alk.getItemId(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            if (this.alk == null) {
                return null;
            }
            return this.alk.getDropDownView(i, view, viewGroup);
        }

        public boolean hasStableIds() {
            return this.alk != null && this.alk.hasStableIds();
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.alk != null) {
                this.alk.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.alk != null) {
                this.alk.unregisterDataSetObserver(dataSetObserver);
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.alm;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.alm;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }
    }

    class C1216b extends ListPopupWindow {
        ListAdapter aam;
        final /* synthetic */ AppCompatSpinner alj;
        private CharSequence aln;
        private final Rect alo = new Rect();

        class C12142 implements OnGlobalLayoutListener {
            final /* synthetic */ C1216b alq;

            C12142(C1216b c1216b) {
                this.alq = c1216b;
            }

            public void onGlobalLayout() {
                if (this.alq.bu(this.alq.alj)) {
                    this.alq.oA();
                    super.show();
                    return;
                }
                this.alq.dismiss();
            }
        }

        public C1216b(final AppCompatSpinner appCompatSpinner, Context context, AttributeSet attributeSet, int i) {
            this.alj = appCompatSpinner;
            super(context, attributeSet, i);
            setAnchorView(appCompatSpinner);
            setModal(true);
            setPromptPosition(0);
            setOnItemClickListener(new OnItemClickListener(this) {
                final /* synthetic */ C1216b alq;

                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.alq.alj.setSelection(i);
                    if (this.alq.alj.getOnItemClickListener() != null) {
                        this.alq.alj.performItemClick(view, i, this.alq.aam.getItemId(i));
                    }
                    this.alq.dismiss();
                }
            });
        }

        public void setAdapter(ListAdapter listAdapter) {
            super.setAdapter(listAdapter);
            this.aam = listAdapter;
        }

        public CharSequence oz() {
            return this.aln;
        }

        public void m2208p(CharSequence charSequence) {
            this.aln = charSequence;
        }

        void oA() {
            int i;
            int i2;
            Drawable background = getBackground();
            if (background != null) {
                background.getPadding(this.alj.uU);
                if (tb.cH(this.alj)) {
                    i = this.alj.uU.right;
                } else {
                    i = -this.alj.uU.left;
                }
                i2 = i;
            } else {
                Rect b = this.alj.uU;
                this.alj.uU.right = 0;
                b.left = 0;
                i2 = 0;
            }
            int paddingLeft = this.alj.getPaddingLeft();
            int paddingRight = this.alj.getPaddingRight();
            int width = this.alj.getWidth();
            if (this.alj.alh == -2) {
                int a = this.alj.m2212a((SpinnerAdapter) this.aam, getBackground());
                i = (this.alj.getContext().getResources().getDisplayMetrics().widthPixels - this.alj.uU.left) - this.alj.uU.right;
                if (a <= i) {
                    i = a;
                }
                setContentWidth(Math.max(i, (width - paddingLeft) - paddingRight));
            } else if (this.alj.alh == -1) {
                setContentWidth((width - paddingLeft) - paddingRight);
            } else {
                setContentWidth(this.alj.alh);
            }
            if (tb.cH(this.alj)) {
                i = ((width - paddingRight) - getWidth()) + i2;
            } else {
                i = i2 + paddingLeft;
            }
            setHorizontalOffset(i);
        }

        public void show() {
            boolean isShowing = isShowing();
            oA();
            setInputMethodMode(2);
            super.show();
            getListView().setChoiceMode(1);
            setSelection(this.alj.getSelectedItemPosition());
            if (!isShowing) {
                ViewTreeObserver viewTreeObserver = this.alj.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    final OnGlobalLayoutListener c12142 = new C12142(this);
                    viewTreeObserver.addOnGlobalLayoutListener(c12142);
                    setOnDismissListener(new OnDismissListener(this) {
                        final /* synthetic */ C1216b alq;

                        public void onDismiss() {
                            ViewTreeObserver viewTreeObserver = this.alq.alj.getViewTreeObserver();
                            if (viewTreeObserver != null) {
                                viewTreeObserver.removeGlobalOnLayoutListener(c12142);
                            }
                        }
                    });
                }
            }
        }

        boolean bu(View view) {
            return li.au(view) && view.getGlobalVisibleRect(this.alo);
        }
    }

    public AppCompatSpinner(Context context) {
        this(context, null);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.spinnerStyle);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2, Theme theme) {
        TypedArray obtainStyledAttributes;
        Throwable e;
        final C1216b c1216b;
        sw a;
        CharSequence[] textArray;
        SpinnerAdapter arrayAdapter;
        super(context, attributeSet, i);
        this.uU = new Rect();
        sw a2 = sw.a(context, attributeSet, j.Spinner, i, 0);
        this.akh = new re(this);
        if (theme != null) {
            this.ahu = new pw(context, theme);
        } else {
            int resourceId = a2.getResourceId(j.Spinner_popupTheme, 0);
            if (resourceId != 0) {
                this.ahu = new pw(context, resourceId);
            } else {
                this.ahu = VERSION.SDK_INT < 23 ? context : null;
            }
        }
        if (this.ahu != null) {
            if (i2 == -1) {
                if (VERSION.SDK_INT >= 11) {
                    try {
                        obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ald, i, 0);
                        try {
                            if (obtainStyledAttributes.hasValue(0)) {
                                i2 = obtainStyledAttributes.getInt(0, 0);
                            }
                            if (obtainStyledAttributes != null) {
                                obtainStyledAttributes.recycle();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                                if (obtainStyledAttributes != null) {
                                    obtainStyledAttributes.recycle();
                                }
                                if (i2 == 1) {
                                    c1216b = new C1216b(this, this.ahu, attributeSet, i);
                                    a = sw.a(this.ahu, attributeSet, j.Spinner, i, 0);
                                    this.alh = a.getLayoutDimension(j.Spinner_android_dropDownWidth, -2);
                                    c1216b.setBackgroundDrawable(a.getDrawable(j.Spinner_android_popupBackground));
                                    c1216b.m2208p(a2.getString(j.Spinner_android_prompt));
                                    a.recycle();
                                    this.alg = c1216b;
                                    this.afd = new ry(this, this) {
                                        final /* synthetic */ AppCompatSpinner alj;

                                        public qu mC() {
                                            return c1216b;
                                        }

                                        public boolean mD() {
                                            if (!this.alj.alg.isShowing()) {
                                                this.alj.alg.show();
                                            }
                                            return true;
                                        }
                                    };
                                }
                                textArray = a2.getTextArray(j.Spinner_android_entries);
                                if (textArray != null) {
                                    arrayAdapter = new ArrayAdapter(context, 17367048, textArray);
                                    arrayAdapter.setDropDownViewResource(g.support_simple_spinner_dropdown_item);
                                    setAdapter(arrayAdapter);
                                }
                                a2.recycle();
                                this.alf = true;
                                if (this.ale != null) {
                                    setAdapter(this.ale);
                                    this.ale = null;
                                }
                                this.akh.a(attributeSet, i);
                            } catch (Throwable th) {
                                e = th;
                                if (obtainStyledAttributes != null) {
                                    obtainStyledAttributes.recycle();
                                }
                                throw e;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        obtainStyledAttributes = null;
                        Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                        if (i2 == 1) {
                            c1216b = new C1216b(this, this.ahu, attributeSet, i);
                            a = sw.a(this.ahu, attributeSet, j.Spinner, i, 0);
                            this.alh = a.getLayoutDimension(j.Spinner_android_dropDownWidth, -2);
                            c1216b.setBackgroundDrawable(a.getDrawable(j.Spinner_android_popupBackground));
                            c1216b.m2208p(a2.getString(j.Spinner_android_prompt));
                            a.recycle();
                            this.alg = c1216b;
                            this.afd = /* anonymous class already generated */;
                        }
                        textArray = a2.getTextArray(j.Spinner_android_entries);
                        if (textArray != null) {
                            arrayAdapter = new ArrayAdapter(context, 17367048, textArray);
                            arrayAdapter.setDropDownViewResource(g.support_simple_spinner_dropdown_item);
                            setAdapter(arrayAdapter);
                        }
                        a2.recycle();
                        this.alf = true;
                        if (this.ale != null) {
                            setAdapter(this.ale);
                            this.ale = null;
                        }
                        this.akh.a(attributeSet, i);
                    } catch (Throwable th2) {
                        e = th2;
                        obtainStyledAttributes = null;
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                        throw e;
                    }
                }
                i2 = 1;
            }
            if (i2 == 1) {
                c1216b = new C1216b(this, this.ahu, attributeSet, i);
                a = sw.a(this.ahu, attributeSet, j.Spinner, i, 0);
                this.alh = a.getLayoutDimension(j.Spinner_android_dropDownWidth, -2);
                c1216b.setBackgroundDrawable(a.getDrawable(j.Spinner_android_popupBackground));
                c1216b.m2208p(a2.getString(j.Spinner_android_prompt));
                a.recycle();
                this.alg = c1216b;
                this.afd = /* anonymous class already generated */;
            }
        }
        textArray = a2.getTextArray(j.Spinner_android_entries);
        if (textArray != null) {
            arrayAdapter = new ArrayAdapter(context, 17367048, textArray);
            arrayAdapter.setDropDownViewResource(g.support_simple_spinner_dropdown_item);
            setAdapter(arrayAdapter);
        }
        a2.recycle();
        this.alf = true;
        if (this.ale != null) {
            setAdapter(this.ale);
            this.ale = null;
        }
        this.akh.a(attributeSet, i);
    }

    public Context getPopupContext() {
        if (this.alg != null) {
            return this.ahu;
        }
        if (VERSION.SDK_INT >= 23) {
            return super.getPopupContext();
        }
        return null;
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.alg != null) {
            this.alg.setBackgroundDrawable(drawable);
        } else if (VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(pn.c(getPopupContext(), i));
    }

    public Drawable getPopupBackground() {
        if (this.alg != null) {
            return this.alg.getBackground();
        }
        if (VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    public void setDropDownVerticalOffset(int i) {
        if (this.alg != null) {
            this.alg.setVerticalOffset(i);
        } else if (VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public int getDropDownVerticalOffset() {
        if (this.alg != null) {
            return this.alg.getVerticalOffset();
        }
        if (VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    public void setDropDownHorizontalOffset(int i) {
        if (this.alg != null) {
            this.alg.setHorizontalOffset(i);
        } else if (VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public int getDropDownHorizontalOffset() {
        if (this.alg != null) {
            return this.alg.getHorizontalOffset();
        }
        if (VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    public void setDropDownWidth(int i) {
        if (this.alg != null) {
            this.alh = i;
        } else if (VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    public int getDropDownWidth() {
        if (this.alg != null) {
            return this.alh;
        }
        if (VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.alf) {
            super.setAdapter(spinnerAdapter);
            if (this.alg != null) {
                this.alg.setAdapter(new C1212a(spinnerAdapter, (this.ahu == null ? getContext() : this.ahu).getTheme()));
                return;
            }
            return;
        }
        this.ale = spinnerAdapter;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.alg != null && this.alg.isShowing()) {
            this.alg.dismiss();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.afd == null || !this.afd.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.alg != null && MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), m2212a(getAdapter(), getBackground())), MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public boolean performClick() {
        if (this.alg == null) {
            return super.performClick();
        }
        if (!this.alg.isShowing()) {
            this.alg.show();
        }
        return true;
    }

    public void setPrompt(CharSequence charSequence) {
        if (this.alg != null) {
            this.alg.m2208p(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public CharSequence getPrompt() {
        return this.alg != null ? this.alg.oz() : super.getPrompt();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.akh != null) {
            this.akh.cQ(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.akh != null) {
            this.akh.o(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.akh != null) {
            this.akh.setSupportBackgroundTintList(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.akh != null ? this.akh.getSupportBackgroundTintList() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.akh != null) {
            this.akh.setSupportBackgroundTintMode(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.akh != null ? this.akh.getSupportBackgroundTintMode() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.akh != null) {
            this.akh.op();
        }
    }

    int m2212a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int max2 = Math.max(0, max - (15 - (min - max)));
        View view = null;
        int i = 0;
        max = 0;
        while (max2 < min) {
            View view2;
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != max) {
                view2 = null;
            } else {
                itemViewType = max;
                view2 = view;
            }
            view = spinnerAdapter.getView(max2, view2, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i = Math.max(i, view.getMeasuredWidth());
            max2++;
            max = itemViewType;
        }
        if (drawable == null) {
            return i;
        }
        drawable.getPadding(this.uU);
        return (this.uU.left + this.uU.right) + i;
    }
}
