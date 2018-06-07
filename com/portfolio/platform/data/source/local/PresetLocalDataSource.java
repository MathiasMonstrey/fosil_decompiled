package com.portfolio.platform.data.source.local;

import android.text.TextUtils;
import com.fossil.cco;
import com.fossil.cnq;
import com.fossil.cok;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.microapp.ActivePreset;
import com.portfolio.platform.data.model.microapp.RecommendedPreset;
import com.portfolio.platform.data.model.microapp.SavedPreset;
import com.portfolio.platform.data.source.PresetDataSource;
import com.portfolio.platform.data.source.PresetDataSource.AddOrUpdateActivePresetCallback;
import com.portfolio.platform.data.source.PresetDataSource.AddOrUpdateSavedPresetCallback;
import com.portfolio.platform.data.source.PresetDataSource.AddOrUpdateSavedPresetListCallback;
import com.portfolio.platform.data.source.PresetDataSource.DeleteMappingSetCallback;
import com.portfolio.platform.data.source.PresetDataSource.GetActivePresetCallback;
import com.portfolio.platform.data.source.PresetDataSource.GetActivePresetListCallback;
import com.portfolio.platform.data.source.PresetDataSource.GetRecommendedPresetCallback;
import com.portfolio.platform.data.source.PresetDataSource.GetRecommendedPresetListCallback;
import com.portfolio.platform.data.source.PresetDataSource.GetSavedPresetCallback;
import com.portfolio.platform.data.source.PresetDataSource.GetSavedPresetListCallback;
import java.util.ArrayList;
import java.util.List;

public class PresetLocalDataSource implements PresetDataSource {
    private static final String TAG = PresetLocalDataSource.class.getSimpleName();

    public void addOrUpdateSavedPreset(SavedPreset savedPreset, AddOrUpdateSavedPresetCallback addOrUpdateSavedPresetCallback) {
        SavedPreset savedPreset2 = (SavedPreset) cco.ce(savedPreset);
        MFLogger.d(TAG, "addOrUpdateSavedPreset mappingSetId=" + savedPreset2.getId() + " mappingSetName=" + savedPreset2.getName() + ", pinType=" + savedPreset2.getPinType());
        SavedPreset hi = cnq.acd().acp().hi(savedPreset2.getId());
        if (hi != null && hi.getPinType() == 3) {
            MFLogger.d(TAG, "addOrUpdateSavedPreset onFail, this saved preset is deleted, cannot add or edit.");
            if (addOrUpdateSavedPresetCallback != null) {
                addOrUpdateSavedPresetCallback.onFail();
            }
        }
        if (cnq.acd().acp().b(savedPreset2)) {
            MFLogger.d(TAG, "addOrUpdateSavedPreset onSuccess");
            if (addOrUpdateSavedPresetCallback != null) {
                addOrUpdateSavedPresetCallback.onSuccess(savedPreset2);
                return;
            }
            return;
        }
        MFLogger.d(TAG, "addOrUpdateSavedPreset onFail");
        if (addOrUpdateSavedPresetCallback != null) {
            addOrUpdateSavedPresetCallback.onFail();
        }
    }

    public void addOrUpdateActivePreset(ActivePreset activePreset, AddOrUpdateActivePresetCallback addOrUpdateActivePresetCallback) {
        MFLogger.d(TAG, "addOrUpdateActivePreset serial=" + activePreset.getSerialNumber());
        if (cnq.acd().acp().a(activePreset)) {
            MFLogger.d(TAG, "addOrUpdateActivePreset onSuccess");
            if (addOrUpdateActivePresetCallback != null) {
                addOrUpdateActivePresetCallback.onSuccess(activePreset);
                return;
            }
            return;
        }
        MFLogger.d(TAG, "addOrUpdateActivePreset onFail");
        if (addOrUpdateActivePresetCallback != null) {
            addOrUpdateActivePresetCallback.onFail();
        }
    }

