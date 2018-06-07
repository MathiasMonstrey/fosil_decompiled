package com.portfolio.platform.ui.widget;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fossil.dgy;
import com.fossil.dy;
import com.fossil.dy.a;
import com.fossil.gn;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.microapp.PusherConfiguration.Pusher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PresetGroupLayout extends RelativeLayout implements OnClickListener {
    private static final String TAG = PresetGroupLayout.class.getSimpleName();
    private int arr;
    private View cUZ;
    private List<Pusher> cYp;
    private int ddU;
    private int ddV;
    private final int ddW;
    private int ddX;
    private int ddY;
    private int ddZ;
    private int dea;
    private int deb;
    private int dec;
    private ArrayList<PresetLayout> ded;
    private PresetLayout dee;
    private PresetLayout def;
    private PresetLayout deg;
    private dy deh;
    private dy dei;
    private dy dej;
    private View dek;
    private View del;
    private View dem;
    private TextView den;
    private TextView deo;
    private TextView dep;
    private TextView deq;
    private TextView der;
    private TextView des;
    private int det;
    private float deu;
    private C4968a dev;
    private int mAction;

    class C49622 extends dgy {
        final /* synthetic */ PresetGroupLayout dey;

        C49622(PresetGroupLayout presetGroupLayout) {
            this.dey = presetGroupLayout;
        }

        protected boolean m15769a(View view, String str) {
            MFLogger.d(PresetGroupLayout.TAG, "Setting local image to microAppId=" + str + "TOP_PUSHER");
            this.dey.m15786b(this.dey.dee);
            return this.dey.dev.m15772c(str, Pusher.TOP_PUSHER);
        }

        protected boolean aof() {
            MFLogger.d(PresetGroupLayout.TAG, "onSwapPreset to TOP_PUSHER");
            this.dey.m15808do(false);
            this.dey.aud();
            this.dey.dev.ak(this.dey.cYp);
            return true;
        }

        protected void iw(String str) {
            MFLogger.d(PresetGroupLayout.TAG, "onDragEnter TOP_PUSHER");
            Object obj = -1;
            switch (str.hashCode()) {
                case -1787728117:
                    if (str.equals("SWAP_PRESET")) {
                        obj = null;
                        break;
                    }
                    break;
                case -1602256410:
                    if (str.equals("MICRO_APP")) {
                        obj = 1;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    this.dey.m15798g(Pusher.TOP_PUSHER);
                    return;
                case 1:
                    this.dey.m15781a(this.dey.dee);
                    return;
                default:
                    return;
            }
        }

        protected void ix(String str) {
            MFLogger.d(PresetGroupLayout.TAG, "onDragExit type=" + str);
            Object obj = -1;
            switch (str.hashCode()) {
                case -1787728117:
                    if (str.equals("SWAP_PRESET")) {
                        obj = null;
                        break;
                    }
                    break;
                case -1602256410:
                    if (str.equals("MICRO_APP")) {
                        obj = 1;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    MFLogger.d(PresetGroupLayout.TAG, "onDragExit clear list");
                    return;
                case 1:
                    this.dey.m15786b(this.dey.dee);
                    return;
                default:
                    return;
            }
        }

        protected void aog() {
            this.dey.m15808do(true);
            this.dey.aud();
            this.dey.clearAnimation();
            this.dey.dev.aow();
        }
    }

    class C49633 extends dgy {
        final /* synthetic */ PresetGroupLayout dey;

        C49633(PresetGroupLayout presetGroupLayout) {
            this.dey = presetGroupLayout;
        }

        protected boolean m15770a(View view, String str) {
            MFLogger.d(PresetGroupLayout.TAG, "Setting local image to microAppId=" + str + " MID_PUSHER");
            this.dey.m15786b(this.dey.def);
            return this.dey.dev.m15772c(str, Pusher.MID_PUSHER);
        }

        protected boolean aof() {
            MFLogger.d(PresetGroupLayout.TAG, "onSwapPreset to MID_PUSHER");
            this.dey.m15808do(false);
            this.dey.aud();
            this.dey.dev.ak(this.dey.cYp);
            return true;
        }

        protected void iw(String str) {
            MFLogger.d(PresetGroupLayout.TAG, "onDragEnter MID_PUSHER");
            Object obj = -1;
            switch (str.hashCode()) {
                case -1787728117:
                    if (str.equals("SWAP_PRESET")) {
                        obj = null;
                        break;
                    }
                    break;
                case -1602256410:
                    if (str.equals("MICRO_APP")) {
                        obj = 1;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    this.dey.m15798g(Pusher.MID_PUSHER);
                    return;
                case 1:
                    this.dey.m15781a(this.dey.def);
                    return;
                default:
                    return;
            }
        }

        protected void ix(String str) {
            Object obj = -1;
            switch (str.hashCode()) {
                case -1787728117:
                    if (str.equals("SWAP_PRESET")) {
                        obj = null;
                        break;
                    }
                    break;
                case -1602256410:
                    if (str.equals("MICRO_APP")) {
                        obj = 1;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case 1:
                    this.dey.m15786b(this.dey.def);
                    return;
                default:
                    return;
            }
        }

        protected void aog() {
            this.dey.m15808do(true);
            this.dey.aud();
            this.dey.clearAnimation();
            this.dey.dev.aow();
        }
    }

    class C49644 extends dgy {
        final /* synthetic */ PresetGroupLayout dey;

        C49644(PresetGroupLayout presetGroupLayout) {
            this.dey = presetGroupLayout;
        }

        protected boolean m15771a(View view, String str) {
            MFLogger.d(PresetGroupLayout.TAG, "Setting local image to microAppId=" + str + "BOTTOM_PUSHER");
            this.dey.m15786b(this.dey.deg);
            return this.dey.dev.m15772c(str, Pusher.BOTTOM_PUSHER);
        }

        protected boolean aof() {
            MFLogger.d(PresetGroupLayout.TAG, "onSwapPreset to BOTTOM_PUSHER");
            this.dey.m15808do(false);
            this.dey.aud();
            this.dey.dev.ak(this.dey.cYp);
            return true;
        }

        protected void iw(String str) {
            MFLogger.d(PresetGroupLayout.TAG, "onDragEnter BOTTOM_PUSHER");
            Object obj = -1;
            switch (str.hashCode()) {
                case -1787728117:
                    if (str.equals("SWAP_PRESET")) {
                        obj = null;
                        break;
                    }
                    break;
                case -1602256410:
                    if (str.equals("MICRO_APP")) {
                        obj = 1;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    this.dey.m15798g(Pusher.BOTTOM_PUSHER);
                    return;
                case 1:
                    this.dey.m15781a(this.dey.deg);
                    return;
                default:
                    return;
            }
        }

        protected void ix(String str) {
            Object obj = -1;
            switch (str.hashCode()) {
                case -1787728117:
                    if (str.equals("SWAP_PRESET")) {
                        obj = null;
                        break;
                    }
                    break;
                case -1602256410:
                    if (str.equals("MICRO_APP")) {
                        obj = 1;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case 1:
                    this.dey.m15786b(this.dey.deg);
                    return;
                default:
                    return;
            }
        }

        protected void aog() {
            this.dey.m15808do(true);
            this.dey.aud();
            this.dey.clearAnimation();
            this.dey.dev.aow();
        }
    }

    class C49665 implements OnGlobalLayoutListener {
        final /* synthetic */ PresetGroupLayout dey;

        class C49651 implements OnTouchListener {
            final /* synthetic */ C49665 deA;

            C49651(C49665 c49665) {
                this.deA = c49665;
            }

            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                this.deA.dey.mAction = motionEvent.getAction();
                this.deA.dey.auf();
                return false;
            }
        }

        C49665(PresetGroupLayout presetGroupLayout) {
            this.dey = presetGroupLayout;
        }

        public void onGlobalLayout() {
            this.dey.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            int width = this.dey.getWidth();
            this.dey.ddV = this.dey.dek.getWidth();
            this.dey.ddU = this.dey.dek.getHeight();
            int h = ((width / 3) - this.dey.ddV) / 2;
            this.dey.ddX = h - this.dey.dee.getLeft();
            this.dey.ddY = ((width / 3) + h) - this.dey.def.getLeft();
            this.dey.ddZ = (((width * 2) / 3) + h) - this.dey.deg.getLeft();
            this.dey.dea = this.dey.dek.getTop() + (this.dey.ddU / 2);
            this.dey.deb = this.dey.del.getTop() + (this.dey.ddU / 2);
            this.dey.dec = this.dey.dem.getTop() + (this.dey.ddU / 2);
            this.dey.requestLayout();
            OnTouchListener c49651 = new C49651(this);
            this.dey.getRootView().findViewById(R.id.main_content).setOnTouchListener(c49651);
            this.dey.getRootView().findViewById(R.id.rlBottomView).setOnTouchListener(c49651);
        }
    }

    public interface C4968a {
        void ak(List<Pusher> list);

        void aow();

        boolean m15772c(String str, Pusher pusher);

        void m15773d(Pusher pusher);
    }

    public PresetGroupLayout(Context context) {
        this(context, null);
    }

    public PresetGroupLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PresetGroupLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ddU = 0;
        this.ddV = 0;
        this.ded = new ArrayList();
        this.ddW = getResources().getDimensionPixelSize(R.dimen.dp200);
        setWillNotDraw(false);
        LayoutInflater.from(context).inflate(R.layout.layout_preset_group, this, true);
        this.det = getResources().getDimensionPixelSize(R.dimen.dp3);
    }

    private dy m15776a(final PresetLayout presetLayout, final View view) {
        MFLogger.d(TAG, "setUpDraggableImage");
        a c49611 = new a(this) {
            final /* synthetic */ PresetGroupLayout dey;

            public boolean m15768a(View view, final dy dyVar) {
                MFLogger.d(PresetGroupLayout.TAG, "Drag start event received from helper.");
                this.dey.cYp = new ArrayList(Arrays.asList(new Pusher[]{Pusher.TOP_PUSHER, Pusher.MID_PUSHER, Pusher.BOTTOM_PUSHER}));
                this.dey.arr = this.dey.m15793f(Pusher.getPusherFromValue(view.getTag().toString()));
                presetLayout.findViewById(R.id.controlContainer).setVisibility(0);
                view.setVisibility(0);
                presetLayout.setAlpha(0.0f);
                presetLayout.setPresetBackground(this.dey.getResources().getColor(R.color.white));
                presetLayout.setDragging(true);
                DragShadowBuilder c49601 = new DragShadowBuilder(this, view) {
                    final /* synthetic */ C49611 dez;

                    public void onProvideShadowMetrics(Point point, Point point2) {
                        super.onProvideShadowMetrics(point, point2);
                        int width = getView().getWidth();
                        int height = getView().getHeight();
                        point.set(width, height);
                        point2.set(width / 2, height / 2);
                        dyVar.a(point2);
                        MFLogger.d(PresetGroupLayout.TAG, "View was touched at: " + point2);
                    }

                    public void onDrawShadow(Canvas canvas) {
                        if (getView() != null) {
                            getView().draw(canvas);
                        }
                    }
                };
                ClipData clipData = new ClipData(new ClipDescription("SWAP_PRESET", new String[]{"text/plain"}), new Item(view.getTag().toString()));
                MFLogger.d(PresetGroupLayout.TAG, "Created ClipDescription. Starting drag and drop.");
                if (VERSION.SDK_INT >= 24) {
                    return view.startDragAndDrop(clipData, c49601, null, 257);
                }
                return view.startDrag(clipData, c49601, null, 257);
            }
        };
        MFLogger.d(TAG, "DragStartHelper attached to view.");
        return new dy(presetLayout, c49611);
    }

    private int m15793f(Pusher pusher) {
        MFLogger.d(TAG, "getPositionByPusher pusher=" + pusher.getValue());
        switch (pusher) {
            case TOP_PUSHER:
                return 0;
            case MID_PUSHER:
                return 1;
            case BOTTOM_PUSHER:
                return 2;
            default:
                return -1;
        }
    }

    public void setListener(C4968a c4968a) {
        this.dev = c4968a;
    }

    public PresetLayout getTopPreset() {
        return this.dee;
    }

    public PresetLayout getMidPreset() {
        return this.def;
    }

    public PresetLayout getBotPreset() {
        return this.deg;
    }

    private void auc() {
        OnDragListener c49622 = new C49622(this);
        OnDragListener c49633 = new C49633(this);
        OnDragListener c49644 = new C49644(this);
        this.dee.setDragListener(c49622);
        this.def.setDragListener(c49633);
        this.deg.setDragListener(c49644);
    }

    private void m15798g(Pusher pusher) {
        int f = m15793f(pusher);
        Pusher pusher2 = (Pusher) this.cYp.get(f);
        if (this.arr != f) {
            m15801h(pusher2).m15810a(lv(this.arr), m15801h(pusher).getTop(), 300);
            MFLogger.d(TAG, "onDragEnter target=" + this.arr);
            m15779a(f, this.arr, this.cYp);
            this.arr = m15793f(pusher);
            MFLogger.d(TAG, "onDragEnter target=" + this.arr);
        }
    }

    private PresetLayout m15801h(Pusher pusher) {
        MFLogger.d(TAG, "getPresetLayoutByPusher pusher=" + pusher.getValue());
        switch (pusher) {
            case TOP_PUSHER:
                return this.dee;
            case MID_PUSHER:
                return this.def;
            case BOTTOM_PUSHER:
                return this.deg;
            default:
                return this.dee;
        }
    }

    private int lv(int i) {
        MFLogger.d(TAG, "getTranslatePosition position=" + i);
        switch (i) {
            case 0:
                return this.dee.getTop();
            case 1:
                return this.def.getTop();
            case 2:
                return this.deg.getTop();
            default:
                return this.dee.getTop();
        }
    }

    private void m15779a(int i, int i2, List<Pusher> list) {
        MFLogger.d(TAG, "swapPosition start=" + i + " end=" + i2 + " pusherList[0]=" + list.get(0) + " pusherList[1]=" + list.get(1) + " pusherList[2]=" + list.get(2));
        Collections.swap(list, i, i2);
        MFLogger.d(TAG, "swapPosition pusherList[0]=" + list.get(0) + " pusherList[1]=" + list.get(1) + " pusherList[2]=" + list.get(2));
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.dee = (PresetLayout) findViewById(R.id.view_top_button);
        this.def = (PresetLayout) findViewById(R.id.view_middle_button);
        this.deg = (PresetLayout) findViewById(R.id.view_bottom_button);
        this.den = (TextView) this.dee.findViewById(R.id.tv_button);
        this.deo = (TextView) this.dee.findViewById(R.id.tv_feature);
        this.dep = (TextView) this.def.findViewById(R.id.tv_button);
        this.deq = (TextView) this.def.findViewById(R.id.tv_feature);
        this.der = (TextView) this.deg.findViewById(R.id.tv_button);
        this.des = (TextView) this.deg.findViewById(R.id.tv_feature);
        this.dek = findViewById(R.id.view_top_button_bg);
        this.del = findViewById(R.id.view_mid_button_bg);
        this.dem = findViewById(R.id.view_bot_button_bg);
        this.dee.setButtonName(R.string.Shortcuts_Landing_Label__Top_Button);
        this.def.setButtonName(R.string.Shortcuts_Landing_Label_Middle_Button);
        this.deg.setButtonName(R.string.Shortcuts_Landing_Label_Bottom_Button);
        this.dee.setTag(Pusher.TOP_PUSHER.getValue());
        this.deh = m15776a(this.dee, this.dek);
        this.def.setTag(Pusher.MID_PUSHER.getValue());
        this.dei = m15776a(this.def, this.del);
        this.deg.setTag(Pusher.BOTTOM_PUSHER.getValue());
        this.dej = m15776a(this.deg, this.dem);
        dn(true);
        this.ded.add(this.dee);
        this.ded.add(this.def);
        this.ded.add(this.deg);
        this.dee.setOnClickListener(this);
        this.def.setOnClickListener(this);
        this.deg.setOnClickListener(this);
        getViewTreeObserver().addOnGlobalLayoutListener(new C49665(this));
        auc();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.view_top_button:
                this.dev.m15773d(Pusher.TOP_PUSHER);
                return;
            case R.id.view_middle_button:
                this.dev.m15773d(Pusher.MID_PUSHER);
                return;
            case R.id.view_bottom_button:
                this.dev.m15773d(Pusher.BOTTOM_PUSHER);
                return;
            default:
                return;
        }
    }

    public void dn(boolean z) {
        if (z) {
            this.deh.hG();
            this.dei.hG();
            this.dej.hG();
            return;
        }
        this.deh.detach();
        this.dei.detach();
        this.dej.detach();
    }

    public void setAnimationProgress(float f) {
        MFLogger.d(TAG, "setAnimationProgress progress=" + f);
        this.deu = f;
        int i = (int) (((float) this.ddU) + (((float) (this.ddW - this.ddU)) * f));
        this.dee.setTranslationX(((float) this.ddX) * f);
        this.dee.setTranslationY(((float) ((i / 2) - this.dea)) * f);
        this.dee.measure(MeasureSpec.makeMeasureSpec(this.ddV, 1073741824), MeasureSpec.makeMeasureSpec(i, 1073741824));
        this.dee.layout(this.dee.getLeft(), this.dea - (i / 2), this.dee.getRight(), this.dea + (i / 2));
        this.def.setTranslationX(((float) this.ddY) * f);
        this.def.setTranslationY(((float) ((i / 2) - this.deb)) * f);
        this.def.measure(MeasureSpec.makeMeasureSpec(this.ddV, 1073741824), MeasureSpec.makeMeasureSpec(i, 1073741824));
        this.def.layout(this.def.getLeft(), this.deb - (i / 2), this.def.getRight(), this.deb + (i / 2));
        this.deg.setTranslationX(((float) this.ddZ) * f);
        this.deg.setTranslationY(((float) ((i / 2) - this.dec)) * f);
        this.deg.measure(MeasureSpec.makeMeasureSpec(this.ddV, 1073741824), MeasureSpec.makeMeasureSpec(i, 1073741824));
        this.deg.layout(this.deg.getLeft(), this.dec - (i / 2), this.deg.getRight(), (i / 2) + this.dec);
        Iterator it = this.ded.iterator();
        while (it.hasNext()) {
            ((PresetLayout) it.next()).setAnimationProgress(f);
        }
        auf();
    }

    private void m15781a(PresetLayout presetLayout) {
        presetLayout.cUW.startAnimation(AnimationUtils.loadAnimation(presetLayout.getContext(), R.anim.hover_in_animation));
        presetLayout.deE.startAnimation(AnimationUtils.loadAnimation(presetLayout.getContext(), R.anim.preset_txt_hover_in_anim));
    }

    private void m15786b(PresetLayout presetLayout) {
        presetLayout.cUW.startAnimation(AnimationUtils.loadAnimation(presetLayout.getContext(), R.anim.hover_out_animation));
        presetLayout.deE.startAnimation(AnimationUtils.loadAnimation(presetLayout.getContext(), R.anim.preset_txt_hover_out_anim));
    }

    public void m15808do(boolean z) {
        MFLogger.d(TAG, "hideAllControl");
        PresetLayout presetLayout = this.dee;
        for (int i = 0; i < this.ded.size(); i++) {
            PresetLayout presetLayout2 = (PresetLayout) this.ded.get(i);
            presetLayout2.findViewById(R.id.controlContainer).setVisibility(8);
            if (i == this.arr && !z) {
                presetLayout = presetLayout2;
            }
            presetLayout2.setAlpha(1.0f);
        }
        if (!z) {
            presetLayout2 = m15801h((Pusher) this.cYp.get(this.arr));
            presetLayout2.m15810a(presetLayout.getTop(), presetLayout2.getTop(), 10);
        }
        invalidate();
    }

    private void aud() {
        this.dee.setPresetBackground(getResources().getColor(R.color.transparent));
        this.def.setPresetBackground(getResources().getColor(R.color.transparent));
        this.deg.setPresetBackground(getResources().getColor(R.color.transparent));
        this.dee.setDragging(false);
        this.def.setDragging(false);
        this.deg.setDragging(false);
        this.dek.setVisibility(4);
        this.del.setVisibility(4);
        this.dem.setVisibility(4);
    }

    public void aoT() {
        MFLogger.d(TAG, "showOverlayLayout");
        if (this.cUZ == null) {
            this.cUZ = new View(getContext());
            this.cUZ.setClickable(true);
            this.cUZ.setBackgroundColor(gn.e(getContext(), R.color.gray_30));
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(getMeasuredWidth(), getMeasuredHeight());
            layoutParams.addRule(9, -1);
            layoutParams.addRule(10, -1);
            addView(this.cUZ, layoutParams);
        }
    }

    public void aue() {
        if (this.cUZ != null) {
            removeView(this.cUZ);
            this.cUZ = null;
        }
    }

    private void auf() {
        if (this.deu == 0.0f && this.den.getMaxLines() != 1) {
            this.den.setGravity(8388611);
            this.deo.setGravity(8388611);
            this.den.setSingleLine();
            this.deo.setSingleLine();
            this.dep.setGravity(8388611);
            this.deq.setGravity(8388611);
            this.dep.setSingleLine();
            this.deq.setSingleLine();
            this.der.setGravity(8388611);
            this.des.setGravity(8388611);
            this.der.setSingleLine();
            this.des.setSingleLine();
            this.den.setPadding(0, 0, 0, 0);
            this.dep.setPadding(0, 0, 0, 0);
            this.der.setPadding(0, 0, 0, 0);
            this.deo.setPadding(0, 0, 0, 0);
            this.deq.setPadding(0, 0, 0, 0);
            this.des.setPadding(0, 0, 0, 0);
        } else if (this.deu == 1.0f && this.den.getMaxLines() == 1) {
            this.den.setGravity(1);
            this.deo.setGravity(1);
            this.den.setSingleLine(false);
            this.deo.setSingleLine(false);
            this.dep.setGravity(1);
            this.deq.setGravity(1);
            this.dep.setSingleLine(false);
            this.deq.setSingleLine(false);
            this.der.setGravity(1);
            this.des.setGravity(1);
            this.der.setSingleLine(false);
            this.des.setSingleLine(false);
            this.den.setPadding(this.det, 0, this.det, 0);
            this.dep.setPadding(this.det, 0, this.det, 0);
            this.der.setPadding(this.det, 0, this.det, 0);
            this.deo.setPadding(this.det, 0, this.det, 0);
            this.deq.setPadding(this.det, 0, this.det, 0);
            this.des.setPadding(this.det, 0, this.det, 0);
        }
    }

    public void clearAnimation() {
        super.clearAnimation();
        Iterator it = this.ded.iterator();
        while (it.hasNext()) {
            ((PresetLayout) it.next()).clearAnimation();
        }
    }
}
