package com.fossil;

import android.support.v7.widget.RecyclerView.C1234a;
import android.support.v7.widget.RecyclerView.C1264v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.microapp.ButtonMapping;
import com.portfolio.platform.data.model.microapp.MicroApp;
import com.portfolio.platform.data.model.microapp.PusherConfiguration.Pusher;
import com.portfolio.platform.data.model.microapp.RecommendedPreset;
import com.portfolio.platform.data.model.microapp.SavedPreset;
import com.portfolio.platform.data.model.microapp.SavedPreset.MappingSetType;
import com.portfolio.platform.view.FlexibleTextView;
import java.util.ArrayList;
import java.util.List;

public class ckh extends C1234a<C2148a> {
    private static String TAG = ckh.class.getSimpleName();
    private C2149b coH;
    private List<C2150c> coI = new ArrayList();
    private int coJ;
    private View cov;
    private final tz cow;
    private List<MicroApp> mMicroAppList;

    static /* synthetic */ class C21471 {
        static final /* synthetic */ int[] f1454x96782840 = new int[Pusher.values().length];
        static final /* synthetic */ int[] coK = new int[MappingSetType.values().length];

        static {
            try {
                f1454x96782840[Pusher.TOP_PUSHER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1454x96782840[Pusher.MID_PUSHER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1454x96782840[Pusher.BOTTOM_PUSHER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                coK[MappingSetType.USER_SAVED.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                coK[MappingSetType.RECOMMENDED.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public static class C2148a extends C1264v implements OnClickListener {
        private C2149b coH;
        private ImageView coL;
        private ImageView coM;
        private ImageView coN;
        private FlexibleTextView coO;
        private FlexibleTextView coP;
        private View coQ;
        private ImageView coR;
        private String coS;
        private MappingSetType coT;
        private View ou;

        private C2148a(View view, C2149b c2149b) {
            super(view);
            this.coL = (ImageView) view.findViewById(R.id.top_feature_icon);
            this.coM = (ImageView) view.findViewById(R.id.middle_feature_icon);
            this.coN = (ImageView) view.findViewById(R.id.bottom_feature_icon);
            this.coO = (FlexibleTextView) view.findViewById(R.id.presets_name_tv);
            this.coP = (FlexibleTextView) view.findViewById(R.id.presets_type_tv);
            this.coQ = view.findViewById(R.id.deleted_icon);
            this.coR = (ImageView) view.findViewById(R.id.preset_divider);
            view.findViewById(R.id.set_to_watch_btn).setOnClickListener(this);
            this.coQ.setOnClickListener(this);
            this.ou = view.findViewById(R.id.presets_icon_layout);
            this.coH = c2149b;
            this.ou.setOnClickListener(this);
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.set_to_watch_btn:
                    if (this.coH != null) {
                        this.coH.mo2389a(this.coS, this.coT);
                        return;
                    }
                    return;
                case R.id.deleted_icon:
                    if (this.coH != null) {
                        this.coH.mo2388a(this.coT, this.coS);
                        return;
                    }
                    return;
                default:
                    if (this.coH != null) {
                        this.coH.fU(this.coS);
                        return;
                    }
                    return;
            }
        }

        public void setVisibility(int i) {
            this.ou.setVisibility(i);
        }
    }

    public interface C2149b {
        void mo2388a(MappingSetType mappingSetType, String str);

        void mo2389a(String str, MappingSetType mappingSetType);

        void fU(String str);
    }

    static class C2150c {
        private String coS;
        private MappingSetType coT;
        private int coU;
        private int coV;
        private int coW;
        private String coX;
        private String coY;
        private String coZ;
        private String cpa;

        private C2150c() {
        }
    }

    public /* synthetic */ C1264v mo1090c(ViewGroup viewGroup, int i) {
        return m6953h(viewGroup, i);
    }

    public ckh(List<MicroApp> list, C2149b c2149b, tz tzVar) {
        this.coH = c2149b;
        if (this.mMicroAppList == null) {
            this.mMicroAppList = new ArrayList();
        }
        if (list != null) {
            this.mMicroAppList.addAll(list);
        }
        this.cow = tzVar;
    }

    public C2148a m6953h(ViewGroup viewGroup, int i) {
        MFLogger.m12670d(TAG, "onCreateViewHolder position=" + i);
        return new C2148a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_customize_preset, viewGroup, false), this.coH);
    }

    public void m6951a(C2148a c2148a, int i) {
        MFLogger.m12670d(TAG, "onBindViewHolder position=" + i);
        C2150c c2150c = (C2150c) this.coI.get(i);
        if (c2150c.coT != null) {
            m6944a(c2150c.coX, c2150c.coU, c2148a.coL);
            m6944a(c2150c.coY, c2150c.coV, c2148a.coM);
            m6944a(c2150c.coZ, c2150c.coW, c2148a.coN);
            c2148a.coO.setText(c2150c.cpa);
            if (i == 0 || (this.coJ != 0 && i == this.coJ)) {
                c2148a.coP.setVisibility(0);
                c2148a.coP.setText(m6941a(c2150c.coT));
                if (c2150c.coT != MappingSetType.RECOMMENDED || this.coJ == 0) {
                    c2148a.coR.setVisibility(8);
                } else {
                    c2148a.coR.setVisibility(0);
                }
            } else {
                c2148a.coP.setVisibility(8);
                c2148a.coR.setVisibility(8);
            }
            c2148a.coS = c2150c.coS;
            c2148a.coT = c2150c.coT;
            switch (C21471.coK[c2150c.coT.ordinal()]) {
                case 1:
                    c2148a.coQ.setVisibility(0);
                    return;
                case 2:
                    c2148a.coQ.setVisibility(8);
                    return;
                default:
                    return;
            }
        }
        c2148a.setVisibility(8);
    }

    private void m6944a(String str, int i, ImageView imageView) {
        this.cow.ah(str).ew(i).c(imageView);
    }

    private int m6941a(MappingSetType mappingSetType) {
        switch (C21471.coK[mappingSetType.ordinal()]) {
            case 1:
                return R.string.Shortcuts_Preset_Text_Saved_Presets;
            case 2:
                return R.string.Shortcuts_Preset_Scroll_Text_Recommended_Presets;
            default:
                return -1;
        }
    }

    public int getItemCount() {
        return this.coI.size();
    }

    public void m6947K(List<SavedPreset> list) {
        MFLogger.m12670d(TAG, "setSavedData");
        if (list != null) {
            MFLogger.m12670d(TAG, "setSavedData savedSavedPresetList not empty");
            List arrayList = new ArrayList();
            for (int i = 0; i < this.coI.size(); i++) {
                MappingSetType a = ((C2150c) this.coI.get(i)).coT;
                if (a != null && a == MappingSetType.RECOMMENDED) {
                    arrayList.add(this.coI.get(i));
                }
            }
            List arrayList2 = new ArrayList();
            for (SavedPreset a2 : list) {
                C2150c a3 = m6943a(a2);
                if (a3 != null) {
                    arrayList2.add(a3);
                }
            }
            m6946b(arrayList2, arrayList);
        }
    }

    private C2150c m6943a(SavedPreset savedPreset) {
        MFLogger.m12670d(TAG, "convertToPresetItem savedPreset=" + savedPreset.getButtons());
        C2150c c2150c = new C2150c();
        c2150c.coS = savedPreset.getId();
        c2150c.cpa = savedPreset.getName();
        c2150c.coT = MappingSetType.USER_SAVED;
        return m6945a(savedPreset.getButtonMappingList(), c2150c) ? c2150c : null;
    }

    private MicroApp fT(String str) {
        for (MicroApp microApp : this.mMicroAppList) {
            if (microApp.getAppId().equals(str)) {
                return microApp;
            }
        }
        return null;
    }

    private boolean m6945a(List<ButtonMapping> list, C2150c c2150c) {
        for (ButtonMapping buttonMapping : list) {
            MFLogger.m12670d(TAG, "convertToPresetItem buttonMapping microAppId=" + buttonMapping.getMicroAppId());
            Pusher pusherFromValue = Pusher.getPusherFromValue(buttonMapping.getButton());
            MicroApp fT = fT(buttonMapping.getMicroAppId());
            if (fT != null) {
                switch (C21471.f1454x96782840[pusherFromValue.ordinal()]) {
                    case 1:
                        c2150c.coX = fT.getIconUrl() == null ? "" : fT.getIconUrl();
                        c2150c.coU = fT.getDefaultIconId();
                        break;
                    case 2:
                        c2150c.coY = fT.getIconUrl() == null ? "" : fT.getIconUrl();
                        c2150c.coV = fT.getDefaultIconId();
                        break;
                    case 3:
                        c2150c.coZ = fT.getIconUrl() == null ? "" : fT.getIconUrl();
                        c2150c.coW = fT.getDefaultIconId();
                        break;
                    default:
                        break;
                }
            }
            return false;
        }
        return true;
    }

    private C2150c m6942a(RecommendedPreset recommendedPreset) {
        MFLogger.m12670d(TAG, "convertToPresetItem savedPreset=" + recommendedPreset.getButtons());
        C2150c c2150c = new C2150c();
        c2150c.coS = recommendedPreset.getId();
        c2150c.coT = MappingSetType.RECOMMENDED;
        c2150c.cpa = recommendedPreset.getName();
        return m6945a(recommendedPreset.getButtonMappingList(), c2150c) ? c2150c : null;
    }

    public void m6948L(List<RecommendedPreset> list) {
        if (list != null) {
            MFLogger.m12670d(TAG, "setRecommendPresets featureSavedPresetList not null");
            List arrayList = new ArrayList();
            for (int i = 0; i < this.coI.size(); i++) {
                MappingSetType a = ((C2150c) this.coI.get(i)).coT;
                if (a != null && a == MappingSetType.USER_SAVED) {
                    arrayList.add(this.coI.get(i));
                }
            }
            List arrayList2 = new ArrayList();
            for (RecommendedPreset recommendedPreset : list) {
                if (recommendedPreset.getType() == MappingSetType.RECOMMENDED) {
                    C2150c a2 = m6942a(recommendedPreset);
                    if (a2 != null) {
                        arrayList2.add(a2);
                    }
                }
            }
            m6946b(arrayList, arrayList2);
        }
    }

    public void abt() {
        MFLogger.m12670d(TAG, "dragStopped");
        if (this.cov != null) {
            this.cov.findViewById(R.id.presets_icon_layout).setAlpha(1.0f);
            this.cov.startAnimation(AnimationUtils.loadAnimation(this.cov.getContext(), R.anim.bouncing_animation));
        }
    }

    private void m6946b(List<C2150c> list, List<C2150c> list2) {
        MFLogger.m12670d(TAG, "notifyDataSetChange savedPresetListSize=" + list.size() + "favoritePresetListSize=" + list2.size());
        this.coI.clear();
        this.coI.addAll(list);
        this.coI.addAll(list2);
        if (list.isEmpty() || ((C2150c) list.get(0)).coT != MappingSetType.USER_SAVED) {
            if (list.isEmpty()) {
                this.coJ = 0;
            }
        } else if (((C2150c) list.get(0)).coT == MappingSetType.USER_SAVED) {
            this.coJ = list.size();
        } else {
            this.coJ = list2.size();
        }
    }

    public void m6949M(List<MicroApp> list) {
        if (list != null && !list.isEmpty()) {
            if (this.mMicroAppList == null) {
                this.mMicroAppList = new ArrayList();
            }
            this.mMicroAppList.clear();
            this.mMicroAppList.addAll(list);
        }
    }
}