    public void deleteSavedPreset(SavedPreset savedPreset, DeleteMappingSetCallback deleteMappingSetCallback) {
        MFLogger.d(TAG, "deleteSavedPreset mappingSetId=" + savedPreset.getId());
        if (cnq.acd().acp().hg(savedPreset.getId())) {
            MFLogger.d(TAG, "deleteSavedPreset onSuccess");
            if (deleteMappingSetCallback != null) {
                deleteMappingSetCallback.onSuccess();
                return;
            }
            return;
        }
        MFLogger.d(TAG, "deleteSavedPreset onFail");
        if (deleteMappingSetCallback != null) {
            deleteMappingSetCallback.onFail();
        }
    }

    public void deleteAllRecommendedPresets(String str, DeleteMappingSetCallback deleteMappingSetCallback) {
        MFLogger.d(TAG, "deleteRecommendedPreset serial=" + str);
        if (cnq.acd().acp().hh(str)) {
            MFLogger.d(TAG, "deleteRecommendedPreset onSuccess");
            if (deleteMappingSetCallback != null) {
                deleteMappingSetCallback.onSuccess();
                return;
            }
            return;
        }
        MFLogger.d(TAG, "deleteRecommendedPreset onFail");
        if (deleteMappingSetCallback != null) {
            deleteMappingSetCallback.onFail();
        }
    }

    public void getActivePreset(String str, GetActivePresetCallback getActivePresetCallback) {
        MFLogger.d(TAG, "getActivePreset serial=" + str);
        ActivePreset hj = cnq.acd().acp().hj(str);
        if (hj != null) {
            MFLogger.d(TAG, "getActivePreset onSuccess - activePreset: " + hj.getButtons());
            if (getActivePresetCallback != null) {
                getActivePresetCallback.onSuccess(hj);
                return;
            }
            return;
        }
        MFLogger.d(TAG, "getActivePreset onFail");
        if (getActivePresetCallback != null) {
            getActivePresetCallback.onFail();
        }
    }

    public void getRecommendedPresets(String str, GetRecommendedPresetListCallback getRecommendedPresetListCallback) {
        MFLogger.d(TAG, "getRecommendedPresets deviceSerial=" + str);
        if (!TextUtils.isEmpty(str)) {
            List hf = cnq.acd().acp().hf(str);
            if (hf == null || hf.isEmpty()) {
                MFLogger.d(TAG, "getRecommendedPresets deviceSerial=" + str + " onFail");
                if (getRecommendedPresetListCallback != null) {
                    getRecommendedPresetListCallback.onFail();
                    return;
                }
                return;
            }
            MFLogger.d(TAG, "getRecommendedPresets deviceSerial=" + str + " onSuccess");
            if (getRecommendedPresetListCallback != null) {
                getRecommendedPresetListCallback.onSuccess(hf);
            }
        } else if (getRecommendedPresetListCallback != null) {
            getRecommendedPresetListCallback.onFail();
        }
    }

    public void getAllSavedPresets(GetSavedPresetListCallback getSavedPresetListCallback) {
        MFLogger.d(TAG, "getAllSavedPresets");
        List adT = cnq.acd().acp().adT();
        if (adT == null || adT.isEmpty()) {
            MFLogger.d(TAG, "getAllSavedPresets onFail");
            if (getSavedPresetListCallback != null) {
                getSavedPresetListCallback.onFail();
                return;
            }
            return;
        }
        MFLogger.d(TAG, "getAllSavedPresets onSuccess");
        if (getSavedPresetListCallback != null) {
            getSavedPresetListCallback.onSuccess(adT);
        }
    }

    public void getDefaultPreset(String str, GetRecommendedPresetCallback getRecommendedPresetCallback, boolean z) {
        MFLogger.d(TAG, "getDefaultPreset deviceSerial=" + str);
        RecommendedPreset hk = cnq.acd().acp().hk(str);
        if (hk == null) {
            MFLogger.d(TAG, "getDefaultPreset deviceSerial=" + str + " onFail");
            if (getRecommendedPresetCallback != null) {
                getRecommendedPresetCallback.onFail();
                return;
            }
            return;
        }
        MFLogger.d(TAG, "getDefaultPreset deviceSerial=" + str + " onSuccess");
        if (getRecommendedPresetCallback != null) {
            getRecommendedPresetCallback.onSuccess(hk);
        }
    }

