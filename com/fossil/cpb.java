package com.fossil;

import com.fossil.wearables.fsl.BaseProvider;
import com.portfolio.platform.data.model.microapp.MicroAppSetting;
import java.util.List;

public interface cpb extends BaseProvider {
    List<MicroAppSetting> aeG();

    boolean aeH();

    boolean mo1996b(MicroAppSetting microAppSetting);

    List<MicroAppSetting> getPendingMicroAppSettings();

    MicroAppSetting hs(String str);

    void updateMicroAppSettingPinType(String str, int i);
}
