package com.fossil;

import android.content.Context;
import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.portfolio.platform.data.model.TimezoneRawData;
import com.portfolio.platform.data.model.microapp.SecondTimezone;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class djs extends ckb<C2132b, C2852a, C2131a> {
    private final Context mApplicationContext;

    class C28511 implements Comparator<TimezoneRawData> {
        final /* synthetic */ djs cXD;

        C28511(djs com_fossil_djs) {
            this.cXD = com_fossil_djs;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m8848a((TimezoneRawData) obj, (TimezoneRawData) obj2);
        }

        public int m8848a(TimezoneRawData timezoneRawData, TimezoneRawData timezoneRawData2) {
            return timezoneRawData.getCityName().compareTo(timezoneRawData2.getCityName());
        }
    }

    public static final class C2852a implements C2133c {
        private final List<SecondTimezone> cXE;

        public C2852a(List<SecondTimezone> list) {
            this.cXE = list;
        }

        public List<SecondTimezone> aqc() {
            return this.cXE;
        }
    }

    djs(Context context) {
        this.mApplicationContext = (Context) cco.m5996s(context, "applicationContext cannot be null!");
    }

    protected void mo2022b(C2132b c2132b) {
        List arrayList = new ArrayList();
        List<TimezoneRawData> bv = cms.bv(this.mApplicationContext);
        Collections.sort(bv, new C28511(this));
        for (TimezoneRawData timezoneRawData : bv) {
            SecondTimezone secondTimezone = new SecondTimezone();
            secondTimezone.setTimezoneId(timezoneRawData.getTimeZoneId());
            secondTimezone.setTimezoneCityName(timezoneRawData.getCityName());
            arrayList.add(secondTimezone);
        }
        abr().onSuccess(new C2852a(arrayList));
    }
}
