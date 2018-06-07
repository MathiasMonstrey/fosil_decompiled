package com.fossil;

import android.content.Context;
import java.io.File;

public class epa {
    private final Context context;
    private final String dPK;
    private final String dPL;

    public epa(emr com_fossil_emr) {
        if (com_fossil_emr.getContext() == null) {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        }
        this.context = com_fossil_emr.getContext();
        this.dPK = com_fossil_emr.getPath();
        this.dPL = "Android/" + this.context.getPackageName();
    }

    public File getFilesDir() {
        return m11003D(this.context.getFilesDir());
    }

    File m11003D(File file) {
        if (file == null) {
            emm.aEU().mo2950d("Fabric", "Null File");
        } else if (file.exists() || file.mkdirs()) {
            return file;
        } else {
            emm.aEU().aS("Fabric", "Couldn't create file");
        }
        return null;
    }
}
