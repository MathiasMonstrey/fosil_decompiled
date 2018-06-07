package com.fossil;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class adl implements adi {
    private final Map<String, String> aKx;
    private final File file;

    public adl(File file) {
        this(file, Collections.emptyMap());
    }

    public adl(File file, Map<String, String> map) {
        this.file = file;
        this.aKx = new HashMap(map);
        if (this.file.length() == 0) {
            this.aKx.putAll(adj.aKj);
        }
    }

    public File getFile() {
        return this.file;
    }

    public String getFileName() {
        return getFile().getName();
    }

    public String getIdentifier() {
        String fileName = getFileName();
        return fileName.substring(0, fileName.lastIndexOf(46));
    }

    public Map<String, String> yE() {
        return Collections.unmodifiableMap(this.aKx);
    }

    public boolean yD() {
        emm.aEU().mo2950d("Fabric", "Removing report at " + this.file.getPath());
        return this.file.delete();
    }
}
