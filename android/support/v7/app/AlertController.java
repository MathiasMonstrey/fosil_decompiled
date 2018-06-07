package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.NestedScrollView.C1178b;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.facebook.login.widget.ProfilePictureView;
import com.fossil.li;
import com.fossil.pc;
import com.fossil.pk.a;
import com.fossil.pk.f;
import com.fossil.pk.j;
import java.lang.ref.WeakReference;

public class AlertController {
    private Drawable AN;
    private ImageView BX;
    private CharSequence Od;
    final pc ZP;
    private final Window ZQ;
    private CharSequence ZR;
    ListView ZS;
    private int ZT;
    private int ZU;
    private int ZV;
    private int ZW;
    private int ZX;
    private boolean ZY = false;
    Button ZZ;
    private CharSequence aaa;
    Message aab;
    Button aac;
    private CharSequence aad;
    Message aae;
    Button aaf;
    private CharSequence aag;
    Message aah;
    NestedScrollView aai;
    private int aaj = 0;
    private TextView aak;
    private View aal;
    ListAdapter aam;
    int aan = -1;
    private int aao;
    private int aap;
    int aaq;
    int aar;
    int aas;
    int aat;
    private boolean aau;
    private int aav = 0;
    private final OnClickListener aaw = new C01421(this);
    private final Context mContext;
    Handler mHandler;
    private View mView;
    private TextView uW;

    class C01421 implements OnClickListener {
        final /* synthetic */ AlertController aax;

        C01421(AlertController alertController) {
            this.aax = alertController;
        }

        public void onClick(View view) {
            Message obtain;
            if (view == this.aax.ZZ && this.aax.aab != null) {
                obtain = Message.obtain(this.aax.aab);
            } else if (view == this.aax.aac && this.aax.aae != null) {
                obtain = Message.obtain(this.aax.aae);
            } else if (view != this.aax.aaf || this.aax.aah == null) {
                obtain = null;
            } else {
                obtain = Message.obtain(this.aax.aah);
            }
            if (obtain != null) {
                obtain.sendToTarget();
            }
            this.aax.mHandler.obtainMessage(1, this.aax.ZP).sendToTarget();
        }
    }

