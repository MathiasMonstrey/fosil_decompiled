package com.fossil;

import com.fossil.wearables.fsl.contact.ContactGroup;
import com.misfit.frameworks.buttonservice.enums.MFDeviceFamily;
import java.util.ArrayList;
import java.util.List;

public class drd {
    public static final String TAG = drd.class.getSimpleName();
    private static drd dfc;

    public static drd auo() {
        if (dfc == null) {
            dfc = new drd();
        }
        return dfc;
    }

    private drd() {
    }

    public List<ContactGroup> m9457b(String str, MFDeviceFamily mFDeviceFamily) {
        List<ContactGroup> arrayList = new ArrayList();
        if (str == null || mFDeviceFamily == null) {
            return arrayList;
        }
        arrayList = cnq.acd().ack().getContactGroupsMatchingSms(str, mFDeviceFamily.ordinal());
        if (arrayList == null) {
            return new ArrayList();
        }
        return arrayList;
    }

    public List<ContactGroup> m9458c(String str, MFDeviceFamily mFDeviceFamily) {
        List<ContactGroup> arrayList = new ArrayList();
        if (str == null || mFDeviceFamily == null) {
            return arrayList;
        }
        arrayList = cnq.acd().ack().getContactGroupsMatchingIncomingCall(str, mFDeviceFamily.ordinal());
        if (arrayList == null) {
            return new ArrayList();
        }
        return arrayList;
    }
}
