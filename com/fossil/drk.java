package com.fossil;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SwitchCompat;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.facebook.internal.Utility;
import com.fossil.ari.C1856a;
import com.fossil.cloudimagelib.Constants.DeviceType;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.HeightFormatter;
import com.portfolio.platform.helper.DeviceHelper;
import com.portfolio.platform.helper.DeviceHelper.ImageStyle;
import com.portfolio.platform.view.FlexibleEditText;
import com.portfolio.platform.view.NumberPickerLarge;
import com.portfolio.platform.view.NumberPickerLarge.Formatter;
import com.portfolio.platform.view.NumberPickerLarge.e;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"UseSparseArrays"})
public class drk extends ev implements OnKeyListener {
    private HashMap<Integer, Bitmap> dfA;
    private HashMap<Integer, String> dfB;
    private HashMap<Integer, String> dfC;
    private HashMap<Integer, SpannableString> dfD;
    private ArrayList<Integer> dfE;
    private ArrayList<Integer> dfF;
    private ArrayList<Integer> dfG;
    private ArrayList<Integer> dfH;
    private HashMap<Integer, List<Serializable>> dfI;
    private HashMap<Integer, Boolean> dfJ;
    private HashMap<Integer, Integer> dfK;
    private Intent dfL;
    private C2095b dfM;
    private C2333c dfN;
    private int dfv;
    private int dfw;
    private boolean dfx;
    private ArrayList<Integer> dfy;
    private HashMap<Integer, Integer> dfz;
    private String mTag;

    public interface C2095b {
        void mo1746a(String str, int i, Intent intent);
    }

    public interface C2333c {
        void hJ(String str);
    }

    class C31244 implements OnCheckedChangeListener {
        final /* synthetic */ drk dfP;

        C31244(drk com_fossil_drk) {
            this.dfP = com_fossil_drk;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (this.dfP.dfJ == null) {
                this.dfP.dfJ = new HashMap();
            }
            this.dfP.dfJ.put(Integer.valueOf(compoundButton.getId()), Boolean.valueOf(z));
        }
    }

    class C31255 implements e {
        final /* synthetic */ drk dfP;

        C31255(drk com_fossil_drk) {
            this.dfP = com_fossil_drk;
        }

        public void m9489a(NumberPickerLarge numberPickerLarge, int i, int i2) {
            if (this.dfP.dfK == null) {
                this.dfP.dfK = new HashMap();
            }
            this.dfP.dfK.put(Integer.valueOf(numberPickerLarge.getId()), Integer.valueOf(i2));
        }
    }

    public static class C3126a {
        private final HashMap<Integer, Bitmap> dfA = new HashMap();
        private final HashMap<Integer, String> dfB = new HashMap();
        private final HashMap<Integer, String> dfC = new HashMap();
        private final HashMap<Integer, SpannableString> dfD = new HashMap();
        private final ArrayList<Integer> dfE = new ArrayList();
        private final ArrayList<Integer> dfF = new ArrayList();
        private final ArrayList<Integer> dfG = new ArrayList();
        private final ArrayList<Integer> dfH = new ArrayList();
        private final HashMap<Integer, List<Serializable>> dfI = new HashMap();
        private final int dfv;
        private int dfw;
        private boolean dfx;
        private final ArrayList<Integer> dfy = new ArrayList();
        private final HashMap<Integer, Integer> dfz = new HashMap();

        public C3126a(int i) {
            this.dfv = i;
        }

        public C3126a cf(int i, int i2) {
            this.dfz.put(Integer.valueOf(i), Integer.valueOf(i2));
            return this;
        }

        public C3126a m9498w(int i, String str) {
            this.dfC.put(Integer.valueOf(i), str);
            return this;
        }

        public C3126a m9492a(int i, SpannableString spannableString) {
            this.dfD.put(Integer.valueOf(i), spannableString);
            return this;
        }

        public C3126a lA(int i) {
            this.dfE.add(Integer.valueOf(i));
            return this;
        }

        public C3126a lB(int i) {
            this.dfF.add(Integer.valueOf(i));
            return this;
        }

        public C3126a m9499y(int i, int i2, int i3, int i4) {
            return m9491a(i, i2, i3, i4, null, null);
        }

        public C3126a m9490a(int i, int i2, int i3, int i4, HeightFormatter heightFormatter) {
            return m9491a(i, i2, i3, i4, heightFormatter, null);
        }

