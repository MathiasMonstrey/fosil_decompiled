package com.jawbone.upplatformsdk.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.HashMap;

public class UpPlatformSdkUtils {
    public static HashMap<String, Object> toMultiPartMap(Class cls) {
        return null;
    }

    public static String toJson(Object obj) {
        try {
            return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
