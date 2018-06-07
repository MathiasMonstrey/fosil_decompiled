package com.fossil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class ach {
    public final String aHV;
    public final String aHl;
    public final String packageName;
    public final String versionName;

    ach(String str, String str2, String str3, String str4) {
        this.aHl = str;
        this.versionName = str2;
        this.aHV = str3;
        this.packageName = str4;
    }

    public static ach m2933a(Properties properties) {
        return new ach(properties.getProperty("version_code"), properties.getProperty("version_name"), properties.getProperty("build_id"), properties.getProperty("package_name"));
    }

    public static ach m2934h(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        properties.load(inputStream);
        return m2933a(properties);
    }
}