        public C3126a m9491a(int i, int i2, int i3, int i4, Formatter formatter, String[] strArr) {
            List arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(i2));
            arrayList.add(Integer.valueOf(i3));
            arrayList.add(Integer.valueOf(i4));
            if (formatter != null) {
                arrayList.add(formatter);
            }
            if (strArr != null) {
                arrayList.add(strArr);
            }
            this.dfI.put(Integer.valueOf(i), arrayList);
            return this;
        }

        public drk jw(String str) {
            return m9497g(str, null);
        }

        public drk m9497g(String str, Bundle bundle) {
            return drk.m9500a(str, bundle, this.dfv, this.dfw, this.dfx, this.dfy, this.dfz, this.dfA, this.dfB, this.dfC, this.dfD, this.dfE, this.dfG, this.dfF, this.dfH, this.dfI);
        }

        public drk m9495c(fa faVar, String str) {
            return m9493a(faVar, str, 1, R.style.AppTheme);
        }

        public drk m9496d(fa faVar, String str) {
            drk jw = jw(str);
            jw.setCancelable(false);
            jw.setStyle(0, R.style.DialogNotFullScreen);
            jw.show(faVar, str);
            return jw;
        }

        public drk m9494a(fa faVar, String str, Bundle bundle) {
            drk g = m9497g(str, bundle);
            g.setCancelable(false);
            g.setStyle(0, R.style.DialogNotFullScreen);
            g.show(faVar, str);
            return g;
        }

