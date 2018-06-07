package com.ua.sdk.activitystory;

import com.facebook.internal.AnalyticsEvents;
import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cfu;
import com.fossil.cfv;
import com.fossil.eed;
import com.fossil.eeh;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class AttachmentAdapter implements cfo<Attachment>, cfv<Attachment> {
    public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        return m16137m(com_fossil_cfp, type, com_fossil_cfn);
    }

    public Attachment m16137m(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
        cfp fq = com_fossil_cfp.WA().fq("object");
        if (fq != null) {
            fq = fq.WA().fq("type");
            if (fq != null) {
                String asString = fq.getAsString();
                if (AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO.equals(asString)) {
                    return (Attachment) com_fossil_cfn.b(com_fossil_cfp, eed.class);
                }
                if (AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO.equals(asString)) {
                    return (Attachment) com_fossil_cfn.b(com_fossil_cfp, eeh.class);
                }
            }
        }
        return null;
    }

    public cfp m16135a(Attachment attachment, Type type, cfu com_fossil_cfu) {
        return com_fossil_cfu.c(attachment, attachment.getClass());
    }
}
