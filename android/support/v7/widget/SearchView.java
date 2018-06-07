package android.support.v7.widget;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.internal.NativeProtocol;
import com.fossil.hb;
import com.fossil.ix;
import com.fossil.iy;
import com.fossil.jy;
import com.fossil.kg;
import com.fossil.li;
import com.fossil.nk;
import com.fossil.pk.a;
import com.fossil.pk.d;
import com.fossil.pk.f;
import com.fossil.pk.g;
import com.fossil.pk.j;
import com.fossil.pv;
import com.fossil.sq;
import com.fossil.sw;
import com.fossil.tb;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView extends LinearLayoutCompat implements pv {
    static final boolean DBG = false;
    static final C1265a HIDDEN_METHOD_INVOKER = new C1265a();
    private static final String IME_OPTION_NO_MICROPHONE = "nm";
    static final String LOG_TAG = "SearchView";
    private Bundle mAppSearchData;
    private boolean mClearingFocus;
    final ImageView mCloseButton;
    private final ImageView mCollapsedIcon;
    private int mCollapsedImeOptions;
    private final CharSequence mDefaultQueryHint;
    private final View mDropDownAnchor;
    private boolean mExpandedInActionView;
    final ImageView mGoButton;
    private boolean mIconified;
    private boolean mIconifiedByDefault;
    private int mMaxWidth;
    private CharSequence mOldQueryText;
    private final OnClickListener mOnClickListener;
    private C1266b mOnCloseListener;
    private final OnEditorActionListener mOnEditorActionListener;
    private final OnItemClickListener mOnItemClickListener;
    private final OnItemSelectedListener mOnItemSelectedListener;
    private C1267c mOnQueryChangeListener;
    OnFocusChangeListener mOnQueryTextFocusChangeListener;
    private OnClickListener mOnSearchClickListener;
    private C1268d mOnSuggestionListener;
    private final WeakHashMap<String, ConstantState> mOutsideDrawablesCache;
    private CharSequence mQueryHint;
    private boolean mQueryRefinement;
    private Runnable mReleaseCursorRunnable;
    final ImageView mSearchButton;
    private final View mSearchEditFrame;
    private final Drawable mSearchHintIcon;
    private final View mSearchPlate;
    final SearchAutoComplete mSearchSrcTextView;
    private Rect mSearchSrcTextViewBounds;
    private Rect mSearchSrtTextViewBoundsExpanded;
    SearchableInfo mSearchable;
    private Runnable mShowImeRunnable;
    private final View mSubmitArea;
    private boolean mSubmitButtonEnabled;
    private final int mSuggestionCommitIconResId;
    private final int mSuggestionRowLayout;
    nk mSuggestionsAdapter;
    private int[] mTemp;
    private int[] mTemp2;
    OnKeyListener mTextKeyListener;
    private TextWatcher mTextWatcher;
    private C1271f mTouchDelegate;
    private final Runnable mUpdateDrawableStateRunnable;
    private CharSequence mUserQuery;
    private final Intent mVoiceAppSearchIntent;
    final ImageView mVoiceButton;
    private boolean mVoiceButtonEnabled;
    private final Intent mVoiceWebSearchIntent;

    class C02231 implements Runnable {
        final /* synthetic */ SearchView asQ;

        C02231(SearchView searchView) {
            this.asQ = searchView;
        }

        public void run() {
            InputMethodManager inputMethodManager = (InputMethodManager) this.asQ.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                SearchView.HIDDEN_METHOD_INVOKER.m2505a(inputMethodManager, this.asQ, 0);
            }
        }
    }

    class C02242 implements OnItemClickListener {
        final /* synthetic */ SearchView asQ;

        C02242(SearchView searchView) {
            this.asQ = searchView;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.asQ.onItemClicked(i, 0, null);
        }
    }

    class C02253 implements OnItemSelectedListener {
        final /* synthetic */ SearchView asQ;

        C02253(SearchView searchView) {
            this.asQ = searchView;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            this.asQ.onItemSelected(i);
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class C02264 implements TextWatcher {
        final /* synthetic */ SearchView asQ;

        C02264(SearchView searchView) {
            this.asQ = searchView;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.asQ.onTextChanged(charSequence);
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    class C02275 implements Runnable {
        final /* synthetic */ SearchView asQ;

        C02275(SearchView searchView) {
            this.asQ = searchView;
        }

        public void run() {
            this.asQ.updateFocusedState();
        }
    }

    class C02286 implements Runnable {
        final /* synthetic */ SearchView asQ;

        C02286(SearchView searchView) {
            this.asQ = searchView;
        }

        public void run() {
            if (this.asQ.mSuggestionsAdapter != null && (this.asQ.mSuggestionsAdapter instanceof sq)) {
                this.asQ.mSuggestionsAdapter.changeCursor(null);
            }
        }
    }

    class C02297 implements OnFocusChangeListener {
        final /* synthetic */ SearchView asQ;

        C02297(SearchView searchView) {
            this.asQ = searchView;
        }

        public void onFocusChange(View view, boolean z) {
            if (this.asQ.mOnQueryTextFocusChangeListener != null) {
                this.asQ.mOnQueryTextFocusChangeListener.onFocusChange(this.asQ, z);
            }
        }
    }

    class C02308 implements OnLayoutChangeListener {
        final /* synthetic */ SearchView asQ;

        C02308(SearchView searchView) {
            this.asQ = searchView;
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.asQ.adjustDropDownSizeAndPosition();
        }
    }

    class C02319 implements OnGlobalLayoutListener {
        final /* synthetic */ SearchView asQ;

        C02319(SearchView searchView) {
            this.asQ = searchView;
        }

        public void onGlobalLayout() {
            this.asQ.adjustDropDownSizeAndPosition();
        }
    }

    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {
        private int asW;
        private SearchView asX;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, a.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.asW = getThreshold();
        }

        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, (float) getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        void setSearchView(SearchView searchView) {
            this.asX = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.asW = i;
        }

        private boolean isEmpty() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        protected void replaceText(CharSequence charSequence) {
        }

        public void performCompletion() {
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.asX.hasFocus() && getVisibility() == 0) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                if (SearchView.isLandscapeMode(getContext())) {
                    SearchView.HIDDEN_METHOD_INVOKER.m2507a(this, true);
                }
            }
        }

        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.asX.onTextFocusChanged();
        }

        public boolean enoughToFilter() {
            return this.asW <= 0 || super.enoughToFilter();
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                DispatcherState keyDispatcherState;
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState == null) {
                        return true;
                    }
                    keyDispatcherState.startTracking(keyEvent, this);
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.asX.clearFocus();
                        this.asX.setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int b = hb.m11553b(getResources());
            int a = hb.m11552a(getResources());
            if (b >= 960 && a >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (b >= 600 || (b >= 640 && a >= 480)) {
                return 192;
            }
            return 160;
        }
    }

    static class C1265a {
        private Method asR;
        private Method asS;
        private Method asT;
        private Method asU;

        C1265a() {
            try {
                this.asR = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.asR.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            try {
                this.asS = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.asS.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            try {
                this.asT = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.asT.setAccessible(true);
            } catch (NoSuchMethodException e3) {
            }
            try {
                this.asU = InputMethodManager.class.getMethod("showSoftInputUnchecked", new Class[]{Integer.TYPE, ResultReceiver.class});
                this.asU.setAccessible(true);
            } catch (NoSuchMethodException e4) {
            }
        }

        void m2506a(AutoCompleteTextView autoCompleteTextView) {
            if (this.asR != null) {
                try {
                    this.asR.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        void m2508b(AutoCompleteTextView autoCompleteTextView) {
            if (this.asS != null) {
                try {
                    this.asS.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        void m2507a(AutoCompleteTextView autoCompleteTextView, boolean z) {
            if (this.asT != null) {
                try {
                    this.asT.invoke(autoCompleteTextView, new Object[]{Boolean.valueOf(z)});
                } catch (Exception e) {
                }
            }
        }

        void m2505a(InputMethodManager inputMethodManager, View view, int i) {
            if (this.asU != null) {
                try {
                    this.asU.invoke(inputMethodManager, new Object[]{Integer.valueOf(i), null});
                    return;
                } catch (Exception e) {
                }
            }
            inputMethodManager.showSoftInput(view, i);
        }
    }

    public interface C1266b {
        boolean onClose();
    }

    public interface C1267c {
        boolean onQueryTextChange(String str);

        boolean onQueryTextSubmit(String str);
    }

    public interface C1268d {
        boolean onSuggestionClick(int i);

        boolean onSuggestionSelect(int i);
    }

    static class C1270e extends jy {
        public static final Creator<C1270e> CREATOR = ix.m11854a(new C12691());
        boolean asV;

        static class C12691 implements iy<C1270e> {
            C12691() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return m2509n(parcel, classLoader);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return dI(i);
            }

            public C1270e m2509n(Parcel parcel, ClassLoader classLoader) {
                return new C1270e(parcel, classLoader);
            }

            public C1270e[] dI(int i) {
                return new C1270e[i];
            }
        }

        C1270e(Parcelable parcelable) {
            super(parcelable);
        }

        public C1270e(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.asV = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.asV));
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.asV + "}";
        }
    }

    static class C1271f extends TouchDelegate {
        private final View asY;
        private final Rect asZ = new Rect();
        private final Rect ata = new Rect();
        private final Rect atb = new Rect();
        private final int atc;
        private boolean atd;

        public C1271f(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.atc = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            m2510a(rect, rect2);
            this.asY = view;
        }

        public void m2510a(Rect rect, Rect rect2) {
            this.asZ.set(rect);
            this.atb.set(rect);
            this.atb.inset(-this.atc, -this.atc);
            this.ata.set(rect2);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouchEvent(android.view.MotionEvent r7) {
            /*
            r6 = this;
            r1 = 1;
            r0 = 0;
            r2 = r7.getX();
            r3 = (int) r2;
            r2 = r7.getY();
            r4 = (int) r2;
            r2 = r7.getAction();
            switch(r2) {
                case 0: goto L_0x003c;
                case 1: goto L_0x0048;
                case 2: goto L_0x0048;
                case 3: goto L_0x0056;
                default: goto L_0x0013;
            };
        L_0x0013:
            r2 = r0;
        L_0x0014:
            if (r2 == 0) goto L_0x003b;
        L_0x0016:
            if (r1 == 0) goto L_0x005b;
        L_0x0018:
            r0 = r6.ata;
            r0 = r0.contains(r3, r4);
            if (r0 != 0) goto L_0x005b;
        L_0x0020:
            r0 = r6.asY;
            r0 = r0.getWidth();
            r0 = r0 / 2;
            r0 = (float) r0;
            r1 = r6.asY;
            r1 = r1.getHeight();
            r1 = r1 / 2;
            r1 = (float) r1;
            r7.setLocation(r0, r1);
        L_0x0035:
            r0 = r6.asY;
            r0 = r0.dispatchTouchEvent(r7);
        L_0x003b:
            return r0;
        L_0x003c:
            r2 = r6.asZ;
            r2 = r2.contains(r3, r4);
            if (r2 == 0) goto L_0x0013;
        L_0x0044:
            r6.atd = r1;
            r2 = r1;
            goto L_0x0014;
        L_0x0048:
            r2 = r6.atd;
            if (r2 == 0) goto L_0x0014;
        L_0x004c:
            r5 = r6.atb;
            r5 = r5.contains(r3, r4);
            if (r5 != 0) goto L_0x0014;
        L_0x0054:
            r1 = r0;
            goto L_0x0014;
        L_0x0056:
            r2 = r6.atd;
            r6.atd = r0;
            goto L_0x0014;
        L_0x005b:
            r0 = r6.ata;
            r0 = r0.left;
            r0 = r3 - r0;
            r0 = (float) r0;
            r1 = r6.ata;
            r1 = r1.top;
            r1 = r4 - r1;
            r1 = (float) r1;
            r7.setLocation(r0, r1);
            goto L_0x0035;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SearchView.f.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSearchSrcTextViewBounds = new Rect();
        this.mSearchSrtTextViewBoundsExpanded = new Rect();
        this.mTemp = new int[2];
        this.mTemp2 = new int[2];
        this.mShowImeRunnable = new C02231(this);
        this.mUpdateDrawableStateRunnable = new C02275(this);
        this.mReleaseCursorRunnable = new C02286(this);
        this.mOutsideDrawablesCache = new WeakHashMap();
        this.mOnClickListener = new OnClickListener(this) {
            final /* synthetic */ SearchView asQ;

            {
                this.asQ = r1;
            }

            public void onClick(View view) {
                if (view == this.asQ.mSearchButton) {
                    this.asQ.onSearchClicked();
                } else if (view == this.asQ.mCloseButton) {
                    this.asQ.onCloseClicked();
                } else if (view == this.asQ.mGoButton) {
                    this.asQ.onSubmitQuery();
                } else if (view == this.asQ.mVoiceButton) {
                    this.asQ.onVoiceClicked();
                } else if (view == this.asQ.mSearchSrcTextView) {
                    this.asQ.forceSuggestionQuery();
                }
            }
        };
        this.mTextKeyListener = new OnKeyListener(this) {
            final /* synthetic */ SearchView asQ;

            {
                this.asQ = r1;
            }

            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (this.asQ.mSearchable == null) {
                    return false;
                }
                if (this.asQ.mSearchSrcTextView.isPopupShowing() && this.asQ.mSearchSrcTextView.getListSelection() != -1) {
                    return this.asQ.onSuggestionsKey(view, i, keyEvent);
                }
                if (this.asQ.mSearchSrcTextView.isEmpty() || !kg.m11963b(keyEvent) || keyEvent.getAction() != 1 || i != 66) {
                    return false;
                }
                view.cancelLongPress();
                this.asQ.launchQuerySearch(0, null, this.asQ.mSearchSrcTextView.getText().toString());
                return true;
            }
        };
        this.mOnEditorActionListener = new OnEditorActionListener(this) {
            final /* synthetic */ SearchView asQ;

            {
                this.asQ = r1;
            }

            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                this.asQ.onSubmitQuery();
                return true;
            }
        };
        this.mOnItemClickListener = new C02242(this);
        this.mOnItemSelectedListener = new C02253(this);
        this.mTextWatcher = new C02264(this);
        sw a = sw.a(context, attributeSet, j.SearchView, i, 0);
        LayoutInflater.from(context).inflate(a.getResourceId(j.SearchView_layout, g.abc_search_view), this, true);
        this.mSearchSrcTextView = (SearchAutoComplete) findViewById(f.search_src_text);
        this.mSearchSrcTextView.setSearchView(this);
        this.mSearchEditFrame = findViewById(f.search_edit_frame);
        this.mSearchPlate = findViewById(f.search_plate);
        this.mSubmitArea = findViewById(f.submit_area);
        this.mSearchButton = (ImageView) findViewById(f.search_button);
        this.mGoButton = (ImageView) findViewById(f.search_go_btn);
        this.mCloseButton = (ImageView) findViewById(f.search_close_btn);
        this.mVoiceButton = (ImageView) findViewById(f.search_voice_btn);
        this.mCollapsedIcon = (ImageView) findViewById(f.search_mag_icon);
        li.m12248a(this.mSearchPlate, a.getDrawable(j.SearchView_queryBackground));
        li.m12248a(this.mSubmitArea, a.getDrawable(j.SearchView_submitBackground));
        this.mSearchButton.setImageDrawable(a.getDrawable(j.SearchView_searchIcon));
        this.mGoButton.setImageDrawable(a.getDrawable(j.SearchView_goIcon));
        this.mCloseButton.setImageDrawable(a.getDrawable(j.SearchView_closeIcon));
        this.mVoiceButton.setImageDrawable(a.getDrawable(j.SearchView_voiceIcon));
        this.mCollapsedIcon.setImageDrawable(a.getDrawable(j.SearchView_searchIcon));
        this.mSearchHintIcon = a.getDrawable(j.SearchView_searchHintIcon);
        this.mSuggestionRowLayout = a.getResourceId(j.SearchView_suggestionRowLayout, g.abc_search_dropdown_item_icons_2line);
        this.mSuggestionCommitIconResId = a.getResourceId(j.SearchView_commitIcon, 0);
        this.mSearchButton.setOnClickListener(this.mOnClickListener);
        this.mCloseButton.setOnClickListener(this.mOnClickListener);
        this.mGoButton.setOnClickListener(this.mOnClickListener);
        this.mVoiceButton.setOnClickListener(this.mOnClickListener);
        this.mSearchSrcTextView.setOnClickListener(this.mOnClickListener);
        this.mSearchSrcTextView.addTextChangedListener(this.mTextWatcher);
        this.mSearchSrcTextView.setOnEditorActionListener(this.mOnEditorActionListener);
        this.mSearchSrcTextView.setOnItemClickListener(this.mOnItemClickListener);
        this.mSearchSrcTextView.setOnItemSelectedListener(this.mOnItemSelectedListener);
        this.mSearchSrcTextView.setOnKeyListener(this.mTextKeyListener);
        this.mSearchSrcTextView.setOnFocusChangeListener(new C02297(this));
        setIconifiedByDefault(a.getBoolean(j.SearchView_iconifiedByDefault, true));
        int dimensionPixelSize = a.getDimensionPixelSize(j.SearchView_android_maxWidth, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.mDefaultQueryHint = a.getText(j.SearchView_defaultQueryHint);
        this.mQueryHint = a.getText(j.SearchView_queryHint);
        dimensionPixelSize = a.getInt(j.SearchView_android_imeOptions, -1);
        if (dimensionPixelSize != -1) {
            setImeOptions(dimensionPixelSize);
        }
        dimensionPixelSize = a.getInt(j.SearchView_android_inputType, -1);
        if (dimensionPixelSize != -1) {
            setInputType(dimensionPixelSize);
        }
        setFocusable(a.getBoolean(j.SearchView_android_focusable, true));
        a.recycle();
        this.mVoiceWebSearchIntent = new Intent("android.speech.action.WEB_SEARCH");
        this.mVoiceWebSearchIntent.addFlags(268435456);
        this.mVoiceWebSearchIntent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.mVoiceAppSearchIntent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.mVoiceAppSearchIntent.addFlags(268435456);
        this.mDropDownAnchor = findViewById(this.mSearchSrcTextView.getDropDownAnchor());
        if (this.mDropDownAnchor != null) {
            if (VERSION.SDK_INT >= 11) {
                addOnLayoutChangeListenerToDropDownAnchorSDK11();
            } else {
                addOnLayoutChangeListenerToDropDownAnchorBase();
            }
        }
        updateViewsVisibility(this.mIconifiedByDefault);
        updateQueryHint();
    }

    @TargetApi(11)
    private void addOnLayoutChangeListenerToDropDownAnchorSDK11() {
        this.mDropDownAnchor.addOnLayoutChangeListener(new C02308(this));
    }

    private void addOnLayoutChangeListenerToDropDownAnchorBase() {
        this.mDropDownAnchor.getViewTreeObserver().addOnGlobalLayoutListener(new C02319(this));
    }

    public int getSuggestionRowLayout() {
        return this.mSuggestionRowLayout;
    }

    public int getSuggestionCommitIconResId() {
        return this.mSuggestionCommitIconResId;
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.mSearchable = searchableInfo;
        if (this.mSearchable != null) {
            updateSearchAutoComplete();
            updateQueryHint();
        }
        this.mVoiceButtonEnabled = hasVoiceSearch();
        if (this.mVoiceButtonEnabled) {
            this.mSearchSrcTextView.setPrivateImeOptions(IME_OPTION_NO_MICROPHONE);
        }
        updateViewsVisibility(isIconified());
    }

    public void setAppSearchData(Bundle bundle) {
        this.mAppSearchData = bundle;
    }

    public void setImeOptions(int i) {
        this.mSearchSrcTextView.setImeOptions(i);
    }

    public int getImeOptions() {
        return this.mSearchSrcTextView.getImeOptions();
    }

    public void setInputType(int i) {
        this.mSearchSrcTextView.setInputType(i);
    }

    public int getInputType() {
        return this.mSearchSrcTextView.getInputType();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.mClearingFocus || !isFocusable()) {
            return false;
        }
        if (isIconified()) {
            return super.requestFocus(i, rect);
        }
        boolean requestFocus = this.mSearchSrcTextView.requestFocus(i, rect);
        if (requestFocus) {
            updateViewsVisibility(false);
        }
        return requestFocus;
    }

    public void clearFocus() {
        this.mClearingFocus = true;
        setImeVisibility(false);
        super.clearFocus();
        this.mSearchSrcTextView.clearFocus();
        this.mClearingFocus = false;
    }

    public void setOnQueryTextListener(C1267c c1267c) {
        this.mOnQueryChangeListener = c1267c;
    }

    public void setOnCloseListener(C1266b c1266b) {
        this.mOnCloseListener = c1266b;
    }

    public void setOnQueryTextFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.mOnQueryTextFocusChangeListener = onFocusChangeListener;
    }

    public void setOnSuggestionListener(C1268d c1268d) {
        this.mOnSuggestionListener = c1268d;
    }

    public void setOnSearchClickListener(OnClickListener onClickListener) {
        this.mOnSearchClickListener = onClickListener;
    }

    public CharSequence getQuery() {
        return this.mSearchSrcTextView.getText();
    }

    public void setQuery(CharSequence charSequence, boolean z) {
        this.mSearchSrcTextView.setText(charSequence);
        if (charSequence != null) {
            this.mSearchSrcTextView.setSelection(this.mSearchSrcTextView.length());
            this.mUserQuery = charSequence;
        }
        if (z && !TextUtils.isEmpty(charSequence)) {
            onSubmitQuery();
        }
    }

    public void setQueryHint(CharSequence charSequence) {
        this.mQueryHint = charSequence;
        updateQueryHint();
    }

    public CharSequence getQueryHint() {
        if (this.mQueryHint != null) {
            return this.mQueryHint;
        }
        if (this.mSearchable == null || this.mSearchable.getHintId() == 0) {
            return this.mDefaultQueryHint;
        }
        return getContext().getText(this.mSearchable.getHintId());
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.mIconifiedByDefault != z) {
            this.mIconifiedByDefault = z;
            updateViewsVisibility(z);
            updateQueryHint();
        }
    }

    public boolean isIconfiedByDefault() {
        return this.mIconifiedByDefault;
    }

    public void setIconified(boolean z) {
        if (z) {
            onCloseClicked();
        } else {
            onSearchClicked();
        }
    }

    public boolean isIconified() {
        return this.mIconified;
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.mSubmitButtonEnabled = z;
        updateViewsVisibility(isIconified());
    }

    public boolean isSubmitButtonEnabled() {
        return this.mSubmitButtonEnabled;
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.mQueryRefinement = z;
        if (this.mSuggestionsAdapter instanceof sq) {
            ((sq) this.mSuggestionsAdapter).ek(z ? 2 : 1);
        }
    }

    public boolean isQueryRefinementEnabled() {
        return this.mQueryRefinement;
    }

    public void setSuggestionsAdapter(nk nkVar) {
        this.mSuggestionsAdapter = nkVar;
        this.mSearchSrcTextView.setAdapter(this.mSuggestionsAdapter);
    }

    public nk getSuggestionsAdapter() {
        return this.mSuggestionsAdapter;
    }

    public void setMaxWidth(int i) {
        this.mMaxWidth = i;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    protected void onMeasure(int i, int i2) {
        if (isIconified()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                if (this.mMaxWidth <= 0) {
                    size = Math.min(getPreferredWidth(), size);
                    break;
                } else {
                    size = Math.min(this.mMaxWidth, size);
                    break;
                }
            case 0:
                if (this.mMaxWidth <= 0) {
                    size = getPreferredWidth();
                    break;
                } else {
                    size = this.mMaxWidth;
                    break;
                }
            case 1073741824:
                if (this.mMaxWidth > 0) {
                    size = Math.min(this.mMaxWidth, size);
                    break;
                }
                break;
        }
        int mode2 = MeasureSpec.getMode(i2);
        mode = MeasureSpec.getSize(i2);
        switch (mode2) {
            case Integer.MIN_VALUE:
                mode = Math.min(getPreferredHeight(), mode);
                break;
            case 0:
                mode = getPreferredHeight();
                break;
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), MeasureSpec.makeMeasureSpec(mode, 1073741824));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            getChildBoundsWithinSearchView(this.mSearchSrcTextView, this.mSearchSrcTextViewBounds);
            this.mSearchSrtTextViewBoundsExpanded.set(this.mSearchSrcTextViewBounds.left, 0, this.mSearchSrcTextViewBounds.right, i4 - i2);
            if (this.mTouchDelegate == null) {
                this.mTouchDelegate = new C1271f(this.mSearchSrtTextViewBoundsExpanded, this.mSearchSrcTextViewBounds, this.mSearchSrcTextView);
                setTouchDelegate(this.mTouchDelegate);
                return;
            }
            this.mTouchDelegate.m2510a(this.mSearchSrtTextViewBoundsExpanded, this.mSearchSrcTextViewBounds);
        }
    }

    private void getChildBoundsWithinSearchView(View view, Rect rect) {
        view.getLocationInWindow(this.mTemp);
        getLocationInWindow(this.mTemp2);
        int i = this.mTemp[1] - this.mTemp2[1];
        int i2 = this.mTemp[0] - this.mTemp2[0];
        rect.set(i2, i, view.getWidth() + i2, view.getHeight() + i);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(d.abc_search_view_preferred_width);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(d.abc_search_view_preferred_height);
    }

    private void updateViewsVisibility(boolean z) {
        boolean z2;
        boolean z3 = true;
        int i = 8;
        this.mIconified = z;
        int i2 = z ? 0 : 8;
        if (TextUtils.isEmpty(this.mSearchSrcTextView.getText())) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.mSearchButton.setVisibility(i2);
        updateSubmitButton(z2);
        View view = this.mSearchEditFrame;
        if (z) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        view.setVisibility(i2);
        if (!(this.mCollapsedIcon.getDrawable() == null || this.mIconifiedByDefault)) {
            i = 0;
        }
        this.mCollapsedIcon.setVisibility(i);
        updateCloseButton();
        if (z2) {
            z3 = false;
        }
        updateVoiceButton(z3);
        updateSubmitArea();
    }

    private boolean hasVoiceSearch() {
        if (this.mSearchable == null || !this.mSearchable.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.mSearchable.getVoiceSearchLaunchWebSearch()) {
            intent = this.mVoiceWebSearchIntent;
        } else if (this.mSearchable.getVoiceSearchLaunchRecognizer()) {
            intent = this.mVoiceAppSearchIntent;
        }
        if (intent == null || getContext().getPackageManager().resolveActivity(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) == null) {
            return false;
        }
        return true;
    }

    private boolean isSubmitAreaEnabled() {
        return (this.mSubmitButtonEnabled || this.mVoiceButtonEnabled) && !isIconified();
    }

    private void updateSubmitButton(boolean z) {
        int i = 8;
        if (this.mSubmitButtonEnabled && isSubmitAreaEnabled() && hasFocus() && (z || !this.mVoiceButtonEnabled)) {
            i = 0;
        }
        this.mGoButton.setVisibility(i);
    }

    private void updateSubmitArea() {
        int i = 8;
        if (isSubmitAreaEnabled() && (this.mGoButton.getVisibility() == 0 || this.mVoiceButton.getVisibility() == 0)) {
            i = 0;
        }
        this.mSubmitArea.setVisibility(i);
    }

    private void updateCloseButton() {
        int i = 1;
        int i2 = 0;
        int i3 = !TextUtils.isEmpty(this.mSearchSrcTextView.getText()) ? 1 : 0;
        if (i3 == 0 && (!this.mIconifiedByDefault || this.mExpandedInActionView)) {
            i = 0;
        }
        ImageView imageView = this.mCloseButton;
        if (i == 0) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        Drawable drawable = this.mCloseButton.getDrawable();
        if (drawable != null) {
            drawable.setState(i3 != 0 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void postUpdateFocusedState() {
        post(this.mUpdateDrawableStateRunnable);
    }

    void updateFocusedState() {
        int[] iArr = this.mSearchSrcTextView.hasFocus() ? FOCUSED_STATE_SET : EMPTY_STATE_SET;
        Drawable background = this.mSearchPlate.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        background = this.mSubmitArea.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        invalidate();
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.mUpdateDrawableStateRunnable);
        post(this.mReleaseCursorRunnable);
        super.onDetachedFromWindow();
    }

    void setImeVisibility(boolean z) {
        if (z) {
            post(this.mShowImeRunnable);
            return;
        }
        removeCallbacks(this.mShowImeRunnable);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    public void onQueryRefine(CharSequence charSequence) {
        setQuery(charSequence);
    }

    boolean onSuggestionsKey(View view, int i, KeyEvent keyEvent) {
        if (this.mSearchable == null || this.mSuggestionsAdapter == null || keyEvent.getAction() != 0 || !kg.m11963b(keyEvent)) {
            return false;
        }
        if (i == 66 || i == 84 || i == 61) {
            return onItemClicked(this.mSearchSrcTextView.getListSelection(), 0, null);
        }
        if (i != 21 && i != 22) {
            return (i == 19 && this.mSearchSrcTextView.getListSelection() == 0) ? false : false;
        } else {
            int i2;
            if (i == 21) {
                i2 = 0;
            } else {
                i2 = this.mSearchSrcTextView.length();
            }
            this.mSearchSrcTextView.setSelection(i2);
            this.mSearchSrcTextView.setListSelection(0);
            this.mSearchSrcTextView.clearListSelection();
            HIDDEN_METHOD_INVOKER.m2507a(this.mSearchSrcTextView, true);
            return true;
        }
    }

    private CharSequence getDecoratedHint(CharSequence charSequence) {
        if (!this.mIconifiedByDefault || this.mSearchHintIcon == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.mSearchSrcTextView.getTextSize()) * 1.25d);
        this.mSearchHintIcon.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.mSearchHintIcon), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private void updateQueryHint() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.mSearchSrcTextView;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(getDecoratedHint(queryHint));
    }

    private void updateSearchAutoComplete() {
        int i = 1;
        this.mSearchSrcTextView.setThreshold(this.mSearchable.getSuggestThreshold());
        this.mSearchSrcTextView.setImeOptions(this.mSearchable.getImeOptions());
        int inputType = this.mSearchable.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.mSearchable.getSuggestAuthority() != null) {
                inputType = (inputType | NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) | 524288;
            }
        }
        this.mSearchSrcTextView.setInputType(inputType);
        if (this.mSuggestionsAdapter != null) {
            this.mSuggestionsAdapter.changeCursor(null);
        }
        if (this.mSearchable.getSuggestAuthority() != null) {
            this.mSuggestionsAdapter = new sq(getContext(), this, this.mSearchable, this.mOutsideDrawablesCache);
            this.mSearchSrcTextView.setAdapter(this.mSuggestionsAdapter);
            sq sqVar = (sq) this.mSuggestionsAdapter;
            if (this.mQueryRefinement) {
                i = 2;
            }
            sqVar.ek(i);
        }
    }

    private void updateVoiceButton(boolean z) {
        int i;
        if (this.mVoiceButtonEnabled && !isIconified() && z) {
            i = 0;
            this.mGoButton.setVisibility(8);
        } else {
            i = 8;
        }
        this.mVoiceButton.setVisibility(i);
    }

    void onTextChanged(CharSequence charSequence) {
        boolean z = true;
        CharSequence text = this.mSearchSrcTextView.getText();
        this.mUserQuery = text;
        boolean z2 = !TextUtils.isEmpty(text);
        updateSubmitButton(z2);
        if (z2) {
            z = false;
        }
        updateVoiceButton(z);
        updateCloseButton();
        updateSubmitArea();
        if (!(this.mOnQueryChangeListener == null || TextUtils.equals(charSequence, this.mOldQueryText))) {
            this.mOnQueryChangeListener.onQueryTextChange(charSequence.toString());
        }
        this.mOldQueryText = charSequence.toString();
    }

    void onSubmitQuery() {
        CharSequence text = this.mSearchSrcTextView.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.mOnQueryChangeListener == null || !this.mOnQueryChangeListener.onQueryTextSubmit(text.toString())) {
                if (this.mSearchable != null) {
                    launchQuerySearch(0, null, text.toString());
                }
                setImeVisibility(false);
                dismissSuggestions();
            }
        }
    }

    private void dismissSuggestions() {
        this.mSearchSrcTextView.dismissDropDown();
    }

    void onCloseClicked() {
        if (!TextUtils.isEmpty(this.mSearchSrcTextView.getText())) {
            this.mSearchSrcTextView.setText("");
            this.mSearchSrcTextView.requestFocus();
            setImeVisibility(true);
        } else if (!this.mIconifiedByDefault) {
        } else {
            if (this.mOnCloseListener == null || !this.mOnCloseListener.onClose()) {
                clearFocus();
                updateViewsVisibility(true);
            }
        }
    }

    void onSearchClicked() {
        updateViewsVisibility(false);
        this.mSearchSrcTextView.requestFocus();
        setImeVisibility(true);
        if (this.mOnSearchClickListener != null) {
            this.mOnSearchClickListener.onClick(this);
        }
    }

    void onVoiceClicked() {
        if (this.mSearchable != null) {
            SearchableInfo searchableInfo = this.mSearchable;
            try {
                if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                    getContext().startActivity(createVoiceWebSearchIntent(this.mVoiceWebSearchIntent, searchableInfo));
                } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    getContext().startActivity(createVoiceAppSearchIntent(this.mVoiceAppSearchIntent, searchableInfo));
                }
            } catch (ActivityNotFoundException e) {
                Log.w(LOG_TAG, "Could not find voice search activity");
            }
        }
    }

    void onTextFocusChanged() {
        updateViewsVisibility(isIconified());
        postUpdateFocusedState();
        if (this.mSearchSrcTextView.hasFocus()) {
            forceSuggestionQuery();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        postUpdateFocusedState();
    }

    public void onActionViewCollapsed() {
        setQuery("", false);
        clearFocus();
        updateViewsVisibility(true);
        this.mSearchSrcTextView.setImeOptions(this.mCollapsedImeOptions);
        this.mExpandedInActionView = false;
    }

    public void onActionViewExpanded() {
        if (!this.mExpandedInActionView) {
            this.mExpandedInActionView = true;
            this.mCollapsedImeOptions = this.mSearchSrcTextView.getImeOptions();
            this.mSearchSrcTextView.setImeOptions(this.mCollapsedImeOptions | 33554432);
            this.mSearchSrcTextView.setText("");
            setIconified(false);
        }
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable c1270e = new C1270e(super.onSaveInstanceState());
        c1270e.asV = isIconified();
        return c1270e;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C1270e) {
            C1270e c1270e = (C1270e) parcelable;
            super.onRestoreInstanceState(c1270e.getSuperState());
            updateViewsVisibility(c1270e.asV);
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    void adjustDropDownSizeAndPosition() {
        if (this.mDropDownAnchor.getWidth() > 1) {
            int dimensionPixelSize;
            int i;
            Resources resources = getContext().getResources();
            int paddingLeft = this.mSearchPlate.getPaddingLeft();
            Rect rect = new Rect();
            boolean cH = tb.cH(this);
            if (this.mIconifiedByDefault) {
                dimensionPixelSize = resources.getDimensionPixelSize(d.abc_dropdownitem_text_padding_left) + resources.getDimensionPixelSize(d.abc_dropdownitem_icon_width);
            } else {
                dimensionPixelSize = 0;
            }
            this.mSearchSrcTextView.getDropDownBackground().getPadding(rect);
            if (cH) {
                i = -rect.left;
            } else {
                i = paddingLeft - (rect.left + dimensionPixelSize);
            }
            this.mSearchSrcTextView.setDropDownHorizontalOffset(i);
            this.mSearchSrcTextView.setDropDownWidth((dimensionPixelSize + ((this.mDropDownAnchor.getWidth() + rect.left) + rect.right)) - paddingLeft);
        }
    }

    boolean onItemClicked(int i, int i2, String str) {
        if (this.mOnSuggestionListener != null && this.mOnSuggestionListener.onSuggestionClick(i)) {
            return false;
        }
        launchSuggestion(i, 0, null);
        setImeVisibility(false);
        dismissSuggestions();
        return true;
    }

    boolean onItemSelected(int i) {
        if (this.mOnSuggestionListener != null && this.mOnSuggestionListener.onSuggestionSelect(i)) {
            return false;
        }
        rewriteQueryFromSuggestion(i);
        return true;
    }

    private void rewriteQueryFromSuggestion(int i) {
        CharSequence text = this.mSearchSrcTextView.getText();
        Cursor cursor = this.mSuggestionsAdapter.getCursor();
        if (cursor != null) {
            if (cursor.moveToPosition(i)) {
                CharSequence convertToString = this.mSuggestionsAdapter.convertToString(cursor);
                if (convertToString != null) {
                    setQuery(convertToString);
                    return;
                } else {
                    setQuery(text);
                    return;
                }
            }
            setQuery(text);
        }
    }

    private boolean launchSuggestion(int i, int i2, String str) {
        Cursor cursor = this.mSuggestionsAdapter.getCursor();
        if (cursor == null || !cursor.moveToPosition(i)) {
            return false;
        }
        launchIntent(createIntentFromSuggestion(cursor, i2, str));
        return true;
    }

    private void launchIntent(Intent intent) {
        if (intent != null) {
            try {
                getContext().startActivity(intent);
            } catch (Throwable e) {
                Log.e(LOG_TAG, "Failed launch activity: " + intent, e);
            }
        }
    }

    private void setQuery(CharSequence charSequence) {
        this.mSearchSrcTextView.setText(charSequence);
        this.mSearchSrcTextView.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    void launchQuerySearch(int i, String str, String str2) {
        getContext().startActivity(createIntent("android.intent.action.SEARCH", null, null, str2, i, str));
    }

    private Intent createIntent(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.mUserQuery);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.mAppSearchData != null) {
            intent.putExtra("app_data", this.mAppSearchData);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.mSearchable.getSearchActivity());
        return intent;
    }

    private Intent createVoiceWebSearchIntent(Intent intent, SearchableInfo searchableInfo) {
        String str;
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        String str2 = "calling_package";
        if (searchActivity == null) {
            str = null;
        } else {
            str = searchActivity.flattenToShortString();
        }
        intent2.putExtra(str2, str);
        return intent2;
    }

    private Intent createVoiceAppSearchIntent(Intent intent, SearchableInfo searchableInfo) {
        String string;
        String string2;
        String str = null;
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        Parcelable activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        if (this.mAppSearchData != null) {
            bundle.putParcelable("app_data", this.mAppSearchData);
        }
        Intent intent3 = new Intent(intent);
        String str2 = "free_form";
        int i = 1;
        Resources resources = getResources();
        if (searchableInfo.getVoiceLanguageModeId() != 0) {
            str2 = resources.getString(searchableInfo.getVoiceLanguageModeId());
        }
        if (searchableInfo.getVoicePromptTextId() != 0) {
            string = resources.getString(searchableInfo.getVoicePromptTextId());
        } else {
            string = null;
        }
        if (searchableInfo.getVoiceLanguageId() != 0) {
            string2 = resources.getString(searchableInfo.getVoiceLanguageId());
        } else {
            string2 = null;
        }
        if (searchableInfo.getVoiceMaxResults() != 0) {
            i = searchableInfo.getVoiceMaxResults();
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", str2);
        intent3.putExtra("android.speech.extra.PROMPT", string);
        intent3.putExtra("android.speech.extra.LANGUAGE", string2);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", i);
        str2 = "calling_package";
        if (searchActivity != null) {
            str = searchActivity.flattenToShortString();
        }
        intent3.putExtra(str2, str);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent createIntentFromSuggestion(Cursor cursor, int i, String str) {
        try {
            String a = sq.a(cursor, "suggest_intent_action");
            if (a == null) {
                a = this.mSearchable.getSuggestIntentAction();
            }
            if (a == null) {
                a = "android.intent.action.SEARCH";
            }
            String a2 = sq.a(cursor, "suggest_intent_data");
            if (a2 == null) {
                a2 = this.mSearchable.getSuggestIntentData();
            }
            if (a2 != null) {
                String a3 = sq.a(cursor, "suggest_intent_data_id");
                if (a3 != null) {
                    a2 = a2 + "/" + Uri.encode(a3);
                }
            }
            return createIntent(a, a2 == null ? null : Uri.parse(a2), sq.a(cursor, "suggest_intent_extra_data"), sq.a(cursor, "suggest_intent_query"), i, str);
        } catch (Throwable e) {
            int position;
            Throwable th = e;
            try {
                position = cursor.getPosition();
            } catch (RuntimeException e2) {
                position = -1;
            }
            Log.w(LOG_TAG, "Search suggestions cursor at row " + position + " returned exception.", th);
            return null;
        }
    }

    void forceSuggestionQuery() {
        HIDDEN_METHOD_INVOKER.m2506a(this.mSearchSrcTextView);
        HIDDEN_METHOD_INVOKER.m2508b(this.mSearchSrcTextView);
    }

    static boolean isLandscapeMode(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }
}