        public drk m9493a(fa faVar, String str, int i, int i2) {
            drk jw = jw(str);
            jw.setStyle(i, i2);
            jw.show(faVar, str);
            return jw;
        }
    }

    private static drk m9500a(String str, Bundle bundle, int i, int i2, boolean z, ArrayList<Integer> arrayList, HashMap<Integer, Integer> hashMap, HashMap<Integer, Bitmap> hashMap2, HashMap<Integer, String> hashMap3, HashMap<Integer, String> hashMap4, HashMap<Integer, SpannableString> hashMap5, ArrayList<Integer> arrayList2, ArrayList<Integer> arrayList3, ArrayList<Integer> arrayList4, ArrayList<Integer> arrayList5, HashMap<Integer, List<Serializable>> hashMap6) {
        drk com_fossil_drk = new drk();
        Bundle bundle2 = new Bundle();
        bundle2.putString("ARGUMENTS_TAG", str);
        bundle2.putBundle("ARGUMENTS_BUNDLE", bundle);
        bundle2.putInt("ARGUMENTS_LAYOUT_ID", i);
        bundle2.putInt("ARGUMENTS_STATUS_BAR_COLOR_ID", i2);
        bundle2.putBoolean("ARGUMENTS_STATUS_BAR_DARK_ICON", z);
        bundle2.putSerializable("ARGUMENTS_STATUS_BAR_FLAGS", arrayList);
        bundle2.putSerializable("ARGUMENTS_IMAGE_VIEWS", hashMap);
        bundle2.putSerializable("ARGUMENTS_BLUR_IMAGE_VIEWS", hashMap2);
        bundle2.putSerializable("ARGUMENTS_DEVICE_IMAGE_VIEWS", hashMap3);
        bundle2.putSerializable("ARGUMENTS_TEXT_VIEWS", hashMap4);
        bundle2.putSerializable("ARGUMENTS_TEXT_VIEWS_SPANNABLE", hashMap5);
        bundle2.putSerializable("ARGUMENTS_DISMISS_VIEWS", arrayList4);
        bundle2.putSerializable("ARGUMENTS_ACTION_VIEWS", arrayList2);
        bundle2.putSerializable("ARGUMENTS_SWITCH_VIEWS", arrayList3);
        bundle2.putSerializable("ARGUMENTS_EDIT_TEXT_VIEWS", arrayList5);
        bundle2.putSerializable("ARGUMENTS_NUMBER_PICKERS", hashMap6);
        com_fossil_drk.setArguments(bundle2);
        return com_fossil_drk;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.dfL = new Intent();
        Bundle arguments = getArguments();
        this.mTag = arguments.getString("ARGUMENTS_TAG");
        Bundle bundle2 = arguments.getBundle("ARGUMENTS_BUNDLE");
        if (bundle2 != null) {
            this.dfL.putExtras(bundle2);
        }
        this.dfv = arguments.getInt("ARGUMENTS_LAYOUT_ID");
        this.dfw = arguments.getInt("ARGUMENTS_STATUS_BAR_COLOR_ID");
        this.dfx = arguments.getBoolean("ARGUMENTS_STATUS_BAR_DARK_ICON");
        this.dfy = (ArrayList) arguments.getSerializable("ARGUMENTS_STATUS_BAR_FLAGS");
        this.dfz = (HashMap) arguments.getSerializable("ARGUMENTS_IMAGE_VIEWS");
        this.dfA = (HashMap) arguments.getSerializable("ARGUMENTS_BLUR_IMAGE_VIEWS");
        this.dfB = (HashMap) arguments.getSerializable("ARGUMENTS_DEVICE_IMAGE_VIEWS");
        this.dfC = (HashMap) arguments.getSerializable("ARGUMENTS_TEXT_VIEWS");
        this.dfD = (HashMap) arguments.getSerializable("ARGUMENTS_TEXT_VIEWS_SPANNABLE");
        this.dfE = (ArrayList) arguments.getSerializable("ARGUMENTS_ACTION_VIEWS");
        this.dfF = (ArrayList) arguments.getSerializable("ARGUMENTS_DISMISS_VIEWS");
        this.dfG = (ArrayList) arguments.getSerializable("ARGUMENTS_SWITCH_VIEWS");
        this.dfH = (ArrayList) arguments.getSerializable("ARGUMENTS_EDIT_TEXT_VIEWS");
        this.dfI = (HashMap) arguments.getSerializable("ARGUMENTS_NUMBER_PICKERS");
    }

    public void setupDialog(Dialog dialog, int i) {
        dialog.requestWindowFeature(1);
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawableResource(R.color.transparent);
            dialog.getWindow().setLayout(-1, -1);
            dialog.getWindow().getDecorView().setSystemUiVisibility(3328);
            dialog.setOnKeyListener(this);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            if (parentFragment instanceof C2095b) {
                this.dfM = (C2095b) parentFragment;
            }
            if (parentFragment instanceof C2333c) {
                this.dfN = (C2333c) parentFragment;
            }
        }
        if (this.dfM == null && (context instanceof C2095b)) {
            this.dfM = (C2095b) context;
        }
        if (this.dfN == null && (context instanceof C2333c)) {
            this.dfN = (C2333c) context;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (VERSION.SDK_INT >= 21) {
            Window window = getDialog().getWindow();
            if (window != null) {
                if (this.dfw != 0) {
                    window.addFlags(Integer.MIN_VALUE);
                    window.setStatusBarColor(gn.m10634e(getContext(), this.dfw));
                }
                if (!(this.dfy == null || this.dfy.isEmpty())) {
                    Iterator it = this.dfy.iterator();
                    while (it.hasNext()) {
                        window.addFlags(((Integer) it.next()).intValue());
                    }
                }
                if (VERSION.SDK_INT >= 23 && this.dfx) {
                    window.getDecorView().setSystemUiVisibility(Utility.DEFAULT_STREAM_BUFFER_SIZE);
                }
            }
        }
        return layoutInflater.inflate(this.dfv, viewGroup);
    }

    public void onViewCreated(final View view, Bundle bundle) {
        int intValue;
        View findViewById;
        int intValue2;
        View findViewById2;
        int intValue3;
        Iterator it;
        super.onViewCreated(view, bundle);
        if (this.dfz != null) {
            for (Integer intValue4 : this.dfz.keySet()) {
                intValue = intValue4.intValue();
                findViewById = view.findViewById(intValue);
                if (findViewById == null) {
                    MFLogger.m12671e("AlertDialogFragment", "Set ImageViews - view is null on mTag = " + this.mTag);
                } else {
                    ((ImageView) findViewById).setImageResource(((Integer) this.dfz.get(Integer.valueOf(intValue))).intValue());
                }
            }
        }
        if (this.dfA != null) {
            for (Integer intValue42 : this.dfA.keySet()) {
                intValue2 = intValue42.intValue();
                findViewById2 = view.findViewById(intValue2);
                if (findViewById2 == null) {
                    MFLogger.m12671e("AlertDialogFragment", "Set mBlurImageViews - view is null on mTag = " + this.mTag);
                } else {
                    drv.cE(getContext()).lV(25).lW(2).m9561v((Bitmap) this.dfA.get(Integer.valueOf(intValue2))).m9560d((ImageView) findViewById2);
                }
            }
        }
        if (this.dfB != null) {
            for (Integer intValue422 : this.dfB.keySet()) {
                intValue2 = intValue422.intValue();
                final View findViewById3 = view.findViewById(intValue2);
                if (findViewById3 == null) {
                    MFLogger.m12671e("AlertDialogFragment", "Set mDeviceImageViews - view is null on mTag = " + this.mTag);
                } else {
                    String str = (String) this.dfB.get(Integer.valueOf(intValue2));
                    ari.Jl().ad(PortfolioApp.ZQ()).cG(str).cH(DeviceHelper.gi(str)).m4283a(DeviceType.TYPE_LARGE).m4280a((ImageView) findViewById3, DeviceHelper.a(str, ImageStyle.LARGE)).m4281a(new C1856a(this) {
                        final /* synthetic */ drk dfP;

                        public void mo1879C(String str, String str2) {
                            tx.t(this.dfP).l(new File(str2)).c(DiskCacheStrategy.RESULT).c((ImageView) findViewById3);
                        }
                    }).Jm();
                }
            }
        }
        if (this.dfC != null) {
            for (Integer intValue4222 : this.dfC.keySet()) {
                intValue = intValue4222.intValue();
                findViewById = view.findViewById(intValue);
                if (findViewById == null) {
                    MFLogger.m12671e("AlertDialogFragment", "Set TextViews - view is null on mTag = " + this.mTag);
                } else {
                    ((TextView) findViewById).setText((CharSequence) this.dfC.get(Integer.valueOf(intValue)));
                }
            }
        }
        if (this.dfD != null) {
            for (Integer intValue42222 : this.dfD.keySet()) {
                intValue3 = intValue42222.intValue();
                findViewById2 = view.findViewById(intValue3);
                if (findViewById2 == null) {
                    MFLogger.m12671e("AlertDialogFragment", "Set TextViews - view is null on mTag = " + this.mTag);
                } else {
                    ((TextView) findViewById2).setText((CharSequence) this.dfD.get(Integer.valueOf(intValue3)));
                    ((TextView) findViewById2).setMovementMethod(LinkMovementMethod.getInstance());
                    ((TextView) findViewById2).setHighlightColor(0);
                }
            }
        }
        if (!(this.dfF == null || this.dfF.isEmpty())) {
            it = this.dfF.iterator();
            while (it.hasNext()) {
                intValue2 = ((Integer) it.next()).intValue();
                if (view.findViewById(intValue2) == null) {
                    MFLogger.m12671e("AlertDialogFragment", "Set action - view is null on mTag = " + this.mTag);
                } else {
                    view.findViewById(intValue2).setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ drk dfP;

                        public void onClick(View view) {
                            this.dfP.dismiss();
                            if (this.dfP.dfJ != null) {
                                this.dfP.dfL.putExtra("EXTRA_SWITCH_RESULTS", this.dfP.dfJ);
                            }
                            if (this.dfP.dfK != null) {
                                this.dfP.dfL.putExtra("EXTRA_NUMBER_PICKER_RESULTS", this.dfP.dfK);
                            }
                            if (this.dfP.dfH != null) {
                                Serializable hashMap = new HashMap();
                                Iterator it = this.dfP.dfH.iterator();
                                while (it.hasNext()) {
                                    int intValue = ((Integer) it.next()).intValue();
                                    hashMap.put(Integer.valueOf(intValue), ((FlexibleEditText) view.findViewById(intValue)).getText().toString());
                                }
                                this.dfP.dfL.putExtra("EXTRA_EDIT_TEXT_RESULTS", hashMap);
                            }
                            if (this.dfP.dfM != null) {
                                this.dfP.dfM.mo1746a(this.dfP.mTag, intValue2, this.dfP.dfL);
                            }
                        }
                    });
                }
            }
        }
        if (this.dfE != null) {
            it = this.dfE.iterator();
            while (it.hasNext()) {
                intValue2 = ((Integer) it.next()).intValue();
                if (view.findViewById(intValue2) == null) {
                    MFLogger.m12671e("AlertDialogFragment", "Set action - view is null on mTag = " + this.mTag);
                } else {
                    view.findViewById(intValue2).setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ drk dfP;

                        public void onClick(View view) {
                            if (this.dfP.dfJ != null) {
                                this.dfP.dfL.putExtra("EXTRA_SWITCH_RESULTS", this.dfP.dfJ);
                            }
                            if (this.dfP.dfK != null) {
                                this.dfP.dfL.putExtra("EXTRA_NUMBER_PICKER_RESULTS", this.dfP.dfK);
                            }
                            if (this.dfP.dfH != null) {
                                Serializable hashMap = new HashMap();
                                Iterator it = this.dfP.dfH.iterator();
                                while (it.hasNext()) {
                                    int intValue = ((Integer) it.next()).intValue();
                                    hashMap.put(Integer.valueOf(intValue), ((FlexibleEditText) view.findViewById(intValue)).getText().toString());
                                }
                                this.dfP.dfL.putExtra("EXTRA_EDIT_TEXT_RESULTS", hashMap);
                            }
                            if (this.dfP.dfM != null) {
                                this.dfP.dfM.mo1746a(this.dfP.mTag, intValue2, this.dfP.dfL);
                            }
                        }
                    });
                }
            }
        }
        if (this.dfG != null) {
            it = this.dfG.iterator();
            while (it.hasNext()) {
                intValue3 = ((Integer) it.next()).intValue();
                findViewById = view.findViewById(intValue3);
                if (findViewById == null) {
                    MFLogger.m12671e("AlertDialogFragment", "Set SwitchViews - view is null on mTag = " + this.mTag);
                } else {
                    if (this.dfJ == null) {
                        this.dfJ = new HashMap();
                    }
                    this.dfJ.put(Integer.valueOf(intValue3), Boolean.valueOf(false));
                    ((SwitchCompat) findViewById).setOnCheckedChangeListener(new C31244(this));
                }
            }
        }
        if (this.dfH != null) {
            it = this.dfH.iterator();
            while (it.hasNext()) {
                if (((FlexibleEditText) view.findViewById(((Integer) it.next()).intValue())) == null) {
                    MFLogger.m12671e("AlertDialogFragment", "Set EditTextViews - view is null on mTag = " + this.mTag);
                }
            }
        }
        if (this.dfI != null) {
            for (Integer intValue422222 : this.dfI.keySet()) {
                int intValue5 = intValue422222.intValue();
                findViewById = view.findViewById(intValue5);
                if (findViewById == null) {
                    MFLogger.m12671e("AlertDialogFragment", "Set NumberPickers - view is null on mTag = " + this.mTag);
                } else {
                    NumberPickerLarge numberPickerLarge = (NumberPickerLarge) findViewById;
                    numberPickerLarge.setOnValueChangedListener(new C31255(this));
                    List list = (List) this.dfI.get(Integer.valueOf(intValue5));
                    int intValue6 = ((Integer) list.get(2)).intValue();
                    numberPickerLarge.setMinValue(((Integer) list.get(0)).intValue());
                    numberPickerLarge.setMaxValue(((Integer) list.get(1)).intValue());
                    numberPickerLarge.setValue(intValue6);
                    if (list.size() > 3) {
                        numberPickerLarge.setFormatter((Formatter) list.get(3));
                    }
                    if (list.size() > 4) {
                        numberPickerLarge.setDisplayedValues((String[]) list.get(4));
                    }
                    if (this.dfK == null) {
                        this.dfK = new HashMap();
                    }
                    this.dfK.put(Integer.valueOf(intValue5), Integer.valueOf(intValue6));
                }
            }
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (this.dfN != null) {
            this.dfN.hJ(getTag());
        }
    }

    public void show(fa faVar, String str) {
        MFLogger.m12670d("AlertDialogFragment", "show - tag: " + str);
        fg hW = faVar.hW();
        Fragment W = faVar.mo3086W(str);
        if (W != null) {
            hW.mo2967a(W);
        }
        hW.mo2964T(null).mo2968a((Fragment) this, str).commitAllowingStateLoss();
    }

    public void dismiss() {
        fa fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            fragmentManager.hW().mo2967a(this).commitAllowingStateLoss();
        }
    }

    protected boolean lM() {
        dismiss();
        return true;
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 4) {
            return false;
        }
        MFLogger.m12670d("AlertDialogFragment", "onKey KEYCODE_BACK");
        return lM();
    }

    public void onDetach() {
        super.onDetach();
        this.dfM = null;
    }
}
