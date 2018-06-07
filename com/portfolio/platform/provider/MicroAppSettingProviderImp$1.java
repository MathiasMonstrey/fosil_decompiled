package com.portfolio.platform.provider;

import android.database.sqlite.SQLiteDatabase;
import com.fossil.cpc;
import com.fossil.wearables.fsl.shared.UpgradeCommand;
import java.util.HashMap;

public class MicroAppSettingProviderImp$1 extends HashMap<Integer, UpgradeCommand> {
    final /* synthetic */ cpc this$0;

    class C49011 implements UpgradeCommand {
        final /* synthetic */ MicroAppSettingProviderImp$1 cBw;

        C49011(MicroAppSettingProviderImp$1 microAppSettingProviderImp$1) {
            this.cBw = microAppSettingProviderImp$1;
        }

        public void execute(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("ALTER TABLE microAppSetting ADD COLUMN pinType INTEGER DEFAULT 0");
        }
    }

    public MicroAppSettingProviderImp$1(cpc com_fossil_cpc) {
        this.this$0 = com_fossil_cpc;
        put(Integer.valueOf(2), new C49011(this));
    }
}
