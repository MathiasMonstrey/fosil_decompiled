package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.log.MFLogger;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class art {
    private static final String TAG = ("Localization_" + art.class.getSimpleName());
    private Map<String, String> bdJ = new HashMap();

    class C18711 extends cgu<HashMap<String, String>> {
        final /* synthetic */ art bdK;

        C18711(art com_fossil_art) {
            this.bdK = com_fossil_art;
        }
    }

    class C18722 extends cgu<HashMap<String, String>> {
        final /* synthetic */ art bdK;

        C18722(art com_fossil_art) {
            this.bdK = com_fossil_art;
        }
    }

    public void m4340a(Context context, String str, boolean z) {
        MFLogger.m12670d(TAG, "parseJSONFile() called with: filePath = [" + str + "], isDownloaded = [" + z + "]");
        try {
            cfj com_fossil_cfj = new cfj();
            Reader fileReader;
            Map map;
            if (z) {
                fileReader = new FileReader(new File(str));
                map = (Map) com_fossil_cfj.m6196a(fileReader, new C18722(this).getType());
                fileReader.close();
                this.bdJ.putAll(map);
                return;
            }
            InputStream open = context.getAssets().open(str);
            fileReader = new InputStreamReader(open, "UTF-8");
            map = (Map) com_fossil_cfj.m6196a(fileReader, new C18711(this).getType());
            fileReader.close();
            open.close();
            this.bdJ.putAll(map);
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "parseJSONFile failed exception=" + e);
        }
    }

    public void JE() {
        if (this.bdJ != null) {
            this.bdJ.clear();
        }
    }

    public Map<String, String> JF() {
        return this.bdJ;
    }

    public String cO(String str) {
        if (this.bdJ == null || str == null || str.equals("")) {
            return "";
        }
        return (String) this.bdJ.get(str);
    }
}