    public void getSavedPreset(String str, GetSavedPresetCallback getSavedPresetCallback) {
        MFLogger.d(TAG, "getSavedPreset presetId=" + str);
        SavedPreset hi = cnq.acd().acp().hi(str);
        if (hi != null) {
            MFLogger.d(TAG, "getSavedPreset onSuccess");
            if (getSavedPresetCallback != null) {
                getSavedPresetCallback.onSuccess(hi);
                return;
            }
            return;
        }
        MFLogger.d(TAG, "getSavedPreset onFail");
        if (getSavedPresetCallback != null) {
            getSavedPresetCallback.onFail();
        }
    }

    public void addOrUpdateUserPresetList(List<SavedPreset> list, AddOrUpdateSavedPresetListCallback addOrUpdateSavedPresetListCallback) {
        MFLogger.d(TAG, "addOrUpdateSavedPresets");
        if (list != null && !list.isEmpty()) {
            MFLogger.d(TAG, ".addOrUpdateSavedPresets - mappingSetListSize=" + list.size());
            List arrayList = new ArrayList();
            for (SavedPreset savedPreset : list) {
                if (cnq.acd().acp().b(savedPreset)) {
                    arrayList.add(savedPreset);
                }
            }
            if (addOrUpdateSavedPresetListCallback != null) {
                addOrUpdateSavedPresetListCallback.onSuccess(arrayList);
            }
        } else if (addOrUpdateSavedPresetListCallback != null) {
            addOrUpdateSavedPresetListCallback.onFail();
        }
    }

    public void downloadRecommendPreset(String str, GetRecommendedPresetListCallback getRecommendedPresetListCallback) {
    }

    public void downloadSavedPreset(GetSavedPresetListCallback getSavedPresetListCallback) {
    }

    public void downloadActivePresetList(GetActivePresetListCallback getActivePresetListCallback) {
    }

    public void clearData() {
        cok acp = cnq.acd().acp();
        acp.aea();
        acp.adZ();
        acp.adY();
    }

    public boolean addOrUpdateRecommendedPresets(List<RecommendedPreset> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        MFLogger.d(TAG, ".addOrUpdateRecommendedPresets - presetListSize=" + list.size() + ", serialNumber=" + ((RecommendedPreset) list.get(0)).getSerialNumber());
        cok acp = cnq.acd().acp();
        for (RecommendedPreset b : list) {
            acp.b(b);
        }
        return true;
    }

    public boolean addOrUpdateDefaultPreset(RecommendedPreset recommendedPreset) {
        if (recommendedPreset == null) {
            return false;
        }
        MFLogger.d(TAG, ".addOrUpdateDefaultPreset - presetListId=" + recommendedPreset.getId() + ", serial=" + recommendedPreset.getSerialNumber());
        cok acp = cnq.acd().acp();
        RecommendedPreset hk = acp.hk(recommendedPreset.getSerialNumber());
        if (hk != null) {
            recommendedPreset.setId(hk.getId());
        }
        return acp.b(recommendedPreset);
    }

    public void updateActivePresetPinType(String str, int i) {
        cok acp = cnq.acd().acp();
        ActivePreset hj = acp.hj(str);
        if (hj != null) {
            hj.setPinType(i);
            acp.a(hj);
        }
    }

    public List<ActivePreset> getAllPendingActivePresets() {
        return cnq.acd().acp().adU();
    }

    public void updateSavedPresetPinType(String str, int i) {
        MFLogger.d(TAG, "updateSavedPresetPinType presetId=" + str);
        cok acp = cnq.acd().acp();
        SavedPreset hi = acp.hi(str);
        MFLogger.d(TAG, "Is save preset in db yet=" + (hi != null));
        if (hi != null) {
            hi.setPinType(i);
            acp.b(hi);
        }
    }

    public List<SavedPreset> getAllPendingSavedPresets() {
        return cnq.acd().acp().adV();
    }
}
