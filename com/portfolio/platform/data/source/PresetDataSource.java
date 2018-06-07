package com.portfolio.platform.data.source;

import com.portfolio.platform.data.model.microapp.ActivePreset;
import com.portfolio.platform.data.model.microapp.RecommendedPreset;
import com.portfolio.platform.data.model.microapp.SavedPreset;
import java.util.List;

public interface PresetDataSource {

    public interface AddOrUpdateActivePresetCallback {
        void onFail();

        void onSuccess(ActivePreset activePreset);
    }

    public interface AddOrUpdateSavedPresetCallback {
        void onFail();

        void onSuccess(SavedPreset savedPreset);
    }

    public interface AddOrUpdateSavedPresetListCallback {
        void onFail();

        void onSuccess(List<SavedPreset> list);
    }

    public interface DeleteMappingSetCallback {
        void onFail();

        void onSuccess();
    }

    public interface DeleteSavedPresetInServerCallback {
        void onFail();

        void onSuccess();
    }

    public interface GetActivePresetCallback {
        void onFail();

        void onSuccess(ActivePreset activePreset);
    }

    public interface GetActivePresetListCallback {
        void onFail();

        void onSuccess(List<ActivePreset> list);
    }

    public interface GetRecommendedPresetCallback {
        void onFail();

        void onSuccess(RecommendedPreset recommendedPreset);
    }

    public interface GetRecommendedPresetListCallback {
        void onFail();

        void onSuccess(List<RecommendedPreset> list);
    }

    public interface GetSavedPresetCallback {
        void onFail();

        void onSuccess(SavedPreset savedPreset);
    }

    public interface GetSavedPresetListCallback {
        void onFail();

        void onSuccess(List<SavedPreset> list);
    }

    public interface PushActivePresetToServerCallback {
        void onFail();

        void onSuccess();
    }

    public interface PushPendingActivePresetsCallback {
        void onDone();
    }

    public interface PushPendingSavedPresetsCallback {
        void onDone();
    }

    public interface PushSavedPresetToServerCallback {
        void onFail();

        void onSuccess();
    }

    void addOrUpdateActivePreset(ActivePreset activePreset, AddOrUpdateActivePresetCallback addOrUpdateActivePresetCallback);

    void addOrUpdateSavedPreset(SavedPreset savedPreset, AddOrUpdateSavedPresetCallback addOrUpdateSavedPresetCallback);

    void addOrUpdateUserPresetList(List<SavedPreset> list, AddOrUpdateSavedPresetListCallback addOrUpdateSavedPresetListCallback);

    void clearData();

    void deleteAllRecommendedPresets(String str, DeleteMappingSetCallback deleteMappingSetCallback);

    void deleteSavedPreset(SavedPreset savedPreset, DeleteMappingSetCallback deleteMappingSetCallback);

    void downloadActivePresetList(GetActivePresetListCallback getActivePresetListCallback);

    void downloadRecommendPreset(String str, GetRecommendedPresetListCallback getRecommendedPresetListCallback);

    void downloadSavedPreset(GetSavedPresetListCallback getSavedPresetListCallback);

    void getActivePreset(String str, GetActivePresetCallback getActivePresetCallback);

    void getAllSavedPresets(GetSavedPresetListCallback getSavedPresetListCallback);

    void getDefaultPreset(String str, GetRecommendedPresetCallback getRecommendedPresetCallback, boolean z);

    void getRecommendedPresets(String str, GetRecommendedPresetListCallback getRecommendedPresetListCallback);

    void getSavedPreset(String str, GetSavedPresetCallback getSavedPresetCallback);
}
