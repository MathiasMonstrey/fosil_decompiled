package com.fossil;

import com.fossil.wearables.fsl.BaseProvider;
import com.misfit.frameworks.buttonservice.enums.MFDeviceFamily;
import com.portfolio.platform.data.model.DeviceModel;
import com.portfolio.platform.data.model.SKUModel;
import com.portfolio.platform.data.model.microapp.ActivePreset;
import com.portfolio.platform.data.model.microapp.DeclarationFile;
import com.portfolio.platform.data.model.microapp.MappingSet;
import com.portfolio.platform.data.model.microapp.MappingSet.MappingSetType;
import com.portfolio.platform.data.model.microapp.MicroApp;
import com.portfolio.platform.data.model.microapp.MicroAppVariant;
import com.portfolio.platform.data.model.microapp.RecommendedPreset;
import com.portfolio.platform.data.model.microapp.SavedPreset;
import com.portfolio.platform.model.UAppSystemVersionModel;
import java.util.List;

public interface cok extends BaseProvider {
    void mo1938C(String str, int i);

    List<MicroAppVariant> mo1939D(String str, int i);

    void mo1940S(List<SKUModel> list);

    MappingSet mo1941a(MFDeviceFamily mFDeviceFamily);

    MicroAppVariant mo1942a(String str, String str2, int i, String str3);

    List<MappingSet> mo1943a(MappingSetType mappingSetType);

    void mo1944a(DeviceModel deviceModel);

    boolean mo1945a(ActivePreset activePreset);

    boolean mo1946a(DeclarationFile declarationFile);

    boolean mo1947a(MicroAppVariant microAppVariant);

    List<DeviceModel> adS();

    List<SavedPreset> adT();

    List<ActivePreset> adU();

    List<SavedPreset> adV();

    List<SKUModel> adW();

    boolean adX();

    boolean adY();

    boolean adZ();

    void addOrUpdateUAppSystemVersionModel(UAppSystemVersionModel uAppSystemVersionModel);

    boolean aea();

    boolean aeb();

    boolean aec();

    boolean aed();

    boolean aee();

    MicroApp ax(String str, String str2);

    boolean mo1963b(MicroApp microApp);

    boolean mo1964b(RecommendedPreset recommendedPreset);

    boolean mo1965b(SavedPreset savedPreset);

    UAppSystemVersionModel getUAppSystemVersionModel(String str);

    DeviceModel hd(String str);

    void he(String str);

    List<RecommendedPreset> hf(String str);

    boolean hg(String str);

    boolean hh(String str);

    SavedPreset hi(String str);

    ActivePreset hj(String str);

    RecommendedPreset hk(String str);

    SKUModel hl(String str);

    List<MicroApp> hm(String str);

    boolean hn(String str);

    void updateListMicroApp(List<MicroApp> list);
}