    public static class RecycleListView extends ListView {
        private final int aba;
        private final int abb;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.RecycleListView);
            this.abb = obtainStyledAttributes.getDimensionPixelOffset(j.RecycleListView_paddingBottomNoButtons, -1);
            this.aba = obtainStyledAttributes.getDimensionPixelOffset(j.RecycleListView_paddingTopNoTitle, -1);
        }

        public void m2162e(boolean z, boolean z2) {
            if (!z2 || !z) {
                setPadding(getPaddingLeft(), z ? getPaddingTop() : this.aba, getPaddingRight(), z2 ? getPaddingBottom() : this.abb);
            }
        }
    }

    public static class C1199a {
        public Drawable AN;
        public Cursor MC;
        public CharSequence Od;
        public final LayoutInflater Yg;
        public CharSequence ZR;
        public int ZT;
        public int ZU;
        public int ZV;
        public int ZW;
        public int ZX;
        public boolean ZY = false;
        public int aaA = 0;
        public CharSequence aaB;
        public DialogInterface.OnClickListener aaC;
        public CharSequence aaD;
        public DialogInterface.OnClickListener aaE;
        public CharSequence aaF;
        public DialogInterface.OnClickListener aaG;
        public OnCancelListener aaH;
        public OnDismissListener aaI;
        public OnKeyListener aaJ;
        public CharSequence[] aaK;
        public DialogInterface.OnClickListener aaL;
        public boolean[] aaM;
        public boolean aaN;
        public boolean aaO;
        public OnMultiChoiceClickListener aaP;
        public String aaQ;
        public String aaR;
        public C1198a aaS;
        public boolean aaT = true;
        public int aaj = 0;
        public View aal;
        public ListAdapter aam;
        public int aan = -1;
        public boolean mCancelable;
        public final Context mContext;
        public OnItemSelectedListener mOnItemSelectedListener;
        public View mView;

        public interface C1198a {
            void m2163a(ListView listView);
        }

        public C1199a(Context context) {
            this.mContext = context;
            this.mCancelable = true;
            this.Yg = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public void m2165a(AlertController alertController) {
            if (this.aal != null) {
                alertController.setCustomTitle(this.aal);
            } else {
                if (this.Od != null) {
                    alertController.setTitle(this.Od);
                }
                if (this.AN != null) {
                    alertController.setIcon(this.AN);
                }
                if (this.aaj != 0) {
                    alertController.setIcon(this.aaj);
                }
                if (this.aaA != 0) {
                    alertController.setIcon(alertController.cj(this.aaA));
                }
            }
            if (this.ZR != null) {
                alertController.setMessage(this.ZR);
            }
            if (this.aaB != null) {
                alertController.m2175a(-1, this.aaB, this.aaC, null);
            }
            if (this.aaD != null) {
                alertController.m2175a(-2, this.aaD, this.aaE, null);
            }
            if (this.aaF != null) {
                alertController.m2175a(-3, this.aaF, this.aaG, null);
            }
            if (!(this.aaK == null && this.MC == null && this.aam == null)) {
                m2164b(alertController);
            }
            if (this.mView != null) {
                if (this.ZY) {
                    alertController.setView(this.mView, this.ZU, this.ZV, this.ZW, this.ZX);
                    return;
                }
                alertController.setView(this.mView);
            } else if (this.ZT != 0) {
                alertController.ci(this.ZT);
            }
        }

        private void m2164b(final AlertController alertController) {
            ListAdapter simpleCursorAdapter;
            final RecycleListView recycleListView = (RecycleListView) this.Yg.inflate(alertController.aaq, null);
            if (!this.aaN) {
                int i;
                if (this.aaO) {
                    i = alertController.aas;
                } else {
                    i = alertController.aat;
                }
                if (this.MC != null) {
                    simpleCursorAdapter = new SimpleCursorAdapter(this.mContext, i, this.MC, new String[]{this.aaQ}, new int[]{16908308});
                } else if (this.aam != null) {
                    simpleCursorAdapter = this.aam;
                } else {
                    simpleCursorAdapter = new C1201c(this.mContext, i, 16908308, this.aaK);
                }
            } else if (this.MC == null) {
                simpleCursorAdapter = new ArrayAdapter<CharSequence>(this, this.mContext, alertController.aar, 16908308, this.aaK) {
                    final /* synthetic */ C1199a aaV;

                    public View getView(int i, View view, ViewGroup viewGroup) {
                        View view2 = super.getView(i, view, viewGroup);
                        if (this.aaV.aaM != null && this.aaV.aaM[i]) {
                            recycleListView.setItemChecked(i, true);
                        }
                        return view2;
                    }
                };
            } else {
                final AlertController alertController2 = alertController;
                Object c11952 = new CursorAdapter(this, this.mContext, this.MC, false) {
                    final /* synthetic */ C1199a aaV;
                    private final int aaW;
                    private final int aaX;

                    public void bindView(View view, Context context, Cursor cursor) {
                        ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.aaW));
                        recycleListView.setItemChecked(cursor.getPosition(), cursor.getInt(this.aaX) == 1);
                    }

                    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                        return this.aaV.Yg.inflate(alertController2.aar, viewGroup, false);
                    }
                };
            }
            if (this.aaS != null) {
                this.aaS.m2163a(recycleListView);
            }
            alertController.aam = simpleCursorAdapter;
            alertController.aan = this.aan;
            if (this.aaL != null) {
                recycleListView.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ C1199a aaV;

                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        this.aaV.aaL.onClick(alertController.ZP, i);
                        if (!this.aaV.aaO) {
                            alertController.ZP.dismiss();
                        }
                    }
                });
            } else if (this.aaP != null) {
                recycleListView.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ C1199a aaV;

                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        if (this.aaV.aaM != null) {
                            this.aaV.aaM[i] = recycleListView.isItemChecked(i);
                        }
                        this.aaV.aaP.onClick(alertController.ZP, i, recycleListView.isItemChecked(i));
                    }
                });
            }
            if (this.mOnItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(this.mOnItemSelectedListener);
            }
            if (this.aaO) {
                recycleListView.setChoiceMode(1);
            } else if (this.aaN) {
                recycleListView.setChoiceMode(2);
            }
            alertController.ZS = recycleListView;
        }
    }

    static final class C1200b extends Handler {
        private WeakReference<DialogInterface> aaZ;

        public C1200b(DialogInterface dialogInterface) {
            this.aaZ = new WeakReference(dialogInterface);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case ProfilePictureView.NORMAL /*-3*/:
                case -2:
                case -1:
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.aaZ.get(), message.what);
                    return;
                case 1:
                    ((DialogInterface) message.obj).dismiss();
                    return;
                default:
                    return;
            }
        }
    }

    static class C1201c extends ArrayAdapter<CharSequence> {
        public C1201c(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }

        public boolean hasStableIds() {
            return true;
        }

        public long getItemId(int i) {
            return (long) i;
        }
    }

    private static boolean m2174t(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(a.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            return true;
        }
        return false;
    }

    public AlertController(Context context, pc pcVar, Window window) {
        this.mContext = context;
        this.ZP = pcVar;
        this.ZQ = window;
        this.mHandler = new C1200b(pcVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, j.AlertDialog, a.alertDialogStyle, 0);
        this.aao = obtainStyledAttributes.getResourceId(j.AlertDialog_android_layout, 0);
        this.aap = obtainStyledAttributes.getResourceId(j.AlertDialog_buttonPanelSideLayout, 0);
        this.aaq = obtainStyledAttributes.getResourceId(j.AlertDialog_listLayout, 0);
        this.aar = obtainStyledAttributes.getResourceId(j.AlertDialog_multiChoiceItemLayout, 0);
        this.aas = obtainStyledAttributes.getResourceId(j.AlertDialog_singleChoiceItemLayout, 0);
        this.aat = obtainStyledAttributes.getResourceId(j.AlertDialog_listItemLayout, 0);
        this.aau = obtainStyledAttributes.getBoolean(j.AlertDialog_showTitle, true);
        obtainStyledAttributes.recycle();
        pcVar.cp(1);
    }

    static boolean bk(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (bk(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public void lk() {
        this.ZP.setContentView(ll());
        lm();
    }

    private int ll() {
        if (this.aap == 0) {
            return this.aao;
        }
        if (this.aav == 1) {
            return this.aap;
        }
        return this.aao;
    }

    public void setTitle(CharSequence charSequence) {
        this.Od = charSequence;
        if (this.aak != null) {
            this.aak.setText(charSequence);
        }
    }

    public void setCustomTitle(View view) {
        this.aal = view;
    }

    public void setMessage(CharSequence charSequence) {
        this.ZR = charSequence;
        if (this.uW != null) {
            this.uW.setText(charSequence);
        }
    }

    public void ci(int i) {
        this.mView = null;
        this.ZT = i;
        this.ZY = false;
    }

    public void setView(View view) {
        this.mView = view;
        this.ZT = 0;
        this.ZY = false;
    }

    public void setView(View view, int i, int i2, int i3, int i4) {
        this.mView = view;
        this.ZT = 0;
        this.ZY = true;
        this.ZU = i;
        this.ZV = i2;
        this.ZW = i3;
        this.ZX = i4;
    }

    public void m2175a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message) {
        if (message == null && onClickListener != null) {
            message = this.mHandler.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case ProfilePictureView.NORMAL /*-3*/:
                this.aag = charSequence;
                this.aah = message;
                return;
            case -2:
                this.aad = charSequence;
                this.aae = message;
                return;
            case -1:
                this.aaa = charSequence;
                this.aab = message;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void setIcon(int i) {
        this.AN = null;
        this.aaj = i;
        if (this.BX == null) {
            return;
        }
        if (i != 0) {
            this.BX.setVisibility(0);
            this.BX.setImageResource(this.aaj);
            return;
        }
        this.BX.setVisibility(8);
    }

    public void setIcon(Drawable drawable) {
        this.AN = drawable;
        this.aaj = 0;
        if (this.BX == null) {
            return;
        }
        if (drawable != null) {
            this.BX.setVisibility(0);
            this.BX.setImageDrawable(drawable);
            return;
        }
        this.BX.setVisibility(8);
    }

    public int cj(int i) {
        TypedValue typedValue = new TypedValue();
        this.mContext.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.aai != null && this.aai.executeKeyEvent(keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.aai != null && this.aai.executeKeyEvent(keyEvent);
    }

    private ViewGroup m2169c(View view, View view2) {
        View inflate;
        if (view == null) {
            if (view2 instanceof ViewStub) {
                inflate = ((ViewStub) view2).inflate();
            } else {
                inflate = view2;
            }
            return (ViewGroup) inflate;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            inflate = ((ViewStub) view).inflate();
        } else {
            inflate = view;
        }
        return (ViewGroup) inflate;
    }

    private void lm() {
        boolean z;
        boolean z2;
        View findViewById = this.ZQ.findViewById(f.parentPanel);
        View findViewById2 = findViewById.findViewById(f.topPanel);
        View findViewById3 = findViewById.findViewById(f.contentPanel);
        View findViewById4 = findViewById.findViewById(f.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(f.customPanel);
        m2170g(viewGroup);
        View findViewById5 = viewGroup.findViewById(f.topPanel);
        View findViewById6 = viewGroup.findViewById(f.contentPanel);
        View findViewById7 = viewGroup.findViewById(f.buttonPanel);
        ViewGroup c = m2169c(findViewById5, findViewById2);
        ViewGroup c2 = m2169c(findViewById6, findViewById3);
        ViewGroup c3 = m2169c(findViewById7, findViewById4);
        m2172i(c2);
        m2173j(c3);
        m2171h(c);
        boolean z3 = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        if (c == null || c.getVisibility() == 8) {
            z = false;
        } else {
            z = true;
        }
        if (c3 == null || c3.getVisibility() == 8) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!(z2 || c2 == null)) {
            findViewById = c2.findViewById(f.textSpacerNoButtons);
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
        }
        if (z) {
            if (this.aai != null) {
                this.aai.setClipToPadding(true);
            }
            findViewById = null;
            if (!((this.ZR == null && this.ZS == null && !z3) || z3)) {
                findViewById = c.findViewById(f.titleDividerNoCustom);
            }
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
        } else if (c2 != null) {
            findViewById = c2.findViewById(f.textSpacerNoTitle);
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
        }
        if (this.ZS instanceof RecycleListView) {
            ((RecycleListView) this.ZS).m2162e(z, z2);
        }
        if (!z3) {
            findViewById3 = this.ZS != null ? this.ZS : this.aai;
            if (findViewById3 != null) {
                int i;
                if (z) {
                    i = 1;
                } else {
                    i = 0;
                }
                m2167a(c2, findViewById3, (z2 ? 2 : 0) | i, 3);
            }
        }
        ListView listView = this.ZS;
        if (listView != null && this.aam != null) {
            listView.setAdapter(this.aam);
            int i2 = this.aan;
            if (i2 > -1) {
                listView.setItemChecked(i2, true);
                listView.setSelection(i2);
            }
        }
    }

    private void m2167a(ViewGroup viewGroup, View view, int i, int i2) {
        View view2 = null;
        View findViewById = this.ZQ.findViewById(f.scrollIndicatorUp);
        View findViewById2 = this.ZQ.findViewById(f.scrollIndicatorDown);
        if (VERSION.SDK_INT >= 23) {
            li.m12263f(view, i, i2);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        if (findViewById != null && (i & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 == null || (i & 2) != 0) {
            view2 = findViewById2;
        } else {
            viewGroup.removeView(findViewById2);
        }
        if (findViewById != null || view2 != null) {
            if (this.ZR != null) {
                this.aai.setOnScrollChangeListener(new C1178b(this) {
                    final /* synthetic */ AlertController aax;

                    public void mo111a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                        AlertController.m2166a(nestedScrollView, findViewById, view2);
                    }
                });
                this.aai.post(new Runnable(this) {
                    final /* synthetic */ AlertController aax;

                    public void run() {
                        AlertController.m2166a(this.aax.aai, findViewById, view2);
                    }
                });
            } else if (this.ZS != null) {
                this.ZS.setOnScrollListener(new OnScrollListener(this) {
                    final /* synthetic */ AlertController aax;

                    public void onScrollStateChanged(AbsListView absListView, int i) {
                    }

                    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                        AlertController.m2166a(absListView, findViewById, view2);
                    }
                });
                this.ZS.post(new Runnable(this) {
                    final /* synthetic */ AlertController aax;

                    public void run() {
                        AlertController.m2166a(this.aax.ZS, findViewById, view2);
                    }
                });
            } else {
                if (findViewById != null) {
                    viewGroup.removeView(findViewById);
                }
                if (view2 != null) {
                    viewGroup.removeView(view2);
                }
            }
        }
    }

    private void m2170g(ViewGroup viewGroup) {
        View view;
        boolean z = false;
        if (this.mView != null) {
            view = this.mView;
        } else if (this.ZT != 0) {
            view = LayoutInflater.from(this.mContext).inflate(this.ZT, viewGroup, false);
        } else {
            view = null;
        }
        if (view != null) {
            z = true;
        }
        if (!(z && bk(view))) {
            this.ZQ.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.ZQ.findViewById(f.custom);
            frameLayout.addView(view, new LayoutParams(-1, -1));
            if (this.ZY) {
                frameLayout.setPadding(this.ZU, this.ZV, this.ZW, this.ZX);
            }
            if (this.ZS != null) {
                ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void m2171h(ViewGroup viewGroup) {
        if (this.aal != null) {
            viewGroup.addView(this.aal, 0, new LayoutParams(-1, -2));
            this.ZQ.findViewById(f.title_template).setVisibility(8);
            return;
        }
        this.BX = (ImageView) this.ZQ.findViewById(16908294);
        if ((!TextUtils.isEmpty(this.Od) ? 1 : 0) == 0 || !this.aau) {
            this.ZQ.findViewById(f.title_template).setVisibility(8);
            this.BX.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        this.aak = (TextView) this.ZQ.findViewById(f.alertTitle);
        this.aak.setText(this.Od);
        if (this.aaj != 0) {
            this.BX.setImageResource(this.aaj);
        } else if (this.AN != null) {
            this.BX.setImageDrawable(this.AN);
        } else {
            this.aak.setPadding(this.BX.getPaddingLeft(), this.BX.getPaddingTop(), this.BX.getPaddingRight(), this.BX.getPaddingBottom());
            this.BX.setVisibility(8);
        }
    }

    private void m2172i(ViewGroup viewGroup) {
        this.aai = (NestedScrollView) this.ZQ.findViewById(f.scrollView);
        this.aai.setFocusable(false);
        this.aai.setNestedScrollingEnabled(false);
        this.uW = (TextView) viewGroup.findViewById(16908299);
        if (this.uW != null) {
            if (this.ZR != null) {
                this.uW.setText(this.ZR);
                return;
            }
            this.uW.setVisibility(8);
            this.aai.removeView(this.uW);
            if (this.ZS != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.aai.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.aai);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.ZS, indexOfChild, new LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    static void m2166a(View view, View view2, View view3) {
        int i = 0;
        if (view2 != null) {
            view2.setVisibility(li.m12271m(view, -1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!li.m12271m(view, 1)) {
                i = 4;
            }
            view3.setVisibility(i);
        }
    }

    private void m2173j(ViewGroup viewGroup) {
        int i;
        int i2 = 1;
        this.ZZ = (Button) viewGroup.findViewById(16908313);
        this.ZZ.setOnClickListener(this.aaw);
        if (TextUtils.isEmpty(this.aaa)) {
            this.ZZ.setVisibility(8);
            i = 0;
        } else {
            this.ZZ.setText(this.aaa);
            this.ZZ.setVisibility(0);
            i = 1;
        }
        this.aac = (Button) viewGroup.findViewById(16908314);
        this.aac.setOnClickListener(this.aaw);
        if (TextUtils.isEmpty(this.aad)) {
            this.aac.setVisibility(8);
        } else {
            this.aac.setText(this.aad);
            this.aac.setVisibility(0);
            i |= 2;
        }
        this.aaf = (Button) viewGroup.findViewById(16908315);
        this.aaf.setOnClickListener(this.aaw);
        if (TextUtils.isEmpty(this.aag)) {
            this.aaf.setVisibility(8);
        } else {
            this.aaf.setText(this.aag);
            this.aaf.setVisibility(0);
            i |= 4;
        }
        if (m2174t(this.mContext)) {
            if (i == 1) {
                m2168a(this.ZZ);
            } else if (i == 2) {
                m2168a(this.aac);
            } else if (i == 4) {
                m2168a(this.aaf);
            }
        }
        if (i == 0) {
            i2 = 0;
        }
        if (i2 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    private void m2168a(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }
}
