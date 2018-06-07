package com.fossil;

import android.text.TextUtils;
import com.fossil.wearables.fsl.appfilter.AppFilter;
import com.misfit.frameworks.buttonservice.enums.MFDeviceFamily;
import java.util.ArrayList;
import java.util.List;

public class drc {
    private static drc dfb;

    public static drc aun() {
        if (dfb == null) {
            dfb = new drc();
        }
        return dfb;
    }

    public List<AppFilter> m9456b(MFDeviceFamily mFDeviceFamily) {
        List<AppFilter> list = null;
        if (mFDeviceFamily != null) {
            list = cnq.acd().acm().getAllAppFilters(mFDeviceFamily.ordinal());
        }
        if (list == null) {
            return new ArrayList();
        }
        return list;
    }

    public AppFilter m9455a(String str, MFDeviceFamily mFDeviceFamily) {
        if (TextUtils.isEmpty(str) || mFDeviceFamily == null) {
            return null;
        }
        return cnq.acd().acm().getAppFilterMatchingType(str, mFDeviceFamily.ordinal());
    }
}
